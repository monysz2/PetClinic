package com.example.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="animals")
public class Animal {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    @Id
    private long id;
    @Column(name="name")
    private String name;
    @Column(name="date_of_birth")
    private java.util.Date dateOfBirth;
    @Column(name="sex")
    private String sex;
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="owner_id")
    private User owner;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="species_id")
    private Species species;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="breed_id")
    private Breed breed;
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public Species getSpecies() {
        return species;
    }

    public void setSpecies(Species species) {
        this.species = species;
    }

    public Breed getBreed() {
        return breed;
    }

    public void setBreed(Breed breed) {
        this.breed = breed;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
}
