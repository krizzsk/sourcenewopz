package com.didi.component.config;

import android.util.Pair;
import com.didi.component.config.BusinessRegistry;
import com.didi.sdk.util.UiThreadHandler;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ComponentsConfig {

    /* renamed from: a */
    private static volatile ComponentsConfig f12589a;

    /* renamed from: b */
    private Map<Object, C5268a> f12590b = new LinkedHashMap();

    /* renamed from: c */
    private final List<ComponentConfigChangedListener> f12591c = new ArrayList();

    public interface ComponentConfigChangedListener {
        void onComponentConfigChanged(List<Pair<String, Integer>> list);
    }

    private ComponentsConfig() {
    }

    public static ComponentsConfig get() {
        if (f12589a == null) {
            synchronized (ComponentsConfig.class) {
                if (f12589a == null) {
                    f12589a = new ComponentsConfig();
                }
            }
        }
        return f12589a;
    }

    public ComponentConfig queryConfig(String str, Object obj, int i) {
        C5268a aVar;
        PageConfig pageConfig;
        synchronized (this) {
            aVar = this.f12590b.get(obj);
        }
        if (aVar == null || (pageConfig = aVar.f12631g.get(i)) == null) {
            return null;
        }
        return pageConfig.f12616c.get(str);
    }

    public void replace(GlobalConfig globalConfig) {
        synchronized (this) {
            if (globalConfig != null) {
                if (!globalConfig.f12599a.isEmpty()) {
                    BusinessRegistry.m8564a();
                    this.f12590b.putAll(globalConfig.f12599a);
                    BusinessRegistry.m8566a(m8573a(this.f12590b.values()));
                }
                m8576a(globalConfig.f12599a);
            }
        }
    }

    /* renamed from: a */
    private void m8576a(Map<Object, C5268a> map) {
        if (!map.isEmpty()) {
            Collection<C5268a> values = map.values();
            if (!values.isEmpty()) {
                final ArrayList arrayList = new ArrayList();
                for (C5268a next : values) {
                    if (next != null) {
                        arrayList.add(new Pair(next.f12626b, Integer.valueOf(next.f12625a)));
                    }
                }
                UiThreadHandler.post(new Runnable() {
                    public void run() {
                        ComponentsConfig.this.m8575a((List<Pair<String, Integer>>) arrayList);
                    }
                });
            }
        }
    }

    /* renamed from: a */
    private List<BusinessRegistry.Entry> m8573a(Collection<C5268a> collection) {
        if (collection == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (C5268a a : collection) {
            BusinessRegistry.Entry a2 = m8572a(a);
            if (a2 != null) {
                arrayList.add(a2);
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    private BusinessRegistry.Entry m8572a(C5268a aVar) {
        if (aVar == null) {
            return null;
        }
        return new BusinessRegistry.Entry(aVar.f12625a, aVar.f12626b, aVar.f12630f);
    }

    public boolean containsBusinessConfig(String str) {
        return this.f12590b.containsKey(str);
    }

    public boolean containsBusinessConfig(int i) {
        return this.f12590b.containsKey(Integer.valueOf(i));
    }

    public void addComponentConfigChangedListener(ComponentConfigChangedListener componentConfigChangedListener) {
        if (componentConfigChangedListener != null) {
            synchronized (this.f12591c) {
                if (!this.f12591c.contains(componentConfigChangedListener)) {
                    this.f12591c.add(componentConfigChangedListener);
                }
            }
        }
    }

    public void removeComponentConfigChangedListener(ComponentConfigChangedListener componentConfigChangedListener) {
        synchronized (this.f12591c) {
            this.f12591c.remove(componentConfigChangedListener);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m8575a(List<Pair<String, Integer>> list) {
        ComponentConfigChangedListener[] componentConfigChangedListenerArr;
        synchronized (this.f12591c) {
            componentConfigChangedListenerArr = (ComponentConfigChangedListener[]) this.f12591c.toArray(new ComponentConfigChangedListener[this.f12591c.size()]);
        }
        for (ComponentConfigChangedListener onComponentConfigChanged : componentConfigChangedListenerArr) {
            onComponentConfigChanged.onComponentConfigChanged(list);
        }
    }

    public void checkOrAddComponent(int i, String str) {
        synchronized (this) {
            if (!this.f12590b.containsKey(Integer.valueOf(i))) {
                C5268a aVar = new C5268a();
                aVar.f12625a = i;
                aVar.f12630f = str;
                this.f12590b.put(Integer.valueOf(i), aVar);
                m8577b(this.f12590b);
            }
        }
    }

    /* renamed from: b */
    private void m8577b(Map<Object, C5268a> map) {
        BusinessRegistry.m8566a(m8573a(map.values()));
        m8576a(map);
    }
}
