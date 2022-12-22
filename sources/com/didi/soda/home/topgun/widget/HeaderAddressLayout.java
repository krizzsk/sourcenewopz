package com.didi.soda.home.topgun.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.soda.home.topgun.manager.HomeUpdateHeaderInfoHelper;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u0007J\u0018\u0010\u0012\u001a\u00020\u000e2\b\b\u0001\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0007R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, mo175978d2 = {"Lcom/didi/soda/home/topgun/widget/HeaderAddressLayout;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "addressTextView", "Landroid/widget/TextView;", "arrowIcon", "icon", "setAddress", "", "scopeContext", "Lcom/didi/app/nova/skeleton/ScopeContext;", "where", "setAddressColor", "color", "iconColor", "Companion", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: HeaderAddressLayout.kt */
public final class HeaderAddressLayout extends ConstraintLayout {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int attachToHome = 0;
    public static final int attachToLanding = 1;

    /* renamed from: a */
    private TextView f43066a;

    /* renamed from: b */
    private TextView f43067b;

    /* renamed from: c */
    private TextView f43068c;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public HeaderAddressLayout(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public HeaderAddressLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public void _$_clearFindViewByIdCache() {
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ HeaderAddressLayout(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HeaderAddressLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        LayoutInflater.from(context).inflate(R.layout.customer_item_home_header_address, this);
        View findViewById = findViewById(R.id.customer_tv_home_address_icon);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.customer_tv_home_address_icon)");
        this.f43066a = (TextView) findViewById;
        View findViewById2 = findViewById(R.id.customer_tv_home_address);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.customer_tv_home_address)");
        this.f43067b = (TextView) findViewById2;
        View findViewById3 = findViewById(R.id.customer_custom_address_arrow);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.customer_custom_address_arrow)");
        this.f43068c = (TextView) findViewById3;
    }

    public final void setAddressColor(int i, int i2) {
        this.f43066a.setTextColor(i2);
        this.f43067b.setTextColor(i);
        this.f43068c.setTextColor(i);
    }

    public static /* synthetic */ void setAddress$default(HeaderAddressLayout headerAddressLayout, ScopeContext scopeContext, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        headerAddressLayout.setAddress(scopeContext, i);
    }

    public final void setAddress(ScopeContext scopeContext, int i) {
        Intrinsics.checkNotNullParameter(scopeContext, "scopeContext");
        HomeUpdateHeaderInfoHelper.updateAddressInfo(this.f43067b, scopeContext, i);
    }

    @Metadata(mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, mo175978d2 = {"Lcom/didi/soda/home/topgun/widget/HeaderAddressLayout$Companion;", "", "()V", "attachToHome", "", "attachToLanding", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: HeaderAddressLayout.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
