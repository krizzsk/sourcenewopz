package com.didi.dimina.container.secondparty;

import com.didi.dimina.container.DMConfig;
import com.didi.dimina.container.DMMina;
import com.didi.dimina.container.mina.DMMinaPool;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0003*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, mo175978d2 = {"<anonymous>", "Lcom/didi/dimina/container/DMMina;", "dmMina", "kotlin.jvm.PlatformType", "relaunch", "com/didi/dimina/container/secondparty/Dimina4DiContainerActivity$parseConfig$1$1"}, mo175979k = 3, mo175980mv = {1, 1, 16})
/* compiled from: Dimina4DiContainerActivity.kt */
final class Dimina4DiContainerActivity$parseConfig$$inlined$let$lambda$1 implements DMConfig.ReLaunchCallback {
    final /* synthetic */ Dimina4DiContainerActivity this$0;

    Dimina4DiContainerActivity$parseConfig$$inlined$let$lambda$1(Dimina4DiContainerActivity dimina4DiContainerActivity) {
        this.this$0 = dimina4DiContainerActivity;
    }

    public final DMMina relaunch(DMMina dMMina) {
        Intrinsics.checkExpressionValueIsNotNull(dMMina, "dmMina");
        DMMinaPool.remove(dMMina.getMinaIndex(), true);
        Dimina4DiContainerActivity dimina4DiContainerActivity = this.this$0;
        dimina4DiContainerActivity.m12568a(dimina4DiContainerActivity.f17044a);
        DMMina access$getMDmMina$p = this.this$0.f17045b;
        if (access$getMDmMina$p == null) {
            Intrinsics.throwNpe();
        }
        return access$getMDmMina$p;
    }
}
