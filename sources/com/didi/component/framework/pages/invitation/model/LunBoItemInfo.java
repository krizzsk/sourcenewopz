package com.didi.component.framework.pages.invitation.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo175977d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B#\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\tJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J2\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0017J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0010\n\u0002\u0010\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u000e\"\u0004\b\u0012\u0010\u0010¨\u0006\u001e"}, mo175978d2 = {"Lcom/didi/component/framework/pages/invitation/model/LunBoItemInfo;", "", "name", "", "amount", "", "amountFormat", "(Ljava/lang/String;Ljava/lang/Double;Ljava/lang/String;)V", "getAmount", "()Ljava/lang/Double;", "setAmount", "(Ljava/lang/Double;)V", "Ljava/lang/Double;", "getAmountFormat", "()Ljava/lang/String;", "setAmountFormat", "(Ljava/lang/String;)V", "getName", "setName", "component1", "component2", "component3", "copy", "(Ljava/lang/String;Ljava/lang/Double;Ljava/lang/String;)Lcom/didi/component/framework/pages/invitation/model/LunBoItemInfo;", "equals", "", "other", "hashCode", "", "toString", "framework_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: InvitePageModel.kt */
public final class LunBoItemInfo {
    private Double amount;
    private String amountFormat;
    private String name;

    public static /* synthetic */ LunBoItemInfo copy$default(LunBoItemInfo lunBoItemInfo, String str, Double d, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = lunBoItemInfo.name;
        }
        if ((i & 2) != 0) {
            d = lunBoItemInfo.amount;
        }
        if ((i & 4) != 0) {
            str2 = lunBoItemInfo.amountFormat;
        }
        return lunBoItemInfo.copy(str, d, str2);
    }

    public final String component1() {
        return this.name;
    }

    public final Double component2() {
        return this.amount;
    }

    public final String component3() {
        return this.amountFormat;
    }

    public final LunBoItemInfo copy(String str, Double d, String str2) {
        return new LunBoItemInfo(str, d, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LunBoItemInfo)) {
            return false;
        }
        LunBoItemInfo lunBoItemInfo = (LunBoItemInfo) obj;
        return Intrinsics.areEqual((Object) this.name, (Object) lunBoItemInfo.name) && Intrinsics.areEqual((Object) this.amount, (Object) lunBoItemInfo.amount) && Intrinsics.areEqual((Object) this.amountFormat, (Object) lunBoItemInfo.amountFormat);
    }

    public int hashCode() {
        String str = this.name;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        Double d = this.amount;
        int hashCode2 = (hashCode + (d == null ? 0 : d.hashCode())) * 31;
        String str2 = this.amountFormat;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        return "LunBoItemInfo(name=" + this.name + ", amount=" + this.amount + ", amountFormat=" + this.amountFormat + VersionRange.RIGHT_OPEN;
    }

    public LunBoItemInfo(String str, Double d, String str2) {
        this.name = str;
        this.amount = d;
        this.amountFormat = str2;
    }

    public final String getName() {
        return this.name;
    }

    public final void setName(String str) {
        this.name = str;
    }

    public final Double getAmount() {
        return this.amount;
    }

    public final void setAmount(Double d) {
        this.amount = d;
    }

    public final String getAmountFormat() {
        return this.amountFormat;
    }

    public final void setAmountFormat(String str) {
        this.amountFormat = str;
    }
}
