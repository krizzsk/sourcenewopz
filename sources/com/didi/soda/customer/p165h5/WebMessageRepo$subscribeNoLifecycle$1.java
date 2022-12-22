package com.didi.soda.customer.p165h5;

import com.didi.app.nova.skeleton.repo.Action1;
import com.didi.app.nova.skeleton.repo.Subscription;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\u0007\u001a\u00020\u0003H\u0016¨\u0006\b"}, mo175978d2 = {"com/didi/soda/customer/h5/WebMessageRepo$subscribeNoLifecycle$1", "Lcom/didi/app/nova/skeleton/repo/Subscription;", "activeChange", "", "active", "", "isUnsubscribed", "unsubscribe", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.soda.customer.h5.WebMessageRepo$subscribeNoLifecycle$1 */
/* compiled from: WebMessageRepo.kt */
public final class WebMessageRepo$subscribeNoLifecycle$1 implements Subscription {
    final /* synthetic */ Action1<WebMessage> $action;
    final /* synthetic */ WebMessageRepo this$0;

    public void activeChange(boolean z) {
    }

    WebMessageRepo$subscribeNoLifecycle$1(WebMessageRepo webMessageRepo, Action1<WebMessage> action1) {
        this.this$0 = webMessageRepo;
        this.$action = action1;
    }

    public boolean isUnsubscribed() {
        return !this.this$0.f41310a.contains(this.$action);
    }

    public void unsubscribe() {
        if (this.this$0.f41310a.contains(this.$action)) {
            this.this$0.f41310a.remove(this.$action);
        }
    }
}
