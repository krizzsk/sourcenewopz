package com.iproov.sdk.core;

import android.content.Context;
import android.opengl.GLES20;
import android.os.Build;
import android.os.Debug;
import android.provider.Settings;
import com.iproov.sdk.logging.IPLog;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Method;

/* renamed from: com.iproov.sdk.core.break */
/* compiled from: IntrusionDetector */
public class C19798break {

    /* renamed from: a */
    private final C19899native f54088a;

    /* renamed from: b */
    private boolean f54089b = false;

    /* renamed from: c */
    private Method f54090c = null;

    /* renamed from: com.iproov.sdk.core.break$do */
    /* compiled from: IntrusionDetector */
    enum C19799do {
        AND15,
        AND16,
        AND17,
        AND18,
        AND19
    }

    public C19798break(Context context) {
        this.f54088a = new C19899native(context);
        C19797b.m38873a();
        C19909while.f54344a.clear();
        m38882c(C19799do.AND15);
        m38880b(context, C19799do.AND16);
        m38878a(context, C19799do.AND17);
        m38881b(C19799do.AND18);
        m38879a(C19799do.AND19);
    }

    /* renamed from: a */
    private void m38878a(Context context, C19799do doVar) {
        C19909while.m39264do(C19898import.AND9);
        C19797b.m38874a(doVar, Boolean.valueOf((context.getApplicationContext().getApplicationInfo().flags & 2) != 0));
    }

    /* renamed from: a */
    private void m38879a(C19799do doVar) {
        if (NativeLibraryLoader.f54084a) {
            try {
                C19907throw.f54343do = new NativeLibraryLoader().performance();
                C19909while.m39264do(C19898import.AND13);
                int i = C19907throw.f54343do;
                boolean z = true;
                if (i != 1) {
                    if (i != 2) {
                        z = false;
                    }
                }
                C19797b.m38874a(doVar, Boolean.valueOf(z));
            } catch (UnsatisfiedLinkError unused) {
                IPLog.m39305w("NativeLib", "Not loaded");
            }
        }
    }

    /* renamed from: c */
    private void m38882c(C19799do doVar) {
        C19909while.m39264do(C19898import.AND11);
        C19797b.m38874a(doVar, Boolean.valueOf(this.f54088a.m47536this()));
    }

    /* renamed from: b */
    private void m38880b(Context context, C19799do doVar) {
        boolean z;
        Settings.System.getString(context.getContentResolver(), "android_id");
        C19909while.m39264do(C19898import.AND12);
        String str = Build.FINGERPRINT;
        if ((!str.startsWith(C19802catch.m38967b()) || !str.endsWith(C19802catch.m39020c()) || !Build.MANUFACTURER.equals(C19802catch.m39042d()) || !Build.PRODUCT.startsWith(C19802catch.m39043e()) || !Build.BRAND.equals(C19802catch.m39044f()) || !Build.MODEL.startsWith(C19802catch.m39043e())) && !str.startsWith(C19802catch.m39045g()) && !str.startsWith(C19802catch.m39046h())) {
            String str2 = Build.MODEL;
            if (!str2.contains(C19802catch.m39047i()) && !str2.contains(C19802catch.m39048j()) && !str2.contains(C19802catch.m39049k()) && !Build.MANUFACTURER.contains(C19802catch.m39050l()) && !Build.HOST.equals(C19802catch.m39051m()) && ((!Build.BRAND.startsWith(C19802catch.m39045g()) || !Build.DEVICE.startsWith(C19802catch.m39045g())) && !Build.PRODUCT.equals(C19802catch.m39047i()) && !m38877a(C19802catch.m39052n(), "").equals("1") && !C19802catch.m39053o().equals(GLES20.glGetString(7937)))) {
                z = false;
                C19797b.m38874a(doVar, Boolean.valueOf(z));
            }
        }
        z = true;
        C19797b.m38874a(doVar, Boolean.valueOf(z));
    }

    /* renamed from: b */
    private void m38881b(C19799do doVar) {
        C19909while.m39264do(C19898import.AND10);
        C19797b.m38874a(doVar, Boolean.valueOf(Debug.isDebuggerConnected()));
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [java.lang.Process, java.lang.Object, java.lang.reflect.Method] */
    /* renamed from: a */
    private String m38877a(String str, String str2) {
        ? r3 = 0;
        if (!this.f54089b) {
            try {
                if (this.f54090c == null) {
                    this.f54090c = Class.forName(C19802catch.m39054p()).getMethod(C19802catch.m39056r(), new Class[]{String.class, String.class});
                }
                String str3 = (String) this.f54090c.invoke(r3, new Object[]{str, ""});
                return str3 == null ? str2 : str3;
            } catch (Exception unused) {
                this.f54090c = r3;
                this.f54089b = true;
            }
        }
        try {
            Process exec = Runtime.getRuntime().exec(String.format(C19802catch.m39055q(), new Object[]{str, str2}));
            String readLine = new BufferedReader(new InputStreamReader(exec.getInputStream())).readLine();
            exec.destroy();
            return readLine;
        } catch (IOException unused2) {
            if (r3 != 0) {
                r3.destroy();
            }
            return str2;
        } catch (Throwable th) {
            if (r3 != 0) {
                r3.destroy();
            }
            throw th;
        }
    }
}
