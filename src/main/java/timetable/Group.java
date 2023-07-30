package timetable;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Group {
    private final int groupId;
    private final int groupSize;
    private final int moduleIds[];
}
