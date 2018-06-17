package com.example.model;

import com.example.common.enums.AnimalSex;
import com.example.common.enums.AnimalType;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="animals")
public class Animal {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    @Id
    private long id;

    @Column(name="name")
    @NotEmpty(message = "*Please provide name")
    private String name;
    @Column(name="date_of_birth")
    private java.util.Date dateOfBirth;
    @Column(name="sex")
    @Enumerated(EnumType.STRING)
    private AnimalSex sex;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="owner_id" )
    private User owner;

    @Column(name="breed")
    private String breed;

    @Column(name="animal_type")
    @Enumerated(EnumType.STRING)
    private AnimalType animalType;

    public List<Visit> getVisits() {
        return visits;
    }

    public void setVisits(List<Visit> visits) {
        this.visits = visits;
    }

    @OneToMany(
    mappedBy = "animal",
    cascade = CascadeType.ALL,
    orphanRemoval = true
            )
    private List<Visit> visits = new ArrayList<>();

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

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public AnimalSex getSex() {
        return sex;
    }

    public void setSex(AnimalSex sex) {
        this.sex = sex;
    }

    public AnimalType getAnimalType() {
        return animalType;
    }

    public void setAnimalType(AnimalType animalType) {
        this.animalType = animalType;
    }


}
