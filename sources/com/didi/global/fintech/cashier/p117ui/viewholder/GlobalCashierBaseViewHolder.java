package com.didi.global.fintech.cashier.p117ui.viewholder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.didi.global.fintech.cashier.p117ui.IGlobalCashierBaseViewHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b&\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u0018J\u0006\u0010\u0019\u001a\u00020\u0016J!\u0010\u001a\u001a\u0002H\u001b\"\b\b\u0000\u0010\u001b*\u00020\u00102\b\b\u0001\u0010\u001c\u001a\u00020\u0018H\u0004¢\u0006\u0002\u0010\u001dJ\b\u0010\u001e\u001a\u00020\u0016H\u0016J\u0010\u0010\u001f\u001a\u00020\u00162\u0006\u0010 \u001a\u00020\bH\u0016R\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006!"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/ui/viewholder/GlobalCashierBaseViewHolder;", "Lcom/didi/global/fintech/cashier/ui/IGlobalCashierBaseViewHolder;", "context", "Landroid/content/Context;", "parent", "Landroid/view/ViewGroup;", "(Landroid/content/Context;Landroid/view/ViewGroup;)V", "attached", "", "getAttached", "()Z", "setAttached", "(Z)V", "getContext", "()Landroid/content/Context;", "mRootView", "Landroid/view/View;", "getMRootView", "()Landroid/view/View;", "getParent", "()Landroid/view/ViewGroup;", "attach", "", "index", "", "detach", "getView", "T", "id", "(I)Landroid/view/View;", "initView", "updateVisible", "visible", "cashier_ui_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.global.fintech.cashier.ui.viewholder.GlobalCashierBaseViewHolder */
/* compiled from: GlobalCashierBaseViewHolder.kt */
public abstract class GlobalCashierBaseViewHolder implements IGlobalCashierBaseViewHolder {

    /* renamed from: a */
    private final Context f21784a;

    /* renamed from: b */
    private final ViewGroup f21785b;

    /* renamed from: c */
    private final View f21786c;

    /* renamed from: d */
    private boolean f21787d;

    public GlobalCashierBaseViewHolder(Context context, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        this.f21784a = context;
        this.f21785b = viewGroup;
        View inflate = LayoutInflater.from(context).inflate(layout(), this.f21785b, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(context).inflate(layout(), parent, false)");
        this.f21786c = inflate;
        initView();
    }

    public final Context getContext() {
        return this.f21784a;
    }

    /* access modifiers changed from: protected */
    public final ViewGroup getParent() {
        return this.f21785b;
    }

    /* access modifiers changed from: protected */
    public final View getMRootView() {
        return this.f21786c;
    }

    public final boolean getAttached() {
        return this.f21787d;
    }

    public final void setAttached(boolean z) {
        this.f21787d = z;
    }

    /* access modifiers changed from: protected */
    public final <T extends View> T getView(int i) {
        T findViewById = this.f21786c.findViewById(i);
        Intrinsics.checkNotNullExpressionValue(findViewById, "mRootView.findViewById(id)");
        return findViewById;
    }

    public void initView() {
        attach$default(this, 0, 1, (Object) null);
    }

    public final void detach() {
        this.f21785b.removeView(this.f21786c);
        this.f21787d = false;
    }

    public static /* synthetic */ void attach$default(GlobalCashierBaseViewHolder globalCashierBaseViewHolder, int i, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 1) != 0) {
                i = -1;
            }
            globalCashierBaseViewHolder.attach(i);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: attach");
    }

    public final void attach(int i) {
        this.f21785b.addView(this.f21786c, i);
        this.f21787d = true;
    }

    public void updateVisible(boolean z) {
        this.f21786c.setVisibility(z ? 0 : 8);
    }
}
