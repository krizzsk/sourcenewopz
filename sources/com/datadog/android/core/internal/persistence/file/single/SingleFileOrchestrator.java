package com.datadog.android.core.internal.persistence.file.single;

import com.datadog.android.core.internal.persistence.file.FileExtKt;
import com.datadog.android.core.internal.persistence.file.FileOrchestrator;
import java.io.File;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006H\u0016J\u000e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006H\u0016J\u0018\u0010\b\u001a\u0004\u0018\u00010\u00032\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\nH\u0016J\n\u0010\u000b\u001a\u0004\u0018\u00010\u0003H\u0016J\u0012\u0010\f\u001a\u0004\u0018\u00010\u00032\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, mo175978d2 = {"Lcom/datadog/android/core/internal/persistence/file/single/SingleFileOrchestrator;", "Lcom/datadog/android/core/internal/persistence/file/FileOrchestrator;", "file", "Ljava/io/File;", "(Ljava/io/File;)V", "getAllFiles", "", "getFlushableFiles", "getReadableFile", "excludeFiles", "", "getRootDir", "getWritableFile", "dataSize", "", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: SingleFileOrchestrator.kt */
public final class SingleFileOrchestrator implements FileOrchestrator {

    /* renamed from: a */
    private final File f3573a;

    public File getRootDir() {
        return null;
    }

    public SingleFileOrchestrator(File file) {
        Intrinsics.checkNotNullParameter(file, "file");
        this.f3573a = file;
    }

    public File getWritableFile(int i) {
        File parentFile = this.f3573a.getParentFile();
        if (parentFile != null) {
            FileExtKt.mkdirsSafe(parentFile);
        }
        return this.f3573a;
    }

    public File getReadableFile(Set<? extends File> set) {
        Intrinsics.checkNotNullParameter(set, "excludeFiles");
        File parentFile = this.f3573a.getParentFile();
        if (parentFile != null) {
            FileExtKt.mkdirsSafe(parentFile);
        }
        if (set.contains(this.f3573a)) {
            return null;
        }
        return this.f3573a;
    }

    public List<File> getAllFiles() {
        File parentFile = this.f3573a.getParentFile();
        if (parentFile != null) {
            FileExtKt.mkdirsSafe(parentFile);
        }
        return CollectionsKt.listOf(this.f3573a);
    }

    public List<File> getFlushableFiles() {
        return getAllFiles();
    }
}
