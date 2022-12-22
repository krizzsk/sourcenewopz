package kshark;

import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\b\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\bHÆ\u0003J1\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\b\u0010\u001c\u001a\u00020\u001dH\u0016R\u0014\u0010\u0006\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001f"}, mo175978d2 = {"Lkshark/HeapAnalysisFailure;", "Lkshark/HeapAnalysis;", "heapDumpFile", "Ljava/io/File;", "createdAtTimeMillis", "", "analysisDurationMillis", "exception", "Lkshark/HeapAnalysisException;", "(Ljava/io/File;JJLkshark/HeapAnalysisException;)V", "getAnalysisDurationMillis", "()J", "getCreatedAtTimeMillis", "getException", "()Lkshark/HeapAnalysisException;", "getHeapDumpFile", "()Ljava/io/File;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "Companion", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
/* compiled from: HeapAnalysis.kt */
public final class HeapAnalysisFailure extends HeapAnalysis {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final long serialVersionUID = 8483254400637792414L;
    private final long analysisDurationMillis;
    private final long createdAtTimeMillis;
    private final HeapAnalysisException exception;
    private final File heapDumpFile;

    public static /* synthetic */ HeapAnalysisFailure copy$default(HeapAnalysisFailure heapAnalysisFailure, File file, long j, long j2, HeapAnalysisException heapAnalysisException, int i, Object obj) {
        if ((i & 1) != 0) {
            file = heapAnalysisFailure.getHeapDumpFile();
        }
        if ((i & 2) != 0) {
            j = heapAnalysisFailure.getCreatedAtTimeMillis();
        }
        long j3 = j;
        if ((i & 4) != 0) {
            j2 = heapAnalysisFailure.getAnalysisDurationMillis();
        }
        long j4 = j2;
        if ((i & 8) != 0) {
            heapAnalysisException = heapAnalysisFailure.exception;
        }
        return heapAnalysisFailure.copy(file, j3, j4, heapAnalysisException);
    }

    public final File component1() {
        return getHeapDumpFile();
    }

    public final long component2() {
        return getCreatedAtTimeMillis();
    }

    public final long component3() {
        return getAnalysisDurationMillis();
    }

    public final HeapAnalysisException component4() {
        return this.exception;
    }

    public final HeapAnalysisFailure copy(File file, long j, long j2, HeapAnalysisException heapAnalysisException) {
        Intrinsics.checkParameterIsNotNull(file, "heapDumpFile");
        Intrinsics.checkParameterIsNotNull(heapAnalysisException, "exception");
        return new HeapAnalysisFailure(file, j, j2, heapAnalysisException);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof HeapAnalysisFailure) {
                HeapAnalysisFailure heapAnalysisFailure = (HeapAnalysisFailure) obj;
                if (Intrinsics.areEqual((Object) getHeapDumpFile(), (Object) heapAnalysisFailure.getHeapDumpFile())) {
                    if (getCreatedAtTimeMillis() == heapAnalysisFailure.getCreatedAtTimeMillis()) {
                        if (!(getAnalysisDurationMillis() == heapAnalysisFailure.getAnalysisDurationMillis()) || !Intrinsics.areEqual((Object) this.exception, (Object) heapAnalysisFailure.exception)) {
                            return false;
                        }
                    }
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        File heapDumpFile2 = getHeapDumpFile();
        int i = 0;
        int hashCode = heapDumpFile2 != null ? heapDumpFile2.hashCode() : 0;
        long createdAtTimeMillis2 = getCreatedAtTimeMillis();
        long analysisDurationMillis2 = getAnalysisDurationMillis();
        int i2 = ((((hashCode * 31) + ((int) (createdAtTimeMillis2 ^ (createdAtTimeMillis2 >>> 32)))) * 31) + ((int) (analysisDurationMillis2 ^ (analysisDurationMillis2 >>> 32)))) * 31;
        HeapAnalysisException heapAnalysisException = this.exception;
        if (heapAnalysisException != null) {
            i = heapAnalysisException.hashCode();
        }
        return i2 + i;
    }

    public File getHeapDumpFile() {
        return this.heapDumpFile;
    }

    public long getCreatedAtTimeMillis() {
        return this.createdAtTimeMillis;
    }

    public long getAnalysisDurationMillis() {
        return this.analysisDurationMillis;
    }

    public final HeapAnalysisException getException() {
        return this.exception;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HeapAnalysisFailure(File file, long j, long j2, HeapAnalysisException heapAnalysisException) {
        super((DefaultConstructorMarker) null);
        Intrinsics.checkParameterIsNotNull(file, "heapDumpFile");
        Intrinsics.checkParameterIsNotNull(heapAnalysisException, "exception");
        this.heapDumpFile = file;
        this.createdAtTimeMillis = j;
        this.analysisDurationMillis = j2;
        this.exception = heapAnalysisException;
    }

    public String toString() {
        return "====================================\nHEAP ANALYSIS FAILED\n\nYou can report this failure at https://github.com/square/leakcanary/issues\nPlease provide the stacktrace, metadata and the heap dump file.\n====================================\nSTACKTRACE\n\n" + this.exception + "====================================\nMETADATA\n\nBuild.VERSION.SDK_INT: " + HeapAnalysisKt.m2907a() + "\nBuild.MANUFACTURER: " + HeapAnalysisKt.m2908b() + "\nLeakCanary version: " + HeapAnalysisKt.m2909c() + "\nAnalysis duration: " + getAnalysisDurationMillis() + " ms\nHeap dump file path: " + getHeapDumpFile().getAbsolutePath() + "\nHeap dump timestamp: " + getCreatedAtTimeMillis() + "\n====================================";
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo175978d2 = {"Lkshark/HeapAnalysisFailure$Companion;", "", "()V", "serialVersionUID", "", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
    /* compiled from: HeapAnalysis.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
