package com.didi.universal.pay.sdk.method.internal;

import com.didi.sdk.util.SingletonHolder;

public class UnifiedPayCallback {

    /* renamed from: a */
    private PayCallback f45111a;

    /* renamed from: b */
    private BindCardCallback f45112b;

    public interface BindCardCallback {
        void onFail(int i, String str);

        void onSuccess();
    }

    public interface PayCallback {
        void onFail(int i, String str);

        void onSuccess();
    }

    private UnifiedPayCallback() {
    }

    public static UnifiedPayCallback getInstance() {
        return (UnifiedPayCallback) SingletonHolder.getInstance(UnifiedPayCallback.class);
    }

    public void registerWXPayCallback(String str, PayCallback payCallback) {
        this.f45111a = payCallback;
    }

    public void registerQQPayCallback(String str, PayCallback payCallback) {
        this.f45111a = payCallback;
    }

    public void registerBindVisaCardCallback(BindCardCallback bindCardCallback) {
        this.f45112b = bindCardCallback;
    }

    public void unRegisterPayCallback() {
        this.f45111a = null;
    }

    public void unRegisterBindCardCallback() {
        this.f45112b = null;
    }

    public void unRegisterAllPayCallback() {
        unRegisterPayCallback();
        unRegisterBindCardCallback();
    }

    public PayCallback getPayCallback() {
        return this.f45111a;
    }

    public BindCardCallback getBindCardCallback() {
        return this.f45112b;
    }
}
