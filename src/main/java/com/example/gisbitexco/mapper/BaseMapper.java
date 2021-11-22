package com.example.gisbitexco.mapper;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

/**
 * BaseMapper
 * <>
 * Map from output entity(ies) to DTO
 * </>
 *
 * @param <D> DTO types
 * @param <E> Entity type
 */
@Component
public interface BaseMapper<D, E> {

    D toDto(E entity);

    List<D> toDtoList(List<E> entities);

    Set<D> toDtoSet(Set<E> entities);
}
