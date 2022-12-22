package com.didichuxing.security.safecollector;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Build;
import android.text.TextUtils;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.diface.logger.DiFaceLogger;
import com.google.common.base.Ascii;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.concurrent.atomic.AtomicBoolean;
import org.apache.commons.codec2.digest.MessageDigestAlgorithms;

final class DeviceUtils {

    /* renamed from: a */
    public static final String f48984a = "imei_";

    /* renamed from: b */
    public static final String f48985b = "android_";

    /* renamed from: c */
    private static final String f48986c = "virtual_device_id_";

    /* renamed from: d */
    private static AtomicBoolean f48987d = new AtomicBoolean(false);
    /* access modifiers changed from: private */

    /* renamed from: e */
    public static Context f48988e;

    /* renamed from: f */
    private static String f48989f;

    /* renamed from: g */
    private static String f48990g;

    /* renamed from: h */
    private static CustomIdSupplier f48991h;

    public interface CustomIdSupplier {
        String getCustomId();
    }

    DeviceUtils() {
    }

    /* renamed from: a */
    public static void m35205a(Context context) {
        m35206a(context, true);
    }

    /* renamed from: a */
    public static void m35206a(Context context, boolean z) {
        if (!f48987d.getAndSet(true)) {
            m35203a(context);
            Context applicationContext = context.getApplicationContext();
            f48988e = applicationContext;
            if (applicationContext != null) {
                context = applicationContext;
            }
            f48988e = context;
            if (z) {
                AsyncTask.THREAD_POOL_EXECUTOR.execute(new Runnable() {
                    public void run() {
                        DeviceUtils.m35213c(DeviceUtils.f48988e);
                    }
                });
            }
        }
    }

    /* renamed from: a */
    public static synchronized void m35207a(CustomIdSupplier customIdSupplier) {
        synchronized (DeviceUtils.class) {
            f48991h = customIdSupplier;
        }
    }

    /* renamed from: a */
    public static synchronized String m35204a() {
        String c;
        synchronized (DeviceUtils.class) {
            if (f48987d.get()) {
                c = m35213c(f48988e);
            } else {
                throw new IllegalStateException("Init not called");
            }
        }
        return c;
    }

    /* renamed from: b */
    public static synchronized String m35210b(Context context) {
        synchronized (DeviceUtils.class) {
            if (!TextUtils.isEmpty(f48990g)) {
                String str = f48990g;
                return str;
            }
            SharedPreferences defaultSharedPreferences = SystemUtils.getDefaultSharedPreferences(context);
            String str2 = null;
            String string = defaultSharedPreferences.getString(f48985b, (String) null);
            if (!TextUtils.isEmpty(string)) {
                f48990g = string;
                return string;
            }
            if (TextUtils.isEmpty((CharSequence) null)) {
                str2 = m35214d(context);
            }
            defaultSharedPreferences.edit().putString(f48985b, str2).apply();
            f48990g = str2;
            return str2;
        }
    }

    /* renamed from: c */
    public static synchronized String m35213c(Context context) {
        synchronized (DeviceUtils.class) {
            m35203a(context);
            if (f48991h != null) {
                String customId = f48991h.getCustomId();
                return customId;
            } else if (!TextUtils.isEmpty(f48989f)) {
                String str = f48989f;
                return str;
            } else {
                SharedPreferences defaultSharedPreferences = SystemUtils.getDefaultSharedPreferences(context);
                String str2 = null;
                String string = defaultSharedPreferences.getString("imei_", (String) null);
                if (!TextUtils.isEmpty(string)) {
                    f48989f = string;
                    return string;
                }
                if (TextUtils.isEmpty((CharSequence) null)) {
                    str2 = m35214d(context);
                }
                defaultSharedPreferences.edit().putString("imei_", str2).apply();
                f48989f = str2;
                return str2;
            }
        }
    }

    /* renamed from: a */
    static boolean m35208a(String str) {
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
    private static String m35211b(String str) {
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

    /* renamed from: c */
    private static String m35212c() {
        SecureRandom secureRandom = new SecureRandom();
        String b = m35211b(Build.BRAND + Build.MODEL + Build.FINGERPRINT + System.nanoTime() + secureRandom.nextLong());
        if (!TextUtils.isEmpty(b)) {
            return b;
        }
        return DiFaceLogger.EVENT_ID_APPEAL_DATA_SUBMIT_CONFIRM_VIDEO_NO + (Build.BOARD.length() % 10) + (Build.BRAND.length() % 10) + (Build.CPU_ABI.length() % 10) + (Build.DEVICE.length() % 10) + (Build.DISPLAY.length() % 10) + (Build.HOST.length() % 10) + (Build.ID.length() % 10) + (Build.MANUFACTURER.length() % 10) + (Build.MODEL.length() % 10) + (Build.PRODUCT.length() % 10) + (Build.TAGS.length() % 10) + (Build.TYPE.length() % 10) + (Build.USER.length() % 10);
    }

    /* renamed from: d */
    private static String m35214d(Context context) {
        SharedPreferences defaultSharedPreferences = SystemUtils.getDefaultSharedPreferences(context);
        String string = defaultSharedPreferences.getString(f48986c, (String) null);
        if (!TextUtils.isEmpty(string)) {
            return string;
        }
        String c = m35212c();
        defaultSharedPreferences.edit().putString(f48986c, c).apply();
        return c;
    }

    /* renamed from: a */
    private static <T> T m35203a(T t) {
        if (t != null) {
            return t;
        }
        throw null;
    }
}
