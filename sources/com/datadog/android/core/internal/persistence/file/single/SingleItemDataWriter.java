package com.datadog.android.core.internal.persistence.file.single;

import com.datadog.android.core.internal.persistence.DataWriter;
import com.datadog.android.core.internal.persistence.Serializer;
import com.datadog.android.core.internal.persistence.SerializerKt;
import com.datadog.android.core.internal.persistence.file.FileHandler;
import com.datadog.android.core.internal.persistence.file.FileOrchestrator;
import com.datadog.android.log.Logger;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0012\n\u0000\b\u0010\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B+\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u0015\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\u0018J\u0015\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0018J\u0016\u0010\u0019\u001a\u00020\u00162\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u001bH\u0016J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002R\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\b\u001a\u00020\tX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006 "}, mo175978d2 = {"Lcom/datadog/android/core/internal/persistence/file/single/SingleItemDataWriter;", "T", "", "Lcom/datadog/android/core/internal/persistence/DataWriter;", "fileOrchestrator", "Lcom/datadog/android/core/internal/persistence/file/FileOrchestrator;", "serializer", "Lcom/datadog/android/core/internal/persistence/Serializer;", "handler", "Lcom/datadog/android/core/internal/persistence/file/FileHandler;", "internalLogger", "Lcom/datadog/android/log/Logger;", "(Lcom/datadog/android/core/internal/persistence/file/FileOrchestrator;Lcom/datadog/android/core/internal/persistence/Serializer;Lcom/datadog/android/core/internal/persistence/file/FileHandler;Lcom/datadog/android/log/Logger;)V", "getFileOrchestrator$dd_sdk_android_release", "()Lcom/datadog/android/core/internal/persistence/file/FileOrchestrator;", "getHandler$dd_sdk_android_release", "()Lcom/datadog/android/core/internal/persistence/file/FileHandler;", "getInternalLogger$dd_sdk_android_release", "()Lcom/datadog/android/log/Logger;", "getSerializer$dd_sdk_android_release", "()Lcom/datadog/android/core/internal/persistence/Serializer;", "consume", "", "data", "(Ljava/lang/Object;)V", "write", "element", "", "writeData", "", "byteArray", "", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: SingleItemDataWriter.kt */
public class SingleItemDataWriter<T> implements DataWriter<T> {

    /* renamed from: a */
    private final FileOrchestrator f3574a;

    /* renamed from: b */
    private final Serializer<T> f3575b;

    /* renamed from: c */
    private final FileHandler f3576c;

    /* renamed from: d */
    private final Logger f3577d;

    public SingleItemDataWriter(FileOrchestrator fileOrchestrator, Serializer<T> serializer, FileHandler fileHandler, Logger logger) {
        Intrinsics.checkNotNullParameter(fileOrchestrator, "fileOrchestrator");
        Intrinsics.checkNotNullParameter(serializer, "serializer");
        Intrinsics.checkNotNullParameter(fileHandler, "handler");
        Intrinsics.checkNotNullParameter(logger, "internalLogger");
        this.f3574a = fileOrchestrator;
        this.f3575b = serializer;
        this.f3576c = fileHandler;
        this.f3577d = logger;
    }

    public final FileOrchestrator getFileOrchestrator$dd_sdk_android_release() {
        return this.f3574a;
    }

    public final Serializer<T> getSerializer$dd_sdk_android_release() {
        return this.f3575b;
    }

    public final FileHandler getHandler$dd_sdk_android_release() {
        return this.f3576c;
    }

    public final Logger getInternalLogger$dd_sdk_android_release() {
        return this.f3577d;
    }

    public void write(T t) {
        Intrinsics.checkNotNullParameter(t, "element");
        m2361a(t);
    }

    public void write(List<? extends T> list) {
        Intrinsics.checkNotNullParameter(list, "data");
        m2361a(CollectionsKt.last(list));
    }

    /* renamed from: a */
    private final void m2361a(T t) {
        byte[] serializeToByteArray = SerializerKt.serializeToByteArray(this.f3575b, t, this.f3577d);
        if (serializeToByteArray != null) {
            synchronized (this) {
                m2362a(serializeToByteArray);
            }
        }
    }

    /* renamed from: a */
    private final boolean m2362a(byte[] bArr) {
        File writableFile = this.f3574a.getWritableFile(bArr.length);
        if (writableFile == null) {
            return false;
        }
        return this.f3576c.writeData(writableFile, bArr, false, (byte[]) null);
    }
}
