package com.didi.global.globalgenerickit.model;

import com.android.didi.bfflib.business.BffGsonStruct;
import com.didi.global.globaluikit.richinfo.LEGORichInfo;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.annotations.SerializedName;
import org.json.JSONException;
import org.json.JSONObject;

public class ComponentConfigBubbleModel extends ComponentConfigModel {
    public String content;
    public String contentColor;
    public int contentSize;
    public String iconUrl;
    public String link;
    public LEGORichInfo subTitleRich;
    public String title;
    public String titleColor;
    public LEGORichInfo titleRich;
    public int titleSize;

    public static class BusinessData implements BffGsonStruct {
        public String content;
        @SerializedName("content_color")
        public String contentColor;
        @SerializedName("content_size")
        public int contentSize;
        @SerializedName("icon")
        public String iconUrl;
        public String title;
        @SerializedName("title_color")
        public String titleColor;
        @SerializedName("title_size")
        public int titleSize;
    }

    public void parse(ComponentConfigModel componentConfigModel) {
        super.parse(componentConfigModel);
        if (componentConfigModel != null && componentConfigModel.data != null) {
            JSONObject jSONObject = null;
            try {
                jSONObject = new JSONObject(componentConfigModel.data.toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (jSONObject != null && isNative()) {
                this.title = jSONObject.optString("title");
                this.titleColor = jSONObject.optString("title_color");
                this.titleSize = jSONObject.optInt("title_size");
                this.content = jSONObject.optString("content");
                this.contentColor = jSONObject.optString("content_color");
                this.contentSize = jSONObject.optInt("content_size");
                this.iconUrl = jSONObject.optString("icon");
                try {
                    this.titleRich = (LEGORichInfo) new Gson().fromJson(jSONObject.optString("title_rich"), LEGORichInfo.class);
                    this.subTitleRich = (LEGORichInfo) new Gson().fromJson(jSONObject.optString("content_rich"), LEGORichInfo.class);
                } catch (JsonSyntaxException e2) {
                    e2.printStackTrace();
                }
                this.link = jSONObject.optString("link");
            }
        }
    }
}
