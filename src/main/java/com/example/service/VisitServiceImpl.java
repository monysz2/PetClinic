package com.example.service;

import com.example.common.enums.WorkingHours;
import com.example.model.Animal;
import com.example.model.Visit;
import com.example.repository.AnimalRepository;
import com.example.repository.VisitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service("visitService")
public class VisitServiceImpl implements VisitService {

    @Autowired
    private VisitRepository visitRepository;

    @Autowired
    private AnimalRepository animalRepository;

    @Override
    public List<WorkingHours> findFreeHoursAtDate(Date date) {
        return null;
    }

    @Override
    public void saveVisit(Visit visit) {
        Animal animal = animalRepository.findById(visit.getAnimal().getId());
        visit.setAnimal(animal);
        visitRepository.save(visit);
    }

    @Override
    public List<Visit> findAll() {
        return visitRepository.findAll();
    }

    @Override
    public List<Visit> findAllHistoricUsersVisits(long userId) {
        return visitRepository.findAllUsersHistoricVisits(userId);
    }
}
