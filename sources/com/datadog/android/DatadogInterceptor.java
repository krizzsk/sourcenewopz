package com.datadog.android;

import com.datadog.android.core.internal.CoreFeature;
import com.datadog.android.core.internal.net.FirstPartyHostDetector;
import com.datadog.android.core.internal.net.RequestUniqueIdentifierKt;
import com.datadog.android.core.internal.utils.RuntimeUtilsKt;
import com.datadog.android.log.Logger;
import com.datadog.android.rum.GlobalRum;
import com.datadog.android.rum.NoOpRumResourceAttributesProvider;
import com.datadog.android.rum.RumAttributes;
import com.datadog.android.rum.RumErrorSource;
import com.datadog.android.rum.RumMonitor;
import com.datadog.android.rum.RumResourceAttributesProvider;
import com.datadog.android.rum.RumResourceKind;
import com.datadog.android.rum.internal.RumFeature;
import com.datadog.android.tracing.NoOpTracedRequestListener;
import com.datadog.android.tracing.TracedRequestListener;
import com.datadog.android.tracing.TracingInterceptor;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import p242io.opentracing.Span;
import p242io.opentracing.Tracer;

@Metadata(mo175977d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u0000 '2\u00020\u0001:\u0001'B)\b\u0017\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tB\u001b\b\u0017\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\nB=\b\u0000\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f¢\u0006\u0002\u0010\u0011J\r\u0010\u0012\u001a\u00020\u0013H\u0010¢\u0006\u0002\b\u0014J\u0019\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0002¢\u0006\u0002\u0010\u0019J$\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0002J\u0018\u0010 \u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010!\u001a\u00020\"H\u0002J\u0010\u0010#\u001a\u00020\u00182\u0006\u0010$\u001a\u00020%H\u0016J.\u0010&\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010!\u001a\u0004\u0018\u00010\"H\u0014R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000¨\u0006("}, mo175978d2 = {"Lcom/datadog/android/DatadogInterceptor;", "Lcom/datadog/android/tracing/TracingInterceptor;", "firstPartyHosts", "", "", "tracedRequestListener", "Lcom/datadog/android/tracing/TracedRequestListener;", "rumResourceAttributesProvider", "Lcom/datadog/android/rum/RumResourceAttributesProvider;", "(Ljava/util/List;Lcom/datadog/android/tracing/TracedRequestListener;Lcom/datadog/android/rum/RumResourceAttributesProvider;)V", "(Lcom/datadog/android/tracing/TracedRequestListener;Lcom/datadog/android/rum/RumResourceAttributesProvider;)V", "tracedHosts", "firstPartyHostDetector", "Lcom/datadog/android/core/internal/net/FirstPartyHostDetector;", "localTracerFactory", "Lkotlin/Function0;", "Lio/opentracing/Tracer;", "(Ljava/util/List;Lcom/datadog/android/tracing/TracedRequestListener;Lcom/datadog/android/core/internal/net/FirstPartyHostDetector;Lcom/datadog/android/rum/RumResourceAttributesProvider;Lkotlin/jvm/functions/Function0;)V", "canSendSpan", "", "canSendSpan$dd_sdk_android_release", "getBodyLength", "", "response", "Lokhttp3/Response;", "(Lokhttp3/Response;)Ljava/lang/Long;", "handleResponse", "", "request", "Lokhttp3/Request;", "span", "Lio/opentracing/Span;", "handleThrowable", "throwable", "", "intercept", "chain", "Lokhttp3/Interceptor$Chain;", "onRequestIntercepted", "Companion", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: DatadogInterceptor.kt */
public class DatadogInterceptor extends TracingInterceptor {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String ERROR_MSG_FORMAT = "OkHttp request error %s %s";
    public static final String ORIGIN_RUM = "rum";
    public static final String WARN_RUM_DISABLED = "You set up a DatadogInterceptor, but RUM features are disabled.Make sure you initialized the Datadog SDK with a valid Application Id, and that RUM features are enabled.";

    /* renamed from: b */
    private static final long f3390b = 33554432;

    /* renamed from: a */
    private final RumResourceAttributesProvider f3391a;

    public DatadogInterceptor() {
        this((TracedRequestListener) null, (RumResourceAttributesProvider) null, 3, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public DatadogInterceptor(TracedRequestListener tracedRequestListener) {
        this(tracedRequestListener, (RumResourceAttributesProvider) null, 2, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(tracedRequestListener, "tracedRequestListener");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public DatadogInterceptor(List<String> list) {
        this((List) list, (TracedRequestListener) null, (RumResourceAttributesProvider) null, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(list, "firstPartyHosts");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public DatadogInterceptor(List<String> list, TracedRequestListener tracedRequestListener) {
        this((List) list, tracedRequestListener, (RumResourceAttributesProvider) null, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(list, "firstPartyHosts");
        Intrinsics.checkNotNullParameter(tracedRequestListener, "tracedRequestListener");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DatadogInterceptor(List list, TracedRequestListener tracedRequestListener, FirstPartyHostDetector firstPartyHostDetector, RumResourceAttributesProvider rumResourceAttributesProvider, Function0 function0, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((List<String>) list, tracedRequestListener, firstPartyHostDetector, (i & 8) != 0 ? new NoOpRumResourceAttributesProvider() : rumResourceAttributesProvider, (Function0<? extends Tracer>) function0);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DatadogInterceptor(List<String> list, TracedRequestListener tracedRequestListener, FirstPartyHostDetector firstPartyHostDetector, RumResourceAttributesProvider rumResourceAttributesProvider, Function0<? extends Tracer> function0) {
        super(list, tracedRequestListener, firstPartyHostDetector, ORIGIN_RUM, function0);
        Intrinsics.checkNotNullParameter(list, "tracedHosts");
        Intrinsics.checkNotNullParameter(tracedRequestListener, "tracedRequestListener");
        Intrinsics.checkNotNullParameter(firstPartyHostDetector, "firstPartyHostDetector");
        Intrinsics.checkNotNullParameter(rumResourceAttributesProvider, "rumResourceAttributesProvider");
        Intrinsics.checkNotNullParameter(function0, "localTracerFactory");
        this.f3391a = rumResourceAttributesProvider;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DatadogInterceptor(List list, TracedRequestListener tracedRequestListener, RumResourceAttributesProvider rumResourceAttributesProvider, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, (i & 2) != 0 ? new NoOpTracedRequestListener() : tracedRequestListener, (i & 4) != 0 ? new NoOpRumResourceAttributesProvider() : rumResourceAttributesProvider);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public DatadogInterceptor(List<String> list, TracedRequestListener tracedRequestListener, RumResourceAttributesProvider rumResourceAttributesProvider) {
        this(list, tracedRequestListener, CoreFeature.INSTANCE.getFirstPartyHostDetector$dd_sdk_android_release(), rumResourceAttributesProvider, (Function0<? extends Tracer>) C21911.INSTANCE);
        Intrinsics.checkNotNullParameter(list, "firstPartyHosts");
        Intrinsics.checkNotNullParameter(tracedRequestListener, "tracedRequestListener");
        Intrinsics.checkNotNullParameter(rumResourceAttributesProvider, "rumResourceAttributesProvider");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DatadogInterceptor(TracedRequestListener tracedRequestListener, RumResourceAttributesProvider rumResourceAttributesProvider, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new NoOpTracedRequestListener() : tracedRequestListener, (i & 2) != 0 ? new NoOpRumResourceAttributesProvider() : rumResourceAttributesProvider);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public DatadogInterceptor(TracedRequestListener tracedRequestListener, RumResourceAttributesProvider rumResourceAttributesProvider) {
        this((List<String>) CollectionsKt.emptyList(), tracedRequestListener, CoreFeature.INSTANCE.getFirstPartyHostDetector$dd_sdk_android_release(), rumResourceAttributesProvider, (Function0<? extends Tracer>) C21922.INSTANCE);
        Intrinsics.checkNotNullParameter(tracedRequestListener, "tracedRequestListener");
        Intrinsics.checkNotNullParameter(rumResourceAttributesProvider, "rumResourceAttributesProvider");
    }

    public Response intercept(Interceptor.Chain chain) {
        Intrinsics.checkNotNullParameter(chain, "chain");
        if (RumFeature.INSTANCE.isInitialized()) {
            Request request = chain.request();
            String httpUrl = request.url().toString();
            Intrinsics.checkNotNullExpressionValue(httpUrl, "request.url().toString()");
            String method = request.method();
            Intrinsics.checkNotNullExpressionValue(request, "request");
            String identifyRequest = RequestUniqueIdentifierKt.identifyRequest(request);
            RumMonitor rumMonitor = GlobalRum.get();
            Intrinsics.checkNotNullExpressionValue(method, "method");
            RumMonitor.DefaultImpls.startResource$default(rumMonitor, identifyRequest, method, httpUrl, (Map) null, 8, (Object) null);
        } else {
            Logger.w$default(RuntimeUtilsKt.getDevLogger(), WARN_RUM_DISABLED, (Throwable) null, (Map) null, 6, (Object) null);
        }
        return super.intercept(chain);
    }

    /* access modifiers changed from: protected */
    public void onRequestIntercepted(Request request, Span span, Response response, Throwable th) {
        Intrinsics.checkNotNullParameter(request, "request");
        super.onRequestIntercepted(request, span, response, th);
        if (!RumFeature.INSTANCE.isInitialized()) {
            return;
        }
        if (th != null) {
            m2288a(request, th);
        } else {
            m2289a(request, response, span);
        }
    }

    public boolean canSendSpan$dd_sdk_android_release() {
        return !RumFeature.INSTANCE.isInitialized();
    }

    /* renamed from: a */
    private final void m2289a(Request request, Response response, Span span) {
        Integer num;
        String str;
        RumResourceKind rumResourceKind;
        Map map;
        String identifyRequest = RequestUniqueIdentifierKt.identifyRequest(request);
        if (response == null) {
            num = null;
        } else {
            num = Integer.valueOf(response.code());
        }
        if (response == null) {
            str = null;
        } else {
            str = response.header("Content-Type");
        }
        if (str == null) {
            rumResourceKind = RumResourceKind.NATIVE;
        } else {
            rumResourceKind = RumResourceKind.Companion.fromMimeType$dd_sdk_android_release(str);
        }
        RumResourceKind rumResourceKind2 = rumResourceKind;
        if (span == null) {
            map = MapsKt.emptyMap();
        } else {
            map = MapsKt.mapOf(TuplesKt.m42317to(RumAttributes.TRACE_ID, span.context().toTraceId()), TuplesKt.m42317to(RumAttributes.SPAN_ID, span.context().toSpanId()));
        }
        GlobalRum.get().stopResource(identifyRequest, num, m2287a(response), rumResourceKind2, MapsKt.plus(map, (Map) this.f3391a.onProvideAttributes(request, response, (Throwable) null)));
    }

    /* renamed from: a */
    private final void m2288a(Request request, Throwable th) {
        String identifyRequest = RequestUniqueIdentifierKt.identifyRequest(request);
        String method = request.method();
        String httpUrl = request.url().toString();
        Intrinsics.checkNotNullExpressionValue(httpUrl, "request.url().toString()");
        RumMonitor rumMonitor = GlobalRum.get();
        String format = String.format(Locale.US, ERROR_MSG_FORMAT, Arrays.copyOf(new Object[]{method, httpUrl}, 2));
        Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(locale, this, *args)");
        rumMonitor.stopResourceWithError(identifyRequest, (Integer) null, format, RumErrorSource.NETWORK, th, this.f3391a.onProvideAttributes(request, (Response) null, th));
    }

    /* renamed from: a */
    private final Long m2287a(Response response) {
        Long l;
        ResponseBody peekBody = response == null ? null : response.peekBody(f3390b);
        if (peekBody == null) {
            l = null;
        } else {
            l = Long.valueOf(peekBody.contentLength());
        }
        if (l != null && l.longValue() == 0) {
            return null;
        }
        return l;
    }

    @Metadata(mo175977d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, mo175978d2 = {"Lcom/datadog/android/DatadogInterceptor$Companion;", "", "()V", "ERROR_MSG_FORMAT", "", "MAX_BODY_PEEK", "", "ORIGIN_RUM", "WARN_RUM_DISABLED", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: DatadogInterceptor.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
