package com.didi.sdk.events;

import org.json.JSONObject;

public class FusionTitlebarRightTextEvent {
    public JSONObject data;

    public FusionTitlebarRightTextEvent(JSONObject jSONObject) {
        this.data = jSONObject;
    }
}
