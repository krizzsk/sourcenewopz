package com.didi.component.framework.pages.promo.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo175977d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001BA\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0011JV\u0010\u001c\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u001dJ\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\u0007HÖ\u0001J\t\u0010\"\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u0015\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0013\u0010\u0011R\u0015\u0010\t\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0014\u0010\u0011R\u0015\u0010\n\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0015\u0010\u0011¨\u0006#"}, mo175978d2 = {"Lcom/didi/component/framework/pages/promo/model/PromoApplyRsp;", "", "data", "Lcom/didi/component/framework/pages/promo/model/PromoData;", "errmsg", "", "errno", "", "pageNo", "pageSize", "totalCount", "(Lcom/didi/component/framework/pages/promo/model/PromoData;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getData", "()Lcom/didi/component/framework/pages/promo/model/PromoData;", "getErrmsg", "()Ljava/lang/String;", "getErrno", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getPageNo", "getPageSize", "getTotalCount", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Lcom/didi/component/framework/pages/promo/model/PromoData;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/didi/component/framework/pages/promo/model/PromoApplyRsp;", "equals", "", "other", "hashCode", "toString", "framework_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: PromoResponse.kt */
public final class PromoApplyRsp {
    private final PromoData data;
    private final String errmsg;
    private final Integer errno;
    private final Integer pageNo;
    private final Integer pageSize;
    private final Integer totalCount;

    public static /* synthetic */ PromoApplyRsp copy$default(PromoApplyRsp promoApplyRsp, PromoData promoData, String str, Integer num, Integer num2, Integer num3, Integer num4, int i, Object obj) {
        if ((i & 1) != 0) {
            promoData = promoApplyRsp.data;
        }
        if ((i & 2) != 0) {
            str = promoApplyRsp.errmsg;
        }
        String str2 = str;
        if ((i & 4) != 0) {
            num = promoApplyRsp.errno;
        }
        Integer num5 = num;
        if ((i & 8) != 0) {
            num2 = promoApplyRsp.pageNo;
        }
        Integer num6 = num2;
        if ((i & 16) != 0) {
            num3 = promoApplyRsp.pageSize;
        }
        Integer num7 = num3;
        if ((i & 32) != 0) {
            num4 = promoApplyRsp.totalCount;
        }
        return promoApplyRsp.copy(promoData, str2, num5, num6, num7, num4);
    }

    public final PromoData component1() {
        return this.data;
    }

    public final String component2() {
        return this.errmsg;
    }

    public final Integer component3() {
        return this.errno;
    }

    public final Integer component4() {
        return this.pageNo;
    }

    public final Integer component5() {
        return this.pageSize;
    }

    public final Integer component6() {
        return this.totalCount;
    }

    public final PromoApplyRsp copy(PromoData promoData, String str, Integer num, Integer num2, Integer num3, Integer num4) {
        return new PromoApplyRsp(promoData, str, num, num2, num3, num4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PromoApplyRsp)) {
            return false;
        }
        PromoApplyRsp promoApplyRsp = (PromoApplyRsp) obj;
        return Intrinsics.areEqual((Object) this.data, (Object) promoApplyRsp.data) && Intrinsics.areEqual((Object) this.errmsg, (Object) promoApplyRsp.errmsg) && Intrinsics.areEqual((Object) this.errno, (Object) promoApplyRsp.errno) && Intrinsics.areEqual((Object) this.pageNo, (Object) promoApplyRsp.pageNo) && Intrinsics.areEqual((Object) this.pageSize, (Object) promoApplyRsp.pageSize) && Intrinsics.areEqual((Object) this.totalCount, (Object) promoApplyRsp.totalCount);
    }

    public int hashCode() {
        PromoData promoData = this.data;
        int i = 0;
        int hashCode = (promoData == null ? 0 : promoData.hashCode()) * 31;
        String str = this.errmsg;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        Integer num = this.errno;
        int hashCode3 = (hashCode2 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.pageNo;
        int hashCode4 = (hashCode3 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.pageSize;
        int hashCode5 = (hashCode4 + (num3 == null ? 0 : num3.hashCode())) * 31;
        Integer num4 = this.totalCount;
        if (num4 != null) {
            i = num4.hashCode();
        }
        return hashCode5 + i;
    }

    public String toString() {
        return "PromoApplyRsp(data=" + this.data + ", errmsg=" + this.errmsg + ", errno=" + this.errno + ", pageNo=" + this.pageNo + ", pageSize=" + this.pageSize + ", totalCount=" + this.totalCount + VersionRange.RIGHT_OPEN;
    }

    public PromoApplyRsp(PromoData promoData, String str, Integer num, Integer num2, Integer num3, Integer num4) {
        this.data = promoData;
        this.errmsg = str;
        this.errno = num;
        this.pageNo = num2;
        this.pageSize = num3;
        this.totalCount = num4;
    }

    public final PromoData getData() {
        return this.data;
    }

    public final String getErrmsg() {
        return this.errmsg;
    }

    public final Integer getErrno() {
        return this.errno;
    }

    public final Integer getPageNo() {
        return this.pageNo;
    }

    public final Integer getPageSize() {
        return this.pageSize;
    }

    public final Integer getTotalCount() {
        return this.totalCount;
    }
}
