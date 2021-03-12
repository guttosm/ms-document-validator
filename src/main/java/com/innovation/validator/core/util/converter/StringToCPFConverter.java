package com.innovation.validator.core.util.converter;

import com.innovation.validator.core.model.mongo.CPF;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import java.util.Arrays;

@Component
public class StringToCPFConverter implements Converter<String, CPF> {

    @Override
    public CPF convert(String numeroCPF) {
        if (!ObjectUtils.isEmpty(numeroCPF)) {
            return CPF.builder()
                    .numero(Arrays.asList(numeroCPF))
                    .build();
        }
        return null;
    }
}
