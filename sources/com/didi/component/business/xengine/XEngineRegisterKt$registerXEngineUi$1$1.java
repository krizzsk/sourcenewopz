package com.didi.component.business.xengine;

import com.didiglobal.enginecore.callback.XEResponseCallback;
import com.didiglobal.enginecore.component.XEComponent;
import com.didiglobal.enginecore.data.exception.EngineErrorException;
import com.didiglobal.enginecore.data.model.XEngineData;
import com.google.gson.JsonObject;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J(\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0016¨\u0006\u000e"}, mo175978d2 = {"com/didi/component/business/xengine/XEngineRegisterKt$registerXEngineUi$1$1", "Lcom/didiglobal/enginecore/callback/XEResponseCallback;", "onFailed", "", "scene", "", "e", "Lcom/didiglobal/enginecore/data/exception/EngineErrorException;", "onSuccess", "data", "Lcom/didiglobal/enginecore/data/model/XEngineData;", "list", "", "Lcom/didiglobal/enginecore/component/XEComponent;", "common_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: XEngineRegister.kt */
public final class XEngineRegisterKt$registerXEngineUi$1$1 implements XEResponseCallback {
    final /* synthetic */ XEngineUiCallbackSupplier $proxy;

    XEngineRegisterKt$registerXEngineUi$1$1(XEngineUiCallbackSupplier xEngineUiCallbackSupplier) {
        this.$proxy = xEngineUiCallbackSupplier;
    }

    public void onSuccess(String str, XEngineData xEngineData, List<XEComponent> list) {
        Intrinsics.checkNotNullParameter(xEngineData, "data");
        Intrinsics.checkNotNullParameter(list, "list");
        Function2<JsonObject, List<? extends XEComponent>, Unit> onSuccessAction$common_release = this.$proxy.getOnSuccessAction$common_release();
        if (onSuccessAction$common_release != null) {
            JsonObject jsonObject = xEngineData.jsonObject;
            Intrinsics.checkNotNullExpressionValue(jsonObject, "data.jsonObject");
            onSuccessAction$common_release.invoke(jsonObject, list);
        }
    }

    public void onFailed(String str, EngineErrorException engineErrorException) {
        Intrinsics.checkNotNullParameter(engineErrorException, "e");
        Function1<Exception, Unit> onErrorAction$common_release = this.$proxy.getOnErrorAction$common_release();
        if (onErrorAction$common_release != null) {
            onErrorAction$common_release.invoke(engineErrorException);
        }
    }
}
