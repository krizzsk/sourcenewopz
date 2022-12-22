package com.didi.dimina.starbox.module.jsbridge.gift;

public abstract class Interceptor<PARAM, RESULT> {
    /* access modifiers changed from: package-private */
    public abstract InterceptorResult<RESULT> onExecute(PARAM param) throws Exception;
}
