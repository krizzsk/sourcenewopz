package com.didi.travel.psnger.model.response.estimate;

import com.android.didi.bfflib.business.BffGsonStruct;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;

public class CarBreakMemberModel implements BffGsonStruct {
    @SerializedName("buy_type")
    public int memberBuyType;
    @SerializedName("cancel_msg")
    public String memberCancelMsg;
    @SerializedName("confirm_msg")
    public String memberConfirmMsg;
    @SerializedName("content")
    public String memberContent;
    @SerializedName("title")
    public String memberTitle;
    @SerializedName("top_img")
    public String memberTopImg;
    @SerializedName("top_img_jump_link")
    public String memberTopImgLink;
    @SerializedName("package_id")
    public String packageId;
    @SerializedName("passenger_newSheet")
    public JsonObject passengerNewSheet;
}
