package com.datadog.android.core.internal.persistence;

import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\ba\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0005H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\t"}, mo175978d2 = {"Lcom/datadog/android/core/internal/persistence/DataReader;", "", "drop", "", "data", "Lcom/datadog/android/core/internal/persistence/Batch;", "dropAll", "lockAndReadNext", "release", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: DataReader.kt */
public interface DataReader {
    void drop(Batch batch);

    void dropAll();

    Batch lockAndReadNext();

    void release(Batch batch);
}
