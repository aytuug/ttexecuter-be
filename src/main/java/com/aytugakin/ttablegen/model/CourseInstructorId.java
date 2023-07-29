package com.aytugakin.ttablegen.model;

import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Embeddable
@EqualsAndHashCode
public class CourseInstructorId implements Serializable {
    private Long courseId;
    private Long instructorId;
}
