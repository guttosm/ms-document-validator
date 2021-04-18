package com.innovation.validator.core.service;

import com.innovation.validator.core.model.mongo.Company;

import java.util.List;

public interface CNPJService {

    String validarCNPJ(String numeroCNPJ);

    Company cadastrarCNPJ(String numeroCNPJ);

    List<Company> listarCNPJs();

}