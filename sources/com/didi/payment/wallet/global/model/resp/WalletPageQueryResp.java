package com.didi.payment.wallet.global.model.resp;

import com.didi.payment.base.service.IWalletService;
import com.didi.payment.base.view.PayRichInfo;
import com.didi.payment.commonsdk.basemodel.account.AccountFreezeData;
import com.didi.payment.commonsdk.net.WBaseResp;
import com.didi.payment.wallet.global.model.resp.WalletHomeResp;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

public class WalletPageQueryResp extends WBaseResp {
    public static final short PHOENIX_SIGN_STATUS_CANCEL = 3;
    public static final short PHOENIX_SIGN_STATUS_INIT = 0;
    public static final short PHOENIX_SIGN_STATUS_SIGN = 1;
    public static final short PHOENIX_SIGN_STATUS_SIGNING = 2;
    public static final short PHONEIX_CARD_STATUS_VERIFY = 1;
    public static final short PHONEIX_SIGN_STATUS_BIND = 4;
    public DataBean data;

    public static class AccountSection implements Serializable {
        public List<AccountSectionItem> entryList;
    }

    public static class AccountSectionItem implements Serializable {
        public IWalletService.AccountInfo accountStatus;
        public double balanceAmount;
        public String buttonText;
        public int channelId;
        public String currency;
        public String detailsText;
        @SerializedName("authenticationStatus")
        public String facialRecognitionStatus = "";
        public AccountFreezeData freezeData;
        public int fullKycStatus;
        @SerializedName("bhasInterest")
        public boolean hasInterest;
        public String helpUrl;
        public int interestStatus;
        public String name;
        public String promotionText;
        public PayRichInfo richText;
        public int status;
        public boolean supportFullKyc;
        public String title;
    }

    public static class BalanceDataBean implements Serializable {
        public int channelId;
        public String currency;
        public String currencySymbol;
        public String desc;
        public boolean enabled;
        public String transDetailDesc;
        public String transDetailUrl;
        public String value;
        public int valueInCents;
    }

    public static class BalanceMenuItemBean implements Serializable {
        public boolean enabled;
        public BalanceMenuItemExtraDataBean extraData;
        public String iconUrl;

        /* renamed from: id */
        public String f31755id;
        public String linkUrl;
        public String name;
        public String promotionText;
    }

    public static class BalanceMenuItemExtraDataBean implements Serializable {
        public int channelId;
        public String currency;
    }

    public static class BalanceSectionBean implements Serializable {
        public BalanceDataBean balanceData;
        public String desc;
        public List<BalanceMenuItemBean> menuItems;
        public PromotionBannerBean promotionBanner;
        public String title;
        public String url;
    }

    public static class DataBean implements Serializable {
        @SerializedName("freezeSection")
        public AccountFreezeData accountFreezeData;
        public AccountSection accountSection;
        public BalanceSectionBean balanceSection;
        @SerializedName("scenarioSection")
        public WalletHomeResp.ConsumeSection consumeSection;
        public String customerSupportUrl;
        public ExtendEntrySection extendEntrySection;
        @SerializedName("myServiceSection")
        public FinanceSection financeSection;
        @SerializedName("allEntries")
        public NewPaymentMethodSectionBean newPaymentMethodSection;
        public PaymentData paymentData;
        @SerializedName("paymentMethodSection")
        public PaymentMethodSectionBean paymentMethodSectionOldServer;
        public WalletHomeResp.PixEntrySection pixSection;
        @SerializedName("promotionSection")
        public PromotionSectionBean promotionSectionOldServer;
        @SerializedName("show99PayAsChannel")
        public boolean sampleStyle;
        @SerializedName("signEntrySection")
        public SignEntrySectionBean signEntrySectionOldServer;
        public String title;
    }

    public static class ExtendEntrySection implements Serializable {
        public Transaction transaction;
    }

    public static class ExtraData implements Serializable {
    }

    public static class FinanceItem implements Serializable {
        public String desc;
        public boolean enabled;
        @SerializedName("extraData")
        public ExtraData extraData;
        public String iconUrl;

        /* renamed from: id */
        public String f31756id;
        public String linkUrl;
        public String name;
        public String promotionText;
    }

    public static class FinanceSection implements Serializable {
        public String desc;
        @SerializedName("menuItems")
        public List<FinanceItem> entryList;
        public String title;
        public String url;
    }

    public static class NewPaymentMethodSectionBean implements Serializable {
        public List<PaymentMethodEntryItemBean> entryList;
        public String title;
        @SerializedName("promotionText")
        public String topTips;
        public TransLink transLink;
    }

    public static class PaymentData implements Serializable {
        public PaymentMethodSectionBean paymentMethodSection;
        public PromotionSectionBean promotionSection;
        public SignEntrySectionBean signEntrySection;
    }

    public static class PaymentMethodEntryItemBean implements Serializable {
        public String cardIndex;
        public int cardStatus;
        public int channelId;
        public String desc;
        public String expireDate;
        public int expired = -1;
        public String expiredDesc;
        public AccountFreezeData freezeData;
        public String iconUrl;
        public String linkUrl;
        public String name;
        public String profileIdentifier;
        public int signStatus;
    }

    public static class PaymentMethodSectionBean implements Serializable {
        public String desc;
        public List<PaymentMethodEntryItemBean> entryList;
        public String title;
        public String url;
    }

    public static class PromotionBannerBean implements Serializable {
        public String imageUrl;
        public String linkUrl;
    }

    public static class PromotionEntryItemBean implements Serializable {
        public int channelId;
        public String desc;
        public String iconUrl;
        public String linkUrl;
        public String name;
    }

    public static class PromotionSectionBean implements Serializable {
        public String desc;
        public List<PromotionEntryItemBean> entryList;
        public String title;
        public String url;
    }

    public static class SignEntryItemBean implements Serializable {
        public int channelId;
        public String desc;
        public String iconUrl;
        public String linkUrl;
        public String name;
    }

    public static class SignEntrySectionBean implements Serializable {
        public String desc;
        public List<SignEntryItemBean> entryList;
        public String entryListTitle;
        public String title;
        public String url;
    }

    public static class TransLink implements Serializable {
        public String link;
        public String title;
    }

    public static class Transaction implements Serializable {
        public boolean enabled;
        public ExtraData extraData;
        public String iconUrl;

        /* renamed from: id */
        public String f31757id;
        public String linkUrl;
        public String name;
        public String promotionText;
    }
}
