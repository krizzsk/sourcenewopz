package com.didi.soda.customer.foundation.log.constant;

public class LogConst {

    public static class Category {
        public static final String CATEGORY_ACT = "c-act|";
        public static final String CATEGORY_APP = "c-app|";
        public static final String CATEGORY_DATA = "c-data|";
        public static final String CATEGORY_SHOW = "c-show|";
        public static final String CATEGORY_STATE = "c-state|";
    }

    public static class Identifier {
        public static final String IDENTIFIER_MSG = "msg- %s | ";
        public static final String IDENTIFIER_PARAMS = "params- %s |";
        public static final String IDENTIFIER_TAG = "tag- %s |";
        public static final String IDENTIFIER_TIME = "time- %s |";
    }

    public static class Level {
        public static final String LEVEL_ERROR = "l-ERROR|";
        public static final String LEVEL_INFO = "l-INFO|";
        public static final String LEVEL_WARNING = "l-WARNING|";
    }

    public static class Module {
        public static final String MODULE_BUSINESS = "m-business|";
        public static final String MODULE_BUSINESS_DETAIL = "m-business-detail|";
        public static final String MODULE_HOME = "m-home|";
        public static final String MODULE_ITEM = "m-item|";
        public static final String MODULE_LOC = "m-loc|";
        public static final String MODULE_MAP = "m-map|";
        public static final String MODULE_MSG = "m-msg|";
        public static final String MODULE_NET_FAIL = "m-net-fail|";
        public static final String MODULE_NET_SUCCESS = "m-net-success|";
        public static final String MODULE_ODR = "m-odr|";
        public static final String MODULE_PURCHASE = "m-purchase|";
        public static final String MODULE_SEARCH = "m-search|";
        public static final String MODULE_SETTING = "m-setting|";
        public static final String MODULE_SKELETON = "m-skeleton|";
    }

    public static class System {
        public static final String SYSTEM_TYPE = "SodaAnd_p";
    }

    public static class Tag {
        public static final String NET_TAG = "net";
    }

    public class Param {
        public static final String ADD_CART_ANIMATION = "add_cart_animation";
        public static final String ADD_TYPE = "add_type";
        public static final String BUSINESS_ID = "business_id";
        public static final String BUSINESS_STATUS = "business_status";
        public static final String CATE_ID = "cate_id";
        public static final String CATE_INDEX = "cate_index";
        public static final String DATA = "data";
        public static final String FROM = "from";
        public static final String GOODS_ID = "goods_id";
        public static final String GOODS_STATUS = "goods_status";
        public static final String HAS_MULTI_CONTEND = "has_multi_content";
        public static final String ORDER_ID = "orderId";
        public static final String TRACE_ID = "traceId";

        public Param() {
        }
    }
}
