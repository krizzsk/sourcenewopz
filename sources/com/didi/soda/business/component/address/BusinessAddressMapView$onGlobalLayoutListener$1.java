package com.didi.soda.business.component.address;

import android.view.ViewTreeObserver;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, mo175978d2 = {"com/didi/soda/business/component/address/BusinessAddressMapView$onGlobalLayoutListener$1", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "onGlobalLayout", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: BusinessAddressMapView.kt */
public final class BusinessAddressMapView$onGlobalLayoutListener$1 implements ViewTreeObserver.OnGlobalLayoutListener {
    final /* synthetic */ BusinessAddressMapView this$0;

    BusinessAddressMapView$onGlobalLayoutListener$1(BusinessAddressMapView businessAddressMapView) {
        this.this$0 = businessAddressMapView;
    }

    public void onGlobalLayout() {
        this.this$0.refreshMapPadding();
    }
}
