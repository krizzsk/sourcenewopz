package com.datadog.android.core.internal.persistence.file.advanced;

import com.datadog.android.core.internal.persistence.file.FileHandler;
import com.datadog.android.core.internal.persistence.file.FileOrchestrator;
import com.datadog.android.core.internal.utils.RuntimeUtilsKt;
import com.datadog.android.log.Logger;
import com.datadog.android.privacy.TrackingConsent;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ*\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000eH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, mo175978d2 = {"Lcom/datadog/android/core/internal/persistence/file/advanced/ConsentAwareFileMigrator;", "Lcom/datadog/android/core/internal/persistence/file/advanced/DataMigrator;", "fileHandler", "Lcom/datadog/android/core/internal/persistence/file/FileHandler;", "executorService", "Ljava/util/concurrent/ExecutorService;", "internalLogger", "Lcom/datadog/android/log/Logger;", "(Lcom/datadog/android/core/internal/persistence/file/FileHandler;Ljava/util/concurrent/ExecutorService;Lcom/datadog/android/log/Logger;)V", "migrateData", "", "previousConsent", "Lcom/datadog/android/privacy/TrackingConsent;", "previousFileOrchestrator", "Lcom/datadog/android/core/internal/persistence/file/FileOrchestrator;", "newConsent", "newFileOrchestrator", "Companion", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: ConsentAwareFileMigrator.kt */
public final class ConsentAwareFileMigrator implements DataMigrator {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String ERROR_REJECTED = "Unable to schedule migration on the executor";

    /* renamed from: a */
    private final FileHandler f3521a;

    /* renamed from: b */
    private final ExecutorService f3522b;

    /* renamed from: c */
    private final Logger f3523c;

    public ConsentAwareFileMigrator(FileHandler fileHandler, ExecutorService executorService, Logger logger) {
        Intrinsics.checkNotNullParameter(fileHandler, "fileHandler");
        Intrinsics.checkNotNullParameter(executorService, "executorService");
        Intrinsics.checkNotNullParameter(logger, "internalLogger");
        this.f3521a = fileHandler;
        this.f3522b = executorService;
        this.f3523c = logger;
    }

    public void migrateData(TrackingConsent trackingConsent, FileOrchestrator fileOrchestrator, TrackingConsent trackingConsent2, FileOrchestrator fileOrchestrator2) {
        boolean z;
        boolean z2;
        boolean z3;
        DataMigrationOperation dataMigrationOperation;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        Intrinsics.checkNotNullParameter(fileOrchestrator, "previousFileOrchestrator");
        Intrinsics.checkNotNullParameter(trackingConsent2, "newConsent");
        Intrinsics.checkNotNullParameter(fileOrchestrator2, "newFileOrchestrator");
        Pair pair = TuplesKt.m42317to(trackingConsent, trackingConsent2);
        boolean z8 = true;
        if (Intrinsics.areEqual((Object) pair, (Object) TuplesKt.m42317to(null, TrackingConsent.PENDING))) {
            z = true;
        } else {
            z = Intrinsics.areEqual((Object) pair, (Object) TuplesKt.m42317to(null, TrackingConsent.GRANTED));
        }
        if (z) {
            z2 = true;
        } else {
            z2 = Intrinsics.areEqual((Object) pair, (Object) TuplesKt.m42317to(null, TrackingConsent.NOT_GRANTED));
        }
        if (z2) {
            z3 = true;
        } else {
            z3 = Intrinsics.areEqual((Object) pair, (Object) TuplesKt.m42317to(TrackingConsent.PENDING, TrackingConsent.NOT_GRANTED));
        }
        if (z3) {
            dataMigrationOperation = new WipeDataMigrationOperation(fileOrchestrator.getRootDir(), this.f3521a, this.f3523c);
        } else {
            if (Intrinsics.areEqual((Object) pair, (Object) TuplesKt.m42317to(TrackingConsent.GRANTED, TrackingConsent.PENDING))) {
                z4 = true;
            } else {
                z4 = Intrinsics.areEqual((Object) pair, (Object) TuplesKt.m42317to(TrackingConsent.NOT_GRANTED, TrackingConsent.PENDING));
            }
            if (z4) {
                dataMigrationOperation = new WipeDataMigrationOperation(fileOrchestrator2.getRootDir(), this.f3521a, this.f3523c);
            } else if (Intrinsics.areEqual((Object) pair, (Object) TuplesKt.m42317to(TrackingConsent.PENDING, TrackingConsent.GRANTED))) {
                dataMigrationOperation = new MoveDataMigrationOperation(fileOrchestrator.getRootDir(), fileOrchestrator2.getRootDir(), this.f3521a, this.f3523c);
            } else {
                if (Intrinsics.areEqual((Object) pair, (Object) TuplesKt.m42317to(TrackingConsent.PENDING, TrackingConsent.PENDING))) {
                    z5 = true;
                } else {
                    z5 = Intrinsics.areEqual((Object) pair, (Object) TuplesKt.m42317to(TrackingConsent.GRANTED, TrackingConsent.GRANTED));
                }
                if (z5) {
                    z6 = true;
                } else {
                    z6 = Intrinsics.areEqual((Object) pair, (Object) TuplesKt.m42317to(TrackingConsent.GRANTED, TrackingConsent.NOT_GRANTED));
                }
                if (z6) {
                    z7 = true;
                } else {
                    z7 = Intrinsics.areEqual((Object) pair, (Object) TuplesKt.m42317to(TrackingConsent.NOT_GRANTED, TrackingConsent.NOT_GRANTED));
                }
                if (!z7) {
                    z8 = Intrinsics.areEqual((Object) pair, (Object) TuplesKt.m42317to(TrackingConsent.NOT_GRANTED, TrackingConsent.GRANTED));
                }
                if (z8) {
                    dataMigrationOperation = new NoOpDataMigrationOperation();
                } else {
                    Logger sdkLogger = RuntimeUtilsKt.getSdkLogger();
                    Logger.w$default(sdkLogger, "Unexpected consent migration from " + trackingConsent + " to " + trackingConsent2, (Throwable) null, (Map) null, 6, (Object) null);
                    dataMigrationOperation = new NoOpDataMigrationOperation();
                }
            }
        }
        try {
            this.f3522b.submit(dataMigrationOperation);
        } catch (RejectedExecutionException e) {
            Logger.e$default(this.f3523c, ERROR_REJECTED, e, (Map) null, 4, (Object) null);
        }
    }

    @Metadata(mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo175978d2 = {"Lcom/datadog/android/core/internal/persistence/file/advanced/ConsentAwareFileMigrator$Companion;", "", "()V", "ERROR_REJECTED", "", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: ConsentAwareFileMigrator.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
