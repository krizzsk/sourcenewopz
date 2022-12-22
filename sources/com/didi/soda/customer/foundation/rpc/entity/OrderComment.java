package com.didi.soda.customer.foundation.rpc.entity;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo175977d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\b\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB;\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005¢\u0006\u0002\u0010\tJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J?\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\b\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\r¨\u0006\u001d"}, mo175978d2 = {"Lcom/didi/soda/customer/foundation/rpc/entity/OrderComment;", "Lcom/didi/soda/customer/foundation/rpc/entity/IEntity;", "title", "", "isShowTipPay", "", "score", "currency", "afterFavPrice", "(Ljava/lang/String;IILjava/lang/String;I)V", "getAfterFavPrice", "()I", "getCurrency", "()Ljava/lang/String;", "getScore", "getTitle", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "toString", "Companion", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: OrderLayoutEntity.kt */
public final class OrderComment implements IEntity {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final long serialVersionUID = -2194963331512864513L;
    private final int afterFavPrice;
    private final String currency;
    private final int isShowTipPay;
    private final int score;
    private final String title;

    public OrderComment() {
        this((String) null, 0, 0, (String) null, 0, 31, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ OrderComment copy$default(OrderComment orderComment, String str, int i, int i2, String str2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            str = orderComment.title;
        }
        if ((i4 & 2) != 0) {
            i = orderComment.isShowTipPay;
        }
        int i5 = i;
        if ((i4 & 4) != 0) {
            i2 = orderComment.score;
        }
        int i6 = i2;
        if ((i4 & 8) != 0) {
            str2 = orderComment.currency;
        }
        String str3 = str2;
        if ((i4 & 16) != 0) {
            i3 = orderComment.afterFavPrice;
        }
        return orderComment.copy(str, i5, i6, str3, i3);
    }

    public final String component1() {
        return this.title;
    }

    public final int component2() {
        return this.isShowTipPay;
    }

    public final int component3() {
        return this.score;
    }

    public final String component4() {
        return this.currency;
    }

    public final int component5() {
        return this.afterFavPrice;
    }

    public final OrderComment copy(String str, int i, int i2, String str2, int i3) {
        return new OrderComment(str, i, i2, str2, i3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OrderComment)) {
            return false;
        }
        OrderComment orderComment = (OrderComment) obj;
        return Intrinsics.areEqual((Object) this.title, (Object) orderComment.title) && this.isShowTipPay == orderComment.isShowTipPay && this.score == orderComment.score && Intrinsics.areEqual((Object) this.currency, (Object) orderComment.currency) && this.afterFavPrice == orderComment.afterFavPrice;
    }

    public int hashCode() {
        String str = this.title;
        int i = 0;
        int hashCode = (((((str == null ? 0 : str.hashCode()) * 31) + this.isShowTipPay) * 31) + this.score) * 31;
        String str2 = this.currency;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return ((hashCode + i) * 31) + this.afterFavPrice;
    }

    public String toString() {
        return "OrderComment(title=" + this.title + ", isShowTipPay=" + this.isShowTipPay + ", score=" + this.score + ", currency=" + this.currency + ", afterFavPrice=" + this.afterFavPrice + VersionRange.RIGHT_OPEN;
    }

    public OrderComment(String str, int i, int i2, String str2, int i3) {
        this.title = str;
        this.isShowTipPay = i;
        this.score = i2;
        this.currency = str2;
        this.afterFavPrice = i3;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ OrderComment(java.lang.String r5, int r6, int r7, java.lang.String r8, int r9, int r10, kotlin.jvm.internal.DefaultConstructorMarker r11) {
        /*
            r4 = this;
            r11 = r10 & 1
            r0 = 0
            if (r11 == 0) goto L_0x0007
            r11 = r0
            goto L_0x0008
        L_0x0007:
            r11 = r5
        L_0x0008:
            r5 = r10 & 2
            r1 = 0
            if (r5 == 0) goto L_0x000f
            r2 = 0
            goto L_0x0010
        L_0x000f:
            r2 = r6
        L_0x0010:
            r5 = r10 & 4
            if (r5 == 0) goto L_0x0016
            r3 = 0
            goto L_0x0017
        L_0x0016:
            r3 = r7
        L_0x0017:
            r5 = r10 & 8
            if (r5 == 0) goto L_0x001c
            goto L_0x001d
        L_0x001c:
            r0 = r8
        L_0x001d:
            r5 = r10 & 16
            if (r5 == 0) goto L_0x0023
            r10 = 0
            goto L_0x0024
        L_0x0023:
            r10 = r9
        L_0x0024:
            r5 = r4
            r6 = r11
            r7 = r2
            r8 = r3
            r9 = r0
            r5.<init>(r6, r7, r8, r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.customer.foundation.rpc.entity.OrderComment.<init>(java.lang.String, int, int, java.lang.String, int, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final String getTitle() {
        return this.title;
    }

    public final int isShowTipPay() {
        return this.isShowTipPay;
    }

    public final int getScore() {
        return this.score;
    }

    public final String getCurrency() {
        return this.currency;
    }

    public final int getAfterFavPrice() {
        return this.afterFavPrice;
    }

    @Metadata(mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo175978d2 = {"Lcom/didi/soda/customer/foundation/rpc/entity/OrderComment$Companion;", "", "()V", "serialVersionUID", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: OrderLayoutEntity.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
