package com.didi.map.sdk.nav.car;

import com.didi.common.map.Map;
import com.didi.common.map.MapVendor;
import com.map.sdk.nav.libc.common.ApolloUtil;

public class ZoomLevelAdapter {
    public static double getCarHeadMinZoom(Map map) {
        return (map == null || map.getMapVendor() != MapVendor.DIDI) ? 15.0d : 18.25d;
    }

    public static double getCarHeadMaxZoom(Map map) {
        if (map == null || map.getMapVendor() != MapVendor.DIDI) {
            return ApolloUtil.getMaxCarHeadLevel();
        }
        return 19.75d;
    }
}
