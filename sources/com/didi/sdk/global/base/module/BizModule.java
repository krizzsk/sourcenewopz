package com.didi.sdk.global.base.module;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelStoreOwner;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0002\b\u0007\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B'\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bB/\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u0010B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u0011J\b\u0010\u001d\u001a\u00020\u001eH\u0014J\u001f\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00028\u00002\b\b\u0002\u0010!\u001a\u00020\u000fH&¢\u0006\u0002\u0010\"J\b\u0010#\u001a\u00020\u001eH\u0016J\b\u0010$\u001a\u00020\u001eH&R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\rX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c¨\u0006%"}, mo175978d2 = {"Lcom/didi/sdk/global/base/module/BizModule;", "T", "Landroidx/lifecycle/DefaultLifecycleObserver;", "context", "Landroid/content/Context;", "viewStub", "Landroid/view/ViewStub;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "viewModelStoreOwner", "Landroidx/lifecycle/ViewModelStoreOwner;", "(Landroid/content/Context;Landroid/view/ViewStub;Landroidx/lifecycle/LifecycleOwner;Landroidx/lifecycle/ViewModelStoreOwner;)V", "parentView", "Landroid/view/ViewGroup;", "resId", "", "(Landroid/content/Context;Landroid/view/ViewGroup;ILandroidx/lifecycle/LifecycleOwner;Landroidx/lifecycle/ViewModelStoreOwner;)V", "(Landroid/content/Context;Landroidx/lifecycle/LifecycleOwner;Landroidx/lifecycle/ViewModelStoreOwner;)V", "getContext", "()Landroid/content/Context;", "getLifecycleOwner", "()Landroidx/lifecycle/LifecycleOwner;", "rootView", "getRootView", "()Landroid/view/ViewGroup;", "setRootView", "(Landroid/view/ViewGroup;)V", "getViewModelStoreOwner", "()Landroidx/lifecycle/ViewModelStoreOwner;", "attach", "", "bindData", "data", "type", "(Ljava/lang/Object;I)V", "detach", "initView", "payment_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: BizModule.kt */
public abstract class BizModule<T> implements DefaultLifecycleObserver {

    /* renamed from: a */
    private final Context f36082a;

    /* renamed from: b */
    private final LifecycleOwner f36083b;

    /* renamed from: c */
    private final ViewModelStoreOwner f36084c;
    protected ViewGroup rootView;

    public abstract void bindData(T t, int i);

    public abstract void initView();

    public /* synthetic */ void onCreate(LifecycleOwner lifecycleOwner) {
        DefaultLifecycleObserver.CC.$default$onCreate(this, lifecycleOwner);
    }

    public /* synthetic */ void onDestroy(LifecycleOwner lifecycleOwner) {
        DefaultLifecycleObserver.CC.$default$onDestroy(this, lifecycleOwner);
    }

    public /* synthetic */ void onPause(LifecycleOwner lifecycleOwner) {
        DefaultLifecycleObserver.CC.$default$onPause(this, lifecycleOwner);
    }

    public /* synthetic */ void onResume(LifecycleOwner lifecycleOwner) {
        DefaultLifecycleObserver.CC.$default$onResume(this, lifecycleOwner);
    }

    public /* synthetic */ void onStart(LifecycleOwner lifecycleOwner) {
        DefaultLifecycleObserver.CC.$default$onStart(this, lifecycleOwner);
    }

    public /* synthetic */ void onStop(LifecycleOwner lifecycleOwner) {
        DefaultLifecycleObserver.CC.$default$onStop(this, lifecycleOwner);
    }

    public BizModule(Context context, LifecycleOwner lifecycleOwner, ViewModelStoreOwner viewModelStoreOwner) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(viewModelStoreOwner, "viewModelStoreOwner");
        this.f36082a = context;
        this.f36083b = lifecycleOwner;
        this.f36084c = viewModelStoreOwner;
    }

    public final Context getContext() {
        return this.f36082a;
    }

    public final LifecycleOwner getLifecycleOwner() {
        return this.f36083b;
    }

    public final ViewModelStoreOwner getViewModelStoreOwner() {
        return this.f36084c;
    }

    /* access modifiers changed from: protected */
    public final ViewGroup getRootView() {
        ViewGroup viewGroup = this.rootView;
        if (viewGroup != null) {
            return viewGroup;
        }
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
        return null;
    }

    /* access modifiers changed from: protected */
    public final void setRootView(ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(viewGroup, "<set-?>");
        this.rootView = viewGroup;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public BizModule(Context context, ViewStub viewStub, LifecycleOwner lifecycleOwner, ViewModelStoreOwner viewModelStoreOwner) {
        this(context, lifecycleOwner, viewModelStoreOwner);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(viewStub, "viewStub");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(viewModelStoreOwner, "viewModelStoreOwner");
        View inflate = viewStub.inflate();
        if (inflate != null) {
            setRootView((ViewGroup) inflate);
            initView();
            attach();
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public BizModule(Context context, ViewGroup viewGroup, int i, LifecycleOwner lifecycleOwner, ViewModelStoreOwner viewModelStoreOwner) {
        this(context, lifecycleOwner, viewModelStoreOwner);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(viewGroup, "parentView");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(viewModelStoreOwner, "viewModelStoreOwner");
        View inflate = LayoutInflater.from(context).inflate(i, viewGroup, false);
        if (inflate != null) {
            setRootView((ViewGroup) inflate);
            viewGroup.addView(getRootView());
            initView();
            attach();
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    }

    /* access modifiers changed from: protected */
    public void attach() {
        this.f36083b.getLifecycle().addObserver(this);
    }

    public void detach() {
        this.f36083b.getLifecycle().removeObserver(this);
    }

    public static /* synthetic */ void bindData$default(BizModule bizModule, Object obj, int i, int i2, Object obj2) {
        if (obj2 == null) {
            if ((i2 & 2) != 0) {
                i = 0;
            }
            bizModule.bindData(obj, i);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: bindData");
    }
}
