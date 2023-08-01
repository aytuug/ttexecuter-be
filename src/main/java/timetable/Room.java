package timetable;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Room {
    private final int id;
    private final String roomCode;
    private final int capacity;
}
