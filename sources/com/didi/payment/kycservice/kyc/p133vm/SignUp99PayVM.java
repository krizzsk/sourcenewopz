package com.didi.payment.kycservice.kyc.p133vm;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import androidx.lifecycle.MutableLiveData;
import com.datadog.android.log.LogAttributes;
import com.didi.commoninterfacelib.permission.PermissionUtil;
import com.didi.payment.base.event.WalletRefreshDataEvent;
import com.didi.payment.base.proxy.LocationProxyHolder;
import com.didi.payment.base.utils.PayBaseParamUtil;
import com.didi.payment.base.utils.WalletApolloUtil;
import com.didi.payment.commonsdk.p129ui.WBaseViewModel;
import com.didi.payment.kycservice.kyc.response.ResultPageData;
import com.didi.payment.kycservice.net.PixNetModel;
import com.didi.payment.kycservice.net.response.AddressZipCodeResp;
import com.didi.payment.kycservice.net.response.PixGetApplyInfoResp;
import com.didi.sdk.util.UiThreadHandler;
import com.yanzhenjie.permission.runtime.Permission;
import java.text.SimpleDateFormat;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.EventBus;

@Metadata(mo175977d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 B2\u00020\u0001:\u0001BB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u00101\u001a\u00020\rH\u0002J\u000e\u00102\u001a\u0002032\u0006\u00104\u001a\u00020)J\u0006\u00105\u001a\u000203J\u0006\u00106\u001a\u000203J\u0010\u00107\u001a\u0004\u0018\u00010\u00132\u0006\u00108\u001a\u000209J\b\u0010:\u001a\u000203H\u0016J\b\u0010;\u001a\u000203H\u0002J\u0006\u0010<\u001a\u000203J&\u0010=\u001a\u0002032\u0006\u0010>\u001a\u00020\u00132\u0006\u0010?\u001a\u00020\u00132\u0006\u0010@\u001a\u00020\u00132\u0006\u0010A\u001a\u00020\u0013R \u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\tR \u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\r0\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\t\"\u0004\b\u0011\u0010\u000bR \u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\t\"\u0004\b\u0015\u0010\u000bR \u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\t\"\u0004\b\u0019\u0010\u000bR \u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00130\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\t\"\u0004\b\u001c\u0010\u000bR\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u000e\u0010\"\u001a\u00020#X\u0004¢\u0006\u0002\n\u0000R\"\u0010$\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010%0\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\t\"\u0004\b'\u0010\u000bR\u001c\u0010(\u001a\u0004\u0018\u00010)X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R \u0010.\u001a\b\u0012\u0004\u0012\u00020\u00130\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\t\"\u0004\b0\u0010\u000b¨\u0006C"}, mo175978d2 = {"Lcom/didi/payment/kycservice/kyc/vm/SignUp99PayVM;", "Lcom/didi/payment/commonsdk/ui/WBaseViewModel;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "addressInfo", "Landroidx/lifecycle/MutableLiveData;", "Lcom/didi/payment/kycservice/net/response/AddressZipCodeResp$DataBean;", "getAddressInfo", "()Landroidx/lifecycle/MutableLiveData;", "setAddressInfo", "(Landroidx/lifecycle/MutableLiveData;)V", "bFinishCreateAccount", "", "getBFinishCreateAccount", "bShowHomelandCityErrorPage", "getBShowHomelandCityErrorPage", "setBShowHomelandCityErrorPage", "bizCode", "", "getBizCode", "setBizCode", "cpfinfo", "Lcom/didi/payment/kycservice/net/response/PixGetApplyInfoResp$CPFInfo;", "getCpfinfo", "setCpfinfo", "errorMsg", "getErrorMsg", "setErrorMsg", "externalId", "getExternalId", "()Ljava/lang/String;", "setExternalId", "(Ljava/lang/String;)V", "model", "Lcom/didi/payment/kycservice/net/PixNetModel;", "permissionData", "Lcom/didi/payment/kycservice/kyc/vm/PermissionData;", "getPermissionData", "setPermissionData", "resultPageData", "Lcom/didi/payment/kycservice/kyc/response/ResultPageData;", "getResultPageData", "()Lcom/didi/payment/kycservice/kyc/response/ResultPageData;", "setResultPageData", "(Lcom/didi/payment/kycservice/kyc/response/ResultPageData;)V", "sessionId", "getSessionId", "setSessionId", "checkLocationIfNeeded", "finishCreate", "", "resultData", "getFaceResult", "getFaceSession", "getShowTime", "date", "Ljava/util/Date;", "loadData", "loadKYCInfo", "requestLocationOnce", "submitKycInfoV1", "name", "birthDate", "cpf", "source", "Companion", "kyc-service_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.payment.kycservice.kyc.vm.SignUp99PayVM */
/* compiled from: SignUp99PayVM.kt */
public final class SignUp99PayVM extends WBaseViewModel {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int PAGE_TYPE_ADDRESS = 1;
    public static final int PAGE_TYPE_FULL_KYC = 2;
    public static final int PAGE_TYPE_KYC = 0;

    /* renamed from: a */
    private final PixNetModel f30886a;

    /* renamed from: b */
    private MutableLiveData<Boolean> f30887b = new MutableLiveData<>();

    /* renamed from: c */
    private MutableLiveData<PermissionData> f30888c = new MutableLiveData<>(null);

    /* renamed from: d */
    private MutableLiveData<PixGetApplyInfoResp.CPFInfo> f30889d = new MutableLiveData<>();

    /* renamed from: e */
    private MutableLiveData<AddressZipCodeResp.DataBean> f30890e = new MutableLiveData<>();

    /* renamed from: f */
    private final MutableLiveData<Boolean> f30891f = new MutableLiveData<>();

    /* renamed from: g */
    private ResultPageData f30892g;

    /* renamed from: h */
    private MutableLiveData<String> f30893h = new MutableLiveData<>();

    /* renamed from: i */
    private MutableLiveData<String> f30894i = new MutableLiveData<>();

    /* renamed from: j */
    private String f30895j;

    /* renamed from: k */
    private MutableLiveData<String> f30896k = new MutableLiveData<>();

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SignUp99PayVM(Application application) {
        super(application);
        Intrinsics.checkNotNullParameter(application, "application");
        Application application2 = getApplication();
        Intrinsics.checkNotNullExpressionValue(application2, "getApplication()");
        this.f30886a = new PixNetModel(application2);
        loadData();
    }

    @Metadata(mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, mo175978d2 = {"Lcom/didi/payment/kycservice/kyc/vm/SignUp99PayVM$Companion;", "", "()V", "PAGE_TYPE_ADDRESS", "", "PAGE_TYPE_FULL_KYC", "PAGE_TYPE_KYC", "kyc-service_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* renamed from: com.didi.payment.kycservice.kyc.vm.SignUp99PayVM$Companion */
    /* compiled from: SignUp99PayVM.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final MutableLiveData<Boolean> getBShowHomelandCityErrorPage() {
        return this.f30887b;
    }

    public final void setBShowHomelandCityErrorPage(MutableLiveData<Boolean> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.f30887b = mutableLiveData;
    }

    public final MutableLiveData<PermissionData> getPermissionData() {
        return this.f30888c;
    }

    public final void setPermissionData(MutableLiveData<PermissionData> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.f30888c = mutableLiveData;
    }

    public final MutableLiveData<PixGetApplyInfoResp.CPFInfo> getCpfinfo() {
        return this.f30889d;
    }

    public final void setCpfinfo(MutableLiveData<PixGetApplyInfoResp.CPFInfo> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.f30889d = mutableLiveData;
    }

    public final MutableLiveData<AddressZipCodeResp.DataBean> getAddressInfo() {
        return this.f30890e;
    }

    public final void setAddressInfo(MutableLiveData<AddressZipCodeResp.DataBean> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.f30890e = mutableLiveData;
    }

    public final MutableLiveData<Boolean> getBFinishCreateAccount() {
        return this.f30891f;
    }

    public final ResultPageData getResultPageData() {
        return this.f30892g;
    }

    public final void setResultPageData(ResultPageData resultPageData) {
        this.f30892g = resultPageData;
    }

    public final MutableLiveData<String> getErrorMsg() {
        return this.f30893h;
    }

    public final void setErrorMsg(MutableLiveData<String> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.f30893h = mutableLiveData;
    }

    public final MutableLiveData<String> getBizCode() {
        return this.f30894i;
    }

    public final void setBizCode(MutableLiveData<String> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.f30894i = mutableLiveData;
    }

    public final String getExternalId() {
        return this.f30895j;
    }

    public final void setExternalId(String str) {
        this.f30895j = str;
    }

    public final MutableLiveData<String> getSessionId() {
        return this.f30896k;
    }

    public final void setSessionId(MutableLiveData<String> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.f30896k = mutableLiveData;
    }

    public final String getShowTime(Date date) {
        Intrinsics.checkNotNullParameter(date, LogAttributes.DATE);
        return new SimpleDateFormat("dd/MM/yyyy").format(date);
    }

    /* renamed from: a */
    private final void m21736a() {
        this.f30886a.getApplyInfo(new SignUp99PayVM$loadKYCInfo$1(this));
    }

    public void loadData() {
        if (!m21738b()) {
            m21736a();
        }
    }

    /* renamed from: b */
    private final boolean m21738b() {
        if (!WalletApolloUtil.getStatus("ibt_wallet_account_loc_intercept_toggle")) {
            return false;
        }
        Application application = getApplication();
        Intrinsics.checkNotNullExpressionValue(application, "getApplication()");
        boolean access$isLocServiceEnable = SignUp99PayVMKt.m21739a(application);
        boolean checkPermissionAllGranted = PermissionUtil.checkPermissionAllGranted((Context) getApplication(), Permission.ACCESS_FINE_LOCATION);
        if (!access$isLocServiceEnable || !checkPermissionAllGranted) {
            this.f30888c.setValue(new PermissionData(access$isLocServiceEnable, checkPermissionAllGranted, true));
            return true;
        }
        Object obj = PayBaseParamUtil.getHttpBaseParams(getApplication()).get("city_id");
        if (obj != null) {
            String obj2 = obj.toString();
            if (!TextUtils.isEmpty(obj2) && !Intrinsics.areEqual((Object) "-1", (Object) obj2) && !Intrinsics.areEqual((Object) "0", (Object) obj2)) {
                return false;
            }
        }
        this.f30888c.setValue(new PermissionData(access$isLocServiceEnable, checkPermissionAllGranted, false));
        return true;
    }

    public final void requestLocationOnce() {
        isLoading().setValue(true);
        if (LocationProxyHolder.getProxy() != null) {
            LocationProxyHolder.getProxy().requestLocationAndCityId();
        }
        UiThreadHandler.postOnceDelayed(new Runnable() {
            public final void run() {
                SignUp99PayVM.m21737a(SignUp99PayVM.this);
            }
        }, 3000);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m21737a(SignUp99PayVM signUp99PayVM) {
        Intrinsics.checkNotNullParameter(signUp99PayVM, "this$0");
        signUp99PayVM.isLoading().setValue(false);
        if (!signUp99PayVM.m21738b()) {
            signUp99PayVM.getPermissionData().setValue(null);
            signUp99PayVM.m21736a();
        }
    }

    public final void submitKycInfoV1(String str, String str2, String str3, String str4) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(str2, "birthDate");
        Intrinsics.checkNotNullParameter(str3, "cpf");
        Intrinsics.checkNotNullParameter(str4, "source");
        this.f30886a.submitKycInfoV1(str, str2, str3, str4, new SignUp99PayVM$submitKycInfoV1$1(this));
    }

    public final void getFaceSession() {
        String str = this.f30895j;
        if (str != null) {
            PixNetModel pixNetModel = this.f30886a;
            String value = getBizCode().getValue();
            if (value != null) {
                pixNetModel.getFaceSession(value, str, new SignUp99PayVM$getFaceSession$1$1(this));
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        }
    }

    public final void getFaceResult() {
        String str = this.f30895j;
        if (str != null) {
            this.f30886a.getFaceResult(String.valueOf(getSessionId().getValue()), str, new SignUp99PayVM$getFaceResult$1$1(this));
        }
    }

    public final void finishCreate(ResultPageData resultPageData) {
        Intrinsics.checkNotNullParameter(resultPageData, "resultData");
        EventBus.getDefault().post(new WalletRefreshDataEvent());
        this.f30892g = resultPageData;
        this.f30891f.setValue(true);
    }
}
