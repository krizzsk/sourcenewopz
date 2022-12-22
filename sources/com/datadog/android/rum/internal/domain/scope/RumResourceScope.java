package com.datadog.android.rum.internal.domain.scope;

import com.datadog.android.core.internal.CoreFeature;
import com.datadog.android.core.internal.net.FirstPartyHostDetector;
import com.datadog.android.core.internal.persistence.DataWriter;
import com.datadog.android.core.internal.utils.ThrowableExtKt;
import com.datadog.android.core.model.NetworkInfo;
import com.datadog.android.core.model.UserInfo;
import com.datadog.android.rum.GlobalRum;
import com.datadog.android.rum.RumAttributes;
import com.datadog.android.rum.RumErrorSource;
import com.datadog.android.rum.RumResourceKind;
import com.datadog.android.rum.internal.domain.RumContext;
import com.datadog.android.rum.internal.domain.Time;
import com.datadog.android.rum.internal.domain.event.ResourceTiming;
import com.datadog.android.rum.internal.domain.scope.RumRawEvent;
import com.datadog.android.rum.model.ErrorEvent;
import com.datadog.android.rum.model.ResourceEvent;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000¦\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 O2\u00020\u0001:\u0001OBS\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0014\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\n\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010J\b\u00102\u001a\u00020\u001bH\u0016J \u00103\u001a\u0004\u0018\u00010\u00012\u0006\u00104\u001a\u0002052\f\u00106\u001a\b\u0012\u0004\u0012\u00020\u000b07H\u0016J\u001e\u00108\u001a\u0002092\u0006\u00104\u001a\u00020:2\f\u00106\u001a\b\u0012\u0004\u0012\u00020\u000b07H\u0002J\u001e\u0010;\u001a\u0002092\u0006\u00104\u001a\u00020<2\f\u00106\u001a\b\u0012\u0004\u0012\u00020\u000b07H\u0002J\u001e\u0010=\u001a\u0002092\u0006\u00104\u001a\u00020>2\f\u00106\u001a\b\u0012\u0004\u0012\u00020\u000b07H\u0002J\u0010\u0010?\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004H\u0002J\n\u0010@\u001a\u0004\u0018\u00010AH\u0002J#\u0010B\u001a\u0004\u0018\u00010\u00042\b\u0010,\u001a\u0004\u0018\u00010\r2\b\u0010C\u001a\u0004\u0018\u00010DH\u0002¢\u0006\u0002\u0010EJ\n\u0010F\u001a\u0004\u0018\u00010GH\u0002J?\u0010H\u001a\u0002092\u0006\u0010I\u001a\u00020\u00042\u0006\u0010J\u001a\u00020K2\b\u0010,\u001a\u0004\u0018\u00010\r2\b\u0010C\u001a\u0004\u0018\u00010D2\f\u00106\u001a\b\u0012\u0004\u0012\u00020\u000b07H\u0002¢\u0006\u0002\u0010LJ?\u0010M\u001a\u0002092\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010,\u001a\u0004\u0018\u00010\r2\b\u0010)\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0007\u001a\u00020\b2\f\u00106\u001a\b\u0012\u0004\u0012\u00020\u000b07H\u0002¢\u0006\u0002\u0010NR\"\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0012X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\rX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001a\u001a\u00020\u001bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u000e\u0010\u001e\u001a\u00020\u001fX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001dR\u000e\u0010!\u001a\u00020\"X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\u00020\u0001X\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0014\u0010%\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001dR\u000e\u0010'\u001a\u00020(X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010)\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0004\n\u0002\u0010*R\u000e\u0010+\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u0012\u0010,\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0004\n\u0002\u0010*R\u000e\u0010-\u001a\u00020(X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010.\u001a\u0004\u0018\u00010/X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b0\u0010\u001dR\u000e\u00101\u001a\u00020(X\u000e¢\u0006\u0002\n\u0000¨\u0006P"}, mo175978d2 = {"Lcom/datadog/android/rum/internal/domain/scope/RumResourceScope;", "Lcom/datadog/android/rum/internal/domain/scope/RumScope;", "parentScope", "url", "", "method", "key", "eventTime", "Lcom/datadog/android/rum/internal/domain/Time;", "initialAttributes", "", "", "serverTimeOffsetInMs", "", "firstPartyHostDetector", "Lcom/datadog/android/core/internal/net/FirstPartyHostDetector;", "(Lcom/datadog/android/rum/internal/domain/scope/RumScope;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/datadog/android/rum/internal/domain/Time;Ljava/util/Map;JLcom/datadog/android/core/internal/net/FirstPartyHostDetector;)V", "attributes", "", "getAttributes$dd_sdk_android_release", "()Ljava/util/Map;", "eventTimestamp", "getEventTimestamp$dd_sdk_android_release", "()J", "getFirstPartyHostDetector$dd_sdk_android_release", "()Lcom/datadog/android/core/internal/net/FirstPartyHostDetector;", "initialContext", "Lcom/datadog/android/rum/internal/domain/RumContext;", "getKey$dd_sdk_android_release", "()Ljava/lang/String;", "kind", "Lcom/datadog/android/rum/RumResourceKind;", "getMethod$dd_sdk_android_release", "networkInfo", "Lcom/datadog/android/core/model/NetworkInfo;", "getParentScope$dd_sdk_android_release", "()Lcom/datadog/android/rum/internal/domain/scope/RumScope;", "resourceId", "getResourceId$dd_sdk_android_release", "sent", "", "size", "Ljava/lang/Long;", "startedNanos", "statusCode", "stopped", "timing", "Lcom/datadog/android/rum/internal/domain/event/ResourceTiming;", "getUrl$dd_sdk_android_release", "waitForTiming", "getRumContext", "handleEvent", "event", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent;", "writer", "Lcom/datadog/android/core/internal/persistence/DataWriter;", "onAddResourceTiming", "", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$AddResourceTiming;", "onStopResource", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$StopResource;", "onStopResourceWithError", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$StopResourceWithError;", "resolveDomain", "resolveErrorProvider", "Lcom/datadog/android/rum/model/ErrorEvent$Provider;", "resolveErrorType", "throwable", "", "(Ljava/lang/Long;Ljava/lang/Throwable;)Ljava/lang/String;", "resolveResourceProvider", "Lcom/datadog/android/rum/model/ResourceEvent$Provider;", "sendError", "message", "source", "Lcom/datadog/android/rum/RumErrorSource;", "(Ljava/lang/String;Lcom/datadog/android/rum/RumErrorSource;Ljava/lang/Long;Ljava/lang/Throwable;Lcom/datadog/android/core/internal/persistence/DataWriter;)V", "sendResource", "(Lcom/datadog/android/rum/RumResourceKind;Ljava/lang/Long;Ljava/lang/Long;Lcom/datadog/android/rum/internal/domain/Time;Lcom/datadog/android/core/internal/persistence/DataWriter;)V", "Companion", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: RumResourceScope.kt */
public final class RumResourceScope implements RumScope {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String ERROR_TYPE_BASED_ON_STATUS_CODE_FORMAT = "HTTP %d";

    /* renamed from: a */
    private final RumScope f3746a;

    /* renamed from: b */
    private final String f3747b;

    /* renamed from: c */
    private final String f3748c;

    /* renamed from: d */
    private final String f3749d;

    /* renamed from: e */
    private final FirstPartyHostDetector f3750e;

    /* renamed from: f */
    private final String f3751f;

    /* renamed from: g */
    private final Map<String, Object> f3752g;

    /* renamed from: h */
    private ResourceTiming f3753h;

    /* renamed from: i */
    private final RumContext f3754i = this.f3746a.getRumContext();

    /* renamed from: j */
    private final long f3755j;

    /* renamed from: k */
    private final long f3756k;

    /* renamed from: l */
    private final NetworkInfo f3757l;

    /* renamed from: m */
    private boolean f3758m;

    /* renamed from: n */
    private boolean f3759n;

    /* renamed from: o */
    private boolean f3760o;

    /* renamed from: p */
    private RumResourceKind f3761p;

    /* renamed from: q */
    private Long f3762q;

    /* renamed from: r */
    private Long f3763r;

    public RumResourceScope(RumScope rumScope, String str, String str2, String str3, Time time, Map<String, ? extends Object> map, long j, FirstPartyHostDetector firstPartyHostDetector) {
        Intrinsics.checkNotNullParameter(rumScope, "parentScope");
        Intrinsics.checkNotNullParameter(str, "url");
        Intrinsics.checkNotNullParameter(str2, "method");
        Intrinsics.checkNotNullParameter(str3, "key");
        Intrinsics.checkNotNullParameter(time, "eventTime");
        Intrinsics.checkNotNullParameter(map, "initialAttributes");
        Intrinsics.checkNotNullParameter(firstPartyHostDetector, "firstPartyHostDetector");
        this.f3746a = rumScope;
        this.f3747b = str;
        this.f3748c = str2;
        this.f3749d = str3;
        this.f3750e = firstPartyHostDetector;
        String uuid = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(uuid, "randomUUID().toString()");
        this.f3751f = uuid;
        Map<String, Object> mutableMap = MapsKt.toMutableMap(map);
        mutableMap.putAll(GlobalRum.INSTANCE.getGlobalAttributes$dd_sdk_android_release());
        Unit unit = Unit.INSTANCE;
        this.f3752g = mutableMap;
        this.f3755j = time.getTimestamp() + j;
        this.f3756k = time.getNanoTime();
        this.f3757l = CoreFeature.INSTANCE.getNetworkInfoProvider$dd_sdk_android_release().getLatestNetworkInfo();
        this.f3761p = RumResourceKind.UNKNOWN;
    }

    public final RumScope getParentScope$dd_sdk_android_release() {
        return this.f3746a;
    }

    public final String getUrl$dd_sdk_android_release() {
        return this.f3747b;
    }

    public final String getMethod$dd_sdk_android_release() {
        return this.f3748c;
    }

    public final String getKey$dd_sdk_android_release() {
        return this.f3749d;
    }

    public final FirstPartyHostDetector getFirstPartyHostDetector$dd_sdk_android_release() {
        return this.f3750e;
    }

    public final String getResourceId$dd_sdk_android_release() {
        return this.f3751f;
    }

    public final Map<String, Object> getAttributes$dd_sdk_android_release() {
        return this.f3752g;
    }

    public final long getEventTimestamp$dd_sdk_android_release() {
        return this.f3755j;
    }

    public RumScope handleEvent(RumRawEvent rumRawEvent, DataWriter<Object> dataWriter) {
        Intrinsics.checkNotNullParameter(rumRawEvent, "event");
        Intrinsics.checkNotNullParameter(dataWriter, "writer");
        if (rumRawEvent instanceof RumRawEvent.WaitForResourceTiming) {
            if (Intrinsics.areEqual((Object) this.f3749d, (Object) ((RumRawEvent.WaitForResourceTiming) rumRawEvent).getKey())) {
                this.f3759n = true;
            }
        } else if (rumRawEvent instanceof RumRawEvent.AddResourceTiming) {
            m2440a((RumRawEvent.AddResourceTiming) rumRawEvent, dataWriter);
        } else if (rumRawEvent instanceof RumRawEvent.StopResource) {
            m2441a((RumRawEvent.StopResource) rumRawEvent, dataWriter);
        } else if (rumRawEvent instanceof RumRawEvent.StopResourceWithError) {
            m2442a((RumRawEvent.StopResourceWithError) rumRawEvent, dataWriter);
        }
        if (this.f3758m) {
            return null;
        }
        return this;
    }

    public RumContext getRumContext() {
        return this.f3754i;
    }

    /* renamed from: a */
    private final void m2441a(RumRawEvent.StopResource stopResource, DataWriter<Object> dataWriter) {
        if (Intrinsics.areEqual((Object) this.f3749d, (Object) stopResource.getKey())) {
            this.f3760o = true;
            this.f3752g.putAll(stopResource.getAttributes());
            this.f3761p = stopResource.getKind();
            this.f3762q = stopResource.getStatusCode();
            this.f3763r = stopResource.getSize();
            if (!this.f3759n || this.f3753h != null) {
                m2439a(this.f3761p, stopResource.getStatusCode(), stopResource.getSize(), stopResource.getEventTime(), dataWriter);
            }
        }
    }

    /* renamed from: a */
    private final void m2440a(RumRawEvent.AddResourceTiming addResourceTiming, DataWriter<Object> dataWriter) {
        if (Intrinsics.areEqual((Object) this.f3749d, (Object) addResourceTiming.getKey())) {
            this.f3753h = addResourceTiming.getTiming();
            if (this.f3760o && !this.f3758m) {
                m2439a(this.f3761p, this.f3762q, this.f3763r, addResourceTiming.getEventTime(), dataWriter);
            }
        }
    }

    /* renamed from: a */
    private final void m2442a(RumRawEvent.StopResourceWithError stopResourceWithError, DataWriter<Object> dataWriter) {
        if (Intrinsics.areEqual((Object) this.f3749d, (Object) stopResourceWithError.getKey())) {
            this.f3752g.putAll(stopResourceWithError.getAttributes());
            m2443a(stopResourceWithError.getMessage(), stopResourceWithError.getSource(), stopResourceWithError.getStatusCode(), stopResourceWithError.getThrowable(), dataWriter);
        }
    }

    /* renamed from: a */
    private final void m2439a(RumResourceKind rumResourceKind, Long l, Long l2, Time time, DataWriter<Object> dataWriter) {
        ResourceEvent.Dns dns;
        ResourceEvent.Connect connect;
        ResourceEvent.Ssl ssl;
        ResourceEvent.FirstByte firstByte;
        ResourceEvent.Download download;
        String str;
        this.f3752g.putAll(GlobalRum.INSTANCE.getGlobalAttributes$dd_sdk_android_release());
        Object remove = this.f3752g.remove(RumAttributes.TRACE_ID);
        ResourceEvent.Action action = null;
        String obj = remove == null ? null : remove.toString();
        Object remove2 = this.f3752g.remove(RumAttributes.SPAN_ID);
        String obj2 = remove2 == null ? null : remove2.toString();
        RumContext rumContext = getRumContext();
        UserInfo userInfo = CoreFeature.INSTANCE.getUserInfoProvider$dd_sdk_android_release().getUserInfo();
        ResourceTiming resourceTiming = this.f3753h;
        if (resourceTiming == null) {
            Object remove3 = this.f3752g.remove(RumAttributes.RESOURCE_TIMINGS);
            resourceTiming = ExternalResourceTimingsKt.extractResourceTiming(remove3 instanceof Map ? (Map) remove3 : null);
        }
        long nanoTime = time.getNanoTime() - this.f3756k;
        long j = this.f3755j;
        String str2 = this.f3751f;
        ResourceEvent.ResourceType schemaType = RumEventExtKt.toSchemaType(rumResourceKind);
        String str3 = this.f3747b;
        ResourceEvent.Method method = RumEventExtKt.toMethod(this.f3748c);
        if (resourceTiming == null) {
            dns = null;
        } else {
            dns = RumEventExtKt.dns(resourceTiming);
        }
        if (resourceTiming == null) {
            connect = null;
        } else {
            connect = RumEventExtKt.connect(resourceTiming);
        }
        if (resourceTiming == null) {
            ssl = null;
        } else {
            ssl = RumEventExtKt.ssl(resourceTiming);
        }
        if (resourceTiming == null) {
            firstByte = null;
        } else {
            firstByte = RumEventExtKt.firstByte(resourceTiming);
        }
        if (resourceTiming == null) {
            download = null;
        } else {
            download = RumEventExtKt.download(resourceTiming);
        }
        ResourceEvent.Resource resource = new ResourceEvent.Resource(str2, schemaType, method, str3, l, nanoTime, l2, (ResourceEvent.Redirect) null, dns, connect, ssl, firstByte, download, m2436a(), 128, (DefaultConstructorMarker) null);
        String actionId = rumContext.getActionId();
        if (actionId != null) {
            action = new ResourceEvent.Action(actionId);
        }
        ResourceEvent.Action action2 = action;
        String viewId = rumContext.getViewId();
        String str4 = viewId != null ? viewId : "";
        String viewName = rumContext.getViewName();
        String viewUrl = rumContext.getViewUrl();
        if (viewUrl != null) {
            str = viewUrl;
        } else {
            str = "";
        }
        dataWriter.write(new ResourceEvent(j, new ResourceEvent.Application(rumContext.getApplicationId()), (String) null, new ResourceEvent.ResourceEventSession(rumContext.getSessionId(), ResourceEvent.ResourceEventSessionType.USER, (Boolean) null, 4, (DefaultConstructorMarker) null), new ResourceEvent.View(str4, (String) null, str, viewName, 2, (DefaultConstructorMarker) null), new ResourceEvent.Usr(userInfo.getId(), userInfo.getName(), userInfo.getEmail(), userInfo.getAdditionalProperties()), RumEventExtKt.toResourceConnectivity(this.f3757l), (ResourceEvent.Synthetics) null, new ResourceEvent.C2204Dd(new ResourceEvent.DdSession(ResourceEvent.Plan.PLAN_1), obj2, obj), new ResourceEvent.Context(this.f3752g), resource, action2, 132, (DefaultConstructorMarker) null));
        this.f3758m = true;
    }

    /* renamed from: a */
    private final ResourceEvent.Provider m2436a() {
        if (this.f3750e.isFirstPartyUrl(this.f3747b)) {
            return new ResourceEvent.Provider(m2438a(this.f3747b), (String) null, ResourceEvent.ProviderType.FIRST_PARTY, 2, (DefaultConstructorMarker) null);
        }
        return null;
    }

    /* renamed from: a */
    private final void m2443a(String str, RumErrorSource rumErrorSource, Long l, Throwable th, DataWriter<Object> dataWriter) {
        String str2;
        long j;
        String str3;
        Long l2 = l;
        Throwable th2 = th;
        this.f3752g.putAll(GlobalRum.INSTANCE.getGlobalAttributes$dd_sdk_android_release());
        RumContext rumContext = getRumContext();
        UserInfo userInfo = CoreFeature.INSTANCE.getUserInfoProvider$dd_sdk_android_release().getUserInfo();
        long j2 = this.f3755j;
        ErrorEvent.Source schemaSource = RumEventExtKt.toSchemaSource(rumErrorSource);
        ErrorEvent.Action action = null;
        if (th2 == null) {
            str2 = null;
        } else {
            str2 = ThrowableExtKt.loggableStackTrace(th);
        }
        String str4 = this.f3747b;
        ErrorEvent.Method errorMethod = RumEventExtKt.toErrorMethod(this.f3748c);
        if (l2 == null) {
            j = 0;
        } else {
            j = l.longValue();
        }
        ErrorEvent.Error error = new ErrorEvent.Error((String) null, str, schemaSource, str2, false, m2437a(l2, th2), (ErrorEvent.Handling) null, (String) null, ErrorEvent.SourceType.ANDROID, new ErrorEvent.Resource(errorMethod, j, str4, m2444b()), 193, (DefaultConstructorMarker) null);
        String actionId = rumContext.getActionId();
        if (actionId != null) {
            action = new ErrorEvent.Action(actionId);
        }
        ErrorEvent.Action action2 = action;
        String viewId = rumContext.getViewId();
        String str5 = viewId != null ? viewId : "";
        String viewName = rumContext.getViewName();
        String viewUrl = rumContext.getViewUrl();
        if (viewUrl != null) {
            str3 = viewUrl;
        } else {
            str3 = "";
        }
        DataWriter<Object> dataWriter2 = dataWriter;
        dataWriter2.write(new ErrorEvent(j2, new ErrorEvent.Application(rumContext.getApplicationId()), (String) null, new ErrorEvent.ErrorEventSession(rumContext.getSessionId(), ErrorEvent.ErrorEventSessionType.USER, (Boolean) null, 4, (DefaultConstructorMarker) null), new ErrorEvent.View(str5, (String) null, str3, viewName, (Boolean) null, 18, (DefaultConstructorMarker) null), new ErrorEvent.Usr(userInfo.getId(), userInfo.getName(), userInfo.getEmail(), userInfo.getAdditionalProperties()), RumEventExtKt.toErrorConnectivity(this.f3757l), (ErrorEvent.Synthetics) null, new ErrorEvent.C2202Dd(new ErrorEvent.DdSession(ErrorEvent.Plan.PLAN_1)), new ErrorEvent.Context(this.f3752g), error, action2, 132, (DefaultConstructorMarker) null));
        this.f3758m = true;
    }

    /* renamed from: b */
    private final ErrorEvent.Provider m2444b() {
        if (this.f3750e.isFirstPartyUrl(this.f3747b)) {
            return new ErrorEvent.Provider(m2438a(this.f3747b), (String) null, ErrorEvent.ProviderType.FIRST_PARTY, 2, (DefaultConstructorMarker) null);
        }
        return null;
    }

    /* renamed from: a */
    private final String m2438a(String str) {
        try {
            String host = new URL(str).getHost();
            Intrinsics.checkNotNullExpressionValue(host, "{\n            URL(url).host\n        }");
            return host;
        } catch (MalformedURLException unused) {
            return str;
        }
    }

    /* renamed from: a */
    private final String m2437a(Long l, Throwable th) {
        if (th != null) {
            return th.getClass().getCanonicalName();
        }
        if (l == null) {
            return null;
        }
        String format = String.format(Locale.US, ERROR_TYPE_BASED_ON_STATUS_CODE_FORMAT, Arrays.copyOf(new Object[]{l}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(locale, this, *args)");
        return format;
    }

    @Metadata(mo175977d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J&\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000e"}, mo175978d2 = {"Lcom/datadog/android/rum/internal/domain/scope/RumResourceScope$Companion;", "", "()V", "ERROR_TYPE_BASED_ON_STATUS_CODE_FORMAT", "", "fromEvent", "Lcom/datadog/android/rum/internal/domain/scope/RumScope;", "parentScope", "event", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$StartResource;", "firstPartyHostDetector", "Lcom/datadog/android/core/internal/net/FirstPartyHostDetector;", "timestampOffset", "", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: RumResourceScope.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final RumScope fromEvent(RumScope rumScope, RumRawEvent.StartResource startResource, FirstPartyHostDetector firstPartyHostDetector, long j) {
            Intrinsics.checkNotNullParameter(rumScope, "parentScope");
            RumRawEvent.StartResource startResource2 = startResource;
            Intrinsics.checkNotNullParameter(startResource, "event");
            Intrinsics.checkNotNullParameter(firstPartyHostDetector, "firstPartyHostDetector");
            return new RumResourceScope(rumScope, startResource.getUrl(), startResource.getMethod(), startResource.getKey(), startResource.getEventTime(), startResource.getAttributes(), j, firstPartyHostDetector);
        }
    }
}
