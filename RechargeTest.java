package com.ra.test;

import java.sql.Connection;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ra.exception.RechargeException;
import com.ra.service.RechargeServiceImpl;
import com.ra.util.DbUtil;

import junit.framework.Assert;


public class RechargeTest {

	static Connection conn;
	@BeforeClass
	public static void initialise() {
	conn=null;
	
	}
	@Before
	public void beforeEachTest() {
		System.out.println("----Starting DBConnection Test Case----\n");
	}
	@Test
	public void testConnection1() {
		Connection conn=DbUtil.getDbConnection();
		Assert.assertNotNull(conn);

}
	
	@Test
	public void testConnection2() {
		
		Connection conn=DbUtil.getDbConnection();
		Assert.assertEquals("the connection is not established", conn, conn);
		
	}
	
	@After
	public void afterEachTest() {
		System.out.println("----Ending DBConnection Test Case----\n");
	}
	@AfterClass
	public static void destroy() {
		
		conn=null;
		System.out.println("End of all test cases");
	}


	
	public void testRecharge() throws RechargeException 
	{
		
		RechargeServiceImpl testServ=new RechargeServiceImpl();
		
		Assert.assertNotNull(testServ.rechargeServiceImpl());
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
