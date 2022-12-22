package com.didi.security.uuid;

import android.os.Build;
import org.json.JSONException;
import org.json.JSONObject;

public class BuildInfo {
    public String getInfo() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("fingerprint", Build.FINGERPRINT);
            jSONObject.put("cpu_abi", Build.CPU_ABI);
            jSONObject.put("cpu_abi2", Build.CPU_ABI2);
            jSONObject.put("brand", Build.BRAND);
            jSONObject.put("manufacturer", Build.MANUFACTURER);
            jSONObject.put("board", Build.BOARD);
            jSONObject.put("model", Build.MODEL);
            jSONObject.put("hardware", Build.HARDWARE);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }
}
