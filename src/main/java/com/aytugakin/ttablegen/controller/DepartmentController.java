package com.aytugakin.ttablegen.controller;

import com.aytugakin.ttablegen.dto.request.CreateDepartmentRequest;
import com.aytugakin.ttablegen.dto.request.UpdateDepartmentRequest;
import com.aytugakin.ttablegen.dto.response.DepartmentResponse;
import com.aytugakin.ttablegen.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(allowedHeaders = "*", origins = "*")
@RestController
@RequiredArgsConstructor
@RequestMapping("api/department")
public class DepartmentController {
    private final DepartmentService departmentService;
    @PostMapping
    public ResponseEntity<DepartmentResponse> createDepartment(@RequestBody CreateDepartmentRequest createDepartmentRequest){
        return ResponseEntity.ok(departmentService.createDepartment(createDepartmentRequest));
    }
    @GetMapping
    public ResponseEntity<List<DepartmentResponse>> getAllDepartments(){
        return ResponseEntity.ok(departmentService.getAllDepartments());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DepartmentResponse> getDepartmentById(@PathVariable Long id){
        return ResponseEntity.ok(departmentService.getDepartmentById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DepartmentResponse> updateDepartment(@PathVariable Long id, @RequestBody UpdateDepartmentRequest updateDepartmentRequest){
        return ResponseEntity.ok(departmentService.updateDepartment(id, updateDepartmentRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDepartment(@PathVariable Long id){
        departmentService.deleteDepartment(id);
        return ResponseEntity.ok().build();
    }
}
