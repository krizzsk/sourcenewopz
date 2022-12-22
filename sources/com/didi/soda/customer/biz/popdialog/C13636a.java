package com.didi.soda.customer.biz.popdialog;

import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didichuxing.dfbasesdk.utils.UIHandler;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u000b\u001a\u00020\u00072\b\b\u0002\u0010\f\u001a\u00020\rJ\u0014\u0010\u000e\u001a\u00020\u00072\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006R\u0016\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, mo175978d2 = {"Lcom/didi/soda/customer/biz/popdialog/AFMethodInvokeCount;", "", "time", "", "(J)V", "callback", "Lkotlin/Function0;", "", "count", "", "timeout", "add", "isFromDataSuccess", "", "setCallback", "c", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.soda.customer.biz.popdialog.a */
/* compiled from: AppsFlyerHelper.kt */
final class C13636a {

    /* renamed from: a */
    private int f40481a;

    /* renamed from: b */
    private final long f40482b;

    /* renamed from: c */
    private Function0<Unit> f40483c;

    public C13636a(long j) {
        this.f40482b = j;
    }

    /* renamed from: a */
    public final void mo102108a(Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "c");
        this.f40483c = function0;
    }

    /* renamed from: a */
    public static /* synthetic */ void m28711a(C13636a aVar, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        aVar.mo102109a(z);
    }

    /* renamed from: a */
    public final void mo102109a(boolean z) {
        LogUtil.m29104i("AppsFlyerListener", Intrinsics.stringPlus("add count = ", Integer.valueOf(this.f40481a)));
        if (z) {
            LogUtil.m29104i("AppsFlyerListener", Intrinsics.stringPlus("do delay timeout = ", Long.valueOf(this.f40482b)));
            UIHandler.postDelayed(this.f40482b, new Runnable() {
                public final void run() {
                    C13636a.m28710a(C13636a.this);
                }
            });
        }
        int i = this.f40481a + 1;
        this.f40481a = i;
        if (i == 2) {
            Function0<Unit> function0 = this.f40483c;
            if (function0 != null) {
                function0.invoke();
            }
            this.f40483c = null;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m28710a(C13636a aVar) {
        Intrinsics.checkNotNullParameter(aVar, "this$0");
        Function0<Unit> function0 = aVar.f40483c;
        if (function0 != null) {
            function0.invoke();
        }
        aVar.f40483c = null;
    }
}
