package com.didiglobal.ddmirror.monitor.core;

import android.content.Context;
import java.lang.reflect.Field;
import java.util.List;

public class GlobalWindowManager {
    private static GlobalWindowManager sGlobalWindowManager;
    private boolean mInitialized;
    private final WindowObserver mWindowObserver = new WindowObserver();

    public static GlobalWindowManager getInstance() {
        GlobalWindowManager globalWindowManager;
        synchronized (GlobalWindowManager.class) {
            if (sGlobalWindowManager == null) {
                sGlobalWindowManager = new GlobalWindowManager();
            }
            globalWindowManager = sGlobalWindowManager;
        }
        return globalWindowManager;
    }

    private GlobalWindowManager() {
    }

    public void init(Context context) {
        if (!this.mInitialized) {
            this.mInitialized = true;
            reflectProxyWindowManager(context);
        }
    }

    public WindowObserver getWindowObserver() {
        return this.mWindowObserver;
    }

    private void reflectProxyWindowManager(Context context) {
        try {
            Object systemService = context.getSystemService("window");
            Field declaredField = systemService.getClass().getDeclaredField("mGlobal");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(systemService);
            Field declaredField2 = obj.getClass().getDeclaredField("mViews");
            declaredField2.setAccessible(true);
            if (declaredField2.get(obj) instanceof List) {
                this.mWindowObserver.addAll((List) declaredField2.get(obj));
                declaredField2.set(obj, this.mWindowObserver);
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e2) {
            e2.printStackTrace();
        }
    }
}
