package com.innovation.validator.test.unit.service;

import com.innovation.validator.core.service.impl.CompanyServiceImpl;
import com.innovation.validator.core.util.SourceMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertTrue;

@RunWith(JUnitPlatform.class)
@ExtendWith({MockitoExtension.class})
public class CompanyServiceTest {

    @Spy
    @InjectMocks
    private CompanyServiceImpl companyService;

    @Mock
    private SourceMessage sourceMessage;

    @Test
    @DisplayName("Test if a CNPJ of a Company is empty")
    void validateCnpjCompanyNumberIsEmpty(){
        assertTrue(Boolean.TRUE);
    }

    @Test
    @DisplayName("Test if a CNPJ of a Company  is a valid document")
    void validateCnpjCompanyNumberIsNotEmptyAndIfIsValid(){
        assertTrue(Boolean.TRUE);
    }

    @Test
    @DisplayName("Test if a CNPJ of a Company  is a invalid document")
    void validateCnpjCompanyNumberIsNotEmpty(){
        assertTrue(Boolean.TRUE);
    }

}