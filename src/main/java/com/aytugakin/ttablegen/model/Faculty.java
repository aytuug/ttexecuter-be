package com.aytugakin.ttablegen.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "faculty")
public class Faculty {

    @Id
    @SequenceGenerator(name = "seqFacultyId", sequenceName = "seq_faculty_id", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqFacultyId")
    private Long id;
    private String name;
    private Long capacity;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;

    @OneToMany(mappedBy = "faculty")
    @JsonManagedReference
    private List<Department> departments;
}
