package com.didi.payment.wallet.global.model.resp;

import com.didi.payment.base.service.IWalletService;
import com.didi.payment.base.view.PayRichInfo;
import com.didi.payment.commonsdk.basemodel.account.AccountFreezeData;
import com.didi.payment.commonsdk.net.WBaseResp;
import com.didi.payment.wallet.global.model.resp.model.WalletOperationSection;
import com.didi.sdk.util.TextUtil;
import com.didi.sdk.util.collection.CollectionUtil;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public class WalletHomeResp extends WBaseResp {
    public DataBean data;

    public static class AccountSection {
        public AccountFreezeData accountFreezeData;
        public IWalletService.AccountInfo accountStatus;
        @SerializedName("balanceAmount")
        public double balanceAmount;
        @SerializedName("balanceMessage")
        public PayRichInfo balanceMsg;
        public String buttonText;
        public int channelId;
        @SerializedName("bgColor")
        public String[] contentBgColors;
        public String currency;
        @SerializedName("detailsMessage")
        public String detailsMsg;
        @SerializedName("authenticationStatus")
        public String facialRecognitionStatus = "";
        public int fullKycStatus;
        @SerializedName("bhasInterest")
        public boolean hasInterest;
        @SerializedName("interestDetailMsg")
        public String interestDetailMsg;
        @SerializedName("interestMessage")
        public PayRichInfo interestMsg;
        @SerializedName("interestStatus")
        public int interestStatus;
        @SerializedName("bhasPromotion")
        public boolean isPromotion;
        public PayRichInfo mobileRechargeText;
        @SerializedName("promotionText")
        public PayRichInfo promotionHeader;
        @SerializedName("bgPicUrl")
        public String promotionHeaderImageUrl;
        @SerializedName("subPromotionText")
        public String promotionLabel;
        public String promotionLink;
        public int status;
        @SerializedName("statusMessage")
        public PayRichInfo statusMsg;
        public boolean supportFullKyc;
        @SerializedName("name")
        public String title;
    }

    public static class ConsumeItem implements Serializable {
        public String iconUrl;
        public boolean isBlocked;
        public String linkUrl;
        public String name;
        public int productLine;
        public PromotionActivity promotionRule;
        public String promotionText;
        public String promotionTextBgColor;
        public String promotionTextFontColor;
    }

    public static class ConsumeSection implements Serializable {
        public List<ConsumeItem> entryList;
        public String title;
    }

    public static class DataBean implements Serializable {
        @SerializedName("accountSection")
        public AccountSection accountSection;
        @SerializedName("scenarioSection")
        public ConsumeSection consumeSection;
        public String customerSupportUrl;
        @SerializedName("freezeSection")
        public AccountFreezeData freezonData;
        @SerializedName("panelSection")
        public WalletOperationSection operationSection;
        @SerializedName("allEntries")
        public PaymentMethodSection paymentSection;
        public PixEntrySection pixSection;
        @SerializedName("signSection")
        public SignEntrySection signSection;
    }

    public static class PaymentMethodItem implements Serializable {
        public String cardIndex;
        public int cardStatus;
        public int channelId;
        public String desc;
        public String expireDate;
        public int expired = -1;
        public String expiredDesc;
        public String iconUrl;
        public String linkUrl;
        public String name;
        public String profileIdentifier;
        public int signStatus;
    }

    public static class PaymentMethodSection {
        @SerializedName("entryList")
        public List<PaymentMethodItem> payMethodItems;
        @SerializedName("title")
        public String title;
        @SerializedName("promotionText")
        public String topTips;
    }

    public static class PixEntry implements Serializable {
        public String iconUrl;
        public boolean isBlocked;
        public String linkUrl;
        public String name;
        public String productLine;
        public int typeId;
    }

    public static class PromotionActivity implements Serializable {
        public String text;
        public String url;
    }

    public interface SectionValidator {
        boolean isValid();
    }

    public static class SignEntryItem {
        public int channelId;
        public String desc;
        public String iconUrl;
        public String linkUrl;
        public String name;
    }

    public static class SignEntrySection {
        public List<SignEntryItem> entryList;
        public String title;
    }

    public static boolean isSectionValid(SectionValidator sectionValidator) {
        return sectionValidator != null && sectionValidator.isValid();
    }

    public static class PixEntrySection implements SectionValidator, Serializable {
        public List<PixEntry> entryList;
        public String title;

        public boolean isValid() {
            return !TextUtil.isEmpty(this.title) && !CollectionUtil.isEmpty((Collection<?>) this.entryList);
        }
    }
}
