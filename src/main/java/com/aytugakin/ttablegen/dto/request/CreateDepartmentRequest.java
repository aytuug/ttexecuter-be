package com.aytugakin.ttablegen.dto.request;

import com.aytugakin.ttablegen.dto.FacultyDto;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateDepartmentRequest {
    private Long id;
    private String name;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
    private CreateFacultyRequest faculty;
}
