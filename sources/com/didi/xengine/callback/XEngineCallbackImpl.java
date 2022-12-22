package com.didi.xengine.callback;

import com.didiglobal.enginecore.XEngineCallback;
import com.didiglobal.enginecore.component.XEComponent;
import com.didiglobal.enginecore.data.exception.EngineErrorException;
import com.didiglobal.enginecore.data.model.XEngineData;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u001c\u0010\u0007\u001a\u00020\b2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000b0\nH\u0016J \u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000e2\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010H\u0016J \u0010\u0012\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000e2\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010H\u0016J\u0010\u0010\u0013\u001a\u00020\b2\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, mo175978d2 = {"Lcom/didi/xengine/callback/XEngineCallbackImpl;", "Lcom/didiglobal/enginecore/XEngineCallback;", "scene", "", "(Ljava/lang/String;)V", "callback", "Lcom/didi/xengine/callback/XECallback;", "onFailed", "", "failedMap", "", "Lcom/didiglobal/enginecore/data/exception/EngineErrorException;", "onSuccess", "data", "Lcom/didiglobal/enginecore/data/model/XEngineData;", "list", "", "Lcom/didiglobal/enginecore/component/XEComponent;", "onSuccessWithRenderList", "setScene", "x-engine_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: XEngineCallbackImpl.kt */
public final class XEngineCallbackImpl implements XEngineCallback {

    /* renamed from: a */
    private XECallback f45187a;

    public XEngineCallbackImpl(String str) {
        this.f45187a = new XECallback(str);
    }

    public final void setScene(String str) {
        this.f45187a = new XECallback(str);
    }

    public void onSuccess(XEngineData xEngineData, List<? extends XEComponent> list) {
        Intrinsics.checkParameterIsNotNull(xEngineData, "data");
        this.f45187a.onSuccess(xEngineData, list);
    }

    public void onSuccessWithRenderList(XEngineData xEngineData, List<? extends XEComponent> list) {
        Intrinsics.checkParameterIsNotNull(xEngineData, "data");
        this.f45187a.onSuccessWithRenderList(xEngineData, list);
    }

    public void onFailed(Map<String, ? extends EngineErrorException> map) {
        Intrinsics.checkParameterIsNotNull(map, "failedMap");
        this.f45187a.onFailed(map);
    }
}
