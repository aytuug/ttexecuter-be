package com.aytugakin.ttablegen.dto.response;

import com.aytugakin.ttablegen.dto.request.CreateDepartmentRequestForInstructorAndStudent;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StudentResponse {
    private Long id;
    private String name;
    private String surname;
    private String email;
    private String studentNo;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
    private CreateDepartmentRequestForInstructorAndStudent department;

}
