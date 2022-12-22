package com.didi.payment.pix.constant;

public class PixRouter {
    public static final String INTENT_BUNDLE_KEY_PIX_ENTRY = "pix_entry";
    public static final String ROUTER_HISTORY_ORDER = "/pix_history";
    public static final String ROUTER_PIX_BANK_ACCOUNT = "/pix_bank_transfer";
    public static final String ROUTER_PIX_HOMEPAGE = "/myPix";
    public static final String ROUTER_PIX_KEY_LIST = "/pix_key_manager";
    public static final String ROUTER_PIX_ORDER_DETAIL = "/pix_order_detail";
    public static final String ROUTER_PIX_ORDER_REFUND = "/pix_order_refund";
    public static final String ROUTER_PIX_RECEIVE_HOME = "/pix_receive";
    public static final String ROUTER_PIX_SCAN_HOME = "/pix_scan";
    public static final String ROUTER_PIX_TRANSFER_HOME = "/pix_transfer";

    public static String build(String str) {
        if (!str.startsWith("/")) {
            return "99pay://one/" + str;
        }
        return "99pay://one" + str;
    }
}
