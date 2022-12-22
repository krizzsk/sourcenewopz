package com.didi.entrega.bill.plugin;

import com.didi.entrega.customer.foundation.rpc.entity.BillComponentEntity;
import com.didi.entrega.customer.foundation.rpc.entity.BillExtraData;
import com.didi.entrega.customer.foundation.rpc.entity.address.AddressEntity;
import com.didi.entrega.manager.base.ICustomerContactManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175977d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, mo175978d2 = {"<anonymous>", "", "component", "Lcom/didi/entrega/customer/foundation/rpc/entity/BillComponentEntity;"}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: BillServiceImp.kt */
final class BillServiceImp$saveBillInfo$1$addressInfo$1 extends Lambda implements Function1<BillComponentEntity, Unit> {
    final /* synthetic */ ICustomerContactManager $this_apply;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BillServiceImp$saveBillInfo$1$addressInfo$1(ICustomerContactManager iCustomerContactManager) {
        super(1);
        this.$this_apply = iCustomerContactManager;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((BillComponentEntity) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(BillComponentEntity billComponentEntity) {
        Intrinsics.checkNotNullParameter(billComponentEntity, "component");
        ICustomerContactManager iCustomerContactManager = this.$this_apply;
        BillExtraData data = billComponentEntity.getData();
        AddressEntity addressEntity = null;
        iCustomerContactManager.updateSendContact(data == null ? null : data.getSenderAddress());
        ICustomerContactManager iCustomerContactManager2 = this.$this_apply;
        BillExtraData data2 = billComponentEntity.getData();
        if (data2 != null) {
            addressEntity = data2.getReceiverAddress();
        }
        iCustomerContactManager2.updateReceiveContact(addressEntity);
    }
}
