package com.deportment.data.service.deportmentExchang.service;

import com.deportment.data.service.deportmentExchang.dto.APIresponseDTO;
import com.deportment.data.service.deportmentExchang.dto.DeportmentDTO;
import com.deportment.data.service.deportmentExchang.dto.EmployeeDTO;
import com.deportment.data.service.deportmentExchang.entity.Deportment;
import com.deportment.data.service.deportmentExchang.repository.DeportmentRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.stream.Collectors;

import static com.deportment.data.service.deportmentExchang.mapper.DeportmentMapStruct.DEPORTMENT_MAP_STRUCT;
@Service
//@AllArgsConstructor
public class DeportmentServiceImpl implements  DeportmentService{

    private DeportmentRepository deportmentRepository;
    private WebClient webClient;

    private ApiClient apiClientOfFeignClient;

    public DeportmentServiceImpl(DeportmentRepository deportmentRepository, WebClient webClient, ApiClient apiClientOfFeignClient) {
        this.deportmentRepository = deportmentRepository;
        this.webClient = webClient;
        this.apiClientOfFeignClient = apiClientOfFeignClient;
    }

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
    public APIresponseDTO findDeportmentByName(String deportmentName){
        Deportment repoResultBydeptName = deportmentRepository.findDeportmentByDeportmentName(deportmentName);

        ResponseEntity<List<EmployeeDTO>> empList = webClient.get().uri("http://localhost:8080/employee-Data/AllEmployee")
                        .retrieve()
                                .toEntityList(EmployeeDTO.class)
                                        .block();


        List<EmployeeDTO> filterdEmplist = empList.getBody().stream().filter(employee->employee.getDeportmentCode().equalsIgnoreCase(repoResultBydeptName.getDeportmentCode()))
                        .collect(Collectors.toList());

        DeportmentDTO deportmentDTO = DEPORTMENT_MAP_STRUCT.mapToDeportmentDTO(repoResultBydeptName);
//        List<EmployeeDTO> employeeDTOList =  apiClientOfFeignClient.getAllExistingEmployee();
        return  new APIresponseDTO(deportmentDTO,filterdEmplist);
    }

    @Override
    public APIresponseDTO findEmployessByDeportmentCode(String deportmentCode) {
        Deportment repoResult = deportmentRepository.findDeportmentByDeportmentCode(deportmentCode);
        DeportmentDTO deportmentDTO  = DEPORTMENT_MAP_STRUCT.mapToDeportmentDTO(repoResult);
//        ResponseEntity<List<EmployeeDTO>> employeeDTOList = webClient.get()
//                .uri("http://localhost:8080/employee-Data/AllEmployee")
//                .retrieve()
//                .toEntityList(EmployeeDTO.class)
//                .block();
        List<EmployeeDTO> employeeDTOList =  apiClientOfFeignClient.getAllExistingEmployee();
//        List<EmployeeDTO> filterdEmplist =   employeeDTOList.stream().filter(employeeDTO -> employeeDTO.getDeportmentCode().equalsIgnoreCase(repoResultBydeptName.getDeportmentCode()))
//                .collect(Collectors.toList());
        List<EmployeeDTO> fetchBody = employeeDTOList.stream().filter(code->code.getDeportmentCode().equalsIgnoreCase(deportmentCode)).collect(Collectors.toList());

        APIresponseDTO apIresponseDTO = new APIresponseDTO();
             apIresponseDTO.setDeportmentDTO(deportmentDTO);
             apIresponseDTO.setEmployeeDTOList(fetchBody);
        return apIresponseDTO;
    }


}
