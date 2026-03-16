package com.iispl.services;

import java.util.Scanner;

import com.iispl.entity.*;

public abstract class AccountService {
	
	static Scanner input = new Scanner(System.in);

	public static AccountService ChooseAccountType() {
		
		System.out.println("Select Which Type of Account You Want to Create:(1. Savings / 2. Current)");
		int chooseAccountType = input.nextInt();
		
		input.nextLine();
		
		if (chooseAccountType == 1) {
			return new SavingsAccountServices() {
			};
		}else if(chooseAccountType == 2) {
			return new CurrentAccountServices() {
			};
		}else {
			System.out.println("Invalid Choice!! Select Correct Option!");
			return null;
		}
	}

	public abstract Account createAccount(); // these all are the abstract class with no function body: this is call
												// prototype

	public abstract void displayAccountDetails(Account account);

	public abstract void withdrawAmount(Account account);

	public abstract void depositAmount(Account account, double depAmount);

	public abstract void viewTransactionDetails();

}
