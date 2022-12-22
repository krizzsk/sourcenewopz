package com.appsflyer.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;
import com.didi.hawaii.mapsdk.gesture.NNGestureClassfy;
import com.didi.unifylogin.utils.LoginOmegaUtil;

/* renamed from: com.appsflyer.internal.b */
public final class C1689b {

    /* renamed from: ı */
    private IntentFilter f1948 = new IntentFilter("android.intent.action.BATTERY_CHANGED");

    /* renamed from: com.appsflyer.internal.b$e */
    public static final class C1691e {

        /* renamed from: ı */
        public static final C1689b f1951 = new C1689b();
    }

    C1689b() {
    }

    /* renamed from: Ι */
    public final C1690d mo16135(Context context) {
        Intent intent;
        String str = null;
        float f = 0.0f;
        try {
            intent = context.registerReceiver((BroadcastReceiver) null, this.f1948);
        } catch (Exception e) {
            Log.d("Context", "registerReceiver", e);
            intent = null;
        } catch (Throwable unused) {
        }
        if (intent != null) {
            if (2 == intent.getIntExtra("status", -1)) {
                int intExtra = intent.getIntExtra("plugged", -1);
                str = intExtra != 1 ? intExtra != 2 ? intExtra != 4 ? "other" : "wireless" : "usb" : "ac";
            } else {
                str = LoginOmegaUtil.NO_EMAIL;
            }
            int intExtra2 = intent.getIntExtra("level", -1);
            int intExtra3 = intent.getIntExtra(NNGestureClassfy.SCALE_LABLE, -1);
            if (!(-1 == intExtra2 || -1 == intExtra3)) {
                f = (((float) intExtra2) * 100.0f) / ((float) intExtra3);
            }
        }
        return new C1690d(f, str);
    }

    /* renamed from: com.appsflyer.internal.b$d */
    public static final class C1690d {

        /* renamed from: ı */
        public final float f1949;

        /* renamed from: Ι */
        public final String f1950;

        C1690d(float f, String str) {
            this.f1949 = f;
            this.f1950 = str;
        }
    }
}
