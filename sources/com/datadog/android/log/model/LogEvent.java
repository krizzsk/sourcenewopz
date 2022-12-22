package com.datadog.android.log.model;

import com.datadog.android.core.internal.utils.MiscUtilsKt;
import com.datadog.android.log.LogAttributes;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;
import p242io.opentracing.tag.Tags;

@Metadata(mo175977d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b#\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\b\u0018\u0000 >2\u00020\u0001:\b=>?@ABCDBq\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0005\u0012\u0016\b\u0002\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0012¢\u0006\u0002\u0010\u0013J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\u0017\u0010+\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0012HÆ\u0003J\t\u0010,\u001a\u00020\u0005HÆ\u0003J\t\u0010-\u001a\u00020\u0005HÆ\u0003J\t\u0010.\u001a\u00020\u0005HÆ\u0003J\t\u0010/\u001a\u00020\tHÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\rHÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\t\u00103\u001a\u00020\u0005HÆ\u0003J\u0001\u00104\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00052\u0016\b\u0002\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0012HÆ\u0001J\u0013\u00105\u001a\u0002062\b\u00107\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00108\u001a\u000209HÖ\u0001J\u0006\u0010:\u001a\u00020;J\t\u0010<\u001a\u00020\u0005HÖ\u0001R\u001f\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0010\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0017\"\u0004\b\u0019\u0010\u001aR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u001a\u0010\u0006\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0017\"\u0004\b \u0010\u001aR\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0017R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)¨\u0006E"}, mo175978d2 = {"Lcom/datadog/android/log/model/LogEvent;", "", "status", "Lcom/datadog/android/log/model/LogEvent$Status;", "service", "", "message", "date", "logger", "Lcom/datadog/android/log/model/LogEvent$Logger;", "usr", "Lcom/datadog/android/log/model/LogEvent$Usr;", "network", "Lcom/datadog/android/log/model/LogEvent$Network;", "error", "Lcom/datadog/android/log/model/LogEvent$Error;", "ddtags", "additionalProperties", "", "(Lcom/datadog/android/log/model/LogEvent$Status;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/datadog/android/log/model/LogEvent$Logger;Lcom/datadog/android/log/model/LogEvent$Usr;Lcom/datadog/android/log/model/LogEvent$Network;Lcom/datadog/android/log/model/LogEvent$Error;Ljava/lang/String;Ljava/util/Map;)V", "getAdditionalProperties", "()Ljava/util/Map;", "getDate", "()Ljava/lang/String;", "getDdtags", "setDdtags", "(Ljava/lang/String;)V", "getError", "()Lcom/datadog/android/log/model/LogEvent$Error;", "getLogger", "()Lcom/datadog/android/log/model/LogEvent$Logger;", "getMessage", "setMessage", "getNetwork", "()Lcom/datadog/android/log/model/LogEvent$Network;", "getService", "getStatus", "()Lcom/datadog/android/log/model/LogEvent$Status;", "setStatus", "(Lcom/datadog/android/log/model/LogEvent$Status;)V", "getUsr", "()Lcom/datadog/android/log/model/LogEvent$Usr;", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "", "toJson", "Lcom/google/gson/JsonElement;", "toString", "Client", "Companion", "Error", "Logger", "Network", "SimCarrier", "Status", "Usr", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: LogEvent.kt */
public final class LogEvent {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */

    /* renamed from: k */
    public static final String[] f3641k = {"status", "service", "message", LogAttributes.DATE, "logger", "usr", "network", "error", "ddtags"};

    /* renamed from: a */
    private Status f3642a;

    /* renamed from: b */
    private final String f3643b;

    /* renamed from: c */
    private String f3644c;

    /* renamed from: d */
    private final String f3645d;

    /* renamed from: e */
    private final Logger f3646e;

    /* renamed from: f */
    private final Usr f3647f;

    /* renamed from: g */
    private final Network f3648g;

    /* renamed from: h */
    private final Error f3649h;

    /* renamed from: i */
    private String f3650i;

    /* renamed from: j */
    private final Map<String, Object> f3651j;

    public static /* synthetic */ LogEvent copy$default(LogEvent logEvent, Status status, String str, String str2, String str3, Logger logger, Usr usr, Network network, Error error, String str4, Map map, int i, Object obj) {
        LogEvent logEvent2 = logEvent;
        int i2 = i;
        return logEvent.copy((i2 & 1) != 0 ? logEvent2.f3642a : status, (i2 & 2) != 0 ? logEvent2.f3643b : str, (i2 & 4) != 0 ? logEvent2.f3644c : str2, (i2 & 8) != 0 ? logEvent2.f3645d : str3, (i2 & 16) != 0 ? logEvent2.f3646e : logger, (i2 & 32) != 0 ? logEvent2.f3647f : usr, (i2 & 64) != 0 ? logEvent2.f3648g : network, (i2 & 128) != 0 ? logEvent2.f3649h : error, (i2 & 256) != 0 ? logEvent2.f3650i : str4, (i2 & 512) != 0 ? logEvent2.f3651j : map);
    }

    @JvmStatic
    public static final LogEvent fromJson(String str) throws JsonParseException {
        return Companion.fromJson(str);
    }

    public final Status component1() {
        return this.f3642a;
    }

    public final Map<String, Object> component10() {
        return this.f3651j;
    }

    public final String component2() {
        return this.f3643b;
    }

    public final String component3() {
        return this.f3644c;
    }

    public final String component4() {
        return this.f3645d;
    }

    public final Logger component5() {
        return this.f3646e;
    }

    public final Usr component6() {
        return this.f3647f;
    }

    public final Network component7() {
        return this.f3648g;
    }

    public final Error component8() {
        return this.f3649h;
    }

    public final String component9() {
        return this.f3650i;
    }

    public final LogEvent copy(Status status, String str, String str2, String str3, Logger logger, Usr usr, Network network, Error error, String str4, Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(str, "service");
        Intrinsics.checkNotNullParameter(str2, "message");
        String str5 = str3;
        Intrinsics.checkNotNullParameter(str5, LogAttributes.DATE);
        Logger logger2 = logger;
        Intrinsics.checkNotNullParameter(logger2, "logger");
        String str6 = str4;
        Intrinsics.checkNotNullParameter(str6, "ddtags");
        Map<String, ? extends Object> map2 = map;
        Intrinsics.checkNotNullParameter(map2, "additionalProperties");
        return new LogEvent(status, str, str2, str5, logger2, usr, network, error, str6, map2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LogEvent)) {
            return false;
        }
        LogEvent logEvent = (LogEvent) obj;
        return this.f3642a == logEvent.f3642a && Intrinsics.areEqual((Object) this.f3643b, (Object) logEvent.f3643b) && Intrinsics.areEqual((Object) this.f3644c, (Object) logEvent.f3644c) && Intrinsics.areEqual((Object) this.f3645d, (Object) logEvent.f3645d) && Intrinsics.areEqual((Object) this.f3646e, (Object) logEvent.f3646e) && Intrinsics.areEqual((Object) this.f3647f, (Object) logEvent.f3647f) && Intrinsics.areEqual((Object) this.f3648g, (Object) logEvent.f3648g) && Intrinsics.areEqual((Object) this.f3649h, (Object) logEvent.f3649h) && Intrinsics.areEqual((Object) this.f3650i, (Object) logEvent.f3650i) && Intrinsics.areEqual((Object) this.f3651j, (Object) logEvent.f3651j);
    }

    public int hashCode() {
        int hashCode = ((((((((this.f3642a.hashCode() * 31) + this.f3643b.hashCode()) * 31) + this.f3644c.hashCode()) * 31) + this.f3645d.hashCode()) * 31) + this.f3646e.hashCode()) * 31;
        Usr usr = this.f3647f;
        int i = 0;
        int hashCode2 = (hashCode + (usr == null ? 0 : usr.hashCode())) * 31;
        Network network = this.f3648g;
        int hashCode3 = (hashCode2 + (network == null ? 0 : network.hashCode())) * 31;
        Error error = this.f3649h;
        if (error != null) {
            i = error.hashCode();
        }
        return ((((hashCode3 + i) * 31) + this.f3650i.hashCode()) * 31) + this.f3651j.hashCode();
    }

    public String toString() {
        return "LogEvent(status=" + this.f3642a + ", service=" + this.f3643b + ", message=" + this.f3644c + ", date=" + this.f3645d + ", logger=" + this.f3646e + ", usr=" + this.f3647f + ", network=" + this.f3648g + ", error=" + this.f3649h + ", ddtags=" + this.f3650i + ", additionalProperties=" + this.f3651j + VersionRange.RIGHT_OPEN;
    }

    public LogEvent(Status status, String str, String str2, String str3, Logger logger, Usr usr, Network network, Error error, String str4, Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(str, "service");
        Intrinsics.checkNotNullParameter(str2, "message");
        Intrinsics.checkNotNullParameter(str3, LogAttributes.DATE);
        Intrinsics.checkNotNullParameter(logger, "logger");
        Intrinsics.checkNotNullParameter(str4, "ddtags");
        Intrinsics.checkNotNullParameter(map, "additionalProperties");
        this.f3642a = status;
        this.f3643b = str;
        this.f3644c = str2;
        this.f3645d = str3;
        this.f3646e = logger;
        this.f3647f = usr;
        this.f3648g = network;
        this.f3649h = error;
        this.f3650i = str4;
        this.f3651j = map;
    }

    public final Status getStatus() {
        return this.f3642a;
    }

    public final void setStatus(Status status) {
        Intrinsics.checkNotNullParameter(status, "<set-?>");
        this.f3642a = status;
    }

    public final String getService() {
        return this.f3643b;
    }

    public final String getMessage() {
        return this.f3644c;
    }

    public final void setMessage(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.f3644c = str;
    }

    public final String getDate() {
        return this.f3645d;
    }

    public final Logger getLogger() {
        return this.f3646e;
    }

    public final Usr getUsr() {
        return this.f3647f;
    }

    public final Network getNetwork() {
        return this.f3648g;
    }

    public final Error getError() {
        return this.f3649h;
    }

    public final String getDdtags() {
        return this.f3650i;
    }

    public final void setDdtags(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.f3650i = str;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ LogEvent(com.datadog.android.log.model.LogEvent.Status r15, java.lang.String r16, java.lang.String r17, java.lang.String r18, com.datadog.android.log.model.LogEvent.Logger r19, com.datadog.android.log.model.LogEvent.Usr r20, com.datadog.android.log.model.LogEvent.Network r21, com.datadog.android.log.model.LogEvent.Error r22, java.lang.String r23, java.util.Map r24, int r25, kotlin.jvm.internal.DefaultConstructorMarker r26) {
        /*
            r14 = this;
            r0 = r25
            r1 = r0 & 32
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r9 = r2
            goto L_0x000b
        L_0x0009:
            r9 = r20
        L_0x000b:
            r1 = r0 & 64
            if (r1 == 0) goto L_0x0011
            r10 = r2
            goto L_0x0013
        L_0x0011:
            r10 = r21
        L_0x0013:
            r1 = r0 & 128(0x80, float:1.794E-43)
            if (r1 == 0) goto L_0x0019
            r11 = r2
            goto L_0x001b
        L_0x0019:
            r11 = r22
        L_0x001b:
            r0 = r0 & 512(0x200, float:7.175E-43)
            if (r0 == 0) goto L_0x0025
            java.util.Map r0 = kotlin.collections.MapsKt.emptyMap()
            r13 = r0
            goto L_0x0027
        L_0x0025:
            r13 = r24
        L_0x0027:
            r3 = r14
            r4 = r15
            r5 = r16
            r6 = r17
            r7 = r18
            r8 = r19
            r12 = r23
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.datadog.android.log.model.LogEvent.<init>(com.datadog.android.log.model.LogEvent$Status, java.lang.String, java.lang.String, java.lang.String, com.datadog.android.log.model.LogEvent$Logger, com.datadog.android.log.model.LogEvent$Usr, com.datadog.android.log.model.LogEvent$Network, com.datadog.android.log.model.LogEvent$Error, java.lang.String, java.util.Map, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final Map<String, Object> getAdditionalProperties() {
        return this.f3651j;
    }

    public final JsonElement toJson() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.add("status", this.f3642a.toJson());
        jsonObject.addProperty("service", this.f3643b);
        jsonObject.addProperty("message", this.f3644c);
        jsonObject.addProperty(LogAttributes.DATE, this.f3645d);
        jsonObject.add("logger", this.f3646e.toJson());
        Usr usr = this.f3647f;
        if (usr != null) {
            jsonObject.add("usr", usr.toJson());
        }
        Network network = this.f3648g;
        if (network != null) {
            jsonObject.add("network", network.toJson());
        }
        Error error = this.f3649h;
        if (error != null) {
            jsonObject.add("error", error.toJson());
        }
        jsonObject.addProperty("ddtags", this.f3650i);
        for (Map.Entry next : this.f3651j.entrySet()) {
            String str = (String) next.getKey();
            Object value = next.getValue();
            if (!ArraysKt.contains((T[]) f3641k, str)) {
                jsonObject.add(str, MiscUtilsKt.toJsonElement(value));
            }
        }
        return jsonObject;
    }

    @Metadata(mo175977d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0005H\u0007R\u001c\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007¨\u0006\f"}, mo175978d2 = {"Lcom/datadog/android/log/model/LogEvent$Companion;", "", "()V", "RESERVED_PROPERTIES", "", "", "getRESERVED_PROPERTIES$dd_sdk_android_release", "()[Ljava/lang/String;", "[Ljava/lang/String;", "fromJson", "Lcom/datadog/android/log/model/LogEvent;", "serializedObject", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: LogEvent.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String[] getRESERVED_PROPERTIES$dd_sdk_android_release() {
            return LogEvent.f3641k;
        }

        /* JADX WARNING: Removed duplicated region for block: B:12:0x007a A[Catch:{ IllegalStateException -> 0x010a, NumberFormatException -> 0x00ff }] */
        /* JADX WARNING: Removed duplicated region for block: B:19:0x0093 A[Catch:{ IllegalStateException -> 0x010a, NumberFormatException -> 0x00ff }] */
        /* JADX WARNING: Removed duplicated region for block: B:26:0x00bf A[Catch:{ IllegalStateException -> 0x010a, NumberFormatException -> 0x00ff }] */
        @kotlin.jvm.JvmStatic
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final com.datadog.android.log.model.LogEvent fromJson(java.lang.String r20) throws com.google.gson.JsonParseException {
            /*
                r19 = this;
                java.lang.String r0 = "ddtags"
                java.lang.String r1 = "date"
                java.lang.String r2 = "message"
                java.lang.String r3 = "service"
                java.lang.String r4 = "it"
                java.lang.String r5 = "serializedObject"
                r6 = r20
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r5)
                com.google.gson.JsonElement r5 = com.google.gson.JsonParser.parseString(r20)     // Catch:{ IllegalStateException -> 0x010a, NumberFormatException -> 0x00ff }
                com.google.gson.JsonObject r5 = r5.getAsJsonObject()     // Catch:{ IllegalStateException -> 0x010a, NumberFormatException -> 0x00ff }
                java.lang.String r6 = "status"
                com.google.gson.JsonElement r6 = r5.get(r6)     // Catch:{ IllegalStateException -> 0x010a, NumberFormatException -> 0x00ff }
                java.lang.String r6 = r6.getAsString()     // Catch:{ IllegalStateException -> 0x010a, NumberFormatException -> 0x00ff }
                com.datadog.android.log.model.LogEvent$Status$Companion r7 = com.datadog.android.log.model.LogEvent.Status.Companion     // Catch:{ IllegalStateException -> 0x010a, NumberFormatException -> 0x00ff }
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r4)     // Catch:{ IllegalStateException -> 0x010a, NumberFormatException -> 0x00ff }
                com.datadog.android.log.model.LogEvent$Status r9 = r7.fromJson(r6)     // Catch:{ IllegalStateException -> 0x010a, NumberFormatException -> 0x00ff }
                com.google.gson.JsonElement r6 = r5.get(r3)     // Catch:{ IllegalStateException -> 0x010a, NumberFormatException -> 0x00ff }
                java.lang.String r10 = r6.getAsString()     // Catch:{ IllegalStateException -> 0x010a, NumberFormatException -> 0x00ff }
                com.google.gson.JsonElement r6 = r5.get(r2)     // Catch:{ IllegalStateException -> 0x010a, NumberFormatException -> 0x00ff }
                java.lang.String r11 = r6.getAsString()     // Catch:{ IllegalStateException -> 0x010a, NumberFormatException -> 0x00ff }
                com.google.gson.JsonElement r6 = r5.get(r1)     // Catch:{ IllegalStateException -> 0x010a, NumberFormatException -> 0x00ff }
                java.lang.String r12 = r6.getAsString()     // Catch:{ IllegalStateException -> 0x010a, NumberFormatException -> 0x00ff }
                java.lang.String r6 = "logger"
                com.google.gson.JsonElement r6 = r5.get(r6)     // Catch:{ IllegalStateException -> 0x010a, NumberFormatException -> 0x00ff }
                java.lang.String r6 = r6.toString()     // Catch:{ IllegalStateException -> 0x010a, NumberFormatException -> 0x00ff }
                com.datadog.android.log.model.LogEvent$Logger$Companion r7 = com.datadog.android.log.model.LogEvent.Logger.Companion     // Catch:{ IllegalStateException -> 0x010a, NumberFormatException -> 0x00ff }
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r4)     // Catch:{ IllegalStateException -> 0x010a, NumberFormatException -> 0x00ff }
                com.datadog.android.log.model.LogEvent$Logger r13 = r7.fromJson(r6)     // Catch:{ IllegalStateException -> 0x010a, NumberFormatException -> 0x00ff }
                java.lang.String r4 = "usr"
                com.google.gson.JsonElement r4 = r5.get(r4)     // Catch:{ IllegalStateException -> 0x010a, NumberFormatException -> 0x00ff }
                r6 = 0
                if (r4 != 0) goto L_0x0062
            L_0x0060:
                r14 = r6
                goto L_0x0070
            L_0x0062:
                java.lang.String r4 = r4.toString()     // Catch:{ IllegalStateException -> 0x010a, NumberFormatException -> 0x00ff }
                if (r4 != 0) goto L_0x0069
                goto L_0x0060
            L_0x0069:
                com.datadog.android.log.model.LogEvent$Usr$Companion r7 = com.datadog.android.log.model.LogEvent.Usr.Companion     // Catch:{ IllegalStateException -> 0x010a, NumberFormatException -> 0x00ff }
                com.datadog.android.log.model.LogEvent$Usr r4 = r7.fromJson(r4)     // Catch:{ IllegalStateException -> 0x010a, NumberFormatException -> 0x00ff }
                r14 = r4
            L_0x0070:
                java.lang.String r4 = "network"
                com.google.gson.JsonElement r4 = r5.get(r4)     // Catch:{ IllegalStateException -> 0x010a, NumberFormatException -> 0x00ff }
                if (r4 != 0) goto L_0x007a
            L_0x0078:
                r15 = r6
                goto L_0x0088
            L_0x007a:
                java.lang.String r4 = r4.toString()     // Catch:{ IllegalStateException -> 0x010a, NumberFormatException -> 0x00ff }
                if (r4 != 0) goto L_0x0081
                goto L_0x0078
            L_0x0081:
                com.datadog.android.log.model.LogEvent$Network$Companion r7 = com.datadog.android.log.model.LogEvent.Network.Companion     // Catch:{ IllegalStateException -> 0x010a, NumberFormatException -> 0x00ff }
                com.datadog.android.log.model.LogEvent$Network r4 = r7.fromJson(r4)     // Catch:{ IllegalStateException -> 0x010a, NumberFormatException -> 0x00ff }
                r15 = r4
            L_0x0088:
                java.lang.String r4 = "error"
                com.google.gson.JsonElement r4 = r5.get(r4)     // Catch:{ IllegalStateException -> 0x010a, NumberFormatException -> 0x00ff }
                if (r4 != 0) goto L_0x0093
            L_0x0090:
                r16 = r6
                goto L_0x00a2
            L_0x0093:
                java.lang.String r4 = r4.toString()     // Catch:{ IllegalStateException -> 0x010a, NumberFormatException -> 0x00ff }
                if (r4 != 0) goto L_0x009a
                goto L_0x0090
            L_0x009a:
                com.datadog.android.log.model.LogEvent$Error$Companion r6 = com.datadog.android.log.model.LogEvent.Error.Companion     // Catch:{ IllegalStateException -> 0x010a, NumberFormatException -> 0x00ff }
                com.datadog.android.log.model.LogEvent$Error r4 = r6.fromJson(r4)     // Catch:{ IllegalStateException -> 0x010a, NumberFormatException -> 0x00ff }
                r16 = r4
            L_0x00a2:
                com.google.gson.JsonElement r4 = r5.get(r0)     // Catch:{ IllegalStateException -> 0x010a, NumberFormatException -> 0x00ff }
                java.lang.String r4 = r4.getAsString()     // Catch:{ IllegalStateException -> 0x010a, NumberFormatException -> 0x00ff }
                java.util.LinkedHashMap r6 = new java.util.LinkedHashMap     // Catch:{ IllegalStateException -> 0x010a, NumberFormatException -> 0x00ff }
                r6.<init>()     // Catch:{ IllegalStateException -> 0x010a, NumberFormatException -> 0x00ff }
                java.util.Map r6 = (java.util.Map) r6     // Catch:{ IllegalStateException -> 0x010a, NumberFormatException -> 0x00ff }
                java.util.Set r5 = r5.entrySet()     // Catch:{ IllegalStateException -> 0x010a, NumberFormatException -> 0x00ff }
                java.util.Iterator r5 = r5.iterator()     // Catch:{ IllegalStateException -> 0x010a, NumberFormatException -> 0x00ff }
            L_0x00b9:
                boolean r7 = r5.hasNext()     // Catch:{ IllegalStateException -> 0x010a, NumberFormatException -> 0x00ff }
                if (r7 == 0) goto L_0x00e8
                java.lang.Object r7 = r5.next()     // Catch:{ IllegalStateException -> 0x010a, NumberFormatException -> 0x00ff }
                java.util.Map$Entry r7 = (java.util.Map.Entry) r7     // Catch:{ IllegalStateException -> 0x010a, NumberFormatException -> 0x00ff }
                java.lang.String[] r8 = r19.getRESERVED_PROPERTIES$dd_sdk_android_release()     // Catch:{ IllegalStateException -> 0x010a, NumberFormatException -> 0x00ff }
                r20 = r5
                java.lang.Object r5 = r7.getKey()     // Catch:{ IllegalStateException -> 0x010a, NumberFormatException -> 0x00ff }
                boolean r5 = kotlin.collections.ArraysKt.contains((T[]) r8, r5)     // Catch:{ IllegalStateException -> 0x010a, NumberFormatException -> 0x00ff }
                if (r5 != 0) goto L_0x00e5
                java.lang.Object r5 = r7.getKey()     // Catch:{ IllegalStateException -> 0x010a, NumberFormatException -> 0x00ff }
                java.lang.String r8 = "entry.key"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r8)     // Catch:{ IllegalStateException -> 0x010a, NumberFormatException -> 0x00ff }
                java.lang.Object r7 = r7.getValue()     // Catch:{ IllegalStateException -> 0x010a, NumberFormatException -> 0x00ff }
                r6.put(r5, r7)     // Catch:{ IllegalStateException -> 0x010a, NumberFormatException -> 0x00ff }
            L_0x00e5:
                r5 = r20
                goto L_0x00b9
            L_0x00e8:
                com.datadog.android.log.model.LogEvent r5 = new com.datadog.android.log.model.LogEvent     // Catch:{ IllegalStateException -> 0x010a, NumberFormatException -> 0x00ff }
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r10, r3)     // Catch:{ IllegalStateException -> 0x010a, NumberFormatException -> 0x00ff }
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r11, r2)     // Catch:{ IllegalStateException -> 0x010a, NumberFormatException -> 0x00ff }
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r12, r1)     // Catch:{ IllegalStateException -> 0x010a, NumberFormatException -> 0x00ff }
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r0)     // Catch:{ IllegalStateException -> 0x010a, NumberFormatException -> 0x00ff }
                r8 = r5
                r17 = r4
                r18 = r6
                r8.<init>(r9, r10, r11, r12, r13, r14, r15, r16, r17, r18)     // Catch:{ IllegalStateException -> 0x010a, NumberFormatException -> 0x00ff }
                return r5
            L_0x00ff:
                r0 = move-exception
                com.google.gson.JsonParseException r1 = new com.google.gson.JsonParseException
                java.lang.String r0 = r0.getMessage()
                r1.<init>((java.lang.String) r0)
                throw r1
            L_0x010a:
                r0 = move-exception
                com.google.gson.JsonParseException r1 = new com.google.gson.JsonParseException
                java.lang.String r0 = r0.getMessage()
                r1.<init>((java.lang.String) r0)
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.datadog.android.log.model.LogEvent.Companion.fromJson(java.lang.String):com.datadog.android.log.model.LogEvent");
        }
    }

    @Metadata(mo175977d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J)\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\u0006\u0010\u0016\u001a\u00020\u0017J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\b¨\u0006\u001a"}, mo175978d2 = {"Lcom/datadog/android/log/model/LogEvent$Logger;", "", "name", "", "threadName", "version", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "getThreadName", "getVersion", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toJson", "Lcom/google/gson/JsonElement;", "toString", "Companion", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: LogEvent.kt */
    public static final class Logger {
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        private String name;
        private final String threadName;
        private final String version;

        public static /* synthetic */ Logger copy$default(Logger logger, String str, String str2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = logger.name;
            }
            if ((i & 2) != 0) {
                str2 = logger.threadName;
            }
            if ((i & 4) != 0) {
                str3 = logger.version;
            }
            return logger.copy(str, str2, str3);
        }

        @JvmStatic
        public static final Logger fromJson(String str) throws JsonParseException {
            return Companion.fromJson(str);
        }

        public final String component1() {
            return this.name;
        }

        public final String component2() {
            return this.threadName;
        }

        public final String component3() {
            return this.version;
        }

        public final Logger copy(String str, String str2, String str3) {
            Intrinsics.checkNotNullParameter(str, "name");
            Intrinsics.checkNotNullParameter(str3, "version");
            return new Logger(str, str2, str3);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Logger)) {
                return false;
            }
            Logger logger = (Logger) obj;
            return Intrinsics.areEqual((Object) this.name, (Object) logger.name) && Intrinsics.areEqual((Object) this.threadName, (Object) logger.threadName) && Intrinsics.areEqual((Object) this.version, (Object) logger.version);
        }

        public int hashCode() {
            int hashCode = this.name.hashCode() * 31;
            String str = this.threadName;
            return ((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.version.hashCode();
        }

        public String toString() {
            return "Logger(name=" + this.name + ", threadName=" + this.threadName + ", version=" + this.version + VersionRange.RIGHT_OPEN;
        }

        public Logger(String str, String str2, String str3) {
            Intrinsics.checkNotNullParameter(str, "name");
            Intrinsics.checkNotNullParameter(str3, "version");
            this.name = str;
            this.threadName = str2;
            this.version = str3;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Logger(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i & 2) != 0 ? null : str2, str3);
        }

        public final String getName() {
            return this.name;
        }

        public final void setName(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.name = str;
        }

        public final String getThreadName() {
            return this.threadName;
        }

        public final String getVersion() {
            return this.version;
        }

        public final JsonElement toJson() {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("name", this.name);
            String str = this.threadName;
            if (str != null) {
                jsonObject.addProperty("thread_name", str);
            }
            jsonObject.addProperty("version", this.version);
            return jsonObject;
        }

        @Metadata(mo175977d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, mo175978d2 = {"Lcom/datadog/android/log/model/LogEvent$Logger$Companion;", "", "()V", "fromJson", "Lcom/datadog/android/log/model/LogEvent$Logger;", "serializedObject", "", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
        /* compiled from: LogEvent.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public final Logger fromJson(String str) throws JsonParseException {
                Intrinsics.checkNotNullParameter(str, "serializedObject");
                try {
                    JsonObject asJsonObject = JsonParser.parseString(str).getAsJsonObject();
                    String asString = asJsonObject.get("name").getAsString();
                    JsonElement jsonElement = asJsonObject.get("thread_name");
                    String asString2 = jsonElement == null ? null : jsonElement.getAsString();
                    String asString3 = asJsonObject.get("version").getAsString();
                    Intrinsics.checkNotNullExpressionValue(asString, "name");
                    Intrinsics.checkNotNullExpressionValue(asString3, "version");
                    return new Logger(asString, asString2, asString3);
                } catch (IllegalStateException e) {
                    throw new JsonParseException(e.getMessage());
                } catch (NumberFormatException e2) {
                    throw new JsonParseException(e2.getMessage());
                }
            }
        }
    }

    @Metadata(mo175977d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cBA\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0007¢\u0006\u0002\u0010\bJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0017\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0007HÆ\u0003JE\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\u0006\u0010\u0019\u001a\u00020\u001aJ\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u001f\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\f¨\u0006\u001d"}, mo175978d2 = {"Lcom/datadog/android/log/model/LogEvent$Usr;", "", "id", "", "name", "email", "additionalProperties", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V", "getAdditionalProperties", "()Ljava/util/Map;", "getEmail", "()Ljava/lang/String;", "getId", "getName", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toJson", "Lcom/google/gson/JsonElement;", "toString", "Companion", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: LogEvent.kt */
    public static final class Usr {
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        /* access modifiers changed from: private */
        public static final String[] RESERVED_PROPERTIES = {"id", "name", "email"};
        private final Map<String, Object> additionalProperties;
        private final String email;

        /* renamed from: id */
        private final String f3653id;
        private final String name;

        public Usr() {
            this((String) null, (String) null, (String) null, (Map) null, 15, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ Usr copy$default(Usr usr, String str, String str2, String str3, Map<String, Object> map, int i, Object obj) {
            if ((i & 1) != 0) {
                str = usr.f3653id;
            }
            if ((i & 2) != 0) {
                str2 = usr.name;
            }
            if ((i & 4) != 0) {
                str3 = usr.email;
            }
            if ((i & 8) != 0) {
                map = usr.additionalProperties;
            }
            return usr.copy(str, str2, str3, map);
        }

        @JvmStatic
        public static final Usr fromJson(String str) throws JsonParseException {
            return Companion.fromJson(str);
        }

        public final String component1() {
            return this.f3653id;
        }

        public final String component2() {
            return this.name;
        }

        public final String component3() {
            return this.email;
        }

        public final Map<String, Object> component4() {
            return this.additionalProperties;
        }

        public final Usr copy(String str, String str2, String str3, Map<String, ? extends Object> map) {
            Intrinsics.checkNotNullParameter(map, "additionalProperties");
            return new Usr(str, str2, str3, map);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Usr)) {
                return false;
            }
            Usr usr = (Usr) obj;
            return Intrinsics.areEqual((Object) this.f3653id, (Object) usr.f3653id) && Intrinsics.areEqual((Object) this.name, (Object) usr.name) && Intrinsics.areEqual((Object) this.email, (Object) usr.email) && Intrinsics.areEqual((Object) this.additionalProperties, (Object) usr.additionalProperties);
        }

        public int hashCode() {
            String str = this.f3653id;
            int i = 0;
            int hashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.name;
            int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.email;
            if (str3 != null) {
                i = str3.hashCode();
            }
            return ((hashCode2 + i) * 31) + this.additionalProperties.hashCode();
        }

        public String toString() {
            return "Usr(id=" + this.f3653id + ", name=" + this.name + ", email=" + this.email + ", additionalProperties=" + this.additionalProperties + VersionRange.RIGHT_OPEN;
        }

        public Usr(String str, String str2, String str3, Map<String, ? extends Object> map) {
            Intrinsics.checkNotNullParameter(map, "additionalProperties");
            this.f3653id = str;
            this.name = str2;
            this.email = str3;
            this.additionalProperties = map;
        }

        public final String getId() {
            return this.f3653id;
        }

        public final String getName() {
            return this.name;
        }

        public final String getEmail() {
            return this.email;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Usr(String str, String str2, String str3, Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? MapsKt.emptyMap() : map);
        }

        public final Map<String, Object> getAdditionalProperties() {
            return this.additionalProperties;
        }

        public final JsonElement toJson() {
            JsonObject jsonObject = new JsonObject();
            String str = this.f3653id;
            if (str != null) {
                jsonObject.addProperty("id", str);
            }
            String str2 = this.name;
            if (str2 != null) {
                jsonObject.addProperty("name", str2);
            }
            String str3 = this.email;
            if (str3 != null) {
                jsonObject.addProperty("email", str3);
            }
            for (Map.Entry next : this.additionalProperties.entrySet()) {
                String str4 = (String) next.getKey();
                Object value = next.getValue();
                if (!ArraysKt.contains((T[]) RESERVED_PROPERTIES, str4)) {
                    jsonObject.add(str4, MiscUtilsKt.toJsonElement(value));
                }
            }
            return jsonObject;
        }

        @Metadata(mo175977d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0005H\u0007R\u001c\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007¨\u0006\f"}, mo175978d2 = {"Lcom/datadog/android/log/model/LogEvent$Usr$Companion;", "", "()V", "RESERVED_PROPERTIES", "", "", "getRESERVED_PROPERTIES$dd_sdk_android_release", "()[Ljava/lang/String;", "[Ljava/lang/String;", "fromJson", "Lcom/datadog/android/log/model/LogEvent$Usr;", "serializedObject", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
        /* compiled from: LogEvent.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final String[] getRESERVED_PROPERTIES$dd_sdk_android_release() {
                return Usr.RESERVED_PROPERTIES;
            }

            @JvmStatic
            public final Usr fromJson(String str) throws JsonParseException {
                Intrinsics.checkNotNullParameter(str, "serializedObject");
                try {
                    JsonObject asJsonObject = JsonParser.parseString(str).getAsJsonObject();
                    JsonElement jsonElement = asJsonObject.get("id");
                    String str2 = null;
                    String asString = jsonElement == null ? null : jsonElement.getAsString();
                    JsonElement jsonElement2 = asJsonObject.get("name");
                    String asString2 = jsonElement2 == null ? null : jsonElement2.getAsString();
                    JsonElement jsonElement3 = asJsonObject.get("email");
                    if (jsonElement3 != null) {
                        str2 = jsonElement3.getAsString();
                    }
                    Map linkedHashMap = new LinkedHashMap();
                    for (Map.Entry next : asJsonObject.entrySet()) {
                        if (!ArraysKt.contains((T[]) getRESERVED_PROPERTIES$dd_sdk_android_release(), next.getKey())) {
                            Object key = next.getKey();
                            Intrinsics.checkNotNullExpressionValue(key, "entry.key");
                            linkedHashMap.put(key, next.getValue());
                        }
                    }
                    return new Usr(asString, asString2, str2, linkedHashMap);
                } catch (IllegalStateException e) {
                    throw new JsonParseException(e.getMessage());
                } catch (NumberFormatException e2) {
                    throw new JsonParseException(e2.getMessage());
                }
            }
        }
    }

    @Metadata(mo175977d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\b\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\u0006\u0010\u000e\u001a\u00020\u000fJ\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0013"}, mo175978d2 = {"Lcom/datadog/android/log/model/LogEvent$Network;", "", "client", "Lcom/datadog/android/log/model/LogEvent$Client;", "(Lcom/datadog/android/log/model/LogEvent$Client;)V", "getClient", "()Lcom/datadog/android/log/model/LogEvent$Client;", "component1", "copy", "equals", "", "other", "hashCode", "", "toJson", "Lcom/google/gson/JsonElement;", "toString", "", "Companion", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: LogEvent.kt */
    public static final class Network {
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        private final Client client;

        public static /* synthetic */ Network copy$default(Network network, Client client2, int i, Object obj) {
            if ((i & 1) != 0) {
                client2 = network.client;
            }
            return network.copy(client2);
        }

        @JvmStatic
        public static final Network fromJson(String str) throws JsonParseException {
            return Companion.fromJson(str);
        }

        public final Client component1() {
            return this.client;
        }

        public final Network copy(Client client2) {
            Intrinsics.checkNotNullParameter(client2, Tags.SPAN_KIND_CLIENT);
            return new Network(client2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Network) && Intrinsics.areEqual((Object) this.client, (Object) ((Network) obj).client);
        }

        public int hashCode() {
            return this.client.hashCode();
        }

        public String toString() {
            return "Network(client=" + this.client + VersionRange.RIGHT_OPEN;
        }

        public Network(Client client2) {
            Intrinsics.checkNotNullParameter(client2, Tags.SPAN_KIND_CLIENT);
            this.client = client2;
        }

        public final Client getClient() {
            return this.client;
        }

        public final JsonElement toJson() {
            JsonObject jsonObject = new JsonObject();
            jsonObject.add(Tags.SPAN_KIND_CLIENT, this.client.toJson());
            return jsonObject;
        }

        @Metadata(mo175977d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, mo175978d2 = {"Lcom/datadog/android/log/model/LogEvent$Network$Companion;", "", "()V", "fromJson", "Lcom/datadog/android/log/model/LogEvent$Network;", "serializedObject", "", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
        /* compiled from: LogEvent.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public final Network fromJson(String str) throws JsonParseException {
                Intrinsics.checkNotNullParameter(str, "serializedObject");
                try {
                    String jsonElement = JsonParser.parseString(str).getAsJsonObject().get(Tags.SPAN_KIND_CLIENT).toString();
                    Client.Companion companion = Client.Companion;
                    Intrinsics.checkNotNullExpressionValue(jsonElement, "it");
                    return new Network(companion.fromJson(jsonElement));
                } catch (IllegalStateException e) {
                    throw new JsonParseException(e.getMessage());
                } catch (NumberFormatException e2) {
                    throw new JsonParseException(e2.getMessage());
                }
            }
        }
    }

    @Metadata(mo175977d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\u0006\u0010\u0018\u001a\u00020\u0019J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\nR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\b\"\u0004\b\u000e\u0010\n¨\u0006\u001c"}, mo175978d2 = {"Lcom/datadog/android/log/model/LogEvent$Error;", "", "kind", "", "message", "stack", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getKind", "()Ljava/lang/String;", "setKind", "(Ljava/lang/String;)V", "getMessage", "setMessage", "getStack", "setStack", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toJson", "Lcom/google/gson/JsonElement;", "toString", "Companion", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: LogEvent.kt */
    public static final class Error {
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        private String kind;
        private String message;
        private String stack;

        public Error() {
            this((String) null, (String) null, (String) null, 7, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ Error copy$default(Error error, String str, String str2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = error.kind;
            }
            if ((i & 2) != 0) {
                str2 = error.message;
            }
            if ((i & 4) != 0) {
                str3 = error.stack;
            }
            return error.copy(str, str2, str3);
        }

        @JvmStatic
        public static final Error fromJson(String str) throws JsonParseException {
            return Companion.fromJson(str);
        }

        public final String component1() {
            return this.kind;
        }

        public final String component2() {
            return this.message;
        }

        public final String component3() {
            return this.stack;
        }

        public final Error copy(String str, String str2, String str3) {
            return new Error(str, str2, str3);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Error)) {
                return false;
            }
            Error error = (Error) obj;
            return Intrinsics.areEqual((Object) this.kind, (Object) error.kind) && Intrinsics.areEqual((Object) this.message, (Object) error.message) && Intrinsics.areEqual((Object) this.stack, (Object) error.stack);
        }

        public int hashCode() {
            String str = this.kind;
            int i = 0;
            int hashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.message;
            int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.stack;
            if (str3 != null) {
                i = str3.hashCode();
            }
            return hashCode2 + i;
        }

        public String toString() {
            return "Error(kind=" + this.kind + ", message=" + this.message + ", stack=" + this.stack + VersionRange.RIGHT_OPEN;
        }

        public Error(String str, String str2, String str3) {
            this.kind = str;
            this.message = str2;
            this.stack = str3;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Error(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3);
        }

        public final String getKind() {
            return this.kind;
        }

        public final void setKind(String str) {
            this.kind = str;
        }

        public final String getMessage() {
            return this.message;
        }

        public final void setMessage(String str) {
            this.message = str;
        }

        public final String getStack() {
            return this.stack;
        }

        public final void setStack(String str) {
            this.stack = str;
        }

        public final JsonElement toJson() {
            JsonObject jsonObject = new JsonObject();
            String str = this.kind;
            if (str != null) {
                jsonObject.addProperty("kind", str);
            }
            String str2 = this.message;
            if (str2 != null) {
                jsonObject.addProperty("message", str2);
            }
            String str3 = this.stack;
            if (str3 != null) {
                jsonObject.addProperty("stack", str3);
            }
            return jsonObject;
        }

        @Metadata(mo175977d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, mo175978d2 = {"Lcom/datadog/android/log/model/LogEvent$Error$Companion;", "", "()V", "fromJson", "Lcom/datadog/android/log/model/LogEvent$Error;", "serializedObject", "", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
        /* compiled from: LogEvent.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public final Error fromJson(String str) throws JsonParseException {
                Intrinsics.checkNotNullParameter(str, "serializedObject");
                try {
                    JsonObject asJsonObject = JsonParser.parseString(str).getAsJsonObject();
                    JsonElement jsonElement = asJsonObject.get("kind");
                    String str2 = null;
                    String asString = jsonElement == null ? null : jsonElement.getAsString();
                    JsonElement jsonElement2 = asJsonObject.get("message");
                    String asString2 = jsonElement2 == null ? null : jsonElement2.getAsString();
                    JsonElement jsonElement3 = asJsonObject.get("stack");
                    if (jsonElement3 != null) {
                        str2 = jsonElement3.getAsString();
                    }
                    return new Error(asString, asString2, str2);
                } catch (IllegalStateException e) {
                    throw new JsonParseException(e.getMessage());
                } catch (NumberFormatException e2) {
                    throw new JsonParseException(e2.getMessage());
                }
            }
        }
    }

    @Metadata(mo175977d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB=\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005¢\u0006\u0002\u0010\tJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003JC\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\b\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\u0006\u0010\u001c\u001a\u00020\u001dJ\t\u0010\u001e\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b¨\u0006 "}, mo175978d2 = {"Lcom/datadog/android/log/model/LogEvent$Client;", "", "simCarrier", "Lcom/datadog/android/log/model/LogEvent$SimCarrier;", "signalStrength", "", "downlinkKbps", "uplinkKbps", "connectivity", "(Lcom/datadog/android/log/model/LogEvent$SimCarrier;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getConnectivity", "()Ljava/lang/String;", "getDownlinkKbps", "getSignalStrength", "getSimCarrier", "()Lcom/datadog/android/log/model/LogEvent$SimCarrier;", "getUplinkKbps", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toJson", "Lcom/google/gson/JsonElement;", "toString", "Companion", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: LogEvent.kt */
    public static final class Client {
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        private final String connectivity;
        private final String downlinkKbps;
        private final String signalStrength;
        private final SimCarrier simCarrier;
        private final String uplinkKbps;

        public static /* synthetic */ Client copy$default(Client client, SimCarrier simCarrier2, String str, String str2, String str3, String str4, int i, Object obj) {
            if ((i & 1) != 0) {
                simCarrier2 = client.simCarrier;
            }
            if ((i & 2) != 0) {
                str = client.signalStrength;
            }
            String str5 = str;
            if ((i & 4) != 0) {
                str2 = client.downlinkKbps;
            }
            String str6 = str2;
            if ((i & 8) != 0) {
                str3 = client.uplinkKbps;
            }
            String str7 = str3;
            if ((i & 16) != 0) {
                str4 = client.connectivity;
            }
            return client.copy(simCarrier2, str5, str6, str7, str4);
        }

        @JvmStatic
        public static final Client fromJson(String str) throws JsonParseException {
            return Companion.fromJson(str);
        }

        public final SimCarrier component1() {
            return this.simCarrier;
        }

        public final String component2() {
            return this.signalStrength;
        }

        public final String component3() {
            return this.downlinkKbps;
        }

        public final String component4() {
            return this.uplinkKbps;
        }

        public final String component5() {
            return this.connectivity;
        }

        public final Client copy(SimCarrier simCarrier2, String str, String str2, String str3, String str4) {
            Intrinsics.checkNotNullParameter(str4, "connectivity");
            return new Client(simCarrier2, str, str2, str3, str4);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Client)) {
                return false;
            }
            Client client = (Client) obj;
            return Intrinsics.areEqual((Object) this.simCarrier, (Object) client.simCarrier) && Intrinsics.areEqual((Object) this.signalStrength, (Object) client.signalStrength) && Intrinsics.areEqual((Object) this.downlinkKbps, (Object) client.downlinkKbps) && Intrinsics.areEqual((Object) this.uplinkKbps, (Object) client.uplinkKbps) && Intrinsics.areEqual((Object) this.connectivity, (Object) client.connectivity);
        }

        public int hashCode() {
            SimCarrier simCarrier2 = this.simCarrier;
            int i = 0;
            int hashCode = (simCarrier2 == null ? 0 : simCarrier2.hashCode()) * 31;
            String str = this.signalStrength;
            int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.downlinkKbps;
            int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.uplinkKbps;
            if (str3 != null) {
                i = str3.hashCode();
            }
            return ((hashCode3 + i) * 31) + this.connectivity.hashCode();
        }

        public String toString() {
            return "Client(simCarrier=" + this.simCarrier + ", signalStrength=" + this.signalStrength + ", downlinkKbps=" + this.downlinkKbps + ", uplinkKbps=" + this.uplinkKbps + ", connectivity=" + this.connectivity + VersionRange.RIGHT_OPEN;
        }

        public Client(SimCarrier simCarrier2, String str, String str2, String str3, String str4) {
            Intrinsics.checkNotNullParameter(str4, "connectivity");
            this.simCarrier = simCarrier2;
            this.signalStrength = str;
            this.downlinkKbps = str2;
            this.uplinkKbps = str3;
            this.connectivity = str4;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Client(SimCarrier simCarrier2, String str, String str2, String str3, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : simCarrier2, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : str3, str4);
        }

        public final SimCarrier getSimCarrier() {
            return this.simCarrier;
        }

        public final String getSignalStrength() {
            return this.signalStrength;
        }

        public final String getDownlinkKbps() {
            return this.downlinkKbps;
        }

        public final String getUplinkKbps() {
            return this.uplinkKbps;
        }

        public final String getConnectivity() {
            return this.connectivity;
        }

        public final JsonElement toJson() {
            JsonObject jsonObject = new JsonObject();
            SimCarrier simCarrier2 = this.simCarrier;
            if (simCarrier2 != null) {
                jsonObject.add("sim_carrier", simCarrier2.toJson());
            }
            String str = this.signalStrength;
            if (str != null) {
                jsonObject.addProperty("signal_strength", str);
            }
            String str2 = this.downlinkKbps;
            if (str2 != null) {
                jsonObject.addProperty("downlink_kbps", str2);
            }
            String str3 = this.uplinkKbps;
            if (str3 != null) {
                jsonObject.addProperty("uplink_kbps", str3);
            }
            jsonObject.addProperty("connectivity", this.connectivity);
            return jsonObject;
        }

        @Metadata(mo175977d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, mo175978d2 = {"Lcom/datadog/android/log/model/LogEvent$Client$Companion;", "", "()V", "fromJson", "Lcom/datadog/android/log/model/LogEvent$Client;", "serializedObject", "", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
        /* compiled from: LogEvent.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            /* JADX WARNING: Removed duplicated region for block: B:11:0x0030 A[Catch:{ IllegalStateException -> 0x0071, NumberFormatException -> 0x0066 }] */
            /* JADX WARNING: Removed duplicated region for block: B:12:0x0032 A[Catch:{ IllegalStateException -> 0x0071, NumberFormatException -> 0x0066 }] */
            /* JADX WARNING: Removed duplicated region for block: B:15:0x003f A[Catch:{ IllegalStateException -> 0x0071, NumberFormatException -> 0x0066 }] */
            /* JADX WARNING: Removed duplicated region for block: B:16:0x0041 A[Catch:{ IllegalStateException -> 0x0071, NumberFormatException -> 0x0066 }] */
            /* JADX WARNING: Removed duplicated region for block: B:19:0x004e A[Catch:{ IllegalStateException -> 0x0071, NumberFormatException -> 0x0066 }] */
            /* JADX WARNING: Removed duplicated region for block: B:20:0x004f A[Catch:{ IllegalStateException -> 0x0071, NumberFormatException -> 0x0066 }] */
            @kotlin.jvm.JvmStatic
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final com.datadog.android.log.model.LogEvent.Client fromJson(java.lang.String r10) throws com.google.gson.JsonParseException {
                /*
                    r9 = this;
                    java.lang.String r0 = "connectivity"
                    java.lang.String r1 = "serializedObject"
                    kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r1)
                    com.google.gson.JsonElement r10 = com.google.gson.JsonParser.parseString(r10)     // Catch:{ IllegalStateException -> 0x0071, NumberFormatException -> 0x0066 }
                    com.google.gson.JsonObject r10 = r10.getAsJsonObject()     // Catch:{ IllegalStateException -> 0x0071, NumberFormatException -> 0x0066 }
                    java.lang.String r1 = "sim_carrier"
                    com.google.gson.JsonElement r1 = r10.get(r1)     // Catch:{ IllegalStateException -> 0x0071, NumberFormatException -> 0x0066 }
                    r2 = 0
                    if (r1 != 0) goto L_0x001a
                L_0x0018:
                    r4 = r2
                    goto L_0x0028
                L_0x001a:
                    java.lang.String r1 = r1.toString()     // Catch:{ IllegalStateException -> 0x0071, NumberFormatException -> 0x0066 }
                    if (r1 != 0) goto L_0x0021
                    goto L_0x0018
                L_0x0021:
                    com.datadog.android.log.model.LogEvent$SimCarrier$Companion r3 = com.datadog.android.log.model.LogEvent.SimCarrier.Companion     // Catch:{ IllegalStateException -> 0x0071, NumberFormatException -> 0x0066 }
                    com.datadog.android.log.model.LogEvent$SimCarrier r1 = r3.fromJson(r1)     // Catch:{ IllegalStateException -> 0x0071, NumberFormatException -> 0x0066 }
                    r4 = r1
                L_0x0028:
                    java.lang.String r1 = "signal_strength"
                    com.google.gson.JsonElement r1 = r10.get(r1)     // Catch:{ IllegalStateException -> 0x0071, NumberFormatException -> 0x0066 }
                    if (r1 != 0) goto L_0x0032
                    r5 = r2
                    goto L_0x0037
                L_0x0032:
                    java.lang.String r1 = r1.getAsString()     // Catch:{ IllegalStateException -> 0x0071, NumberFormatException -> 0x0066 }
                    r5 = r1
                L_0x0037:
                    java.lang.String r1 = "downlink_kbps"
                    com.google.gson.JsonElement r1 = r10.get(r1)     // Catch:{ IllegalStateException -> 0x0071, NumberFormatException -> 0x0066 }
                    if (r1 != 0) goto L_0x0041
                    r6 = r2
                    goto L_0x0046
                L_0x0041:
                    java.lang.String r1 = r1.getAsString()     // Catch:{ IllegalStateException -> 0x0071, NumberFormatException -> 0x0066 }
                    r6 = r1
                L_0x0046:
                    java.lang.String r1 = "uplink_kbps"
                    com.google.gson.JsonElement r1 = r10.get(r1)     // Catch:{ IllegalStateException -> 0x0071, NumberFormatException -> 0x0066 }
                    if (r1 != 0) goto L_0x004f
                    goto L_0x0053
                L_0x004f:
                    java.lang.String r2 = r1.getAsString()     // Catch:{ IllegalStateException -> 0x0071, NumberFormatException -> 0x0066 }
                L_0x0053:
                    r7 = r2
                    com.google.gson.JsonElement r10 = r10.get(r0)     // Catch:{ IllegalStateException -> 0x0071, NumberFormatException -> 0x0066 }
                    java.lang.String r8 = r10.getAsString()     // Catch:{ IllegalStateException -> 0x0071, NumberFormatException -> 0x0066 }
                    com.datadog.android.log.model.LogEvent$Client r10 = new com.datadog.android.log.model.LogEvent$Client     // Catch:{ IllegalStateException -> 0x0071, NumberFormatException -> 0x0066 }
                    kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r0)     // Catch:{ IllegalStateException -> 0x0071, NumberFormatException -> 0x0066 }
                    r3 = r10
                    r3.<init>(r4, r5, r6, r7, r8)     // Catch:{ IllegalStateException -> 0x0071, NumberFormatException -> 0x0066 }
                    return r10
                L_0x0066:
                    r10 = move-exception
                    com.google.gson.JsonParseException r0 = new com.google.gson.JsonParseException
                    java.lang.String r10 = r10.getMessage()
                    r0.<init>((java.lang.String) r10)
                    throw r0
                L_0x0071:
                    r10 = move-exception
                    com.google.gson.JsonParseException r0 = new com.google.gson.JsonParseException
                    java.lang.String r10 = r10.getMessage()
                    r0.<init>((java.lang.String) r10)
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.datadog.android.log.model.LogEvent.Client.Companion.fromJson(java.lang.String):com.datadog.android.log.model.LogEvent$Client");
            }
        }
    }

    @Metadata(mo175977d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u000b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\u0006\u0010\u0011\u001a\u00020\u0012J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0015"}, mo175978d2 = {"Lcom/datadog/android/log/model/LogEvent$SimCarrier;", "", "id", "", "name", "(Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getName", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toJson", "Lcom/google/gson/JsonElement;", "toString", "Companion", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: LogEvent.kt */
    public static final class SimCarrier {
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

        /* renamed from: id */
        private final String f3652id;
        private final String name;

        public SimCarrier() {
            this((String) null, (String) null, 3, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ SimCarrier copy$default(SimCarrier simCarrier, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = simCarrier.f3652id;
            }
            if ((i & 2) != 0) {
                str2 = simCarrier.name;
            }
            return simCarrier.copy(str, str2);
        }

        @JvmStatic
        public static final SimCarrier fromJson(String str) throws JsonParseException {
            return Companion.fromJson(str);
        }

        public final String component1() {
            return this.f3652id;
        }

        public final String component2() {
            return this.name;
        }

        public final SimCarrier copy(String str, String str2) {
            return new SimCarrier(str, str2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof SimCarrier)) {
                return false;
            }
            SimCarrier simCarrier = (SimCarrier) obj;
            return Intrinsics.areEqual((Object) this.f3652id, (Object) simCarrier.f3652id) && Intrinsics.areEqual((Object) this.name, (Object) simCarrier.name);
        }

        public int hashCode() {
            String str = this.f3652id;
            int i = 0;
            int hashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.name;
            if (str2 != null) {
                i = str2.hashCode();
            }
            return hashCode + i;
        }

        public String toString() {
            return "SimCarrier(id=" + this.f3652id + ", name=" + this.name + VersionRange.RIGHT_OPEN;
        }

        public SimCarrier(String str, String str2) {
            this.f3652id = str;
            this.name = str2;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ SimCarrier(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2);
        }

        public final String getId() {
            return this.f3652id;
        }

        public final String getName() {
            return this.name;
        }

        public final JsonElement toJson() {
            JsonObject jsonObject = new JsonObject();
            String str = this.f3652id;
            if (str != null) {
                jsonObject.addProperty("id", str);
            }
            String str2 = this.name;
            if (str2 != null) {
                jsonObject.addProperty("name", str2);
            }
            return jsonObject;
        }

        @Metadata(mo175977d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, mo175978d2 = {"Lcom/datadog/android/log/model/LogEvent$SimCarrier$Companion;", "", "()V", "fromJson", "Lcom/datadog/android/log/model/LogEvent$SimCarrier;", "serializedObject", "", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
        /* compiled from: LogEvent.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public final SimCarrier fromJson(String str) throws JsonParseException {
                Intrinsics.checkNotNullParameter(str, "serializedObject");
                try {
                    JsonObject asJsonObject = JsonParser.parseString(str).getAsJsonObject();
                    JsonElement jsonElement = asJsonObject.get("id");
                    String str2 = null;
                    String asString = jsonElement == null ? null : jsonElement.getAsString();
                    JsonElement jsonElement2 = asJsonObject.get("name");
                    if (jsonElement2 != null) {
                        str2 = jsonElement2.getAsString();
                    }
                    return new SimCarrier(asString, str2);
                } catch (IllegalStateException e) {
                    throw new JsonParseException(e.getMessage());
                } catch (NumberFormatException e2) {
                    throw new JsonParseException(e2.getMessage());
                }
            }
        }
    }

    @Metadata(mo175977d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0001\u0018\u0000 \u000e2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000eB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0005\u001a\u00020\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000f"}, mo175978d2 = {"Lcom/datadog/android/log/model/LogEvent$Status;", "", "jsonValue", "", "(Ljava/lang/String;ILjava/lang/String;)V", "toJson", "Lcom/google/gson/JsonElement;", "CRITICAL", "ERROR", "WARN", "INFO", "DEBUG", "TRACE", "EMERGENCY", "Companion", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: LogEvent.kt */
    public enum Status {
        CRITICAL("critical"),
        ERROR("error"),
        WARN("warn"),
        INFO("info"),
        DEBUG("debug"),
        TRACE("trace"),
        EMERGENCY("emergency");
        
        public static final Companion Companion = null;
        /* access modifiers changed from: private */
        public final String jsonValue;

        @JvmStatic
        public static final Status fromJson(String str) {
            return Companion.fromJson(str);
        }

        private Status(String str) {
            this.jsonValue = str;
        }

        static {
            Companion = new Companion((DefaultConstructorMarker) null);
        }

        public final JsonElement toJson() {
            return new JsonPrimitive(this.jsonValue);
        }

        @Metadata(mo175977d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, mo175978d2 = {"Lcom/datadog/android/log/model/LogEvent$Status$Companion;", "", "()V", "fromJson", "Lcom/datadog/android/log/model/LogEvent$Status;", "serializedObject", "", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
        /* compiled from: LogEvent.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public final Status fromJson(String str) {
                Intrinsics.checkNotNullParameter(str, "serializedObject");
                for (Status status : Status.values()) {
                    if (Intrinsics.areEqual((Object) status.jsonValue, (Object) str)) {
                        return status;
                    }
                }
                throw new NoSuchElementException("Array contains no element matching the predicate.");
            }
        }
    }
}
