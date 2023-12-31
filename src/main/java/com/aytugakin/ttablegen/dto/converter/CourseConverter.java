package com.aytugakin.ttablegen.dto.converter;

import com.aytugakin.ttablegen.dto.CourseDto;
import com.aytugakin.ttablegen.model.Course;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import timetable.Module;

@Mapper
public interface CourseConverter {
    CourseConverter MAPPER = Mappers.getMapper(CourseConverter.class);
    @Mapping(source = "courseInstructors", target = "instructors")
    @Mapping(source = "courseStudents", target = "students")
    CourseDto courseToCourseDto(Course course);
}
