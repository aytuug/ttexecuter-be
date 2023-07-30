package com.aytugakin.ttablegen.service;

import com.aytugakin.ttablegen.dto.ClassroomDto;
import com.aytugakin.ttablegen.dto.converter.ClassroomConverter;
import com.aytugakin.ttablegen.dto.converter.DepartmentConverter;
import com.aytugakin.ttablegen.dto.converter.InstructorConverter;
import com.aytugakin.ttablegen.dto.request.CreateClassroomRequest;
import com.aytugakin.ttablegen.dto.request.CreateInstructorRequest;
import com.aytugakin.ttablegen.dto.request.UpdateClassroomRequest;
import com.aytugakin.ttablegen.dto.request.UpdateInstructorRequest;
import com.aytugakin.ttablegen.dto.response.InstructorResponse;
import com.aytugakin.ttablegen.exception.ClassroomCodeAlreadyException;
import com.aytugakin.ttablegen.exception.EmailAlreadyExistException;
import com.aytugakin.ttablegen.exception.ResourceNotFoundException;
import com.aytugakin.ttablegen.model.Classroom;
import com.aytugakin.ttablegen.model.Instructor;
import com.aytugakin.ttablegen.repository.ClassroomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ClassroomService {
    private final ClassroomRepository classroomRepository;

    public ClassroomDto createClassroom(CreateClassroomRequest createClassroomRequest) {

        Optional<Classroom> optionalClassroom = classroomRepository.findByRoomCode(createClassroomRequest.getRoomCode());
        if (optionalClassroom.isPresent()) {
            throw new ClassroomCodeAlreadyException("ClassroomCode Already exist for Classroom");
        }
        return ClassroomConverter.MAPPER.classroomToClassroomDto(classroomRepository.save(
                Classroom.builder()
                        .id(createClassroomRequest.getId())
                        .roomCode(createClassroomRequest.getRoomCode())
                        .capacity(createClassroomRequest.getCapacity())
                        .createdDate(createClassroomRequest.getCreatedDate())
                        .updatedDate(createClassroomRequest.getUpdatedDate())
                        .build()
        ));
    }

    public ClassroomDto getClassroomById(Long id){
        return classroomRepository.findById(id)
                .map(ClassroomConverter.MAPPER::classroomToClassroomDto).orElseThrow(() -> new ResourceNotFoundException("Classroom", "Id", id));
    }

    public List<ClassroomDto> getAllClassrooms(){
        List<Classroom> classroomList = classroomRepository.findAll();
        return classroomList.stream()
                .map(ClassroomConverter.MAPPER::classroomToClassroomDto)
                .collect(Collectors.toList());
    }

    public ClassroomDto updateClassroom(Long id, UpdateClassroomRequest updateClassroomRequest){
        Optional<Classroom> classroomOptional = classroomRepository.findById(id);

        classroomOptional.ifPresent(classroom -> {
            classroom.setRoomCode(updateClassroomRequest.getRoomCode());
            classroom.setCapacity(updateClassroomRequest.getCapacity());
            classroomRepository.save(classroom);
        });

        return classroomOptional.map(ClassroomConverter.MAPPER::classroomToClassroomDto).orElseThrow(() -> new ResourceNotFoundException("Classroom", "Id", id));

    }

    public String deleteClassroom(Long id) {
        String username = getClassroomById(id).getRoomCode();
        classroomRepository.deleteById(id);
        return "Classroom with username: " + username + " is deleted!";
    }

}
