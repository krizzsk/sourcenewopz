package com.didi.soda.address.edit.component;

import com.didi.soda.address.edit.component.Contract;
import com.didi.soda.address.omega.AddressOmegaHelper;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.map.listener.MapGestureListener;
import com.didi.soda.customer.widget.map.SodaMapView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, mo175978d2 = {"com/didi/soda/address/edit/component/EditAddressInfoView$gesListener$1", "Lcom/didi/soda/customer/map/listener/MapGestureListener;", "onDown", "", "v", "", "v1", "onMapStable", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: EditAddressInfoView.kt */
public final class EditAddressInfoView$gesListener$1 extends MapGestureListener {
    final /* synthetic */ EditAddressInfoView this$0;

    EditAddressInfoView$gesListener$1(EditAddressInfoView editAddressInfoView) {
        this.this$0 = editAddressInfoView;
    }

    public boolean onDown(float f, float f2) {
        this.this$0.f38768v = true;
        LogUtil.m29100d("map", Intrinsics.stringPlus("onDown isMapStable:", Boolean.valueOf(this.this$0.f38767u)));
        return super.onDown(f, f2);
    }

    public void onMapStable() {
        SodaMapView access$getSodaMapView$p = this.this$0.f38747a;
        if (access$getSodaMapView$p == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sodaMapView");
            access$getSodaMapView$p = null;
        }
        access$getSodaMapView$p.setMapGestureEnable(true);
        if (this.this$0.f38768v) {
            this.this$0.f38768v = false;
            ((Contract.AbsEditAddressInfoPresent) this.this$0.getPresenter()).freshAddressTipStatus(true);
            this.this$0.f38767u = true;
            if (this.this$0.f38760n != null && this.this$0.f38762p != null && this.this$0.f38757k != null) {
                AddressOmegaHelper.traceLocationMapMove();
                if (!this.this$0.f38759m) {
                    this.this$0.f38759m = true;
                    EditAddressInfoView editAddressInfoView = this.this$0;
                    editAddressInfoView.m27464c(editAddressInfoView.m27467d());
                    AddressOmegaHelper.traceLocationSw(1);
                    return;
                }
                EditAddressInfoView editAddressInfoView2 = this.this$0;
                editAddressInfoView2.m27448a(editAddressInfoView2.m27467d());
            }
        }
    }
}
