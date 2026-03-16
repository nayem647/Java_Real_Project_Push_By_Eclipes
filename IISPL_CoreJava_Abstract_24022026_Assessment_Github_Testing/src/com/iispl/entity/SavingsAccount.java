package com.iispl.entity;

public class SavingsAccount extends Account {

	private double roi;

	public SavingsAccount(String accountNumber, String accountHolderName, double balance, double roi, int pin) {
		super(accountNumber, accountHolderName, balance, pin);
		this.roi = roi;
	}

	public double getRoi() {
		return roi;
	}

	public void setRoi(double roi) {
		this.roi = roi;
	}

}
