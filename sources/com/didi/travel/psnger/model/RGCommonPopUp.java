package com.didi.travel.psnger.model;

import com.didi.travel.psnger.common.net.base.BaseObject;
import com.didi.travel.psnger.utils.JsonUtil;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class RGCommonPopUp extends BaseObject {
    public List<RGPopUpOptions> options;
    public List<RGBlockingSelection> selection;
    public String showMsg;
    public String title;

    public static class RGPopUpOptionsData {
        public static final int DRIVER = 2;
        public static final int PAX = 1;
        public int businessId;
        public String orderId;
        public int productId;
        public int role;
        public String tripId;
        public String url;
    }

    public void parse(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.title = jSONObject.optString("title");
            this.showMsg = jSONObject.optString("show_msg");
            JSONArray optJSONArray = jSONObject.optJSONArray("selection");
            if (optJSONArray != null) {
                this.selection = new JsonUtil().parseJSONArray(optJSONArray, new RGBlockingSelection());
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray(SDKConstants.PARAM_GAME_REQUESTS_OPTIONS);
            if (optJSONArray2 != null) {
                this.options = new JsonUtil().parseJSONArray(optJSONArray2, new RGPopUpOptions());
            }
        }
    }

    public static class RGBlockingSelection extends BaseObject {
        public String text;

        /* access modifiers changed from: protected */
        public void parse(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.text = jSONObject.optString("text");
            }
        }
    }

    public static class RGPopUpOptions extends BaseObject {
        public RGPopUpOptionsData data;
        public String text;
        public int type;

        /* access modifiers changed from: protected */
        public void parse(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.text = jSONObject.optString("text");
                this.type = jSONObject.optInt("type");
                JSONObject optJSONObject = jSONObject.optJSONObject("data");
                if (optJSONObject != null) {
                    RGPopUpOptionsData rGPopUpOptionsData = new RGPopUpOptionsData();
                    this.data = rGPopUpOptionsData;
                    rGPopUpOptionsData.url = optJSONObject.optString("url");
                    this.data.orderId = optJSONObject.optString("order_id");
                    this.data.productId = optJSONObject.optInt("product_id");
                    this.data.tripId = optJSONObject.optString("trip_id");
                    this.data.businessId = optJSONObject.optInt("business_id");
                    this.data.role = optJSONObject.optInt("role");
                }
            }
        }
    }
}
