package com.didi.unifiedPay.sdk.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class SubChannel implements Serializable {
    public int canSelect = 1;
    public int card_status;
    public String copy_writing;
    public int expired;
    public String expired_desc;
    @SerializedName("marketing_text")
    public String marketing_text;
    public String status_desc;
    @SerializedName("sub_icon")
    public String sub_icon;
    @SerializedName("sub_id")
    public String sub_id;
    @SerializedName("sub_name")
    public String sub_name;
    @SerializedName("sub_select_name")
    public String sub_select_name;
}
