package com.didi.soda.bill.model.datamodel;

import com.didi.soda.customer.foundation.rpc.entity.bill.ShopInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(mo175977d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000f\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000eR\u001c\u0010\u0015\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\f\"\u0004\b\u0017\u0010\u000e¨\u0006\u0019"}, mo175978d2 = {"Lcom/didi/soda/bill/model/datamodel/ShopInfoModel;", "", "()V", "cShopStatus", "", "getCShopStatus", "()I", "setCShopStatus", "(I)V", "cShopStatusDesc", "", "getCShopStatusDesc", "()Ljava/lang/String;", "setCShopStatusDesc", "(Ljava/lang/String;)V", "closeSoonDesc", "getCloseSoonDesc", "setCloseSoonDesc", "nextBizTimeDesc", "getNextBizTimeDesc", "setNextBizTimeDesc", "shopId", "getShopId", "setShopId", "Companion", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: ShopInfoModel.kt */
public final class ShopInfoModel {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a */
    private int f39135a;

    /* renamed from: b */
    private String f39136b;

    /* renamed from: c */
    private String f39137c;

    /* renamed from: d */
    private String f39138d;

    /* renamed from: e */
    private String f39139e;

    public final int getCShopStatus() {
        return this.f39135a;
    }

    public final void setCShopStatus(int i) {
        this.f39135a = i;
    }

    public final String getCShopStatusDesc() {
        return this.f39136b;
    }

    public final void setCShopStatusDesc(String str) {
        this.f39136b = str;
    }

    public final String getNextBizTimeDesc() {
        return this.f39137c;
    }

    public final void setNextBizTimeDesc(String str) {
        this.f39137c = str;
    }

    public final String getShopId() {
        return this.f39138d;
    }

    public final void setShopId(String str) {
        this.f39138d = str;
    }

    public final String getCloseSoonDesc() {
        return this.f39139e;
    }

    public final void setCloseSoonDesc(String str) {
        this.f39139e = str;
    }

    @Metadata(mo175977d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¨\u0006\u0007"}, mo175978d2 = {"Lcom/didi/soda/bill/model/datamodel/ShopInfoModel$Companion;", "", "()V", "convert", "Lcom/didi/soda/bill/model/datamodel/ShopInfoModel;", "shopInfo", "Lcom/didi/soda/customer/foundation/rpc/entity/bill/ShopInfo;", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: ShopInfoModel.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ShopInfoModel convert(ShopInfo shopInfo) {
            if (shopInfo == null) {
                return null;
            }
            ShopInfoModel shopInfoModel = new ShopInfoModel();
            shopInfoModel.setCShopStatus(shopInfo.getCShopStatus());
            shopInfoModel.setCShopStatusDesc(shopInfo.getCShopStatusDesc());
            shopInfoModel.setNextBizTimeDesc(shopInfo.getNextBizTimeDesc());
            shopInfoModel.setShopId(shopInfo.getShopId());
            shopInfoModel.setCloseSoonDesc(shopInfo.getCloseSoonDesc());
            return shopInfoModel;
        }
    }
}
