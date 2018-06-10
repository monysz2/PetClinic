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
    @OneToOne(fetch = FetchType.EAGER)
    @MapsId
    private Animal animal;
    @OneToOne(fetch = FetchType.EAGER)
    @MapsId
    private Room room;
    @OneToOne(fetch = FetchType.EAGER)
    @MapsId
    private Doctor doctor;
    @OneToOne(fetch = FetchType.EAGER)
    @MapsId
    private VisitType visitType;

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

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public VisitType getVisitType() {
        return visitType;
    }

    public void setVisitType(VisitType visitType) {
        this.visitType = visitType;
    }
}
