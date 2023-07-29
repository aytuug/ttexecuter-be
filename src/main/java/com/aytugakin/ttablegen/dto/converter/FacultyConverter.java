package com.aytugakin.ttablegen.dto.converter;

import com.aytugakin.ttablegen.dto.FacultyDto;
import com.aytugakin.ttablegen.dto.request.CreateFacultyRequest;
import com.aytugakin.ttablegen.dto.response.FacultyResponse;
import com.aytugakin.ttablegen.model.Faculty;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface FacultyConverter {
    FacultyConverter MAPPER = Mappers.getMapper(FacultyConverter.class);
    Faculty facultyDtoToFaculty(FacultyDto facultyDto);
    FacultyDto facultyToFacultyDto(Faculty faculty);
    FacultyResponse facultyToFacultyResponse(Faculty faculty);

    Faculty facultyRequestToFaculty(CreateFacultyRequest createFacultyRequest);

}
