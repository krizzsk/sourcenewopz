package com.didi.soda.customer.foundation.rpc.entity;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo175977d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\b\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB?\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\nJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003JC\u0010\u0018\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u0007HÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\f¨\u0006 "}, mo175978d2 = {"Lcom/didi/soda/customer/foundation/rpc/entity/DebtInfo;", "Lcom/didi/soda/customer/foundation/rpc/entity/IEntity;", "debtId", "", "payChannel", "Lcom/didi/soda/customer/foundation/rpc/entity/PayChannel;", "unpaidMoney", "", "unpaidMoneyDisplay", "transId", "(Ljava/lang/String;Lcom/didi/soda/customer/foundation/rpc/entity/PayChannel;ILjava/lang/String;Ljava/lang/String;)V", "getDebtId", "()Ljava/lang/String;", "getPayChannel", "()Lcom/didi/soda/customer/foundation/rpc/entity/PayChannel;", "getTransId", "getUnpaidMoney", "()I", "getUnpaidMoneyDisplay", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "toString", "Companion", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: OrderLayoutEntity.kt */
public final class DebtInfo implements IEntity {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final long serialVersionUID = -7331726169834727494L;
    private final String debtId;
    private final PayChannel payChannel;
    private final String transId;
    private final int unpaidMoney;
    private final String unpaidMoneyDisplay;

    public DebtInfo() {
        this((String) null, (PayChannel) null, 0, (String) null, (String) null, 31, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ DebtInfo copy$default(DebtInfo debtInfo, String str, PayChannel payChannel2, int i, String str2, String str3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = debtInfo.debtId;
        }
        if ((i2 & 2) != 0) {
            payChannel2 = debtInfo.payChannel;
        }
        PayChannel payChannel3 = payChannel2;
        if ((i2 & 4) != 0) {
            i = debtInfo.unpaidMoney;
        }
        int i3 = i;
        if ((i2 & 8) != 0) {
            str2 = debtInfo.unpaidMoneyDisplay;
        }
        String str4 = str2;
        if ((i2 & 16) != 0) {
            str3 = debtInfo.transId;
        }
        return debtInfo.copy(str, payChannel3, i3, str4, str3);
    }

    public final String component1() {
        return this.debtId;
    }

    public final PayChannel component2() {
        return this.payChannel;
    }

    public final int component3() {
        return this.unpaidMoney;
    }

    public final String component4() {
        return this.unpaidMoneyDisplay;
    }

    public final String component5() {
        return this.transId;
    }

    public final DebtInfo copy(String str, PayChannel payChannel2, int i, String str2, String str3) {
        return new DebtInfo(str, payChannel2, i, str2, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DebtInfo)) {
            return false;
        }
        DebtInfo debtInfo = (DebtInfo) obj;
        return Intrinsics.areEqual((Object) this.debtId, (Object) debtInfo.debtId) && Intrinsics.areEqual((Object) this.payChannel, (Object) debtInfo.payChannel) && this.unpaidMoney == debtInfo.unpaidMoney && Intrinsics.areEqual((Object) this.unpaidMoneyDisplay, (Object) debtInfo.unpaidMoneyDisplay) && Intrinsics.areEqual((Object) this.transId, (Object) debtInfo.transId);
    }

    public int hashCode() {
        String str = this.debtId;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        PayChannel payChannel2 = this.payChannel;
        int hashCode2 = (((hashCode + (payChannel2 == null ? 0 : payChannel2.hashCode())) * 31) + this.unpaidMoney) * 31;
        String str2 = this.unpaidMoneyDisplay;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.transId;
        if (str3 != null) {
            i = str3.hashCode();
        }
        return hashCode3 + i;
    }

    public String toString() {
        return "DebtInfo(debtId=" + this.debtId + ", payChannel=" + this.payChannel + ", unpaidMoney=" + this.unpaidMoney + ", unpaidMoneyDisplay=" + this.unpaidMoneyDisplay + ", transId=" + this.transId + VersionRange.RIGHT_OPEN;
    }

    public DebtInfo(String str, PayChannel payChannel2, int i, String str2, String str3) {
        this.debtId = str;
        this.payChannel = payChannel2;
        this.unpaidMoney = i;
        this.unpaidMoneyDisplay = str2;
        this.transId = str3;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ DebtInfo(java.lang.String r5, com.didi.soda.customer.foundation.rpc.entity.PayChannel r6, int r7, java.lang.String r8, java.lang.String r9, int r10, kotlin.jvm.internal.DefaultConstructorMarker r11) {
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
            if (r5 == 0) goto L_0x000e
            r1 = r0
            goto L_0x000f
        L_0x000e:
            r1 = r6
        L_0x000f:
            r5 = r10 & 4
            if (r5 == 0) goto L_0x0016
            r7 = 0
            r2 = 0
            goto L_0x0017
        L_0x0016:
            r2 = r7
        L_0x0017:
            r5 = r10 & 8
            if (r5 == 0) goto L_0x001d
            r3 = r0
            goto L_0x001e
        L_0x001d:
            r3 = r8
        L_0x001e:
            r5 = r10 & 16
            if (r5 == 0) goto L_0x0024
            r10 = r0
            goto L_0x0025
        L_0x0024:
            r10 = r9
        L_0x0025:
            r5 = r4
            r6 = r11
            r7 = r1
            r8 = r2
            r9 = r3
            r5.<init>(r6, r7, r8, r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.customer.foundation.rpc.entity.DebtInfo.<init>(java.lang.String, com.didi.soda.customer.foundation.rpc.entity.PayChannel, int, java.lang.String, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final String getDebtId() {
        return this.debtId;
    }

    public final PayChannel getPayChannel() {
        return this.payChannel;
    }

    public final int getUnpaidMoney() {
        return this.unpaidMoney;
    }

    public final String getUnpaidMoneyDisplay() {
        return this.unpaidMoneyDisplay;
    }

    public final String getTransId() {
        return this.transId;
    }

    @Metadata(mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo175978d2 = {"Lcom/didi/soda/customer/foundation/rpc/entity/DebtInfo$Companion;", "", "()V", "serialVersionUID", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: OrderLayoutEntity.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
