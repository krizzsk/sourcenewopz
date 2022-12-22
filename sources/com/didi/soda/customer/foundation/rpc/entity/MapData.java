package com.didi.soda.customer.foundation.rpc.entity;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo175977d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u001e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\b\u0018\u0000 ,2\u00020\u0001:\u0001,Be\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\f\u001a\u00020\u0007\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u000eJ\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0007HÆ\u0003J\t\u0010 \u001a\u00020\u0007HÆ\u0003J\t\u0010!\u001a\u00020\u0007HÆ\u0003J\t\u0010\"\u001a\u00020\u0007HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0005HÆ\u0003Ji\u0010$\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\u00072\b\b\u0002\u0010\f\u001a\u00020\u00072\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010(HÖ\u0003J\t\u0010)\u001a\u00020*HÖ\u0001J\t\u0010+\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0011\u0010\t\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015R\u0011\u0010\n\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0015R\u0011\u0010\u000b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0015R\u0011\u0010\f\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0015¨\u0006-"}, mo175978d2 = {"Lcom/didi/soda/customer/foundation/rpc/entity/MapData;", "Lcom/didi/soda/customer/foundation/rpc/entity/IEntity;", "bubble", "Lcom/didi/soda/customer/foundation/rpc/entity/Bubble;", "riderId", "", "riderLat", "", "riderLng", "shopLat", "shopLng", "userLat", "userLng", "riderDesc", "(Lcom/didi/soda/customer/foundation/rpc/entity/Bubble;Ljava/lang/String;DDDDDDLjava/lang/String;)V", "getBubble", "()Lcom/didi/soda/customer/foundation/rpc/entity/Bubble;", "getRiderDesc", "()Ljava/lang/String;", "getRiderId", "getRiderLat", "()D", "getRiderLng", "getShopLat", "getShopLng", "getUserLat", "getUserLng", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "", "hashCode", "", "toString", "Companion", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: OrderLayoutEntity.kt */
public final class MapData implements IEntity {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final long serialVersionUID = -1356027535404659139L;
    private final Bubble bubble;
    private final String riderDesc;
    private final String riderId;
    private final double riderLat;
    private final double riderLng;
    private final double shopLat;
    private final double shopLng;
    private final double userLat;
    private final double userLng;

    public MapData() {
        this((Bubble) null, (String) null, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, (String) null, 511, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ MapData copy$default(MapData mapData, Bubble bubble2, String str, double d, double d2, double d3, double d4, double d5, double d6, String str2, int i, Object obj) {
        MapData mapData2 = mapData;
        int i2 = i;
        return mapData.copy((i2 & 1) != 0 ? mapData2.bubble : bubble2, (i2 & 2) != 0 ? mapData2.riderId : str, (i2 & 4) != 0 ? mapData2.riderLat : d, (i2 & 8) != 0 ? mapData2.riderLng : d2, (i2 & 16) != 0 ? mapData2.shopLat : d3, (i2 & 32) != 0 ? mapData2.shopLng : d4, (i2 & 64) != 0 ? mapData2.userLat : d5, (i2 & 128) != 0 ? mapData2.userLng : d6, (i2 & 256) != 0 ? mapData2.riderDesc : str2);
    }

    public final Bubble component1() {
        return this.bubble;
    }

    public final String component2() {
        return this.riderId;
    }

    public final double component3() {
        return this.riderLat;
    }

    public final double component4() {
        return this.riderLng;
    }

    public final double component5() {
        return this.shopLat;
    }

    public final double component6() {
        return this.shopLng;
    }

    public final double component7() {
        return this.userLat;
    }

    public final double component8() {
        return this.userLng;
    }

    public final String component9() {
        return this.riderDesc;
    }

    public final MapData copy(Bubble bubble2, String str, double d, double d2, double d3, double d4, double d5, double d6, String str2) {
        return new MapData(bubble2, str, d, d2, d3, d4, d5, d6, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MapData)) {
            return false;
        }
        MapData mapData = (MapData) obj;
        return Intrinsics.areEqual((Object) this.bubble, (Object) mapData.bubble) && Intrinsics.areEqual((Object) this.riderId, (Object) mapData.riderId) && Intrinsics.areEqual((Object) Double.valueOf(this.riderLat), (Object) Double.valueOf(mapData.riderLat)) && Intrinsics.areEqual((Object) Double.valueOf(this.riderLng), (Object) Double.valueOf(mapData.riderLng)) && Intrinsics.areEqual((Object) Double.valueOf(this.shopLat), (Object) Double.valueOf(mapData.shopLat)) && Intrinsics.areEqual((Object) Double.valueOf(this.shopLng), (Object) Double.valueOf(mapData.shopLng)) && Intrinsics.areEqual((Object) Double.valueOf(this.userLat), (Object) Double.valueOf(mapData.userLat)) && Intrinsics.areEqual((Object) Double.valueOf(this.userLng), (Object) Double.valueOf(mapData.userLng)) && Intrinsics.areEqual((Object) this.riderDesc, (Object) mapData.riderDesc);
    }

    public int hashCode() {
        Bubble bubble2 = this.bubble;
        int i = 0;
        int hashCode = (bubble2 == null ? 0 : bubble2.hashCode()) * 31;
        String str = this.riderId;
        int hashCode2 = (((((((((((((hashCode + (str == null ? 0 : str.hashCode())) * 31) + Double.doubleToLongBits(this.riderLat)) * 31) + Double.doubleToLongBits(this.riderLng)) * 31) + Double.doubleToLongBits(this.shopLat)) * 31) + Double.doubleToLongBits(this.shopLng)) * 31) + Double.doubleToLongBits(this.userLat)) * 31) + Double.doubleToLongBits(this.userLng)) * 31;
        String str2 = this.riderDesc;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        return "MapData(bubble=" + this.bubble + ", riderId=" + this.riderId + ", riderLat=" + this.riderLat + ", riderLng=" + this.riderLng + ", shopLat=" + this.shopLat + ", shopLng=" + this.shopLng + ", userLat=" + this.userLat + ", userLng=" + this.userLng + ", riderDesc=" + this.riderDesc + VersionRange.RIGHT_OPEN;
    }

    public MapData(Bubble bubble2, String str, double d, double d2, double d3, double d4, double d5, double d6, String str2) {
        this.bubble = bubble2;
        this.riderId = str;
        this.riderLat = d;
        this.riderLng = d2;
        this.shopLat = d3;
        this.shopLng = d4;
        this.userLat = d5;
        this.userLng = d6;
        this.riderDesc = str2;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ MapData(com.didi.soda.customer.foundation.rpc.entity.Bubble r18, java.lang.String r19, double r20, double r22, double r24, double r26, double r28, double r30, java.lang.String r32, int r33, kotlin.jvm.internal.DefaultConstructorMarker r34) {
        /*
            r17 = this;
            r0 = r33
            r1 = r0 & 1
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r1 = r2
            goto L_0x000b
        L_0x0009:
            r1 = r18
        L_0x000b:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0011
            r3 = r2
            goto L_0x0013
        L_0x0011:
            r3 = r19
        L_0x0013:
            r4 = r0 & 4
            r5 = 0
            if (r4 == 0) goto L_0x001b
            r7 = r5
            goto L_0x001d
        L_0x001b:
            r7 = r20
        L_0x001d:
            r4 = r0 & 8
            if (r4 == 0) goto L_0x0023
            r9 = r5
            goto L_0x0025
        L_0x0023:
            r9 = r22
        L_0x0025:
            r4 = r0 & 16
            if (r4 == 0) goto L_0x002b
            r11 = r5
            goto L_0x002d
        L_0x002b:
            r11 = r24
        L_0x002d:
            r4 = r0 & 32
            if (r4 == 0) goto L_0x0033
            r13 = r5
            goto L_0x0035
        L_0x0033:
            r13 = r26
        L_0x0035:
            r4 = r0 & 64
            if (r4 == 0) goto L_0x003b
            r15 = r5
            goto L_0x003d
        L_0x003b:
            r15 = r28
        L_0x003d:
            r4 = r0 & 128(0x80, float:1.794E-43)
            if (r4 == 0) goto L_0x0042
            goto L_0x0044
        L_0x0042:
            r5 = r30
        L_0x0044:
            r0 = r0 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L_0x0049
            goto L_0x004b
        L_0x0049:
            r2 = r32
        L_0x004b:
            r18 = r17
            r19 = r1
            r20 = r3
            r21 = r7
            r23 = r9
            r25 = r11
            r27 = r13
            r29 = r15
            r31 = r5
            r33 = r2
            r18.<init>(r19, r20, r21, r23, r25, r27, r29, r31, r33)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.customer.foundation.rpc.entity.MapData.<init>(com.didi.soda.customer.foundation.rpc.entity.Bubble, java.lang.String, double, double, double, double, double, double, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final Bubble getBubble() {
        return this.bubble;
    }

    public final String getRiderId() {
        return this.riderId;
    }

    public final double getRiderLat() {
        return this.riderLat;
    }

    public final double getRiderLng() {
        return this.riderLng;
    }

    public final double getShopLat() {
        return this.shopLat;
    }

    public final double getShopLng() {
        return this.shopLng;
    }

    public final double getUserLat() {
        return this.userLat;
    }

    public final double getUserLng() {
        return this.userLng;
    }

    public final String getRiderDesc() {
        return this.riderDesc;
    }

    @Metadata(mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo175978d2 = {"Lcom/didi/soda/customer/foundation/rpc/entity/MapData$Companion;", "", "()V", "serialVersionUID", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: OrderLayoutEntity.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
