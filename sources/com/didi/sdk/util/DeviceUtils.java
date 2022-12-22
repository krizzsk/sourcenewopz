package com.didi.sdk.util;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.didi.security.wireless.SecurityController;
import com.google.common.base.Ascii;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.concurrent.atomic.AtomicBoolean;
import org.apache.commons.codec2.digest.MessageDigestAlgorithms;

public class DeviceUtils {
    public static final String IMEI = "imei_";

    /* renamed from: a */
    private static AtomicBoolean f37586a = new AtomicBoolean(false);
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static Context f37587b;

    /* renamed from: c */
    private static String f37588c;

    public static void init(Context context) {
        if (!f37586a.getAndSet(true)) {
            m26682a(context);
            f37587b = context;
            SecurityController.getInstance().post((Runnable) new Runnable() {
                public void run() {
                    DeviceUtils.getDeviceId(DeviceUtils.f37587b);
                }
            });
        }
    }

    public static synchronized String getDeviceId() {
        String deviceId;
        synchronized (DeviceUtils.class) {
            if (f37586a.get()) {
                deviceId = getDeviceId(f37587b);
            } else {
                throw new IllegalStateException("Init not called");
            }
        }
        return deviceId;
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x0065  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized java.lang.String getDeviceId(android.content.Context r5) {
        /*
            java.lang.Class<com.didi.sdk.util.DeviceUtils> r0 = com.didi.sdk.util.DeviceUtils.class
            monitor-enter(r0)
            m26682a(r5)     // Catch:{ all -> 0x0081 }
            java.lang.String r1 = f37588c     // Catch:{ all -> 0x0081 }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x0081 }
            if (r1 != 0) goto L_0x0012
            java.lang.String r5 = f37588c     // Catch:{ all -> 0x0081 }
            monitor-exit(r0)
            return r5
        L_0x0012:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0081 }
            r1.<init>()     // Catch:{ all -> 0x0081 }
            java.lang.String r2 = r5.getPackageName()     // Catch:{ all -> 0x0081 }
            r1.append(r2)     // Catch:{ all -> 0x0081 }
            java.lang.String r2 = "_preferences"
            r1.append(r2)     // Catch:{ all -> 0x0081 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0081 }
            r2 = 0
            android.content.SharedPreferences r1 = com.didi.sdk.apm.SystemUtils.getSharedPreferences(r5, r1, r2)     // Catch:{ all -> 0x0081 }
            java.lang.String r2 = "imei_"
            r3 = 0
            r4 = r3
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ all -> 0x0081 }
            java.lang.String r2 = r1.getString(r2, r4)     // Catch:{ all -> 0x0081 }
            boolean r4 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x0081 }
            if (r4 != 0) goto L_0x0040
            f37588c = r2     // Catch:{ all -> 0x0081 }
            monitor-exit(r0)
            return r2
        L_0x0040:
            int r2 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x0081 }
            r4 = 28
            if (r2 > r4) goto L_0x0066
            java.lang.String r2 = "android.permission.READ_PHONE_STATE"
            int r2 = r5.checkCallingOrSelfPermission(r2)     // Catch:{ all -> 0x0081 }
            if (r2 != 0) goto L_0x0066
            java.lang.String r2 = "phone"
            java.lang.Object r5 = r5.getSystemService(r2)     // Catch:{ Exception -> 0x005e }
            android.telephony.TelephonyManager r5 = (android.telephony.TelephonyManager) r5     // Catch:{ Exception -> 0x005e }
            if (r5 == 0) goto L_0x005e
            java.lang.String r5 = r5.getDeviceId()     // Catch:{ Exception -> 0x005e }
            goto L_0x005f
        L_0x005e:
            r5 = r3
        L_0x005f:
            boolean r2 = m26684a((java.lang.String) r5)     // Catch:{ all -> 0x0081 }
            if (r2 == 0) goto L_0x0066
            r3 = r5
        L_0x0066:
            boolean r5 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x0081 }
            if (r5 == 0) goto L_0x0070
            java.lang.String r3 = m26683a()     // Catch:{ all -> 0x0081 }
        L_0x0070:
            android.content.SharedPreferences$Editor r5 = r1.edit()     // Catch:{ all -> 0x0081 }
            java.lang.String r1 = "imei_"
            android.content.SharedPreferences$Editor r5 = r5.putString(r1, r3)     // Catch:{ all -> 0x0081 }
            r5.apply()     // Catch:{ all -> 0x0081 }
            f37588c = r3     // Catch:{ all -> 0x0081 }
            monitor-exit(r0)
            return r3
        L_0x0081:
            r5 = move-exception
            monitor-exit(r0)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.sdk.util.DeviceUtils.getDeviceId(android.content.Context):java.lang.String");
    }

    /* renamed from: a */
    static boolean m26684a(String str) {
        boolean z = false;
        if (TextUtils.isEmpty(str) || str.length() < 15) {
            return false;
        }
        int i = 0;
        while (true) {
            if (i >= str.length() - 1) {
                z = true;
                break;
            }
            char charAt = str.charAt(i);
            i++;
            if (charAt != str.charAt(i)) {
                break;
            }
        }
        return !z;
    }

    /* renamed from: b */
    private static String m26686b(String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
            instance.update(str.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : instance.digest()) {
                sb.append(Integer.toHexString((b >> 4) & 15).toLowerCase());
                sb.append(Integer.toHexString(b & Ascii.f53593SI).toLowerCase());
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException unused) {
            return null;
        }
    }

    /* renamed from: a */
    static String m26683a() {
        SecureRandom secureRandom = new SecureRandom();
        return m26686b(Build.BRAND + Build.MODEL + Build.FINGERPRINT + System.nanoTime() + secureRandom.nextLong());
    }

    /* renamed from: a */
    private static <T> T m26682a(T t) {
        if (t != null) {
            return t;
        }
        throw null;
    }
}
