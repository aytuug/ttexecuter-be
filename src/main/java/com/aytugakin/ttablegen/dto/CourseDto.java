package com.aytugakin.ttablegen.dto;

import lombok.*;

import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CourseDto {
    private Long id;
    private String courseCode;
    private String courseName;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
    private Set<CourseInstructorDto> instructors;
}
