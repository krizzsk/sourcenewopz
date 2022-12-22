package com.datadog.android.core.internal;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import com.datadog.android.DatadogEndpoint;
import com.datadog.android.core.configuration.BatchSize;
import com.datadog.android.core.configuration.Configuration;
import com.datadog.android.core.configuration.Credentials;
import com.datadog.android.core.configuration.UploadFrequency;
import com.datadog.android.core.internal.net.FirstPartyHostDetector;
import com.datadog.android.core.internal.net.GzipRequestInterceptor;
import com.datadog.android.core.internal.net.info.BroadcastReceiverNetworkInfoProvider;
import com.datadog.android.core.internal.net.info.CallbackNetworkInfoProvider;
import com.datadog.android.core.internal.net.info.NetworkInfoDeserializer;
import com.datadog.android.core.internal.net.info.NetworkInfoProvider;
import com.datadog.android.core.internal.net.info.NoOpNetworkInfoProvider;
import com.datadog.android.core.internal.persistence.file.FilePersistenceConfig;
import com.datadog.android.core.internal.persistence.file.advanced.ScheduledWriter;
import com.datadog.android.core.internal.persistence.file.batch.BatchFileHandler;
import com.datadog.android.core.internal.privacy.ConsentProvider;
import com.datadog.android.core.internal.privacy.NoOpConsentProvider;
import com.datadog.android.core.internal.privacy.TrackingConsentProvider;
import com.datadog.android.core.internal.system.BroadcastReceiverSystemInfoProvider;
import com.datadog.android.core.internal.system.NoOpSystemInfoProvider;
import com.datadog.android.core.internal.system.SystemInfoProvider;
import com.datadog.android.core.internal.time.KronosTimeProvider;
import com.datadog.android.core.internal.time.LoggingSyncListener;
import com.datadog.android.core.internal.time.NoOpTimeProvider;
import com.datadog.android.core.internal.time.TimeProvider;
import com.datadog.android.core.internal.utils.RuntimeUtilsKt;
import com.datadog.android.log.internal.domain.LogGenerator;
import com.datadog.android.log.internal.user.DatadogUserInfoProvider;
import com.datadog.android.log.internal.user.MutableUserInfoProvider;
import com.datadog.android.log.internal.user.NoOpMutableUserInfoProvider;
import com.datadog.android.log.internal.user.UserInfoDeserializer;
import com.datadog.android.privacy.TrackingConsent;
import com.datadog.android.rum.internal.domain.event.RumEventDeserializer;
import com.datadog.android.rum.internal.ndk.DatadogNdkCrashHandler;
import com.datadog.android.rum.internal.ndk.NdkCrashHandler;
import com.datadog.android.rum.internal.ndk.NdkCrashLogDeserializer;
import com.datadog.android.rum.internal.ndk.NdkNetworkInfoDataWriter;
import com.datadog.android.rum.internal.ndk.NdkUserInfoDataWriter;
import com.datadog.android.rum.internal.ndk.NoOpNdkCrashHandler;
import com.didi.sdk.apm.SystemUtils;
import com.lyft.kronos.AndroidClockFactory;
import com.lyft.kronos.KronosClock;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.ConnectionSpec;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;

@Metadata(mo175977d1 = {"\u0000È\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0001\u001a\u00030\u0001J\n\u0010\u0001\u001a\u00030\u0001H\u0002J\n\u0010\u0001\u001a\u00030\u0001H\u0002J\b\u0010\u0001\u001a\u00030\u0001J/\u0010\u0001\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u00020\u001a2\b\u0010\u0001\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030\u0001J\u0013\u0010\u0001\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u00020\u001aH\u0002J\u0013\u0010\u0001\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u00020\u001aH\u0002J\u001d\u0010\u0001\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u00020\u001a2\b\u0010\u0001\u001a\u00030\u0001H\u0002J\u0014\u0010\u0001\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030\u0001H\u0002J\u0013\u0010\u0001\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u00020\u001aH\u0002J\n\u0010\u0001\u001a\u00030\u0001H\u0002J\u001d\u0010\u0001\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u00020\u001a2\b\u0010\u0001\u001a\u00030\u0001H\u0002J\u0013\u0010\u0001\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u00020\u001aH\u0002J\u0014\u0010\u0001\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030\u0001H\u0002J\u0013\u0010 \u0001\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u00020\u001aH\u0002J\n\u0010¡\u0001\u001a\u00030\u0001H\u0002J\b\u0010¢\u0001\u001a\u00030\u0001R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u00020\tX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\u001f\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0015\"\u0004\b!\u0010\u0017R\u001a\u0010\"\u001a\u00020#X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u0014\u0010(\u001a\u00020)X\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u001a\u0010,\u001a\u00020-X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u001a\u00102\u001a\u000203X.¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u001a\u00108\u001a\u000209X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\u001a\u0010>\u001a\u00020?X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR\u001a\u0010D\u001a\u00020EX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR\u001a\u0010J\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010\u0015\"\u0004\bL\u0010\u0017R\u001a\u0010M\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010\u0015\"\u0004\bO\u0010\u0017R\u001a\u0010P\u001a\u00020QX.¢\u0006\u000e\n\u0000\u001a\u0004\bR\u0010S\"\u0004\bT\u0010UR\u001c\u0010V\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bW\u0010\u0015\"\u0004\bX\u0010\u0017R\u001a\u0010Y\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bZ\u0010\u0015\"\u0004\b[\u0010\u0017R\u001a\u0010\\\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b]\u0010\u0015\"\u0004\b^\u0010\u0017R\u001a\u0010_\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b`\u0010\u0015\"\u0004\ba\u0010\u0017R\u001a\u0010b\u001a\u00020cX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bd\u0010e\"\u0004\bf\u0010gR\u001a\u0010h\u001a\u00020iX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bj\u0010k\"\u0004\bl\u0010mR\u001a\u0010n\u001a\u00020oX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bp\u0010q\"\u0004\br\u0010sR\u001a\u0010t\u001a\u00020uX.¢\u0006\u000e\n\u0000\u001a\u0004\bv\u0010w\"\u0004\bx\u0010yR\u001a\u0010z\u001a\u00020{X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b|\u0010}\"\u0004\b~\u0010R \u0010\u0001\u001a\u00030\u0001X\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R\u001d\u0010\u0001\u001a\u00020\u0006X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010\u0015\"\u0005\b\u0001\u0010\u0017¨\u0006£\u0001"}, mo175978d2 = {"Lcom/datadog/android/core/internal/CoreFeature;", "", "()V", "CORE_DEFAULT_POOL_SIZE", "", "DEFAULT_SDK_VERSION", "", "DEFAULT_SOURCE_NAME", "NETWORK_TIMEOUT_MS", "", "getNETWORK_TIMEOUT_MS$dd_sdk_android_release", "()J", "THREAD_POOL_MAX_KEEP_ALIVE_MS", "batchSize", "Lcom/datadog/android/core/configuration/BatchSize;", "getBatchSize$dd_sdk_android_release", "()Lcom/datadog/android/core/configuration/BatchSize;", "setBatchSize$dd_sdk_android_release", "(Lcom/datadog/android/core/configuration/BatchSize;)V", "clientToken", "getClientToken$dd_sdk_android_release", "()Ljava/lang/String;", "setClientToken$dd_sdk_android_release", "(Ljava/lang/String;)V", "contextRef", "Ljava/lang/ref/WeakReference;", "Landroid/content/Context;", "getContextRef$dd_sdk_android_release", "()Ljava/lang/ref/WeakReference;", "setContextRef$dd_sdk_android_release", "(Ljava/lang/ref/WeakReference;)V", "envName", "getEnvName$dd_sdk_android_release", "setEnvName$dd_sdk_android_release", "firstPartyHostDetector", "Lcom/datadog/android/core/internal/net/FirstPartyHostDetector;", "getFirstPartyHostDetector$dd_sdk_android_release", "()Lcom/datadog/android/core/internal/net/FirstPartyHostDetector;", "setFirstPartyHostDetector$dd_sdk_android_release", "(Lcom/datadog/android/core/internal/net/FirstPartyHostDetector;)V", "initialized", "Ljava/util/concurrent/atomic/AtomicBoolean;", "getInitialized$dd_sdk_android_release", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "isMainProcess", "", "isMainProcess$dd_sdk_android_release", "()Z", "setMainProcess$dd_sdk_android_release", "(Z)V", "kronosClock", "Lcom/lyft/kronos/KronosClock;", "getKronosClock$dd_sdk_android_release", "()Lcom/lyft/kronos/KronosClock;", "setKronosClock$dd_sdk_android_release", "(Lcom/lyft/kronos/KronosClock;)V", "ndkCrashHandler", "Lcom/datadog/android/rum/internal/ndk/NdkCrashHandler;", "getNdkCrashHandler$dd_sdk_android_release", "()Lcom/datadog/android/rum/internal/ndk/NdkCrashHandler;", "setNdkCrashHandler$dd_sdk_android_release", "(Lcom/datadog/android/rum/internal/ndk/NdkCrashHandler;)V", "networkInfoProvider", "Lcom/datadog/android/core/internal/net/info/NetworkInfoProvider;", "getNetworkInfoProvider$dd_sdk_android_release", "()Lcom/datadog/android/core/internal/net/info/NetworkInfoProvider;", "setNetworkInfoProvider$dd_sdk_android_release", "(Lcom/datadog/android/core/internal/net/info/NetworkInfoProvider;)V", "okHttpClient", "Lokhttp3/OkHttpClient;", "getOkHttpClient$dd_sdk_android_release", "()Lokhttp3/OkHttpClient;", "setOkHttpClient$dd_sdk_android_release", "(Lokhttp3/OkHttpClient;)V", "packageName", "getPackageName$dd_sdk_android_release", "setPackageName$dd_sdk_android_release", "packageVersion", "getPackageVersion$dd_sdk_android_release", "setPackageVersion$dd_sdk_android_release", "persistenceExecutorService", "Ljava/util/concurrent/ExecutorService;", "getPersistenceExecutorService$dd_sdk_android_release", "()Ljava/util/concurrent/ExecutorService;", "setPersistenceExecutorService$dd_sdk_android_release", "(Ljava/util/concurrent/ExecutorService;)V", "rumApplicationId", "getRumApplicationId$dd_sdk_android_release", "setRumApplicationId$dd_sdk_android_release", "sdkVersion", "getSdkVersion$dd_sdk_android_release", "setSdkVersion$dd_sdk_android_release", "serviceName", "getServiceName$dd_sdk_android_release", "setServiceName$dd_sdk_android_release", "sourceName", "getSourceName$dd_sdk_android_release", "setSourceName$dd_sdk_android_release", "systemInfoProvider", "Lcom/datadog/android/core/internal/system/SystemInfoProvider;", "getSystemInfoProvider$dd_sdk_android_release", "()Lcom/datadog/android/core/internal/system/SystemInfoProvider;", "setSystemInfoProvider$dd_sdk_android_release", "(Lcom/datadog/android/core/internal/system/SystemInfoProvider;)V", "timeProvider", "Lcom/datadog/android/core/internal/time/TimeProvider;", "getTimeProvider$dd_sdk_android_release", "()Lcom/datadog/android/core/internal/time/TimeProvider;", "setTimeProvider$dd_sdk_android_release", "(Lcom/datadog/android/core/internal/time/TimeProvider;)V", "trackingConsentProvider", "Lcom/datadog/android/core/internal/privacy/ConsentProvider;", "getTrackingConsentProvider$dd_sdk_android_release", "()Lcom/datadog/android/core/internal/privacy/ConsentProvider;", "setTrackingConsentProvider$dd_sdk_android_release", "(Lcom/datadog/android/core/internal/privacy/ConsentProvider;)V", "uploadExecutorService", "Ljava/util/concurrent/ScheduledThreadPoolExecutor;", "getUploadExecutorService$dd_sdk_android_release", "()Ljava/util/concurrent/ScheduledThreadPoolExecutor;", "setUploadExecutorService$dd_sdk_android_release", "(Ljava/util/concurrent/ScheduledThreadPoolExecutor;)V", "uploadFrequency", "Lcom/datadog/android/core/configuration/UploadFrequency;", "getUploadFrequency$dd_sdk_android_release", "()Lcom/datadog/android/core/configuration/UploadFrequency;", "setUploadFrequency$dd_sdk_android_release", "(Lcom/datadog/android/core/configuration/UploadFrequency;)V", "userInfoProvider", "Lcom/datadog/android/log/internal/user/MutableUserInfoProvider;", "getUserInfoProvider$dd_sdk_android_release", "()Lcom/datadog/android/log/internal/user/MutableUserInfoProvider;", "setUserInfoProvider$dd_sdk_android_release", "(Lcom/datadog/android/log/internal/user/MutableUserInfoProvider;)V", "variant", "getVariant$dd_sdk_android_release", "setVariant$dd_sdk_android_release", "buildFilePersistenceConfig", "Lcom/datadog/android/core/internal/persistence/file/FilePersistenceConfig;", "cleanupApplicationInfo", "", "cleanupProviders", "drainAndShutdownExecutors", "initialize", "appContext", "credentials", "Lcom/datadog/android/core/configuration/Credentials;", "configuration", "Lcom/datadog/android/core/configuration/Configuration$Core;", "consent", "Lcom/datadog/android/privacy/TrackingConsent;", "initializeClockSync", "prepareNdkCrashData", "readApplicationInformation", "readConfigurationSettings", "resolveIsMainProcess", "setupExecutors", "setupInfoProviders", "setupNetworkInfoProviders", "setupOkHttpClient", "setupUserInfoProvider", "shutDownExecutors", "stop", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CoreFeature.kt */
public final class CoreFeature {
    public static final String DEFAULT_SDK_VERSION = "1.11.1";
    public static final String DEFAULT_SOURCE_NAME = "android";
    public static final CoreFeature INSTANCE = new CoreFeature();

    /* renamed from: a */
    private static final long f3414a = TimeUnit.SECONDS.toMillis(45);

    /* renamed from: b */
    private static final long f3415b = TimeUnit.SECONDS.toMillis(5);

    /* renamed from: c */
    private static final int f3416c = 1;

    /* renamed from: d */
    private static final AtomicBoolean f3417d = new AtomicBoolean(false);

    /* renamed from: e */
    private static WeakReference<Context> f3418e = new WeakReference<>((Object) null);

    /* renamed from: f */
    private static FirstPartyHostDetector f3419f = new FirstPartyHostDetector(CollectionsKt.emptyList());

    /* renamed from: g */
    private static NetworkInfoProvider f3420g = new NoOpNetworkInfoProvider();

    /* renamed from: h */
    private static SystemInfoProvider f3421h = new NoOpSystemInfoProvider();

    /* renamed from: i */
    private static TimeProvider f3422i = new NoOpTimeProvider();

    /* renamed from: j */
    private static ConsentProvider f3423j = new NoOpConsentProvider();

    /* renamed from: k */
    private static MutableUserInfoProvider f3424k = new NoOpMutableUserInfoProvider();
    public static KronosClock kronosClock;

    /* renamed from: l */
    private static OkHttpClient f3425l;

    /* renamed from: m */
    private static String f3426m = "";

    /* renamed from: n */
    private static String f3427n = "";

    /* renamed from: o */
    private static String f3428o = "";

    /* renamed from: p */
    private static String f3429p = "";
    public static ExecutorService persistenceExecutorService;

    /* renamed from: q */
    private static String f3430q = "android";

    /* renamed from: r */
    private static String f3431r = "1.11.1";

    /* renamed from: s */
    private static String f3432s;

    /* renamed from: t */
    private static boolean f3433t = true;

    /* renamed from: u */
    private static String f3434u = "";
    public static ScheduledThreadPoolExecutor uploadExecutorService;

    /* renamed from: v */
    private static String f3435v = "";

    /* renamed from: w */
    private static BatchSize f3436w = BatchSize.MEDIUM;

    /* renamed from: x */
    private static UploadFrequency f3437x = UploadFrequency.AVERAGE;

    /* renamed from: y */
    private static NdkCrashHandler f3438y = new NoOpNdkCrashHandler();

    private CoreFeature() {
    }

    static {
        OkHttpClient build = new OkHttpClient.Builder().build();
        Intrinsics.checkNotNullExpressionValue(build, "Builder().build()");
        f3425l = build;
    }

    public final long getNETWORK_TIMEOUT_MS$dd_sdk_android_release() {
        return f3414a;
    }

    public final AtomicBoolean getInitialized$dd_sdk_android_release() {
        return f3417d;
    }

    public final WeakReference<Context> getContextRef$dd_sdk_android_release() {
        return f3418e;
    }

    public final void setContextRef$dd_sdk_android_release(WeakReference<Context> weakReference) {
        Intrinsics.checkNotNullParameter(weakReference, "<set-?>");
        f3418e = weakReference;
    }

    public final FirstPartyHostDetector getFirstPartyHostDetector$dd_sdk_android_release() {
        return f3419f;
    }

    public final void setFirstPartyHostDetector$dd_sdk_android_release(FirstPartyHostDetector firstPartyHostDetector) {
        Intrinsics.checkNotNullParameter(firstPartyHostDetector, "<set-?>");
        f3419f = firstPartyHostDetector;
    }

    public final NetworkInfoProvider getNetworkInfoProvider$dd_sdk_android_release() {
        return f3420g;
    }

    public final void setNetworkInfoProvider$dd_sdk_android_release(NetworkInfoProvider networkInfoProvider) {
        Intrinsics.checkNotNullParameter(networkInfoProvider, "<set-?>");
        f3420g = networkInfoProvider;
    }

    public final SystemInfoProvider getSystemInfoProvider$dd_sdk_android_release() {
        return f3421h;
    }

    public final void setSystemInfoProvider$dd_sdk_android_release(SystemInfoProvider systemInfoProvider) {
        Intrinsics.checkNotNullParameter(systemInfoProvider, "<set-?>");
        f3421h = systemInfoProvider;
    }

    public final TimeProvider getTimeProvider$dd_sdk_android_release() {
        return f3422i;
    }

    public final void setTimeProvider$dd_sdk_android_release(TimeProvider timeProvider) {
        Intrinsics.checkNotNullParameter(timeProvider, "<set-?>");
        f3422i = timeProvider;
    }

    public final ConsentProvider getTrackingConsentProvider$dd_sdk_android_release() {
        return f3423j;
    }

    public final void setTrackingConsentProvider$dd_sdk_android_release(ConsentProvider consentProvider) {
        Intrinsics.checkNotNullParameter(consentProvider, "<set-?>");
        f3423j = consentProvider;
    }

    public final MutableUserInfoProvider getUserInfoProvider$dd_sdk_android_release() {
        return f3424k;
    }

    public final void setUserInfoProvider$dd_sdk_android_release(MutableUserInfoProvider mutableUserInfoProvider) {
        Intrinsics.checkNotNullParameter(mutableUserInfoProvider, "<set-?>");
        f3424k = mutableUserInfoProvider;
    }

    public final OkHttpClient getOkHttpClient$dd_sdk_android_release() {
        return f3425l;
    }

    public final void setOkHttpClient$dd_sdk_android_release(OkHttpClient okHttpClient) {
        Intrinsics.checkNotNullParameter(okHttpClient, "<set-?>");
        f3425l = okHttpClient;
    }

    public final KronosClock getKronosClock$dd_sdk_android_release() {
        KronosClock kronosClock2 = kronosClock;
        if (kronosClock2 != null) {
            return kronosClock2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("kronosClock");
        throw null;
    }

    public final void setKronosClock$dd_sdk_android_release(KronosClock kronosClock2) {
        Intrinsics.checkNotNullParameter(kronosClock2, "<set-?>");
        kronosClock = kronosClock2;
    }

    public final String getClientToken$dd_sdk_android_release() {
        return f3426m;
    }

    public final void setClientToken$dd_sdk_android_release(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        f3426m = str;
    }

    public final String getPackageName$dd_sdk_android_release() {
        return f3427n;
    }

    public final void setPackageName$dd_sdk_android_release(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        f3427n = str;
    }

    public final String getPackageVersion$dd_sdk_android_release() {
        return f3428o;
    }

    public final void setPackageVersion$dd_sdk_android_release(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        f3428o = str;
    }

    public final String getServiceName$dd_sdk_android_release() {
        return f3429p;
    }

    public final void setServiceName$dd_sdk_android_release(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        f3429p = str;
    }

    public final String getSourceName$dd_sdk_android_release() {
        return f3430q;
    }

    public final void setSourceName$dd_sdk_android_release(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        f3430q = str;
    }

    public final String getSdkVersion$dd_sdk_android_release() {
        return f3431r;
    }

    public final void setSdkVersion$dd_sdk_android_release(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        f3431r = str;
    }

    public final String getRumApplicationId$dd_sdk_android_release() {
        return f3432s;
    }

    public final void setRumApplicationId$dd_sdk_android_release(String str) {
        f3432s = str;
    }

    public final boolean isMainProcess$dd_sdk_android_release() {
        return f3433t;
    }

    public final void setMainProcess$dd_sdk_android_release(boolean z) {
        f3433t = z;
    }

    public final String getEnvName$dd_sdk_android_release() {
        return f3434u;
    }

    public final void setEnvName$dd_sdk_android_release(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        f3434u = str;
    }

    public final String getVariant$dd_sdk_android_release() {
        return f3435v;
    }

    public final void setVariant$dd_sdk_android_release(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        f3435v = str;
    }

    public final BatchSize getBatchSize$dd_sdk_android_release() {
        return f3436w;
    }

    public final void setBatchSize$dd_sdk_android_release(BatchSize batchSize) {
        Intrinsics.checkNotNullParameter(batchSize, "<set-?>");
        f3436w = batchSize;
    }

    public final UploadFrequency getUploadFrequency$dd_sdk_android_release() {
        return f3437x;
    }

    public final void setUploadFrequency$dd_sdk_android_release(UploadFrequency uploadFrequency) {
        Intrinsics.checkNotNullParameter(uploadFrequency, "<set-?>");
        f3437x = uploadFrequency;
    }

    public final NdkCrashHandler getNdkCrashHandler$dd_sdk_android_release() {
        return f3438y;
    }

    public final void setNdkCrashHandler$dd_sdk_android_release(NdkCrashHandler ndkCrashHandler) {
        Intrinsics.checkNotNullParameter(ndkCrashHandler, "<set-?>");
        f3438y = ndkCrashHandler;
    }

    public final ScheduledThreadPoolExecutor getUploadExecutorService$dd_sdk_android_release() {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = uploadExecutorService;
        if (scheduledThreadPoolExecutor != null) {
            return scheduledThreadPoolExecutor;
        }
        Intrinsics.throwUninitializedPropertyAccessException("uploadExecutorService");
        throw null;
    }

    public final void setUploadExecutorService$dd_sdk_android_release(ScheduledThreadPoolExecutor scheduledThreadPoolExecutor) {
        Intrinsics.checkNotNullParameter(scheduledThreadPoolExecutor, "<set-?>");
        uploadExecutorService = scheduledThreadPoolExecutor;
    }

    public final ExecutorService getPersistenceExecutorService$dd_sdk_android_release() {
        ExecutorService executorService = persistenceExecutorService;
        if (executorService != null) {
            return executorService;
        }
        Intrinsics.throwUninitializedPropertyAccessException("persistenceExecutorService");
        throw null;
    }

    public final void setPersistenceExecutorService$dd_sdk_android_release(ExecutorService executorService) {
        Intrinsics.checkNotNullParameter(executorService, "<set-?>");
        persistenceExecutorService = executorService;
    }

    public final void initialize(Context context, Credentials credentials, Configuration.Core core, TrackingConsent trackingConsent) {
        Intrinsics.checkNotNullParameter(context, "appContext");
        Intrinsics.checkNotNullParameter(credentials, "credentials");
        Intrinsics.checkNotNullParameter(core, "configuration");
        Intrinsics.checkNotNullParameter(trackingConsent, "consent");
        if (!f3417d.get()) {
            m2294a(core);
            m2292a(context, credentials);
            m2302e(context);
            m2296b(context);
            m2297b(core);
            f3419f.addKnownHosts(core.getFirstPartyHosts());
            m2290a();
            f3422i = new KronosTimeProvider(getKronosClock$dd_sdk_android_release());
            m2291a(context);
            m2293a(context, trackingConsent);
            f3417d.set(true);
        }
    }

    public final void stop() {
        if (f3417d.get()) {
            Context context = (Context) f3418e.get();
            if (context != null) {
                INSTANCE.getNetworkInfoProvider$dd_sdk_android_release().unregister(context);
                INSTANCE.getSystemInfoProvider$dd_sdk_android_release().unregister(context);
            }
            f3418e.clear();
            f3423j.unregisterAllCallbacks();
            m2298c();
            m2300d();
            m2295b();
            f3417d.set(false);
            f3438y = new NoOpNdkCrashHandler();
        }
    }

    public final FilePersistenceConfig buildFilePersistenceConfig() {
        return new FilePersistenceConfig(f3436w.getWindowDurationMs$dd_sdk_android_release(), 0, 0, 0, 0, 0, 62, (DefaultConstructorMarker) null);
    }

    public final void drainAndShutdownExecutors() {
        BlockingQueue<Runnable> queue;
        ArrayList<Runnable> arrayList = new ArrayList<>();
        ExecutorService persistenceExecutorService$dd_sdk_android_release = getPersistenceExecutorService$dd_sdk_android_release();
        ThreadPoolExecutor threadPoolExecutor = persistenceExecutorService$dd_sdk_android_release instanceof ThreadPoolExecutor ? (ThreadPoolExecutor) persistenceExecutorService$dd_sdk_android_release : null;
        if (!(threadPoolExecutor == null || (queue = threadPoolExecutor.getQueue()) == null)) {
            queue.drainTo(arrayList);
        }
        getUploadExecutorService$dd_sdk_android_release().getQueue().drainTo(arrayList);
        getPersistenceExecutorService$dd_sdk_android_release().shutdown();
        getUploadExecutorService$dd_sdk_android_release().shutdown();
        getPersistenceExecutorService$dd_sdk_android_release().awaitTermination(10, TimeUnit.SECONDS);
        getUploadExecutorService$dd_sdk_android_release().awaitTermination(10, TimeUnit.SECONDS);
        for (Runnable run : arrayList) {
            run.run();
        }
    }

    /* renamed from: a */
    private final void m2291a(Context context) {
        if (f3433t) {
            NdkCrashHandler datadogNdkCrashHandler = new DatadogNdkCrashHandler(context, getPersistenceExecutorService$dd_sdk_android_release(), new LogGenerator(f3429p, DatadogNdkCrashHandler.LOGGER_NAME, f3420g, f3424k, f3422i, f3431r, f3434u, f3428o), new NdkCrashLogDeserializer(RuntimeUtilsKt.getSdkLogger()), new RumEventDeserializer(), new NetworkInfoDeserializer(RuntimeUtilsKt.getSdkLogger()), new UserInfoDeserializer(RuntimeUtilsKt.getSdkLogger()), RuntimeUtilsKt.getSdkLogger(), f3422i);
            f3438y = datadogNdkCrashHandler;
            datadogNdkCrashHandler.prepareData();
        }
    }

    /* renamed from: b */
    private final void m2296b(Context context) {
        List listOf = CollectionsKt.listOf(DatadogEndpoint.NTP_0, DatadogEndpoint.NTP_1, DatadogEndpoint.NTP_2, DatadogEndpoint.NTP_3);
        long millis = TimeUnit.MINUTES.toMillis(30);
        Context context2 = context;
        KronosClock createKronosClock$default = AndroidClockFactory.createKronosClock$default(context2, new LoggingSyncListener(), listOf, 0, TimeUnit.MINUTES.toMillis(5), millis, 0, 72, (Object) null);
        createKronosClock$default.syncInBackground();
        Unit unit = Unit.INSTANCE;
        setKronosClock$dd_sdk_android_release(createKronosClock$default);
    }

    /* renamed from: a */
    private final void m2292a(Context context, Credentials credentials) {
        String packageName = context.getPackageName();
        Intrinsics.checkNotNullExpressionValue(packageName, "appContext.packageName");
        f3427n = packageName;
        PackageInfo packageInfo = SystemUtils.getPackageInfo(context.getPackageManager(), f3427n, 0);
        String str = packageInfo.versionName;
        if (str == null) {
            str = String.valueOf(packageInfo.versionCode);
        }
        f3428o = str;
        f3426m = credentials.getClientToken();
        String serviceName = credentials.getServiceName();
        if (serviceName == null) {
            serviceName = context.getPackageName();
            Intrinsics.checkNotNullExpressionValue(serviceName, "appContext.packageName");
        }
        f3429p = serviceName;
        f3432s = credentials.getRumApplicationId();
        f3434u = credentials.getEnvName();
        f3435v = credentials.getVariant();
        f3418e = new WeakReference<>(context);
    }

    /* renamed from: a */
    private final void m2294a(Configuration.Core core) {
        f3436w = core.getBatchSize();
        f3437x = core.getUploadFrequency();
    }

    /* renamed from: a */
    private final void m2293a(Context context, TrackingConsent trackingConsent) {
        f3423j = new TrackingConsentProvider(trackingConsent);
        SystemInfoProvider broadcastReceiverSystemInfoProvider = new BroadcastReceiverSystemInfoProvider();
        f3421h = broadcastReceiverSystemInfoProvider;
        broadcastReceiverSystemInfoProvider.register(context);
        m2301d(context);
        m2299c(context);
    }

    /* renamed from: c */
    private final void m2299c(Context context) {
        f3424k = new DatadogUserInfoProvider(new ScheduledWriter(new NdkUserInfoDataWriter(context, f3423j, getPersistenceExecutorService$dd_sdk_android_release(), new BatchFileHandler(RuntimeUtilsKt.getSdkLogger()), RuntimeUtilsKt.getSdkLogger()), getPersistenceExecutorService$dd_sdk_android_release(), RuntimeUtilsKt.getSdkLogger()));
    }

    /* renamed from: d */
    private final void m2301d(Context context) {
        NetworkInfoProvider networkInfoProvider;
        ScheduledWriter scheduledWriter = new ScheduledWriter(new NdkNetworkInfoDataWriter(context, f3423j, getPersistenceExecutorService$dd_sdk_android_release(), new BatchFileHandler(RuntimeUtilsKt.getSdkLogger()), RuntimeUtilsKt.getSdkLogger()), getPersistenceExecutorService$dd_sdk_android_release(), RuntimeUtilsKt.getSdkLogger());
        if (Build.VERSION.SDK_INT >= 24) {
            networkInfoProvider = new CallbackNetworkInfoProvider(scheduledWriter);
        } else {
            networkInfoProvider = new BroadcastReceiverNetworkInfoProvider(scheduledWriter);
        }
        f3420g = networkInfoProvider;
        networkInfoProvider.register(context);
    }

    /* renamed from: b */
    private final void m2297b(Configuration.Core core) {
        ConnectionSpec connectionSpec;
        if (core.getNeedsClearTextHttp()) {
            connectionSpec = ConnectionSpec.CLEARTEXT;
        } else if (Build.VERSION.SDK_INT >= 21) {
            connectionSpec = ConnectionSpec.RESTRICTED_TLS;
        } else {
            connectionSpec = ConnectionSpec.MODERN_TLS;
        }
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.addInterceptor(new GzipRequestInterceptor()).callTimeout(f3414a, TimeUnit.MILLISECONDS).writeTimeout(f3414a, TimeUnit.MILLISECONDS).protocols(CollectionsKt.listOf(Protocol.HTTP_2, Protocol.HTTP_1_1)).connectionSpecs(CollectionsKt.listOf(connectionSpec));
        if (core.getProxy() != null) {
            builder.proxy(core.getProxy());
            builder.proxyAuthenticator(core.getProxyAuth());
        }
        OkHttpClient build = builder.build();
        Intrinsics.checkNotNullExpressionValue(build, "builder.build()");
        f3425l = build;
    }

    /* renamed from: a */
    private final void m2290a() {
        setUploadExecutorService$dd_sdk_android_release(new ScheduledThreadPoolExecutor(1));
        setPersistenceExecutorService$dd_sdk_android_release(new ThreadPoolExecutor(1, Runtime.getRuntime().availableProcessors(), f3415b, TimeUnit.MILLISECONDS, new LinkedBlockingDeque()));
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: android.app.ActivityManager$RunningAppProcessInfo} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: android.app.ActivityManager$RunningAppProcessInfo} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: android.app.ActivityManager$RunningAppProcessInfo} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v1, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v0, resolved type: android.app.ActivityManager$RunningAppProcessInfo} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: android.app.ActivityManager$RunningAppProcessInfo} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void m2302e(android.content.Context r7) {
        /*
            r6 = this;
            int r0 = android.os.Process.myPid()
            java.lang.String r1 = "activity"
            java.lang.Object r1 = r7.getSystemService(r1)
            boolean r2 = r1 instanceof android.app.ActivityManager
            r3 = 0
            if (r2 == 0) goto L_0x0012
            android.app.ActivityManager r1 = (android.app.ActivityManager) r1
            goto L_0x0013
        L_0x0012:
            r1 = r3
        L_0x0013:
            r2 = 1
            if (r1 != 0) goto L_0x0017
            goto L_0x003d
        L_0x0017:
            java.util.List r1 = r1.getRunningAppProcesses()
            if (r1 != 0) goto L_0x001e
            goto L_0x003d
        L_0x001e:
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.Iterator r1 = r1.iterator()
        L_0x0024:
            boolean r4 = r1.hasNext()
            if (r4 == 0) goto L_0x003b
            java.lang.Object r4 = r1.next()
            r5 = r4
            android.app.ActivityManager$RunningAppProcessInfo r5 = (android.app.ActivityManager.RunningAppProcessInfo) r5
            int r5 = r5.pid
            if (r5 != r0) goto L_0x0037
            r5 = 1
            goto L_0x0038
        L_0x0037:
            r5 = 0
        L_0x0038:
            if (r5 == 0) goto L_0x0024
            r3 = r4
        L_0x003b:
            android.app.ActivityManager$RunningAppProcessInfo r3 = (android.app.ActivityManager.RunningAppProcessInfo) r3
        L_0x003d:
            if (r3 != 0) goto L_0x0040
            goto L_0x004a
        L_0x0040:
            java.lang.String r7 = r7.getPackageName()
            java.lang.String r0 = r3.processName
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r7, (java.lang.Object) r0)
        L_0x004a:
            f3433t = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.datadog.android.core.internal.CoreFeature.m2302e(android.content.Context):void");
    }

    /* renamed from: b */
    private final void m2295b() {
        getUploadExecutorService$dd_sdk_android_release().shutdownNow();
        getPersistenceExecutorService$dd_sdk_android_release().shutdownNow();
        getUploadExecutorService$dd_sdk_android_release().awaitTermination(1, TimeUnit.SECONDS);
        getPersistenceExecutorService$dd_sdk_android_release().awaitTermination(1, TimeUnit.SECONDS);
    }

    /* renamed from: c */
    private final void m2298c() {
        f3426m = "";
        f3427n = "";
        f3428o = "";
        f3429p = "";
        f3430q = "android";
        f3432s = null;
        f3433t = true;
        f3434u = "";
        f3435v = "";
    }

    /* renamed from: d */
    private final void m2300d() {
        f3419f = new FirstPartyHostDetector(CollectionsKt.emptyList());
        f3420g = new NoOpNetworkInfoProvider();
        f3421h = new NoOpSystemInfoProvider();
        f3422i = new NoOpTimeProvider();
        f3423j = new NoOpConsentProvider();
        f3424k = new NoOpMutableUserInfoProvider();
    }
}
