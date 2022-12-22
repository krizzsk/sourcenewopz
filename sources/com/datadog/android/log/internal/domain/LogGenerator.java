package com.datadog.android.log.internal.domain;

import com.datadog.android.core.internal.net.info.NetworkInfoProvider;
import com.datadog.android.core.internal.time.TimeProvider;
import com.datadog.android.core.model.NetworkInfo;
import com.datadog.android.core.model.UserInfo;
import com.datadog.android.log.LogAttributes;
import com.datadog.android.log.internal.user.UserInfoProvider;
import com.datadog.android.log.model.LogEvent;
import com.datadog.android.rum.GlobalRum;
import com.datadog.android.rum.internal.domain.RumContext;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import p242io.opentracing.Span;
import p242io.opentracing.SpanContext;
import p242io.opentracing.util.GlobalTracer;

@Metadata(mo175977d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 ?2\u00020\u0001:\u0001?BG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003¢\u0006\u0002\u0010\u000eJ\u0001\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u00032\b\u0010#\u001a\u0004\u0018\u00010$2\u0014\u0010%\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010&2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00030(2\u0006\u0010)\u001a\u00020*2\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010,\u001a\u00020-2\b\b\u0002\u0010.\u001a\u00020-2\n\b\u0002\u0010/\u001a\u0004\u0018\u0001002\n\b\u0002\u00101\u001a\u0004\u0018\u000102J<\u00103\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001042\u0014\u0010%\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010&2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020-H\u0002J\u0010\u00105\u001a\u0002062\u0006\u0010 \u001a\u00020!H\u0002J\u0014\u00107\u001a\u0004\u0018\u0001082\b\u00101\u001a\u0004\u0018\u000102H\u0002J\u0012\u00109\u001a\u0004\u0018\u00010:2\u0006\u00101\u001a\u000202H\u0002J\u001c\u0010;\u001a\b\u0012\u0004\u0012\u00020\u00030<2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00030(H\u0002J\u0012\u0010=\u001a\u00020>2\b\u0010/\u001a\u0004\u0018\u000100H\u0002R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0004\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u000b\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0012R\u000e\u0010\u0018\u001a\u00020\u0019X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\nX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001d¨\u0006@"}, mo175978d2 = {"Lcom/datadog/android/log/internal/domain/LogGenerator;", "", "serviceName", "", "loggerName", "networkInfoProvider", "Lcom/datadog/android/core/internal/net/info/NetworkInfoProvider;", "userInfoProvider", "Lcom/datadog/android/log/internal/user/UserInfoProvider;", "timeProvider", "Lcom/datadog/android/core/internal/time/TimeProvider;", "sdkVersion", "envName", "appVersion", "(Ljava/lang/String;Ljava/lang/String;Lcom/datadog/android/core/internal/net/info/NetworkInfoProvider;Lcom/datadog/android/log/internal/user/UserInfoProvider;Lcom/datadog/android/core/internal/time/TimeProvider;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "appVersionTag", "envTag", "getEnvTag$dd_sdk_android_release", "()Ljava/lang/String;", "getLoggerName$dd_sdk_android_release", "getNetworkInfoProvider$dd_sdk_android_release", "()Lcom/datadog/android/core/internal/net/info/NetworkInfoProvider;", "getSdkVersion$dd_sdk_android_release", "getServiceName$dd_sdk_android_release", "simpleDateFormat", "Ljava/text/SimpleDateFormat;", "getTimeProvider$dd_sdk_android_release", "()Lcom/datadog/android/core/internal/time/TimeProvider;", "getUserInfoProvider$dd_sdk_android_release", "()Lcom/datadog/android/log/internal/user/UserInfoProvider;", "generateLog", "Lcom/datadog/android/log/model/LogEvent;", "level", "", "message", "throwable", "", "attributes", "", "tags", "", "timestamp", "", "threadName", "bundleWithTraces", "", "bundleWithRum", "userInfo", "Lcom/datadog/android/core/model/UserInfo;", "networkInfo", "Lcom/datadog/android/core/model/NetworkInfo;", "resolveAttributes", "", "resolveLogLevelStatus", "Lcom/datadog/android/log/model/LogEvent$Status;", "resolveNetworkInfo", "Lcom/datadog/android/log/model/LogEvent$Network;", "resolveSimCarrier", "Lcom/datadog/android/log/model/LogEvent$SimCarrier;", "resolveTags", "", "resolveUserInfo", "Lcom/datadog/android/log/model/LogEvent$Usr;", "Companion", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: LogGenerator.kt */
public final class LogGenerator {
    public static final int CRASH = 9;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String ISO_8601 = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";

    /* renamed from: a */
    private final String f3613a;

    /* renamed from: b */
    private final String f3614b;

    /* renamed from: c */
    private final NetworkInfoProvider f3615c;

    /* renamed from: d */
    private final UserInfoProvider f3616d;

    /* renamed from: e */
    private final TimeProvider f3617e;

    /* renamed from: f */
    private final String f3618f;

    /* renamed from: g */
    private final SimpleDateFormat f3619g;

    /* renamed from: h */
    private final String f3620h;

    /* renamed from: i */
    private final String f3621i;

    public LogGenerator(String str, String str2, NetworkInfoProvider networkInfoProvider, UserInfoProvider userInfoProvider, TimeProvider timeProvider, String str3, String str4, String str5) {
        String str6;
        String str7;
        Intrinsics.checkNotNullParameter(str, "serviceName");
        Intrinsics.checkNotNullParameter(str2, "loggerName");
        Intrinsics.checkNotNullParameter(userInfoProvider, "userInfoProvider");
        Intrinsics.checkNotNullParameter(timeProvider, "timeProvider");
        Intrinsics.checkNotNullParameter(str3, "sdkVersion");
        Intrinsics.checkNotNullParameter(str4, "envName");
        Intrinsics.checkNotNullParameter(str5, "appVersion");
        this.f3613a = str;
        this.f3614b = str2;
        this.f3615c = networkInfoProvider;
        this.f3616d = userInfoProvider;
        this.f3617e = timeProvider;
        this.f3618f = str3;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(ISO_8601, Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        Unit unit = Unit.INSTANCE;
        this.f3619g = simpleDateFormat;
        boolean z = true;
        if (str4.length() > 0) {
            str6 = Intrinsics.stringPlus("env:", str4);
        } else {
            str6 = null;
        }
        this.f3620h = str6;
        if (str5.length() <= 0 ? false : z) {
            str7 = Intrinsics.stringPlus("version:", str5);
        } else {
            str7 = null;
        }
        this.f3621i = str7;
    }

    public final String getServiceName$dd_sdk_android_release() {
        return this.f3613a;
    }

    public final String getLoggerName$dd_sdk_android_release() {
        return this.f3614b;
    }

    public final NetworkInfoProvider getNetworkInfoProvider$dd_sdk_android_release() {
        return this.f3615c;
    }

    public final UserInfoProvider getUserInfoProvider$dd_sdk_android_release() {
        return this.f3616d;
    }

    public final TimeProvider getTimeProvider$dd_sdk_android_release() {
        return this.f3617e;
    }

    public final String getSdkVersion$dd_sdk_android_release() {
        return this.f3618f;
    }

    public final String getEnvTag$dd_sdk_android_release() {
        return this.f3620h;
    }

    public static /* synthetic */ LogEvent generateLog$default(LogGenerator logGenerator, int i, String str, Throwable th, Map map, Set set, long j, String str2, boolean z, boolean z2, UserInfo userInfo, NetworkInfo networkInfo, int i2, Object obj) {
        int i3 = i2;
        return logGenerator.generateLog(i, str, th, map, set, j, (i3 & 64) != 0 ? null : str2, (i3 & 128) != 0 ? true : z, (i3 & 256) != 0 ? true : z2, (i3 & 512) != 0 ? null : userInfo, (i3 & 1024) != 0 ? null : networkInfo);
    }

    public final LogEvent generateLog(int i, String str, Throwable th, Map<String, ? extends Object> map, Set<String> set, long j, String str2, boolean z, boolean z2, UserInfo userInfo, NetworkInfo networkInfo) {
        String format;
        LogEvent.Error error;
        UserInfo userInfo2;
        Map<String, ? extends Object> map2 = map;
        Set<String> set2 = set;
        Intrinsics.checkNotNullParameter(str, "message");
        Intrinsics.checkNotNullParameter(map2, "attributes");
        Intrinsics.checkNotNullParameter(set2, "tags");
        long serverOffsetMillis = j + this.f3617e.getServerOffsetMillis();
        Map<String, Object> a = m2395a(map2, z, z2);
        synchronized (this.f3619g) {
            format = this.f3619g.format(new Date(serverOffsetMillis));
        }
        Set<String> a2 = m2396a(set2);
        if (th == null) {
            error = null;
            userInfo2 = userInfo;
        } else {
            String canonicalName = th.getClass().getCanonicalName();
            if (canonicalName == null) {
                canonicalName = th.getClass().getSimpleName();
            }
            LogEvent.Error error2 = new LogEvent.Error(canonicalName, th.getMessage(), ExceptionsKt.stackTraceToString(th));
            userInfo2 = userInfo;
            error = error2;
        }
        LogEvent.Usr a3 = m2394a(userInfo2);
        LogEvent.Network a4 = m2392a(networkInfo);
        LogEvent.Logger logger = new LogEvent.Logger(this.f3614b, str2 == null ? Thread.currentThread().getName() : str2, this.f3618f);
        String str3 = this.f3613a;
        LogEvent.Status a5 = m2393a(i);
        String joinToString$default = CollectionsKt.joinToString$default(a2, ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
        Intrinsics.checkNotNullExpressionValue(format, "formattedDate");
        return new LogEvent(a5, str3, str, format, logger, a3, a4, error, joinToString$default, a);
    }

    /* renamed from: a */
    private final LogEvent.Network m2392a(NetworkInfo networkInfo) {
        String str = null;
        if (networkInfo == null) {
            NetworkInfoProvider networkInfoProvider = this.f3615c;
            networkInfo = networkInfoProvider == null ? null : networkInfoProvider.getLatestNetworkInfo();
        }
        if (networkInfo == null) {
            return null;
        }
        LogEvent.SimCarrier b = m2397b(networkInfo);
        Long strength = networkInfo.getStrength();
        String l = strength == null ? null : strength.toString();
        Long downKbps = networkInfo.getDownKbps();
        String l2 = downKbps == null ? null : downKbps.toString();
        Long upKbps = networkInfo.getUpKbps();
        if (upKbps != null) {
            str = upKbps.toString();
        }
        return new LogEvent.Network(new LogEvent.Client(b, l, l2, str, networkInfo.getConnectivity().toString()));
    }

    /* renamed from: a */
    private final LogEvent.Usr m2394a(UserInfo userInfo) {
        if (userInfo == null) {
            userInfo = this.f3616d.getUserInfo();
        }
        return new LogEvent.Usr(userInfo.getId(), userInfo.getName(), userInfo.getEmail(), userInfo.getAdditionalProperties());
    }

    /* renamed from: a */
    private final Set<String> m2396a(Set<String> set) {
        Set<String> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.addAll(set);
        String str = this.f3620h;
        if (str != null) {
            linkedHashSet.add(str);
        }
        String str2 = this.f3621i;
        if (str2 != null) {
            linkedHashSet.add(str2);
        }
        return linkedHashSet;
    }

    /* renamed from: a */
    private final Map<String, Object> m2395a(Map<String, ? extends Object> map, boolean z, boolean z2) {
        Map<String, Object> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.putAll(map);
        if (z && GlobalTracer.isRegistered()) {
            Span activeSpan = GlobalTracer.get().activeSpan();
            SpanContext context = activeSpan == null ? null : activeSpan.context();
            if (context != null) {
                linkedHashMap.put(LogAttributes.DD_TRACE_ID, context.toTraceId());
                linkedHashMap.put(LogAttributes.DD_SPAN_ID, context.toSpanId());
            }
        }
        if (z2 && GlobalRum.isRegistered()) {
            RumContext rumContext$dd_sdk_android_release = GlobalRum.INSTANCE.getRumContext$dd_sdk_android_release();
            linkedHashMap.put(LogAttributes.RUM_APPLICATION_ID, rumContext$dd_sdk_android_release.getApplicationId());
            linkedHashMap.put("session_id", rumContext$dd_sdk_android_release.getSessionId());
            linkedHashMap.put(LogAttributes.RUM_VIEW_ID, rumContext$dd_sdk_android_release.getViewId());
            linkedHashMap.put(LogAttributes.RUM_ACTION_ID, rumContext$dd_sdk_android_release.getActionId());
        }
        return linkedHashMap;
    }

    /* renamed from: a */
    private final LogEvent.Status m2393a(int i) {
        switch (i) {
            case 2:
                return LogEvent.Status.TRACE;
            case 3:
                return LogEvent.Status.DEBUG;
            case 4:
                return LogEvent.Status.INFO;
            case 5:
                return LogEvent.Status.WARN;
            case 6:
                return LogEvent.Status.ERROR;
            case 7:
                return LogEvent.Status.CRITICAL;
            case 9:
                return LogEvent.Status.EMERGENCY;
            default:
                return LogEvent.Status.DEBUG;
        }
    }

    /* renamed from: b */
    private final LogEvent.SimCarrier m2397b(NetworkInfo networkInfo) {
        String str = null;
        if (networkInfo.getCarrierId() == null && networkInfo.getCarrierName() == null) {
            return null;
        }
        Long carrierId = networkInfo.getCarrierId();
        if (carrierId != null) {
            str = carrierId.toString();
        }
        return new LogEvent.SimCarrier(str, networkInfo.getCarrierName());
    }

    @Metadata(mo175977d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, mo175978d2 = {"Lcom/datadog/android/log/internal/domain/LogGenerator$Companion;", "", "()V", "CRASH", "", "ISO_8601", "", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: LogGenerator.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
