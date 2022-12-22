package com.didi.dimina.container.p106ui.statusbar;

import android.app.Activity;
import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* renamed from: com.didi.dimina.container.ui.statusbar.f */
/* compiled from: SpecialBarFontUtils */
class C7686f {

    /* renamed from: a */
    private static Method f17791a;

    /* renamed from: b */
    private static Method f17792b;

    /* renamed from: c */
    private static Field f17793c;

    /* renamed from: d */
    private static int f17794d;

    /* renamed from: a */
    static int m13280a(int i) {
        return (((((i & 16711680) >> 16) * 38) + (((65280 & i) >> 8) * 75)) + ((i & 255) * 15)) >> 7;
    }

    C7686f() {
    }

    static {
        Class<Activity> cls = Activity.class;
        try {
            f17791a = cls.getMethod("setStatusBarDarkIcon", new Class[]{Integer.TYPE});
        } catch (NoSuchMethodException unused) {
        }
        Class<Activity> cls2 = Activity.class;
        try {
            f17792b = cls2.getMethod("setStatusBarDarkIcon", new Class[]{Boolean.TYPE});
        } catch (NoSuchMethodException unused2) {
        }
        try {
            f17793c = WindowManager.LayoutParams.class.getField("statusBarColor");
        } catch (NoSuchFieldException unused3) {
        }
        try {
            f17794d = View.class.getField("SYSTEM_UI_FLAG_LIGHT_STATUS_BAR").getInt((Object) null);
        } catch (IllegalAccessException | NoSuchFieldException unused4) {
        }
    }

    /* renamed from: a */
    static boolean m13288a(int i, int i2) {
        return m13280a(i) < i2;
    }

    /* renamed from: a */
    public static void m13281a(Activity activity, int i) {
        Method method = f17791a;
        if (method != null) {
            try {
                method.invoke(activity, new Object[]{Integer.valueOf(i)});
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e2) {
                e2.printStackTrace();
            }
        } else {
            boolean a = m13288a(i, 50);
            if (f17793c != null) {
                m13283a(activity, a, a);
                m13285a(activity.getWindow(), i);
                return;
            }
            m13282a(activity, a);
        }
    }

    /* renamed from: a */
    public static void m13285a(Window window, int i) {
        try {
            m13290b(window, i);
            if (Build.VERSION.SDK_INT > 22) {
                m13284a(window.getDecorView(), true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public static void m13282a(Activity activity, boolean z) {
        m13283a(activity, z, true);
    }

    /* renamed from: a */
    private static boolean m13289a(WindowManager.LayoutParams layoutParams, String str, boolean z) {
        try {
            Field declaredField = layoutParams.getClass().getDeclaredField(str);
            declaredField.setAccessible(true);
            int i = declaredField.getInt(layoutParams);
            Field declaredField2 = layoutParams.getClass().getDeclaredField("meizuFlags");
            declaredField2.setAccessible(true);
            int i2 = declaredField2.getInt(layoutParams);
            int i3 = z ? i | i2 : (~i) & i2;
            if (i2 == i3) {
                return false;
            }
            declaredField2.setInt(layoutParams, i3);
            return true;
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
            return false;
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
            return false;
        } catch (IllegalArgumentException e3) {
            e3.printStackTrace();
            return false;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    /* renamed from: a */
    private static void m13284a(View view, boolean z) {
        int i;
        int systemUiVisibility = view.getSystemUiVisibility();
        if (z) {
            i = f17794d | systemUiVisibility;
        } else {
            i = (~f17794d) & systemUiVisibility;
        }
        if (i != systemUiVisibility) {
            view.setSystemUiVisibility(i);
        }
    }

    /* renamed from: b */
    private static void m13290b(Window window, int i) {
        WindowManager.LayoutParams attributes = window.getAttributes();
        Field field = f17793c;
        if (field != null) {
            try {
                if (field.getInt(attributes) != i) {
                    f17793c.set(attributes, Integer.valueOf(i));
                    window.setAttributes(attributes);
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    public static void m13287a(Window window, boolean z) {
        if (Build.VERSION.SDK_INT < 23) {
            m13289a(window.getAttributes(), "MEIZU_FLAG_DARK_STATUS_BAR_ICON", z);
            return;
        }
        m13284a(window.getDecorView(), z);
        m13290b(window, 0);
    }

    /* renamed from: a */
    private static void m13283a(Activity activity, boolean z, boolean z2) {
        Method method = f17792b;
        if (method != null) {
            try {
                method.invoke(activity, new Object[]{Boolean.valueOf(z)});
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e2) {
                e2.printStackTrace();
            }
        } else if (z2) {
            m13287a(activity.getWindow(), z);
        }
    }

    /* renamed from: a */
    static void m13286a(Window window, String str, boolean z) {
        if (window != null) {
            Class<?> cls = window.getClass();
            try {
                Class<?> cls2 = Class.forName("android.view.MiuiWindowManager$LayoutParams");
                int i = cls2.getField(str).getInt(cls2);
                Method method = cls.getMethod("setExtraFlags", new Class[]{Integer.TYPE, Integer.TYPE});
                if (z) {
                    method.invoke(window, new Object[]{Integer.valueOf(i), Integer.valueOf(i)});
                    return;
                }
                method.invoke(window, new Object[]{0, Integer.valueOf(i)});
            } catch (Exception unused) {
            }
        }
    }
}
