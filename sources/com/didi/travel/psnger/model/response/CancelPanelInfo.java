package com.didi.travel.psnger.model.response;

import com.google.gson.annotations.SerializedName;

public class CancelPanelInfo {
    @SerializedName("back_button")
    public String mBackButton;
    @SerializedName("confirm_button")
    public String mConfirmButton;
    @SerializedName("sub_title")
    public String mSubTitle;
    @SerializedName("title")
    public String mTitle;
}
