package com.iispl.entity;

import java.util.ArrayList;
import java.util.List;

public class Customer {

    private String customerFullName;
    private List<Account> customerAccounts = new ArrayList<>();

    public Customer(String customerFullName) {
        this.customerFullName = customerFullName;
    }

    public void addNewAccount(Account newAccount) {
        customerAccounts.add(newAccount);
        System.out.println("Account Created Successfully.");
    }

    public Account findAccountByNumber(String accountNumber) {

        for (Account account : customerAccounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }
        return null;
    }

    public List<Account> getAllCustomerAccounts() {

        List<Account> accountListCopy = new ArrayList<>();

        for (Account account : customerAccounts) {
            accountListCopy.add(account);
        }

        return accountListCopy;
    }

    public String getCustomerFullName() {
        return customerFullName;
    }
}