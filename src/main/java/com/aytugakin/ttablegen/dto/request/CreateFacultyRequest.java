package com.aytugakin.ttablegen.dto.request;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateFacultyRequest {
    private Long id;
    private String name;
    private Long capacity;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
}
