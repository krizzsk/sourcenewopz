package com.didi.component.comp_selectseat.ticket;

import com.didi.global.globaluikit.richinfo.LEGORichInfo;
import com.google.gson.annotations.SerializedName;

public class TicketModel {
    @SerializedName("name")
    public String mName;
    @SerializedName("payment")
    public LEGORichInfo mPayment;
    @SerializedName("payment_mark")
    public String mPaymentMark;
    @SerializedName("payment_mark_show")
    public int mPaymentMarkShow;
    @SerializedName("price")
    public LEGORichInfo mPrice;
    @SerializedName("role")
    public String mRole;
    @SerializedName("seat_num")
    public int mSeatNum;
    @SerializedName("seat_units")
    public String mSeatUnits;
    @SerializedName("ticket_head_bg_color")
    public String mTicketHeadBgColor;
    @SerializedName("ticket_intro")
    public String mTicketIntro;
    @SerializedName("ticket_num")
    public String mTicketNum;
    @SerializedName("title_bar_text")
    public String mTitleBarText;
}
