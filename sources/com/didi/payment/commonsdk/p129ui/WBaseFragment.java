package com.didi.payment.commonsdk.p129ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.didi.commoninterfacelib.permission.TheOneBaseFragment;
import com.didi.payment.base.view.PayGlobalLoading;
import com.didi.payment.commonsdk.p129ui.WBaseViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u00032\u00020\u0004B\u0005¢\u0006\u0002\u0010\u0005J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\n\u0010\u001c\u001a\u0004\u0018\u00010\rH$J\b\u0010\u001d\u001a\u00020\u001eH\u0016J\b\u0010\u001f\u001a\u00020\u0019H\u0016J\b\u0010 \u001a\u00020\u001eH\u0016J&\u0010!\u001a\u0004\u0018\u00010\r2\u0006\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010\u00072\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\b\u0010'\u001a\u00020(H\u0016J\u001a\u0010)\u001a\u00020\u001e2\u0006\u0010*\u001a\u00020\r2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\b\u0010+\u001a\u00020\u001eH\u0016J\u0015\u0010,\u001a\u00020\u001e2\u0006\u0010\u0012\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0016R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u00028\u0000X.¢\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006-"}, mo175978d2 = {"Lcom/didi/payment/commonsdk/ui/WBaseFragment;", "T", "Lcom/didi/payment/commonsdk/ui/WBaseViewModel;", "Lcom/didi/commoninterfacelib/permission/TheOneBaseFragment;", "Landroidx/lifecycle/HasDefaultViewModelProviderFactory;", "()V", "errViewContainer", "Landroid/view/ViewGroup;", "getErrViewContainer", "()Landroid/view/ViewGroup;", "setErrViewContainer", "(Landroid/view/ViewGroup;)V", "mRootView", "Landroid/view/View;", "getMRootView", "()Landroid/view/View;", "setMRootView", "(Landroid/view/View;)V", "vm", "getVm", "()Lcom/didi/payment/commonsdk/ui/WBaseViewModel;", "setVm", "(Lcom/didi/payment/commonsdk/ui/WBaseViewModel;)V", "Lcom/didi/payment/commonsdk/ui/WBaseViewModel;", "customErrorUI", "", "getDefaultViewModelProviderFactory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "getTitleBarView", "hideLoading", "", "onBackKeyPressed", "onBackToFront", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "savedInstanceState", "Landroid/os/Bundle;", "onInflateLayout", "", "onViewCreated", "view", "showLoading", "subscribeUi", "wallet-service-commonsdk_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.payment.commonsdk.ui.WBaseFragment */
/* compiled from: WBaseFragment.kt */
public abstract class WBaseFragment<T extends WBaseViewModel> extends TheOneBaseFragment implements HasDefaultViewModelProviderFactory {

    /* renamed from: a */
    private ViewGroup f30178a;
    protected View mRootView;

    /* renamed from: vm */
    protected T f30179vm;

    public boolean customErrorUI() {
        return false;
    }

    /* access modifiers changed from: protected */
    public abstract View getTitleBarView();

    public boolean onBackKeyPressed() {
        return false;
    }

    public void onBackToFront() {
    }

    public int onInflateLayout() {
        return -1;
    }

    /* access modifiers changed from: protected */
    public final View getMRootView() {
        View view = this.mRootView;
        if (view != null) {
            return view;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mRootView");
        return null;
    }

    /* access modifiers changed from: protected */
    public final void setMRootView(View view) {
        Intrinsics.checkNotNullParameter(view, "<set-?>");
        this.mRootView = view;
    }

    /* access modifiers changed from: protected */
    public final ViewGroup getErrViewContainer() {
        return this.f30178a;
    }

    /* access modifiers changed from: protected */
    public final void setErrViewContainer(ViewGroup viewGroup) {
        this.f30178a = viewGroup;
    }

    /* access modifiers changed from: protected */
    public final T getVm() {
        T t = this.f30179vm;
        if (t != null) {
            return t;
        }
        Intrinsics.throwUninitializedPropertyAccessException("vm");
        return null;
    }

    /* access modifiers changed from: protected */
    public final void setVm(T t) {
        Intrinsics.checkNotNullParameter(t, "<set-?>");
        this.f30179vm = t;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
    }

    public void subscribeUi(T t) {
        Intrinsics.checkNotNullParameter(t, "vm");
        t.isLoading().observe(getViewLifecycleOwner(), new Observer() {
            public final void onChanged(Object obj) {
                WBaseFragment.m21130a(WBaseFragment.this, (Boolean) obj);
            }
        });
        t.isNetError().observe(getViewLifecycleOwner(), new Observer() {
            public final void onChanged(Object obj) {
                WBaseFragment.m21131b(WBaseFragment.this, (Boolean) obj);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m21130a(WBaseFragment wBaseFragment, Boolean bool) {
        Intrinsics.checkNotNullParameter(wBaseFragment, "this$0");
        Intrinsics.checkNotNullExpressionValue(bool, "isLoading");
        if (bool.booleanValue()) {
            wBaseFragment.showLoading();
        } else {
            wBaseFragment.hideLoading();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static final void m21131b(WBaseFragment wBaseFragment, Boolean bool) {
        Intrinsics.checkNotNullParameter(wBaseFragment, "this$0");
        ViewGroup errViewContainer = wBaseFragment.getErrViewContainer();
        if (errViewContainer != null) {
            Intrinsics.checkNotNullExpressionValue(bool, "isNetError");
            errViewContainer.setVisibility((!bool.booleanValue() || wBaseFragment.customErrorUI()) ? 8 : 0);
        }
    }

    public void showLoading() {
        if (getActivity() != null && getTitleBarView() != null) {
            PayGlobalLoading.show(getTitleBarView(), true);
        }
    }

    public void hideLoading() {
        if (getActivity() != null && getTitleBarView() != null) {
            PayGlobalLoading.hide(getTitleBarView());
        }
    }

    public ViewModelProvider.Factory getDefaultViewModelProviderFactory() {
        return new ViewModelProvider.AndroidViewModelFactory(requireActivity().getApplication());
    }
}
