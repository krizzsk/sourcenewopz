package com.didi.component.never.core.util;

import com.didi.component.never.core.ComponentProxy;
import com.didi.component.never.core.IComponent;
import com.didi.component.never.core.container.ContainerComponent;
import com.didi.component.never.core.node.Node;
import com.didi.component.never.core.proxy.ProxyMap;
import com.didi.component_processor.annonation.ModuleMap;
import java.lang.reflect.InvocationTargetException;

public class FrameworkRegister {

    /* renamed from: a */
    private static final String f14677a = "com.didi.component.auto.ComponentMapStore";

    public static Class<? extends IComponent> getChildComponentClass(String str) {
        try {
            return ModuleMap.getChildComponent(str);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Class<? extends IComponent> getStandardComponentClass(String str) {
        try {
            return ModuleMap.getStandardComponent(str);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Class<? extends ContainerComponent> getContainerComponentClass(String str) {
        try {
            return ModuleMap.getContainer(str);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Class<? extends Node> getNode(String str) {
        try {
            return ModuleMap.getNode(str);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void addComponentProxy(String str, Class<? extends ComponentProxy> cls) {
        ProxyMap.addProxy(str, cls);
    }

    public static void init() {
        try {
            Class.forName(f14677a).getMethod("addMap", new Class[0]).invoke((Object) null, new Object[0]);
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
