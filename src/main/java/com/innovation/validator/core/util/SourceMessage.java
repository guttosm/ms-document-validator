package com.innovation.validator.core.util;

import java.util.Locale;

public interface SourceMessage {

	String getMessage(String key);
    String getMessage(String key, Object... objects);
    String getMessage(String key, Locale locale);
}
