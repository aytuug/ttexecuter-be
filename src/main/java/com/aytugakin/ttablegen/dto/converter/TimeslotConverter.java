package com.aytugakin.ttablegen.dto.converter;

import com.aytugakin.ttablegen.dto.TimeslotDto;
import com.aytugakin.ttablegen.model.Timeslot;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import timetable.TimeslotTimetable;

@Mapper
public interface TimeslotConverter {
    TimeslotConverter MAPPER = Mappers.getMapper(TimeslotConverter.class);
    Timeslot timeslotDtoToTimeslot(TimeslotDto timeslotDto);
    @Mapping(source = "timeslot.timeEnum.value", target = "timeEnum")
    TimeslotDto timeslotToTimeslotDto(Timeslot timeslot);
    TimeslotTimetable timeslotToTimeslotTable(Timeslot timeslot);
}
