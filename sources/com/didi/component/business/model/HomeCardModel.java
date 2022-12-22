package com.didi.component.business.model;

import com.google.gson.annotations.SerializedName;
import com.sdk.poibase.model.RpcPoiBaseInfo;
import com.sdk.poibase.model.RpcPoiExtendInfo;
import java.io.Serializable;

public class HomeCardModel implements Serializable {
    @SerializedName("base_info")
    public RpcPoiBaseInfo base_info;
    @SerializedName("extend_info")
    public HomeExtendInfo extend_info;

    public static class HomeExtendInfo extends RpcPoiExtendInfo {
    }
}
