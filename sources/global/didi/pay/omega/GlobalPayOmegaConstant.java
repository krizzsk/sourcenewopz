package global.didi.pay.omega;

public class GlobalPayOmegaConstant {

    public static class EventId {
        public static final String GLOBAL_PAS_PAYMENT_CREDIT_CK = "global_pas_payment_credit_ck";
        public static final String GLOBAL_PAS_PAYMENT_ENTERPRISE_CK = "global_pas_payment_enterprise_ck";
        public static final String GLOBAL_PAS_PAYMENT_NINENINEPAY_CK = "global_pas_payment_99pay_ck";
        public static final String GLOBAL_PAS_PAYMENT_PAYPAL_CK = "global_pas_payment_paypal_ck";
        public static final String GLOBAL_PAS_PAYMENT_PAYPAY_CK = "global_pas_payment_paypay_ck";
        public static final String GLOBAL_PAS_PAYMENT_RETURN_CK = "global_pas_payment_return_ck";
        public static final String GLOBAL_PAS_PAYMENT_SW = "global_pas_payment_sw";
        public static final String GLOBAL_PAYFAILURE_FARE_CK = "payCard_detail_sw";
        public static final String GLOBAL_PAYFAILURE_PAYMENT_CK = "ibt_wallet_paycard_methods_change_ck";
        public static final String GP_PAYMENT_PAYPALV2_CK = "gp_payment_paypalv2_ck";
        public static final String IBT_GP_CASHIER_WAITPIX_SW = "ibt_gp_cashier_waitpix_sw";
        public static final String IBT_GP_PAYFAIL_POPUP_FAQ_CK = "ibt_gp_payfail_popup_faq_ck";
        public static final String IBT_THIRDSDK_CONFIRM_BTN_CK = "ibt_thirdsdk_confirm_btn_ck";
        public static final String IBT_THIRDSDK_PAYTYPE_PAGE_SW = "ibt_thirdsdk_paytype_page_sw";
        public static final String IBT_THIRDSDK_PAY_SUCCESS_PAGE_SW = "ibt_thirdsdk_pay_success_page_sw";
        public static final String PAY_BTN_CLICK_ID = "ibt_wallet_paycard_pay_ck";
        public static final String PAY_CARD_CLOSE_ID = "ibt_wallet_paycard_close_ck";
        public static final String PAY_CARD_SHOW_ID = "ibt_wallet_paycard_sw";
        public static final String PAY_CARD_WAIT_RESULT_ID = "payCard_resultwait_sw";
        public static final String PAY_FAILED_DIALOG_RETRY_ID = "payCard_ab_retry";
        public static final String PAY_FAILED_ID = "payCard_ab_sw";
        public static final String PAY_SUCCESS_ID = "payCard_suc";
        public static final String PAY_SWITCH_COUPON_ID = "ibt_wallet_paycard_coupon_ck";
        public static final String ibt_3ds_verify_result_ex = "ibt_3ds_verify_result_ex";
        public static final String ibt_3ds_verify_result_server_st = "ibt_3ds_verify_result_server_st";
        public static final String ibt_3ds_verify_st = "ibt_3ds_verify_st";
        public static final String ibt_didipay_installment_option_ck = "ibt_didipay_installment_option_ck";
        public static final String ibt_didipay_installment_option_sw = "ibt_didipay_installment_option_sw";
        public static final String ibt_didipay_installment_select_ck = "ibt_didipay_installment_select_ck";
        public static final String ibt_gp_cashier_noresult_cancel_ck = "ibt_gp_cashier_noresult_cancel_ck";
        public static final String ibt_gp_cashier_noresult_copy_ck = "ibt_gp_cashier_noresult_copy_ck";
        public static final String ibt_gp_cashier_noresult_retry_ck = "ibt_gp_cashier_noresult_retry_ck";
        public static final String ibt_gp_cashier_noresult_sw = "ibt_gp_cashier_noresult_sw";
        public static final String ibt_gp_cashier_pixpayment_cancel_ck = "ibt_gp_cashier_pixpayment_cancel_ck";
        public static final String ibt_gp_cashier_pixpayment_copycode_ck = "ibt_gp_cashier_pixpayment_copycode_ck";
        public static final String ibt_gp_cashier_pixpayment_paid_ck = "ibt_gp_cashier_pixpayment_paid_ck";
        public static final String ibt_gp_cashier_pixpayment_sw = "ibt_gp_cashier_pixpayment_sw";
        public static final String ibt_gp_cashier_waitpix_exit_ck = "ibt_gp_cashier_waitpix_exit_ck";
        public static final String ibt_gp_cashier_waitpix_time_sw = "ibt_gp_cashier_waitpix_time_sw";
        public static final String ibt_gp_pixpay_page_pix_ck = "ibt_gp_pixpay_page_pix_ck";
        public static final String ibt_gp_pixpay_page_sw = "ibt_gp_pixpay_page_sw";
    }

    public static class EventKey {
        public static final String APPID = "appid";
        public static final String APP_ID = "app_id";
        public static final String CARD_COUNT = "card_count";
        public static final String CITY_ID = "city_id";
        public static final String COUPON = "coupon";
        public static final String CURRENT_PAYMENT_TYPE = "current_payment_type";
        public static final String HAS_CREDIT_CARD = "has_credit_card";
        public static final String HAS_SUFFICENT_99PAY_BALANCE = "has_sufficent_99pay_balance";
        public static final String IBT_WALLET_INSTALLMENT_PLAN = "installment_plan";
        public static final String IBT_WALLET_INSTALLMENT_STATUS = "installment_status";
        public static final String IBT_WALLET_INSTALLMENT_TOAST = "installment_toast";
        public static final String IBT_WALLET_INSTALLMENT_amount = "amount";
        public static final String IBT_WALLET_IS_COUPON = "is_coupon";
        public static final String IBT_WALLET_PAY_METHOD = "pay_method";
        public static final String LAST_PAYMENT_TYPE = "last_payment_type";
        public static final String ORDER_ID = "order_id";
        public static final String OUT_TRADE_ID = "out_trade_id";
        public static final String PASSENGER_ID = "passenger_id";
        public static final String PAYMENT = "payment";
        public static final String PAYMETHOD_NAME = "paym";
        public static final String PAY_BUTTON_STATUS = "pay_button_status";
        public static final String PRODUCT_ID = "product_id";
        public static final String RESOURCE_ID = "resource_id";
        public static final String SOURCE = "source";
        public static final String STYLE = "style";
        public static final String TAB = "tab";
        public static final String TYPE = "type";
    }

    public static class EventValue {
        public static final int FROM_UNIFIED_PAY = 4;
        public static final int TYPE_PAYMETHOD_ADDCARD = 3;
        public static final int TYPE_PAYMETHOD_NEXT = 1;
        public static final int TYPE_PAYMETHOD_SELECT = 2;
    }
}
