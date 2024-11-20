package com.deportment.data.service.deportmentExchang.service;

import com.deportment.data.service.deportmentExchang.dto.DeportmentDTO;
import org.springframework.stereotype.Service;


public interface DeportmentService {
    DeportmentDTO saveDeportment(DeportmentDTO deportmentDTO);
}
