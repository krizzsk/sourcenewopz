package com.didi.unifylogin.utils.phone;

import android.text.TextUtils;
import com.didi.sdk.util.TextUtil;
import com.didi.unifylogin.base.net.pojo.response.CountryListResponse;
import com.didi.unifylogin.country.CountryManager;
import java.util.regex.Pattern;

public class PhoneUtils {
    public static String toNormalPhone(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return str.replaceAll(" ", "");
    }

    public static String toSpecialPhone(String str) {
        return toSpecialPhone(str, CountryManager.getIns().getCurrentCountry());
    }

    public static String toSpecialPhone(String str, CountryListResponse.CountryRule countryRule) {
        if (TextUtils.isEmpty(str) || countryRule == null) {
            return str;
        }
        String str2 = countryRule.format;
        if (TextUtil.isEmpty(str2)) {
            return str;
        }
        String normalPhone = toNormalPhone(str);
        StringBuffer stringBuffer = new StringBuffer();
        int i = 0;
        for (char c : normalPhone.toCharArray()) {
            if (i >= str2.length() || str2.charAt(i) != ' ') {
                stringBuffer.append(c);
            } else {
                stringBuffer.append(' ');
                stringBuffer.append(c);
                i++;
            }
            i++;
        }
        return stringBuffer.toString();
    }

    public static boolean isNum(String str) {
        if (TextUtil.isEmpty(str)) {
            return false;
        }
        return Pattern.compile("[0-9]*").matcher(str).matches();
    }

    public static String hideMiddleDigital(String str) {
        String str2;
        String str3;
        if (TextUtils.isEmpty(str) || str.length() < 2) {
            return str;
        }
        int length = str.length() / 2;
        if (length > 3) {
            str2 = str.substring(0, 3);
        } else {
            str2 = str.substring(0, length);
        }
        if (str.length() - length > 3) {
            str3 = str.substring(str.length() - 3, str.length());
        } else {
            str3 = str.substring(length, str.length());
        }
        int length2 = (str.length() - str2.length()) - str3.length();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str2);
        for (int i = 0; i < length2; i++) {
            stringBuffer.append("*");
        }
        stringBuffer.append(str3);
        return stringBuffer.toString();
    }
}
