package com.didi.xengine.callback;

import com.didiglobal.enginecore.callback.XEReqParamsCallback;

public abstract class XEReqStringParamsCallbackImpl implements XEReqParamsCallback<String> {
    public abstract String getRequestParams();
}
