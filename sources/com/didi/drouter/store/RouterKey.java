package com.didi.drouter.store;

import android.net.Uri;
import androidx.lifecycle.LifecycleOwner;
import com.didi.drouter.router.IRouterInterceptor;
import com.didi.drouter.utils.TextUtils;

public class RouterKey {

    /* renamed from: a */
    Uri f19226a;

    /* renamed from: b */
    Class<? extends IRouterInterceptor>[] f19227b;

    /* renamed from: c */
    int f19228c;

    /* renamed from: d */
    boolean f19229d;

    /* renamed from: e */
    LifecycleOwner f19230e;

    private RouterKey() {
    }

    public static RouterKey build(String str) {
        RouterKey routerKey = new RouterKey();
        routerKey.f19226a = TextUtils.getUriKey(str);
        return routerKey;
    }

    public void setThread(int i) {
        this.f19228c = i;
    }

    @SafeVarargs
    public final RouterKey setInterceptor(Class<? extends IRouterInterceptor>... clsArr) {
        this.f19227b = clsArr;
        return this;
    }

    public RouterKey setHold(boolean z) {
        this.f19229d = z;
        return this;
    }

    public RouterKey setLifecycleOwner(LifecycleOwner lifecycleOwner) {
        this.f19230e = lifecycleOwner;
        return this;
    }
}
