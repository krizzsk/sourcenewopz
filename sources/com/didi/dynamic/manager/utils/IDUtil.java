package com.didi.dynamic.manager.utils;

import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.didichuxing.diface.logger.DiFaceLogger;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;

public class IDUtil {

    /* renamed from: a */
    private static boolean f19358a;

    /* renamed from: b */
    private static String f19359b;

    /* renamed from: c */
    private static String f19360c;

    public static String getUUID(Context context) {
        if (!TextUtils.isEmpty(f19360c)) {
            return f19360c;
        }
        String uuid = DownloadUtil.getUUID(context);
        f19360c = uuid;
        if (!TextUtils.isEmpty(uuid)) {
            return f19360c;
        }
        String androidID = getAndroidID(context);
        String cPUSerialno = getCPUSerialno();
        String md5 = MD5.toMD5("1_" + androidID + "2_" + getIMEI(context) + "3_" + cPUSerialno);
        f19360c = md5;
        DownloadUtil.setUUID(context, md5);
        return f19360c;
    }

    public static String getAndroidID(Context context) {
        return Settings.Secure.getString(context.getContentResolver(), "android_id");
    }

    public static String getCPUSerialno() {
        if (!isEmpty(f19359b)) {
            return f19359b;
        }
        String str = "";
        if (f19358a) {
            f19359b = str;
            return str;
        }
        try {
            f19358a = true;
            Process exec = Runtime.getRuntime().exec("cat /proc/cpuinfo");
            if (exec == null) {
                return null;
            }
            LineNumberReader lineNumberReader = new LineNumberReader(new InputStreamReader(exec.getInputStream()));
            while (true) {
                if (str != null) {
                    str = lineNumberReader.readLine();
                    if (str != null) {
                        f19359b = str.trim();
                        break;
                    }
                } else {
                    break;
                }
            }
            return f19359b;
        } catch (IOException e) {
            Log.m14494w("System.err", (Throwable) e);
        }
    }

    public static boolean isEmpty(String str) {
        return str == null || str.length() <= 0;
    }

    public static String getIMEI(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        String str = "";
        if (telephonyManager != null) {
            try {
                str = telephonyManager.getDeviceId();
            } catch (Throwable th) {
                Log.m14487e("SystemUtil", str, th);
            }
        }
        if (str == null || str.length() == 0 || str.equals("null")) {
            str = DiFaceLogger.EVENT_ID_APPEAL_DATA_SUBMIT_CONFIRM_VIDEO_NO + (Build.BOARD.length() % 10) + (Build.BRAND.length() % 10) + (Build.CPU_ABI.length() % 10) + (Build.DEVICE.length() % 10) + (Build.DISPLAY.length() % 10) + (Build.HOST.length() % 10) + (Build.ID.length() % 10) + (Build.MANUFACTURER.length() % 10) + (Build.MODEL.length() % 10) + (Build.PRODUCT.length() % 10) + (Build.TAGS.length() % 10) + (Build.TYPE.length() % 10) + (Build.USER.length() % 10);
        }
        return str + m14481a();
    }

    /* renamed from: a */
    private static final String m14481a() {
        return Long.valueOf(new File("/system/build.prop").lastModified()).toString();
    }
}
