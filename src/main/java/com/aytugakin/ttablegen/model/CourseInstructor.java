package com.aytugakin.ttablegen.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "courseInstructor")
public class CourseInstructor {
    @EmbeddedId
    private CourseInstructorId courseInstructorId = new CourseInstructorId();

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("courseId")
    @JoinColumn(name = "course_id")
    private Course course;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("instructorId")
    @JoinColumn(name = "instructor_id")
    private Instructor instructor;

    private LocalDateTime validityStartDate;
    private LocalDateTime validityEndDate;
}
