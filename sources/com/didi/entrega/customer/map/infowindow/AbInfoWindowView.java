package com.didi.entrega.customer.map.infowindow;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import com.didi.entrega.customer.map.marker.InfoWindowViewBuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nB)\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\t¢\u0006\u0002\u0010\fJ\b\u0010\r\u001a\u00020\tH%J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H$J\b\u0010\u0012\u001a\u00020\u000fH\u0002J\u0010\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0015H&¨\u0006\u0016"}, mo175978d2 = {"Lcom/didi/entrega/customer/map/infowindow/AbInfoWindowView;", "Landroid/widget/FrameLayout;", "ctx", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "getLayoutRes", "initView", "", "rootView", "Landroid/view/View;", "internalInflateLayout", "updateView", "infoWindowViewBuildConfig", "Lcom/didi/entrega/customer/map/marker/InfoWindowViewBuildConfig;", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: AbInfoWindowView.kt */
public abstract class AbInfoWindowView extends FrameLayout {
    public void _$_clearFindViewByIdCache() {
    }

    /* access modifiers changed from: protected */
    public abstract int getLayoutRes();

    /* access modifiers changed from: protected */
    public abstract void initView(View view);

    public abstract void updateView(InfoWindowViewBuildConfig infoWindowViewBuildConfig);

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public AbInfoWindowView(Context context) {
        this(context, (AttributeSet) null);
        Intrinsics.checkNotNullParameter(context, "ctx");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public AbInfoWindowView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "ctx");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public AbInfoWindowView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
        Intrinsics.checkNotNullParameter(context, "ctx");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AbInfoWindowView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "ctx");
        m14865a();
    }

    /* renamed from: a */
    private final void m14865a() {
        View inflate = LayoutInflater.from(getContext()).inflate(getLayoutRes(), this);
        Intrinsics.checkNotNullExpressionValue(inflate, "this");
        initView(inflate);
    }
}
