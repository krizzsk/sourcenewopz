package com.didi.soda.address.edit.component;

import com.didi.soda.customer.foundation.rpc.entity.address.AddressEntity;
import com.didi.soda.customer.foundation.rpc.net.CustomerRpcCallback;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u001a\u0010\u0007\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, mo175978d2 = {"com/didi/soda/address/edit/component/EditAddressInfoPresent$getReversePoi$1", "Lcom/didi/soda/customer/foundation/rpc/net/CustomerRpcCallback;", "Lcom/didi/soda/customer/foundation/rpc/entity/address/AddressEntity$PoiEntity;", "onFailure", "", "exception", "Ljava/io/IOException;", "onRpcSuccess", "poi", "var2", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: EditAddressInfoPresent.kt */
public final class EditAddressInfoPresent$getReversePoi$1 extends CustomerRpcCallback<AddressEntity.PoiEntity> {
    final /* synthetic */ double $lat;
    final /* synthetic */ double $lng;
    final /* synthetic */ EditAddressInfoPresent this$0;

    EditAddressInfoPresent$getReversePoi$1(EditAddressInfoPresent editAddressInfoPresent, double d, double d2) {
        this.this$0 = editAddressInfoPresent;
        this.$lat = d;
        this.$lng = d2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x000c, code lost:
        r7 = r7.getLiveHandler();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onRpcSuccess(com.didi.soda.customer.foundation.rpc.entity.address.AddressEntity.PoiEntity r6, long r7) {
        /*
            r5 = this;
            com.didi.soda.address.edit.component.EditAddressInfoPresent r7 = r5.this$0
            com.didi.app.nova.skeleton.ScopeContext r7 = r7.getScopeContext()
            r8 = 1
            r0 = 0
            if (r7 != 0) goto L_0x000c
        L_0x000a:
            r7 = 0
            goto L_0x001a
        L_0x000c:
            com.didi.app.nova.skeleton.LiveHandler r7 = r7.getLiveHandler()
            if (r7 != 0) goto L_0x0013
            goto L_0x000a
        L_0x0013:
            boolean r7 = r7.isActive()
            if (r7 != r8) goto L_0x000a
            r7 = 1
        L_0x001a:
            if (r7 == 0) goto L_0x0104
            if (r6 != 0) goto L_0x0024
            com.didi.soda.address.edit.component.EditAddressInfoPresent r6 = r5.this$0
            r6.m27436a((boolean) r8)
            return
        L_0x0024:
            com.didi.soda.address.edit.component.EditAddressInfoPresent r7 = r5.this$0
            com.didi.soda.customer.foundation.rpc.entity.address.AddressEntity r7 = r7.f38740l
            r1 = 0
            if (r7 != 0) goto L_0x002f
            r7 = r1
            goto L_0x0033
        L_0x002f:
            com.didi.soda.customer.foundation.rpc.entity.address.AddressEntity r7 = r7.cloneNoPoi()
        L_0x0033:
            if (r7 != 0) goto L_0x003a
            com.didi.soda.customer.foundation.rpc.entity.address.AddressEntity r7 = new com.didi.soda.customer.foundation.rpc.entity.address.AddressEntity
            r7.<init>()
        L_0x003a:
            r7.poi = r6
            com.didi.soda.address.edit.component.EditAddressInfoPresent r2 = r5.this$0
            com.didi.soda.address.edit.binder.EditAddressModel r2 = r2.f38737i
            if (r2 != 0) goto L_0x0046
            r2 = r1
            goto L_0x004e
        L_0x0046:
            boolean r2 = r2.isExpendMap()
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
        L_0x004e:
            com.didi.soda.address.edit.component.EditAddressInfoPresent r3 = r5.this$0
            com.didi.soda.address.edit.binder.EditAddressModel$Companion r4 = com.didi.soda.address.edit.binder.EditAddressModel.Companion
            com.didi.soda.address.edit.binder.EditAddressModel r4 = r4.from(r7)
            r3.f38737i = r4
            com.didi.soda.address.edit.component.EditAddressInfoPresent r3 = r5.this$0
            com.didi.soda.address.edit.binder.EditAddressModel r3 = r3.f38737i
            if (r3 != 0) goto L_0x0062
            goto L_0x006d
        L_0x0062:
            if (r2 != 0) goto L_0x0066
            r2 = 0
            goto L_0x006a
        L_0x0066:
            boolean r2 = r2.booleanValue()
        L_0x006a:
            r3.setExpendMap(r2)
        L_0x006d:
            java.lang.String r6 = r6.poiId
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            boolean r6 = android.text.TextUtils.isEmpty(r6)
            if (r6 != 0) goto L_0x00e3
            com.didi.soda.address.edit.component.EditAddressInfoPresent r6 = r5.this$0
            com.didi.soda.customer.foundation.rpc.entity.address.AddressEntity$PoiEntity r7 = r7.poi
            com.didi.soda.address.edit.component.EditAddressInfoPresent r2 = r5.this$0
            com.didi.soda.customer.foundation.rpc.entity.address.AddressEntity r2 = r2.f38740l
            if (r2 != 0) goto L_0x0084
            goto L_0x0086
        L_0x0084:
            com.didi.soda.customer.foundation.rpc.entity.address.AddressEntity$PoiEntity r1 = r2.poi
        L_0x0086:
            boolean r6 = r6.m27441a((com.didi.soda.customer.foundation.rpc.entity.address.AddressEntity.PoiEntity) r7, (com.didi.soda.customer.foundation.rpc.entity.address.AddressEntity.PoiEntity) r1)
            java.lang.String r7 = ""
            if (r6 != 0) goto L_0x00c1
            com.didi.soda.address.edit.component.EditAddressInfoPresent r6 = r5.this$0
            com.didi.soda.address.edit.binder.EditAddressModel r6 = r6.f38737i
            if (r6 != 0) goto L_0x0097
            goto L_0x009a
        L_0x0097:
            r6.setAid(r7)
        L_0x009a:
            com.didi.soda.address.edit.component.EditAddressInfoPresent r6 = r5.this$0
            com.didi.soda.address.edit.binder.EditAddressModel r6 = r6.f38737i
            if (r6 == 0) goto L_0x00bb
            com.didi.soda.address.edit.component.EditAddressInfoPresent r8 = r5.this$0
            r8.m27442b()
            com.didi.soda.address.edit.component.EditAddressInfoPresent r8 = r5.this$0
            com.didi.app.nova.skeleton.mvp.IView r8 = r8.getLogicView()
            com.didi.soda.address.edit.component.Contract$AbsEditAddressInfoView r8 = (com.didi.soda.address.edit.component.Contract.AbsEditAddressInfoView) r8
            java.lang.String r6 = r6.getAddressDisplayName()
            if (r6 != 0) goto L_0x00b6
            goto L_0x00b7
        L_0x00b6:
            r7 = r6
        L_0x00b7:
            r8.hidePinLoading(r7, r0)
            goto L_0x0104
        L_0x00bb:
            com.didi.soda.address.edit.component.EditAddressInfoPresent r6 = r5.this$0
            r6.m27436a((boolean) r0)
            goto L_0x0104
        L_0x00c1:
            com.didi.soda.address.edit.component.EditAddressInfoPresent r6 = r5.this$0
            r6.m27442b()
            com.didi.soda.address.edit.component.EditAddressInfoPresent r6 = r5.this$0
            com.didi.app.nova.skeleton.mvp.IView r6 = r6.getLogicView()
            com.didi.soda.address.edit.component.Contract$AbsEditAddressInfoView r6 = (com.didi.soda.address.edit.component.Contract.AbsEditAddressInfoView) r6
            com.didi.soda.address.edit.component.EditAddressInfoPresent r0 = r5.this$0
            com.didi.soda.address.edit.binder.EditAddressModel r0 = r0.f38737i
            if (r0 != 0) goto L_0x00d7
            goto L_0x00df
        L_0x00d7:
            java.lang.String r0 = r0.getAddressDisplayName()
            if (r0 != 0) goto L_0x00de
            goto L_0x00df
        L_0x00de:
            r7 = r0
        L_0x00df:
            r6.hidePinLoading(r7, r8)
            goto L_0x0104
        L_0x00e3:
            com.didi.soda.address.edit.component.EditAddressInfoPresent r6 = r5.this$0
            com.didi.soda.address.edit.binder.EditAddressModel r6 = r6.f38737i
            if (r6 != 0) goto L_0x00ec
            goto L_0x00f1
        L_0x00ec:
            double r0 = r5.$lat
            r6.setLat(r0)
        L_0x00f1:
            com.didi.soda.address.edit.component.EditAddressInfoPresent r6 = r5.this$0
            com.didi.soda.address.edit.binder.EditAddressModel r6 = r6.f38737i
            if (r6 != 0) goto L_0x00fa
            goto L_0x00ff
        L_0x00fa:
            double r0 = r5.$lng
            r6.setLng(r0)
        L_0x00ff:
            com.didi.soda.address.edit.component.EditAddressInfoPresent r6 = r5.this$0
            r6.m27436a((boolean) r8)
        L_0x0104:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.address.edit.component.EditAddressInfoPresent$getReversePoi$1.onRpcSuccess(com.didi.soda.customer.foundation.rpc.entity.address.AddressEntity$PoiEntity, long):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x000c, code lost:
        r6 = r6.getLiveHandler();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onFailure(java.io.IOException r6) {
        /*
            r5 = this;
            com.didi.soda.address.edit.component.EditAddressInfoPresent r6 = r5.this$0
            com.didi.app.nova.skeleton.ScopeContext r6 = r6.getScopeContext()
            r0 = 1
            r1 = 0
            if (r6 != 0) goto L_0x000c
        L_0x000a:
            r6 = 0
            goto L_0x001a
        L_0x000c:
            com.didi.app.nova.skeleton.LiveHandler r6 = r6.getLiveHandler()
            if (r6 != 0) goto L_0x0013
            goto L_0x000a
        L_0x0013:
            boolean r6 = r6.isActive()
            if (r6 != r0) goto L_0x000a
            r6 = 1
        L_0x001a:
            if (r6 == 0) goto L_0x0088
            com.didi.soda.address.edit.component.EditAddressInfoPresent r6 = r5.this$0
            com.didi.soda.customer.foundation.rpc.entity.address.AddressEntity r6 = r6.f38740l
            r2 = 0
            if (r6 != 0) goto L_0x0027
            r6 = r2
            goto L_0x002b
        L_0x0027:
            com.didi.soda.customer.foundation.rpc.entity.address.AddressEntity r6 = r6.clone()
        L_0x002b:
            if (r6 != 0) goto L_0x0032
            com.didi.soda.customer.foundation.rpc.entity.address.AddressEntity r6 = new com.didi.soda.customer.foundation.rpc.entity.address.AddressEntity
            r6.<init>()
        L_0x0032:
            com.didi.soda.customer.foundation.rpc.entity.address.AddressEntity$PoiEntity r3 = r6.poi
            java.lang.String r4 = ""
            r3.poiId = r4
            com.didi.soda.address.edit.component.EditAddressInfoPresent r3 = r5.this$0
            com.didi.soda.address.edit.binder.EditAddressModel r3 = r3.f38737i
            if (r3 != 0) goto L_0x0041
            goto L_0x0049
        L_0x0041:
            boolean r2 = r3.isExpendMap()
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
        L_0x0049:
            com.didi.soda.address.edit.component.EditAddressInfoPresent r3 = r5.this$0
            com.didi.soda.address.edit.binder.EditAddressModel$Companion r4 = com.didi.soda.address.edit.binder.EditAddressModel.Companion
            com.didi.soda.address.edit.binder.EditAddressModel r6 = r4.from(r6)
            r3.f38737i = r6
            com.didi.soda.address.edit.component.EditAddressInfoPresent r6 = r5.this$0
            com.didi.soda.address.edit.binder.EditAddressModel r6 = r6.f38737i
            if (r6 != 0) goto L_0x005d
            goto L_0x0067
        L_0x005d:
            if (r2 != 0) goto L_0x0060
            goto L_0x0064
        L_0x0060:
            boolean r1 = r2.booleanValue()
        L_0x0064:
            r6.setExpendMap(r1)
        L_0x0067:
            com.didi.soda.address.edit.component.EditAddressInfoPresent r6 = r5.this$0
            com.didi.soda.address.edit.binder.EditAddressModel r6 = r6.f38737i
            if (r6 != 0) goto L_0x0070
            goto L_0x0075
        L_0x0070:
            double r1 = r5.$lat
            r6.setLat(r1)
        L_0x0075:
            com.didi.soda.address.edit.component.EditAddressInfoPresent r6 = r5.this$0
            com.didi.soda.address.edit.binder.EditAddressModel r6 = r6.f38737i
            if (r6 != 0) goto L_0x007e
            goto L_0x0083
        L_0x007e:
            double r1 = r5.$lng
            r6.setLng(r1)
        L_0x0083:
            com.didi.soda.address.edit.component.EditAddressInfoPresent r6 = r5.this$0
            r6.m27436a((boolean) r0)
        L_0x0088:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.address.edit.component.EditAddressInfoPresent$getReversePoi$1.onFailure(java.io.IOException):void");
    }
}
