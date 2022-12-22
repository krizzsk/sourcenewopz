package com.sdk.poibase.model.local;

import com.google.gson.annotations.SerializedName;
import com.sdk.poibase.model.HttpResultBase;

public class PsnPickupResult extends HttpResultBase {
    @SerializedName("result")
    public LocalPickUpResult result;
    @SerializedName("searchid")
    public String searchid;

    public static class LocalPickUpResult {
        @SerializedName("accuracy")
        public int accuracy;
        @SerializedName("lat")
        public double lat;
        @SerializedName("lng")
        public double lng;
        @SerializedName("order_id")
        public String orderId;
        @SerializedName("user_id")
        public String userId;
    }
}
