package com.didi.dimina.container.secondparty.trace.inner;

import com.didi.dimina.container.DMMina;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010$\n\u0002\b\u0006\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001J\u001c\u0010\u0013\u001a\u00020\u00002\u0014\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0017J\b\u0010\u0018\u001a\u00020\u000eH\u0002J\u0006\u0010\u0019\u001a\u00020\u0005J\u0006\u0010\u001a\u001a\u00020\u0005J\b\u0010\u001b\u001a\u00020\u0005H\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u001d"}, mo175978d2 = {"Lcom/didi/dimina/container/secondparty/trace/inner/LogBase;", "", "mina", "Lcom/didi/dimina/container/DMMina;", "eventId", "", "(Lcom/didi/dimina/container/DMMina;Ljava/lang/String;)V", "currentLogCreateTime", "", "getEventId", "()Ljava/lang/String;", "setEventId", "(Ljava/lang/String;)V", "eventmap", "Lorg/json/JSONObject;", "getMina", "()Lcom/didi/dimina/container/DMMina;", "setMina", "(Lcom/didi/dimina/container/DMMina;)V", "append", "key", "value", "hashMap", "", "getParamsJsonObj", "getSeq", "toJsonStr", "toString", "Companion", "2party-impl_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: LogBase.kt */
public final class LogBase {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String KEY_DATA = "tech_saga_track_data";
    public static final String KEY_EVENT_ID = "tech_saga_track_type";
    public static final String KEY_UID = "pub_uid";
    public static final String KEY_UNION_ID = "unionid";

    /* renamed from: a */
    private JSONObject f17456a = new JSONObject();

    /* renamed from: b */
    private final long f17457b = System.currentTimeMillis();

    /* renamed from: c */
    private DMMina f17458c;

    /* renamed from: d */
    private String f17459d;

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0026, code lost:
        r0 = (r0 = r0.getConfig()).getLaunchConfig();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public LogBase(com.didi.dimina.container.DMMina r3, java.lang.String r4) {
        /*
            r2 = this;
            r2.<init>()
            r2.f17458c = r3
            r2.f17459d = r4
            org.json.JSONObject r3 = new org.json.JSONObject
            r3.<init>()
            r2.f17456a = r3
            long r3 = java.lang.System.currentTimeMillis()
            r2.f17457b = r3
            java.lang.String r3 = r2.f17459d
            if (r3 == 0) goto L_0x00f2
            org.json.JSONObject r3 = r2.f17456a     // Catch:{ Exception -> 0x00ed }
            java.lang.String r4 = "pub_jsapp_id"
            com.didi.dimina.container.DMMina r0 = r2.f17458c     // Catch:{ Exception -> 0x00ed }
            if (r0 == 0) goto L_0x0031
            com.didi.dimina.container.DMConfig r0 = r0.getConfig()     // Catch:{ Exception -> 0x00ed }
            if (r0 == 0) goto L_0x0031
            com.didi.dimina.container.DMConfig$LaunchConfig r0 = r0.getLaunchConfig()     // Catch:{ Exception -> 0x00ed }
            if (r0 == 0) goto L_0x0031
            java.lang.String r0 = r0.getAppId()     // Catch:{ Exception -> 0x00ed }
            goto L_0x0032
        L_0x0031:
            r0 = 0
        L_0x0032:
            r3.put(r4, r0)     // Catch:{ Exception -> 0x00ed }
            com.didi.dimina.container.secondparty.trace.inner.LogManager r3 = com.didi.dimina.container.secondparty.trace.inner.LogManager.INSTANCE     // Catch:{ Exception -> 0x00ed }
            r3.getUniqueId()     // Catch:{ Exception -> 0x00ed }
            org.json.JSONObject r3 = r2.f17456a     // Catch:{ Exception -> 0x00ed }
            java.lang.String r4 = "pub_jssdk_version"
            com.didi.dimina.container.DMMina r0 = r2.f17458c     // Catch:{ Exception -> 0x00ed }
            java.lang.String r0 = com.didi.dimina.container.secondparty.bundle.DiminaHelper.getJsSdkVersionName(r0)     // Catch:{ Exception -> 0x00ed }
            r3.put(r4, r0)     // Catch:{ Exception -> 0x00ed }
            org.json.JSONObject r3 = r2.f17456a     // Catch:{ Exception -> 0x00ed }
            java.lang.String r4 = "pub_jssdk_code"
            com.didi.dimina.container.secondparty.trace.inner.LogManager r0 = com.didi.dimina.container.secondparty.trace.inner.LogManager.INSTANCE     // Catch:{ Exception -> 0x00ed }
            com.didi.dimina.container.DMMina r1 = r2.f17458c     // Catch:{ Exception -> 0x00ed }
            java.lang.String r0 = r0.getJssdkVersionCode(r1)     // Catch:{ Exception -> 0x00ed }
            r3.put(r4, r0)     // Catch:{ Exception -> 0x00ed }
            org.json.JSONObject r3 = r2.f17456a     // Catch:{ Exception -> 0x00ed }
            java.lang.String r4 = "pub_jsapp_version"
            com.didi.dimina.container.DMMina r0 = r2.f17458c     // Catch:{ Exception -> 0x00ed }
            java.lang.String r0 = com.didi.dimina.container.secondparty.bundle.DiminaHelper.getJsAppVersionName(r0)     // Catch:{ Exception -> 0x00ed }
            r3.put(r4, r0)     // Catch:{ Exception -> 0x00ed }
            org.json.JSONObject r3 = r2.f17456a     // Catch:{ Exception -> 0x00ed }
            java.lang.String r4 = "pub_jsapp_code"
            com.didi.dimina.container.DMMina r0 = r2.f17458c     // Catch:{ Exception -> 0x00ed }
            java.lang.String r0 = com.didi.dimina.container.secondparty.bundle.DiminaHelper.getJsAppVersionCode(r0)     // Catch:{ Exception -> 0x00ed }
            r3.put(r4, r0)     // Catch:{ Exception -> 0x00ed }
            org.json.JSONObject r3 = r2.f17456a     // Catch:{ Exception -> 0x00ed }
            java.lang.String r4 = "pub_sdk_version"
            java.lang.String r0 = com.didi.dimina.container.Dimina.getVersion()     // Catch:{ Exception -> 0x00ed }
            r3.put(r4, r0)     // Catch:{ Exception -> 0x00ed }
            org.json.JSONObject r3 = r2.f17456a     // Catch:{ Exception -> 0x00ed }
            java.lang.String r4 = "pub_net_type"
            com.didi.dimina.container.secondparty.trace.inner.LogManager r0 = com.didi.dimina.container.secondparty.trace.inner.LogManager.INSTANCE     // Catch:{ Exception -> 0x00ed }
            java.lang.String r0 = r0.getNetWorkType()     // Catch:{ Exception -> 0x00ed }
            if (r0 == 0) goto L_0x00e5
            java.lang.String r0 = r0.toUpperCase()     // Catch:{ Exception -> 0x00ed }
            java.lang.String r1 = "(this as java.lang.String).toUpperCase()"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r1)     // Catch:{ Exception -> 0x00ed }
            r3.put(r4, r0)     // Catch:{ Exception -> 0x00ed }
            org.json.JSONObject r3 = r2.f17456a     // Catch:{ Exception -> 0x00ed }
            java.lang.String r4 = "pub_launch_type"
            com.didi.dimina.container.DMMina r0 = r2.f17458c     // Catch:{ Exception -> 0x00ed }
            int r0 = com.didi.dimina.container.mina.DMMinaHelper.getLaunchType(r0)     // Catch:{ Exception -> 0x00ed }
            r3.put(r4, r0)     // Catch:{ Exception -> 0x00ed }
            com.didi.unifylogin.api.ILoginStoreApi r3 = com.didi.unifylogin.api.OneLoginFacade.getStore()     // Catch:{ Exception -> 0x00ed }
            java.lang.String r4 = ""
            if (r3 == 0) goto L_0x00bb
            java.lang.String r3 = r3.getUid()     // Catch:{ Exception -> 0x00ed }
            java.lang.String r0 = "it.uid"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r3, r0)     // Catch:{ Exception -> 0x00ed }
            java.lang.String r0 = "-1"
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r0)     // Catch:{ Exception -> 0x00ed }
            if (r0 == 0) goto L_0x00ba
            goto L_0x00bb
        L_0x00ba:
            r4 = r3
        L_0x00bb:
            org.json.JSONObject r3 = r2.f17456a     // Catch:{ Exception -> 0x00ed }
            java.lang.String r0 = "pub_uid"
            r3.put(r0, r4)     // Catch:{ Exception -> 0x00ed }
            org.json.JSONObject r3 = r2.f17456a     // Catch:{ Exception -> 0x00ed }
            java.lang.String r4 = "ts"
            long r0 = r2.f17457b     // Catch:{ Exception -> 0x00ed }
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch:{ Exception -> 0x00ed }
            r3.put(r4, r0)     // Catch:{ Exception -> 0x00ed }
            org.json.JSONObject r3 = r2.f17456a     // Catch:{ Exception -> 0x00ed }
            java.lang.String r4 = "tech_saga_track_type"
            java.lang.String r0 = r2.f17459d     // Catch:{ Exception -> 0x00ed }
            r3.put(r4, r0)     // Catch:{ Exception -> 0x00ed }
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ Exception -> 0x00ed }
            r3.<init>()     // Catch:{ Exception -> 0x00ed }
            org.json.JSONObject r4 = r2.f17456a     // Catch:{ Exception -> 0x00ed }
            java.lang.String r0 = "tech_saga_track_data"
            r4.put(r0, r3)     // Catch:{ Exception -> 0x00ed }
            goto L_0x00f1
        L_0x00e5:
            kotlin.TypeCastException r3 = new kotlin.TypeCastException     // Catch:{ Exception -> 0x00ed }
            java.lang.String r4 = "null cannot be cast to non-null type java.lang.String"
            r3.<init>(r4)     // Catch:{ Exception -> 0x00ed }
            throw r3     // Catch:{ Exception -> 0x00ed }
        L_0x00ed:
            r3 = move-exception
            r3.printStackTrace()
        L_0x00f1:
            return
        L_0x00f2:
            java.lang.IllegalArgumentException r3 = new java.lang.IllegalArgumentException
            java.lang.String r4 = "EventId is null!"
            r3.<init>(r4)
            java.lang.Throwable r3 = (java.lang.Throwable) r3
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.dimina.container.secondparty.trace.inner.LogBase.<init>(com.didi.dimina.container.DMMina, java.lang.String):void");
    }

    public final String getEventId() {
        return this.f17459d;
    }

    public final DMMina getMina() {
        return this.f17458c;
    }

    public final void setEventId(String str) {
        this.f17459d = str;
    }

    public final void setMina(DMMina dMMina) {
        this.f17458c = dMMina;
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, mo175978d2 = {"Lcom/didi/dimina/container/secondparty/trace/inner/LogBase$Companion;", "", "()V", "KEY_DATA", "", "KEY_EVENT_ID", "KEY_UID", "KEY_UNION_ID", "2party-impl_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
    /* compiled from: LogBase.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final String getSeq() {
        return String.valueOf(this.f17457b);
    }

    public final String toJsonStr() {
        String jSONObject = this.f17456a.toString();
        Intrinsics.checkExpressionValueIsNotNull(jSONObject, "eventmap.toString()");
        return jSONObject;
    }

    public final LogBase append(String str, Object obj) {
        Intrinsics.checkParameterIsNotNull(str, "key");
        m12977a().put(str, obj);
        return this;
    }

    public final LogBase append(Map<String, ? extends Object> map) {
        Intrinsics.checkParameterIsNotNull(map, "hashMap");
        JSONObject a = m12977a();
        for (Map.Entry next : map.entrySet()) {
            a.put((String) next.getKey(), next.getValue());
        }
        return this;
    }

    /* renamed from: a */
    private final JSONObject m12977a() {
        Object obj = this.f17456a.get(KEY_DATA);
        if (!(obj instanceof JSONObject)) {
            obj = null;
        }
        JSONObject jSONObject = (JSONObject) obj;
        if (jSONObject != null) {
            return jSONObject;
        }
        JSONObject jSONObject2 = new JSONObject();
        this.f17456a.put(KEY_DATA, jSONObject2);
        return jSONObject2;
    }

    public String toString() {
        String jSONObject = this.f17456a.toString();
        Intrinsics.checkExpressionValueIsNotNull(jSONObject, "eventmap.toString()");
        return jSONObject;
    }
}
