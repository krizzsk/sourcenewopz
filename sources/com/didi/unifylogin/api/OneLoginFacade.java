package com.didi.unifylogin.api;

import android.content.Context;
import com.didichuxing.foundation.spi.ServiceLoader;

public class OneLoginFacade {

    /* renamed from: a */
    private static final String f44658a = "OneLoginFacade";

    /* renamed from: b */
    private static ILoginActionApi f44659b = ((ILoginActionApi) m31718a(ILoginActionApi.class));

    /* renamed from: c */
    private static ILoginStoreApi f44660c = ((ILoginStoreApi) m31718a(ILoginStoreApi.class));

    /* renamed from: d */
    private static ILoginFunctionApi f44661d = ((ILoginFunctionApi) m31718a(ILoginFunctionApi.class));

    /* renamed from: e */
    private static ILoginConfigApi f44662e = ((ILoginConfigApi) m31718a(ILoginConfigApi.class));

    /* renamed from: f */
    private static ILoginFacade f44663f = ((ILoginFacade) m31718a(ILoginFacade.class));

    public static ILoginActionApi getAction() {
        return f44659b;
    }

    public static ILoginStoreApi getStore() {
        return f44660c;
    }

    public static ILoginFunctionApi getFunction() {
        return f44661d;
    }

    public static ILoginConfigApi getConfigApi() {
        return f44662e;
    }

    public static void init(Context context, LoginInitParam loginInitParam) {
        f44663f.init(context, loginInitParam);
    }

    public static void agentInstance(Context context, LoginInitParam loginInitParam, ILoginActionApi iLoginActionApi, ILoginStoreApi iLoginStoreApi, ILoginFunctionApi iLoginFunctionApi, ILoginConfigApi iLoginConfigApi, ILoginFacade iLoginFacade) {
        f44659b = iLoginActionApi;
        f44660c = iLoginStoreApi;
        f44661d = iLoginFunctionApi;
        f44662e = iLoginConfigApi;
        f44663f = iLoginFacade;
        iLoginFacade.init(context, loginInitParam);
    }

    /* renamed from: a */
    private static <S> S m31718a(Class<S> cls) {
        ServiceLoader<S> load = ServiceLoader.load(cls);
        if (load == null) {
            return null;
        }
        return load.get();
    }
}
