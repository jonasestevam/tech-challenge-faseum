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

import com.techchallenges.faseUm.dtos.PersonDTO;
import com.techchallenges.faseUm.services.PersonService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("person")
public class PersonController {

    @Autowired
    PersonService personService;

    @PostMapping
    public PersonDTO save(@Valid @RequestBody PersonDTO newPerson) {
        return personService.save(newPerson);
    }

    @PutMapping
    public ResponseEntity<?> update(@Valid @RequestBody PersonDTO personDTO) {
        personService.update(personDTO);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public List<PersonDTO> getAll() {
        return personService.getAll();
    }

    @GetMapping("/{id}")
    public PersonDTO getById(@PathVariable UUID id) {
        return personService.getById(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable UUID id) {
        personService.delete(id);
        return ResponseEntity.ok().build();
    }

}