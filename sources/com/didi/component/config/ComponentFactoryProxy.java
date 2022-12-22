package com.didi.component.config;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.didi.component.core.ComponentFactory;
import com.didi.component.core.ComponentStatus;
import com.didi.component.core.IComponent;
import com.didi.component.core.util.CLog;
import com.didi.sdk.util.collection.CollectionUtil;
import com.didichuxing.foundation.spi.ServiceLoader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.Callable;

public class ComponentFactoryProxy implements ComponentFactory.Proxy {

    /* renamed from: a */
    private ComponentFactory.ComponentRegistry f12586a;

    /* renamed from: b */
    private ArrayList<String> f12587b;

    /* renamed from: c */
    private boolean f12588c;

    public ComponentFactoryProxy(ComponentFactory.ComponentRegistry componentRegistry) {
        this.f12586a = componentRegistry;
    }

    public <T extends IComponent> T newComponent(Context context, int i, String str, int i2, int i3, boolean z) {
        CLog.m8710i("ComponentFactoryProxy#newComponent: " + i + "|" + str + "|" + i2 + "|config enable:" + z);
        boolean z2 = false;
        boolean z3 = z && ConfigLoader.isUseConfig() && ComponentsConfig.get().containsBusinessConfig(i);
        ComponentConfig a = m8568a(i, str, i2);
        CLog.m8710i("ComponentFactoryProxy#newComponent useConfig|cfg: " + z3 + "|" + a);
        if (!this.f12588c) {
            this.f12587b = getCompListNoUseConfig();
            this.f12588c = true;
        }
        if (CollectionUtil.isEmpty((Collection<?>) this.f12587b) || !this.f12587b.contains(str)) {
            z2 = z3;
        }
        String str2 = null;
        if (z2 && (a == null || !a.open())) {
            return null;
        }
        if (a != null) {
            str2 = a.params();
        }
        return m8569a(i, str, str2, i3);
    }

    public static ArrayList<String> getCompListNoUseConfig() {
        IComponentTypeNoUseConfigService iComponentTypeNoUseConfigService = (IComponentTypeNoUseConfigService) ServiceLoader.load(IComponentTypeNoUseConfigService.class).get();
        if (iComponentTypeNoUseConfigService != null) {
            return iComponentTypeNoUseConfigService.getCompListNoUseConfig();
        }
        return new ArrayList<>();
    }

    public ComponentStatus checkComponentStatus(Context context, int i, String str, int i2) {
        boolean z = ConfigLoader.isUseConfig() && ComponentsConfig.get().containsBusinessConfig(i);
        ComponentConfig a = m8568a(i, str, i2);
        if (z && (a == null || !a.open())) {
            return ComponentStatus.NOT_CONFIGURED;
        }
        if (this.f12586a.query(str) == null) {
            return ComponentStatus.NOT_REGISTERED;
        }
        return ComponentStatus.f12737OK;
    }

    /* renamed from: a */
    private <T extends IComponent> T m8569a(int i, String str, String str2, int i2) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Class<? extends IComponent> query = this.f12586a.query(str);
        CLog.m8708d("ComponentFactory#newInnerComponent clazz: " + query);
        if (query != null) {
            try {
                T t = (IComponent) query.newInstance();
                if (t instanceof IComponentEx) {
                    ((IComponentEx) t).setExtras(m8571c(i, str2, str, i2));
                }
                return t;
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e2) {
                e2.printStackTrace();
            } catch (ClassCastException e3) {
                e3.printStackTrace();
            }
        }
        return null;
    }

    /* renamed from: b */
    private <T extends IComponent> T m8570b(int i, String str, String str2, int i2) {
        Callable<?> queryCallable;
        if (!TextUtils.isEmpty(str) && (queryCallable = this.f12586a.queryCallable(str)) != null) {
            try {
                T t = (IComponent) queryCallable.call();
                if (t instanceof IComponentEx) {
                    ((IComponentEx) t).setExtras(m8571c(i, str2, str, i2));
                }
                return t;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /* renamed from: a */
    private ComponentConfig m8568a(int i, String str, int i2) {
        CLog.m8708d("ComponentFactory#configuredComponent: " + i + "|" + str + "|" + i2);
        ComponentConfig queryConfig = ComponentsConfig.get().queryConfig(str, Integer.valueOf(i), i2);
        StringBuilder sb = new StringBuilder();
        sb.append("ComponentFactory#configuredComponent config:");
        sb.append(queryConfig);
        CLog.m8708d(sb.toString());
        if (queryConfig != null && queryConfig.valid() && TextUtils.equals(str, queryConfig.type())) {
            return queryConfig;
        }
        String bid2ParentSid = BusinessRegistry.bid2ParentSid(i);
        CLog.m8708d("ComponentFactory#configuredComponent parent sid:" + bid2ParentSid);
        if (TextUtils.isEmpty(bid2ParentSid)) {
            return null;
        }
        ComponentConfig queryConfig2 = ComponentsConfig.get().queryConfig(str, bid2ParentSid, i2);
        CLog.m8708d("ComponentFactory#configuredComponent config form parent: " + queryConfig2);
        if (queryConfig2 == null || !queryConfig2.valid() || !TextUtils.equals(str, queryConfig2.type())) {
            return null;
        }
        return queryConfig2;
    }

    /* renamed from: c */
    private Bundle m8571c(int i, String str, String str2, int i2) {
        Bundle bundle = new Bundle();
        bundle.putString("BUNDLE_KEY_SID", BusinessRegistry.bid2Sid(i));
        bundle.putString("BUNDLE_KEY_PARENT_SID", BusinessRegistry.bid2ParentSid(i));
        bundle.putInt("BUNDLE_KEY_BID", i);
        bundle.putInt("BUNDLE_KEY_COMBO_TYPE", i2);
        if (str != null && !str.isEmpty()) {
            bundle.putString("BUNDLE_KEY_PARAMS", str);
        }
        return bundle;
    }
}
