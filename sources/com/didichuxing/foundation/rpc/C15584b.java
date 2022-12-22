package com.didichuxing.foundation.rpc;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.foundation.net.UnsupportedSchemeException;
import com.didichuxing.foundation.spi.ServiceLoader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Iterator;

/* renamed from: com.didichuxing.foundation.rpc.b */
/* compiled from: RpcClientFactoryService */
class C15584b {

    /* renamed from: a */
    static final ServiceLoader<RpcClientFactory> f47622a = ServiceLoader.load(RpcClientFactory.class);

    /* renamed from: c */
    private static final String f47623c = "/sdcard/.rpc_crash_dump.log";

    /* renamed from: d */
    private static Object f47624d;

    /* renamed from: e */
    private static Method f47625e;

    /* renamed from: f */
    private static Object f47626f;

    /* renamed from: g */
    private static Method f47627g;

    /* renamed from: h */
    private static Method f47628h;

    /* renamed from: b */
    final Context f47629b;

    static {
        try {
            Class<?> cls = Class.forName("com.didichuxing.foundation.net.rpc.http.HttpRpcClientFactory");
            Constructor<?> constructor = cls.getConstructor(new Class[0]);
            if (constructor != null) {
                f47626f = constructor.newInstance(new Object[0]);
                f47627g = cls.getMethod("isSchemeSupported", new Class[]{String.class});
                f47628h = cls.getMethod("newRpcClient", new Class[]{Context.class});
            }
            Class<?> cls2 = Class.forName("didinet.ProblemTracking");
            f47624d = cls2.getMethod("getInstance", new Class[0]).invoke((Object) null, new Object[0]);
            f47625e = cls2.getMethod("recordContextInfo", new Class[]{Class.class, Boolean.TYPE, String.class});
        } catch (Throwable th) {
            if (C15583a.f47621a) {
                SystemUtils.log(3, "networking", "" + Log.getStackTraceString(th), (Throwable) null, "com.didichuxing.foundation.rpc.RpcClientFactoryService", 43);
            }
        }
    }

    public C15584b(Context context) {
        this.f47629b = context;
    }

    /* renamed from: a */
    public RpcClient<? extends RpcRequest, ? extends RpcResponse> mo117359a(Uri uri) {
        String scheme = uri.getScheme();
        Iterator<RpcClientFactory> it = f47622a.iterator();
        while (it.hasNext()) {
            RpcClientFactory next = it.next();
            if (next.isSchemeSupported(scheme)) {
                m34088a(getClass(), false, f47623c);
                return next.newRpcClient(this.f47629b);
            }
        }
        m34088a(getClass(), true, f47623c);
        try {
            if (!(f47626f == null || f47627g == null)) {
                if (((Boolean) f47627g.invoke(f47626f, new Object[]{scheme})).booleanValue() && f47628h != null) {
                    return (RpcClient) f47628h.invoke(f47626f, new Object[]{this.f47629b});
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        throw new UnsupportedSchemeException(scheme);
    }

    /* renamed from: a */
    private static void m34088a(Class cls, boolean z, String str) {
        Object obj;
        Method method = f47625e;
        if (method != null && (obj = f47624d) != null) {
            try {
                method.invoke(obj, new Object[]{cls, Boolean.valueOf(z), str});
            } catch (Throwable th) {
                if (C15583a.f47621a) {
                    SystemUtils.log(3, "networking", "" + Log.getStackTraceString(th), (Throwable) null, "com.didichuxing.foundation.rpc.RpcClientFactoryService", 90);
                }
            }
        }
    }
}
