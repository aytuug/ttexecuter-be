package timetable;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Module {
    private final int id;
    private final String courseCode;
    private final String courseName;
    private final int courseInstructors[];
    public int getRandomProfessorId(){
        int professorId = courseInstructors[(int) (courseInstructors.length * Math.random())];
        return professorId;
    }
}
