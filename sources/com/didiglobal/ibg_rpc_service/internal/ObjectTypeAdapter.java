package com.didiglobal.ibg_rpc_service.internal;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(mo175977d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u000e2\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001:\u0001\u000eB\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00022\u0006\u0010\b\u001a\u00020\tH\u0016J\u001a\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u000f"}, mo175978d2 = {"Lcom/didiglobal/ibg_rpc_service/internal/ObjectTypeAdapter;", "Lcom/google/gson/TypeAdapter;", "", "()V", "adaptNumber", "value", "", "read", "source", "Lcom/google/gson/stream/JsonReader;", "write", "", "out", "Lcom/google/gson/stream/JsonWriter;", "Companion", "ibg_rpc_service_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: ObjectTypeAdapter.kt */
public final class ObjectTypeAdapter extends TypeAdapter<Object> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a */
    private static final String f50253a = "ObjectTypeAdapter";
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static final Lazy<Gson> f50254b = LazyKt.lazy(ObjectTypeAdapter$Companion$gson$2.INSTANCE);
    /* access modifiers changed from: private */

    /* renamed from: c */
    public static final Lazy<TypeAdapter<Object>> f50255c = LazyKt.lazy(ObjectTypeAdapter$Companion$objectTypeAdapter$2.INSTANCE);

    @Metadata(mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: ObjectTypeAdapter.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[JsonToken.values().length];
            iArr[JsonToken.BEGIN_ARRAY.ordinal()] = 1;
            iArr[JsonToken.BEGIN_OBJECT.ordinal()] = 2;
            iArr[JsonToken.STRING.ordinal()] = 3;
            iArr[JsonToken.NUMBER.ordinal()] = 4;
            iArr[JsonToken.BOOLEAN.ordinal()] = 5;
            iArr[JsonToken.NULL.ordinal()] = 6;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v3, resolved type: java.util.List} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v7, resolved type: java.util.Map} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v12, resolved type: java.util.List} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v13, resolved type: java.util.List} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object read(com.google.gson.stream.JsonReader r4) throws java.io.IOException {
        /*
            r3 = this;
            java.lang.String r0 = "source"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            com.google.gson.stream.JsonToken r0 = r4.peek()
            if (r0 != 0) goto L_0x000d
            r0 = -1
            goto L_0x0015
        L_0x000d:
            int[] r1 = com.didiglobal.ibg_rpc_service.internal.ObjectTypeAdapter.WhenMappings.$EnumSwitchMapping$0
            int r0 = r0.ordinal()
            r0 = r1[r0]
        L_0x0015:
            switch(r0) {
                case 1: goto L_0x0064;
                case 2: goto L_0x003f;
                case 3: goto L_0x003a;
                case 4: goto L_0x002c;
                case 5: goto L_0x0023;
                case 6: goto L_0x001e;
                default: goto L_0x0018;
            }
        L_0x0018:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            r4.<init>()
            throw r4
        L_0x001e:
            r4.nextNull()
            r4 = 0
            goto L_0x0080
        L_0x0023:
            boolean r4 = r4.nextBoolean()
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4)
            goto L_0x0080
        L_0x002c:
            java.lang.String r4 = r4.nextString()
            java.lang.String r0 = "value"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r0)
            java.lang.Object r4 = r3.m36211a(r4)
            goto L_0x0080
        L_0x003a:
            java.lang.String r4 = r4.nextString()
            goto L_0x0080
        L_0x003f:
            com.google.gson.internal.LinkedTreeMap r0 = new com.google.gson.internal.LinkedTreeMap
            r0.<init>()
            java.util.Map r0 = (java.util.Map) r0
            r4.beginObject()
        L_0x0049:
            boolean r1 = r4.hasNext()
            if (r1 == 0) goto L_0x0060
            java.lang.String r1 = r4.nextName()
            java.lang.String r2 = "source.nextName()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            java.lang.Object r2 = r3.read(r4)
            r0.put(r1, r2)
            goto L_0x0049
        L_0x0060:
            r4.endObject()
            goto L_0x007f
        L_0x0064:
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.List r0 = (java.util.List) r0
            r4.beginArray()
        L_0x006e:
            boolean r1 = r4.hasNext()
            if (r1 == 0) goto L_0x007c
            java.lang.Object r1 = r3.read(r4)
            r0.add(r1)
            goto L_0x006e
        L_0x007c:
            r4.endArray()
        L_0x007f:
            r4 = r0
        L_0x0080:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didiglobal.ibg_rpc_service.internal.ObjectTypeAdapter.read(com.google.gson.stream.JsonReader):java.lang.Object");
    }

    /* renamed from: a */
    private final Object m36211a(String str) {
        long j;
        double d;
        boolean z = false;
        if (StringsKt.contains$default((CharSequence) str, (CharSequence) ".", false, 2, (Object) null)) {
            try {
                d = Double.parseDouble(str);
            } catch (Exception e) {
                Logger.m36209e(f50253a, "adaptNumber", e);
                d = 0.0d;
            }
            j = Double.valueOf(d);
        } else {
            try {
                long parseLong = Long.parseLong(str);
                if (-2147483648L <= parseLong && parseLong <= 2147483647L) {
                    z = true;
                }
                if (z) {
                    j = Integer.valueOf((int) parseLong);
                } else {
                    j = Long.valueOf(parseLong);
                }
            } catch (Exception e2) {
                Logger.m36209e(f50253a, "adaptNumber", e2);
                j = 0L;
            }
        }
        Logger.m36210v(f50253a, Intrinsics.stringPlus("adaptNumber return ", j));
        return j;
    }

    public void write(JsonWriter jsonWriter, Object obj) throws IOException {
        Intrinsics.checkNotNullParameter(jsonWriter, "out");
        Companion.getObjectTypeAdapter().write(jsonWriter, obj);
    }

    @Metadata(mo175977d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR#\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\f8BX\u0002¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000e¨\u0006\u0010"}, mo175978d2 = {"Lcom/didiglobal/ibg_rpc_service/internal/ObjectTypeAdapter$Companion;", "", "()V", "TAG", "", "gson", "Lcom/google/gson/Gson;", "getGson", "()Lcom/google/gson/Gson;", "gson$delegate", "Lkotlin/Lazy;", "objectTypeAdapter", "Lcom/google/gson/TypeAdapter;", "getObjectTypeAdapter", "()Lcom/google/gson/TypeAdapter;", "objectTypeAdapter$delegate", "ibg_rpc_service_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: ObjectTypeAdapter.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* access modifiers changed from: private */
        public final Gson getGson() {
            return (Gson) ObjectTypeAdapter.f50254b.getValue();
        }

        /* access modifiers changed from: private */
        public final TypeAdapter<Object> getObjectTypeAdapter() {
            Object value = ObjectTypeAdapter.f50255c.getValue();
            Intrinsics.checkNotNullExpressionValue(value, "<get-objectTypeAdapter>(...)");
            return (TypeAdapter) value;
        }
    }
}
