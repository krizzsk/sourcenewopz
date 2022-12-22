package com.didi.sdk.global.base.p151ui;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.didi.commoninterfacelib.permission.TheOneBaseActivity;
import com.didi.commoninterfacelib.statuslightning.StatusBarLightingCompat;
import com.didi.payment.base.proxy.LoadingProxyHolder;
import com.didi.payment.base.view.PayGlobalLoading;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.global.base.p151ui.BaseVM;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u00032\u00020\u0004B\u0005¢\u0006\u0002\u0010\u0005J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\n\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0014J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0017H\u0002J\u0012\u0010\u0019\u001a\u00020\u00172\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0014J\b\u0010\u001c\u001a\u00020\u0017H\u0014J\b\u0010\u001d\u001a\u00020\u0017H\u0016J\u0015\u0010\u001e\u001a\u00020\u00172\u0006\u0010\f\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0010R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u00028\u0000X.¢\u0006\u0010\n\u0002\u0010\u0011\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u001f"}, mo175978d2 = {"Lcom/didi/sdk/global/base/ui/BaseActivity;", "T", "Lcom/didi/sdk/global/base/ui/BaseVM;", "Lcom/didi/commoninterfacelib/permission/TheOneBaseActivity;", "Landroidx/lifecycle/HasDefaultViewModelProviderFactory;", "()V", "errViewContainer", "Landroid/view/ViewGroup;", "getErrViewContainer", "()Landroid/view/ViewGroup;", "setErrViewContainer", "(Landroid/view/ViewGroup;)V", "vm", "getVm", "()Lcom/didi/sdk/global/base/ui/BaseVM;", "setVm", "(Lcom/didi/sdk/global/base/ui/BaseVM;)V", "Lcom/didi/sdk/global/base/ui/BaseVM;", "getDefaultViewModelProviderFactory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "getTitleBarView", "Landroid/view/View;", "hideLoading", "", "initStatusBar", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "showLoading", "subscribeUi", "payment_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.sdk.global.base.ui.BaseActivity */
/* compiled from: BaseActivity.kt */
public abstract class BaseActivity<T extends BaseVM> extends TheOneBaseActivity implements HasDefaultViewModelProviderFactory {

    /* renamed from: a */
    private ViewGroup f36085a;

    /* renamed from: vm */
    protected T f36086vm;

    /* access modifiers changed from: protected */
    public View getTitleBarView() {
        return null;
    }

    /* access modifiers changed from: protected */
    public final T getVm() {
        T t = this.f36086vm;
        if (t != null) {
            return t;
        }
        Intrinsics.throwUninitializedPropertyAccessException("vm");
        return null;
    }

    /* access modifiers changed from: protected */
    public final void setVm(T t) {
        Intrinsics.checkNotNullParameter(t, "<set-?>");
        this.f36086vm = t;
    }

    /* access modifiers changed from: protected */
    public final ViewGroup getErrViewContainer() {
        return this.f36085a;
    }

    /* access modifiers changed from: protected */
    public final void setErrViewContainer(ViewGroup viewGroup) {
        this.f36085a = viewGroup;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        m25498a();
        super.onCreate(bundle);
        LoadingProxyHolder.setProxy(new BaseActivity$onCreate$1(this));
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        LoadingProxyHolder.releaseProxy();
    }

    /* renamed from: a */
    private final void m25498a() {
        setTheme(R.style.GlobalActivityTheme);
        StatusBarLightingCompat.setStatusBarBgLightning(this, true, ContextCompat.getColor(this, R.color.transparent));
    }

    public void showLoading() {
        if (getTitleBarView() != null) {
            PayGlobalLoading.show(getTitleBarView(), true);
        }
    }

    public void hideLoading() {
        if (getTitleBarView() != null) {
            PayGlobalLoading.hide(getTitleBarView());
        }
    }

    public void subscribeUi(T t) {
        Intrinsics.checkNotNullParameter(t, "vm");
        LifecycleOwner lifecycleOwner = this;
        t.isLoadingLD().observe(lifecycleOwner, new Observer() {
            public final void onChanged(Object obj) {
                BaseActivity.m25499a(BaseActivity.this, (Boolean) obj);
            }
        });
        t.isNetErrorLD().observe(lifecycleOwner, new Observer() {
            public final void onChanged(Object obj) {
                BaseActivity.m25500b(BaseActivity.this, (Boolean) obj);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m25499a(BaseActivity baseActivity, Boolean bool) {
        Intrinsics.checkNotNullParameter(baseActivity, "this$0");
        Intrinsics.checkNotNullExpressionValue(bool, "isLoading");
        if (bool.booleanValue()) {
            baseActivity.showLoading();
        } else {
            baseActivity.hideLoading();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static final void m25500b(BaseActivity baseActivity, Boolean bool) {
        Intrinsics.checkNotNullParameter(baseActivity, "this$0");
        ViewGroup errViewContainer = baseActivity.getErrViewContainer();
        if (errViewContainer != null) {
            Intrinsics.checkNotNullExpressionValue(bool, "isNetError");
            errViewContainer.setVisibility(bool.booleanValue() ? 0 : 8);
        }
    }

    public ViewModelProvider.Factory getDefaultViewModelProviderFactory() {
        return new ViewModelProvider.AndroidViewModelFactory(getApplication());
    }
}
