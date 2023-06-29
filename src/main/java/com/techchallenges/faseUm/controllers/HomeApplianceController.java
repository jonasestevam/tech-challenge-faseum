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

import com.techchallenges.faseUm.dtos.HomeApplianceDTO;
import com.techchallenges.faseUm.services.HomeApplianceService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("homeappliance")
public class HomeApplianceController {

    @Autowired
    HomeApplianceService homeApplianceService;

    @PostMapping
    public HomeApplianceDTO save(@Valid @RequestBody HomeApplianceDTO newHomeAppliance) {
        return homeApplianceService.save(newHomeAppliance);
    }

    @PutMapping
    public HomeApplianceDTO update(@Valid @RequestBody HomeApplianceDTO homeApplianceToEdit) {
        return homeApplianceService.update(homeApplianceToEdit);
    }

    @GetMapping
    public List<HomeApplianceDTO> getAll() {
        return homeApplianceService.getAll();
    }

    @GetMapping("/{id}")
    public HomeApplianceDTO getByID(@PathVariable UUID id) {
        return homeApplianceService.getById(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable UUID id) {
        homeApplianceService.delete(id);
        return ResponseEntity.ok().build();
    }

}
