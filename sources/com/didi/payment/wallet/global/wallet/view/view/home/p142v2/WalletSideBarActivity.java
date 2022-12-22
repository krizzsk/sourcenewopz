package com.didi.payment.wallet.global.wallet.view.view.home.p142v2;

import android.content.Intent;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import com.didi.commoninterfacelib.statuslightning.StatusBarLightingCompat;
import com.didi.payment.base.utils.PayBaseConfigUtil;
import com.didi.payment.wallet.global.wallet.contract.WalletHomeContract;
import com.didi.payment.wallet.global.wallet.view.view.home.p142v2.popmgr.WHomePopChain;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0002J\b\u0010\u000b\u001a\u00020\nH\u0002J\u0012\u0010\f\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0014J\b\u0010\u000f\u001a\u00020\nH\u0014J\u0012\u0010\u0010\u001a\u00020\n2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0014J\b\u0010\u0013\u001a\u00020\nH\u0014J\b\u0010\u0014\u001a\u00020\nH\u0014J\b\u0010\u0015\u001a\u00020\nH\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, mo175978d2 = {"Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/WalletSideBarActivity;", "Landroidx/fragment/app/FragmentActivity;", "()V", "isNewIntent", "", "mPresenter", "Lcom/didi/payment/wallet/global/wallet/contract/WalletHomeContract$Presenter;", "mView", "Lcom/didi/payment/wallet/global/wallet/contract/WalletHomeContract$V2View;", "forbidScreenShot", "", "initStatusBar", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onNewIntent", "intent", "Landroid/content/Intent;", "onResume", "onStart", "onStop", "wallet_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.payment.wallet.global.wallet.view.view.home.v2.WalletSideBarActivity */
/* compiled from: WalletSideBarActivity.kt */
public final class WalletSideBarActivity extends FragmentActivity {

    /* renamed from: a */
    private WalletHomeContract.Presenter f32665a;

    /* renamed from: b */
    private WalletHomeContract.V2View f32666b;

    /* renamed from: c */
    private boolean f32667c;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        m23114b();
        super.onCreate(bundle);
        WalletHomeContract.V2View walletHomePage = new WalletHomePage(this, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        this.f32666b = walletHomePage;
        if (walletHomePage != null) {
            setContentView((View) (WalletHomePage) walletHomePage);
            m23112a();
            WalletHomeContract.Presenter walletHomeV2Presenter = new WalletHomeV2Presenter(this, this.f32666b, "1");
            this.f32665a = walletHomeV2Presenter;
            if (walletHomeV2Presenter != null) {
                walletHomeV2Presenter.init();
            }
            WalletHomeContract.V2View v2View = this.f32666b;
            if (v2View != null) {
                WalletHomePage walletHomePage2 = (WalletHomePage) v2View;
                WalletHomePage.setPagePaddingBottom$default(walletHomePage2, 0.0f, 1, (Object) null);
                walletHomePage2.showBackButton(true, new View.OnClickListener() {
                    public final void onClick(View view) {
                        WalletSideBarActivity.m23113a(WalletSideBarActivity.this, view);
                    }
                });
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type com.didi.payment.wallet.global.wallet.view.view.home.v2.WalletHomePage");
        }
        throw new NullPointerException("null cannot be cast to non-null type com.didi.payment.wallet.global.wallet.view.view.home.v2.WalletHomePage");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m23113a(WalletSideBarActivity walletSideBarActivity, View view) {
        Intrinsics.checkNotNullParameter(walletSideBarActivity, "this$0");
        walletSideBarActivity.onBackPressed();
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        WHomePopChain.INSTANCE.addTask(300).start(this, 300);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        WalletHomeContract.Presenter presenter;
        super.onResume();
        WalletHomeContract.Presenter presenter2 = this.f32665a;
        if (presenter2 != null) {
            presenter2.onResume();
        }
        if (!this.f32667c && (presenter = this.f32665a) != null) {
            presenter.requestDataIfNeeded();
        }
        WalletHomeContract.Presenter presenter3 = this.f32665a;
        if (presenter3 != null) {
            presenter3.checkQRCode("");
        }
        WHomePopChain.INSTANCE.setHomeVisible(true);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        WalletHomeContract.Presenter presenter = this.f32665a;
        if (presenter != null) {
            presenter.onDestroy();
        }
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        WHomePopChain.INSTANCE.setHomeVisible(false);
    }

    /* access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        this.f32667c = true;
        WalletHomeContract.Presenter presenter = this.f32665a;
        if (presenter != null) {
            presenter.requestDataIfNeeded();
        }
    }

    /* renamed from: a */
    private final void m23112a() {
        if (!PayBaseConfigUtil.isDebugMode()) {
            getWindow().setFlags(8192, 8192);
        }
    }

    /* renamed from: b */
    private final void m23114b() {
        setTheme(R.style.GlobalActivity50);
        StatusBarLightingCompat.setStatusBarBgLightning(this, true, ContextCompat.getColor(this, R.color.transparent));
    }
}
