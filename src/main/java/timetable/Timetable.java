package timetable;

import com.aytugakin.ttablegen.util.Individual;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
@RequiredArgsConstructor
public class Timetable {
    private final HashMap<Integer, Room> rooms;
    private final HashMap<Integer, Professor> professors;
    private final HashMap<Integer, Module> modules;
    private final HashMap<Integer, Group> groups;
    private final HashMap<Integer, TimeslotTimetable> timeslots;
    private Section[] classes;

    private int numClasses = 0;

    public Timetable() {
        this.rooms = new HashMap<Integer, Room>();
        this.professors = new HashMap<Integer, Professor>();
        this.modules = new HashMap<Integer, Module>();
        this.groups = new HashMap<Integer, Group>();
        this.timeslots = new HashMap<Integer, TimeslotTimetable>();
    }

    public Timetable(Timetable cloneable) {
        this.rooms = cloneable.getRooms();
        this.professors = cloneable.getProfessors();
        this.modules = cloneable.getModules();
        this.groups = cloneable.getGroups();
        this.timeslots = cloneable.getTimeslots();
    }

    private HashMap<Integer, Group> getGroups() {
        return this.groups;
    }

    private HashMap<Integer, TimeslotTimetable> getTimeslots() {
        return this.timeslots;
    }

    private HashMap<Integer, Module> getModules() {
        return this.modules;
    }

    private HashMap<Integer, Professor> getProfessors() {
        return this.professors;
    }

    public void addRoom(int roomId, String roomName, int capacity) {
        this.rooms.put(roomId, new Room(roomId, roomName, capacity));
    }

    public void addProfessor(int professorId, String professorName) {
        this.professors.put(professorId, new Professor(professorId, professorName));
    }

    public void addModule(int moduleId, String moduleCode, String module, int professorIds[]) {
        this.modules.put(moduleId, new Module(moduleId, moduleCode, module, professorIds));
    }

    public void addGroup(int groupId, int groupSize, int moduleIds[]) {
        this.groups.put(groupId, new Group(groupId, groupSize, moduleIds));
        this.numClasses = 0;
    }

    public void addTimeslot(int timeslotId, String timeslot) {
        this.timeslots.put(timeslotId, new TimeslotTimetable(timeslotId, timeslot));
    }

    public void createClasses(Individual individual) {
        // Init classes
        Section classes[] = new Section[this.getNumClasses()];

        // Get individual's chromosome
        int chromosome[] = individual.getChromosome();
        int chromosomePos = 0;
        int classIndex = 0;

        for (Group group : this.getGroupsAsArray()) {
            int moduleIds[] = group.getModuleIds();
            for (int moduleId : moduleIds) {
                classes[classIndex] = new Section(classIndex, group.getGroupId(), moduleId);

                // Add timeslot
                classes[classIndex].addTimeslot(chromosome[chromosomePos]);
                chromosomePos++;

                // Add room
                classes[classIndex].setRoomId(chromosome[chromosomePos]);
                chromosomePos++;

                // Add professor
                classes[classIndex].addProfessor(chromosome[chromosomePos]);
                chromosomePos++;

                classIndex++;
            }
        }

        this.classes = classes;
    }

    public Room getRoom(int roomId) {
        if (!this.rooms.containsKey(roomId)) {
            System.out.println("Rooms doesn't contain key " + roomId);
        }
        return (Room) this.rooms.get(roomId);
    }

    public HashMap<Integer, Room> getRooms() {
        return this.rooms;
    }

    public Room getRandomRoom() {
        Object[] roomsArray = this.rooms.values().toArray();
        Room room = (Room) roomsArray[(int) (roomsArray.length * Math.random())];
        return room;
    }

    public Professor getProfessor(int professorId) {
        return (Professor) this.professors.get(professorId);
    }

    public Module getModule(int moduleId) {
        return (Module) this.modules.get(moduleId);
    }

    public int[] getGroupModules(int groupId) {
        Group group = (Group) this.groups.get(groupId);
        return group.getModuleIds();
    }


    public Group getGroup(int groupId) {
        return (Group) this.groups.get(groupId);
    }


    public Group[] getGroupsAsArray() {
        return (Group[]) this.groups.values().toArray(new Group[this.groups.size()]);
    }


    public TimeslotTimetable getTimeslot(int timeslotId) {
        return (TimeslotTimetable) this.timeslots.get(timeslotId);
    }

    public TimeslotTimetable getRandomTimeslot() {
        Object[] timeslotArray = this.timeslots.values().toArray();
        TimeslotTimetable timeslot = (TimeslotTimetable) timeslotArray[(int) (timeslotArray.length * Math.random())];
        return timeslot;
    }

    public Section[] getClasses() {
        return this.classes;
    }

    public int getNumClasses() {
        if (this.numClasses > 0) {
            return this.numClasses;
        }

        int numClasses = 0;
        Group groups[] = (Group[]) this.groups.values().toArray(new Group[this.groups.size()]);
        for (Group group : groups) {
            numClasses += group.getModuleIds().length;
        }
        this.numClasses = numClasses;

        return this.numClasses;
    }

    public int calcClashes() {
        int clashes = 0;

        for (Section classA : this.classes) {
            // Check room capacity
            int roomCapacity = this.getRoom(classA.getRoomId()).getCapacity();
            int groupSize = this.getGroup(classA.getGroupId()).getGroupSize();

            if (roomCapacity < groupSize) {
                clashes++;
            }

            // Check if room is taken
            for (Section classB : this.classes) {
                if (classA.getRoomId() == classB.getRoomId() && classA.getTimeslotId() == classB.getTimeslotId()
                        && classA.getClassId() != classB.getClassId()) {
                    clashes++;
                    break;
                }
            }

            // Check if professor is available
            for (Section classB : this.classes) {
                if (classA.getProfessorId() == classB.getProfessorId() && classA.getTimeslotId() == classB.getTimeslotId()
                        && classA.getClassId() != classB.getClassId()) {
                    clashes++;
                    break;
                }
            }
        }

        return clashes;
    }
}
