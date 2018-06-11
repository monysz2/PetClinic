package com.example.repository;

import com.example.model.Breed;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("breedRepository")
public interface BreedRepository extends JpaRepository<Breed,Integer> {
    Breed findById(long id);
    @Query("SELECT b FROM Breed b")
    List<Breed> findAll();
}
