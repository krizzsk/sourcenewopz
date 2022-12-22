package com.datadog.android.core.internal.persistence.file.advanced;

import com.datadog.android.core.internal.persistence.file.FileOrchestrator;
import com.datadog.android.core.internal.persistence.file.FilePersistenceConfig;
import com.datadog.android.core.internal.privacy.ConsentProvider;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B/\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fB%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\u0010\u001a\u00020\u0011¢\u0006\u0002\u0010\u0012¨\u0006\u0014"}, mo175978d2 = {"Lcom/datadog/android/core/internal/persistence/file/advanced/FeatureFileOrchestrator;", "Lcom/datadog/android/core/internal/persistence/file/advanced/ConsentAwareFileOrchestrator;", "consentProvider", "Lcom/datadog/android/core/internal/privacy/ConsentProvider;", "context", "Landroid/content/Context;", "featureName", "", "executorService", "Ljava/util/concurrent/ExecutorService;", "internalLogger", "Lcom/datadog/android/log/Logger;", "(Lcom/datadog/android/core/internal/privacy/ConsentProvider;Landroid/content/Context;Ljava/lang/String;Ljava/util/concurrent/ExecutorService;Lcom/datadog/android/log/Logger;)V", "pendingOrchestrator", "Lcom/datadog/android/core/internal/persistence/file/FileOrchestrator;", "grantedOrchestrator", "dataMigrator", "Lcom/datadog/android/core/internal/persistence/file/advanced/DataMigrator;", "(Lcom/datadog/android/core/internal/privacy/ConsentProvider;Lcom/datadog/android/core/internal/persistence/file/FileOrchestrator;Lcom/datadog/android/core/internal/persistence/file/FileOrchestrator;Lcom/datadog/android/core/internal/persistence/file/advanced/DataMigrator;)V", "Companion", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: FeatureFileOrchestrator.kt */
public final class FeatureFileOrchestrator extends ConsentAwareFileOrchestrator {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int VERSION = 1;

    /* renamed from: a */
    private static final String f3529a = "dd-%s-pending-v1";

    /* renamed from: b */
    private static final String f3530b = "dd-%s-v1";

    /* renamed from: c */
    private static final FilePersistenceConfig f3531c = new FilePersistenceConfig(0, 0, 0, 0, 0, 0, 63, (DefaultConstructorMarker) null);

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FeatureFileOrchestrator(ConsentProvider consentProvider, FileOrchestrator fileOrchestrator, FileOrchestrator fileOrchestrator2, DataMigrator dataMigrator) {
        super(consentProvider, fileOrchestrator, fileOrchestrator2, dataMigrator);
        Intrinsics.checkNotNullParameter(consentProvider, "consentProvider");
        Intrinsics.checkNotNullParameter(fileOrchestrator, "pendingOrchestrator");
        Intrinsics.checkNotNullParameter(fileOrchestrator2, "grantedOrchestrator");
        Intrinsics.checkNotNullParameter(dataMigrator, "dataMigrator");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public FeatureFileOrchestrator(com.datadog.android.core.internal.privacy.ConsentProvider r9, android.content.Context r10, java.lang.String r11, java.util.concurrent.ExecutorService r12, com.datadog.android.log.Logger r13) {
        /*
            r8 = this;
            java.lang.String r0 = "consentProvider"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            java.lang.String r0 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            java.lang.String r0 = "featureName"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            java.lang.String r0 = "executorService"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            java.lang.String r0 = "internalLogger"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            com.datadog.android.core.internal.persistence.file.batch.BatchFileOrchestrator r0 = new com.datadog.android.core.internal.persistence.file.batch.BatchFileOrchestrator
            java.io.File r1 = new java.io.File
            java.io.File r2 = r10.getFilesDir()
            java.util.Locale r3 = java.util.Locale.US
            r4 = 1
            java.lang.Object[] r5 = new java.lang.Object[r4]
            r6 = 0
            r5[r6] = r11
            java.lang.Object[] r5 = java.util.Arrays.copyOf(r5, r4)
            java.lang.String r7 = "dd-%s-pending-v1"
            java.lang.String r3 = java.lang.String.format(r3, r7, r5)
            java.lang.String r5 = "java.lang.String.format(locale, this, *args)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r5)
            r1.<init>(r2, r3)
            com.datadog.android.core.internal.persistence.file.FilePersistenceConfig r2 = f3531c
            r0.<init>(r1, r2, r13)
            com.datadog.android.core.internal.persistence.file.FileOrchestrator r0 = (com.datadog.android.core.internal.persistence.file.FileOrchestrator) r0
            com.datadog.android.core.internal.persistence.file.batch.BatchFileOrchestrator r1 = new com.datadog.android.core.internal.persistence.file.batch.BatchFileOrchestrator
            java.io.File r2 = new java.io.File
            java.io.File r10 = r10.getFilesDir()
            java.util.Locale r3 = java.util.Locale.US
            java.lang.Object[] r7 = new java.lang.Object[r4]
            r7[r6] = r11
            java.lang.Object[] r11 = java.util.Arrays.copyOf(r7, r4)
            java.lang.String r4 = "dd-%s-v1"
            java.lang.String r11 = java.lang.String.format(r3, r4, r11)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r11, r5)
            r2.<init>(r10, r11)
            com.datadog.android.core.internal.persistence.file.FilePersistenceConfig r10 = f3531c
            r1.<init>(r2, r10, r13)
            com.datadog.android.core.internal.persistence.file.FileOrchestrator r1 = (com.datadog.android.core.internal.persistence.file.FileOrchestrator) r1
            com.datadog.android.core.internal.persistence.file.advanced.ConsentAwareFileMigrator r10 = new com.datadog.android.core.internal.persistence.file.advanced.ConsentAwareFileMigrator
            com.datadog.android.core.internal.persistence.file.batch.BatchFileHandler r11 = new com.datadog.android.core.internal.persistence.file.batch.BatchFileHandler
            r11.<init>(r13)
            com.datadog.android.core.internal.persistence.file.FileHandler r11 = (com.datadog.android.core.internal.persistence.file.FileHandler) r11
            r10.<init>(r11, r12, r13)
            com.datadog.android.core.internal.persistence.file.advanced.DataMigrator r10 = (com.datadog.android.core.internal.persistence.file.advanced.DataMigrator) r10
            r8.<init>(r9, r0, r1, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.datadog.android.core.internal.persistence.file.advanced.FeatureFileOrchestrator.<init>(com.datadog.android.core.internal.privacy.ConsentProvider, android.content.Context, java.lang.String, java.util.concurrent.ExecutorService, com.datadog.android.log.Logger):void");
    }

    @Metadata(mo175977d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tXT¢\u0006\u0002\n\u0000¨\u0006\n"}, mo175978d2 = {"Lcom/datadog/android/core/internal/persistence/file/advanced/FeatureFileOrchestrator$Companion;", "", "()V", "GRANTED_DIR", "", "PENDING_DIR", "PERSISTENCE_CONFIG", "Lcom/datadog/android/core/internal/persistence/file/FilePersistenceConfig;", "VERSION", "", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: FeatureFileOrchestrator.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
