package com.example.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="visits")
public class Visit {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name="date")
    private java.util.Date date;

    @Column(name="description")
    private String description;

    @Column(name="notes")
    private String notes;

    @OneToOne(fetch = FetchType.EAGER)
    @MapsId
    private Animal animal;
    @OneToOne(fetch = FetchType.EAGER)
    @MapsId
    private Doctor doctor;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

   public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

}
