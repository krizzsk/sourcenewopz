package com.didi.component.business.xengine;

import com.didiglobal.enginecore.data.model.XEngineData;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0000¢\u0006\u0002\u0010\u0002J)\u0010\u000b\u001a\u00020\u00062!\u0010\f\u001a\u001d\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00060\u0004R(\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u0010"}, mo175978d2 = {"Lcom/didi/component/business/xengine/XELogicCallbackSupplier;", "Lcom/didi/component/business/xengine/AbsXEngineCallback;", "()V", "onSuccessAction", "Lkotlin/Function1;", "Lcom/didiglobal/enginecore/data/model/XEngineData;", "", "getOnSuccessAction$common_release", "()Lkotlin/jvm/functions/Function1;", "setOnSuccessAction$common_release", "(Lkotlin/jvm/functions/Function1;)V", "onSuccess", "action", "Lkotlin/ParameterName;", "name", "rawData", "common_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: XEngineRegister.kt */
public final class XELogicCallbackSupplier extends AbsXEngineCallback {

    /* renamed from: a */
    private Function1<? super XEngineData, Unit> f11406a;

    public XELogicCallbackSupplier() {
        super((DefaultConstructorMarker) null);
    }

    public final Function1<XEngineData, Unit> getOnSuccessAction$common_release() {
        return this.f11406a;
    }

    public final void setOnSuccessAction$common_release(Function1<? super XEngineData, Unit> function1) {
        this.f11406a = function1;
    }

    public final void onSuccess(Function1<? super XEngineData, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "action");
        this.f11406a = function1;
    }
}
