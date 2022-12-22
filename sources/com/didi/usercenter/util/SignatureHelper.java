package com.didi.usercenter.util;

import android.content.Context;
import android.provider.Settings;
import android.text.TextUtils;
import com.didi.sdk.util.MD5;
import com.didi.sdk.util.SystemUtil;
import com.google.common.base.Ascii;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.apache.commons.codec2.digest.MessageDigestAlgorithms;

public class SignatureHelper {

    /* renamed from: a */
    private static String f45138a;

    public static String getParamSig(String str) {
        try {
            return m32419a("didiwuxiankejiyouxian2013q" + str);
        } catch (NoSuchAlgorithmException unused) {
            return "";
        }
    }

    /* renamed from: a */
    private static String m32419a(String str) throws NoSuchAlgorithmException {
        if (str == null || str.length() == 0) {
            return "";
        }
        MessageDigest instance = MessageDigest.getInstance("SHA-1");
        instance.update(str.getBytes());
        return m32420a(instance.digest());
    }

    public static String toMD5(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        try {
            MessageDigest instance = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
            instance.reset();
            instance.update(str.getBytes("UTF-8"));
            byte[] digest = instance.digest();
            for (int i = 0; i < digest.length; i++) {
                stringBuffer.append(String.format("%02X", new Object[]{Byte.valueOf(digest[i])}));
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
        }
        return stringBuffer.toString();
    }

    /* renamed from: a */
    private static String m32420a(byte[] bArr) {
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

    public static String md5Encode(byte[] bArr) {
        try {
            MessageDigest instance = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
            instance.update(bArr);
            byte[] digest = instance.digest();
            StringBuffer stringBuffer = new StringBuffer(digest.length * 2);
            for (int i = 0; i < digest.length; i++) {
                stringBuffer.append(Character.forDigit((digest[i] & 240) >> 4, 16));
                stringBuffer.append(Character.forDigit(digest[i] & Ascii.f53593SI, 16));
            }
            return stringBuffer.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String encode(String str) {
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return str;
        }
    }

    public static String getUUID(Context context) {
        if (!TextUtils.isEmpty(f45138a)) {
            return f45138a;
        }
        String androidID = getAndroidID(context);
        String cPUSerialno = SystemUtil.getCPUSerialno();
        String md5 = MD5.toMD5("1_" + androidID + "2_" + SystemUtil.getIMEI() + "3_" + cPUSerialno);
        f45138a = md5;
        return md5;
    }

    public static String getAndroidID(Context context) {
        return Settings.Secure.getString(context.getContentResolver(), "android_id");
    }
}
