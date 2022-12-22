package com.didi.xengine.callback;

import com.didi.xengine.dispatcher.XEngineDispatcher;
import com.didiglobal.enginecore.XEngineCallback;
import com.didiglobal.enginecore.component.XEComponent;
import com.didiglobal.enginecore.data.exception.EngineErrorException;
import com.didiglobal.enginecore.data.model.XEngineData;
import java.util.List;
import java.util.Map;

public class XECallback implements XEngineCallback {

    /* renamed from: a */
    private String f45185a;

    /* renamed from: b */
    private XEngineDispatcher f45186b = new XEngineDispatcher();

    public XECallback(String str) {
        this.f45185a = str;
    }

    public void onSuccess(XEngineData xEngineData, List<XEComponent> list) {
        this.f45186b.dispatchOnSuccess(this.f45185a, xEngineData, list);
    }

    public void onSuccessWithRenderList(XEngineData xEngineData, List<XEComponent> list) {
        this.f45186b.dispatchOnSuccess(this.f45185a, xEngineData, list);
    }

    public void onFailed(Map<String, EngineErrorException> map) {
        if (map != null && !map.isEmpty()) {
            for (Map.Entry next : map.entrySet()) {
                if (!(next == null || next.getKey() == null)) {
                    this.f45186b.dispatchOnFail(this.f45185a, (String) next.getKey(), (EngineErrorException) next.getValue());
                }
            }
        }
    }
}
