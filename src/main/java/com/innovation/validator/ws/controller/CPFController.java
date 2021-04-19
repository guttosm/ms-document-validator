package com.innovation.validator.ws.controller;

import com.innovation.validator.core.model.mongo.Customer;
import com.innovation.validator.core.service.CustomerService;
import com.innovation.validator.ws.contract.CPFContract;
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
@Api(value = "Cadastro e valida\u00E7\u00F5es de CPF", tags = "CPF")
public class CPFController implements CPFContract {

    private final CustomerService customerService;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public ResponseEntity<String> validadarCPF(String numeroCPF) {
        logger.debug("-----------> INICIO DA VALIDAÇÃO DO CPF", numeroCPF);
        return ResponseEntity.status(HttpStatus.OK).body(customerService.validateCpfCustomerNumber(numeroCPF));
    }

    @Override
    public ResponseEntity<Customer> cadastrarCPF(String numeroCPF) {
        return ResponseEntity.status(HttpStatus.CREATED).body(customerService.createCustomer(numeroCPF));
    }

    @Override
    public ResponseEntity<List<Customer>> listarCPF() {
        return ResponseEntity.status(HttpStatus.OK).body(customerService.getAllCustomer());
    }

}