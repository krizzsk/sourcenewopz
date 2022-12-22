package com.didi.global.globalgenerickit;

import android.text.TextUtils;
import com.didi.global.globalgenerickit.template.yoga.EventListener;
import com.didi.global.globalgenerickit.utils.JsonUtil;
import com.didichuxing.publicservice.p196db.model.ScreenAdNewModel;
import com.didiglobal.dittoview.DittoEventListener;
import com.didiglobal.dittoview.mvvm.DittoData;
import com.google.gson.JsonObject;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class GGKData {
    protected CDNCallback CDNCallback;
    protected String cdn;
    protected JSONObject data;
    protected Map<String, Object> ext = new HashMap();
    protected JSONObject extension;

    /* renamed from: id */
    protected String f22038id;
    protected EventListener mEventListener = new CommonEventListener(this);
    protected JSONObject originalData;
    protected String template;

    public interface CDNCallback {
        void onCDNCached();
    }

    public GGKData() {
    }

    public GGKData(String str, String str2, String str3, JSONObject jSONObject, JSONObject jSONObject2) {
        this.f22038id = str;
        this.template = str2;
        this.cdn = str3;
        this.data = jSONObject;
        this.extension = jSONObject2;
        m15977a();
    }

    public GGKData(String str, String str2, String str3, JsonObject jsonObject, JsonObject jsonObject2) {
        this.f22038id = str;
        this.template = str2;
        this.cdn = str3;
        if (jsonObject != null) {
            try {
                this.data = new JSONObject(jsonObject.toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        if (jsonObject2 != null) {
            try {
                this.extension = new JSONObject(jsonObject2.toString());
                m15977a();
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    public GGKData(String str, String str2, String str3, String str4, String str5) {
        this.f22038id = str;
        this.template = str2;
        this.cdn = str3;
        try {
            this.data = new JSONObject(str4);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (str5 != null) {
            try {
                this.extension = new JSONObject(str5);
                m15977a();
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    public DittoData parse2DittoData() {
        DittoData dittoData = new DittoData();
        dittoData.setId(this.f22038id);
        dittoData.setTemplate(this.template);
        dittoData.setCdn(this.cdn);
        dittoData.setData(this.data);
        dittoData.setExtension(this.extension);
        dittoData.setCDNCallback(new com.didiglobal.dittoview.callback.CDNCallback() {
            public void onCDNCachedFailed(String str) {
            }

            public void onCDNCached() {
                if (GGKData.this.CDNCallback != null) {
                    GGKData.this.CDNCallback.onCDNCached();
                }
            }
        });
        dittoData.setEventListener(new DittoEventListener() {
            public boolean handleEvent(String str, String str2, Map<String, Object> map) {
                if (GGKData.this.mEventListener == null) {
                    return false;
                }
                GGKData.this.mEventListener.handleEvent(str, str2, map);
                return false;
            }
        });
        return dittoData;
    }

    public JSONObject getOriginalData() {
        return this.originalData;
    }

    public String getId() {
        return this.f22038id;
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

    public String getCdn() {
        return this.cdn;
    }

    public CDNCallback getCDNCallback() {
        return this.CDNCallback;
    }

    public void setCDNCallback(CDNCallback cDNCallback) {
        this.CDNCallback = cDNCallback;
    }

    public void setEventListener(EventListener eventListener) {
        this.mEventListener = eventListener;
    }

    public EventListener getEventListener() {
        return this.mEventListener;
    }

    public Map<String, Object> getExt() {
        return this.ext;
    }

    public void setId(String str) {
        this.f22038id = str;
    }

    public void setTemplate(String str) {
        this.template = str;
    }

    public void setData(JSONObject jSONObject) {
        this.data = jSONObject;
    }

    public void setExtension(JSONObject jSONObject) {
        this.extension = jSONObject;
        m15977a();
    }

    public void setCdn(String str) {
        this.cdn = str;
    }

    public GGKData parse(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        this.originalData = jSONObject;
        this.f22038id = jSONObject.optString("id");
        this.template = jSONObject.optString("template");
        this.cdn = jSONObject.optString(ScreenAdNewModel.ScreenAdNewColumn.CDN);
        this.data = jSONObject.optJSONObject("data");
        this.extension = jSONObject.optJSONObject("extension");
        m15977a();
        return this;
    }

    /* renamed from: a */
    private void m15977a() {
        JSONObject optJSONObject;
        JSONObject jSONObject = this.extension;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("log_data")) != null) {
            try {
                this.ext = JsonUtil.jsonToMap(optJSONObject);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public String debugInfo() {
        return String.format("{id:%s,template:%s,hasCDN:%s}", new Object[]{this.f22038id, this.template, Boolean.valueOf(!TextUtils.isEmpty(this.cdn))});
    }
}
