package com.didi.sdk.security;

import android.content.Context;
import android.provider.Settings;
import android.text.TextUtils;
import com.didi.sdk.net.HttpParamUtils;
import com.didi.sdk.util.MD5;
import com.didi.sdk.util.SUUIDHelper;
import com.didi.sdk.util.SystemUtil;
import com.didi.sdk.util.TextUtil;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

public class SecurityUtil {

    /* renamed from: a */
    private static final String f37157a = "didiwuxiankejiyouxian2013";

    /* renamed from: b */
    private static final String f37158b = "__x_";

    /* renamed from: c */
    private static String f37159c = "";

    /* renamed from: d */
    private static String f37160d;

    /* renamed from: e */
    private static Context f37161e;

    public static String getSUSIGN() {
        return "";
    }

    public static void init(Context context) {
        f37161e = context;
    }

    public static String getDeviceId() {
        if (TextUtil.isEmpty(f37159c)) {
            try {
                f37159c = SecurityLib.getDeviceId(f37161e);
            } catch (Throwable unused) {
            }
        }
        return f37159c;
    }

    public static String getAndroidID() {
        return Settings.Secure.getString(f37161e.getContentResolver(), "android_id");
    }

    public static String getUUID() {
        if (!TextUtils.isEmpty(f37160d)) {
            return f37160d;
        }
        String androidID = getAndroidID();
        String cPUSerialno = SystemUtil.getCPUSerialno();
        String md5 = MD5.toMD5("1_" + androidID + "2_" + SystemUtil.getIMEI() + "3_" + cPUSerialno);
        f37160d = md5;
        return md5;
    }

    public static String getSUUID() {
        return SUUIDHelper.getDiDiSUUID();
    }

    /* renamed from: a */
    private static String m26336a(String str) throws NoSuchAlgorithmException {
        if (str == null || str.length() == 0) {
            return "";
        }
        MessageDigest instance = MessageDigest.getInstance("SHA-1");
        instance.update(str.getBytes());
        return m26337a(instance.digest());
    }

    /* renamed from: a */
    private static String m26337a(byte[] bArr) {
        String str = "";
        for (byte b : bArr) {
            String hexString = Integer.toHexString(b & 255);
            if (hexString.length() == 1) {
                str = str + "0" + hexString;
            } else {
                str = str + hexString;
            }
        }
        return str;
    }

    public static String generateSignature(Map<String, Object> map) {
        try {
            return m26336a(HttpParamUtils.getSortedParamsString(map));
        } catch (NoSuchAlgorithmException unused) {
            return "";
        }
    }

    public static String generateSignature(Map<String, Object> map, String str) {
        try {
            return m26336a(HttpParamUtils.getSortedParamsTrimValue(map, str));
        } catch (NoSuchAlgorithmException unused) {
            return "";
        }
    }
}
