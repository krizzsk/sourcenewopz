package com.didi.sdk.global.sign.payselect.module;

import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import com.didi.sdk.global.base.module.BizModule;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \u00152\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0015\u0016B\u001f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\bH\u0016J\b\u0010\u0014\u001a\u00020\u0011H\u0016R\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0017"}, mo175978d2 = {"Lcom/didi/sdk/global/sign/payselect/module/ShowMoreItemModule;", "Lcom/didi/sdk/global/base/module/BizModule;", "", "activity", "Landroidx/fragment/app/FragmentActivity;", "parentView", "Landroid/view/ViewGroup;", "resId", "", "(Landroidx/fragment/app/FragmentActivity;Landroid/view/ViewGroup;I)V", "onItemClickListener", "Lcom/didi/sdk/global/sign/payselect/module/ShowMoreItemModule$OnItemClickListener;", "getOnItemClickListener", "()Lcom/didi/sdk/global/sign/payselect/module/ShowMoreItemModule$OnItemClickListener;", "setOnItemClickListener", "(Lcom/didi/sdk/global/sign/payselect/module/ShowMoreItemModule$OnItemClickListener;)V", "bindData", "", "data", "type", "initView", "Companion", "OnItemClickListener", "payment_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: ShowMoreItemModule.kt */
public final class ShowMoreItemModule extends BizModule<Object> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static boolean f36276b;

    /* renamed from: a */
    private OnItemClickListener f36277a;

    @Metadata(mo175977d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, mo175978d2 = {"Lcom/didi/sdk/global/sign/payselect/module/ShowMoreItemModule$OnItemClickListener;", "", "expendAll", "", "payment_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: ShowMoreItemModule.kt */
    public interface OnItemClickListener {
        void expendAll();
    }

    public void bindData(Object obj, int i) {
        Intrinsics.checkNotNullParameter(obj, "data");
    }

    @Metadata(mo175977d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rR\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u0006\u000e"}, mo175978d2 = {"Lcom/didi/sdk/global/sign/payselect/module/ShowMoreItemModule$Companion;", "", "()V", "isExpend", "", "()Z", "setExpend", "(Z)V", "create", "Lcom/didi/sdk/global/sign/payselect/module/ShowMoreItemModule;", "activity", "Landroidx/fragment/app/FragmentActivity;", "parentView", "Landroid/view/ViewGroup;", "payment_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: ShowMoreItemModule.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ShowMoreItemModule create(FragmentActivity fragmentActivity, ViewGroup viewGroup) {
            Intrinsics.checkNotNullParameter(fragmentActivity, "activity");
            Intrinsics.checkNotNullParameter(viewGroup, "parentView");
            return new ShowMoreItemModule(fragmentActivity, viewGroup, R.layout.payment_paysel_show_more);
        }

        public final boolean isExpend() {
            return ShowMoreItemModule.f36276b;
        }

        public final void setExpend(boolean z) {
            ShowMoreItemModule.f36276b = z;
        }
    }

    public final OnItemClickListener getOnItemClickListener() {
        return this.f36277a;
    }

    public final void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.f36277a = onItemClickListener;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ShowMoreItemModule(FragmentActivity fragmentActivity, ViewGroup viewGroup, int i) {
        super(fragmentActivity, viewGroup, i, fragmentActivity, fragmentActivity);
        Intrinsics.checkNotNullParameter(fragmentActivity, "activity");
        Intrinsics.checkNotNullParameter(viewGroup, "parentView");
    }

    public void initView() {
        getRootView().setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                ShowMoreItemModule.m25657a(ShowMoreItemModule.this, view);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m25657a(ShowMoreItemModule showMoreItemModule, View view) {
        Intrinsics.checkNotNullParameter(showMoreItemModule, "this$0");
        f36276b = !f36276b;
        OnItemClickListener onItemClickListener = showMoreItemModule.getOnItemClickListener();
        if (onItemClickListener != null) {
            onItemClickListener.expendAll();
        }
    }
}
