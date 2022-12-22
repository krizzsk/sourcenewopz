package com.didi.payment.base.proxy;

public class LoadingProxyHolder {

    /* renamed from: a */
    private static ILoadingProxy f29919a;

    public interface ILoadingProxy {
        void dismissLoading();

        void showLoading();
    }

    public static void releaseProxy() {
        f29919a = null;
    }

    public static ILoadingProxy getProxy() {
        return f29919a;
    }

    public static void setProxy(ILoadingProxy iLoadingProxy) {
        f29919a = iLoadingProxy;
    }
}
