package com.didi.component.business.xengine;

import com.didi.xengine.register.XERegister;
import com.didiglobal.enginecore.callback.XEResponseCallback;
import com.didiglobal.enginecore.register.XERegisterModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000,\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a5\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00052\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\n\u001a5\u0010\u000b\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00052\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\n¨\u0006\r"}, mo175978d2 = {"registerXEngineLogic", "Lcom/didiglobal/enginecore/callback/XEResponseCallback;", "requestKey", "", "scenes", "", "supplier", "Lkotlin/Function1;", "Lcom/didi/component/business/xengine/XELogicCallbackSupplier;", "", "Lkotlin/ExtensionFunctionType;", "registerXEngineUi", "Lcom/didi/component/business/xengine/XEngineUiCallbackSupplier;", "common_release"}, mo175979k = 2, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: XEngineRegister.kt */
public final class XEngineRegisterKt {
    public static final XEResponseCallback registerXEngineUi(String str, List<String> list, Function1<? super XEngineUiCallbackSupplier, Unit> function1) {
        Intrinsics.checkNotNullParameter(str, "requestKey");
        Intrinsics.checkNotNullParameter(list, "scenes");
        Intrinsics.checkNotNullParameter(function1, "supplier");
        XEngineUiCallbackSupplier xEngineUiCallbackSupplier = new XEngineUiCallbackSupplier();
        function1.invoke(xEngineUiCallbackSupplier);
        XEResponseCallback xEngineRegisterKt$registerXEngineUi$1$1 = new XEngineRegisterKt$registerXEngineUi$1$1(xEngineUiCallbackSupplier);
        XERegister.registerTemplate(new XERegisterModel(str, list, xEngineRegisterKt$registerXEngineUi$1$1));
        return xEngineRegisterKt$registerXEngineUi$1$1;
    }

    public static final XEResponseCallback registerXEngineLogic(String str, List<String> list, Function1<? super XELogicCallbackSupplier, Unit> function1) {
        Intrinsics.checkNotNullParameter(str, "requestKey");
        Intrinsics.checkNotNullParameter(list, "scenes");
        Intrinsics.checkNotNullParameter(function1, "supplier");
        XELogicCallbackSupplier xELogicCallbackSupplier = new XELogicCallbackSupplier();
        function1.invoke(xELogicCallbackSupplier);
        XEResponseCallback xEngineRegisterKt$registerXEngineLogic$1$1 = new XEngineRegisterKt$registerXEngineLogic$1$1(xELogicCallbackSupplier);
        XERegister.registerTemplate(new XERegisterModel(str, list, xEngineRegisterKt$registerXEngineLogic$1$1));
        return xEngineRegisterKt$registerXEngineLogic$1$1;
    }
}
