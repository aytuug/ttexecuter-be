package com.aytugakin.ttablegen.repository;

import com.aytugakin.ttablegen.model.Classroom;
import com.aytugakin.ttablegen.model.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClassroomRepository extends JpaRepository<Classroom, Long> {
    Optional<Classroom> findByRoomCode(String roomCode);

}
