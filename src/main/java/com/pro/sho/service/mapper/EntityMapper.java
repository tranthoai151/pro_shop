package com.pro.sho.service.mapper;
import java.io.IOException;
import java.util.List;


/**
 * Contract for a generic dto to entity mapper.
 *
 * @param <D> - DTO type parameter.
 * @param <E> - Entity type parameter.
 */

public interface EntityMapper <D, E> {

    E toEntity(D dto);

    D toDto(E entity) throws IOException;

    List <E> toEntity(List<D> dtoList);

    List <D> toDto(List<E> entityList);
}
