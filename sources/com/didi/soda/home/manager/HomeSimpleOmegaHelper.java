package com.didi.soda.home.manager;

import com.didi.soda.customer.foundation.tracker.OmegaTracker;
import com.didi.soda.customer.foundation.tracker.event.EventConst;
import com.didi.soda.customer.foundation.tracker.param.ParamConst;
import com.didi.soda.customer.foundation.util.LocationUtil;

public final class HomeSimpleOmegaHelper {
    private HomeSimpleOmegaHelper() {
    }

    public static void trackHomePhonePageSW(int i) {
        OmegaTracker.Builder.create(EventConst.Home.HOME_SUBMIT_PHONE_SW).addEventParam("from", Integer.valueOf(i)).addEventParam(ParamConst.PARAM_POI_ID_CITY, String.valueOf(LocationUtil.getPoiCityId())).build().track();
    }

    public static void trackHomePhonePageCK(int i) {
        OmegaTracker.Builder.create(EventConst.Home.HOME_SUBMIT_PHONE_CK).addEventParam("from", Integer.valueOf(i)).addEventParam(ParamConst.PARAM_POI_ID_CITY, String.valueOf(LocationUtil.getPoiCityId())).build().track();
    }

    public static void trackHomeCityListSW(int i) {
        OmegaTracker.Builder.create(EventConst.Home.HOME_AVAILABLE_CITY_SW).addEventParam("from", Integer.valueOf(i)).addEventParam(ParamConst.PARAM_POI_ID_CITY, String.valueOf(LocationUtil.getPoiCityId())).build().track();
    }

    public static void trackHomeCityListCK(int i) {
        OmegaTracker.Builder.create(EventConst.Home.HOME_AVAILABLE_CITY_CK).addEventParam("from", Integer.valueOf(i)).addEventParam(ParamConst.PARAM_POI_ID_CITY, String.valueOf(LocationUtil.getPoiCityId())).build().track();
    }
}
