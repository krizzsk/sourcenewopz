package com.datadog.android.core.internal.persistence.file.batch;

import com.datadog.android.core.internal.persistence.file.FileExtKt;
import com.datadog.android.core.internal.persistence.file.FileHandler;
import com.datadog.android.log.Logger;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.p245io.FilesKt;

@Metadata(mo175977d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\f\b\u0000\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J*\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u00062\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u0018\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\bH\u0002J\u0018\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\bH\u0016J$\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0016\u001a\u0004\u0018\u00010\u000eH\u0016J \u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u000eH\u0002J*\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u00062\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, mo175978d2 = {"Lcom/datadog/android/core/internal/persistence/file/batch/BatchFileHandler;", "Lcom/datadog/android/core/internal/persistence/file/FileHandler;", "internalLogger", "Lcom/datadog/android/log/Logger;", "(Lcom/datadog/android/log/Logger;)V", "delete", "", "target", "Ljava/io/File;", "lockFileAndWriteData", "", "file", "append", "separator", "", "data", "moveFile", "destDir", "moveFiles", "srcDir", "readData", "prefix", "suffix", "readFileData", "writeData", "Companion", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: BatchFileHandler.kt */
public final class BatchFileHandler implements FileHandler {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String ERROR_DELETE = "Unable to delete file: %s";
    public static final String ERROR_MOVE_NOT_DIR = "Unable to move files; file is not a directory: %s";
    public static final String ERROR_MOVE_NO_DST = "Unable to move files; could not create directory: %s";
    public static final String ERROR_READ = "Unable to read data from file: %s";
    public static final String ERROR_WRITE = "Unable to write data to file: %s";
    public static final String INFO_MOVE_NO_SRC = "Unable to move files; source directory does not exist: %s";

    /* renamed from: b */
    private static final byte[] f3556b = new byte[0];

    /* renamed from: a */
    private final Logger f3557a;

    public BatchFileHandler(Logger logger) {
        Intrinsics.checkNotNullParameter(logger, "internalLogger");
        this.f3557a = logger;
    }

    public boolean writeData(File file, byte[] bArr, boolean z, byte[] bArr2) {
        Intrinsics.checkNotNullParameter(file, "file");
        Intrinsics.checkNotNullParameter(bArr, "data");
        try {
            m2350a(file, z, bArr2, bArr);
            return true;
        } catch (IOException e) {
            Logger logger = this.f3557a;
            String format = String.format(Locale.US, ERROR_WRITE, Arrays.copyOf(new Object[]{file.getPath()}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(locale, this, *args)");
            Logger.e$default(logger, format, e, (Map) null, 4, (Object) null);
        } catch (SecurityException e2) {
            Logger logger2 = this.f3557a;
            String format2 = String.format(Locale.US, ERROR_WRITE, Arrays.copyOf(new Object[]{file.getPath()}, 1));
            Intrinsics.checkNotNullExpressionValue(format2, "java.lang.String.format(locale, this, *args)");
            Logger.e$default(logger2, format2, e2, (Map) null, 4, (Object) null);
        }
        return false;
    }

    public byte[] readData(File file, byte[] bArr, byte[] bArr2) {
        Intrinsics.checkNotNullParameter(file, "file");
        if (bArr == null) {
            try {
                bArr = f3556b;
            } catch (IOException e) {
                Logger logger = this.f3557a;
                String format = String.format(Locale.US, ERROR_READ, Arrays.copyOf(new Object[]{file.getPath()}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(locale, this, *args)");
                Logger.e$default(logger, format, e, (Map) null, 4, (Object) null);
                return f3556b;
            } catch (SecurityException e2) {
                Logger logger2 = this.f3557a;
                String format2 = String.format(Locale.US, ERROR_READ, Arrays.copyOf(new Object[]{file.getPath()}, 1));
                Intrinsics.checkNotNullExpressionValue(format2, "java.lang.String.format(locale, this, *args)");
                Logger.e$default(logger2, format2, e2, (Map) null, 4, (Object) null);
                return f3556b;
            }
        }
        if (bArr2 == null) {
            bArr2 = f3556b;
        }
        return m2352a(file, bArr, bArr2);
    }

    public boolean delete(File file) {
        Intrinsics.checkNotNullParameter(file, "target");
        try {
            return FilesKt.deleteRecursively(file);
        } catch (IOException e) {
            Logger logger = this.f3557a;
            String format = String.format(Locale.US, "Unable to delete file: %s", Arrays.copyOf(new Object[]{file.getPath()}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(locale, this, *args)");
            Logger.e$default(logger, format, e, (Map) null, 4, (Object) null);
            return false;
        } catch (SecurityException e2) {
            Logger logger2 = this.f3557a;
            String format2 = String.format(Locale.US, "Unable to delete file: %s", Arrays.copyOf(new Object[]{file.getPath()}, 1));
            Intrinsics.checkNotNullExpressionValue(format2, "java.lang.String.format(locale, this, *args)");
            Logger.e$default(logger2, format2, e2, (Map) null, 4, (Object) null);
            return false;
        }
    }

    public boolean moveFiles(File file, File file2) {
        Intrinsics.checkNotNullParameter(file, "srcDir");
        Intrinsics.checkNotNullParameter(file2, "destDir");
        if (!file.exists()) {
            Logger logger = this.f3557a;
            String format = String.format(Locale.US, INFO_MOVE_NO_SRC, Arrays.copyOf(new Object[]{file.getPath()}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(locale, this, *args)");
            Logger.i$default(logger, format, (Throwable) null, (Map) null, 6, (Object) null);
            return true;
        } else if (!file.isDirectory()) {
            Logger logger2 = this.f3557a;
            String format2 = String.format(Locale.US, ERROR_MOVE_NOT_DIR, Arrays.copyOf(new Object[]{file.getPath()}, 1));
            Intrinsics.checkNotNullExpressionValue(format2, "java.lang.String.format(locale, this, *args)");
            Logger.e$default(logger2, format2, (Throwable) null, (Map) null, 6, (Object) null);
            return false;
        } else {
            if (!file2.exists()) {
                if (!FileExtKt.mkdirsSafe(file2)) {
                    Logger logger3 = this.f3557a;
                    String format3 = String.format(Locale.US, ERROR_MOVE_NO_DST, Arrays.copyOf(new Object[]{file.getPath()}, 1));
                    Intrinsics.checkNotNullExpressionValue(format3, "java.lang.String.format(locale, this, *args)");
                    Logger.e$default(logger3, format3, (Throwable) null, (Map) null, 6, (Object) null);
                    return false;
                }
            } else if (!file2.isDirectory()) {
                Logger logger4 = this.f3557a;
                String format4 = String.format(Locale.US, ERROR_MOVE_NOT_DIR, Arrays.copyOf(new Object[]{file2.getPath()}, 1));
                Intrinsics.checkNotNullExpressionValue(format4, "java.lang.String.format(locale, this, *args)");
                Logger.e$default(logger4, format4, (Throwable) null, (Map) null, 6, (Object) null);
                return false;
            }
            File[] listFiles = file.listFiles();
            if (listFiles == null) {
                listFiles = new File[0];
            }
            for (File file3 : listFiles) {
                Intrinsics.checkNotNullExpressionValue(file3, "file");
                if (!m2351a(file3, file2)) {
                    return false;
                }
            }
            return true;
        }
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x003e, code lost:
        r9 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x003f, code lost:
        kotlin.p245io.CloseableKt.closeFinally(r0, r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0042, code lost:
        throw r9;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void m2350a(java.io.File r8, boolean r9, byte[] r10, byte[] r11) {
        /*
            r7 = this;
            java.io.FileOutputStream r0 = new java.io.FileOutputStream
            r0.<init>(r8, r9)
            java.io.Closeable r0 = (java.io.Closeable) r0
            r9 = 0
            java.lang.Throwable r9 = (java.lang.Throwable) r9
            r1 = r0
            java.io.FileOutputStream r1 = (java.io.FileOutputStream) r1     // Catch:{ all -> 0x003c }
            java.nio.channels.FileChannel r2 = r1.getChannel()     // Catch:{ all -> 0x003c }
            java.nio.channels.FileLock r2 = r2.lock()     // Catch:{ all -> 0x003c }
            java.lang.String r3 = "outputStream.channel.lock()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)     // Catch:{ all -> 0x003c }
            long r3 = r8.length()     // Catch:{ all -> 0x0037 }
            r5 = 0
            int r8 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r8 <= 0) goto L_0x0029
            if (r10 == 0) goto L_0x0029
            r1.write(r10)     // Catch:{ all -> 0x0037 }
        L_0x0029:
            r1.write(r11)     // Catch:{ all -> 0x0037 }
            kotlin.Unit r8 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0037 }
            r2.release()     // Catch:{ all -> 0x003c }
            kotlin.Unit r8 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x003c }
            kotlin.p245io.CloseableKt.closeFinally(r0, r9)
            return
        L_0x0037:
            r8 = move-exception
            r2.release()     // Catch:{ all -> 0x003c }
            throw r8     // Catch:{ all -> 0x003c }
        L_0x003c:
            r8 = move-exception
            throw r8     // Catch:{ all -> 0x003e }
        L_0x003e:
            r9 = move-exception
            kotlin.p245io.CloseableKt.closeFinally(r0, r8)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.datadog.android.core.internal.persistence.file.batch.BatchFileHandler.m2350a(java.io.File, boolean, byte[], byte[]):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0044, code lost:
        r9 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0045, code lost:
        kotlin.p245io.CloseableKt.closeFinally(r3, r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0048, code lost:
        throw r9;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final byte[] m2352a(java.io.File r8, byte[] r9, byte[] r10) {
        /*
            r7 = this;
            long r0 = r8.length()
            int r1 = (int) r0
            int r0 = r9.length
            int r0 = r0 + r1
            int r2 = r10.length
            int r0 = r0 + r2
            byte[] r2 = new byte[r0]
            int r3 = r9.length
            r4 = 0
            java.lang.System.arraycopy(r9, r4, r2, r4, r3)
            int r9 = r9.length
            java.io.FileInputStream r3 = new java.io.FileInputStream
            r3.<init>(r8)
            java.io.Closeable r3 = (java.io.Closeable) r3
            r8 = 0
            java.lang.Throwable r8 = (java.lang.Throwable) r8
            r5 = r3
            java.io.FileInputStream r5 = (java.io.FileInputStream) r5     // Catch:{ all -> 0x0042 }
        L_0x001e:
            if (r1 <= 0) goto L_0x002a
            int r6 = r5.read(r2, r9, r1)     // Catch:{ all -> 0x0042 }
            if (r6 >= 0) goto L_0x0027
            goto L_0x002a
        L_0x0027:
            int r9 = r9 + r6
            int r1 = r1 - r6
            goto L_0x001e
        L_0x002a:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0042 }
            kotlin.p245io.CloseableKt.closeFinally(r3, r8)
            int r8 = r10.length
            java.lang.System.arraycopy(r10, r4, r2, r9, r8)
            int r8 = r10.length
            int r9 = r9 + r8
            if (r0 != r9) goto L_0x0038
            goto L_0x0041
        L_0x0038:
            byte[] r2 = java.util.Arrays.copyOf(r2, r9)
            java.lang.String r8 = "java.util.Arrays.copyOf(this, newSize)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r8)
        L_0x0041:
            return r2
        L_0x0042:
            r8 = move-exception
            throw r8     // Catch:{ all -> 0x0044 }
        L_0x0044:
            r9 = move-exception
            kotlin.p245io.CloseableKt.closeFinally(r3, r8)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.datadog.android.core.internal.persistence.file.batch.BatchFileHandler.m2352a(java.io.File, byte[], byte[]):byte[]");
    }

    /* renamed from: a */
    private final boolean m2351a(File file, File file2) {
        return FileExtKt.renameToSafe(file, new File(file2, file.getName()));
    }

    @Metadata(mo175977d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\f"}, mo175978d2 = {"Lcom/datadog/android/core/internal/persistence/file/batch/BatchFileHandler$Companion;", "", "()V", "EMPTY_BYTE_ARRAY", "", "ERROR_DELETE", "", "ERROR_MOVE_NOT_DIR", "ERROR_MOVE_NO_DST", "ERROR_READ", "ERROR_WRITE", "INFO_MOVE_NO_SRC", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: BatchFileHandler.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
