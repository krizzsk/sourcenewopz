package com.datadog.android.core.internal.persistence.file;

import java.io.File;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\b\b`\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005H&J(\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\nH&J.\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\n2\b\b\u0002\u0010\u0010\u001a\u00020\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\nH&¨\u0006\u0012"}, mo175978d2 = {"Lcom/datadog/android/core/internal/persistence/file/FileHandler;", "", "delete", "", "target", "Ljava/io/File;", "moveFiles", "srcDir", "destDir", "readData", "", "file", "prefix", "suffix", "writeData", "data", "append", "separator", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: FileHandler.kt */
public interface FileHandler {
    boolean delete(File file);

    boolean moveFiles(File file, File file2);

    byte[] readData(File file, byte[] bArr, byte[] bArr2);

    boolean writeData(File file, byte[] bArr, boolean z, byte[] bArr2);

    @Metadata(mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: FileHandler.kt */
    public static final class DefaultImpls {
        public static /* synthetic */ boolean writeData$default(FileHandler fileHandler, File file, byte[] bArr, boolean z, byte[] bArr2, int i, Object obj) {
            if (obj == null) {
                if ((i & 4) != 0) {
                    z = false;
                }
                if ((i & 8) != 0) {
                    bArr2 = null;
                }
                return fileHandler.writeData(file, bArr, z, bArr2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: writeData");
        }

        public static /* synthetic */ byte[] readData$default(FileHandler fileHandler, File file, byte[] bArr, byte[] bArr2, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    bArr = null;
                }
                if ((i & 4) != 0) {
                    bArr2 = null;
                }
                return fileHandler.readData(file, bArr, bArr2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: readData");
        }
    }
}
