package com.controllers;

public class CustomerPojo {
	private String custName;
	private Long mobileNum;
	
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public Long getMobileNum() {
		return mobileNum;
	}
	public void setMobileNum(Long mobileNum) {
		this.mobileNum = mobileNum;
	}
	@Override
	public String toString() {
		return "CustomerPojo [custName=" + custName + ", mobileNum=" + mobileNum + "]";
	}
}
