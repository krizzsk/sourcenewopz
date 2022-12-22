package com.didi.soda.customer.foundation.rpc.entity.bill;

import com.didi.soda.customer.foundation.rpc.entity.BusinessModeInfoEntity;
import com.didi.soda.customer.foundation.rpc.entity.IEntity;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(mo175977d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 !2\u00020\u0001:\u0001!B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\u001a\u0010\u0012\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\f\"\u0004\b\u001d\u0010\u000eR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\f\"\u0004\b \u0010\u000e¨\u0006\""}, mo175978d2 = {"Lcom/didi/soda/customer/foundation/rpc/entity/bill/ShopInfo;", "Lcom/didi/soda/customer/foundation/rpc/entity/IEntity;", "()V", "cShopStatus", "", "getCShopStatus", "()I", "setCShopStatus", "(I)V", "cShopStatusDesc", "", "getCShopStatusDesc", "()Ljava/lang/String;", "setCShopStatusDesc", "(Ljava/lang/String;)V", "closeSoonDesc", "getCloseSoonDesc", "setCloseSoonDesc", "deliveryType", "getDeliveryType", "setDeliveryType", "modeInfo", "Lcom/didi/soda/customer/foundation/rpc/entity/BusinessModeInfoEntity;", "getModeInfo", "()Lcom/didi/soda/customer/foundation/rpc/entity/BusinessModeInfoEntity;", "setModeInfo", "(Lcom/didi/soda/customer/foundation/rpc/entity/BusinessModeInfoEntity;)V", "nextBizTimeDesc", "getNextBizTimeDesc", "setNextBizTimeDesc", "shopId", "getShopId", "setShopId", "Companion", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: ShopInfo.kt */
public final class ShopInfo implements IEntity {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final long serialVersionUID = 5583317612523733784L;
    private int cShopStatus;
    private String cShopStatusDesc;
    private String closeSoonDesc;
    private int deliveryType;
    private BusinessModeInfoEntity modeInfo;
    private String nextBizTimeDesc;
    private String shopId;

    public final String getShopId() {
        return this.shopId;
    }

    public final void setShopId(String str) {
        this.shopId = str;
    }

    public final int getCShopStatus() {
        return this.cShopStatus;
    }

    public final void setCShopStatus(int i) {
        this.cShopStatus = i;
    }

    public final String getCShopStatusDesc() {
        return this.cShopStatusDesc;
    }

    public final void setCShopStatusDesc(String str) {
        this.cShopStatusDesc = str;
    }

    public final String getNextBizTimeDesc() {
        return this.nextBizTimeDesc;
    }

    public final void setNextBizTimeDesc(String str) {
        this.nextBizTimeDesc = str;
    }

    public final String getCloseSoonDesc() {
        return this.closeSoonDesc;
    }

    public final void setCloseSoonDesc(String str) {
        this.closeSoonDesc = str;
    }

    public final int getDeliveryType() {
        return this.deliveryType;
    }

    public final void setDeliveryType(int i) {
        this.deliveryType = i;
    }

    public final BusinessModeInfoEntity getModeInfo() {
        return this.modeInfo;
    }

    public final void setModeInfo(BusinessModeInfoEntity businessModeInfoEntity) {
        this.modeInfo = businessModeInfoEntity;
    }

    @Metadata(mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo175978d2 = {"Lcom/didi/soda/customer/foundation/rpc/entity/bill/ShopInfo$Companion;", "", "()V", "serialVersionUID", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: ShopInfo.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
