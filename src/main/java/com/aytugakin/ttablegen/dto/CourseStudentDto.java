package com.aytugakin.ttablegen.dto;

import com.aytugakin.ttablegen.model.Course;
import com.aytugakin.ttablegen.model.CourseStudentId;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.EmbeddedId;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CourseStudentDto {
    @EmbeddedId
    @JsonIgnore
    private CourseStudentId id = new CourseStudentId();
    @JsonIgnore
    private Course course;
    private StudentDto student;
    private LocalDateTime validityStartDate;
    private LocalDateTime validityEndDate;
}
