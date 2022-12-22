package com.didi.payment.wallet.global.wallet.entity;

import com.didi.payment.commonsdk.basemodel.account.AccountFreezeData;
import com.didi.payment.wallet.global.model.resp.WalletHomeResp;
import com.didi.payment.wallet.global.model.resp.WalletPageQueryResp;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

public class WalletPageInfo implements Serializable {
    public WalletPageQueryResp.AccountSectionItem accountSection;
    public BalanceSection balanceSection;
    public WalletHomeResp.ConsumeSection consumeSection;
    public WalletPageQueryResp.ExtendEntrySection extendEntrySection;
    public WalletPageQueryResp.FinanceSection financeSection;
    @SerializedName("freezeSection")
    public AccountFreezeData freezonData;
    public WalletPageQueryResp.NewPaymentMethodSectionBean newPayMethodSection;
    public PayMethodSection payMethodSection;
    public WalletPageQueryResp.PaymentMethodEntryItemBean paypalItem;
    public WalletHomeResp.PixEntrySection pixSection;
    public PromotionSection promotionSection;
    public String serviceCenterUrl;
    public String title;

    public static class AddPayMethodEntry implements Serializable {
        public String desc;
        public AddPayMethodEntryDialogInfo dialogInfo;
        public String iconUrl;
        public String title;
    }

    public static class AddPayMethodEntryDialogInfo implements Serializable {
        public List<AddPayMethodEntryDialogItem> signEntries;
        public String title;
    }

    public static class AddPayMethodEntryDialogItem implements Serializable {
        public int channelId;
        public String desc;
        public String iconUrl;
        public String linkUrl;
        public String name;
    }

    public static class BalanceItem implements Serializable {
        public static final String DISCOUNT = "discount";
        public static final String MOBILEPREPAID = "refill";
        public static final int STATUS_OK = 1;
        public static final String TOPUP = "topup";
        public String iconUrl;

        /* renamed from: id */
        public String f32015id;
        public String linkUrl;
        public String promotionText;
        public int status;
        public String title;
    }

    public static class BalanceSection implements Serializable {
        public String bannerLinkUrl;
        public String bannerUrl;
        public String currency;
        public String desc;
        public String helpUrl;
        public String linkUrl;
        public List<BalanceItem> menuItems;
        public int status;
        public String symbol;
        public String title;
        public String value;
    }

    public static class PayMethodItem implements Serializable {
        public static final short CARD_EXPIRED = 1;
        public static final short CARD_STATUS_VERIFY = 1;
        public String cardExpiryDate;
        public String cardIndex;
        public int cardStatus;
        public int channelId;
        public String desc;
        public int expired;
        public String expiredDesc;
        public String iconUrl;
        public String linkUrl;
        public String profileIdentifier;
        public int signStatus;
        public String title;
    }

    public static class PayMethodSection implements Serializable {
        public String helpUrl;
        public List<PayMethodItem> payMethodItems;
        public AddPayMethodEntry signEntry;
        public String title;
    }

    public static class PromotionItem implements Serializable {
        public String desc;
        public String iconUrl;
        public String linkUrl;
        public String title;
    }

    public static class PromotionSection implements Serializable {
        public String desc;
        public String helpUrl;
        public List<PromotionItem> promotionItems;
        public String title;
    }
}
