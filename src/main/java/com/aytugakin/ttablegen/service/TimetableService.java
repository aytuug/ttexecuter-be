package com.aytugakin.ttablegen.service;

import com.aytugakin.ttablegen.dto.CourseDto;
import com.aytugakin.ttablegen.model.Student;
import com.aytugakin.ttablegen.util.GeneticAlgorithm;
import com.aytugakin.ttablegen.util.Population;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import timetable.*;

import java.util.*;

@Service
@RequiredArgsConstructor
public class TimetableService {
    private final ClassroomService classroomService;
    private final TimeslotService timeslotService;
    private final InstructorService instructorService;
    private final CourseService courseService;
    private final StudentService studentService;
    public void generateTimetable() {
        Timetable timetable = initializeTimetable();
        GeneticAlgorithm ga = new GeneticAlgorithm(100, 0.01, 0.9, 2, 5);
        Population population = ga.initPopulation(timetable);
        ga.evalPopulation(population, timetable);

        int generation = 1;
        while (ga.isTerminationConditionMet(generation, 1000) == false
                && ga.isTerminationConditionMet(population) == false) {
            // Print fitness
            System.out.println("G" + generation + " Best fitness: " + population.getFittest(0).getFitness());

            // Apply crossover
            population = ga.crossoverPopulation(population);

            // Apply mutation
            population = ga.mutatePopulation(population, timetable);

            // Evaluate population
            ga.evalPopulation(population, timetable);

            // Increment the current generation
            generation++;
        }
        timetable.createClasses(population.getFittest(0));
        System.out.println();
        System.out.println("Solution found in " + generation + " generations");
        System.out.println("Final solution fitness: " + population.getFittest(0).getFitness());
        System.out.println("Clashes: " + timetable.calcClashes());
        System.out.println();

        Section classes[] = timetable.getClasses();
        int classIndex = 1;
        for (Section bestClass : classes) {
            System.out.println("Class " + classIndex + ":");
            System.out.println("Module: " +
                    timetable.getModule(bestClass.getModuleId()).getCourseCode());
            System.out.println("Group: " +
                    timetable.getGroup(bestClass.getGroupId()).getGroupId());
            System.out.println("Room: " +
                    timetable.getRoom(bestClass.getRoomId()).getRoomCode());
            System.out.println("Professor: " +
                    timetable.getProfessor(bestClass.getProfessorId()).getName());
            System.out.println("Time: " +
                    timetable.getTimeslot(bestClass.getTimeslotId()).getTimeEnum());
            System.out.println("-----");
            classIndex++;
        }
    }

    private  Timetable initializeTimetable() {
        
        // timetable.addRoom(5, "F1", 25);
        Timetable timetable = new Timetable();
        List<Room> rooms = classroomService.getAllRooms();
        for (Room room: rooms) {
            timetable.addRoom(room.getId(), room.getRoomCode(), room.getCapacity());
        }

        //timetable.addTimeslot(2, "Mon 11:00 - 13:00");
        List<TimeslotTimetable> timeslotTimetables = timeslotService.getAllTimeslotTables();
        for (TimeslotTimetable timeslotTimetable: timeslotTimetables) {
            timetable.addTimeslot(timeslotTimetable.getId(), timeslotTimetable.getTimeEnum());
        }

        //timetable.addProfessor(1, "Dr P Smith");
        List<Professor> professors = instructorService.getAllProfessors();
        for (Professor professor: professors) {
            timetable.addProfessor(professor.getId(), professor.getName());
        }

        //timetable.addModule(1, "cs1", "Computer Science", new int[] { 1, 2 });
        List<CourseDto> courses = courseService.getAllCourses();
        for (CourseDto course: courses) {
            int[] instructorIds = instructorService.getCourseInstructorIds(course.getId());
            timetable.addModule(course.getId().intValue(), course.getCourseCode(), course.getCourseName(), instructorIds);
        }

        //timetable.addGroup(1, 10, new int[] { 1, 3, 4 });
        Set<int[]> moduleGroups = new HashSet<>();
        List<Map<int[], Long>> studentModuleGroup = new ArrayList<>();
        List<Student> students = studentService.findAllStudents();

        for (Student student : students) {
            int[] studentModules = courseService.getCourseIdsOfStudent(student.getId());
            moduleGroups.add(studentModules);
            studentModuleGroup.add(Map.of(studentModules, student.getId()));
        }

        List<int[]> moduleGroupsList = new ArrayList<>(moduleGroups);

        for (int i = 0; i < moduleGroupsList.size(); i++) {
            final int[] moduleGroup = moduleGroupsList.get(i);
            int groupSize = getSizeByKey(studentModuleGroup, moduleGroup);
            timetable.addGroup(i, groupSize, moduleGroup);
        }

        return timetable;
    }

    public static int getSizeByKey(List<Map<int[], Long>> list, int[] key) {
        int count = 0;

        for (Map<int[], Long> map : list) {
            if (map.containsKey(key)) {
                count++;
            }
        }

        return count;
    }
}
