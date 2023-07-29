package com.aytugakin.ttablegen.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class InstructorDto {
    private Long id;
    private String name;
    private String surname;
    private String email;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
}
