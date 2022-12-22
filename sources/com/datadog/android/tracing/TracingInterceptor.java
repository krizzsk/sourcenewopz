package com.datadog.android.tracing;

import com.datadog.android.core.internal.CoreFeature;
import com.datadog.android.core.internal.net.FirstPartyHostDetector;
import com.datadog.android.core.internal.utils.RuntimeUtilsKt;
import com.datadog.android.core.internal.utils.ThrowableExtKt;
import com.datadog.android.log.Logger;
import com.datadog.android.tracing.internal.TracesFeature;
import com.datadog.opentracing.DDSpan;
import com.datadog.trace.api.DDTags;
import com.datadog.trace.api.interceptor.MutableSpan;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import p242io.opentracing.Span;
import p242io.opentracing.SpanContext;
import p242io.opentracing.Tracer;
import p242io.opentracing.propagation.Format;
import p242io.opentracing.propagation.TextMapExtract;
import p242io.opentracing.propagation.TextMapExtractAdapter;
import p242io.opentracing.propagation.TextMapInject;
import p242io.opentracing.tag.Tags;
import p242io.opentracing.util.GlobalTracer;

@Metadata(mo175977d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u0000 92\u00020\u0001:\u00019B\u001f\b\u0017\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B\u0011\b\u0017\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\bB=\b\u0000\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0004\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\u0002\u0010\u000fJ\u0018\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u000e2\u0006\u0010 \u001a\u00020!H\u0002J\r\u0010\"\u001a\u00020#H\u0010¢\u0006\u0002\b$J\u001a\u0010%\u001a\u0004\u0018\u00010&2\u0006\u0010\u001f\u001a\u00020\u000e2\u0006\u0010 \u001a\u00020!H\u0002J\"\u0010'\u001a\u00020(2\u0006\u0010 \u001a\u00020!2\u0006\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010\u001eH\u0002J \u0010,\u001a\u00020(2\u0006\u0010 \u001a\u00020!2\u0006\u0010-\u001a\u00020.2\u0006\u0010+\u001a\u00020\u001eH\u0002J\u0010\u0010/\u001a\u00020*2\u0006\u00100\u001a\u000201H\u0016J\u0018\u0010/\u001a\u00020*2\u0006\u00100\u001a\u0002012\u0006\u0010 \u001a\u00020!H\u0002J \u00102\u001a\u00020*2\u0006\u00100\u001a\u0002012\u0006\u0010 \u001a\u00020!2\u0006\u0010\u001f\u001a\u00020\u000eH\u0002J\u0010\u00103\u001a\u00020#2\u0006\u0010 \u001a\u00020!H\u0002J.\u00104\u001a\u00020(2\u0006\u0010 \u001a\u00020!2\b\u0010+\u001a\u0004\u0018\u00010\u001e2\b\u0010)\u001a\u0004\u0018\u00010*2\b\u0010-\u001a\u0004\u0018\u00010.H\u0014J\b\u00105\u001a\u00020\u000eH\u0002J\n\u00106\u001a\u0004\u0018\u00010\u000eH\u0002J \u00107\u001a\u0002082\u0006\u0010 \u001a\u00020!2\u0006\u0010\u001f\u001a\u00020\u000e2\u0006\u0010+\u001a\u00020\u001eH\u0002R\u0014\u0010\t\u001a\u00020\nX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0016X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\u0004\u0018\u00010\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c¨\u0006:"}, mo175978d2 = {"Lcom/datadog/android/tracing/TracingInterceptor;", "Lokhttp3/Interceptor;", "tracedHosts", "", "", "tracedRequestListener", "Lcom/datadog/android/tracing/TracedRequestListener;", "(Ljava/util/List;Lcom/datadog/android/tracing/TracedRequestListener;)V", "(Lcom/datadog/android/tracing/TracedRequestListener;)V", "firstPartyHostDetector", "Lcom/datadog/android/core/internal/net/FirstPartyHostDetector;", "traceOrigin", "localTracerFactory", "Lkotlin/Function0;", "Lio/opentracing/Tracer;", "(Ljava/util/List;Lcom/datadog/android/tracing/TracedRequestListener;Lcom/datadog/android/core/internal/net/FirstPartyHostDetector;Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", "getFirstPartyHostDetector$dd_sdk_android_release", "()Lcom/datadog/android/core/internal/net/FirstPartyHostDetector;", "localFirstPartyHostDetector", "getLocalTracerFactory$dd_sdk_android_release", "()Lkotlin/jvm/functions/Function0;", "localTracerReference", "Ljava/util/concurrent/atomic/AtomicReference;", "getTraceOrigin$dd_sdk_android_release", "()Ljava/lang/String;", "getTracedHosts$dd_sdk_android_release", "()Ljava/util/List;", "getTracedRequestListener$dd_sdk_android_release", "()Lcom/datadog/android/tracing/TracedRequestListener;", "buildSpan", "Lio/opentracing/Span;", "tracer", "request", "Lokhttp3/Request;", "canSendSpan", "", "canSendSpan$dd_sdk_android_release", "extractParentContext", "Lio/opentracing/SpanContext;", "handleResponse", "", "response", "Lokhttp3/Response;", "span", "handleThrowable", "throwable", "", "intercept", "chain", "Lokhttp3/Interceptor$Chain;", "interceptAndTrace", "isRequestTraceable", "onRequestIntercepted", "resolveLocalTracer", "resolveTracer", "updateRequest", "Lokhttp3/Request$Builder;", "Companion", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: TracingInterceptor.kt */
public class TracingInterceptor implements Interceptor {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String HEADER_CT = "Content-Type";
    public static final String RESOURCE_NAME_404 = "404";
    public static final String SPAN_NAME = "okhttp.request";
    public static final String WARNING_DEFAULT_TRACER = "You added a TracingInterceptor to your OkHttpClient, but you didn't register any Tracer. We automatically created a local tracer for you.";
    public static final String WARNING_TRACING_DISABLED = "You added a TracingInterceptor to your OkHttpClient, but you did not enable the TracingFeature. Your requests won't be traced.";
    public static final String WARNING_TRACING_NO_HOSTS = "You added a TracingInterceptor to your OkHttpClient, but you did not specify any first party hosts. Your requests won't be traced.\nTo set a list of known hosts, you can use the Configuration.Builder::setFirstPartyHosts() method.";

    /* renamed from: a */
    private final List<String> f4044a;

    /* renamed from: b */
    private final TracedRequestListener f4045b;

    /* renamed from: c */
    private final FirstPartyHostDetector f4046c;

    /* renamed from: d */
    private final String f4047d;

    /* renamed from: e */
    private final Function0<Tracer> f4048e;

    /* renamed from: f */
    private final AtomicReference<Tracer> f4049f;

    /* renamed from: g */
    private final FirstPartyHostDetector f4050g;

    public TracingInterceptor() {
        this((TracedRequestListener) null, 1, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public TracingInterceptor(List<String> list) {
        this(list, (TracedRequestListener) null, 2, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(list, "tracedHosts");
    }

    public boolean canSendSpan$dd_sdk_android_release() {
        return true;
    }

    public TracingInterceptor(List<String> list, TracedRequestListener tracedRequestListener, FirstPartyHostDetector firstPartyHostDetector, String str, Function0<? extends Tracer> function0) {
        Intrinsics.checkNotNullParameter(list, "tracedHosts");
        Intrinsics.checkNotNullParameter(tracedRequestListener, "tracedRequestListener");
        Intrinsics.checkNotNullParameter(firstPartyHostDetector, "firstPartyHostDetector");
        Intrinsics.checkNotNullParameter(function0, "localTracerFactory");
        this.f4044a = list;
        this.f4045b = tracedRequestListener;
        this.f4046c = firstPartyHostDetector;
        this.f4047d = str;
        this.f4048e = function0;
        this.f4049f = new AtomicReference<>();
        FirstPartyHostDetector firstPartyHostDetector2 = new FirstPartyHostDetector(this.f4044a);
        this.f4050g = firstPartyHostDetector2;
        if (firstPartyHostDetector2.isEmpty() && this.f4046c.isEmpty()) {
            Logger.w$default(RuntimeUtilsKt.getDevLogger(), WARNING_TRACING_NO_HOSTS, (Throwable) null, (Map) null, 6, (Object) null);
        }
    }

    public final List<String> getTracedHosts$dd_sdk_android_release() {
        return this.f4044a;
    }

    public final TracedRequestListener getTracedRequestListener$dd_sdk_android_release() {
        return this.f4045b;
    }

    public final FirstPartyHostDetector getFirstPartyHostDetector$dd_sdk_android_release() {
        return this.f4046c;
    }

    public final String getTraceOrigin$dd_sdk_android_release() {
        return this.f4047d;
    }

    public final Function0<Tracer> getLocalTracerFactory$dd_sdk_android_release() {
        return this.f4048e;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TracingInterceptor(List list, TracedRequestListener tracedRequestListener, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, (i & 2) != 0 ? new NoOpTracedRequestListener() : tracedRequestListener);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public TracingInterceptor(List<String> list, TracedRequestListener tracedRequestListener) {
        this(list, tracedRequestListener, CoreFeature.INSTANCE.getFirstPartyHostDetector$dd_sdk_android_release(), (String) null, C22091.INSTANCE);
        Intrinsics.checkNotNullParameter(list, "tracedHosts");
        Intrinsics.checkNotNullParameter(tracedRequestListener, "tracedRequestListener");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TracingInterceptor(TracedRequestListener tracedRequestListener, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new NoOpTracedRequestListener() : tracedRequestListener);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public TracingInterceptor(TracedRequestListener tracedRequestListener) {
        this(CollectionsKt.emptyList(), tracedRequestListener, CoreFeature.INSTANCE.getFirstPartyHostDetector$dd_sdk_android_release(), (String) null, C22102.INSTANCE);
        Intrinsics.checkNotNullParameter(tracedRequestListener, "tracedRequestListener");
    }

    public Response intercept(Interceptor.Chain chain) {
        Intrinsics.checkNotNullParameter(chain, "chain");
        Tracer a = m2531a();
        Request request = chain.request();
        if (a != null) {
            Intrinsics.checkNotNullExpressionValue(request, "request");
            if (m2538a(request)) {
                return m2534a(chain, request, a);
            }
        }
        Intrinsics.checkNotNullExpressionValue(request, "request");
        return m2533a(chain, request);
    }

    /* access modifiers changed from: protected */
    public void onRequestIntercepted(Request request, Span span, Response response, Throwable th) {
        Intrinsics.checkNotNullParameter(request, "request");
        if (span != null) {
            this.f4045b.onRequestIntercepted(request, span, response, th);
        }
    }

    /* renamed from: a */
    private final boolean m2538a(Request request) {
        HttpUrl url = request.url();
        FirstPartyHostDetector firstPartyHostDetector = this.f4046c;
        Intrinsics.checkNotNullExpressionValue(url, "url");
        return firstPartyHostDetector.isFirstPartyUrl(url) || this.f4050g.isFirstPartyUrl(url);
    }

    /* renamed from: a */
    private final Response m2534a(Interceptor.Chain chain, Request request, Tracer tracer) {
        Span a = m2530a(tracer, request);
        try {
            Response proceed = chain.proceed(m2532a(request, tracer, a).build());
            Intrinsics.checkNotNullExpressionValue(proceed, "response");
            m2537a(request, proceed, a);
            return proceed;
        } catch (Throwable th) {
            m2536a(request, th, a);
            throw th;
        }
    }

    /* JADX INFO: finally extract failed */
    /* renamed from: a */
    private final Response m2533a(Interceptor.Chain chain, Request request) {
        try {
            Response proceed = chain.proceed(request);
            onRequestIntercepted(request, (Span) null, proceed, (Throwable) null);
            Intrinsics.checkNotNullExpressionValue(proceed, "response");
            return proceed;
        } catch (Throwable th) {
            onRequestIntercepted(request, (Span) null, (Response) null, th);
            throw th;
        }
    }

    /* renamed from: a */
    private final synchronized Tracer m2531a() {
        Tracer tracer;
        if (!TracesFeature.INSTANCE.getInitialized$dd_sdk_android_release().get()) {
            Logger.w$default(RuntimeUtilsKt.getDevLogger(), WARNING_TRACING_DISABLED, (Throwable) null, (Map) null, 6, (Object) null);
            tracer = null;
        } else if (GlobalTracer.isRegistered()) {
            this.f4049f.set((Object) null);
            tracer = GlobalTracer.get();
        } else {
            tracer = m2540b();
        }
        return tracer;
    }

    /* renamed from: b */
    private final Tracer m2540b() {
        if (this.f4049f.get() == null) {
            this.f4049f.compareAndSet((Object) null, this.f4048e.invoke());
            Logger.w$default(RuntimeUtilsKt.getDevLogger(), WARNING_DEFAULT_TRACER, (Throwable) null, (Map) null, 6, (Object) null);
        }
        Tracer tracer = this.f4049f.get();
        Intrinsics.checkNotNullExpressionValue(tracer, "localTracerReference.get()");
        return tracer;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v3, resolved type: io.opentracing.Span} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: com.datadog.trace.api.interceptor.MutableSpan} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final p242io.opentracing.Span m2530a(p242io.opentracing.Tracer r6, okhttp3.Request r7) {
        /*
            r5 = this;
            io.opentracing.SpanContext r0 = r5.m2539b(r6, r7)
            okhttp3.HttpUrl r1 = r7.url()
            java.lang.String r1 = r1.toString()
            java.lang.String r2 = "request.url().toString()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            java.lang.String r2 = "okhttp.request"
            io.opentracing.Tracer$SpanBuilder r6 = r6.buildSpan(r2)
            boolean r2 = r6 instanceof com.datadog.opentracing.DDTracer.DDSpanBuilder
            r3 = 0
            if (r2 == 0) goto L_0x0020
            r2 = r6
            com.datadog.opentracing.DDTracer$DDSpanBuilder r2 = (com.datadog.opentracing.DDTracer.DDSpanBuilder) r2
            goto L_0x0021
        L_0x0020:
            r2 = r3
        L_0x0021:
            if (r2 != 0) goto L_0x0024
            goto L_0x0029
        L_0x0024:
            java.lang.String r4 = r5.f4047d
            r2.withOrigin(r4)
        L_0x0029:
            io.opentracing.Tracer$SpanBuilder r6 = r6.asChildOf((p242io.opentracing.SpanContext) r0)
            io.opentracing.Span r6 = r6.start()
            boolean r0 = r6 instanceof com.datadog.trace.api.interceptor.MutableSpan
            if (r0 == 0) goto L_0x0038
            r3 = r6
            com.datadog.trace.api.interceptor.MutableSpan r3 = (com.datadog.trace.api.interceptor.MutableSpan) r3
        L_0x0038:
            if (r3 != 0) goto L_0x003b
            goto L_0x003e
        L_0x003b:
            r3.setResourceName(r1)
        L_0x003e:
            io.opentracing.tag.StringTag r0 = p242io.opentracing.tag.Tags.HTTP_URL
            java.lang.String r0 = r0.getKey()
            r6.setTag((java.lang.String) r0, (java.lang.String) r1)
            io.opentracing.tag.StringTag r0 = p242io.opentracing.tag.Tags.HTTP_METHOD
            java.lang.String r0 = r0.getKey()
            java.lang.String r7 = r7.method()
            r6.setTag((java.lang.String) r0, (java.lang.String) r7)
            java.lang.String r7 = "span"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r7)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.datadog.android.tracing.TracingInterceptor.m2530a(io.opentracing.Tracer, okhttp3.Request):io.opentracing.Span");
    }

    /* renamed from: b */
    private final SpanContext m2539b(Tracer tracer, Request request) {
        Span span = (Span) request.tag(Span.class);
        SpanContext context = span == null ? null : span.context();
        Format<TextMapExtract> format = Format.Builtin.TEXT_MAP_EXTRACT;
        Map<String, List<String>> multimap = request.headers().toMultimap();
        Intrinsics.checkNotNullExpressionValue(multimap, "request.headers().toMultimap()");
        Collection arrayList = new ArrayList(multimap.size());
        for (Map.Entry next : multimap.entrySet()) {
            Object key = next.getKey();
            Object value = next.getValue();
            Intrinsics.checkNotNullExpressionValue(value, "it.value");
            arrayList.add(TuplesKt.m42317to(key, CollectionsKt.joinToString$default((Iterable) value, ";", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null)));
        }
        SpanContext extract = tracer.extract(format, new TextMapExtractAdapter(MapsKt.toMap((List) arrayList)));
        return extract == null ? context : extract;
    }

    /* renamed from: a */
    private final Request.Builder m2532a(Request request, Tracer tracer, Span span) {
        Request.Builder newBuilder = request.newBuilder();
        tracer.inject(span.context(), Format.Builtin.TEXT_MAP_INJECT, new TextMapInject() {
            public final void put(String str, String str2) {
                TracingInterceptor.m2535a(Request.Builder.this, str, str2);
            }
        });
        Intrinsics.checkNotNullExpressionValue(newBuilder, "tracedRequestBuilder");
        return newBuilder;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m2535a(Request.Builder builder, String str, String str2) {
        builder.removeHeader(str);
        builder.addHeader(str, str2);
    }

    /* renamed from: a */
    private final void m2537a(Request request, Response response, Span span) {
        int code = response.code();
        if (span != null) {
            span.setTag(Tags.HTTP_STATUS.getKey(), (Number) Integer.valueOf(code));
        }
        boolean z = false;
        if (400 <= code && code <= 499) {
            z = true;
        }
        DDSpan dDSpan = null;
        if (z) {
            MutableSpan mutableSpan = span instanceof MutableSpan ? (MutableSpan) span : null;
            if (mutableSpan != null) {
                mutableSpan.setError(true);
            }
        }
        if (code == 404) {
            MutableSpan mutableSpan2 = span instanceof MutableSpan ? (MutableSpan) span : null;
            if (mutableSpan2 != null) {
                mutableSpan2.setResourceName(RESOURCE_NAME_404);
            }
        }
        onRequestIntercepted(request, span, response, (Throwable) null);
        if (!canSendSpan$dd_sdk_android_release()) {
            if (span instanceof DDSpan) {
                dDSpan = (DDSpan) span;
            }
            if (dDSpan != null) {
                dDSpan.drop();
            }
        } else if (span != null) {
            span.finish();
        }
    }

    /* renamed from: a */
    private final void m2536a(Request request, Throwable th, Span span) {
        DDSpan dDSpan = null;
        MutableSpan mutableSpan = span instanceof MutableSpan ? (MutableSpan) span : null;
        if (mutableSpan != null) {
            mutableSpan.setError(true);
        }
        span.setTag(DDTags.ERROR_MSG, th.getMessage());
        span.setTag(DDTags.ERROR_TYPE, th.getClass().getName());
        span.setTag("error.stack", ThrowableExtKt.loggableStackTrace(th));
        onRequestIntercepted(request, span, (Response) null, th);
        if (canSendSpan$dd_sdk_android_release()) {
            span.finish();
            return;
        }
        if (span instanceof DDSpan) {
            dDSpan = (DDSpan) span;
        }
        if (dDSpan != null) {
            dDSpan.drop();
        }
    }

    @Metadata(mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\n"}, mo175978d2 = {"Lcom/datadog/android/tracing/TracingInterceptor$Companion;", "", "()V", "HEADER_CT", "", "RESOURCE_NAME_404", "SPAN_NAME", "WARNING_DEFAULT_TRACER", "WARNING_TRACING_DISABLED", "WARNING_TRACING_NO_HOSTS", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: TracingInterceptor.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
