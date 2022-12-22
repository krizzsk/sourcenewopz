package com.didi.soda.customer.foundation.tracker;

import com.didi.soda.customer.foundation.tracker.OmegaTracker;
import com.didi.soda.customer.foundation.tracker.event.EventConst;
import com.didi.soda.customer.foundation.util.LocationUtil;

public class LoginOmegaHelper {
    public static final int TYPE_1 = 1;
    public static final int TYPE_10 = 10;
    public static final int TYPE_11 = 11;
    public static final int TYPE_12 = 12;
    public static final int TYPE_14 = 14;
    public static final int TYPE_18 = 18;
    public static final int TYPE_19 = 19;
    public static final int TYPE_2 = 2;
    public static final int TYPE_20 = 20;
    public static final int TYPE_21 = 21;
    public static final int TYPE_22 = 22;
    public static final int TYPE_23 = 23;
    public static final int TYPE_24 = 24;
    public static final int TYPE_25 = 25;
    public static final int TYPE_26 = 26;
    public static final int TYPE_6 = 6;
    public static final int TYPE_7 = 7;
    public static final int TYPE_8 = 8;
    public static final int TYPE_9 = 9;
    public static final int TYPE_DEFAULT = 0;

    public static void loginTrack(int i) {
        OmegaTracker.Builder.create(EventConst.Setting.LOGIN_COMMON_CK).addEventParam("pull_type", Integer.valueOf(i)).addEventParam("poi_id", LocationUtil.getPoiId()).addEventParam("poi_lat", Double.valueOf(LocationUtil.getPoiLat())).addEventParam("poi_lng", Double.valueOf(LocationUtil.getPoiLng())).addEventParam("poi_city", Integer.valueOf(LocationUtil.getPoiCityId())).build().track();
    }

    public static void loginCallbackTrack(int i) {
        OmegaTracker.Builder.create(EventConst.Setting.LOGIN_CALLBACK_CK).addEventParam("pull_type", Integer.valueOf(i)).addEventParam("poi_id", LocationUtil.getPoiId()).addEventParam("poi_lat", Double.valueOf(LocationUtil.getPoiLat())).addEventParam("poi_lng", Double.valueOf(LocationUtil.getPoiLng())).addEventParam("poi_city", Integer.valueOf(LocationUtil.getPoiCityId())).build().track();
    }
}
