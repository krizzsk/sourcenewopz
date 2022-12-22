package com.didi.travel.psnger.model.response;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class NextRefund implements Serializable {
    public static final int STATUS_REFUND_APPLY = 2;
    public static final int STATUS_REFUND_NORMAL = 0;
    public static final int STATUS_REFUND_NO_APPLY = 1;
    @SerializedName("refund_link")
    public String mRefundLink;
    @SerializedName("refund_status")
    public int mRefundStatus = 0;
    @SerializedName("refund_tip")
    public String mRefundTip;
    @SerializedName("refund_title")
    public String mRefundTitle;
}
