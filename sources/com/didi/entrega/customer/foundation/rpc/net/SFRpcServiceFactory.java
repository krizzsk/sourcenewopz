package com.didi.entrega.customer.foundation.rpc.net;

import android.app.Application;
import androidx.collection.ArrayMap;
import com.didi.entrega.customer.app.GlobalContext;
import com.didi.entrega.customer.foundation.tracker.OmegaTracker;
import com.didi.entrega.customer.foundation.util.LoginUtil;
import com.didichuxing.foundation.rpc.RpcService;
import com.didichuxing.foundation.rpc.RpcServiceFactory;
import com.didichuxing.swarm.launcher.SwarmLauncher;
import com.didichuxing.swarm.launcher.util.SwarmServices;
import org.osgi.framework.launch.Framework;

public final class SFRpcServiceFactory {

    /* renamed from: a */
    private static Object f20022a = new Object();

    /* renamed from: b */
    private static volatile SFRpcServiceFactory f20023b = null;

    /* renamed from: c */
    private RpcServiceFactory f20024c = new RpcServiceFactory(GlobalContext.getContext());

    /* renamed from: d */
    private ArrayMap<Class<?>, RpcService> f20025d = new ArrayMap<>();

    private SFRpcServiceFactory() {
        if (SwarmServices.lookup(Application.class) == null) {
            Framework framework = SwarmLauncher.getInstance().getFramework();
            int i = 0;
            OmegaTracker.Builder addEventParam = OmegaTracker.Builder.create("swarm_application_crash").addEventParam("phone", LoginUtil.getPhone()).addEventParam("framework", Integer.valueOf(framework == null ? 0 : 1));
            if (framework != null) {
                addEventParam.addEventParam("context", Integer.valueOf(framework.getBundleContext() != null ? 1 : i));
            }
            addEventParam.build().track();
        }
    }

    public static <T extends RpcService> T getRpcService(Class<T> cls, String str) {
        T t = (RpcService) m14786a().f20025d.get(cls);
        if (t == null) {
            synchronized (cls) {
                t = m14786a().f20024c.newRpcService(cls, str);
                m14786a().f20025d.put(cls, t);
            }
        }
        return t;
    }

    public static void clearCache() {
        m14786a().f20025d.clear();
    }

    /* renamed from: a */
    private static SFRpcServiceFactory m14786a() {
        if (f20023b == null) {
            synchronized (f20022a) {
                f20023b = new SFRpcServiceFactory();
            }
        }
        return f20023b;
    }
}
