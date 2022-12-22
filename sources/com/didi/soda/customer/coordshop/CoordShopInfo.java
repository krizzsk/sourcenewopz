package com.didi.soda.customer.coordshop;

import com.didi.soda.customer.foundation.rpc.entity.CoordShopEntity;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo175977d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u0015\u001a\u00020\u0003H\u0016R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u0016"}, mo175978d2 = {"Lcom/didi/soda/customer/coordshop/CoordShopInfo;", "", "traceId", "", "requestInfo", "Lcom/didi/soda/customer/coordshop/RequestInfo;", "entity", "Lcom/didi/soda/customer/foundation/rpc/entity/CoordShopEntity;", "(Ljava/lang/String;Lcom/didi/soda/customer/coordshop/RequestInfo;Lcom/didi/soda/customer/foundation/rpc/entity/CoordShopEntity;)V", "getEntity", "()Lcom/didi/soda/customer/foundation/rpc/entity/CoordShopEntity;", "setEntity", "(Lcom/didi/soda/customer/foundation/rpc/entity/CoordShopEntity;)V", "getRequestInfo", "()Lcom/didi/soda/customer/coordshop/RequestInfo;", "setRequestInfo", "(Lcom/didi/soda/customer/coordshop/RequestInfo;)V", "getTraceId", "()Ljava/lang/String;", "setTraceId", "(Ljava/lang/String;)V", "toString", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: ShopSaver.kt */
public final class CoordShopInfo {

    /* renamed from: a */
    private String f40837a;

    /* renamed from: b */
    private RequestInfo f40838b;

    /* renamed from: c */
    private CoordShopEntity f40839c;

    public CoordShopInfo(String str, RequestInfo requestInfo, CoordShopEntity coordShopEntity) {
        Intrinsics.checkNotNullParameter(str, "traceId");
        Intrinsics.checkNotNullParameter(requestInfo, "requestInfo");
        this.f40837a = str;
        this.f40838b = requestInfo;
        this.f40839c = coordShopEntity;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CoordShopInfo(String str, RequestInfo requestInfo, CoordShopEntity coordShopEntity, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, requestInfo, (i & 4) != 0 ? null : coordShopEntity);
    }

    public final String getTraceId() {
        return this.f40837a;
    }

    public final void setTraceId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.f40837a = str;
    }

    public final RequestInfo getRequestInfo() {
        return this.f40838b;
    }

    public final void setRequestInfo(RequestInfo requestInfo) {
        Intrinsics.checkNotNullParameter(requestInfo, "<set-?>");
        this.f40838b = requestInfo;
    }

    public final CoordShopEntity getEntity() {
        return this.f40839c;
    }

    public final void setEntity(CoordShopEntity coordShopEntity) {
        this.f40839c = coordShopEntity;
    }

    public String toString() {
        return "CoordShopInfo(traceId='" + this.f40837a + "', entity=" + this.f40839c + VersionRange.RIGHT_OPEN;
    }
}
