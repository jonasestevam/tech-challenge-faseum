package com.techchallenges.faseUm.mappers;

public interface BaseMapper<D, E> {
    D toDto(E entity);

    E toEntity(D dto);
}