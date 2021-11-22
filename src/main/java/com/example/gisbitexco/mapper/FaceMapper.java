package com.example.gisbitexco.mapper;

import com.example.gisbitexco.dto.FaceDto;
import com.example.gisbitexco.entity.Face;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

/**
 * FaceMapper
 */
@Component
public interface FaceMapper {

    FaceDto toDto(Face face);

    List<FaceDto> toDtoList(List<Face> faces);

    Set<FaceDto> toDtoSet(Set<Face> faces);
}
