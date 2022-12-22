package com.didi.xengine.callback;

import com.didiglobal.enginecore.callback.XEReqParamsCallback;
import org.json.JSONObject;

public abstract class XEReqJSONParamsCallbackImpl implements XEReqParamsCallback<JSONObject> {
    public abstract JSONObject getRequestParams();
}
