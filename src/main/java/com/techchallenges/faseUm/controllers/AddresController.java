package com.techchallenges.faseUm.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techchallenges.faseUm.dtos.AddressDTO;
import com.techchallenges.faseUm.services.AddressService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("address")
public class AddresController {

    @Autowired
    AddressService addressService;

    @PostMapping
    public AddressDTO save(@Valid @RequestBody AddressDTO addressDTO) {
        return addressService.save(addressDTO);
    }

    @PutMapping
    public ResponseEntity<?> update(@Valid @RequestBody AddressDTO addressDTO) {
        addressService.update(addressDTO);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public List<AddressDTO> getAll() {
        return addressService.getAll();
    }

    @GetMapping("/{id}")
    public AddressDTO getById(@PathVariable UUID id) {
        return addressService.getById(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable UUID id) {
        addressService.delete(id);
        return ResponseEntity.ok().build();
    }
}
