package com.aytugakin.ttablegen.service;

import com.aytugakin.ttablegen.dto.CourseDto;
import com.aytugakin.ttablegen.dto.converter.CourseConverter;
import com.aytugakin.ttablegen.dto.converter.InstructorConverter;
import com.aytugakin.ttablegen.dto.request.CreateCourseRequest;
import com.aytugakin.ttablegen.dto.response.InstructorResponse;
import com.aytugakin.ttablegen.exception.CourseCodeAlreadyException;
import com.aytugakin.ttablegen.exception.EmailAlreadyExistException;
import com.aytugakin.ttablegen.exception.ResourceNotFoundException;
import com.aytugakin.ttablegen.model.*;
import com.aytugakin.ttablegen.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CourseService {
    private final CourseRepository courseRepository;
    private final InstructorService instructorService;
    private final StudentService studentService;

    public CourseDto createCourse(CreateCourseRequest createCourseRequest) {

        Optional<Course> optionalCourse = courseRepository.findByCourseCode(createCourseRequest.getCourseCode());
        if (optionalCourse.isPresent()) {
            throw new CourseCodeAlreadyException("CourseCode Already exist for Course");
        }

        Course course = new Course();
        course.setId(createCourseRequest.getId());
        course.setCourseCode(createCourseRequest.getCourseCode());
        course.setCourseName(createCourseRequest.getCourseName());
        course.setCreatedDate(createCourseRequest.getCreatedDate());
        course.setUpdatedDate(createCourseRequest.getUpdatedDate());

        course.getCourseInstructors().addAll(createCourseRequest.getCourseInstructors()
                .stream()
                .map(courseInstructor -> {
                    Instructor instructor = instructorService.getInstructorByIdForCourse(courseInstructor.getInstructor().getId());
                    CourseInstructor newCourseInstructor = new CourseInstructor();
                    newCourseInstructor.setCourseInstructorId(courseInstructor.getId());
                    newCourseInstructor.setInstructor(instructor);
                    newCourseInstructor.setCourse(course);
                    newCourseInstructor.setValidityStartDate(courseInstructor.getValidityStartDate());
                    newCourseInstructor.setValidityEndDate(courseInstructor.getValidityEndDate());
                    return newCourseInstructor;
                }).collect(Collectors.toSet())
        );


        course.getCourseStudents().addAll(createCourseRequest.getCourseStudents()
                .stream()
                .map(courseStudent -> {
                    Student student = studentService.getStudentByIdForCourse(courseStudent.getStudent().getId());
                    CourseStudent newCourseStudent = new CourseStudent();
                    newCourseStudent.setCourseStudentId(courseStudent.getId());
                    newCourseStudent.setStudent(student);
                    newCourseStudent.setCourse(course);
                    newCourseStudent.setValidityStartDate(courseStudent.getValidityStartDate());
                    newCourseStudent.setValidityEndDate(courseStudent.getValidityEndDate());
                    return newCourseStudent;
                }).collect(Collectors.toSet())
        );

        courseRepository.save(course);
        return CourseConverter.MAPPER.courseToCourseDto(course);
    }

    public CourseDto getCourseById(Long id){
        return courseRepository.findById(id)
                .map(CourseConverter.MAPPER::courseToCourseDto).orElseThrow(() -> new ResourceNotFoundException("Course", "Id", id));
    }

    public List<CourseDto> getAllCourses(){
        List<Course> courseList = courseRepository.findAll();
        return courseList.stream()
                .map(CourseConverter.MAPPER::courseToCourseDto)
                .collect(Collectors.toList());
    }


    public String deleteCourse(Long id) {
        String username = getCourseById(id).getCourseName();
        courseRepository.deleteById(id);
        return "Course with username: " + username + " is deleted!";
    }



}
