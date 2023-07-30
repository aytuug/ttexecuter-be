package com.aytugakin.ttablegen.dto.request;

import lombok.*;

import java.time.LocalDateTime;
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateClassroomRequest {
    private Long id;
    private String roomCode;
    private Long capacity;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
}
