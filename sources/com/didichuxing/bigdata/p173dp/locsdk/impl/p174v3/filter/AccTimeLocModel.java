package com.didichuxing.bigdata.p173dp.locsdk.impl.p174v3.filter;

import com.google.gson.annotations.SerializedName;

/* renamed from: com.didichuxing.bigdata.dp.locsdk.impl.v3.filter.AccTimeLocModel */
public class AccTimeLocModel {
    @SerializedName("lat")
    public double lat;
    @SerializedName("lng")
    public double lng;
    @SerializedName("timestamp_driv")
    public long timestampDriver;
    @SerializedName("timestamp_ntp")
    public long timestampNTP;
    @SerializedName("timestamp_produce")
    public long timestampProduce;
    @SerializedName("type")
    public String typeStr;
}
