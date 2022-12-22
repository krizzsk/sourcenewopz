package com.didi.travel.psnger.bff;

public interface BffConstants {

    public interface AbilityID {
        public static final String ABILITY_CANCEL_ORDER = "passenger/pCancelOrder";
        public static final String ABILITY_CANCEL_TRIP = "passenger/pCancelTrip";
        public static final String ABILITY_EXPO_PASSENGER = "expo/pMultiEstimatePrice";
        public static final String ABILITY_GET_CANCEL_FEE_HISTORY = "passenger/pGetCancelFeeHistory";
        public static final String ABILITY_GET_REAL_TIME_PRICE = "passenger/pGetRealTimePrice";
        public static final String ABILITY_ORDER_DETAIL = "passenger/pOrderDetail";
        public static final String ABILITY_ORDER_STATUS = "passenger/pOrderStatus";
    }

    public interface Apollo {
        public static final String BFF_STAGE_NEW_FIFTH = "global_bff_passenger_newFifth_period_toggle";
    }

    public interface Tags {
        public static final String BFF_CANCEL_ORDER_TAG = "cancel_order";
        public static final String BFF_CANCEL_TRIP_TAG = "cancel_trip";
        public static final String BFF_ORDER_INFO_TAG = "order_info";
    }
}
