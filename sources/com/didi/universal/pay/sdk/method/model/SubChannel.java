package com.didi.universal.pay.sdk.method.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class SubChannel implements Serializable {
    public int card_status;
    public String status_desc;
    @SerializedName("sub_icon")
    public String sub_icon;
    @SerializedName("sub_id")
    public String sub_id;
    @SerializedName("sub_name")
    public String sub_name;
}
