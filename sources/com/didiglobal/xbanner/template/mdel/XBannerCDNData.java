package com.didiglobal.xbanner.template.mdel;

import android.text.TextUtils;
import com.didi.global.xbanner.basemodel.XBCardViewData;
import com.didichuxing.publicservice.p196db.model.ScreenAdNewModel;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class XBannerCDNData extends XBCardViewData implements Serializable {
    protected String cdn;
    protected JSONObject data;
    public int display_count;
    protected Map ext = new HashMap();
    protected JSONObject extension;

    /* renamed from: id */
    protected String f51475id;
    protected int index;
    protected JSONObject originalData;
    protected String template;

    public JSONObject getOriginalData() {
        return this.originalData;
    }

    public String getId() {
        return this.f51475id;
    }

    public String getTemplate() {
        return this.template;
    }

    public JSONObject getData() {
        return this.data;
    }

    public JSONObject getExtension() {
        return this.extension;
    }

    public int getIndex() {
        return this.index;
    }

    public String getCdn() {
        return this.cdn;
    }

    public Map getExt() {
        return this.ext;
    }

    public XBannerCDNData parseNormal(JSONObject jSONObject, int i) {
        if (jSONObject == null) {
            return null;
        }
        this.originalData = jSONObject;
        this.f51475id = jSONObject.optString("id");
        this.template = jSONObject.optString("template");
        if (jSONObject.has("normal")) {
            JSONObject optJSONObject = jSONObject.optJSONObject("normal");
            this.cdn = optJSONObject.optString(ScreenAdNewModel.ScreenAdNewColumn.CDN);
            this.data = optJSONObject.optJSONObject("data");
        }
        this.extension = jSONObject.optJSONObject("extension");
        this.index = i;
        return this;
    }

    public XBannerCDNData parseExpand(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject == null) {
            return null;
        }
        this.originalData = jSONObject;
        this.f51475id = jSONObject.optString("id");
        this.template = jSONObject.optString("template");
        if (jSONObject.has("expand") && (optJSONObject = jSONObject.optJSONObject("normal")) != null) {
            this.cdn = optJSONObject.optString(ScreenAdNewModel.ScreenAdNewColumn.CDN);
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("data");
            this.data = optJSONObject2;
            if (optJSONObject2 != null) {
                this.display_count = optJSONObject2.optInt("display_count ", 0);
            }
        }
        this.extension = jSONObject.optJSONObject("extension");
        this.index = 0;
        return this;
    }

    public String debugInfo() {
        return String.format("{id:%s,template:%s,hasCDN:%s}", new Object[]{this.f51475id, this.template, Boolean.valueOf(!TextUtils.isEmpty(this.cdn))});
    }
}
