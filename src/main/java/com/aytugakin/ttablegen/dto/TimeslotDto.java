package com.aytugakin.ttablegen.dto;

import com.aytugakin.ttablegen.model.TimeEnum;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TimeslotDto {
    private Long id;
    private String timeEnum;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
}
