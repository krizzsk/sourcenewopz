package com.didi.payment.creditcard.open;

import java.io.Serializable;

public class DidiGlobalVerifyCardData {

    public static class VerifyCardParam implements Serializable {
        public String cardIndex;
        public String cardNo;
        public String productId;
    }
}
