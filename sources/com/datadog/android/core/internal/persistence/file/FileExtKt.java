package com.datadog.android.core.internal.persistence.file;

import com.datadog.android.core.internal.utils.RuntimeUtilsKt;
import com.datadog.android.log.Logger;
import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000F\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\f\u0010\u0003\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\f\u0010\u0004\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\f\u0010\u0005\u001a\u00020\u0006*\u00020\u0002H\u0000\u001a\f\u0010\u0007\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\f\u0010\b\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\f\u0010\t\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\f\u0010\n\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\f\u0010\u000b\u001a\u00020\f*\u00020\u0002H\u0000\u001a\u0019\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000e*\u00020\u0002H\u0000¢\u0006\u0002\u0010\u000f\u001a!\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000e*\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0011H\u0000¢\u0006\u0002\u0010\u0012\u001a!\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000e*\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0013H\u0000¢\u0006\u0002\u0010\u0014\u001a\u0019\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u000e*\u00020\u0002H\u0000¢\u0006\u0002\u0010\u0017\u001a!\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u000e*\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0013H\u0000¢\u0006\u0002\u0010\u0018\u001a\f\u0010\u0019\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\f\u0010\u001a\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\u0014\u0010\u001b\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u0002H\u0000\u001a8\u0010\u001d\u001a\u0002H\u001e\"\u0004\b\u0000\u0010\u001e*\u00020\u00022\u0006\u0010\u001f\u001a\u0002H\u001e2\u0017\u0010 \u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u0002H\u001e0!¢\u0006\u0002\b\"H\u0002¢\u0006\u0002\u0010#¨\u0006$"}, mo175978d2 = {"canReadSafe", "", "Ljava/io/File;", "canWriteSafe", "createNewFileSafe", "deleteOnExitSafe", "", "deleteSafe", "existsSafe", "isDirectorySafe", "isFileSafe", "lengthSafe", "", "listFilesSafe", "", "(Ljava/io/File;)[Ljava/io/File;", "filter", "Ljava/io/FileFilter;", "(Ljava/io/File;Ljava/io/FileFilter;)[Ljava/io/File;", "Ljava/io/FilenameFilter;", "(Ljava/io/File;Ljava/io/FilenameFilter;)[Ljava/io/File;", "listSafe", "", "(Ljava/io/File;)[Ljava/lang/String;", "(Ljava/io/File;Ljava/io/FilenameFilter;)[Ljava/lang/String;", "mkdirSafe", "mkdirsSafe", "renameToSafe", "dest", "safeCall", "T", "default", "lambda", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "(Ljava/io/File;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "dd-sdk-android_release"}, mo175979k = 2, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: FileExt.kt */
public final class FileExtKt {
    /* renamed from: a */
    private static final <T> T m2339a(File file, T t, Function1<? super File, ? extends T> function1) {
        try {
            return function1.invoke(file);
        } catch (SecurityException e) {
            Logger.e$default(RuntimeUtilsKt.getSdkLogger(), Intrinsics.stringPlus("Security exception was thrown for file ", file.getPath()), e, (Map) null, 4, (Object) null);
            return t;
        }
    }

    public static final boolean canWriteSafe(File file) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        return ((Boolean) m2339a(file, false, FileExtKt$canWriteSafe$1.INSTANCE)).booleanValue();
    }

    public static final boolean canReadSafe(File file) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        return ((Boolean) m2339a(file, false, FileExtKt$canReadSafe$1.INSTANCE)).booleanValue();
    }

    public static final boolean createNewFileSafe(File file) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        return ((Boolean) m2339a(file, false, FileExtKt$createNewFileSafe$1.INSTANCE)).booleanValue();
    }

    public static final boolean deleteSafe(File file) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        return ((Boolean) m2339a(file, false, FileExtKt$deleteSafe$1.INSTANCE)).booleanValue();
    }

    public static final void deleteOnExitSafe(File file) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        m2339a(file, Unit.INSTANCE, FileExtKt$deleteOnExitSafe$1.INSTANCE);
    }

    public static final boolean existsSafe(File file) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        return ((Boolean) m2339a(file, false, FileExtKt$existsSafe$1.INSTANCE)).booleanValue();
    }

    public static final boolean isFileSafe(File file) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        return ((Boolean) m2339a(file, false, FileExtKt$isFileSafe$1.INSTANCE)).booleanValue();
    }

    public static final boolean isDirectorySafe(File file) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        return ((Boolean) m2339a(file, false, FileExtKt$isDirectorySafe$1.INSTANCE)).booleanValue();
    }

    public static final String[] listSafe(File file) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        return (String[]) m2339a(file, (Object) null, FileExtKt$listSafe$1.INSTANCE);
    }

    public static final String[] listSafe(File file, FilenameFilter filenameFilter) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        Intrinsics.checkNotNullParameter(filenameFilter, "filter");
        return (String[]) m2339a(file, (Object) null, new FileExtKt$listSafe$2(filenameFilter));
    }

    public static final File[] listFilesSafe(File file) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        return (File[]) m2339a(file, (Object) null, FileExtKt$listFilesSafe$1.INSTANCE);
    }

    public static final File[] listFilesSafe(File file, FilenameFilter filenameFilter) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        Intrinsics.checkNotNullParameter(filenameFilter, "filter");
        return (File[]) m2339a(file, (Object) null, new FileExtKt$listFilesSafe$2(filenameFilter));
    }

    public static final File[] listFilesSafe(File file, FileFilter fileFilter) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        Intrinsics.checkNotNullParameter(fileFilter, "filter");
        return (File[]) m2339a(file, (Object) null, new FileExtKt$listFilesSafe$3(fileFilter));
    }

    public static final long lengthSafe(File file) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        return ((Number) m2339a(file, 0L, FileExtKt$lengthSafe$1.INSTANCE)).longValue();
    }

    public static final boolean mkdirSafe(File file) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        return ((Boolean) m2339a(file, false, FileExtKt$mkdirSafe$1.INSTANCE)).booleanValue();
    }

    public static final boolean mkdirsSafe(File file) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        return ((Boolean) m2339a(file, false, FileExtKt$mkdirsSafe$1.INSTANCE)).booleanValue();
    }

    public static final boolean renameToSafe(File file, File file2) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        Intrinsics.checkNotNullParameter(file2, "dest");
        return ((Boolean) m2339a(file, false, new FileExtKt$renameToSafe$1(file2))).booleanValue();
    }
}
