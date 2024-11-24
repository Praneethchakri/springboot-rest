package com.deportment.data.service.deportmentExchang.service;

import com.deportment.data.service.deportmentExchang.dto.APIresponseDTO;
import com.deportment.data.service.deportmentExchang.dto.DeportmentDTO;


public interface DeportmentService {
    DeportmentDTO saveDeportment(DeportmentDTO deportmentDTO);
    DeportmentDTO findDeportmentByDeportmentCode(String deportmentCode);

    DeportmentDTO findDeportmentByName(String deportmentName);

    APIresponseDTO findEmployessByDeportmentCode(String deportmentCode);
}
