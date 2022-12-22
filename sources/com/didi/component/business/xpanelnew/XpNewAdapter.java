package com.didi.component.business.xpanelnew;

import org.json.JSONObject;

public interface XpNewAdapter {
    void setViewWithData(JSONObject jSONObject, IXpCardBindDataReadyCallback iXpCardBindDataReadyCallback);
}
