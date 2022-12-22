package kshark;

import java.io.File;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0012\u0010\u0007\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\u0006R\u0012\u0010\t\u001a\u00020\nX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f\u0001\u0002\u000e\u000f¨\u0006\u0010"}, mo175978d2 = {"Lkshark/HeapAnalysis;", "Ljava/io/Serializable;", "()V", "analysisDurationMillis", "", "getAnalysisDurationMillis", "()J", "createdAtTimeMillis", "getCreatedAtTimeMillis", "heapDumpFile", "Ljava/io/File;", "getHeapDumpFile", "()Ljava/io/File;", "Companion", "Lkshark/HeapAnalysisFailure;", "Lkshark/HeapAnalysisSuccess;", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
/* compiled from: HeapAnalysis.kt */
public abstract class HeapAnalysis implements Serializable {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final long serialVersionUID = -8657286725869987172L;

    public abstract long getAnalysisDurationMillis();

    public abstract long getCreatedAtTimeMillis();

    public abstract File getHeapDumpFile();

    private HeapAnalysis() {
    }

    public /* synthetic */ HeapAnalysis(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo175978d2 = {"Lkshark/HeapAnalysis$Companion;", "", "()V", "serialVersionUID", "", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
    /* compiled from: HeapAnalysis.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
