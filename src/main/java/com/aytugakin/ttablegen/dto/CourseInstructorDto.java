package com.aytugakin.ttablegen.dto;

import com.aytugakin.ttablegen.model.Course;
import com.aytugakin.ttablegen.model.CourseInstructorId;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.EmbeddedId;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CourseInstructorDto {
    @EmbeddedId
    @JsonIgnore
    private CourseInstructorId id = new CourseInstructorId();
    @JsonIgnore
    private Course course;
    private InstructorDto instructor;
    private LocalDateTime validityStartDate;
    private LocalDateTime validityEndDate;

}
