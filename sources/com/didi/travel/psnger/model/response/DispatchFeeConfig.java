package com.didi.travel.psnger.model.response;

import com.didi.travel.psnger.common.net.base.BaseObject;
import com.didi.travel.psnger.utils.JsonUtil;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class DispatchFeeConfig extends BaseObject {
    public String addDispatchFee;
    public List<DispatchFee> dispatchFeeList;
    public DispatchFeeTips educationText;

    /* access modifiers changed from: protected */
    public void parse(JSONObject jSONObject) {
        JSONArray optJSONArray;
        super.parse(jSONObject);
        if (jSONObject != null) {
            if (jSONObject.has("education_text")) {
                JSONObject optJSONObject = jSONObject.optJSONObject("education_text");
                DispatchFeeTips dispatchFeeTips = new DispatchFeeTips();
                this.educationText = dispatchFeeTips;
                dispatchFeeTips.parse(optJSONObject);
            }
            this.addDispatchFee = jSONObject.optString("add_dispatch_fee_text");
            this.dispatchFeeList = new ArrayList();
            if (jSONObject.has("dispatch_fees") && (optJSONArray = jSONObject.optJSONArray("dispatch_fees")) != null) {
                this.dispatchFeeList = new JsonUtil().parseJSONArray(optJSONArray, new DispatchFee());
            }
        }
    }

    public static class DispatchFeeTips extends BaseObject {
        public String banner;
        public String button;
        public List<String> options;
        public String title;

        /* access modifiers changed from: protected */
        public void parse(JSONObject jSONObject) {
            JSONArray optJSONArray;
            super.parse(jSONObject);
            if (jSONObject != null) {
                this.title = jSONObject.optString("title");
                this.banner = jSONObject.optString("banner_pic_gloabl");
                this.button = jSONObject.optString("button_label");
                this.options = new ArrayList();
                if (jSONObject.has("option") && (optJSONArray = jSONObject.optJSONArray("option")) != null) {
                    this.options = JsonUtil.parseJSONArrayString(optJSONArray);
                }
            }
        }
    }

    public static class DispatchFee extends BaseObject {
        public String name;
        public String selectedName;
        public BigDecimal value = BigDecimal.valueOf(0.0d);

        /* access modifiers changed from: protected */
        public void parse(JSONObject jSONObject) {
            super.parse(jSONObject);
            if (jSONObject != null) {
                this.name = jSONObject.optString("name");
                this.value = BigDecimal.valueOf(jSONObject.optDouble("value", 0.0d));
                this.selectedName = jSONObject.optString("checked_name");
            }
        }
    }
}
