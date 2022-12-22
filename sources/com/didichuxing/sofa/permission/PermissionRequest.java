package com.didichuxing.sofa.permission;

import android.app.Activity;
import androidx.fragment.app.Fragment;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.bigdata.p173dp.locsdk.Const;
import java.lang.ref.WeakReference;

public abstract class PermissionRequest<T> {

    /* renamed from: a */
    private static final String f49145a = "PermissionRequest";

    /* renamed from: b */
    private WeakReference<T> f49146b;

    /* renamed from: c */
    private String[] f49147c;

    /* renamed from: d */
    private int f49148d;

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public abstract void mo121147a(T t, String[] strArr, int i);

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public abstract boolean mo121148a(T t, String[] strArr);

    public void cancel() {
    }

    PermissionRequest(T t, String[] strArr, int i) {
        this.f49146b = new WeakReference<>(t);
        this.f49147c = strArr;
        this.f49148d = i;
    }

    /* renamed from: b */
    static PermissionRequest m35422b(Object obj, String[] strArr, int i) {
        if (obj instanceof Activity) {
            return new C16478a((Activity) obj, strArr, i);
        }
        if (obj instanceof Fragment) {
            return new C16479b((Fragment) obj, strArr, i);
        }
        SystemUtils.log(6, f49145a, "createRequest: Can't resolve host: " + obj, (Throwable) null, "com.didichuxing.sofa.permission.PermissionRequest", 34);
        return null;
    }

    public void execute() {
        if (this.f49146b.get() == null) {
            SystemUtils.log(6, f49145a, "execute: host is null", (Throwable) null, "com.didichuxing.sofa.permission.PermissionRequest", 43);
        } else if (mo121148a(this.f49146b.get(), this.f49147c)) {
            SystemUtils.log(3, f49145a, "execute: permissions " + PermissionUtils.formatArrayAsString(this.f49147c) + " have granted already!", (Throwable) null, "com.didichuxing.sofa.permission.PermissionRequest", 47);
        } else {
            mo121147a(this.f49146b.get(), this.f49147c, this.f49148d);
        }
    }

    public void proceed() {
        if (this.f49146b.get() == null) {
            SystemUtils.log(6, f49145a, "proceed: host is null", (Throwable) null, "com.didichuxing.sofa.permission.PermissionRequest", 67);
        } else if (mo121148a(this.f49146b.get(), this.f49147c)) {
            SystemUtils.log(3, f49145a, "proceed: permissions " + PermissionUtils.formatArrayAsString(this.f49147c) + " have granted already!", (Throwable) null, "com.didichuxing.sofa.permission.PermissionRequest", 71);
        } else {
            mo121147a(this.f49146b.get(), this.f49147c, this.f49148d);
        }
    }

    public String toString() {
        return Const.jaLeft + this.f49146b + "] request permissions: " + PermissionUtils.formatArrayAsString(this.f49147c);
    }
}
