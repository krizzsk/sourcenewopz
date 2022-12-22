package com.didi.payment.wallet.global.constant;

public class WalletConstant {

    public static class ErrorCode {
        public static final int INVALID_HOMELAND_CITY = 1010;
        public static final int INVALID_TOKEN = 401;
        public static final int SYSTEM_MAINTENANCE = 405;
    }

    public static class IntentBundleKey {
        public static final String INTENT_PARAMS_ORDER_TOPUP_COFIRM_FLAG = "params_topup_confirm_flag";
        public static final String INTENT_PARAM_KEY_EXT_METADATA = "bundle_key_ext_metadata";
        public static final String INTENT_PARAM_KEY_FROM_PAGE = "intent_extra_from_page";
        public static final String INTENT_PARAM_KEY_ORDER_ID = "order_id";
        public static final String INTENT_PARAM_KEY_ORDER_TYPE = "order_type";
        public static final String INTENT_PARAM_KEY_PRODUCT_LINE = "product_line";
        public static final String INTENT_PARAM_KEY_UNPAID_BILLS = "intent_extra_unpaid_bills";
    }

    public static class OrderQueryType {
        public static final int ALL = -1;
        public static final int COMPLETED = 1;
        public static final int UNPAID = 0;
    }

    public static class OrderType {
        public static final int ORDER_TYPE_ALL = -1;
        public static final int ORDER_TYPE_TOPUP_0 = 0;
        public static final int ORDER_TYPE_TOPUP_1 = 1;
        public static final int ORDER_TYPE_TOPUP_2 = 2;
    }

    public static class Pages {
        public static final int PAGE_BOLETO_UNPAID = 260;
        public static final int PAGE_TOPUP_AMOUNT = 258;
        public static final int PAGE_TOPUP_CHANNELS = 259;
        public static final int PAGE_TOPUP_ORDERDETAIL = 257;
        public static final int PAGE_TOPUP_RECORD = 256;
    }

    public static class ProductLine {
        public static final int MEX_ONLINE_TOPUP_AMOUNT = 300;
        public static final int ONLINE_BITCOIN = 656;
        public static final int ONLINE_PRE_CARD = 665;
        public static final int ONLINE_TOPUP_BALANCE = 650;
        public static final int PIX_TRANSFER = 99996;
        public static final int REFILL_PHONE = 605;
        public static final int TRANSFER = 99999;
        public static final int UTILITIES = 606;
    }

    public static class TopUpChannelStatus {
        public static final int DISABLED = 1;
    }

    public static class URL {
        public static final String H5_99PAY_BALANCE_SERVICE = "https://help.didiglobal.com/passenger-index-new.html?source=99pay&kfPageSource=99pay";
        public static final String H5_99PAY_TERM_CONDITIONS = "https://99app.com/legal/termos/termos-e-condicoes-de-uso-de-conta-de-pagamento-pre-paga-99pay";
        public static final String H5_DRIVER_BOLETO_DETAILS = "https://page.99taxis.mobi/pay_intl_driver/wallet99_bank_transfer_boleto_payment/wallet99_bank_transfer_boleto_payment.html?jumpTo=BoletoNativeSDK";
        public static final String H5_NIGHTLY_LIMIT_HELP = "https://help.didiglobal.com/questionDetail.html?from=singleFAQ&entry=FAQ&qid=59999&kfPageSource=99pay";
        public static final String H5_UTILITIES_GUIDE = "http://99app.com/99pay/pagina-boletos/";
    }

    public class WalletStatus {
        public static final int STATUS_NONE = 0;
        public static final int STATUS_ON_CHECK = 2;
        public static final int STATUS_SIGN_UP_FAILED = 3;
        public static final int STATUS_SIGN_UP_SUCCEED = 1;

        public WalletStatus() {
        }
    }
}
