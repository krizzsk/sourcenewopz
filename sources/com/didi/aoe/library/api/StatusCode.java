package com.didi.aoe.library.api;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD, ElementType.LOCAL_VARIABLE, ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.SOURCE)
public @interface StatusCode {
    public static final int STATUS_CONFIG_PARSE_ERROR = 1;
    public static final int STATUS_CONNECTION_WAITTING = 2;
    public static final int STATUS_INNER_ERROR = -2;
    public static final int STATUS_MODEL_DOWNLOAD_WAITING = 3;
    public static final int STATUS_MODEL_LOAD_FAILED = 4;
    public static final int STATUS_OK = 0;
    public static final int STATUS_UNDEFINE = -1;
}
