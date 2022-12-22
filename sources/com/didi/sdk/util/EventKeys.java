package com.didi.sdk.util;

public class EventKeys {
    public static final String APP_FCM_APPKEY = "fcm_app_type";
    public static final String APP_SCHEME_PREFIX = "deeplink_scheme";
    public static final String BRAND = "brand";
    public static final String ORIGIN_ID = "origin_id";
    public static final String SWITCH_TYPE = "switch_type";
    public static final String TERMINAL_ID = "terminal_id";
    public static final String USER_AGENT_PREFIX = "ua";

    public static class MisConfig {
        public static final String CAR_INFO_UPDATE = "car_info_update";
        public static final String LAW_INFO_UPDATE = "law_info_update";
        public static final String MIS_DATA_FROM_UPDATE = "mis_data_from_update";
        public static final String MIS_DATA_UPDATE = "mis_data_update";
        public static final String MIS_SEND_DATA = "mis_send_data";
        public static final String REFRESH_MIS = "refresh_mis";
    }

    public static class Sidebar {
        public static final String CLOSE_SIDEBAR = "closeSidebar";
        public static final String OPEN_SIDEBAR = "openSidebar";
        public static final String REFRESH_SIDEBAR = "refreshSidebar";
    }
}
