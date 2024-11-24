package com.deportment.data.service.deportmentExchang.service;

import com.deportment.data.service.deportmentExchang.dto.APIresponseDTO;
import com.deportment.data.service.deportmentExchang.dto.DeportmentDTO;
import com.deportment.data.service.deportmentExchang.dto.EmployeeDTO;
import com.deportment.data.service.deportmentExchang.entity.Deportment;
import com.deportment.data.service.deportmentExchang.repository.DeportmentRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.stream.Collectors;

import static com.deportment.data.service.deportmentExchang.mapper.DeportmentMapStruct.DEPORTMENT_MAP_STRUCT;
@Service
@AllArgsConstructor
public class DeportmentServiceImpl implements  DeportmentService{

    private DeportmentRepository deportmentRepository;
    private WebClient webClient;

    @Override
    public DeportmentDTO saveDeportment(DeportmentDTO deportmentDTO) {
        //Conveters come into Place  from DeportmentDTO to Deportment
        Deportment deportment = DEPORTMENT_MAP_STRUCT.maptTODeportment(deportmentDTO);
        System.out.println("DTO TO Deportment With MapStruct "+deportment);
        Deportment savedDeportment =  deportmentRepository.save(deportment);
        System.out.println("Database Save Deportment "+savedDeportment);
        System.out.println("Response DTO "+DEPORTMENT_MAP_STRUCT.mapToDeportmentDTO(savedDeportment));
        return DEPORTMENT_MAP_STRUCT.mapToDeportmentDTO(savedDeportment);
    }

    @Override
    public DeportmentDTO findDeportmentByDeportmentCode(String deportmentCode) {
        Deportment repoResult = deportmentRepository.findDeportmentByDeportmentCode(deportmentCode);
        DeportmentDTO deportmentDTO = DEPORTMENT_MAP_STRUCT.mapToDeportmentDTO(repoResult);
        return deportmentDTO;
    }
    @Override
    public DeportmentDTO findDeportmentByName(String deportmentName){
        Deportment repoResultBydeptName = deportmentRepository.findDeportmentByDeportmentName(deportmentName);
        DeportmentDTO deportmentDTO = DEPORTMENT_MAP_STRUCT.mapToDeportmentDTO(repoResultBydeptName);
        return  deportmentDTO;
    }

    @Override
    public APIresponseDTO findEmployessByDeportmentCode(String deportmentCode) {
        Deportment repoResult = deportmentRepository.findDeportmentByDeportmentCode(deportmentCode);
        DeportmentDTO deportmentDTO  = DEPORTMENT_MAP_STRUCT.mapToDeportmentDTO(repoResult);
        ResponseEntity<List<EmployeeDTO>> employeeDTOList = webClient.get()
                .uri("http://localhost:8080/employee-Data/AllEmployee")
                .retrieve()
                .toEntityList(EmployeeDTO.class)
                .block();
        List<EmployeeDTO> fetchBody = employeeDTOList.getBody().stream().filter(code->code.getDeportmentCode().equalsIgnoreCase(deportmentCode)).collect(Collectors.toList());

        APIresponseDTO apIresponseDTO = new APIresponseDTO();
             apIresponseDTO.setDeportmentDTO(deportmentDTO);
             apIresponseDTO.setEmployeeDTOList(fetchBody);
        return apIresponseDTO;
    }


}
