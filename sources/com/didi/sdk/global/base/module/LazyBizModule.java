package com.didi.sdk.global.base.module;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelStoreOwner;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B'\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bB\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\fJ\u0006\u0010\u0011\u001a\u00020\u0012J\u0006\u0010\u0013\u001a\u00020\u0014J\u0010\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\bH\u0016R\u001a\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0017"}, mo175978d2 = {"Lcom/didi/sdk/global/base/module/LazyBizModule;", "T", "Lcom/didi/sdk/global/base/module/BizModule;", "context", "Landroid/content/Context;", "viewStub", "Landroid/view/ViewStub;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "viewModelStoreOwner", "Landroidx/lifecycle/ViewModelStoreOwner;", "(Landroid/content/Context;Landroid/view/ViewStub;Landroidx/lifecycle/LifecycleOwner;Landroidx/lifecycle/ViewModelStoreOwner;)V", "(Landroid/content/Context;Landroidx/lifecycle/LifecycleOwner;Landroidx/lifecycle/ViewModelStoreOwner;)V", "getViewStub", "()Landroid/view/ViewStub;", "setViewStub", "(Landroid/view/ViewStub;)V", "inflateViewStub", "", "isInflatedViewStub", "", "onCreate", "owner", "payment_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: LazyBizModule.kt */
public abstract class LazyBizModule<T> extends BizModule<T> {
    protected ViewStub viewStub;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LazyBizModule(Context context, LifecycleOwner lifecycleOwner, ViewModelStoreOwner viewModelStoreOwner) {
        super(context, lifecycleOwner, viewModelStoreOwner);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(viewModelStoreOwner, "viewModelStoreOwner");
    }

    /* access modifiers changed from: protected */
    public final ViewStub getViewStub() {
        ViewStub viewStub2 = this.viewStub;
        if (viewStub2 != null) {
            return viewStub2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("viewStub");
        return null;
    }

    /* access modifiers changed from: protected */
    public final void setViewStub(ViewStub viewStub2) {
        Intrinsics.checkNotNullParameter(viewStub2, "<set-?>");
        this.viewStub = viewStub2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public LazyBizModule(Context context, ViewStub viewStub2, LifecycleOwner lifecycleOwner, ViewModelStoreOwner viewModelStoreOwner) {
        this(context, lifecycleOwner, viewModelStoreOwner);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(viewStub2, "viewStub");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(viewModelStoreOwner, "viewModelStoreOwner");
        setViewStub(viewStub2);
        attach();
    }

    public final boolean isInflatedViewStub() {
        return getViewStub().getParent() == null;
    }

    public final void inflateViewStub() {
        if (getViewStub().getParent() != null) {
            View inflate = getViewStub().inflate();
            if (inflate != null) {
                setRootView((ViewGroup) inflate);
                initView();
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
        }
    }

    public void onCreate(LifecycleOwner lifecycleOwner) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "owner");
        super.onCreate(lifecycleOwner);
    }
}
