package com.aytugakin.ttablegen.repository;

import com.aytugakin.ttablegen.model.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface InstructorRepository extends JpaRepository<Instructor, Long> {
    Optional<Instructor> findByEmail(String email);

    @Query("SELECT DISTINCT (cs.course.id) FROM CourseInstructor cs WHERE cs.course.id = :#{#moduleId}")




    List<Long> findInstructorIdsByModuleId(Long moduleId);
}
