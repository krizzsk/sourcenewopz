package com.didi.soda.customer.foundation.rpc.entity.cart;

import android.text.TextUtils;
import com.didi.soda.customer.foundation.rpc.entity.IEntity;
import com.didi.soda.customer.foundation.rpc.entity.PayChannelEntity;
import com.didi.soda.customer.foundation.util.GsonUtil;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.google.gson.annotations.SerializedName;
import com.taxis99.R;
import java.util.List;

public class PayMethodListInfoEntity implements IEntity {
    private static final long serialVersionUID = 2961714963267134264L;
    @SerializedName("default_pay_channel")
    public String defaultPayChannel;
    public List<PayMethodInfo> payments;
    @SerializedName("style")
    public int style;

    public static class PayMethodInfo implements IEntity {
        public static final int CHANNEL_99PAY = 190;
        public static final int CHANNEL_CASH = 153;
        public static final int CHANNEL_CREDIT_CARD = 150;
        public static final int CHANNEL_DIDI_CASH = 120;
        public static final int CHANNEL_PAY_PAY = 182;
        public static final int CHANNEL_POS = 154;
        private static final long serialVersionUID = 4145209156109192750L;
        public int balance;
        public String balanceMsg;
        @SerializedName("channelID")
        public String channelId;
        public String channelName;
        public List<PayChannelEntity> combinedChannelList = null;
        public String extraInfo;
        public List<CardInfo> extraInfoList;
        public List<String> flags;
        @SerializedName("icon_url")
        public String iconUrl;
        public int isBalanceEnough;
        public int isBindCard;
        public int isDisplay;
        public String isLatestPayed;
        public Object isOffline;
        public int isSigned;
        @SerializedName("marketing_text")
        public String marketingText;
        @SerializedName("pay_type")
        public String payType;
        @SerializedName("pay_type_desc")
        public String payTypeDesc;
        @SerializedName("payment_mode")
        public String paymentMode;
        @SerializedName("payment_name")
        public String paymentName;
        public String reason;
        public Object recommendSignChannel;
        public Object recommendSignPayType;
        public SupportCardType supportCardType;
        public String tip;
        @SerializedName("warn_msg")
        public String warnMsg;

        public static class CardInfo implements IEntity {
            private static final long serialVersionUID = -6488434705328738372L;
            public String alias;
            @SerializedName("card_index")
            public String cardIndex;
            @SerializedName("card_name")
            public String cardName;
            @SerializedName("card_org")
            public String cardOrg;
            @SerializedName("card_prefix")
            public String cardPrefix;
            @SerializedName("card_status")
            public String cardStatus;
            @SerializedName("card_suffix")
            public String cardSuffix;
            @SerializedName("card_type")
            public int cardType;
            public String disableReason;
            public int isDisable;
            public String isLatestPayed;
            @SerializedName("need_ex_validate")
            public int needExValidate;
            @SerializedName("status_desc")
            public String statusDesc;
            public String tip;
        }

        public static class SupportCardType implements IEntity {
            private static final long serialVersionUID = 9119812598643398531L;
            public String disabled;
            @SerializedName("show_msg")
            public String showMsg;
        }

        public CardInfo getExtraInfo() {
            if (TextUtils.isEmpty(this.extraInfo)) {
                return null;
            }
            return (CardInfo) GsonUtil.fromJson(this.extraInfo, CardInfo.class);
        }
    }

    public static String getPayMethodInfoWarnMsg(PayMethodListInfoEntity payMethodListInfoEntity, int i) {
        List<PayMethodInfo> list;
        if (payMethodListInfoEntity == null || (list = payMethodListInfoEntity.payments) == null) {
            return "";
        }
        for (PayMethodInfo next : list) {
            if (TextUtils.equals(String.valueOf(i), next.channelId)) {
                if (next.supportCardType != null) {
                    return next.supportCardType.showMsg;
                }
                return "";
            }
        }
        return "";
    }

    public static String getPayMethodChannelName(int i, String str, String str2, boolean z) {
        if (i != 120) {
            if (i != 150) {
                if (i != 182) {
                    if (i == 190) {
                        return ResourceHelper.getString(R.string.customer_cart_99_pay);
                    }
                    if (i == 153) {
                        return TextUtils.isEmpty(str) ? ResourceHelper.getString(R.string.customer_name_cash_pay_method) : str;
                    }
                    if (i != 154) {
                        return null;
                    }
                    return ResourceHelper.getString(R.string.customer_cart_pos_pay);
                } else if (!z) {
                    return null;
                } else {
                    if (str != null) {
                        return str;
                    }
                    return "";
                }
            } else if (TextUtils.isEmpty(str2)) {
                return null;
            } else {
                return str2.substring(str2.length() - 4);
            }
        } else if (str != null) {
            return str;
        } else {
            return "";
        }
    }
}
