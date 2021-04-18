package com.innovation.validator.core.service.impl;

import com.innovation.validator.core.model.mongo.Company;
import com.innovation.validator.core.repository.CompanyRepository;
import com.innovation.validator.core.service.CNPJService;
import com.innovation.validator.core.util.SourceMessage;
import com.innovation.validator.core.util.converter.StringToCNPJConverter;
import com.innovation.validator.core.util.helper.MessageHelper;
import com.innovation.validator.core.util.validator.CNPJValidator;
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
public class CNPJServiceImpl implements CNPJService {

    private final SourceMessage sourceMessage;
    private final CNPJValidator cnpjValidator;
    private final CompanyRepository companyRepository;
    private final StringToCNPJConverter cnpjConverter;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public String validarCNPJ(String numeroCNPJ) {
        if (ObjectUtils.isEmpty(numeroCNPJ)) {
            String mensagemErroI18n = sourceMessage.getMessage(MessageHelper.CNPJ_VAZIO, numeroCNPJ);
            logger.error(sourceMessage.getMessage(MessageHelper.CNPJ_VALIDAR_ERRO, mensagemErroI18n));
            throw new ValidatorDocumentException(sourceMessage.getMessage(MessageHelper.CNPJ_VALIDAR_ERRO, mensagemErroI18n));
        }
        if (cnpjValidator.validarCNPJ(numeroCNPJ)) {
            logger.debug(sourceMessage.getMessage(MessageHelper.CNPJ_VALIDO, numeroCNPJ));
            return sourceMessage.getMessage(MessageHelper.CNPJ_VALIDO, numeroCNPJ);
        } else {
            logger.debug(sourceMessage.getMessage(MessageHelper.CNPJ_INVALIDO, numeroCNPJ));
            return sourceMessage.getMessage(MessageHelper.CNPJ_INVALIDO, numeroCNPJ);
        }
    }

    @Override
    public Company cadastrarCNPJ(String numeroCNPJ) {
        numeroCNPJ = numeroCNPJ.replaceAll("[^0-9]", "");
        if (!cnpjValidator.validarCNPJ(numeroCNPJ)) {
            String mensagemErroI18n = sourceMessage.getMessage(MessageHelper.CNPJ_INVALIDO, numeroCNPJ);
            logger.error(sourceMessage.getMessage(MessageHelper.CNPJ_CADASTRAR_ERRO, mensagemErroI18n));
            throw new ValidatorDocumentException(sourceMessage.getMessage(MessageHelper.CNPJ_CADASTRAR_ERRO, mensagemErroI18n));
        }
        if (!verificaSeCNPJPossuiCadastro(numeroCNPJ)) {
            String mensagemErroI18n = sourceMessage.getMessage(MessageHelper.CNPJ_DUPLICADO, numeroCNPJ);
            logger.error(sourceMessage.getMessage(MessageHelper.CNPJ_CADASTRAR_ERRO, mensagemErroI18n));
            throw new ValidatorDocumentException(sourceMessage.getMessage(MessageHelper.CNPJ_CADASTRAR_ERRO, mensagemErroI18n));
        } else {
            return companyRepository.insert(cnpjConverter.convert(numeroCNPJ));
        }
    }

    @Override
    public List<Company> listarCNPJs() {
        return companyRepository.findAll();
    }

    public Boolean verificaSeCNPJPossuiCadastro(String numeroCNPJ) {
        Company cnpjCadastrado = companyRepository.findCNPJByNumber(numeroCNPJ);
        return ObjectUtils.isEmpty(cnpjCadastrado);
    }

}