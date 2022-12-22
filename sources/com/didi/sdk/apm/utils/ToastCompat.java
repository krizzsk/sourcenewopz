package com.didi.sdk.apm.utils;

import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.Toast;
import java.lang.reflect.Field;

public class ToastCompat {

    /* renamed from: a */
    private static final String f35073a = "ToastCompat";

    public static void showToast(Toast toast) {
        Log.d(f35073a, "ToastCompat.showToast");
        hookToast(toast).show();
    }

    public static Toast hookToast(Toast toast) {
        Object fieldValue;
        Object fieldValue2;
        Object fieldValue3;
        if (Build.VERSION.SDK_INT >= 21 && (fieldValue = getFieldValue(toast, "mTN")) != null && (((fieldValue2 = getFieldValue(fieldValue, "mHandler")) == null || !(fieldValue2 instanceof Handler) || !setFieldValue(fieldValue2, "mCallback", new InternalCallback((Handler) fieldValue2))) && (fieldValue3 = getFieldValue(fieldValue, "mShow")) != null && (fieldValue3 instanceof Runnable))) {
            setFieldValue(fieldValue3, "mShow", new InternalRunnable((Runnable) fieldValue3));
        }
        return toast;
    }

    public static Object getFieldValue(Object obj, String str) {
        Field field;
        try {
            field = obj.getClass().getDeclaredField(str);
        } catch (Throwable unused) {
            field = null;
        }
        if (field == null) {
            try {
                field = obj.getClass().getSuperclass().getDeclaredField(str);
            } catch (Throwable unused2) {
            }
        }
        if (field != null) {
            try {
                field.setAccessible(true);
                return field.get(obj);
            } catch (Throwable unused3) {
            }
        }
        return null;
    }

    public static boolean setFieldValue(Object obj, String str, Object obj2) {
        Field field;
        try {
            field = obj.getClass().getDeclaredField(str);
        } catch (Throwable unused) {
            field = null;
        }
        if (field == null) {
            try {
                field = obj.getClass().getSuperclass().getDeclaredField(str);
            } catch (Throwable unused2) {
            }
        }
        if (field == null) {
            return false;
        }
        try {
            field.setAccessible(true);
            field.set(obj, obj2);
            return true;
        } catch (Throwable unused3) {
            return false;
        }
    }

    public static final class InternalRunnable implements Runnable {
        final Runnable mRunnable;

        InternalRunnable(Runnable runnable) {
            this.mRunnable = runnable;
        }

        public void run() {
            try {
                this.mRunnable.run();
                Log.d(ToastCompat.f35073a, "InternalRunnable#run");
            } catch (Throwable unused) {
            }
        }
    }

    public static final class InternalCallback implements Handler.Callback {
        final Handler mHandler;

        InternalCallback(Handler handler) {
            this.mHandler = handler;
        }

        public boolean handleMessage(Message message) {
            try {
                this.mHandler.handleMessage(message);
                Log.d(ToastCompat.f35073a, "InternalCallback#handleMessage");
                return true;
            } catch (Throwable unused) {
                return true;
            }
        }
    }
}
