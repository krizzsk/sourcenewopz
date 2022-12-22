package com.didi.payment.pix.constant;

public class PixConstants {
    public static final int PRODUCT_LINE_BALANCE_TOP_UP = 650;
    public static final int PRODUCT_LINE_PIX = 99996;

    public static class BundleKeys {
        public static final String KEY_BANK_METADATA = "bank_metadata";
        public static final String KEY_DETECTED_QRCODE = "detected_qrcode";
        public static final String KEY_ORDER_DETAIL = "order_detail";
        public static final String KEY_ORDER_ID = "order_id";
        public static final String KEY_PIX_ACCOUNT = "pix_account";
        public static final String KEY_SOURCE_PAGE = "source_page";
        public static final String TARGET_FRAGMENT = "target_fragment";
    }

    public static class OmegaKeys {
        public static final String ORDER_ID = "order_id";
    }

    public static class OrderType {
        public static final int ORDER_TYPE_PIX_0 = 0;
        public static final int ORDER_TYPE_PIX_1 = 1;
    }

    public static class TradeType {
        public static final int TRADE_TYPE_BANK_3 = 3;
        public static final int TRADE_TYPE_PIX_1 = 1;
        public static final int TRADE_TYPE_QRSCAN_2 = 2;
    }

    public static class WebPage {
        public static final String WEB_99_DOWN_PAGE = "https://rebrand.ly/99pay";
    }
}
