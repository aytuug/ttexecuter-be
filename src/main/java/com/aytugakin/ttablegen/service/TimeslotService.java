package com.aytugakin.ttablegen.service;

import com.aytugakin.ttablegen.dto.TimeslotDto;
import com.aytugakin.ttablegen.dto.converter.TimeslotConverter;
import com.aytugakin.ttablegen.dto.request.CreateTimeslotRequest;
import com.aytugakin.ttablegen.exception.ResourceNotFoundException;
import com.aytugakin.ttablegen.model.Timeslot;
import com.aytugakin.ttablegen.repository.TimeslotRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import timetable.TimeslotTimetable;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TimeslotService {

    private final TimeslotRepository timeslotRepository;

    public TimeslotDto createTimeslot(CreateTimeslotRequest createTimeslotRequest) {

        return TimeslotConverter.MAPPER.timeslotToTimeslotDto(timeslotRepository.save(
                Timeslot.builder()
                        .id(createTimeslotRequest.getId())
                        .timeEnum(createTimeslotRequest.getTimeEnum())
                        .createdDate(createTimeslotRequest.getCreatedDate())
                        .updatedDate(createTimeslotRequest.getUpdatedDate())
                        .build()
        ));
    }
    public TimeslotDto getTimeslotById(Long id){
        return timeslotRepository.findById(id)
                .map(TimeslotConverter.MAPPER::timeslotToTimeslotDto).orElseThrow(() -> new ResourceNotFoundException("Timeslot", "Id", id));
    }

    public List<TimeslotDto> getAllTimeslots(){
        List<Timeslot> userList = timeslotRepository.findAll();
        return userList.stream()
                .map(TimeslotConverter.MAPPER::timeslotToTimeslotDto)
                .collect(Collectors.toList());
    }

    public List<TimeslotTimetable> getAllTimeslotTables(){
        List<Timeslot> userList = timeslotRepository.findAll();
        return userList.stream()
                .map(TimeslotConverter.MAPPER::timeslotToTimeslotTable)
                .collect(Collectors.toList());
    }

}
