package com.didi.soda.router;

import android.os.Bundle;
import android.text.TextUtils;
import com.didi.travel.psnger.common.net.base.ParamKeys;

/* renamed from: com.didi.soda.router.b */
/* compiled from: SchemeUtils */
class C14170b {

    /* renamed from: a */
    static final String f43676a = "^-?[1-9]\\d*$";

    /* renamed from: b */
    static final String f43677b = "^[-]?[1-9]\\d*\\.\\d*|-0\\.\\d*[1-9]\\d*$";

    C14170b() {
    }

    /* renamed from: a */
    static String m30989a(String str) {
        int indexOf = str.indexOf("?&");
        if (indexOf > 0) {
            indexOf += 2;
        }
        if (indexOf == -1 && (indexOf = str.indexOf("?")) > 0) {
            indexOf++;
        }
        if (indexOf > 0) {
            return str.substring(indexOf);
        }
        return null;
    }

    /* renamed from: a */
    static void m30992a(String str, Bundle bundle) {
        for (String split : str.trim().split(ParamKeys.SIGN_AND)) {
            String[] split2 = split.split("=");
            String str2 = null;
            String str3 = (split2 == null || split2.length <= 0) ? null : split2[0];
            if (split2 != null && split2.length > 1) {
                str2 = split2[1];
            }
            m30991a(bundle, str3, str2);
        }
    }

    /* renamed from: a */
    static String m30990a(String str, String str2, int i) {
        int length = str.length() + 1;
        for (int i2 = 0; i2 <= i; i2++) {
            int indexOf = str2.indexOf("/", length);
            if (indexOf == -1) {
                return null;
            }
            length = indexOf + 1;
        }
        return str2.substring(0, length);
    }

    /* renamed from: a */
    private static void m30991a(Bundle bundle, String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            bundle.putString(str, str2);
        }
    }

    /* renamed from: b */
    static String m30993b(String str) {
        return str.substring(str.startsWith("/") ? 1 : 0, str.endsWith("/") ? str.length() - 1 : str.length());
    }
}
