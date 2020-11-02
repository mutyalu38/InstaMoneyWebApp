package com.gtids.InstaMoney.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gtids.InstaMoney.model.Loans;
import com.gtids.InstaMoney.repository.LoansRepository;

@RequestMapping("/rest")
@RestController
public class LoanController {
	@Autowired
	private LoansRepository loansRepository;

	@RequestMapping(value = "loanDataByCurrentDate", method = RequestMethod.GET)
	public List<Loans> loanDataByCurrentDate() {
		System.out.println("current  >>>" + loansRepository.findCurrentDateLoanApp());
		return loansRepository.findCurrentDateLoanApp();

	}

	@RequestMapping(value = "loanDataByLastSevanDays", method = RequestMethod.GET)
	public List<Loans> loanDataByLastSevanDays() {
		System.out.println("sevendays" + loansRepository.findSevenDaysLoanApp());
		return loansRepository.findSevenDaysLoanApp();

	}

	@RequestMapping(value = "totalLoanData", method = RequestMethod.GET)
	public List<Loans> getTotalLoanData() {
		return loansRepository.findAll();
	}

	@RequestMapping(value = "loanDataByCurrentDateCount", method = RequestMethod.GET)
	public Integer getLoanDataByCurrentDateCount() {
		return loansRepository.findCurrentDateLoanAppCount();
	}
	@RequestMapping(value = "loanDataByLastSevanDaysCount", method = RequestMethod.GET)
	public Integer getLoanDataByLastSevanDaysCount() {
		return loansRepository.findSevenDaysLoanAppCount();
	}

}
