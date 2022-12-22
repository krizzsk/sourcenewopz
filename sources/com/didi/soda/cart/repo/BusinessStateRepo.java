package com.didi.soda.cart.repo;

import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.app.nova.skeleton.repo.Action1;
import com.didi.app.nova.skeleton.repo.Repo;
import com.didi.app.nova.skeleton.repo.Subscription;
import com.didi.soda.cart.model.BusinessState;
import com.didi.soda.customer.foundation.util.CloneUtil;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002(\u0012$\u0012\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0002j\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u00050\u0001B\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\u0003J(\u0010\t\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0002j\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005H\u0016J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0004J$\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00040\u0013¨\u0006\u0014"}, mo175978d2 = {"Lcom/didi/soda/cart/repo/BusinessStateRepo;", "Lcom/didi/app/nova/skeleton/repo/Repo;", "Ljava/util/HashMap;", "", "Lcom/didi/soda/cart/model/BusinessState;", "Lkotlin/collections/HashMap;", "()V", "getState", "id", "getValue", "setValue", "", "businessState", "subscribe", "Lcom/didi/app/nova/skeleton/repo/Subscription;", "shopId", "scopeContext", "Lcom/didi/app/nova/skeleton/ScopeContext;", "action", "Lcom/didi/app/nova/skeleton/repo/Action1;", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: BusinessStateRepo.kt */
public final class BusinessStateRepo extends Repo<HashMap<String, BusinessState>> {
    public HashMap<String, BusinessState> getValue() {
        return (HashMap) super.getValue();
    }

    public final void setValue(BusinessState businessState) {
        Intrinsics.checkNotNullParameter(businessState, "businessState");
        HashMap value = getValue();
        if (value == null) {
            value = new HashMap();
        }
        String str = businessState.shopId;
        Intrinsics.checkNotNullExpressionValue(str, "businessState.shopId");
        value.put(str, businessState);
        super.setValue(value);
    }

    public final BusinessState getState(String str) {
        Intrinsics.checkNotNullParameter(str, "id");
        Map value = getValue();
        if (value == null || !(!value.isEmpty())) {
            return null;
        }
        return (BusinessState) CloneUtil.deepClone(value.get(str));
    }

    public final Subscription subscribe(String str, ScopeContext scopeContext, Action1<BusinessState> action1) {
        Intrinsics.checkNotNullParameter(str, "shopId");
        Intrinsics.checkNotNullParameter(scopeContext, "scopeContext");
        Intrinsics.checkNotNullParameter(action1, "action");
        Subscription subscribe = subscribe(scopeContext, new Action1(str, action1) {
            public final /* synthetic */ String f$0;
            public final /* synthetic */ Action1 f$1;

            {
                this.f$0 = r1;
                this.f$1 = r2;
            }

            public final void call(Object obj) {
                BusinessStateRepo.m28531a(this.f$0, this.f$1, (HashMap) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(subscribe, "subscribe(scopeContext, …\n            }\n        })");
        return subscribe;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m28531a(String str, Action1 action1, HashMap hashMap) {
        Intrinsics.checkNotNullParameter(str, "$shopId");
        Intrinsics.checkNotNullParameter(action1, "$action");
        if (hashMap != null && hashMap.containsKey(str)) {
            action1.call(hashMap.get(str));
        }
    }
}
