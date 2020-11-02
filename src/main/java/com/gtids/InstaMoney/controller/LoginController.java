package com.gtids.InstaMoney.controller;


import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gtids.InstaMoney.exception.CustomException;
import com.gtids.InstaMoney.exception.ErrorDetails;
import com.gtids.InstaMoney.exception.UserNotFoundException;
import com.gtids.InstaMoney.model.TblBankAdmin;
import com.gtids.InstaMoney.repository.TblBankAdminRepository;



@RequestMapping("/rest")
@RestController
public class LoginController {


	@Autowired
	private TblBankAdminRepository tblBankAdminRepository;

	private List<TblBankAdmin> tblBankAdminList = new ArrayList<TblBankAdmin>();

	@RequestMapping(value = "testJson",method = RequestMethod.GET)
	public TblBankAdmin testJson() {
		TblBankAdmin tabBankAdmin = new TblBankAdmin();
		tabBankAdmin.setBranch("VZM");
		tabBankAdmin.setUserName("Jag");
		return tabBankAdmin;

	}

	@RequestMapping(value = "isValidUser",method = RequestMethod.GET)
	public TblBankAdmin isValidUser(@Valid @RequestBody TblBankAdmin tableBankAdmin) throws UserNotFoundException,CustomException{
		System.out.println("Calling IsValidUser"+tableBankAdmin);
		String userName = tableBankAdmin.getUserName();
		String password = tableBankAdmin.getPassword();

		TblBankAdmin dataResult = tblBankAdminRepository.findUserByName(userName);
		if(dataResult!=null) {
			boolean result  = BCrypt.checkpw(password, dataResult.getPassword());
			if(!result) {
				throw new CustomException("You Entered Wrong Password..!");
			}
			//OTP 
			return dataResult;
		}else {
			throw new UserNotFoundException("User not Registered with us ..!");
		}
		//		dataResult=tblBankAdminRepository.findUserByNameAndPwd(userName, password);
		//tblBankAdminList =  tblBankAdminRepository.findAll();

		//System.out.println("Result >>>>"+dataResult+"\t list>>"+tblBankAdminList);
		//return dataResult;
	}
	@RequestMapping(value = "allTblBankAdmins",method = RequestMethod.GET)
	//	 @GetMapping("/allTblBankAdmins")
	public List<TblBankAdmin> getTblBankAdmins() {

		return  tblBankAdminRepository.findAll();
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorDetails> handleMethodArgumentNotValidExceptionHandler(Exception ex) {
		ErrorDetails error = new ErrorDetails();
		error.setErrorCode(HttpStatus.BAD_REQUEST.value());
		error.setMessage(ex.getMessage());
		return new ResponseEntity<ErrorDetails>(error, HttpStatus.OK);
	}
}
