package com.didi.soda.customer.widget.tabbar;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0016\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\tJ\u000e\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020 R\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\rR\u001e\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\t@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006!"}, mo175978d2 = {"Lcom/didi/soda/customer/widget/tabbar/TabBarItemModel;", "", "tabBarItem", "Lcom/didi/soda/customer/widget/tabbar/TabBarItem;", "itemView", "Lcom/didi/soda/customer/widget/tabbar/TabBarItemView;", "tabContainer", "Landroid/view/View;", "isClicked", "", "(Lcom/didi/soda/customer/widget/tabbar/TabBarItem;Lcom/didi/soda/customer/widget/tabbar/TabBarItemView;Landroid/view/View;Z)V", "()Z", "setClicked", "(Z)V", "isControllerInit", "setControllerInit", "<set-?>", "isSelected", "getItemView", "()Lcom/didi/soda/customer/widget/tabbar/TabBarItemView;", "getTabBarItem", "()Lcom/didi/soda/customer/widget/tabbar/TabBarItem;", "getTabContainer", "()Landroid/view/View;", "setTabContainer", "(Landroid/view/View;)V", "setIsSelected", "", "selected", "fromUser", "updateSelf", "op", "Lcom/didi/soda/customer/widget/tabbar/TabBarOp;", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.soda.customer.widget.tabbar.a */
/* compiled from: TabBarController.kt */
final class C13883a {

    /* renamed from: a */
    private final TabBarItem f42220a;

    /* renamed from: b */
    private final C13884b f42221b;

    /* renamed from: c */
    private View f42222c;

    /* renamed from: d */
    private boolean f42223d;

    /* renamed from: e */
    private boolean f42224e;

    /* renamed from: f */
    private boolean f42225f;

    public C13883a(TabBarItem tabBarItem, C13884b bVar, View view, boolean z) {
        Intrinsics.checkNotNullParameter(tabBarItem, "tabBarItem");
        Intrinsics.checkNotNullParameter(bVar, "itemView");
        this.f42220a = tabBarItem;
        this.f42221b = bVar;
        this.f42222c = view;
        this.f42223d = z;
        this.f42224e = tabBarItem.isSelected();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C13883a(TabBarItem tabBarItem, C13884b bVar, View view, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(tabBarItem, bVar, (i & 4) != 0 ? null : view, (i & 8) != 0 ? false : z);
    }

    /* renamed from: a */
    public final TabBarItem mo106241a() {
        return this.f42220a;
    }

    /* renamed from: b */
    public final C13884b mo106246b() {
        return this.f42221b;
    }

    /* renamed from: a */
    public final void mo106242a(View view) {
        this.f42222c = view;
    }

    /* renamed from: c */
    public final View mo106248c() {
        return this.f42222c;
    }

    /* renamed from: a */
    public final void mo106244a(boolean z) {
        this.f42223d = z;
    }

    /* renamed from: d */
    public final boolean mo106249d() {
        return this.f42223d;
    }

    /* renamed from: e */
    public final boolean mo106250e() {
        return this.f42224e;
    }

    /* renamed from: b */
    public final void mo106247b(boolean z) {
        this.f42225f = z;
    }

    /* renamed from: f */
    public final boolean mo106251f() {
        return this.f42225f;
    }

    /* renamed from: a */
    public final void mo106245a(boolean z, boolean z2) {
        this.f42224e = z;
        this.f42220a.setSelected(z);
        if (z2 && z) {
            C13884b bVar = this.f42221b;
            if (bVar != null) {
                bVar.mo106253a(this);
            }
            this.f42223d = true;
        }
        this.f42221b.mo106254b(this);
        View view = this.f42222c;
        if (view != null) {
            view.setVisibility(z ? 0 : 8);
        }
    }

    /* renamed from: a */
    public final void mo106243a(TabBarOp tabBarOp) {
        ComponentController controller;
        Intrinsics.checkNotNullParameter(tabBarOp, "op");
        this.f42221b.mo106254b(this);
        if (tabBarOp == TabBarOp.UPDATE_ALL && this.f42225f && (controller = this.f42220a.getController()) != null) {
            controller.internOnTabUpdate(this.f42220a.getParams());
        }
    }
}
