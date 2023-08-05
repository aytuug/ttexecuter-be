package com.aytugakin.ttablegen.repository;

import com.aytugakin.ttablegen.model.TTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TTableRepository extends JpaRepository<TTable, Long> {
}
