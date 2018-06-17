package com.example.service;

import com.example.model.Animal;
import com.example.repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("animalService")
public class AnimalServiceImpl implements AnimalService {

    @Autowired
    AnimalRepository animalRepository;

    @Override
    public List<Animal> findAll() {
        return animalRepository.findAll();
    }

    @Override
    public Animal findById(long id) {
        return animalRepository.findById(id);
    }

    @Override
    public void addAnimal(Animal animal) {
        animalRepository.save(animal);
    }

    @Override
    public List<Animal> findUsersAnimals(long userId) {
        return animalRepository.findUsersAnimals(userId);
    }

    @Override
    public void saveAnimal(Animal animal) {
        animalRepository.save(animal);
    }
}
