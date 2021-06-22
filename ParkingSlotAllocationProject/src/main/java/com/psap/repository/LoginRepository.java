package com.psap.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.psap.model.Login;

@Repository
public interface LoginRepository extends JpaRepository<Login, String> {
	Login findByLoginId(String loginId);
}
