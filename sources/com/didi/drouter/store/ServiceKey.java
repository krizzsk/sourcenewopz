package com.didi.drouter.store;

import androidx.lifecycle.LifecycleOwner;
import com.didi.drouter.service.IFeatureMatcher;

public class ServiceKey<T> {

    /* renamed from: a */
    Class<T> f19264a;

    /* renamed from: b */
    String f19265b = "";

    /* renamed from: c */
    IFeatureMatcher<?> f19266c;

    /* renamed from: d */
    LifecycleOwner f19267d;

    /* renamed from: e */
    RouterMeta f19268e;

    private ServiceKey() {
    }

    public static <T> ServiceKey<T> build(Class<T> cls) {
        ServiceKey<T> serviceKey = new ServiceKey<>();
        serviceKey.f19264a = cls;
        return serviceKey;
    }

    public ServiceKey<T> setAlias(String str) {
        if (str == null) {
            str = "";
        }
        this.f19265b = str;
        return this;
    }

    public ServiceKey<T> setFeature(IFeatureMatcher<?> iFeatureMatcher) {
        this.f19266c = iFeatureMatcher;
        return this;
    }

    public ServiceKey<T> setLifecycleOwner(LifecycleOwner lifecycleOwner) {
        this.f19267d = lifecycleOwner;
        return this;
    }
}
