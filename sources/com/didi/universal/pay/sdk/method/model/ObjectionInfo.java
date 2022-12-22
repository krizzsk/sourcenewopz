package com.didi.universal.pay.sdk.method.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.Map;

public class ObjectionInfo implements Serializable {
    @SerializedName("deduction_list")
    public DeductionInfo[] deductions;
    @SerializedName("fee_detail_list")
    public FeeItem[] feeDetails;
    @SerializedName("fee_objection_page_optimize")
    public Map fee_objection_page_optimize;
    @SerializedName("objection_page")
    public String objection_page;
    @SerializedName("order_info")
    public OrderBaseInfo orderInfo;
    @SerializedName("page_info")
    public PageInfo pageInfo;
    public int productId;
}
