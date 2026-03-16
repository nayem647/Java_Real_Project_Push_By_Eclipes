package com.iispl.services;

import com.iispl.entity.Account;
import com.iispl.entity.CurrentAccount;

public abstract class CurrentAccountServices extends AccountService {

	@Override
	public Account createAccount() {

		System.out.println("Enter the account holder name: ");
		String accountHolderName = input.nextLine();

		System.out.println("Enter account number: ");
		String accountNumber = input.nextLine();

		System.out.println("Enter the GST Number: ");
		String gstNumber = input.nextLine();

		System.out.println("Enter the initial balance(Must Be >= 10K): ");
		double initialBalance = input.nextDouble();

		if (initialBalance < 10000) {
			System.out.println("Account Cannot Be Created! Initial Amount Must Be >= 10K!");
			return null;
		}

		System.out.println("Set the account security PIN: ");
		int pin = input.nextInt();
		input.nextLine();

		System.out.println(accountHolderName+" Your Current Account is Created Successfully!!");

		return new CurrentAccount(accountNumber, accountHolderName, initialBalance, gstNumber, 10000, pin);
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
		
		CurrentAccount currentAccount = (CurrentAccount)account;

		System.out.println("===== "+currentAccount.getAccountHolderName()+" Here Is Your Account Details =====");
		System.out.println("Account Type: Current");
		System.out.println("Account Holder Name: " + currentAccount.getAccountHolderName());
		System.out.println("Account Number: " + currentAccount.getAccountNumber());
		System.out.println("Current Balance: " + currentAccount.getCurrentBalance());
		System.out.println("GST Number: "+currentAccount.getGST());
		System.out.println("====================================");
	}

	@Override
	public void withdrawAmount(Account account) {

		System.out.println("Re-Enter Your Account Number: ");
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

		if (account.getCurrentBalance() - withAmount < 10000) {
			System.out.println("Cannot Withdraw! Minimum Balance Must Be 10000!");
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