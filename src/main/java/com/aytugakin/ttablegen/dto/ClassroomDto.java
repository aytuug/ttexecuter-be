package com.aytugakin.ttablegen.dto;

import lombok.*;

import java.time.LocalDateTime;
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClassroomDto {
    private Long id;
    private String roomCode;
    private Long capacity;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
}
