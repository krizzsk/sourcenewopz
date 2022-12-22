package com.didi.payment.creditcard.base.encryption;

import android.text.TextUtils;
import com.didi.sdk.util.MD5;

public class LianLianEncryptUtils {
    public static String encryptWithAES(String str, String str2) {
        return (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) ? "" : C10601a.m21184a(str, str2);
    }

    public static String decryptWithAES(String str, String str2) {
        return (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) ? "" : C10601a.m21188b(str, str2);
    }

    public static String encryptWithRSA(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return "";
        }
        try {
            return C10607g.m21252a(str, str2);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String decryptWithRSA(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return "";
        }
        try {
            return C10607g.m21256b(str, str2);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String getRandomAESKey() {
        return C10608h.m21260a(16);
    }

    public static String MD5(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return MD5.toMD5(str);
    }
}
