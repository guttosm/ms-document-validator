package com.innovation.validator.core.util.converter;

import com.innovation.validator.core.model.mongo.Customer;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

@Component
public class StringToCPFConverter implements Converter<String, Customer> {

    @Override
    public Customer convert(String cpfNumber) {
        if (!ObjectUtils.isEmpty(cpfNumber)) {
            return Customer.builder()
                    .number(cpfNumber)
                    .build();
        }
        return null;
    }
}
