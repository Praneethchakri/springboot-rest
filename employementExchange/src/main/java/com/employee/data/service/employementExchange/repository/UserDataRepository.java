package com.employee.data.service.employementExchange.repository;

import com.employee.data.service.employementExchange.entityModel.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDataRepository extends JpaRepository<User,Long> {

}
