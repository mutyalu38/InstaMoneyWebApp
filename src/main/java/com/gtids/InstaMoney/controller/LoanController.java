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
		//System.out.println("current  >>>>" + loansRepository.findCurrentDateLoanApp());
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
	
//	@RequestMapping(value = "loanDataByTopSevenNearestAPGVBBank", method = RequestMethod.GET)
//	public List<Loans> getTopSevenNearestAPGVBBank() {
//		System.out.println("sevendays" + loansRepository.findTopSevenNearestAPGVBBank());
//		return loansRepository.findTopSevenNearestAPGVBBank();
//
//	}
//	@RequestMapping(value = "loanDataByAllNearestAPGVBBank", method = RequestMethod.GET)
//	public List<Loans> getAllNearestAPGVBBank() {
//		System.out.println("sevendays" + loansRepository.findAllNearestAPGVBBank());
//		return loansRepository.findAllNearestAPGVBBank();
//
//	}
//	
//	@RequestMapping(value = "loanDataByTopSevenCustomerOccupation", method = RequestMethod.GET)
//	public List<Loans> getTopSevenCustomerOccupation() {
//		System.out.println("sevendays" + loansRepository.findTopSevenCustomerOccupation());
//		return loansRepository.findTopSevenCustomerOccupation();
//
//	}
//	@RequestMapping(value = "loanDataByAllCustomerOccupation", method = RequestMethod.GET)
//	public List<Loans> getAllCustomerOccupation() {
//		System.out.println("sevendays" + loansRepository.findAllCustomerOccupation());
//		return loansRepository.findAllCustomerOccupation();
//
//	}

}
