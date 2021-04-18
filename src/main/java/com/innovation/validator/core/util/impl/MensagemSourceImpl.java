package com.innovation.validator.core.util.impl;

import com.innovation.validator.core.util.SourceMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
@RequiredArgsConstructor
public class MensagemSourceImpl implements SourceMessage {

    private final MessageSource messageSource;

    @Override
    public String getMessage(String key) {
        Locale locale = LocaleContextHolder.getLocale();
        return messageSource.getMessage(key, null, locale);
    }

    @Override
    public String getMessage(String key, Object... objects) {
        Locale locale = LocaleContextHolder.getLocale();
        return messageSource.getMessage(key, objects, locale);
    }

    @Override
    public String getMessage(String key, Locale locale) {
        return messageSource.getMessage(key, null, locale);
    }

}