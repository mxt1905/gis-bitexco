package com.example.gisbitexco.mapper.impl;

import com.example.gisbitexco.dto.BodyDto;
import com.example.gisbitexco.entity.Body;
import com.example.gisbitexco.mapper.BodyMapper;
import com.example.gisbitexco.mapper.FaceMapper;
import com.example.gisbitexco.mapper.FieldMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * BodyMapperImpl
 */
@Component
@RequiredArgsConstructor
public class BodyMapperImpl implements BodyMapper {

    private final FieldMapper fieldMapper;
    private final FaceMapper faceMapper;

    @Override
    public BodyDto toDto(Body body) {
        if (Objects.isNull(body))
            return null;
        BodyDto response = new BodyDto();
        response.setBodyId(body.getBodyId())
            .setBodyName(body.getBodyName())
            .setBodyColor(body.getBodyColor())
            .setBodyDesc(body.getBodyDesc())
            .setBodyHeight(body.getBodyHeight())
            .setBodyStorey(body.getBodyStorey())
            .setBodyAddress(body.getBodyAddress())
            .setField(fieldMapper.toDto(body.getField()))
            .setFaces(faceMapper.toDtoSet(body.getFaces()));
        return response;
    }

    @Override
    public List<BodyDto> toDtoList(List<Body> bodies) {
        if (Objects.isNull(bodies) || bodies.isEmpty())
            return Collections.emptyList();
        List<BodyDto> response = new ArrayList<>();
        bodies.forEach(body -> response.add(this.toDto(body)));
        return response;
    }

    @Override
    public Set<BodyDto> toDtoSet(Set<Body> bodies) {
        if (Objects.isNull(bodies) || bodies.isEmpty())
            return Collections.emptySet();
        Set<BodyDto> response = new HashSet<>();
        bodies.forEach(body -> response.add(this.toDto(body)));
        return response;
    }
}
