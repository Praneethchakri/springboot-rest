package com.deportment.data.service.deportmentExchang.repository;

import com.deportment.data.service.deportmentExchang.entity.Deportment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeportmentRepository extends JpaRepository<Deportment,Long> {
    Deportment findDeportmentByDeportmentCode(String deportmentByCode);

    Deportment findDeportmentByDeportmentName(String deportmentName);



}
