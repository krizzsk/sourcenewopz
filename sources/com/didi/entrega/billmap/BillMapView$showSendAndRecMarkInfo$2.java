package com.didi.entrega.billmap;

import com.didi.common.map.listener.OnInfoWindowClickListener;
import com.didi.common.map.model.LatLng;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175977d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, mo175978d2 = {"<anonymous>", ""}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: BillMapView.kt */
final class BillMapView$showSendAndRecMarkInfo$2 extends Lambda implements Function0<Unit> {
    final /* synthetic */ String $receiveTip;
    final /* synthetic */ LatLng $receiverLatLng;
    final /* synthetic */ BillMapView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BillMapView$showSendAndRecMarkInfo$2(BillMapView billMapView, LatLng latLng, String str) {
        super(0);
        this.this$0 = billMapView;
        this.$receiverLatLng = latLng;
        this.$receiveTip = str;
    }

    public final void invoke() {
        this.this$0.m14642a().showWithInfoWindow(this.$receiverLatLng, this.$receiveTip, (OnInfoWindowClickListener) null);
    }
}
