package com.didi.component.evaluateentrance.evaluate.model;

import com.didi.soda.customer.blocks.BlocksConst;
import com.google.gson.annotations.SerializedName;
import org.json.JSONObject;

public class FiveStarModel extends EvaluateModel {
    public NormalBean normal;

    public static class NormalBean {
        @SerializedName("avatar_icon")
        public String avatarIcon;
        public String evaluateInfoJson;
        public int level;
        public int status;
        @SerializedName("sub_title")
        public String subTitle;
        @SerializedName("tip_info")
        public GXPCarTipInfo tipInfo;
        public String title;

        public void parseData(JSONObject jSONObject) {
            JSONObject optJSONObject;
            this.avatarIcon = jSONObject.optString("avatar_icon");
            this.title = jSONObject.optString("title");
            this.subTitle = jSONObject.optString(BlocksConst.WIDGET_PARAMS_TYPE_SUB_TITLE);
            this.status = jSONObject.optInt("status");
            this.level = jSONObject.optInt("level");
            if (jSONObject.has("tip_info") && jSONObject.optJSONObject("tip_info") != null) {
                GXPCarTipInfo gXPCarTipInfo = new GXPCarTipInfo();
                this.tipInfo = gXPCarTipInfo;
                gXPCarTipInfo.parse(jSONObject.optJSONObject("tip_info"));
            }
            if (jSONObject.has("xpanel_evaluate_info") && (optJSONObject = jSONObject.optJSONObject("xpanel_evaluate_info")) != null) {
                this.evaluateInfoJson = optJSONObject.toString();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void parseNormal(JSONObject jSONObject) {
        if (jSONObject.has("data") && jSONObject.optJSONObject("data") != null) {
            NormalBean normalBean = new NormalBean();
            this.normal = normalBean;
            normalBean.parseData(jSONObject.optJSONObject("data"));
        }
    }
}
