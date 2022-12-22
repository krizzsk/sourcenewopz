package com.didi.soda.customer.widget.tabbar;

import com.didi.app.nova.skeleton.Component;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\f"}, mo175978d2 = {"Lcom/didi/soda/customer/widget/tabbar/ComponentInfo;", "", "component", "Lcom/didi/app/nova/skeleton/Component;", "isAdded", "", "(Lcom/didi/app/nova/skeleton/Component;Z)V", "getComponent", "()Lcom/didi/app/nova/skeleton/Component;", "()Z", "setAdded", "(Z)V", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: ComponentInfo.kt */
public final class ComponentInfo {

    /* renamed from: a */
    private final Component f42189a;

    /* renamed from: b */
    private boolean f42190b;

    public ComponentInfo(Component component, boolean z) {
        Intrinsics.checkNotNullParameter(component, "component");
        this.f42189a = component;
        this.f42190b = z;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ComponentInfo(Component component, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(component, (i & 2) != 0 ? false : z);
    }

    public final Component getComponent() {
        return this.f42189a;
    }

    public final boolean isAdded() {
        return this.f42190b;
    }

    public final void setAdded(boolean z) {
        this.f42190b = z;
    }
}
