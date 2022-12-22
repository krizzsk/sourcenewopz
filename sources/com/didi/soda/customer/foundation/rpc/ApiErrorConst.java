package com.didi.soda.customer.foundation.rpc;

import android.text.TextUtils;
import android.util.ArrayMap;

public final class ApiErrorConst {

    public static class Message {
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

    public static boolean isAddressAbnormal(int i) {
        return i == 40104;
    }

    private ApiErrorConst() {
    }

    public static final class Code {
        public static final int ALCOHOL = 44040;
        public static final int CREATE_NO_CAPACITY_CONFIRM = 41093;
        public static final int CREATE_NO_CAPACITY_SUPPORT = 41091;
        public static final int CREATE_ORDER_ADDRESS_ERROR = 41043;
        public static final int CREATE_ORDER_BILL_INFO_ERROR = 44100;
        public static final int CREATE_ORDER_BUY_COUPON_ERROR = 41045;
        public static final int CREATE_ORDER_DELIVERY_METHOD = 47101;
        public static final int CREATE_ORDER_DUPLICATED_ORDER = 46900;
        public static final int CREATE_ORDER_EFO_RISK_ERROR = 41067;
        public static final int CREATE_ORDER_EFO_STATE_ERROR = 41049;
        public static final int CREATE_ORDER_EMPTY_SKU_ERROR = 41010;
        public static final int CREATE_ORDER_ETA_GAP = 41042;
        public static final int CREATE_ORDER_ETA_LONG = 41035;
        public static final int CREATE_ORDER_INVALIDATION_ERROR = 41068;
        public static final int CREATE_ORDER_ITEM_NONE = 41013;
        public static final int CREATE_ORDER_ITEM_NUM_MAX = 41040;
        public static final int CREATE_ORDER_LIMIT = 41090;
        public static final int CREATE_ORDER_LIMIT_ERROR = 41072;
        public static final int CREATE_ORDER_MINOR_CONFIRM = 41046;
        public static final int CREATE_ORDER_MINOR_TIP = 41047;
        public static final int CREATE_ORDER_MONEY_LOWER_THAN_PAY_CHANNEL = 41094;
        public static final int CREATE_ORDER_NOT_PAY = 41025;
        public static final int CREATE_ORDER_ORDER_INFO_ERROR = 41034;
        public static final int CREATE_ORDER_OUT_OPEN_CITY = 41036;
        public static final int CREATE_ORDER_PAY_INFO_ERROR1 = 41038;
        public static final int CREATE_ORDER_PAY_INFO_ERROR2 = 41039;
        public static final int CREATE_ORDER_PRICE_DIFF = 41020;
        public static final int CREATE_ORDER_REGULAR_RISK_ERROR = 41069;
        public static final int CREATE_ORDER_RISK_CANNOT_CREATE = 41053;
        public static final int CREATE_ORDER_RISK_CANNOT_USE_CASH = 41054;
        public static final int CREATE_ORDER_RISK_CANNOT_USE_CREDIT_CARD = 41055;
        public static final int CREATE_ORDER_RISK_CHECK_ID = 41060;
        public static final int CREATE_ORDER_RISK_NEED_EX_VALIDATE = 41063;
        public static final int CREATE_ORDER_RISK_NO_COUPON = 41051;
        public static final int CREATE_ORDER_SHOP_NOT_OPEN = 41032;
        public static final int CREATE_ORDER_SHOP_OUT_RANGE = 41033;
        public static final int CREATE_ORDER_UNKNOWN_CODE = -1;
        public static final int CREATE_ORDER_UNREACH_DELIVERY = 40115;
        public static final int DEBT_ORDER_REPAY_RISK_NEED_EX_VALIDATE = 48201;
        public static final int EDIT_ADDRESS_NAME_ERROR = 42424;
        public static final int ERROR_40104 = 40104;
        public static final int ERROR_50001 = 50001;
        public static final int ERROR_50002 = 50002;
        public static final int ERROR_50004 = 50004;
        public static final int ORDER_ADDRESS_CHANGED_ERROR = 42423;
        public static final int PROTECT_PHONE_INVAIL_ERROR = 46588;

        private Code() {
        }
    }

    public static final class LogoutReasons {
        private static final String CLIENT_VERSION_IS_OLD = "clientVersionIsOld";
        private static final String LOGIN_ANOTHER_PLACE = "loginAnotherPlace";
        private static final String LOGOUT_DEVIDER = "_";
        private static final String LOGOUT_PREFIX = "rlab";
        private static final String NOT_LOGIN_ERROR = "notLoginError";
        private static final String REQUEST_PARAMS_ERROR = "requestParamsError";
        private static final String TOKEN_VALIDATE_FAILED = "tokenValidateFailed";
        private static final String USERS_ARE_BLOCKED = "usersAreBlocked";
        private static final ArrayMap<Integer, String> mReasonMap;

        static {
            ArrayMap<Integer, String> arrayMap = new ArrayMap<>();
            mReasonMap = arrayMap;
            arrayMap.put(50001, REQUEST_PARAMS_ERROR);
            mReasonMap.put(50002, NOT_LOGIN_ERROR);
            mReasonMap.put(50004, CLIENT_VERSION_IS_OLD);
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
