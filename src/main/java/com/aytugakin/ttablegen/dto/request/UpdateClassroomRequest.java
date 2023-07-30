package com.aytugakin.ttablegen.dto.request;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UpdateClassroomRequest {
    private String roomCode;
    private Long capacity;
}
