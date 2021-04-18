package com.innovation.validator.core.util.converter;

import com.innovation.validator.core.model.mongo.Company;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

@Component
public class StringToCNPJConverter implements Converter<String, Company> {

    @Override
    public Company convert(String numeroCNPJ) {
        if (!ObjectUtils.isEmpty(numeroCNPJ)) {
            return Company.builder()
                    .numero(numeroCNPJ)
                    .build();
        }
        return null;
    }
}
