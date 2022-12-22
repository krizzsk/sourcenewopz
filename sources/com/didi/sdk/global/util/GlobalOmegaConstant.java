package com.didi.sdk.global.util;

public class GlobalOmegaConstant {

    public static class EnterprisePage {

        public static class EventId {
            public static final String GP_CORPORATE_COMPANY_BTN_CK = "gp_corporate_companybtn_ck";
            public static final String GP_CORPORATE_COMPANY_RETURN_CK = "gp_corporate_company_return_ck";
            public static final String GP_CORPORATE_COMPANY_SW = "gp_corporate_company_sw";
            public static final String GP_CORPORATE_CONTINUE_BTN_CK = "gp_corporate_continuebtn_ck";
            public static final String GP_CORPORATE_COSTCENTER_BTN_CK = "gp_corporate_costcenterbtn_ck";
            public static final String GP_CORPORATE_COSTCENTER_RETURN_CK = "gp_corporate_costcenter_return_ck";
            public static final String GP_CORPORATE_COSTCENTER_SW = "gp_corporate_costcenter_sw";
            public static final String GP_CORPORATE_PROJECT_BTN_CK = "gp_corporate_projectbtn_ck";
            public static final String GP_CORPORATE_PROJECT_RETURN_CK = "gp_corporate_project_return_ck";
            public static final String GP_CORPORATE_PROJECT_SW = "gp_corporate_project_sw";
            public static final String GP_PAYMENT_ADD_CORPORATE_CK = "gp_payment_addcorporate_ck";
            public static final String GP_PAYMENT_EDIT_CORPORATE_CK = "gp_payment_editcorporate_ck";
        }

        public static class EventKey {
            public static final String CITY_ID = "city_id";
            public static final String COUNTRY_CODE = "country_code";
            public static final String PASSENGER_ID = "passenger_id";
            public static final String PAYMENT_MOTHOD = "paymentmethod";
            public static final String SOURCE = "source";
        }

        public static class EventValue {
            public static final int FROM_GUIDE = 2;
            public static final int FROM_PAY = 1;
            public static final int FROM_SIDEBAR = 3;
            public static final int FROM_UNIFIED_PAY = 4;
        }
    }

    public static class GlobalBalanceDetailPage {

        public static class EventId {
            public static final String GLOBAL_PAS_BALANCE_DETAIL_CK = "gp_balance_detail_ck";
            public static final String GLOBAL_PAS_BALANCE_SW = "gp_balance_view_sw";
            public static final String GLOBAL_PAS_BALANCE_TOPUP_CK = "gp_balance_topup_ck";
        }

        public static class EventKey {
            public static final String CITY_ID = "city_id";
            public static final String PASSENGER_ID = "passenger_id";
        }
    }

    public static class PayMethodSelectPage {

        public static class BalanceSwitchType {
            public static final int SWITCHED_OFF = 0;
            public static final int SWITCHED_ON = 1;
            public static final int SWITCH_OFF_NOT_ALLOW = 3;
            public static final int SWITCH_ON_NOT_ALLOWED = 2;
        }

        public static class EventId {
            public static final String GLOBAL_PAS_PAYMENT_CASH_CK = "global_pas_payment_cash_ck";
            public static final String GLOBAL_PAS_PAYMENT_CREDIT_CK = "global_pas_payment_credit_ck";
            public static final String GLOBAL_PAS_PAYMENT_ENTERPRISE_CK = "global_pas_payment_enterprise_ck";
            public static final String GLOBAL_PAS_PAYMENT_PAYPAL_CK = "global_pas_payment_paypal_ck";
            public static final String GLOBAL_PAS_PAYMENT_POS_CK = "global_pas_payment_pos_ck";
            public static final String GLOBAL_PAS_PAYMENT_RETURN_CK = "global_pas_payment_return_ck";
            public static final String GLOBAL_PAS_PAYMENT_SW = "global_pas_payment_sw";
            public static final String GLOBAL_PAS_PAYMENT_SWITCH_BANKCARD = "global_pas_payment_switch_bankcard";
            public static final String GLOBAL_PAS_PAYMENT_SWITCH_PAYMETHOD = "global_pas_payment_switch_paymethod";
            public static final String GP_PAYLIST_PAGE_BALANCEPRE_SWITCH_CK = "ibt_gp_paylist_page_balancepre_switch_ck";
            public static final String GP_PAYMENT_BALANCE_CK = "gp_payment_balance_ck";
        }

        public static class EventKey {
            public static final String BALANCE_SWITCH_TYPE = "type";
            public static final String CAMPAIGN_STATUS = "campaign_status";
            public static final String CARD_COUNT = "card_count";
            public static final String CITY_ID = "city_id";
            public static final String PASSENGER_ID = "passenger_id";
            public static final String PAYMENT = "payment";
            public static final String RESOURCE_ID = "resource_id";
            public static final String SOURCE = "source";
            public static final String TYPE = "type";
        }

        public static class EventValue {
            public static final int FROM_BIKE = 5;
            public static final int FROM_GUIDE = 2;
            public static final int FROM_PAY = 1;
            public static final int FROM_SIDEBAR = 3;
            public static final int FROM_UNIFIED_PAY = 4;
            public static final int TYPE_PAYMETHOD_ADDCARD = 3;
            public static final int TYPE_PAYMETHOD_NEXT = 1;
            public static final int TYPE_PAYMETHOD_SELECT = 2;
        }
    }

    public static class PayMethodSettingPage {

        public static class EventId {
            public static final String GLOBAL_PAS_PAYMENT_CASH_CK = "global_pas_payment_cash_ck";
            public static final String GLOBAL_PAS_PAYMENT_CREDIT_CK = "global_pas_payment_credit_ck";
            public static final String GLOBAL_PAS_PAYMENT_METHODS_CLOSE_CK = "global_pas_payment_methods_close_ck";
            public static final String GLOBAL_PAS_PAYMENT_METHODS_DISCOUNTS_CK = "global_pas_payment_methods_discounts_ck";
            public static final String GLOBAL_PAS_PAYMENT_PAYPAL_CK = "global_pas_payment_paypal_ck";
            public static final String GLOBAL_PAS_PAYMENT_POS_CK = "global_pas_payment_pos_ck";
            public static final String GLOBAL_PAS_PAYMENT_SW = "global_pas_payment_sw";
            public static final String GP_PAYMENT_PAYPALV2_CK = "gp_payment_paypalv2_ck";
            public static final String GP_WALLET_BALANCE_CK = "gp_wallet_balance_ck";
        }

        public static class EventKey {
            public static final String CARD_COUNT = "card_count";
            public static final String CITY_ID = "city_id";
            public static final String PASSENGER_ID = "passenger_id";
            public static final String PAYMENT = "payment";
            public static final String SOURCE = "source";
            public static final String TYPE = "type";
        }

        public static class EventValue {
            public static final int FROM_BIKE = 5;
            public static final int FROM_GUIDE = 2;
            public static final int FROM_PAY = 1;
            public static final int FROM_SIDEBAR = 3;
            public static final int FROM_UNIFIED_PAY = 4;
            public static final int TYPE_PAYMETHOD_ADDCARD = 3;
            public static final int TYPE_PAYMETHOD_NEXT = 1;
        }
    }

    public static class PayPalDetailPage {

        public static class EventId {
            public static final String GLOBAL_PAS_PAYPAL_REMOVE_CANCEL_CK = "global_pas_paypal_remove_cancel_ck";
            public static final String GLOBAL_PAS_PAYPAL_REMOVE_CK = "global_pas_paypal_remove_ck";
            public static final String GLOBAL_PAS_PAYPAL_REMOVE_OK_CK = "global_pas_paypal_remove_ok_ck";
            public static final String GLOBAL_PAS_PAYPAL_RETURN_CK = "global_pas_paypal_return_ck";
            public static final String GLOBAL_PAS_PAYPAL_SW = "global_pas_paypal_sw";
        }

        public static class EventKey {
            public static final String CITY_ID = "city_id";
            public static final String PASSENGER_ID = "passenger_id";
        }
    }
}
