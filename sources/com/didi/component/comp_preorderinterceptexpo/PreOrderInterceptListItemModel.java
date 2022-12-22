package com.didi.component.comp_preorderinterceptexpo;

import android.text.TextUtils;
import com.android.didi.bfflib.business.BffGsonStruct;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import java.util.HashMap;
import java.util.Map;

/* compiled from: PreOrderInterceptExpo */
class PreOrderInterceptListItemModel implements BffGsonStruct {
    public JsonObject data;
    @SerializedName("extension")
    public Extension mExtension;
    @SerializedName("unique_id")
    public String uniqueId;

    /* compiled from: PreOrderInterceptExpo */
    public static class BizParams implements BffGsonStruct {
        @SerializedName("intercept_event_ck")
        public String interceptEventClick;
        @SerializedName("intercept_event_sw")
        public String interceptEventShow;
    }

    /* compiled from: PreOrderInterceptExpo */
    public static class Extension implements BffGsonStruct {
        @SerializedName("biz_params")
        public BizParams bizParams;
        @SerializedName("log_data")
        public JsonObject mLogData;
    }

    PreOrderInterceptListItemModel() {
    }

    public Map<String, Object> getExtraLog() {
        Extension extension = this.mExtension;
        if (extension == null || extension.mLogData == null) {
            return null;
        }
        try {
            return (Map) new Gson().fromJson((JsonElement) this.mExtension.mLogData, new TypeToken<HashMap<String, Object>>() {
            }.getType());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String getEventSw() {
        Extension extension = this.mExtension;
        return (extension == null || extension.bizParams == null || TextUtils.isEmpty(this.mExtension.bizParams.interceptEventShow)) ? "" : this.mExtension.bizParams.interceptEventShow;
    }

    public String getEventCk() {
        Extension extension = this.mExtension;
        return (extension == null || extension.bizParams == null || TextUtils.isEmpty(this.mExtension.bizParams.interceptEventClick)) ? "" : this.mExtension.bizParams.interceptEventClick;
    }
}
