package com.didi.soda.customer.repo;

import android.os.Bundle;
import com.didi.app.nova.skeleton.repo.Resource;

public final class CustomerResource<T> extends Resource<T> {
    public final Bundle mExtension;

    protected CustomerResource(Resource.Status status, T t, int i, String str) {
        super(status, t, i, str);
        this.mExtension = null;
    }

    protected CustomerResource(Resource.Status status, T t, int i, String str, Bundle bundle) {
        super(status, t, i, str);
        this.mExtension = bundle;
    }

    public static <T> CustomerResource<T> success(T t, int i, String str, Bundle bundle) {
        return new CustomerResource(Resource.Status.SUCCESS, t, i, str, bundle);
    }

    public static <T> CustomerResource<T> success(T t) {
        return success(t, (Bundle) null);
    }

    public static <T> CustomerResource<T> success(T t, Bundle bundle) {
        return new CustomerResource(Resource.Status.SUCCESS, t, -1, (String) null, bundle);
    }

    public static <T> CustomerResource<T> error(String str) {
        return error(-1, str);
    }

    public static <T> CustomerResource<T> error(int i, String str) {
        return error(i, str, (Object) null);
    }

    public static <T> CustomerResource<T> error(int i, String str, T t) {
        return new CustomerResource<>(Resource.Status.ERROR, t, i, str);
    }

    public static <T> CustomerResource<T> error(int i, String str, T t, Bundle bundle) {
        return new CustomerResource(Resource.Status.ERROR, t, i, str, bundle);
    }

    public static <T> CustomerResource<T> loading() {
        return new CustomerResource<>(Resource.Status.LOADING, (Object) null, -1, (String) null);
    }

    public static <T> CustomerResource<T> loading(T t) {
        return new CustomerResource<>(Resource.Status.LOADING, t, -1, (String) null);
    }

    public static <T> CustomerResource<T> change(T t) {
        return change(t, (Bundle) null);
    }

    public static <T> CustomerResource<T> change(T t, Bundle bundle) {
        return new CustomerResource(Resource.Status.CHANGE, t, -1, (String) null, bundle);
    }

    public String toString() {
        return "CustomerResource{status: " + this.status + ",data: " + this.data + ",code: " + this.code + ",message: " + this.message + ",mExtension: " + this.mExtension + "}";
    }
}
