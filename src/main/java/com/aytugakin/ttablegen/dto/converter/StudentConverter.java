package com.aytugakin.ttablegen.dto.converter;

import com.aytugakin.ttablegen.dto.response.StudentResponse;
import com.aytugakin.ttablegen.model.Student;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface StudentConverter {
    StudentConverter MAPPER = Mappers.getMapper(StudentConverter.class);
    StudentResponse studentToStudentRepository(Student student);

}
