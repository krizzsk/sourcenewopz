package com.didichuxing.xpanel.global.models.misoperation;

import com.didichuxing.xpanel.agent.net.ParseJsonUtil;
import com.didichuxing.xpanel.global.models.XPanelModels;
import com.didichuxing.xpanel.models.IXPanelModel;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

public class MisOperationData extends IXPanelModel {

    /* renamed from: T */
    public String f49503T;
    public String activityId;
    public String[] bottombarImages;
    public String[] bottombarLinks;
    public String[] bottombarTxts;
    public String content;
    public String imageUrl;
    public String link;
    public HashMap<String, Object> logDataMap = new HashMap<>();
    public String title;
    public String type;

    public String getTemplate() {
        return XPanelModels.X_PANEL_TEMPLATE_GLOBAL_OPERATION;
    }

    public boolean parse(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject == null) {
            return false;
        }
        this.imageUrl = ParseJsonUtil.optString(jSONObject, "image1", "");
        this.title = ParseJsonUtil.optString(jSONObject, "text0", "");
        this.content = ParseJsonUtil.optString(jSONObject, "text1", "");
        this.link = ParseJsonUtil.optString(jSONObject, "link0", "");
        JSONArray optJSONArray = jSONObject.optJSONArray("buttons");
        if (optJSONArray != null) {
            int length = optJSONArray.length();
            this.bottombarTxts = new String[length];
            this.bottombarImages = new String[length];
            this.bottombarLinks = new String[length];
            for (int i = 0; i < length; i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    this.bottombarTxts[i] = ParseJsonUtil.optString(optJSONObject, "text", "");
                    this.bottombarImages[i] = ParseJsonUtil.optString(optJSONObject, "image", "");
                    this.bottombarLinks[i] = ParseJsonUtil.optString(optJSONObject, "link", "");
                }
            }
        } else {
            this.bottombarTxts = new String[0];
            this.bottombarImages = new String[0];
            this.bottombarLinks = new String[0];
        }
        if (jSONObject2 == null) {
            return true;
        }
        this.f49503T = ParseJsonUtil.optString(jSONObject2, "T", "");
        this.activityId = ParseJsonUtil.optString(jSONObject2, "activity_id", "");
        this.type = ParseJsonUtil.optString(jSONObject2, "type", "");
        JSONObject optJSONObject2 = jSONObject2.optJSONObject("log_data");
        if (optJSONObject2 != null) {
            Iterator<String> keys = optJSONObject2.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                this.logDataMap.put(next, ParseJsonUtil.optString(optJSONObject2, next, ""));
            }
            return true;
        }
        this.logDataMap = new HashMap<>();
        return true;
    }

    public HashMap<String, Object> getExtension() {
        return this.logDataMap;
    }
}
