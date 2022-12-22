package com.didi.soda.customer.foundation.report;

import com.didi.soda.customer.app.ApplicationForegroundListener;
import com.didi.soda.customer.app.CustomerApplicationLifecycleHandler;
import com.didi.soda.customer.foundation.rpc.CustomerRpcManagerProxy;
import com.didi.soda.customer.foundation.rpc.CustomerRpcService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u000e\u001a\u00020\u000fJ\u0006\u0010\u0010\u001a\u00020\u000fJ\u0006\u0010\u0011\u001a\u00020\u000fJ\u0006\u0010\u0012\u001a\u00020\u000fJ\u0006\u0010\u0013\u001a\u00020\u000fJ\u0010\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u0004H\u0002J\u0006\u0010\u0016\u001a\u00020\u000fJ\u0006\u0010\u0017\u001a\u00020\u000fJ\u0006\u0010\u0018\u001a\u00020\u000fR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, mo175978d2 = {"Lcom/didi/soda/customer/foundation/report/CustomerUserEventReporter;", "", "()V", "USER_EVENT_APP_KILL", "", "USER_EVENT_APP_START", "USER_EVENT_BECOME_BACKGROUND", "USER_EVENT_BECOME_FOREGROUND", "USER_EVENT_TAB_IN", "USER_EVENT_TAB_OUT", "mForegroundListener", "Lcom/didi/soda/customer/app/ApplicationForegroundListener;", "mRpcService", "Lcom/didi/soda/customer/foundation/rpc/CustomerRpcService;", "bindApplicationLifecycle", "", "reportAppKill", "reportAppStart", "reportBackground", "reportForeground", "reportInner", "eventCode", "reportTabIn", "reportTabOut", "unBindApplicationLifecycle", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CustomerUserEventReporter.kt */
public final class CustomerUserEventReporter {
    public static final CustomerUserEventReporter INSTANCE = new CustomerUserEventReporter();

    /* renamed from: a */
    private static final int f40954a = 100;

    /* renamed from: b */
    private static final int f40955b = 200;

    /* renamed from: c */
    private static final int f40956c = 300;

    /* renamed from: d */
    private static final int f40957d = 400;

    /* renamed from: e */
    private static final int f40958e = 500;

    /* renamed from: f */
    private static final int f40959f = 600;

    /* renamed from: g */
    private static CustomerRpcService f40960g;

    /* renamed from: h */
    private static ApplicationForegroundListener f40961h = new CustomerUserEventReporter$mForegroundListener$1();

    private CustomerUserEventReporter() {
    }

    static {
        CustomerRpcService customerRpcService = CustomerRpcManagerProxy.get();
        Intrinsics.checkNotNullExpressionValue(customerRpcService, "get()");
        f40960g = customerRpcService;
    }

    public final void bindApplicationLifecycle() {
        CustomerApplicationLifecycleHandler.getInstance().registerForegroundListener(f40961h);
    }

    public final void reportAppKill() {
        m29115a(400);
    }

    public final void reportAppStart() {
        m29115a(100);
    }

    public final void reportBackground() {
        m29115a(200);
    }

    public final void reportForeground() {
        m29115a(300);
    }

    public final void reportTabIn() {
        m29115a(500);
    }

    public final void reportTabOut() {
        m29115a(600);
    }

    public final void unBindApplicationLifecycle() {
        CustomerApplicationLifecycleHandler.getInstance().unregisterForegroundListener(f40961h);
    }

    /* renamed from: a */
    private final void m29115a(int i) {
        f40960g.reportUserEvent(i, new CustomerUserEventReporter$reportInner$1());
    }
}
