package com.didi.payment.kycservice.key.create;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.didi.payment.commonsdk.p129ui.WBaseActivity;
import com.didi.payment.commonsdk.p129ui.WBaseViewModel;
import com.didi.payment.commonsdk.utils.NFragmentUtils;
import com.didi.payment.commonsdk.utils.NWRouter;
import com.didi.payment.commonsdk.widget.WalletToastNew;
import com.didi.payment.kycservice.key.create.fragment.CheckCodeFragment;
import com.didi.payment.kycservice.key.create.fragment.CreateKeyByCpfFragment;
import com.didi.payment.kycservice.key.create.fragment.CreateKeyByEmailFragment;
import com.didi.payment.kycservice.key.create.fragment.CreateKeyByPhoneFragment;
import com.didi.payment.kycservice.key.create.fragment.CreateKeyByRandomFragment;
import com.didi.payment.kycservice.kyc.response.ResultPageData;
import com.didi.payment.kycservice.utils.KycRegisterUtils;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(mo175977d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\rB\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\u0012\u0010\b\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0014J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0002H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, mo175978d2 = {"Lcom/didi/payment/kycservice/key/create/PixKeyCreateActivity;", "Lcom/didi/payment/commonsdk/ui/WBaseActivity;", "Lcom/didi/payment/kycservice/key/create/PixKeyCreateVM;", "()V", "createFragment", "Landroidx/fragment/app/Fragment;", "onBackPressed", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "subscribeUi", "vm", "Companion", "kyc-service_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: PixKeyCreateActivity.kt */
public final class PixKeyCreateActivity extends WBaseActivity<PixKeyCreateVM> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String PARAM_KEY_SUBTITLE = "param_key_subtitle";
    public static final String PARAM_KEY_TITLE = "param_key_title";
    public static final String PARAM_KEY_TYPE = "param_key_type";
    public static final String PARAM_KEY_VAL = "param_key_val";

    /* renamed from: a */
    private Fragment f30622a;

    @Metadata(mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, mo175978d2 = {"Lcom/didi/payment/kycservice/key/create/PixKeyCreateActivity$Companion;", "", "()V", "PARAM_KEY_SUBTITLE", "", "PARAM_KEY_TITLE", "PARAM_KEY_TYPE", "PARAM_KEY_VAL", "kyc-service_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: PixKeyCreateActivity.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        Fragment fragment;
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_pix_key_create_new);
        int intExtra = getIntent().getIntExtra("param_key_type", 1);
        String stringExtra = getIntent().getStringExtra("param_key_val");
        String str = "";
        String str2 = stringExtra == null ? str : stringExtra;
        String stringExtra2 = getIntent().getStringExtra(PARAM_KEY_TITLE);
        if (stringExtra2 == null) {
            stringExtra2 = str;
        }
        String stringExtra3 = getIntent().getStringExtra(PARAM_KEY_SUBTITLE);
        if (stringExtra3 != null) {
            str = stringExtra3;
        }
        if (bundle == null) {
            if (intExtra == 1) {
                fragment = CreateKeyByCpfFragment.Companion.newInstance(stringExtra2, str, str2);
            } else if (intExtra == 2) {
                fragment = CreateKeyByEmailFragment.Companion.newInstance(stringExtra2, str, str2);
            } else if (intExtra != 3) {
                fragment = CreateKeyByRandomFragment.Companion.newInstance(stringExtra2, str, str2);
            } else {
                if (StringsKt.startsWith$default(str2, "+55", false, 2, (Object) null)) {
                    str2 = StringsKt.replaceFirst$default(str2, "+55", "", false, 4, (Object) null);
                }
                fragment = CreateKeyByPhoneFragment.Companion.newInstance(stringExtra2, str, str2);
            }
            this.f30622a = fragment;
            if (fragment != null) {
                getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).commitAllowingStateLoss();
            }
        }
        ViewModel viewModel = new ViewModelProvider(this).get(PixKeyCreateVM.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this).…xKeyCreateVM::class.java)");
        setVm((WBaseViewModel) viewModel);
        subscribeUi((PixKeyCreateVM) getVm());
    }

    public void subscribeUi(PixKeyCreateVM pixKeyCreateVM) {
        Intrinsics.checkNotNullParameter(pixKeyCreateVM, "vm");
        LifecycleOwner lifecycleOwner = this;
        pixKeyCreateVM.getShowToastLD().observe(lifecycleOwner, new Observer() {
            public final void onChanged(Object obj) {
                PixKeyCreateActivity.m21526a(PixKeyCreateActivity.this, (String) obj);
            }
        });
        if (this.f30622a != null) {
            pixKeyCreateVM.getShowVerifyPageLD().observe(lifecycleOwner, new Observer(pixKeyCreateVM) {
                public final /* synthetic */ PixKeyCreateVM f$1;

                {
                    this.f$1 = r2;
                }

                public final void onChanged(Object obj) {
                    PixKeyCreateActivity.m21524a(PixKeyCreateActivity.this, this.f$1, (Boolean) obj);
                }
            });
        }
        pixKeyCreateVM.getShowKeyListPageLD().observe(lifecycleOwner, new Observer() {
            public final void onChanged(Object obj) {
                PixKeyCreateActivity.m21525a(PixKeyCreateActivity.this, (Boolean) obj);
            }
        });
        pixKeyCreateVM.getShowResultPageLD().observe(lifecycleOwner, new Observer(this) {
            public final /* synthetic */ PixKeyCreateActivity f$1;

            {
                this.f$1 = r2;
            }

            public final void onChanged(Object obj) {
                PixKeyCreateActivity.m21527a(PixKeyCreateVM.this, this.f$1, (Boolean) obj);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m21526a(PixKeyCreateActivity pixKeyCreateActivity, String str) {
        Intrinsics.checkNotNullParameter(pixKeyCreateActivity, "this$0");
        WalletToastNew.showMsg(pixKeyCreateActivity, str);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m21524a(PixKeyCreateActivity pixKeyCreateActivity, PixKeyCreateVM pixKeyCreateVM, Boolean bool) {
        Intrinsics.checkNotNullParameter(pixKeyCreateActivity, "this$0");
        Intrinsics.checkNotNullParameter(pixKeyCreateVM, "$vm");
        Fragment fragment = pixKeyCreateActivity.f30622a;
        if (fragment != null) {
            pixKeyCreateActivity.getSupportFragmentManager().beginTransaction().hide(fragment).commitAllowingStateLoss();
        }
        NFragmentUtils.INSTANCE.addFragment2BackStack(pixKeyCreateActivity, R.id.container, CheckCodeFragment.Companion.newInstance(pixKeyCreateVM.getKeyType(), pixKeyCreateVM.getKeyVal(), pixKeyCreateVM.getCheckCodePageSrcFrom()));
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m21525a(PixKeyCreateActivity pixKeyCreateActivity, Boolean bool) {
        Intrinsics.checkNotNullParameter(pixKeyCreateActivity, "this$0");
        NWRouter.INSTANCE.go2PixKeyListPage(pixKeyCreateActivity);
        pixKeyCreateActivity.finish();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m21527a(PixKeyCreateVM pixKeyCreateVM, PixKeyCreateActivity pixKeyCreateActivity, Boolean bool) {
        Intrinsics.checkNotNullParameter(pixKeyCreateVM, "$vm");
        Intrinsics.checkNotNullParameter(pixKeyCreateActivity, "this$0");
        ResultPageData resultPageData = pixKeyCreateVM.getResultPageData();
        if (resultPageData != null) {
            resultPageData.setPix(true);
        }
        KycRegisterUtils.INSTANCE.go2PixSignUpResultPage(pixKeyCreateActivity, pixKeyCreateVM.getResultPageData());
    }

    public void onBackPressed() {
        if (getSupportFragmentManager().getBackStackEntryCount() <= 0 || this.f30622a == null) {
            finish();
            return;
        }
        getSupportFragmentManager().popBackStack();
        Fragment fragment = this.f30622a;
        if (fragment != null) {
            getSupportFragmentManager().beginTransaction().show(fragment).commitAllowingStateLoss();
        }
    }
}
