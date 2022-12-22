package com.didiglobal.domainservice.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public @interface SuffixType {
    public static final String IDC = "idc";
    public static final String PII = "pii";
}
