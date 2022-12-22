package com.datadog.android.rum.internal.ndk;

import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo175977d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0007\b\b\u0018\u0000  2\u00020\u0001:\u0001 B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÆ\u0003J;\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001J\r\u0010\u001d\u001a\u00020\u0007H\u0000¢\u0006\u0002\b\u001eJ\t\u0010\u001f\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\t\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006!"}, mo175978d2 = {"Lcom/datadog/android/rum/internal/ndk/NdkCrashLog;", "", "signal", "", "timestamp", "", "signalName", "", "message", "stacktrace", "(IJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "getSignal", "()I", "getSignalName", "getStacktrace", "getTimestamp", "()J", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toJson", "toJson$dd_sdk_android_release", "toString", "Companion", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: NdkCrashLog.kt */
public final class NdkCrashLog {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String MESSAGE_KEY_NAME = "message";
    public static final String SIGNAL_KEY_NAME = "signal";
    public static final String SIGNAL_NAME_KEY_NAME = "signal_name";
    public static final String STACKTRACE_KEY_NAME = "stacktrace";
    public static final String TIMESTAMP_KEY_NAME = "timestamp";

    /* renamed from: a */
    private final int f3881a;

    /* renamed from: b */
    private final long f3882b;

    /* renamed from: c */
    private final String f3883c;

    /* renamed from: d */
    private final String f3884d;

    /* renamed from: e */
    private final String f3885e;

    public static /* synthetic */ NdkCrashLog copy$default(NdkCrashLog ndkCrashLog, int i, long j, String str, String str2, String str3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = ndkCrashLog.f3881a;
        }
        if ((i2 & 2) != 0) {
            j = ndkCrashLog.f3882b;
        }
        long j2 = j;
        if ((i2 & 4) != 0) {
            str = ndkCrashLog.f3883c;
        }
        String str4 = str;
        if ((i2 & 8) != 0) {
            str2 = ndkCrashLog.f3884d;
        }
        String str5 = str2;
        if ((i2 & 16) != 0) {
            str3 = ndkCrashLog.f3885e;
        }
        return ndkCrashLog.copy(i, j2, str4, str5, str3);
    }

    public final int component1() {
        return this.f3881a;
    }

    public final long component2() {
        return this.f3882b;
    }

    public final String component3() {
        return this.f3883c;
    }

    public final String component4() {
        return this.f3884d;
    }

    public final String component5() {
        return this.f3885e;
    }

    public final NdkCrashLog copy(int i, long j, String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "signalName");
        Intrinsics.checkNotNullParameter(str2, "message");
        Intrinsics.checkNotNullParameter(str3, STACKTRACE_KEY_NAME);
        return new NdkCrashLog(i, j, str, str2, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NdkCrashLog)) {
            return false;
        }
        NdkCrashLog ndkCrashLog = (NdkCrashLog) obj;
        return this.f3881a == ndkCrashLog.f3881a && this.f3882b == ndkCrashLog.f3882b && Intrinsics.areEqual((Object) this.f3883c, (Object) ndkCrashLog.f3883c) && Intrinsics.areEqual((Object) this.f3884d, (Object) ndkCrashLog.f3884d) && Intrinsics.areEqual((Object) this.f3885e, (Object) ndkCrashLog.f3885e);
    }

    public int hashCode() {
        return (((((((this.f3881a * 31) + C$r8$backportedMethods$utility$Long$1$hashCode.hashCode(this.f3882b)) * 31) + this.f3883c.hashCode()) * 31) + this.f3884d.hashCode()) * 31) + this.f3885e.hashCode();
    }

    public String toString() {
        return "NdkCrashLog(signal=" + this.f3881a + ", timestamp=" + this.f3882b + ", signalName=" + this.f3883c + ", message=" + this.f3884d + ", stacktrace=" + this.f3885e + VersionRange.RIGHT_OPEN;
    }

    public NdkCrashLog(int i, long j, String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "signalName");
        Intrinsics.checkNotNullParameter(str2, "message");
        Intrinsics.checkNotNullParameter(str3, STACKTRACE_KEY_NAME);
        this.f3881a = i;
        this.f3882b = j;
        this.f3883c = str;
        this.f3884d = str2;
        this.f3885e = str3;
    }

    public final int getSignal() {
        return this.f3881a;
    }

    public final long getTimestamp() {
        return this.f3882b;
    }

    public final String getSignalName() {
        return this.f3883c;
    }

    public final String getMessage() {
        return this.f3884d;
    }

    public final String getStacktrace() {
        return this.f3885e;
    }

    public final String toJson$dd_sdk_android_release() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("signal", (Number) Integer.valueOf(this.f3881a));
        jsonObject.addProperty(SIGNAL_NAME_KEY_NAME, this.f3883c);
        jsonObject.addProperty("timestamp", (Number) Long.valueOf(this.f3882b));
        jsonObject.addProperty("message", this.f3884d);
        jsonObject.addProperty(STACKTRACE_KEY_NAME, this.f3885e);
        String jsonObject2 = jsonObject.toString();
        Intrinsics.checkNotNullExpressionValue(jsonObject2, "jsonObject.toString()");
        return jsonObject2;
    }

    @Metadata(mo175977d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0015\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0004H\u0000¢\u0006\u0002\b\fR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\r"}, mo175978d2 = {"Lcom/datadog/android/rum/internal/ndk/NdkCrashLog$Companion;", "", "()V", "MESSAGE_KEY_NAME", "", "SIGNAL_KEY_NAME", "SIGNAL_NAME_KEY_NAME", "STACKTRACE_KEY_NAME", "TIMESTAMP_KEY_NAME", "fromJson", "Lcom/datadog/android/rum/internal/ndk/NdkCrashLog;", "jsonString", "fromJson$dd_sdk_android_release", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: NdkCrashLog.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final NdkCrashLog fromJson$dd_sdk_android_release(String str) throws JsonParseException, IllegalStateException {
            Intrinsics.checkNotNullParameter(str, "jsonString");
            JsonObject asJsonObject = JsonParser.parseString(str).getAsJsonObject();
            int asInt = asJsonObject.get("signal").getAsInt();
            long asLong = asJsonObject.get("timestamp").getAsLong();
            String asString = asJsonObject.get(NdkCrashLog.SIGNAL_NAME_KEY_NAME).getAsString();
            Intrinsics.checkNotNullExpressionValue(asString, "jsonObject.get(SIGNAL_NAME_KEY_NAME).asString");
            String asString2 = asJsonObject.get("message").getAsString();
            Intrinsics.checkNotNullExpressionValue(asString2, "jsonObject.get(MESSAGE_KEY_NAME).asString");
            String asString3 = asJsonObject.get(NdkCrashLog.STACKTRACE_KEY_NAME).getAsString();
            Intrinsics.checkNotNullExpressionValue(asString3, "jsonObject.get(STACKTRACE_KEY_NAME).asString");
            return new NdkCrashLog(asInt, asLong, asString, asString2, asString3);
        }
    }
}
