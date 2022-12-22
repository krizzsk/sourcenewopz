package com.didi.travel.p171v2.biz;

import com.didi.travel.p171v2.biz.rpc.IRpcDynamicHostCallback;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Inherited
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
/* renamed from: com.didi.travel.v2.biz.IIBiz */
public @interface IIBiz {
    String key();

    Class<? extends IRpcDynamicHostCallback> rpcDynamicHostImp() default IRpcDynamicHostCallback.class;
}
