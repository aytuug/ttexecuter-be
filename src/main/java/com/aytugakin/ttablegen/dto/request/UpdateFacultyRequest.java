package com.aytugakin.ttablegen.dto.request;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UpdateFacultyRequest {
    private String name;
    private Long capacity;
}
