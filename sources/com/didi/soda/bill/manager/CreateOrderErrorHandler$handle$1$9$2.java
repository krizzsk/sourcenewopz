package com.didi.soda.bill.manager;

import com.didi.soda.customer.foundation.rpc.entity.SceneParamsEntity;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175977d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, mo175978d2 = {"<anonymous>", "", "senceParam", "Lcom/didi/soda/customer/foundation/rpc/entity/SceneParamsEntity;"}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CreateOrderErrorHandler.kt */
final class CreateOrderErrorHandler$handle$1$9$2 extends Lambda implements Function1<SceneParamsEntity, Unit> {
    final /* synthetic */ CreateOrderErrorHandler this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CreateOrderErrorHandler$handle$1$9$2(CreateOrderErrorHandler createOrderErrorHandler) {
        super(1);
        this.this$0 = createOrderErrorHandler;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((SceneParamsEntity) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(SceneParamsEntity sceneParamsEntity) {
        Intrinsics.checkNotNullParameter(sceneParamsEntity, "senceParam");
        this.this$0.m27698a(1, sceneParamsEntity);
    }
}
