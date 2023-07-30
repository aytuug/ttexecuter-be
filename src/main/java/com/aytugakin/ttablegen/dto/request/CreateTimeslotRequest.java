package com.aytugakin.ttablegen.dto.request;

import com.aytugakin.ttablegen.model.TimeEnum;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateTimeslotRequest {
    private Long id;
    private TimeEnum timeEnum;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
}
