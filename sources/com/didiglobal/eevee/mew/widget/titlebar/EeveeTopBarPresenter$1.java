package com.didiglobal.eevee.mew.widget.titlebar;

import com.didiglobal.enginecore.callback.XEResponseCallback;
import com.didiglobal.enginecore.component.XEComponent;
import com.didiglobal.enginecore.data.exception.EngineErrorException;
import com.didiglobal.enginecore.data.model.XEngineData;
import java.util.List;

class EeveeTopBarPresenter$1 implements XEResponseCallback {
    final /* synthetic */ C16807a this$0;

    public void onSuccess(String str, XEngineData xEngineData, List<XEComponent> list) {
    }

    EeveeTopBarPresenter$1(C16807a aVar) {
        this.this$0 = aVar;
    }

    public void onFailed(String str, EngineErrorException engineErrorException) {
        engineErrorException.printStackTrace();
    }
}
