package com.ra.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ra.dtobean.RechargeBean;
import com.ra.exception.RechargeException;
import com.ra.ui.RechargeUi;
import com.ra.util.DbUtil;




public class RechargeDaoImpl implements IRechargeDao{
	 
	Connection conn=null;
	int status=0;
	@Override
	public int rechargeDao(RechargeBean rec) throws RechargeException {
		
	
		Connection conn=DbUtil.getDbConnection();
		try {
		PreparedStatement insert=conn.prepareStatement(IQueryMapper.INSERT_QRY);
		insert.setString(1,rec.getCustomerName());
		insert.setString(2,rec.getMobileNo());
		insert.setInt(3,rec.getRechargeAmount());
		insert.setString(4, rec.getRechargePlan());
		
		status=insert.executeUpdate();		
		
		
		}
		catch(SQLException e){
			
			throw new RechargeException("data not stored : "+e.getMessage());
		}
			
		
		return status;
		
		
		
	}
	
	
	@Override
	public List<RechargeBean> rechargeHistoryDao() throws RechargeException {
		
		Connection conn=DbUtil.getDbConnection();
		
		List<RechargeBean> recList=null;
		     
		try {
			Statement st=conn.createStatement();
			ResultSet rs=st.executeQuery(IQueryMapper.SELECT_QRY);
			recList=new ArrayList<RechargeBean>();
			RechargeBean rec=null;
			while(rs.next())
			{
				rec=new RechargeBean(rs.getString(1), rs.getString(2), rs.getString(4), rs.getInt(3));
				recList.add(rec);
		    } 
		}
		
		catch (SQLException e) 
		{
		
			throw new RechargeException("Data can't be retrieved "+e.getMessage());
		}
		
		
		return recList;
	
		
		
		
	}


	@Override
	public List<RechargeBean> rechargeHistoryDaoNo(String mobileNumber) throws RechargeException {
	
		Connection conn=DbUtil.getDbConnection();
		List<RechargeBean> recListByNo=null;
		try {
		PreparedStatement pstno=conn.prepareStatement(IQueryMapper.SELECT_QRY_BY_NUMBER);
		RechargeUi recui=new RechargeUi();
		String number=recui.getMobileNumber();
		pstno.setString(1, number);
		ResultSet rs=pstno.executeQuery();
		
		recListByNo=new ArrayList();
		RechargeBean rec=null;
		while(rs.next())
		{
			rec=new RechargeBean(rs.getString(1), rs.getString(2), rs.getString(4), rs.getInt(3));
			recListByNo.add(rec);
	    } 
	}	
	catch (SQLException e) 
	{
	
		throw new RechargeException("Data can't be retrieved "+e.getMessage());
	
	}
		
		return recListByNo;
	}


	
	
	
	
}
