package com.aytugakin.ttablegen.controller;

import com.aytugakin.ttablegen.dto.request.CreateFacultyRequest;
import com.aytugakin.ttablegen.dto.request.UpdateFacultyRequest;
import com.aytugakin.ttablegen.dto.response.FacultyResponse;
import com.aytugakin.ttablegen.service.FacultyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/faculty")
public class FacultyController {
    private final FacultyService facultyService;
    @PostMapping
    public ResponseEntity<FacultyResponse> createFaculty(@RequestBody CreateFacultyRequest createFacultyRequest){
        return ResponseEntity.ok(facultyService.createFaculty(createFacultyRequest));
    }
    @GetMapping
    public ResponseEntity<List<FacultyResponse>> getAllFaculties(){
        return ResponseEntity.ok(facultyService.getAllFaculties());
    }

    @GetMapping("/{id}")
    public ResponseEntity<FacultyResponse> getFacultyById(@PathVariable Long id){
        return ResponseEntity.ok(facultyService.getFacultyById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<FacultyResponse> updateFaculty(@PathVariable Long id, @RequestBody UpdateFacultyRequest updateFacultyRequest){
        return ResponseEntity.ok(facultyService.updateFaculty(id, updateFacultyRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFaculty(@PathVariable Long id){
        facultyService.deleteFaculty(id);
        return ResponseEntity.ok().build();
    }
}
