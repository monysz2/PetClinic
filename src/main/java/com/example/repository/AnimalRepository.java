package com.example.repository;

import com.example.model.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;


@Repository("animalRepository")
public interface AnimalRepository extends JpaRepository<Animal,Integer>{
    public Animal findById(long id);
    @Query("SELECT a FROM Animal a WHERE 1=1")
    public List<Animal> findAll();
}
