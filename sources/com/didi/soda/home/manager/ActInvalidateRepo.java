package com.didi.soda.home.manager;

import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.app.nova.skeleton.repo.Action;
import com.didi.app.nova.skeleton.repo.Repo;
import com.didi.app.nova.skeleton.repo.Subscription;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\t¨\u0006\n"}, mo175978d2 = {"Lcom/didi/soda/home/manager/ActInvalidateRepo;", "Lcom/didi/app/nova/skeleton/repo/Repo;", "", "()V", "subscriptionNoViscous", "Lcom/didi/app/nova/skeleton/repo/Subscription;", "pageContext", "Lcom/didi/app/nova/skeleton/ScopeContext;", "action", "Lcom/didi/app/nova/skeleton/repo/Action;", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: ActInvalidateRepo.kt */
public final class ActInvalidateRepo extends Repo<String> {
    public final Subscription subscriptionNoViscous(ScopeContext scopeContext, Action<String> action) {
        Subscription subscribe = getLiveData().from().shutViscidityNotice().subscribe(scopeContext, action);
        Intrinsics.checkNotNullExpressionValue(subscribe, "liveData.from().shutVisc…ribe(pageContext, action)");
        return subscribe;
    }
}
