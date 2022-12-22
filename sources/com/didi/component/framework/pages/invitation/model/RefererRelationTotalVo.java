package com.didi.component.framework.pages.invitation.model;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo175977d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b(\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001Bu\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0012J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\u0010\u0010%\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u001eJ\u000b\u0010&\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010(\u001a\u00020\u0007HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0011\u0010*\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nHÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010,\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u001eJ\u0010\u0010-\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u001eJ\u000b\u0010.\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0001\u0010/\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u00100J\u0013\u00101\u001a\u00020\u00032\b\u00102\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00103\u001a\u000204HÖ\u0001J\t\u00105\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0016R\u0019\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0013\u0010\f\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0016R\u0015\u0010\r\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b\u001d\u0010\u001eR\u0015\u0010\u000e\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b \u0010\u001eR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0016R\u0015\u0010\u0010\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b\"\u0010\u001eR\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0016¨\u00066"}, mo175978d2 = {"Lcom/didi/component/framework/pages/invitation/model/RefererRelationTotalVo;", "", "currencyFirst", "", "currencySymbol", "", "receivedAmount", "", "receivedAmountFormat", "refererRelationVos", "", "Lcom/didi/component/framework/pages/invitation/model/RefererRelationVo;", "referrerCode", "referrerId", "restAmount", "restAmountFormat", "totalAmount", "totalAmountFormat", "(ZLjava/lang/String;JLjava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;)V", "getCurrencyFirst", "()Z", "getCurrencySymbol", "()Ljava/lang/String;", "getReceivedAmount", "()J", "getReceivedAmountFormat", "getRefererRelationVos", "()Ljava/util/List;", "getReferrerCode", "getReferrerId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getRestAmount", "getRestAmountFormat", "getTotalAmount", "getTotalAmountFormat", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(ZLjava/lang/String;JLjava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;)Lcom/didi/component/framework/pages/invitation/model/RefererRelationTotalVo;", "equals", "other", "hashCode", "", "toString", "framework_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: InviteListModel.kt */
public final class RefererRelationTotalVo {
    private final boolean currencyFirst;
    private final String currencySymbol;
    private final long receivedAmount;
    private final String receivedAmountFormat;
    private final List<RefererRelationVo> refererRelationVos;
    private final String referrerCode;
    private final Long referrerId;
    private final Long restAmount;
    private final String restAmountFormat;
    private final Long totalAmount;
    private final String totalAmountFormat;

    public static /* synthetic */ RefererRelationTotalVo copy$default(RefererRelationTotalVo refererRelationTotalVo, boolean z, String str, long j, String str2, List list, String str3, Long l, Long l2, String str4, Long l3, String str5, int i, Object obj) {
        RefererRelationTotalVo refererRelationTotalVo2 = refererRelationTotalVo;
        int i2 = i;
        return refererRelationTotalVo.copy((i2 & 1) != 0 ? refererRelationTotalVo2.currencyFirst : z, (i2 & 2) != 0 ? refererRelationTotalVo2.currencySymbol : str, (i2 & 4) != 0 ? refererRelationTotalVo2.receivedAmount : j, (i2 & 8) != 0 ? refererRelationTotalVo2.receivedAmountFormat : str2, (i2 & 16) != 0 ? refererRelationTotalVo2.refererRelationVos : list, (i2 & 32) != 0 ? refererRelationTotalVo2.referrerCode : str3, (i2 & 64) != 0 ? refererRelationTotalVo2.referrerId : l, (i2 & 128) != 0 ? refererRelationTotalVo2.restAmount : l2, (i2 & 256) != 0 ? refererRelationTotalVo2.restAmountFormat : str4, (i2 & 512) != 0 ? refererRelationTotalVo2.totalAmount : l3, (i2 & 1024) != 0 ? refererRelationTotalVo2.totalAmountFormat : str5);
    }

    public final boolean component1() {
        return this.currencyFirst;
    }

    public final Long component10() {
        return this.totalAmount;
    }

    public final String component11() {
        return this.totalAmountFormat;
    }

    public final String component2() {
        return this.currencySymbol;
    }

    public final long component3() {
        return this.receivedAmount;
    }

    public final String component4() {
        return this.receivedAmountFormat;
    }

    public final List<RefererRelationVo> component5() {
        return this.refererRelationVos;
    }

    public final String component6() {
        return this.referrerCode;
    }

    public final Long component7() {
        return this.referrerId;
    }

    public final Long component8() {
        return this.restAmount;
    }

    public final String component9() {
        return this.restAmountFormat;
    }

    public final RefererRelationTotalVo copy(boolean z, String str, long j, String str2, List<RefererRelationVo> list, String str3, Long l, Long l2, String str4, Long l3, String str5) {
        return new RefererRelationTotalVo(z, str, j, str2, list, str3, l, l2, str4, l3, str5);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RefererRelationTotalVo)) {
            return false;
        }
        RefererRelationTotalVo refererRelationTotalVo = (RefererRelationTotalVo) obj;
        return this.currencyFirst == refererRelationTotalVo.currencyFirst && Intrinsics.areEqual((Object) this.currencySymbol, (Object) refererRelationTotalVo.currencySymbol) && this.receivedAmount == refererRelationTotalVo.receivedAmount && Intrinsics.areEqual((Object) this.receivedAmountFormat, (Object) refererRelationTotalVo.receivedAmountFormat) && Intrinsics.areEqual((Object) this.refererRelationVos, (Object) refererRelationTotalVo.refererRelationVos) && Intrinsics.areEqual((Object) this.referrerCode, (Object) refererRelationTotalVo.referrerCode) && Intrinsics.areEqual((Object) this.referrerId, (Object) refererRelationTotalVo.referrerId) && Intrinsics.areEqual((Object) this.restAmount, (Object) refererRelationTotalVo.restAmount) && Intrinsics.areEqual((Object) this.restAmountFormat, (Object) refererRelationTotalVo.restAmountFormat) && Intrinsics.areEqual((Object) this.totalAmount, (Object) refererRelationTotalVo.totalAmount) && Intrinsics.areEqual((Object) this.totalAmountFormat, (Object) refererRelationTotalVo.totalAmountFormat);
    }

    public int hashCode() {
        boolean z = this.currencyFirst;
        if (z) {
            z = true;
        }
        int i = (z ? 1 : 0) * true;
        String str = this.currencySymbol;
        int i2 = 0;
        int hashCode = (((i + (str == null ? 0 : str.hashCode())) * 31) + C$r8$backportedMethods$utility$Long$1$hashCode.hashCode(this.receivedAmount)) * 31;
        String str2 = this.receivedAmountFormat;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        List<RefererRelationVo> list = this.refererRelationVos;
        int hashCode3 = (hashCode2 + (list == null ? 0 : list.hashCode())) * 31;
        String str3 = this.referrerCode;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Long l = this.referrerId;
        int hashCode5 = (hashCode4 + (l == null ? 0 : l.hashCode())) * 31;
        Long l2 = this.restAmount;
        int hashCode6 = (hashCode5 + (l2 == null ? 0 : l2.hashCode())) * 31;
        String str4 = this.restAmountFormat;
        int hashCode7 = (hashCode6 + (str4 == null ? 0 : str4.hashCode())) * 31;
        Long l3 = this.totalAmount;
        int hashCode8 = (hashCode7 + (l3 == null ? 0 : l3.hashCode())) * 31;
        String str5 = this.totalAmountFormat;
        if (str5 != null) {
            i2 = str5.hashCode();
        }
        return hashCode8 + i2;
    }

    public String toString() {
        return "RefererRelationTotalVo(currencyFirst=" + this.currencyFirst + ", currencySymbol=" + this.currencySymbol + ", receivedAmount=" + this.receivedAmount + ", receivedAmountFormat=" + this.receivedAmountFormat + ", refererRelationVos=" + this.refererRelationVos + ", referrerCode=" + this.referrerCode + ", referrerId=" + this.referrerId + ", restAmount=" + this.restAmount + ", restAmountFormat=" + this.restAmountFormat + ", totalAmount=" + this.totalAmount + ", totalAmountFormat=" + this.totalAmountFormat + VersionRange.RIGHT_OPEN;
    }

    public RefererRelationTotalVo(boolean z, String str, long j, String str2, List<RefererRelationVo> list, String str3, Long l, Long l2, String str4, Long l3, String str5) {
        this.currencyFirst = z;
        this.currencySymbol = str;
        this.receivedAmount = j;
        this.receivedAmountFormat = str2;
        this.refererRelationVos = list;
        this.referrerCode = str3;
        this.referrerId = l;
        this.restAmount = l2;
        this.restAmountFormat = str4;
        this.totalAmount = l3;
        this.totalAmountFormat = str5;
    }

    public final boolean getCurrencyFirst() {
        return this.currencyFirst;
    }

    public final String getCurrencySymbol() {
        return this.currencySymbol;
    }

    public final long getReceivedAmount() {
        return this.receivedAmount;
    }

    public final String getReceivedAmountFormat() {
        return this.receivedAmountFormat;
    }

    public final List<RefererRelationVo> getRefererRelationVos() {
        return this.refererRelationVos;
    }

    public final String getReferrerCode() {
        return this.referrerCode;
    }

    public final Long getReferrerId() {
        return this.referrerId;
    }

    public final Long getRestAmount() {
        return this.restAmount;
    }

    public final String getRestAmountFormat() {
        return this.restAmountFormat;
    }

    public final Long getTotalAmount() {
        return this.totalAmount;
    }

    public final String getTotalAmountFormat() {
        return this.totalAmountFormat;
    }
}
