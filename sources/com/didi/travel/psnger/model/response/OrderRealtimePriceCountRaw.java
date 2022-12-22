package com.didi.travel.psnger.model.response;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* compiled from: OrderRealtimePriceCount */
class OrderRealtimePriceCountRaw implements Serializable {
    private static final long serialVersionUID = 6510773719262929296L;
    @SerializedName("data")
    public OrderRealtimePriceCount data;
    @SerializedName("fee_info")
    public List<NextRealtimeFeeItem> feeItemInfos = new ArrayList();
    @SerializedName("p_late_fee_txt")
    public String lateFee;
    @SerializedName("p_late_fee_condition")
    public String lateFeeCondition;
    @SerializedName("p_late_fee_wait")
    public String lateFeeWait;
    @SerializedName("normal_time")
    public String normaTime;
    @SerializedName("normal_distance")
    public String normalDistance;
    @SerializedName("oid")
    public String oid;
    @SerializedName("total_fee")
    public String totalFee;
    @SerializedName("total_fee_text")
    public String totalFeeText;

    OrderRealtimePriceCountRaw() {
    }

    public String toString() {
        return "OrderRealtimePriceCount{feeItemInfos=" + this.feeItemInfos + ", oid='" + this.oid + '\'' + ", totalFee=" + this.totalFee + ", totalFeeText=" + this.totalFeeText + '}';
    }
}
