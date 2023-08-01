package com.aytugakin.ttablegen.controller;

import com.aytugakin.ttablegen.service.TimetableService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/timetable")
public class TimetableController {
    private final TimetableService timetableService;

    //TODO BURASI DEĞİŞECEK CONSOLDA TEST ETMEK İÇİN YAZILDI. MODELLİ BİR ŞEKİLDE TEKRARDAN DUZENLENİCEK.
    @PostMapping
    public void createTimeslot(){
        timetableService.generateTimetable();
    }
}
