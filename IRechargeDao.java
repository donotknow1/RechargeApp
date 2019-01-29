package com.ra.dao;

import java.util.List;

import com.ra.dtobean.RechargeBean;
import com.ra.exception.RechargeException;

public interface IRechargeDao {

	int rechargeDao(RechargeBean rec) throws RechargeException;

	List<RechargeBean> rechargeHistoryDao() throws RechargeException;

	List<RechargeBean> rechargeHistoryDaoNo(String mobileNumber) throws RechargeException;

   
	
	
}
