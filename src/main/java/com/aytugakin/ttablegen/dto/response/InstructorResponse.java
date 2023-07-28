package com.aytugakin.ttablegen.dto.response;

import com.aytugakin.ttablegen.dto.DepartmentDto;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class InstructorResponse {
    private Long id;
    private String name;
    private String surname;
    private String email;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
    private DepartmentResponse department;
}
