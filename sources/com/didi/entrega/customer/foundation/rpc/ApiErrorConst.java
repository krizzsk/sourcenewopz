package com.didi.entrega.customer.foundation.rpc;

import android.text.TextUtils;
import android.util.ArrayMap;

public final class ApiErrorConst {

    public static class Message {
    }

    public static final class OrderRiskType {
        public static final int RISK_CODE_CHANNEL_UNSED = 100007;
        public static final int RISK_GO_TO_PAY_METHOD = 100010;
        public static final int RISK_NEED_CHECK_ID = 100008;
    }

    public static boolean isAccountAbnormal(int i) {
        switch (i) {
            case 50001:
            case 50002:
            case 50004:
                return true;
            default:
                return false;
        }
    }

    private ApiErrorConst() {
    }

    public static final class Code {
        public static final int CREATE_NO_CAPACITY_SUPPORT = 41091;
        public static final int CREATE_ORDER_BUY_COUPON_ERROR = 41045;
        public static final int CREATE_ORDER_CASH_LIMIT = 41404;
        public static final int CREATE_ORDER_DELIVERY_METHOD = 47101;
        public static final int CREATE_ORDER_DISTANCE_CHECK = 41413;
        public static final int CREATE_ORDER_DUPLICATED_ORDER = 46900;
        public static final int CREATE_ORDER_ITEM_NUM_MAX = 41040;
        public static final int CREATE_ORDER_LIMIT_AMOUNT = 41402;
        public static final int CREATE_ORDER_LOW_AMOUNT = 41403;
        public static final int CREATE_ORDER_MANY_RUNNING_ORDER = 41400;
        public static final int CREATE_ORDER_MAX_CREDIT = 41401;
        public static final int CREATE_ORDER_OUT_OPEN_CITY = 41036;
        public static final int CREATE_ORDER_PAY_99_ERROR = 41064;
        public static final int CREATE_ORDER_PAY_CHANNEL_CHECK_ERROR = 41039;
        public static final int CREATE_ORDER_PAY_CHANNEL_NOT_SUPPORT = 41044;
        public static final int CREATE_ORDER_PAY_METHOD_ERROR = 41038;
        public static final int CREATE_ORDER_PAY_PAYPAY_ERROR = 41066;
        public static final int CREATE_ORDER_RECEIVE_ADDRESS_ERROR = 41406;
        public static final int CREATE_ORDER_RECEIVE_COUNTRY_ERROR = 41410;
        public static final int CREATE_ORDER_RECEIVE_NO_SERVICE = 41412;
        public static final int CREATE_ORDER_RECEIVE_OUT_OF_RANGE = 41408;
        public static final int CREATE_ORDER_RECEIVE_PHONE_NULL = 41415;
        public static final int CREATE_ORDER_RISK_CANNOT_CREATE = 41053;
        public static final int CREATE_ORDER_RISK_CANNOT_USE_CASH = 41054;
        public static final int CREATE_ORDER_RISK_CANNOT_USE_CREDIT_CARD = 41055;
        public static final int CREATE_ORDER_RISK_CHANNEL_FAILED = 41052;
        public static final int CREATE_ORDER_RISK_CHECK_ID = 41060;
        public static final int CREATE_ORDER_RISK_NEED_EX_VALIDATE = 41063;
        public static final int CREATE_ORDER_RISK_NO_COUPON = 41051;
        public static final int CREATE_ORDER_SEND_ADDRESS_ERROR = 41405;
        public static final int CREATE_ORDER_SEND_COUNTRY_ERROR = 41409;
        public static final int CREATE_ORDER_SEND_NO_SERVICE = 41411;
        public static final int CREATE_ORDER_SEND_OUT_OF_RANGE = 41407;
        public static final int CREATE_ORDER_SEND_PHONE_NULL = 41414;
        public static final int CREATE_ORDER_SHOP_OUT_RANGE = 41033;
        public static final int CREATE_ORDER_SN_CHANGE = 41034;
        public static final int CREATE_ORDER_UNREACH_DELIVERY = 40115;
        public static final int DEBT_ORDER_REPAY_RISK_NEED_EX_VALIDATE = 48201;
        public static final int ERROR_50000 = 50000;
        public static final int ERROR_50001 = 50001;
        public static final int ERROR_50002 = 50002;
        public static final int ERROR_50003 = 50003;
        public static final int ERROR_50004 = 50004;
        public static final int ERROR_50005 = 50005;
        public static final int NOT_OPENED_CITY = 40109;
        public static final int PROTECT_PHONE_INVAIL_ERROR = 46588;

        private Code() {
        }
    }

    public static final class LogoutReasons {
        private static final String CLIENT_VERSION_IS_OLD = "clientVersionIsOld";
        private static final String LOGIN_ANOTHER_PLACE = "loginAnotherPlace";
        private static final String LOGOUT_DEVIDER = "_";
        private static final String LOGOUT_PREFIX = "entrega";
        private static final String NOT_LOGIN_ERROR = "notLoginError";
        private static final String REQUEST_PARAMS_ERROR = "requestParamsError";
        private static final String TOKEN_VALIDATE_FAILED = "tokenValidateFailed";
        private static final String USERS_ARE_BLOCKED = "usersAreBlocked";
        private static final ArrayMap<Integer, String> mReasonMap;

        static {
            ArrayMap<Integer, String> arrayMap = new ArrayMap<>();
            mReasonMap = arrayMap;
            arrayMap.put(Integer.valueOf(Code.ERROR_50000), TOKEN_VALIDATE_FAILED);
            mReasonMap.put(50001, REQUEST_PARAMS_ERROR);
            mReasonMap.put(50002, NOT_LOGIN_ERROR);
            mReasonMap.put(Integer.valueOf(Code.ERROR_50003), LOGIN_ANOTHER_PLACE);
            mReasonMap.put(50004, CLIENT_VERSION_IS_OLD);
            mReasonMap.put(Integer.valueOf(Code.ERROR_50005), USERS_ARE_BLOCKED);
        }

        public static String getSignReasonByErrorCode(int i) {
            if (mReasonMap.containsKey(Integer.valueOf(i))) {
                String str = mReasonMap.get(Integer.valueOf(i));
                if (!TextUtils.isEmpty(str)) {
                    return LOGOUT_PREFIX + "_" + str + "_" + i;
                }
            }
            return "";
        }
    }
}
