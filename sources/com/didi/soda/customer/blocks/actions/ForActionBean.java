package com.didi.soda.customer.blocks.actions;

import com.didi.soda.blocks.model.WidgetNodeModel;
import com.didi.soda.customer.foundation.rpc.entity.IEntity;
import com.didi.soda.customer.foundation.util.CollectionUtilsKt;
import com.didi.soda.customer.foundation.util.GsonUtil;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(mo175977d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0002\u0018\u0000 #2\u00020\u0001:\u0001#B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u001f\u001a\u00020 H\u0002J\b\u0010!\u001a\u00020 H\u0002J\u0006\u0010\"\u001a\u00020 R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\b\"\u0004\b\u0013\u0010\nR\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\b\"\u0004\b\u0016\u0010\nR\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\b\"\u0004\b\u0019\u0010\nR\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\b\"\u0004\b\u001c\u0010\nR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001e¨\u0006$"}, mo175978d2 = {"Lcom/didi/soda/customer/blocks/actions/ForActionBean;", "Lcom/didi/soda/customer/foundation/rpc/entity/IEntity;", "widgetNodeModel", "Lcom/didi/soda/blocks/model/WidgetNodeModel;", "(Lcom/didi/soda/blocks/model/WidgetNodeModel;)V", "contextKey", "", "getContextKey", "()Ljava/lang/String;", "setContextKey", "(Ljava/lang/String;)V", "data", "Lcom/google/gson/JsonArray;", "getData", "()Lcom/google/gson/JsonArray;", "setData", "(Lcom/google/gson/JsonArray;)V", "divider", "getDivider", "setDivider", "jsonKey", "getJsonKey", "setJsonKey", "type", "getType", "setType", "valueKey", "getValueKey", "setValueKey", "getWidgetNodeModel", "()Lcom/didi/soda/blocks/model/WidgetNodeModel;", "formatToJson", "", "formatToString", "run", "Companion", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: ForEachTrackParams.kt */
final class ForActionBean implements IEntity {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String JSON_TYPE = "json";
    private String contextKey = "";
    private JsonArray data;
    private String divider = "";
    private String jsonKey = "";
    private String type = "";
    private String valueKey = "";
    private final WidgetNodeModel widgetNodeModel;

    public ForActionBean(WidgetNodeModel widgetNodeModel2) {
        this.widgetNodeModel = widgetNodeModel2;
    }

    public final WidgetNodeModel getWidgetNodeModel() {
        return this.widgetNodeModel;
    }

    public final JsonArray getData() {
        return this.data;
    }

    public final void setData(JsonArray jsonArray) {
        this.data = jsonArray;
    }

    public final String getValueKey() {
        return this.valueKey;
    }

    public final void setValueKey(String str) {
        this.valueKey = str;
    }

    public final String getDivider() {
        return this.divider;
    }

    public final void setDivider(String str) {
        this.divider = str;
    }

    public final String getContextKey() {
        return this.contextKey;
    }

    public final void setContextKey(String str) {
        this.contextKey = str;
    }

    public final String getType() {
        return this.type;
    }

    public final void setType(String str) {
        this.type = str;
    }

    public final String getJsonKey() {
        return this.jsonKey;
    }

    public final void setJsonKey(String str) {
        this.jsonKey = str;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v1, resolved type: java.lang.Integer} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v7, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r4v0 */
    /* JADX WARNING: type inference failed for: r4v9 */
    /* JADX WARNING: type inference failed for: r4v10 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void formatToString() {
        /*
            r8 = this;
            com.google.gson.JsonArray r0 = r8.data
            if (r0 != 0) goto L_0x0006
            goto L_0x0107
        L_0x0006:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
        L_0x0011:
            boolean r2 = r0.hasNext()
            java.lang.String r3 = "null"
            r4 = 0
            r5 = 0
            r6 = 1
            if (r2 == 0) goto L_0x0082
            java.lang.Object r2 = r0.next()
            com.google.gson.JsonElement r2 = (com.google.gson.JsonElement) r2
            java.lang.String r7 = r8.getValueKey()
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            if (r7 == 0) goto L_0x0033
            int r7 = r7.length()
            if (r7 != 0) goto L_0x0031
            goto L_0x0033
        L_0x0031:
            r7 = 0
            goto L_0x0034
        L_0x0033:
            r7 = 1
        L_0x0034:
            if (r7 == 0) goto L_0x0043
            java.lang.String r7 = "it"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r7)
            java.lang.String r2 = com.didi.global.fintech.cashier.p117ui.kts.JsonKtxKt.toJson$default(r2, r4, r6, r4)
            r1.append(r2)
            goto L_0x005c
        L_0x0043:
            com.google.gson.JsonObject r2 = r2.getAsJsonObject()
            if (r2 != 0) goto L_0x004a
            goto L_0x0059
        L_0x004a:
            java.lang.String r7 = r8.getValueKey()
            com.google.gson.JsonElement r2 = r2.get(r7)
            if (r2 != 0) goto L_0x0055
            goto L_0x0059
        L_0x0055:
            java.lang.String r4 = r2.getAsString()
        L_0x0059:
            r1.append(r4)
        L_0x005c:
            java.lang.String r2 = r8.getDivider()
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            if (r2 == 0) goto L_0x006d
            int r4 = r2.length()
            if (r4 != 0) goto L_0x006b
            goto L_0x006d
        L_0x006b:
            r4 = 0
            goto L_0x006e
        L_0x006d:
            r4 = 1
        L_0x006e:
            if (r4 != 0) goto L_0x0078
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r3)
            r2 = r2 ^ r6
            if (r2 == 0) goto L_0x0078
            r5 = 1
        L_0x0078:
            if (r5 == 0) goto L_0x0011
            java.lang.String r2 = r8.getDivider()
            r1.append(r2)
            goto L_0x0011
        L_0x0082:
            r0 = r1
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            int r0 = r0.length()
            if (r0 <= 0) goto L_0x008d
            r0 = 1
            goto L_0x008e
        L_0x008d:
            r0 = 0
        L_0x008e:
            if (r0 == 0) goto L_0x0107
            java.lang.String r0 = r8.getDivider()
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            if (r0 == 0) goto L_0x00a1
            int r2 = r0.length()
            if (r2 != 0) goto L_0x009f
            goto L_0x00a1
        L_0x009f:
            r2 = 0
            goto L_0x00a2
        L_0x00a1:
            r2 = 1
        L_0x00a2:
            if (r2 != 0) goto L_0x00ad
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r3)
            r0 = r0 ^ r6
            if (r0 == 0) goto L_0x00ad
            r0 = 1
            goto L_0x00ae
        L_0x00ad:
            r0 = 0
        L_0x00ae:
            if (r0 == 0) goto L_0x00cd
            int r0 = r1.length()
            java.lang.String r2 = r8.getDivider()
            if (r2 != 0) goto L_0x00bb
            goto L_0x00c3
        L_0x00bb:
            int r2 = r2.length()
            java.lang.Integer r4 = java.lang.Integer.valueOf(r2)
        L_0x00c3:
            int r2 = com.didi.soda.customer.foundation.util.ExtentionsKt.orZero((java.lang.Integer) r4)
            int r0 = r0 - r2
            java.lang.String r0 = r1.substring(r5, r0)
            goto L_0x00d1
        L_0x00cd:
            java.lang.String r0 = r1.toString()
        L_0x00d1:
            java.lang.String r1 = r8.getContextKey()
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            if (r1 == 0) goto L_0x00e2
            int r2 = r1.length()
            if (r2 != 0) goto L_0x00e0
            goto L_0x00e2
        L_0x00e0:
            r2 = 0
            goto L_0x00e3
        L_0x00e2:
            r2 = 1
        L_0x00e3:
            if (r2 != 0) goto L_0x00ed
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r3)
            r1 = r1 ^ r6
            if (r1 == 0) goto L_0x00ed
            r5 = 1
        L_0x00ed:
            if (r5 == 0) goto L_0x0107
            com.didi.soda.blocks.model.WidgetNodeModel r1 = r8.getWidgetNodeModel()
            if (r1 != 0) goto L_0x00f6
            goto L_0x0107
        L_0x00f6:
            java.util.HashMap r1 = r1.getContext()
            if (r1 != 0) goto L_0x00fd
            goto L_0x0107
        L_0x00fd:
            java.lang.String r2 = r8.getContextKey()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2)
            r1.put(r2, r0)
        L_0x0107:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.customer.blocks.actions.ForActionBean.formatToString():void");
    }

    private final void formatToJson() {
        boolean z;
        WidgetNodeModel widgetNodeModel2;
        HashMap<String, Object> context;
        String str;
        JsonElement jsonElement;
        JsonArray jsonArray = this.data;
        if (jsonArray != null) {
            JsonArray jsonArray2 = new JsonArray();
            Iterator it = jsonArray.iterator();
            while (true) {
                z = false;
                if (!it.hasNext()) {
                    break;
                }
                JsonElement jsonElement2 = (JsonElement) it.next();
                JsonObject jsonObject = new JsonObject();
                String valueKey2 = getValueKey();
                List split$default = valueKey2 == null ? null : StringsKt.split$default((CharSequence) valueKey2, new String[]{","}, false, 0, 6, (Object) null);
                String jsonKey2 = getJsonKey();
                List split$default2 = jsonKey2 == null ? null : StringsKt.split$default((CharSequence) jsonKey2, new String[]{","}, false, 0, 6, (Object) null);
                if (split$default != null) {
                    int i = 0;
                    for (Object next : split$default) {
                        int i2 = i + 1;
                        if (i < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        String str2 = (String) next;
                        JsonObject asJsonObject = jsonElement2.getAsJsonObject();
                        String asString = (asJsonObject == null || (jsonElement = asJsonObject.get(str2)) == null) ? null : jsonElement.getAsString();
                        if (split$default2 == null) {
                            str = null;
                        } else {
                            str = (String) CollectionUtilsKt.safeGet(split$default2, i);
                        }
                        CharSequence charSequence = str;
                        if (!(charSequence == null || charSequence.length() == 0) && (Intrinsics.areEqual((Object) charSequence, (Object) "null") ^ true)) {
                            CharSequence charSequence2 = asString;
                            if (!(charSequence2 == null || charSequence2.length() == 0) && (Intrinsics.areEqual((Object) charSequence2, (Object) "null") ^ true)) {
                                jsonObject.addProperty(str, asString);
                            }
                        }
                        i = i2;
                    }
                }
                if (jsonObject.size() > 0) {
                    jsonArray2.add((JsonElement) jsonObject);
                }
            }
            if (!jsonArray2.isEmpty()) {
                CharSequence contextKey2 = getContextKey();
                if (!(contextKey2 == null || contextKey2.length() == 0) && (!Intrinsics.areEqual((Object) contextKey2, (Object) "null"))) {
                    z = true;
                }
                if (z && (widgetNodeModel2 = getWidgetNodeModel()) != null && (context = widgetNodeModel2.getContext()) != null) {
                    String contextKey3 = getContextKey();
                    Intrinsics.checkNotNull(contextKey3);
                    context.put(contextKey3, GsonUtil.toJson(jsonArray2));
                }
            }
        }
    }

    public final void run() {
        try {
            if (Intrinsics.areEqual((Object) getType(), (Object) "json")) {
                formatToJson();
            } else {
                formatToString();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Metadata(mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo175978d2 = {"Lcom/didi/soda/customer/blocks/actions/ForActionBean$Companion;", "", "()V", "JSON_TYPE", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: ForEachTrackParams.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
