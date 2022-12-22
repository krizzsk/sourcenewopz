package com.datadog.android.tracing.internal.domain;

import com.datadog.android.core.internal.persistence.file.batch.BatchFilePersistenceStrategy;
import com.datadog.opentracing.DDSpan;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001BM\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\u0006\u0010\u0013\u001a\u00020\u0014¢\u0006\u0002\u0010\u0015¨\u0006\u0016"}, mo175978d2 = {"Lcom/datadog/android/tracing/internal/domain/TracesFilePersistenceStrategy;", "Lcom/datadog/android/core/internal/persistence/file/batch/BatchFilePersistenceStrategy;", "Lcom/datadog/opentracing/DDSpan;", "consentProvider", "Lcom/datadog/android/core/internal/privacy/ConsentProvider;", "context", "Landroid/content/Context;", "executorService", "Ljava/util/concurrent/ExecutorService;", "timeProvider", "Lcom/datadog/android/core/internal/time/TimeProvider;", "networkInfoProvider", "Lcom/datadog/android/core/internal/net/info/NetworkInfoProvider;", "userInfoProvider", "Lcom/datadog/android/log/internal/user/UserInfoProvider;", "envName", "", "internalLogger", "Lcom/datadog/android/log/Logger;", "spanEventMapper", "Lcom/datadog/android/event/SpanEventMapper;", "(Lcom/datadog/android/core/internal/privacy/ConsentProvider;Landroid/content/Context;Ljava/util/concurrent/ExecutorService;Lcom/datadog/android/core/internal/time/TimeProvider;Lcom/datadog/android/core/internal/net/info/NetworkInfoProvider;Lcom/datadog/android/log/internal/user/UserInfoProvider;Ljava/lang/String;Lcom/datadog/android/log/Logger;Lcom/datadog/android/event/SpanEventMapper;)V", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: TracesFilePersistenceStrategy.kt */
public final class TracesFilePersistenceStrategy extends BatchFilePersistenceStrategy<DDSpan> {
    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public TracesFilePersistenceStrategy(com.datadog.android.core.internal.privacy.ConsentProvider r15, android.content.Context r16, java.util.concurrent.ExecutorService r17, com.datadog.android.core.internal.time.TimeProvider r18, com.datadog.android.core.internal.net.info.NetworkInfoProvider r19, com.datadog.android.log.internal.user.UserInfoProvider r20, java.lang.String r21, com.datadog.android.log.Logger r22, com.datadog.android.event.SpanEventMapper r23) {
        /*
            r14 = this;
            r0 = r18
            r1 = r19
            r2 = r20
            r3 = r21
            r4 = r23
            java.lang.String r5 = "consentProvider"
            r7 = r15
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r5)
            java.lang.String r5 = "context"
            r8 = r16
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r5)
            java.lang.String r5 = "executorService"
            r12 = r17
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r5)
            java.lang.String r5 = "timeProvider"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r5)
            java.lang.String r5 = "networkInfoProvider"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r5)
            java.lang.String r5 = "userInfoProvider"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r5)
            java.lang.String r5 = "envName"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r5)
            java.lang.String r5 = "internalLogger"
            r13 = r22
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r5)
            java.lang.String r5 = "spanEventMapper"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r5)
            com.datadog.android.core.internal.persistence.file.advanced.FeatureFileOrchestrator r5 = new com.datadog.android.core.internal.persistence.file.advanced.FeatureFileOrchestrator
            java.lang.String r9 = "tracing"
            r6 = r5
            r10 = r17
            r11 = r22
            r6.<init>(r7, r8, r9, r10, r11)
            r7 = r5
            com.datadog.android.core.internal.persistence.file.FileOrchestrator r7 = (com.datadog.android.core.internal.persistence.file.FileOrchestrator) r7
            com.datadog.android.tracing.internal.domain.event.SpanMapperSerializer r5 = new com.datadog.android.tracing.internal.domain.event.SpanMapperSerializer
            com.datadog.android.tracing.internal.domain.event.DdSpanToSpanEventMapper r6 = new com.datadog.android.tracing.internal.domain.event.DdSpanToSpanEventMapper
            r6.<init>(r0, r1, r2)
            com.datadog.android.core.internal.Mapper r6 = (com.datadog.android.core.internal.Mapper) r6
            com.datadog.android.tracing.internal.domain.event.SpanEventMapperWrapper r0 = new com.datadog.android.tracing.internal.domain.event.SpanEventMapperWrapper
            r0.<init>(r4)
            com.datadog.android.event.EventMapper r0 = (com.datadog.android.event.EventMapper) r0
            com.datadog.android.tracing.internal.domain.event.SpanEventSerializer r1 = new com.datadog.android.tracing.internal.domain.event.SpanEventSerializer
            r2 = 0
            r4 = 2
            r1.<init>(r3, r2, r4, r2)
            com.datadog.android.core.internal.persistence.Serializer r1 = (com.datadog.android.core.internal.persistence.Serializer) r1
            r5.<init>(r6, r0, r1)
            r9 = r5
            com.datadog.android.core.internal.persistence.Serializer r9 = (com.datadog.android.core.internal.persistence.Serializer) r9
            com.datadog.android.core.internal.persistence.PayloadDecoration$Companion r0 = com.datadog.android.core.internal.persistence.PayloadDecoration.Companion
            com.datadog.android.core.internal.persistence.PayloadDecoration r10 = r0.getNEW_LINE_DECORATION()
            r6 = r14
            r8 = r17
            r6.<init>(r7, r8, r9, r10, r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.datadog.android.tracing.internal.domain.TracesFilePersistenceStrategy.<init>(com.datadog.android.core.internal.privacy.ConsentProvider, android.content.Context, java.util.concurrent.ExecutorService, com.datadog.android.core.internal.time.TimeProvider, com.datadog.android.core.internal.net.info.NetworkInfoProvider, com.datadog.android.log.internal.user.UserInfoProvider, java.lang.String, com.datadog.android.log.Logger, com.datadog.android.event.SpanEventMapper):void");
    }
}
