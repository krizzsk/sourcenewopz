package com.didi.payment.transfer.channels;

import com.didi.payment.base.service.IWalletService;
import com.didi.payment.commonsdk.basemodel.account.AccountFreezeData;
import com.didi.payment.transfer.net.TransBaseResp;
import com.didi.payment.wallet.global.model.resp.LimitRiskReminderVo;
import com.didi.sdk.util.collection.CollectionUtil;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public class TransChannelResp extends TransBaseResp {
    @SerializedName("data")
    public DataBean data;

    public static class ChannelBean implements Serializable {
        @SerializedName("channelId")
        public String channelId;
        @SerializedName("desc")
        public String desc;
        @SerializedName("extraData")
        public String extraData;
        @SerializedName("iconUrl")
        public String iconUrl;
        @SerializedName("limitRiskReminder")
        public LimitRiskReminderVo limitRiskReminder;
        @SerializedName("linkUrl")
        public String linkUrl;
        @SerializedName("name")
        public String name;
        @SerializedName("productLine")
        public int productLine;
        @SerializedName("promotion")
        public String promotion;
    }

    public static class ExtraDataBrazilBankTransfer implements Serializable {
        @SerializedName("accountNumber")
        public String accountNumber;
        @SerializedName("agencyCode")
        public String agencyCode;
        @SerializedName("bankCode")
        public String bankCode;
        @SerializedName("holderName")
        public String holderName;
        @SerializedName("instruction")
        public String instruction;
    }

    public static class ExtraDataMexicoOnline implements Serializable {
        @SerializedName("online_top_up_items")
        public List<ExtraDataMexicoOnlineItem> online_top_up_items;
        @SerializedName("select_amount_page_title")
        public String select_amount_page_title;
        @SerializedName("select_amount_rule_text")
        public String select_amount_rule_text;
        @SerializedName("select_amount_text")
        public String select_amount_text;
        @SerializedName("top_up_button_text")
        public String top_up_button_text;
    }

    public static class ExtraDataMexicoOnlineItem implements Serializable {
        @SerializedName("currency")
        public String currency;
        @SerializedName("desc")
        public String desc;
        @SerializedName("extend_params")
        public String extend_params;
        @SerializedName("extra_info")
        public String extra_info;
        @SerializedName("name")
        public String name;
        @SerializedName("price")
        public int price;
        public boolean selected;
        @SerializedName("sku")
        public String sku;
    }

    public static class PromotionActivity {
        public String text;
        public String url;
    }

    public static class DataBean implements Serializable {
        @SerializedName("freezeSection")
        public AccountFreezeData accountFreezeStatus;
        @SerializedName("accountStatus")
        public IWalletService.AccountInfo accountInfo;
        @SerializedName("channelList")
        public List<ChannelBean> channelList;
        @SerializedName("collectAddress")
        public boolean collectAddress;
        @SerializedName("termsAndConditionText")
        public String conditionText;
        @SerializedName("history")
        public String historyTitle;
        @SerializedName("hitBankImprove")
        public boolean hitBankImprove;
        public int productLine;
        public String productLines;
        @SerializedName("promotionText")
        public String promotionText;
        @SerializedName("ruleText")
        public String ruleText;
        @SerializedName("status")
        public int status;
        @SerializedName("statusMessage")
        public String statusMsg;
        @SerializedName("termsAndConditionUrl")
        public String termsAndConditionUrl;
        public String title;

        public boolean isValid() {
            return !CollectionUtil.isEmpty((Collection<?>) this.channelList);
        }
    }
}
