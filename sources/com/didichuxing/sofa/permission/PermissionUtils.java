package com.didichuxing.sofa.permission;

import android.text.TextUtils;
import com.didichuxing.bigdata.p173dp.locsdk.Const;

public final class PermissionUtils {
    private PermissionUtils() {
    }

    public static String formatArrayAsString(String[] strArr) {
        String str = "";
        for (String str2 : strArr) {
            if (!TextUtils.isEmpty(str)) {
                str = str + ", ";
            }
            str = str + str2;
        }
        return Const.jaLeft + str + Const.jaRight;
    }
}
