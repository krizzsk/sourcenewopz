package com.didi.soda.customer.coordshop;

import com.didi.soda.customer.foundation.rpc.entity.CoordShopRequestEntity;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR \u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R \u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0012\"\u0004\b\u0018\u0010\u0014¨\u0006\u001a"}, mo175978d2 = {"Lcom/didi/soda/customer/coordshop/RequestInfo;", "", "()V", "curEnterShop", "Lcom/didi/soda/customer/foundation/rpc/entity/CoordShopRequestEntity;", "getCurEnterShop", "()Lcom/didi/soda/customer/foundation/rpc/entity/CoordShopRequestEntity;", "setCurEnterShop", "(Lcom/didi/soda/customer/foundation/rpc/entity/CoordShopRequestEntity;)V", "indexInRv", "", "getIndexInRv", "()I", "setIndexInRv", "(I)V", "nearByShopList", "", "getNearByShopList", "()Ljava/util/List;", "setNearByShopList", "(Ljava/util/List;)V", "visibleShopList", "", "getVisibleShopList", "setVisibleShopList", "Companion", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: RequestCoordShop.kt */
public final class RequestInfo {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a */
    private List<String> f40849a = new ArrayList();

    /* renamed from: b */
    private List<CoordShopRequestEntity> f40850b = new ArrayList();

    /* renamed from: c */
    private CoordShopRequestEntity f40851c;

    /* renamed from: d */
    private int f40852d = -1;

    public final List<String> getVisibleShopList() {
        return this.f40849a;
    }

    public final void setVisibleShopList(List<String> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.f40849a = list;
    }

    public final List<CoordShopRequestEntity> getNearByShopList() {
        return this.f40850b;
    }

    public final void setNearByShopList(List<CoordShopRequestEntity> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.f40850b = list;
    }

    public final CoordShopRequestEntity getCurEnterShop() {
        return this.f40851c;
    }

    public final void setCurEnterShop(CoordShopRequestEntity coordShopRequestEntity) {
        this.f40851c = coordShopRequestEntity;
    }

    public final int getIndexInRv() {
        return this.f40852d;
    }

    public final void setIndexInRv(int i) {
        this.f40852d = i;
    }

    @Metadata(mo175977d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, mo175978d2 = {"Lcom/didi/soda/customer/coordshop/RequestInfo$Companion;", "", "()V", "createCoordShopRequestEntity", "Lcom/didi/soda/customer/foundation/rpc/entity/CoordShopRequestEntity;", "info", "Lcom/didi/soda/customer/coordshop/CollectedShopInfo;", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: RequestCoordShop.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final CoordShopRequestEntity createCoordShopRequestEntity(CollectedShopInfo collectedShopInfo) {
            Intrinsics.checkNotNullParameter(collectedShopInfo, "info");
            CoordShopRequestEntity coordShopRequestEntity = new CoordShopRequestEntity();
            coordShopRequestEntity.shopId = collectedShopInfo.getShopId();
            coordShopRequestEntity.position = collectedShopInfo.getPosition();
            coordShopRequestEntity.pageNo = collectedShopInfo.getPageNo();
            return coordShopRequestEntity;
        }
    }
}
