package com.didichuxing.apollo.sdk.utils;

import android.os.Build;
import android.text.TextUtils;
import com.didichuxing.apollo.sdk.log.LogUtils;
import com.didichuxing.diface.logger.DiFaceLogger;
import com.didichuxing.security.safecollector.WsgSecInfo;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.apache.commons.codec2.digest.MessageDigestAlgorithms;

public class Utils {

    /* renamed from: a */
    private static String f45656a;

    /* renamed from: b */
    private static String f45657b;

    /* renamed from: c */
    private static String f45658c;

    /* renamed from: d */
    private static String f45659d;

    /* renamed from: e */
    private static String f45660e;

    /* renamed from: f */
    private static String f45661f;

    public static String getOsType() {
        return "android";
    }

    public static String getOsVersion() {
        return WsgSecInfo.osVersion();
    }

    public static String getAndroidId() {
        if (TextUtils.isEmpty(f45658c)) {
            f45658c = WsgSecInfo.androidId();
        }
        return f45658c;
    }

    public static String getDdfp() {
        if (!TextUtils.isEmpty(f45656a)) {
            return f45656a;
        }
        if (Build.VERSION.SDK_INT >= 29) {
            f45656a = getAndroidId();
        }
        if (TextUtils.isEmpty(f45656a) || "null".equalsIgnoreCase(f45656a)) {
            f45656a = m32714a();
        }
        return f45656a;
    }

    /* renamed from: a */
    private static String m32714a() {
        return DiFaceLogger.EVENT_ID_APPEAL_DATA_SUBMIT_CONFIRM_VIDEO_NO + (Build.BOARD.length() % 10) + (getBrand().length() % 10) + (Build.CPU_ABI.length() % 10) + (Build.DEVICE.length() % 10) + (Build.DISPLAY.length() % 10) + (Build.HOST.length() % 10) + (Build.ID.length() % 10) + (Build.MANUFACTURER.length() % 10) + (getModel().length() % 10) + (Build.PRODUCT.length() % 10) + (Build.TAGS.length() % 10) + (Build.TYPE.length() % 10) + (Build.USER.length() % 10);
    }

    public static String getBrand() {
        if (TextUtils.isEmpty(f45660e)) {
            f45660e = WsgSecInfo.brand();
        }
        return f45660e;
    }

    public static String getModel() {
        if (TextUtils.isEmpty(f45661f)) {
            f45661f = WsgSecInfo.model();
        }
        return f45661f;
    }

    public static String getVersionName() {
        return WsgSecInfo.appVersionName();
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

    public static synchronized String generateKey() {
        String str;
        synchronized (Utils.class) {
            if (TextUtils.isEmpty(f45657b)) {
                String ddfp = getDdfp();
                String str2 = Build.FINGERPRINT == null ? "" : Build.FINGERPRINT;
                String str3 = Build.DISPLAY == null ? "" : Build.DISPLAY;
                String str4 = Build.HARDWARE == null ? "" : Build.HARDWARE;
                String str5 = Build.BOARD == null ? "" : Build.BOARD;
                f45657b = md5(ddfp + str2 + str3 + str4 + str5);
            }
            LogUtils.m32690d("uKey: " + f45657b);
            str = f45657b;
        }
        return str;
    }

    public static int getVersionCode() {
        return WsgSecInfo.appVersionCode();
    }

    public static String getPackageName() {
        if (TextUtils.isEmpty(f45659d)) {
            f45659d = WsgSecInfo.packageName();
        }
        return f45659d;
    }
}
