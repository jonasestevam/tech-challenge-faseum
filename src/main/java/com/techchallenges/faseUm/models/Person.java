package com.techchallenges.faseUm.models;

import java.time.LocalDate;
import java.util.UUID;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "TB_PERSON")
@Getter
@Setter
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "GENDER")
    private String gender;

    @Column(name = "BIRTH_DATE")
    private LocalDate birthDate;

    @ManyToOne
    @JoinColumn(name = "PARENT_ID")
    @OnDelete(action = OnDeleteAction.SET_NULL)
    private Person parent;

}
