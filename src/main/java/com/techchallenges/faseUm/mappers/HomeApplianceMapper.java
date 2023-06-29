package com.techchallenges.faseUm.mappers;

import org.mapstruct.Mapper;

import com.techchallenges.faseUm.dtos.HomeApplianceDTO;
import com.techchallenges.faseUm.models.HomeAppliance;

@Mapper(componentModel = "spring")
public interface HomeApplianceMapper extends BaseMapper<HomeApplianceDTO, HomeAppliance> {
}
