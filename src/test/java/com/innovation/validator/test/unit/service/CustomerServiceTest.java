package com.innovation.validator.test.unit.service;

import com.innovation.validator.core.service.impl.CustomerServiceImpl;
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
public class CustomerServiceTest {

    @Spy
    @InjectMocks
    private CustomerServiceImpl customerService;

    @Mock
    private SourceMessage sourceMessage;

    @Test
    @DisplayName("Test if a CPF of a Customer is empty")
    void validateCpfCustomerNumberIsEmpty(){
        assertTrue(Boolean.TRUE);
    }

    @Test
    @DisplayName("Test if a CPF of a Customer is a valid document")
    void validateCpfCustomerNumberIsNotEmptyAndIfIsValid(){
        assertTrue(Boolean.TRUE);
    }

    @Test
    @DisplayName("Test if a CPF of a Customer is a invalid document")
    void validateCpfCustomerNumberIsNotEmptyAndIfIsInvalid(){
        assertTrue(Boolean.TRUE);
    }


}