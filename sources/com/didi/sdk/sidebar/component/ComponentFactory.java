package com.didi.sdk.sidebar.component;

import android.text.TextUtils;
import com.didi.sdk.app.BaseBusinessContext;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didi.sdk.sidebar.model.SidebarItem;
import java.util.HashSet;
import java.util.Set;

public class ComponentFactory {

    /* renamed from: a */
    private static final Set<Class<? extends AbsComponent>> f37192a = new HashSet();

    /* renamed from: b */
    private Logger f37193b = LoggerFactory.getLogger("DataContainer");

    public static void addComponentClass(Class<? extends AbsComponent> cls) {
        f37192a.add(cls);
    }

    public AbsComponent createComponent(String str, BaseBusinessContext baseBusinessContext, SidebarItem sidebarItem, String str2) {
        for (Class next : f37192a) {
            ComponentType componentType = (ComponentType) next.getAnnotation(ComponentType.class);
            if (componentType != null) {
                String name = componentType.name();
                if (TextUtils.equals(str, name)) {
                    try {
                        Logger logger = this.f37193b;
                        logger.debug("begin create component type = " + str + ",name = " + name, new Object[0]);
                        AbsComponent absComponent = (AbsComponent) next.getConstructor(new Class[]{BaseBusinessContext.class, SidebarItem.class, String.class}).newInstance(new Object[]{baseBusinessContext, sidebarItem, str2});
                        Logger logger2 = this.f37193b;
                        logger2.debug("finish create component type = " + str + ",name = " + name, new Object[0]);
                        return absComponent;
                    } catch (Exception e) {
                        Logger logger3 = this.f37193b;
                        logger3.debug("Exception create component type = " + str + ",name = " + name + ",e = " + e + ",msg = " + e.getMessage(), new Object[0]);
                        throw new RuntimeException(e);
                    }
                }
            }
        }
        return null;
    }
}
