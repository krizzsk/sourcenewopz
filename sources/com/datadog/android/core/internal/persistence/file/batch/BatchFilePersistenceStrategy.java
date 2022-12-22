package com.datadog.android.core.internal.persistence.file.batch;

import com.datadog.android.core.internal.data.upload.DataFlusher;
import com.datadog.android.core.internal.data.upload.Flusher;
import com.datadog.android.core.internal.persistence.DataReader;
import com.datadog.android.core.internal.persistence.DataWriter;
import com.datadog.android.core.internal.persistence.PayloadDecoration;
import com.datadog.android.core.internal.persistence.PersistenceStrategy;
import com.datadog.android.core.internal.persistence.Serializer;
import com.datadog.android.core.internal.persistence.file.FileOrchestrator;
import com.datadog.android.core.internal.persistence.file.advanced.ScheduledWriter;
import com.datadog.android.log.Logger;
import java.util.concurrent.ExecutorService;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0010\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B3\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJA\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00162\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0010¢\u0006\u0002\b\u001cJ\b\u0010\u001d\u001a\u00020\u001eH\u0016J\b\u0010\u001f\u001a\u00020 H\u0016J\u000e\u0010!\u001a\b\u0012\u0004\u0012\u00028\u00000\u0016H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000R!\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u00168BX\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0017\u0010\u0018R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, mo175978d2 = {"Lcom/datadog/android/core/internal/persistence/file/batch/BatchFilePersistenceStrategy;", "T", "", "Lcom/datadog/android/core/internal/persistence/PersistenceStrategy;", "fileOrchestrator", "Lcom/datadog/android/core/internal/persistence/file/FileOrchestrator;", "executorService", "Ljava/util/concurrent/ExecutorService;", "serializer", "Lcom/datadog/android/core/internal/persistence/Serializer;", "payloadDecoration", "Lcom/datadog/android/core/internal/persistence/PayloadDecoration;", "internalLogger", "Lcom/datadog/android/log/Logger;", "(Lcom/datadog/android/core/internal/persistence/file/FileOrchestrator;Ljava/util/concurrent/ExecutorService;Lcom/datadog/android/core/internal/persistence/Serializer;Lcom/datadog/android/core/internal/persistence/PayloadDecoration;Lcom/datadog/android/log/Logger;)V", "fileHandler", "Lcom/datadog/android/core/internal/persistence/file/batch/BatchFileHandler;", "getFileHandler$dd_sdk_android_release", "()Lcom/datadog/android/core/internal/persistence/file/batch/BatchFileHandler;", "fileReader", "Lcom/datadog/android/core/internal/persistence/file/batch/BatchFileDataReader;", "fileWriter", "Lcom/datadog/android/core/internal/persistence/DataWriter;", "getFileWriter", "()Lcom/datadog/android/core/internal/persistence/DataWriter;", "fileWriter$delegate", "Lkotlin/Lazy;", "createWriter", "createWriter$dd_sdk_android_release", "getFlusher", "Lcom/datadog/android/core/internal/data/upload/Flusher;", "getReader", "Lcom/datadog/android/core/internal/persistence/DataReader;", "getWriter", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: BatchFilePersistenceStrategy.kt */
public class BatchFilePersistenceStrategy<T> implements PersistenceStrategy<T> {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final FileOrchestrator f3567a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final ExecutorService f3568b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final PayloadDecoration f3569c;

    /* renamed from: d */
    private final BatchFileHandler f3570d;

    /* renamed from: e */
    private final Lazy f3571e;

    /* renamed from: f */
    private final BatchFileDataReader f3572f;

    public BatchFilePersistenceStrategy(FileOrchestrator fileOrchestrator, ExecutorService executorService, Serializer<T> serializer, PayloadDecoration payloadDecoration, Logger logger) {
        Intrinsics.checkNotNullParameter(fileOrchestrator, "fileOrchestrator");
        Intrinsics.checkNotNullParameter(executorService, "executorService");
        Intrinsics.checkNotNullParameter(serializer, "serializer");
        Intrinsics.checkNotNullParameter(payloadDecoration, "payloadDecoration");
        Intrinsics.checkNotNullParameter(logger, "internalLogger");
        this.f3567a = fileOrchestrator;
        this.f3568b = executorService;
        this.f3569c = payloadDecoration;
        this.f3570d = new BatchFileHandler(logger);
        this.f3571e = LazyKt.lazy(new BatchFilePersistenceStrategy$fileWriter$2(this, serializer, logger));
        this.f3572f = new BatchFileDataReader(this.f3567a, this.f3569c, this.f3570d, logger);
    }

    public final BatchFileHandler getFileHandler$dd_sdk_android_release() {
        return this.f3570d;
    }

    /* renamed from: a */
    private final DataWriter<T> m2360a() {
        return (DataWriter) this.f3571e.getValue();
    }

    public DataWriter<T> getWriter() {
        return m2360a();
    }

    public DataReader getReader() {
        return this.f3572f;
    }

    public Flusher getFlusher() {
        return new DataFlusher(this.f3567a, this.f3569c, this.f3570d);
    }

    public DataWriter<T> createWriter$dd_sdk_android_release(FileOrchestrator fileOrchestrator, ExecutorService executorService, Serializer<T> serializer, PayloadDecoration payloadDecoration, Logger logger) {
        Intrinsics.checkNotNullParameter(fileOrchestrator, "fileOrchestrator");
        Intrinsics.checkNotNullParameter(executorService, "executorService");
        Intrinsics.checkNotNullParameter(serializer, "serializer");
        Intrinsics.checkNotNullParameter(payloadDecoration, "payloadDecoration");
        Intrinsics.checkNotNullParameter(logger, "internalLogger");
        return new ScheduledWriter<>(new BatchFileDataWriter(fileOrchestrator, serializer, payloadDecoration, this.f3570d, logger), executorService, logger);
    }
}
