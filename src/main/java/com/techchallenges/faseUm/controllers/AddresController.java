package com.techchallenges.faseUm.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techchallenges.faseUm.dtos.AddressDTO;
import com.techchallenges.faseUm.services.AddressService;

@RestController
@RequestMapping("address")
public class AddresController {

    @Autowired
    AddressService addressService;

    @PostMapping
    public AddressDTO salvar(@RequestBody AddressDTO addressDTO) {
        return addressService.salvar(addressDTO);
    }
}
