package timetable;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Room {
    private final int roomId;
    private final String roomNumber;
    private final int capacity;
}
