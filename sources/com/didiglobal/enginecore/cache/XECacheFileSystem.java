package com.didiglobal.enginecore.cache;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okio.Okio;
import okio.Sink;
import okio.Source;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b`\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0005H&J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0005H&J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0004\u001a\u00020\u0005H&\u0002\u0007\n\u0005\bF0\u0001¨\u0006\u0016"}, mo175978d2 = {"Lcom/didiglobal/enginecore/cache/XECacheFileSystem;", "", "appendingSink", "Lokio/Sink;", "file", "Ljava/io/File;", "delete", "", "deleteContents", "directory", "exists", "", "isCivilized", "rename", "from", "to", "sink", "size", "", "source", "Lokio/Source;", "Companion", "engine-core_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: XECacheFileSystem.kt */
public interface XECacheFileSystem {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final XECacheFileSystem SYSTEM = new Companion.SystemFileSystem();

    Sink appendingSink(File file) throws FileNotFoundException;

    void delete(File file) throws IOException;

    void deleteContents(File file) throws IOException;

    boolean exists(File file);

    boolean isCivilized(File file);

    void rename(File file, File file2) throws IOException;

    Sink sink(File file) throws FileNotFoundException;

    long size(File file);

    Source source(File file) throws FileNotFoundException;

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0005B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000¨\u0006\u0001\u0002\u0007\n\u0005\bF0\u0001¨\u0006\u0006"}, mo175978d2 = {"Lcom/didiglobal/enginecore/cache/XECacheFileSystem$Companion;", "", "()V", "SYSTEM", "Lcom/didiglobal/enginecore/cache/XECacheFileSystem;", "SystemFileSystem", "engine-core_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
    /* compiled from: XECacheFileSystem.kt */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = null;

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0006H\u0016J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0018\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0006H\u0016J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016¨\u0006\u0017"}, mo175978d2 = {"Lcom/didiglobal/enginecore/cache/XECacheFileSystem$Companion$SystemFileSystem;", "Lcom/didiglobal/enginecore/cache/XECacheFileSystem;", "()V", "appendingSink", "Lokio/Sink;", "file", "Ljava/io/File;", "delete", "", "deleteContents", "directory", "exists", "", "rename", "from", "to", "sink", "size", "", "source", "Lokio/Source;", "toString", "", "engine-core_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
        /* compiled from: XECacheFileSystem.kt */
        private static final class SystemFileSystem implements XECacheFileSystem {
            public String toString() {
                return "FileSystem.SYSTEM";
            }

            public boolean isCivilized(File file) {
                Intrinsics.checkParameterIsNotNull(file, "file");
                return DefaultImpls.isCivilized(this, file);
            }

            public Source source(File file) throws FileNotFoundException {
                Intrinsics.checkParameterIsNotNull(file, "file");
                return Okio.source(file);
            }

            public Sink sink(File file) throws FileNotFoundException {
                Intrinsics.checkParameterIsNotNull(file, "file");
                try {
                    return Okio__JvmOkioKt.sink$default(file, false, 1, (Object) null);
                } catch (FileNotFoundException unused) {
                    file.getParentFile().mkdirs();
                    return Okio__JvmOkioKt.sink$default(file, false, 1, (Object) null);
                }
            }

            public Sink appendingSink(File file) throws FileNotFoundException {
                Intrinsics.checkParameterIsNotNull(file, "file");
                try {
                    return Okio.appendingSink(file);
                } catch (FileNotFoundException unused) {
                    file.getParentFile().mkdirs();
                    return Okio.appendingSink(file);
                }
            }

            public void delete(File file) throws IOException {
                Intrinsics.checkParameterIsNotNull(file, "file");
                if (!file.delete() && file.exists()) {
                    throw new IOException("failed to delete " + file);
                }
            }

            public boolean exists(File file) {
                Intrinsics.checkParameterIsNotNull(file, "file");
                return file.exists();
            }

            public long size(File file) {
                Intrinsics.checkParameterIsNotNull(file, "file");
                return file.length();
            }

            public void rename(File file, File file2) throws IOException {
                Intrinsics.checkParameterIsNotNull(file, "from");
                Intrinsics.checkParameterIsNotNull(file2, "to");
                delete(file2);
                if (!file.renameTo(file2)) {
                    throw new IOException("failed to rename " + file + " to " + file2);
                }
            }

            public void deleteContents(File file) throws IOException {
                Intrinsics.checkParameterIsNotNull(file, "directory");
                File[] listFiles = file.listFiles();
                if (listFiles != null) {
                    int length = listFiles.length;
                    int i = 0;
                    while (i < length) {
                        File file2 = listFiles[i];
                        Intrinsics.checkExpressionValueIsNotNull(file2, "file");
                        if (file2.isDirectory()) {
                            deleteContents(file2);
                        }
                        if (file2.delete()) {
                            i++;
                        } else {
                            throw new IOException("failed to delete " + file2);
                        }
                    }
                    return;
                }
                throw new IOException("not a readable directory: " + file);
            }
        }
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175979k = 3, mo175980mv = {1, 1, 16})
    /* compiled from: XECacheFileSystem.kt */
    public static final class DefaultImpls {
        /* JADX WARNING: Can't wrap try/catch for region: R(4:9|10|11|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:10:?, code lost:
            r2 = kotlin.Unit.INSTANCE;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:11:0x001b, code lost:
            kotlin.p245io.CloseableKt.closeFinally(r0, r1);
            r3.delete(r4);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0022, code lost:
            return false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0025, code lost:
            r4 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0026, code lost:
            kotlin.p245io.CloseableKt.closeFinally(r0, r3);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0029, code lost:
            throw r4;
         */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0019 */
        /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static boolean isCivilized(com.didiglobal.enginecore.cache.XECacheFileSystem r3, java.io.File r4) {
            /*
                java.lang.String r0 = "file"
                kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r4, r0)
                okio.Sink r0 = r3.sink(r4)
                java.io.Closeable r0 = (java.io.Closeable) r0
                r1 = 0
                java.lang.Throwable r1 = (java.lang.Throwable) r1
                r2 = r0
                okio.Sink r2 = (okio.Sink) r2     // Catch:{ all -> 0x0023 }
                r3.delete(r4)     // Catch:{ IOException -> 0x0019 }
                r2 = 1
                kotlin.p245io.CloseableKt.closeFinally(r0, r1)     // Catch:{  }
                return r2
            L_0x0019:
                kotlin.Unit r2 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0023 }
                kotlin.p245io.CloseableKt.closeFinally(r0, r1)
                r3.delete(r4)
                r3 = 0
                return r3
            L_0x0023:
                r3 = move-exception
                throw r3     // Catch:{ all -> 0x0025 }
            L_0x0025:
                r4 = move-exception
                kotlin.p245io.CloseableKt.closeFinally(r0, r3)
                throw r4
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didiglobal.enginecore.cache.XECacheFileSystem.DefaultImpls.isCivilized(com.didiglobal.enginecore.cache.XECacheFileSystem, java.io.File):boolean");
        }
    }
}
