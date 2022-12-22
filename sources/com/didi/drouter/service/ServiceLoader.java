package com.didi.drouter.service;

import androidx.lifecycle.LifecycleOwner;
import java.util.List;

public class ServiceLoader<T> {

    /* renamed from: a */
    private final ServiceAgent<T> f19225a;

    private ServiceLoader(Class<T> cls) {
        this.f19225a = new ServiceAgent<>(cls);
    }

    public static <T> ServiceLoader<T> build(Class<T> cls) {
        if (cls != null) {
            return new ServiceLoader<>(cls);
        }
        throw new RuntimeException("DRouter function class can't be null");
    }

    public ServiceLoader<T> setFilter(String str) {
        this.f19225a.mo58922a(str);
        return this;
    }

    public ServiceLoader<T> setAlias(String str) {
        this.f19225a.mo58922a(str);
        return this;
    }

    public ServiceLoader<T> setFeature(Object obj) {
        this.f19225a.mo58921a(obj);
        return this;
    }

    public ServiceLoader<T> setRemoteAuthority(String str) {
        this.f19225a.mo58926b(str);
        return this;
    }

    public ServiceLoader<T> setRemoteDeadResend(int i) {
        this.f19225a.mo58919a(i);
        return this;
    }

    public ServiceLoader<T> setLifecycleOwner(LifecycleOwner lifecycleOwner) {
        this.f19225a.mo58920a(lifecycleOwner);
        return this;
    }

    public ServiceLoader<T> setDefaultIfEmpty(T t) {
        this.f19225a.mo58925b(t);
        return this;
    }

    public T getService(Object... objArr) {
        return this.f19225a.mo58924b(objArr);
    }

    public List<T> getAllService(Object... objArr) {
        return this.f19225a.mo58918a(objArr);
    }

    public Class<? extends T> getServiceClass() {
        return this.f19225a.mo58923b();
    }

    public List<Class<? extends T>> getAllServiceClass() {
        return this.f19225a.mo58917a();
    }
}
