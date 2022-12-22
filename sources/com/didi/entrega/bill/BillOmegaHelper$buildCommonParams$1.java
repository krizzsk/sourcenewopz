package com.didi.entrega.bill;

import com.didi.entrega.customer.foundation.rpc.entity.BillComponentEntity;
import com.didi.entrega.customer.foundation.rpc.entity.BillExtraData;
import com.didi.entrega.customer.foundation.rpc.entity.address.AddressEntity;
import com.didi.entrega.customer.foundation.tracker.OmegaTracker;
import com.didi.entrega.customer.foundation.tracker.param.ParamConst;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175977d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, mo175978d2 = {"<anonymous>", "", "component", "Lcom/didi/entrega/customer/foundation/rpc/entity/BillComponentEntity;"}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: BillOmegaHelper.kt */
final class BillOmegaHelper$buildCommonParams$1 extends Lambda implements Function1<BillComponentEntity, Unit> {
    final /* synthetic */ OmegaTracker.Builder $builder;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BillOmegaHelper$buildCommonParams$1(OmegaTracker.Builder builder) {
        super(1);
        this.$builder = builder;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((BillComponentEntity) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(BillComponentEntity billComponentEntity) {
        AddressEntity.PoiEntity poiEntity;
        AddressEntity.PoiEntity poiEntity2;
        Intrinsics.checkNotNullParameter(billComponentEntity, "component");
        BillExtraData data = billComponentEntity.getData();
        String str = null;
        AddressEntity senderAddress = data == null ? null : data.getSenderAddress();
        if (senderAddress == null) {
            poiEntity = null;
        } else {
            poiEntity = senderAddress.poi;
        }
        if (poiEntity != null) {
            this.$builder.addEventParam("sender_poi_id", senderAddress.poi.poiId);
            this.$builder.addEventParam(ParamConst.InfoOmega.SENDER_CITY_ID, Integer.valueOf(senderAddress.poi.cityId));
        }
        OmegaTracker.Builder builder = this.$builder;
        String str2 = senderAddress == null ? null : senderAddress.aid;
        String str3 = "";
        if (str2 == null) {
            str2 = str3;
        }
        builder.addEventParam(ParamConst.PARAM_SENDER_AID, str2);
        BillExtraData data2 = billComponentEntity.getData();
        AddressEntity receiverAddress = data2 == null ? null : data2.getReceiverAddress();
        if (receiverAddress == null) {
            poiEntity2 = null;
        } else {
            poiEntity2 = receiverAddress.poi;
        }
        if (poiEntity2 != null) {
            this.$builder.addEventParam("receiver_poi_id", receiverAddress.poi.poiId);
            this.$builder.addEventParam(ParamConst.InfoOmega.RECEIVER_CITY_ID, Integer.valueOf(receiverAddress.poi.cityId));
        }
        OmegaTracker.Builder builder2 = this.$builder;
        if (receiverAddress != null) {
            str = receiverAddress.aid;
        }
        if (str != null) {
            str3 = str;
        }
        builder2.addEventParam(ParamConst.PARAM_RECEIVER_AID, str3);
    }
}
