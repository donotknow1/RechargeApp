package com.ra.service;

import java.util.List;

import com.ra.dtobean.RechargeBean;
import com.ra.exception.RechargeException;

public interface IRechargeService {

	

	int rechargeServ(RechargeBean rec) throws RechargeException;

	List<RechargeBean> rechargeServiceImpl() throws RechargeException;

	List<RechargeBean> rechargeServicebyNo(String mobileNumber) throws RechargeException;

	//validation
	boolean validateName(String name);
	boolean validateMobile(String number);

	


	
	
	
	
	
	
	
}
