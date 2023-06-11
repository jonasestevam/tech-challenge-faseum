package com.techchallenges.faseUm.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressDTO {
    private String streetName;
    private String neighborhood;
    private String city;
    private String state;
    private int number;
}
