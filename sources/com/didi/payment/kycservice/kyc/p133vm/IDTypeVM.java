package com.didi.payment.kycservice.kyc.p133vm;

import android.app.Application;
import androidx.lifecycle.MutableLiveData;
import com.didi.payment.commonsdk.p129ui.WBaseViewModel;
import com.didi.payment.kycservice.kyc.response.ResultPageData;
import com.didi.payment.kycservice.net.PixNetModel;
import com.didi.payment.kycservice.net.response.JumioCreateResultResp;
import com.didi.payment.kycservice.net.response.JumioGuideResp;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001!B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bJ\u0016\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0006J\b\u0010 \u001a\u00020\u0019H\u0016R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR \u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R \u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000f\"\u0004\b\u0015\u0010\u0011R\u000e\u0010\u0016\u001a\u00020\u0017X\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, mo175978d2 = {"Lcom/didi/payment/kycservice/kyc/vm/IDTypeVM;", "Lcom/didi/payment/commonsdk/ui/WBaseViewModel;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "count", "", "getCount", "()I", "setCount", "(I)V", "jumioCreateData", "Landroidx/lifecycle/MutableLiveData;", "Lcom/didi/payment/kycservice/net/response/JumioCreateResultResp$Data;", "getJumioCreateData", "()Landroidx/lifecycle/MutableLiveData;", "setJumioCreateData", "(Landroidx/lifecycle/MutableLiveData;)V", "jumioGuideData", "Lcom/didi/payment/kycservice/net/response/JumioGuideResp$Data;", "getJumioGuideData", "setJumioGuideData", "netModel", "Lcom/didi/payment/kycservice/net/PixNetModel;", "checkJumio", "", "listener", "Lcom/didi/payment/kycservice/kyc/vm/IDTypeVM$CheckListener;", "createToken", "guidanceSource", "", "fromPrimary", "loadData", "CheckListener", "kyc-service_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.payment.kycservice.kyc.vm.IDTypeVM */
/* compiled from: IDTypeVM.kt */
public final class IDTypeVM extends WBaseViewModel {

    /* renamed from: a */
    private final PixNetModel f30879a;

    /* renamed from: b */
    private MutableLiveData<JumioCreateResultResp.Data> f30880b = new MutableLiveData<>();

    /* renamed from: c */
    private MutableLiveData<JumioGuideResp.Data> f30881c = new MutableLiveData<>();

    /* renamed from: d */
    private int f30882d = 1;

    @Metadata(mo175977d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u0006"}, mo175978d2 = {"Lcom/didi/payment/kycservice/kyc/vm/IDTypeVM$CheckListener;", "", "onSuccess", "", "resultEntryFormat", "Lcom/didi/payment/kycservice/kyc/response/ResultPageData;", "kyc-service_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* renamed from: com.didi.payment.kycservice.kyc.vm.IDTypeVM$CheckListener */
    /* compiled from: IDTypeVM.kt */
    public interface CheckListener {
        void onSuccess(ResultPageData resultPageData);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public IDTypeVM(Application application) {
        super(application);
        Intrinsics.checkNotNullParameter(application, "application");
        Application application2 = getApplication();
        Intrinsics.checkNotNullExpressionValue(application2, "getApplication()");
        this.f30879a = new PixNetModel(application2);
    }

    public final MutableLiveData<JumioCreateResultResp.Data> getJumioCreateData() {
        return this.f30880b;
    }

    public final void setJumioCreateData(MutableLiveData<JumioCreateResultResp.Data> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.f30880b = mutableLiveData;
    }

    public final MutableLiveData<JumioGuideResp.Data> getJumioGuideData() {
        return this.f30881c;
    }

    public final void setJumioGuideData(MutableLiveData<JumioGuideResp.Data> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.f30881c = mutableLiveData;
    }

    public void loadData() {
        this.f30879a.getJumioGuide(new IDTypeVM$loadData$1$1(this));
    }

    public final void createToken(String str, int i) {
        Intrinsics.checkNotNullParameter(str, "guidanceSource");
        this.f30879a.createJumio(str, i, new IDTypeVM$createToken$1(this));
    }

    public final int getCount() {
        return this.f30882d;
    }

    public final void setCount(int i) {
        this.f30882d = i;
    }

    public final void checkJumio(CheckListener checkListener) {
        PixNetModel pixNetModel = this.f30879a;
        int i = this.f30882d;
        JumioCreateResultResp.Data value = this.f30880b.getValue();
        String workflowId = value == null ? null : value.getWorkflowId();
        if (workflowId != null) {
            pixNetModel.checkJumio(i, workflowId, new IDTypeVM$checkJumio$1(this, checkListener));
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    }
}
