package com.iispl.entity;

public class CurrentAccount extends Account {
	private String gst;
	private double minBalance = 10000;

	public CurrentAccount(String accountNumber, String accountHolderName, double balance, String gst,
			double minBalance, int pin) {
		super(accountNumber, accountHolderName, balance, pin);
		this.gst = gst;
		this.minBalance = minBalance;
	}

	public String getGST() {
		return gst;
	}

	public void setGst(String gst) {
		this.gst = gst;
	}

	public double getMinBalance() {
		return minBalance;
	}

	public void setMinBalance(double minBalance) {
		this.minBalance = minBalance;
	}
}
