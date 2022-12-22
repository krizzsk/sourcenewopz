package com.didi.sdk.global.enterprise.model.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

@Deprecated
public class CostCenterListBean implements Serializable {
    @SerializedName("cost_center_list")
    public List<CostCenterBean> costCenterList;
}
