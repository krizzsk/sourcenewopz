package com.didi.component.business.xengine;

import com.didiglobal.enginecore.component.XEComponent;
import com.google.gson.JsonObject;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\b\u0000¢\u0006\u0002\u0010\u0002JD\u0010\r\u001a\u00020\b2<\u0010\u000e\u001a8\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\b0\u0004R4\u0010\u0003\u001a\u001c\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0004\u0012\u00020\b\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u0013"}, mo175978d2 = {"Lcom/didi/component/business/xengine/XEngineUiCallbackSupplier;", "Lcom/didi/component/business/xengine/AbsXEngineCallback;", "()V", "onSuccessAction", "Lkotlin/Function2;", "Lcom/google/gson/JsonObject;", "", "Lcom/didiglobal/enginecore/component/XEComponent;", "", "getOnSuccessAction$common_release", "()Lkotlin/jvm/functions/Function2;", "setOnSuccessAction$common_release", "(Lkotlin/jvm/functions/Function2;)V", "onSuccess", "action", "Lkotlin/ParameterName;", "name", "rawData", "list", "common_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: XEngineRegister.kt */
public final class XEngineUiCallbackSupplier extends AbsXEngineCallback {

    /* renamed from: a */
    private Function2<? super JsonObject, ? super List<? extends XEComponent>, Unit> f11409a;

    public XEngineUiCallbackSupplier() {
        super((DefaultConstructorMarker) null);
    }

    public final Function2<JsonObject, List<? extends XEComponent>, Unit> getOnSuccessAction$common_release() {
        return this.f11409a;
    }

    public final void setOnSuccessAction$common_release(Function2<? super JsonObject, ? super List<? extends XEComponent>, Unit> function2) {
        this.f11409a = function2;
    }

    public final void onSuccess(Function2<? super JsonObject, ? super List<? extends XEComponent>, Unit> function2) {
        Intrinsics.checkNotNullParameter(function2, "action");
        this.f11409a = function2;
    }
}
