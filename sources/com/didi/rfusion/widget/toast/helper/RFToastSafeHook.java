package com.didi.rfusion.widget.toast.helper;

import android.os.Handler;
import android.os.Message;
import android.widget.Toast;
import java.lang.reflect.Field;

public class RFToastSafeHook {

    /* renamed from: a */
    private static Field f34012a;

    /* renamed from: b */
    private static Field f34013b;

    static {
        try {
            Field declaredField = Toast.class.getDeclaredField("mTN");
            f34012a = declaredField;
            declaredField.setAccessible(true);
            Field declaredField2 = f34012a.getType().getDeclaredField("mHandler");
            f34013b = declaredField2;
            declaredField2.setAccessible(true);
        } catch (Exception unused) {
        }
    }

    public static void makeSafe(Toast toast) {
        try {
            Object obj = f34012a.get(toast);
            f34013b.set(obj, new SafeHandler((Handler) f34013b.get(obj)));
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    static class SafeHandler extends Handler {
        private Handler impl;

        SafeHandler(Handler handler) {
            this.impl = handler;
        }

        public void handleMessage(Message message) {
            this.impl.handleMessage(message);
        }

        public void dispatchMessage(Message message) {
            try {
                this.impl.dispatchMessage(message);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
