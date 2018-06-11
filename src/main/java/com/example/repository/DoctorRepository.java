package com.example.repository;

import com.example.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("doctorRepository")
public interface DoctorRepository extends JpaRepository<Doctor,Integer> {
    Doctor findById(long id);
    @Query("SELECT d FROM Doctor d")
    List<Doctor> findAll();
}
