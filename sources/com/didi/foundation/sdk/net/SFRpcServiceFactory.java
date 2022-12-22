package com.didi.foundation.sdk.net;

import com.didi.foundation.sdk.application.FoundationApplicationListener;
import com.didichuxing.foundation.rpc.RpcService;
import com.didichuxing.foundation.rpc.RpcServiceFactory;
import java.util.concurrent.ConcurrentHashMap;

public class SFRpcServiceFactory {

    /* renamed from: a */
    private static volatile SFRpcServiceFactory f21270a;

    /* renamed from: b */
    private static final Object f21271b = new Object();

    /* renamed from: c */
    private RpcServiceFactory f21272c = new RpcServiceFactory(FoundationApplicationListener.getApplication());

    /* renamed from: d */
    private ConcurrentHashMap<Class<?>, RpcService> f21273d = new ConcurrentHashMap<>();

    private SFRpcServiceFactory() {
    }

    /* renamed from: a */
    private static SFRpcServiceFactory m15628a() {
        if (f21270a == null) {
            synchronized (f21271b) {
                f21270a = new SFRpcServiceFactory();
            }
        }
        return f21270a;
    }

    public static <T extends RpcService> T getRpcService(Class<T> cls, String str) {
        T t = (RpcService) m15628a().f21273d.get(cls);
        if (t == null) {
            synchronized (cls) {
                t = m15628a().f21272c.newRpcService(cls, str);
                m15628a().f21273d.put(cls, t);
            }
        }
        return t;
    }

    public static void clearCache() {
        m15628a().f21273d.clear();
    }
}
