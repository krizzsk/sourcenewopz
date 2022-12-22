package com.didi.xengine.flutter;

import com.didi.xengine.flutter.model.FlutterResponseModel;

@Deprecated
public interface FlutterEngineResponse {
    void onMessageGot(FlutterResponseModel flutterResponseModel);
}
