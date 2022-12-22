package com.didi.xengine.model;

import com.didiglobal.enginecore.callback.XEReqParamRunnableImpl;
import com.didiglobal.enginecore.callback.XEReqParamsCallback;
import com.didiglobal.enginecore.callback.XEResponseCallback;
import java.util.List;

public class XECallbackModel {
    public XEReqParamsCallback requestParams;
    public List<XEResponseCallback> responses;
    public XEReqParamRunnableImpl runnable;
    public List<String> scenes;
}
