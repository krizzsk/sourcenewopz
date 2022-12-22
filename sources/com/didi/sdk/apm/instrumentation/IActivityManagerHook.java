package com.didi.sdk.apm.instrumentation;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.util.Log;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\tB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\n"}, mo175978d2 = {"Lcom/didi/sdk/apm/instrumentation/IActivityManagerHook;", "", "()V", "TAG", "", "iActivityManagerHook", "", "context", "Landroid/content/Context;", "IActivityManagerProxy", "library_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: IActivityManagerHook.kt */
public final class IActivityManagerHook {
    public static final IActivityManagerHook INSTANCE = new IActivityManagerHook();

    /* renamed from: a */
    private static final String f35041a = "IActivityManagerHook";

    private IActivityManagerHook() {
    }

    public final void iActivityManagerHook(Context context) {
        Object obj;
        Intrinsics.checkParameterIsNotNull(context, "context");
        if (Build.VERSION.SDK_INT >= 24 && Build.VERSION.SDK_INT <= 28 && HookApolloHelper.m24761a(context)) {
            Log.w(f35041a, "IActivityManager hook ...");
            try {
                Class<?> cls = Class.forName("android.util.Singleton");
                Field[] declaredFields = ActivityManager.class.getDeclaredFields();
                int length = declaredFields.length;
                int i = 0;
                while (true) {
                    obj = null;
                    if (i >= length) {
                        break;
                    }
                    Field field = declaredFields[i];
                    Intrinsics.checkExpressionValueIsNotNull(field, "field");
                    if (Intrinsics.areEqual((Object) field.getType(), (Object) cls)) {
                        field.setAccessible(true);
                        obj = field.get((Object) null);
                        break;
                    }
                    i++;
                }
                if (obj == null) {
                    Log.w(f35041a, "Not found IActivityManagerSingleton field in class ActivityManager.");
                    return;
                }
                Field declaredField = cls.getDeclaredField("mInstance");
                Intrinsics.checkExpressionValueIsNotNull(declaredField, "instanceField");
                declaredField.setAccessible(true);
                Object obj2 = declaredField.get(obj);
                if (obj2 == null) {
                    Log.w(f35041a, "Not found IActivityManager instance.");
                    return;
                }
                IActivityManagerProxy iActivityManagerProxy = new IActivityManagerProxy(obj2);
                Class<?> cls2 = Class.forName("android.app.IActivityManager");
                Intrinsics.checkExpressionValueIsNotNull(cls2, "iActivityManagerCls");
                declaredField.set(obj, Proxy.newProxyInstance(cls2.getClassLoader(), new Class[]{cls2}, iActivityManagerProxy));
                Log.d(f35041a, "IActivityManager hook success.");
            } catch (Throwable th) {
                Log.w(f35041a, "IActivityManager hook fail: " + th);
            }
        }
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J4\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0010\u0010\t\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0003\u0018\u00010\nH\u0002¢\u0006\u0002\u0010\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, mo175978d2 = {"Lcom/didi/sdk/apm/instrumentation/IActivityManagerHook$IActivityManagerProxy;", "Ljava/lang/reflect/InvocationHandler;", "instance", "", "(Ljava/lang/Object;)V", "invoke", "proxy", "method", "Ljava/lang/reflect/Method;", "args", "", "(Ljava/lang/Object;Ljava/lang/reflect/Method;[Ljava/lang/Object;)Ljava/lang/Object;", "library_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
    /* compiled from: IActivityManagerHook.kt */
    private static final class IActivityManagerProxy implements InvocationHandler {
        private final Object instance;

        public IActivityManagerProxy(Object obj) {
            Intrinsics.checkParameterIsNotNull(obj, "instance");
            this.instance = obj;
        }

        public Object invoke(Object obj, Method method, Object[] objArr) {
            Intrinsics.checkParameterIsNotNull(method, "method");
            boolean z = false;
            if (Intrinsics.areEqual((Object) method.getName(), (Object) "isTopOfTask")) {
                Log.d(IActivityManagerHook.f35041a, "invoke: " + method.getName() + "()");
                try {
                    Object obj2 = this.instance;
                    if (objArr == null) {
                        objArr = new Object[0];
                    }
                    Object invoke = method.invoke(obj2, Arrays.copyOf(objArr, objArr.length));
                    if (invoke != null) {
                        boolean booleanValue = ((Boolean) invoke).booleanValue();
                        Log.d(IActivityManagerHook.f35041a, "isTopOfTask() invoke success");
                        z = booleanValue;
                        return Boolean.valueOf(z);
                    }
                    throw new TypeCastException("null cannot be cast to non-null type kotlin.Boolean");
                } catch (Exception e) {
                    Log.w(IActivityManagerHook.f35041a, "isTopOfTask() invoke exception: " + e);
                }
            } else {
                Object obj3 = this.instance;
                if (objArr == null) {
                    objArr = new Object[0];
                }
                return method.invoke(obj3, Arrays.copyOf(objArr, objArr.length));
            }
        }
    }
}
