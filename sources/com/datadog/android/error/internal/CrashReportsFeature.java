package com.datadog.android.error.internal;

import android.content.Context;
import com.datadog.android.core.configuration.Configuration;
import com.datadog.android.core.internal.CoreFeature;
import com.datadog.android.core.internal.SdkFeature;
import com.datadog.android.core.internal.net.DataUploader;
import com.datadog.android.core.internal.persistence.PersistenceStrategy;
import com.datadog.android.core.internal.utils.RuntimeUtilsKt;
import com.datadog.android.log.internal.domain.LogGenerator;
import com.datadog.android.log.internal.net.LogsOkHttpUploaderV2;
import com.datadog.android.log.model.LogEvent;
import java.lang.Thread;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\bÀ\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0004J\u001e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0003H\u0016J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u0003H\u0016J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0003H\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0016J\b\u0010\u0012\u001a\u00020\u0010H\u0002J\u0010\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u000bH\u0002R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, mo175978d2 = {"Lcom/datadog/android/error/internal/CrashReportsFeature;", "Lcom/datadog/android/core/internal/SdkFeature;", "Lcom/datadog/android/log/model/LogEvent;", "Lcom/datadog/android/core/configuration/Configuration$Feature$CrashReport;", "()V", "originalUncaughtExceptionHandler", "Ljava/lang/Thread$UncaughtExceptionHandler;", "kotlin.jvm.PlatformType", "createPersistenceStrategy", "Lcom/datadog/android/core/internal/persistence/PersistenceStrategy;", "context", "Landroid/content/Context;", "configuration", "createUploader", "Lcom/datadog/android/core/internal/net/DataUploader;", "onInitialize", "", "onStop", "resetOriginalExceptionHandler", "setupExceptionHandler", "appContext", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CrashReportsFeature.kt */
public final class CrashReportsFeature extends SdkFeature<LogEvent, Configuration.Feature.CrashReport> {
    public static final CrashReportsFeature INSTANCE = new CrashReportsFeature();

    /* renamed from: a */
    private static Thread.UncaughtExceptionHandler f3603a = Thread.getDefaultUncaughtExceptionHandler();

    private CrashReportsFeature() {
    }

    public void onInitialize(Context context, Configuration.Feature.CrashReport crashReport) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(crashReport, "configuration");
        m2370a(context);
    }

    public void onStop() {
        m2369a();
    }

    public PersistenceStrategy<LogEvent> createPersistenceStrategy(Context context, Configuration.Feature.CrashReport crashReport) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(crashReport, "configuration");
        return new CrashReportFilePersistenceStrategy(CoreFeature.INSTANCE.getTrackingConsentProvider$dd_sdk_android_release(), context, CoreFeature.INSTANCE.getPersistenceExecutorService$dd_sdk_android_release(), RuntimeUtilsKt.getSdkLogger());
    }

    public DataUploader createUploader(Configuration.Feature.CrashReport crashReport) {
        Intrinsics.checkNotNullParameter(crashReport, "configuration");
        return new LogsOkHttpUploaderV2(crashReport.getEndpointUrl(), CoreFeature.INSTANCE.getClientToken$dd_sdk_android_release(), CoreFeature.INSTANCE.getSourceName$dd_sdk_android_release(), CoreFeature.INSTANCE.getSdkVersion$dd_sdk_android_release(), CoreFeature.INSTANCE.getOkHttpClient$dd_sdk_android_release(), RuntimeUtilsKt.getSdkLogger());
    }

    /* renamed from: a */
    private final void m2370a(Context context) {
        f3603a = Thread.getDefaultUncaughtExceptionHandler();
        new DatadogExceptionHandler(new LogGenerator(CoreFeature.INSTANCE.getServiceName$dd_sdk_android_release(), "crash", CoreFeature.INSTANCE.getNetworkInfoProvider$dd_sdk_android_release(), CoreFeature.INSTANCE.getUserInfoProvider$dd_sdk_android_release(), CoreFeature.INSTANCE.getTimeProvider$dd_sdk_android_release(), CoreFeature.INSTANCE.getSdkVersion$dd_sdk_android_release(), CoreFeature.INSTANCE.getEnvName$dd_sdk_android_release(), CoreFeature.INSTANCE.getPackageVersion$dd_sdk_android_release()), getPersistenceStrategy$dd_sdk_android_release().getWriter(), context).register();
    }

    /* renamed from: a */
    private final void m2369a() {
        Thread.setDefaultUncaughtExceptionHandler(f3603a);
    }
}
