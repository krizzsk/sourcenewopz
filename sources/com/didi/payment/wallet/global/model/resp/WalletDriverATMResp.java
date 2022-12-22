package com.didi.payment.wallet.global.model.resp;

import com.didi.payment.commonsdk.net.WBaseResp;
import com.didi.sdk.util.TextUtil;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class WalletDriverATMResp extends WBaseResp {
    public DataBean data;

    public static class DataBean implements Serializable {
        @SerializedName("extMetadata")
        public String extMetaData;
        public String subTitle;
        public String title;
    }

    public boolean canTopup4Psgr() {
        DataBean dataBean = this.data;
        return dataBean != null && !TextUtil.isEmpty(dataBean.extMetaData);
    }
}
