package com.didi.soda.customer.dynamic;

import android.text.TextUtils;
import com.didi.app.nova.support.view.recyclerview.binder.RecyclerModel;
import com.didi.soda.blocks.model.ComponentModel;
import com.didi.soda.blocks.scope.IBlockScope;
import com.didi.soda.datasource.listener.DataMapFunction;
import com.google.gson.JsonObject;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0006\b&\u0018\u0000 )2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001)B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J \u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\bH\u0016J \u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001aH\u0002J\u0018\u0010\u001c\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\u0003H\u0016J\u0012\u0010\u001f\u001a\u00020\u001a2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0002H\u0004J\u0018\u0010 \u001a\u00020!2\u0006\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\u0003H\u0016J\u0010\u0010\"\u001a\u00020!2\u0006\u0010\u001d\u001a\u00020\u001aH&J$\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00030$2\u0006\u0010%\u001a\u00020\b2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00020$H\u0016J*\u0010'\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u001d\u001a\u00020\u001a2\u0006\u0010(\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\bH&R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0006¨\u0006*"}, mo175978d2 = {"Lcom/didi/soda/customer/dynamic/DynamicDataMapFunction;", "Lcom/didi/soda/datasource/listener/DataMapFunction;", "Lcom/google/gson/JsonObject;", "Lcom/didi/app/nova/support/view/recyclerview/binder/RecyclerModel;", "scope", "Lcom/didi/soda/blocks/scope/IBlockScope;", "(Lcom/didi/soda/blocks/scope/IBlockScope;)V", "mComponentIndex", "", "mIndexOffset", "getMIndexOffset", "()I", "setMIndexOffset", "(I)V", "getScope", "()Lcom/didi/soda/blocks/scope/IBlockScope;", "setScope", "attachContextParams", "", "componentModel", "Lcom/didi/soda/blocks/model/ComponentModel;", "pageIndex", "index", "attachNeighborType", "componentJsonObject", "preType", "", "nextType", "getSkippedIndexOffset", "type", "rvModel", "getType", "isIndexIgnoreType", "", "isParsable", "mapData", "", "key", "sourceList", "parse", "itemJsonObject", "Companion", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: DynamicDataMapFunction.kt */
public abstract class DynamicDataMapFunction implements DataMapFunction<JsonObject, RecyclerModel> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String NEXT_TYPE = "Next_Type";
    public static final String PRE_TYPE = "Pre_Type";
    public static final String TYPE_NONE = "";

    /* renamed from: a */
    private IBlockScope f40886a;

    /* renamed from: b */
    private int f40887b;

    /* renamed from: c */
    private int f40888c;

    public void attachContextParams(ComponentModel componentModel, int i, int i2) {
        Intrinsics.checkNotNullParameter(componentModel, "componentModel");
    }

    public int getSkippedIndexOffset(String str, RecyclerModel recyclerModel) {
        Intrinsics.checkNotNullParameter(str, "type");
        Intrinsics.checkNotNullParameter(recyclerModel, "rvModel");
        return 0;
    }

    public boolean isIndexIgnoreType(String str, RecyclerModel recyclerModel) {
        Intrinsics.checkNotNullParameter(str, "type");
        Intrinsics.checkNotNullParameter(recyclerModel, "rvModel");
        return false;
    }

    public abstract boolean isParsable(String str);

    public abstract RecyclerModel parse(String str, JsonObject jsonObject, int i, int i2);

    public DynamicDataMapFunction(IBlockScope iBlockScope) {
        Intrinsics.checkNotNullParameter(iBlockScope, "scope");
        this.f40886a = iBlockScope;
    }

    public final IBlockScope getScope() {
        return this.f40886a;
    }

    public final void setScope(IBlockScope iBlockScope) {
        Intrinsics.checkNotNullParameter(iBlockScope, "<set-?>");
        this.f40886a = iBlockScope;
    }

    public int getMIndexOffset() {
        return this.f40888c;
    }

    public void setMIndexOffset(int i) {
        this.f40888c = i;
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x00af A[LOOP:0: B:3:0x001a->B:38:0x00af, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00b2 A[EDGE_INSN: B:40:0x00b2->B:39:0x00b2 ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<com.didi.app.nova.support.view.recyclerview.binder.RecyclerModel> mapData(int r12, java.util.List<com.google.gson.JsonObject> r13) {
        /*
            r11 = this;
            java.lang.String r0 = "sourceList"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.List r0 = (java.util.List) r0
            int r1 = r13.size()
            int r1 = r1 + -1
            if (r1 < 0) goto L_0x00b2
            r2 = 0
            java.lang.String r3 = ""
            r5 = r3
            r4 = 0
        L_0x001a:
            int r6 = r4 + 1
            java.lang.Object r7 = r13.get(r4)
            com.google.gson.JsonObject r7 = (com.google.gson.JsonObject) r7
            r8 = 1
            if (r12 != 0) goto L_0x002e
            if (r4 != 0) goto L_0x002e
            int r9 = r11.getMIndexOffset()
            r11.f40887b = r9
            goto L_0x0033
        L_0x002e:
            int r9 = r11.f40887b
            int r9 = r9 + r8
            r11.f40887b = r9
        L_0x0033:
            java.lang.String r9 = r11.getType(r7)
            int r10 = r13.size()
            int r10 = r10 - r8
            if (r4 >= r10) goto L_0x003f
            goto L_0x0040
        L_0x003f:
            r8 = 0
        L_0x0040:
            r4 = 0
            if (r8 == 0) goto L_0x0045
            r8 = r13
            goto L_0x0046
        L_0x0045:
            r8 = r4
        L_0x0046:
            if (r8 != 0) goto L_0x004a
        L_0x0048:
            r8 = r3
            goto L_0x005a
        L_0x004a:
            java.lang.Object r8 = r8.get(r6)
            com.google.gson.JsonObject r8 = (com.google.gson.JsonObject) r8
            if (r8 != 0) goto L_0x0053
            goto L_0x0048
        L_0x0053:
            java.lang.String r8 = r11.getType(r8)
            if (r8 != 0) goto L_0x005a
            goto L_0x0048
        L_0x005a:
            com.didi.soda.customer.dynamic.BlocksCommonParser$Companion r10 = com.didi.soda.customer.dynamic.BlocksCommonParser.Companion
            boolean r10 = r10.isBlockType(r7)
            if (r10 == 0) goto L_0x0080
            com.didi.soda.customer.dynamic.BlocksCommonParser$Companion r5 = com.didi.soda.customer.dynamic.BlocksCommonParser.Companion
            android.content.Context r8 = com.didi.soda.customer.app.GlobalContext.getContext()
            java.lang.String r10 = "getContext()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r10)
            com.didi.soda.blocks.scope.IBlockScope r10 = r11.f40886a
            com.didi.app.nova.support.view.recyclerview.binder.RecyclerModel r5 = r5.parse(r8, r7, r10)
            if (r5 != 0) goto L_0x0076
            goto L_0x008f
        L_0x0076:
            r4 = r5
            com.didi.soda.blocks.model.ComponentModel r4 = (com.didi.soda.blocks.model.ComponentModel) r4
            int r7 = r11.f40887b
            r11.attachContextParams(r4, r12, r7)
            r4 = r5
            goto L_0x008f
        L_0x0080:
            boolean r4 = r11.isParsable(r9)
            if (r4 == 0) goto L_0x00ac
            r11.m29051a(r7, r5, r8)
            int r4 = r11.f40887b
            com.didi.app.nova.support.view.recyclerview.binder.RecyclerModel r4 = r11.parse(r9, r7, r12, r4)
        L_0x008f:
            if (r4 == 0) goto L_0x00ab
            r0.add(r4)
            boolean r5 = r11.isIndexIgnoreType(r9, r4)
            if (r5 == 0) goto L_0x00a0
            int r5 = r11.f40887b
            int r5 = r5 + -1
            r11.f40887b = r5
        L_0x00a0:
            int r4 = r11.getSkippedIndexOffset(r9, r4)
            if (r4 <= 0) goto L_0x00ab
            int r5 = r11.f40887b
            int r5 = r5 + r4
            r11.f40887b = r5
        L_0x00ab:
            r5 = r9
        L_0x00ac:
            if (r6 <= r1) goto L_0x00af
            goto L_0x00b2
        L_0x00af:
            r4 = r6
            goto L_0x001a
        L_0x00b2:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.customer.dynamic.DynamicDataMapFunction.mapData(int, java.util.List):java.util.List");
    }

    /* access modifiers changed from: protected */
    public final String getType(JsonObject jsonObject) {
        if (jsonObject == null) {
            return "";
        }
        try {
            if (jsonObject.isJsonNull()) {
                return "";
            }
            String asString = jsonObject.get("type").getAsString();
            if (TextUtils.isEmpty(asString)) {
                return "";
            }
            Intrinsics.checkNotNullExpressionValue(asString, "{\n                type\n            }");
            return asString;
        } catch (Exception unused) {
            return "";
        }
    }

    /* renamed from: a */
    private final void m29051a(JsonObject jsonObject, String str, String str2) {
        jsonObject.addProperty(PRE_TYPE, str);
        jsonObject.addProperty(NEXT_TYPE, str2);
    }

    @Metadata(mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, mo175978d2 = {"Lcom/didi/soda/customer/dynamic/DynamicDataMapFunction$Companion;", "", "()V", "NEXT_TYPE", "", "PRE_TYPE", "TYPE_NONE", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: DynamicDataMapFunction.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
