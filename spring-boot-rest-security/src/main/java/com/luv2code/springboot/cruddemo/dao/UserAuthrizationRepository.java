package com.luv2code.springboot.cruddemo.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.luv2code.springboot.cruddemo.entity.AppUser;

@Repository
public interface UserAuthrizationRepository extends JpaRepository<AppUser, Integer>{
	
	Optional<AppUser> findByUserName(String name);

}
