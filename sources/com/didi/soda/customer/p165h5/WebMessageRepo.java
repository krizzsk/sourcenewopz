package com.didi.soda.customer.p165h5;

import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.app.nova.skeleton.repo.Action1;
import com.didi.app.nova.skeleton.repo.Repo;
import com.didi.app.nova.skeleton.repo.Subscription;
import com.didichuxing.dfbasesdk.utils.UIHandler;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(mo175977d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u000f2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000fB\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0002J\"\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0010\u0010\u000e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u0006R\u001e\u0010\u0004\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u00060\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, mo175978d2 = {"Lcom/didi/soda/customer/h5/WebMessageRepo;", "Lcom/didi/app/nova/skeleton/repo/Repo;", "Lcom/didi/soda/customer/h5/WebMessage;", "()V", "actions", "", "Lcom/didi/app/nova/skeleton/repo/Action1;", "dispatch", "", "data", "subscribeNoLifecycle", "Lcom/didi/app/nova/skeleton/repo/Subscription;", "pageContext", "Lcom/didi/app/nova/skeleton/ScopeContext;", "action", "Companion", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.soda.customer.h5.WebMessageRepo */
/* compiled from: WebMessageRepo.kt */
public final class WebMessageRepo extends Repo<WebMessage> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int billEvent = 1;
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final List<Action1<WebMessage>> f41310a = new ArrayList();

    @Metadata(mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo175978d2 = {"Lcom/didi/soda/customer/h5/WebMessageRepo$Companion;", "", "()V", "billEvent", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* renamed from: com.didi.soda.customer.h5.WebMessageRepo$Companion */
    /* compiled from: WebMessageRepo.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final void dispatch(WebMessage webMessage) {
        for (Action1 r1 : this.f41310a) {
            UIHandler.post(new Runnable(webMessage) {
                public final /* synthetic */ WebMessage f$1;

                {
                    this.f$1 = r2;
                }

                public final void run() {
                    WebMessageRepo.m29262a(Action1.this, this.f$1);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m29262a(Action1 action1, WebMessage webMessage) {
        if (action1 != null) {
            action1.call(webMessage);
        }
    }

    public final Subscription subscribeNoLifecycle(ScopeContext scopeContext, Action1<WebMessage> action1) {
        this.f41310a.add(action1);
        return new WebMessageRepo$subscribeNoLifecycle$1(this, action1);
    }
}
