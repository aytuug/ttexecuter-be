package com.aytugakin.ttablegen.dto.request;

import com.aytugakin.ttablegen.dto.CourseInstructorDto;
import com.aytugakin.ttablegen.dto.CourseStudentDto;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateCourseRequest {
    private Long id;
    private String courseCode;
    private String courseName;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
    private Set<CourseInstructorDto> courseInstructors;
    private Set<CourseStudentDto> courseStudents;

}
