package com.aytugakin.ttablegen.repository;

import com.aytugakin.ttablegen.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CourseRepository extends JpaRepository<Course, Long> {
    Optional<Course> findByCourseCode(String courseCode);

    @Query("SELECT DISTINCT(cs.course.id) FROM CourseStudent cs WHERE cs.student.id = :#{#studentId}")
    List<Long> findCourseIdsByStudentIds(Long studentId);
}
