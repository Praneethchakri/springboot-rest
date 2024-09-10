package com.di.Inversionofcontrol.injectionTypes_spring.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.di.Inversionofcontrol.injectionTypes_spring.exceptions.InvestorNotFoundException;
import com.di.Inversionofcontrol.injectionTypes_spring.model.AppResponseModel;
import com.di.Inversionofcontrol.injectionTypes_spring.model.Investor;
import com.di.Inversionofcontrol.injectionTypes_spring.service.InvestorService;

@RestController
@RequestMapping(path = "/investor")
public class InvestorController {

	private final InvestorService investorService;

	public InvestorController(InvestorService investorService) {
		this.investorService = investorService;
	}

	@PostMapping
	public ResponseEntity<AppResponseModel> addInvestor(@RequestBody Investor investor) {
		investorService.add(investor);

		AppResponseModel response = new AppResponseModel("Investor Added Successfully !!", HttpStatus.CREATED.value(),
				null);
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<?> getInvestor(@RequestParam(name = "investorId") int investorId) {
		try {
			Investor investor = investorService.fetchByInvestorId(investorId);
			return new ResponseEntity<>(investor, HttpStatus.ACCEPTED);

		} catch (InvestorNotFoundException e) {
			AppResponseModel exceptionResponse = new AppResponseModel("Investor Not Available ",
					HttpStatus.NOT_FOUND.value(), e);
			
			return new ResponseEntity<>(exceptionResponse,HttpStatus.NOT_FOUND);
		}

	}

}
