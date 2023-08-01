package com.aytugakin.ttablegen.dto.converter;

import com.aytugakin.ttablegen.dto.ClassroomDto;
import com.aytugakin.ttablegen.model.Classroom;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import timetable.Room;

@Mapper
public interface ClassroomConverter {
    ClassroomConverter MAPPER = Mappers.getMapper(ClassroomConverter.class);
    Classroom classroomDtoToClassroom(ClassroomDto classroomDto);
    ClassroomDto classroomToClassroomDto(Classroom classroom);
    Room classroomToRoom(Classroom classroom);
}
