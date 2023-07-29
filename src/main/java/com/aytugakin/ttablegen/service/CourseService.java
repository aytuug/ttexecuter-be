package com.aytugakin.ttablegen.service;

import com.aytugakin.ttablegen.dto.CourseDto;
import com.aytugakin.ttablegen.dto.converter.CourseConverter;
import com.aytugakin.ttablegen.dto.request.CreateCourseRequest;
import com.aytugakin.ttablegen.exception.EmailAlreadyExistException;
import com.aytugakin.ttablegen.model.Course;
import com.aytugakin.ttablegen.model.CourseInstructor;
import com.aytugakin.ttablegen.model.Instructor;
import com.aytugakin.ttablegen.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CourseService {
    private final CourseRepository courseRepository;
    private final InstructorService instructorService;

    public CourseDto createCourse(CreateCourseRequest createCourseRequest) {

        Optional<Course> optionalCourse = courseRepository.findByCourseCode(createCourseRequest.getCourseCode());
        if (optionalCourse.isPresent()) {
            throw new EmailAlreadyExistException("CourseCode Already exist for Course");
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

        courseRepository.save(course);
        return CourseConverter.MAPPER.courseToCourseDto(course);
    }
}
