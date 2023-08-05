package com.aytugakin.ttablegen.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "ttable")
public class TTable {
    @Id
    @SequenceGenerator(name = "seqTtableId", sequenceName = "seq_ttable_id", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqTtableId")
    private Long id;
    private String moduleName;
    private Integer groupSize;
    private String classroomCode;
    private String professorName;
    private String time;
    @CreationTimestamp
    private LocalDateTime createdDate;
    @UpdateTimestamp
    private LocalDateTime updatedDate;
}
