package com.aytugakin.ttablegen.controller;

import com.aytugakin.ttablegen.dto.TimeslotDto;
import com.aytugakin.ttablegen.dto.request.CreateTimeslotRequest;
import com.aytugakin.ttablegen.service.TimeslotService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(allowedHeaders = "*", origins = "*")

@RestController
@RequiredArgsConstructor
@RequestMapping("api/timeslot")
public class TimeslotController {
    private final TimeslotService timeslotService;

    @PostMapping
    public ResponseEntity<TimeslotDto> createTimeslot(@RequestBody CreateTimeslotRequest createTimeslotRequest){
        return ResponseEntity.ok(timeslotService.createTimeslot(createTimeslotRequest));
    }
    @GetMapping
    public ResponseEntity<List<TimeslotDto>> getAllTimeslots(){
        return ResponseEntity.ok(timeslotService.getAllTimeslots());
    }
    @GetMapping("/{id}")
    public ResponseEntity<TimeslotDto> getTimeslotsById(@PathVariable Long id){
        return ResponseEntity.ok(timeslotService.getTimeslotById(id));
    }
}
