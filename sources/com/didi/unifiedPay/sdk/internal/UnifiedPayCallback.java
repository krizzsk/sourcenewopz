package com.didi.unifiedPay.sdk.internal;

import com.didi.sdk.util.SingletonHolder;

public class UnifiedPayCallback {

    /* renamed from: a */
    private PayCallback f44547a;

    /* renamed from: b */
    private BindCardCallback f44548b;

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
        this.f44547a = payCallback;
    }

    public void registerQQPayCallback(String str, PayCallback payCallback) {
        this.f44547a = payCallback;
    }

    public void registerBindVisaCardCallback(BindCardCallback bindCardCallback) {
        this.f44548b = bindCardCallback;
    }

    public void unRegisterPayCallback() {
        this.f44547a = null;
    }

    public void unRegisterBindCardCallback() {
        this.f44548b = null;
    }

    public void unRegisterAllPayCallback() {
        unRegisterPayCallback();
        unRegisterBindCardCallback();
    }

    public PayCallback getPayCallback() {
        return this.f44547a;
    }

    public BindCardCallback getBindCardCallback() {
        return this.f44548b;
    }
}
