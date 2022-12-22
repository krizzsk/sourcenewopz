package com.didi.travel.p171v2.biz.rpc;

import com.didi.travel.psnger.common.net.base.BaseObject;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
/* renamed from: com.didi.travel.v2.biz.rpc.IIRpc */
public @interface IIRpc {
    Class<? extends BaseObject> dataType();

    Class<? extends IRpcDynamicHostCallback> dynamicHostImp() default IRpcDynamicHostCallback.class;

    String host();

    String hostKey();

    Class<? extends RpcInvokeCallback> rpcInvokeCallbackImp() default RpcInvokeCallback.class;

    String sharePath();
}
