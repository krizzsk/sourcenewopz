package com.didi.payment.transfer.common;

public class PayEventKeys {

    public static class Common {
        public static final String EVENT_KEY_DISMISSLOADING = "event_key_dismissloading";
        public static final String EVENT_KEY_SHOWLOADING = "event_key_showloading";
    }

    public static class FragmentForward {
        public static String EVENT_FORWARD_TO_ADDNEW_ACCOUNT = "forward_to_add_account_fragment";
        public static String EVENT_FORWARD_TO_BANKLIST_TRANAMOUNT = "forward_to_banklist_fragment";
        public static String EVENT_FORWARD_TO_CONFIRM_TRANAMOUNT = "forward_to_confirm_trans_amount_fragment";
    }

    public static class TransferFillAmount {
        public static String EVENT_KEY_GOTO_EDIT_AMOUNT = "event_key_goto_edit_amount_page";
    }
}
