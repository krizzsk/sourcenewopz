package com.didi.entrega.customer.map.marker;

import android.content.Context;
import android.view.View;
import com.didi.entrega.customer.map.infowindow.AbInfoWindowView;
import com.didi.entrega.customer.widget.support.CustomerAppCompatTextView;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u000b\u001a\u00020\fH\u0014J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0014J\u0010\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016R\u001a\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u0014"}, mo175978d2 = {"Lcom/didi/entrega/customer/map/marker/BillInfoWindowView;", "Lcom/didi/entrega/customer/map/infowindow/AbInfoWindowView;", "ctx", "Landroid/content/Context;", "(Landroid/content/Context;)V", "mTvTip", "Lcom/didi/entrega/customer/widget/support/CustomerAppCompatTextView;", "getMTvTip", "()Lcom/didi/entrega/customer/widget/support/CustomerAppCompatTextView;", "setMTvTip", "(Lcom/didi/entrega/customer/widget/support/CustomerAppCompatTextView;)V", "getLayoutRes", "", "initView", "", "rootView", "Landroid/view/View;", "updateView", "infoWindowViewBuildConfig", "Lcom/didi/entrega/customer/map/marker/InfoWindowViewBuildConfig;", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: InfoWindowViewFactory.kt */
public final class BillInfoWindowView extends AbInfoWindowView {
    public CustomerAppCompatTextView mTvTip;

    public void _$_clearFindViewByIdCache() {
    }

    /* access modifiers changed from: protected */
    public int getLayoutRes() {
        return R.layout.entrega_customer_bill_map_tip;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BillInfoWindowView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "ctx");
    }

    public final CustomerAppCompatTextView getMTvTip() {
        CustomerAppCompatTextView customerAppCompatTextView = this.mTvTip;
        if (customerAppCompatTextView != null) {
            return customerAppCompatTextView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mTvTip");
        return null;
    }

    public final void setMTvTip(CustomerAppCompatTextView customerAppCompatTextView) {
        Intrinsics.checkNotNullParameter(customerAppCompatTextView, "<set-?>");
        this.mTvTip = customerAppCompatTextView;
    }

    /* access modifiers changed from: protected */
    public void initView(View view) {
        Intrinsics.checkNotNullParameter(view, "rootView");
        View findViewById = view.findViewById(R.id.customer_tv_bill_map_tip);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById<Cu…customer_tv_bill_map_tip)");
        setMTvTip((CustomerAppCompatTextView) findViewById);
    }

    public void updateView(InfoWindowViewBuildConfig infoWindowViewBuildConfig) {
        Intrinsics.checkNotNullParameter(infoWindowViewBuildConfig, "infoWindowViewBuildConfig");
        if (1 == infoWindowViewBuildConfig.getCategory()) {
            getMTvTip().setBackgroundResource(R.drawable.entraga_shape_bill_map_green_bg);
        } else {
            getMTvTip().setBackgroundResource(R.drawable.entraga_shape_bill_map_orange_bg);
        }
        getMTvTip().setMaxWidth(InfoWindowViewFactory.Companion.getMarkerInfoMaxWidth());
        String title = infoWindowViewBuildConfig.getTitle();
        if (title != null) {
            getMTvTip().setText(title);
        }
    }
}
