package com.ra.dtobean;



public class RechargeBean {

	private String customerName;
	private String mobileNo;
	private String rechargePlan;
	private int rechargeAmount;


	
	
	public String getCustomerName() {
		return customerName;
	}



	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}



	public String getMobileNo() {
		return mobileNo;
	}



	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}



	public String getRechargePlan() {
		return rechargePlan;
	}



	public void setRechargePlan(String rechargePlan) {
		this.rechargePlan = rechargePlan;
	}



	public int getRechargeAmount() {
		return rechargeAmount;
	}



	public void setRechargeAmount(int rechargeAmount) {
		this.rechargeAmount = rechargeAmount;
	}








	public RechargeBean(String customerName, String mobileNo, String rechargePlan, int rechargeAmount) {
		super();
		this.customerName = customerName;
		this.mobileNo = mobileNo;
		this.rechargePlan = rechargePlan;
		this.rechargeAmount = rechargeAmount;	
		

	}



	@Override
	public String toString() {
		return "RechargeBean [customerName=" + customerName + ", mobileNo=" + mobileNo + ", rechargePlan="
				+ rechargePlan + ", rechargeAmount=" + rechargeAmount + "]";
	}
	
	
	



	
	


	
	
	
	
	
}
