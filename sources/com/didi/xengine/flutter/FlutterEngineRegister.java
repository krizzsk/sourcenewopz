package com.didi.xengine.flutter;

import android.text.TextUtils;
import com.didi.xengine.register.XERegister;
import com.didiglobal.enginecore.callback.EngineAsyncCallback;
import com.didiglobal.enginecore.callback.XEReqParamRunnableImpl;
import com.didiglobal.enginecore.callback.XEResponseCallback;
import com.didiglobal.enginecore.register.XERegisterModel;
import java.util.Map;

public class FlutterEngineRegister {
    public static void registerFlutterModel(final FlutterRegisterModel flutterRegisterModel, XEResponseCallback xEResponseCallback) {
        if (flutterRegisterModel != null && !flutterRegisterModel.scenes.isEmpty() && !TextUtils.isEmpty(flutterRegisterModel.identifier)) {
            XERegisterModel xERegisterModel = new XERegisterModel(flutterRegisterModel.identifier, flutterRegisterModel.scenes.get(0), xEResponseCallback);
            final String str = flutterRegisterModel.scenes.get(0);
            final String str2 = flutterRegisterModel.identifier;
            if (flutterRegisterModel.scenes.size() > 1) {
                xERegisterModel.scenes.clear();
                xERegisterModel.scenes = flutterRegisterModel.scenes;
            }
            xERegisterModel.priority = flutterRegisterModel.priority;
            xERegisterModel.required = flutterRegisterModel.required;
            if (flutterRegisterModel.callback != null) {
                xERegisterModel.paramRunnable = new XEReqParamRunnableImpl() {
                    public void run() {
                        if (this.runnableCallback != null) {
                            flutterRegisterModel.callback.getBizParams(str, str2, new EngineAsyncCallback() {
                                public void getBizParamsMap(Map<String, Object> map) {
                                    C148761.this.runnableCallback.getCallback(map);
                                }
                            });
                        }
                    }
                };
            }
            XERegister.registerTemplate(xERegisterModel);
        }
    }

    public static void unregisterFlutterModel(FlutterRegisterModel flutterRegisterModel) {
        if (flutterRegisterModel != null && !TextUtils.isEmpty(flutterRegisterModel.identifier)) {
            XERegister.unregisterTemplate(flutterRegisterModel.identifier);
        }
    }
}
