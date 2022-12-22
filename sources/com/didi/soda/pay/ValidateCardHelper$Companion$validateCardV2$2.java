package com.didi.soda.pay;

import com.didi.soda.customer.foundation.rpc.entity.SceneParamsEntity;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175977d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, mo175978d2 = {"<anonymous>", "", "it", "Lcom/didi/soda/customer/foundation/rpc/entity/SceneParamsEntity;"}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: ValidateCardHelper.kt */
final class ValidateCardHelper$Companion$validateCardV2$2 extends Lambda implements Function1<SceneParamsEntity, Unit> {
    public static final ValidateCardHelper$Companion$validateCardV2$2 INSTANCE = new ValidateCardHelper$Companion$validateCardV2$2();

    ValidateCardHelper$Companion$validateCardV2$2() {
        super(1);
    }

    public final void invoke(SceneParamsEntity sceneParamsEntity) {
        Intrinsics.checkNotNullParameter(sceneParamsEntity, "it");
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((SceneParamsEntity) obj);
        return Unit.INSTANCE;
    }
}
