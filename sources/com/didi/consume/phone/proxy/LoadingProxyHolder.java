package com.didi.consume.phone.proxy;

public class LoadingProxyHolder {

    /* renamed from: a */
    private static ILoadingProxy f16256a;

    public interface ILoadingProxy {
        void dismissLoading();

        void showLoading();
    }

    public static void releaseProxy() {
        f16256a = null;
    }

    public static ILoadingProxy getProxy() {
        return f16256a;
    }

    public static void setProxy(ILoadingProxy iLoadingProxy) {
        f16256a = iLoadingProxy;
    }
}
