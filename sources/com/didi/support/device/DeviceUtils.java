package com.didi.support.device;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Build;
import android.text.TextUtils;
import com.didichuxing.diface.logger.DiFaceLogger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public class DeviceUtils {
    public static final String IMEI = "imei_";
    public static final String KEY_DEVICE_ID = "DeviceId";

    /* renamed from: a */
    private static AtomicBoolean f17684a = new AtomicBoolean(false);
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static Context f17685b;

    /* renamed from: c */
    private static Map<String, Object> f17686c = new ConcurrentHashMap();

    /* renamed from: d */
    private static final List<CustomIdSupplier> f17687d = new ArrayList();

    public interface CustomIdSupplier {
        String getCustomId();
    }

    public static synchronized void init(Context context) {
        synchronized (DeviceUtils.class) {
            if (!f17684a.getAndSet(true)) {
                Objects.requireNonNull(context);
                Context applicationContext = context.getApplicationContext();
                f17685b = applicationContext;
                if (applicationContext != null) {
                    context = applicationContext;
                }
                f17685b = context;
                AsyncTask.THREAD_POOL_EXECUTOR.execute(new Runnable() {
                    public void run() {
                        DeviceUtils.getDeviceId(DeviceUtils.f17685b);
                    }
                });
            }
        }
    }

    public static void addCustomIdSupplier(CustomIdSupplier customIdSupplier) {
        if (customIdSupplier != null) {
            synchronized (f17687d) {
                f17687d.add(customIdSupplier);
            }
        }
    }

    public static synchronized String getDeviceId() {
        String deviceId;
        synchronized (DeviceUtils.class) {
            if (f17684a.get()) {
                deviceId = getDeviceId(f17685b);
            } else {
                throw new IllegalStateException("Init not called");
            }
        }
        return deviceId;
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:52:0x00d0 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized java.lang.String getDeviceId(android.content.Context r5) {
        /*
            java.lang.Class<com.didi.support.device.DeviceUtils> r0 = com.didi.support.device.DeviceUtils.class
            monitor-enter(r0)
            java.util.Objects.requireNonNull(r5)     // Catch:{ all -> 0x00eb }
            java.lang.String r1 = "DeviceId"
            java.lang.Object r1 = m13171b(r1)     // Catch:{ all -> 0x00eb }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ all -> 0x00eb }
            if (r1 == 0) goto L_0x0012
            monitor-exit(r0)
            return r1
        L_0x0012:
            android.content.SharedPreferences r1 = com.didi.sdk.apm.SystemUtils.getDefaultSharedPreferences(r5)     // Catch:{ all -> 0x00eb }
            java.lang.String r2 = "imei_"
            r3 = 0
            java.lang.String r2 = r1.getString(r2, r3)     // Catch:{ all -> 0x00eb }
            if (r2 == 0) goto L_0x002c
            boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x00eb }
            if (r3 != 0) goto L_0x002c
            java.lang.String r5 = "DeviceId"
            m13167a(r5, r2)     // Catch:{ all -> 0x00eb }
            monitor-exit(r0)
            return r2
        L_0x002c:
            java.lang.String r3 = "android.permission.READ_PHONE_STATE"
            int r3 = androidx.core.content.PermissionChecker.checkCallingOrSelfPermission(r5, r3)     // Catch:{ all -> 0x00eb }
            if (r3 != 0) goto L_0x004a
            int r3 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x00eb }
            r4 = 28
            if (r3 > r4) goto L_0x004a
            java.lang.String r3 = "phone"
            java.lang.Object r3 = r5.getSystemService(r3)     // Catch:{ Exception -> 0x0049 }
            android.telephony.TelephonyManager r3 = (android.telephony.TelephonyManager) r3     // Catch:{ Exception -> 0x0049 }
            if (r3 == 0) goto L_0x004a
            java.lang.String r2 = r3.getDeviceId()     // Catch:{ Exception -> 0x0049 }
            goto L_0x004a
        L_0x0049:
        L_0x004a:
            if (r2 == 0) goto L_0x0069
            boolean r3 = m13169a(r2)     // Catch:{ all -> 0x00eb }
            if (r3 == 0) goto L_0x0069
            android.content.SharedPreferences$Editor r5 = r1.edit()     // Catch:{ all -> 0x00eb }
            java.lang.String r1 = "imei_"
            android.content.SharedPreferences$Editor r5 = r5.putString(r1, r2)     // Catch:{ all -> 0x00eb }
            r5.apply()     // Catch:{ all -> 0x00eb }
            java.lang.String r5 = "DeviceId"
            java.lang.Object r5 = m13167a(r5, r2)     // Catch:{ all -> 0x00eb }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ all -> 0x00eb }
            monitor-exit(r0)
            return r5
        L_0x0069:
            java.util.List<com.didi.support.device.DeviceUtils$CustomIdSupplier> r2 = f17687d     // Catch:{ all -> 0x00eb }
            boolean r2 = r2.isEmpty()     // Catch:{ all -> 0x00eb }
            if (r2 != 0) goto L_0x00a9
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch:{ all -> 0x00eb }
            java.util.List<com.didi.support.device.DeviceUtils$CustomIdSupplier> r3 = f17687d     // Catch:{ all -> 0x00eb }
            r2.<init>(r3)     // Catch:{ all -> 0x00eb }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ all -> 0x00eb }
        L_0x007c:
            boolean r3 = r2.hasNext()     // Catch:{ all -> 0x00eb }
            if (r3 == 0) goto L_0x00a9
            java.lang.Object r3 = r2.next()     // Catch:{ all -> 0x00eb }
            com.didi.support.device.DeviceUtils$CustomIdSupplier r3 = (com.didi.support.device.DeviceUtils.CustomIdSupplier) r3     // Catch:{ all -> 0x00eb }
            java.lang.String r3 = r3.getCustomId()     // Catch:{ all -> 0x00eb }
            boolean r4 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x00eb }
            if (r4 != 0) goto L_0x007c
            android.content.SharedPreferences$Editor r5 = r1.edit()     // Catch:{ all -> 0x00eb }
            java.lang.String r1 = "imei_"
            android.content.SharedPreferences$Editor r5 = r5.putString(r1, r3)     // Catch:{ all -> 0x00eb }
            r5.apply()     // Catch:{ all -> 0x00eb }
            java.lang.String r5 = "DeviceId"
            java.lang.Object r5 = m13167a(r5, r3)     // Catch:{ all -> 0x00eb }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ all -> 0x00eb }
            monitor-exit(r0)
            return r5
        L_0x00a9:
            android.content.ContentResolver r5 = r5.getContentResolver()     // Catch:{ Exception -> 0x00d0 }
            java.lang.String r2 = "android_id"
            java.lang.String r5 = android.provider.Settings.Secure.getString(r5, r2)     // Catch:{ Exception -> 0x00d0 }
            boolean r2 = android.text.TextUtils.isEmpty(r5)     // Catch:{ Exception -> 0x00d0 }
            if (r2 == 0) goto L_0x00d0
            android.content.SharedPreferences$Editor r2 = r1.edit()     // Catch:{ Exception -> 0x00d0 }
            java.lang.String r3 = "imei_"
            android.content.SharedPreferences$Editor r2 = r2.putString(r3, r5)     // Catch:{ Exception -> 0x00d0 }
            r2.apply()     // Catch:{ Exception -> 0x00d0 }
            java.lang.String r2 = "DeviceId"
            java.lang.Object r5 = m13167a(r2, r5)     // Catch:{ Exception -> 0x00d0 }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ Exception -> 0x00d0 }
            monitor-exit(r0)
            return r5
        L_0x00d0:
            java.lang.String r5 = m13168a()     // Catch:{ all -> 0x00eb }
            android.content.SharedPreferences$Editor r1 = r1.edit()     // Catch:{ all -> 0x00eb }
            java.lang.String r2 = "imei_"
            android.content.SharedPreferences$Editor r1 = r1.putString(r2, r5)     // Catch:{ all -> 0x00eb }
            r1.apply()     // Catch:{ all -> 0x00eb }
            java.lang.String r1 = "DeviceId"
            java.lang.Object r5 = m13167a(r1, r5)     // Catch:{ all -> 0x00eb }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ all -> 0x00eb }
            monitor-exit(r0)
            return r5
        L_0x00eb:
            r5 = move-exception
            monitor-exit(r0)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.support.device.DeviceUtils.getDeviceId(android.content.Context):java.lang.String");
    }

    /* renamed from: b */
    private static <T> T m13171b(String str) {
        return f17686c.get(str);
    }

    /* renamed from: a */
    private static <T> T m13167a(String str, Object obj) {
        f17686c.put(str, obj);
        return obj;
    }

    /* renamed from: a */
    static boolean m13169a(String str) {
        if (TextUtils.isEmpty(str) || str.length() < 15 || str.equals("000000000000000")) {
            return false;
        }
        try {
            String substring = str.substring(14);
            char[] charArray = str.substring(0, 14).toCharArray();
            int i = 0;
            int i2 = 0;
            while (i < charArray.length) {
                int parseInt = Integer.parseInt(String.valueOf(charArray[i]));
                int i3 = i + 1;
                int parseInt2 = Integer.parseInt(String.valueOf(charArray[i3])) * 2;
                if (parseInt2 >= 10) {
                    parseInt2 -= 9;
                }
                i2 += parseInt + parseInt2;
                i = i3 + 1;
            }
            int i4 = i2 % 10;
            return TextUtils.equals(String.valueOf(i4 == 0 ? 0 : 10 - i4), substring);
        } catch (NumberFormatException unused) {
            return false;
        }
    }

    /* renamed from: a */
    static String m13168a() {
        return DiFaceLogger.EVENT_ID_APPEAL_DATA_SUBMIT_CONFIRM_VIDEO_NO + (Build.BOARD.length() % 10) + (Build.BRAND.length() % 10) + (Build.CPU_ABI.length() % 10) + (Build.DEVICE.length() % 10) + (Build.DISPLAY.length() % 10) + (Build.HOST.length() % 10) + (Build.ID.length() % 10) + (Build.MANUFACTURER.length() % 10) + (Build.MODEL.length() % 10) + (Build.PRODUCT.length() % 10) + (Build.TAGS.length() % 10) + (Build.TYPE.length() % 10) + (Build.USER.length() % 10);
    }
}
