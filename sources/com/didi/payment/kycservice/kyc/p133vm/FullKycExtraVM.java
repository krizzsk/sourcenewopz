package com.didi.payment.kycservice.kyc.p133vm;

import android.app.Application;
import androidx.lifecycle.MutableLiveData;
import com.didi.payment.commonsdk.p129ui.WBaseViewModel;
import com.didi.payment.kycservice.kyc.fragment.FullKycExtraFragment;
import com.didi.payment.kycservice.net.PixNetModel;
import com.didi.payment.kycservice.net.response.AddressZipCodeResp;
import com.didi.payment.kycservice.net.response.PixGetApplyInfoResp;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u001cH\u0002J\u000e\u0010\u001e\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\u0017JN\u0010 \u001a\u00020\u001c2\u0006\u0010!\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020\u00172\u0006\u0010\"\u001a\u00020\u00172\u0006\u0010#\u001a\u00020\u00172\u0006\u0010$\u001a\u00020\u00172\u0006\u0010%\u001a\u00020\u00172\u0006\u0010&\u001a\u00020\u00172\u0006\u0010'\u001a\u00020\u00172\u0006\u0010(\u001a\u00020\u0017JF\u0010)\u001a\u00020\u001c2\u0006\u0010!\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020\u00172\u0006\u0010\"\u001a\u00020\u00172\u0006\u0010#\u001a\u00020\u00172\u0006\u0010$\u001a\u00020\u00172\u0006\u0010%\u001a\u00020\u00172\u0006\u0010&\u001a\u00020\u00172\u0006\u0010'\u001a\u00020\u0017R \u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\tR \u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\r0\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\t\"\u0004\b\u0011\u0010\u000bR \u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\t\"\u0004\b\u0015\u0010\u000bR\u0017\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\tR\u000e\u0010\u0019\u001a\u00020\u001aX\u0004¢\u0006\u0002\n\u0000¨\u0006*"}, mo175978d2 = {"Lcom/didi/payment/kycservice/kyc/vm/FullKycExtraVM;", "Lcom/didi/payment/commonsdk/ui/WBaseViewModel;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "addressInfo", "Landroidx/lifecycle/MutableLiveData;", "Lcom/didi/payment/kycservice/net/response/AddressZipCodeResp$DataBean;", "getAddressInfo", "()Landroidx/lifecycle/MutableLiveData;", "setAddressInfo", "(Landroidx/lifecycle/MutableLiveData;)V", "bFinishCreateAccount", "", "getBFinishCreateAccount", "bShowHomelandCityErrorPage", "getBShowHomelandCityErrorPage", "setBShowHomelandCityErrorPage", "cpfinfo", "Lcom/didi/payment/kycservice/net/response/PixGetApplyInfoResp$CPFInfo;", "getCpfinfo", "setCpfinfo", "errorMsg", "", "getErrorMsg", "model", "Lcom/didi/payment/kycservice/net/PixNetModel;", "loadData", "", "loadExtraInfo", "requestAddress", "zipCode", "submitAddressVerification", "incomeType", "street", "number", "more", "district", "state", "city", "blockId", "submitKycAddressInfo", "kyc-service_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.payment.kycservice.kyc.vm.FullKycExtraVM */
/* compiled from: FullKycExtraVM.kt */
public final class FullKycExtraVM extends WBaseViewModel {

    /* renamed from: a */
    private final PixNetModel f30873a;

    /* renamed from: b */
    private MutableLiveData<AddressZipCodeResp.DataBean> f30874b = new MutableLiveData<>();

    /* renamed from: c */
    private MutableLiveData<Boolean> f30875c = new MutableLiveData<>();

    /* renamed from: d */
    private MutableLiveData<PixGetApplyInfoResp.CPFInfo> f30876d = new MutableLiveData<>();

    /* renamed from: e */
    private final MutableLiveData<Boolean> f30877e = new MutableLiveData<>();

    /* renamed from: f */
    private final MutableLiveData<String> f30878f = new MutableLiveData<>();

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FullKycExtraVM(Application application) {
        super(application);
        Intrinsics.checkNotNullParameter(application, "application");
        Application application2 = getApplication();
        Intrinsics.checkNotNullExpressionValue(application2, "getApplication()");
        this.f30873a = new PixNetModel(application2);
        loadData();
    }

    public final MutableLiveData<AddressZipCodeResp.DataBean> getAddressInfo() {
        return this.f30874b;
    }

    public final void setAddressInfo(MutableLiveData<AddressZipCodeResp.DataBean> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.f30874b = mutableLiveData;
    }

    public final MutableLiveData<Boolean> getBShowHomelandCityErrorPage() {
        return this.f30875c;
    }

    public final void setBShowHomelandCityErrorPage(MutableLiveData<Boolean> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.f30875c = mutableLiveData;
    }

    public final MutableLiveData<PixGetApplyInfoResp.CPFInfo> getCpfinfo() {
        return this.f30876d;
    }

    public final void setCpfinfo(MutableLiveData<PixGetApplyInfoResp.CPFInfo> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.f30876d = mutableLiveData;
    }

    public final MutableLiveData<Boolean> getBFinishCreateAccount() {
        return this.f30877e;
    }

    public final MutableLiveData<String> getErrorMsg() {
        return this.f30878f;
    }

    public void loadData() {
        m21735a();
    }

    /* renamed from: a */
    private final void m21735a() {
        this.f30873a.getApplyInfo(new FullKycExtraVM$loadExtraInfo$1(this));
    }

    public final void requestAddress(String str) {
        Intrinsics.checkNotNullParameter(str, "zipCode");
        this.f30873a.requestAddress(str, new FullKycExtraVM$requestAddress$1(this));
    }

    public final void submitKycAddressInfo(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        Intrinsics.checkNotNullParameter(str, "incomeType");
        Intrinsics.checkNotNullParameter(str2, "zipCode");
        Intrinsics.checkNotNullParameter(str3, "street");
        String str9 = str4;
        Intrinsics.checkNotNullParameter(str9, "number");
        String str10 = str5;
        Intrinsics.checkNotNullParameter(str10, "more");
        String str11 = str6;
        Intrinsics.checkNotNullParameter(str11, ParamKeys.PARAM_DISTRICT);
        String str12 = str7;
        Intrinsics.checkNotNullParameter(str12, "state");
        String str13 = str8;
        Intrinsics.checkNotNullParameter(str13, "city");
        this.f30873a.submitKycAddressInfo(str, str2, str3, str9, str10, str11, str12, str13, new FullKycExtraVM$submitKycAddressInfo$1(this));
    }

    public final void submitAddressVerification(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        Intrinsics.checkNotNullParameter(str, "incomeType");
        Intrinsics.checkNotNullParameter(str2, "zipCode");
        String str10 = str3;
        Intrinsics.checkNotNullParameter(str10, "street");
        String str11 = str4;
        Intrinsics.checkNotNullParameter(str11, "number");
        String str12 = str5;
        Intrinsics.checkNotNullParameter(str12, "more");
        String str13 = str6;
        Intrinsics.checkNotNullParameter(str13, ParamKeys.PARAM_DISTRICT);
        String str14 = str7;
        Intrinsics.checkNotNullParameter(str14, "state");
        String str15 = str8;
        Intrinsics.checkNotNullParameter(str15, "city");
        String str16 = str9;
        Intrinsics.checkNotNullParameter(str16, FullKycExtraFragment.BLOCK_ID);
        this.f30873a.submitAddressVerification(str, str2, str10, str11, str12, str13, str14, str15, str16, new FullKycExtraVM$submitAddressVerification$1(this));
    }
}
