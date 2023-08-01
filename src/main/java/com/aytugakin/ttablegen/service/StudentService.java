package com.aytugakin.ttablegen.service;

import com.aytugakin.ttablegen.dto.converter.DepartmentConverter;
import com.aytugakin.ttablegen.dto.converter.StudentConverter;
import com.aytugakin.ttablegen.dto.request.CreateStudentRequest;
import com.aytugakin.ttablegen.dto.response.StudentResponse;
import com.aytugakin.ttablegen.exception.ResourceNotFoundException;
import com.aytugakin.ttablegen.exception.StudentNoAlreadyException;
import com.aytugakin.ttablegen.model.Student;
import com.aytugakin.ttablegen.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;
    public StudentResponse createStudent(CreateStudentRequest createStudentRequest) {

        Optional<Student> optionalStudent = studentRepository.findByStudentNo(createStudentRequest.getStudentNo());
        if (optionalStudent.isPresent()) {
            throw new StudentNoAlreadyException("StudentNo Already exist for Student");
        }
        return StudentConverter.MAPPER.studentToStudentRepository(studentRepository.save(
                Student.builder()
                        .id(createStudentRequest.getId())
                        .name(createStudentRequest.getName())
                        .surname(createStudentRequest.getSurname())
                        .email(createStudentRequest.getEmail())
                        .studentNo(createStudentRequest.getStudentNo())
                        .createdDate(createStudentRequest.getCreatedDate())
                        .updatedDate(createStudentRequest.getUpdatedDate())
                        .department( DepartmentConverter.MAPPER.departmentRequestToDepartmentForInstructor(createStudentRequest.getDepartment()))
                        .build()
        ));
    }

    public StudentResponse getStudentById(Long id){
        return studentRepository.findById(id)
                .map(StudentConverter.MAPPER::studentToStudentRepository).orElseThrow(() -> new ResourceNotFoundException("Student", "Id", id));
    }

    public List<StudentResponse> getAllStudents(){
        List<Student> studentList = studentRepository.findAll();
        return studentList.stream()
                .map(StudentConverter.MAPPER::studentToStudentRepository)
                .collect(Collectors.toList());
    }

    public List<Student> findAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentByIdForCourse(Long id) {
        return studentRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Student", "id" , id)
        );
    }

    public String deleteStudent(Long id) {
        String username = getStudentById(id).getName();
        studentRepository.deleteById(id);
        return "Student with username: " + username + " is deleted!";
    }
}
