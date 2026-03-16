package com.iispl.services;

import com.iispl.entity.Customer;

public class CustomerService {

    public static Customer createNewCustomer(String customerFullName) {
        return new Customer(customerFullName);
    }
}