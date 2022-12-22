package com.didi.payment.wallet.global.model.resp;

import com.didi.payment.wallet.global.model.resp.WalletTopUpChannelResp;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

public class WalletTopUpChannelRespOldServer implements Serializable {
    @SerializedName("data")
    public DataBean data;
    @SerializedName("errmsg")
    public String errmsg;
    @SerializedName("errno")
    public int errno;

    public static class ChannelBean implements Serializable {
        @SerializedName("action_link")
        public String actionLink;
        @SerializedName("desc")
        public String desc;
        @SerializedName("extra_info")
        public String extraInfo;
        @SerializedName("icon_url")
        public String icon;
        @SerializedName("id")

        /* renamed from: id */
        public String f31758id;
        @SerializedName("name")
        public String name;
    }

    public static class DataBean implements Serializable {
        @SerializedName("select_amount_text")
        public String amountDesc;
        @SerializedName("select_amount_page_title")
        public String amountPageTitle;
        @SerializedName("select_amount_rule_text")
        public String amountRuleText;
        @SerializedName("online_top_up_items")
        public List<WalletTopUpChannelResp.ExtraDataMexicoOnlineItem> amounts;
        @SerializedName("top_up_button_text")
        public String buttonText;
        @SerializedName("select_channel_text")
        public String channelDesc;
        @SerializedName("select_channel_page_title")
        public String channelPageTitle;
        @SerializedName("select_channel_rule_text")
        public String channelRuleText;
        @SerializedName("top_up_channels")
        public List<ChannelBean> channels;
        @SerializedName("terms_and_condition_text")
        public String conditionText;
        @SerializedName("terms_and_condition_url")
        public String conditionUrl;
    }
}
