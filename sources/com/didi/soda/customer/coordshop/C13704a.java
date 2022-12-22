package com.didi.soda.customer.coordshop;

import android.util.Range;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u000e\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR(\u0010\t\u001a\u0010\u0012\f\u0012\n \f*\u0004\u0018\u00010\u000b0\u000b0\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R \u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u000e\"\u0004\b\u0018\u0010\u0010¨\u0006\u0019"}, mo175978d2 = {"Lcom/didi/soda/customer/coordshop/FeedSessionInfo;", "", "()V", "allItems", "", "getAllItems", "()Ljava/util/List;", "setAllItems", "(Ljava/util/List;)V", "currentVisibleRange", "Landroid/util/Range;", "", "kotlin.jvm.PlatformType", "getCurrentVisibleRange", "()Landroid/util/Range;", "setCurrentVisibleRange", "(Landroid/util/Range;)V", "refreshCount", "getRefreshCount", "()I", "setRefreshCount", "(I)V", "visibleRange", "getVisibleRange", "setVisibleRange", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.soda.customer.coordshop.a */
/* compiled from: ShopSaver.kt */
final class C13704a {

    /* renamed from: a */
    private int f40861a;

    /* renamed from: b */
    private Range<Integer> f40862b = new Range<>((Integer) null, (Integer) null);

    /* renamed from: c */
    private Range<Integer> f40863c = new Range<>((Integer) null, (Comparable) 0);

    /* renamed from: d */
    private List<Object> f40864d = new ArrayList();

    /* renamed from: a */
    public final int mo102837a() {
        return this.f40861a;
    }

    /* renamed from: a */
    public final void mo102838a(int i) {
        this.f40861a = i;
    }

    /* renamed from: a */
    public final void mo102839a(Range<Integer> range) {
        Intrinsics.checkNotNullParameter(range, "<set-?>");
        this.f40862b = range;
    }

    /* renamed from: b */
    public final Range<Integer> mo102841b() {
        return this.f40862b;
    }

    /* renamed from: b */
    public final void mo102842b(Range<Integer> range) {
        Intrinsics.checkNotNullParameter(range, "<set-?>");
        this.f40863c = range;
    }

    /* renamed from: c */
    public final Range<Integer> mo102843c() {
        return this.f40863c;
    }

    /* renamed from: a */
    public final void mo102840a(List<Object> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.f40864d = list;
    }

    /* renamed from: d */
    public final List<Object> mo102844d() {
        return this.f40864d;
    }
}
