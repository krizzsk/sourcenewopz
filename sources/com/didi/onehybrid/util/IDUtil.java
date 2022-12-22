package com.didi.onehybrid.util;

import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.diface.logger.DiFaceLogger;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;

public class IDUtil {

    /* renamed from: a */
    private static boolean f29713a;

    /* renamed from: b */
    private static String f29714b;

    /* renamed from: c */
    private static String f29715c;

    public static String getUUID(Context context) {
        if (!TextUtils.isEmpty(f29715c)) {
            return f29715c;
        }
        String androidID = getAndroidID(context);
        String cPUSerialno = getCPUSerialno();
        String md5 = MD5.toMD5("1_" + androidID + "2_" + getIMEI(context) + "3_" + cPUSerialno);
        f29715c = md5;
        return md5;
    }

    public static String getAndroidID(Context context) {
        return Settings.Secure.getString(context.getContentResolver(), "android_id");
    }

    public static String getCPUSerialno() {
        if (!isEmpty(f29714b)) {
            return f29714b;
        }
        String str = "";
        if (f29713a) {
            f29714b = str;
            return str;
        }
        try {
            f29713a = true;
            Process exec = Runtime.getRuntime().exec("cat /proc/cpuinfo");
            if (exec == null) {
                return null;
            }
            LineNumberReader lineNumberReader = new LineNumberReader(new InputStreamReader(exec.getInputStream()));
            while (true) {
                if (str != null) {
                    str = lineNumberReader.readLine();
                    if (str != null) {
                        f29714b = str.trim();
                        break;
                    }
                } else {
                    break;
                }
            }
            return f29714b;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean isEmpty(String str) {
        return str == null || str.length() <= 0;
    }

    public static String getIMEI(Context context) {
        String str;
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (telephonyManager != null) {
            try {
                str = telephonyManager.getDeviceId();
            } catch (Throwable th) {
                SystemUtils.log(6, "SystemUtil", "", th, "com.didi.onehybrid.util.IDUtil", 99);
            }
            if (str == null || str.length() == 0 || str.equals("null")) {
                str = DiFaceLogger.EVENT_ID_APPEAL_DATA_SUBMIT_CONFIRM_VIDEO_NO + (Build.BOARD.length() % 10) + (Build.BRAND.length() % 10) + (Build.CPU_ABI.length() % 10) + (Build.DEVICE.length() % 10) + (Build.DISPLAY.length() % 10) + (Build.HOST.length() % 10) + (Build.ID.length() % 10) + (Build.MANUFACTURER.length() % 10) + (Build.MODEL.length() % 10) + (Build.PRODUCT.length() % 10) + (Build.TAGS.length() % 10) + (Build.TYPE.length() % 10) + (Build.USER.length() % 10);
            }
            return str + m20857a();
        }
        str = "";
        str = DiFaceLogger.EVENT_ID_APPEAL_DATA_SUBMIT_CONFIRM_VIDEO_NO + (Build.BOARD.length() % 10) + (Build.BRAND.length() % 10) + (Build.CPU_ABI.length() % 10) + (Build.DEVICE.length() % 10) + (Build.DISPLAY.length() % 10) + (Build.HOST.length() % 10) + (Build.ID.length() % 10) + (Build.MANUFACTURER.length() % 10) + (Build.MODEL.length() % 10) + (Build.PRODUCT.length() % 10) + (Build.TAGS.length() % 10) + (Build.TYPE.length() % 10) + (Build.USER.length() % 10);
        return str + m20857a();
    }

    /* renamed from: a */
    private static final String m20857a() {
        return Long.valueOf(new File("/system/build.prop").lastModified()).toString();
    }
}
