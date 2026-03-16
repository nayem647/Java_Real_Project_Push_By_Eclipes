package com.iispl.services;

import com.iispl.entity.Account;
import com.iispl.entity.SavingsAccount;

public abstract class SavingsAccountServices extends AccountService {

	@Override
	public Account createAccount() {

		System.out.println("Enter the account holder name: ");
		String accountHolderName = input.nextLine();

		System.out.println("Enter account number: ");
		String accountNumber = input.nextLine();

		System.out.println("Enter the initial balance: ");
		double initialBalance = input.nextDouble();

		System.out.println("Enter the ROI(%): ");
		double roi = input.nextDouble();

		System.out.println("Enter the account security PIN: ");
		int pin = input.nextInt();
		input.nextLine();

		System.out.println(accountHolderName + " Your Savings Account is Created Successfully!!");

		return new SavingsAccount(accountNumber, accountHolderName, initialBalance, roi, pin);
	}

	@Override
	public void displayAccountDetails(Account account) {

		System.out.println("Re-Enter Account Number: ");
		String reAccountNumber = input.nextLine();

		if (!reAccountNumber.equals(account.getAccountNumber())) {
			System.out.println("Account Number Mismatched!");
			return;
		}

		System.out.println("Re-Enter Security PIN: ");
		int rePin = input.nextInt();
		input.nextLine();

		if (rePin != account.getPin()) {
			System.out.println("Security PIN Mismatched!");
			return;
		}
		
		SavingsAccount savingAccount = (SavingsAccount)account;

		System.out.println("===== "+savingAccount.getAccountHolderName()+" Here Is Your Account Details =====");
		System.out.println("Account Type: Savings");
		System.out.println("Account Holder Name: " + savingAccount.getAccountHolderName());
		System.out.println("Account Number: " + savingAccount.getAccountNumber());
		System.out.println("Current Balance: " + savingAccount.getCurrentBalance());
		System.out.println("ROI(%): "+savingAccount.getRoi());
		System.out.println("ROI(%): "+savingAccount.getRoi());
		System.out.println("====================================");
	}

	@Override
	public void withdrawAmount(Account account) {

		System.out.println("Re-Enter Account Number: ");
		String reAccountNumber = input.nextLine();

		if (!reAccountNumber.equals(account.getAccountNumber())) {
			System.out.println("Account Number Mismatched!");
			return;
		}

		System.out.println("Re-Enter Security PIN: ");
		int rePin = input.nextInt();

		if (rePin != account.getPin()) {
			System.out.println("Security PIN Mismatched!");
			return;
		}

		System.out.println("Enter Amount You Want To Withdraw: ");
		double withAmount = input.nextDouble();
		input.nextLine();

		if (withAmount > account.getCurrentBalance()) {
			System.out.println("Insufficient Balance!");
			return;
		}

		account.setCurrentBalance(account.getCurrentBalance() - withAmount);
		System.out.println("Withdraw Successful!");
		System.out.println("Updated Balance: " + account.getCurrentBalance());
	}

	@Override
	public void depositAmount(Account account, double depAmount) {

		account.setCurrentBalance(account.getCurrentBalance() + depAmount);
		System.out.println("Amount Deposited Successfully.");
		System.out.println("Updated Balance: " + account.getCurrentBalance());
	}

	@Override
	public void viewTransactionDetails() {
		System.out.println("Transaction Details Feature Coming Soon...");
	}
}