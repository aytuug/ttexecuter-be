package com.aytugakin.ttablegen.dto.response;

import lombok.*;

import java.time.LocalDateTime;
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FacultyResponse {
    private Long id;
    private String name;
    private Long capacity;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
}
