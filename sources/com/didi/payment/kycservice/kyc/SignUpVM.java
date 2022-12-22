package com.didi.payment.kycservice.kyc;

import android.app.Application;
import android.util.SparseArray;
import androidx.lifecycle.MutableLiveData;
import com.didi.payment.base.utils.WalletCommonParamsUtil;
import com.didi.payment.commonsdk.p129ui.WBaseViewModel;
import com.didi.payment.kycservice.guide.rule.GuidsRuleManager;
import com.didi.payment.kycservice.guide.rule.IKycGuidesRule;
import com.didi.payment.kycservice.kyc.response.GuidesInfoResp;
import com.didi.payment.kycservice.kyc.response.ResultPageData;
import com.didi.payment.kycservice.net.PixNetModel;
import com.didi.payment.kycservice.utils.KycStore;
import com.didi.sdk.apm.SystemUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010H\u001a\u00020IH\u0016J\u0010\u0010J\u001a\u00020I2\b\u0010K\u001a\u0004\u0018\u00010/J\b\u0010L\u001a\u00020IH\u0002J\u0006\u0010M\u001a\u00020;R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0014\"\u0004\b \u0010\u0016R\u001a\u0010!\u001a\u00020\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0014\"\u0004\b#\u0010\u0016R\u000e\u0010$\u001a\u00020%X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010&\u001a\b\u0012\u0004\u0012\u00020(0'¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u001a\u0010+\u001a\u00020\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0014\"\u0004\b-\u0010\u0016R\u001c\u0010.\u001a\u0004\u0018\u00010/X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u001c\u00104\u001a\u0004\u0018\u000105X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u001a\u0010:\u001a\u00020;X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R0\u0010@\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020B0Aj\b\u0012\u0004\u0012\u00020B`C0'X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010*\"\u0004\bE\u0010FR\u000e\u0010G\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000¨\u0006N"}, mo175978d2 = {"Lcom/didi/payment/kycservice/kyc/SignUpVM;", "Lcom/didi/payment/commonsdk/ui/WBaseViewModel;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "exitDetail", "Lcom/didi/payment/kycservice/kyc/response/GuidesInfoResp$ExitDetail;", "getExitDetail", "()Lcom/didi/payment/kycservice/kyc/response/GuidesInfoResp$ExitDetail;", "setExitDetail", "(Lcom/didi/payment/kycservice/kyc/response/GuidesInfoResp$ExitDetail;)V", "fromPrimary", "", "getFromPrimary", "()I", "setFromPrimary", "(I)V", "idTitlePrefix", "", "getIdTitlePrefix", "()Ljava/lang/String;", "setIdTitlePrefix", "(Ljava/lang/String;)V", "incomeDetailList", "Ljava/util/LinkedList;", "Lcom/didi/payment/kycservice/kyc/response/GuidesInfoResp$Income;", "getIncomeDetailList", "()Ljava/util/LinkedList;", "setIncomeDetailList", "(Ljava/util/LinkedList;)V", "keyTitlePrefix", "getKeyTitlePrefix", "setKeyTitlePrefix", "kycTitlePrefix", "getKycTitlePrefix", "setKycTitlePrefix", "netModel", "Lcom/didi/payment/kycservice/net/PixNetModel;", "pageSceneLD", "Landroidx/lifecycle/MutableLiveData;", "Lcom/didi/payment/kycservice/kyc/SignUpPageScene;", "getPageSceneLD", "()Landroidx/lifecycle/MutableLiveData;", "pageSource", "getPageSource", "setPageSource", "pixSignUpInfoData", "Lcom/didi/payment/kycservice/kyc/response/GuidesInfoResp$Data;", "getPixSignUpInfoData", "()Lcom/didi/payment/kycservice/kyc/response/GuidesInfoResp$Data;", "setPixSignUpInfoData", "(Lcom/didi/payment/kycservice/kyc/response/GuidesInfoResp$Data;)V", "resultPageData", "Lcom/didi/payment/kycservice/kyc/response/ResultPageData;", "getResultPageData", "()Lcom/didi/payment/kycservice/kyc/response/ResultPageData;", "setResultPageData", "(Lcom/didi/payment/kycservice/kyc/response/ResultPageData;)V", "srcFromResultPage", "", "getSrcFromResultPage", "()Z", "setSrcFromResultPage", "(Z)V", "stepListData", "Ljava/util/ArrayList;", "Lcom/didi/payment/kycservice/kyc/response/GuidesInfoResp$StepInfo;", "Lkotlin/collections/ArrayList;", "getStepListData", "setStepListData", "(Landroidx/lifecycle/MutableLiveData;)V", "stepSize", "loadData", "", "saveStatus", "response", "switchPage", "updatePageSceneByStepList", "kyc-service_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: SignUpVM.kt */
public final class SignUpVM extends WBaseViewModel {

    /* renamed from: a */
    private final PixNetModel f30738a;

    /* renamed from: b */
    private final MutableLiveData<SignUpPageScene> f30739b = new MutableLiveData<>();

    /* renamed from: c */
    private MutableLiveData<ArrayList<GuidesInfoResp.StepInfo>> f30740c = new MutableLiveData<>();

    /* renamed from: d */
    private GuidesInfoResp.Data f30741d;

    /* renamed from: e */
    private ResultPageData f30742e;

    /* renamed from: f */
    private String f30743f = "";

    /* renamed from: g */
    private String f30744g = "";

    /* renamed from: h */
    private String f30745h = "";

    /* renamed from: i */
    private boolean f30746i;

    /* renamed from: j */
    private LinkedList<GuidesInfoResp.Income> f30747j;

    /* renamed from: k */
    private int f30748k;

    /* renamed from: l */
    private String f30749l = "2";

    /* renamed from: m */
    private int f30750m;

    /* renamed from: n */
    private GuidesInfoResp.ExitDetail f30751n;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SignUpVM(Application application) {
        super(application);
        Intrinsics.checkNotNullParameter(application, "application");
        Application application2 = getApplication();
        Intrinsics.checkNotNullExpressionValue(application2, "getApplication()");
        this.f30738a = new PixNetModel(application2);
    }

    public final MutableLiveData<SignUpPageScene> getPageSceneLD() {
        return this.f30739b;
    }

    public final MutableLiveData<ArrayList<GuidesInfoResp.StepInfo>> getStepListData() {
        return this.f30740c;
    }

    public final void setStepListData(MutableLiveData<ArrayList<GuidesInfoResp.StepInfo>> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.f30740c = mutableLiveData;
    }

    public final GuidesInfoResp.Data getPixSignUpInfoData() {
        return this.f30741d;
    }

    public final void setPixSignUpInfoData(GuidesInfoResp.Data data) {
        this.f30741d = data;
    }

    public final ResultPageData getResultPageData() {
        return this.f30742e;
    }

    public final void setResultPageData(ResultPageData resultPageData) {
        this.f30742e = resultPageData;
    }

    public final String getKycTitlePrefix() {
        return this.f30743f;
    }

    public final void setKycTitlePrefix(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.f30743f = str;
    }

    public final String getIdTitlePrefix() {
        return this.f30744g;
    }

    public final void setIdTitlePrefix(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.f30744g = str;
    }

    public final String getKeyTitlePrefix() {
        return this.f30745h;
    }

    public final void setKeyTitlePrefix(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.f30745h = str;
    }

    public final boolean getSrcFromResultPage() {
        return this.f30746i;
    }

    public final void setSrcFromResultPage(boolean z) {
        this.f30746i = z;
    }

    public final LinkedList<GuidesInfoResp.Income> getIncomeDetailList() {
        return this.f30747j;
    }

    public final void setIncomeDetailList(LinkedList<GuidesInfoResp.Income> linkedList) {
        this.f30747j = linkedList;
    }

    public final String getPageSource() {
        return this.f30749l;
    }

    public final void setPageSource(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.f30749l = str;
    }

    public final int getFromPrimary() {
        return this.f30750m;
    }

    public final void setFromPrimary(int i) {
        this.f30750m = i;
    }

    public final GuidesInfoResp.ExitDetail getExitDetail() {
        return this.f30751n;
    }

    public final void setExitDetail(GuidesInfoResp.ExitDetail exitDetail) {
        this.f30751n = exitDetail;
    }

    public void loadData() {
        this.f30748k = 0;
        this.f30738a.getGuidesInfo(new SignUpVM$loadData$1(this), this.f30749l);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m21612a() {
        SparseArray<IKycGuidesRule> guidesRules = GuidsRuleManager.Companion.getGuidesRules();
        IKycGuidesRule iKycGuidesRule = guidesRules == null ? null : guidesRules.get(Integer.parseInt(this.f30749l));
        boolean z = false;
        if (iKycGuidesRule != null && iKycGuidesRule.showGuideRule()) {
            z = true;
        }
        if (z) {
            this.f30739b.setValue(SignUpPageScene.GUIDE);
        } else if (this.f30742e == null || this.f30746i) {
            updatePageSceneByStepList();
        } else {
            this.f30739b.setValue(SignUpPageScene.RESULT);
        }
    }

    public final boolean updatePageSceneByStepList() {
        ArrayList<GuidesInfoResp.StepInfo> stepList;
        ArrayList<GuidesInfoResp.StepInfo> stepList2;
        GuidesInfoResp.Data data = this.f30741d;
        if ((data == null ? null : data.getStepList()) != null) {
            GuidesInfoResp.Data data2 = this.f30741d;
            if (!((data2 == null || (stepList2 = data2.getStepList()) == null || stepList2.size() != 0) ? false : true)) {
                GuidesInfoResp.Data data3 = this.f30741d;
                if (data3 == null || (stepList = data3.getStepList()) == null) {
                    return true;
                }
                this.f30748k++;
                Iterator<GuidesInfoResp.StepInfo> it = stepList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    GuidesInfoResp.StepInfo next = it.next();
                    if (next.getStatus() == 1) {
                        int stepType = next.getStepType();
                        if (stepType == 1) {
                            next.setStatus(2);
                        } else if (stepType == 2) {
                            next.setStatus(2);
                        } else if (stepType == 3) {
                            next.setStatus(2);
                        } else if (stepType == 4) {
                            next.setStatus(2);
                        } else if (stepType == 5) {
                            next.setStatus(2);
                        }
                    }
                    if (next.getStatus() == 0) {
                        int stepType2 = next.getStepType();
                        if (stepType2 == 1) {
                            next.setStatus(1);
                            getPageSceneLD().setValue(SignUpPageScene.SIGN_UP_99PAY);
                        } else if (stepType2 == 2) {
                            next.setStatus(1);
                            getPageSceneLD().setValue(SignUpPageScene.FULL_KYC_EXTRA);
                        } else if (stepType2 == 3) {
                            next.setStatus(1);
                            getPageSceneLD().setValue(SignUpPageScene.CHOOSE_ID_TYPE);
                        } else if (stepType2 == 4) {
                            next.setStatus(1);
                            getPageSceneLD().setValue(SignUpPageScene.CHOOSE_KEY_TYPE);
                        } else if (stepType2 == 5) {
                            next.setStatus(1);
                            getPageSceneLD().setValue(SignUpPageScene.CHOOSE_ID_TYPE_JUMIO);
                        }
                    }
                }
                SystemUtils.log(3, "kyc_test", "FinishStepSize= " + this.f30748k + "  ;ResultStepSize= " + stepList.size(), (Throwable) null, "com.didi.payment.kycservice.kyc.SignUpVM", 159);
                getStepListData().setValue(stepList);
                if (this.f30748k > stepList.size()) {
                    return true;
                }
                return false;
            }
        }
        this.f30739b.setValue(SignUpPageScene.FULL_KYC_FINISH);
        return true;
    }

    public final void saveStatus(GuidesInfoResp.Data data) {
        if (data != null) {
            KycStore.INSTANCE.setPrimaryKycStatus(data.getKycStatus());
            KycStore.INSTANCE.setFullKycStatus(data.getFullKycStatus());
            KycStore.INSTANCE.setFaceStatus(data.getFaceStatus());
            if (data.getPixStatus() != null) {
                KycStore.INSTANCE.setPixStatus(data.getPixStatus());
            }
            KycStore.INSTANCE.setLatourKycStatus(data.getLatourKycStatus());
            if (WalletCommonParamsUtil.is99PayClient() && data.getLatourKycStatus() == 1 && !Intrinsics.areEqual((Object) this.f30749l, (Object) "4") && !Intrinsics.areEqual((Object) this.f30749l, (Object) "6")) {
                this.f30739b.setValue(SignUpPageScene.FULL_KYC_FINISH);
            }
        }
    }
}
