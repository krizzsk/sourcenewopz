package com.didi.soda.customer.p165h5.invokejs;

import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.app.nova.skeleton.repo.Action1;
import com.didi.app.nova.skeleton.repo.Subscription;
import com.didi.soda.customer.foundation.rpc.entity.address.AddressEntity;
import com.didi.soda.customer.p165h5.CustomerWebPage;
import com.didi.soda.customer.p165h5.WebMessageRepo;
import com.didi.soda.customer.repo.RepoFactory;
import com.didi.soda.manager.CustomerManagerLoader;
import com.didi.soda.manager.base.ICustomerAddressManager;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(mo175977d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\f\u001a\u00020\r2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\n\u001a\u00020\u000bJ\u0006\u0010\u000e\u001a\u00020\rJ\b\u0010\u000f\u001a\u00020\rH\u0002J\b\u0010\u0010\u001a\u00020\rH\u0002J\b\u0010\u0011\u001a\u00020\rH\u0002J\u0010\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013J\u0010\u0010\u0015\u001a\u00020\r2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, mo175978d2 = {"Lcom/didi/soda/customer/h5/invokejs/TriggerJsHelper;", "", "()V", "scopeContext", "Lcom/didi/app/nova/skeleton/ScopeContext;", "subscriptions", "", "Lcom/didi/app/nova/skeleton/repo/Subscription;", "triggerManager", "Lcom/didi/soda/customer/h5/invokejs/TriggerManager;", "webPage", "Lcom/didi/soda/customer/h5/CustomerWebPage;", "attach", "", "detach", "listenAddressChanged", "listenBillMessage", "listenLifecycleChanged", "registerTrigger", "Lorg/json/JSONObject;", "params", "unregisterTrigger", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.soda.customer.h5.invokejs.TriggerJsHelper */
/* compiled from: TriggerJsHelper.kt */
public final class TriggerJsHelper {

    /* renamed from: a */
    private ScopeContext f41336a;

    /* renamed from: b */
    private CustomerWebPage f41337b;

    /* renamed from: c */
    private List<Subscription> f41338c = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final TriggerManager f41339d = new TriggerManager();

    /* renamed from: a */
    private final void m29287a() {
        Subscription subscribeAddressNoViscous = ((ICustomerAddressManager) CustomerManagerLoader.loadManager(ICustomerAddressManager.class)).subscribeAddressNoViscous(this.f41336a, new Action1() {
            public final void call(Object obj) {
                TriggerJsHelper.m29288a(TriggerJsHelper.this, (AddressEntity) obj);
            }
        });
        List<Subscription> list = this.f41338c;
        Intrinsics.checkNotNullExpressionValue(subscribeAddressNoViscous, "subscription");
        list.add(subscribeAddressNoViscous);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m29288a(TriggerJsHelper triggerJsHelper, AddressEntity addressEntity) {
        Intrinsics.checkNotNullParameter(triggerJsHelper, "this$0");
        ((CustomerWebTrigger) triggerJsHelper.f41339d.get(CustomerWebTrigger.class)).triggerAddressChanged();
    }

    /* renamed from: b */
    private final void m29289b() {
        ScopeContext scopeContext = this.f41336a;
        if (scopeContext != null) {
            scopeContext.addObserver(new TriggerJsHelper$listenLifecycleChanged$1(this));
        }
    }

    /* renamed from: c */
    private final void m29290c() {
        this.f41338c.add(((WebMessageRepo) RepoFactory.getRepo(WebMessageRepo.class)).subscribeNoLifecycle(this.f41336a, new TriggerJsHelper$listenBillMessage$subscription$1(this)));
    }

    public final void attach(ScopeContext scopeContext, CustomerWebPage customerWebPage) {
        Intrinsics.checkNotNullParameter(customerWebPage, "webPage");
        if (scopeContext != null) {
            this.f41337b = customerWebPage;
            this.f41336a = scopeContext;
            this.f41339d.attach(customerWebPage);
            m29290c();
            m29287a();
            m29289b();
        }
    }

    public final void detach() {
        for (Subscription unsubscribe : this.f41338c) {
            unsubscribe.unsubscribe();
        }
    }

    public final JSONObject registerTrigger(JSONObject jSONObject) {
        if (jSONObject == null) {
            return new JSONObject();
        }
        return this.f41339d.registerTrigger(jSONObject);
    }

    public final void unregisterTrigger(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.f41339d.unregisterTrigger(jSONObject);
        }
    }
}
