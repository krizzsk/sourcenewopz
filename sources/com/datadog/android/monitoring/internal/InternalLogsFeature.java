package com.datadog.android.monitoring.internal;

import android.content.Context;
import com.datadog.android.core.configuration.Configuration;
import com.datadog.android.core.internal.CoreFeature;
import com.datadog.android.core.internal.SdkFeature;
import com.datadog.android.core.internal.net.DataUploader;
import com.datadog.android.core.internal.persistence.PersistenceStrategy;
import com.datadog.android.core.internal.utils.RuntimeUtilsKt;
import com.datadog.android.log.Logger;
import com.datadog.android.log.internal.logger.NoOpLogHandler;
import com.datadog.android.log.internal.net.LogsOkHttpUploaderV2;
import com.datadog.android.log.model.LogEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0004J\u001e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0003H\u0016J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\u0003H\u0016J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0013"}, mo175978d2 = {"Lcom/datadog/android/monitoring/internal/InternalLogsFeature;", "Lcom/datadog/android/core/internal/SdkFeature;", "Lcom/datadog/android/log/model/LogEvent;", "Lcom/datadog/android/core/configuration/Configuration$Feature$InternalLogs;", "()V", "APPLICATION_PACKAGE_KEY", "", "ENV_NAME", "SERVICE_NAME", "createPersistenceStrategy", "Lcom/datadog/android/core/internal/persistence/PersistenceStrategy;", "context", "Landroid/content/Context;", "configuration", "createUploader", "Lcom/datadog/android/core/internal/net/DataUploader;", "onPostInitialized", "", "onPostStopped", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: InternalLogsFeature.kt */
public final class InternalLogsFeature extends SdkFeature<LogEvent, Configuration.Feature.InternalLogs> {
    public static final String ENV_NAME = "prod";
    public static final InternalLogsFeature INSTANCE = new InternalLogsFeature();
    public static final String SERVICE_NAME = "dd-sdk-android";

    /* renamed from: a */
    private static final String f3654a = "application.name";

    private InternalLogsFeature() {
    }

    public void onPostInitialized(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        RuntimeUtilsKt.rebuildSdkLogger();
        RuntimeUtilsKt.getSdkLogger().addAttribute(f3654a, CoreFeature.INSTANCE.getPackageName$dd_sdk_android_release());
    }

    public void onPostStopped() {
        RuntimeUtilsKt.rebuildSdkLogger();
    }

    public PersistenceStrategy<LogEvent> createPersistenceStrategy(Context context, Configuration.Feature.InternalLogs internalLogs) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(internalLogs, "configuration");
        return new InternalLogFilePersistenceStrategy(CoreFeature.INSTANCE.getTrackingConsentProvider$dd_sdk_android_release(), context, CoreFeature.INSTANCE.getPersistenceExecutorService$dd_sdk_android_release(), new Logger(new NoOpLogHandler()));
    }

    public DataUploader createUploader(Configuration.Feature.InternalLogs internalLogs) {
        Intrinsics.checkNotNullParameter(internalLogs, "configuration");
        return new LogsOkHttpUploaderV2(internalLogs.getEndpointUrl(), internalLogs.getInternalClientToken(), CoreFeature.INSTANCE.getSourceName$dd_sdk_android_release(), CoreFeature.INSTANCE.getSdkVersion$dd_sdk_android_release(), CoreFeature.INSTANCE.getOkHttpClient$dd_sdk_android_release(), new Logger(new NoOpLogHandler()));
    }
}
