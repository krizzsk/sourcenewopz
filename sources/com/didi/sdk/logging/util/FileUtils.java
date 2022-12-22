package com.didi.sdk.logging.util;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J1\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0016\u0010\u0006\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\b0\u0007\"\u0004\u0018\u00010\bH\u0007¢\u0006\u0002\u0010\tJ\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0004H\u0007J\u0010\u0010\r\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fJ\u0016\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u00112\u0006\u0010\f\u001a\u00020\u0004H\u0007J\u0010\u0010\u0012\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0004¨\u0006\u0013"}, mo175978d2 = {"Lcom/didi/sdk/logging/util/FileUtils;", "", "()V", "buildPath", "Ljava/io/File;", "base", "segments", "", "", "(Ljava/io/File;[Ljava/lang/String;)Ljava/io/File;", "cleanDir", "", "file", "closeQuietly", "closeable", "Ljava/io/Closeable;", "collectAllFiles", "", "deleteFile", "api_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: FileUtils.kt */
public final class FileUtils {
    public static final FileUtils INSTANCE = new FileUtils();

    private FileUtils() {
    }

    public final void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    @JvmStatic
    public static final void cleanDir(File file) {
        File[] listFiles;
        if (file != null && file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null) {
            for (File deleteFile : listFiles) {
                INSTANCE.deleteFile(deleteFile);
            }
        }
    }

    public final void deleteFile(File file) {
        File[] listFiles;
        if (file != null && file.exists()) {
            if (file.isDirectory() && (listFiles = file.listFiles()) != null) {
                for (File deleteFile : listFiles) {
                    deleteFile(deleteFile);
                }
            }
            file.delete();
        }
    }

    @JvmStatic
    public static final List<File> collectAllFiles(File file) {
        Intrinsics.checkParameterIsNotNull(file, "file");
        if (file.exists()) {
            List<File> arrayList = new ArrayList<>();
            if (!file.isDirectory()) {
                return arrayList;
            }
            LinkedList linkedList = new LinkedList();
            linkedList.push(file);
            while (!linkedList.isEmpty()) {
                File[] listFiles = ((File) linkedList.pop()).listFiles();
                if (listFiles != null) {
                    for (File file2 : listFiles) {
                        Intrinsics.checkExpressionValueIsNotNull(file2, "f");
                        if (!file2.isDirectory()) {
                            arrayList.add(file2);
                        } else {
                            linkedList.push(file2);
                        }
                    }
                }
            }
            return arrayList;
        }
        throw new IllegalArgumentException(file + " does not exist");
    }

    @JvmStatic
    public static final File buildPath(File file, String... strArr) {
        Intrinsics.checkParameterIsNotNull(strArr, "segments");
        for (String str : strArr) {
            if (file == null) {
                file = new File(str);
            } else {
                file = new File(file, str);
            }
        }
        return file;
    }
}
