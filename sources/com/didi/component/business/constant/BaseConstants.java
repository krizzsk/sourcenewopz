package com.didi.component.business.constant;

public class BaseConstants {

    public static class CancelTrip {
        public static final int ERROR_CODE_CANCEL_FAIL = 1044;
        public static final int ERROR_CODE_CANCEL_SUCCESS = 0;
        public static final int ERROR_CODE_CLOSE_ORDER = 1035;
        public static final int REQUEST_CODE_TO_CANCEL_TRIP = 100;
        public static final int STATE_CANCEL_TRIP_CONFIRM = 2;
        public static final int TYPE_ORDER_CANCEL_EXCEPTION = 0;
        public static final int TYPE_ORDER_CANCEL_NOREASON = 1;
        public static final int TYPE_ORDER_CANCEL_REASON = 2;
    }

    public static class Common {
        public static final int OP_ACTIVITY_BID = 21009;
    }

    public static class CompVersionCode {

        /* renamed from: V1 */
        public static final int f11192V1 = 1;

        /* renamed from: V2 */
        public static final int f11193V2 = 2;
        public static final int VMAX = 100;
    }

    public static class ConfirmPageExtraKeys {
        public static final String DEFAULT_SELECT_BIZ_INT = "default_select_biz_id";
        public static final String PAGE_HOME_DESTINATION = "page_home_destination";
        public static final String PAGE_SOURCE = "page_source";
        public static final String PAGE_SOURCE_DEEPLINK = "page_source_deeplink";
        public static final String PAGE_SUG = "page_sug";
    }

    public static class DeeplinkDispatcherExtraKeys {
        public static final String DEEPLINK_EVENT = "deeplink_context";
    }

    public static class NewGuideDialogOrigin {
        public static final int FROM_BUBBLE_CARD = 1;
        public static final int FROM_BUBBLE_CARPOOL_RIDER = 4;
        public static final int FROM_BUBBLE_DISPATCH = 2;
        public static final int FROM_BUBBLE_ESTIMATE = 0;
        public static final int FROM_BUBBLE_OPTIONS = 3;
        public static final int FROM_MATCH_TO_GO = 6;
        public static final int FROM_TWO_PRICE = 5;
    }

    public static class NormalFinishTrip {
        public static final String LAST_ORDER_PARENT_SID = "last_order_parent_sid";
        public static final String NORMAL_FINISH_THE_TRIP = "normal_finish_the_trip";
    }

    public static class OpenRideState {
        public static final int CANCEL = 2;
        public static final int IN_PROGRESS = 1;
    }

    public static class OrderBan {
        public static final int ORDER_BAN_STATUS_BANED = 1;
        public static final int ORDER_BAN_STATUS_BANED_FOREVER = 2;
        public static final int ORDER_BAN_STATUS_NONE = 0;
    }
}
