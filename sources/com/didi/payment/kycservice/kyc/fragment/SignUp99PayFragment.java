package com.didi.payment.kycservice.kyc.fragment;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.bigkoo.pickerview.builder.TimePickerBuilder;
import com.bigkoo.pickerview.listener.CustomListener;
import com.bigkoo.pickerview.listener.OnTimeSelectListener;
import com.bigkoo.pickerview.view.TimePickerView;
import com.datadog.android.log.LogAttributes;
import com.didi.commoninterfacelib.permission.PermissionCallback;
import com.didi.commoninterfacelib.permission.PermissionContext;
import com.didi.commoninterfacelib.permission.PermissionUtil;
import com.didi.global.globaluikit.drawer.LEGODrawer;
import com.didi.payment.base.utils.PayBaseParamUtil;
import com.didi.payment.base.utils.TextHighlightUtil;
import com.didi.payment.base.view.PayHomelandCityErrorView;
import com.didi.payment.base.web.WebBrowserUtil;
import com.didi.payment.commonsdk.p129ui.WBaseFragment;
import com.didi.payment.commonsdk.p129ui.WBaseViewModel;
import com.didi.payment.commonsdk.utils.KycOmega;
import com.didi.payment.commonsdk.utils.NWRouter;
import com.didi.payment.commonsdk.utils.OmegaComParams;
import com.didi.payment.kycservice.kyc.SignUpVM;
import com.didi.payment.kycservice.kyc.p133vm.PermissionData;
import com.didi.payment.kycservice.kyc.p133vm.SignUp99PayVM;
import com.didi.payment.kycservice.net.response.PixGetApplyInfoResp;
import com.didi.payment.kycservice.utils.CPFInputWatcher;
import com.didi.payment.kycservice.utils.KycRegisterUtils;
import com.didi.payment.kycservice.utils.KycSPUtils;
import com.didi.payment.kycservice.widget.NewPixInputView;
import com.didichuxing.diface.DiFace;
import com.didichuxing.diface.DiFaceParam;
import com.didichuxing.diface.DiFaceResult;
import com.taxis99.R;
import com.yanzhenjie.permission.runtime.Permission;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

@Metadata(mo175977d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 U2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001UB\u0005¢\u0006\u0002\u0010\u0003J\b\u0010(\u001a\u00020)H\u0002J\b\u0010*\u001a\u00020+H\u0002J\u0018\u0010,\u001a\u00020+2\u0006\u0010-\u001a\u00020'2\u0006\u0010.\u001a\u00020'H\u0002J\u0010\u0010/\u001a\u00020+2\u0006\u00100\u001a\u00020'H\u0002J\b\u00101\u001a\u00020+H\u0002J\n\u00102\u001a\u0004\u0018\u00010\u0011H\u0014J\b\u00103\u001a\u00020'H\u0002J\b\u00104\u001a\u00020+H\u0002J\b\u00105\u001a\u00020+H\u0002J\b\u00106\u001a\u00020+H\u0002J\b\u00107\u001a\u00020+H\u0002J\b\u00108\u001a\u00020+H\u0002J\u0010\u00109\u001a\u00020+2\u0006\u0010:\u001a\u00020\u0011H\u0002J\b\u0010;\u001a\u00020)H\u0002J\b\u0010<\u001a\u00020)H\u0002J\b\u0010=\u001a\u00020)H\u0002J\u0012\u0010>\u001a\u00020+2\b\u0010?\u001a\u0004\u0018\u00010@H\u0016J&\u0010A\u001a\u0004\u0018\u00010\u00112\u0006\u0010B\u001a\u00020C2\b\u0010D\u001a\u0004\u0018\u00010\u000e2\b\u0010?\u001a\u0004\u0018\u00010@H\u0016J\b\u0010E\u001a\u00020+H\u0016J\u001a\u0010F\u001a\u00020+2\u0006\u0010G\u001a\u00020\u00112\b\u0010?\u001a\u0004\u0018\u00010@H\u0016J\u0012\u0010H\u001a\u0004\u0018\u00010\u001b2\u0006\u0010I\u001a\u00020'H\u0002J\b\u0010J\u001a\u00020+H\u0002J\u0010\u0010K\u001a\u00020+2\u0006\u0010L\u001a\u00020\nH\u0002J\u0010\u0010M\u001a\u00020+2\u0006\u0010N\u001a\u00020OH\u0002J\u0006\u0010P\u001a\u00020+J\b\u0010Q\u001a\u00020+H\u0002J\u0010\u0010R\u001a\u00020+2\u0006\u0010S\u001a\u00020\u0002H\u0016J\b\u0010T\u001a\u00020+H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X.¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X.¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X.¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0005X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\fX.¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0005X.¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0005X.¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX.¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0005X.¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0005X.¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X.¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020'X\u000e¢\u0006\u0002\n\u0000¨\u0006V"}, mo175978d2 = {"Lcom/didi/payment/kycservice/kyc/fragment/SignUp99PayFragment;", "Lcom/didi/payment/commonsdk/ui/WBaseFragment;", "Lcom/didi/payment/kycservice/kyc/vm/SignUp99PayVM;", "()V", "mActivityTv", "Landroid/widget/TextView;", "mAgeErrorTv", "mBackDialog", "Lcom/didi/global/globaluikit/drawer/LEGODrawer;", "mCPFInfo", "Lcom/didi/payment/kycservice/net/response/PixGetApplyInfoResp$CPFInfo;", "mCPFInput", "Lcom/didi/payment/kycservice/widget/NewPixInputView;", "mContentView", "Landroid/view/ViewGroup;", "mDateTv", "mErrorContentView", "Landroid/view/View;", "mErrorViewStub", "Landroid/view/ViewStub;", "mFaceGuideView", "mFacesVerify", "mMainTitleTv", "mNameInput", "mPageType", "", "mSelectDate", "Ljava/util/Date;", "mSubTitleTv", "mSubmitBtn", "mTermCb", "Landroid/widget/CheckBox;", "mTermTv", "mTimePickerView", "Lcom/bigkoo/pickerview/view/TimePickerView;", "mTvAgeTitle", "pixSignUpVM", "Lcom/didi/payment/kycservice/kyc/SignUpVM;", "titlePrefix", "", "checkInputInfo", "", "closeKeyboard", "", "doFaceCreate", "bizCode", "sessionId", "fillCPFInput", "taxId", "fillInfoFromSP", "getTitleBarView", "getUpLoadTime", "gotoTermPage", "hideErrorPage", "initListener", "initTermView", "initTimePicker", "initView", "rootView", "isValidAge", "isValidCPF", "isValidName", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "onDestroyView", "onViewCreated", "view", "parseDateString", "text", "requestLocationPermission", "showData", "data", "showErrorPage", "locationResultData", "Lcom/didi/payment/kycservice/kyc/vm/PermissionData;", "showHomelandCityErrorPage", "submitKycInfoV1", "subscribeUi", "viewModel", "updateSubmitBtn", "Companion", "kyc-service_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: SignUp99PayFragment.kt */
public final class SignUp99PayFragment extends WBaseFragment<SignUp99PayVM> {

    /* renamed from: A */
    private static final int f30807A = 18;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: x */
    private static final int f30808x = 14;

    /* renamed from: y */
    private static final String f30809y = "param_title_prefix";

    /* renamed from: z */
    private static final String f30810z = "param_page_type";

    /* renamed from: a */
    private ViewGroup f30811a;

    /* renamed from: b */
    private TextView f30812b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public NewPixInputView f30813c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public NewPixInputView f30814d;

    /* renamed from: e */
    private TextView f30815e;

    /* renamed from: f */
    private TextView f30816f;

    /* renamed from: g */
    private TextView f30817g;

    /* renamed from: h */
    private TextView f30818h;

    /* renamed from: i */
    private TextView f30819i;

    /* renamed from: j */
    private TextView f30820j;

    /* renamed from: k */
    private CheckBox f30821k;

    /* renamed from: l */
    private ViewStub f30822l;

    /* renamed from: m */
    private View f30823m;

    /* renamed from: n */
    private View f30824n;

    /* renamed from: o */
    private View f30825o;

    /* renamed from: p */
    private TextView f30826p;

    /* renamed from: q */
    private TimePickerView f30827q;

    /* renamed from: r */
    private LEGODrawer f30828r;

    /* renamed from: s */
    private Date f30829s;

    /* renamed from: t */
    private PixGetApplyInfoResp.CPFInfo f30830t;

    /* renamed from: u */
    private String f30831u = "";

    /* renamed from: v */
    private int f30832v;

    /* renamed from: w */
    private SignUpVM f30833w;

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m21695a(Date date) {
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static final void m21698b(View view) {
    }

    /* access modifiers changed from: protected */
    public View getTitleBarView() {
        return null;
    }

    @Metadata(mo175977d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000¨\u0006\r"}, mo175978d2 = {"Lcom/didi/payment/kycservice/kyc/fragment/SignUp99PayFragment$Companion;", "", "()V", "CPF_LENGTH", "", "LEGAL_AGE", "PARAM_PAGE_TYPE", "", "PARAM_TITLE_PREFIX", "newInstance", "Lcom/didi/payment/kycservice/kyc/fragment/SignUp99PayFragment;", "pageType", "titlePrefix", "kyc-service_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: SignUp99PayFragment.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final SignUp99PayFragment newInstance(int i, String str) {
            Intrinsics.checkNotNullParameter(str, "titlePrefix");
            SignUp99PayFragment signUp99PayFragment = new SignUp99PayFragment();
            Bundle bundle = new Bundle();
            bundle.putString("param_title_prefix", str);
            bundle.putInt(SignUp99PayFragment.f30810z, i);
            signUp99PayFragment.setArguments(bundle);
            return signUp99PayFragment;
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            String string = arguments.getString("param_title_prefix", "");
            Intrinsics.checkNotNullExpressionValue(string, "it.getString(PARAM_TITLE_PREFIX, \"\")");
            this.f30831u = string;
            this.f30832v = arguments.getInt(f30810z);
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.fragment_common_sign_up_99pay, viewGroup, false);
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        ViewModel viewModel = new ViewModelProvider(requireActivity()).get(SignUpVM.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(requir…get(SignUpVM::class.java)");
        this.f30833w = (SignUpVM) viewModel;
        OmegaComParams.Companion.setPubPage(OmegaComParams.PRIMARY_KYC);
        m21681a(view);
        m21697b();
        m21680a();
        m21717k();
        ViewModel viewModel2 = new ViewModelProvider(this).get(SignUp99PayVM.class);
        Intrinsics.checkNotNullExpressionValue(viewModel2, "ViewModelProvider(this).…ignUp99PayVM::class.java)");
        setVm((WBaseViewModel) viewModel2);
        subscribeUi((SignUp99PayVM) getVm());
    }

    public void onDestroyView() {
        super.onDestroyView();
        OmegaComParams.Companion.setPUB_FROM_PAGE(OmegaComParams.PRIMARY_KYC);
    }

    public void subscribeUi(SignUp99PayVM signUp99PayVM) {
        Intrinsics.checkNotNullParameter(signUp99PayVM, "viewModel");
        signUp99PayVM.getPermissionData().observe(getViewLifecycleOwner(), new Observer() {
            public final void onChanged(Object obj) {
                SignUp99PayFragment.m21683a(SignUp99PayFragment.this, (PermissionData) obj);
            }
        });
        signUp99PayVM.getCpfinfo().observe(getViewLifecycleOwner(), new Observer() {
            public final void onChanged(Object obj) {
                SignUp99PayFragment.m21684a(SignUp99PayFragment.this, (PixGetApplyInfoResp.CPFInfo) obj);
            }
        });
        signUp99PayVM.isLoading().observe(getViewLifecycleOwner(), new Observer() {
            public final void onChanged(Object obj) {
                SignUp99PayFragment.m21686a(SignUp99PayFragment.this, (Boolean) obj);
            }
        });
        signUp99PayVM.getBShowHomelandCityErrorPage().observe(getViewLifecycleOwner(), new Observer() {
            public final void onChanged(Object obj) {
                SignUp99PayFragment.m21700b(SignUp99PayFragment.this, (Boolean) obj);
            }
        });
        signUp99PayVM.getBFinishCreateAccount().observe(getViewLifecycleOwner(), new Observer() {
            public final void onChanged(Object obj) {
                SignUp99PayFragment.m21704c(SignUp99PayFragment.this, (Boolean) obj);
            }
        });
        ((SignUp99PayVM) getVm()).getErrorMsg().observe(getViewLifecycleOwner(), $$Lambda$SignUp99PayFragment$APeLs2NgDoLG6FJEnf5rXO74F0.INSTANCE);
        signUp99PayVM.getBizCode().observe(getViewLifecycleOwner(), new Observer() {
            public final void onChanged(Object obj) {
                SignUp99PayFragment.m21687a(SignUp99PayFragment.this, (String) obj);
            }
        });
        signUp99PayVM.getSessionId().observe(getViewLifecycleOwner(), new Observer() {
            public final void onChanged(Object obj) {
                SignUp99PayFragment.m21701b(SignUp99PayFragment.this, (String) obj);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m21683a(SignUp99PayFragment signUp99PayFragment, PermissionData permissionData) {
        Intrinsics.checkNotNullParameter(signUp99PayFragment, "this$0");
        if (permissionData == null) {
            signUp99PayFragment.m21706d();
        } else {
            signUp99PayFragment.m21690a(permissionData);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m21684a(SignUp99PayFragment signUp99PayFragment, PixGetApplyInfoResp.CPFInfo cPFInfo) {
        Intrinsics.checkNotNullParameter(signUp99PayFragment, "this$0");
        Intrinsics.checkNotNullExpressionValue(cPFInfo, "it");
        signUp99PayFragment.m21692a(cPFInfo);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m21686a(SignUp99PayFragment signUp99PayFragment, Boolean bool) {
        Intrinsics.checkNotNullParameter(signUp99PayFragment, "this$0");
        SignUpVM signUpVM = signUp99PayFragment.f30833w;
        if (signUpVM == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pixSignUpVM");
            signUpVM = null;
        }
        signUpVM.isLoading().setValue(bool);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static final void m21700b(SignUp99PayFragment signUp99PayFragment, Boolean bool) {
        Intrinsics.checkNotNullParameter(signUp99PayFragment, "this$0");
        Intrinsics.checkNotNullExpressionValue(bool, "isShow");
        if (bool.booleanValue()) {
            signUp99PayFragment.showHomelandCityErrorPage();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public static final void m21704c(SignUp99PayFragment signUp99PayFragment, Boolean bool) {
        FragmentActivity activity;
        Intrinsics.checkNotNullParameter(signUp99PayFragment, "this$0");
        Intrinsics.checkNotNullExpressionValue(bool, "isFinish");
        if (bool.booleanValue()) {
            SignUpVM signUpVM = signUp99PayFragment.f30833w;
            SignUpVM signUpVM2 = null;
            if (signUpVM == null) {
                Intrinsics.throwUninitializedPropertyAccessException("pixSignUpVM");
                signUpVM = null;
            }
            if (!Intrinsics.areEqual((Object) signUpVM.getPageSource(), (Object) "1") || ((SignUp99PayVM) signUp99PayFragment.getVm()).getResultPageData() == null) {
                SignUpVM signUpVM3 = signUp99PayFragment.f30833w;
                if (signUpVM3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("pixSignUpVM");
                    signUpVM3 = null;
                }
                signUpVM3.setFromPrimary(1);
                OmegaComParams.Companion.setPUB_FROM_PRIMARY(1);
                SignUpVM signUpVM4 = signUp99PayFragment.f30833w;
                if (signUpVM4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("pixSignUpVM");
                } else {
                    signUpVM2 = signUpVM4;
                }
                if (signUpVM2.updatePageSceneByStepList() && (activity = signUp99PayFragment.getActivity()) != null) {
                    activity.finish();
                    return;
                }
                return;
            }
            KycRegisterUtils.INSTANCE.go2PixSignUpResultPage(signUp99PayFragment.getActivity(), ((SignUp99PayVM) signUp99PayFragment.getVm()).getResultPageData());
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public static final void m21705c(String str) {
        Map linkedHashMap = new LinkedHashMap();
        Intrinsics.checkNotNullExpressionValue(str, "it");
        linkedHashMap.put("error_message", str);
        KycOmega.Companion.trackEvent("fin_primarykycinformation_toast_sw", linkedHashMap);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m21687a(SignUp99PayFragment signUp99PayFragment, String str) {
        Intrinsics.checkNotNullParameter(signUp99PayFragment, "this$0");
        ViewGroup viewGroup = signUp99PayFragment.f30811a;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContentView");
            viewGroup = null;
        }
        viewGroup.setVisibility(8);
        View view = signUp99PayFragment.f30824n;
        if (view != null) {
            view.setVisibility(0);
        }
        OmegaComParams.Companion.setPubPage(OmegaComParams.FACE_GUIDE);
        KycOmega.Companion.trackEvent("fin_faceguide_sw");
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static final void m21701b(SignUp99PayFragment signUp99PayFragment, String str) {
        String value;
        Intrinsics.checkNotNullParameter(signUp99PayFragment, "this$0");
        if (str != null && (value = ((SignUp99PayVM) signUp99PayFragment.getVm()).getBizCode().getValue()) != null) {
            signUp99PayFragment.m21694a(value, str);
        }
    }

    /* renamed from: a */
    private final void m21694a(String str, String str2) {
        DiFaceParam diFaceParam = new DiFaceParam();
        diFaceParam.setBizCode(Integer.parseInt(str));
        diFaceParam.setSessionId(str2);
        diFaceParam.setToken(PayBaseParamUtil.getStringParam(getActivity(), "token"));
        DiFace.startFaceRecognition(diFaceParam, new DiFace.IDiFaceCallback() {
            public final void onResult(DiFaceResult diFaceResult) {
                SignUp99PayFragment.m21685a(SignUp99PayFragment.this, diFaceResult);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m21685a(SignUp99PayFragment signUp99PayFragment, DiFaceResult diFaceResult) {
        Intrinsics.checkNotNullParameter(signUp99PayFragment, "this$0");
        if (diFaceResult.getCode() != 102) {
            ((SignUp99PayVM) signUp99PayFragment.getVm()).getFaceResult();
        }
    }

    /* renamed from: a */
    private final void m21681a(View view) {
        this.f30824n = view.findViewById(R.id.face_guide_layout);
        this.f30825o = view.findViewById(R.id.face_guide_confirm_btn);
        View findViewById = view.findViewById(R.id.rl_wallet_account_apply_content);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.…et_account_apply_content)");
        this.f30811a = (ViewGroup) findViewById;
        View findViewById2 = view.findViewById(R.id.wallet_account_appply_title_tv);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById<Te…_account_appply_title_tv)");
        this.f30819i = (TextView) findViewById2;
        View findViewById3 = view.findViewById(R.id.wallet_account_appply_sub_title_tv);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById<Te…ount_appply_sub_title_tv)");
        this.f30820j = (TextView) findViewById3;
        View findViewById4 = view.findViewById(R.id.wallet_account_appply_age_title);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "rootView.findViewById(R.…account_appply_age_title)");
        this.f30812b = (TextView) findViewById4;
        View findViewById5 = view.findViewById(R.id.wallet_account_appply_name_input);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "rootView.findViewById(R.…ccount_appply_name_input)");
        this.f30813c = (NewPixInputView) findViewById5;
        View findViewById6 = view.findViewById(R.id.wallet_account_appply_cpf_input);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "rootView.findViewById(R.…account_appply_cpf_input)");
        this.f30814d = (NewPixInputView) findViewById6;
        View findViewById7 = view.findViewById(R.id.wallet_account_appply_age_tv);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "rootView.findViewById<Te…et_account_appply_age_tv)");
        this.f30815e = (TextView) findViewById7;
        View findViewById8 = view.findViewById(R.id.wallet_account_appply_term_cb);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "rootView.findViewById<Ch…t_account_appply_term_cb)");
        this.f30821k = (CheckBox) findViewById8;
        View findViewById9 = view.findViewById(R.id.wallet_account_appply_term_tv);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "rootView.findViewById<Te…t_account_appply_term_tv)");
        this.f30816f = (TextView) findViewById9;
        View findViewById10 = view.findViewById(R.id.wallet_account_activity_tv);
        Intrinsics.checkNotNullExpressionValue(findViewById10, "rootView.findViewById<Te…llet_account_activity_tv)");
        this.f30818h = (TextView) findViewById10;
        View findViewById11 = view.findViewById(R.id.wallet_account_appply_submit_btn);
        Intrinsics.checkNotNullExpressionValue(findViewById11, "rootView.findViewById<Te…ccount_appply_submit_btn)");
        this.f30817g = (TextView) findViewById11;
        View findViewById12 = view.findViewById(R.id.wallet_account_apply_vs);
        Intrinsics.checkNotNullExpressionValue(findViewById12, "rootView.findViewById<Vi….wallet_account_apply_vs)");
        this.f30822l = (ViewStub) findViewById12;
        View findViewById13 = view.findViewById(R.id.tv_age_error_info);
        Intrinsics.checkNotNullExpressionValue(findViewById13, "rootView.findViewById(R.id.tv_age_error_info)");
        this.f30826p = (TextView) findViewById13;
        SignUpVM signUpVM = this.f30833w;
        NewPixInputView newPixInputView = null;
        if (signUpVM == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pixSignUpVM");
            signUpVM = null;
        }
        if (Intrinsics.areEqual((Object) signUpVM.getPageSource(), (Object) "1")) {
            TextView textView = this.f30817g;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSubmitBtn");
                textView = null;
            }
            textView.setText(getString(R.string.Fintech_Payment_Optimization_Submission_hMgW));
        } else {
            TextView textView2 = this.f30817g;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSubmitBtn");
                textView2 = null;
            }
            textView2.setText(getString(R.string.Fintech_Payment_Optimization_Next_step_SRDJ));
        }
        TextView textView3 = this.f30817g;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSubmitBtn");
            textView3 = null;
        }
        textView3.setEnabled(false);
        TextView textView4 = this.f30812b;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTvAgeTitle");
            textView4 = null;
        }
        textView4.setText(TextHighlightUtil.highlight(getString(R.string.kyc_create_account_page_input_age), Color.parseColor("#999999"), Color.parseColor("#FF0000")));
        CharSequence highlight = TextHighlightUtil.highlight(getString(R.string.kyc_create_account_page_input_name), Color.parseColor("#999999"), Color.parseColor("#FF0000"));
        NewPixInputView newPixInputView2 = this.f30813c;
        if (newPixInputView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mNameInput");
            newPixInputView2 = null;
        }
        Intrinsics.checkNotNullExpressionValue(highlight, "nameTitle");
        newPixInputView2.initData(highlight, 120, 1);
        CharSequence highlight2 = TextHighlightUtil.highlight(getString(R.string.kyc_create_account_page_input_cpf), Color.parseColor("#999999"), Color.parseColor("#FF0000"));
        NewPixInputView newPixInputView3 = this.f30814d;
        if (newPixInputView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCPFInput");
        } else {
            newPixInputView = newPixInputView3;
        }
        Intrinsics.checkNotNullExpressionValue(highlight2, "cpfTitle");
        newPixInputView.initData(highlight2, 14, 2, "000.000.000-00");
        KycOmega.Companion.trackEvent("gp_99pay_information_vew_sw");
    }

    /* renamed from: a */
    private final void m21680a() {
        String stringParam = PayBaseParamUtil.getStringParam(getContext(), "phone");
        TextView textView = this.f30815e;
        CheckBox checkBox = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDateTv");
            textView = null;
        }
        textView.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                SignUp99PayFragment.m21682a(SignUp99PayFragment.this, view);
            }
        });
        TextView textView2 = this.f30817g;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSubmitBtn");
            textView2 = null;
        }
        textView2.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                SignUp99PayFragment.m21699b(SignUp99PayFragment.this, view);
            }
        });
        NewPixInputView newPixInputView = this.f30814d;
        if (newPixInputView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCPFInput");
            newPixInputView = null;
        }
        newPixInputView.setAfterTextChangedListener(new SignUp99PayFragment$initListener$3(this));
        NewPixInputView newPixInputView2 = this.f30814d;
        if (newPixInputView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCPFInput");
            newPixInputView2 = null;
        }
        NewPixInputView newPixInputView3 = this.f30814d;
        if (newPixInputView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCPFInput");
            newPixInputView3 = null;
        }
        newPixInputView2.addTextChangeListener(new CPFInputWatcher(newPixInputView3.getEditText()));
        NewPixInputView newPixInputView4 = this.f30813c;
        if (newPixInputView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mNameInput");
            newPixInputView4 = null;
        }
        newPixInputView4.setAfterTextChangedListener(new SignUp99PayFragment$initListener$4(this));
        NewPixInputView newPixInputView5 = this.f30813c;
        if (newPixInputView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mNameInput");
            newPixInputView5 = null;
        }
        newPixInputView5.setOnLoseFocus(new SignUp99PayFragment$initListener$5(this, stringParam));
        NewPixInputView newPixInputView6 = this.f30814d;
        if (newPixInputView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCPFInput");
            newPixInputView6 = null;
        }
        newPixInputView6.setOnLoseFocus(new SignUp99PayFragment$initListener$6(this, stringParam));
        CheckBox checkBox2 = this.f30821k;
        if (checkBox2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTermCb");
        } else {
            checkBox = checkBox2;
        }
        checkBox.setOnCheckedChangeListener(new SignUp99PayFragment$initListener$7(this, stringParam));
        View view = this.f30825o;
        if (view != null) {
            view.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    SignUp99PayFragment.m21703c(SignUp99PayFragment.this, view);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m21682a(SignUp99PayFragment signUp99PayFragment, View view) {
        Intrinsics.checkNotNullParameter(signUp99PayFragment, "this$0");
        if (signUp99PayFragment.f30827q == null) {
            signUp99PayFragment.m21702c();
        }
        TimePickerView timePickerView = signUp99PayFragment.f30827q;
        Intrinsics.checkNotNull(timePickerView);
        timePickerView.show();
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static final void m21699b(SignUp99PayFragment signUp99PayFragment, View view) {
        Intrinsics.checkNotNullParameter(signUp99PayFragment, "this$0");
        KycOmega.Companion.trackEvent("gp_99pay_information_submit_ck");
        signUp99PayFragment.m21719m();
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public static final void m21703c(SignUp99PayFragment signUp99PayFragment, View view) {
        Intrinsics.checkNotNullParameter(signUp99PayFragment, "this$0");
        KycOmega.Companion.trackButtonEvent("fin_faceguide_button_ck", 1);
        ((SignUp99PayVM) signUp99PayFragment.getVm()).getFaceSession();
    }

    /* renamed from: b */
    private final void m21697b() {
        Context context = getContext();
        if (context != null) {
            String stringParam = PayBaseParamUtil.getStringParam(context, "phone");
            KycSPUtils.Companion companion = KycSPUtils.Companion;
            Intrinsics.checkNotNullExpressionValue(stringParam, "phone");
            String name = companion.getName(context, stringParam);
            String birthday = KycSPUtils.Companion.getBirthday(context, stringParam);
            String cpf = KycSPUtils.Companion.getCPF(context, stringParam);
            CharSequence charSequence = name;
            boolean z = false;
            CheckBox checkBox = null;
            if (!(charSequence == null || charSequence.length() == 0)) {
                NewPixInputView newPixInputView = this.f30813c;
                if (newPixInputView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mNameInput");
                    newPixInputView = null;
                }
                newPixInputView.setInputStr(name);
            }
            CharSequence charSequence2 = birthday;
            if (!(charSequence2 == null || charSequence2.length() == 0)) {
                TextView textView = this.f30815e;
                if (textView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mDateTv");
                    textView = null;
                }
                textView.setText(charSequence2);
                TextView textView2 = this.f30815e;
                if (textView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mDateTv");
                    textView2 = null;
                }
                textView2.setTextColor(Color.parseColor("#000000"));
                if (birthday != null) {
                    String substring = birthday.substring(0, 2);
                    Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    if (birthday != null) {
                        String substring2 = birthday.substring(3, 5);
                        Intrinsics.checkNotNullExpressionValue(substring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                        if (birthday != null) {
                            String substring3 = birthday.substring(6, 10);
                            Intrinsics.checkNotNullExpressionValue(substring3, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                            this.f30829s = m21696b(substring3 + '-' + substring2 + '-' + substring);
                        } else {
                            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                        }
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                    }
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                }
            } else {
                TextView textView3 = this.f30815e;
                if (textView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mDateTv");
                    textView3 = null;
                }
                textView3.setText(getString(R.string.Fintech_Payment_Optimization_Day_month_tVPF));
                TextView textView4 = this.f30815e;
                if (textView4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mDateTv");
                    textView4 = null;
                }
                textView4.setTextColor(Color.parseColor("#999999"));
            }
            CharSequence charSequence3 = cpf;
            if (!(charSequence3 == null || charSequence3.length() == 0)) {
                NewPixInputView newPixInputView2 = this.f30814d;
                if (newPixInputView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mCPFInput");
                    newPixInputView2 = null;
                }
                newPixInputView2.setInputStr(cpf);
            }
            CheckBox checkBox2 = this.f30821k;
            if (checkBox2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTermCb");
            } else {
                checkBox = checkBox2;
            }
            if (KycSPUtils.Companion.isCheckedTc(context, stringParam)) {
                z = true;
            }
            checkBox.setChecked(z);
            m21710f();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00c5, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0.getText(), (java.lang.Object) getString(com.taxis99.R.string.Fintech_Payment_Optimization_Day_month_tVPF)) != false) goto L_0x00c7;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void m21692a(com.didi.payment.kycservice.net.response.PixGetApplyInfoResp.CPFInfo r6) {
        /*
            r5 = this;
            android.view.ViewGroup r0 = r5.f30811a
            r1 = 0
            if (r0 != 0) goto L_0x000b
            java.lang.String r0 = "mContentView"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)
            r0 = r1
        L_0x000b:
            r2 = 0
            r0.setVisibility(r2)
            android.view.View r0 = r5.f30823m
            if (r0 == 0) goto L_0x001b
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            r3 = 8
            r0.setVisibility(r3)
        L_0x001b:
            r5.f30830t = r6
            java.lang.String r0 = r6.getName()
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            r3 = 1
            if (r0 != 0) goto L_0x0057
            com.didi.payment.kycservice.widget.NewPixInputView r0 = r5.f30813c
            java.lang.String r4 = "mNameInput"
            if (r0 != 0) goto L_0x0034
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r4)
            r0 = r1
        L_0x0034:
            java.lang.String r0 = r0.getInputStr()
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            int r0 = r0.length()
            if (r0 != 0) goto L_0x0042
            r0 = 1
            goto L_0x0043
        L_0x0042:
            r0 = 0
        L_0x0043:
            if (r0 == 0) goto L_0x0057
            com.didi.payment.kycservice.widget.NewPixInputView r0 = r5.f30813c
            if (r0 != 0) goto L_0x004d
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r4)
            r0 = r1
        L_0x004d:
            java.lang.String r4 = r6.getName()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r4)
            r0.setInputStr(r4)
        L_0x0057:
            java.lang.String r0 = r6.getTaxId()
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x0088
            com.didi.payment.kycservice.widget.NewPixInputView r0 = r5.f30814d
            if (r0 != 0) goto L_0x006d
            java.lang.String r0 = "mCPFInput"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)
            r0 = r1
        L_0x006d:
            java.lang.String r0 = r0.getInputStr()
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            int r0 = r0.length()
            if (r0 != 0) goto L_0x007b
            r0 = 1
            goto L_0x007c
        L_0x007b:
            r0 = 0
        L_0x007c:
            if (r0 == 0) goto L_0x0088
            java.lang.String r0 = r6.getTaxId()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            r5.m21693a((java.lang.String) r0)
        L_0x0088:
            java.lang.String r0 = r6.getBirthdate()
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x0103
            android.widget.TextView r0 = r5.f30815e
            java.lang.String r4 = "mDateTv"
            if (r0 != 0) goto L_0x009e
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r4)
            r0 = r1
        L_0x009e:
            java.lang.CharSequence r0 = r0.getText()
            if (r0 == 0) goto L_0x00ac
            int r0 = r0.length()
            if (r0 != 0) goto L_0x00ab
            goto L_0x00ac
        L_0x00ab:
            r3 = 0
        L_0x00ac:
            if (r3 != 0) goto L_0x00c7
            android.widget.TextView r0 = r5.f30815e
            if (r0 != 0) goto L_0x00b6
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r4)
            r0 = r1
        L_0x00b6:
            java.lang.CharSequence r0 = r0.getText()
            r3 = 2131951758(0x7f13008e, float:1.953994E38)
            java.lang.String r3 = r5.getString(r3)
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r3)
            if (r0 == 0) goto L_0x0103
        L_0x00c7:
            java.lang.String r0 = r6.getBirthdate()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            java.util.Date r0 = r5.m21696b((java.lang.String) r0)
            if (r0 == 0) goto L_0x0103
            r5.f30829s = r0
            android.widget.TextView r0 = r5.f30815e
            if (r0 != 0) goto L_0x00de
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r4)
            r0 = r1
        L_0x00de:
            java.lang.String r3 = "#000000"
            int r3 = android.graphics.Color.parseColor(r3)
            r0.setTextColor(r3)
            android.widget.TextView r0 = r5.f30815e
            if (r0 != 0) goto L_0x00ef
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r4)
            r0 = r1
        L_0x00ef:
            com.didi.payment.commonsdk.ui.WBaseViewModel r3 = r5.getVm()
            com.didi.payment.kycservice.kyc.vm.SignUp99PayVM r3 = (com.didi.payment.kycservice.kyc.p133vm.SignUp99PayVM) r3
            java.util.Date r4 = r5.f30829s
            kotlin.jvm.internal.Intrinsics.checkNotNull(r4)
            java.lang.String r3 = r3.getShowTime(r4)
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            r0.setText(r3)
        L_0x0103:
            com.didi.payment.kycservice.net.response.PixGetApplyInfoResp$PromotionActivity r0 = r6.getPromotionRule()
            if (r0 == 0) goto L_0x0170
            com.didi.payment.kycservice.net.response.PixGetApplyInfoResp$PromotionActivity r0 = r6.getPromotionRule()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            java.lang.String r0 = r0.getText()
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x0170
            com.didi.payment.kycservice.net.response.PixGetApplyInfoResp$PromotionActivity r0 = r6.getPromotionRule()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            java.lang.String r0 = r0.getUrl()
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x0170
            android.widget.TextView r0 = r5.f30818h
            java.lang.String r3 = "mActivityTv"
            if (r0 != 0) goto L_0x0139
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r3)
            r0 = r1
        L_0x0139:
            r0.setVisibility(r2)
            android.widget.TextView r0 = r5.f30818h
            if (r0 != 0) goto L_0x0144
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r3)
            r0 = r1
        L_0x0144:
            com.didi.payment.kycservice.net.response.PixGetApplyInfoResp$PromotionActivity r2 = r6.getPromotionRule()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2)
            java.lang.String r2 = r2.getText()
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r0.setText(r2)
            com.didi.payment.kycservice.net.response.PixGetApplyInfoResp$PromotionActivity r6 = r6.getPromotionRule()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r6)
            java.lang.String r6 = r6.getUrl()
            android.widget.TextView r0 = r5.f30818h
            if (r0 != 0) goto L_0x0167
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r3)
            goto L_0x0168
        L_0x0167:
            r1 = r0
        L_0x0168:
            com.didi.payment.kycservice.kyc.fragment.-$$Lambda$SignUp99PayFragment$Jtiqm4Y1FvvlSP6nAeNKQS5sWSs r0 = new com.didi.payment.kycservice.kyc.fragment.-$$Lambda$SignUp99PayFragment$Jtiqm4Y1FvvlSP6nAeNKQS5sWSs
            r0.<init>(r6)
            r1.setOnClickListener(r0)
        L_0x0170:
            r5.m21710f()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.payment.kycservice.kyc.fragment.SignUp99PayFragment.m21692a(com.didi.payment.kycservice.net.response.PixGetApplyInfoResp$CPFInfo):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m21688a(SignUp99PayFragment signUp99PayFragment, String str, View view) {
        Intrinsics.checkNotNullParameter(signUp99PayFragment, "this$0");
        WebBrowserUtil.startInternalWebActivity(signUp99PayFragment.getContext(), str, "");
    }

    /* renamed from: c */
    private final void m21702c() {
        Calendar instance = Calendar.getInstance();
        instance.set(1904, 1, 23);
        Calendar instance2 = Calendar.getInstance();
        Calendar instance3 = Calendar.getInstance();
        Date date = this.f30829s;
        if (date != null) {
            instance3.setTime(date);
        } else {
            instance3.set(1990, 0, 1);
        }
        TimePickerView build = new TimePickerBuilder(getContext(), new OnTimeSelectListener() {
            public final void onTimeSelect(Date date, View view) {
                SignUp99PayFragment.m21689a(SignUp99PayFragment.this, date, view);
            }
        }).setTimeSelectChangeListener($$Lambda$SignUp99PayFragment$J1r7cFWnPmDcOYh73d74BGghIJA.INSTANCE).setType(new boolean[]{true, true, true, false, false, false}).isDialog(true).addOnCancelClickListener($$Lambda$SignUp99PayFragment$EpWlczTK_b8sdHpu8yNBE3a2h0.INSTANCE).setItemVisibleCount(5).setLineSpacingMultiplier(2.0f).isAlphaGradient(true).setDate(instance3).setRangDate(instance, instance2).setLabel("", "", "", "", "", "").setLayoutRes(R.layout.wallet_time_picker_layout, new CustomListener() {
            public final void customLayout(View view) {
                SignUp99PayFragment.m21711f(SignUp99PayFragment.this, view);
            }
        }).build();
        this.f30827q = build;
        Dialog dialog = build == null ? null : build.getDialog();
        if (dialog != null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2, 80);
            layoutParams.leftMargin = 0;
            layoutParams.rightMargin = 0;
            TimePickerView timePickerView = this.f30827q;
            Intrinsics.checkNotNull(timePickerView);
            timePickerView.getDialogContainerLayout().setLayoutParams(layoutParams);
            Window window = dialog.getWindow();
            if (window != null) {
                window.setWindowAnimations(R.style.picker_view_slide_anim);
                window.getDecorView().setPadding(0, 0, 0, 0);
                window.setGravity(80);
                window.setBackgroundDrawableResource(R.drawable.transparent);
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.width = -1;
                attributes.height = -2;
                window.setAttributes(attributes);
                window.setDimAmount(0.2f);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m21689a(SignUp99PayFragment signUp99PayFragment, Date date, View view) {
        Intrinsics.checkNotNullParameter(signUp99PayFragment, "this$0");
        signUp99PayFragment.f30829s = date;
        TextView textView = signUp99PayFragment.f30815e;
        NewPixInputView newPixInputView = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDateTv");
            textView = null;
        }
        Intrinsics.checkNotNullExpressionValue(date, LogAttributes.DATE);
        textView.setText(((SignUp99PayVM) signUp99PayFragment.getVm()).getShowTime(date));
        TextView textView2 = signUp99PayFragment.f30815e;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDateTv");
            textView2 = null;
        }
        textView2.setTextColor(Color.parseColor("#000000"));
        if (signUp99PayFragment.m21716j()) {
            TextView textView3 = signUp99PayFragment.f30826p;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAgeErrorTv");
                textView3 = null;
            }
            textView3.setVisibility(8);
            Context context = signUp99PayFragment.getContext();
            if (context != null) {
                KycSPUtils.Companion companion = KycSPUtils.Companion;
                String stringParam = PayBaseParamUtil.getStringParam(signUp99PayFragment.getContext(), "phone");
                Intrinsics.checkNotNullExpressionValue(stringParam, "getStringParam(context, PayParam.PHONE)");
                TextView textView4 = signUp99PayFragment.f30815e;
                if (textView4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mDateTv");
                    textView4 = null;
                }
                companion.putBirthday(context, stringParam, textView4.getText().toString());
            }
        } else {
            TextView textView5 = signUp99PayFragment.f30826p;
            if (textView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAgeErrorTv");
                textView5 = null;
            }
            textView5.setVisibility(0);
            TextView textView6 = signUp99PayFragment.f30826p;
            if (textView6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAgeErrorTv");
                textView6 = null;
            }
            textView6.setText(signUp99PayFragment.getString(R.string.Fintech_Payment_Optimization_Unregistered_until_gAeR));
        }
        signUp99PayFragment.m21710f();
        NewPixInputView newPixInputView2 = signUp99PayFragment.f30814d;
        if (newPixInputView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCPFInput");
        } else {
            newPixInputView = newPixInputView2;
        }
        newPixInputView.getEditText().requestFocus();
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public static final void m21711f(SignUp99PayFragment signUp99PayFragment, View view) {
        Intrinsics.checkNotNullParameter(signUp99PayFragment, "this$0");
        ((TextView) view.findViewById(R.id.wallet_account_appply_time_confirm_btn)).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                SignUp99PayFragment.m21707d(SignUp99PayFragment.this, view);
            }
        });
        ((ImageView) view.findViewById(R.id.wallet_time_picker_cancel_btn)).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                SignUp99PayFragment.m21709e(SignUp99PayFragment.this, view);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public static final void m21707d(SignUp99PayFragment signUp99PayFragment, View view) {
        Intrinsics.checkNotNullParameter(signUp99PayFragment, "this$0");
        TimePickerView timePickerView = signUp99PayFragment.f30827q;
        Intrinsics.checkNotNull(timePickerView);
        timePickerView.returnData();
        TimePickerView timePickerView2 = signUp99PayFragment.f30827q;
        Intrinsics.checkNotNull(timePickerView2);
        timePickerView2.dismiss();
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public static final void m21709e(SignUp99PayFragment signUp99PayFragment, View view) {
        Intrinsics.checkNotNullParameter(signUp99PayFragment, "this$0");
        TimePickerView timePickerView = signUp99PayFragment.f30827q;
        Intrinsics.checkNotNull(timePickerView);
        timePickerView.dismiss();
    }

    /* renamed from: a */
    private final void m21690a(PermissionData permissionData) {
        ViewGroup viewGroup = null;
        if (this.f30823m == null) {
            ViewStub viewStub = this.f30822l;
            if (viewStub == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mErrorViewStub");
                viewStub = null;
            }
            this.f30823m = viewStub.inflate();
        }
        ViewGroup viewGroup2 = this.f30811a;
        if (viewGroup2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContentView");
        } else {
            viewGroup = viewGroup2;
        }
        viewGroup.setVisibility(8);
        View view = this.f30823m;
        Intrinsics.checkNotNull(view);
        view.setVisibility(0);
        View view2 = this.f30823m;
        Intrinsics.checkNotNull(view2);
        View findViewById = view2.findViewById(R.id.tv_account_apply_error_title);
        Intrinsics.checkNotNullExpressionValue(findViewById, "mErrorContentView!!.find…ccount_apply_error_title)");
        TextView textView = (TextView) findViewById;
        View view3 = this.f30823m;
        Intrinsics.checkNotNull(view3);
        View findViewById2 = view3.findViewById(R.id.ll_account_apply_retry);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "mErrorContentView!!.find…d.ll_account_apply_retry)");
        View view4 = this.f30823m;
        Intrinsics.checkNotNull(view4);
        View findViewById3 = view4.findViewById(R.id.tv_account_apply_setting);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "mErrorContentView!!.find…tv_account_apply_setting)");
        TextView textView2 = (TextView) findViewById3;
        if (!permissionData.getHasGetCityId()) {
            textView.setText(R.string.wallet_account_location_failed_title);
            findViewById2.setVisibility(0);
            textView2.setVisibility(8);
            findViewById2.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    SignUp99PayFragment.m21712g(SignUp99PayFragment.this, view);
                }
            });
            return;
        }
        textView.setText(R.string.wallet_account_location_none_title);
        findViewById2.setVisibility(8);
        textView2.setVisibility(0);
        textView2.setOnClickListener(new View.OnClickListener(this) {
            public final /* synthetic */ SignUp99PayFragment f$1;

            {
                this.f$1 = r2;
            }

            public final void onClick(View view) {
                SignUp99PayFragment.m21691a(PermissionData.this, this.f$1, view);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public static final void m21712g(SignUp99PayFragment signUp99PayFragment, View view) {
        Intrinsics.checkNotNullParameter(signUp99PayFragment, "this$0");
        ((SignUp99PayVM) signUp99PayFragment.getVm()).requestLocationOnce();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m21691a(PermissionData permissionData, SignUp99PayFragment signUp99PayFragment, View view) {
        Intrinsics.checkNotNullParameter(permissionData, "$locationResultData");
        Intrinsics.checkNotNullParameter(signUp99PayFragment, "this$0");
        if (!permissionData.getHasGranted()) {
            signUp99PayFragment.m21708e();
        }
        if (!permissionData.getHasLocEnable()) {
            signUp99PayFragment.startActivity(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"));
            FragmentActivity activity = signUp99PayFragment.getActivity();
            if (activity != null) {
                activity.finish();
            }
        }
    }

    /* renamed from: d */
    private final void m21706d() {
        View view = this.f30823m;
        if (view != null) {
            view.setVisibility(8);
        }
        ViewGroup viewGroup = this.f30811a;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContentView");
            viewGroup = null;
        }
        viewGroup.setVisibility(0);
    }

    /* renamed from: e */
    private final void m21708e() {
        PermissionUtil.checkAndRequestPermissions((PermissionContext) this, (PermissionCallback) new SignUp99PayFragment$requestLocationPermission$1(this), new String[]{Permission.ACCESS_FINE_LOCATION}, false);
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public final void m21710f() {
        TextView textView = this.f30817g;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSubmitBtn");
            textView = null;
        }
        textView.setEnabled(m21713g());
    }

    /* renamed from: g */
    private final boolean m21713g() {
        if (m21715i() && m21714h() && m21716j()) {
            CheckBox checkBox = this.f30821k;
            if (checkBox == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTermCb");
                checkBox = null;
            }
            if (checkBox.isChecked()) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public final boolean m21714h() {
        NewPixInputView newPixInputView = this.f30814d;
        if (newPixInputView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCPFInput");
            newPixInputView = null;
        }
        String replace = new Regex(" ").replace((CharSequence) new Regex("-").replace((CharSequence) StringsKt.replace$default(newPixInputView.getInputStr(), '.', ' ', false, 4, (Object) null), ""), "");
        if (StringsKt.isBlank(replace) || replace.length() != 11) {
            return false;
        }
        int[] iArr = new int[11];
        int i = 0;
        while (true) {
            int i2 = i + 1;
            iArr[i] = Character.getNumericValue(replace.charAt(i));
            if (i2 > 10) {
                break;
            }
            i = i2;
        }
        int i3 = 100;
        int i4 = 0;
        for (int i5 = 0; i5 < 9; i5++) {
            i4 += iArr[i5] * i3;
            i3 -= 10;
        }
        int i6 = i4 % 11;
        if (i6 == 10) {
            i6 = 0;
        }
        if (i6 != iArr[9]) {
            return false;
        }
        int i7 = 110;
        int i8 = 0;
        for (int i9 = 0; i9 < 10; i9++) {
            i8 += iArr[i9] * i7;
            i7 -= 10;
        }
        int i10 = i8 % 11;
        if (i10 == 10) {
            i10 = 0;
        }
        if (i10 == iArr[10]) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    /* renamed from: i */
    public final boolean m21715i() {
        NewPixInputView newPixInputView = this.f30813c;
        NewPixInputView newPixInputView2 = null;
        if (newPixInputView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mNameInput");
            newPixInputView = null;
        }
        if (!StringsKt.isBlank(newPixInputView.getInputStr())) {
            NewPixInputView newPixInputView3 = this.f30813c;
            if (newPixInputView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mNameInput");
            } else {
                newPixInputView2 = newPixInputView3;
            }
            if (Pattern.matches("[^1234567890\\-/:;()$&@“”\".,?!’\\[\\]{}#%^*+=_|~<>€£¥•]*$", newPixInputView2.getInputStr())) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: j */
    private final boolean m21716j() {
        TextView textView = this.f30815e;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDateTv");
            textView = null;
        }
        CharSequence text = textView.getText();
        if ((text == null || text.length() == 0) || Intrinsics.areEqual((Object) text, (Object) getString(R.string.Fintech_Payment_Optimization_Day_month_tVPF))) {
            return false;
        }
        Intrinsics.checkNotNullExpressionValue(text, "str");
        int parseInt = Integer.parseInt(text.subSequence(0, 2).toString());
        int parseInt2 = Integer.parseInt(text.subSequence(3, 5).toString());
        int parseInt3 = Integer.parseInt(text.subSequence(6, 10).toString());
        Calendar instance = Calendar.getInstance();
        int i = instance.get(1) - parseInt3;
        int i2 = (instance.get(2) + 1) - parseInt2;
        int i3 = instance.get(5) - parseInt;
        if (i <= 0) {
            return false;
        }
        if (i2 < 0 || (i2 == 0 && i3 < 0)) {
            i--;
        }
        if (i >= 18) {
            return true;
        }
        return false;
    }

    /* renamed from: k */
    private final void m21717k() {
        String string = getString(R.string.wallet_create_account_page_term_text);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.walle…e_account_page_term_text)");
        String string2 = getString(R.string.wallet_create_account_page_term_high_light_text);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(R.string.walle…age_term_high_light_text)");
        CharSequence charSequence = string;
        int indexOf$default = StringsKt.indexOf$default(charSequence, string2, 0, false, 6, (Object) null);
        SpannableString spannableString = new SpannableString(charSequence);
        spannableString.setSpan(new SignUp99PayFragment$initTermView$clickableSpan$1(this), indexOf$default, string.length(), 18);
        TextView textView = this.f30816f;
        TextView textView2 = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTermTv");
            textView = null;
        }
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        TextView textView3 = this.f30816f;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTermTv");
            textView3 = null;
        }
        textView3.setHighlightColor(0);
        TextView textView4 = this.f30816f;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTermTv");
        } else {
            textView2 = textView4;
        }
        textView2.setText(spannableString);
    }

    /* access modifiers changed from: private */
    /* renamed from: l */
    public final void m21718l() {
        PixGetApplyInfoResp.CPFInfo cPFInfo = this.f30830t;
        if ((cPFInfo == null ? null : cPFInfo.getTermsUrl()) != null && getActivity() != null) {
            NWRouter nWRouter = NWRouter.INSTANCE;
            FragmentActivity activity = getActivity();
            PixGetApplyInfoResp.CPFInfo cPFInfo2 = this.f30830t;
            Intrinsics.checkNotNull(cPFInfo2);
            nWRouter.gotoPDFPage(activity, cPFInfo2.getTermsUrl());
        }
    }

    /* renamed from: m */
    private final void m21719m() {
        NewPixInputView newPixInputView = this.f30814d;
        SignUpVM signUpVM = null;
        if (newPixInputView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCPFInput");
            newPixInputView = null;
        }
        String replace = new Regex(" ").replace((CharSequence) new Regex("-").replace((CharSequence) StringsKt.replace$default(newPixInputView.getInputStr(), '.', ' ', false, 4, (Object) null), ""), "");
        SignUp99PayVM signUp99PayVM = (SignUp99PayVM) getVm();
        NewPixInputView newPixInputView2 = this.f30813c;
        if (newPixInputView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mNameInput");
            newPixInputView2 = null;
        }
        String inputStr = newPixInputView2.getInputStr();
        String n = m21720n();
        SignUpVM signUpVM2 = this.f30833w;
        if (signUpVM2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pixSignUpVM");
        } else {
            signUpVM = signUpVM2;
        }
        signUp99PayVM.submitKycInfoV1(inputStr, n, replace, signUpVM.getPageSource());
    }

    /* renamed from: n */
    private final String m21720n() {
        if (this.f30829s == null) {
            return "";
        }
        String format = new SimpleDateFormat("yyyy-MM-dd").format(this.f30829s);
        Intrinsics.checkNotNullExpressionValue(format, "format.format(mSelectDate)");
        return format;
    }

    public final void showHomelandCityErrorPage() {
        ViewGroup viewGroup = this.f30811a;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContentView");
            viewGroup = null;
        }
        PayHomelandCityErrorView.show(viewGroup);
    }

    /* renamed from: a */
    private final void m21693a(String str) {
        if (!TextUtils.isEmpty(str) && str.length() == 11) {
            NewPixInputView newPixInputView = this.f30814d;
            if (newPixInputView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCPFInput");
                newPixInputView = null;
            }
            newPixInputView.setInputStr(str);
        }
    }

    /* renamed from: b */
    private final Date m21696b(String str) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd").parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: o */
    private final void m21721o() {
        FragmentActivity activity = getActivity();
        Object obj = null;
        View currentFocus = activity == null ? null : activity.getCurrentFocus();
        if (currentFocus != null) {
            FragmentActivity activity2 = getActivity();
            if (activity2 != null) {
                obj = activity2.getSystemService("input_method");
            }
            if (obj != null) {
                ((InputMethodManager) obj).hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        }
    }
}
