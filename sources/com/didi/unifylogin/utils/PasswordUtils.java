package com.didi.unifylogin.utils;

import android.text.TextUtils;
import com.didi.unifylogin.api.LoginPreferredConfig;
import java.util.regex.Pattern;

public class PasswordUtils {

    /* renamed from: a */
    private static String f44939a;

    public static int getMinDigit(boolean z) {
        return z ? 6 : 8;
    }

    public static boolean isValid(String str) {
        return isValid(str, true);
    }

    public static boolean isValid(String str, boolean z) {
        if (!TextUtils.isEmpty(str) && str.length() >= getMinDigit(z) && str.length() <= 16) {
            return true;
        }
        return false;
    }

    public static int getMinDigit() {
        return getMinDigit(LoginPreferredConfig.isUseWeakPwd());
    }

    public static boolean chackPasswordMix(String str) {
        if (!Pattern.compile("[0-9]*").matcher(str).matches() && !Pattern.compile("[a-zA-Z]*").matcher(str).matches() && !Pattern.compile("[-/:;()$&@\".,?!'\\[\\]\\{\\}#%^*+=_\\|~<>€£¥]*").matcher(str).matches()) {
            return true;
        }
        return false;
    }

    public static void setTempPassword(String str) {
        f44939a = str;
    }

    public static String getTempPassword() {
        return f44939a;
    }
}
