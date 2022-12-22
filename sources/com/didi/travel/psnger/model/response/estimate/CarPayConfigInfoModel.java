package com.didi.travel.psnger.model.response.estimate;

import com.android.didi.bfflib.business.BffGsonStruct;
import com.didi.travel.psnger.common.net.base.BaseObject;
import com.google.gson.annotations.SerializedName;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

public class CarPayConfigInfoModel extends BaseObject implements BffGsonStruct {
    @SerializedName("ext")
    public Map<String, Object> ext;
    @SerializedName("tag")
    public int payTag;
    @SerializedName("change_advise")
    public PopupItem switchOut99PayPopup;
    @SerializedName("combination_advise")
    public PopupItem switchOutCombinationPayPopup;

    public static class PopupItem extends BaseObject implements BffGsonStruct {
        @SerializedName("abandon")
        public String cancelBtn;
        @SerializedName("accept")
        public String confirmBtn;
        @SerializedName("subtitle")
        public String subTitle;
        @SerializedName("title")
        public String title;

        /* access modifiers changed from: protected */
        public void parse(JSONObject jSONObject) {
            super.parse(jSONObject);
            if (jSONObject != null) {
                this.title = jSONObject.optString("title");
                this.subTitle = jSONObject.optString("subtitle");
                this.confirmBtn = jSONObject.optString("accept");
                this.cancelBtn = jSONObject.optString("abandon");
            }
        }
    }

    public void parse(JSONObject jSONObject) {
        super.parse(jSONObject);
        if (jSONObject != null) {
            JSONObject optJSONObject = jSONObject.optJSONObject("change_advise");
            if (optJSONObject != null) {
                PopupItem popupItem = new PopupItem();
                this.switchOut99PayPopup = popupItem;
                popupItem.parse(optJSONObject);
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("combination_advise");
            if (optJSONObject2 != null) {
                PopupItem popupItem2 = new PopupItem();
                this.switchOutCombinationPayPopup = popupItem2;
                popupItem2.parse(optJSONObject2);
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("ext");
            HashMap hashMap = new HashMap();
            if (optJSONObject3 != null) {
                try {
                    if (optJSONObject3.length() > 0) {
                        Iterator<String> keys = optJSONObject3.keys();
                        while (keys.hasNext()) {
                            String next = keys.next();
                            hashMap.put(next, optJSONObject3.opt(next));
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            this.ext = hashMap;
        }
    }
}
