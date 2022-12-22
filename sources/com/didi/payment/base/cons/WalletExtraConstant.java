package com.didi.payment.base.cons;

public class WalletExtraConstant {

    public static class Key {
        public static final String ACTIVITY_TEXT = "activity_text";
        public static final String ACTIVITY_URL = "activity_url";
        public static final String AMOUNT_RICH_TEXT = "amountRichText";
        public static final String BALANCE_ACCOUNT_INFO = "balance_account_info";
        public static final String BALANCE_ACCOUNT_STATUS = "balance_account_status";
        public static final String BALANCE_AMOUNT = "balance_amount";
        public static final String BALANCE_DETAILS = "balance_details";
        public static final String BALANCE_TAB = "balance_tab";
        public static final String BARCODE = "barcode";
        public static final String CHANNEL_ID = "channelId";
        public static final String CRASH_PAGE_SUBTITLE = "crash_page_subtitle";
        public static final String CRASH_PAGE_TITLE = "crash_page_title";
        public static final String CRASH_TYPE = "crash_type";
        public static final String FROM = "key_from";
        @Deprecated
        public static final String FROM_XPANEL = "key_from_wallet";
        public static final String FULL_KYC_ADDRESS_PAGE_FROM = "full_kyc_address_inbound_source";
        public static final String HAS_INTEREST = "has_interest";
        public static final String KEY_BLOCK_DATA = "key_block_data";
        public static final String KEY_FULL_KYC_CHANNEL_TYPE = "type";
        public static final String PAGE_FROM_KYC = "page_from_kyc";
        public static final String PAGE_REFER = "page_refer";
        public static final String PARAM_EXT = "ext";
        public static final String PHOTO_URI = "photo_uri";
        public static final String PRODUCT_LINE = "product_line";
        public static final String PUB_PAGE_FROM = "pub_page_from";
        public static final String REMOVE = "remove";
        public static final String RISK_LIMIT_REMINDER = "risk_limit_reminder";
        public static final String TERMINAL_ENV = "env";
        public static final String TERMINAL_ID = "terminal_id";
        public static final String TOPUP_INFO = "key_topup_info";
        public static final String WALLET_SIDEBAR_PAGE_MODEL = "wallet_sidebar_page_model";
    }

    public static class RequestCode {
        public static final int REQ_CODE_ADD_CARD = 1;
        public static final int REQ_CODE_ADD_PAYPAL = 3;
        public static final int REQ_CODE_BALANCE_ACCOUNT_DETAIL = 7;
        public static final int REQ_CODE_CARD_DETAIL = 2;
        public static final int REQ_CODE_ENTERPRISE = 5;
        public static final int REQ_CODE_PAYPAL_DETAIL = 4;
        public static final int REQ_CODE_TOPUP_AMOUNT = 8;
        public static final int REQ_CODE_TOPUP_CHANNEL = 10;
        public static final int REQ_CODE_UPDATE_CARD = 6;
        public static final int REQ_CODE_VERIFY_BALANCE = 5;
        public static final int REQ_CODE_WALLET_HOME = 9;
    }

    public static class Value {
        public static final int BALANCE_TAB_CALLBACK = 8;
        public static final int BALANCE_TAB_HISTORY = 6;
        public static final int BALANCE_TAB_INTEREST = 7;
        public static final int FROM_COMMON = 0;
        public static final int FROM_ESTIMATE_PAYSELECT = 2;
        public static final int FROM_WALLET_HOME = 3;
        public static final int FROM_WALLET_SIDEBAR = 5;
        public static final int FROM_WALLET_UNIPAY = 4;
        public static final int FROM_XPANEL = 1;
        public static final int FULL_KYC_ADDRESS_PAGE_FROM_KYC_STATUS_ON_CHECK = 0;
        public static final int FULL_KYC_ADDRESS_PAGE_FROM_KYC_STATUS_PIX_GUIDE = 2;
        public static final int FULL_KYC_ADDRESS_PAGE_FROM_KYC_STATUS_SUCCEED = 1;
        public static final String FULL_KYC_CHANNEL_TYPE_99 = "99";
    }
}
