package com.didi.entrega.customer.foundation.rpc.entity.order;

import com.didi.entrega.customer.foundation.rpc.entity.IEntity;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo175977d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b$\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\b\u0018\u0000 02\u00020\u0001:\u00010B\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0006\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0006¢\u0006\u0002\u0010\u0010J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0006HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0006HÆ\u0003J\t\u0010#\u001a\u00020\u0006HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0006HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0001\u0010)\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00062\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u0006HÆ\u0001J\u0013\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010-HÖ\u0003J\t\u0010.\u001a\u00020\u0006HÖ\u0001J\t\u0010/\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0014R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0014R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u0011\u0010\u000b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0012R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0012R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0012R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0012R\u0011\u0010\u000f\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0014¨\u00061"}, mo175978d2 = {"Lcom/didi/entrega/customer/foundation/rpc/entity/order/OrderRiderInfo;", "Lcom/didi/entrega/customer/foundation/rpc/entity/IEntity;", "name", "", "headPic", "isOpenIm", "", "isOpenPhone", "riderUid", "riderId", "phone", "phoneProtected", "imSecret", "senderPhone", "senderCallingCode", "senderPhoneCountryId", "(Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "getHeadPic", "()Ljava/lang/String;", "getImSecret", "()I", "getName", "getPhone", "getPhoneProtected", "getRiderId", "getRiderUid", "getSenderCallingCode", "getSenderPhone", "getSenderPhoneCountryId", "component1", "component10", "component11", "component12", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "", "hashCode", "toString", "Companion", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: OrderInfoEntity.kt */
public final class OrderRiderInfo implements IEntity {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final long serialVersionUID = 5726301245471723670L;
    private final String headPic;
    private final String imSecret;
    private final int isOpenIm;
    private final int isOpenPhone;
    private final String name;
    private final String phone;
    private final int phoneProtected;
    private final String riderId;
    private final String riderUid;
    private final String senderCallingCode;
    private final String senderPhone;
    private final int senderPhoneCountryId;

    public OrderRiderInfo() {
        this((String) null, (String) null, 0, 0, (String) null, (String) null, (String) null, 0, (String) null, (String) null, (String) null, 0, 4095, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ OrderRiderInfo copy$default(OrderRiderInfo orderRiderInfo, String str, String str2, int i, int i2, String str3, String str4, String str5, int i3, String str6, String str7, String str8, int i4, int i5, Object obj) {
        OrderRiderInfo orderRiderInfo2 = orderRiderInfo;
        int i6 = i5;
        return orderRiderInfo.copy((i6 & 1) != 0 ? orderRiderInfo2.name : str, (i6 & 2) != 0 ? orderRiderInfo2.headPic : str2, (i6 & 4) != 0 ? orderRiderInfo2.isOpenIm : i, (i6 & 8) != 0 ? orderRiderInfo2.isOpenPhone : i2, (i6 & 16) != 0 ? orderRiderInfo2.riderUid : str3, (i6 & 32) != 0 ? orderRiderInfo2.riderId : str4, (i6 & 64) != 0 ? orderRiderInfo2.phone : str5, (i6 & 128) != 0 ? orderRiderInfo2.phoneProtected : i3, (i6 & 256) != 0 ? orderRiderInfo2.imSecret : str6, (i6 & 512) != 0 ? orderRiderInfo2.senderPhone : str7, (i6 & 1024) != 0 ? orderRiderInfo2.senderCallingCode : str8, (i6 & 2048) != 0 ? orderRiderInfo2.senderPhoneCountryId : i4);
    }

    public final String component1() {
        return this.name;
    }

    public final String component10() {
        return this.senderPhone;
    }

    public final String component11() {
        return this.senderCallingCode;
    }

    public final int component12() {
        return this.senderPhoneCountryId;
    }

    public final String component2() {
        return this.headPic;
    }

    public final int component3() {
        return this.isOpenIm;
    }

    public final int component4() {
        return this.isOpenPhone;
    }

    public final String component5() {
        return this.riderUid;
    }

    public final String component6() {
        return this.riderId;
    }

    public final String component7() {
        return this.phone;
    }

    public final int component8() {
        return this.phoneProtected;
    }

    public final String component9() {
        return this.imSecret;
    }

    public final OrderRiderInfo copy(String str, String str2, int i, int i2, String str3, String str4, String str5, int i3, String str6, String str7, String str8, int i4) {
        return new OrderRiderInfo(str, str2, i, i2, str3, str4, str5, i3, str6, str7, str8, i4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OrderRiderInfo)) {
            return false;
        }
        OrderRiderInfo orderRiderInfo = (OrderRiderInfo) obj;
        return Intrinsics.areEqual((Object) this.name, (Object) orderRiderInfo.name) && Intrinsics.areEqual((Object) this.headPic, (Object) orderRiderInfo.headPic) && this.isOpenIm == orderRiderInfo.isOpenIm && this.isOpenPhone == orderRiderInfo.isOpenPhone && Intrinsics.areEqual((Object) this.riderUid, (Object) orderRiderInfo.riderUid) && Intrinsics.areEqual((Object) this.riderId, (Object) orderRiderInfo.riderId) && Intrinsics.areEqual((Object) this.phone, (Object) orderRiderInfo.phone) && this.phoneProtected == orderRiderInfo.phoneProtected && Intrinsics.areEqual((Object) this.imSecret, (Object) orderRiderInfo.imSecret) && Intrinsics.areEqual((Object) this.senderPhone, (Object) orderRiderInfo.senderPhone) && Intrinsics.areEqual((Object) this.senderCallingCode, (Object) orderRiderInfo.senderCallingCode) && this.senderPhoneCountryId == orderRiderInfo.senderPhoneCountryId;
    }

    public int hashCode() {
        String str = this.name;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.headPic;
        int hashCode2 = (((((hashCode + (str2 == null ? 0 : str2.hashCode())) * 31) + this.isOpenIm) * 31) + this.isOpenPhone) * 31;
        String str3 = this.riderUid;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.riderId;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.phone;
        int hashCode5 = (((hashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31) + this.phoneProtected) * 31;
        String str6 = this.imSecret;
        int hashCode6 = (hashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.senderPhone;
        int hashCode7 = (hashCode6 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.senderCallingCode;
        if (str8 != null) {
            i = str8.hashCode();
        }
        return ((hashCode7 + i) * 31) + this.senderPhoneCountryId;
    }

    public String toString() {
        return "OrderRiderInfo(name=" + this.name + ", headPic=" + this.headPic + ", isOpenIm=" + this.isOpenIm + ", isOpenPhone=" + this.isOpenPhone + ", riderUid=" + this.riderUid + ", riderId=" + this.riderId + ", phone=" + this.phone + ", phoneProtected=" + this.phoneProtected + ", imSecret=" + this.imSecret + ", senderPhone=" + this.senderPhone + ", senderCallingCode=" + this.senderCallingCode + ", senderPhoneCountryId=" + this.senderPhoneCountryId + VersionRange.RIGHT_OPEN;
    }

    public OrderRiderInfo(String str, String str2, int i, int i2, String str3, String str4, String str5, int i3, String str6, String str7, String str8, int i4) {
        this.name = str;
        this.headPic = str2;
        this.isOpenIm = i;
        this.isOpenPhone = i2;
        this.riderUid = str3;
        this.riderId = str4;
        this.phone = str5;
        this.phoneProtected = i3;
        this.imSecret = str6;
        this.senderPhone = str7;
        this.senderCallingCode = str8;
        this.senderPhoneCountryId = i4;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ OrderRiderInfo(java.lang.String r15, java.lang.String r16, int r17, int r18, java.lang.String r19, java.lang.String r20, java.lang.String r21, int r22, java.lang.String r23, java.lang.String r24, java.lang.String r25, int r26, int r27, kotlin.jvm.internal.DefaultConstructorMarker r28) {
        /*
            r14 = this;
            r0 = r27
            r1 = r0 & 1
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r1 = r2
            goto L_0x000a
        L_0x0009:
            r1 = r15
        L_0x000a:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0010
            r3 = r2
            goto L_0x0012
        L_0x0010:
            r3 = r16
        L_0x0012:
            r4 = r0 & 4
            r5 = 0
            if (r4 == 0) goto L_0x0019
            r4 = 0
            goto L_0x001b
        L_0x0019:
            r4 = r17
        L_0x001b:
            r6 = r0 & 8
            if (r6 == 0) goto L_0x0021
            r6 = 0
            goto L_0x0023
        L_0x0021:
            r6 = r18
        L_0x0023:
            r7 = r0 & 16
            if (r7 == 0) goto L_0x0029
            r7 = r2
            goto L_0x002b
        L_0x0029:
            r7 = r19
        L_0x002b:
            r8 = r0 & 32
            if (r8 == 0) goto L_0x0031
            r8 = r2
            goto L_0x0033
        L_0x0031:
            r8 = r20
        L_0x0033:
            r9 = r0 & 64
            if (r9 == 0) goto L_0x0039
            r9 = r2
            goto L_0x003b
        L_0x0039:
            r9 = r21
        L_0x003b:
            r10 = r0 & 128(0x80, float:1.794E-43)
            if (r10 == 0) goto L_0x0041
            r10 = 0
            goto L_0x0043
        L_0x0041:
            r10 = r22
        L_0x0043:
            r11 = r0 & 256(0x100, float:3.59E-43)
            if (r11 == 0) goto L_0x0049
            r11 = r2
            goto L_0x004b
        L_0x0049:
            r11 = r23
        L_0x004b:
            r12 = r0 & 512(0x200, float:7.175E-43)
            if (r12 == 0) goto L_0x0051
            r12 = r2
            goto L_0x0053
        L_0x0051:
            r12 = r24
        L_0x0053:
            r13 = r0 & 1024(0x400, float:1.435E-42)
            if (r13 == 0) goto L_0x0058
            goto L_0x005a
        L_0x0058:
            r2 = r25
        L_0x005a:
            r0 = r0 & 2048(0x800, float:2.87E-42)
            if (r0 == 0) goto L_0x005f
            goto L_0x0061
        L_0x005f:
            r5 = r26
        L_0x0061:
            r15 = r14
            r16 = r1
            r17 = r3
            r18 = r4
            r19 = r6
            r20 = r7
            r21 = r8
            r22 = r9
            r23 = r10
            r24 = r11
            r25 = r12
            r26 = r2
            r27 = r5
            r15.<init>(r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.entrega.customer.foundation.rpc.entity.order.OrderRiderInfo.<init>(java.lang.String, java.lang.String, int, int, java.lang.String, java.lang.String, java.lang.String, int, java.lang.String, java.lang.String, java.lang.String, int, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final String getName() {
        return this.name;
    }

    public final String getHeadPic() {
        return this.headPic;
    }

    public final int isOpenIm() {
        return this.isOpenIm;
    }

    public final int isOpenPhone() {
        return this.isOpenPhone;
    }

    public final String getRiderUid() {
        return this.riderUid;
    }

    public final String getRiderId() {
        return this.riderId;
    }

    public final String getPhone() {
        return this.phone;
    }

    public final int getPhoneProtected() {
        return this.phoneProtected;
    }

    public final String getImSecret() {
        return this.imSecret;
    }

    public final String getSenderPhone() {
        return this.senderPhone;
    }

    public final String getSenderCallingCode() {
        return this.senderCallingCode;
    }

    public final int getSenderPhoneCountryId() {
        return this.senderPhoneCountryId;
    }

    @Metadata(mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo175978d2 = {"Lcom/didi/entrega/customer/foundation/rpc/entity/order/OrderRiderInfo$Companion;", "", "()V", "serialVersionUID", "", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: OrderInfoEntity.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
