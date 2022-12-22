package com.didi.entrega.bill.datastore.p110op;

import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.entrega.bill.model.PriceModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0018\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\r"}, mo175978d2 = {"Lcom/didi/entrega/bill/datastore/op/BillPriceOperation;", "Lcom/didi/entrega/bill/datastore/op/EntityOperation;", "Lcom/didi/entrega/bill/model/PriceModel;", "scopeContext", "Lcom/didi/app/nova/skeleton/ScopeContext;", "(Lcom/didi/app/nova/skeleton/ScopeContext;)V", "getScopeContext", "()Lcom/didi/app/nova/skeleton/ScopeContext;", "operate", "repo", "Lcom/didi/entrega/bill/datastore/BillRepo;", "entity", "Lcom/didi/entrega/customer/foundation/rpc/entity/BillEntity;", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.entrega.bill.datastore.op.BillPriceOperation */
/* compiled from: BillPriceOperation.kt */
public final class BillPriceOperation extends EntityOperation<PriceModel> {

    /* renamed from: a */
    private final ScopeContext f19517a;

    public BillPriceOperation(ScopeContext scopeContext) {
        Intrinsics.checkNotNullParameter(scopeContext, "scopeContext");
        this.f19517a = scopeContext;
    }

    public final ScopeContext getScopeContext() {
        return this.f19517a;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v1, resolved type: java.util.Collection} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v3, resolved type: java.util.List} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.didi.entrega.bill.model.PriceModel operate(com.didi.entrega.bill.datastore.BillRepo r10, com.didi.entrega.customer.foundation.rpc.entity.BillEntity r11) {
        /*
            r9 = this;
            java.lang.String r0 = "repo"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            java.lang.String r0 = "entity"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            com.didi.entrega.bill.model.PriceModel r0 = new com.didi.entrega.bill.model.PriceModel
            r0.<init>()
            java.lang.String r1 = r11.getCartId()
            r0.setCartId(r1)
            int r1 = r11.getPriceSumOri()
            r0.setPriceSumOri(r1)
            java.lang.String r1 = r11.getPriceSumOriText()
            r0.setPriceSumOriText(r1)
            int r1 = r11.getRealPayPrice()
            r0.setRealPayPrice(r1)
            java.lang.String r1 = r11.getRealPayPriceText()
            r0.setRealPayPriceText(r1)
            java.util.List r1 = r11.getSections()
            if (r1 != 0) goto L_0x003b
            goto L_0x00ca
        L_0x003b:
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.util.Collection r2 = (java.util.Collection) r2
            java.util.Iterator r1 = r1.iterator()
        L_0x0048:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L_0x00c8
            java.lang.Object r3 = r1.next()
            com.didi.entrega.customer.foundation.rpc.entity.BillSectionEntity r3 = (com.didi.entrega.customer.foundation.rpc.entity.BillSectionEntity) r3
            java.util.List r3 = r3.getComponents()
            r4 = 0
            if (r3 != 0) goto L_0x005d
            goto L_0x00c2
        L_0x005d:
            java.lang.Iterable r3 = (java.lang.Iterable) r3
            java.util.ArrayList r5 = new java.util.ArrayList
            r6 = 10
            int r6 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r3, r6)
            r5.<init>(r6)
            java.util.Collection r5 = (java.util.Collection) r5
            r6 = 0
            java.util.Iterator r3 = r3.iterator()
        L_0x0071:
            boolean r7 = r3.hasNext()
            if (r7 == 0) goto L_0x00bf
            java.lang.Object r7 = r3.next()
            int r8 = r6 + 1
            if (r6 >= 0) goto L_0x0082
            kotlin.collections.CollectionsKt.throwIndexOverflow()
        L_0x0082:
            com.didi.entrega.customer.foundation.rpc.entity.BillComponentEntity r7 = (com.didi.entrega.customer.foundation.rpc.entity.BillComponentEntity) r7
            com.didi.entrega.customer.foundation.rpc.entity.BillExtraData r6 = r7.getData()
            if (r6 != 0) goto L_0x008b
            goto L_0x0095
        L_0x008b:
            com.didi.entrega.customer.foundation.rpc.entity.address.AddressEntity r6 = r6.getReceiverAddress()
            if (r6 != 0) goto L_0x0092
            goto L_0x0095
        L_0x0092:
            r0.setReceiverAddress(r6)
        L_0x0095:
            com.didi.entrega.customer.foundation.rpc.entity.BillExtraData r6 = r7.getData()
            if (r6 != 0) goto L_0x009c
            goto L_0x00a6
        L_0x009c:
            com.didi.entrega.customer.foundation.rpc.entity.address.AddressEntity r6 = r6.getSenderAddress()
            if (r6 != 0) goto L_0x00a3
            goto L_0x00a6
        L_0x00a3:
            r0.setSenderAddress(r6)
        L_0x00a6:
            com.didi.entrega.customer.foundation.rpc.entity.BillExtraData r6 = r7.getData()
            if (r6 != 0) goto L_0x00ae
        L_0x00ac:
            r6 = r4
            goto L_0x00ba
        L_0x00ae:
            com.didi.entrega.customer.foundation.rpc.entity.address.ContactStufEntity r6 = r6.getPackageInfo()
            if (r6 != 0) goto L_0x00b5
            goto L_0x00ac
        L_0x00b5:
            r0.setPackageInfo(r6)
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
        L_0x00ba:
            r5.add(r6)
            r6 = r8
            goto L_0x0071
        L_0x00bf:
            r4 = r5
            java.util.List r4 = (java.util.List) r4
        L_0x00c2:
            if (r4 == 0) goto L_0x0048
            r2.add(r4)
            goto L_0x0048
        L_0x00c8:
            java.util.List r2 = (java.util.List) r2
        L_0x00ca:
            com.didi.entrega.bill.BillExt$Companion r1 = com.didi.entrega.bill.BillExt.Companion
            com.didi.entrega.customer.foundation.rpc.entity.address.AddressEntity r2 = r0.getReceiverAddress()
            com.didi.entrega.customer.foundation.rpc.entity.address.AddressEntity r3 = r0.getSenderAddress()
            com.didi.entrega.customer.foundation.rpc.entity.address.ContactStufEntity r4 = r0.getPackageInfo()
            boolean r1 = r1.checkAddressAndPackageInfo(r2, r3, r4)
            if (r1 == 0) goto L_0x00e6
            r1 = 2131952063(0x7f1301bf, float:1.9540558E38)
            java.lang.String r1 = com.didi.entrega.customer.foundation.util.ResourceHelper.getString(r1)
            goto L_0x00ed
        L_0x00e6:
            r1 = 2131952025(0x7f130199, float:1.9540481E38)
            java.lang.String r1 = com.didi.entrega.customer.foundation.util.ResourceHelper.getString(r1)
        L_0x00ed:
            r0.setPayBtnText(r1)
            java.lang.String r1 = r11.getSn()
            r0.setSn(r1)
            com.didi.entrega.bill.datastore.op.BillPriceOperation$operate$1$2 r1 = new com.didi.entrega.bill.datastore.op.BillPriceOperation$operate$1$2
            r1.<init>(r11, r9, r10)
            kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1
            r0.setOnPayClick(r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.entrega.bill.datastore.p110op.BillPriceOperation.operate(com.didi.entrega.bill.datastore.BillRepo, com.didi.entrega.customer.foundation.rpc.entity.BillEntity):com.didi.entrega.bill.model.PriceModel");
    }
}
