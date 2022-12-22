package com.didi.soda.globalcart.anim;

import com.didi.app.nova.skeleton.ScopeContext;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0006\u001a\u00020\u0007JG\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\f2#\u0010\u000e\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\f¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u00070\u000fR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, mo175978d2 = {"Lcom/didi/soda/globalcart/anim/TotalPriceManager;", "", "()V", "mAnimList", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "Lcom/didi/soda/globalcart/anim/TotalPriceAnim;", "release", "", "startAnim", "scopeContext", "Lcom/didi/app/nova/skeleton/ScopeContext;", "newDisplay", "", "lastDisplay", "setTextBlock", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "text", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: TotalPriceManager.kt */
public final class TotalPriceManager {

    /* renamed from: a */
    private final ConcurrentLinkedQueue<TotalPriceAnim> f42283a = new ConcurrentLinkedQueue<>();

    public final void startAnim(ScopeContext scopeContext, String str, String str2, Function1<? super String, Unit> function1) {
        Intrinsics.checkNotNullParameter(scopeContext, "scopeContext");
        Intrinsics.checkNotNullParameter(function1, "setTextBlock");
        Unit unit = null;
        if (!(str2 == null || str == null)) {
            TotalPriceAnim totalPriceAnim = new TotalPriceAnim(str, str2);
            this.f42283a.add(totalPriceAnim);
            totalPriceAnim.run(function1);
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            function1.invoke(str);
        }
    }

    public final void release() {
        while (!this.f42283a.isEmpty()) {
            TotalPriceAnim poll = this.f42283a.poll();
            if (poll != null) {
                poll.cancel();
            }
        }
    }
}
