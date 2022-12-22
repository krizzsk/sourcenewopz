package com.didi.payment.wallet.global.omega;

public class GlobalOmegaConstant {

    public static class AccountBalancePage {

        public static class EventId {
            public static final String GLOBAL_99PAY_ACCOUNT_BALANCE_VIEW_SW = "gp_99pay_balance_view_sw";
        }
    }

    public static class BankTransferPage {

        public static class EventId {
            public static final String GLOBAL_99PAY_CHARGE_BANK_INFORMATION_SW = "gp_99pay_charge_bankinformation_sw";
        }
    }

    public static class BoletoAddressPatchDetailPage {

        public static class EventId {
            public static final String GLOBAL_99PAY_CHARGE_BOLETO2_CONFIRM_CK = "gp_99pay_charge_boleto2_confirm_ck";
            public static final String GLOBAL_99PAY_CHARGE_BOLETO2_SW = "gp_99pay_charge_boleto2_sw";
        }
    }

    public static class BoletoAddressPatchZipcodePage {

        public static class EventId {
            public static final String GLOBAL_99PAY_CHARGE_BOLETO1_CONFIRM_CK = "gp_99pay_charge_boleto1_confirm_ck";
            public static final String GLOBAL_99PAY_CHARGE_BOLETO1_SW = "gp_99pay_charge_boleto1_sw";
        }
    }

    public static class BoletoHistoryPage {

        public static class EventId {
            public static final String BOLETO_HISTORY_CANCEL_ORDER_CK = "ibt_didipay_pay_boleto_cancel_order_ck";
            public static final String BOLETO_HISTORY_CANCEL_ORDER_EXIT_CK = "ibt_didipay_pay_boleto_cancel_order_exit_ck";
            public static final String BOLETO_HISTORY_CANCEL_ORDER_SW = "ibt_didipay_pay_boleto_cancel_order_sw";
            public static final String BOLETO_HISTORY_COMPLETED_CK = "ibt_didipay_pay_boleto_history_completed_ck";
            public static final String BOLETO_HISTORY_COMPLETED_SW = "ibt_didipay_pay_boleto_history_completed_sw";
            public static final String BOLETO_HISTORY_EXIT_CK = "ibt_didipay_pay_boleto_history_exit_ck";
            public static final String BOLETO_HISTORY_UNPAID_CK = "ibt_didipay_pay_boleto_history_unpaid_ck";
            public static final String BOLETO_HISTORY_UNPAID_ORDER_CANCEL_CK = "ibt_didipay_pay_boleto_unpaid_order_cancel_ck";
            public static final String BOLETO_HISTORY_UNPAID_ORDER_PAY_CK = "ibt_didipay_pay_boleto_unpaid_order_pay_ck";
            public static final String BOLETO_HISTORY_UNPAID_SW = "ibt_didipay_pay_boleto_history_unpaid_sw";
            public static final String BOLETO_NO_KYC_GEN_BOLETO_SW = "ibt_gp_didipay_is_gen_boleto_sw";
            public static final String BOLETO_NO_KYC_GOT_IT_CK = "ibt_gp_didipay_is_gen_boleto_got_it_ck";
            public static final String BOLETO_NO_KYC_PENDING_SW = "ibt_gp_didipay_pay_boleto_order_kyc_pending_sw";
            public static final String BOLETO_NO_KYC_SIGNUP_CK = "ibt_gp_didipay_is_gen_boleto_signup_ck";
            public static final String GLOBAL_99PAY_BILLS_BILL_CK = "gp_99pay_bills_bill_ck";
            public static final String GLOBAL_99PAY_BILLS_VIEW_SW = "gp_99pay_bills_view_sw";
        }
    }

    public static class BoletoSendEmailDialog {

        public static class EventId {
            public static final String GLOBAL_99PAY_SENDEMAIL_CONFIRM_CK = "gp_99pay_bill_sendemail_confirm_ck";
        }
    }

    public static class BoletoTopUpAmountPage {

        public static class EventId {
            public static final String GLOBAL_99PAY_CHARGE_AMOUNT_BOLETO_CK = "gp_99pay_charge_amount_boleto_ck";
            public static final String GLOBAL_99PAY_CHARGE_AMOUNT_CONFIRM_CK = "gp_99pay_charge_amount_confirm_ck";
            public static final String GLOBAL_99PAY_CHARGE_AMOUNT_VIEW = "gp_99pay_charge_amount_view";
        }
    }

    public static class PayMethodSettingPage {

        public static class EventId {
            public static final String GLOBAL_PAS_PAYMENT_CASH_CK = "global_pas_payment_cash_ck";
            public static final String GLOBAL_PAS_PAYMENT_CREDIT_CK = "global_pas_payment_credit_ck";
            public static final String GLOBAL_PAS_PAYMENT_METHODS_CLOSE_CK = "global_pas_payment_methods_close_ck";
            public static final String GLOBAL_PAS_PAYMENT_METHODS_DISCOUNTS_CK = "global_pas_payment_methods_discounts_ck";
            public static final String GLOBAL_PAS_PAYMENT_PAYPAL_CK = "global_pas_payment_paypal_ck";
            public static final String GLOBAL_PAS_PAYMENT_PAYPAY_CK = "global_pas_payment_paypay_ck";
            public static final String GLOBAL_PAS_PAYMENT_POS_CK = "global_pas_payment_pos_ck";
            public static final String GLOBAL_PAS_PAYMENT_SW = "global_pas_payment_sw";
            public static final String GP_BALANCE_MBP_CK = "gp_balance_MbP_ck";
            public static final String GP_BALANCE_PHOTO_CK = "gp_balance_photo_ck";
            public static final String GP_BALANCE_TOPUP_CK = "gp_balance_topup_ck";
            public static final String GP_PAYMENT_PAYPALV2_CK = "gp_payment_paypalv2_ck";
            public static final String GP_RECHARGECANCEL_BTN_CK = "gp_rechargeCancel_btn_ck";
            public static final String GP_RECHARGE_BTN_CK = "gp_recharge_btn_ck";
            public static final String GP_RECHARGE_POPUP_SW = "gp_recharge_popup_sw";
            public static final String GP_WALLET_ADDPMT_CK = "gp_wallet_addPmt_ck";
            public static final String GP_WALLET_BALANCEQA_CK = "gp_wallet_balanceQa_ck";
            public static final String GP_WALLET_BALANCE_CK = "gp_wallet_balance_ck";
            public static final String GP_WALLET_BALANCE_SW = "gp_wallet_balance_sw";
            public static final String GP_WALLET_METHODQA_CK = "gp_wallet_methodQa_ck";
            public static final String GP_WALLET_POPUPCLOSE_CK = "gp_wallet_popupClose_ck";
            public static final String GP_WALLET_POPUP_SW = "gp_wallet_popup_sw";
        }

        public static class EventKey {
            public static final String CARD_COUNT = "card_count";
            public static final String CITY_ID = "city_id";
            public static final String PASSENGER_ID = "passenger_id";
            public static final String SOURCE = "source";
            public static final String TYPE = "type";
        }

        public static class EventValue {
            public static final int FROM_SIDEBAR = 3;
            public static final int TYPE_PAYMETHOD_ADDCARD = 3;
            public static final int TYPE_PAYMETHOD_NEXT = 1;
        }
    }

    public static class SkuRiskLimit {
        public static final String PUB_PAGE_BOLETO_BILL_DETAIL = "boleto_bill_detail";
        public static final String PUB_PAGE_BOLETO_IMPORT_METHOD = "boleto_import_method";
        public static final String PUB_PAGE_BOLETO_ORDERS = "boleto_orders";
        public static final String PUB_PAGE_TOPUP = "topup";
        public static final String PUB_PAGE_TRANSFER_METHOD = "transfer_method";
    }

    public static class TopUpCardPaymentPage {

        public static class EventId {
            public static final String GLOBAL_TOPUP_CARD_PAYMENT_CONFIRM_CK = "ibt_gp_didipay_charge_bankcard_confrim_ck";
            public static final String GLOBAL_TOPUP_CARD_PAYMENT_SW = "ibt_gp_didipay_charge_bankcard_sw";
        }
    }

    public static class TopUpChannelPage {

        public static class EventId {
            public static final String GLOBAL_TOPUP_99PAY_CHARGE_BANK_CK = "gp_99pay_charge_bank_ck";
            public static final String GLOBAL_TOPUP_99PAY_CHARGE_BOLETO_CK = "gp_99pay_charge_boleto_ck";
            public static final String GLOBAL_TOPUP_99PAY_CHARGE_VIEW_SW = "gp_99pay_charge_view_sw";
            public static final String GLOBAL_TOPUP_CARD_PAYMENT_CK = "ibt_gp_didipay_charge_bankcard_ck";
        }
    }

    public static class TopUpPage {

        public static class EventId {
            public static final String GLOBAL_TOPUP_COFIRM_CK = "gp_topup_detail_confirm_btn_ck";
            public static final String GLOBAL_TOPUP_DETAIL_SW = "gp_topup_detail_view_sw";
            public static final String GLOBAL_TOPUP_OFFLINE_CK = "gp_topup_offline_btn_ck";
            public static final String GLOBAL_TOPUP_ONLINE_CK = "gp_topup_online_btn_ck";
        }
    }

    public static class ViewBoletoPage {

        public static class EventId {
            public static final String GLOBAL_99PAY_BILL_COPY_CK = "gp_99pay_bill_copy_ck";
            public static final String GLOBAL_99PAY_BILL_DETAIL_CK = "gp_99pay_bill_detail_ck";
            public static final String GLOBAL_99PAY_BILL_SENDEMAIL_CK = "gp_99pay_bill_sendemail_ck";
            public static final String GLOBAL_99PAY_BILL_VIEW_SW = "gp_99pay_bill_view_sw";
        }
    }
}
