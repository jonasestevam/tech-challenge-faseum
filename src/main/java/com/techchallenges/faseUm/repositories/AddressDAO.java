package com.techchallenges.faseUm.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.techchallenges.faseUm.mappers.AddressMapper;
import com.techchallenges.faseUm.models.Address;

@Repository
public class AddressDAO {

    @Autowired
    AddressMapper addressMapper;

    public Address salvar(Address address) {
        return address;
    }

}
