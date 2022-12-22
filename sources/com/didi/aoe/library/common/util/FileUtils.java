package com.didi.aoe.library.common.util;

import android.content.Context;
import android.os.Environment;
import com.didi.aoe.library.logging.Logger;
import com.didi.aoe.library.logging.LoggerFactory;
import com.wallet.flutter.wallet_flutter.function.FlutterShareMethod;
import java.io.File;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0007J\u0012\u0010\r\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\nH\u0007J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0007J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u000e\u001a\u00020\nH\u0007J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0014\u001a\u00020\u0012H\u0007J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000e\u001a\u00020\nH\u0007R\u001a\u0010\u0003\u001a\u00020\u00048FX\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0003\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, mo175978d2 = {"Lcom/didi/aoe/library/common/util/FileUtils;", "", "()V", "isExternalMediaAvailable", "", "isExternalMediaAvailable$annotations", "()Z", "mLogger", "Lcom/didi/aoe/library/logging/Logger;", "getFilesDir", "", "context", "Landroid/content/Context;", "isExist", "filePath", "read", "", "inputStream", "Ljava/io/InputStream;", "readString", "input", "library-common_release"}, mo175979k = 1, mo175980mv = {1, 1, 15})
/* compiled from: FileUtils.kt */
public final class FileUtils {
    public static final FileUtils INSTANCE = new FileUtils();

    /* renamed from: a */
    private static final Logger f8172a;

    @JvmStatic
    public static /* synthetic */ void isExternalMediaAvailable$annotations() {
    }

    static {
        Logger logger = LoggerFactory.getLogger("FileUtils");
        Intrinsics.checkExpressionValueIsNotNull(logger, "LoggerFactory.getLogger(\"FileUtils\")");
        f8172a = logger;
    }

    private FileUtils() {
    }

    @JvmStatic
    public static final String getFilesDir(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        if (isExternalMediaAvailable()) {
            File externalFilesDir = context.getExternalFilesDir((String) null);
            Intrinsics.checkExpressionValueIsNotNull(externalFilesDir, "filesDir");
            String absolutePath = externalFilesDir.getAbsolutePath();
            Intrinsics.checkExpressionValueIsNotNull(absolutePath, "filesDir.absolutePath");
            return absolutePath;
        }
        File filesDir = context.getFilesDir();
        Intrinsics.checkExpressionValueIsNotNull(filesDir, "context.filesDir");
        String absolutePath2 = filesDir.getAbsolutePath();
        Intrinsics.checkExpressionValueIsNotNull(absolutePath2, "context.filesDir.absolutePath");
        return absolutePath2;
    }

    public static final boolean isExternalMediaAvailable() {
        return Intrinsics.areEqual((Object) "mounted", (Object) Environment.getExternalStorageState()) || !Environment.isExternalStorageRemovable();
    }

    @JvmStatic
    public static final boolean isExist(String str) {
        return new File(str).exists();
    }

    @JvmStatic
    public static final String readString(String str) {
        Intrinsics.checkParameterIsNotNull(str, FlutterShareMethod.filePathKey);
        byte[] read = read(str);
        if (read == null) {
            return null;
        }
        return new String(read, Charsets.UTF_8);
    }

    @JvmStatic
    public static final String readString(InputStream inputStream) {
        Intrinsics.checkParameterIsNotNull(inputStream, "input");
        byte[] read = read(inputStream);
        if (read == null) {
            return null;
        }
        return new String(read, Charsets.UTF_8);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001f, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:?, code lost:
        kotlin.p245io.CloseableKt.closeFinally(r1, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0023, code lost:
        throw r2;
     */
    @kotlin.jvm.JvmStatic
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final byte[] read(java.lang.String r3) {
        /*
            java.lang.String r0 = "filePath"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r3, r0)
            r0 = 0
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch:{ Exception -> 0x0024 }
            r1.<init>(r3)     // Catch:{ Exception -> 0x0024 }
            java.io.Closeable r1 = (java.io.Closeable) r1     // Catch:{ Exception -> 0x0024 }
            r3 = r0
            java.lang.Throwable r3 = (java.lang.Throwable) r3     // Catch:{ Exception -> 0x0024 }
            r2 = r1
            java.io.FileInputStream r2 = (java.io.FileInputStream) r2     // Catch:{ all -> 0x001d }
            java.io.InputStream r2 = (java.io.InputStream) r2     // Catch:{ all -> 0x001d }
            byte[] r2 = read((java.io.InputStream) r2)     // Catch:{ all -> 0x001d }
            kotlin.p245io.CloseableKt.closeFinally(r1, r3)     // Catch:{ Exception -> 0x0024 }
            return r2
        L_0x001d:
            r3 = move-exception
            throw r3     // Catch:{ all -> 0x001f }
        L_0x001f:
            r2 = move-exception
            kotlin.p245io.CloseableKt.closeFinally(r1, r3)     // Catch:{ Exception -> 0x0024 }
            throw r2     // Catch:{ Exception -> 0x0024 }
        L_0x0024:
            r3 = move-exception
            com.didi.aoe.library.logging.Logger r1 = f8172a
            java.lang.Throwable r3 = (java.lang.Throwable) r3
            java.lang.String r2 = "read file exception: "
            r1.error((java.lang.String) r2, (java.lang.Throwable) r3)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.aoe.library.common.util.FileUtils.read(java.lang.String):byte[]");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0046, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
        kotlin.p245io.CloseableKt.closeFinally(r3, r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x004a, code lost:
        throw r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x004d, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:?, code lost:
        kotlin.p245io.CloseableKt.closeFinally(r1, r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0051, code lost:
        throw r2;
     */
    @kotlin.jvm.JvmStatic
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final byte[] read(java.io.InputStream r10) {
        /*
            java.lang.String r0 = "inputStream"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r10, r0)
            r0 = 0
            java.io.BufferedInputStream r1 = new java.io.BufferedInputStream     // Catch:{ Exception -> 0x0052 }
            r1.<init>(r10)     // Catch:{ Exception -> 0x0052 }
            java.io.Closeable r1 = (java.io.Closeable) r1     // Catch:{ Exception -> 0x0052 }
            r10 = r0
            java.lang.Throwable r10 = (java.lang.Throwable) r10     // Catch:{ Exception -> 0x0052 }
            r2 = r1
            java.io.BufferedInputStream r2 = (java.io.BufferedInputStream) r2     // Catch:{ all -> 0x004b }
            java.io.ByteArrayOutputStream r3 = new java.io.ByteArrayOutputStream     // Catch:{ all -> 0x004b }
            r3.<init>()     // Catch:{ all -> 0x004b }
            java.io.Closeable r3 = (java.io.Closeable) r3     // Catch:{ all -> 0x004b }
            r4 = r0
            java.lang.Throwable r4 = (java.lang.Throwable) r4     // Catch:{ all -> 0x004b }
            r5 = r3
            java.io.ByteArrayOutputStream r5 = (java.io.ByteArrayOutputStream) r5     // Catch:{ all -> 0x0044 }
            kotlin.jvm.internal.Ref$IntRef r6 = new kotlin.jvm.internal.Ref$IntRef     // Catch:{ all -> 0x0044 }
            r6.<init>()     // Catch:{ all -> 0x0044 }
            r7 = 1024(0x400, float:1.435E-42)
            byte[] r7 = new byte[r7]     // Catch:{ all -> 0x0044 }
        L_0x0029:
            int r8 = r2.read(r7)     // Catch:{ all -> 0x0044 }
            r6.element = r8     // Catch:{ all -> 0x0044 }
            r9 = -1
            if (r8 == r9) goto L_0x0039
            r8 = 0
            int r9 = r6.element     // Catch:{ all -> 0x0044 }
            r5.write(r7, r8, r9)     // Catch:{ all -> 0x0044 }
            goto L_0x0029
        L_0x0039:
            byte[] r2 = r5.toByteArray()     // Catch:{ all -> 0x0044 }
            kotlin.p245io.CloseableKt.closeFinally(r3, r4)     // Catch:{ all -> 0x004b }
            kotlin.p245io.CloseableKt.closeFinally(r1, r10)     // Catch:{ Exception -> 0x0052 }
            return r2
        L_0x0044:
            r10 = move-exception
            throw r10     // Catch:{ all -> 0x0046 }
        L_0x0046:
            r2 = move-exception
            kotlin.p245io.CloseableKt.closeFinally(r3, r10)     // Catch:{ all -> 0x004b }
            throw r2     // Catch:{ all -> 0x004b }
        L_0x004b:
            r10 = move-exception
            throw r10     // Catch:{ all -> 0x004d }
        L_0x004d:
            r2 = move-exception
            kotlin.p245io.CloseableKt.closeFinally(r1, r10)     // Catch:{ Exception -> 0x0052 }
            throw r2     // Catch:{ Exception -> 0x0052 }
        L_0x0052:
            r10 = move-exception
            com.didi.aoe.library.logging.Logger r1 = f8172a
            java.lang.Throwable r10 = (java.lang.Throwable) r10
            java.lang.String r2 = "read IO exception: "
            r1.error((java.lang.String) r2, (java.lang.Throwable) r10)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.aoe.library.common.util.FileUtils.read(java.io.InputStream):byte[]");
    }
}
