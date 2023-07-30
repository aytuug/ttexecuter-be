package com.aytugakin.ttablegen.service;

import com.aytugakin.ttablegen.dto.converter.FacultyConverter;
import com.aytugakin.ttablegen.dto.request.CreateFacultyRequest;
import com.aytugakin.ttablegen.dto.request.UpdateFacultyRequest;
import com.aytugakin.ttablegen.dto.response.FacultyResponse;
import com.aytugakin.ttablegen.exception.EmailAlreadyExistException;
import com.aytugakin.ttablegen.exception.FacultyNameAlreadyException;
import com.aytugakin.ttablegen.exception.ResourceNotFoundException;
import com.aytugakin.ttablegen.model.Faculty;
import com.aytugakin.ttablegen.repository.FacultyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FacultyService {
    private final FacultyRepository facultyRepository;
    public FacultyResponse createFaculty(CreateFacultyRequest createFacultyRequest) {
        Faculty faculty = new Faculty(
               createFacultyRequest.getId(),
                createFacultyRequest.getName(),
                createFacultyRequest.getCapacity(),
                createFacultyRequest.getCreatedDate(),
                createFacultyRequest.getUpdatedDate(),
                Collections.emptyList()
        );

        Optional<Faculty> optionalFaculty = facultyRepository.findByName(createFacultyRequest.getName());
        if (optionalFaculty.isPresent()) {
            throw new FacultyNameAlreadyException("Faculty name Already exist for Faculty");
        }

        facultyRepository.save(faculty);
        return FacultyConverter.MAPPER.facultyToFacultyResponse(faculty);
    }

    public FacultyResponse getFacultyById(Long id){
        return facultyRepository.findById(id)
                .map(FacultyConverter.MAPPER::facultyToFacultyResponse).orElseThrow(() -> new ResourceNotFoundException("Faculty", "Id", id));
    }

    public List<FacultyResponse> getAllFaculties(){
        List<Faculty> facultyList = facultyRepository.findAll();
        return facultyList.stream()
                .map(FacultyConverter.MAPPER::facultyToFacultyResponse)
                .collect(Collectors.toList());
    }

    public FacultyResponse updateFaculty(Long id, UpdateFacultyRequest updateFacultyRequest){
        Optional<Faculty> facultyOptional = facultyRepository.findById(id);

        facultyOptional.ifPresent(faculty -> {
            faculty.setName(updateFacultyRequest.getName());
            faculty.setCapacity(updateFacultyRequest.getCapacity());
            facultyRepository.save(faculty);
        });

        return facultyOptional.map(FacultyConverter.MAPPER::facultyToFacultyResponse).orElseThrow(() -> new ResourceNotFoundException("Faculty", "Id", id));

    }

    public String deleteFaculty(Long id) {
        String username = getFacultyById(id).getName();
        facultyRepository.deleteById(id);
        return "Faculty with username: " + username + " is deleted!";
    }
}
