package com.didi.global.fintech.cashier.user.model;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(mo175977d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\b\u0018\u0000 !2\u00020\u0001:\u0001!B?\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\tJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003JC\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\bHÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\b\u0010 \u001a\u00020\u0003H\u0016R&\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b0\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000f\"\u0004\b\u0013\u0010\u0011R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000f\"\u0004\b\u0015\u0010\u0011¨\u0006\""}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/user/model/FastPayParam;", "Ljava/io/Serializable;", "productId", "", "outTradeId", "orderPageTitle", "omegaAttrs", "", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V", "getOmegaAttrs", "()Ljava/util/Map;", "setOmegaAttrs", "(Ljava/util/Map;)V", "getOrderPageTitle", "()Ljava/lang/String;", "setOrderPageTitle", "(Ljava/lang/String;)V", "getOutTradeId", "setOutTradeId", "getProductId", "setProductId", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "Companion", "cashier_user_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: FastPayParam.kt */
public final class FastPayParam implements Serializable {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private Map<String, Object> omegaAttrs;
    private String orderPageTitle;
    private String outTradeId;
    private String productId;

    public FastPayParam() {
        this((String) null, (String) null, (String) null, (Map) null, 15, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ FastPayParam copy$default(FastPayParam fastPayParam, String str, String str2, String str3, Map<String, Object> map, int i, Object obj) {
        if ((i & 1) != 0) {
            str = fastPayParam.productId;
        }
        if ((i & 2) != 0) {
            str2 = fastPayParam.outTradeId;
        }
        if ((i & 4) != 0) {
            str3 = fastPayParam.orderPageTitle;
        }
        if ((i & 8) != 0) {
            map = fastPayParam.omegaAttrs;
        }
        return fastPayParam.copy(str, str2, str3, map);
    }

    public final String component1() {
        return this.productId;
    }

    public final String component2() {
        return this.outTradeId;
    }

    public final String component3() {
        return this.orderPageTitle;
    }

    public final Map<String, Object> component4() {
        return this.omegaAttrs;
    }

    public final FastPayParam copy(String str, String str2, String str3, Map<String, Object> map) {
        Intrinsics.checkNotNullParameter(map, "omegaAttrs");
        return new FastPayParam(str, str2, str3, map);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FastPayParam)) {
            return false;
        }
        FastPayParam fastPayParam = (FastPayParam) obj;
        return Intrinsics.areEqual((Object) this.productId, (Object) fastPayParam.productId) && Intrinsics.areEqual((Object) this.outTradeId, (Object) fastPayParam.outTradeId) && Intrinsics.areEqual((Object) this.orderPageTitle, (Object) fastPayParam.orderPageTitle) && Intrinsics.areEqual((Object) this.omegaAttrs, (Object) fastPayParam.omegaAttrs);
    }

    public int hashCode() {
        String str = this.productId;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.outTradeId;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.orderPageTitle;
        if (str3 != null) {
            i = str3.hashCode();
        }
        return ((hashCode2 + i) * 31) + this.omegaAttrs.hashCode();
    }

    public FastPayParam(String str, String str2, String str3, Map<String, Object> map) {
        Intrinsics.checkNotNullParameter(map, "omegaAttrs");
        this.productId = str;
        this.outTradeId = str2;
        this.orderPageTitle = str3;
        this.omegaAttrs = map;
    }

    public final String getProductId() {
        return this.productId;
    }

    public final void setProductId(String str) {
        this.productId = str;
    }

    public final String getOutTradeId() {
        return this.outTradeId;
    }

    public final void setOutTradeId(String str) {
        this.outTradeId = str;
    }

    public final String getOrderPageTitle() {
        return this.orderPageTitle;
    }

    public final void setOrderPageTitle(String str) {
        this.orderPageTitle = str;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FastPayParam(String str, String str2, String str3, Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? new LinkedHashMap() : map);
    }

    public final Map<String, Object> getOmegaAttrs() {
        return this.omegaAttrs;
    }

    public final void setOmegaAttrs(Map<String, Object> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.omegaAttrs = map;
    }

    @Metadata(mo175977d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/user/model/FastPayParam$Companion;", "", "()V", "cashier_user_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: FastPayParam.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        StringsKt.appendln(sb);
        sb.append(Intrinsics.stringPlus("productId:", this.productId));
        Intrinsics.checkNotNullExpressionValue(sb, "sb.append(\"productId:$productId\")");
        StringsKt.appendln(sb);
        sb.append(Intrinsics.stringPlus("outTradeId:", this.outTradeId));
        Intrinsics.checkNotNullExpressionValue(sb, "sb.append(\"outTradeId:$outTradeId\")");
        StringsKt.appendln(sb);
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "sb.toString()");
        return sb2;
    }
}
