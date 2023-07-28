package com.aytugakin.ttablegen.dto;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FacultyDto {
    private Long id;
    private String name;
    private Long capacity;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
}
