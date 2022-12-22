package com.didi.soda.home.topgun.binder;

import com.didi.soda.customer.foundation.rpc.entity.TabInfoEntity;
import com.didi.soda.home.manager.LandinglogicRepo;
import com.didi.soda.home.topgun.binder.LandingHeaderBinder;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: LandingHeaderBinder.kt */
/* synthetic */ class LandingHeaderBinder$bind$1 extends FunctionReferenceImpl implements Function1<TabInfoEntity, Unit> {
    LandingHeaderBinder$bind$1(Object obj) {
        super(1, obj, LandingHeaderBinder.LandingHeaderBinderLogic.class, LandinglogicRepo.LOGIC_TYPE_ON_TAB_CLICK, "onTabClick(Lcom/didi/soda/customer/foundation/rpc/entity/TabInfoEntity;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((TabInfoEntity) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(TabInfoEntity tabInfoEntity) {
        Intrinsics.checkNotNullParameter(tabInfoEntity, "p0");
        ((LandingHeaderBinder.LandingHeaderBinderLogic) this.receiver).onTabClick(tabInfoEntity);
    }
}
