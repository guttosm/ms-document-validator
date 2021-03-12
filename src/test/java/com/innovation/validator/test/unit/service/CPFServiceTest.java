package com.innovation.validator.test.unit.service;

import com.innovation.validator.core.service.impl.CPFServiceImpl;
import com.innovation.validator.core.util.Mensagem;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;


@RunWith(JUnitPlatform.class)
@ExtendWith({MockitoExtension.class})
public class CPFServiceTest {

    @Spy
    @InjectMocks
    private CPFServiceImpl cpfService;

    @Mock
    private Mensagem mensagem;

}