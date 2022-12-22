package com.didi.dimina.container.secondparty.bundle.chain;

import android.content.Context;
import com.didi.dimina.container.DMMina;
import com.didi.dimina.container.Dimina;

public abstract class IPckInterceptor {
    protected InterceptorConfig config;
    protected Context context;
    protected String jsAppId;
    protected String jsSdkId;
    protected DMMina mina;
    protected IPckInterceptor nextInterceptor;

    /* access modifiers changed from: protected */
    public abstract boolean process();

    public void setNextInterceptor(IPckInterceptor iPckInterceptor) {
        this.nextInterceptor = iPckInterceptor;
    }

    public void setValue(DMMina dMMina, InterceptorConfig interceptorConfig) {
        if (dMMina != null) {
            this.mina = dMMina;
        }
        if (interceptorConfig != null) {
            this.jsAppId = interceptorConfig.jsAppId;
            this.jsSdkId = interceptorConfig.jsSdkId;
            this.config = interceptorConfig;
        }
        this.context = Dimina.getConfig().getApp();
    }

    public void intercept() {
        if (process()) {
            execNextInterceptor();
        }
    }

    /* access modifiers changed from: protected */
    public void execNextInterceptor() {
        IPckInterceptor iPckInterceptor = this.nextInterceptor;
        if (iPckInterceptor != null) {
            iPckInterceptor.setValue(this.mina, this.config);
            this.nextInterceptor.intercept();
        }
    }

    public String toString() {
        return "IPckInterceptor{, App:'" + this.jsAppId + '\'' + ", sdk:'" + this.jsSdkId + '\'' + ", @" + hashCode() + '}';
    }
}
