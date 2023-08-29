package com.aytugakin.ttablegen.service;

import com.aytugakin.ttablegen.model.TTable;
import com.aytugakin.ttablegen.repository.TTableRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TTableService {
    private final TTableRepository tTableRepository;
    public void createTtable(String module, Integer group, String classroomCode, String professor, String time,
                             LocalDateTime createdDate, LocalDateTime updatedDate) {
       tTableRepository.save(
                TTable.builder()
                        .moduleName(module)
                        .groupSize(group)
                        .classroomCode(classroomCode)
                        .professorName(professor)
                        .time(time)
                        .createdDate(createdDate)
                        .updatedDate(updatedDate)
                        .build()
       );
    }

    public List<TTable> getMaxTTable() {
        return tTableRepository.findByMaxGroupSize();
    }

    public String deleteAllTTables() {
        tTableRepository.deleteAll();
        return "All records deleted!";
    }
}
