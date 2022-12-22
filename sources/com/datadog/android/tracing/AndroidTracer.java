package com.datadog.android.tracing;

import com.datadog.android.core.internal.CoreFeature;
import com.datadog.android.core.internal.utils.RuntimeUtilsKt;
import com.datadog.android.log.LogAttributes;
import com.datadog.android.log.Logger;
import com.datadog.android.rum.GlobalRum;
import com.datadog.android.rum.internal.RumFeature;
import com.datadog.android.rum.internal.domain.RumContext;
import com.datadog.android.tracing.internal.TracesFeature;
import com.datadog.android.tracing.internal.data.TraceWriter;
import com.datadog.android.tracing.internal.handlers.AndroidSpanLogsHandler;
import com.datadog.opentracing.DDTracer;
import com.datadog.opentracing.LogHandler;
import com.datadog.trace.api.Config;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Random;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import p242io.opentracing.Span;
import p242io.opentracing.log.Fields;

@Metadata(mo175977d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \u00132\u00020\u0001:\u0002\u0012\u0013B/\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u0014\u0010\r\u001a\u00060\u000eR\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0014\u0010\u0011\u001a\u00060\u000eR\u00020\u0001*\u00060\u000eR\u00020\u0001H\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, mo175978d2 = {"Lcom/datadog/android/tracing/AndroidTracer;", "Lcom/datadog/opentracing/DDTracer;", "config", "Lcom/datadog/trace/api/Config;", "writer", "Lcom/datadog/android/tracing/internal/data/TraceWriter;", "random", "Ljava/util/Random;", "logsHandler", "Lcom/datadog/opentracing/LogHandler;", "bundleWithRum", "", "(Lcom/datadog/trace/api/Config;Lcom/datadog/android/tracing/internal/data/TraceWriter;Ljava/util/Random;Lcom/datadog/opentracing/LogHandler;Z)V", "buildSpan", "Lcom/datadog/opentracing/DDTracer$DDSpanBuilder;", "operationName", "", "withRumContext", "Builder", "Companion", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: AndroidTracer.kt */
public final class AndroidTracer extends DDTracer {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int DEFAULT_PARTIAL_MIN_FLUSH = 5;
    public static final String RUM_NOT_ENABLED_ERROR_MESSAGE = "You're trying to bundle the traces with a RUM context, but the RUM feature was disabled in your Configuration. No RUM context will be attached to your traces in this case.";
    public static final int TRACE_ID_BIT_SIZE = 63;
    public static final String TRACE_LOGGER_NAME = "trace";
    public static final String TRACING_NOT_ENABLED_ERROR_MESSAGE = "You're trying to create an AndroidTracer instance, but the Tracing feature was disabled in your Configuration. No tracing data will be sent.";

    /* renamed from: f */
    private final LogHandler f4042f;

    /* renamed from: g */
    private final boolean f4043g;

    @JvmStatic
    public static final void logErrorMessage(Span span, String str) {
        Companion.logErrorMessage(span, str);
    }

    @JvmStatic
    public static final void logThrowable(Span span, Throwable th) {
        Companion.logThrowable(span, th);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AndroidTracer(Config config, TraceWriter traceWriter, Random random, LogHandler logHandler, boolean z) {
        super(config, traceWriter, random);
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(traceWriter, "writer");
        Intrinsics.checkNotNullParameter(random, "random");
        Intrinsics.checkNotNullParameter(logHandler, "logsHandler");
        this.f4042f = logHandler;
        this.f4043g = z;
    }

    public DDTracer.DDSpanBuilder buildSpan(String str) {
        Intrinsics.checkNotNullParameter(str, "operationName");
        DDTracer.DDSpanBuilder withLogHandler = new DDTracer.DDSpanBuilder(str, scopeManager()).withLogHandler(this.f4042f);
        Intrinsics.checkNotNullExpressionValue(withLogHandler, "DDSpanBuilder(operationName, scopeManager())\n            .withLogHandler(logsHandler)");
        return m2529a(withLogHandler);
    }

    @Metadata(mo175977d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0007J\u0006\u0010\u0012\u001a\u00020\u0013J\b\u0010\u0014\u001a\u00020\u0015H\u0002J\r\u0010\u0016\u001a\u00020\u0017H\u0000¢\u0006\u0002\b\u0018J\u000e\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u0004J\u000e\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u000bJ\u000e\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u0007J\u0015\u0010\u001e\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\rH\u0000¢\u0006\u0002\b\u001fR\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, mo175978d2 = {"Lcom/datadog/android/tracing/AndroidTracer$Builder;", "", "()V", "bundleWithRumEnabled", "", "globalTags", "", "", "logsHandler", "Lcom/datadog/opentracing/LogHandler;", "partialFlushThreshold", "", "random", "Ljava/util/Random;", "serviceName", "addGlobalTag", "key", "value", "build", "Lcom/datadog/android/tracing/AndroidTracer;", "config", "Lcom/datadog/trace/api/Config;", "properties", "Ljava/util/Properties;", "properties$dd_sdk_android_release", "setBundleWithRumEnabled", "enabled", "setPartialFlushThreshold", "threshold", "setServiceName", "withRandom", "withRandom$dd_sdk_android_release", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: AndroidTracer.kt */
    public static final class Builder {
        private boolean bundleWithRumEnabled = true;
        private final Map<String, String> globalTags = new LinkedHashMap();
        private final LogHandler logsHandler = new AndroidSpanLogsHandler(new Logger.Builder().setLoggerName("trace").build());
        private int partialFlushThreshold = 5;
        private Random random = new SecureRandom();
        private String serviceName = CoreFeature.INSTANCE.getServiceName$dd_sdk_android_release();

        public final AndroidTracer build() {
            if (!TracesFeature.INSTANCE.isInitialized()) {
                Logger.e$default(RuntimeUtilsKt.getDevLogger(), AndroidTracer.TRACING_NOT_ENABLED_ERROR_MESSAGE, (Throwable) null, (Map) null, 6, (Object) null);
            }
            if (this.bundleWithRumEnabled && !RumFeature.INSTANCE.isInitialized()) {
                Logger.e$default(RuntimeUtilsKt.getDevLogger(), AndroidTracer.RUM_NOT_ENABLED_ERROR_MESSAGE, (Throwable) null, (Map) null, 6, (Object) null);
                this.bundleWithRumEnabled = false;
            }
            return new AndroidTracer(config(), new TraceWriter(TracesFeature.INSTANCE.getPersistenceStrategy$dd_sdk_android_release().getWriter()), this.random, this.logsHandler, this.bundleWithRumEnabled);
        }

        public final Builder setServiceName(String str) {
            Intrinsics.checkNotNullParameter(str, "serviceName");
            this.serviceName = str;
            return this;
        }

        public final Builder setPartialFlushThreshold(int i) {
            this.partialFlushThreshold = i;
            return this;
        }

        public final Builder addGlobalTag(String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "key");
            Intrinsics.checkNotNullParameter(str2, "value");
            this.globalTags.put(str, str2);
            return this;
        }

        public final Builder setBundleWithRumEnabled(boolean z) {
            this.bundleWithRumEnabled = z;
            return this;
        }

        public final Builder withRandom$dd_sdk_android_release(Random random2) {
            Intrinsics.checkNotNullParameter(random2, "random");
            this.random = random2;
            return this;
        }

        public final Properties properties$dd_sdk_android_release() {
            Properties properties = new Properties();
            properties.setProperty("service.name", this.serviceName);
            properties.setProperty(Config.PARTIAL_FLUSH_MIN_SPANS, String.valueOf(this.partialFlushThreshold));
            Map<String, String> map = this.globalTags;
            Collection arrayList = new ArrayList(map.size());
            for (Map.Entry next : map.entrySet()) {
                arrayList.add(((String) next.getKey()) + ':' + ((String) next.getValue()));
            }
            properties.setProperty("tags", CollectionsKt.joinToString$default((List) arrayList, ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null));
            return properties;
        }

        private final Config config() {
            Config config = Config.get(properties$dd_sdk_android_release());
            Intrinsics.checkNotNullExpressionValue(config, "get(properties())");
            return config;
        }
    }

    /* renamed from: a */
    private final DDTracer.DDSpanBuilder m2529a(DDTracer.DDSpanBuilder dDSpanBuilder) {
        if (!this.f4043g) {
            return dDSpanBuilder;
        }
        RumContext rumContext$dd_sdk_android_release = GlobalRum.INSTANCE.getRumContext$dd_sdk_android_release();
        DDTracer.DDSpanBuilder withTag = dDSpanBuilder.withTag(LogAttributes.RUM_APPLICATION_ID, rumContext$dd_sdk_android_release.getApplicationId()).withTag("session_id", rumContext$dd_sdk_android_release.getSessionId()).withTag(LogAttributes.RUM_VIEW_ID, rumContext$dd_sdk_android_release.getViewId()).withTag(LogAttributes.RUM_ACTION_ID, rumContext$dd_sdk_android_release.getActionId());
        Intrinsics.checkNotNullExpressionValue(withTag, "{\n            val rumContext = GlobalRum.getRumContext()\n            withTag(LogAttributes.RUM_APPLICATION_ID, rumContext.applicationId)\n                .withTag(LogAttributes.RUM_SESSION_ID, rumContext.sessionId)\n                .withTag(LogAttributes.RUM_VIEW_ID, rumContext.viewId)\n                .withTag(LogAttributes.RUM_ACTION_ID, rumContext.actionId)\n        }");
        return withTag;
    }

    @Metadata(mo175977d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0006H\u0007J\u0018\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0011H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0012"}, mo175978d2 = {"Lcom/datadog/android/tracing/AndroidTracer$Companion;", "", "()V", "DEFAULT_PARTIAL_MIN_FLUSH", "", "RUM_NOT_ENABLED_ERROR_MESSAGE", "", "TRACE_ID_BIT_SIZE", "TRACE_LOGGER_NAME", "TRACING_NOT_ENABLED_ERROR_MESSAGE", "logErrorMessage", "", "span", "Lio/opentracing/Span;", "message", "logThrowable", "throwable", "", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: AndroidTracer.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final void logThrowable(Span span, Throwable th) {
            Intrinsics.checkNotNullParameter(span, "span");
            Intrinsics.checkNotNullParameter(th, "throwable");
            span.log((Map<String, ?>) MapsKt.mapOf(TuplesKt.m42317to(Fields.ERROR_OBJECT, th)));
        }

        @JvmStatic
        public final void logErrorMessage(Span span, String str) {
            Intrinsics.checkNotNullParameter(span, "span");
            Intrinsics.checkNotNullParameter(str, "message");
            span.log((Map<String, ?>) MapsKt.mapOf(TuplesKt.m42317to("message", str)));
        }
    }
}
