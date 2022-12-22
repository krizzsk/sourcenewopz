package com.didi.payment.kycservice.kyc.p133vm;

import android.app.Application;
import androidx.lifecycle.MutableLiveData;
import com.didi.payment.commonsdk.p129ui.WBaseViewModel;
import com.didi.payment.kycservice.net.PixNetModel;
import com.didi.payment.kycservice.net.response.AddressZipCodeResp;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u000e\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u000fR \u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\t¨\u0006\u0015"}, mo175978d2 = {"Lcom/didi/payment/kycservice/kyc/vm/SignUpAddressVM;", "Lcom/didi/payment/commonsdk/ui/WBaseViewModel;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "addressInfo", "Landroidx/lifecycle/MutableLiveData;", "Lcom/didi/payment/kycservice/net/response/AddressZipCodeResp$DataBean;", "getAddressInfo", "()Landroidx/lifecycle/MutableLiveData;", "setAddressInfo", "(Landroidx/lifecycle/MutableLiveData;)V", "model", "Lcom/didi/payment/kycservice/net/PixNetModel;", "showToastLD", "", "getShowToastLD", "loadData", "", "requestAddress", "zipCode", "kyc-service_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.payment.kycservice.kyc.vm.SignUpAddressVM */
/* compiled from: SignUpAddressVM.kt */
public final class SignUpAddressVM extends WBaseViewModel {

    /* renamed from: a */
    private final PixNetModel f30897a;

    /* renamed from: b */
    private MutableLiveData<AddressZipCodeResp.DataBean> f30898b = new MutableLiveData<>();

    /* renamed from: c */
    private final MutableLiveData<String> f30899c = new MutableLiveData<>();

    public void loadData() {
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SignUpAddressVM(Application application) {
        super(application);
        Intrinsics.checkNotNullParameter(application, "application");
        Application application2 = getApplication();
        Intrinsics.checkNotNullExpressionValue(application2, "getApplication()");
        this.f30897a = new PixNetModel(application2);
    }

    public final MutableLiveData<AddressZipCodeResp.DataBean> getAddressInfo() {
        return this.f30898b;
    }

    public final void setAddressInfo(MutableLiveData<AddressZipCodeResp.DataBean> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.f30898b = mutableLiveData;
    }

    public final MutableLiveData<String> getShowToastLD() {
        return this.f30899c;
    }

    public final void requestAddress(String str) {
        Intrinsics.checkNotNullParameter(str, "zipCode");
        this.f30897a.requestAddress(str, new SignUpAddressVM$requestAddress$1(this));
    }
}
