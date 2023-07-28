package com.aytugakin.ttablegen.repository;

import com.aytugakin.ttablegen.model.Department;
import com.aytugakin.ttablegen.model.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
    Optional<Department> findByName(String name);

}
