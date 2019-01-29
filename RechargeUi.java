package com.ra.ui;


import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.ra.dtobean.RechargeBean;
import com.ra.exception.RechargeException;
import com.ra.service.IRechargeService;
import com.ra.service.RechargeServiceImpl;

public class RechargeUi {

	static Scanner scan=null;
	static IRechargeService recServ=null;
	static String mobileNumber;
	
	public String getMobileNumber() {
		return mobileNumber;
	}
    public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}


	public static void main(String[] args) throws RechargeException {
		
		
		PropertyConfigurator.configure("resources/log4j.properties");
		Logger log=Logger.getRootLogger();
		
		System.out.println("--------------RECHARGE------------------");
		System.out.println("             1.Recharge             ");
		System.out.println("         2.Recharge History         ");
		System.out.println("      3.Recharge History by Number      ");
		System.out.println("              4.Exit                  ");
		System.out.println("----------------------------------------");
		
		RechargeServiceImpl val=new RechargeServiceImpl();
		scan=new Scanner(System.in);
		System.out.println("Choose required service : ");
		int option=scan.nextInt();
		
		switch(option) {
		
		case 1:
			log.info("Selected option "+option);	
			String name;
			do {
			System.out.println("Enter Your Name : ");	
			name=scan.next();
			}while(val.validateName(name)==false);
	
			
			String mobile;			
			do{	
			System.out.println("Enter Mobile number : ");
			mobile=scan.next();
	     	}while(val.validateMobile(mobile)==false);
			
			
			System.out.println("Choose your Plan : ");
			System.out.println("    ");
			System.out.println("1)rc100   2)rc150  3)rc200  4)rc250  5)rc300");
			String plan=scan.next();
			
			System.out.println("Enter recharge Amount : ");
			int amount=scan.nextInt();
		
			
			RechargeBean rec=new RechargeBean(name,mobile,plan,amount);
			int fin=0;
			try {
		    fin=recharge(rec);
			}
			catch(RechargeException e) {
				System.out.println(e.getMessage()+"ui");
			}
			if(fin>0) {
				System.out.println(fin+" data is inserted");
				log.info("Data is inserted");
			}
			else
			{
				System.out.println("data is not inserted");
			}
		    break;
		    
		case 2 :
			
			log.info("Selected option "+option);
			List<RechargeBean> finList=null;
			
			try {
			finList=rechargeHistory();
			}
			catch(RechargeException e) {
				System.out.println(e.getMessage()+"retrieve");
			}
			
			for(RechargeBean rech:finList) {
				
				System.out.println(rech);
			}
			break;
			
		case 3 :
			
			log.info("Selected Option "+option);
			List<RechargeBean> listByNo=null;
			
			System.out.println("Enter Mobile Number ");
		    mobileNumber=scan.next();
		    try 
			{
			listByNo=rechargeHistoryByNo(mobileNumber);
			}			
			catch(RechargeException|NullPointerException e) {
				System.out.println(e.getMessage()+"retrieve");
			}
			
			for(RechargeBean rech1:listByNo)
			{
				System.out.println(rech1);
			}
			
			break;
			
		case 4 :
			log.info("Selected option "+option);
			System.out.println("EXIT");
			
			System.exit(0);
			
			
			break;
			
			default: 
				System.out.println("Please enter valid option");
		}
				    
		    
		}
		

				
		
	
	
	public static int recharge(RechargeBean rec) throws RechargeException {
		
		recServ=new RechargeServiceImpl();
		int result=recServ.rechargeServ(rec);
		return result;
		
	}
	 
	public static List<RechargeBean> rechargeHistory() throws RechargeException {
		
		recServ=new RechargeServiceImpl();
		
		return recServ.rechargeServiceImpl();
		
		
	}	
	
	
	public static List<RechargeBean> rechargeHistoryByNo(String mobileNumber) throws RechargeException{
		
		recServ=new RechargeServiceImpl();
		
		return recServ.rechargeServicebyNo(mobileNumber);
	}	
	
	
		
		
	
	
	
}
