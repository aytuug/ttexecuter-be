package com.aytugakin.ttablegen.dto.converter;

import com.aytugakin.ttablegen.dto.InstructorDto;
import com.aytugakin.ttablegen.model.Instructor;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface InstructorConverter {

    InstructorConverter MAPPER = Mappers.getMapper(InstructorConverter.class);
    Instructor instructorDtoToInstructor(InstructorDto instructorDto);
    InstructorDto instructorToInstructorDto(Instructor instructor);


}
