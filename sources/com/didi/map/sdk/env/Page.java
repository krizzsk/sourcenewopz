package com.didi.map.sdk.env;

import com.didi.component.business.tracker.GPageIdConstant;
import com.didi.map.google.util.GoogleSyncTripOmegaUtil;
import com.didichuxing.bigdata.p173dp.locsdk.Const;

public enum Page {
    HOMEPAGE("homepage"),
    SUG_PAGE("sug_page"),
    START_BUBBLE("start_bubble"),
    END_BUBBLE("end_bubble"),
    CONF_PAGE("conf_page"),
    PICONF_PAGE("piconf_page"),
    PREVIEW_PAGE("preview_page"),
    INSERVICE_PAGE(GoogleSyncTripOmegaUtil.PARAM_PAGE_VALUE),
    PICKUP_PAGE(Const.CALL_FROM_DEPARTURE_PAGE),
    ONTRIP_PAGE("ontrip_page"),
    CANCEL_PAGE("cancel_page"),
    ENDS_PAGE("ends_page"),
    SETTING_PAGE("setting_page"),
    HISTORYORDERLIST(GPageIdConstant.G_PAGE_ID_MY_TRIP),
    OTHER_PAGE("other_page"),
    WAITING_PAGE("waiting_page"),
    LOCKSCREEN_PAGE("lockscreen_page"),
    MINIBUS_CONFIRM_PAGE("mini_bus_conf_page"),
    MINIBUS_APPOINT_PAGE("mini_bus_appoint_page"),
    MINIBUS_PICKING_PAGE("mini_bus_picking_page"),
    MINIBUS_SERVICE_PAGE("mini_bus_serving_page"),
    MINIBUS_OVER_PAGE("mini_bus_over_page");
    
    private final String value;

    private Page(String str) {
        this.value = str;
    }

    public String toString() {
        return this.value;
    }
}
