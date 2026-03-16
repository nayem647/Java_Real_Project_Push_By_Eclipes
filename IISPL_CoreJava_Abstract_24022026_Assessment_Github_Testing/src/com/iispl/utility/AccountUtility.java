package com.iispl.utility;

import java.util.*;
import com.iispl.entity.*;
import com.iispl.services.*;

public class AccountUtility {

	static List<Account> accountList = new ArrayList<>();

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		char continueChoice;

		do {

			System.out.println("==== WELCOME TO IISPL INTERNATIONAL BANK ====");

			System.out.println("1.Create Account");
			System.out.println("2.Display Account Details");
			System.out.println("3.Withdraw Amount");
			System.out.println("4.Deposit Amount");
			System.out.println("5.Check Current Available Balance");
			System.out.println("6.View Transaction Details");
			System.out.println("7.Exit");

			System.out.println("Enter What You Want to Do: ");
			int choice = input.nextInt();
			input.nextLine();

			switch (choice) {

			case 1:
				AccountService accountService = AccountService.ChooseAccountType();
				if (accountService != null) {
					Account newAccount = accountService.createAccount();
					if (newAccount != null) {
						accountList.add(newAccount);
					}
				}
				break;
				
			case 2:
				System.out.println("Enter Account Number: ");
				String accountNumberDisplay = input.nextLine();
				
				for(Account account: accountList) {
					if(account.getAccountNumber().equals(accountNumberDisplay)) {
						AccountService service;
						
						if(account instanceof SavingsAccount) {
							service = new SavingsAccountServices() {
							};
						}else {
							service = new CurrentAccountServices() {
							};
						}
						service.displayAccountDetails(account);
					}
				}
				break;

			case 3:
				System.out.println("Enter Account Number: ");
				String accNo = input.nextLine();

				for (Account acc : accountList) {
					if (acc.getAccountNumber().equals(accNo)) {

						AccountService service;

						if (acc instanceof SavingsAccount) {
							service = new SavingsAccountServices() {};
						} else {
							service = new CurrentAccountServices() {};
						}

						service.withdrawAmount(acc);
					}
				}
				break;

			case 4:
				System.out.println("Enter Account Number: ");
				String accNo2 = input.nextLine();

				System.out.println("Enter Amount To Deposit: ");
				double depAmount = input.nextDouble();
				input.nextLine();

				for (Account acc : accountList) {
					if (acc.getAccountNumber().equals(accNo2)) {

						AccountService service;

						if (acc instanceof SavingsAccount) {
							service = new SavingsAccountServices() {};
						} else {
							service = new CurrentAccountServices() {};
						}

						service.depositAmount(acc, depAmount);
					}
				}
				break;

			case 7:
				System.out.println("Thank You For Visiting IISPL Bank!");
				System.exit(0);

			default:
				System.out.println("Invalid Choice!!");
			}

			System.out.println("Do You Want to Continue(y/n)?");
			continueChoice = input.next().charAt(0);
			input.nextLine();

		} while (continueChoice == 'y' || continueChoice == 'Y');

		System.out.println("Thank You For Visiting IISPL Bank!");
	}
}