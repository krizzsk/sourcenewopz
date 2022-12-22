package com.datadog.android.rum.internal.domain;

import com.datadog.android.core.internal.persistence.DataWriter;
import com.datadog.android.core.internal.persistence.PayloadDecoration;
import com.datadog.android.core.internal.persistence.Serializer;
import com.datadog.android.core.internal.persistence.file.FileOrchestrator;
import com.datadog.android.core.internal.persistence.file.advanced.ScheduledWriter;
import com.datadog.android.core.internal.persistence.file.batch.BatchFilePersistenceStrategy;
import com.datadog.android.log.Logger;
import java.io.File;
import java.util.concurrent.ExecutorService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B;\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010\u000fJA\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\n2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u000b\u001a\u00020\fH\u0010¢\u0006\u0002\b\u0018R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, mo175978d2 = {"Lcom/datadog/android/rum/internal/domain/RumFilePersistenceStrategy;", "Lcom/datadog/android/core/internal/persistence/file/batch/BatchFilePersistenceStrategy;", "", "consentProvider", "Lcom/datadog/android/core/internal/privacy/ConsentProvider;", "context", "Landroid/content/Context;", "eventMapper", "Lcom/datadog/android/event/EventMapper;", "executorService", "Ljava/util/concurrent/ExecutorService;", "internalLogger", "Lcom/datadog/android/log/Logger;", "lastViewEventFile", "Ljava/io/File;", "(Lcom/datadog/android/core/internal/privacy/ConsentProvider;Landroid/content/Context;Lcom/datadog/android/event/EventMapper;Ljava/util/concurrent/ExecutorService;Lcom/datadog/android/log/Logger;Ljava/io/File;)V", "createWriter", "Lcom/datadog/android/core/internal/persistence/DataWriter;", "fileOrchestrator", "Lcom/datadog/android/core/internal/persistence/file/FileOrchestrator;", "serializer", "Lcom/datadog/android/core/internal/persistence/Serializer;", "payloadDecoration", "Lcom/datadog/android/core/internal/persistence/PayloadDecoration;", "createWriter$dd_sdk_android_release", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: RumFilePersistenceStrategy.kt */
public final class RumFilePersistenceStrategy extends BatchFilePersistenceStrategy<Object> {

    /* renamed from: a */
    private final File f3694a;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public RumFilePersistenceStrategy(com.datadog.android.core.internal.privacy.ConsentProvider r12, android.content.Context r13, com.datadog.android.event.EventMapper<java.lang.Object> r14, java.util.concurrent.ExecutorService r15, com.datadog.android.log.Logger r16, java.io.File r17) {
        /*
            r11 = this;
            r0 = r14
            r1 = r17
            java.lang.String r2 = "consentProvider"
            r4 = r12
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r2)
            java.lang.String r2 = "context"
            r5 = r13
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r2)
            java.lang.String r2 = "eventMapper"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r2)
            java.lang.String r2 = "executorService"
            r9 = r15
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r2)
            java.lang.String r2 = "internalLogger"
            r10 = r16
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r2)
            java.lang.String r2 = "lastViewEventFile"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r2)
            com.datadog.android.core.internal.persistence.file.advanced.FeatureFileOrchestrator r2 = new com.datadog.android.core.internal.persistence.file.advanced.FeatureFileOrchestrator
            java.lang.String r6 = "rum"
            r3 = r2
            r7 = r15
            r8 = r16
            r3.<init>(r4, r5, r6, r7, r8)
            r4 = r2
            com.datadog.android.core.internal.persistence.file.FileOrchestrator r4 = (com.datadog.android.core.internal.persistence.file.FileOrchestrator) r4
            com.datadog.android.event.MapperSerializer r2 = new com.datadog.android.event.MapperSerializer
            com.datadog.android.rum.internal.domain.event.RumEventSerializer r3 = new com.datadog.android.rum.internal.domain.event.RumEventSerializer
            r5 = 0
            r6 = 1
            r3.<init>(r5, r6, r5)
            com.datadog.android.core.internal.persistence.Serializer r3 = (com.datadog.android.core.internal.persistence.Serializer) r3
            r2.<init>(r14, r3)
            r6 = r2
            com.datadog.android.core.internal.persistence.Serializer r6 = (com.datadog.android.core.internal.persistence.Serializer) r6
            com.datadog.android.core.internal.persistence.PayloadDecoration$Companion r0 = com.datadog.android.core.internal.persistence.PayloadDecoration.Companion
            com.datadog.android.core.internal.persistence.PayloadDecoration r7 = r0.getNEW_LINE_DECORATION()
            r3 = r11
            r5 = r15
            r3.<init>(r4, r5, r6, r7, r8)
            r0 = r11
            r0.f3694a = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.datadog.android.rum.internal.domain.RumFilePersistenceStrategy.<init>(com.datadog.android.core.internal.privacy.ConsentProvider, android.content.Context, com.datadog.android.event.EventMapper, java.util.concurrent.ExecutorService, com.datadog.android.log.Logger, java.io.File):void");
    }

    public DataWriter<Object> createWriter$dd_sdk_android_release(FileOrchestrator fileOrchestrator, ExecutorService executorService, Serializer<Object> serializer, PayloadDecoration payloadDecoration, Logger logger) {
        Intrinsics.checkNotNullParameter(fileOrchestrator, "fileOrchestrator");
        Intrinsics.checkNotNullParameter(executorService, "executorService");
        Intrinsics.checkNotNullParameter(serializer, "serializer");
        Intrinsics.checkNotNullParameter(payloadDecoration, "payloadDecoration");
        Intrinsics.checkNotNullParameter(logger, "internalLogger");
        return new ScheduledWriter<>(new RumDataWriter(fileOrchestrator, serializer, payloadDecoration, getFileHandler$dd_sdk_android_release(), logger, this.f3694a), executorService, logger);
    }
}
