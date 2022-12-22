package com.didi.component.common.push.handler;

import org.json.JSONObject;

public interface PushHandler {
    void handle(JSONObject jSONObject);
}
