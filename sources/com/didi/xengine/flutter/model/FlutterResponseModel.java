package com.didi.xengine.flutter.model;

import com.didiglobal.enginecore.data.model.XEngineData;
import com.google.gson.JsonObject;

public class FlutterResponseModel {
    public String errMsg;
    public int errNo;
    public JsonObject jsonObject;
    public String requestKey;
    public String scene;

    public FlutterResponseModel(int i, String str, String str2, XEngineData xEngineData) {
        this.errNo = i;
        this.errMsg = str;
        this.scene = str2;
        if (xEngineData != null) {
            this.requestKey = xEngineData.requestKey;
            this.jsonObject = xEngineData.jsonObject;
        }
    }

    public FlutterResponseModel(int i, String str, String str2) {
        this.errNo = i;
        this.errMsg = str;
        this.scene = str2;
    }
}
