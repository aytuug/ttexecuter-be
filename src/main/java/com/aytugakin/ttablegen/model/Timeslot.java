package com.aytugakin.ttablegen.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "timeSlot")
public class Timeslot {
    @Id
    @SequenceGenerator(name = "seqTimeslotId", sequenceName = "seq_timeslot_id", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqTimeslotId")
    private Long id;
    @Enumerated(value = EnumType.STRING)
    private TimeEnum timeEnum;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
}
