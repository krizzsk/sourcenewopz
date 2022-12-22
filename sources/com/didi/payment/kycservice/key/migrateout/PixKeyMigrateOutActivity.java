package com.didi.payment.kycservice.key.migrateout;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.didi.dcrypto.util.ColorUtils;
import com.didi.payment.commonsdk.net.WBaseResp;
import com.didi.payment.commonsdk.p129ui.WBaseActivity;
import com.didi.payment.commonsdk.p129ui.WBaseViewModel;
import com.didi.payment.commonsdk.utils.NFragmentUtils;
import com.didi.payment.kycservice.key.migrateout.p132vm.PixKeyMigrateOutVM;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.util.ToastHelper;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\n\u0010\b\u001a\u0004\u0018\u00010\u0005H\u0014J\b\u0010\t\u001a\u00020\nH\u0002J\b\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\f\u001a\u00020\nH\u0016J\u0012\u0010\r\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0014J\u0010\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0002H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X.¢\u0006\u0002\n\u0000¨\u0006\u0012"}, mo175978d2 = {"Lcom/didi/payment/kycservice/key/migrateout/PixKeyMigrateOutActivity;", "Lcom/didi/payment/commonsdk/ui/WBaseActivity;", "Lcom/didi/payment/kycservice/key/migrateout/vm/PixKeyMigrateOutVM;", "()V", "ivBack", "Landroid/view/View;", "toolbarContainer", "Landroid/widget/LinearLayout;", "getTitleBarView", "initListener", "", "initView", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "subscribeUi", "vm", "kyc-service_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: PixKeyMigrateOutActivity.kt */
public final class PixKeyMigrateOutActivity extends WBaseActivity<PixKeyMigrateOutVM> {

    /* renamed from: a */
    private LinearLayout f30716a;

    /* renamed from: b */
    private View f30717b;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_pix_key_migrate_out_new);
        m21588a();
        m21592b();
        ViewModel viewModel = new ViewModelProvider(this).get(PixKeyMigrateOutVM.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this).…MigrateOutVM::class.java)");
        setVm((WBaseViewModel) viewModel);
        subscribeUi((PixKeyMigrateOutVM) getVm());
    }

    /* renamed from: a */
    private final void m21588a() {
        View findViewById = findViewById(R.id.pix_toolbar);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.pix_toolbar)");
        this.f30716a = (LinearLayout) findViewById;
        View findViewById2 = findViewById(R.id.pix_toolbar_left_back_iv);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.pix_toolbar_left_back_iv)");
        this.f30717b = findViewById2;
        setErrViewContainer((ViewGroup) findViewById(R.id.pix_net_error_container));
    }

    /* renamed from: b */
    private final void m21592b() {
        View view = this.f30717b;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivBack");
            view = null;
        }
        view.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                PixKeyMigrateOutActivity.m21589a(PixKeyMigrateOutActivity.this, view);
            }
        });
        ViewGroup errViewContainer = getErrViewContainer();
        if (errViewContainer != null) {
            errViewContainer.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    PixKeyMigrateOutActivity.m21593b(PixKeyMigrateOutActivity.this, view);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m21589a(PixKeyMigrateOutActivity pixKeyMigrateOutActivity, View view) {
        Intrinsics.checkNotNullParameter(pixKeyMigrateOutActivity, "this$0");
        pixKeyMigrateOutActivity.onBackPressed();
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static final void m21593b(PixKeyMigrateOutActivity pixKeyMigrateOutActivity, View view) {
        Intrinsics.checkNotNullParameter(pixKeyMigrateOutActivity, "this$0");
        ((PixKeyMigrateOutVM) pixKeyMigrateOutActivity.getVm()).loadData();
    }

    /* access modifiers changed from: protected */
    public View getTitleBarView() {
        LinearLayout linearLayout = this.f30716a;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("toolbarContainer");
            linearLayout = null;
        }
        return linearLayout;
    }

    public void subscribeUi(PixKeyMigrateOutVM pixKeyMigrateOutVM) {
        Intrinsics.checkNotNullParameter(pixKeyMigrateOutVM, "vm");
        super.subscribeUi(pixKeyMigrateOutVM);
        LifecycleOwner lifecycleOwner = this;
        pixKeyMigrateOutVM.getPageSceneLD().observe(lifecycleOwner, new Observer() {
            public final void onChanged(Object obj) {
                PixKeyMigrateOutActivity.m21591a(PixKeyMigrateOutActivity.this, (Integer) obj);
            }
        });
        pixKeyMigrateOutVM.getMigrateOutRespLD().observe(lifecycleOwner, new Observer(pixKeyMigrateOutVM) {
            public final /* synthetic */ PixKeyMigrateOutVM f$1;

            {
                this.f$1 = r2;
            }

            public final void onChanged(Object obj) {
                PixKeyMigrateOutActivity.m21590a(PixKeyMigrateOutActivity.this, this.f$1, (WBaseResp) obj);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m21591a(PixKeyMigrateOutActivity pixKeyMigrateOutActivity, Integer num) {
        Intrinsics.checkNotNullParameter(pixKeyMigrateOutActivity, "this$0");
        LinearLayout linearLayout = null;
        if (num != null && num.intValue() == 100) {
            LinearLayout linearLayout2 = pixKeyMigrateOutActivity.f30716a;
            if (linearLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("toolbarContainer");
            } else {
                linearLayout = linearLayout2;
            }
            linearLayout.setBackgroundColor(Color.parseColor(ColorUtils.DIDI_GREY));
            NFragmentUtils.INSTANCE.replaceFragment(pixKeyMigrateOutActivity, R.id.pix_key_migrate_fragment_container, MigrateOutListFragment.Companion.newInstance());
        } else if (num != null && num.intValue() == 101) {
            LinearLayout linearLayout3 = pixKeyMigrateOutActivity.f30716a;
            if (linearLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("toolbarContainer");
            } else {
                linearLayout = linearLayout3;
            }
            linearLayout.setBackgroundColor(Color.parseColor("#FFFFFF"));
            NFragmentUtils.INSTANCE.replaceFragment(pixKeyMigrateOutActivity, R.id.pix_key_migrate_fragment_container, MigrateOutDetailFragment.Companion.newInstance());
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m21590a(PixKeyMigrateOutActivity pixKeyMigrateOutActivity, PixKeyMigrateOutVM pixKeyMigrateOutVM, WBaseResp wBaseResp) {
        Intrinsics.checkNotNullParameter(pixKeyMigrateOutActivity, "this$0");
        Intrinsics.checkNotNullParameter(pixKeyMigrateOutVM, "$vm");
        if (!TextUtils.isEmpty(wBaseResp.errmsg)) {
            ToastHelper.showLongCompleted((Context) pixKeyMigrateOutActivity, wBaseResp.errmsg);
        }
        pixKeyMigrateOutActivity.onBackPressed();
        pixKeyMigrateOutVM.loadData();
    }

    public void onBackPressed() {
        Integer value = ((PixKeyMigrateOutVM) getVm()).getPageSceneLD().getValue();
        if (value != null && value.intValue() == 101) {
            if (((PixKeyMigrateOutVM) getVm()).isOnlyOneMigratedKey()) {
                super.onBackPressed();
            } else {
                ((PixKeyMigrateOutVM) getVm()).getPageSceneLD().setValue(100);
            }
        } else if (value != null && value.intValue() == 100) {
            super.onBackPressed();
        } else {
            super.onBackPressed();
        }
    }
}
