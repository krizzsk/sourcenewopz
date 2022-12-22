package com.didi.travel.p171v2.biz.bff;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
/* renamed from: com.didi.travel.v2.biz.bff.IIBff */
public @interface IIBff {
    String ability();

    Class<? extends BffV1InvokeCallback> bffV1InvokeCallbackImp() default BffV1InvokeCallback.class;

    Class<? extends BffV2InvokeCallback> bffV2InvokeCallbackImp() default BffV2InvokeCallback.class;

    Class<?> dataType();

    BffVersion version();
}
