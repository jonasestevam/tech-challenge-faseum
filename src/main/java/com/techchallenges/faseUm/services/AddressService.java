package com.techchallenges.faseUm.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techchallenges.faseUm.dtos.AddressDTO;
import com.techchallenges.faseUm.mappers.AddressMapper;
import com.techchallenges.faseUm.models.Address;
import com.techchallenges.faseUm.repositories.AddressDAO;

@Service
public class AddressService {

    @Autowired
    AddressDAO addressDAO;

    @Autowired
    AddressMapper addressMapper;

    public AddressDTO salvar(AddressDTO addressDTO) {
        Address savedAddress = addressDAO.save(addressMapper.toEntity(addressDTO));
        return addressMapper.toDto(savedAddress);
    }

}
