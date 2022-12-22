package kshark;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\b\b\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u000f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\u0013\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\nHÖ\u0001J\r\u0010\u0019\u001a\u00020\u0004H\u0000¢\u0006\u0002\b\u001aJ\b\u0010\u001b\u001a\u00020\rH\u0016R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0004X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0012\u0010\t\u001a\u0004\u0018\u00010\nX\u0004¢\u0006\u0004\n\u0002\u0010\u000bR\u0014\u0010\f\u001a\u00020\r8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\r8VX\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u000f¨\u0006\u001d"}, mo175978d2 = {"Lkshark/ApplicationLeak;", "Lkshark/Leak;", "leakTraces", "", "Lkshark/LeakTrace;", "(Ljava/util/List;)V", "leakTrace", "getLeakTraces", "()Ljava/util/List;", "retainedHeapByteSize", "", "Ljava/lang/Integer;", "shortDescription", "", "getShortDescription", "()Ljava/lang/String;", "signature", "getSignature", "component1", "copy", "equals", "", "other", "", "hashCode", "leakTraceFromV20", "leakTraceFromV20$shark", "toString", "Companion", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
/* compiled from: HeapAnalysis.kt */
public final class ApplicationLeak extends Leak {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final long serialVersionUID = 524928276700576863L;
    private final LeakTrace leakTrace;
    private final List<LeakTrace> leakTraces;
    private final Integer retainedHeapByteSize;

    public static /* synthetic */ ApplicationLeak copy$default(ApplicationLeak applicationLeak, List<LeakTrace> list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = applicationLeak.getLeakTraces();
        }
        return applicationLeak.copy(list);
    }

    public final List<LeakTrace> component1() {
        return getLeakTraces();
    }

    public final ApplicationLeak copy(List<LeakTrace> list) {
        Intrinsics.checkParameterIsNotNull(list, "leakTraces");
        return new ApplicationLeak(list);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof ApplicationLeak) && Intrinsics.areEqual((Object) getLeakTraces(), (Object) ((ApplicationLeak) obj).getLeakTraces());
        }
        return true;
    }

    public int hashCode() {
        List<LeakTrace> leakTraces2 = getLeakTraces();
        if (leakTraces2 != null) {
            return leakTraces2.hashCode();
        }
        return 0;
    }

    public List<LeakTrace> getLeakTraces() {
        return this.leakTraces;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ApplicationLeak(List<LeakTrace> list) {
        super((DefaultConstructorMarker) null);
        Intrinsics.checkParameterIsNotNull(list, "leakTraces");
        this.leakTraces = list;
    }

    public String getSignature() {
        return ((LeakTrace) CollectionsKt.first(getLeakTraces())).getSignature();
    }

    public String getShortDescription() {
        LeakTrace leakTrace2 = (LeakTrace) CollectionsKt.first(getLeakTraces());
        LeakTraceReference leakTraceReference = (LeakTraceReference) SequencesKt.firstOrNull(leakTrace2.getSuspectReferenceSubpath());
        if (leakTraceReference != null) {
            String str = leakTraceReference.getOriginObject().getClassSimpleName() + "." + leakTraceReference.getReferenceGenericName();
            if (str != null) {
                return str;
            }
        }
        return leakTrace2.getLeakingObject().getClassName();
    }

    public String toString() {
        return super.toString();
    }

    public final LeakTrace leakTraceFromV20$shark() {
        LeakTrace leakTrace2 = this.leakTrace;
        if (leakTrace2 == null) {
            Intrinsics.throwNpe();
        }
        return leakTrace2.fromV20$shark(this.retainedHeapByteSize);
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo175978d2 = {"Lkshark/ApplicationLeak$Companion;", "", "()V", "serialVersionUID", "", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
    /* compiled from: HeapAnalysis.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
