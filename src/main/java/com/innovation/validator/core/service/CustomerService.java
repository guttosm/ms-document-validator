package com.innovation.validator.core.service;

import com.innovation.validator.core.model.mongo.Customer;

import java.util.List;

public interface CustomerService {

    String validateCpfCustomerNumber(String numeroCPF);

    Customer createCustomer(String numeroCPF);

    List<Customer> getAllCustomer();

}