package com.didichuxing.dfbasesdk.camera2;

import com.didichuxing.security.safecollector.WsgSecInfo;

public class PhoneList2 {
    public static final String OPPO_R9 = "OPPO R9m";
    public static final String[] phoneList = {"OPPO R9m"};

    public static boolean isAdapterPhone() {
        String model = WsgSecInfo.model();
        for (String equals : phoneList) {
            if (model.equals(equals)) {
                return true;
            }
        }
        return false;
    }
}
