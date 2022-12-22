package com.didi.sdk.componentconfig;

import android.text.TextUtils;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ComponentConfigInfo implements Serializable {
    public HashMap<String, BusinessComponentConfig> businessComponentConfigHashMap = new HashMap<>();
    @SerializedName("city_id")
    public String cityId;
    public String data;
    @SerializedName("errmsg")
    public String errMsg;
    @SerializedName("errno")
    public String errno;
    @SerializedName("log_id")
    public String logId;
    @SerializedName("version")
    public String version;

    public List<BusinessComponentConfig.BusinessCompoentConfigItem> getBusinessComponentConfig(String str, String str2) {
        BusinessComponentConfig businessComponentConfig = this.businessComponentConfigHashMap.get(str);
        if (businessComponentConfig != null) {
            return businessComponentConfig.hashMap.get(str2);
        }
        return null;
    }

    public static ComponentConfigInfo parse(String str) {
        try {
            ComponentConfigInfo componentConfigInfo = new ComponentConfigInfo();
            JSONObject jSONObject = new JSONObject(str);
            componentConfigInfo.errno = jSONObject.optString("errno");
            componentConfigInfo.version = jSONObject.optString("verison");
            componentConfigInfo.cityId = jSONObject.optString("city_id");
            String optString = jSONObject.optString("data");
            componentConfigInfo.data = optString;
            if (!TextUtils.isEmpty(optString)) {
                try {
                    JSONObject jSONObject2 = new JSONObject(optString);
                    JSONObject optJSONObject = jSONObject2.optJSONObject("201");
                    BusinessComponentConfig businessComponentConfig = new BusinessComponentConfig();
                    businessComponentConfig.parse(optJSONObject);
                    componentConfigInfo.businessComponentConfigHashMap.put("201", businessComponentConfig);
                    jSONObject2.optJSONObject("timer");
                } catch (Exception unused) {
                }
            }
            return componentConfigInfo;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static class BusinessComponentConfig {
        public HashMap<String, List<BusinessCompoentConfigItem>> hashMap = new HashMap<>();

        public void parse(JSONObject jSONObject) {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                ArrayList arrayList = new ArrayList();
                try {
                    JSONArray jSONArray = jSONObject.getJSONArray(next);
                    if (jSONArray != null) {
                        for (int i = 0; i < jSONArray.length(); i++) {
                            BusinessCompoentConfigItem businessCompoentConfigItem = new BusinessCompoentConfigItem();
                            businessCompoentConfigItem.parse(jSONArray.optJSONObject(i));
                            arrayList.add(businessCompoentConfigItem);
                        }
                    }
                    this.hashMap.put(next, arrayList);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }

        public static class BusinessCompoentConfigItem {
            public int car_level;
            public int order_type;
            public String scence;
            public HashMap<String, String> tips = new HashMap<>();

            public void parse(JSONObject jSONObject) {
                this.order_type = jSONObject.optInt("order_type");
                this.scence = jSONObject.optString("scence");
                this.car_level = jSONObject.optInt("car_level");
                JSONObject optJSONObject = jSONObject.optJSONObject("data");
                if (optJSONObject != null) {
                    Iterator<String> keys = optJSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        this.tips.put(next, optJSONObject.optString(next));
                    }
                }
            }
        }
    }
}
