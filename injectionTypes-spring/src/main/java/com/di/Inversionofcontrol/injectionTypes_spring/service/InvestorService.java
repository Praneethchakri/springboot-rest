package com.di.Inversionofcontrol.injectionTypes_spring.service;

import org.springframework.stereotype.Service;

import com.di.Inversionofcontrol.injectionTypes_spring.model.AppResponseModel;
import com.di.Inversionofcontrol.injectionTypes_spring.model.Investor;

@Service
public interface InvestorService {
	public void add(Investor investor);
	public Investor fetchByInvestorId(int investorId);
}
