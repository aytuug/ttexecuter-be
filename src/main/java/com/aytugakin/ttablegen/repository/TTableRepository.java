package com.aytugakin.ttablegen.repository;

import com.aytugakin.ttablegen.model.TTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TTableRepository extends JpaRepository<TTable, Long> {
    @Query("SELECT t FROM TTable t " +
            "WHERE t.groupSize = (SELECT MAX(tt.groupSize) FROM TTable tt) " +
            "AND NOT EXISTS (" +
            "    SELECT 1 " +
            "    FROM TTable tt2 " +
            "    WHERE tt2.time = t.time " +
            "    AND tt2.classroomCode = t.classroomCode " +
            "    AND tt2.id <> t.id " +
            ")")
    List<TTable> findByMaxGroupSize();
}
