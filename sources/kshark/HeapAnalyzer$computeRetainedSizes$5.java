package kshark;

import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kshark.HeapAnalyzer;
import kshark.HeapObject;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0005"}, mo175978d2 = {"<anonymous>", "", "instanceId", "", "dominatorId", "invoke"}, mo175979k = 3, mo175980mv = {1, 1, 15})
/* compiled from: HeapAnalyzer.kt */
final class HeapAnalyzer$computeRetainedSizes$5 extends Lambda implements Function2<Long, Long, Unit> {
    final /* synthetic */ Set $leakingInstanceIds;
    final /* synthetic */ Map $nativeSizes;
    final /* synthetic */ Map $sizeByDominator;
    final /* synthetic */ HeapAnalyzer.FindLeakInput $this_computeRetainedSizes;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HeapAnalyzer$computeRetainedSizes$5(HeapAnalyzer.FindLeakInput findLeakInput, Set set, Map map, Map map2) {
        super(2);
        this.$this_computeRetainedSizes = findLeakInput;
        this.$leakingInstanceIds = set;
        this.$sizeByDominator = map;
        this.$nativeSizes = map2;
    }

    public /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke(((Number) obj).longValue(), ((Number) obj2).longValue());
        return Unit.INSTANCE;
    }

    public final void invoke(long j, long j2) {
        int i;
        if (!this.$leakingInstanceIds.contains(Long.valueOf(j))) {
            int intValue = ((Number) MapsKt.getValue(this.$sizeByDominator, Long.valueOf(j2))).intValue();
            int intValue2 = ((Number) MapsKt.getValue(this.$nativeSizes, Long.valueOf(j))).intValue();
            HeapObject findObjectById = this.$this_computeRetainedSizes.getGraph().findObjectById(j);
            if (findObjectById instanceof HeapObject.HeapInstance) {
                i = ((HeapObject.HeapInstance) findObjectById).getByteSize();
            } else if (findObjectById instanceof HeapObject.HeapObjectArray) {
                i = ((HeapObject.HeapObjectArray) findObjectById).readByteSize();
            } else if (findObjectById instanceof HeapObject.HeapPrimitiveArray) {
                i = ((HeapObject.HeapPrimitiveArray) findObjectById).readByteSize();
            } else if (findObjectById instanceof HeapObject.HeapClass) {
                throw new IllegalStateException("Unexpected class record " + findObjectById);
            } else {
                throw new NoWhenBranchMatchedException();
            }
            this.$sizeByDominator.put(Long.valueOf(j2), Integer.valueOf(intValue + intValue2 + i));
        }
    }
}
