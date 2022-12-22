package com.didi.safety.god.util;

import android.os.Build;

public class PhoneList {
    public static final String OPPO_R9 = "OPPO R9m";
    public static final String[] phoneList = {"OPPO R9m"};

    public static boolean isAdapterPhone() {
        String str = Build.MODEL;
        for (String equals : phoneList) {
            if (str.equals(equals)) {
                return true;
            }
        }
        return false;
    }
}
