package com.aytugakin.ttablegen.dto.converter;

import com.aytugakin.ttablegen.dto.DepartmentDto;
import com.aytugakin.ttablegen.dto.request.CreateDepartmentRequestForInstructorAndStudent;
import com.aytugakin.ttablegen.dto.response.DepartmentResponse;
import com.aytugakin.ttablegen.model.Department;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DepartmentConverter {
    DepartmentConverter MAPPER = Mappers.getMapper(DepartmentConverter.class);
    Department departmentDtoToDepartment(DepartmentDto departmentDto);
    DepartmentDto departmentToDepartmentDto(Department department);
    DepartmentResponse departmentToDepartmentResponse(Department department);

    Department departmentRequestToDepartmentForInstructor(CreateDepartmentRequestForInstructorAndStudent createDepartmentRequestForInstructorAndStudent);
}
