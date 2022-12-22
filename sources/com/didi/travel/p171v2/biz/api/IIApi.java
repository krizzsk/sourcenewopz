package com.didi.travel.p171v2.biz.api;

import com.didi.travel.p171v2.biz.common.CommonInvokeCallback;
import com.didi.travel.p171v2.store.IStoreCallback;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
/* renamed from: com.didi.travel.v2.biz.api.IIApi */
public @interface IIApi {
    Class<? extends IApiInvokeCallback> apiInvokeCallbackImp() default CommonInvokeCallback.class;

    ApiInvokePolicy apiInvokePolicy();

    Class<? extends IStoreCallback> apiStoreCallbackImp() default IStoreCallback.class;

    String key();

    DataLevel storeDataLevel() default DataLevel.NONE;
}
