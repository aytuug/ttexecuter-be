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
    public int getRandomProfessorId() {
        return courseInstructors[(int) (courseInstructors.length * Math.random())];
    }
}
