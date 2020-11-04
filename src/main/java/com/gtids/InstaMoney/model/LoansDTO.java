package com.gtids.InstaMoney.model;

//import com.fasterxml.jackson.annotation.JsonInclude;

public interface LoansDTO {


	String getNearestAPGVBBank();


	int getCountOfAPGVBBank();
	
	//@JsonInclude(Include.NON_NULL)
	String getFirstName();

}
