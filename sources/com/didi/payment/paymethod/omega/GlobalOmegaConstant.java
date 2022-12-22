package com.didi.payment.paymethod.omega;

public class GlobalOmegaConstant {

    public static class PayMethodPayPalPage {

        public static class EventId {
            public static final String GP_ADD_PAYPALV2_SUCESS = "gp_add_paypalv2_sucess";
            public static final String GP_PAYPALV2_REMOVE_CANCEL_CK = "gp_paypalv2_remove_cancel_ck";
            public static final String GP_PAYPALV2_REMOVE_CK = "gp_paypalv2_remove_ck";
            public static final String GP_PAYPALV2_REMOVE_OK_CK = "gp_paypalv2_remove_ok_ck";
        }

        public static class EventKey {
            public static final String CITY_ID = "city_id";
            public static final String PASSENGER_ID = "passenger_id";
            public static final String SOURCE = "source";
        }
    }

    public static class PayMethodPayPayPage {

        public static class EventId {
            public static final String GLOBAL_PAS_ADD_PAYPAY_SUCESS = "global_pas_add_paypay_sucess";
            public static final String GLOBAL_PAS_PAYPAY_REMOVE_CANCEL_CK = "global_pas_paypay_remove_cancel_ck";
            public static final String GLOBAL_PAS_PAYPAY_REMOVE_CK = "global_pas_paypay_remove_ck";
            public static final String GLOBAL_PAS_PAYPAY_REMOVE_OK_CK = "global_pas_paypay_remove_ok_ck";
        }

        public static class EventKey {
            public static final String CITY_ID = "city_id";
            public static final String PASSENGER_ID = "passenger_id";
            public static final String SOURCE = "source";
        }

        public static class EventValue {
            public static final int FROM_SIDEBAR = 3;
        }
    }
}
