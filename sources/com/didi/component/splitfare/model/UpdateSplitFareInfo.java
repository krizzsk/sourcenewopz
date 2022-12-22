package com.didi.component.splitfare.model;

import com.didi.travel.psnger.common.net.base.BaseObject;
import com.didi.travel.psnger.core.model.response.DTSDKOrderDetail;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;

public class UpdateSplitFareInfo extends BaseObject {
    public ExtraData data;
    public DTSDKOrderDetail orderDetail;

    public static class ExtraData implements Serializable {
        @SerializedName("business_id")
        public String businessId;
        public int code;
        @SerializedName("overdraftOid")
        public String overdraftOid;
        @SerializedName("product_id")
        public String productId;
        public String title;
    }

    /* access modifiers changed from: protected */
    public void parse(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.orderDetail = new DTSDKOrderDetail();
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject != null && optJSONObject.optJSONObject("order_detail") != null) {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.putOpt("data", optJSONObject.optJSONObject("order_detail"));
                    this.orderDetail.parse(jSONObject2);
                    this.orderDetail.errno = 0;
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
