package com.datadog.android.rum.internal.domain.scope;

import com.datadog.android.core.internal.CoreFeature;
import com.datadog.android.core.internal.persistence.DataWriter;
import com.datadog.android.core.internal.utils.RuntimeUtilsKt;
import com.datadog.android.core.model.UserInfo;
import com.datadog.android.log.Logger;
import com.datadog.android.rum.GlobalRum;
import com.datadog.android.rum.RumActionType;
import com.datadog.android.rum.internal.domain.RumContext;
import com.datadog.android.rum.internal.domain.Time;
import com.datadog.android.rum.internal.domain.scope.RumRawEvent;
import com.datadog.android.rum.model.ActionEvent;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010%\n\u0002\b\u0017\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 `2\u00020\u0001:\u0001`B_\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\f\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u000f¢\u0006\u0002\u0010\u0012J\u0010\u0010F\u001a\u00020\u00042\u0006\u0010G\u001a\u00020\bH\u0002J\b\u0010H\u001a\u00020IH\u0016J \u0010J\u001a\u0004\u0018\u00010\u00012\u0006\u0010K\u001a\u00020L2\f\u0010M\u001a\b\u0012\u0004\u0012\u00020\r0NH\u0016J&\u0010O\u001a\u00020P2\u0006\u0010K\u001a\u00020Q2\u0006\u0010R\u001a\u00020\u000f2\f\u0010M\u001a\b\u0012\u0004\u0012\u00020\r0NH\u0002J\u0010\u0010S\u001a\u00020P2\u0006\u0010R\u001a\u00020\u000fH\u0002J\u0018\u0010T\u001a\u00020P2\u0006\u0010K\u001a\u00020U2\u0006\u0010R\u001a\u00020\u000fH\u0002J\u0018\u0010V\u001a\u00020P2\u0006\u0010K\u001a\u00020W2\u0006\u0010R\u001a\u00020\u000fH\u0002J\u0018\u0010X\u001a\u00020P2\u0006\u0010K\u001a\u00020Y2\u0006\u0010R\u001a\u00020\u000fH\u0002J\u0018\u0010Z\u001a\u00020P2\u0006\u0010K\u001a\u00020[2\u0006\u0010R\u001a\u00020\u000fH\u0002J\u001e\u0010\\\u001a\u00020P2\u0006\u0010R\u001a\u00020\u000f2\f\u0010M\u001a\b\u0012\u0004\u0012\u00020\r0NH\u0002J\u0010\u0010]\u001a\u00020P2\u0006\u0010R\u001a\u00020\u000fH\u0002J\u001e\u0010^\u001a\u00020P2\u0006\u0010_\u001a\u00020\u000f2\f\u0010M\u001a\b\u0012\u0004\u0012\u00020\r0NH\u0002R\u0014\u0010\u0013\u001a\u00020\nX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\"\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0017X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\u001f\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u001c\"\u0004\b!\u0010\u001eR\u0014\u0010\"\u001a\u00020\u000fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001cR\u000e\u0010$\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010&\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u001c\"\u0004\b(\u0010\u001eR\u000e\u0010)\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010*\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0015\"\u0004\b,\u0010-R\u001a\u0010.\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r000/X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u001a\u00103\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\u001c\"\u0004\b5\u0010\u001eR\u000e\u00106\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u001a\u00109\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\u001a\u0010>\u001a\u00020?X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\bD\u0010E¨\u0006a"}, mo175978d2 = {"Lcom/datadog/android/rum/internal/domain/scope/RumActionScope;", "Lcom/datadog/android/rum/internal/domain/scope/RumScope;", "parentScope", "waitForStop", "", "eventTime", "Lcom/datadog/android/rum/internal/domain/Time;", "initialType", "Lcom/datadog/android/rum/RumActionType;", "initialName", "", "initialAttributes", "", "", "serverTimeOffsetInMs", "", "inactivityThresholdMs", "maxDurationMs", "(Lcom/datadog/android/rum/internal/domain/scope/RumScope;ZLcom/datadog/android/rum/internal/domain/Time;Lcom/datadog/android/rum/RumActionType;Ljava/lang/String;Ljava/util/Map;JJJ)V", "actionId", "getActionId$dd_sdk_android_release", "()Ljava/lang/String;", "attributes", "", "getAttributes$dd_sdk_android_release", "()Ljava/util/Map;", "crashCount", "getCrashCount$dd_sdk_android_release", "()J", "setCrashCount$dd_sdk_android_release", "(J)V", "errorCount", "getErrorCount$dd_sdk_android_release", "setErrorCount$dd_sdk_android_release", "eventTimestamp", "getEventTimestamp$dd_sdk_android_release", "inactivityThresholdNs", "lastInteractionNanos", "longTaskCount", "getLongTaskCount$dd_sdk_android_release", "setLongTaskCount$dd_sdk_android_release", "maxDurationNs", "name", "getName$dd_sdk_android_release", "setName$dd_sdk_android_release", "(Ljava/lang/String;)V", "ongoingResourceKeys", "", "Ljava/lang/ref/WeakReference;", "getParentScope", "()Lcom/datadog/android/rum/internal/domain/scope/RumScope;", "resourceCount", "getResourceCount$dd_sdk_android_release", "setResourceCount$dd_sdk_android_release", "sent", "startedNanos", "stopped", "type", "getType$dd_sdk_android_release", "()Lcom/datadog/android/rum/RumActionType;", "setType$dd_sdk_android_release", "(Lcom/datadog/android/rum/RumActionType;)V", "viewTreeChangeCount", "", "getViewTreeChangeCount$dd_sdk_android_release", "()I", "setViewTreeChangeCount$dd_sdk_android_release", "(I)V", "getWaitForStop", "()Z", "actionCanBeSent", "actualType", "getRumContext", "Lcom/datadog/android/rum/internal/domain/RumContext;", "handleEvent", "event", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent;", "writer", "Lcom/datadog/android/core/internal/persistence/DataWriter;", "onError", "", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$AddError;", "now", "onLongTask", "onResourceError", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$StopResourceWithError;", "onStartResource", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$StartResource;", "onStopAction", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$StopAction;", "onStopResource", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$StopResource;", "onStopView", "onViewTreeChanged", "sendAction", "endNanos", "Companion", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: RumActionScope.kt */
public final class RumActionScope implements RumScope {
    public static final long ACTION_INACTIVITY_MS = 100;
    public static final long ACTION_MAX_DURATION_MS = 5000;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a */
    private final RumScope f3723a;

    /* renamed from: b */
    private final boolean f3724b;

    /* renamed from: c */
    private final long f3725c;

    /* renamed from: d */
    private final long f3726d;

    /* renamed from: e */
    private final long f3727e;

    /* renamed from: f */
    private final String f3728f;

    /* renamed from: g */
    private RumActionType f3729g;

    /* renamed from: h */
    private String f3730h;

    /* renamed from: i */
    private final long f3731i;

    /* renamed from: j */
    private long f3732j;

    /* renamed from: k */
    private final Map<String, Object> f3733k;

    /* renamed from: l */
    private final List<WeakReference<Object>> f3734l;

    /* renamed from: m */
    private long f3735m;

    /* renamed from: n */
    private long f3736n;

    /* renamed from: o */
    private long f3737o;

    /* renamed from: p */
    private long f3738p;

    /* renamed from: q */
    private int f3739q;

    /* renamed from: r */
    private boolean f3740r;

    /* renamed from: s */
    private boolean f3741s;

    public RumActionScope(RumScope rumScope, boolean z, Time time, RumActionType rumActionType, String str, Map<String, ? extends Object> map, long j, long j2, long j3) {
        Intrinsics.checkNotNullParameter(rumScope, "parentScope");
        Intrinsics.checkNotNullParameter(time, "eventTime");
        Intrinsics.checkNotNullParameter(rumActionType, "initialType");
        Intrinsics.checkNotNullParameter(str, "initialName");
        Intrinsics.checkNotNullParameter(map, "initialAttributes");
        this.f3723a = rumScope;
        this.f3724b = z;
        this.f3725c = TimeUnit.MILLISECONDS.toNanos(j2);
        this.f3726d = TimeUnit.MILLISECONDS.toNanos(j3);
        this.f3727e = time.getTimestamp() + j;
        String uuid = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(uuid, "randomUUID().toString()");
        this.f3728f = uuid;
        this.f3729g = rumActionType;
        this.f3730h = str;
        long nanoTime = time.getNanoTime();
        this.f3731i = nanoTime;
        this.f3732j = nanoTime;
        Map<String, Object> mutableMap = MapsKt.toMutableMap(map);
        mutableMap.putAll(GlobalRum.INSTANCE.getGlobalAttributes$dd_sdk_android_release());
        Unit unit = Unit.INSTANCE;
        this.f3733k = mutableMap;
        this.f3734l = new ArrayList();
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ RumActionScope(com.datadog.android.rum.internal.domain.scope.RumScope r17, boolean r18, com.datadog.android.rum.internal.domain.Time r19, com.datadog.android.rum.RumActionType r20, java.lang.String r21, java.util.Map r22, long r23, long r25, long r27, int r29, kotlin.jvm.internal.DefaultConstructorMarker r30) {
        /*
            r16 = this;
            r0 = r29
            r1 = r0 & 128(0x80, float:1.794E-43)
            if (r1 == 0) goto L_0x000a
            r1 = 100
            r12 = r1
            goto L_0x000c
        L_0x000a:
            r12 = r25
        L_0x000c:
            r0 = r0 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L_0x0014
            r0 = 5000(0x1388, double:2.4703E-320)
            r14 = r0
            goto L_0x0016
        L_0x0014:
            r14 = r27
        L_0x0016:
            r3 = r16
            r4 = r17
            r5 = r18
            r6 = r19
            r7 = r20
            r8 = r21
            r9 = r22
            r10 = r23
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r12, r14)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.datadog.android.rum.internal.domain.scope.RumActionScope.<init>(com.datadog.android.rum.internal.domain.scope.RumScope, boolean, com.datadog.android.rum.internal.domain.Time, com.datadog.android.rum.RumActionType, java.lang.String, java.util.Map, long, long, long, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final RumScope getParentScope() {
        return this.f3723a;
    }

    public final boolean getWaitForStop() {
        return this.f3724b;
    }

    public final long getEventTimestamp$dd_sdk_android_release() {
        return this.f3727e;
    }

    public final String getActionId$dd_sdk_android_release() {
        return this.f3728f;
    }

    public final RumActionType getType$dd_sdk_android_release() {
        return this.f3729g;
    }

    public final void setType$dd_sdk_android_release(RumActionType rumActionType) {
        Intrinsics.checkNotNullParameter(rumActionType, "<set-?>");
        this.f3729g = rumActionType;
    }

    public final String getName$dd_sdk_android_release() {
        return this.f3730h;
    }

    public final void setName$dd_sdk_android_release(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.f3730h = str;
    }

    public final Map<String, Object> getAttributes$dd_sdk_android_release() {
        return this.f3733k;
    }

    public final long getResourceCount$dd_sdk_android_release() {
        return this.f3735m;
    }

    public final void setResourceCount$dd_sdk_android_release(long j) {
        this.f3735m = j;
    }

    public final long getErrorCount$dd_sdk_android_release() {
        return this.f3736n;
    }

    public final void setErrorCount$dd_sdk_android_release(long j) {
        this.f3736n = j;
    }

    public final long getCrashCount$dd_sdk_android_release() {
        return this.f3737o;
    }

    public final void setCrashCount$dd_sdk_android_release(long j) {
        this.f3737o = j;
    }

    public final long getLongTaskCount$dd_sdk_android_release() {
        return this.f3738p;
    }

    public final void setLongTaskCount$dd_sdk_android_release(long j) {
        this.f3738p = j;
    }

    public final int getViewTreeChangeCount$dd_sdk_android_release() {
        return this.f3739q;
    }

    public final void setViewTreeChangeCount$dd_sdk_android_release(int i) {
        this.f3739q = i;
    }

    public RumScope handleEvent(RumRawEvent rumRawEvent, DataWriter<Object> dataWriter) {
        Intrinsics.checkNotNullParameter(rumRawEvent, "event");
        Intrinsics.checkNotNullParameter(dataWriter, "writer");
        long nanoTime = rumRawEvent.getEventTime().getNanoTime();
        boolean z = true;
        boolean z2 = nanoTime - this.f3732j > this.f3725c;
        boolean z3 = nanoTime - this.f3731i > this.f3726d;
        CollectionsKt.removeAll(this.f3734l, RumActionScope$handleEvent$1.INSTANCE);
        boolean z4 = this.f3724b && !this.f3741s;
        if (!z2 || !this.f3734l.isEmpty() || z4) {
            z = false;
        }
        if (z) {
            m2435b(this.f3732j, dataWriter);
        } else if (z3) {
            m2435b(nanoTime, dataWriter);
        } else if (rumRawEvent instanceof RumRawEvent.SendCustomActionNow) {
            m2435b(this.f3732j, dataWriter);
        } else if (rumRawEvent instanceof RumRawEvent.ViewTreeChanged) {
            m2426a(nanoTime);
        } else if (rumRawEvent instanceof RumRawEvent.StopView) {
            m2427a(nanoTime, dataWriter);
        } else if (rumRawEvent instanceof RumRawEvent.StopAction) {
            m2430a((RumRawEvent.StopAction) rumRawEvent, nanoTime);
        } else if (rumRawEvent instanceof RumRawEvent.StartResource) {
            m2429a((RumRawEvent.StartResource) rumRawEvent, nanoTime);
        } else if (rumRawEvent instanceof RumRawEvent.StopResource) {
            m2431a((RumRawEvent.StopResource) rumRawEvent, nanoTime);
        } else if (rumRawEvent instanceof RumRawEvent.AddError) {
            m2428a((RumRawEvent.AddError) rumRawEvent, nanoTime, dataWriter);
        } else if (rumRawEvent instanceof RumRawEvent.StopResourceWithError) {
            m2432a((RumRawEvent.StopResourceWithError) rumRawEvent, nanoTime);
        } else if (rumRawEvent instanceof RumRawEvent.AddLongTask) {
            m2434b(nanoTime);
        }
        if (this.f3740r) {
            return null;
        }
        return this;
    }

    public RumContext getRumContext() {
        return this.f3723a.getRumContext();
    }

    /* renamed from: a */
    private final void m2426a(long j) {
        this.f3732j = j;
        this.f3739q++;
    }

    /* renamed from: a */
    private final void m2427a(long j, DataWriter<Object> dataWriter) {
        this.f3734l.clear();
        m2435b(j, dataWriter);
    }

    /* renamed from: a */
    private final void m2430a(RumRawEvent.StopAction stopAction, long j) {
        RumActionType type = stopAction.getType();
        if (type != null) {
            setType$dd_sdk_android_release(type);
        }
        String name = stopAction.getName();
        if (name != null) {
            setName$dd_sdk_android_release(name);
        }
        this.f3733k.putAll(stopAction.getAttributes());
        this.f3741s = true;
        this.f3732j = j;
    }

    /* renamed from: a */
    private final void m2429a(RumRawEvent.StartResource startResource, long j) {
        this.f3732j = j;
        this.f3735m++;
        this.f3734l.add(new WeakReference(startResource.getKey()));
    }

    /* renamed from: a */
    private final void m2431a(RumRawEvent.StopResource stopResource, long j) {
        Object obj;
        Iterator it = this.f3734l.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (Intrinsics.areEqual(((WeakReference) obj).get(), (Object) stopResource.getKey())) {
                break;
            }
        }
        WeakReference weakReference = (WeakReference) obj;
        if (weakReference != null) {
            this.f3734l.remove(weakReference);
            this.f3732j = j;
        }
    }

    /* renamed from: a */
    private final void m2428a(RumRawEvent.AddError addError, long j, DataWriter<Object> dataWriter) {
        this.f3732j = j;
        this.f3736n++;
        if (addError.isFatal()) {
            this.f3737o++;
            m2435b(j, dataWriter);
        }
    }

    /* renamed from: a */
    private final void m2432a(RumRawEvent.StopResourceWithError stopResourceWithError, long j) {
        Object obj;
        Iterator it = this.f3734l.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (Intrinsics.areEqual(((WeakReference) obj).get(), (Object) stopResourceWithError.getKey())) {
                break;
            }
        }
        WeakReference weakReference = (WeakReference) obj;
        if (weakReference != null) {
            this.f3734l.remove(weakReference);
            this.f3732j = j;
            this.f3735m--;
            this.f3736n++;
        }
    }

    /* renamed from: b */
    private final void m2434b(long j) {
        this.f3732j = j;
        this.f3738p++;
    }

    /* renamed from: b */
    private final void m2435b(long j, DataWriter<Object> dataWriter) {
        DataWriter<Object> dataWriter2 = dataWriter;
        if (!this.f3740r) {
            RumActionType rumActionType = this.f3729g;
            String str = "";
            if (m2433a(rumActionType)) {
                this.f3733k.putAll(GlobalRum.INSTANCE.getGlobalAttributes$dd_sdk_android_release());
                RumContext rumContext = getRumContext();
                UserInfo userInfo = CoreFeature.INSTANCE.getUserInfoProvider$dd_sdk_android_release().getUserInfo();
                long j2 = this.f3727e;
                ActionEvent.Action action = new ActionEvent.Action(RumEventExtKt.toSchemaType(rumActionType), this.f3728f, Long.valueOf(Math.max(j - this.f3731i, 1)), new ActionEvent.Target(this.f3730h), new ActionEvent.Error(this.f3736n), new ActionEvent.Crash(this.f3737o), new ActionEvent.LongTask(this.f3738p), new ActionEvent.Resource(this.f3735m));
                String viewId = rumContext.getViewId();
                String str2 = viewId != null ? viewId : str;
                String viewName = rumContext.getViewName();
                String viewUrl = rumContext.getViewUrl();
                dataWriter.write(new ActionEvent(j2, new ActionEvent.Application(rumContext.getApplicationId()), (String) null, new ActionEvent.ActionEventSession(rumContext.getSessionId(), ActionEvent.ActionEventSessionType.USER, (Boolean) null, 4, (DefaultConstructorMarker) null), new ActionEvent.View(str2, (String) null, viewUrl != null ? viewUrl : str, viewName, (Boolean) null, 18, (DefaultConstructorMarker) null), new ActionEvent.Usr(userInfo.getId(), userInfo.getName(), userInfo.getEmail(), userInfo.getAdditionalProperties()), (ActionEvent.Connectivity) null, (ActionEvent.Synthetics) null, new ActionEvent.C2201Dd(new ActionEvent.DdSession(ActionEvent.Plan.PLAN_1)), new ActionEvent.Context(this.f3733k), action, 196, (DefaultConstructorMarker) null));
            } else {
                RumScope rumScope = this.f3723a;
                String viewId2 = getRumContext().getViewId();
                if (viewId2 != null) {
                    str = viewId2;
                }
                rumScope.handleEvent(new RumRawEvent.ActionDropped(str, (Time) null, 2, (DefaultConstructorMarker) null), dataWriter2);
                Logger devLogger = RuntimeUtilsKt.getDevLogger();
                Logger.i$default(devLogger, "RUM Action " + this.f3728f + " (" + rumActionType + " on " + this.f3730h + ") was dropped (no side effect was registered during its scope)", (Throwable) null, (Map) null, 6, (Object) null);
            }
            this.f3740r = true;
        }
    }

    /* renamed from: a */
    private final boolean m2433a(RumActionType rumActionType) {
        return ((this.f3735m + this.f3736n) + ((long) this.f3739q)) + this.f3738p > 0 || rumActionType == RumActionType.CUSTOM;
    }

    @Metadata(mo175977d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\f"}, mo175978d2 = {"Lcom/datadog/android/rum/internal/domain/scope/RumActionScope$Companion;", "", "()V", "ACTION_INACTIVITY_MS", "", "ACTION_MAX_DURATION_MS", "fromEvent", "Lcom/datadog/android/rum/internal/domain/scope/RumScope;", "parentScope", "event", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$StartAction;", "timestampOffset", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: RumActionScope.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final RumScope fromEvent(RumScope rumScope, RumRawEvent.StartAction startAction, long j) {
            RumScope rumScope2 = rumScope;
            Intrinsics.checkNotNullParameter(rumScope2, "parentScope");
            Intrinsics.checkNotNullParameter(startAction, "event");
            return new RumActionScope(rumScope2, startAction.getWaitForStop(), startAction.getEventTime(), startAction.getType(), startAction.getName(), startAction.getAttributes(), j, 0, 0, 384, (DefaultConstructorMarker) null);
        }
    }
}
