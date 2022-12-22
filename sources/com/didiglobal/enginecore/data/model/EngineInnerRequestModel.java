package com.didiglobal.enginecore.data.model;

import com.didiglobal.enginecore.XEngineCallback;
import java.util.Map;

public class EngineInnerRequestModel {
    public Map<String, Object> bizParams;
    public XEngineCallback callback;
    public EngineCommitModel commitModel;
    public Map<String, Object> commonParams;
    public Boolean requestCache = false;
    public Boolean requestCacheOnly = false;
    public String[] requestKeys;
    public String scene;

    public EngineInnerRequestModel(String str, Map<String, Object> map, Map<String, Object> map2, XEngineCallback xEngineCallback) {
        this.scene = str;
        this.bizParams = map;
        this.commonParams = map2;
        this.callback = xEngineCallback;
    }
}
