package com.aytugakin.ttablegen.service;

import com.aytugakin.ttablegen.dto.InstructorDto;
import com.aytugakin.ttablegen.dto.converter.InstructorConverter;
import com.aytugakin.ttablegen.dto.request.CreateInstructorRequest;
import com.aytugakin.ttablegen.dto.request.UpdateInstructorRequest;
import com.aytugakin.ttablegen.exception.EmailAlreadyExistException;
import com.aytugakin.ttablegen.exception.ResourceNotFoundException;
import com.aytugakin.ttablegen.model.Instructor;
import com.aytugakin.ttablegen.repository.InstructorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class InstructorService {
    private final InstructorRepository instructorRepository;
    private final InstructorConverter instructorConverter;
    public InstructorDto createInstructor(CreateInstructorRequest createInstructorRequest) {
        Instructor instructor = new Instructor(
            createInstructorRequest.id(),
                createInstructorRequest.name(),
                createInstructorRequest.surname(),
                createInstructorRequest.email()
        );
        Optional<Instructor> optionalInstructor = instructorRepository.findByEmail(createInstructorRequest.email());
        if (optionalInstructor.isPresent()) {
            throw new EmailAlreadyExistException("Email Already exist for Instructor");
        }
        instructorRepository.save(instructor);
        return instructorConverter.convertInstructorDto(instructor);
    }

    public InstructorDto getInstructorById(Long id){
        return instructorRepository.findById(id)
                .map(instructorConverter::convertInstructorDto).orElseThrow(() -> new ResourceNotFoundException("Instructor", "Id", id));
    }

    public List<InstructorDto> getAllInstructors(){
        List<Instructor> userList = instructorRepository.findAll();
        return userList.stream()
                .map(instructorConverter::convertInstructorDto)
                .collect(Collectors.toList());
    }

    public InstructorDto updateInstructor(Long id, UpdateInstructorRequest updateInstructorRequest){
        Optional<Instructor> instructorOptional = instructorRepository.findById(id);

        instructorOptional.ifPresent(instructor -> {
            instructor.setEmail(updateInstructorRequest.email());
            instructorRepository.save(instructor);
        });

        return instructorOptional.map(instructorConverter::convertInstructorDto).orElseThrow(() -> new ResourceNotFoundException("Instructor", "Id", id));

    }

    public String deleteInstructor(Long id) {
        String username = getInstructorById(id).name();
        instructorRepository.deleteById(id);
        return "User with username: " + username + " is deleted!";
    }

}
