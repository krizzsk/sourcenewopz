package com.datadog.android.core.internal.persistence.file.batch;

import com.datadog.android.core.internal.persistence.DataWriter;
import com.datadog.android.core.internal.persistence.PayloadDecoration;
import com.datadog.android.core.internal.persistence.Serializer;
import com.datadog.android.core.internal.persistence.SerializerKt;
import com.datadog.android.core.internal.persistence.file.FileHandler;
import com.datadog.android.core.internal.persistence.file.FileOrchestrator;
import com.datadog.android.log.Logger;
import com.google.firebase.messaging.Constants;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0010\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B3\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\u0015\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\u001cJ\u0017\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00028\u0000H\u0010¢\u0006\u0004\b\u001e\u0010\u001cJ\u001f\u0010\u001f\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00028\u00002\u0006\u0010 \u001a\u00020!H\u0010¢\u0006\u0004\b\"\u0010#J\u0015\u0010$\u001a\u00020\u001a2\u0006\u0010%\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001cJ\u0016\u0010$\u001a\u00020\u001a2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00000&H\u0016J\u0010\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020!H\u0002R\u0014\u0010\b\u001a\u00020\tX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\f\u001a\u00020\rX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006*"}, mo175978d2 = {"Lcom/datadog/android/core/internal/persistence/file/batch/BatchFileDataWriter;", "T", "", "Lcom/datadog/android/core/internal/persistence/DataWriter;", "fileOrchestrator", "Lcom/datadog/android/core/internal/persistence/file/FileOrchestrator;", "serializer", "Lcom/datadog/android/core/internal/persistence/Serializer;", "decoration", "Lcom/datadog/android/core/internal/persistence/PayloadDecoration;", "handler", "Lcom/datadog/android/core/internal/persistence/file/FileHandler;", "internalLogger", "Lcom/datadog/android/log/Logger;", "(Lcom/datadog/android/core/internal/persistence/file/FileOrchestrator;Lcom/datadog/android/core/internal/persistence/Serializer;Lcom/datadog/android/core/internal/persistence/PayloadDecoration;Lcom/datadog/android/core/internal/persistence/file/FileHandler;Lcom/datadog/android/log/Logger;)V", "getDecoration$dd_sdk_android_release", "()Lcom/datadog/android/core/internal/persistence/PayloadDecoration;", "getFileOrchestrator$dd_sdk_android_release", "()Lcom/datadog/android/core/internal/persistence/file/FileOrchestrator;", "getHandler$dd_sdk_android_release", "()Lcom/datadog/android/core/internal/persistence/file/FileHandler;", "getInternalLogger$dd_sdk_android_release", "()Lcom/datadog/android/log/Logger;", "getSerializer$dd_sdk_android_release", "()Lcom/datadog/android/core/internal/persistence/Serializer;", "consume", "", "data", "(Ljava/lang/Object;)V", "onDataWriteFailed", "onDataWriteFailed$dd_sdk_android_release", "onDataWritten", "rawData", "", "onDataWritten$dd_sdk_android_release", "(Ljava/lang/Object;[B)V", "write", "element", "", "writeData", "", "byteArray", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: BatchFileDataWriter.kt */
public class BatchFileDataWriter<T> implements DataWriter<T> {

    /* renamed from: a */
    private final FileOrchestrator f3551a;

    /* renamed from: b */
    private final Serializer<T> f3552b;

    /* renamed from: c */
    private final PayloadDecoration f3553c;

    /* renamed from: d */
    private final FileHandler f3554d;

    /* renamed from: e */
    private final Logger f3555e;

    public void onDataWriteFailed$dd_sdk_android_release(T t) {
        Intrinsics.checkNotNullParameter(t, "data");
    }

    public void onDataWritten$dd_sdk_android_release(T t, byte[] bArr) {
        Intrinsics.checkNotNullParameter(t, "data");
        Intrinsics.checkNotNullParameter(bArr, Constants.MessagePayloadKeys.RAW_DATA);
    }

    public BatchFileDataWriter(FileOrchestrator fileOrchestrator, Serializer<T> serializer, PayloadDecoration payloadDecoration, FileHandler fileHandler, Logger logger) {
        Intrinsics.checkNotNullParameter(fileOrchestrator, "fileOrchestrator");
        Intrinsics.checkNotNullParameter(serializer, "serializer");
        Intrinsics.checkNotNullParameter(payloadDecoration, "decoration");
        Intrinsics.checkNotNullParameter(fileHandler, "handler");
        Intrinsics.checkNotNullParameter(logger, "internalLogger");
        this.f3551a = fileOrchestrator;
        this.f3552b = serializer;
        this.f3553c = payloadDecoration;
        this.f3554d = fileHandler;
        this.f3555e = logger;
    }

    public final FileOrchestrator getFileOrchestrator$dd_sdk_android_release() {
        return this.f3551a;
    }

    public final Serializer<T> getSerializer$dd_sdk_android_release() {
        return this.f3552b;
    }

    public final PayloadDecoration getDecoration$dd_sdk_android_release() {
        return this.f3553c;
    }

    public final FileHandler getHandler$dd_sdk_android_release() {
        return this.f3554d;
    }

    public final Logger getInternalLogger$dd_sdk_android_release() {
        return this.f3555e;
    }

    public void write(T t) {
        Intrinsics.checkNotNullParameter(t, "element");
        m2348a(t);
    }

    public void write(List<? extends T> list) {
        Intrinsics.checkNotNullParameter(list, "data");
        for (Object a : list) {
            m2348a(a);
        }
    }

    /* renamed from: a */
    private final void m2348a(T t) {
        byte[] serializeToByteArray = SerializerKt.serializeToByteArray(this.f3552b, t, this.f3555e);
        if (serializeToByteArray != null) {
            synchronized (this) {
                if (m2349a(serializeToByteArray)) {
                    onDataWritten$dd_sdk_android_release(t, serializeToByteArray);
                } else {
                    onDataWriteFailed$dd_sdk_android_release(t);
                }
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    /* renamed from: a */
    private final boolean m2349a(byte[] bArr) {
        File writableFile = this.f3551a.getWritableFile(bArr.length);
        if (writableFile == null) {
            return false;
        }
        return this.f3554d.writeData(writableFile, bArr, true, this.f3553c.getSeparatorBytes());
    }
}
