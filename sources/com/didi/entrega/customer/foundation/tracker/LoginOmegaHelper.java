package com.didi.entrega.customer.foundation.tracker;

import com.didi.entrega.customer.foundation.tracker.OmegaTracker;
import com.didi.entrega.customer.foundation.tracker.event.EventConst;
import com.didi.entrega.customer.foundation.util.LocationUtil;

public class LoginOmegaHelper {
    public static final int TYPE_1 = 1;
    public static final int TYPE_2 = 2;
    public static final int TYPE_3 = 3;
    public static final int TYPE_9 = 9;
    public static final int TYPE_DEFAULT = 0;

    public static void loginTrack(int i) {
        OmegaTracker.Builder.create(EventConst.Setting.LOGIN_COMMON_CK).addEventParam("pull_type", Integer.valueOf(i)).addEventParam("poi_id", LocationUtil.getPoiId()).addEventParam("poi_lat", Double.valueOf(LocationUtil.getPoiLat())).addEventParam("poi_lng", Double.valueOf(LocationUtil.getPoiLng())).addEventParam("poi_city", Integer.valueOf(LocationUtil.getPoiCityId())).build().track();
    }

    public static void loginCallbackTrack(int i) {
        OmegaTracker.Builder.create(EventConst.Setting.LOGIN_CALLBACK_CK).addEventParam("pull_type", Integer.valueOf(i)).addEventParam("poi_id", LocationUtil.getPoiId()).addEventParam("poi_lat", Double.valueOf(LocationUtil.getPoiLat())).addEventParam("poi_lng", Double.valueOf(LocationUtil.getPoiLng())).addEventParam("poi_city", Integer.valueOf(LocationUtil.getPoiCityId())).build().track();
    }
}
