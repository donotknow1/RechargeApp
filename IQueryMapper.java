package com.ra.dao;

public interface IQueryMapper {

	static String INSERT_QRY="insert into rechargeinfo2 values(?,?,?,?)";
	
	static String SELECT_QRY="select * from rechargeinfo2";
	
	static String SELECT_QRY_BY_NUMBER="select * from rechargeinfo2 where MOBILE_NO=?";
}
