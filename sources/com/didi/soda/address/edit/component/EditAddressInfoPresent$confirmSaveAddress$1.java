package com.didi.soda.address.edit.component;

import com.didi.soda.address.edit.binder.EditAddressModel;
import com.didi.soda.customer.foundation.rpc.entity.address.AddressEntity;
import com.didi.soda.customer.foundation.rpc.net.CustomerRpcCallback;
import com.didi.soda.customer.foundation.rpc.net.SFRpcException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001a\u0010\u0007\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, mo175978d2 = {"com/didi/soda/address/edit/component/EditAddressInfoPresent$confirmSaveAddress$1", "Lcom/didi/soda/customer/foundation/rpc/net/CustomerRpcCallback;", "Lcom/didi/soda/customer/foundation/rpc/entity/address/AddressEntity;", "onRpcFailure", "", "ex", "Lcom/didi/soda/customer/foundation/rpc/net/SFRpcException;", "onRpcSuccess", "address", "time", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: EditAddressInfoPresent.kt */
public final class EditAddressInfoPresent$confirmSaveAddress$1 extends CustomerRpcCallback<AddressEntity> {
    final /* synthetic */ EditAddressModel $editAddressModel;
    final /* synthetic */ EditAddressInfoPresent this$0;

    EditAddressInfoPresent$confirmSaveAddress$1(EditAddressInfoPresent editAddressInfoPresent, EditAddressModel editAddressModel) {
        this.this$0 = editAddressInfoPresent;
        this.$editAddressModel = editAddressModel;
    }

    public void onRpcFailure(SFRpcException sFRpcException) {
        Intrinsics.checkNotNullParameter(sFRpcException, "ex");
        if (!this.this$0.m27440a(1, this.$editAddressModel, sFRpcException)) {
            super.onRpcFailure(sFRpcException);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x003b, code lost:
        r0 = r0.poi;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onRpcSuccess(com.didi.soda.customer.foundation.rpc.entity.address.AddressEntity r12, long r13) {
        /*
            r11 = this;
            com.didi.soda.address.edit.component.EditAddressInfoPresent r13 = r11.this$0
            com.didi.app.nova.skeleton.mvp.IView r13 = r13.getLogicView()
            com.didi.soda.address.edit.component.Contract$AbsEditAddressInfoView r13 = (com.didi.soda.address.edit.component.Contract.AbsEditAddressInfoView) r13
            r13.hideLoading()
            com.didi.soda.address.edit.component.EditAddressInfoPresent r13 = r11.this$0
            boolean r13 = r13.isActive()
            if (r13 != 0) goto L_0x0014
            return
        L_0x0014:
            com.didi.soda.address.edit.component.EditAddressInfoPresent r13 = r11.this$0
            r13.m27443c()
            if (r12 != 0) goto L_0x001c
            goto L_0x006d
        L_0x001c:
            com.didi.soda.address.edit.component.EditAddressInfoPresent r13 = r11.this$0
            com.didi.soda.address.edit.binder.EditAddressModel r14 = r11.$editAddressModel
            java.lang.String r1 = r12.getAid()
            r2 = 1
            java.lang.String r3 = r14.getHouseNumber()
            java.lang.String r4 = r14.getBuildingName()
            int r5 = r14.getType()
            r6 = 1
            com.didi.soda.customer.foundation.rpc.entity.address.AddressEntity r0 = r14.getOriginAddressEntity()
            r7 = 0
            if (r0 != 0) goto L_0x003b
        L_0x0039:
            r9 = r7
            goto L_0x0043
        L_0x003b:
            com.didi.soda.customer.foundation.rpc.entity.address.AddressEntity$PoiEntity r0 = r0.poi
            if (r0 != 0) goto L_0x0040
            goto L_0x0039
        L_0x0040:
            java.lang.String r0 = r0.poiId
            r9 = r0
        L_0x0043:
            if (r14 != 0) goto L_0x0047
        L_0x0045:
            r10 = r7
            goto L_0x0056
        L_0x0047:
            com.didi.soda.customer.foundation.rpc.entity.address.AddressEntity r14 = r14.getOriginAddressEntity()
            if (r14 != 0) goto L_0x004e
            goto L_0x0045
        L_0x004e:
            com.didi.soda.customer.foundation.rpc.entity.address.AddressEntity$PoiEntity r14 = r14.poi
            if (r14 != 0) goto L_0x0053
            goto L_0x0045
        L_0x0053:
            java.lang.String r14 = r14.poiType
            r10 = r14
        L_0x0056:
            java.lang.String r7 = ""
            java.lang.String r8 = ""
            r0 = r13
            r0.m27435a(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            com.didi.soda.address.edit.strategy.AddressStrategyManager r14 = r13.f38734f
            com.didi.soda.address.edit.strategy.IAddressStrategy r14 = r14.getStrategy()
            boolean r13 = r13.f38733e
            r14.saveAddressSuccess(r12, r13)
        L_0x006d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.address.edit.component.EditAddressInfoPresent$confirmSaveAddress$1.onRpcSuccess(com.didi.soda.customer.foundation.rpc.entity.address.AddressEntity, long):void");
    }
}
