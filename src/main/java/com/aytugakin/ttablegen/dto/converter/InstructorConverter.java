package com.aytugakin.ttablegen.dto.converter;

import com.aytugakin.ttablegen.dto.InstructorDto;
import com.aytugakin.ttablegen.dto.response.InstructorResponse;
import com.aytugakin.ttablegen.model.Instructor;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface InstructorConverter {

    InstructorConverter MAPPER = Mappers.getMapper(InstructorConverter.class);
    Instructor instructorDtoToInstructor(InstructorDto instructorDto);
    Instructor instructorResponseToInstructor(InstructorResponse instructorResponse);
    InstructorDto instructorToInstructorDto(Instructor instructor);
    InstructorResponse instructorToInstructorResponse(Instructor instructor);



}
