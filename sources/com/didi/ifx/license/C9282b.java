package com.didi.ifx.license;

import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.util.Base64;
import java.security.MessageDigest;
import java.util.Locale;

/* renamed from: com.didi.ifx.license.b */
/* compiled from: DeviceIdUtil */
class C9282b {
    C9282b() {
    }

    /* renamed from: a */
    static String m17452a(Context context) {
        String a;
        StringBuilder sb = new StringBuilder();
        String b = m17456b(context);
        String a2 = m17451a();
        String b2 = m17455b();
        if (b != null && b.length() > 0) {
            sb.append(b);
            sb.append("|");
        }
        if (a2 != null && a2.length() > 0) {
            sb.append(a2);
            sb.append("|");
        }
        if (b2 != null && b2.length() > 0) {
            sb.append(b2);
        }
        if (sb.length() <= 0 || (a = m17453a(m17454a(sb.toString()))) == null || a.length() <= 0) {
            return null;
        }
        return a;
    }

    /* renamed from: b */
    private static String m17456b(Context context) {
        try {
            return Settings.Secure.getString(context.getContentResolver(), "android_id");
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    /* renamed from: b */
    private static String m17455b() {
        try {
            return Base64.encodeToString(("3883756" + (Build.BOARD.length() % 10) + (Build.BRAND.length() % 10) + (Build.DEVICE.length() % 10) + (Build.HARDWARE.length() % 10) + (Build.ID.length() % 10) + (Build.MODEL.length() % 10) + (Build.PRODUCT.length() % 10) + (Build.SERIAL.length() % 10)).getBytes(), 0);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    /* renamed from: a */
    private static byte[] m17454a(String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance("SHA1");
            instance.reset();
            instance.update(str.getBytes("UTF-8"));
            return instance.digest();
        } catch (Exception unused) {
            return "".getBytes();
        }
    }

    /* renamed from: a */
    private static String m17453a(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bArr) {
            String hexString = Integer.toHexString(b & 255);
            if (hexString.length() == 1) {
                sb.append("0");
            }
            sb.append(hexString);
        }
        return sb.toString().toUpperCase(Locale.CHINA);
    }

    /* renamed from: a */
    private static String m17451a() {
        try {
            return Build.SERIAL;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}
