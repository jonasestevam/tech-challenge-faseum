package com.techchallenges.faseUm.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techchallenges.faseUm.models.Address;

public interface AddressDAO extends JpaRepository<Address, UUID> {

}
