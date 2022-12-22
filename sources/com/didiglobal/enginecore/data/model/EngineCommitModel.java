package com.didiglobal.enginecore.data.model;

import com.didiglobal.enginecore.XEngineCommitCallback;
import com.google.gson.JsonObject;

public class EngineCommitModel {
    public XEngineCommitCallback commitCallback;
    public JsonObject commitModel;

    public EngineCommitModel(XEngineCommitCallback xEngineCommitCallback) {
        this.commitCallback = xEngineCommitCallback;
    }
}
