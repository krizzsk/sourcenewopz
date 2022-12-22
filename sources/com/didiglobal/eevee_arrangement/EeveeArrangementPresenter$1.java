package com.didiglobal.eevee_arrangement;

import com.didiglobal.enginecore.callback.XEResponseCallback;
import com.didiglobal.enginecore.component.XEComponent;
import com.didiglobal.enginecore.data.exception.EngineErrorException;
import com.didiglobal.enginecore.data.model.XEngineData;
import java.util.List;

class EeveeArrangementPresenter$1 implements XEResponseCallback {
    final /* synthetic */ C16830a this$0;

    public void onFailed(String str, EngineErrorException engineErrorException) {
    }

    EeveeArrangementPresenter$1(C16830a aVar) {
        this.this$0 = aVar;
    }

    public void onSuccess(String str, XEngineData xEngineData, List<XEComponent> list) {
        if (xEngineData != null && xEngineData.jsonObject != null) {
            this.this$0.m36099a(xEngineData.jsonObject);
        }
    }
}
