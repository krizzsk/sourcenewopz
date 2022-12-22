package com.datadog.android.core.internal.data.upload;

import com.datadog.android.core.internal.net.DataUploader;
import com.datadog.android.core.internal.persistence.PayloadDecoration;
import com.datadog.android.core.internal.persistence.file.FileHandler;
import com.datadog.android.core.internal.persistence.file.FileOrchestrator;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0013"}, mo175978d2 = {"Lcom/datadog/android/core/internal/data/upload/DataFlusher;", "Lcom/datadog/android/core/internal/data/upload/Flusher;", "fileOrchestrator", "Lcom/datadog/android/core/internal/persistence/file/FileOrchestrator;", "decoration", "Lcom/datadog/android/core/internal/persistence/PayloadDecoration;", "handler", "Lcom/datadog/android/core/internal/persistence/file/FileHandler;", "(Lcom/datadog/android/core/internal/persistence/file/FileOrchestrator;Lcom/datadog/android/core/internal/persistence/PayloadDecoration;Lcom/datadog/android/core/internal/persistence/file/FileHandler;)V", "getDecoration$dd_sdk_android_release", "()Lcom/datadog/android/core/internal/persistence/PayloadDecoration;", "getFileOrchestrator$dd_sdk_android_release", "()Lcom/datadog/android/core/internal/persistence/file/FileOrchestrator;", "getHandler$dd_sdk_android_release", "()Lcom/datadog/android/core/internal/persistence/file/FileHandler;", "flush", "", "uploader", "Lcom/datadog/android/core/internal/net/DataUploader;", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: DataFlusher.kt */
public final class DataFlusher implements Flusher {

    /* renamed from: a */
    private final FileOrchestrator f3450a;

    /* renamed from: b */
    private final PayloadDecoration f3451b;

    /* renamed from: c */
    private final FileHandler f3452c;

    public DataFlusher(FileOrchestrator fileOrchestrator, PayloadDecoration payloadDecoration, FileHandler fileHandler) {
        Intrinsics.checkNotNullParameter(fileOrchestrator, "fileOrchestrator");
        Intrinsics.checkNotNullParameter(payloadDecoration, "decoration");
        Intrinsics.checkNotNullParameter(fileHandler, "handler");
        this.f3450a = fileOrchestrator;
        this.f3451b = payloadDecoration;
        this.f3452c = fileHandler;
    }

    public final FileOrchestrator getFileOrchestrator$dd_sdk_android_release() {
        return this.f3450a;
    }

    public final PayloadDecoration getDecoration$dd_sdk_android_release() {
        return this.f3451b;
    }

    public final FileHandler getHandler$dd_sdk_android_release() {
        return this.f3452c;
    }

    public void flush(DataUploader dataUploader) {
        Intrinsics.checkNotNullParameter(dataUploader, "uploader");
        for (File file : this.f3450a.getFlushableFiles()) {
            dataUploader.upload(getHandler$dd_sdk_android_release().readData(file, getDecoration$dd_sdk_android_release().getPrefixBytes(), getDecoration$dd_sdk_android_release().getSuffixBytes()));
            getHandler$dd_sdk_android_release().delete(file);
        }
    }
}
