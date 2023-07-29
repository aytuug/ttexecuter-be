package com.aytugakin.ttablegen.controller;

import com.aytugakin.ttablegen.dto.request.CreateInstructorRequest;
import com.aytugakin.ttablegen.dto.request.UpdateInstructorRequest;
import com.aytugakin.ttablegen.dto.response.InstructorResponse;
import com.aytugakin.ttablegen.service.InstructorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/instructor")
public class InstructorController {
    private final InstructorService instructorService;
    @PostMapping
    public ResponseEntity<InstructorResponse> createInstructor(@RequestBody CreateInstructorRequest createInstructorRequest){
        return ResponseEntity.ok(instructorService.createInstructor(createInstructorRequest));
    }
    @GetMapping
    public ResponseEntity<List<InstructorResponse>> getAllInstructors(){
        return ResponseEntity.ok(instructorService.getAllInstructors());
    }

    @GetMapping("/{id}")
    public ResponseEntity<InstructorResponse> getInstructorById(@PathVariable Long id){
        return ResponseEntity.ok(instructorService.getInstructorById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<InstructorResponse> updateInstructor(@PathVariable Long id, @RequestBody UpdateInstructorRequest updateUserRequest){
        return ResponseEntity.ok(instructorService.updateInstructor(id, updateUserRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInstructor(@PathVariable Long id){
        instructorService.deleteInstructor(id);
        return ResponseEntity.ok().build();
    }
}
