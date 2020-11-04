package com.gtids.InstaMoney.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gtids.InstaMoney.model.Loans;
import com.gtids.InstaMoney.model.LoansCustomerOccupationDTO;
import com.gtids.InstaMoney.model.LoansDTO;
import com.gtids.InstaMoney.repository.LoansDTORepository;
import com.gtids.InstaMoney.repository.LoansRepository;

@RequestMapping("/rest")
@RestController
public class LoanController {
	
	private static final Logger logger = LogManager.getLogger(LoanController.class);
	
	@Autowired
	private LoansRepository loansRepository;
	
	@Autowired
	private LoansDTORepository loansDTORepository;
	
	

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
	public int getLoanDataByLastSevanDaysCount() {
		int count = loansRepository.findSevenDaysLoanAppCount();
		 logger.debug("getLoanDataByLastSevanDaysCount from Log4j 2 - num : {}",count);
		 System.out.println(logger.isDebugEnabled());
		return count;
	}
	
	@RequestMapping(value = "loanDataByTopSevenAPGVBBank", method = RequestMethod.GET)
	public List<LoansDTO> getTopSevenNearestAPGVBBank() {
//		System.out.println("sevendays" + loansRepository.findTopSevenNearestAPGVBBank());
		return loansDTORepository.findTopSevenNearestAPGVBBank();

	}
	
	@RequestMapping(value = "loanDataByAllNearestAPGVBBank", method = RequestMethod.GET)
	public List<LoansDTO> getAllNearestAPGVBBank() {

		return loansDTORepository.findAllNearestAPGVBBank();

	}
	@RequestMapping(value = "loanDataByTopSevenCustomerOccupation", method = RequestMethod.GET)
	public List<LoansCustomerOccupationDTO> getTopSevenCustomerOccupation() {
//		System.out.println("sevendays" + loansRepository.findTopSevenNearestAPGVBBank());
		return loansDTORepository.findTopSevenCustomerOccupation();

	}
	
	@RequestMapping(value = "loanDataByAllCustomerOccupation", method = RequestMethod.GET)
	public List<LoansCustomerOccupationDTO> getAllCustomerOccupation() {

		return loansDTORepository.findAllCustomerOccupation();

	}
	
//	@RequestMapping(value = "fetch/{one_date}/{two_date}", method = RequestMethod.GET)
//	@GetMapping("/fetch/{one_date}/{two_date}")
//public List<Loans> getData_between(@PathVariable(value = "one_date") @DateTimeFormat(pattern = "yyyyMMdd") LocalDateTime fromDate, @PathVariable(value = "two_date") @DateTimeFormat(pattern = "yyyyMMdd") LocalDateTime toDate) {
//    return loansRepository.getData_between(fromDate, toDate);
//}


}
