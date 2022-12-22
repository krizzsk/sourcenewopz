package com.didi.payment.creditcard.global.omega;

public class GlobalOmegaConstant {

    public static class AddCardPage {

        public static class EventId {
            public static final String GLOBAL_PAS_ADDCARD_ADD_CK = "global_pas_addcard_add_ck";
            public static final String GLOBAL_PAS_ADDCARD_CARDNUMBER_CK = "global_pas_addcard_cardnumber_ck";
            public static final String GLOBAL_PAS_ADDCARD_CK = "global_pas_addcard_ck";
            public static final String GLOBAL_PAS_ADDCARD_CREDIT_CK = "global_pas_addcard_credit_ck";
            public static final String GLOBAL_PAS_ADDCARD_CVV_CK = "global_pas_addcard_cvv_ck";
            public static final String GLOBAL_PAS_ADDCARD_DEBIT_CK = "global_pas_addcard_debit_ck";
            public static final String GLOBAL_PAS_ADDCARD_EXPIRATION_CK = "global_pas_addcard_expiration_ck";
            public static final String GLOBAL_PAS_ADDCARD_RETURN_CK = "global_pas_addcard_return_ck";
            public static final String GLOBAL_PAS_ADDCARD_SW = "global_pas_addcard_sw";
            public static final String GLOBAL_PAS_CREDITCARD_CIDHLP_CL = "gp_creditcard_cidhlp_cl";
            public static final String GLOBAL_PAS_CREDITCARD_CVVHLP_CL = "gp_creditcard_cvvhlp_cl";
            public static final String GLOBAL_PAS_CREDITCARD_ERROR = "gp_creditcard_err";
            public static final String GLOBAL_PAS_CREDITCARD_VLDHLP_CL = "gp_creditcard_vldhlp_cl";
            public static final String GLOBAL_PAS_GRAYBUTTON_CK = "gp_graybutton_ck";
            public static final String GLOBAL_PAS_OCR_ENTER_PASSIVITY_CK = "gp_af_mandatory_entrance";
            public static final String GLOBAL_PAS_OCR_OPERATION_CK = "gp_user_cardbind_OCR";
            public static final String GLOBAL_PAS_OCR_PASSIVITY_CK = "gp_af_mandatory_OCR";
            public static final String GLOBAL_PAS_ORANGEBUTTON_CK = "gp_orangebutton_ck";
            public static final String GP_ADDCARDERRORBACK_BTN_CK = "gp_AddCardErrorBack_btn_ck";
            public static final String GP_ADDCARDERRORWAIT_BTN_CK = "gp_AddCardErrorWait_btn_ck";
            public static final String GP_ADDCARDERROR_POPUP_SW = "gp_AddCardError_popup_sw";
        }

        public static class EventKey {
            public static final String APP_ID = "app_id";
            public static final String BIND_TYPE = "bind_type";
            public static final String CAMPAIGN_STATUS = "campaign_status";
            public static final String CITY_ID = "city_id";
            public static final String ERR_NO = "errNo";
            public static final String INVALID_CARD_NO = "invalid_card_number";
            public static final String INVALID_CID = "invalid_cid_length";
            public static final String INVALID_CVV = "invalid_cvv_length";
            public static final String INVALID_NOT_SUPPORTED = "not_supported";
            public static final String INVALID_VALIDATION_DATE = "invalid_expiration_date";
            public static final String MANUAL_INPUT = "manual_input";
            public static final String OCR_SESSION = "ocr_session";
            public static final String OCR_STATUS = "ocr_status";
            public static final String PASSENGER_ID = "passenger_id";
            public static final String POPUPBUTTON_NAME = "add_card_now";
            public static final String POPUP_TYPE = "popup_type";
            public static final String PRODUCT_ID = "product_id";
            public static final String RESOURCE_ID = "resource_id";
            public static final String SAME_CHECK = "same_check";
            public static final String SOURCE = "source";
            public static final String STATUS = "status";
            public static final String USER_OCR_RESULT = "user_ocr_result";
            public static final String VERSION = "version";
        }

        public static class EventValue {
            public static final int FROM_GUIDE = 2;
            public static final int FROM_PAY = 1;
            public static final int FROM_SIDEBAR = 3;
            public static final int FROM_UNIFIED_PAY = 4;
            public static final int RESULT_FAIL = 0;
            public static final int RESULT_SUCC = 1;
        }
    }

    public static class CardDetailPage {

        public static class EventId {
            public static final String GLOBAL_PAS_CREDIT_REMOVE_CANCEL_CK = "global_pas_credit_remove_cancel_ck";
            public static final String GLOBAL_PAS_CREDIT_REMOVE_CK = "global_pas_credit_remove_ck";
            public static final String GLOBAL_PAS_CREDIT_REMOVE_OK_CK = "global_pas_credit_remove_ok_ck";
            public static final String GLOBAL_PAS_CREDIT_RETURN_CK = "global_pas_credit_return_ck";
            public static final String GLOBAL_PAS_CREDIT_SW = "global_pas_credit_sw";
        }

        public static class EventKey {
            public static final String CITY_ID = "city_id";
            public static final String PASSENGER_ID = "passenger_id";
        }
    }

    public static class OcrPage {

        public static class EventId {
            public static final String GLOBAL_CREDITCARD_OCR_MNL_CK = "globalpas_creditcard_ocr_mnl_cl";
            public static final String GLOBAL_PAS_CREDITCARD_OCR_BCK_CK = "globalpas_creditcard_ocr_bck_cl";
            public static final String GLOBAL_PAS_CREDITCARD_OCR_CK = "globalpas_creditcard_ocr_cl";
            public static final String GLOBAL_PAS_CREDITCARD_OCR_TIME_CK = "globalpas_creditcard_ocr_time_cl";
        }

        public static class EventKey {
            public static final String CITY_ID = "city_id";
            public static final String DURATION = "duration";
            public static final String PHONE = "phone";
            public static final String UID = "uid";
        }
    }
}
