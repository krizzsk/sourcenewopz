package com.didi.travel.psnger.p170v2;

/* renamed from: com.didi.travel.psnger.v2.EventKeys */
public class EventKeys {

    /* renamed from: com.didi.travel.psnger.v2.EventKeys$Poll */
    public static class Poll {
        public static final String EVENT_TRAVEL_SDK_ORDER_STATUS_CHANGE_BY_PUSH = "event_travel_sdk_order_status_by_push";
        public static final String EVENT_TRAVEL_SDK_UPDATE_POLL_INTERVAL = "event_travel_sdk_update_poll_interval";
    }

    /* renamed from: com.didi.travel.psnger.v2.EventKeys$Session */
    public static class Session {
        public static final String EVENT_TRAVEL_SDK_CREATE_SESSION = "event_travel_sdk_create_session";
        public static final String EVENT_TRAVEL_SDK_DESTROY_SESSION = "event_travel_sdk_destroy_session";
        public static final String EVENT_TRAVEL_SDK_RETURN_CREATE_SESSION = "event_travel_sdk_return_create_session";
        public static final String EVENT_TRAVEL_SDK_RETURN_DESTROY_SESSION = "event_travel_sdk_return_destroy_session";
        public static final String EVENT_TRAVEL_SDK_UPDATE_ORDER_ID = "event_travel_sdk_update_order_id";
    }

    /* renamed from: com.didi.travel.psnger.v2.EventKeys$XEngine */
    public static class XEngine {
        public static final String EVENT_X_ENGINE_ORDER_DETAIL_ERROR = "event_trip_x_engine_order_detail_error";
        public static final String EVENT_X_ENGINE_ORDER_DETAIL_FAIL = "event_trip_x_engine_order_detail_fail";
        public static final String EVENT_X_ENGINE_ORDER_DETAIL_SUCCESS = "event_trip_x_engine_order_detail_success";
        public static final String EVENT_X_ENGINE_ORDER_STATUS_CHANGE = "event_trip_x_engine_order_status_change";
    }
}
