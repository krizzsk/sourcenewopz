package com.didi.payment.kycservice.utils;

import android.app.Application;
import com.didi.payment.commonsdk.p129ui.WBaseViewModel;
import com.didi.payment.kycservice.net.PixNetModel;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0012\u001a\u00020\u0013H\u0014J&\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u001aR\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u00020\tX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u001b"}, mo175978d2 = {"Lcom/didi/payment/kycservice/utils/PollVM;", "Lcom/didi/payment/commonsdk/ui/WBaseViewModel;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "executor", "Ljava/util/concurrent/ScheduledExecutorService;", "kotlin.jvm.PlatformType", "netModel", "Lcom/didi/payment/kycservice/net/PixNetModel;", "getNetModel", "()Lcom/didi/payment/kycservice/net/PixNetModel;", "pollCount", "", "getPollCount", "()I", "setPollCount", "(I)V", "onCleared", "", "pollPixKeyStatus", "keyType", "keyVal", "", "pollType", "callback", "Lcom/didi/payment/kycservice/utils/IPollResultCallback;", "kyc-service_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: PollVM.kt */
public abstract class PollVM extends WBaseViewModel {

    /* renamed from: a */
    private int f30938a;

    /* renamed from: b */
    private final PixNetModel f30939b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final ScheduledExecutorService f30940c = Executors.newSingleThreadScheduledExecutor();

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PollVM(Application application) {
        super(application);
        Intrinsics.checkNotNullParameter(application, "application");
        this.f30939b = new PixNetModel(application);
    }

    /* access modifiers changed from: protected */
    public final int getPollCount() {
        return this.f30938a;
    }

    /* access modifiers changed from: protected */
    public final void setPollCount(int i) {
        this.f30938a = i;
    }

    /* access modifiers changed from: protected */
    public final PixNetModel getNetModel() {
        return this.f30939b;
    }

    public final void pollPixKeyStatus(int i, String str, int i2, IPollResultCallback iPollResultCallback) {
        Intrinsics.checkNotNullParameter(str, "keyVal");
        Intrinsics.checkNotNullParameter(iPollResultCallback, "callback");
        this.f30938a++;
        this.f30939b.pollPixKeyStatus(i, str, i2, new PollVM$pollPixKeyStatus$1(this, iPollResultCallback, i, str, i2));
    }

    /* access modifiers changed from: protected */
    public void onCleared() {
        super.onCleared();
        this.f30940c.shutdown();
    }
}
