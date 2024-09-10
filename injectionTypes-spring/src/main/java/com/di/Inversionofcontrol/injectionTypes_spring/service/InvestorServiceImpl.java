package com.di.Inversionofcontrol.injectionTypes_spring.service;

import com.di.Inversionofcontrol.injectionTypes_spring.exceptions.InvestorNotFoundException;
import com.di.Inversionofcontrol.injectionTypes_spring.model.Investor;
import com.di.Inversionofcontrol.injectionTypes_spring.repo.InvestorRepository;

public class InvestorServiceImpl implements InvestorService {

	private final InvestorRepository investorRepository;

	public InvestorServiceImpl(InvestorRepository investorRepository) {
		this.investorRepository = investorRepository;
	}

	@Override
	public void add(Investor investor) {
		investorRepository.save(investor);
	}

	@Override
	public Investor fetchByInvestorId(int investorId) {
		return	investorRepository.findById(investorId).orElseThrow(()->new InvestorNotFoundException("Investor Not found !!"));
	}

}
