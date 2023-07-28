package com.aytugakin.ttablegen.repository;

import com.aytugakin.ttablegen.model.Faculty;
import com.aytugakin.ttablegen.model.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FacultyRepository extends JpaRepository<Faculty, Long> {
    Optional<Faculty> findByName(String name);

}
