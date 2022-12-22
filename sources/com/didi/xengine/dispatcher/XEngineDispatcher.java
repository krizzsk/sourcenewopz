package com.didi.xengine.dispatcher;

import android.text.TextUtils;
import com.didi.xengine.model.XECallbackModel;
import com.didi.xengine.register.XEngineCallbackRegister;
import com.didiglobal.enginecore.callback.XEResponseCallback;
import com.didiglobal.enginecore.component.XEComponent;
import com.didiglobal.enginecore.data.exception.EngineErrorException;
import com.didiglobal.enginecore.data.model.XEngineData;
import java.util.List;

public class XEngineDispatcher {
    public void dispatchOnFail(String str, String str2, EngineErrorException engineErrorException) {
        if (TextUtils.isEmpty(str2)) {
            for (XECallbackModel next : XEngineCallbackRegister.getCallbackMap().values()) {
                if (next.responses != null) {
                    for (XEResponseCallback onFailed : next.responses) {
                        onFailed.onFailed(str, engineErrorException);
                    }
                }
            }
            return;
        }
        XECallbackModel xECallbackModel = XEngineCallbackRegister.getCallbackMap().get(str2);
        if (xECallbackModel != null && xECallbackModel.responses != null) {
            for (XEResponseCallback onFailed2 : xECallbackModel.responses) {
                onFailed2.onFailed(str, engineErrorException);
            }
        }
    }

    public void dispatchOnSuccess(String str, XEngineData xEngineData, List<XEComponent> list) {
        if (TextUtils.isEmpty(xEngineData.requestKey)) {
            for (XECallbackModel next : XEngineCallbackRegister.getCallbackMap().values()) {
                if (next.responses != null) {
                    for (XEResponseCallback onSuccess : next.responses) {
                        onSuccess.onSuccess(str, xEngineData, list);
                    }
                }
            }
            return;
        }
        XECallbackModel xECallbackModel = XEngineCallbackRegister.getCallbackMap().get(xEngineData.requestKey);
        if (xECallbackModel != null && xECallbackModel.responses != null) {
            for (XEResponseCallback onSuccess2 : xECallbackModel.responses) {
                onSuccess2.onSuccess(str, xEngineData, list);
            }
        }
    }
}
