package com.didi.payment.kycservice.key.migrateout.p132vm;

import android.app.Application;
import androidx.lifecycle.MutableLiveData;
import com.didi.payment.commonsdk.net.WBaseResp;
import com.didi.payment.commonsdk.p129ui.WBaseViewModel;
import com.didi.payment.kycservice.key.migrateout.response.PixKeyMigrateOutListResp;
import com.didi.payment.kycservice.net.PixNetModel;
import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010$\u001a\u00020%J\u0006\u0010&\u001a\u00020%J\b\u0010'\u001a\u0004\u0018\u00010(J\u0006\u0010)\u001a\u00020\tJ\b\u0010*\u001a\u00020%H\u0016J\b\u0010+\u001a\u00020%H\u0014J\u0018\u0010,\u001a\u00020%2\u0006\u0010-\u001a\u00020\u001c2\u0006\u0010.\u001a\u00020/H\u0002R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\n\"\u0004\b\u000b\u0010\fR\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u00020\u0010X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0019\u001a\u00020\u001aX\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0018R\u000e\u0010\u001e\u001a\u00020\u001cX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001f\u001a\u00020\u001cX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#¨\u00060"}, mo175978d2 = {"Lcom/didi/payment/kycservice/key/migrateout/vm/PixKeyMigrateOutVM;", "Lcom/didi/payment/commonsdk/ui/WBaseViewModel;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "executor", "Ljava/util/concurrent/ScheduledExecutorService;", "kotlin.jvm.PlatformType", "isFirstLoad", "", "()Z", "setFirstLoad", "(Z)V", "migrateOutData", "Lcom/didi/payment/commonsdk/net/WBaseResp;", "migrateOutListData", "Lcom/didi/payment/kycservice/key/migrateout/response/PixKeyMigrateOutListResp$Data;", "getMigrateOutListData", "()Lcom/didi/payment/kycservice/key/migrateout/response/PixKeyMigrateOutListResp$Data;", "setMigrateOutListData", "(Lcom/didi/payment/kycservice/key/migrateout/response/PixKeyMigrateOutListResp$Data;)V", "migrateOutRespLD", "Landroidx/lifecycle/MutableLiveData;", "getMigrateOutRespLD", "()Landroidx/lifecycle/MutableLiveData;", "netModel", "Lcom/didi/payment/kycservice/net/PixNetModel;", "pageSceneLD", "", "getPageSceneLD", "pollCount", "position", "getPosition", "()I", "setPosition", "(I)V", "cancelMigrateOut", "", "doMigrateOut", "getDetailPageData", "Lcom/didi/payment/kycservice/key/migrateout/response/PixKeyMigrateOutListResp$KeyItem;", "isOnlyOneMigratedKey", "loadData", "onCleared", "pollPixKeyStatus", "keyType", "keyVal", "", "kyc-service_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.payment.kycservice.key.migrateout.vm.PixKeyMigrateOutVM */
/* compiled from: PixKeyMigrateOutVM.kt */
public final class PixKeyMigrateOutVM extends WBaseViewModel {

    /* renamed from: a */
    private final PixNetModel f30720a;

    /* renamed from: b */
    private final MutableLiveData<Integer> f30721b = new MutableLiveData<>();

    /* renamed from: c */
    private final MutableLiveData<WBaseResp> f30722c = new MutableLiveData<>();

    /* renamed from: d */
    private int f30723d;

    /* renamed from: e */
    private boolean f30724e = true;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public int f30725f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public final ScheduledExecutorService f30726g = Executors.newSingleThreadScheduledExecutor();
    /* access modifiers changed from: private */

    /* renamed from: h */
    public WBaseResp f30727h;
    public PixKeyMigrateOutListResp.Data migrateOutListData;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PixKeyMigrateOutVM(Application application) {
        super(application);
        Intrinsics.checkNotNullParameter(application, "application");
        this.f30720a = new PixNetModel(application);
        loadData();
    }

    public final PixKeyMigrateOutListResp.Data getMigrateOutListData() {
        PixKeyMigrateOutListResp.Data data = this.migrateOutListData;
        if (data != null) {
            return data;
        }
        Intrinsics.throwUninitializedPropertyAccessException("migrateOutListData");
        return null;
    }

    public final void setMigrateOutListData(PixKeyMigrateOutListResp.Data data) {
        Intrinsics.checkNotNullParameter(data, "<set-?>");
        this.migrateOutListData = data;
    }

    public final MutableLiveData<Integer> getPageSceneLD() {
        return this.f30721b;
    }

    public final MutableLiveData<WBaseResp> getMigrateOutRespLD() {
        return this.f30722c;
    }

    public final int getPosition() {
        return this.f30723d;
    }

    public final void setPosition(int i) {
        this.f30723d = i;
    }

    public final boolean isFirstLoad() {
        return this.f30724e;
    }

    public final void setFirstLoad(boolean z) {
        this.f30724e = z;
    }

    public final PixKeyMigrateOutListResp.KeyItem getDetailPageData() {
        ArrayList<PixKeyMigrateOutListResp.KeyItem> items = getMigrateOutListData().getItems();
        Intrinsics.checkNotNull(items);
        return items.get(this.f30723d);
    }

    public final boolean isOnlyOneMigratedKey() {
        ArrayList<PixKeyMigrateOutListResp.KeyItem> items = getMigrateOutListData().getItems();
        Intrinsics.checkNotNull(items);
        return items.size() == 1;
    }

    public void loadData() {
        this.f30720a.getPixKeyMigrateOutList(new PixKeyMigrateOutVM$loadData$1(this));
    }

    public final void doMigrateOut() {
        int i;
        String value;
        this.f30725f = 0;
        PixKeyMigrateOutListResp.KeyItem detailPageData = getDetailPageData();
        if (detailPageData == null) {
            i = -100;
        } else {
            i = detailPageData.getType();
        }
        String str = "";
        if (!(detailPageData == null || (value = detailPageData.getValue()) == null)) {
            str = value;
        }
        this.f30720a.reqPixKeyMigrateOut(i, str, new PixKeyMigrateOutVM$doMigrateOut$1(this, i, str));
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m21594a(int i, String str) {
        this.f30725f++;
        this.f30720a.pollPixKeyStatus(i, str, 3, new PixKeyMigrateOutVM$pollPixKeyStatus$1(this, i, str));
    }

    public final void cancelMigrateOut() {
        int i;
        String value;
        PixKeyMigrateOutListResp.KeyItem detailPageData = getDetailPageData();
        if (detailPageData == null) {
            i = -100;
        } else {
            i = detailPageData.getType();
        }
        String str = "";
        if (!(detailPageData == null || (value = detailPageData.getValue()) == null)) {
            str = value;
        }
        this.f30720a.cancelPixKeyMigrateOut(i, str, new PixKeyMigrateOutVM$cancelMigrateOut$1(this));
    }

    /* access modifiers changed from: protected */
    public void onCleared() {
        super.onCleared();
        this.f30726g.shutdown();
    }
}
