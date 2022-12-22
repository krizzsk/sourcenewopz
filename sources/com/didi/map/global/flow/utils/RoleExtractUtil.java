package com.didi.map.global.flow.utils;

import com.didi.map.sdk.env.RoleType;

public class RoleExtractUtil {
    public static String getId(RoleType roleType) {
        return (roleType == null || roleType != RoleType.DRIVER) ? "0" : "1";
    }
}
