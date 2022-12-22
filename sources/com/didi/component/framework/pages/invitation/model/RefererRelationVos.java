package com.didi.component.framework.pages.invitation.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo175977d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0007\"\u0004\b\u000b\u0010\t¨\u0006\u0015"}, mo175978d2 = {"Lcom/didi/component/framework/pages/invitation/model/RefererRelationVos;", "", "rebateAmountFormat", "", "acquiredAmount", "(Ljava/lang/String;Ljava/lang/String;)V", "getAcquiredAmount", "()Ljava/lang/String;", "setAcquiredAmount", "(Ljava/lang/String;)V", "getRebateAmountFormat", "setRebateAmountFormat", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "framework_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: InvitePageModel.kt */
public final class RefererRelationVos {
    private String acquiredAmount;
    private String rebateAmountFormat;

    public static /* synthetic */ RefererRelationVos copy$default(RefererRelationVos refererRelationVos, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = refererRelationVos.rebateAmountFormat;
        }
        if ((i & 2) != 0) {
            str2 = refererRelationVos.acquiredAmount;
        }
        return refererRelationVos.copy(str, str2);
    }

    public final String component1() {
        return this.rebateAmountFormat;
    }

    public final String component2() {
        return this.acquiredAmount;
    }

    public final RefererRelationVos copy(String str, String str2) {
        return new RefererRelationVos(str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RefererRelationVos)) {
            return false;
        }
        RefererRelationVos refererRelationVos = (RefererRelationVos) obj;
        return Intrinsics.areEqual((Object) this.rebateAmountFormat, (Object) refererRelationVos.rebateAmountFormat) && Intrinsics.areEqual((Object) this.acquiredAmount, (Object) refererRelationVos.acquiredAmount);
    }

    public int hashCode() {
        String str = this.rebateAmountFormat;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.acquiredAmount;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "RefererRelationVos(rebateAmountFormat=" + this.rebateAmountFormat + ", acquiredAmount=" + this.acquiredAmount + VersionRange.RIGHT_OPEN;
    }

    public RefererRelationVos(String str, String str2) {
        this.rebateAmountFormat = str;
        this.acquiredAmount = str2;
    }

    public final String getRebateAmountFormat() {
        return this.rebateAmountFormat;
    }

    public final void setRebateAmountFormat(String str) {
        this.rebateAmountFormat = str;
    }

    public final String getAcquiredAmount() {
        return this.acquiredAmount;
    }

    public final void setAcquiredAmount(String str) {
        this.acquiredAmount = str;
    }
}
