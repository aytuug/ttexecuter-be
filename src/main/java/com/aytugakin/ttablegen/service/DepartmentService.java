package com.aytugakin.ttablegen.service;

import com.aytugakin.ttablegen.dto.converter.DepartmentConverter;
import com.aytugakin.ttablegen.dto.converter.FacultyConverter;
import com.aytugakin.ttablegen.dto.request.CreateDepartmentRequest;
import com.aytugakin.ttablegen.dto.request.UpdateDepartmentRequest;
import com.aytugakin.ttablegen.dto.response.DepartmentResponse;
import com.aytugakin.ttablegen.exception.EmailAlreadyExistException;
import com.aytugakin.ttablegen.exception.ResourceNotFoundException;
import com.aytugakin.ttablegen.model.Department;
import com.aytugakin.ttablegen.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DepartmentService {
    private final DepartmentRepository departmentRepository;
    public DepartmentResponse createDepartment(CreateDepartmentRequest createDepartmentRequest) {
        Department department = new Department(
             createDepartmentRequest.getId(),
                createDepartmentRequest.getName(),
                createDepartmentRequest.getCreatedDate(),
                createDepartmentRequest.getUpdatedDate(),
                FacultyConverter.MAPPER.facultyRequestToFaculty(createDepartmentRequest.getFaculty()),
                Collections.emptyList()
        );

        Optional<Department> optionalDepartment = departmentRepository.findByName(createDepartmentRequest.getName());
        if (optionalDepartment.isPresent()) {
            throw new EmailAlreadyExistException("Department name Already exist for Department");
        }

        departmentRepository.save(department);
        return DepartmentConverter.MAPPER.departmentToDepartmentResponse(department);
    }

    public DepartmentResponse getDepartmentById(Long id){
        return departmentRepository.findById(id)
                .map(DepartmentConverter.MAPPER::departmentToDepartmentResponse).orElseThrow(() -> new ResourceNotFoundException("Department", "Id", id));
    }

    public List<DepartmentResponse> getAllDepartments(){
        List<Department> departmentList = departmentRepository.findAll();
        return departmentList.stream()
                .map(DepartmentConverter.MAPPER::departmentToDepartmentResponse)
                .collect(Collectors.toList());
    }

    public DepartmentResponse updateDepartment(Long id, UpdateDepartmentRequest updateDepartmentRequest){
        Optional<Department> departmentOptional = departmentRepository.findById(id);

        departmentOptional.ifPresent(department -> {
            department.setName(updateDepartmentRequest.getName());
            departmentRepository.save(department);
        });

        return departmentOptional.map(DepartmentConverter.MAPPER::departmentToDepartmentResponse).orElseThrow(() -> new ResourceNotFoundException("Department", "Id", id));

    }

    public String deleteDepartment(Long id) {
        String username = getDepartmentById(id).getName();
        departmentRepository.deleteById(id);
        return "Department with name: " + username + " is deleted!";
    }
}
