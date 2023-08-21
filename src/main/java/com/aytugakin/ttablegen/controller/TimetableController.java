package com.aytugakin.ttablegen.controller;

import com.aytugakin.ttablegen.model.TTable;
import com.aytugakin.ttablegen.service.TTableService;
import com.aytugakin.ttablegen.service.TimetableService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(allowedHeaders = "*", origins = "*")

@RestController
@RequiredArgsConstructor
@RequestMapping("api/timetable")
public class TimetableController {
    private final TimetableService timetableService;
    private final TTableService tTableService;

    //TODO BURASI DEĞİŞECEK CONSOLDA TEST ETMEK İÇİN YAZILDI. MODELLİ BİR ŞEKİLDE TEKRARDAN DUZENLENİCEK.
    @GetMapping
    public ResponseEntity<Void> createTimetable(){
        timetableService.generateTimetable();
        return ResponseEntity.ok().build();
    }
    @GetMapping("/max")
    public ResponseEntity<List<TTable>> getMaxTTable(){
        return ResponseEntity.ok(tTableService.getMaxTTable());
    }
}
