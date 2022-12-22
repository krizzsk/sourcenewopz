package com.didi.payment.kycservice.key.detail;

import android.app.Application;
import androidx.lifecycle.MutableLiveData;
import com.didi.payment.commonsdk.net.WBaseResp;
import com.didi.payment.commonsdk.p129ui.WBaseViewModel;
import com.didi.payment.kycservice.key.detail.response.PixKeyDetailResp;
import com.didi.payment.kycservice.net.PixNetModel;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u001c\u001a\u00020\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u001dH\u0014J\u0016\u0010\u001f\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020\u00132\u0006\u0010!\u001a\u00020\"J\u0016\u0010#\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020\u00132\u0006\u0010!\u001a\u00020\"J\u0016\u0010$\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020\u00132\u0006\u0010!\u001a\u00020\"J\u0016\u0010%\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020\u00132\u0006\u0010!\u001a\u00020\"R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\tR\u0016\u0010\r\u001a\n \u000f*\u0004\u0018\u00010\u000e0\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\tR\u001a\u0010\u0017\u001a\u00020\u000bX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006&"}, mo175978d2 = {"Lcom/didi/payment/kycservice/key/detail/PixKeyDetailVM;", "Lcom/didi/payment/commonsdk/ui/WBaseViewModel;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "bizData", "Landroidx/lifecycle/MutableLiveData;", "Lcom/didi/payment/kycservice/key/detail/response/PixKeyDetailResp$Data;", "getBizData", "()Landroidx/lifecycle/MutableLiveData;", "bizDefaultApiData", "Lcom/didi/payment/commonsdk/net/WBaseResp;", "getBizDefaultApiData", "executor", "Ljava/util/concurrent/ScheduledExecutorService;", "kotlin.jvm.PlatformType", "netModel", "Lcom/didi/payment/kycservice/net/PixNetModel;", "pollCount", "", "showUnbindRetLD", "", "getShowUnbindRetLD", "unBindApiData", "getUnBindApiData", "()Lcom/didi/payment/commonsdk/net/WBaseResp;", "setUnBindApiData", "(Lcom/didi/payment/commonsdk/net/WBaseResp;)V", "loadData", "", "onCleared", "pollPixKeyStatus", "keyType", "keyVal", "", "reqPixKeyDefault", "reqPixKeyDetail", "reqUnbindKey", "kyc-service_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: PixKeyDetailVM.kt */
public final class PixKeyDetailVM extends WBaseViewModel {

    /* renamed from: a */
    private final PixNetModel f30687a;

    /* renamed from: b */
    private final MutableLiveData<PixKeyDetailResp.Data> f30688b = new MutableLiveData<>();

    /* renamed from: c */
    private final MutableLiveData<Boolean> f30689c = new MutableLiveData<>();

    /* renamed from: d */
    private final MutableLiveData<WBaseResp> f30690d = new MutableLiveData<>();
    /* access modifiers changed from: private */

    /* renamed from: e */
    public final ScheduledExecutorService f30691e = Executors.newSingleThreadScheduledExecutor();
    /* access modifiers changed from: private */

    /* renamed from: f */
    public int f30692f;
    public WBaseResp unBindApiData;

    public void loadData() {
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PixKeyDetailVM(Application application) {
        super(application);
        Intrinsics.checkNotNullParameter(application, "application");
        this.f30687a = new PixNetModel(application);
    }

    public final MutableLiveData<PixKeyDetailResp.Data> getBizData() {
        return this.f30688b;
    }

    public final MutableLiveData<Boolean> getShowUnbindRetLD() {
        return this.f30689c;
    }

    public final MutableLiveData<WBaseResp> getBizDefaultApiData() {
        return this.f30690d;
    }

    public final WBaseResp getUnBindApiData() {
        WBaseResp wBaseResp = this.unBindApiData;
        if (wBaseResp != null) {
            return wBaseResp;
        }
        Intrinsics.throwUninitializedPropertyAccessException("unBindApiData");
        return null;
    }

    public final void setUnBindApiData(WBaseResp wBaseResp) {
        Intrinsics.checkNotNullParameter(wBaseResp, "<set-?>");
        this.unBindApiData = wBaseResp;
    }

    public final void reqPixKeyDetail(int i, String str) {
        Intrinsics.checkNotNullParameter(str, "keyVal");
        this.f30687a.getPixKeyDetail(i, str, new PixKeyDetailVM$reqPixKeyDetail$1(this));
    }

    public final void reqUnbindKey(int i, String str) {
        Intrinsics.checkNotNullParameter(str, "keyVal");
        this.f30687a.reqUnbindPixKey(i, str, new PixKeyDetailVM$reqUnbindKey$1(this, i, str));
    }

    public final void pollPixKeyStatus(int i, String str) {
        Intrinsics.checkNotNullParameter(str, "keyVal");
        this.f30692f++;
        this.f30687a.pollPixKeyStatus(i, str, 0, new PixKeyDetailVM$pollPixKeyStatus$1(this, i, str));
    }

    public final void reqPixKeyDefault(int i, String str) {
        Intrinsics.checkNotNullParameter(str, "keyVal");
        this.f30687a.setPixKeyDefault(i, str, new PixKeyDetailVM$reqPixKeyDefault$1(this));
    }

    /* access modifiers changed from: protected */
    public void onCleared() {
        super.onCleared();
        this.f30691e.shutdown();
    }
}
