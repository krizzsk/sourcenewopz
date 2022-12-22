package com.sdk.poibase;

import com.didichuxing.bigdata.p173dp.locsdk.Const;
import java.io.Serializable;

public enum CallFrom implements Serializable {
    HOME_ONE_KEY_ORDER("lamei_api_directcall"),
    GLOBAL_HOMEPAGE_STATION("global_homepage_station"),
    GLOBAL_BUBBLEPAGE_STATION("global_bubblepage_station"),
    PICKUP_PAGE(Const.CALL_FROM_DEPARTURE_PAGE),
    SUG_PACKING_PROMPT(Const.CALL_FROM_SUG_PAGE),
    GLOBAL_STARTSUG_DRAG("global_startsug_drag"),
    GLOBAL_ENDSUG_DRAG("global_endsug_drag"),
    ALTER_PICKUP_PAGE("alter_pickup_page"),
    DROPOFF_PAGE("dropoff_page"),
    BUBBLEPAGE_REC_START("bubblepage_rec_start"),
    HOME_PAGE_DRAG("home_page_drag"),
    GLOBAL_FROMBUBBLE_ENDSUG_DRAG("global_frombubble_endsug_drag"),
    GLOBAL_FROMBUBBLE_STARTSUG_DRAG("global_frombubble_startsug_drag"),
    GLOBAL_FROMHOME_ENDSUG_DRAG("global_fromhome_endsug_drag"),
    GLOBAL_FROMHOME_STARTSUG_DRAG("global_fromhome_startsug_drag"),
    LONG_PRESS_START_FROMHOME("home_page_startsug_longpress"),
    LONG_PRESS_END_FROMHOME("home_page_endsug_longpress"),
    LONG_PRESS_START_FROMBUBBLE("global_frombubble_startsug_longpress"),
    LONG_PRESS_END_FROMBUBBLE("global_frombubble_endsug_longpress"),
    CANOE_DEPARTURE_FROMHOME("canoe_departure_fromhome"),
    GOOGLEMAP("googlemap"),
    SAFETOOLKIT("safetoolkit"),
    SODA("soda"),
    UNKNOWN("unknown");
    
    private final String key;

    private CallFrom(String str) {
        this.key = str;
    }

    public String toString() {
        return this.key;
    }
}
