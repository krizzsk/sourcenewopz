package com.didiglobal.ibg_rpc_service;

import com.didiglobal.ibg_rpc_service.internal.Executors;
import com.didiglobal.ibg_rpc_service.internal.Logger;
import com.didiglobal.ibg_rpc_service.internal.ResponseWrapper;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import p242io.flutter.plugin.common.MethodChannel;

@Metadata(mo175977d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, mo175978d2 = {"<anonymous>", "", "it", "Lcom/didiglobal/ibg_rpc_service/internal/ResponseWrapper;"}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: IbgRpcServicePlugin.kt */
final class IbgRpcServicePlugin$onMethodCall$callback$1 extends Lambda implements Function1<ResponseWrapper, Unit> {
    final /* synthetic */ MethodChannel.Result $result;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    IbgRpcServicePlugin$onMethodCall$callback$1(MethodChannel.Result result) {
        super(1);
        this.$result = result;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((ResponseWrapper) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(ResponseWrapper responseWrapper) {
        Intrinsics.checkNotNullParameter(responseWrapper, "it");
        Logger.m36210v("IbgRpcServicePlugin", "thread=" + Thread.currentThread().getName() + " result.success#" + responseWrapper);
        Executors.INSTANCE.runOnMain(new Runnable(responseWrapper) {
            public final /* synthetic */ ResponseWrapper f$1;

            {
                this.f$1 = r2;
            }

            public final void run() {
                IbgRpcServicePlugin$onMethodCall$callback$1.m47047invoke$lambda0(MethodChannel.Result.this, this.f$1);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: invoke$lambda-0  reason: not valid java name */
    public static final void m47047invoke$lambda0(MethodChannel.Result result, ResponseWrapper responseWrapper) {
        Intrinsics.checkNotNullParameter(result, "$result");
        Intrinsics.checkNotNullParameter(responseWrapper, "$it");
        result.success(responseWrapper.toMap());
    }
}
