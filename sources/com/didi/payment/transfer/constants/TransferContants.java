package com.didi.payment.transfer.constants;

public class TransferContants {

    public static class BankData {
        public static final String JSON_KEY_FULL_LIST = "full_list";
        public static final String JSON_KEY_TOP_FIVE = "top_five";
        public static final String STATIC_BANK_JSON_FILE = "banklist.json";
    }

    public static class GlobalTransfer {
        public static final int ORDER_TYPE_TRANSFER = 0;
        public static final int PRODUCT_LINE_PIX = 99996;
        public static final int PRODUCT_LINE_TRANSTO99PAY = 99998;
        public static final int PRODUCT_LINE_TRANSTOBANK = 651;
        public static final int PRODUCT_LINE_TRASNFER_BIZ = 99999;
    }

    public static class IntentKey {
        public static final String INTENT_PARAMS_KEY_2BANK_NEW_VERSION = "transfer_to_bank_new_version";
        public static final String INTENT_PARAMS_KEY_HAS99PAY = "has_99pay_account";
        public static final String INTENT_PARAMS_KEY_PRODUCT_LINES = "INTENT_PARAMS_KEY_PRODUCT_LINES";
        public static final String INTENT_PARAMS_ORDER_TOPUP_COFIRM_FLAG = "params_topup_confirm_flag";
        public static final String INTENT_PARAM_KEY_FROM_PAGE = "INTENT_PARAM_KEY_FROM_PAGE";
        public static final String INTENT_PARAM_KEY_GROUP_PRODUCT_LINE = "INTENT_PARAM_KEY_GROUP_PRODUCT_LINE";
        public static final String INTENT_PARAM_KEY_ORDER_ID = "INTENT_PARAM_KEY_ORDER_ID";
        public static final String INTENT_PARAM_KEY_ORDER_TYPE = "INTENT_PARAM_KEY_ORDER_TYPE";
        public static final String INTENT_PARAM_KEY_PRODUCT_LINE = "INTENT_PARAM_KEY_PRODUCT_LINE";
        public static final String INTENT_PARAM_KEY_TRANS_CFM_AMOUNT_MODEL = "intent_param_key_trans_cfm_amount_model";
    }

    public static class Pages {
        public static int PAGE_TRANSFER_CHANNELS = 0;
        public static final int PAGE_TRANSFER_ORDER_RECORD = 1;
    }

    public static class RecordData {
        public static final int DATA_TYPE_TO99 = 2;
        public static final int DATA_TYPE_TOBANK = 1;
    }

    public static class Router {
        public static final String ROUTER_HOST_TRANSFER = "one";
        public static final String ROUTER_SHEME_TRANSFER = "GuaranaOneTravel://";
        public static final String ROUTE_TO_99PAY_HOMEPAGE = "/transferto99pay";
        public static final String ROUTE_TO_99PAY_REGISTE = "/register";
        public static final String ROUTE_TO_BANK_HOMEPAGE = "/transfertobank";

        public static String getRouteUrl(String str) {
            return "GuaranaOneTravel://one" + str;
        }
    }
}
