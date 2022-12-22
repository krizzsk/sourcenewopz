package com.datadog.android.core.internal.persistence.file.batch;

import com.datadog.android.core.internal.persistence.Batch;
import com.datadog.android.core.internal.persistence.DataReader;
import com.datadog.android.core.internal.persistence.PayloadDecoration;
import com.datadog.android.core.internal.persistence.file.FileHandler;
import com.datadog.android.core.internal.persistence.file.FileOrchestrator;
import com.datadog.android.log.Logger;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0000\u0018\u0000 %2\u00020\u0001:\u0001%B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0015H\u0002J\u0010\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u0017H\u0016J\n\u0010\u001d\u001a\u0004\u0018\u00010\u0015H\u0002J\n\u0010\u001e\u001a\u0004\u0018\u00010\u001bH\u0016J\u0010\u0010\u001f\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0018\u0010 \u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00152\u0006\u0010!\u001a\u00020\"H\u0002J\u0018\u0010 \u001a\u00020\u00172\u0006\u0010#\u001a\u00020$2\u0006\u0010!\u001a\u00020\"H\u0002R\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\b\u001a\u00020\tX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014X\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, mo175978d2 = {"Lcom/datadog/android/core/internal/persistence/file/batch/BatchFileDataReader;", "Lcom/datadog/android/core/internal/persistence/DataReader;", "fileOrchestrator", "Lcom/datadog/android/core/internal/persistence/file/FileOrchestrator;", "decoration", "Lcom/datadog/android/core/internal/persistence/PayloadDecoration;", "handler", "Lcom/datadog/android/core/internal/persistence/file/FileHandler;", "internalLogger", "Lcom/datadog/android/log/Logger;", "(Lcom/datadog/android/core/internal/persistence/file/FileOrchestrator;Lcom/datadog/android/core/internal/persistence/PayloadDecoration;Lcom/datadog/android/core/internal/persistence/file/FileHandler;Lcom/datadog/android/log/Logger;)V", "getDecoration$dd_sdk_android_release", "()Lcom/datadog/android/core/internal/persistence/PayloadDecoration;", "getFileOrchestrator$dd_sdk_android_release", "()Lcom/datadog/android/core/internal/persistence/file/FileOrchestrator;", "getHandler$dd_sdk_android_release", "()Lcom/datadog/android/core/internal/persistence/file/FileHandler;", "getInternalLogger$dd_sdk_android_release", "()Lcom/datadog/android/log/Logger;", "lockedFiles", "", "Ljava/io/File;", "deleteFile", "", "file", "drop", "data", "Lcom/datadog/android/core/internal/persistence/Batch;", "dropAll", "getAndLockReadableFile", "lockAndReadNext", "release", "releaseFile", "delete", "", "fileName", "", "Companion", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: BatchFileDataReader.kt */
public final class BatchFileDataReader implements DataReader {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String WARNING_DELETE_FAILED = "Unable to delete file: %s";
    public static final String WARNING_UNKNOWN_BATCH_ID = "Attempting to unlock or delete an unknown file: %s";

    /* renamed from: a */
    private final FileOrchestrator f3546a;

    /* renamed from: b */
    private final PayloadDecoration f3547b;

    /* renamed from: c */
    private final FileHandler f3548c;

    /* renamed from: d */
    private final Logger f3549d;

    /* renamed from: e */
    private final List<File> f3550e = new ArrayList();

    public BatchFileDataReader(FileOrchestrator fileOrchestrator, PayloadDecoration payloadDecoration, FileHandler fileHandler, Logger logger) {
        Intrinsics.checkNotNullParameter(fileOrchestrator, "fileOrchestrator");
        Intrinsics.checkNotNullParameter(payloadDecoration, "decoration");
        Intrinsics.checkNotNullParameter(fileHandler, "handler");
        Intrinsics.checkNotNullParameter(logger, "internalLogger");
        this.f3546a = fileOrchestrator;
        this.f3547b = payloadDecoration;
        this.f3548c = fileHandler;
        this.f3549d = logger;
    }

    public final FileOrchestrator getFileOrchestrator$dd_sdk_android_release() {
        return this.f3546a;
    }

    public final PayloadDecoration getDecoration$dd_sdk_android_release() {
        return this.f3547b;
    }

    public final FileHandler getHandler$dd_sdk_android_release() {
        return this.f3548c;
    }

    public final Logger getInternalLogger$dd_sdk_android_release() {
        return this.f3549d;
    }

    public Batch lockAndReadNext() {
        File a = m2344a();
        if (a == null) {
            return null;
        }
        byte[] readData = this.f3548c.readData(a, this.f3547b.getPrefixBytes(), this.f3547b.getSuffixBytes());
        String name = a.getName();
        Intrinsics.checkNotNullExpressionValue(name, "file.name");
        return new Batch(name, readData);
    }

    public void release(Batch batch) {
        Intrinsics.checkNotNullParameter(batch, "data");
        m2347a(batch.getId(), false);
    }

    public void drop(Batch batch) {
        Intrinsics.checkNotNullParameter(batch, "data");
        m2347a(batch.getId(), true);
    }

    public void dropAll() {
        synchronized (this.f3550e) {
            Object[] array = this.f3550e.toArray(new File[0]);
            if (array != null) {
                for (Object obj : array) {
                    m2346a((File) obj, true);
                }
                Unit unit = Unit.INSTANCE;
            } else {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
            }
        }
        for (File a : this.f3546a.getAllFiles()) {
            m2345a(a);
        }
    }

    /* renamed from: a */
    private final File m2344a() {
        File readableFile;
        synchronized (this.f3550e) {
            readableFile = getFileOrchestrator$dd_sdk_android_release().getReadableFile(CollectionsKt.toSet(this.f3550e));
            if (readableFile != null) {
                this.f3550e.add(readableFile);
            }
        }
        return readableFile;
    }

    /* renamed from: a */
    private final void m2347a(String str, boolean z) {
        Object obj;
        File file;
        synchronized (this.f3550e) {
            Iterator it = this.f3550e.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (Intrinsics.areEqual((Object) ((File) obj).getName(), (Object) str)) {
                    break;
                }
            }
            file = (File) obj;
        }
        if (file != null) {
            m2346a(file, z);
            return;
        }
        Logger logger = this.f3549d;
        String format = String.format(Locale.US, WARNING_UNKNOWN_BATCH_ID, Arrays.copyOf(new Object[]{str}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(locale, this, *args)");
        Logger.w$default(logger, format, (Throwable) null, (Map) null, 6, (Object) null);
    }

    /* renamed from: a */
    private final void m2346a(File file, boolean z) {
        if (z) {
            m2345a(file);
        }
        synchronized (this.f3550e) {
            this.f3550e.remove(file);
        }
    }

    /* renamed from: a */
    private final void m2345a(File file) {
        if (!this.f3548c.delete(file)) {
            Logger logger = this.f3549d;
            String format = String.format(Locale.US, "Unable to delete file: %s", Arrays.copyOf(new Object[]{file.getPath()}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(locale, this, *args)");
            Logger.w$default(logger, format, (Throwable) null, (Map) null, 6, (Object) null);
        }
    }

    @Metadata(mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, mo175978d2 = {"Lcom/datadog/android/core/internal/persistence/file/batch/BatchFileDataReader$Companion;", "", "()V", "WARNING_DELETE_FAILED", "", "WARNING_UNKNOWN_BATCH_ID", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: BatchFileDataReader.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
