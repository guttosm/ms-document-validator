package com.innovation.validator.core.service;

import com.innovation.validator.core.model.mongo.Company;

import java.util.List;

public interface CompanyService {

    String validateCnpjCompanyNumber(String numeroCNPJ);

    Company createCompany(String numeroCNPJ);

    List<Company> getAllCompany();

}