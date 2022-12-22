package com.didi.global.fintech.cashier.p117ui.viewholder;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo175977d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0019\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B5\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\bJ\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0010J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÆ\u0003J>\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u001bJ\u0013\u0010\u001c\u001a\u00020\u00032\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020\u0005HÖ\u0001R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\fR\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\n\"\u0004\b\u0015\u0010\f¨\u0006!"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/ui/viewholder/MerchantButtonData;", "", "show", "", "message", "", "type", "return_url", "(Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "setMessage", "(Ljava/lang/String;)V", "getReturn_url", "setReturn_url", "getShow", "()Ljava/lang/Boolean;", "setShow", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getType", "setType", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/didi/global/fintech/cashier/ui/viewholder/MerchantButtonData;", "equals", "other", "hashCode", "", "toString", "cashier_ui_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.global.fintech.cashier.ui.viewholder.MerchantButtonData */
/* compiled from: GlobalCashierResultPayViewHolder.kt */
public final class MerchantButtonData {

    /* renamed from: a */
    private Boolean f21817a;

    /* renamed from: b */
    private String f21818b;

    /* renamed from: c */
    private String f21819c;

    /* renamed from: d */
    private String f21820d;

    public MerchantButtonData() {
        this((Boolean) null, (String) null, (String) null, (String) null, 15, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ MerchantButtonData copy$default(MerchantButtonData merchantButtonData, Boolean bool, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            bool = merchantButtonData.f21817a;
        }
        if ((i & 2) != 0) {
            str = merchantButtonData.f21818b;
        }
        if ((i & 4) != 0) {
            str2 = merchantButtonData.f21819c;
        }
        if ((i & 8) != 0) {
            str3 = merchantButtonData.f21820d;
        }
        return merchantButtonData.copy(bool, str, str2, str3);
    }

    public final Boolean component1() {
        return this.f21817a;
    }

    public final String component2() {
        return this.f21818b;
    }

    public final String component3() {
        return this.f21819c;
    }

    public final String component4() {
        return this.f21820d;
    }

    public final MerchantButtonData copy(Boolean bool, String str, String str2, String str3) {
        return new MerchantButtonData(bool, str, str2, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MerchantButtonData)) {
            return false;
        }
        MerchantButtonData merchantButtonData = (MerchantButtonData) obj;
        return Intrinsics.areEqual((Object) this.f21817a, (Object) merchantButtonData.f21817a) && Intrinsics.areEqual((Object) this.f21818b, (Object) merchantButtonData.f21818b) && Intrinsics.areEqual((Object) this.f21819c, (Object) merchantButtonData.f21819c) && Intrinsics.areEqual((Object) this.f21820d, (Object) merchantButtonData.f21820d);
    }

    public int hashCode() {
        Boolean bool = this.f21817a;
        int i = 0;
        int hashCode = (bool == null ? 0 : bool.hashCode()) * 31;
        String str = this.f21818b;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.f21819c;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.f21820d;
        if (str3 != null) {
            i = str3.hashCode();
        }
        return hashCode3 + i;
    }

    public String toString() {
        return "MerchantButtonData(show=" + this.f21817a + ", message=" + this.f21818b + ", type=" + this.f21819c + ", return_url=" + this.f21820d + VersionRange.RIGHT_OPEN;
    }

    public MerchantButtonData(Boolean bool, String str, String str2, String str3) {
        this.f21817a = bool;
        this.f21818b = str;
        this.f21819c = str2;
        this.f21820d = str3;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MerchantButtonData(Boolean bool, String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : bool, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : str3);
    }

    public final Boolean getShow() {
        return this.f21817a;
    }

    public final void setShow(Boolean bool) {
        this.f21817a = bool;
    }

    public final String getMessage() {
        return this.f21818b;
    }

    public final void setMessage(String str) {
        this.f21818b = str;
    }

    public final String getType() {
        return this.f21819c;
    }

    public final void setType(String str) {
        this.f21819c = str;
    }

    public final String getReturn_url() {
        return this.f21820d;
    }

    public final void setReturn_url(String str) {
        this.f21820d = str;
    }
}
