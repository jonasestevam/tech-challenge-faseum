package com.techchallenges.faseUm.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techchallenges.faseUm.dtos.PersonDTO;
import com.techchallenges.faseUm.mappers.PersonMapper;
import com.techchallenges.faseUm.repositories.PersonDAO;

import jakarta.persistence.NoResultException;

@Service
public class PersonService implements BaseService<PersonDTO> {

    @Autowired
    PersonDAO personDAO;

    @Autowired
    PersonMapper personMapper;

    public PersonDTO save(PersonDTO newPerson) {

        return personMapper.toDto(personDAO.save(personMapper.toEntity(newPerson)));
    }

    public List<PersonDTO> getAll() {
        return personMapper.toDto(personDAO.findAll());
    }

    public PersonDTO getById(UUID id) {
        checkIfExists(id);
        return personMapper.toDto(personDAO.findById(id).get());
    }

    public PersonDTO update(PersonDTO personToEdit) {
        checkIfExists(personToEdit.getId());
        return personMapper.toDto(personDAO.save(personMapper.toEntity(personToEdit)));
    }

    public void delete(UUID id) {
        checkIfExists(id);
        personDAO.deleteById(id);
    }

    private void checkIfExists(UUID id) {
        if (!personDAO.existsById(id)) {
            throw new NoResultException("This person was not found");
        }
    }

}
