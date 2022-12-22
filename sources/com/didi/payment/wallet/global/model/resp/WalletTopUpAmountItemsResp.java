package com.didi.payment.wallet.global.model.resp;

import com.didi.payment.commonsdk.net.WBaseResp;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

public class WalletTopUpAmountItemsResp extends WBaseResp {
    @SerializedName("data")
    public DataBean data;

    public static class CashInLimitSection implements Serializable {
        public static final int CASHIN_LIMIT_SECTION_5K_LIMIT = 2;
        public static final int CASHIN_LIMIT_SECTION_RULE_LIMIT = 1;
        public VerifyDialog dialog;
        public String link;
        public String maximumAmount;
        public String selectAmountRuleText;
        public int type;
        public String verifyText;
    }

    public static class DataBean implements Serializable {
        @SerializedName("selectAmountText")
        public String amountText;
        @SerializedName("topUpButtonText")
        public String buttonText;
        @SerializedName("cashinLimitSection")
        public CashInLimitSection cashinLimitSection;
        public String disabledReason;
        @SerializedName("items")
        public List<TopupItem> items;
        @SerializedName("selectAmountPageTitle")
        public String pageTitle;
        @SerializedName("productLine")
        public int productLine;
        @SerializedName("selectAmountRuleText")
        public String ruleText;
    }

    public static class VerifyDialog implements Serializable {
        public String desc;
        public String kycLink;
        public String title;
    }

    public static class TopupItem implements Serializable {
        public static final String STATE_DISABLE = "1";
        @SerializedName("amount")
        public String amount;
        @SerializedName("currencySymbol")
        public String currency;
        @SerializedName("customer")
        public String customer;
        @SerializedName("desc")
        public String desc;
        public String disabled;
        @SerializedName("extra_info")
        public String extraInfo;
        public boolean isInput;
        @SerializedName("maxPrice")
        public String maxPrice;
        @SerializedName("metadata")
        public String metadata;
        @SerializedName("minPrice")
        public String minPrice;
        @SerializedName("name")
        public String name;
        @SerializedName("price")
        public String price;
        public boolean selected;

        public boolean isDisable() {
            return "1".equalsIgnoreCase(this.disabled);
        }
    }
}
