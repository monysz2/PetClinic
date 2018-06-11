package com.example.repository;

import com.example.model.Species;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("speciesRepository")
public interface SpeciesRepository extends JpaRepository<Species, Integer> {
    Species findById(long id);
    @Query("SELECT s FROM Species s")
    List<Species> findAll();
}
