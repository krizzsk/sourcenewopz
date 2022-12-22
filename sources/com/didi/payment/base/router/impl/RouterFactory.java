package com.didi.payment.base.router.impl;

public class RouterFactory {
    public final IPayRouter getPayRouter(String str) {
        if (str.startsWith("njbundle")) {
            return getBundlePayRouter();
        }
        if (str.startsWith("http") || str.startsWith("https")) {
            return getWebRouter();
        }
        if (str.startsWith("native")) {
            return getActivityRouter();
        }
        return new OtherRouter();
    }

    /* access modifiers changed from: protected */
    public IPayRouter getBundlePayRouter() {
        return new BundleRouter();
    }

    /* access modifiers changed from: protected */
    public IPayRouter getWebRouter() {
        return new WebRouter();
    }

    /* access modifiers changed from: protected */
    public IPayRouter getActivityRouter() {
        return new ActivityRouter();
    }
}
