package com.didi.component.business.constant;

public class BaseExtras {

    public static class CancelService {
        public static final String EXTRA_CANCEL_TRIP_CONTENT = "extra_cancel_trip_content";
        public static final String EXTRA_CANCEL_TRIP_DATA = "extra_cancel_trip_data";
    }

    public static class Common {
        public static final String EXTRA_BACK_TO_CONFIRM = "extra_back_to_confirm";
        public static final String EXTRA_CLOSE_H5_CALLBACK_DATA = "extra_close_h5_callback_data";
        public static final String EXTRA_CREATE_ORDER = "extra_create_order";
        public static final String EXTRA_CURRENT_BID = "extra_base_current_bid";
        public static final String EXTRA_CURRENT_COMBOTYPE = "extra_current_combotype";
        public static final String EXTRA_FROM_PAGE_ID = "extra_from";
        public static final String EXTRA_GETON_TO_RSP = "extra_geton_to_rsp";
        public static final String EXTRA_OPEN_RIDE_DEEP_LINK_URI = "extra_open_ride_deep_link_uri";
        public static final String EXTRA_ORDER_BEAN = "param_order_bean";
        public static final String EXTRA_ORDER_SOURCE = "param_order_source";
    }

    public static class ConfirmService {
        public static final String CANCEL_ORDER_BACK_TO_ESTIMATE = "cancel_order_back_to_estimate";
        public static final String EXTRA_BACK_TO_CONFIRM_TIP = "extra_back_to_confirm_tip";
        public static final String EXTRA_BOOK_ORDER_REASSIGN = "extra_book_order_reassign";
        public static final String EXTRA_CONFIRM_GET_ON_SCENE = "extra_confirm_get_on_scene";
        public static final String EXTRA_CONFIRM_GET_ON_SCENE_V2 = "extra_confirm_get_on_scene_v2";
        public static final String EXTRA_CONFIRM_REQUEST_BY_CANCEL_TRIP = "extra_confirm_request_by_cancel_trip";
        public static final String EXTRA_CREATE_ORDER_FAIL_CARORDER = "extra_create_order_fail_carorder";
        public static final String EXTRA_GOTO_WAIT_RSP_SOURCE = "extra_goto_wait_rsp_source";
        public static final String EXTRA_SEND_ORDER_IN_WAIT_RSP_PAGE = "extra_send_order_in_wait_rsp_page";
    }

    public static class EndService {
        public static final String EXTRA_CANCEL_INTERCEPT_JUMP = "extra_cancel_intercept_jump";
        public static final String EXTRA_EVALUATE_QUESTION_DATA = "extra_end_service_evaluate_question_data";
        public static final String EXTRA_FIRST_VIEW = "extra_end_service_first_view";
        public static final String EXTRA_NEED_SHOW_CANCEL_REASON = "extra_cancel_service_show_cancel_reason";
        public static final String EXTRA_SHOW_ORDER_CANCEL = "extra_end_service_show_order_cancel";
        public static final String EXTRA_SHOW_ORDER_DETAIL = "extra_end_service_show_order_detail";
        public static final int VIEW_EVALUATE_ENTRANCE = 1;
        public static final int VIEW_PAYMENT = 2;
        public static final int VIEW_PAY_ENTRANCE = 3;
    }

    public static class Home {
        public static final String EXTRAS_EVALUATE_JSON = "extras_unevaluated_json";
        public static final String EXTRAS_EVALUATE_LEVEL = "extras_unevaluated_satisfied";
        public static final String EXTRAS_EVALUATE_STYLE = "extras_unevaluated_style";
        public static final String EXTRAS_UNEVALUATED_COMMENT_DATA = "extras_unevaluated_comment_data";
    }

    public static class RouteEditor {
        public static final String EXTRA_CONFIG_ROUTE_EDIT_IS_ADD_NEW_STOP = "extra_config_route_edit_is_add_new_stop";
        public static final String EXTRA_CONFIG_ROUTE_EDIT_IS_ONSERVICE = "extra_config_route_edit_type";
        public static final String EXTRA_WAY_POINT_UPDATE_RESULT = "extra_way_point_update_result";
    }

    public static class Trip {
        public static final String EXTRA_TRIP_IS_ANY_CAR = "extra_trip_is_any_car";
        public static final String EXTRA_TRIP_SCENE = "extra_trip_scene";
    }

    public static class WaitResponse {
        public static final String EXTRA_WAIT_RSP_PAGE_SOURCE = "extra_wait_rsp_page_source";
        public static final int SOURCE_BOOKING_FAIL = 1;
        public static final int SOURCE_BOOKING_REASSIGN = 2;
    }
}
