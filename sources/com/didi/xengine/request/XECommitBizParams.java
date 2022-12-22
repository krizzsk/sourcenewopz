package com.didi.xengine.request;

import com.didiglobal.enginecore.XEngineCommitCallback;
import com.google.gson.JsonObject;
import java.util.Map;

public class XECommitBizParams extends XEBizParam {
    public String actionID;
    public String buttonType;
    public XEngineCommitCallback callback;
    @Deprecated
    public JsonObject commitModel;
    public Map<String, Object> extraParams;
    public String identifier;
    public String submitUrl;
}
