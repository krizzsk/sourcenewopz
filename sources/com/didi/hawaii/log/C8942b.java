package com.didi.hawaii.log;

import com.didi.hawaii.basic.HWSupportedAppVersion;
import java.text.DateFormat;
import java.util.Date;

/* renamed from: com.didi.hawaii.log.b */
/* compiled from: HWLogger */
final class C8942b {

    /* renamed from: a */
    private static final String f23484a = "hawii_sdk_";

    /* renamed from: b */
    private static final String f23485b = "{phonenumber}_{hawaii}{count}_{date:yyyyMMdd}-1.txt";

    /* renamed from: a */
    static String m16774a() {
        return f23485b;
    }

    C8942b() {
    }

    /* renamed from: a */
    static String m16775a(String str) {
        return HWSupportedAppVersion.getBaMaiLogFileNameRule(str, f23485b);
    }

    /* renamed from: a */
    static String m16776a(String str, String str2, int i, DateFormat dateFormat, DateFormat dateFormat2) {
        String str3 = str + "_temp";
        if (str.contains("{phonenumber}")) {
            str3 = str3.replace("{phonenumber}", str2);
        }
        if (str.contains("{date:yyyyMMdd}")) {
            str3 = str3.replace("{date:yyyyMMdd}", dateFormat.format(new Date(System.currentTimeMillis())));
        }
        if (str.contains("{count}")) {
            str3 = str3.replace("{count}", String.valueOf(i));
        }
        if (str.contains("{hawaii}")) {
            str3 = str3.replace("{hawaii}", f23484a);
        }
        if (str.contains("{date:HH_mm_ss}")) {
            str3 = str3.replace("{date:HH_mm_ss}", dateFormat2.format(new Date(System.currentTimeMillis())));
        }
        return str3.substring(0, str3.length() - 5) + "-1.txt";
    }
}
