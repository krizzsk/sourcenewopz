package com.didi.sdk.global.enterprise.model.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

@Deprecated
public class CostCenterBean implements Serializable {
    @SerializedName("cost_center_id")

    /* renamed from: id */
    public String f36157id;
    public boolean isRequired;
    @SerializedName("name")
    public String name;
}
