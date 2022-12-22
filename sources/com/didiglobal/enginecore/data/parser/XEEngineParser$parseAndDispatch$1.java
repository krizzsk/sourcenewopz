package com.didiglobal.enginecore.data.parser;

import android.content.Context;
import com.didiglobal.enginecore.XEParserCallback;
import com.didiglobal.enginecore.XEngineCallback;
import com.didiglobal.enginecore.component.XEComponent;
import com.didiglobal.enginecore.data.model.XEngineData;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u00020\u00032\n\u0010\u0004\u001a\u00060\u0005j\u0002`\u0006H\u0016J \u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bH\u0016J \u0010\r\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bH\u0016¨\u0006\u000e"}, mo175978d2 = {"com/didiglobal/enginecore/data/parser/XEEngineParser$parseAndDispatch$1", "Lcom/didiglobal/enginecore/XEParserCallback;", "onFail", "", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "onRenderSuccess", "engineData", "Lcom/didiglobal/enginecore/data/model/XEngineData;", "list", "", "Lcom/didiglobal/enginecore/component/XEComponent;", "onSuccess", "engine-core_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: XEEngineParser.kt */
public final class XEEngineParser$parseAndDispatch$1 implements XEParserCallback {
    final /* synthetic */ XEngineCallback $callback;
    final /* synthetic */ Context $context;
    final /* synthetic */ boolean $isCache;

    XEEngineParser$parseAndDispatch$1(Context context, XEngineCallback xEngineCallback, boolean z) {
        this.$context = context;
        this.$callback = xEngineCallback;
        this.$isCache = z;
    }

    public void onFail(Exception exc) {
        Intrinsics.checkParameterIsNotNull(exc, "e");
        exc.printStackTrace();
    }

    public void onSuccess(XEngineData xEngineData, List<? extends XEComponent> list) {
        Intrinsics.checkParameterIsNotNull(xEngineData, "engineData");
        XEEngineParser.INSTANCE.m36144a(this.$context, this.$callback, list, this, this.$isCache);
        xEngineData.isCache = this.$isCache;
        XEngineCallback xEngineCallback = this.$callback;
        if (xEngineCallback != null) {
            xEngineCallback.onSuccess(xEngineData, list);
        }
    }

    public void onRenderSuccess(XEngineData xEngineData, List<? extends XEComponent> list) {
        Intrinsics.checkParameterIsNotNull(xEngineData, "engineData");
        XEEngineParser.INSTANCE.m36144a(this.$context, this.$callback, list, this, this.$isCache);
        xEngineData.isCache = this.$isCache;
        XEngineCallback xEngineCallback = this.$callback;
        if (xEngineCallback != null) {
            xEngineCallback.onSuccessWithRenderList(xEngineData, list);
        }
    }
}
