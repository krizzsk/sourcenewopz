package com.datadog.android.core.internal.persistence.file.batch;

import com.datadog.android.core.internal.persistence.DataWriter;
import com.datadog.android.core.internal.persistence.Serializer;
import com.datadog.android.log.Logger;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175977d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003H\n"}, mo175978d2 = {"<anonymous>", "Lcom/datadog/android/core/internal/persistence/DataWriter;", "T", ""}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: BatchFilePersistenceStrategy.kt */
final class BatchFilePersistenceStrategy$fileWriter$2 extends Lambda implements Function0<DataWriter<T>> {
    final /* synthetic */ Logger $internalLogger;
    final /* synthetic */ Serializer<T> $serializer;
    final /* synthetic */ BatchFilePersistenceStrategy<T> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BatchFilePersistenceStrategy$fileWriter$2(BatchFilePersistenceStrategy<T> batchFilePersistenceStrategy, Serializer<T> serializer, Logger logger) {
        super(0);
        this.this$0 = batchFilePersistenceStrategy;
        this.$serializer = serializer;
        this.$internalLogger = logger;
    }

    public final DataWriter<T> invoke() {
        BatchFilePersistenceStrategy<T> batchFilePersistenceStrategy = this.this$0;
        return batchFilePersistenceStrategy.createWriter$dd_sdk_android_release(batchFilePersistenceStrategy.f3567a, this.this$0.f3568b, this.$serializer, this.this$0.f3569c, this.$internalLogger);
    }
}
