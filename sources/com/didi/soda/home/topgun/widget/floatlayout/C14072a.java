package com.didi.soda.home.topgun.widget.floatlayout;

import android.view.View;
import android.view.ViewGroup;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0012\b\u0002\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nR\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, mo175978d2 = {"Lcom/didi/soda/home/topgun/widget/floatlayout/StickInfo;", "", "stickHolder", "Lcom/didi/soda/home/topgun/widget/floatlayout/IStickHolder;", "stickView", "Landroid/view/View;", "stickViewParent", "Landroid/view/ViewGroup;", "position", "", "(Lcom/didi/soda/home/topgun/widget/floatlayout/IStickHolder;Landroid/view/View;Landroid/view/ViewGroup;I)V", "getPosition", "()I", "setPosition", "(I)V", "getStickHolder", "()Lcom/didi/soda/home/topgun/widget/floatlayout/IStickHolder;", "setStickHolder", "(Lcom/didi/soda/home/topgun/widget/floatlayout/IStickHolder;)V", "getStickView", "()Landroid/view/View;", "setStickView", "(Landroid/view/View;)V", "getStickViewParent", "()Landroid/view/ViewGroup;", "setStickViewParent", "(Landroid/view/ViewGroup;)V", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.soda.home.topgun.widget.floatlayout.a */
/* compiled from: StickItemImp.kt */
final class C14072a {

    /* renamed from: a */
    private IStickHolder f43268a;

    /* renamed from: b */
    private View f43269b;

    /* renamed from: c */
    private ViewGroup f43270c;

    /* renamed from: d */
    private int f43271d;

    public C14072a(IStickHolder iStickHolder, View view, ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(iStickHolder, "stickHolder");
        Intrinsics.checkNotNullParameter(view, "stickView");
        Intrinsics.checkNotNullParameter(viewGroup, "stickViewParent");
        this.f43268a = iStickHolder;
        this.f43269b = view;
        this.f43270c = viewGroup;
        this.f43271d = i;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C14072a(IStickHolder iStickHolder, View view, ViewGroup viewGroup, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(iStickHolder, view, viewGroup, (i2 & 8) != 0 ? 0 : i);
    }

    /* renamed from: a */
    public final IStickHolder mo108191a() {
        return this.f43268a;
    }

    /* renamed from: a */
    public final void mo108195a(IStickHolder iStickHolder) {
        Intrinsics.checkNotNullParameter(iStickHolder, "<set-?>");
        this.f43268a = iStickHolder;
    }

    /* renamed from: a */
    public final void mo108193a(View view) {
        Intrinsics.checkNotNullParameter(view, "<set-?>");
        this.f43269b = view;
    }

    /* renamed from: b */
    public final View mo108196b() {
        return this.f43269b;
    }

    /* renamed from: a */
    public final void mo108194a(ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(viewGroup, "<set-?>");
        this.f43270c = viewGroup;
    }

    /* renamed from: c */
    public final ViewGroup mo108197c() {
        return this.f43270c;
    }

    /* renamed from: a */
    public final void mo108192a(int i) {
        this.f43271d = i;
    }

    /* renamed from: d */
    public final int mo108198d() {
        return this.f43271d;
    }
}
