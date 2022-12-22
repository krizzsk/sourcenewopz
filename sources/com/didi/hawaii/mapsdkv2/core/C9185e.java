package com.didi.hawaii.mapsdkv2.core;

import android.content.Context;

/* renamed from: com.didi.hawaii.mapsdkv2.core.e */
/* compiled from: MapContextImpl */
final class C9185e implements MapContext {

    /* renamed from: a */
    DefaultEGLContextFactory f24019a;

    /* renamed from: b */
    String f24020b;

    /* renamed from: c */
    private final Context f24021c;

    /* renamed from: d */
    private final Resources f24022d;

    /* renamed from: e */
    private GLHttpClient f24023e;

    private C9185e(Context context, GLHttpClient gLHttpClient) {
        Context applicationContext = context.getApplicationContext();
        this.f24021c = applicationContext;
        this.f24022d = new Resources(applicationContext, this);
        this.f24023e = gLHttpClient;
    }

    /* renamed from: a */
    static C9185e m17084a(Context context, GLHttpClient gLHttpClient) {
        return new C9185e(context, gLHttpClient);
    }

    public Context getAndroidContext() {
        return this.f24021c;
    }

    public Resources getResources() {
        return this.f24022d;
    }

    public GLHttpClient getHttpClient() {
        return this.f24023e;
    }
}
