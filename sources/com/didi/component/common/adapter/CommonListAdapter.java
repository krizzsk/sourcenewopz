package com.didi.component.common.adapter;

import org.json.JSONObject;

public interface CommonListAdapter {
    void setViewWithData(JSONObject jSONObject, ICommonListCardBindDataReadyCallback iCommonListCardBindDataReadyCallback);
}
