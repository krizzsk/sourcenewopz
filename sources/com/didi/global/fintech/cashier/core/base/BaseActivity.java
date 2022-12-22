package com.didi.global.fintech.cashier.core.base;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.didi.commoninterfacelib.statuslightning.StatusBarLightingCompat;
import com.didi.global.fintech.cashier.core.contract.IGlobalCashierBasePresenter;
import com.didi.global.fintech.cashier.core.contract.IGlobalCashierBaseView;
import com.didi.global.fintech.cashier.core.contract.IView;
import com.didi.global.fintech.cashier.core.utils.ThemeManager;
import com.didi.global.fintech.cashier.user.facade.CashierConfigurationProxy;
import com.didi.global.fintech.cashier.user.facade.CashierFacade;
import com.didi.sdk.apm.SystemUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u00042\u00020\u0005B\u0005¢\u0006\u0002\u0010\u0006J\u0012\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0014J\u000f\u0010\u0017\u001a\u0004\u0018\u00018\u0000H&¢\u0006\u0002\u0010\tJ\u000f\u0010\u0018\u001a\u0004\u0018\u00018\u0001H&¢\u0006\u0002\u0010\u000fJ\b\u0010\u0019\u001a\u00020\u0014H\u0016J\b\u0010\u001a\u001a\u00020\u001bH'J\u0012\u0010\u001c\u001a\u00020\u00142\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0014J\b\u0010\u001f\u001a\u00020\u0014H&J\b\u0010 \u001a\u00020\u0014H&J\b\u0010!\u001a\u00020\u0014H\u0016J\b\u0010\"\u001a\u00020#H\u0016R\u001e\u0010\u0007\u001a\u0004\u0018\u00018\u0000X\u000e¢\u0006\u0010\n\u0002\u0010\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001e\u0010\r\u001a\u0004\u0018\u00018\u0001X\u000e¢\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006$"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/core/base/BaseActivity;", "P", "Lcom/didi/global/fintech/cashier/core/contract/IGlobalCashierBasePresenter;", "V", "Lcom/didi/global/fintech/cashier/core/contract/IGlobalCashierBaseView;", "Landroidx/fragment/app/FragmentActivity;", "()V", "mPresenter", "getMPresenter", "()Lcom/didi/global/fintech/cashier/core/contract/IGlobalCashierBasePresenter;", "setMPresenter", "(Lcom/didi/global/fintech/cashier/core/contract/IGlobalCashierBasePresenter;)V", "Lcom/didi/global/fintech/cashier/core/contract/IGlobalCashierBasePresenter;", "mView", "getMView", "()Lcom/didi/global/fintech/cashier/core/contract/IGlobalCashierBaseView;", "setMView", "(Lcom/didi/global/fintech/cashier/core/contract/IGlobalCashierBaseView;)V", "Lcom/didi/global/fintech/cashier/core/contract/IGlobalCashierBaseView;", "attachBaseContext", "", "newBase", "Landroid/content/Context;", "getPresenter", "getView", "initTheme", "layoutRes", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onParamInit", "onPresenterCreated", "onViewCreated", "statusBarTextColorDark", "", "cashier_core_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: BaseActivity.kt */
public abstract class BaseActivity<P extends IGlobalCashierBasePresenter, V extends IGlobalCashierBaseView> extends FragmentActivity {

    /* renamed from: a */
    private P f21423a;

    /* renamed from: b */
    private V f21424b;

    public abstract P getPresenter();

    public abstract V getView();

    public abstract int layoutRes();

    public abstract void onParamInit();

    public abstract void onPresenterCreated();

    public boolean statusBarTextColorDark() {
        return true;
    }

    /* access modifiers changed from: protected */
    public final P getMPresenter() {
        return this.f21423a;
    }

    /* access modifiers changed from: protected */
    public final void setMPresenter(P p) {
        this.f21423a = p;
    }

    /* access modifiers changed from: protected */
    public final V getMView() {
        return this.f21424b;
    }

    /* access modifiers changed from: protected */
    public final void setMView(V v) {
        this.f21424b = v;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        if (bundle != null) {
            bundle.clear();
        }
        initTheme();
        StatusBarLightingCompat.setStatusBarBgLightning(this, statusBarTextColorDark(), 17170445);
        super.onCreate(bundle);
        setContentView(layoutRes());
        onParamInit();
        onViewCreated();
    }

    public void onViewCreated() {
        SystemUtils.log(4, "Arirus", Intrinsics.stringPlus(getClass().getSimpleName(), " onViewCreated: Start"), (Throwable) null, "com.didi.global.fintech.cashier.core.base.BaseActivity", 41);
        this.f21423a = getPresenter();
        this.f21424b = getView();
        onPresenterCreated();
        P p = this.f21423a;
        if (p != null) {
            p.bindView((IView) this.f21424b);
        }
        SystemUtils.log(4, "Arirus", "BaseActivity onViewCreated: Finish", (Throwable) null, "com.didi.global.fintech.cashier.core.base.BaseActivity", 46);
    }

    public void initTheme() {
        ThemeManager.INSTANCE.initTheme(this);
    }

    /* access modifiers changed from: protected */
    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        CashierConfigurationProxy configurationProxy = CashierFacade.Companion.getInstance().getConfigurationProxy();
        if (configurationProxy != null) {
            configurationProxy.updateConfiguration(context);
        }
    }
}
