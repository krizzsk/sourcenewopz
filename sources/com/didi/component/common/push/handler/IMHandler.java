package com.didi.component.common.push.handler;

import com.datadog.android.monitoring.internal.InternalLogsFeature;
import com.didi.beatles.p099im.access.IMEngine;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import org.json.JSONObject;

public class IMHandler implements PushHandler {
    public void handle(JSONObject jSONObject) {
        if (jSONObject.has("c")) {
            try {
                IMEngine.pullMessagesSync(Integer.parseInt(jSONObject.optJSONObject("c").optString(InternalLogsFeature.ENV_NAME)));
                OmegaSDKAdapter.trackEvent("IM_PullMessage_ApnsFCM");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
