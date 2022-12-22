package com.didi.component.core;

import android.content.Context;
import android.text.TextUtils;
import com.didi.component.core.util.CLog;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;

public class ComponentFactory {

    /* renamed from: a */
    private ComponentRegistry f12732a = new ComponentRegistry();

    /* renamed from: b */
    private Proxy f12733b;

    public interface Proxy {
        ComponentStatus checkComponentStatus(Context context, int i, String str, int i2);

        <T extends IComponent> T newComponent(Context context, int i, String str, int i2, int i3, boolean z);
    }

    public final void setProxy(Proxy proxy) {
        this.f12733b = proxy;
    }

    public final void register(String str, Class<? extends IComponent> cls) {
        CLog.m8708d("ComponentFactory#register: " + str + "|" + cls);
        this.f12732a.register(str, (Class) cls);
    }

    public void register(String str, Callable<?> callable) {
        CLog.m8708d("ComponentFactory#register: " + str);
        this.f12732a.register(str, callable);
    }

    public ComponentRegistry getComponentRegistry() {
        return this.f12732a;
    }

    public final <T extends IComponent> T newComponent(Context context, int i, String str, int i2, int i3, boolean z) {
        Proxy proxy = this.f12733b;
        if (proxy != null) {
            return proxy.newComponent(context, i, str, i2, i3, z);
        }
        return null;
    }

    public final ComponentStatus checkComponentStatus(Context context, int i, String str, int i2) {
        Proxy proxy = this.f12733b;
        if (proxy != null) {
            return proxy.checkComponentStatus(context, i, str, i2);
        }
        return ComponentStatus.UNKNOWN;
    }

    public static ComponentFactory get() {
        return Holder.INSTANCE;
    }

    private static final class Holder {
        /* access modifiers changed from: private */
        public static final ComponentFactory INSTANCE = new ComponentFactory();

        private Holder() {
        }
    }

    public static class ComponentRegistry {
        private final Map<String, Callable<?>> mComponentCallableMap = new HashMap();
        private final Map<String, Class<? extends IComponent>> mComponentMap = new HashMap();

        public void register(String str, Class cls) {
            if (!TextUtils.isEmpty(str) && cls != null) {
                synchronized (this.mComponentMap) {
                    this.mComponentMap.put(str, cls);
                }
            }
        }

        public Class<? extends IComponent> query(String str) {
            Class<? extends IComponent> cls;
            synchronized (this.mComponentMap) {
                cls = this.mComponentMap.get(str);
            }
            return cls;
        }

        public void register(String str, Callable<?> callable) {
            if (!TextUtils.isEmpty(str) && callable != null) {
                synchronized (this.mComponentCallableMap) {
                    this.mComponentCallableMap.put(str, callable);
                }
            }
        }

        public Callable<?> queryCallable(String str) {
            Callable<?> callable;
            synchronized (this.mComponentCallableMap) {
                callable = this.mComponentCallableMap.get(str);
            }
            return callable;
        }
    }
}
