package com.aytugakin.ttablegen.controller;

import com.aytugakin.ttablegen.dto.ClassroomDto;
import com.aytugakin.ttablegen.dto.request.CreateClassroomRequest;
import com.aytugakin.ttablegen.dto.request.UpdateClassroomRequest;
import com.aytugakin.ttablegen.service.ClassroomService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(allowedHeaders = "*", origins = "*")
@RestController
@RequiredArgsConstructor
@RequestMapping("api/classroom")
public class ClassroomController {
    private final ClassroomService classroomService;
    @PostMapping
    public ResponseEntity<ClassroomDto> createClassroom(@RequestBody CreateClassroomRequest createClassroomRequest){
        return ResponseEntity.ok(classroomService.createClassroom(createClassroomRequest));
    }
    @GetMapping
    public ResponseEntity<List<ClassroomDto>> getAllClassrooms(){
        return ResponseEntity.ok(classroomService.getAllClassrooms());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClassroomDto> getClassroomById(@PathVariable Long id){
        return ResponseEntity.ok(classroomService.getClassroomById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClassroomDto> updateClassroom(@PathVariable Long id, @RequestBody UpdateClassroomRequest updateClassroomRequest){
        return ResponseEntity.ok(classroomService.updateClassroom(id, updateClassroomRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClassroom(@PathVariable Long id){
        classroomService.deleteClassroom(id);
        return ResponseEntity.ok().build();
    }
}
