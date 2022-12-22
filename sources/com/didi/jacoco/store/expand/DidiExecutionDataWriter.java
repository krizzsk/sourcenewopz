package com.didi.jacoco.store.expand;

import com.didi.jacoco.p120ec.EcInfo;
import com.didi.jacoco.store.ExecutionDataWriter;
import java.io.IOException;
import java.io.OutputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \n2\u00020\u00012\u00020\u0002:\u0001\nB\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\u000b"}, mo175978d2 = {"Lcom/didi/jacoco/store/expand/DidiExecutionDataWriter;", "Lcom/didi/jacoco/store/ExecutionDataWriter;", "Lcom/didi/jacoco/store/expand/IEcInfoVisitor;", "out", "Ljava/io/OutputStream;", "(Ljava/io/OutputStream;)V", "visitEcInfo", "", "info", "Lcom/didi/jacoco/ec/EcInfo;", "Companion", "jacoco-store"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: DidiExecutionDataWriter.kt */
public final class DidiExecutionDataWriter extends ExecutionDataWriter implements IEcInfoVisitor {
    /* access modifiers changed from: private */
    public static final byte BLOCK_ECINO = 18;
    /* access modifiers changed from: private */
    public static final byte BLOCK_EXECUTIONDATA = 17;
    /* access modifiers changed from: private */
    public static final byte BLOCK_HEADER = 1;
    /* access modifiers changed from: private */
    public static final byte BLOCK_SESSIONINFO = 16;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static int FORMAT_VERSION = 4103;
    /* access modifiers changed from: private */
    public static final char MAGIC_NUMBER = ((char) 49344);

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DidiExecutionDataWriter(OutputStream outputStream) {
        super(outputStream);
        Intrinsics.checkParameterIsNotNull(outputStream, "out");
    }

    public void visitEcInfo(EcInfo ecInfo) {
        Intrinsics.checkParameterIsNotNull(ecInfo, "info");
        try {
            this.out.writeByte(BLOCK_ECINO);
            this.out.writeUTF(ecInfo.getVersionCode());
            this.out.writeUTF(ecInfo.getVersionName());
            this.out.writeLong(ecInfo.getBuildTime());
            this.out.writeUTF(ecInfo.getAppId());
            this.out.writeUTF(ecInfo.getBranchName());
            this.out.writeLong(ecInfo.getStartTime());
            this.out.writeLong(ecInfo.getEndTime());
            this.out.writeUTF(ecInfo.getUser().toJson());
            this.out.writeUTF(ecInfo.getCommitInfo().toJson());
            this.out.writeUTF(ecInfo.getJenkinsInfo().toJson());
            this.out.writeUTF(ecInfo.getDeviceInfo().toJson());
            this.out.writeUTF(ecInfo.getFlavor());
            this.out.writeUTF(ecInfo.getBuildType());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\f\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u001a\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u0014XD¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, mo175978d2 = {"Lcom/didi/jacoco/store/expand/DidiExecutionDataWriter$Companion;", "", "()V", "BLOCK_ECINO", "", "getBLOCK_ECINO", "()B", "BLOCK_EXECUTIONDATA", "getBLOCK_EXECUTIONDATA", "BLOCK_HEADER", "getBLOCK_HEADER", "BLOCK_SESSIONINFO", "getBLOCK_SESSIONINFO", "FORMAT_VERSION", "", "getFORMAT_VERSION", "()I", "setFORMAT_VERSION", "(I)V", "MAGIC_NUMBER", "", "getMAGIC_NUMBER", "()C", "jacoco-store"}, mo175979k = 1, mo175980mv = {1, 1, 16})
    /* compiled from: DidiExecutionDataWriter.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int getFORMAT_VERSION() {
            return DidiExecutionDataWriter.FORMAT_VERSION;
        }

        public final void setFORMAT_VERSION(int i) {
            DidiExecutionDataWriter.FORMAT_VERSION = i;
        }

        public final char getMAGIC_NUMBER() {
            return DidiExecutionDataWriter.MAGIC_NUMBER;
        }

        public final byte getBLOCK_HEADER() {
            return DidiExecutionDataWriter.BLOCK_HEADER;
        }

        public final byte getBLOCK_SESSIONINFO() {
            return DidiExecutionDataWriter.BLOCK_SESSIONINFO;
        }

        public final byte getBLOCK_EXECUTIONDATA() {
            return DidiExecutionDataWriter.BLOCK_EXECUTIONDATA;
        }

        public final byte getBLOCK_ECINO() {
            return DidiExecutionDataWriter.BLOCK_ECINO;
        }
    }
}
