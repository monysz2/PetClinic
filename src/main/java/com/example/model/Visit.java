package com.example.model;

import com.example.common.enums.WorkingHours;

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

    @Column(name="hour")
    @Enumerated(EnumType.STRING)
    private WorkingHours hour;

    @Column(name="description")
    private String description;

    @Column(name="notes")
    private String notes;



    @OneToOne(fetch = FetchType.EAGER)
    @MapsId
    private Animal animal;

    @Column(name="complete")
    private boolean completed;

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

    public WorkingHours getHour() {
        return hour;
    }

    public void setHour(WorkingHours hour) {
        this.hour = hour;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
