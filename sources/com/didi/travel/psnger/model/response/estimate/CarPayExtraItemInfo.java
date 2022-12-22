package com.didi.travel.psnger.model.response.estimate;

import com.android.didi.bfflib.business.BffGsonStruct;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class CarPayExtraItemInfo implements BffGsonStruct {
    @SerializedName("card_org")
    public String carOrg;
    @SerializedName("discount_tags")
    public List<String> cardDiscountTags;
    @SerializedName("expired")
    public int cardExpried;
    @SerializedName("card_index")
    public String cardIndex;
    @SerializedName("card_status")
    public int cardStatus;
    @SerializedName("status_desc")
    public String cardStatusDesc;
    @SerializedName("card_suffix")
    public String cardSuffix;
    @SerializedName("card_select_suffix")
    public String cardSuffixInSelectPage;
    @SerializedName("discount_msg")
    public String discountMsg;
    @SerializedName("expired_desc")
    public String expiredDesc;
    @SerializedName("log_data")
    public JsonObject mLogData;
    @SerializedName("discount_subtitle")
    public String mostFavorableTxt;
}
