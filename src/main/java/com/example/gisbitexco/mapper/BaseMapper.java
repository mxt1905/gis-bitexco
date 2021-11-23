package com.example.gisbitexco.mapper;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

/**
 * BaseMapper
 * <p>
 * Map from entity to dto
 * </p>
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
