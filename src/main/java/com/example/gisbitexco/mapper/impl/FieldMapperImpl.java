package com.example.gisbitexco.mapper.impl;

import com.example.gisbitexco.dto.FieldDto;
import com.example.gisbitexco.entity.Field;
import com.example.gisbitexco.mapper.FieldMapper;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * FieldMapperImpl
 */
@Component
public class FieldMapperImpl implements FieldMapper {

    @Override
    public FieldDto toDto(Field field) {
        if (Objects.isNull(field))
            return null;
        FieldDto response = new FieldDto();
        response.setFieldId(field.getFieldId())
            .setFieldName(field.getFieldName());
        return response;
    }

    @Override
    public List<FieldDto> toDtoList(List<Field> fields) {
        if (Objects.isNull(fields) || fields.isEmpty())
            return Collections.emptyList();
        List<FieldDto> response = new ArrayList<>();
        fields.forEach(field -> response.add(this.toDto(field)));
        return response;
    }

    @Override
    public Set<FieldDto> toDtoSet(Set<Field> fields) {
        if (Objects.isNull(fields) || fields.isEmpty())
            return Collections.emptySet();
        Set<FieldDto> response = new HashSet<>();
        fields.forEach(field -> response.add(this.toDto(field)));
        return response;
    }
}
