package com.didichuxing.mas.sdk.quality.report.collector;

import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import android.webkit.WebSettings;
import com.datadog.android.core.internal.net.DataOkHttpUploader;
import com.didichuxing.diface.logger.DiFaceLogger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.apache.commons.codec2.digest.MessageDigestAlgorithms;

public class DeviceCollector {
    private static String androidId;
    private static String apolloKey;
    private static String ddfp;
    private static Boolean isDebug;
    private static Context mContext;

    public static void init(Context context) {
        mContext = context;
        syncIsDebug();
    }

    public static String getUserAgent() {
        if (Build.VERSION.SDK_INT < 17) {
            return System.getProperty(DataOkHttpUploader.SYSTEM_UA);
        }
        try {
            return WebSettings.getDefaultUserAgent(mContext);
        } catch (Exception unused) {
            return System.getProperty(DataOkHttpUploader.SYSTEM_UA);
        }
    }

    public static String getAndroidId() {
        if (TextUtils.isEmpty(androidId)) {
            try {
                androidId = Settings.Secure.getString(mContext.getContentResolver(), "android_id");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return androidId;
    }

    public static int getEmulatorType() {
        try {
            if (Build.FINGERPRINT.startsWith("generic")) {
                return 1;
            }
            if (Build.FINGERPRINT.toLowerCase().contains("vbox")) {
                return 2;
            }
            if (Build.FINGERPRINT.toLowerCase().contains("test-keys")) {
                return 3;
            }
            if (Build.MODEL.toLowerCase().equals("sdk")) {
                return 4;
            }
            if (Build.MODEL.toLowerCase().contains("google_sdk")) {
                return 5;
            }
            if (Build.MODEL.toLowerCase().contains("emulator")) {
                return 6;
            }
            if (Build.MODEL.toLowerCase().contains("android sdk built for x86")) {
                return 7;
            }
            if (Build.HARDWARE.toLowerCase().contains("goldfish")) {
                return 8;
            }
            if (Build.HOST.toLowerCase().contains("android-test")) {
                return 9;
            }
            if (Build.MANUFACTURER.toLowerCase().contains("genymotion")) {
                return 12;
            }
            if (Build.PRODUCT.toLowerCase().equals("google_sdk")) {
                return 13;
            }
            if (!Build.BRAND.startsWith("generic") || !Build.DEVICE.startsWith("generic")) {
                return "android".equals(NetworkCollector.getNetworkOperator()) ? 18 : 0;
            }
            return 14;
        } catch (Exception unused) {
            return 0;
        }
    }

    public static boolean isDebug() {
        Boolean bool = isDebug;
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public static void syncIsDebug() {
        try {
            if (isDebug == null) {
                isDebug = Boolean.valueOf((mContext.getApplicationInfo() == null || (mContext.getApplicationInfo().flags & 2) == 0) ? false : true);
            }
        } catch (Throwable unused) {
        }
    }

    public static String getDdfp() {
        if (!TextUtils.isEmpty(ddfp)) {
            return ddfp;
        }
        if (Build.VERSION.SDK_INT >= 29) {
            ddfp = getAndroidId();
        }
        if (TextUtils.isEmpty(ddfp) || "null".equalsIgnoreCase(ddfp)) {
            ddfp = getDdfpFromBuild();
        }
        return ddfp;
    }

    private static String getDdfpFromBuild() {
        return DiFaceLogger.EVENT_ID_APPEAL_DATA_SUBMIT_CONFIRM_VIDEO_NO + (Build.BOARD.length() % 10) + (Build.BRAND.length() % 10) + (Build.CPU_ABI.length() % 10) + (Build.DEVICE.length() % 10) + (Build.DISPLAY.length() % 10) + (Build.HOST.length() % 10) + (Build.ID.length() % 10) + (Build.MANUFACTURER.length() % 10) + (Build.MODEL.length() % 10) + (Build.PRODUCT.length() % 10) + (Build.TAGS.length() % 10) + (Build.TYPE.length() % 10) + (Build.USER.length() % 10);
    }

    public static String md5(String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
            instance.update(str.getBytes());
            byte[] digest = instance.digest();
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b : digest) {
                stringBuffer.append(Integer.toHexString(b & 255));
            }
            return stringBuffer.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static synchronized String getApolloKey() {
        String str;
        synchronized (DeviceCollector.class) {
            if (TextUtils.isEmpty(apolloKey)) {
                String ddfp2 = getDdfp();
                String str2 = Build.FINGERPRINT == null ? "" : Build.FINGERPRINT;
                String str3 = Build.DISPLAY == null ? "" : Build.DISPLAY;
                String str4 = Build.HARDWARE == null ? "" : Build.HARDWARE;
                String str5 = Build.BOARD == null ? "" : Build.BOARD;
                apolloKey = md5(ddfp2 + str2 + str3 + str4 + str5);
            }
            str = apolloKey;
        }
        return str;
    }
}
