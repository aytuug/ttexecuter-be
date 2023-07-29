package com.aytugakin.ttablegen.dto.converter;

import com.aytugakin.ttablegen.dto.CourseDto;
import com.aytugakin.ttablegen.model.Course;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CourseConverter {
    CourseConverter MAPPER = Mappers.getMapper(CourseConverter.class);
    Course courseDtoToCourse(CourseDto courseDto);
    @Mapping(source = "courseInstructors", target = "instructors")
    CourseDto courseToCourseDto(Course course);
}
