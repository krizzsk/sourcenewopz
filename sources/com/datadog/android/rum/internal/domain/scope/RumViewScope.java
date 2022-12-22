package com.datadog.android.rum.internal.domain.scope;

import android.app.Activity;
import android.os.Build;
import android.view.Display;
import android.view.WindowManager;
import androidx.fragment.app.Fragment;
import com.datadog.android.core.internal.CoreFeature;
import com.datadog.android.core.internal.net.FirstPartyHostDetector;
import com.datadog.android.core.internal.persistence.DataWriter;
import com.datadog.android.core.internal.time.TimeProvider;
import com.datadog.android.core.internal.utils.RuntimeUtilsKt;
import com.datadog.android.core.internal.utils.ViewUtilsKt;
import com.datadog.android.core.model.NetworkInfo;
import com.datadog.android.core.model.UserInfo;
import com.datadog.android.log.Logger;
import com.datadog.android.rum.GlobalRum;
import com.datadog.android.rum.RumActionType;
import com.datadog.android.rum.RumAttributes;
import com.datadog.android.rum.internal.domain.RumContext;
import com.datadog.android.rum.internal.domain.Time;
import com.datadog.android.rum.internal.domain.scope.RumRawEvent;
import com.datadog.android.rum.internal.vitals.VitalInfo;
import com.datadog.android.rum.internal.vitals.VitalListener;
import com.datadog.android.rum.internal.vitals.VitalMonitor;
import com.datadog.android.rum.model.ActionEvent;
import com.datadog.android.rum.model.LongTaskEvent;
import com.datadog.android.rum.model.ViewEvent;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.apache.commons.p071io.IOUtils;

@Metadata(mo175977d1 = {"\u0000\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010%\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0010\u0018\u0000 \u00012\u00020\u0001:\u0002\u0001Bc\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0014\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00040\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\u0010\u001a\u00020\u000e\u0012\u0006\u0010\u0011\u001a\u00020\u0012¢\u0006\u0002\u0010\u0013J,\u0010g\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u001c2\u0014\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00040\nH\u0002J\u001e\u0010h\u001a\u00020i2\u0006\u0010j\u001a\u00020k2\f\u0010l\u001a\b\u0012\u0004\u0012\u00020\u00040mH\u0002J\u001e\u0010n\u001a\u00020i2\u0006\u0010j\u001a\u00020k2\f\u0010l\u001a\b\u0012\u0004\u0012\u00020\u00040mH\u0002J\u001e\u0010o\u001a\u00020i2\u0006\u0010j\u001a\u00020k2\f\u0010l\u001a\b\u0012\u0004\u0012\u00020\u00040mH\u0002J\u0010\u0010p\u001a\u00020i2\u0006\u0010\u0003\u001a\u00020\u0004H\u0002J\b\u0010q\u001a\u00020rH\u0016J\u0010\u0010s\u001a\u00020\u00152\u0006\u0010j\u001a\u00020tH\u0002J \u0010u\u001a\u0004\u0018\u00010\u00012\u0006\u0010j\u001a\u00020k2\f\u0010l\u001a\b\u0012\u0004\u0012\u00020\u00040mH\u0016J\b\u0010v\u001a\u00020ZH\u0002J\u0010\u0010w\u001a\u00020i2\u0006\u0010j\u001a\u00020xH\u0002J\u001e\u0010y\u001a\u00020i2\u0006\u0010j\u001a\u00020z2\f\u0010l\u001a\b\u0012\u0004\u0012\u00020\u00040mH\u0002J\u001e\u0010{\u001a\u00020i2\u0006\u0010j\u001a\u00020|2\f\u0010l\u001a\b\u0012\u0004\u0012\u00020\u00040mH\u0002J\u001e\u0010}\u001a\u00020i2\u0006\u0010j\u001a\u00020~2\f\u0010l\u001a\b\u0012\u0004\u0012\u00020\u00040mH\u0002J\u001f\u0010\u001a\u00020i2\u0007\u0010j\u001a\u00030\u00012\f\u0010l\u001a\b\u0012\u0004\u0012\u00020\u00040mH\u0002J\u001f\u0010\u0001\u001a\u00020i2\u0006\u0010j\u001a\u00020t2\f\u0010l\u001a\b\u0012\u0004\u0012\u00020\u00040mH\u0002J\u0012\u0010\u0001\u001a\u00020i2\u0007\u0010j\u001a\u00030\u0001H\u0002J \u0010\u0001\u001a\u00020i2\u0007\u0010j\u001a\u00030\u00012\f\u0010l\u001a\b\u0012\u0004\u0012\u00020\u00040mH\u0002J \u0010\u0001\u001a\u00020i2\u0007\u0010j\u001a\u00030\u00012\f\u0010l\u001a\b\u0012\u0004\u0012\u00020\u00040mH\u0002J\u0012\u0010\u0001\u001a\u00020i2\u0007\u0010j\u001a\u00030\u0001H\u0002J \u0010\u0001\u001a\u00020i2\u0007\u0010j\u001a\u00030\u00012\f\u0010l\u001a\b\u0012\u0004\u0012\u00020\u00040mH\u0002J\u0012\u0010\u0001\u001a\u00020i2\u0007\u0010j\u001a\u00030\u0001H\u0002J \u0010\u0001\u001a\u00020i2\u0007\u0010j\u001a\u00030\u00012\f\u0010l\u001a\b\u0012\u0004\u0012\u00020\u00040mH\u0002J \u0010\u0001\u001a\u00020i2\u0007\u0010j\u001a\u00030\u00012\f\u0010l\u001a\b\u0012\u0004\u0012\u00020\u00040mH\u0002J \u0010\u0001\u001a\u00020i2\u0007\u0010j\u001a\u00030\u00012\f\u0010l\u001a\b\u0012\u0004\u0012\u00020\u00040mH\u0002J \u0010\u0001\u001a\u00020i2\u0007\u0010j\u001a\u00030\u00012\f\u0010l\u001a\b\u0012\u0004\u0012\u00020\u00040mH\u0002J \u0010\u0001\u001a\u00020i2\u0007\u0010j\u001a\u00030\u00012\f\u0010l\u001a\b\u0012\u0004\u0012\u00020\u00040mH\u0002J \u0010\u0001\u001a\u00020i2\u0007\u0010j\u001a\u00030\u00012\f\u0010l\u001a\b\u0012\u0004\u0012\u00020\u00040mH\u0002J\u001f\u0010\u0001\u001a\u00020i2\u0006\u0010j\u001a\u00020k2\f\u0010l\u001a\b\u0012\u0004\u0012\u00020\u00040mH\u0002J\u0014\u0010\u0001\u001a\u00020i2\t\u0010\u0001\u001a\u0004\u0018\u00010\u0001H\u0002R\u000e\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0001X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR \u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u001cX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\"\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u001cX\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001eR\u0012\u0010!\u001a\u0004\u0018\u00010\"X\u000e¢\u0006\u0004\n\u0002\u0010#R\u000e\u0010$\u001a\u00020%X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u000e\u0010(\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010)\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00150\u001cX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010+\u001a\u00020\u0015X\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0014\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u000e\u00100\u001a\u00020%X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\u00020\u000eX\u0004¢\u0006\b\n\u0000\u001a\u0004\b1\u0010'R\u000e\u00102\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u001a\u00103\u001a\b\u0012\u0004\u0012\u00020\u000404X\u0004¢\u0006\b\n\u0000\u001a\u0004\b5\u00106R\u0010\u00107\u001a\u0004\u0018\u000108X\u000e¢\u0006\u0002\n\u0000R\u0010\u00109\u001a\u0004\u0018\u000108X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010:\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0004\n\u0002\u0010;R\u0010\u0010<\u001a\u0004\u0018\u00010=X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020%X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\u00020\u000eX\u0004¢\u0006\b\n\u0000\u001a\u0004\b@\u0010'R\u0014\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\bA\u0010BR\u000e\u0010\u0002\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010C\u001a\u00020\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010-\"\u0004\bE\u0010FR\u001a\u0010G\u001a\u00020\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010-\"\u0004\bI\u0010FR\u001a\u0010J\u001a\u00020\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010-\"\u0004\bL\u0010FR\u001a\u0010M\u001a\u00020\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010-\"\u0004\bO\u0010FR\u001a\u0010P\u001a\u00020\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010-\"\u0004\bR\u0010FR\u000e\u0010S\u001a\u00020\"X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010T\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010U\u001a\u00020\u0015X\u0004¢\u0006\b\n\u0000\u001a\u0004\bV\u0010-R\u000e\u0010W\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010X\u001a\u00020\u0015X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010Y\u001a\u00020ZX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b[\u0010\\\"\u0004\b]\u0010^R\u0014\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\b\n\u0000\u001a\u0004\b_\u0010`R\u0014\u0010a\u001a\u00020\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\bb\u0010BR\u000e\u0010c\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010e\u001a\u00020\u00062\u0006\u0010d\u001a\u00020\u0006@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\bf\u0010B¨\u0006\u0001"}, mo175978d2 = {"Lcom/datadog/android/rum/internal/domain/scope/RumViewScope;", "Lcom/datadog/android/rum/internal/domain/scope/RumScope;", "parentScope", "key", "", "name", "", "eventTime", "Lcom/datadog/android/rum/internal/domain/Time;", "initialAttributes", "", "firstPartyHostDetector", "Lcom/datadog/android/core/internal/net/FirstPartyHostDetector;", "cpuVitalMonitor", "Lcom/datadog/android/rum/internal/vitals/VitalMonitor;", "memoryVitalMonitor", "frameRateVitalMonitor", "timeProvider", "Lcom/datadog/android/core/internal/time/TimeProvider;", "(Lcom/datadog/android/rum/internal/domain/scope/RumScope;Ljava/lang/Object;Ljava/lang/String;Lcom/datadog/android/rum/internal/domain/Time;Ljava/util/Map;Lcom/datadog/android/core/internal/net/FirstPartyHostDetector;Lcom/datadog/android/rum/internal/vitals/VitalMonitor;Lcom/datadog/android/rum/internal/vitals/VitalMonitor;Lcom/datadog/android/rum/internal/vitals/VitalMonitor;Lcom/datadog/android/core/internal/time/TimeProvider;)V", "actionCount", "", "activeActionScope", "getActiveActionScope$dd_sdk_android_release", "()Lcom/datadog/android/rum/internal/domain/scope/RumScope;", "setActiveActionScope$dd_sdk_android_release", "(Lcom/datadog/android/rum/internal/domain/scope/RumScope;)V", "activeResourceScopes", "", "getActiveResourceScopes$dd_sdk_android_release", "()Ljava/util/Map;", "attributes", "getAttributes$dd_sdk_android_release", "cpuTicks", "", "Ljava/lang/Double;", "cpuVitalListener", "Lcom/datadog/android/rum/internal/vitals/VitalListener;", "getCpuVitalMonitor$dd_sdk_android_release", "()Lcom/datadog/android/rum/internal/vitals/VitalMonitor;", "crashCount", "customTimings", "errorCount", "eventTimestamp", "getEventTimestamp$dd_sdk_android_release", "()J", "getFirstPartyHostDetector$dd_sdk_android_release", "()Lcom/datadog/android/core/internal/net/FirstPartyHostDetector;", "frameRateVitalListener", "getFrameRateVitalMonitor$dd_sdk_android_release", "frozenFrameCount", "keyRef", "Ljava/lang/ref/Reference;", "getKeyRef$dd_sdk_android_release", "()Ljava/lang/ref/Reference;", "lastFrameRateInfo", "Lcom/datadog/android/rum/internal/vitals/VitalInfo;", "lastMemoryInfo", "loadingTime", "Ljava/lang/Long;", "loadingType", "Lcom/datadog/android/rum/model/ViewEvent$LoadingType;", "longTaskCount", "memoryVitalListener", "getMemoryVitalMonitor$dd_sdk_android_release", "getName$dd_sdk_android_release", "()Ljava/lang/String;", "pendingActionCount", "getPendingActionCount$dd_sdk_android_release", "setPendingActionCount$dd_sdk_android_release", "(J)V", "pendingErrorCount", "getPendingErrorCount$dd_sdk_android_release", "setPendingErrorCount$dd_sdk_android_release", "pendingFrozenFrameCount", "getPendingFrozenFrameCount$dd_sdk_android_release", "setPendingFrozenFrameCount$dd_sdk_android_release", "pendingLongTaskCount", "getPendingLongTaskCount$dd_sdk_android_release", "setPendingLongTaskCount$dd_sdk_android_release", "pendingResourceCount", "getPendingResourceCount$dd_sdk_android_release", "setPendingResourceCount$dd_sdk_android_release", "refreshRateScale", "resourceCount", "serverTimeOffsetInMs", "getServerTimeOffsetInMs$dd_sdk_android_release", "sessionId", "startedNanos", "stopped", "", "getStopped$dd_sdk_android_release", "()Z", "setStopped$dd_sdk_android_release", "(Z)V", "getTimeProvider$dd_sdk_android_release", "()Lcom/datadog/android/core/internal/time/TimeProvider;", "url", "getUrl$dd_sdk_android_release", "version", "<set-?>", "viewId", "getViewId$dd_sdk_android_release", "addExtraAttributes", "delegateEventToAction", "", "event", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent;", "writer", "Lcom/datadog/android/core/internal/persistence/DataWriter;", "delegateEventToChildren", "delegateEventToResources", "detectRefreshRateScale", "getRumContext", "Lcom/datadog/android/rum/internal/domain/RumContext;", "getStartupTime", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$ApplicationStarted;", "handleEvent", "isViewComplete", "onActionDropped", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$ActionDropped;", "onActionSent", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$ActionSent;", "onAddCustomTiming", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$AddCustomTiming;", "onAddError", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$AddError;", "onAddLongTask", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$AddLongTask;", "onApplicationStarted", "onErrorDropped", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$ErrorDropped;", "onErrorSent", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$ErrorSent;", "onKeepAlive", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$KeepAlive;", "onLongTaskDropped", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$LongTaskDropped;", "onLongTaskSent", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$LongTaskSent;", "onResourceDropped", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$ResourceDropped;", "onResourceSent", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$ResourceSent;", "onStartAction", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$StartAction;", "onStartResource", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$StartResource;", "onStartView", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$StartView;", "onStopView", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$StopView;", "onUpdateViewLoadingTime", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$UpdateViewLoadingTime;", "sendViewUpdate", "updateActiveActionScope", "scope", "Companion", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: RumViewScope.kt */
public class RumViewScope implements RumScope {
    public static final String ACTION_DROPPED_WARNING = "RUM Action (%s on %s) was dropped, because another action is still active for the same view";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */

    /* renamed from: O */
    public static final long f3786O = TimeUnit.SECONDS.toNanos(1);
    /* access modifiers changed from: private */

    /* renamed from: P */
    public static final long f3787P = TimeUnit.MILLISECONDS.toNanos(700);
    public static final String RUM_BACKGROUND_VIEW_NAME = "Background";
    public static final String RUM_BACKGROUND_VIEW_URL = "com/datadog/background/view";
    public static final int SLOW_RENDERED_THRESHOLD_FPS = 55;

    /* renamed from: A */
    private long f3788A;

    /* renamed from: B */
    private long f3789B;

    /* renamed from: C */
    private long f3790C;

    /* renamed from: D */
    private Long f3791D;

    /* renamed from: E */
    private ViewEvent.LoadingType f3792E;

    /* renamed from: F */
    private final Map<String, Long> f3793F;

    /* renamed from: G */
    private boolean f3794G;
    /* access modifiers changed from: private */

    /* renamed from: H */
    public Double f3795H;

    /* renamed from: I */
    private VitalListener f3796I;
    /* access modifiers changed from: private */

    /* renamed from: J */
    public VitalInfo f3797J;

    /* renamed from: K */
    private VitalListener f3798K;

    /* renamed from: L */
    private double f3799L;
    /* access modifiers changed from: private */

    /* renamed from: M */
    public VitalInfo f3800M;

    /* renamed from: N */
    private VitalListener f3801N;

    /* renamed from: a */
    private final RumScope f3802a;

    /* renamed from: b */
    private final String f3803b;

    /* renamed from: c */
    private final FirstPartyHostDetector f3804c;

    /* renamed from: d */
    private final VitalMonitor f3805d;

    /* renamed from: e */
    private final VitalMonitor f3806e;

    /* renamed from: f */
    private final VitalMonitor f3807f;

    /* renamed from: g */
    private final TimeProvider f3808g;

    /* renamed from: h */
    private final String f3809h;

    /* renamed from: i */
    private final Reference<Object> f3810i;

    /* renamed from: j */
    private final Map<String, Object> f3811j;

    /* renamed from: k */
    private String f3812k = this.f3802a.getRumContext().getSessionId();

    /* renamed from: l */
    private String f3813l;

    /* renamed from: m */
    private final long f3814m;

    /* renamed from: n */
    private final long f3815n;

    /* renamed from: o */
    private final long f3816o;

    /* renamed from: p */
    private RumScope f3817p;

    /* renamed from: q */
    private final Map<String, RumScope> f3818q;

    /* renamed from: r */
    private long f3819r;

    /* renamed from: s */
    private long f3820s;

    /* renamed from: t */
    private long f3821t;

    /* renamed from: u */
    private long f3822u;

    /* renamed from: v */
    private long f3823v;

    /* renamed from: w */
    private long f3824w;

    /* renamed from: x */
    private long f3825x;

    /* renamed from: y */
    private long f3826y;

    /* renamed from: z */
    private long f3827z;

    public RumViewScope(RumScope rumScope, Object obj, String str, Time time, Map<String, ? extends Object> map, FirstPartyHostDetector firstPartyHostDetector, VitalMonitor vitalMonitor, VitalMonitor vitalMonitor2, VitalMonitor vitalMonitor3, TimeProvider timeProvider) {
        Object obj2 = obj;
        FirstPartyHostDetector firstPartyHostDetector2 = firstPartyHostDetector;
        VitalMonitor vitalMonitor4 = vitalMonitor;
        VitalMonitor vitalMonitor5 = vitalMonitor2;
        VitalMonitor vitalMonitor6 = vitalMonitor3;
        TimeProvider timeProvider2 = timeProvider;
        Intrinsics.checkNotNullParameter(rumScope, "parentScope");
        Intrinsics.checkNotNullParameter(obj, "key");
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(time, "eventTime");
        Intrinsics.checkNotNullParameter(map, "initialAttributes");
        Intrinsics.checkNotNullParameter(firstPartyHostDetector2, "firstPartyHostDetector");
        Intrinsics.checkNotNullParameter(vitalMonitor4, "cpuVitalMonitor");
        Intrinsics.checkNotNullParameter(vitalMonitor5, "memoryVitalMonitor");
        Intrinsics.checkNotNullParameter(vitalMonitor6, "frameRateVitalMonitor");
        Intrinsics.checkNotNullParameter(timeProvider2, "timeProvider");
        this.f3802a = rumScope;
        this.f3803b = str;
        this.f3804c = firstPartyHostDetector2;
        this.f3805d = vitalMonitor4;
        this.f3806e = vitalMonitor5;
        this.f3807f = vitalMonitor6;
        this.f3808g = timeProvider2;
        this.f3809h = StringsKt.replace$default(ViewUtilsKt.resolveViewUrl(obj), '.', (char) IOUtils.DIR_SEPARATOR_UNIX, false, 4, (Object) null);
        this.f3810i = new WeakReference(obj);
        Map<String, Object> mutableMap = MapsKt.toMutableMap(map);
        mutableMap.putAll(GlobalRum.INSTANCE.getGlobalAttributes$dd_sdk_android_release());
        Unit unit = Unit.INSTANCE;
        this.f3811j = mutableMap;
        String uuid = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(uuid, "randomUUID().toString()");
        this.f3813l = uuid;
        this.f3814m = time.getNanoTime();
        this.f3815n = this.f3808g.getServerOffsetMillis();
        this.f3816o = time.getTimestamp() + this.f3815n;
        this.f3818q = new LinkedHashMap();
        this.f3790C = 1;
        this.f3793F = new LinkedHashMap();
        this.f3796I = new RumViewScope$cpuVitalListener$1(this);
        this.f3798K = new RumViewScope$memoryVitalListener$1(this);
        this.f3799L = 1.0d;
        this.f3801N = new RumViewScope$frameRateVitalListener$1(this);
        GlobalRum.INSTANCE.updateRumContext$dd_sdk_android_release(getRumContext());
        this.f3811j.putAll(GlobalRum.INSTANCE.getGlobalAttributes$dd_sdk_android_release());
        this.f3805d.register(this.f3796I);
        this.f3806e.register(this.f3798K);
        this.f3807f.register(this.f3801N);
        m2470a(obj);
    }

    public final String getName$dd_sdk_android_release() {
        return this.f3803b;
    }

    public final FirstPartyHostDetector getFirstPartyHostDetector$dd_sdk_android_release() {
        return this.f3804c;
    }

    public final VitalMonitor getCpuVitalMonitor$dd_sdk_android_release() {
        return this.f3805d;
    }

    public final VitalMonitor getMemoryVitalMonitor$dd_sdk_android_release() {
        return this.f3806e;
    }

    public final VitalMonitor getFrameRateVitalMonitor$dd_sdk_android_release() {
        return this.f3807f;
    }

    public final TimeProvider getTimeProvider$dd_sdk_android_release() {
        return this.f3808g;
    }

    public final String getUrl$dd_sdk_android_release() {
        return this.f3809h;
    }

    public final Reference<Object> getKeyRef$dd_sdk_android_release() {
        return this.f3810i;
    }

    public final Map<String, Object> getAttributes$dd_sdk_android_release() {
        return this.f3811j;
    }

    public final String getViewId$dd_sdk_android_release() {
        return this.f3813l;
    }

    public final long getServerTimeOffsetInMs$dd_sdk_android_release() {
        return this.f3815n;
    }

    public final long getEventTimestamp$dd_sdk_android_release() {
        return this.f3816o;
    }

    public final RumScope getActiveActionScope$dd_sdk_android_release() {
        return this.f3817p;
    }

    public final void setActiveActionScope$dd_sdk_android_release(RumScope rumScope) {
        this.f3817p = rumScope;
    }

    public final Map<String, RumScope> getActiveResourceScopes$dd_sdk_android_release() {
        return this.f3818q;
    }

    public final long getPendingResourceCount$dd_sdk_android_release() {
        return this.f3825x;
    }

    public final void setPendingResourceCount$dd_sdk_android_release(long j) {
        this.f3825x = j;
    }

    public final long getPendingActionCount$dd_sdk_android_release() {
        return this.f3826y;
    }

    public final void setPendingActionCount$dd_sdk_android_release(long j) {
        this.f3826y = j;
    }

    public final long getPendingErrorCount$dd_sdk_android_release() {
        return this.f3827z;
    }

    public final void setPendingErrorCount$dd_sdk_android_release(long j) {
        this.f3827z = j;
    }

    public final long getPendingLongTaskCount$dd_sdk_android_release() {
        return this.f3788A;
    }

    public final void setPendingLongTaskCount$dd_sdk_android_release(long j) {
        this.f3788A = j;
    }

    public final long getPendingFrozenFrameCount$dd_sdk_android_release() {
        return this.f3789B;
    }

    public final void setPendingFrozenFrameCount$dd_sdk_android_release(long j) {
        this.f3789B = j;
    }

    public final boolean getStopped$dd_sdk_android_release() {
        return this.f3794G;
    }

    public final void setStopped$dd_sdk_android_release(boolean z) {
        this.f3794G = z;
    }

    public RumScope handleEvent(RumRawEvent rumRawEvent, DataWriter<Object> dataWriter) {
        Intrinsics.checkNotNullParameter(rumRawEvent, "event");
        Intrinsics.checkNotNullParameter(dataWriter, "writer");
        if (rumRawEvent instanceof RumRawEvent.ResourceSent) {
            m2462a((RumRawEvent.ResourceSent) rumRawEvent, dataWriter);
        } else if (rumRawEvent instanceof RumRawEvent.ActionSent) {
            m2451a((RumRawEvent.ActionSent) rumRawEvent, dataWriter);
        } else if (rumRawEvent instanceof RumRawEvent.ErrorSent) {
            m2457a((RumRawEvent.ErrorSent) rumRawEvent, dataWriter);
        } else if (rumRawEvent instanceof RumRawEvent.LongTaskSent) {
            m2460a((RumRawEvent.LongTaskSent) rumRawEvent, dataWriter);
        } else if (rumRawEvent instanceof RumRawEvent.ResourceDropped) {
            m2461a((RumRawEvent.ResourceDropped) rumRawEvent);
        } else if (rumRawEvent instanceof RumRawEvent.ActionDropped) {
            m2450a((RumRawEvent.ActionDropped) rumRawEvent);
        } else if (rumRawEvent instanceof RumRawEvent.ErrorDropped) {
            m2456a((RumRawEvent.ErrorDropped) rumRawEvent);
        } else if (rumRawEvent instanceof RumRawEvent.LongTaskDropped) {
            m2459a((RumRawEvent.LongTaskDropped) rumRawEvent);
        } else if (rumRawEvent instanceof RumRawEvent.StartView) {
            m2465a((RumRawEvent.StartView) rumRawEvent, dataWriter);
        } else if (rumRawEvent instanceof RumRawEvent.StopView) {
            m2466a((RumRawEvent.StopView) rumRawEvent, dataWriter);
        } else if (rumRawEvent instanceof RumRawEvent.StartAction) {
            m2463a((RumRawEvent.StartAction) rumRawEvent, dataWriter);
        } else if (rumRawEvent instanceof RumRawEvent.StartResource) {
            m2464a((RumRawEvent.StartResource) rumRawEvent, dataWriter);
        } else if (rumRawEvent instanceof RumRawEvent.AddError) {
            m2453a((RumRawEvent.AddError) rumRawEvent, dataWriter);
        } else if (rumRawEvent instanceof RumRawEvent.AddLongTask) {
            m2454a((RumRawEvent.AddLongTask) rumRawEvent, dataWriter);
        } else if (rumRawEvent instanceof RumRawEvent.ApplicationStarted) {
            m2455a((RumRawEvent.ApplicationStarted) rumRawEvent, dataWriter);
        } else if (rumRawEvent instanceof RumRawEvent.UpdateViewLoadingTime) {
            m2467a((RumRawEvent.UpdateViewLoadingTime) rumRawEvent, dataWriter);
        } else if (rumRawEvent instanceof RumRawEvent.AddCustomTiming) {
            m2452a((RumRawEvent.AddCustomTiming) rumRawEvent, dataWriter);
        } else if (rumRawEvent instanceof RumRawEvent.KeepAlive) {
            m2458a((RumRawEvent.KeepAlive) rumRawEvent, dataWriter);
        } else {
            m2468a(rumRawEvent, dataWriter);
        }
        if (m2471a()) {
            return null;
        }
        return this;
    }

    public RumContext getRumContext() {
        RumContext rumContext = this.f3802a.getRumContext();
        if (!Intrinsics.areEqual((Object) rumContext.getSessionId(), (Object) this.f3812k)) {
            this.f3812k = rumContext.getSessionId();
            String uuid = UUID.randomUUID().toString();
            Intrinsics.checkNotNullExpressionValue(uuid, "randomUUID().toString()");
            this.f3813l = uuid;
        }
        String str = this.f3813l;
        String str2 = this.f3803b;
        String str3 = this.f3809h;
        RumScope rumScope = this.f3817p;
        RumActionScope rumActionScope = rumScope instanceof RumActionScope ? (RumActionScope) rumScope : null;
        return RumContext.copy$default(rumContext, (String) null, (String) null, str, str2, str3, rumActionScope == null ? null : rumActionScope.getActionId$dd_sdk_android_release(), 3, (Object) null);
    }

    /* renamed from: a */
    private final void m2465a(RumRawEvent.StartView startView, DataWriter<Object> dataWriter) {
        if (!this.f3794G) {
            this.f3794G = true;
            RumRawEvent rumRawEvent = startView;
            m2474d(rumRawEvent, dataWriter);
            m2468a(rumRawEvent, dataWriter);
        }
    }

    /* renamed from: a */
    private final void m2466a(RumRawEvent.StopView stopView, DataWriter<Object> dataWriter) {
        RumRawEvent rumRawEvent = stopView;
        m2468a(rumRawEvent, dataWriter);
        Object obj = this.f3810i.get();
        if ((Intrinsics.areEqual(stopView.getKey(), obj) || obj == null) && !this.f3794G) {
            this.f3811j.putAll(stopView.getAttributes());
            this.f3794G = true;
            m2474d(rumRawEvent, dataWriter);
        }
    }

    /* renamed from: a */
    private final void m2463a(RumRawEvent.StartAction startAction, DataWriter<Object> dataWriter) {
        m2468a((RumRawEvent) startAction, dataWriter);
        if (!this.f3794G) {
            if (this.f3817p == null) {
                m2469a(RumActionScope.Companion.fromEvent(this, startAction, this.f3815n));
                this.f3826y++;
            } else if (startAction.getType() != RumActionType.CUSTOM || startAction.getWaitForStop()) {
                Logger devLogger = RuntimeUtilsKt.getDevLogger();
                String format = String.format(Locale.US, ACTION_DROPPED_WARNING, Arrays.copyOf(new Object[]{startAction.getType(), startAction.getName()}, 2));
                Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(locale, this, *args)");
                Logger.w$default(devLogger, format, (Throwable) null, (Map) null, 6, (Object) null);
            } else {
                RumScope fromEvent = RumActionScope.Companion.fromEvent(this, startAction, this.f3815n);
                this.f3826y++;
                fromEvent.handleEvent(new RumRawEvent.SendCustomActionNow((Time) null, 1, (DefaultConstructorMarker) null), dataWriter);
            }
        }
    }

    /* renamed from: a */
    private final void m2464a(RumRawEvent.StartResource startResource, DataWriter<Object> dataWriter) {
        m2468a((RumRawEvent) startResource, dataWriter);
        if (!this.f3794G) {
            this.f3818q.put(startResource.getKey(), RumResourceScope.Companion.fromEvent(this, RumRawEvent.StartResource.copy$default(startResource, (String) null, (String) null, (String) null, m2449a((Map<String, ? extends Object>) startResource.getAttributes()), (Time) null, 23, (Object) null), this.f3804c, this.f3815n));
            this.f3825x++;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0082  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x009b  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00bd  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00d1  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0100  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x010d  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x010f  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x011b  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x011d  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x018f  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x019d  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void m2453a(com.datadog.android.rum.internal.domain.scope.RumRawEvent.AddError r41, com.datadog.android.core.internal.persistence.DataWriter<java.lang.Object> r42) {
        /*
            r40 = this;
            r0 = r40
            r1 = r42
            r2 = r41
            com.datadog.android.rum.internal.domain.scope.RumRawEvent r2 = (com.datadog.android.rum.internal.domain.scope.RumRawEvent) r2
            r0.m2468a((com.datadog.android.rum.internal.domain.scope.RumRawEvent) r2, (com.datadog.android.core.internal.persistence.DataWriter<java.lang.Object>) r1)
            boolean r3 = r0.f3794G
            if (r3 == 0) goto L_0x0010
            return
        L_0x0010:
            com.datadog.android.rum.internal.domain.RumContext r3 = r40.getRumContext()
            com.datadog.android.core.internal.CoreFeature r4 = com.datadog.android.core.internal.CoreFeature.INSTANCE
            com.datadog.android.log.internal.user.MutableUserInfoProvider r4 = r4.getUserInfoProvider$dd_sdk_android_release()
            com.datadog.android.core.model.UserInfo r4 = r4.getUserInfo()
            java.util.Map r5 = r41.getAttributes()
            java.util.Map r5 = r0.m2449a((java.util.Map<java.lang.String, ? extends java.lang.Object>) r5)
            java.lang.String r6 = "_dd.error.is_crash"
            java.lang.Object r6 = r5.remove(r6)
            boolean r7 = r6 instanceof java.lang.Boolean
            r8 = 0
            if (r7 == 0) goto L_0x0034
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            goto L_0x0035
        L_0x0034:
            r6 = r8
        L_0x0035:
            com.datadog.android.core.internal.CoreFeature r7 = com.datadog.android.core.internal.CoreFeature.INSTANCE
            com.datadog.android.core.internal.net.info.NetworkInfoProvider r7 = r7.getNetworkInfoProvider$dd_sdk_android_release()
            com.datadog.android.core.model.NetworkInfo r7 = r7.getLatestNetworkInfo()
            java.lang.String r9 = r41.getType()
            if (r9 != 0) goto L_0x0059
            java.lang.Throwable r9 = r41.getThrowable()
            if (r9 != 0) goto L_0x004e
        L_0x004b:
            r16 = r8
            goto L_0x005b
        L_0x004e:
            java.lang.Class r9 = r9.getClass()
            if (r9 != 0) goto L_0x0055
            goto L_0x004b
        L_0x0055:
            java.lang.String r9 = r9.getCanonicalName()
        L_0x0059:
            r16 = r9
        L_0x005b:
            java.lang.Throwable r9 = r41.getThrowable()
            java.lang.String r23 = ""
            if (r9 != 0) goto L_0x0066
        L_0x0063:
            r9 = r23
            goto L_0x006d
        L_0x0066:
            java.lang.String r9 = r9.getMessage()
            if (r9 != 0) goto L_0x006d
            goto L_0x0063
        L_0x006d:
            r10 = r9
            java.lang.CharSequence r10 = (java.lang.CharSequence) r10
            boolean r10 = kotlin.text.StringsKt.isBlank(r10)
            r11 = 1
            r10 = r10 ^ r11
            if (r10 == 0) goto L_0x009b
            java.lang.String r10 = r41.getMessage()
            boolean r10 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r10, (java.lang.Object) r9)
            if (r10 != 0) goto L_0x009b
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r12 = r41.getMessage()
            r10.append(r12)
            java.lang.String r12 = ": "
            r10.append(r12)
            r10.append(r9)
            java.lang.String r9 = r10.toString()
            goto L_0x009f
        L_0x009b:
            java.lang.String r9 = r41.getMessage()
        L_0x009f:
            r12 = r9
            com.datadog.android.rum.internal.domain.Time r9 = r41.getEventTime()
            long r9 = r9.getTimestamp()
            long r13 = r0.f3815n
            long r25 = r9 + r13
            com.datadog.android.rum.model.ErrorEvent$Error r36 = new com.datadog.android.rum.model.ErrorEvent$Error
            r9 = 0
            com.datadog.android.rum.RumErrorSource r10 = r41.getSource()
            com.datadog.android.rum.model.ErrorEvent$Source r13 = com.datadog.android.rum.internal.domain.scope.RumEventExtKt.toSchemaSource(r10)
            java.lang.String r10 = r41.getStacktrace()
            if (r10 != 0) goto L_0x00c9
            java.lang.Throwable r10 = r41.getThrowable()
            if (r10 != 0) goto L_0x00c5
            r14 = r8
            goto L_0x00ca
        L_0x00c5:
            java.lang.String r10 = com.datadog.android.core.internal.utils.ThrowableExtKt.loggableStackTrace(r10)
        L_0x00c9:
            r14 = r10
        L_0x00ca:
            boolean r10 = r41.isFatal()
            r15 = 0
            if (r10 != 0) goto L_0x00dd
            if (r6 != 0) goto L_0x00d5
            r6 = 0
            goto L_0x00d9
        L_0x00d5:
            boolean r6 = r6.booleanValue()
        L_0x00d9:
            if (r6 == 0) goto L_0x00dc
            goto L_0x00dd
        L_0x00dc:
            r11 = 0
        L_0x00dd:
            java.lang.Boolean r15 = java.lang.Boolean.valueOf(r11)
            r17 = 0
            r18 = 0
            com.datadog.android.rum.internal.RumErrorSourceType r6 = r41.getSourceType()
            com.datadog.android.rum.model.ErrorEvent$SourceType r19 = com.datadog.android.rum.internal.domain.scope.RumEventExtKt.toSchemaSourceType(r6)
            r20 = 0
            r21 = 705(0x2c1, float:9.88E-43)
            r22 = 0
            r10 = r36
            r11 = r9
            r10.<init>(r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22)
            java.lang.String r6 = r3.getActionId()
            if (r6 != 0) goto L_0x0100
            goto L_0x0105
        L_0x0100:
            com.datadog.android.rum.model.ErrorEvent$Action r8 = new com.datadog.android.rum.model.ErrorEvent$Action
            r8.<init>(r6)
        L_0x0105:
            r37 = r8
            java.lang.String r6 = r3.getViewId()
            if (r6 == 0) goto L_0x010f
            r9 = r6
            goto L_0x0111
        L_0x010f:
            r9 = r23
        L_0x0111:
            java.lang.String r12 = r3.getViewName()
            java.lang.String r6 = r3.getViewUrl()
            if (r6 == 0) goto L_0x011d
            r11 = r6
            goto L_0x011f
        L_0x011d:
            r11 = r23
        L_0x011f:
            com.datadog.android.rum.model.ErrorEvent$View r30 = new com.datadog.android.rum.model.ErrorEvent$View
            r10 = 0
            r13 = 0
            r14 = 18
            r15 = 0
            r8 = r30
            r8.<init>(r9, r10, r11, r12, r13, r14, r15)
            com.datadog.android.rum.model.ErrorEvent$Usr r6 = new com.datadog.android.rum.model.ErrorEvent$Usr
            java.lang.String r8 = r4.getId()
            java.lang.String r9 = r4.getName()
            java.lang.String r10 = r4.getEmail()
            java.util.Map r4 = r4.getAdditionalProperties()
            r6.<init>(r8, r9, r10, r4)
            com.datadog.android.rum.model.ErrorEvent$Connectivity r32 = com.datadog.android.rum.internal.domain.scope.RumEventExtKt.toErrorConnectivity(r7)
            com.datadog.android.rum.model.ErrorEvent$Application r4 = new com.datadog.android.rum.model.ErrorEvent$Application
            java.lang.String r7 = r3.getApplicationId()
            r4.<init>(r7)
            com.datadog.android.rum.model.ErrorEvent$ErrorEventSession r29 = new com.datadog.android.rum.model.ErrorEvent$ErrorEventSession
            java.lang.String r9 = r3.getSessionId()
            com.datadog.android.rum.model.ErrorEvent$ErrorEventSessionType r10 = com.datadog.android.rum.model.ErrorEvent.ErrorEventSessionType.USER
            r11 = 0
            r12 = 4
            r8 = r29
            r8.<init>(r9, r10, r11, r12, r13)
            com.datadog.android.rum.model.ErrorEvent$Context r3 = new com.datadog.android.rum.model.ErrorEvent$Context
            r3.<init>(r5)
            com.datadog.android.rum.model.ErrorEvent$Dd r5 = new com.datadog.android.rum.model.ErrorEvent$Dd
            com.datadog.android.rum.model.ErrorEvent$DdSession r7 = new com.datadog.android.rum.model.ErrorEvent$DdSession
            com.datadog.android.rum.model.ErrorEvent$Plan r8 = com.datadog.android.rum.model.ErrorEvent.Plan.PLAN_1
            r7.<init>(r8)
            r5.<init>(r7)
            com.datadog.android.rum.model.ErrorEvent r7 = new com.datadog.android.rum.model.ErrorEvent
            r28 = 0
            r33 = 0
            r38 = 132(0x84, float:1.85E-43)
            r39 = 0
            r24 = r7
            r27 = r4
            r31 = r6
            r34 = r5
            r35 = r3
            r24.<init>(r25, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39)
            r1.write(r7)
            boolean r3 = r41.isFatal()
            r4 = 1
            if (r3 == 0) goto L_0x019d
            long r6 = r0.f3821t
            long r6 = r6 + r4
            r0.f3821t = r6
            long r6 = r0.f3822u
            long r6 = r6 + r4
            r0.f3822u = r6
            r0.m2474d(r2, r1)
            goto L_0x01a2
        L_0x019d:
            long r1 = r0.f3827z
            long r1 = r1 + r4
            r0.f3827z = r1
        L_0x01a2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.datadog.android.rum.internal.domain.scope.RumViewScope.m2453a(com.datadog.android.rum.internal.domain.scope.RumRawEvent$AddError, com.datadog.android.core.internal.persistence.DataWriter):void");
    }

    /* renamed from: a */
    private final void m2452a(RumRawEvent.AddCustomTiming addCustomTiming, DataWriter<Object> dataWriter) {
        this.f3793F.put(addCustomTiming.getName(), Long.valueOf(Math.max(addCustomTiming.getEventTime().getNanoTime() - this.f3814m, 1)));
        m2474d(addCustomTiming, dataWriter);
    }

    /* renamed from: a */
    private final void m2458a(RumRawEvent.KeepAlive keepAlive, DataWriter<Object> dataWriter) {
        RumRawEvent rumRawEvent = keepAlive;
        m2468a(rumRawEvent, dataWriter);
        if (!this.f3794G) {
            m2474d(rumRawEvent, dataWriter);
        }
    }

    /* renamed from: a */
    private final void m2468a(RumRawEvent rumRawEvent, DataWriter<Object> dataWriter) {
        m2473c(rumRawEvent, dataWriter);
        m2472b(rumRawEvent, dataWriter);
    }

    /* renamed from: b */
    private final void m2472b(RumRawEvent rumRawEvent, DataWriter<Object> dataWriter) {
        RumScope rumScope = this.f3817p;
        if (rumScope != null && rumScope.handleEvent(rumRawEvent, dataWriter) == null) {
            m2469a((RumScope) null);
        }
    }

    /* renamed from: a */
    private final void m2469a(RumScope rumScope) {
        this.f3817p = rumScope;
        GlobalRum.INSTANCE.updateRumContext$dd_sdk_android_release(getRumContext());
    }

    /* renamed from: c */
    private final void m2473c(RumRawEvent rumRawEvent, DataWriter<Object> dataWriter) {
        Iterator<Map.Entry<String, RumScope>> it = this.f3818q.entrySet().iterator();
        while (it.hasNext()) {
            if (((RumScope) it.next().getValue()).handleEvent(rumRawEvent, dataWriter) == null) {
                it.remove();
            }
        }
    }

    /* renamed from: a */
    private final void m2462a(RumRawEvent.ResourceSent resourceSent, DataWriter<Object> dataWriter) {
        if (Intrinsics.areEqual((Object) resourceSent.getViewId(), (Object) this.f3813l)) {
            this.f3825x--;
            this.f3819r++;
            m2474d(resourceSent, dataWriter);
        }
    }

    /* renamed from: a */
    private final void m2451a(RumRawEvent.ActionSent actionSent, DataWriter<Object> dataWriter) {
        if (Intrinsics.areEqual((Object) actionSent.getViewId(), (Object) this.f3813l)) {
            this.f3826y--;
            this.f3820s++;
            m2474d(actionSent, dataWriter);
        }
    }

    /* renamed from: a */
    private final void m2457a(RumRawEvent.ErrorSent errorSent, DataWriter<Object> dataWriter) {
        if (Intrinsics.areEqual((Object) errorSent.getViewId(), (Object) this.f3813l)) {
            this.f3827z--;
            this.f3821t++;
            m2474d(errorSent, dataWriter);
        }
    }

    /* renamed from: a */
    private final void m2460a(RumRawEvent.LongTaskSent longTaskSent, DataWriter<Object> dataWriter) {
        if (Intrinsics.areEqual((Object) longTaskSent.getViewId(), (Object) this.f3813l)) {
            this.f3788A--;
            this.f3823v++;
            if (longTaskSent.isFrozenFrame()) {
                this.f3789B--;
                this.f3824w++;
            }
            m2474d(longTaskSent, dataWriter);
        }
    }

    /* renamed from: a */
    private final void m2461a(RumRawEvent.ResourceDropped resourceDropped) {
        if (Intrinsics.areEqual((Object) resourceDropped.getViewId(), (Object) this.f3813l)) {
            this.f3825x--;
        }
    }

    /* renamed from: a */
    private final void m2450a(RumRawEvent.ActionDropped actionDropped) {
        if (Intrinsics.areEqual((Object) actionDropped.getViewId(), (Object) this.f3813l)) {
            this.f3826y--;
        }
    }

    /* renamed from: a */
    private final void m2456a(RumRawEvent.ErrorDropped errorDropped) {
        if (Intrinsics.areEqual((Object) errorDropped.getViewId(), (Object) this.f3813l)) {
            this.f3827z--;
        }
    }

    /* renamed from: a */
    private final void m2459a(RumRawEvent.LongTaskDropped longTaskDropped) {
        if (Intrinsics.areEqual((Object) longTaskDropped.getViewId(), (Object) this.f3813l)) {
            this.f3788A--;
            if (longTaskDropped.isFrozenFrame()) {
                this.f3789B--;
            }
        }
    }

    /* renamed from: d */
    private final void m2474d(RumRawEvent rumRawEvent, DataWriter<Object> dataWriter) {
        ViewEvent.CustomTimings customTimings;
        Boolean valueOf;
        ViewEvent.FrozenFrame frozenFrame;
        Double d;
        Double d2;
        Double d3;
        Double d4;
        ViewEvent.LoadingType loadingType;
        Long l;
        RumContext rumContext;
        UserInfo userInfo;
        Double d5;
        this.f3811j.putAll(GlobalRum.INSTANCE.getGlobalAttributes$dd_sdk_android_release());
        this.f3790C++;
        long nanoTime = rumRawEvent.getEventTime().getNanoTime() - this.f3814m;
        RumContext rumContext2 = getRumContext();
        UserInfo userInfo2 = CoreFeature.INSTANCE.getUserInfoProvider$dd_sdk_android_release().getUserInfo();
        if (!this.f3793F.isEmpty()) {
            customTimings = new ViewEvent.CustomTimings(new LinkedHashMap(this.f3793F));
        } else {
            customTimings = null;
        }
        ViewEvent.CustomTimings customTimings2 = customTimings;
        VitalInfo vitalInfo = this.f3797J;
        VitalInfo vitalInfo2 = this.f3800M;
        if (vitalInfo2 == null) {
            valueOf = null;
        } else {
            valueOf = Boolean.valueOf(vitalInfo2.getMeanValue() < 55.0d);
        }
        Boolean bool = valueOf;
        long j = this.f3816o;
        String viewId = rumContext2.getViewId();
        String str = "";
        String str2 = viewId != null ? viewId : str;
        String viewName = rumContext2.getViewName();
        String str3 = viewName != null ? viewName : str;
        String viewUrl = rumContext2.getViewUrl();
        if (viewUrl != null) {
            str = viewUrl;
        }
        Long l2 = this.f3791D;
        ViewEvent.LoadingType loadingType2 = this.f3792E;
        VitalInfo vitalInfo3 = vitalInfo2;
        ViewEvent.Action action = new ViewEvent.Action(this.f3820s);
        ViewEvent.Resource resource = new ViewEvent.Resource(this.f3819r);
        ViewEvent.Error error = new ViewEvent.Error(this.f3821t);
        long j2 = j;
        ViewEvent.Crash crash = new ViewEvent.Crash(this.f3822u);
        ViewEvent.LongTask longTask = new ViewEvent.LongTask(this.f3823v);
        ViewEvent.FrozenFrame frozenFrame2 = new ViewEvent.FrozenFrame(this.f3824w);
        boolean z = true ^ this.f3794G;
        Double d6 = this.f3795H;
        if (d6 == null) {
            frozenFrame = frozenFrame2;
            d = null;
        } else {
            frozenFrame = frozenFrame2;
            d = Double.valueOf((d6.doubleValue() * ((double) f3786O)) / ((double) nanoTime));
        }
        if (vitalInfo == null) {
            d2 = null;
        } else {
            d2 = Double.valueOf(vitalInfo.getMeanValue());
        }
        if (vitalInfo == null) {
            d3 = null;
        } else {
            d3 = Double.valueOf(vitalInfo.getMaxValue());
        }
        if (vitalInfo3 == null) {
            loadingType = loadingType2;
            l = l2;
            d4 = null;
        } else {
            loadingType = loadingType2;
            l = l2;
            d4 = Double.valueOf(vitalInfo3.getMeanValue() * this.f3799L);
        }
        if (vitalInfo3 == null) {
            rumContext = rumContext2;
            userInfo = userInfo2;
            d5 = null;
        } else {
            rumContext = rumContext2;
            userInfo = userInfo2;
            d5 = Double.valueOf(vitalInfo3.getMinValue() * this.f3799L);
        }
        dataWriter.write(new ViewEvent(j2, new ViewEvent.Application(rumContext.getApplicationId()), (String) null, new ViewEvent.ViewEventSession(rumContext.getSessionId(), ViewEvent.Type.USER, (Boolean) null, 4, (DefaultConstructorMarker) null), new ViewEvent.View(str2, (String) null, str, str3, l, loadingType, nanoTime, (Long) null, (Long) null, (Long) null, (Long) null, (Number) null, (Long) null, (Long) null, (Long) null, (Long) null, customTimings2, Boolean.valueOf(z), bool, action, error, crash, longTask, frozenFrame, resource, (List) null, d2, d3, d6, d, d4, d5, 33619842, (DefaultConstructorMarker) null), new ViewEvent.Usr(userInfo.getId(), userInfo.getName(), userInfo.getEmail(), userInfo.getAdditionalProperties()), (ViewEvent.Connectivity) null, (ViewEvent.Synthetics) null, new ViewEvent.C2205Dd(new ViewEvent.DdSession(ViewEvent.Plan.PLAN_1), this.f3790C), new ViewEvent.Context(this.f3811j), 196, (DefaultConstructorMarker) null));
    }

    /* renamed from: a */
    private final Map<String, Object> m2449a(Map<String, ? extends Object> map) {
        Map<String, Object> mutableMap = MapsKt.toMutableMap(map);
        mutableMap.putAll(GlobalRum.INSTANCE.getGlobalAttributes$dd_sdk_android_release());
        return mutableMap;
    }

    /* renamed from: a */
    private final void m2467a(RumRawEvent.UpdateViewLoadingTime updateViewLoadingTime, DataWriter<Object> dataWriter) {
        if (Intrinsics.areEqual(updateViewLoadingTime.getKey(), this.f3810i.get())) {
            this.f3791D = Long.valueOf(updateViewLoadingTime.getLoadingTime());
            this.f3792E = updateViewLoadingTime.getLoadingType();
            m2474d(updateViewLoadingTime, dataWriter);
        }
    }

    /* renamed from: a */
    private final void m2455a(RumRawEvent.ApplicationStarted applicationStarted, DataWriter<Object> dataWriter) {
        String str;
        this.f3826y++;
        RumContext rumContext = getRumContext();
        UserInfo userInfo = CoreFeature.INSTANCE.getUserInfoProvider$dd_sdk_android_release().getUserInfo();
        long j = this.f3816o;
        ActionEvent.Action action = new ActionEvent.Action(ActionEvent.ActionType.APPLICATION_START, UUID.randomUUID().toString(), Long.valueOf(m2448a(applicationStarted)), (ActionEvent.Target) null, (ActionEvent.Error) null, (ActionEvent.Crash) null, (ActionEvent.LongTask) null, (ActionEvent.Resource) null, 248, (DefaultConstructorMarker) null);
        String viewId = rumContext.getViewId();
        String str2 = viewId != null ? viewId : "";
        String viewName = rumContext.getViewName();
        String viewUrl = rumContext.getViewUrl();
        if (viewUrl != null) {
            str = viewUrl;
        } else {
            str = "";
        }
        ActionEvent.View view = new ActionEvent.View(str2, (String) null, str, viewName, (Boolean) null, 18, (DefaultConstructorMarker) null);
        ActionEvent.Usr usr = new ActionEvent.Usr(userInfo.getId(), userInfo.getName(), userInfo.getEmail(), userInfo.getAdditionalProperties());
        dataWriter.write(new ActionEvent(j, new ActionEvent.Application(rumContext.getApplicationId()), (String) null, new ActionEvent.ActionEventSession(rumContext.getSessionId(), ActionEvent.ActionEventSessionType.USER, (Boolean) null, 4, (DefaultConstructorMarker) null), view, usr, (ActionEvent.Connectivity) null, (ActionEvent.Synthetics) null, new ActionEvent.C2201Dd(new ActionEvent.DdSession(ActionEvent.Plan.PLAN_1)), new ActionEvent.Context(GlobalRum.INSTANCE.getGlobalAttributes$dd_sdk_android_release()), action, 196, (DefaultConstructorMarker) null));
    }

    /* renamed from: a */
    private final long m2448a(RumRawEvent.ApplicationStarted applicationStarted) {
        return Math.max(applicationStarted.getEventTime().getNanoTime() - applicationStarted.getApplicationStartupNanos(), 1);
    }

    /* renamed from: a */
    private final void m2454a(RumRawEvent.AddLongTask addLongTask, DataWriter<Object> dataWriter) {
        String str;
        DataWriter<Object> dataWriter2 = dataWriter;
        m2468a((RumRawEvent) addLongTask, dataWriter2);
        if (!this.f3794G) {
            RumContext rumContext = getRumContext();
            UserInfo userInfo = CoreFeature.INSTANCE.getUserInfoProvider$dd_sdk_android_release().getUserInfo();
            Map<String, Object> a = m2449a((Map<String, ? extends Object>) MapsKt.mapOf(TuplesKt.m42317to(RumAttributes.LONG_TASK_TARGET, addLongTask.getTarget())));
            NetworkInfo latestNetworkInfo = CoreFeature.INSTANCE.getNetworkInfoProvider$dd_sdk_android_release().getLatestNetworkInfo();
            long timestamp = addLongTask.getEventTime().getTimestamp() + this.f3815n;
            boolean z = addLongTask.getDurationNs() > f3787P;
            long millis = timestamp - TimeUnit.NANOSECONDS.toMillis(addLongTask.getDurationNs());
            LongTaskEvent.LongTask longTask = new LongTaskEvent.LongTask((String) null, addLongTask.getDurationNs(), Boolean.valueOf(z), 1, (DefaultConstructorMarker) null);
            String actionId = rumContext.getActionId();
            LongTaskEvent.Action action = actionId == null ? null : new LongTaskEvent.Action(actionId);
            String viewId = rumContext.getViewId();
            String str2 = viewId != null ? viewId : "";
            String viewName = rumContext.getViewName();
            String viewUrl = rumContext.getViewUrl();
            if (viewUrl != null) {
                str = viewUrl;
            } else {
                str = "";
            }
            dataWriter2.write(new LongTaskEvent(millis, new LongTaskEvent.Application(rumContext.getApplicationId()), (String) null, new LongTaskEvent.LongTaskEventSession(rumContext.getSessionId(), LongTaskEvent.Type.USER, (Boolean) null, 4, (DefaultConstructorMarker) null), new LongTaskEvent.View(str2, (String) null, str, viewName, 2, (DefaultConstructorMarker) null), new LongTaskEvent.Usr(userInfo.getId(), userInfo.getName(), userInfo.getEmail(), userInfo.getAdditionalProperties()), RumEventExtKt.toLongTaskConnectivity(latestNetworkInfo), (LongTaskEvent.Synthetics) null, new LongTaskEvent.C2203Dd(new LongTaskEvent.DdSession(LongTaskEvent.Plan.PLAN_1)), new LongTaskEvent.Context(a), longTask, action, 132, (DefaultConstructorMarker) null));
            this.f3788A++;
            if (z) {
                this.f3789B++;
            }
        }
    }

    /* renamed from: a */
    private final boolean m2471a() {
        return this.f3794G && this.f3818q.isEmpty() && ((this.f3826y + this.f3825x) + this.f3827z) + this.f3788A <= 0;
    }

    /* renamed from: a */
    private final void m2470a(Object obj) {
        Activity activity;
        Display display = null;
        if (obj instanceof Activity) {
            activity = (Activity) obj;
        } else if (obj instanceof Fragment) {
            activity = ((Fragment) obj).getActivity();
        } else {
            activity = obj instanceof android.app.Fragment ? ((android.app.Fragment) obj).getActivity() : null;
        }
        if (activity != null) {
            if (Build.VERSION.SDK_INT >= 30) {
                display = activity.getDisplay();
            } else {
                Object systemService = activity.getSystemService("window");
                WindowManager windowManager = systemService instanceof WindowManager ? (WindowManager) systemService : null;
                if (windowManager != null) {
                    display = windowManager.getDefaultDisplay();
                }
            }
            if (display != null) {
                this.f3799L = 60.0d / ((double) display.getRefreshRate());
            }
        }
    }

    @Metadata(mo175977d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JE\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001cH\u0000¢\u0006\u0002\b\u001dR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bR\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eXT¢\u0006\u0002\n\u0000¨\u0006\u001e"}, mo175978d2 = {"Lcom/datadog/android/rum/internal/domain/scope/RumViewScope$Companion;", "", "()V", "ACTION_DROPPED_WARNING", "", "FROZEN_FRAME_THRESHOLD_NS", "", "getFROZEN_FRAME_THRESHOLD_NS$dd_sdk_android_release", "()J", "ONE_SECOND_NS", "getONE_SECOND_NS$dd_sdk_android_release", "RUM_BACKGROUND_VIEW_NAME", "RUM_BACKGROUND_VIEW_URL", "SLOW_RENDERED_THRESHOLD_FPS", "", "fromEvent", "Lcom/datadog/android/rum/internal/domain/scope/RumViewScope;", "parentScope", "Lcom/datadog/android/rum/internal/domain/scope/RumScope;", "event", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$StartView;", "firstPartyHostDetector", "Lcom/datadog/android/core/internal/net/FirstPartyHostDetector;", "cpuVitalMonitor", "Lcom/datadog/android/rum/internal/vitals/VitalMonitor;", "memoryVitalMonitor", "frameRateVitalMonitor", "timeProvider", "Lcom/datadog/android/core/internal/time/TimeProvider;", "fromEvent$dd_sdk_android_release", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: RumViewScope.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final long getONE_SECOND_NS$dd_sdk_android_release() {
            return RumViewScope.f3786O;
        }

        public final long getFROZEN_FRAME_THRESHOLD_NS$dd_sdk_android_release() {
            return RumViewScope.f3787P;
        }

        public final RumViewScope fromEvent$dd_sdk_android_release(RumScope rumScope, RumRawEvent.StartView startView, FirstPartyHostDetector firstPartyHostDetector, VitalMonitor vitalMonitor, VitalMonitor vitalMonitor2, VitalMonitor vitalMonitor3, TimeProvider timeProvider) {
            Intrinsics.checkNotNullParameter(rumScope, "parentScope");
            RumRawEvent.StartView startView2 = startView;
            Intrinsics.checkNotNullParameter(startView, "event");
            Intrinsics.checkNotNullParameter(firstPartyHostDetector, "firstPartyHostDetector");
            VitalMonitor vitalMonitor4 = vitalMonitor;
            Intrinsics.checkNotNullParameter(vitalMonitor4, "cpuVitalMonitor");
            VitalMonitor vitalMonitor5 = vitalMonitor2;
            Intrinsics.checkNotNullParameter(vitalMonitor5, "memoryVitalMonitor");
            VitalMonitor vitalMonitor6 = vitalMonitor3;
            Intrinsics.checkNotNullParameter(vitalMonitor6, "frameRateVitalMonitor");
            TimeProvider timeProvider2 = timeProvider;
            Intrinsics.checkNotNullParameter(timeProvider2, "timeProvider");
            return new RumViewScope(rumScope, startView.getKey(), startView.getName(), startView.getEventTime(), startView.getAttributes(), firstPartyHostDetector, vitalMonitor4, vitalMonitor5, vitalMonitor6, timeProvider2);
        }
    }
}
