package com.aytugakin.ttablegen.dto.response;

import lombok.*;

import java.time.LocalDateTime;
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentResponse {
    private Long id;
    private String name;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
    private FacultyResponse faculty;
}
