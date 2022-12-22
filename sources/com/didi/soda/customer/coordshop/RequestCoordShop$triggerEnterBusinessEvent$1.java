package com.didi.soda.customer.coordshop;

import com.didi.app.nova.skeleton.ILive;
import com.didi.app.nova.skeleton.repo.Subscription;
import com.didi.soda.customer.listener.SimpleScopeLifecycle;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref;

@Metadata(mo175977d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, mo175978d2 = {"com/didi/soda/customer/coordshop/RequestCoordShop$triggerEnterBusinessEvent$1", "Lcom/didi/soda/customer/listener/SimpleScopeLifecycle;", "onDestroy", "", "live", "Lcom/didi/app/nova/skeleton/ILive;", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: RequestCoordShop.kt */
public final class RequestCoordShop$triggerEnterBusinessEvent$1 extends SimpleScopeLifecycle {
    final /* synthetic */ Ref.ObjectRef<Subscription> $subscription;

    RequestCoordShop$triggerEnterBusinessEvent$1(Ref.ObjectRef<Subscription> objectRef) {
        this.$subscription = objectRef;
    }

    public void onDestroy(ILive iLive) {
        super.onDestroy(iLive);
        Subscription subscription = (Subscription) this.$subscription.element;
        if (subscription != null) {
            subscription.unsubscribe();
        }
    }
}
