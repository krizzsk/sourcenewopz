package com.didi.payment.creditcard.open;

import java.io.Serializable;

public class DidiGlobalDeleteCardData {

    public static class DeleteCardParam implements Serializable {
        public String cardIndex;
        public String cardNo;
        public int expired;
        public String expiryDate;
        public String resourceId;
    }
}
