package com.didi.payment.kycservice.kyc;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.didi.payment.base.anti.AccessBlockManager;
import com.didi.payment.base.event.WalletRefreshDataEvent;
import com.didi.payment.base.event.home.MapEventKey;
import com.didi.payment.base.event.home.MapEventManager;
import com.didi.payment.base.utils.UIUtil;
import com.didi.payment.commonsdk.p129ui.WBaseActivity;
import com.didi.payment.commonsdk.p129ui.WBaseViewModel;
import com.didi.payment.commonsdk.spi.DDCustomViewData;
import com.didi.payment.commonsdk.spi.JumioService;
import com.didi.payment.commonsdk.utils.KycOmega;
import com.didi.payment.commonsdk.utils.NViewUtils;
import com.didi.payment.commonsdk.utils.OmegaComParams;
import com.didi.payment.kycservice.guide.rule.GuidsRuleManager;
import com.didi.payment.kycservice.guide.rule.IKycGuidesRule;
import com.didi.payment.kycservice.kyc.fragment.FullKycExtraFragment;
import com.didi.payment.kycservice.kyc.fragment.IDTypeFragment;
import com.didi.payment.kycservice.kyc.response.GuidesInfoResp;
import com.didi.payment.kycservice.kyc.response.ResultPageData;
import com.didi.payment.kycservice.kyc.view.widget.StepProgressBar;
import com.didi.payment.wallet_ui.dialog.WalletDialog;
import com.didi.payment.wallet_ui.dialog.WalletDrawerContent;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import org.greenrobot.eventbus.EventBus;

@Metadata(mo175977d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 :2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001:B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\n\u0010\u0014\u001a\u0004\u0018\u00010\nH\u0014J*\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00182\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0002J\b\u0010\u001c\u001a\u00020\u0013H\u0002J\b\u0010\u001d\u001a\u00020\u0013H\u0014J\b\u0010\u001e\u001a\u00020\u0013H\u0002J\b\u0010\u001f\u001a\u00020 H\u0002J\"\u0010!\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00182\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0014J\b\u0010\"\u001a\u00020\u0013H\u0016J\u0012\u0010#\u001a\u00020\u00132\b\u0010$\u001a\u0004\u0018\u00010%H\u0014J\b\u0010&\u001a\u00020\u0013H\u0014J\u0012\u0010'\u001a\u00020\u00132\b\u0010(\u001a\u0004\u0018\u00010\u001bH\u0014J-\u0010)\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u00182\u000e\u0010*\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050+2\u0006\u0010,\u001a\u00020-H\u0016¢\u0006\u0002\u0010.J\u0010\u0010/\u001a\u00020\u00132\u0006\u0010(\u001a\u00020\u001bH\u0002J\"\u00100\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00182\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0002J\b\u00101\u001a\u00020\u0013H\u0002J\b\u00102\u001a\u00020 H\u0002J \u00103\u001a\u00020\u00132\u0016\u00104\u001a\u0012\u0012\u0004\u0012\u00020605j\b\u0012\u0004\u0012\u000206`7H\u0002J\u0010\u00108\u001a\u00020\u00132\u0006\u00109\u001a\u00020\u0002H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX.¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\nX.¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X.¢\u0006\u0002\n\u0000¨\u0006;"}, mo175978d2 = {"Lcom/didi/payment/kycservice/kyc/SignUpActivity;", "Lcom/didi/payment/commonsdk/ui/WBaseActivity;", "Lcom/didi/payment/kycservice/kyc/SignUpVM;", "()V", "addressType", "", "blockId", "curFragment", "Landroidx/fragment/app/Fragment;", "ivBack", "Landroid/view/View;", "mBackDialog", "Lcom/didi/payment/wallet_ui/dialog/WalletDialog;", "spaceView", "stepProgressBar", "Lcom/didi/payment/kycservice/kyc/view/widget/StepProgressBar;", "toolbarContainer", "Landroid/widget/LinearLayout;", "finish", "", "getTitleBarView", "handleResult", "fragment", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "initListener", "initStatusBar", "initView", "isAccessBlock", "", "onActivityResult", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onNewIntent", "intent", "onRequestPermissionsResult", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "parseParam", "reqFragment", "resetActionBar", "showBackPressedDialog", "showStepBar", "arrayList", "Ljava/util/ArrayList;", "Lcom/didi/payment/kycservice/kyc/response/GuidesInfoResp$StepInfo;", "Lkotlin/collections/ArrayList;", "subscribeUi", "vm", "Companion", "kyc-service_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: SignUpActivity.kt */
public final class SignUpActivity extends WBaseActivity<SignUpVM> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String PARAM_FROM_RESULT_PAGE = "p_from_result_page";
    public static final String PARAM_PAGE_SCENE = "scene";
    public static final String PARAM_RESULT_DATA = "p_result_data";
    public static final int REQ_CODE_ADDRESS_LIST = 10001;
    public static final int REQ_CODE_GUIDE = 10000;

    /* renamed from: a */
    private LinearLayout f30730a;

    /* renamed from: b */
    private View f30731b;

    /* renamed from: c */
    private View f30732c;

    /* renamed from: d */
    private Fragment f30733d;

    /* renamed from: e */
    private StepProgressBar f30734e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public WalletDialog f30735f;

    /* renamed from: g */
    private String f30736g;

    /* renamed from: h */
    private String f30737h;

    @Metadata(mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: SignUpActivity.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SignUpPageScene.values().length];
            iArr[SignUpPageScene.NULL.ordinal()] = 1;
            iArr[SignUpPageScene.GUIDE.ordinal()] = 2;
            iArr[SignUpPageScene.SIGN_UP_99PAY.ordinal()] = 3;
            iArr[SignUpPageScene.CHOOSE_ID_TYPE.ordinal()] = 4;
            iArr[SignUpPageScene.CHOOSE_ID_TYPE_JUMIO.ordinal()] = 5;
            iArr[SignUpPageScene.CHOOSE_KEY_TYPE.ordinal()] = 6;
            iArr[SignUpPageScene.RESULT.ordinal()] = 7;
            iArr[SignUpPageScene.ADDRESS.ordinal()] = 8;
            iArr[SignUpPageScene.FULL_KYC_EXTRA.ordinal()] = 9;
            iArr[SignUpPageScene.FULL_KYC_FINISH.ordinal()] = 10;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final /* synthetic */ SignUpVM access$getVm(SignUpActivity signUpActivity) {
        return (SignUpVM) signUpActivity.getVm();
    }

    @Metadata(mo175977d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bXT¢\u0006\u0002\n\u0000¨\u0006\n"}, mo175978d2 = {"Lcom/didi/payment/kycservice/kyc/SignUpActivity$Companion;", "", "()V", "PARAM_FROM_RESULT_PAGE", "", "PARAM_PAGE_SCENE", "PARAM_RESULT_DATA", "REQ_CODE_ADDRESS_LIST", "", "REQ_CODE_GUIDE", "kyc-service_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: SignUpActivity.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_sign_up);
        m21597a();
        m21609c();
        ViewModel viewModel = new ViewModelProvider(this).get(SignUpVM.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this).get(SignUpVM::class.java)");
        setVm((WBaseViewModel) viewModel);
        JumioService.Companion.isSupportedPlatform(this);
        subscribeUi((SignUpVM) getVm());
        Intent intent = getIntent();
        Intrinsics.checkNotNullExpressionValue(intent, "intent");
        m21599a(intent);
        SystemUtils.log(3, "kyc_test", Intrinsics.stringPlus("onCreate source=", ((SignUpVM) getVm()).getPageSource()), (Throwable) null, "com.didi.payment.kycservice.kyc.SignUpActivity", 79);
        DDCustomViewData.INSTANCE.clearData();
    }

    /* access modifiers changed from: protected */
    public void initStatusBar() {
        super.initStatusBar();
        setTheme(R.style.GlobalActivity50);
    }

    /* access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (intent != null) {
            m21599a(intent);
        }
    }

    /* renamed from: a */
    private final void m21599a(Intent intent) {
        Bundle extras = intent.getExtras();
        if (extras != null) {
            String valueOf = String.valueOf(extras.get("source"));
            SignUpVM signUpVM = (SignUpVM) getVm();
            if (StringsKt.isBlank(valueOf) || Intrinsics.areEqual((Object) valueOf, (Object) "0")) {
                valueOf = "2";
            }
            signUpVM.setPageSource(valueOf);
        }
        boolean z = false;
        ((SignUpVM) getVm()).setSrcFromResultPage(intent.getBooleanExtra(PARAM_FROM_RESULT_PAGE, false));
        Serializable serializableExtra = intent.getSerializableExtra(PARAM_RESULT_DATA);
        if (serializableExtra != null && (serializableExtra instanceof ResultPageData)) {
            ((SignUpVM) getVm()).setResultPageData((ResultPageData) serializableExtra);
        }
        String stringExtra = intent.getStringExtra("scene");
        CharSequence charSequence = stringExtra;
        if (charSequence == null || charSequence.length() == 0) {
            z = true;
        }
        if (z || m21611e()) {
            ((SignUpVM) getVm()).getPageSceneLD().setValue(SignUpPageScene.NULL);
            ((SignUpVM) getVm()).loadData();
        } else {
            ((SignUpVM) getVm()).getPageSceneLD().setValue(SignUpPageScene.Companion.getScene(stringExtra));
        }
        this.f30736g = intent.getStringExtra(FullKycExtraFragment.ADDRESS_TYPE);
        this.f30737h = intent.getStringExtra(FullKycExtraFragment.BLOCK_ID);
    }

    /* renamed from: a */
    private final void m21597a() {
        View findViewById = findViewById(R.id.pix_toolbar);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById<LinearLayout>(R.id.pix_toolbar)");
        this.f30730a = (LinearLayout) findViewById;
        View findViewById2 = findViewById(R.id.space_view);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.space_view)");
        this.f30732c = findViewById2;
        m21607b();
        View findViewById3 = findViewById(R.id.pix_toolbar_left_back_iv);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.pix_toolbar_left_back_iv)");
        this.f30731b = findViewById3;
        setErrViewContainer((ViewGroup) findViewById(R.id.pix_net_error_container));
        this.f30734e = (StepProgressBar) findViewById(R.id.step_progress_view);
        LinearLayout linearLayout = this.f30730a;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("toolbarContainer");
            linearLayout = null;
        }
        linearLayout.setVisibility(8);
        GuidsRuleManager.Companion.init();
    }

    /* renamed from: b */
    private final void m21607b() {
        Ref.IntRef intRef = new Ref.IntRef();
        intRef.element = -1;
        int identifier = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            intRef.element = getResources().getDimensionPixelSize(identifier);
        }
        LinearLayout linearLayout = this.f30730a;
        View view = null;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("toolbarContainer");
            linearLayout = null;
        }
        ViewGroup.LayoutParams layoutParams = linearLayout.getLayoutParams();
        if (layoutParams != null) {
            ((ViewGroup.MarginLayoutParams) layoutParams).setMargins(0, intRef.element, 0, 0);
            View view2 = this.f30732c;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("spaceView");
            } else {
                view = view2;
            }
            view.post(new Runnable(intRef) {
                public final /* synthetic */ Ref.IntRef f$1;

                {
                    this.f$1 = r2;
                }

                public final void run() {
                    SignUpActivity.m21605a(SignUpActivity.this, this.f$1);
                }
            });
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m21605a(SignUpActivity signUpActivity, Ref.IntRef intRef) {
        Intrinsics.checkNotNullParameter(signUpActivity, "this$0");
        Intrinsics.checkNotNullParameter(intRef, "$statusBarHeight");
        NViewUtils nViewUtils = NViewUtils.INSTANCE;
        View view = signUpActivity.f30732c;
        LinearLayout linearLayout = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("spaceView");
            view = null;
        }
        Context context = signUpActivity;
        LinearLayout linearLayout2 = signUpActivity.f30730a;
        if (linearLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("toolbarContainer");
        } else {
            linearLayout = linearLayout2;
        }
        nViewUtils.resetHeight(view, UIUtil.px2dip(context, (float) (linearLayout.getHeight() + intRef.element)));
    }

    /* renamed from: c */
    private final void m21609c() {
        View view = this.f30731b;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivBack");
            view = null;
        }
        view.setOnClickListener(new SignUpActivity$initListener$1(this));
        ViewGroup errViewContainer = getErrViewContainer();
        if (errViewContainer != null) {
            errViewContainer.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    SignUpActivity.m21601a(SignUpActivity.this, view);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m21601a(SignUpActivity signUpActivity, View view) {
        Intrinsics.checkNotNullParameter(signUpActivity, "this$0");
        ((SignUpVM) signUpActivity.getVm()).loadData();
    }

    public void onBackPressed() {
        if (!m21610d()) {
            finish();
        }
    }

    public void subscribeUi(SignUpVM signUpVM) {
        Intrinsics.checkNotNullParameter(signUpVM, "vm");
        super.subscribeUi(signUpVM);
        LifecycleOwner lifecycleOwner = this;
        signUpVM.isLoading().observe(lifecycleOwner, new Observer() {
            public final void onChanged(Object obj) {
                SignUpActivity.m21603a(SignUpActivity.this, (Boolean) obj);
            }
        });
        signUpVM.isNetError().observe(lifecycleOwner, new Observer() {
            public final void onChanged(Object obj) {
                SignUpActivity.m21608b(SignUpActivity.this, (Boolean) obj);
            }
        });
        signUpVM.getStepListData().observe(lifecycleOwner, new Observer() {
            public final void onChanged(Object obj) {
                SignUpActivity.m21604a(SignUpActivity.this, (ArrayList) obj);
            }
        });
        signUpVM.getPageSceneLD().observe(lifecycleOwner, new Observer(signUpVM) {
            public final /* synthetic */ SignUpVM f$1;

            {
                this.f$1 = r2;
            }

            public final void onChanged(Object obj) {
                SignUpActivity.m21602a(SignUpActivity.this, this.f$1, (SignUpPageScene) obj);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m21603a(SignUpActivity signUpActivity, Boolean bool) {
        Intrinsics.checkNotNullParameter(signUpActivity, "this$0");
        LinearLayout linearLayout = signUpActivity.f30730a;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("toolbarContainer");
            linearLayout = null;
        }
        linearLayout.setVisibility(0);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static final void m21608b(SignUpActivity signUpActivity, Boolean bool) {
        Intrinsics.checkNotNullParameter(signUpActivity, "this$0");
        Intrinsics.checkNotNullExpressionValue(bool, "isNetError");
        if (bool.booleanValue()) {
            LinearLayout linearLayout = signUpActivity.f30730a;
            if (linearLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("toolbarContainer");
                linearLayout = null;
            }
            linearLayout.setVisibility(0);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m21604a(SignUpActivity signUpActivity, ArrayList arrayList) {
        Intrinsics.checkNotNullParameter(signUpActivity, "this$0");
        Intrinsics.checkNotNullExpressionValue(arrayList, "it");
        signUpActivity.m21606a((ArrayList<GuidesInfoResp.StepInfo>) arrayList);
        if (arrayList.size() == 0) {
            EventBus.getDefault().post(new WalletRefreshDataEvent());
            signUpActivity.finish();
        }
        StepProgressBar stepProgressBar = signUpActivity.f30734e;
        if (stepProgressBar != null) {
            stepProgressBar.updateView(arrayList);
        }
    }

    /* JADX WARNING: type inference failed for: r6v12, types: [android.view.View] */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m21602a(com.didi.payment.kycservice.kyc.SignUpActivity r5, com.didi.payment.kycservice.kyc.SignUpVM r6, com.didi.payment.kycservice.kyc.SignUpPageScene r7) {
        /*
            java.lang.String r0 = "this$0"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.lang.String r0 = "$vm"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            android.view.View r0 = r5.f30732c
            java.lang.String r1 = "spaceView"
            r2 = 0
            if (r0 != 0) goto L_0x0015
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
            r0 = r2
        L_0x0015:
            r3 = 0
            r0.setVisibility(r3)
            com.didi.payment.commonsdk.utils.OmegaComParams$Companion r0 = com.didi.payment.commonsdk.utils.OmegaComParams.Companion
            java.lang.String r4 = r6.getPageSource()
            r0.setSOURCE(r4)
            if (r7 != 0) goto L_0x0026
            r7 = -1
            goto L_0x002e
        L_0x0026:
            int[] r0 = com.didi.payment.kycservice.kyc.SignUpActivity.WhenMappings.$EnumSwitchMapping$0
            int r7 = r7.ordinal()
            r7 = r0[r7]
        L_0x002e:
            r0 = 8
            java.lang.String r4 = "toolbarContainer"
            switch(r7) {
                case 1: goto L_0x0122;
                case 2: goto L_0x0100;
                case 3: goto L_0x00e5;
                case 4: goto L_0x00ca;
                case 5: goto L_0x00b2;
                case 6: goto L_0x0096;
                case 7: goto L_0x0076;
                case 8: goto L_0x0067;
                case 9: goto L_0x003c;
                case 10: goto L_0x0037;
                default: goto L_0x0035;
            }
        L_0x0035:
            goto L_0x013b
        L_0x0037:
            r5.finish()
            goto L_0x013b
        L_0x003c:
            android.widget.LinearLayout r6 = r5.f30730a
            if (r6 != 0) goto L_0x0044
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r4)
            goto L_0x0045
        L_0x0044:
            r2 = r6
        L_0x0045:
            r2.setVisibility(r3)
            android.os.Bundle r6 = new android.os.Bundle
            r6.<init>()
            java.lang.String r7 = r5.f30736g
            java.lang.String r0 = "typeId"
            r6.putString(r0, r7)
            java.lang.String r7 = r5.f30737h
            java.lang.String r0 = "blockId"
            r6.putString(r0, r7)
            com.didi.payment.kycservice.kyc.fragment.FullKycExtraFragment$Companion r7 = com.didi.payment.kycservice.kyc.fragment.FullKycExtraFragment.Companion
            com.didi.payment.kycservice.kyc.fragment.FullKycExtraFragment r6 = r7.newInstance(r6)
            androidx.fragment.app.Fragment r6 = (androidx.fragment.app.Fragment) r6
            r5.f30733d = r6
            goto L_0x013b
        L_0x0067:
            com.didi.payment.kycservice.kyc.fragment.SignUp99PayFragment$Companion r6 = com.didi.payment.kycservice.kyc.fragment.SignUp99PayFragment.Companion
            r7 = 1
            java.lang.String r0 = ""
            com.didi.payment.kycservice.kyc.fragment.SignUp99PayFragment r6 = r6.newInstance(r7, r0)
            androidx.fragment.app.Fragment r6 = (androidx.fragment.app.Fragment) r6
            r5.f30733d = r6
            goto L_0x013b
        L_0x0076:
            com.didi.payment.kycservice.kyc.view.widget.StepProgressBar r6 = r5.f30734e
            if (r6 != 0) goto L_0x007b
            goto L_0x007e
        L_0x007b:
            r6.setVisibility(r0)
        L_0x007e:
            android.widget.LinearLayout r6 = r5.f30730a
            if (r6 != 0) goto L_0x0086
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r4)
            goto L_0x0087
        L_0x0086:
            r2 = r6
        L_0x0087:
            r2.setVisibility(r3)
            com.didi.payment.kycservice.kyc.fragment.SignUpResultFragment$Companion r6 = com.didi.payment.kycservice.kyc.fragment.SignUpResultFragment.Companion
            com.didi.payment.kycservice.kyc.fragment.SignUpResultFragment r6 = r6.newInstance()
            androidx.fragment.app.Fragment r6 = (androidx.fragment.app.Fragment) r6
            r5.f30733d = r6
            goto L_0x013b
        L_0x0096:
            android.widget.LinearLayout r7 = r5.f30730a
            if (r7 != 0) goto L_0x009e
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r4)
            goto L_0x009f
        L_0x009e:
            r2 = r7
        L_0x009f:
            r2.setVisibility(r3)
            com.didi.payment.kycservice.kyc.fragment.ChooseKeyTypeFragment$Companion r7 = com.didi.payment.kycservice.kyc.fragment.ChooseKeyTypeFragment.Companion
            java.lang.String r6 = r6.getKeyTitlePrefix()
            com.didi.payment.kycservice.kyc.fragment.ChooseKeyTypeFragment r6 = r7.newInstance(r6)
            androidx.fragment.app.Fragment r6 = (androidx.fragment.app.Fragment) r6
            r5.f30733d = r6
            goto L_0x013b
        L_0x00b2:
            android.widget.LinearLayout r6 = r5.f30730a
            if (r6 != 0) goto L_0x00ba
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r4)
            goto L_0x00bb
        L_0x00ba:
            r2 = r6
        L_0x00bb:
            r2.setVisibility(r3)
            com.didi.payment.kycservice.kyc.fragment.IDTypeFragment$Companion r6 = com.didi.payment.kycservice.kyc.fragment.IDTypeFragment.Companion
            com.didi.payment.kycservice.kyc.fragment.IDTypeFragment r6 = r6.newInstance()
            androidx.fragment.app.Fragment r6 = (androidx.fragment.app.Fragment) r6
            r5.f30733d = r6
            goto L_0x013b
        L_0x00ca:
            android.widget.LinearLayout r7 = r5.f30730a
            if (r7 != 0) goto L_0x00d2
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r4)
            goto L_0x00d3
        L_0x00d2:
            r2 = r7
        L_0x00d3:
            r2.setVisibility(r3)
            com.didi.payment.kycservice.kyc.fragment.ChooseIDTypeFragment$Companion r7 = com.didi.payment.kycservice.kyc.fragment.ChooseIDTypeFragment.Companion
            java.lang.String r6 = r6.getIdTitlePrefix()
            com.didi.payment.kycservice.kyc.fragment.ChooseIDTypeFragment r6 = r7.newInstance(r6)
            androidx.fragment.app.Fragment r6 = (androidx.fragment.app.Fragment) r6
            r5.f30733d = r6
            goto L_0x013b
        L_0x00e5:
            android.widget.LinearLayout r7 = r5.f30730a
            if (r7 != 0) goto L_0x00ed
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r4)
            goto L_0x00ee
        L_0x00ed:
            r2 = r7
        L_0x00ee:
            r2.setVisibility(r3)
            com.didi.payment.kycservice.kyc.fragment.SignUp99PayFragment$Companion r7 = com.didi.payment.kycservice.kyc.fragment.SignUp99PayFragment.Companion
            java.lang.String r6 = r6.getKycTitlePrefix()
            com.didi.payment.kycservice.kyc.fragment.SignUp99PayFragment r6 = r7.newInstance(r3, r6)
            androidx.fragment.app.Fragment r6 = (androidx.fragment.app.Fragment) r6
            r5.f30733d = r6
            goto L_0x013b
        L_0x0100:
            android.widget.LinearLayout r6 = r5.f30730a
            if (r6 != 0) goto L_0x0108
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r4)
            r6 = r2
        L_0x0108:
            r6.setVisibility(r3)
            com.didi.payment.kycservice.kyc.fragment.GuidesFragment$Companion r6 = com.didi.payment.kycservice.kyc.fragment.GuidesFragment.Companion
            com.didi.payment.kycservice.kyc.fragment.GuidesFragment r6 = r6.newInstance()
            androidx.fragment.app.Fragment r6 = (androidx.fragment.app.Fragment) r6
            r5.f30733d = r6
            android.view.View r6 = r5.f30732c
            if (r6 != 0) goto L_0x011d
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
            goto L_0x011e
        L_0x011d:
            r2 = r6
        L_0x011e:
            r2.setVisibility(r0)
            goto L_0x013b
        L_0x0122:
            androidx.fragment.app.Fragment r6 = r5.f30733d
            if (r6 == 0) goto L_0x013a
            androidx.fragment.app.FragmentManager r6 = r5.getSupportFragmentManager()
            androidx.fragment.app.FragmentTransaction r6 = r6.beginTransaction()
            androidx.fragment.app.Fragment r5 = r5.f30733d
            kotlin.jvm.internal.Intrinsics.checkNotNull(r5)
            androidx.fragment.app.FragmentTransaction r5 = r6.remove(r5)
            r5.commitAllowingStateLoss()
        L_0x013a:
            return
        L_0x013b:
            androidx.fragment.app.Fragment r6 = r5.f30733d
            if (r6 != 0) goto L_0x0140
            goto L_0x0164
        L_0x0140:
            androidx.fragment.app.FragmentManager r6 = r5.getSupportFragmentManager()
            androidx.fragment.app.FragmentTransaction r6 = r6.beginTransaction()
            r7 = 2131433367(0x7f0b1797, float:1.8488518E38)
            androidx.fragment.app.Fragment r0 = r5.f30733d
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            androidx.fragment.app.Fragment r5 = r5.f30733d
            kotlin.jvm.internal.Intrinsics.checkNotNull(r5)
            java.lang.Class r5 = r5.getClass()
            java.lang.String r5 = r5.getSimpleName()
            androidx.fragment.app.FragmentTransaction r5 = r6.replace(r7, r0, r5)
            r5.commitAllowingStateLoss()
        L_0x0164:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.payment.kycservice.kyc.SignUpActivity.m21602a(com.didi.payment.kycservice.kyc.SignUpActivity, com.didi.payment.kycservice.kyc.SignUpVM, com.didi.payment.kycservice.kyc.SignUpPageScene):void");
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        setResult(-1);
        OmegaComParams.Companion.cleanConParams();
    }

    /* access modifiers changed from: protected */
    public View getTitleBarView() {
        LinearLayout linearLayout = this.f30730a;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("toolbarContainer");
            linearLayout = null;
        }
        return linearLayout;
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        IKycGuidesRule iKycGuidesRule;
        super.onActivityResult(i, i2, intent);
        if (i == 10000) {
            if (i2 == -1) {
                SparseArray<IKycGuidesRule> guidesRules = GuidsRuleManager.Companion.getGuidesRules();
                if (!(guidesRules == null || (iKycGuidesRule = guidesRules.get(Integer.parseInt(((SignUpVM) getVm()).getPageSource()))) == null)) {
                    iKycGuidesRule.displayedGuideRule();
                }
                if (((SignUpVM) getVm()).getResultPageData() != null && !((SignUpVM) getVm()).getSrcFromResultPage()) {
                    ((SignUpVM) getVm()).getPageSceneLD().setValue(SignUpPageScene.RESULT);
                    return;
                } else if (((SignUpVM) getVm()).updatePageSceneByStepList()) {
                    finish();
                }
            } else if (i2 == 0) {
                finish();
            }
        }
        m21598a(i, i2, intent);
    }

    /* renamed from: a */
    private final void m21598a(int i, int i2, Intent intent) {
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
        int size = supportFragmentManager.getFragments().size();
        if (size > 0) {
            int i3 = 0;
            while (true) {
                int i4 = i3 + 1;
                Fragment fragment = supportFragmentManager.getFragments().get(i3);
                Intrinsics.checkNotNullExpressionValue(fragment, "fragmentManager.fragments[index]");
                m21600a(fragment, i, i2, intent);
                if (i4 < size) {
                    i3 = i4;
                } else {
                    return;
                }
            }
        }
    }

    /* renamed from: a */
    private final void m21600a(Fragment fragment, int i, int i2, Intent intent) {
        fragment.onActivityResult(i, i2, intent);
        List<Fragment> fragments = fragment.getChildFragmentManager().getFragments();
        Intrinsics.checkNotNullExpressionValue(fragments, "fragment.childFragmentManager.fragments");
        for (Fragment next : fragments) {
            if (next != null) {
                m21600a(next, i, i2, intent);
            }
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        Intrinsics.checkNotNullParameter(strArr, "permissions");
        Intrinsics.checkNotNullParameter(iArr, "grantResults");
        super.onRequestPermissionsResult(i, strArr, iArr);
        Fragment fragment = this.f30733d;
        if (!(fragment instanceof IDTypeFragment)) {
            return;
        }
        if (fragment != null) {
            ((IDTypeFragment) fragment).showPerDialog(i, strArr, iArr);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.didi.payment.kycservice.kyc.fragment.IDTypeFragment");
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public final boolean m21610d() {
        if (((SignUpVM) getVm()).getPageSceneLD().getValue() == SignUpPageScene.RESULT || ((SignUpVM) getVm()).getExitDetail() == null) {
            return false;
        }
        SignUpPageScene value = ((SignUpVM) getVm()).getPageSceneLD().getValue();
        int i = value == null ? -1 : WhenMappings.$EnumSwitchMapping$0[value.ordinal()];
        if (i == 2) {
            KycOmega.Companion.trackEvent("fin_kycguide_popup_sw");
        } else if (i != 3) {
            if (i == 4) {
                KycOmega.Companion.trackEvent("ibt_didipay_verification_cancel_sw");
            } else if (i == 5) {
                KycOmega.Companion.trackEvent("fin_fullkycverification_popup_sw");
            } else if (i == 9) {
                KycOmega.Companion.trackEvent("ibt_didipay_kyc_return_sw");
            }
        } else if (Intrinsics.areEqual((Object) OmegaComParams.Companion.getPUB_PAGE(), (Object) OmegaComParams.FACE_GUIDE)) {
            KycOmega.Companion.trackEvent("fin_faceguide_popup_sw");
        } else {
            KycOmega.Companion.trackEvent("fin_primarykycinformation_popup_sw");
        }
        WalletDrawerContent.Builder builder = new WalletDrawerContent.Builder();
        GuidesInfoResp.ExitDetail exitDetail = ((SignUpVM) getVm()).getExitDetail();
        Intrinsics.checkNotNull(exitDetail);
        builder.setTitle(exitDetail.getTitle());
        GuidesInfoResp.ExitDetail exitDetail2 = ((SignUpVM) getVm()).getExitDetail();
        Intrinsics.checkNotNull(exitDetail2);
        builder.setContent(exitDetail2.getSubTitle());
        GuidesInfoResp.ExitDetail exitDetail3 = ((SignUpVM) getVm()).getExitDetail();
        Intrinsics.checkNotNull(exitDetail3);
        builder.setFirstBtnText(exitDetail3.getFirstBtn());
        builder.setFirstClickListener(new SignUpActivity$showBackPressedDialog$1$1(this));
        GuidesInfoResp.ExitDetail exitDetail4 = ((SignUpVM) getVm()).getExitDetail();
        Intrinsics.checkNotNull(exitDetail4);
        builder.setSecondBtnText(exitDetail4.getSecondBtn());
        builder.setSecondClickListener(new SignUpActivity$showBackPressedDialog$1$2(this));
        builder.setShowClose(true);
        builder.setCloseClickListener(new SignUpActivity$showBackPressedDialog$1$3(this));
        Unit unit = Unit.INSTANCE;
        WalletDialog configDrawer$default = WalletDialog.Companion.configDrawer$default(WalletDialog.Companion, this, builder, false, false, 4, (Object) null);
        this.f30735f = configDrawer$default;
        if (configDrawer$default != null) {
            SystemUtils.showDialog(configDrawer$default);
        }
        return true;
    }

    public void finish() {
        try {
            SignUpVM signUpVM = (SignUpVM) getVm();
            SignUpPageScene signUpPageScene = null;
            if (signUpVM != null) {
                MutableLiveData<SignUpPageScene> pageSceneLD = signUpVM.getPageSceneLD();
                if (pageSceneLD != null) {
                    signUpPageScene = pageSceneLD.getValue();
                }
            }
            if (signUpPageScene != SignUpPageScene.GUIDE) {
                MapEventManager.INSTANCE.postWalletEvent(MapEventKey.WALLET_HOME_UPDATE);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } catch (Throwable th) {
            super.finish();
            throw th;
        }
        super.finish();
    }

    /* renamed from: e */
    private final boolean m21611e() {
        if (!getIntent().getBooleanExtra(AccessBlockManager.PARAM_ACCESS_BLOCK, false) || getIntent().getIntExtra(AccessBlockManager.PARAM_ACCESS_BLOCK_CODE, 0) != 10012) {
            return false;
        }
        return true;
    }

    /* renamed from: a */
    private final void m21606a(ArrayList<GuidesInfoResp.StepInfo> arrayList) {
        if (arrayList == null || arrayList.size() == 0 || arrayList.size() == 1 || ((SignUpVM) getVm()).getPageSceneLD().getValue() == SignUpPageScene.GUIDE || ((SignUpVM) getVm()).getPageSceneLD().getValue() == SignUpPageScene.RESULT) {
            StepProgressBar stepProgressBar = this.f30734e;
            if (stepProgressBar != null) {
                stepProgressBar.setVisibility(8);
                return;
            }
            return;
        }
        StepProgressBar stepProgressBar2 = this.f30734e;
        if (stepProgressBar2 != null) {
            stepProgressBar2.setVisibility(0);
        }
    }
}
