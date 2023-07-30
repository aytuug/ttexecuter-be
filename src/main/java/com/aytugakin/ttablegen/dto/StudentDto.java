package com.aytugakin.ttablegen.dto;

import lombok.*;


import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto {
    private Long id;
    private String name;
    private String surname;
    private String email;
    private String studentNo;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
}
