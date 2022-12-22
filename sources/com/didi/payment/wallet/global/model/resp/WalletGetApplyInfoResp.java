package com.didi.payment.wallet.global.model.resp;

import com.didi.payment.commonsdk.net.WBaseResp;

public class WalletGetApplyInfoResp extends WBaseResp {
    public CPFInfo data;

    public static class CPFInfo {
        public String birthdate;
        public String email;
        public String name;
        public PromotionActivity promotionRule;
        public String subTitle;
        public String taxId;
        public String termsUrl;
    }

    public static class PromotionActivity {
        public String text;
        public String url;
    }
}
