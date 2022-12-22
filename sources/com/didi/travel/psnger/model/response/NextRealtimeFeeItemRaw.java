package com.didi.travel.psnger.model.response;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* compiled from: NextRealtimeFeeItem */
class NextRealtimeFeeItemRaw implements Serializable {
    @SerializedName("extra_info")
    public String extraInfo;
    @SerializedName("fee_color")
    public String feeColor;
    @SerializedName("fee_cust")
    public int feeCust = 0;
    @SerializedName("fee_id")
    public String feeId;
    @SerializedName("fee_label")
    public String feeLabel;
    @SerializedName("fee_type")
    public int feeType = 0;
    @SerializedName("fee_url")
    public String feeUrl;
    @SerializedName("fee_value")
    public String feeValue;

    NextRealtimeFeeItemRaw() {
    }
}
