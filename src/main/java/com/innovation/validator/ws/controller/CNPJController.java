package com.innovation.validator.ws.controller;

import com.innovation.validator.core.model.mongo.Company;
import com.innovation.validator.core.service.CompanyService;
import com.innovation.validator.ws.contract.CNPJContract;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@Api(value = "Cadastro e valida\u00E7\u00F5es de CNPJ", tags = "CNPJ")
public class CNPJController implements CNPJContract {

    private final CompanyService companyService;

    @Override
    public ResponseEntity<String> validadarCNPJ(String numeroCNPJ) {
        return ResponseEntity.status(HttpStatus.OK).body(companyService.validateCnpjCompanyNumber(numeroCNPJ));
    }

    @Override
    public ResponseEntity<Company> cadastrarCNPJ(String numeroCNPJ) {
        return ResponseEntity.status(HttpStatus.CREATED).body(companyService.createCompany(numeroCNPJ));
    }

    @Override
    public ResponseEntity<List<Company>> listarCNPJ() {
        return ResponseEntity.status(HttpStatus.OK).body(companyService.getAllCompany());
    }
}