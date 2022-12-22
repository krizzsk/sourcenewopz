package butterknife;

import android.app.Activity;
import android.app.Dialog;
import android.view.View;
import com.didi.sdk.apm.SystemUtils;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.LinkedHashMap;
import java.util.Map;

public final class ButterKnife {

    /* renamed from: a */
    static final Map<Class<?>, Constructor<? extends Unbinder>> f438a = new LinkedHashMap();

    /* renamed from: b */
    private static final String f439b = "ButterKnife";

    /* renamed from: c */
    private static boolean f440c = false;

    private ButterKnife() {
        throw new AssertionError("No instances.");
    }

    public static void setDebug(boolean z) {
        f440c = z;
    }

    public static Unbinder bind(Activity activity) {
        return bind((Object) activity, activity.getWindow().getDecorView());
    }

    public static Unbinder bind(View view) {
        return bind((Object) view, view);
    }

    public static Unbinder bind(Dialog dialog) {
        return bind((Object) dialog, dialog.getWindow().getDecorView());
    }

    public static Unbinder bind(Object obj, Activity activity) {
        return bind(obj, activity.getWindow().getDecorView());
    }

    public static Unbinder bind(Object obj, Dialog dialog) {
        return bind(obj, dialog.getWindow().getDecorView());
    }

    public static Unbinder bind(Object obj, View view) {
        Class<?> cls = obj.getClass();
        if (f440c) {
            SystemUtils.log(3, f439b, "Looking up binding for " + cls.getName(), (Throwable) null, "butterknife.ButterKnife", 161);
        }
        Constructor<? extends Unbinder> a = m951a(cls);
        if (a == null) {
            return Unbinder.EMPTY;
        }
        try {
            return (Unbinder) a.newInstance(new Object[]{obj, view});
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Unable to invoke " + a, e);
        } catch (InstantiationException e2) {
            throw new RuntimeException("Unable to invoke " + a, e2);
        } catch (InvocationTargetException e3) {
            Throwable cause = e3.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            } else if (cause instanceof Error) {
                throw ((Error) cause);
            } else {
                throw new RuntimeException("Unable to create binding instance.", cause);
            }
        }
    }

    /* renamed from: a */
    private static Constructor<? extends Unbinder> m951a(Class<?> cls) {
        Constructor<? extends Unbinder> constructor;
        Constructor<? extends Unbinder> constructor2 = f438a.get(cls);
        if (constructor2 != null || f438a.containsKey(cls)) {
            if (f440c) {
                SystemUtils.log(3, f439b, "HIT: Cached in binding map.", (Throwable) null, "butterknife.ButterKnife", 191);
            }
            return constructor2;
        }
        String name = cls.getName();
        if (!name.startsWith("android.") && !name.startsWith("java.") && !name.startsWith("androidx.")) {
            try {
                ClassLoader classLoader = cls.getClassLoader();
                constructor = classLoader.loadClass(name + "_ViewBinding").getConstructor(new Class[]{cls, View.class});
                if (f440c) {
                    SystemUtils.log(3, f439b, "HIT: Loaded binding class and constructor.", (Throwable) null, "butterknife.ButterKnife", 204);
                }
            } catch (ClassNotFoundException unused) {
                if (f440c) {
                    SystemUtils.log(3, f439b, "Not found. Trying superclass " + cls.getSuperclass().getName(), (Throwable) null, "butterknife.ButterKnife", 206);
                }
                constructor = m951a(cls.getSuperclass());
            } catch (NoSuchMethodException e) {
                throw new RuntimeException("Unable to find binding constructor for " + name, e);
            }
            f438a.put(cls, constructor);
            return constructor;
        } else if (!f440c) {
            return null;
        } else {
            SystemUtils.log(3, f439b, "MISS: Reached framework class. Abandoning search.", (Throwable) null, "butterknife.ButterKnife", 197);
            return null;
        }
    }
}
