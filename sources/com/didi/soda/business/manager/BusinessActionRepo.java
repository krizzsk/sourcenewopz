package com.didi.soda.business.manager;

import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.app.nova.skeleton.repo.Action;
import com.didi.app.nova.skeleton.repo.Repo;
import com.didi.app.nova.skeleton.repo.Subscription;
import com.didi.soda.business.model.BusinessActionParam;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0016J$\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0010\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\nH\u0016¨\u0006\u000b"}, mo175978d2 = {"Lcom/didi/soda/business/manager/BusinessActionRepo;", "Lcom/didi/app/nova/skeleton/repo/Repo;", "Lcom/didi/soda/business/model/BusinessActionParam;", "()V", "getValue", "subscribe", "Lcom/didi/app/nova/skeleton/repo/Subscription;", "pageContext", "Lcom/didi/app/nova/skeleton/ScopeContext;", "action", "Lcom/didi/app/nova/skeleton/repo/Action;", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: BusinessActionRepo.kt */
public final class BusinessActionRepo extends Repo<BusinessActionParam> {
    public BusinessActionParam getValue() {
        if (super.getValue() == null) {
            return new BusinessActionParam(false, false, (Boolean) null, 7, (DefaultConstructorMarker) null);
        }
        return (BusinessActionParam) super.getValue();
    }

    public Subscription subscribe(ScopeContext scopeContext, Action<BusinessActionParam> action) {
        Subscription subscribe = getLiveData().from().shutViscidityNotice().subscribe(scopeContext, action);
        Intrinsics.checkNotNullExpressionValue(subscribe, "liveData.from().shutVisc…ribe(pageContext, action)");
        return subscribe;
    }
}
