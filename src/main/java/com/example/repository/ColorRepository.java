package com.example.repository;

import com.example.model.Color;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("colorRepository")
public interface ColorRepository extends JpaRepository<Color,Integer> {
    Color findById(long id);
    @Query("SELECT c FROM Color c")
    List<Color> findAll();
}
