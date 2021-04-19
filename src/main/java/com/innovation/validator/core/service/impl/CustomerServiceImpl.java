package com.innovation.validator.core.service.impl;

import com.innovation.validator.core.model.mongo.Customer;
import com.innovation.validator.core.repository.CustomerRepository;
import com.innovation.validator.core.service.CustomerService;
import com.innovation.validator.core.service.KafkaService;
import com.innovation.validator.core.util.SourceMessage;
import com.innovation.validator.core.util.converter.StringToCPFConverter;
import com.innovation.validator.core.util.helper.MessageHelper;
import com.innovation.validator.core.util.validator.CPFValidator;
import com.innovation.validator.ws.configuration.MessageDTO;
import com.innovation.validator.ws.exception.ValidatorDocumentException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final KafkaService kafkaService;
    private final CPFValidator cpfValidator;
    private final SourceMessage sourceMessage;
    private final CustomerRepository customerRepository;
    private final StringToCPFConverter cpfConverter;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public String validateCpfCustomerNumber(String numeroCPF) {
        kafkaService.sendMessage("test", "teste", MessageDTO.builder().body(numeroCPF).build());
        if (ObjectUtils.isEmpty(numeroCPF)) {
            String mensagemErroI18n = sourceMessage.getMessage(MessageHelper.CPF_VAZIO, numeroCPF);
            logger.error(sourceMessage.getMessage(MessageHelper.CPF_VALIDAR_ERRO, mensagemErroI18n));
            throw new ValidatorDocumentException(sourceMessage.getMessage(MessageHelper.CPF_VALIDAR_ERRO, mensagemErroI18n));
        }
        if (cpfValidator.documentValidation(numeroCPF)) {
            logger.debug(sourceMessage.getMessage(MessageHelper.CPF_VALIDO, numeroCPF));
            return sourceMessage.getMessage(MessageHelper.CPF_VALIDO, numeroCPF);
        }
        logger.debug(sourceMessage.getMessage(MessageHelper.CPF_INVALIDO, numeroCPF));
        return sourceMessage.getMessage(MessageHelper.CPF_INVALIDO, numeroCPF);

    }

    @Override
    public Customer createCustomer(String numeroCPF) {
        numeroCPF = numeroCPF.replaceAll("[^0-9]", "");
        if (!cpfValidator.documentValidation(numeroCPF)) {
            String mensagemErroI18n = sourceMessage.getMessage(MessageHelper.CPF_INVALIDO, numeroCPF);
            logger.error(sourceMessage.getMessage(MessageHelper.CPF_CADASTRAR_ERRO, mensagemErroI18n));
            throw new ValidatorDocumentException(sourceMessage.getMessage(MessageHelper.CPF_CADASTRAR_ERRO, mensagemErroI18n));
        }
        if (!verificaSeCPFPossuiCadastro(numeroCPF)) {
            String mensagemErroI18n = sourceMessage.getMessage(MessageHelper.CPF_DUPLICADO, numeroCPF);
            logger.error(sourceMessage.getMessage(MessageHelper.CPF_CADASTRAR_ERRO, mensagemErroI18n));
            throw new ValidatorDocumentException(sourceMessage.getMessage(MessageHelper.CPF_CADASTRAR_ERRO, mensagemErroI18n));
        }
        return customerRepository.insert(cpfConverter.convert(numeroCPF));
    }

    @Override
    public List<Customer> getAllCustomer() {
        return customerRepository.findAll();
    }

    public Boolean verificaSeCPFPossuiCadastro(String numeroCPF) {
        Customer cpfCadastrado = customerRepository.findCPFByNumber(numeroCPF);
        return ObjectUtils.isEmpty(cpfCadastrado);
    }

}