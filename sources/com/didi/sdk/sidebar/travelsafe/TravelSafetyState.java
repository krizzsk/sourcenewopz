package com.didi.sdk.sidebar.travelsafe;

import com.didi.sdk.util.TextUtil;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import org.json.JSONObject;

public class TravelSafetyState implements Serializable {
    @SerializedName("hidephone")
    public boolean hidephone = false;

    public String toJsonString() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("hidephone", this.hidephone);
            return jSONObject.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static TravelSafetyState fromJsonString(String str) {
        if (TextUtil.isEmpty(str)) {
            return null;
        }
        TravelSafetyState travelSafetyState = new TravelSafetyState();
        try {
            travelSafetyState.hidephone = new JSONObject(str).getBoolean("hidephone");
            return travelSafetyState;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
