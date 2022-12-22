package com.didi.soda.globalcart.component;

import com.didi.soda.customer.app.ApplicationForegroundListener;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005H\u0016¨\u0006\n"}, mo175978d2 = {"com/didi/soda/globalcart/component/GlobalCartPresenter$foregroundListener$1", "Lcom/didi/soda/customer/app/ApplicationForegroundListener;", "onBecomeBackground", "", "currentBackgroundTime", "", "lastForegroundTime", "onBecomeForeground", "currentForegroundTime", "lastBackgroundTime", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: GlobalCartPresenter.kt */
public final class GlobalCartPresenter$foregroundListener$1 implements ApplicationForegroundListener {
    final /* synthetic */ GlobalCartPresenter this$0;

    public void onBecomeForeground(long j, long j2) {
    }

    GlobalCartPresenter$foregroundListener$1(GlobalCartPresenter globalCartPresenter) {
        this.this$0 = globalCartPresenter;
    }

    public void onBecomeBackground(long j, long j2) {
        this.this$0.f42286c = true;
    }
}
