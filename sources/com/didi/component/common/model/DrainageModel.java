package com.didi.component.common.model;

import com.didi.travel.psnger.common.net.base.BaseObject;
import com.didichuxing.publicservice.p196db.model.ScreenAdModel;
import com.didiglobal.p205sa.biz.component.ComponentType;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class DrainageModel extends BaseObject {
    private String business_type;
    private int contentId;
    private String image = "";
    private Map<String, Object> logDataMap;
    private String point_action;
    private int show;
    private String tips = "";
    private String tips_action;

    /* access modifiers changed from: protected */
    public void parse(JSONObject jSONObject) {
        JSONObject optJSONObject;
        super.parse(jSONObject);
        try {
            JSONObject optJSONObject2 = jSONObject.optJSONObject("data");
            if (optJSONObject2 != null && (optJSONObject = optJSONObject2.optJSONObject(ComponentType.COMPONENT_DRAINAGE_GUIDE)) != null) {
                JSONObject optJSONObject3 = optJSONObject.optJSONObject("data");
                this.show = optJSONObject3.optInt("show");
                this.contentId = optJSONObject3.optInt(ScreenAdModel.ScreenAdColumn.CONTENT_ID);
                this.business_type = optJSONObject3.optString("business_type");
                this.image = optJSONObject3.optString("image");
                this.tips = optJSONObject3.optString("tips");
                this.tips_action = optJSONObject3.optString("tips_action");
                this.point_action = optJSONObject3.optString("point_action");
                if (optJSONObject3.has("log_data")) {
                    JSONObject optJSONObject4 = optJSONObject3.optJSONObject("log_data");
                    this.logDataMap = new HashMap();
                    this.logDataMap = (Map) new Gson().fromJson((JsonElement) new JsonParser().parse(optJSONObject4.toString()).getAsJsonObject(), this.logDataMap.getClass());
                }
            }
        } catch (Exception unused) {
        }
    }

    public int getContentId() {
        return this.contentId;
    }

    public int getShow() {
        return this.show;
    }

    public void setShow(int i) {
        this.show = i;
    }

    public String getBusiness_type() {
        return this.business_type;
    }

    public void setBusiness_type(String str) {
        this.business_type = str;
    }

    public String getImage() {
        return this.image;
    }

    public void setImage(String str) {
        this.image = str;
    }

    public String getTips() {
        return this.tips;
    }

    public void setTips(String str) {
        this.tips = str;
    }

    public String getTips_action() {
        return this.tips_action;
    }

    public void setTips_action(String str) {
        this.tips_action = str;
    }

    public String getPoint_action() {
        return this.point_action;
    }

    public void setPoint_action(String str) {
        this.point_action = str;
    }

    public Map<String, Object> getLogDataMap() {
        return this.logDataMap;
    }

    public void setLogDataMap(Map<String, Object> map) {
        this.logDataMap = map;
    }
}
