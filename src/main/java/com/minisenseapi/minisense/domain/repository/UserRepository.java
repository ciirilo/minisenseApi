package com.minisenseapi.minisense.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.minisenseapi.minisense.domain.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	boolean existsByEmail(String email);

}
	