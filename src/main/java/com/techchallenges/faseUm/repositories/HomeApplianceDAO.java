package com.techchallenges.faseUm.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techchallenges.faseUm.models.HomeAppliance;

public interface HomeApplianceDAO extends JpaRepository<HomeAppliance, UUID> {

}
