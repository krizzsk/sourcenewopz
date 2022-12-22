package com.didi.global.fintech.cashier.fastpay.dialog;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo175977d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0007\"\u0004\b\u000b\u0010\t¨\u0006\u0015"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/fastpay/dialog/FastPayLimitItemData;", "", "content", "", "amount", "(Ljava/lang/String;Ljava/lang/String;)V", "getAmount", "()Ljava/lang/String;", "setAmount", "(Ljava/lang/String;)V", "getContent", "setContent", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "cashier_fastpay_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: FastPayLimitDrawer.kt */
public final class FastPayLimitItemData {

    /* renamed from: a */
    private String f21549a;

    /* renamed from: b */
    private String f21550b;

    public FastPayLimitItemData() {
        this((String) null, (String) null, 3, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ FastPayLimitItemData copy$default(FastPayLimitItemData fastPayLimitItemData, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = fastPayLimitItemData.f21549a;
        }
        if ((i & 2) != 0) {
            str2 = fastPayLimitItemData.f21550b;
        }
        return fastPayLimitItemData.copy(str, str2);
    }

    public final String component1() {
        return this.f21549a;
    }

    public final String component2() {
        return this.f21550b;
    }

    public final FastPayLimitItemData copy(String str, String str2) {
        return new FastPayLimitItemData(str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FastPayLimitItemData)) {
            return false;
        }
        FastPayLimitItemData fastPayLimitItemData = (FastPayLimitItemData) obj;
        return Intrinsics.areEqual((Object) this.f21549a, (Object) fastPayLimitItemData.f21549a) && Intrinsics.areEqual((Object) this.f21550b, (Object) fastPayLimitItemData.f21550b);
    }

    public int hashCode() {
        String str = this.f21549a;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.f21550b;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "FastPayLimitItemData(content=" + this.f21549a + ", amount=" + this.f21550b + VersionRange.RIGHT_OPEN;
    }

    public FastPayLimitItemData(String str, String str2) {
        this.f21549a = str;
        this.f21550b = str2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FastPayLimitItemData(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2);
    }

    public final String getContent() {
        return this.f21549a;
    }

    public final void setContent(String str) {
        this.f21549a = str;
    }

    public final String getAmount() {
        return this.f21550b;
    }

    public final void setAmount(String str) {
        this.f21550b = str;
    }
}
