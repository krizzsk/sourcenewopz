package com.xiaojuchefu.prism.monitor.core;

import android.content.Context;
import java.lang.reflect.Field;
import java.util.List;

public class GlobalWindowManager {

    /* renamed from: a */
    private static GlobalWindowManager f56094a;

    /* renamed from: b */
    private final WindowObserver f56095b = new WindowObserver();

    /* renamed from: c */
    private boolean f56096c;

    public static GlobalWindowManager getInstance() {
        GlobalWindowManager globalWindowManager;
        synchronized (GlobalWindowManager.class) {
            if (f56094a == null) {
                f56094a = new GlobalWindowManager();
            }
            globalWindowManager = f56094a;
        }
        return globalWindowManager;
    }

    private GlobalWindowManager() {
    }

    public void init(Context context) {
        if (!this.f56096c) {
            this.f56096c = true;
            m40387a(context);
        }
    }

    public WindowObserver getWindowObserver() {
        return this.f56095b;
    }

    /* renamed from: a */
    private void m40387a(Context context) {
        try {
            Object systemService = context.getSystemService("window");
            Field declaredField = systemService.getClass().getDeclaredField("mGlobal");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(systemService);
            Field declaredField2 = obj.getClass().getDeclaredField("mViews");
            declaredField2.setAccessible(true);
            if (declaredField2.get(obj) instanceof List) {
                this.f56095b.addAll((List) declaredField2.get(obj));
                declaredField2.set(obj, this.f56095b);
            }
        } catch (IllegalAccessException | NoSuchFieldException unused) {
        }
    }
}
