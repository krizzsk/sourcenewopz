package com.didi.map.google.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public @interface OmegaTraceEvent {

    @Retention(RetentionPolicy.SOURCE)
    public @interface CommentParamNames {
        public static final String ENTRANCE = "entrance";
        public static final String ORDER_ID = "order_id";
        public static final String PAGE = "page";
        public static final String PRODUCT_ID = "product_id";
        public static final String TIMESTAMP = "timestamp";
        public static final String TRIP_STEP = "trip_step";
        public static final String USER_ID = "uid";
        public static final String USER_TYPE = "user_type";
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface Keys {
        public static final String COM_MAP_MOCK_MOVEMENT_SW_GLOBAL = "com_map_mock_movement_sw_global";
        public static final String MAP_MOCKTYPE_SW = "map_mockType_sw";
        public static final String MAP_PAX_ANIMATION_CAR_DELAY = "map_pax_animation_car_delay";
        public static final String MAP_PAX_CAR_JUMP = "map_pax_car_jump";
        public static final String MAP_PAX_SHOW_DRIVER_EXCEPTION = "map_pax_show_driver_exception";
    }
}
