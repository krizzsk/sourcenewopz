package com.didi.beatles.p099im.protocol.service;

import android.text.TextUtils;
import com.didi.beatles.p099im.utils.IMLog;
import com.didichuxing.foundation.spi.ServiceLoader;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.didi.beatles.im.protocol.service.IMSpiServiceProvider */
public final class IMSpiServiceProvider {

    /* renamed from: a */
    private static final String f9579a = IMSpiServiceProvider.class.getSimpleName();

    /* renamed from: b */
    private static final String f9580b = "#";

    /* renamed from: c */
    private static final Map<String, SoftReference<?>> f9581c = new HashMap();

    public static <T extends IIMSpiProvider> T getService(Class<T> cls) {
        if (cls == null) {
            return null;
        }
        String canonicalName = cls.getCanonicalName();
        SoftReference softReference = f9581c.get(canonicalName);
        if (softReference == null || softReference.get() == null) {
            return registerService(cls);
        }
        String str = f9579a;
        IMLog.m6631d(str, "getService success: " + canonicalName);
        return (IIMSpiProvider) softReference.get();
    }

    public static <T extends IIMSpiProvider> T getService(Class<T> cls, String str) {
        if (cls == null || TextUtils.isEmpty(str)) {
            return null;
        }
        String a = m6485a(cls, str);
        SoftReference softReference = f9581c.get(a);
        if (softReference == null || softReference.get() == null) {
            return registerService(cls, str);
        }
        String str2 = f9579a;
        IMLog.m6631d(str2, "getService success: " + a);
        return (IIMSpiProvider) softReference.get();
    }

    /* renamed from: a */
    private static String m6485a(Class cls, String str) {
        return cls.getCanonicalName() + "#" + str;
    }

    public static <T extends IIMSpiProvider> T registerService(Class<T> cls) {
        if (cls == null) {
            return null;
        }
        T t = (IIMSpiProvider) ServiceLoader.load(cls).get();
        if (t != null) {
            String str = f9579a;
            IMLog.m6631d(str, "registerService success: " + t.getClass().getCanonicalName());
            f9581c.put(cls.getCanonicalName(), new SoftReference(t));
        }
        return t;
    }

    public static <T extends IIMSpiProvider> T registerService(Class<T> cls, String str) {
        if (cls == null || TextUtils.isEmpty(str)) {
            return null;
        }
        T t = (IIMSpiProvider) ServiceLoader.load(cls, str).get();
        if (t != null) {
            String a = m6485a(cls, str);
            String str2 = f9579a;
            IMLog.m6631d(str2, "registerService success: " + a);
            f9581c.put(a, new SoftReference(t));
        }
        return t;
    }

    public static <T extends IIMSpiProvider> void unRegisterService(Class<T> cls) {
        if (cls != null) {
            String str = f9579a;
            IMLog.m6631d(str, "unRegisterService: " + cls.getCanonicalName());
            f9581c.remove(cls.getCanonicalName());
        }
    }

    public static <T extends IIMSpiProvider> void unRegisterService(Class<T> cls, String str) {
        if (cls != null && !TextUtils.isEmpty(str)) {
            String a = m6485a(cls, str);
            String str2 = f9579a;
            IMLog.m6631d(str2, "unRegisterService: " + a);
            f9581c.remove(a);
        }
    }
}
