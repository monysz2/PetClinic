package com.example.repository;

import com.example.common.enums.WorkingHours;
import com.example.model.Visit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Repository("visitRepository")
public interface VisitRepository extends JpaRepository<Visit, Integer> {


    public List<Visit> findAllByDate(Date date);
}
