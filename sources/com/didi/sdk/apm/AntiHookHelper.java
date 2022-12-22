package com.didi.sdk.apm;

import android.content.Context;
import android.os.Process;
import android.util.Base64;
import com.didi.sdk.apm.utils.BackgroundThread;
import com.didi.sdk.apm.utils.EventReporter;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class AntiHookHelper {
    public static void init(final Context context) {
        BackgroundThread.getHandler().post(new Runnable() {
            public void run() {
                AntiHookHelper.m24684b(context);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static void m24684b(Context context) {
        try {
            throw new Exception("test");
        } catch (Exception e) {
            for (StackTraceElement className : e.getStackTrace()) {
                if (className.getClassName().contains(m24681a("tn9soBeBIUD5xLyH"))) {
                    EventReporter.trackError("xpsd_hook", "hook", "xpsd hook");
                    return;
                }
            }
        }
    }

    /* renamed from: a */
    private static void m24682a() {
        Process.killProcess(Process.myPid());
        System.exit(10);
    }

    /* renamed from: a */
    private static String m24681a(String str) {
        try {
            Cipher instance = Cipher.getInstance("ARCFOUR");
            instance.init(2, new SecretKeySpec("7KmQl69ppyKyr12G".getBytes(), "ARCFOUR"));
            instance.init(2, new SecretKeySpec(instance.doFinal(Base64.decode("WaIJAodjoBWhQ0H+y4QRCQ==", 0)), "ARCFOUR"));
            return new String(instance.doFinal(Base64.decode(str, 0)));
        } catch (Exception unused) {
            return "";
        }
    }
}
