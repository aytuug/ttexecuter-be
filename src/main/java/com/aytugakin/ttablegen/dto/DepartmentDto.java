package com.aytugakin.ttablegen.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentDto {
    private Long id;
    private String name;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
    private FacultyDto faculty;
}
