package com.didi.payment.kycservice.module;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import androidx.lifecycle.LifecycleObserver;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0003\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0017\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B\u001f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fB\r\u0012\u0006\u0010\r\u001a\u00020\u0004¢\u0006\u0002\u0010\u000eJ\u0015\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u0017R\u000e\u0010\r\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u00020\tX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u0018"}, mo175978d2 = {"Lcom/didi/payment/kycservice/module/BaseModule;", "T", "Landroidx/lifecycle/LifecycleObserver;", "pContext", "Landroid/content/Context;", "pViewStub", "Landroid/view/ViewStub;", "(Landroid/content/Context;Landroid/view/ViewStub;)V", "pParentView", "Landroid/view/ViewGroup;", "pResId", "", "(Landroid/content/Context;Landroid/view/ViewGroup;I)V", "mContext", "(Landroid/content/Context;)V", "mRootView", "getMRootView", "()Landroid/view/ViewGroup;", "setMRootView", "(Landroid/view/ViewGroup;)V", "bindData", "", "data", "(Ljava/lang/Object;)V", "kyc-service_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: BaseModule.kt */
public abstract class BaseModule<T> implements LifecycleObserver {

    /* renamed from: a */
    private final Context f30900a;
    protected ViewGroup mRootView;

    public abstract void bindData(T t);

    public BaseModule(Context context) {
        Intrinsics.checkNotNullParameter(context, "mContext");
        this.f30900a = context;
    }

    /* access modifiers changed from: protected */
    public final ViewGroup getMRootView() {
        ViewGroup viewGroup = this.mRootView;
        if (viewGroup != null) {
            return viewGroup;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mRootView");
        return null;
    }

    /* access modifiers changed from: protected */
    public final void setMRootView(ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(viewGroup, "<set-?>");
        this.mRootView = viewGroup;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public BaseModule(Context context, ViewStub viewStub) {
        this(context);
        Intrinsics.checkNotNullParameter(context, "pContext");
        Intrinsics.checkNotNullParameter(viewStub, "pViewStub");
        View inflate = viewStub.inflate();
        if (inflate != null) {
            setMRootView((ViewGroup) inflate);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public BaseModule(Context context, ViewGroup viewGroup, int i) {
        this(context);
        Intrinsics.checkNotNullParameter(context, "pContext");
        Intrinsics.checkNotNullParameter(viewGroup, "pParentView");
        View inflate = LayoutInflater.from(this.f30900a).inflate(i, viewGroup);
        if (inflate != null) {
            setMRootView((ViewGroup) inflate);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    }
}
