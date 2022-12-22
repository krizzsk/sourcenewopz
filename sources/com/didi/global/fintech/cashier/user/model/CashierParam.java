package com.didi.global.fintech.cashier.user.model;

import com.didichuxing.dfbasesdk.logupload2.LogDbHelper2;
import java.io.Serializable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(mo175977d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\b\u001e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\b\u0018\u0000 -2\u00020\u0001:\u0001-Bm\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t0\b\u0012\u0014\b\u0002\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t0\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\fJ\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t0\bHÆ\u0003J\u0015\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t0\bHÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003Jq\u0010&\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t0\b2\u0014\b\u0002\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t0\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010\tHÖ\u0003J\t\u0010*\u001a\u00020+HÖ\u0001J\b\u0010,\u001a\u00020\u0003H\u0016R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R&\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t0\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u000e\"\u0004\b\u0016\u0010\u0010R&\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t0\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0012\"\u0004\b\u0018\u0010\u0014R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u000e\"\u0004\b\u001a\u0010\u0010R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u000e\"\u0004\b\u001c\u0010\u0010R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u000e\"\u0004\b\u001e\u0010\u0010¨\u0006."}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/user/model/CashierParam;", "Ljava/io/Serializable;", "sign", "", "signType", "bizContent", "outTradeId", "extraParams", "", "", "omegaAttrs", "needPayFeeTextDisplay", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;Ljava/lang/String;)V", "getBizContent", "()Ljava/lang/String;", "setBizContent", "(Ljava/lang/String;)V", "getExtraParams", "()Ljava/util/Map;", "setExtraParams", "(Ljava/util/Map;)V", "getNeedPayFeeTextDisplay", "setNeedPayFeeTextDisplay", "getOmegaAttrs", "setOmegaAttrs", "getOutTradeId", "setOutTradeId", "getSign", "setSign", "getSignType", "setSignType", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "", "toString", "Companion", "cashier_user_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CashierParam.kt */
public final class CashierParam implements Serializable {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String PARAM_FROM_TYPE = "from_type";
    public static final String PARAM_MERCHANT_WSG_ENV = "merchant_wsgenv";
    private String bizContent;
    private Map<String, Object> extraParams;
    private String needPayFeeTextDisplay;
    private Map<String, Object> omegaAttrs;
    private String outTradeId;
    private String sign;
    private String signType;

    public CashierParam() {
        this((String) null, (String) null, (String) null, (String) null, (Map) null, (Map) null, (String) null, 127, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ CashierParam copy$default(CashierParam cashierParam, String str, String str2, String str3, String str4, Map<String, Object> map, Map<String, Object> map2, String str5, int i, Object obj) {
        if ((i & 1) != 0) {
            str = cashierParam.sign;
        }
        if ((i & 2) != 0) {
            str2 = cashierParam.signType;
        }
        String str6 = str2;
        if ((i & 4) != 0) {
            str3 = cashierParam.bizContent;
        }
        String str7 = str3;
        if ((i & 8) != 0) {
            str4 = cashierParam.outTradeId;
        }
        String str8 = str4;
        if ((i & 16) != 0) {
            map = cashierParam.extraParams;
        }
        Map<String, Object> map3 = map;
        if ((i & 32) != 0) {
            map2 = cashierParam.omegaAttrs;
        }
        Map<String, Object> map4 = map2;
        if ((i & 64) != 0) {
            str5 = cashierParam.needPayFeeTextDisplay;
        }
        return cashierParam.copy(str, str6, str7, str8, map3, map4, str5);
    }

    public final String component1() {
        return this.sign;
    }

    public final String component2() {
        return this.signType;
    }

    public final String component3() {
        return this.bizContent;
    }

    public final String component4() {
        return this.outTradeId;
    }

    public final Map<String, Object> component5() {
        return this.extraParams;
    }

    public final Map<String, Object> component6() {
        return this.omegaAttrs;
    }

    public final String component7() {
        return this.needPayFeeTextDisplay;
    }

    public final CashierParam copy(String str, String str2, String str3, String str4, Map<String, Object> map, Map<String, Object> map2, String str5) {
        Intrinsics.checkNotNullParameter(map, LogDbHelper2.LogColumns.COLUMN_NAME_POST_EXTRAS);
        Intrinsics.checkNotNullParameter(map2, "omegaAttrs");
        return new CashierParam(str, str2, str3, str4, map, map2, str5);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CashierParam)) {
            return false;
        }
        CashierParam cashierParam = (CashierParam) obj;
        return Intrinsics.areEqual((Object) this.sign, (Object) cashierParam.sign) && Intrinsics.areEqual((Object) this.signType, (Object) cashierParam.signType) && Intrinsics.areEqual((Object) this.bizContent, (Object) cashierParam.bizContent) && Intrinsics.areEqual((Object) this.outTradeId, (Object) cashierParam.outTradeId) && Intrinsics.areEqual((Object) this.extraParams, (Object) cashierParam.extraParams) && Intrinsics.areEqual((Object) this.omegaAttrs, (Object) cashierParam.omegaAttrs) && Intrinsics.areEqual((Object) this.needPayFeeTextDisplay, (Object) cashierParam.needPayFeeTextDisplay);
    }

    public int hashCode() {
        String str = this.sign;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.signType;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.bizContent;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.outTradeId;
        int hashCode4 = (((((hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31) + this.extraParams.hashCode()) * 31) + this.omegaAttrs.hashCode()) * 31;
        String str5 = this.needPayFeeTextDisplay;
        if (str5 != null) {
            i = str5.hashCode();
        }
        return hashCode4 + i;
    }

    public CashierParam(String str, String str2, String str3, String str4, Map<String, Object> map, Map<String, Object> map2, String str5) {
        Intrinsics.checkNotNullParameter(map, LogDbHelper2.LogColumns.COLUMN_NAME_POST_EXTRAS);
        Intrinsics.checkNotNullParameter(map2, "omegaAttrs");
        this.sign = str;
        this.signType = str2;
        this.bizContent = str3;
        this.outTradeId = str4;
        this.extraParams = map;
        this.omegaAttrs = map2;
        this.needPayFeeTextDisplay = str5;
        map.put(PARAM_FROM_TYPE, "NATIVE");
    }

    public final String getSign() {
        return this.sign;
    }

    public final void setSign(String str) {
        this.sign = str;
    }

    public final String getSignType() {
        return this.signType;
    }

    public final void setSignType(String str) {
        this.signType = str;
    }

    public final String getBizContent() {
        return this.bizContent;
    }

    public final void setBizContent(String str) {
        this.bizContent = str;
    }

    public final String getOutTradeId() {
        return this.outTradeId;
    }

    public final void setOutTradeId(String str) {
        this.outTradeId = str;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ CashierParam(java.lang.String r7, java.lang.String r8, java.lang.String r9, java.lang.String r10, java.util.Map r11, java.util.Map r12, java.lang.String r13, int r14, kotlin.jvm.internal.DefaultConstructorMarker r15) {
        /*
            r6 = this;
            r15 = r14 & 1
            r0 = 0
            if (r15 == 0) goto L_0x0007
            r15 = r0
            goto L_0x0008
        L_0x0007:
            r15 = r7
        L_0x0008:
            r7 = r14 & 2
            if (r7 == 0) goto L_0x000e
            r1 = r0
            goto L_0x000f
        L_0x000e:
            r1 = r8
        L_0x000f:
            r7 = r14 & 4
            if (r7 == 0) goto L_0x0015
            r2 = r0
            goto L_0x0016
        L_0x0015:
            r2 = r9
        L_0x0016:
            r7 = r14 & 8
            if (r7 == 0) goto L_0x001c
            r3 = r0
            goto L_0x001d
        L_0x001c:
            r3 = r10
        L_0x001d:
            r7 = r14 & 16
            if (r7 == 0) goto L_0x0029
            java.util.LinkedHashMap r7 = new java.util.LinkedHashMap
            r7.<init>()
            r11 = r7
            java.util.Map r11 = (java.util.Map) r11
        L_0x0029:
            r4 = r11
            r7 = r14 & 32
            if (r7 == 0) goto L_0x0036
            java.util.LinkedHashMap r7 = new java.util.LinkedHashMap
            r7.<init>()
            r12 = r7
            java.util.Map r12 = (java.util.Map) r12
        L_0x0036:
            r5 = r12
            r7 = r14 & 64
            if (r7 == 0) goto L_0x003d
            r14 = r0
            goto L_0x003e
        L_0x003d:
            r14 = r13
        L_0x003e:
            r7 = r6
            r8 = r15
            r9 = r1
            r10 = r2
            r11 = r3
            r12 = r4
            r13 = r5
            r7.<init>(r8, r9, r10, r11, r12, r13, r14)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.global.fintech.cashier.user.model.CashierParam.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.util.Map, java.util.Map, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final Map<String, Object> getExtraParams() {
        return this.extraParams;
    }

    public final void setExtraParams(Map<String, Object> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.extraParams = map;
    }

    public final Map<String, Object> getOmegaAttrs() {
        return this.omegaAttrs;
    }

    public final void setOmegaAttrs(Map<String, Object> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.omegaAttrs = map;
    }

    public final String getNeedPayFeeTextDisplay() {
        return this.needPayFeeTextDisplay;
    }

    public final void setNeedPayFeeTextDisplay(String str) {
        this.needPayFeeTextDisplay = str;
    }

    @Metadata(mo175977d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J$\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\u000b\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\r"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/user/model/CashierParam$Companion;", "", "()V", "PARAM_FROM_TYPE", "", "PARAM_MERCHANT_WSG_ENV", "insByBizContent", "Lcom/didi/global/fintech/cashier/user/model/CashierParam;", "sign", "signType", "bizContent", "insByOutTradeId", "oid", "cashier_user_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: CashierParam.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final CashierParam insByOutTradeId(String str) {
            return new CashierParam((String) null, (String) null, (String) null, str, (Map) null, (Map) null, (String) null, 119, (DefaultConstructorMarker) null);
        }

        public final CashierParam insByBizContent(String str, String str2, String str3) {
            return new CashierParam(str, str2, str3, (String) null, (Map) null, (Map) null, (String) null, 120, (DefaultConstructorMarker) null);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        StringsKt.appendln(sb);
        sb.append(Intrinsics.stringPlus("outTradeId:", this.outTradeId));
        Intrinsics.checkNotNullExpressionValue(sb, "sb.append(\"outTradeId:$outTradeId\")");
        StringsKt.appendln(sb);
        sb.append(Intrinsics.stringPlus("signType:", this.signType));
        Intrinsics.checkNotNullExpressionValue(sb, "sb.append(\"signType:$signType\")");
        StringsKt.appendln(sb);
        sb.append(Intrinsics.stringPlus("sign:", this.sign));
        Intrinsics.checkNotNullExpressionValue(sb, "sb.append(\"sign:$sign\")");
        StringsKt.appendln(sb);
        sb.append(Intrinsics.stringPlus("outTradeId:", this.bizContent));
        Intrinsics.checkNotNullExpressionValue(sb, "sb.append(\"outTradeId:$bizContent\")");
        StringsKt.appendln(sb);
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "sb.toString()");
        return sb2;
    }
}
