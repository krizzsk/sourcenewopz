package com.didi.dimina.container.secondparty.imghook;

import didihttp.Interceptor;
import didihttp.Response;

/* renamed from: com.didi.dimina.container.secondparty.imghook.-$$Lambda$ImgLoadHooker$PjjEgu0tKdFjFzmaxcK7U7AYBq0  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$ImgLoadHooker$PjjEgu0tKdFjFzmaxcK7U7AYBq0 implements Interceptor {
    public static final /* synthetic */ $$Lambda$ImgLoadHooker$PjjEgu0tKdFjFzmaxcK7U7AYBq0 INSTANCE = new $$Lambda$ImgLoadHooker$PjjEgu0tKdFjFzmaxcK7U7AYBq0();

    private /* synthetic */ $$Lambda$ImgLoadHooker$PjjEgu0tKdFjFzmaxcK7U7AYBq0() {
    }

    public final Response intercept(Interceptor.Chain chain) {
        return chain.proceed(chain.request()).newBuilder();
    }
}
