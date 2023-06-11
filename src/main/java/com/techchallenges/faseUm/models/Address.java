package com.techchallenges.faseUm.models;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String streetName;
    private String neighborhood;
    private String city;
    private String state;
    private int number;

}
