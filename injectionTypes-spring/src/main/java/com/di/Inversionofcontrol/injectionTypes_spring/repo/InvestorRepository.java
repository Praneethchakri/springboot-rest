package com.di.Inversionofcontrol.injectionTypes_spring.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.di.Inversionofcontrol.injectionTypes_spring.model.Investor;

@Repository
public interface InvestorRepository extends JpaRepository<Investor, Integer> {

}
