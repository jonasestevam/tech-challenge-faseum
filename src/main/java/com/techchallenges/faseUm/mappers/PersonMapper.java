package com.techchallenges.faseUm.mappers;

import org.mapstruct.Mapper;

import com.techchallenges.faseUm.dtos.PersonDTO;
import com.techchallenges.faseUm.models.Person;

@Mapper(componentModel = "spring")
public interface PersonMapper extends BaseMapper<PersonDTO, Person> {
}
