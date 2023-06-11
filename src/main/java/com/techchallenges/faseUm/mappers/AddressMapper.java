package com.techchallenges.faseUm.mappers;

import org.mapstruct.Mapper;

import com.techchallenges.faseUm.dtos.AddressDTO;
import com.techchallenges.faseUm.models.Address;

@Mapper(componentModel = "spring")
public interface AddressMapper extends BaseMapper<AddressDTO, Address> {
}
