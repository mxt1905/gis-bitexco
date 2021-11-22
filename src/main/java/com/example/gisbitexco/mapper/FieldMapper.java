package com.example.gisbitexco.mapper;

import com.example.gisbitexco.dto.FieldDto;
import com.example.gisbitexco.entity.Field;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

/**
 * FieldMapper
 */
@Component
public interface FieldMapper {

    FieldDto toDto(Field field);

    List<FieldDto> toDtoList(List<Field> fields);

    Set<FieldDto> toDtoSet(Set<Field> fields);
}
