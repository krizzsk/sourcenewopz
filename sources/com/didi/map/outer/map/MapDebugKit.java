package com.didi.map.outer.map;

import android.content.Context;
import global.didi.pay.newview.pix.IPixView;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MapDebugKit {
    public static void init(Context context, MapView mapView, MapOpenGL mapOpenGL) {
        try {
            Class<?> cls = Class.forName("map.debugview.MapDebugKit");
            if (cls != null) {
                m19924a(cls, IPixView.PAGE_STATUS_INIT, new Class[]{Context.class, MapView.class, MapOpenGL.class}, context, mapView, mapOpenGL);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    private static Object m19924a(Class<?> cls, String str, Class<?>[] clsArr, Object... objArr) {
        Method a = m19925a(cls, str, clsArr);
        if (a != null) {
            try {
                a.setAccessible(true);
                return a.invoke((Object) null, objArr);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
                return null;
            } catch (InvocationTargetException e2) {
                e2.printStackTrace();
                return null;
            }
        } else {
            System.err.println("Method is not exist");
            return null;
        }
    }

    /* renamed from: a */
    private static Method m19925a(Class<?> cls, String str, Class... clsArr) {
        Method method;
        try {
            method = cls.getDeclaredMethod(str, clsArr);
        } catch (NoSuchMethodException unused) {
            method = null;
        }
        if (method != null) {
            return method;
        }
        try {
            return cls.getMethod(str, clsArr);
        } catch (NoSuchMethodException unused2) {
            return method;
        }
    }
}
