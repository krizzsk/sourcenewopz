package com.didi.component.business.xengine;

public interface XERequestKey {
    public static final String REQUEST_KEY_ALERT = "passenger_newPopup";
    public static final String REQUEST_KEY_CASH_UNPAY = "passenger_unpaid";
    public static final String REQUEST_KEY_ESTIMATE = "passenger_eyeball_estimate";
    public static final String REQUEST_KEY_FLEX_OPERATION_PANEL = "flex_driverlist_operationPanel";
    public static final String REQUEST_KEY_FLOAT_BAR = "passenger_float_bar";
    public static final String REQUEST_KEY_INDRIVER = "passenger_newXpanel+bargainingCard_logic+bargaining_card";
    public static final String REQUEST_KEY_MAP_INFO = "passenger_tripMap";
    public static final String REQUEST_KEY_MATCH_ON_TRIP = "passenger_newXpanel+orderDetailRelativeCard_logic+xpanel_carpool_matchontrip";
    public static final String REQUEST_KEY_MATCH_TOGO = "passenger_newXpanel+orderDetailRelativeCard_logic+xpanel_carpool_matchtogo";
    public static final String REQUEST_KEY_MESSAGE = "passenger_message";
    public static final String REQUEST_KEY_NEW_ORDER = "passenger_new_order";
    public static final String REQUEST_KEY_NOTALK = "passenger_meetcard";
    public static final String REQUEST_KEY_ORDER_COM = "passenger_orderCom";
    public static final String REQUEST_KEY_ORDER_DETAIL = "passenger_order_detail";
    public static final String REQUEST_KEY_PASSENGER_HOME_CARD = "passenger_home_card";
    public static final String REQUEST_KEY_SAVING_CENTER = "passenger_saving_center";
    public static final String REQUEST_KEY_SHARE = "share_trip_platform";
    public static final String REQUEST_KEY_SHEET = "passenger_newSheet";
    public static final String REQUEST_KEY_SHIFT = "passenger_shift_data";
    public static final String REQUEST_KEY_TOAST = "passenger_toast";
    public static final String REQUEST_KEY_TRAVEL_GROUP_CARD = "travel_group_info_v2";
    public static final String REQUEST_KEY_UNIPAY = "passenger_unipay";
    public static final String REQUEST_KEY_XBANNER = "passenger_xbanner";
    public static final String REQUEST_KEY_XPANEL = "passenger_newXpanel";
    public static final String SCENE_CONFIRM = "xEngine_confirm";
    public static final String SCENE_CONFIRM_ADDRESS = "xEngine_confirm_address";
    public static final String SCENE_ESTIMATE = "xEngine_estimate";
    public static final String SCENE_HOME = "xEngine_home";
    public static final String SCENE_NEW_ORDER = "new_order";
    public static final String SCENE_SHIFT = "xEngine_shift";
    public static final String SCENE_TRIP = "xEngine_trip";
    public static final String X_ENGINE_TYPE_4_PASSENGER = "globalXEngine";

    public interface SingeMinibus {
        public static final String REQUEST_KEY_HAS_LOCATION = "eevee_enable_location";
        public static final String SCENE_HOME = "bus_home";
    }

    public interface SingleCompRefresh {
        public static final String REQUEST_KEY_ANYCAR_EYEBALL = "passenger_anycar_eyeball";
        public static final String REQUEST_KEY_ANYCAR_USER_PAY_INFO = "passenger_user_pay_info";
        public static final String REQUEST_KEY_FLEX_DRIVER = "flex_driverlist_panel";
        public static final String REQUEST_KEY_OFFER_FLEX_PRICE = "passenger_offer_flex_price";
        public static final String REQUEST_KEY_PREORDER_EXPO_INTERCEPT = "passenger_preorder_expo_intercept";
        public static final String REQUEST_KEY_SELECT_SEAT = "passenger_seat_select";
        public static final String REQUEST_KEY_SUBSTITUTE_CALL = "passenger_substitute_call";
    }
}
