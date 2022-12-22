package com.didi.sdk.global.balance.model.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

@Deprecated
public class TopUpMethodDetail implements Serializable {
    @SerializedName("channelIcon")
    public String channelIcon;
    @SerializedName("channelId")
    public int channelId;
    @SerializedName("channelName")
    public String channelName;
    @SerializedName("discountMainDesc")
    public String discountMainDesc;
    @SerializedName("discountSubDesc")
    public String discountSubDesc;
    @SerializedName("hasMoreTopUpMethod")
    public boolean hasMoreTopUpMethod;
    @SerializedName("legalTermsDesc")
    public String legalTermsTitle;
    @SerializedName("legalTermsUrl")
    public String legalTermsUrl;
    @SerializedName("title")
    public String title;
    @SerializedName("topUpDesc")
    public String topUpDesc;
    @SerializedName("topUpUrl")
    public String topUpUrl;
}
