package timetable;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Section {
    private final int classId;
    private final int groupId;
    private final int moduleId;
    private int professorId;
    private int timeslotId;
    private int roomId;
    public Section(int classId, int groupId, int moduleId){
        this.classId = classId;
        this.moduleId = moduleId;
        this.groupId = groupId;
    }
    public void addProfessor(int professorId){
        this.professorId = professorId;
    }
    public void addTimeslot(int timeslotId){
        this.timeslotId = timeslotId;
    }
    public void setRoomId(int roomId){
        this.roomId = roomId;
    }
}
