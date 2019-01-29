package com.ra.service;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.ra.dao.IRechargeDao;
import com.ra.dao.RechargeDaoImpl;
import com.ra.dtobean.RechargeBean;
import com.ra.exception.RechargeException;

public class RechargeServiceImpl implements IRechargeService{
	
	static IRechargeDao recDao=null;
	
	
	
	
	
	@Override
	public int rechargeServ(RechargeBean rec) throws RechargeException {
		
		recDao=new RechargeDaoImpl();
		int result1=recDao.rechargeDao(rec);	
		return result1;
	}


	@Override
	public List<RechargeBean> rechargeServiceImpl() throws RechargeException {
	
		recDao=new RechargeDaoImpl();
		return recDao.rechargeHistoryDao();
	}




	@Override
	public boolean validateName(String name) {
		Pattern pattern=Pattern.compile("[A-Z][a-zA-Z]{7}");
		Matcher m=pattern.matcher(name);
		if(m.matches())	{
			return true;
		}
		else 
		{
			return false;		 
		}
		
	}
	
	
	



	@Override
	public List<RechargeBean> rechargeServicebyNo(String mobileNumber) throws RechargeException {
		
		recDao=new RechargeDaoImpl();
		
		return recDao.rechargeHistoryDaoNo(mobileNumber);
	}


	@Override
	public boolean validateMobile(String number) {
		
		Pattern pattern2=Pattern.compile("[6-9][0-9]{9}");
		Matcher m1=pattern2.matcher(number);
		if(m1.matches()) {
			return true;
		}
		else {
			return false;
		}
		
		
		
		
	}





	














	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
