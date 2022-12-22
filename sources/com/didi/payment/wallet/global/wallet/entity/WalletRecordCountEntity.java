package com.didi.payment.wallet.global.wallet.entity;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo175977d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u001f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001Bq\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\rJ\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0011J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0011J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003Jz\u0010\"\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010#J\u0013\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010'\u001a\u00020(HÖ\u0001J\t\u0010)\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0007\u0010\u0011R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000fR\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000fR\u0018\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000fR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000fR\u0018\u0010\f\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u000f¨\u0006*"}, mo175978d2 = {"Lcom/didi/payment/wallet/global/wallet/entity/WalletRecordCountEntity;", "", "amount", "", "amountColor", "", "businessType", "isDetail", "month", "time", "title", "transactionId", "year", "(Ljava/lang/String;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAmount", "()Ljava/lang/String;", "getAmountColor", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getBusinessType", "getMonth", "getTime", "getTitle", "getTransactionId", "getYear", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/didi/payment/wallet/global/wallet/entity/WalletRecordCountEntity;", "equals", "", "other", "hashCode", "", "toString", "wallet_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: WalletRecordCountEntity.kt */
public final class WalletRecordCountEntity {
    @SerializedName("amount")
    private final String amount;
    @SerializedName("amountColor")
    private final Double amountColor;
    @SerializedName("businessType")
    private final String businessType;
    @SerializedName("isDetail")
    private final Double isDetail;
    @SerializedName("month")
    private final String month;
    @SerializedName("time")
    private final String time;
    @SerializedName("title")
    private final String title;
    @SerializedName("transactionId")
    private final String transactionId;
    @SerializedName("year")
    private final String year;

    public WalletRecordCountEntity() {
        this((String) null, (Double) null, (String) null, (Double) null, (String) null, (String) null, (String) null, (String) null, (String) null, 511, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ WalletRecordCountEntity copy$default(WalletRecordCountEntity walletRecordCountEntity, String str, Double d, String str2, Double d2, String str3, String str4, String str5, String str6, String str7, int i, Object obj) {
        WalletRecordCountEntity walletRecordCountEntity2 = walletRecordCountEntity;
        int i2 = i;
        return walletRecordCountEntity.copy((i2 & 1) != 0 ? walletRecordCountEntity2.amount : str, (i2 & 2) != 0 ? walletRecordCountEntity2.amountColor : d, (i2 & 4) != 0 ? walletRecordCountEntity2.businessType : str2, (i2 & 8) != 0 ? walletRecordCountEntity2.isDetail : d2, (i2 & 16) != 0 ? walletRecordCountEntity2.month : str3, (i2 & 32) != 0 ? walletRecordCountEntity2.time : str4, (i2 & 64) != 0 ? walletRecordCountEntity2.title : str5, (i2 & 128) != 0 ? walletRecordCountEntity2.transactionId : str6, (i2 & 256) != 0 ? walletRecordCountEntity2.year : str7);
    }

    public final String component1() {
        return this.amount;
    }

    public final Double component2() {
        return this.amountColor;
    }

    public final String component3() {
        return this.businessType;
    }

    public final Double component4() {
        return this.isDetail;
    }

    public final String component5() {
        return this.month;
    }

    public final String component6() {
        return this.time;
    }

    public final String component7() {
        return this.title;
    }

    public final String component8() {
        return this.transactionId;
    }

    public final String component9() {
        return this.year;
    }

    public final WalletRecordCountEntity copy(String str, Double d, String str2, Double d2, String str3, String str4, String str5, String str6, String str7) {
        return new WalletRecordCountEntity(str, d, str2, d2, str3, str4, str5, str6, str7);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WalletRecordCountEntity)) {
            return false;
        }
        WalletRecordCountEntity walletRecordCountEntity = (WalletRecordCountEntity) obj;
        return Intrinsics.areEqual((Object) this.amount, (Object) walletRecordCountEntity.amount) && Intrinsics.areEqual((Object) this.amountColor, (Object) walletRecordCountEntity.amountColor) && Intrinsics.areEqual((Object) this.businessType, (Object) walletRecordCountEntity.businessType) && Intrinsics.areEqual((Object) this.isDetail, (Object) walletRecordCountEntity.isDetail) && Intrinsics.areEqual((Object) this.month, (Object) walletRecordCountEntity.month) && Intrinsics.areEqual((Object) this.time, (Object) walletRecordCountEntity.time) && Intrinsics.areEqual((Object) this.title, (Object) walletRecordCountEntity.title) && Intrinsics.areEqual((Object) this.transactionId, (Object) walletRecordCountEntity.transactionId) && Intrinsics.areEqual((Object) this.year, (Object) walletRecordCountEntity.year);
    }

    public int hashCode() {
        String str = this.amount;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        Double d = this.amountColor;
        int hashCode2 = (hashCode + (d == null ? 0 : d.hashCode())) * 31;
        String str2 = this.businessType;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Double d2 = this.isDetail;
        int hashCode4 = (hashCode3 + (d2 == null ? 0 : d2.hashCode())) * 31;
        String str3 = this.month;
        int hashCode5 = (hashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.time;
        int hashCode6 = (hashCode5 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.title;
        int hashCode7 = (hashCode6 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.transactionId;
        int hashCode8 = (hashCode7 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.year;
        if (str7 != null) {
            i = str7.hashCode();
        }
        return hashCode8 + i;
    }

    public String toString() {
        return "WalletRecordCountEntity(amount=" + this.amount + ", amountColor=" + this.amountColor + ", businessType=" + this.businessType + ", isDetail=" + this.isDetail + ", month=" + this.month + ", time=" + this.time + ", title=" + this.title + ", transactionId=" + this.transactionId + ", year=" + this.year + VersionRange.RIGHT_OPEN;
    }

    public WalletRecordCountEntity(String str, Double d, String str2, Double d2, String str3, String str4, String str5, String str6, String str7) {
        this.amount = str;
        this.amountColor = d;
        this.businessType = str2;
        this.isDetail = d2;
        this.month = str3;
        this.time = str4;
        this.title = str5;
        this.transactionId = str6;
        this.year = str7;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ WalletRecordCountEntity(java.lang.String r11, java.lang.Double r12, java.lang.String r13, java.lang.Double r14, java.lang.String r15, java.lang.String r16, java.lang.String r17, java.lang.String r18, java.lang.String r19, int r20, kotlin.jvm.internal.DefaultConstructorMarker r21) {
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
            if (r3 == 0) goto L_0x0010
            r3 = r2
            goto L_0x0011
        L_0x0010:
            r3 = r12
        L_0x0011:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x0017
            r4 = r2
            goto L_0x0018
        L_0x0017:
            r4 = r13
        L_0x0018:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x001e
            r5 = r2
            goto L_0x001f
        L_0x001e:
            r5 = r14
        L_0x001f:
            r6 = r0 & 16
            if (r6 == 0) goto L_0x0025
            r6 = r2
            goto L_0x0026
        L_0x0025:
            r6 = r15
        L_0x0026:
            r7 = r0 & 32
            if (r7 == 0) goto L_0x002c
            r7 = r2
            goto L_0x002e
        L_0x002c:
            r7 = r16
        L_0x002e:
            r8 = r0 & 64
            if (r8 == 0) goto L_0x0034
            r8 = r2
            goto L_0x0036
        L_0x0034:
            r8 = r17
        L_0x0036:
            r9 = r0 & 128(0x80, float:1.794E-43)
            if (r9 == 0) goto L_0x003c
            r9 = r2
            goto L_0x003e
        L_0x003c:
            r9 = r18
        L_0x003e:
            r0 = r0 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L_0x0043
            goto L_0x0045
        L_0x0043:
            r2 = r19
        L_0x0045:
            r11 = r10
            r12 = r1
            r13 = r3
            r14 = r4
            r15 = r5
            r16 = r6
            r17 = r7
            r18 = r8
            r19 = r9
            r20 = r2
            r11.<init>(r12, r13, r14, r15, r16, r17, r18, r19, r20)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.payment.wallet.global.wallet.entity.WalletRecordCountEntity.<init>(java.lang.String, java.lang.Double, java.lang.String, java.lang.Double, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final String getAmount() {
        return this.amount;
    }

    public final Double getAmountColor() {
        return this.amountColor;
    }

    public final String getBusinessType() {
        return this.businessType;
    }

    public final Double isDetail() {
        return this.isDetail;
    }

    public final String getMonth() {
        return this.month;
    }

    public final String getTime() {
        return this.time;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getTransactionId() {
        return this.transactionId;
    }

    public final String getYear() {
        return this.year;
    }
}
