package com.didi.payment.utilities.resp;

import com.didi.payment.commonsdk.basemodel.account.AccountFreezeData;
import com.didi.payment.commonsdk.net.WBaseResp;
import com.didi.payment.wallet.global.model.resp.LimitRiskReminderVo;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class CsBoletoChannels extends WBaseResp {
    public Data data;

    public static class AccountInfo implements Serializable {
        public String subTitle;
        public String title;
    }

    public static class Data implements Serializable {
        @SerializedName("freezeSection")
        public AccountFreezeData accountFreezeData;
        public AccountInfo accountStatus;
        public int count;
        public String countMessage;
        @SerializedName("limitRiskReminder")
        public LimitRiskReminderVo limitRiskReminder;
        public int status;
        public String statusMessage;
    }
}
