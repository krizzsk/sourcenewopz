package com.didi.soda.customer.foundation.rpc.entity.cart;

import com.didi.soda.customer.foundation.rpc.entity.IEntity;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo175977d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b)\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\b\u0018\u0000 42\u00020\u0001:\u00014Bi\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003¢\u0006\u0002\u0010\rJ\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0005HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u0005HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010+\u001a\u00020\u0005HÆ\u0003J\t\u0010,\u001a\u00020\u0003HÆ\u0003Jm\u0010-\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\b\u001a\u00020\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\u0003HÆ\u0001J\u0013\u0010.\u001a\u00020/2\b\u00100\u001a\u0004\u0018\u000101HÖ\u0003J\t\u00102\u001a\u00020\u0005HÖ\u0001J\t\u00103\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000f\"\u0004\b\u0013\u0010\u0011R\u001a\u0010\u000b\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u000f\"\u0004\b\u0019\u0010\u0011R\u001c\u0010\n\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u000f\"\u0004\b\u001b\u0010\u0011R\u001a\u0010\b\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0015\"\u0004\b\u001d\u0010\u0017R\u001c\u0010\t\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u000f\"\u0004\b\u001f\u0010\u0011R\u001a\u0010\f\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u000f\"\u0004\b!\u0010\u0011R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0015\"\u0004\b#\u0010\u0017¨\u00065"}, mo175978d2 = {"Lcom/didi/soda/customer/foundation/rpc/entity/cart/CouponInfoEntity;", "Lcom/didi/soda/customer/foundation/rpc/entity/IEntity;", "couponId", "", "selected", "", "batchId", "activityId", "deductionAmount", "deductionAmountDisplay", "currency", "billCouponType", "relateId", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;ILjava/lang/String;)V", "getActivityId", "()Ljava/lang/String;", "setActivityId", "(Ljava/lang/String;)V", "getBatchId", "setBatchId", "getBillCouponType", "()I", "setBillCouponType", "(I)V", "getCouponId", "setCouponId", "getCurrency", "setCurrency", "getDeductionAmount", "setDeductionAmount", "getDeductionAmountDisplay", "setDeductionAmountDisplay", "getRelateId", "setRelateId", "getSelected", "setSelected", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "", "hashCode", "toString", "Companion", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CouponInfoEntity.kt */
public final class CouponInfoEntity implements IEntity {
    public static final int BILL_PLATFORM_COUPON = 0;
    public static final int BILL_R_COUPON = 101;
    public static final int BILL_SHOP_COUPON = 1;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int SELECTED_PICKING = 1;
    public static final int SELECTED_RECOMMEND = 0;
    private static final long serialVersionUID = 2555329472049138574L;
    private String activityId;
    private String batchId;
    private transient int billCouponType;
    private String couponId;
    private String currency;
    private int deductionAmount;
    private String deductionAmountDisplay;
    private String relateId;
    private int selected;

    public CouponInfoEntity() {
        this((String) null, 0, (String) null, (String) null, 0, (String) null, (String) null, 0, (String) null, 511, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ CouponInfoEntity copy$default(CouponInfoEntity couponInfoEntity, String str, int i, String str2, String str3, int i2, String str4, String str5, int i3, String str6, int i4, Object obj) {
        CouponInfoEntity couponInfoEntity2 = couponInfoEntity;
        int i5 = i4;
        return couponInfoEntity.copy((i5 & 1) != 0 ? couponInfoEntity2.couponId : str, (i5 & 2) != 0 ? couponInfoEntity2.selected : i, (i5 & 4) != 0 ? couponInfoEntity2.batchId : str2, (i5 & 8) != 0 ? couponInfoEntity2.activityId : str3, (i5 & 16) != 0 ? couponInfoEntity2.deductionAmount : i2, (i5 & 32) != 0 ? couponInfoEntity2.deductionAmountDisplay : str4, (i5 & 64) != 0 ? couponInfoEntity2.currency : str5, (i5 & 128) != 0 ? couponInfoEntity2.billCouponType : i3, (i5 & 256) != 0 ? couponInfoEntity2.relateId : str6);
    }

    public final String component1() {
        return this.couponId;
    }

    public final int component2() {
        return this.selected;
    }

    public final String component3() {
        return this.batchId;
    }

    public final String component4() {
        return this.activityId;
    }

    public final int component5() {
        return this.deductionAmount;
    }

    public final String component6() {
        return this.deductionAmountDisplay;
    }

    public final String component7() {
        return this.currency;
    }

    public final int component8() {
        return this.billCouponType;
    }

    public final String component9() {
        return this.relateId;
    }

    public final CouponInfoEntity copy(String str, int i, String str2, String str3, int i2, String str4, String str5, int i3, String str6) {
        String str7 = str6;
        Intrinsics.checkNotNullParameter(str7, "relateId");
        return new CouponInfoEntity(str, i, str2, str3, i2, str4, str5, i3, str7);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CouponInfoEntity)) {
            return false;
        }
        CouponInfoEntity couponInfoEntity = (CouponInfoEntity) obj;
        return Intrinsics.areEqual((Object) this.couponId, (Object) couponInfoEntity.couponId) && this.selected == couponInfoEntity.selected && Intrinsics.areEqual((Object) this.batchId, (Object) couponInfoEntity.batchId) && Intrinsics.areEqual((Object) this.activityId, (Object) couponInfoEntity.activityId) && this.deductionAmount == couponInfoEntity.deductionAmount && Intrinsics.areEqual((Object) this.deductionAmountDisplay, (Object) couponInfoEntity.deductionAmountDisplay) && Intrinsics.areEqual((Object) this.currency, (Object) couponInfoEntity.currency) && this.billCouponType == couponInfoEntity.billCouponType && Intrinsics.areEqual((Object) this.relateId, (Object) couponInfoEntity.relateId);
    }

    public int hashCode() {
        String str = this.couponId;
        int i = 0;
        int hashCode = (((str == null ? 0 : str.hashCode()) * 31) + this.selected) * 31;
        String str2 = this.batchId;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.activityId;
        int hashCode3 = (((hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31) + this.deductionAmount) * 31;
        String str4 = this.deductionAmountDisplay;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.currency;
        if (str5 != null) {
            i = str5.hashCode();
        }
        return ((((hashCode4 + i) * 31) + this.billCouponType) * 31) + this.relateId.hashCode();
    }

    public String toString() {
        return "CouponInfoEntity(couponId=" + this.couponId + ", selected=" + this.selected + ", batchId=" + this.batchId + ", activityId=" + this.activityId + ", deductionAmount=" + this.deductionAmount + ", deductionAmountDisplay=" + this.deductionAmountDisplay + ", currency=" + this.currency + ", billCouponType=" + this.billCouponType + ", relateId=" + this.relateId + VersionRange.RIGHT_OPEN;
    }

    public CouponInfoEntity(String str, int i, String str2, String str3, int i2, String str4, String str5, int i3, String str6) {
        Intrinsics.checkNotNullParameter(str6, "relateId");
        this.couponId = str;
        this.selected = i;
        this.batchId = str2;
        this.activityId = str3;
        this.deductionAmount = i2;
        this.deductionAmountDisplay = str4;
        this.currency = str5;
        this.billCouponType = i3;
        this.relateId = str6;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ CouponInfoEntity(java.lang.String r11, int r12, java.lang.String r13, java.lang.String r14, int r15, java.lang.String r16, java.lang.String r17, int r18, java.lang.String r19, int r20, kotlin.jvm.internal.DefaultConstructorMarker r21) {
        /*
            r10 = this;
            r0 = r20
            r1 = r0 & 1
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r1 = r2
            goto L_0x000a
        L_0x0009:
            r1 = r11
        L_0x000a:
            r3 = r0 & 2
            r4 = 0
            if (r3 == 0) goto L_0x0011
            r3 = 0
            goto L_0x0012
        L_0x0011:
            r3 = r12
        L_0x0012:
            r5 = r0 & 4
            if (r5 == 0) goto L_0x0018
            r5 = r2
            goto L_0x0019
        L_0x0018:
            r5 = r13
        L_0x0019:
            r6 = r0 & 8
            if (r6 == 0) goto L_0x001f
            r6 = r2
            goto L_0x0020
        L_0x001f:
            r6 = r14
        L_0x0020:
            r7 = r0 & 16
            if (r7 == 0) goto L_0x0026
            r7 = 0
            goto L_0x0027
        L_0x0026:
            r7 = r15
        L_0x0027:
            r8 = r0 & 32
            if (r8 == 0) goto L_0x002d
            r8 = r2
            goto L_0x002f
        L_0x002d:
            r8 = r16
        L_0x002f:
            r9 = r0 & 64
            if (r9 == 0) goto L_0x0034
            goto L_0x0036
        L_0x0034:
            r2 = r17
        L_0x0036:
            r9 = r0 & 128(0x80, float:1.794E-43)
            if (r9 == 0) goto L_0x003b
            goto L_0x003d
        L_0x003b:
            r4 = r18
        L_0x003d:
            r0 = r0 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L_0x0044
            java.lang.String r0 = ""
            goto L_0x0046
        L_0x0044:
            r0 = r19
        L_0x0046:
            r11 = r10
            r12 = r1
            r13 = r3
            r14 = r5
            r15 = r6
            r16 = r7
            r17 = r8
            r18 = r2
            r19 = r4
            r20 = r0
            r11.<init>(r12, r13, r14, r15, r16, r17, r18, r19, r20)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.customer.foundation.rpc.entity.cart.CouponInfoEntity.<init>(java.lang.String, int, java.lang.String, java.lang.String, int, java.lang.String, java.lang.String, int, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final String getCouponId() {
        return this.couponId;
    }

    public final void setCouponId(String str) {
        this.couponId = str;
    }

    public final int getSelected() {
        return this.selected;
    }

    public final void setSelected(int i) {
        this.selected = i;
    }

    public final String getBatchId() {
        return this.batchId;
    }

    public final void setBatchId(String str) {
        this.batchId = str;
    }

    public final String getActivityId() {
        return this.activityId;
    }

    public final void setActivityId(String str) {
        this.activityId = str;
    }

    public final int getDeductionAmount() {
        return this.deductionAmount;
    }

    public final void setDeductionAmount(int i) {
        this.deductionAmount = i;
    }

    public final String getDeductionAmountDisplay() {
        return this.deductionAmountDisplay;
    }

    public final void setDeductionAmountDisplay(String str) {
        this.deductionAmountDisplay = str;
    }

    public final String getCurrency() {
        return this.currency;
    }

    public final void setCurrency(String str) {
        this.currency = str;
    }

    public final int getBillCouponType() {
        return this.billCouponType;
    }

    public final void setBillCouponType(int i) {
        this.billCouponType = i;
    }

    public final String getRelateId() {
        return this.relateId;
    }

    public final void setRelateId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.relateId = str;
    }

    @Metadata(mo175977d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nXT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, mo175978d2 = {"Lcom/didi/soda/customer/foundation/rpc/entity/cart/CouponInfoEntity$Companion;", "", "()V", "BILL_PLATFORM_COUPON", "", "BILL_R_COUPON", "BILL_SHOP_COUPON", "SELECTED_PICKING", "SELECTED_RECOMMEND", "serialVersionUID", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: CouponInfoEntity.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
