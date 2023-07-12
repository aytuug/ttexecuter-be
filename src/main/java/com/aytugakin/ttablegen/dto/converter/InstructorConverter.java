package com.aytugakin.ttablegen.dto.converter;

import com.aytugakin.ttablegen.dto.InstructorDto;
import com.aytugakin.ttablegen.model.Instructor;
import org.springframework.stereotype.Component;

@Component
public class InstructorConverter {
    public Instructor convertInstructor(InstructorDto instructorDto) {
        return Instructor.builder()
                .id(instructorDto.id())
                .name(instructorDto.name())
                .surname(instructorDto.surname())
                .email(instructorDto.email()).build();
    }

    public InstructorDto convertInstructorDto(Instructor instructor) {
        return InstructorDto.builder()
                .id(instructor.getId())
                .name(instructor.getName())
                .surname(instructor.getSurname())
                .email(instructor.getEmail()).build();
    }
}
