package com.didi.entrega.customer.foundation.rpc.entity;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(mo175977d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\b\t\u0018\u0000 \r2\u00020\u0001:\u0001\rB%\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\u000e"}, mo175978d2 = {"Lcom/didi/entrega/customer/foundation/rpc/entity/ReceiverPoi;", "Lcom/didi/entrega/customer/foundation/rpc/entity/IEntity;", "displayName", "", "lat", "", "lng", "(Ljava/lang/String;DD)V", "getDisplayName", "()Ljava/lang/String;", "getLat", "()D", "getLng", "Companion", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: BillEntity.kt */
public final class ReceiverPoi implements IEntity {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final long serialVersionUID = 144775152930758735L;
    private final String displayName;
    private final double lat;
    private final double lng;

    public ReceiverPoi() {
        this((String) null, 0.0d, 0.0d, 7, (DefaultConstructorMarker) null);
    }

    public ReceiverPoi(String str, double d, double d2) {
        this.displayName = str;
        this.lat = d;
        this.lng = d2;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ ReceiverPoi(java.lang.String r5, double r6, double r8, int r10, kotlin.jvm.internal.DefaultConstructorMarker r11) {
        /*
            r4 = this;
            r11 = r10 & 1
            if (r11 == 0) goto L_0x0005
            r5 = 0
        L_0x0005:
            r11 = r10 & 2
            r0 = 0
            if (r11 == 0) goto L_0x000d
            r2 = r0
            goto L_0x000e
        L_0x000d:
            r2 = r6
        L_0x000e:
            r6 = r10 & 4
            if (r6 == 0) goto L_0x0014
            r10 = r0
            goto L_0x0015
        L_0x0014:
            r10 = r8
        L_0x0015:
            r6 = r4
            r7 = r5
            r8 = r2
            r6.<init>(r7, r8, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.entrega.customer.foundation.rpc.entity.ReceiverPoi.<init>(java.lang.String, double, double, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final String getDisplayName() {
        return this.displayName;
    }

    public final double getLat() {
        return this.lat;
    }

    public final double getLng() {
        return this.lng;
    }

    @Metadata(mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo175978d2 = {"Lcom/didi/entrega/customer/foundation/rpc/entity/ReceiverPoi$Companion;", "", "()V", "serialVersionUID", "", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: BillEntity.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
