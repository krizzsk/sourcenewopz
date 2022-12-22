package com.didi.payment.wallet.global.model.resp;

import android.text.TextUtils;
import com.didi.payment.commonsdk.basemodel.account.AccountFreezeData;
import com.didi.payment.commonsdk.net.WBaseResp;
import com.didi.sdk.util.collection.CollectionUtil;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class WalletTopUpChannelResp extends WBaseResp {
    @SerializedName("data")
    public DataBean data;

    public static class ChannelBean implements Serializable {
        @SerializedName("channelId")
        public String channelId;
        @SerializedName("desc")
        public String desc;
        @SerializedName("disable")
        public boolean disable;
        @SerializedName("extraData")
        public String extraData;
        @SerializedName("iconUrl")
        public String iconUrl;
        @SerializedName("limitRiskReminder")
        public LimitRiskReminderVo limitRiskReminder;
        @SerializedName("limitRiskReminderText")
        public String limitRiskReminderText;
        @SerializedName("linkUrl")
        public String linkUrl;
        @SerializedName("name")
        public String name;
        @SerializedName("productLine")
        public int productLine;
        @SerializedName("promotion")
        public String promotion;
        @SerializedName("channelStatusInfo")
        public ChannelStatusInfo statusInfo;
    }

    public static class ChannelExtraData implements Serializable {
        @SerializedName("dialog")
        public RemindDialog dialog;
        @SerializedName("inputAmountRuleText")
        public String inputAmountRuleText;
        @SerializedName("link")
        public String link;
        @SerializedName("maximumAmount")
        public String maximumAmount;
        @SerializedName("minimumAmount")
        public String minimumAmount;
    }

    public static class ExtraDataBrazilBankTransfer implements Serializable {
        @SerializedName("accountNumber")
        public String accountNumber;
        @SerializedName("accountType")
        public String accountType;
        @SerializedName("agencyCode")
        public String agencyCode;
        @SerializedName("amountRuleText")
        public String amountRuleText;
        @SerializedName("bankCode")
        public String bankCode;
        @SerializedName("bankName")
        public String bankName;
        @SerializedName("holderName")
        public String holderName;
        @SerializedName("instruction")
        public String instruction;
        @SerializedName("link")
        public String link;
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

    public static class RemindDialog implements Serializable {
        public String desc;
        public String kycLink;
        public String title;
    }

    public static class DataBean implements Serializable {
        @SerializedName("freezeSection")
        public AccountFreezeData accountFreezeStatus;
        @SerializedName("channelList")
        public List<ChannelBean> channelList;
        @SerializedName("channelsTitle")
        public String channelsTitle;
        @SerializedName("collectAddress")
        public boolean collectAddress;
        @SerializedName("termsAndConditionText")
        public String conditionText;
        @SerializedName("remindDialog")
        public RemindDialog dialog;
        public int productLine;
        public PromotionActivity promotionRule;
        @SerializedName("promotionText")
        public String promotionText;
        @SerializedName("ruleText")
        public String ruleText;
        @SerializedName("termsAndConditionUrl")
        public String termsAndConditionUrl;

        public boolean isValid() {
            return !CollectionUtil.isEmpty((Collection<?>) this.channelList);
        }
    }

    public static class ChannelStatusInfo implements Serializable {
        @SerializedName("extMetadata")
        public String extMetaData;
        public int status;
        public String subTitle;
        public String title;
        @SerializedName("statusCode")
        public int unableReasonCode;

        public static boolean isOrderInTrip(String str) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            try {
                if (new JSONObject(str).optInt("order_in_trip") == 1) {
                    return true;
                }
                return false;
            } catch (JSONException e) {
                e.printStackTrace();
                return false;
            }
        }
    }
}
