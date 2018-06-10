package com.example.service;

import com.example.model.Animal;

import java.util.List;

public interface AnimalService {
    public List<Animal> findAll();
    public Animal findById(long id);
    public void addAnimal(Animal animal);
}
