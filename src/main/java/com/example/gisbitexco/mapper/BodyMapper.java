package com.example.gisbitexco.mapper;

import com.example.gisbitexco.dto.BodyDto;
import com.example.gisbitexco.entity.Body;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

/**
 * BodyMapper
 */
@Component
public interface BodyMapper {

    BodyDto toDto(Body body);

    List<BodyDto> toDtoList(List<Body> bodies);

    Set<BodyDto> toDtoSet(Set<Body> bodies);
}
