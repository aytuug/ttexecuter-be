package com.aytugakin.ttablegen.dto.request;

public record CreateInstructorRequest(
        Long id,
        String name,
        String surname,
        String email) {
}
