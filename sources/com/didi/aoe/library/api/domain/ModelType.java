package com.didi.aoe.library.api.domain;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public @interface ModelType {
    public static final String FLOAT = "float";
    public static final String QUANTIZED = "quantized";
}
