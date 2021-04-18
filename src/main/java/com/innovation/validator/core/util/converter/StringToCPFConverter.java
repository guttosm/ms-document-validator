package com.innovation.validator.core.util.converter;

import com.innovation.validator.core.model.mongo.Customer;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import java.util.Arrays;

@Component
public class StringToCPFConverter implements Converter<String, Customer> {

    @Override
    public Customer convert(String numeroCPF) {
        if (!ObjectUtils.isEmpty(numeroCPF)) {
            return Customer.builder()
                    .numero(Arrays.asList(numeroCPF))
                    .build();
        }
        return null;
    }
}
