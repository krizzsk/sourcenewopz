package com.datadog.android.monitoring.internal;

import android.content.Context;
import com.datadog.android.core.internal.constraints.DataConstraints;
import com.datadog.android.core.internal.persistence.PayloadDecoration;
import com.datadog.android.core.internal.persistence.file.advanced.FeatureFileOrchestrator;
import com.datadog.android.core.internal.persistence.file.batch.BatchFilePersistenceStrategy;
import com.datadog.android.core.internal.privacy.ConsentProvider;
import com.datadog.android.log.Logger;
import com.datadog.android.log.internal.domain.event.LogEventSerializer;
import com.datadog.android.log.model.LogEvent;
import java.util.concurrent.ExecutorService;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B%\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000b¨\u0006\f"}, mo175978d2 = {"Lcom/datadog/android/monitoring/internal/InternalLogFilePersistenceStrategy;", "Lcom/datadog/android/core/internal/persistence/file/batch/BatchFilePersistenceStrategy;", "Lcom/datadog/android/log/model/LogEvent;", "consentProvider", "Lcom/datadog/android/core/internal/privacy/ConsentProvider;", "context", "Landroid/content/Context;", "executorService", "Ljava/util/concurrent/ExecutorService;", "internalLogger", "Lcom/datadog/android/log/Logger;", "(Lcom/datadog/android/core/internal/privacy/ConsentProvider;Landroid/content/Context;Ljava/util/concurrent/ExecutorService;Lcom/datadog/android/log/Logger;)V", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: InternalLogFilePersistenceStrategy.kt */
public final class InternalLogFilePersistenceStrategy extends BatchFilePersistenceStrategy<LogEvent> {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public InternalLogFilePersistenceStrategy(ConsentProvider consentProvider, Context context, ExecutorService executorService, Logger logger) {
        super(new FeatureFileOrchestrator(consentProvider, context, "internal-logs", executorService, logger), executorService, new LogEventSerializer((DataConstraints) null, 1, (DefaultConstructorMarker) null), PayloadDecoration.Companion.getJSON_ARRAY_DECORATION(), logger);
        Intrinsics.checkNotNullParameter(consentProvider, "consentProvider");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(executorService, "executorService");
        Intrinsics.checkNotNullParameter(logger, "internalLogger");
    }
}
