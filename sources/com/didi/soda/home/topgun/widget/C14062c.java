package com.didi.soda.home.topgun.widget;

import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B'\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0004J\u000e\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0010R\u001d\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, mo175978d2 = {"Lcom/didi/soda/home/topgun/widget/OffsetHelper;", "", "getHeaderHeight", "Lkotlin/Function0;", "", "block", "Lkotlin/Function1;", "", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)V", "getBlock", "()Lkotlin/jvm/functions/Function1;", "getGetHeaderHeight", "()Lkotlin/jvm/functions/Function0;", "offset", "acceptRefreshAnchor", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "acceptRefreshOffset", "ofs", "attachRecycleView", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.soda.home.topgun.widget.c */
/* compiled from: FeedHeaderLayout.kt */
final class C14062c {

    /* renamed from: a */
    private final Function0<Integer> f43223a;

    /* renamed from: b */
    private final Function1<Integer, Unit> f43224b;

    /* renamed from: c */
    private int f43225c;

    public C14062c(Function0<Integer> function0, Function1<? super Integer, Unit> function1) {
        Intrinsics.checkNotNullParameter(function0, "getHeaderHeight");
        Intrinsics.checkNotNullParameter(function1, "block");
        this.f43223a = function0;
        this.f43224b = function1;
    }

    /* renamed from: a */
    public final Function0<Integer> mo108148a() {
        return this.f43223a;
    }

    /* renamed from: b */
    public final Function1<Integer, Unit> mo108151b() {
        return this.f43224b;
    }

    /* renamed from: a */
    public final void mo108150a(RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        recyclerView.addOnScrollListener(new OffsetHelper$attachRecycleView$1(this));
    }

    /* renamed from: b */
    public final void mo108152b(RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        this.f43224b.invoke(Integer.valueOf(recyclerView.computeVerticalScrollOffset()));
    }

    /* renamed from: a */
    public final void mo108149a(int i) {
        int i2 = -i;
        this.f43225c = i2;
        this.f43224b.invoke(Integer.valueOf(i2));
    }
}
