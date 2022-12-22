package com.didi.component.payentrance.model;

import android.content.Context;
import com.didi.component.common.config.DynamicConfigManager;
import com.didi.travel.psnger.common.net.base.BaseObject;
import com.didi.travel.psnger.model.response.CarOrder;
import com.didiglobal.travel.infra.content.ContextKt;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(mo175977d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u00103\u001a\u00020\"2\u0006\u00104\u001a\u000205H\u0002J\u0012\u00106\u001a\u0002072\b\u00108\u001a\u0004\u0018\u000109H\u0014J\u001c\u0010:\u001a\u0004\u0018\u00010\u001c*\u0002092\f\u0010;\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bH\u0002J\f\u0010<\u001a\u000207*\u000209H\u0002R\u0014\u0010\u0005\u001a\u00020\u0006XD¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u0006XD¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R\u001a\u0010\u0016\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\b\"\u0004\b\u0018\u0010\u0019R \u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010!\u001a\u00020\"X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001a\u0010'\u001a\u00020\"X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010$\"\u0004\b)\u0010&R\u001a\u0010*\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\b\"\u0004\b,\u0010\u0019R\u001e\u0010.\u001a\u00020\u00062\u0006\u0010-\u001a\u00020\u0006@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\bR\u001a\u00100\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\b\"\u0004\b2\u0010\u0019¨\u0006="}, mo175978d2 = {"Lcom/didi/component/payentrance/model/FareDetailsModel;", "Lcom/didi/travel/psnger/common/net/base/BaseObject;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "COUNTRY_REGION_BX", "", "getCOUNTRY_REGION_BX", "()Ljava/lang/String;", "COUNTRY_REGION_JAPAN", "getCOUNTRY_REGION_JAPAN", "getContext", "()Landroid/content/Context;", "countPriceType", "", "getCountPriceType", "()I", "setCountPriceType", "(I)V", "currentPoi", "getCurrentPoi", "setCurrentPoi", "currentSymbol", "getCurrentSymbol", "setCurrentSymbol", "(Ljava/lang/String;)V", "feeList", "", "Lcom/didi/component/payentrance/model/FareInfoItem;", "getFeeList", "()Ljava/util/List;", "setFeeList", "(Ljava/util/List;)V", "hasFAQ", "", "getHasFAQ", "()Z", "setHasFAQ", "(Z)V", "hasPayMethod", "getHasPayMethod", "setHasPayMethod", "payStatus", "getPayStatus", "setPayStatus", "<set-?>", "rulesUrl", "getRulesUrl", "totalFeeText", "getTotalFeeText", "setTotalFeeText", "isPricingTaxi", "order", "Lcom/didi/travel/psnger/model/response/CarOrder;", "parse", "", "json", "Lorg/json/JSONObject;", "parseHighlight", "container", "parseUrls", "comp-payentrance_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: FareDetailsModel.kt */
public final class FareDetailsModel extends BaseObject {
    private final String COUNTRY_REGION_BX = "BR";
    private final String COUNTRY_REGION_JAPAN = "JP";
    private final Context context;
    private int countPriceType;
    private int currentPoi = -1;
    private String currentSymbol = "";
    private List<FareInfoItem> feeList = new ArrayList();
    private boolean hasFAQ;
    private boolean hasPayMethod;
    private String payStatus = "";
    private String rulesUrl = "";
    private String totalFeeText = "";

    public FareDetailsModel(Context context2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        this.context = context2;
    }

    public final Context getContext() {
        return this.context;
    }

    public final int getCurrentPoi() {
        return this.currentPoi;
    }

    public final void setCurrentPoi(int i) {
        this.currentPoi = i;
    }

    public final String getCurrentSymbol() {
        return this.currentSymbol;
    }

    public final void setCurrentSymbol(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.currentSymbol = str;
    }

    public final String getPayStatus() {
        return this.payStatus;
    }

    public final void setPayStatus(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.payStatus = str;
    }

    public final String getTotalFeeText() {
        return this.totalFeeText;
    }

    public final void setTotalFeeText(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.totalFeeText = str;
    }

    public final List<FareInfoItem> getFeeList() {
        return this.feeList;
    }

    public final void setFeeList(List<FareInfoItem> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.feeList = list;
    }

    public final int getCountPriceType() {
        return this.countPriceType;
    }

    public final void setCountPriceType(int i) {
        this.countPriceType = i;
    }

    public final boolean getHasFAQ() {
        return this.hasFAQ;
    }

    public final void setHasFAQ(boolean z) {
        this.hasFAQ = z;
    }

    public final boolean getHasPayMethod() {
        return this.hasPayMethod;
    }

    public final void setHasPayMethod(boolean z) {
        this.hasPayMethod = z;
    }

    public final String getCOUNTRY_REGION_BX() {
        return this.COUNTRY_REGION_BX;
    }

    public final String getCOUNTRY_REGION_JAPAN() {
        return this.COUNTRY_REGION_JAPAN;
    }

    public final String getRulesUrl() {
        return this.rulesUrl;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:100:0x02e2  */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x03b7 A[LOOP:3: B:114:0x0385->B:116:0x03b7, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x03d4 A[Catch:{ NumberFormatException -> 0x03df }] */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x03d6 A[Catch:{ NumberFormatException -> 0x03df }] */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x03d9 A[Catch:{ NumberFormatException -> 0x03df }] */
    /* JADX WARNING: Removed duplicated region for block: B:125:0x03da A[Catch:{ NumberFormatException -> 0x03df }] */
    /* JADX WARNING: Removed duplicated region for block: B:138:0x040f  */
    /* JADX WARNING: Removed duplicated region for block: B:147:0x0438  */
    /* JADX WARNING: Removed duplicated region for block: B:150:0x0450  */
    /* JADX WARNING: Removed duplicated region for block: B:151:0x0452  */
    /* JADX WARNING: Removed duplicated region for block: B:153:0x0455  */
    /* JADX WARNING: Removed duplicated region for block: B:165:0x049f  */
    /* JADX WARNING: Removed duplicated region for block: B:166:0x04a1  */
    /* JADX WARNING: Removed duplicated region for block: B:168:0x04a4  */
    /* JADX WARNING: Removed duplicated region for block: B:179:0x04dd  */
    /* JADX WARNING: Removed duplicated region for block: B:187:0x0519  */
    /* JADX WARNING: Removed duplicated region for block: B:188:0x051b  */
    /* JADX WARNING: Removed duplicated region for block: B:190:0x051e  */
    /* JADX WARNING: Removed duplicated region for block: B:193:0x053c  */
    /* JADX WARNING: Removed duplicated region for block: B:194:0x0550  */
    /* JADX WARNING: Removed duplicated region for block: B:212:0x05ce A[LOOP:4: B:210:0x05ad->B:212:0x05ce, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:217:0x05d7  */
    /* JADX WARNING: Removed duplicated region for block: B:229:0x063f  */
    /* JADX WARNING: Removed duplicated region for block: B:245:0x03b9 A[EDGE_INSN: B:245:0x03b9->B:117:0x03b9 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:246:0x05d3 A[EDGE_INSN: B:246:0x05d3->B:215:0x05d3 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:251:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0133  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x016f  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0171  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0174  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x01a1  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x01a3  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x01a8  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x01d0  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x02a5  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x02cc  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x02ce  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x02d9  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x02db  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void parse(org.json.JSONObject r21) {
        /*
            r20 = this;
            r0 = r20
            r1 = r21
            super.parse((org.json.JSONObject) r21)
            if (r1 != 0) goto L_0x000b
            r1 = 0
            goto L_0x0011
        L_0x000b:
            java.lang.String r3 = "data"
            org.json.JSONObject r1 = r1.optJSONObject(r3)
        L_0x0011:
            if (r1 != 0) goto L_0x0014
            return
        L_0x0014:
            com.didi.travel.psnger.model.response.CarOrder r3 = com.didi.component.business.util.CarOrderHelper.getOrder()
            if (r3 != 0) goto L_0x001b
            return
        L_0x001b:
            java.lang.String r4 = "carpool_tips"
            org.json.JSONObject r4 = r1.optJSONObject(r4)
            r5 = 9
            java.lang.String r6 = "title"
            r7 = 0
            r8 = 1
            if (r4 == 0) goto L_0x006c
            java.lang.String r9 = r4.optString(r6)
            java.lang.String r10 = "sub_title"
            java.lang.String r4 = r4.optString(r10)
            java.lang.String r10 = "carPoolTitle"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r10)
            r10 = r9
            java.lang.CharSequence r10 = (java.lang.CharSequence) r10
            int r10 = r10.length()
            if (r10 <= 0) goto L_0x0043
            r10 = 1
            goto L_0x0044
        L_0x0043:
            r10 = 0
        L_0x0044:
            if (r10 == 0) goto L_0x006c
            java.lang.String r10 = "carPoolSubTitle"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r10)
            r10 = r4
            java.lang.CharSequence r10 = (java.lang.CharSequence) r10
            int r10 = r10.length()
            if (r10 <= 0) goto L_0x0056
            r10 = 1
            goto L_0x0057
        L_0x0056:
            r10 = 0
        L_0x0057:
            if (r10 == 0) goto L_0x006c
            com.didi.component.payentrance.model.FareInfoItem r10 = new com.didi.component.payentrance.model.FareInfoItem
            r10.<init>()
            r10.setType(r5)
            r10.setCarPoolTitle(r9)
            r10.setCarPoolSubTitle(r4)
            java.util.List<com.didi.component.payentrance.model.FareInfoItem> r4 = r0.feeList
            r4.add(r10)
        L_0x006c:
            java.lang.String r4 = "currency_pos"
            int r4 = r1.optInt(r4)
            r0.currentPoi = r4
            java.lang.String r4 = "currency_symbol"
            java.lang.String r4 = r1.optString(r4)
            java.lang.String r9 = "data.optString(\"currency_symbol\")"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r9)
            r0.currentSymbol = r4
            java.lang.String r4 = "pay_status"
            java.lang.String r4 = r1.optString(r4)
            java.lang.String r9 = "data.optString(\"pay_status\")"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r9)
            r0.payStatus = r4
            java.lang.String r4 = "count_price_type"
            int r4 = r1.optInt(r4)
            r0.countPriceType = r4
            java.lang.String r4 = "faq"
            org.json.JSONArray r4 = r1.optJSONArray(r4)
            if (r4 == 0) goto L_0x00a6
            int r9 = r4.length()
            if (r9 <= 0) goto L_0x00a6
            r0.hasFAQ = r8
        L_0x00a6:
            r0.parseUrls(r1)
            java.lang.String r9 = "feeInfo"
            org.json.JSONObject r1 = r1.optJSONObject(r9)
            r10 = 3
            if (r1 == 0) goto L_0x05d0
            java.lang.String r11 = "fee_detail_title"
            java.lang.String r11 = r1.optString(r11)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r11, r6)
            r6 = r11
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            int r6 = r6.length()
            if (r6 <= 0) goto L_0x00c6
            r6 = 1
            goto L_0x00c7
        L_0x00c6:
            r6 = 0
        L_0x00c7:
            if (r6 == 0) goto L_0x00d9
            com.didi.component.payentrance.model.FareInfoItem r6 = new com.didi.component.payentrance.model.FareInfoItem
            r6.<init>()
            r6.setType(r5)
            r6.setCarPoolTitle(r11)
            java.util.List<com.didi.component.payentrance.model.FareInfoItem> r5 = r0.feeList
            r5.add(r6)
        L_0x00d9:
            java.lang.String r5 = "total_fee_text"
            java.lang.String r5 = r1.optString(r5)
            java.lang.String r6 = "feeInfo.optString(\"total_fee_text\")"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r6)
            r0.totalFeeText = r5
            com.didi.component.payentrance.model.FareInfoItem r5 = new com.didi.component.payentrance.model.FareInfoItem
            r5.<init>()
            r5.setType(r7)
            java.lang.String r6 = "total_fee_text_split"
            org.json.JSONArray r6 = r1.optJSONArray(r6)
            r11 = 2
            if (r6 != 0) goto L_0x00f9
        L_0x00f7:
            r6 = 0
            goto L_0x0131
        L_0x00f9:
            int r12 = r6.length()
            if (r12 <= 0) goto L_0x0101
            r12 = 1
            goto L_0x0102
        L_0x0101:
            r12 = 0
        L_0x0102:
            if (r12 == 0) goto L_0x0105
            goto L_0x0106
        L_0x0105:
            r6 = 0
        L_0x0106:
            if (r6 != 0) goto L_0x0109
            goto L_0x00f7
        L_0x0109:
            java.lang.String r12 = r6.optString(r7)
            java.lang.String r13 = "it.optString(0)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r12, r13)
            r5.setFeeLabel(r12)
            java.lang.String r12 = r6.optString(r8)
            java.lang.String r13 = "it.optString(1)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r12, r13)
            r5.setFeeValue(r12)
            int r12 = r6.optInt(r11)
            r5.setShowPoi(r12)
            java.util.List r12 = r20.getFeeList()
            r12.add(r5)
            kotlin.Unit r12 = kotlin.Unit.INSTANCE
        L_0x0131:
            if (r6 != 0) goto L_0x014d
            r6 = r0
            com.didi.component.payentrance.model.FareDetailsModel r6 = (com.didi.component.payentrance.model.FareDetailsModel) r6
            java.lang.String r6 = r20.getCurrentSymbol()
            r5.setFeeLabel(r6)
            java.lang.String r6 = r20.getTotalFeeText()
            r5.setFeeValue(r6)
            int r6 = r20.getCurrentPoi()
            r5.setShowPoi(r6)
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
        L_0x014d:
            com.didi.component.payentrance.model.FareInfoItem r5 = new com.didi.component.payentrance.model.FareInfoItem
            r5.<init>()
            r5.setType(r8)
            java.lang.String r6 = "count_price_msg"
            java.lang.String r6 = r1.optString(r6)
            java.lang.String r12 = "feeInfo.optString(\"count_price_msg\")"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r12)
            r5.setFeeLabel(r6)
            java.lang.String r6 = r5.getFeeLabel()
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            int r6 = r6.length()
            if (r6 <= 0) goto L_0x0171
            r6 = 1
            goto L_0x0172
        L_0x0171:
            r6 = 0
        L_0x0172:
            if (r6 == 0) goto L_0x0180
            int r6 = r0.countPriceType
            if (r6 != r10) goto L_0x017b
            r5.setHighlight(r8)
        L_0x017b:
            java.util.List<com.didi.component.payentrance.model.FareInfoItem> r6 = r0.feeList
            r6.add(r5)
        L_0x0180:
            com.didi.component.payentrance.model.FareInfoItem r5 = new com.didi.component.payentrance.model.FareInfoItem
            r5.<init>()
            r5.setType(r11)
            java.util.List<com.didi.component.payentrance.model.FareInfoItem> r6 = r0.feeList
            r6.add(r5)
            java.lang.String r5 = "fee_reduction_title"
            java.lang.String r5 = r1.optString(r5)
            java.lang.String r6 = "feeReductionTitle"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r6)
            r6 = r5
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            int r6 = r6.length()
            if (r6 <= 0) goto L_0x01a3
            r6 = 1
            goto L_0x01a4
        L_0x01a3:
            r6 = 0
        L_0x01a4:
            r12 = 10
            if (r6 == 0) goto L_0x01b8
            com.didi.component.payentrance.model.FareInfoItem r6 = new com.didi.component.payentrance.model.FareInfoItem
            r6.<init>()
            r6.setType(r12)
            r6.setTitle(r5)
            java.util.List<com.didi.component.payentrance.model.FareInfoItem> r5 = r0.feeList
            r5.add(r6)
        L_0x01b8:
            java.lang.String r5 = "fee_reduction_list"
            org.json.JSONArray r5 = r1.optJSONArray(r5)
            java.lang.String r6 = "obj.optString(\"fee_value\")"
            java.lang.String r13 = "obj.optString(\"fee_label\")"
            java.lang.String r14 = "fee_type"
            java.lang.String r15 = "fee_value"
            java.lang.String r7 = "fee_label"
            if (r5 == 0) goto L_0x02a5
            int r2 = r5.length()
            if (r2 <= 0) goto L_0x02a5
            r9 = 0
        L_0x01d1:
            int r12 = r9 + 1
            org.json.JSONObject r9 = r5.optJSONObject(r9)
            com.didi.component.payentrance.model.FareInfoItem r11 = new com.didi.component.payentrance.model.FareInfoItem
            r11.<init>()
            r11.setType(r10)
            java.lang.String r10 = r9.optString(r7)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r10, r13)
            r11.setFeeLabel(r10)
            java.lang.String r10 = r9.optString(r15)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r10, r6)
            r11.setFeeValue(r10)
            int r10 = r9.optInt(r14)
            r11.setFeeType(r10)
            java.lang.String r10 = "fee_rgb"
            java.lang.String r10 = r9.optString(r10)
            java.lang.String r8 = "obj.optString(\"fee_rgb\")"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r10, r8)
            r11.setFeeValueRGB(r10)
            java.util.List<com.didi.component.payentrance.model.FareInfoItem> r8 = r0.feeList
            r8.add(r11)
            java.lang.String r8 = "children"
            org.json.JSONArray r8 = r9.optJSONArray(r8)
            if (r8 == 0) goto L_0x0264
            int r10 = r8.length()
            if (r10 <= 0) goto L_0x0264
            r11 = 0
        L_0x021c:
            r16 = r5
            int r5 = r11 + 1
            org.json.JSONObject r11 = r8.optJSONObject(r11)
            r17 = r8
            com.didi.component.payentrance.model.FareInfoItem r8 = new com.didi.component.payentrance.model.FareInfoItem
            r8.<init>()
            r18 = r4
            r4 = 4
            r8.setType(r4)
            java.lang.String r4 = r11.optString(r7)
            r19 = r6
            java.lang.String r6 = "children.optString(\"fee_label\")"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r6)
            r8.setFeeLabel(r4)
            java.lang.String r4 = r11.optString(r15)
            java.lang.String r6 = "children.optString(\"fee_value\")"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r6)
            r8.setFeeValue(r4)
            int r4 = r11.optInt(r14)
            r8.setFeeType(r4)
            java.util.List<com.didi.component.payentrance.model.FareInfoItem> r4 = r0.feeList
            r4.add(r8)
            if (r5 < r10) goto L_0x025a
            goto L_0x026a
        L_0x025a:
            r11 = r5
            r5 = r16
            r8 = r17
            r4 = r18
            r6 = r19
            goto L_0x021c
        L_0x0264:
            r18 = r4
            r16 = r5
            r19 = r6
        L_0x026a:
            java.lang.String r4 = "fee_info"
            java.lang.String r4 = r9.optString(r4)
            java.lang.String r5 = "feeMsg"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r5)
            r5 = r4
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            int r5 = r5.length()
            if (r5 <= 0) goto L_0x0280
            r5 = 1
            goto L_0x0281
        L_0x0280:
            r5 = 0
        L_0x0281:
            if (r5 == 0) goto L_0x0294
            com.didi.component.payentrance.model.FareInfoItem r5 = new com.didi.component.payentrance.model.FareInfoItem
            r5.<init>()
            r6 = 1
            r5.setType(r6)
            r5.setFeeLabel(r4)
            java.util.List<com.didi.component.payentrance.model.FareInfoItem> r4 = r0.feeList
            r4.add(r5)
        L_0x0294:
            if (r12 < r2) goto L_0x0297
            goto L_0x02a9
        L_0x0297:
            r9 = r12
            r5 = r16
            r4 = r18
            r6 = r19
            r8 = 1
            r10 = 3
            r11 = 2
            r12 = 10
            goto L_0x01d1
        L_0x02a5:
            r18 = r4
            r19 = r6
        L_0x02a9:
            java.lang.String r2 = r0.COUNTRY_REGION_JAPAN
            java.lang.String r4 = r3.countryCode
            r5 = 1
            boolean r2 = kotlin.text.StringsKt.equals(r2, r4, r5)
            java.lang.String r4 = "pay_detail_title"
            java.lang.String r4 = r1.optString(r4)
            java.lang.String r5 = "pay_detail_list"
            org.json.JSONArray r5 = r1.optJSONArray(r5)
            java.lang.String r6 = "payDetailTitle"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r6)
            r6 = r4
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            int r6 = r6.length()
            if (r6 <= 0) goto L_0x02ce
            r6 = 1
            goto L_0x02cf
        L_0x02ce:
            r6 = 0
        L_0x02cf:
            if (r6 == 0) goto L_0x02de
            if (r5 == 0) goto L_0x02de
            int r6 = r5.length()
            if (r6 <= 0) goto L_0x02db
            r6 = 1
            goto L_0x02dc
        L_0x02db:
            r6 = 0
        L_0x02dc:
            r0.hasPayMethod = r6
        L_0x02de:
            boolean r6 = r0.hasPayMethod
            if (r6 == 0) goto L_0x036e
            com.didi.component.payentrance.model.FareInfoItem r6 = new com.didi.component.payentrance.model.FareInfoItem
            r6.<init>()
            r8 = 2
            r6.setType(r8)
            java.util.List<com.didi.component.payentrance.model.FareInfoItem> r8 = r0.feeList
            r8.add(r6)
            com.didi.component.payentrance.model.FareInfoItem r6 = new com.didi.component.payentrance.model.FareInfoItem
            r6.<init>()
            r8 = 10
            r6.setType(r8)
            r6.setTitle(r4)
            java.util.List<com.didi.component.payentrance.model.FareInfoItem> r4 = r0.feeList
            r4.add(r6)
            if (r5 == 0) goto L_0x036e
            int r4 = r5.length()
            if (r4 <= 0) goto L_0x036e
            r6 = 0
        L_0x030b:
            int r8 = r6 + 1
            org.json.JSONObject r6 = r5.optJSONObject(r6)
            com.didi.component.payentrance.model.FareInfoItem r9 = new com.didi.component.payentrance.model.FareInfoItem
            r9.<init>()
            r10 = 11
            r9.setType(r10)
            java.lang.String r10 = r6.optString(r7)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r10, r13)
            r9.setFeeLabel(r10)
            java.lang.String r10 = r6.optString(r15)
            r11 = r19
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r10, r11)
            r9.setFeeValue(r10)
            int r10 = r6.optInt(r14)
            r9.setFeeType(r10)
            java.lang.String r10 = "fee_icon"
            java.lang.String r10 = r6.optString(r10)
            java.lang.String r12 = "obj.optString(\"fee_icon\")"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r10, r12)
            r9.setFeeIcon(r10)
            java.lang.String r10 = "fee_card_suffix"
            java.lang.String r10 = r6.optString(r10)
            java.lang.String r12 = "obj.optString(\"fee_card_suffix\")"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r10, r12)
            r9.setFeeCardSuffix(r10)
            java.lang.String r10 = "fee_value_rgb"
            java.lang.String r6 = r6.optString(r10)
            java.lang.String r10 = "obj.optString(\"fee_value_rgb\")"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r10)
            r9.setFeeValueRGB(r6)
            java.util.List<com.didi.component.payentrance.model.FareInfoItem> r6 = r0.feeList
            r6.add(r9)
            if (r8 < r4) goto L_0x036a
            goto L_0x0370
        L_0x036a:
            r6 = r8
            r19 = r11
            goto L_0x030b
        L_0x036e:
            r11 = r19
        L_0x0370:
            java.util.List<com.didi.component.payentrance.model.FareInfoItem> r4 = r0.feeList
            com.didi.component.payentrance.model.FareInfoItem r4 = r0.parseHighlight(r1, r4)
            java.lang.String r5 = "split_fee_info_list"
            org.json.JSONArray r5 = r1.optJSONArray(r5)
            if (r5 == 0) goto L_0x03b9
            int r6 = r5.length()
            if (r6 <= 0) goto L_0x03b9
            r8 = 0
        L_0x0385:
            int r9 = r8 + 1
            org.json.JSONObject r8 = r5.optJSONObject(r8)
            com.didi.component.payentrance.model.FareInfoItem r10 = new com.didi.component.payentrance.model.FareInfoItem
            r10.<init>()
            r12 = 3
            r10.setType(r12)
            java.lang.String r12 = r8.optString(r7)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r12, r13)
            r10.setFeeLabel(r12)
            java.lang.String r12 = r8.optString(r15)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r12, r11)
            r10.setFeeValue(r12)
            int r8 = r8.optInt(r14)
            r10.setFeeType(r8)
            java.util.List<com.didi.component.payentrance.model.FareInfoItem> r8 = r0.feeList
            r8.add(r10)
            if (r9 < r6) goto L_0x03b7
            goto L_0x03b9
        L_0x03b7:
            r8 = r9
            goto L_0x0385
        L_0x03b9:
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            java.util.List r5 = (java.util.List) r5
            java.lang.String r6 = "jp_un_pickup_fee"
            java.lang.String r6 = r1.optString(r6)
            java.lang.String r7 = "msg"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r7)     // Catch:{ NumberFormatException -> 0x03df }
            r7 = r6
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7     // Catch:{ NumberFormatException -> 0x03df }
            int r7 = r7.length()     // Catch:{ NumberFormatException -> 0x03df }
            if (r7 != 0) goto L_0x03d6
            r7 = 1
            goto L_0x03d7
        L_0x03d6:
            r7 = 0
        L_0x03d7:
            if (r7 == 0) goto L_0x03da
            goto L_0x03df
        L_0x03da:
            int r6 = java.lang.Integer.parseInt(r6)     // Catch:{ NumberFormatException -> 0x03df }
            goto L_0x03e0
        L_0x03df:
            r6 = 1
        L_0x03e0:
            boolean r7 = com.didi.component.business.util.GlobalApolloUtil.isJpPickupFeeOpen()
            if (r7 == 0) goto L_0x0435
            if (r6 != 0) goto L_0x0435
            java.lang.String r6 = r0.payStatus
            java.lang.String r7 = "2"
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r6, (java.lang.Object) r7)
            if (r6 != 0) goto L_0x03fc
            java.lang.String r6 = r0.payStatus
            java.lang.String r7 = "3"
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r6, (java.lang.Object) r7)
            if (r6 == 0) goto L_0x0435
        L_0x03fc:
            if (r2 == 0) goto L_0x0435
            com.didi.component.payentrance.model.FareInfoItem r6 = new com.didi.component.payentrance.model.FareInfoItem
            r6.<init>()
            r7 = 1
            r6.setType(r7)
            java.lang.String r7 = "pe_pay_fare_details_pick_up_fee"
            java.lang.String r7 = r1.optString(r7)
            if (r2 == 0) goto L_0x0426
            java.lang.String r8 = "pickUpFee"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r8)
            r8 = r7
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            int r8 = r8.length()
            if (r8 <= 0) goto L_0x041f
            r8 = 1
            goto L_0x0420
        L_0x041f:
            r8 = 0
        L_0x0420:
            if (r8 == 0) goto L_0x0426
            r6.setFeeLabel(r7)
            goto L_0x0432
        L_0x0426:
            android.content.Context r7 = r0.context
            r8 = 2131957110(0x7f131576, float:1.9550795E38)
            java.lang.String r7 = com.didiglobal.travel.infra.content.ContextKt.stringOf(r7, r8)
            r6.setFeeLabel(r7)
        L_0x0432:
            r5.add(r6)
        L_0x0435:
            if (r4 != 0) goto L_0x0438
            goto L_0x043d
        L_0x0438:
            r5.add(r4)
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
        L_0x043d:
            java.lang.String r4 = "showCouponTip"
            java.lang.String r4 = r1.optString(r4)
            java.lang.String r6 = "tip"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r6)
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            int r4 = r4.length()
            if (r4 <= 0) goto L_0x0452
            r4 = 1
            goto L_0x0453
        L_0x0452:
            r4 = 0
        L_0x0453:
            if (r4 == 0) goto L_0x048c
            com.didi.component.payentrance.model.FareInfoItem r4 = new com.didi.component.payentrance.model.FareInfoItem
            r4.<init>()
            r6 = 1
            r4.setType(r6)
            java.lang.String r6 = "pe_pay_fare_details_tip"
            java.lang.String r6 = r1.optString(r6)
            if (r2 == 0) goto L_0x047d
            java.lang.String r7 = "fareDetailTip"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r7)
            r7 = r6
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            int r7 = r7.length()
            if (r7 <= 0) goto L_0x0476
            r7 = 1
            goto L_0x0477
        L_0x0476:
            r7 = 0
        L_0x0477:
            if (r7 == 0) goto L_0x047d
            r4.setFeeLabel(r6)
            goto L_0x0489
        L_0x047d:
            android.content.Context r6 = r0.context
            r7 = 2131957112(0x7f131578, float:1.9550799E38)
            java.lang.String r6 = com.didiglobal.travel.infra.content.ContextKt.stringOf(r6, r7)
            r4.setFeeLabel(r6)
        L_0x0489:
            r5.add(r4)
        L_0x048c:
            java.lang.String r4 = "showInTripTips"
            java.lang.String r4 = r1.optString(r4)
            java.lang.String r6 = "tips"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r6)
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            int r4 = r4.length()
            if (r4 <= 0) goto L_0x04a1
            r4 = 1
            goto L_0x04a2
        L_0x04a1:
            r4 = 0
        L_0x04a2:
            if (r4 == 0) goto L_0x04db
            com.didi.component.payentrance.model.FareInfoItem r4 = new com.didi.component.payentrance.model.FareInfoItem
            r4.<init>()
            r6 = 1
            r4.setType(r6)
            java.lang.String r6 = "pe_pay_fare_details_tips"
            java.lang.String r6 = r1.optString(r6)
            if (r2 == 0) goto L_0x04cc
            java.lang.String r7 = "fareDetailTips"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r7)
            r7 = r6
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            int r7 = r7.length()
            if (r7 <= 0) goto L_0x04c5
            r7 = 1
            goto L_0x04c6
        L_0x04c5:
            r7 = 0
        L_0x04c6:
            if (r7 == 0) goto L_0x04cc
            r4.setFeeLabel(r6)
            goto L_0x04d8
        L_0x04cc:
            android.content.Context r6 = r0.context
            r7 = 2131957113(0x7f131579, float:1.95508E38)
            java.lang.String r6 = com.didiglobal.travel.infra.content.ContextKt.stringOf(r6, r7)
            r4.setFeeLabel(r6)
        L_0x04d8:
            r5.add(r4)
        L_0x04db:
            if (r2 == 0) goto L_0x0505
            java.lang.String r4 = "pe_pay_fare_details_limit_fee"
            java.lang.String r4 = r1.optString(r4)
            java.lang.String r6 = "rideFeeExplainText"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r6)
            r6 = r4
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            int r6 = r6.length()
            if (r6 <= 0) goto L_0x04f3
            r6 = 1
            goto L_0x04f4
        L_0x04f3:
            r6 = 0
        L_0x04f4:
            if (r6 == 0) goto L_0x0505
            com.didi.component.payentrance.model.FareInfoItem r6 = new com.didi.component.payentrance.model.FareInfoItem
            r6.<init>()
            r7 = 1
            r6.setType(r7)
            r6.setFeeLabel(r4)
            r5.add(r6)
        L_0x0505:
            java.lang.String r4 = "passenger_change_msg"
            java.lang.String r4 = r1.optString(r4)
            java.lang.String r6 = "changePayMsg"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r6)
            r6 = r4
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            int r6 = r6.length()
            if (r6 <= 0) goto L_0x051b
            r6 = 1
            goto L_0x051c
        L_0x051b:
            r6 = 0
        L_0x051c:
            if (r6 == 0) goto L_0x0534
            com.didi.component.payentrance.model.FareInfoItem r6 = new com.didi.component.payentrance.model.FareInfoItem
            r6.<init>()
            r7 = 8
            r6.setType(r7)
            r6.setFooterMsg(r4)
            r4 = 1
            r6.setHighlight(r4)
            java.util.List<com.didi.component.payentrance.model.FareInfoItem> r4 = r0.feeList
            r4.add(r6)
        L_0x0534:
            java.util.Collection r5 = (java.util.Collection) r5
            boolean r4 = r5.isEmpty()
            if (r4 != 0) goto L_0x0550
            com.didi.component.payentrance.model.FareInfoItem r4 = new com.didi.component.payentrance.model.FareInfoItem
            r4.<init>()
            r6 = 2
            r4.setType(r6)
            java.util.List<com.didi.component.payentrance.model.FareInfoItem> r6 = r0.feeList
            r6.add(r4)
            java.util.List<com.didi.component.payentrance.model.FareInfoItem> r4 = r0.feeList
            r4.addAll(r5)
            goto L_0x0562
        L_0x0550:
            r6 = 2
            boolean r4 = r0.hasFAQ
            if (r4 != 0) goto L_0x0562
            com.didi.component.payentrance.model.FareInfoItem r4 = new com.didi.component.payentrance.model.FareInfoItem
            r4.<init>()
            r4.setType(r6)
            java.util.List<com.didi.component.payentrance.model.FareInfoItem> r5 = r0.feeList
            r5.add(r4)
        L_0x0562:
            if (r2 != 0) goto L_0x059e
            boolean r2 = r0.isPricingTaxi(r3)
            if (r2 != 0) goto L_0x059e
            java.lang.String r2 = r3.countryCode
            boolean r2 = com.didi.component.business.util.GlobalApolloUtil.shouldHideFareRule(r2)
            if (r2 != 0) goto L_0x059e
            java.lang.String r2 = r0.rulesUrl
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L_0x059e
            com.didi.component.payentrance.model.FareInfoItem r2 = new com.didi.component.payentrance.model.FareInfoItem
            r2.<init>()
            r4 = 6
            r2.setType(r4)
            android.content.Context r4 = r0.context
            r5 = 2131957111(0x7f131577, float:1.9550797E38)
            java.lang.String r4 = com.didi.sdk.util.ResourcesHelper.getString(r4, r5)
            java.lang.String r5 = "getString(context, R.str…e_pay_fare_details_rules)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r5)
            r2.setFeeLabel(r4)
            r2.setCarOrder(r3)
            java.util.List<com.didi.component.payentrance.model.FareInfoItem> r3 = r0.feeList
            r3.add(r2)
        L_0x059e:
            java.lang.String r2 = "rules_list"
            org.json.JSONArray r2 = r1.optJSONArray(r2)
            if (r2 == 0) goto L_0x05d2
            int r3 = r2.length()
            if (r3 <= 0) goto L_0x05d2
            r4 = 0
        L_0x05ad:
            int r5 = r4 + 1
            com.didi.component.payentrance.model.FareInfoItem r6 = new com.didi.component.payentrance.model.FareInfoItem
            r6.<init>()
            r7 = 12
            r6.setType(r7)
            r7 = 0
            java.lang.String r4 = r2.optString(r4, r7)
            java.lang.String r8 = "rulesList.optString(i, null)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r8)
            r6.setTitle(r4)
            java.util.List<com.didi.component.payentrance.model.FareInfoItem> r4 = r0.feeList
            r4.add(r6)
            if (r5 < r3) goto L_0x05ce
            goto L_0x05d3
        L_0x05ce:
            r4 = r5
            goto L_0x05ad
        L_0x05d0:
            r18 = r4
        L_0x05d2:
            r7 = 0
        L_0x05d3:
            boolean r2 = r0.hasFAQ
            if (r2 == 0) goto L_0x0632
            com.didi.component.payentrance.model.FareInfoItem r2 = new com.didi.component.payentrance.model.FareInfoItem
            r2.<init>()
            r3 = 7
            r2.setType(r3)
            java.util.List<com.didi.component.payentrance.model.FareInfoItem> r3 = r0.feeList
            r3.add(r2)
            int r2 = r18.length()
            if (r2 <= 0) goto L_0x0632
            r3 = 0
        L_0x05ec:
            int r4 = r3 + 1
            r5 = r18
            org.json.JSONObject r3 = r5.optJSONObject(r3)
            if (r3 != 0) goto L_0x05f7
            goto L_0x0632
        L_0x05f7:
            java.lang.String r6 = "question"
            java.lang.String r8 = r3.optString(r6)
            java.lang.String r9 = "answer"
            java.lang.String r3 = r3.optString(r9)
            com.didi.component.payentrance.model.FareInfoItem r10 = new com.didi.component.payentrance.model.FareInfoItem
            r10.<init>()
            r11 = 3
            r10.setType(r11)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r6)
            r10.setFeeLabel(r8)
            com.didi.component.payentrance.model.FareInfoItem r6 = new com.didi.component.payentrance.model.FareInfoItem
            r6.<init>()
            r8 = 1
            r6.setType(r8)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r9)
            r6.setFeeLabel(r3)
            java.util.List<com.didi.component.payentrance.model.FareInfoItem> r3 = r0.feeList
            r3.add(r10)
            java.util.List<com.didi.component.payentrance.model.FareInfoItem> r3 = r0.feeList
            r3.add(r6)
            if (r4 < r2) goto L_0x062e
            goto L_0x0633
        L_0x062e:
            r3 = r4
            r18 = r5
            goto L_0x05ec
        L_0x0632:
            r8 = 1
        L_0x0633:
            if (r1 != 0) goto L_0x0636
            goto L_0x0677
        L_0x0636:
            java.lang.String r2 = "preauth_msg"
            java.lang.String r1 = r1.optString(r2)
            if (r1 != 0) goto L_0x063f
            goto L_0x0677
        L_0x063f:
            r2 = r1
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            int r2 = r2.length()
            if (r2 <= 0) goto L_0x064a
            r6 = 1
            goto L_0x064b
        L_0x064a:
            r6 = 0
        L_0x064b:
            if (r6 == 0) goto L_0x0656
            java.lang.String r2 = "null"
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r2)
            if (r2 != 0) goto L_0x0656
            goto L_0x0657
        L_0x0656:
            r8 = 0
        L_0x0657:
            if (r8 == 0) goto L_0x065b
            r2 = r1
            goto L_0x065c
        L_0x065b:
            r2 = r7
        L_0x065c:
            if (r2 != 0) goto L_0x065f
            goto L_0x0677
        L_0x065f:
            java.util.List r1 = r20.getFeeList()
            com.didi.component.payentrance.model.FareInfoItem r3 = new com.didi.component.payentrance.model.FareInfoItem
            r3.<init>()
            r4 = 8
            r3.setType(r4)
            r3.setFooterMsg(r2)
            kotlin.Unit r2 = kotlin.Unit.INSTANCE
            r1.add(r3)
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
        L_0x0677:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.component.payentrance.model.FareDetailsModel.parse(org.json.JSONObject):void");
    }

    private final boolean isPricingTaxi(CarOrder carOrder) {
        String str = carOrder.carLevel;
        if (str != null && Integer.parseInt(str) == 1800) {
            return true;
        }
        return DynamicConfigManager.getInstance().checkConfigEnable(carOrder.getProductId(), DynamicConfigManager.FUNCTION_KEY_PRICING_MODE, false);
    }

    private final FareInfoItem parseHighlight(JSONObject jSONObject, List<FareInfoItem> list) {
        JSONObject optJSONObject = jSONObject.optJSONObject("discountFeeInfo");
        String str = null;
        if (optJSONObject == null) {
            return null;
        }
        JSONObject r4 = FeeItemInfo.m46262constructorimpl(optJSONObject);
        int r0 = FeeItemInfo.m46259component1impl(r4);
        String r42 = FeeItemInfo.m46260component2impl(r4);
        FareInfoItem fareInfoItem = new FareInfoItem();
        fareInfoItem.setFeeType(r0);
        CharSequence charSequence = r42;
        if (charSequence != null) {
            if (charSequence.length() > 0) {
                str = charSequence;
            }
        }
        String str2 = str;
        if (str2 == null) {
            str2 = ContextKt.stringOf(getContext(), R.string.pe_pay_fare_details_favour);
        }
        fareInfoItem.setFeeLabel(str2);
        fareInfoItem.setType(r0);
        return fareInfoItem;
    }

    private final void parseUrls(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("links");
        if (optJSONObject != null) {
            String optString = optJSONObject.optString("rule_url");
            Intrinsics.checkNotNullExpressionValue(optString, "it.optString(\"rule_url\")");
            this.rulesUrl = optString;
        }
    }
}
