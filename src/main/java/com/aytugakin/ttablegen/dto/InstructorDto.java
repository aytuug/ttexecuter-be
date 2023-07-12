package com.aytugakin.ttablegen.dto;

import lombok.Builder;

@Builder
public record InstructorDto(
         Long id,
         String name,
         String surname,
         String email
) {
}
