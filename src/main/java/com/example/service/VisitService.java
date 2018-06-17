package com.example.service;

import com.example.common.enums.WorkingHours;
import com.example.model.Visit;

import java.util.Date;
import java.util.List;

public interface VisitService {
    public List<WorkingHours> findFreeHoursAtDate(Date date);
    public void saveVisit(Visit visit);
    public List<Visit> findAll();
    public List<Visit> findAllHistoricUsersVisits(long userId);
}
