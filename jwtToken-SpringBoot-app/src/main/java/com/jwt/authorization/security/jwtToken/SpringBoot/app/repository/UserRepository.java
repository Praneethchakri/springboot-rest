package com.jwt.authorization.security.jwtToken.SpringBoot.app.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jwt.authorization.security.jwtToken.SpringBoot.app.entity.UserRegisterEntity;

@Repository
public interface UserRepository extends CrudRepository<UserRegisterEntity, Integer> {
	Optional<UserRegisterEntity> findByEmail(String email);
}
