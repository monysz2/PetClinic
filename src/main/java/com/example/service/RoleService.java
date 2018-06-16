package com.example.service;

import com.example.model.Role;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Set;

public interface RoleService {

    List<Role> findAll();
}
