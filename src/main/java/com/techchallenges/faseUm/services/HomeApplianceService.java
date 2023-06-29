package com.techchallenges.faseUm.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techchallenges.faseUm.dtos.HomeApplianceDTO;
import com.techchallenges.faseUm.mappers.HomeApplianceMapper;
import com.techchallenges.faseUm.repositories.HomeApplianceDAO;

import jakarta.persistence.NoResultException;

@Service
public class HomeApplianceService implements BaseService<HomeApplianceDTO> {

    @Autowired
    HomeApplianceDAO homeApplianceDAO;

    @Autowired
    HomeApplianceMapper homeApplianceMapper;

    public List<HomeApplianceDTO> getAll() {
        return homeApplianceMapper.toDto(homeApplianceDAO.findAll());
    }

    public HomeApplianceDTO getById(UUID id) {
        checkIfExists(id);
        return homeApplianceMapper.toDto(homeApplianceDAO.findById(id).get());
    }

    public HomeApplianceDTO save(HomeApplianceDTO newHomeAppliance) {
        return homeApplianceMapper.toDto(homeApplianceDAO.save(homeApplianceMapper.toEntity(newHomeAppliance)));
    }

    public HomeApplianceDTO update(HomeApplianceDTO homeApplianceToEdit) {
        checkIfExists(homeApplianceToEdit.getId());
        return homeApplianceMapper.toDto(homeApplianceDAO.save(homeApplianceMapper.toEntity(homeApplianceToEdit)));
    }

    public void delete(UUID id) {
        checkIfExists(id);
        homeApplianceDAO.deleteById(id);
    }

    private void checkIfExists(UUID id) {
        if (!homeApplianceDAO.existsById(id)) {
            throw new NoResultException("This home appliance was not found");
        }
    }

}
