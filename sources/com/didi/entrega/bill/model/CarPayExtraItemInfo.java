package com.didi.entrega.bill.model;

import com.didi.entrega.customer.foundation.rpc.entity.IEntity;
import com.google.gson.annotations.SerializedName;

public class CarPayExtraItemInfo implements IEntity {
    private static final long serialVersionUID = -5220056400607121465L;
    @SerializedName("card_org")
    public String carOrg;
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
}
