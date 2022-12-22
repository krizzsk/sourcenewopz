package com.microblink.blinkbarcode.secured;

import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.os.Build;
import com.microblink.blinkbarcode.util.Log;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;

/* compiled from: line */
class lIllIlIlIl {
    private static Constructor<?> IlIllIlIIl;
    private static Method IllIIIIllI;
    private static Constructor<?> IllIIIllII;
    private static Class<?> llIIIlllll;
    private static Constructor<?> llIIlIlIIl;

    static {
        Class<lIllIlIlIl> cls = lIllIlIlIl.class;
        if (Build.VERSION.SDK_INT >= 21) {
            try {
                Class<?> cls2 = Class.forName("android.hardware.camera2.utils.TypeReference");
                llIIIlllll = cls2;
                IllIIIIllI = cls2.getMethod("createSpecializedTypeReference", new Class[]{Type.class});
                llIIlIlIIl = CameraCharacteristics.Key.class.getDeclaredConstructor(new Class[]{String.class, llIIIlllll});
                IlIllIlIIl = CaptureRequest.Key.class.getDeclaredConstructor(new Class[]{String.class, llIIIlllll});
                IllIIIllII = CaptureResult.Key.class.getDeclaredConstructor(new Class[]{String.class, llIIIlllll});
            } catch (ClassNotFoundException e) {
                Log.m40230e(cls, e, "Failed to find desired class!", new Object[0]);
            } catch (NoSuchMethodException e2) {
                Log.m40230e(cls, e2, "Failed to find desired method!", new Object[0]);
            }
        }
    }

    public static <T> Object llIIlIlIIl(Object[] objArr) {
        Constructor<?> constructor;
        Class<lIllIlIlIl> cls = lIllIlIlIl.class;
        if (objArr.length >= 3) {
            String str = objArr[0];
            Type type = objArr[1];
            int intValue = objArr[2].intValue();
            Method method = IllIIIIllI;
            if (method == null) {
                Log.m40229e(cls, "Unable to invoke method createSpecializedTypeReference", new Object[0]);
                return null;
            }
            try {
                Object invoke = method.invoke((Object) null, new Object[]{type});
                if (intValue == 0) {
                    Constructor<?> constructor2 = llIIlIlIIl;
                    if (constructor2 == null) {
                        return null;
                    }
                    return constructor2.newInstance(new Object[]{str, invoke});
                } else if (intValue == 1) {
                    Constructor<?> constructor3 = IlIllIlIIl;
                    if (constructor3 == null) {
                        return null;
                    }
                    return constructor3.newInstance(new Object[]{str, invoke});
                } else if (intValue != 2 || (constructor = IllIIIllII) == null) {
                    return null;
                } else {
                    return constructor.newInstance(new Object[]{str, invoke});
                }
            } catch (IllegalAccessException | InstantiationException | InvocationTargetException e) {
                Log.m40230e(cls, e, "Failed to invoke reflection method!", new Object[0]);
                return null;
            }
        } else {
            throw new RuntimeException("Illegal arguments to createKey");
        }
    }
}
