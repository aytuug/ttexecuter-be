package com.aytugakin.ttablegen.controller;

import com.aytugakin.ttablegen.dto.CourseDto;
import com.aytugakin.ttablegen.dto.request.CreateCourseRequest;
import com.aytugakin.ttablegen.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/course")
public class CourseController {
    private final CourseService courseService;
    @PostMapping
    public ResponseEntity<CourseDto> createCourse(@RequestBody CreateCourseRequest createCourseRequest){
        return ResponseEntity.ok(courseService.createCourse(createCourseRequest));
    }
}
