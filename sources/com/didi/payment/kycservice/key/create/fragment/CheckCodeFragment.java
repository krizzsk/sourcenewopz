package com.didi.payment.kycservice.key.create.fragment;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.didi.global.globaluikit.LEGOUICreator;
import com.didi.global.globaluikit.callback.LEGOBtnTextAndCallback;
import com.didi.global.globaluikit.drawer.LEGODrawer;
import com.didi.global.globaluikit.drawer.templatemodel.LEGODrawerModel1;
import com.didi.payment.commonsdk.p129ui.WBaseFragment;
import com.didi.payment.commonsdk.p129ui.WBaseViewModel;
import com.didi.payment.kycservice.key.create.p131vm.CheckCodeVM;
import com.didi.payment.kycservice.kyc.response.MigrateTipData;
import com.didi.payment.kycservice.module.PixTitleBarModule;
import com.didi.payment.kycservice.module.TitleBarData;
import com.didi.payment.kycservice.utils.KycRegisterUtils;
import com.didi.payment.kycservice.widget.NewAuthCodeInputView;
import com.didi.sdk.util.ToastHelper;
import com.taxis99.R;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.osgi.framework.VersionRange;

@Metadata(mo175977d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 &2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001&B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0011\u001a\u00020\u0012H\u0014J\b\u0010\u0013\u001a\u00020\u0014H\u0002J\u0010\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0012H\u0002J\u0012\u0010\u0017\u001a\u00020\u00142\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J&\u0010\u001a\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\b\u0010\u001f\u001a\u00020\u0014H\u0016J\u001a\u0010 \u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00122\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J \u0010!\u001a\u00020\u00142\u0006\u0010\"\u001a\u00020#2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002J\u0010\u0010$\u001a\u00020\u00142\u0006\u0010%\u001a\u00020\u0002H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X.¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X.¢\u0006\u0002\n\u0000¨\u0006'"}, mo175978d2 = {"Lcom/didi/payment/kycservice/key/create/fragment/CheckCodeFragment;", "Lcom/didi/payment/commonsdk/ui/WBaseFragment;", "Lcom/didi/payment/kycservice/key/create/vm/CheckCodeVM;", "()V", "btnRetry", "Landroid/widget/TextView;", "dlgMigrate", "Lcom/didi/global/globaluikit/drawer/LEGODrawer;", "etInputNew", "Lcom/didi/payment/kycservice/widget/NewAuthCodeInputView;", "keyType", "", "keyVal", "", "srcFrom", "titleBarModule", "Lcom/didi/payment/kycservice/module/PixTitleBarModule;", "getTitleBarView", "Landroid/view/View;", "initListener", "", "initView", "view", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroyView", "onViewCreated", "showMigrateDlg", "dlgInfo", "Lcom/didi/payment/kycservice/kyc/response/MigrateTipData;", "subscribeUi", "vm", "Companion", "kyc-service_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CheckCodeFragment.kt */
public final class CheckCodeFragment extends WBaseFragment<CheckCodeVM> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int FROM_CREATE = 0;
    public static final int FROM_MIGRATE = 1;

    /* renamed from: h */
    private static final int f30634h = 6;

    /* renamed from: a */
    private TextView f30635a;

    /* renamed from: b */
    private NewAuthCodeInputView f30636b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public LEGODrawer f30637c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public int f30638d = -100;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public String f30639e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public int f30640f;

    /* renamed from: g */
    private PixTitleBarModule f30641g;

    public static final /* synthetic */ CheckCodeVM access$getVm(CheckCodeFragment checkCodeFragment) {
        return (CheckCodeVM) checkCodeFragment.getVm();
    }

    @Metadata(mo175977d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\r"}, mo175978d2 = {"Lcom/didi/payment/kycservice/key/create/fragment/CheckCodeFragment$Companion;", "", "()V", "CODE_LEN", "", "FROM_CREATE", "FROM_MIGRATE", "newInstance", "Lcom/didi/payment/kycservice/key/create/fragment/CheckCodeFragment;", "keyType", "keyVal", "", "srcFrom", "kyc-service_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: CheckCodeFragment.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final CheckCodeFragment newInstance(int i, String str, int i2) {
            Intrinsics.checkNotNullParameter(str, "keyVal");
            CheckCodeFragment checkCodeFragment = new CheckCodeFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("param_key_type", i);
            bundle.putString("param_key_val", str);
            bundle.putInt("param_src_from", i2);
            Unit unit = Unit.INSTANCE;
            checkCodeFragment.setArguments(bundle);
            return checkCodeFragment;
        }
    }

    public void onCreate(Bundle bundle) {
        String string;
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        int i = -100;
        if (arguments != null) {
            i = arguments.getInt("param_key_type", -100);
        }
        this.f30638d = i;
        Bundle arguments2 = getArguments();
        String str = "";
        if (!(arguments2 == null || (string = arguments2.getString("param_key_val")) == null)) {
            str = string;
        }
        this.f30639e = str;
        Bundle arguments3 = getArguments();
        int i2 = 0;
        if (arguments3 != null) {
            i2 = arguments3.getInt("param_src_from", 0);
        }
        this.f30640f = i2;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.new_fragment_check_code, viewGroup, false);
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        m21530a(view);
        m21529a();
        ViewModel viewModel = new ViewModelProvider(requireActivity()).get(CheckCodeVM.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(requir…(CheckCodeVM::class.java)");
        setVm((WBaseViewModel) viewModel);
        subscribeUi((CheckCodeVM) getVm());
        ((CheckCodeVM) getVm()).startCountDown();
    }

    /* renamed from: a */
    private final void m21530a(View view) {
        String str;
        ViewStub viewStub = (ViewStub) view.findViewById(R.id.create_key_title_bar);
        PixTitleBarModule.Companion companion = PixTitleBarModule.Companion;
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        Intrinsics.checkNotNullExpressionValue(viewStub, "titleBarStub");
        PixTitleBarModule create = companion.create(requireContext, viewStub);
        this.f30641g = create;
        PixTitleBarModule pixTitleBarModule = null;
        if (create == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleBarModule");
            create = null;
        }
        String string = getString(R.string.GRider_Registration_Enter_verification_exRe);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.GRide…_Enter_verification_exRe)");
        int i = this.f30638d;
        if (i == 2) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String string2 = getString(R.string.GRider_Registration_Verification_code_cTTj);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(R.string.GRide…n_Verification_code_cTTj)");
            Object[] objArr = new Object[1];
            String str2 = this.f30639e;
            if (str2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("keyVal");
                str2 = null;
            }
            objArr[0] = str2;
            str = String.format(string2, Arrays.copyOf(objArr, 1));
            Intrinsics.checkNotNullExpressionValue(str, "java.lang.String.format(format, *args)");
        } else if (i != 3) {
            StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
            String string3 = getString(R.string.GRider_Registration_Verification_code_ZkLZ);
            Intrinsics.checkNotNullExpressionValue(string3, "getString(R.string.GRide…n_Verification_code_ZkLZ)");
            Object[] objArr2 = new Object[1];
            String str3 = this.f30639e;
            if (str3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("keyVal");
                str3 = null;
            }
            objArr2[0] = str3;
            str = String.format(string3, Arrays.copyOf(objArr2, 1));
            Intrinsics.checkNotNullExpressionValue(str, "java.lang.String.format(format, *args)");
        } else {
            StringCompanionObject stringCompanionObject3 = StringCompanionObject.INSTANCE;
            String string4 = getString(R.string.GRider_Registration_Verification_code_ZkLZ);
            Intrinsics.checkNotNullExpressionValue(string4, "getString(R.string.GRide…n_Verification_code_ZkLZ)");
            Object[] objArr3 = new Object[1];
            String str4 = this.f30639e;
            if (str4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("keyVal");
                str4 = null;
            }
            objArr3[0] = str4;
            str = String.format(string4, Arrays.copyOf(objArr3, 1));
            Intrinsics.checkNotNullExpressionValue(str, "java.lang.String.format(format, *args)");
        }
        create.bindData(new TitleBarData((String) null, string, str, false, 9, (DefaultConstructorMarker) null));
        PixTitleBarModule pixTitleBarModule2 = this.f30641g;
        if (pixTitleBarModule2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleBarModule");
        } else {
            pixTitleBarModule = pixTitleBarModule2;
        }
        pixTitleBarModule.setBackImgOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                CheckCodeFragment.m21531a(CheckCodeFragment.this, view);
            }
        });
        View findViewById = view.findViewById(R.id.pix_verify_code_retry_btn);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.pix_verify_code_retry_btn)");
        this.f30635a = (TextView) findViewById;
        View findViewById2 = view.findViewById(R.id.pix_verify_code_input_et);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.pix_verify_code_input_et)");
        this.f30636b = (NewAuthCodeInputView) findViewById2;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m21531a(CheckCodeFragment checkCodeFragment, View view) {
        Intrinsics.checkNotNullParameter(checkCodeFragment, "this$0");
        FragmentActivity activity = checkCodeFragment.getActivity();
        if (activity != null) {
            activity.onBackPressed();
        }
    }

    /* renamed from: a */
    private final void m21529a() {
        NewAuthCodeInputView newAuthCodeInputView = this.f30636b;
        if (newAuthCodeInputView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("etInputNew");
            newAuthCodeInputView = null;
        }
        newAuthCodeInputView.addTextChangedListener(new C10750xee59bbc0(this));
    }

    public void onDestroyView() {
        super.onDestroyView();
        ((CheckCodeVM) getVm()).stopCountDown();
    }

    public void subscribeUi(CheckCodeVM checkCodeVM) {
        Intrinsics.checkNotNullParameter(checkCodeVM, "vm");
        super.subscribeUi(checkCodeVM);
        checkCodeVM.getLeftTimeLD().observe(getViewLifecycleOwner(), new Observer(checkCodeVM) {
            public final /* synthetic */ CheckCodeVM f$1;

            {
                this.f$1 = r2;
            }

            public final void onChanged(Object obj) {
                CheckCodeFragment.m21534a(CheckCodeFragment.this, this.f$1, (Long) obj);
            }
        });
        checkCodeVM.getShowToastLD().observe(getViewLifecycleOwner(), new Observer() {
            public final void onChanged(Object obj) {
                CheckCodeFragment.m21536a(CheckCodeFragment.this, (String) obj);
            }
        });
        checkCodeVM.getShowResultPageLD().observe(getViewLifecycleOwner(), new Observer(checkCodeVM) {
            public final /* synthetic */ CheckCodeVM f$1;

            {
                this.f$1 = r2;
            }

            public final void onChanged(Object obj) {
                CheckCodeFragment.m21533a(CheckCodeFragment.this, this.f$1, (Boolean) obj);
            }
        });
        checkCodeVM.getShowMigrateTipLD().observe(getViewLifecycleOwner(), new Observer() {
            public final void onChanged(Object obj) {
                CheckCodeFragment.m21535a(CheckCodeFragment.this, (MigrateTipData) obj);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m21534a(CheckCodeFragment checkCodeFragment, CheckCodeVM checkCodeVM, Long l) {
        Intrinsics.checkNotNullParameter(checkCodeFragment, "this$0");
        Intrinsics.checkNotNullParameter(checkCodeVM, "$vm");
        TextView textView = null;
        if (l != null && l.longValue() == 0) {
            TextView textView2 = checkCodeFragment.f30635a;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("btnRetry");
                textView2 = null;
            }
            textView2.setText(checkCodeFragment.getString(R.string.GRider_payment_Try_again_SxKx));
            TextView textView3 = checkCodeFragment.f30635a;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("btnRetry");
                textView3 = null;
            }
            textView3.setEnabled(true);
            TextView textView4 = checkCodeFragment.f30635a;
            if (textView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("btnRetry");
            } else {
                textView = textView4;
            }
            textView.setOnClickListener(new View.OnClickListener(checkCodeVM) {
                public final /* synthetic */ CheckCodeVM f$1;

                {
                    this.f$1 = r2;
                }

                public final void onClick(View view) {
                    CheckCodeFragment.m21532a(CheckCodeFragment.this, this.f$1, view);
                }
            });
            return;
        }
        String str = checkCodeFragment.getString(R.string.GRider_Registration_Once_again_qTbn) + VersionRange.LEFT_OPEN + checkCodeVM.getLeftTimeLD().getValue() + VersionRange.RIGHT_OPEN;
        TextView textView5 = checkCodeFragment.f30635a;
        if (textView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnRetry");
            textView5 = null;
        }
        textView5.setText(str);
        TextView textView6 = checkCodeFragment.f30635a;
        if (textView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnRetry");
        } else {
            textView = textView6;
        }
        textView.setEnabled(false);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m21532a(CheckCodeFragment checkCodeFragment, CheckCodeVM checkCodeVM, View view) {
        Intrinsics.checkNotNullParameter(checkCodeFragment, "this$0");
        Intrinsics.checkNotNullParameter(checkCodeVM, "$vm");
        NewAuthCodeInputView newAuthCodeInputView = checkCodeFragment.f30636b;
        String str = null;
        if (newAuthCodeInputView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("etInputNew");
            newAuthCodeInputView = null;
        }
        newAuthCodeInputView.setText("");
        checkCodeVM.startCountDown();
        int i = checkCodeFragment.f30638d;
        String str2 = checkCodeFragment.f30639e;
        if (str2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("keyVal");
        } else {
            str = str2;
        }
        checkCodeVM.reqAuthCode(i, str);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m21536a(CheckCodeFragment checkCodeFragment, String str) {
        Context context;
        Intrinsics.checkNotNullParameter(checkCodeFragment, "this$0");
        if (!TextUtils.isEmpty(str) && (context = checkCodeFragment.getContext()) != null) {
            ToastHelper.showLongInfo(context, str);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m21533a(CheckCodeFragment checkCodeFragment, CheckCodeVM checkCodeVM, Boolean bool) {
        Intrinsics.checkNotNullParameter(checkCodeFragment, "this$0");
        Intrinsics.checkNotNullParameter(checkCodeVM, "$vm");
        KycRegisterUtils.INSTANCE.go2PixSignUpResultPage(checkCodeFragment.getActivity(), checkCodeVM.getResultPageData());
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m21535a(CheckCodeFragment checkCodeFragment, MigrateTipData migrateTipData) {
        Intrinsics.checkNotNullParameter(checkCodeFragment, "this$0");
        Intrinsics.checkNotNullExpressionValue(migrateTipData, "migrateData");
        int i = checkCodeFragment.f30638d;
        String str = checkCodeFragment.f30639e;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("keyVal");
            str = null;
        }
        checkCodeFragment.m21537a(migrateTipData, i, str);
    }

    /* access modifiers changed from: protected */
    public View getTitleBarView() {
        PixTitleBarModule pixTitleBarModule = this.f30641g;
        if (pixTitleBarModule == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleBarModule");
            pixTitleBarModule = null;
        }
        return pixTitleBarModule.getToolBar();
    }

    /* renamed from: a */
    private final void m21537a(MigrateTipData migrateTipData, int i, String str) {
        this.f30637c = LEGOUICreator.showDrawerTemplate(getContext(), new LEGODrawerModel1(migrateTipData.getMigrateTitle(), new LEGOBtnTextAndCallback(migrateTipData.getMigrateButton(), new CheckCodeFragment$showMigrateDlg$model$1(this, i, str))).addMinorBtn(new LEGOBtnTextAndCallback(migrateTipData.getCancelButton(), new CheckCodeFragment$showMigrateDlg$model$2(this))).setClickOutsideCanCancel(true).setSubTitle(migrateTipData.getMigrateSubTitle()));
    }
}
