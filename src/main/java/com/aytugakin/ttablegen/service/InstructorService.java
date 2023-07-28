package com.aytugakin.ttablegen.service;

import com.aytugakin.ttablegen.dto.InstructorDto;
import com.aytugakin.ttablegen.dto.converter.DepartmentConverter;
import com.aytugakin.ttablegen.dto.converter.InstructorConverter;
import com.aytugakin.ttablegen.dto.request.CreateInstructorRequest;
import com.aytugakin.ttablegen.dto.request.UpdateInstructorRequest;
import com.aytugakin.ttablegen.dto.response.InstructorResponse;
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
    public InstructorResponse createInstructor(CreateInstructorRequest createInstructorRequest) {
        Instructor instructor = new Instructor(
                createInstructorRequest.getId(),
                createInstructorRequest.getName(),
                createInstructorRequest.getSurname(),
                createInstructorRequest.getEmail(),
                createInstructorRequest.getCreatedDate(),
                createInstructorRequest.getUpdatedDate(),
                DepartmentConverter.MAPPER.departmentRequestToDepartmentForInstructor(createInstructorRequest.getDepartment())
        );
        Optional<Instructor> optionalInstructor = instructorRepository.findByEmail(createInstructorRequest.getEmail());
        if (optionalInstructor.isPresent()) {
            throw new EmailAlreadyExistException("Email Already exist for Instructor");
        }
        instructorRepository.save(instructor);
        return InstructorConverter.MAPPER.instructorToInstructorResponse(instructor);
    }

    public InstructorResponse getInstructorById(Long id){
        return instructorRepository.findById(id)
                .map(InstructorConverter.MAPPER::instructorToInstructorResponse).orElseThrow(() -> new ResourceNotFoundException("Instructor", "Id", id));
    }

    public List<InstructorResponse> getAllInstructors(){
        List<Instructor> userList = instructorRepository.findAll();
        return userList.stream()
                .map(InstructorConverter.MAPPER::instructorToInstructorResponse)
                .collect(Collectors.toList());
    }

    public InstructorResponse updateInstructor(Long id, UpdateInstructorRequest updateInstructorRequest){
        Optional<Instructor> instructorOptional = instructorRepository.findById(id);

        instructorOptional.ifPresent(instructor -> {
            instructor.setEmail(updateInstructorRequest.getEmail());
            instructorRepository.save(instructor);
        });

        return instructorOptional.map(InstructorConverter.MAPPER::instructorToInstructorResponse).orElseThrow(() -> new ResourceNotFoundException("Instructor", "Id", id));

    }

    public String deleteInstructor(Long id) {
        String username = getInstructorById(id).getName();
        instructorRepository.deleteById(id);
        return "Instructor with username: " + username + " is deleted!";
    }

}
