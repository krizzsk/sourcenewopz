package com.didi.jacoco.store.expand;

import com.didi.jacoco.p120ec.EcInfo;
import com.didi.jacoco.store.ExecutionDataStore;
import com.didi.jacoco.store.SessionInfoStore;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\t\u001a\u00020\u0004J\u0006\u0010\n\u001a\u00020\u0006J\u0006\u0010\u000b\u001a\u00020\bJ\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u001e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000fJ\u0016\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u0017J\u0010\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u0019H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, mo175978d2 = {"Lcom/didi/jacoco/store/expand/DidiExecFileLoader;", "", "()V", "ecInfoData", "Lcom/didi/jacoco/store/expand/EcInfoDataStore;", "executionData", "Lcom/didi/jacoco/store/ExecutionDataStore;", "sessionInfo", "Lcom/didi/jacoco/store/SessionInfoStore;", "getEcInfoStore", "getExecutionDataStore", "getSessionInfoStore", "load", "Lcom/didi/jacoco/store/expand/DidiExecutionDataReader;", "file", "Ljava/io/File;", "rewrite", "", "ecInfo", "Lcom/didi/jacoco/ec/EcInfo;", "target", "save", "append", "", "stream", "Ljava/io/OutputStream;", "jacoco-store"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: DidiExecFileLoader.kt */
public final class DidiExecFileLoader {
    private final EcInfoDataStore ecInfoData = new EcInfoDataStore();
    private final ExecutionDataStore executionData = new ExecutionDataStore();
    private final SessionInfoStore sessionInfo = new SessionInfoStore();

    public final EcInfoDataStore getEcInfoStore() {
        return this.ecInfoData;
    }

    public final SessionInfoStore getSessionInfoStore() {
        return this.sessionInfo;
    }

    public final ExecutionDataStore getExecutionDataStore() {
        return this.executionData;
    }

    public final DidiExecutionDataReader load(File file) {
        Intrinsics.checkParameterIsNotNull(file, "file");
        DidiExecutionDataReader didiExecutionDataReader = new DidiExecutionDataReader(new FileInputStream(file));
        didiExecutionDataReader.setExecutionDataVisitor(this.executionData);
        didiExecutionDataReader.setSessionInfoVisitor(this.sessionInfo);
        didiExecutionDataReader.setEcInfoVisitor(this.ecInfoData);
        didiExecutionDataReader.read();
        return didiExecutionDataReader;
    }

    public final void rewrite(File file, EcInfo ecInfo, File file2) {
        Intrinsics.checkParameterIsNotNull(file, "file");
        Intrinsics.checkParameterIsNotNull(ecInfo, "ecInfo");
        Intrinsics.checkParameterIsNotNull(file2, "target");
        load(file);
        this.ecInfoData.visitEcInfo(ecInfo);
        save(file2, false);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0036, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0037, code lost:
        kotlin.p245io.CloseableKt.closeFinally(r2, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x003a, code lost:
        throw r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void save(java.io.File r2, boolean r3) throws java.io.IOException {
        /*
            r1 = this;
            java.lang.String r0 = "file"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r2, r0)
            java.io.File r0 = r2.getParentFile()
            if (r0 == 0) goto L_0x000e
            r0.mkdirs()
        L_0x000e:
            java.io.FileOutputStream r0 = new java.io.FileOutputStream
            r0.<init>(r2, r3)
            java.nio.channels.FileChannel r2 = r0.getChannel()
            r2.lock()
            java.io.BufferedOutputStream r2 = new java.io.BufferedOutputStream
            java.io.OutputStream r0 = (java.io.OutputStream) r0
            r2.<init>(r0)
            java.io.OutputStream r2 = (java.io.OutputStream) r2
            java.io.Closeable r2 = (java.io.Closeable) r2
            r3 = 0
            java.lang.Throwable r3 = (java.lang.Throwable) r3
            r0 = r2
            java.io.OutputStream r0 = (java.io.OutputStream) r0     // Catch:{ all -> 0x0034 }
            r1.save(r0)     // Catch:{ all -> 0x0034 }
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0034 }
            kotlin.p245io.CloseableKt.closeFinally(r2, r3)
            return
        L_0x0034:
            r3 = move-exception
            throw r3     // Catch:{ all -> 0x0036 }
        L_0x0036:
            r0 = move-exception
            kotlin.p245io.CloseableKt.closeFinally(r2, r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.jacoco.store.expand.DidiExecFileLoader.save(java.io.File, boolean):void");
    }

    private final void save(OutputStream outputStream) throws IOException {
        DidiExecutionDataWriter didiExecutionDataWriter = new DidiExecutionDataWriter(outputStream);
        this.sessionInfo.accept(didiExecutionDataWriter);
        this.ecInfoData.accept(didiExecutionDataWriter);
        this.executionData.accept(didiExecutionDataWriter);
    }
}
