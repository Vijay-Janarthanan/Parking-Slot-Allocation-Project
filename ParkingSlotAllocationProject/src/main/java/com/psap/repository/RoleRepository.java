package com.psap.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.psap.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer>{

}
