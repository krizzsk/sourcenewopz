package com.didi.map.global.sctx.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public @interface OrderRouteParamError {
    public static final int END_POINT = 3;
    public static final int ORDER_ID = 1;
    public static final int PRODUCT_ID = 4;
    public static final int START_POINT = 2;
}
