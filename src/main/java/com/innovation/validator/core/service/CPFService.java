package com.innovation.validator.core.service;

import com.innovation.validator.core.model.mongo.Customer;

import java.util.List;

public interface CPFService {

    String validarCPF(String numeroCPF);

    Customer cadastrarCPF(String numeroCPF);

    List<Customer> listarCPFs();

}