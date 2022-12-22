package com.didi.travel.psnger.model.response;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* compiled from: NextTotalFeeDetail */
class NextTotalFeeDetailRaw implements Serializable {
    @SerializedName(alternate = {"basicFeeInfoList"}, value = "basic_fee_info_list")
    public List<NextRealtimeFeeItem> basicFeeItemInfos = new ArrayList();
    @SerializedName("carfee_title")
    public String basicFeeTitle = "";
    @SerializedName("carfee_total")
    public String basicFeeValue = "";
    @SerializedName("payments")
    public List<NextFeeDetailPayment> carPayments;
    @SerializedName("refund_info")
    public NextRefund carRefund;
    @SerializedName("fee_objection_entrance")
    public String chargeDissentEnter = "";
    @SerializedName("fee_objection_page")
    public String chargeDissentInfos = "";
    @SerializedName("ext_msg")
    public String extraMsg = "";
    @SerializedName("extra_info")
    public String extra_info = "";
    @SerializedName(alternate = {"favourFeeInfoList"}, value = "favour_fee_info_list")
    public List<NextRealtimeFeeItem> favourFeeItemInfos = new ArrayList();
    @SerializedName("favour_title")
    public String favourFeeTitle = "";
    @SerializedName("favour_total")
    public String favourFeeValue = "";
    @SerializedName(alternate = {"oid"}, value = "id")
    public String oid;
    @SerializedName("pay_button_title")
    public String payButtonTitle;
    @SerializedName("pay_button_title_label")
    public String payButtonTitleLabel;
    @SerializedName("pay_title")
    public String payTitle;
    @SerializedName("pay_type")
    public int payType;
    @SerializedName("penny_flag")
    public int pennyFlag;
    @SerializedName("refund_tip")
    public String refundTip;
    @SerializedName("wxagent_payinfo")
    public String wxagentPayinfo;

    NextTotalFeeDetailRaw() {
    }
}
