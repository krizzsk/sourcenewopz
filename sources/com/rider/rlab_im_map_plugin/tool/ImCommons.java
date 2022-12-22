package com.rider.rlab_im_map_plugin.tool;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public final class ImCommons {
    public static final String BASE_ROUTER_URL = "://rider.didichuxing.com";
    public static final int BICYCLE = 2;
    public static final String BUNDLE_ADDRESS_NAME = "address";
    public static final String BUNDLE_CALL_FROM = "callFrom";
    public static final String BUNDLE_C_ORDER_ID = "c_orderId";
    public static final String BUNDLE_DISTANCE = "distance";
    public static final String BUNDLE_DOWNGRADE_MAP = "downgradeMap";
    public static final String BUNDLE_FAVOR = "favor";
    public static final String BUNDLE_IM_DATA = "imBusinessBean";
    public static final String BUNDLE_KEY_PARAMS = "params";
    public static final String BUNDLE_KEY_PATH = "path";
    public static final String BUNDLE_LANG = "lang";
    public static final String BUNDLE_LAT = "lat";
    public static final String BUNDLE_LNG = "lng";
    public static final String BUNDLE_MAP = "extParams";
    public static final String BUNDLE_NAV_TYPE = "travelMode";
    public static final String BUNDLE_NET_PARAMS = "netParams";
    public static final String BUNDLE_OMEGA = "omegaParams";
    public static final String BUNDLE_ORDER_ID = "orderId";
    public static final String BUNDLE_SECTION_NAME = "displayname";
    public static final String BUNDLE_TYPE = "pageType";
    public static final int CALL_FROM_RLAB_B = 1;
    public static final int CALL_FROM_RLAB_C = 2;
    public static final int CALL_FROM_RLAB_D = 3;
    public static final int DRIVE = 1;
    public static final String FAVOR_BRAZIL = "brazil";
    public static final String FAVOR_GLOBAL = "global";
    public static final int FINISH_SUCCESS = 2;
    public static final transient int GOOGLE_NAV = 2;
    public static final String HOST_B = "gsodamerchant://rider.didichuxing.com";
    public static final String HOST_C = "gsodacustomer://rider.didichuxing.com";
    public static final String HOST_D = "gsodarider://rider.didichuxing.com";
    public static final String IM_FLUTTER_PATH = "/im_map_page";
    public static final String IM_PATH = "/im_page";
    public static final transient int IN_APP = 1;
    public static final int MAP_ANIM_TIME = 300;
    public static final int MAP_MAX_ZOOM_LEVEL = 21;
    public static final int MAP_OPEN_MAX_ZOOM = 16;
    public static final int MAP_OPEN_MIN_ZOOM = 9;
    public static final int MAP_ZOOM_LEVEL = 14;
    public static final transient int NONE = 0;
    public static final int OPEN_IM_MAP = 1;
    public static final int REQUEST_CODE = 1;
    public static final String ROUTER_SCHEME_B = "gsodamerchant";
    public static final String ROUTER_SCHEME_C = "gsodacustomer";
    public static final String ROUTER_SCHEME_D = "gsodarider";
    public static final String ROUTER_SCHEME_IM = "http";
    public static final String ROUTE_PAGE_MAIN = "/main";
    public static final int SEND_IM_MAP = 0;
    public static final int START_ERROR = 1;
    public static final int START_SUCCESS = 0;
    public static final int WALK = 3;
    public static final transient int WAZE = 3;
    public static final int Z_INDEX = 30;

    @Retention(RetentionPolicy.SOURCE)
    public @interface CallFromType {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface NavStateType {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface NavType {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface PageFromType {
    }

    private ImCommons() {
    }
}
