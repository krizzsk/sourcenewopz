package com.didi.payment.kycservice.kyc.p133vm;

import android.app.Application;
import androidx.lifecycle.MutableLiveData;
import com.didi.payment.commonsdk.net.WBaseResp;
import com.didi.payment.kycservice.kyc.response.CPFCheckResp;
import com.didi.payment.kycservice.kyc.response.PixChooseTypeListResp;
import com.didi.payment.kycservice.kyc.response.PixKeyMigrateInResp;
import com.didi.payment.kycservice.kyc.response.ResultPageData;
import com.didi.payment.kycservice.net.PixNetModel;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u000eJ\u0016\u0010$\u001a\u00020\"2\u0006\u0010%\u001a\u00020\u001a2\u0006\u0010&\u001a\u00020'J\b\u0010(\u001a\u00020\"H\u0014J\u0016\u0010)\u001a\u00020\"2\u0006\u0010%\u001a\u00020\u001a2\u0006\u0010&\u001a\u00020'R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\tR\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0013\u001a\n \u0015*\u0004\u0018\u00010\u00140\u0014X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\tR\u000e\u0010\u0019\u001a\u00020\u001aX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 ¨\u0006*"}, mo175978d2 = {"Lcom/didi/payment/kycservice/kyc/vm/ChooseKeyTypeVM;", "Lcom/didi/payment/kycservice/kyc/vm/ChooseTypeBaseVM;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "bizMigrateInApiData", "Landroidx/lifecycle/MutableLiveData;", "Lcom/didi/payment/commonsdk/net/WBaseResp;", "getBizMigrateInApiData", "()Landroidx/lifecycle/MutableLiveData;", "cpfCheckData", "Lcom/didi/payment/kycservice/kyc/response/CPFCheckResp;", "getCpfCheckData", "cpfItemData", "Lcom/didi/payment/kycservice/kyc/response/PixChooseTypeListResp$Item;", "getCpfItemData", "()Lcom/didi/payment/kycservice/kyc/response/PixChooseTypeListResp$Item;", "setCpfItemData", "(Lcom/didi/payment/kycservice/kyc/response/PixChooseTypeListResp$Item;)V", "executor", "Ljava/util/concurrent/ScheduledExecutorService;", "kotlin.jvm.PlatformType", "migrateInResp", "Lcom/didi/payment/kycservice/kyc/response/PixKeyMigrateInResp;", "getMigrateInResp", "pollCount", "", "resultPageData", "Lcom/didi/payment/kycservice/kyc/response/ResultPageData;", "getResultPageData", "()Lcom/didi/payment/kycservice/kyc/response/ResultPageData;", "setResultPageData", "(Lcom/didi/payment/kycservice/kyc/response/ResultPageData;)V", "checkCPF", "", "item", "migrateIn", "keyType", "keyVal", "", "onCleared", "pollPixKeyStatus", "kyc-service_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.payment.kycservice.kyc.vm.ChooseKeyTypeVM */
/* compiled from: ChooseKeyTypeVM.kt */
public final class ChooseKeyTypeVM extends ChooseTypeBaseVM {

    /* renamed from: a */
    private final MutableLiveData<CPFCheckResp> f30862a = new MutableLiveData<>();

    /* renamed from: b */
    private final MutableLiveData<PixKeyMigrateInResp> f30863b = new MutableLiveData<>();

    /* renamed from: c */
    private final MutableLiveData<WBaseResp> f30864c = new MutableLiveData<>();

    /* renamed from: d */
    private PixChooseTypeListResp.Item f30865d;

    /* renamed from: e */
    private ResultPageData f30866e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public final ScheduledExecutorService f30867f = Executors.newSingleThreadScheduledExecutor();
    /* access modifiers changed from: private */

    /* renamed from: g */
    public int f30868g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ChooseKeyTypeVM(Application application) {
        super(application, 1);
        Intrinsics.checkNotNullParameter(application, "application");
    }

    public final MutableLiveData<CPFCheckResp> getCpfCheckData() {
        return this.f30862a;
    }

    public final MutableLiveData<PixKeyMigrateInResp> getMigrateInResp() {
        return this.f30863b;
    }

    public final MutableLiveData<WBaseResp> getBizMigrateInApiData() {
        return this.f30864c;
    }

    public final PixChooseTypeListResp.Item getCpfItemData() {
        return this.f30865d;
    }

    public final void setCpfItemData(PixChooseTypeListResp.Item item) {
        this.f30865d = item;
    }

    public final ResultPageData getResultPageData() {
        return this.f30866e;
    }

    public final void setResultPageData(ResultPageData resultPageData) {
        this.f30866e = resultPageData;
    }

    public final void checkCPF(PixChooseTypeListResp.Item item) {
        String defaultValue;
        Intrinsics.checkNotNullParameter(item, "item");
        this.f30865d = item;
        PixNetModel netModel = getNetModel();
        PixChooseTypeListResp.Item.Detail defaultDetail = item.getDefaultDetail();
        String str = "";
        if (!(defaultDetail == null || (defaultValue = defaultDetail.getDefaultValue()) == null)) {
            str = defaultValue;
        }
        netModel.checkCPF(1, str, new ChooseKeyTypeVM$checkCPF$1(this));
    }

    public final void migrateIn(int i, String str) {
        Intrinsics.checkNotNullParameter(str, "keyVal");
        getNetModel().reqPixKeyMigrateIn(i, str, new ChooseKeyTypeVM$migrateIn$1(this, i, str));
    }

    public final void pollPixKeyStatus(int i, String str) {
        Intrinsics.checkNotNullParameter(str, "keyVal");
        this.f30868g++;
        getNetModel().pollPixKeyStatus(i, str, 2, new ChooseKeyTypeVM$pollPixKeyStatus$1(this, i, str));
    }

    /* access modifiers changed from: protected */
    public void onCleared() {
        super.onCleared();
        this.f30867f.shutdown();
    }
}
