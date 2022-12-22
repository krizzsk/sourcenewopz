package com.didi.soda.customer.widget.scroll;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\"B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cJ\u0010\u0010\u001d\u001a\u00020\u00182\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fJ\u0018\u0010 \u001a\u00020\u00182\u0006\u0010!\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u0013¨\u0006#"}, mo175978d2 = {"Lcom/didi/soda/customer/widget/scroll/CustomerNavScrollListener;", "", "()V", "callback", "Lcom/didi/soda/customer/widget/scroll/CustomerNavScrollListener$Callback;", "getCallback", "()Lcom/didi/soda/customer/widget/scroll/CustomerNavScrollListener$Callback;", "setCallback", "(Lcom/didi/soda/customer/widget/scroll/CustomerNavScrollListener$Callback;)V", "isActive", "", "()Z", "setActive", "(Z)V", "maxOffset", "", "getMaxOffset", "()I", "setMaxOffset", "(I)V", "overlapHeight", "getOverlapHeight", "setOverlapHeight", "forceScroll", "", "scrolledView", "Landroid/view/View;", "progress", "", "listenRecycleViewScrollEvent", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "viewScroll", "view", "Callback", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CustomerNavScrollListener.kt */
public final class CustomerNavScrollListener {

    /* renamed from: a */
    private boolean f42150a = true;

    /* renamed from: b */
    private int f42151b = 400;

    /* renamed from: c */
    private int f42152c;

    /* renamed from: d */
    private Callback f42153d;

    @Metadata(mo175977d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, mo175978d2 = {"Lcom/didi/soda/customer/widget/scroll/CustomerNavScrollListener$Callback;", "", "onProgressChanged", "", "scrolledView", "Landroid/view/View;", "progress", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: CustomerNavScrollListener.kt */
    public interface Callback {
        void onProgressChanged(View view, float f);
    }

    public final boolean isActive() {
        return this.f42150a;
    }

    public final void setActive(boolean z) {
        this.f42150a = z;
    }

    public final int getMaxOffset() {
        return this.f42151b;
    }

    public final void setMaxOffset(int i) {
        this.f42151b = i;
    }

    public final int getOverlapHeight() {
        return this.f42152c;
    }

    public final void setOverlapHeight(int i) {
        this.f42152c = i;
    }

    public final Callback getCallback() {
        return this.f42153d;
    }

    public final void setCallback(Callback callback) {
        this.f42153d = callback;
    }

    public final void listenRecycleViewScrollEvent(RecyclerView recyclerView) {
        if (recyclerView != null) {
            recyclerView.addOnScrollListener(new C13881xf1ed7938(this));
        }
    }

    public final void forceScroll(View view, float f) {
        Intrinsics.checkNotNullParameter(view, "scrolledView");
        float f2 = 0.0f;
        if (f >= 0.0f) {
            f2 = f;
        }
        if (f > 1.0f) {
            f2 = 1.0f;
        }
        m29720a(view, f2);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m29720a(View view, float f) {
        Callback callback;
        if (this.f42150a && (callback = this.f42153d) != null) {
            callback.onProgressChanged(view, f);
        }
    }
}
