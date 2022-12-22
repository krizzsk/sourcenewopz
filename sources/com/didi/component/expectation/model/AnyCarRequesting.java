package com.didi.component.expectation.model;

import com.didi.global.globaluikit.richinfo.LEGORichInfo;
import com.google.gson.annotations.SerializedName;

public class AnyCarRequesting {
    @SerializedName("business_id")
    public String business_id;
    @SerializedName("icon")
    public String iconUrl;
    @SerializedName("product_id")
    public String product_id;
    @SerializedName("status_des")
    public LEGORichInfo statusDes;
    @SerializedName("type_name")
    public String typeName;
}
