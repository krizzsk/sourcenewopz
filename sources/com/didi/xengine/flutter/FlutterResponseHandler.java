package com.didi.xengine.flutter;

import com.didi.xengine.flutter.model.FlutterResponseModel;
import com.didiglobal.enginecore.callback.XEResponseCallback;
import com.didiglobal.enginecore.component.XEComponent;
import com.didiglobal.enginecore.data.exception.EngineErrorException;
import com.didiglobal.enginecore.data.model.XEngineData;
import java.util.List;

@Deprecated
public class FlutterResponseHandler implements XEResponseCallback {

    /* renamed from: a */
    private FlutterEngineResponse f45190a;

    public FlutterResponseHandler(FlutterEngineResponse flutterEngineResponse) {
        this.f45190a = flutterEngineResponse;
    }

    public void onSuccess(String str, XEngineData xEngineData, List<XEComponent> list) {
        if (this.f45190a != null) {
            this.f45190a.onMessageGot(new FlutterResponseModel(0, "success", str, xEngineData));
        }
    }

    public void onFailed(String str, EngineErrorException engineErrorException) {
        if (this.f45190a != null) {
            this.f45190a.onMessageGot(new FlutterResponseModel(engineErrorException.getErrNo(), "failed", str));
        }
    }
}
