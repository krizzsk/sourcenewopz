package kshark;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, mo175978d2 = {"<anonymous>", "", "index", "invoke", "(I)Ljava/lang/Integer;"}, mo175979k = 3, mo175980mv = {1, 1, 15})
/* compiled from: HeapAnalyzer.kt */
final class HeapAnalyzer$computeLeakStatuses$previousLeakingIndex$1 extends Lambda implements Function1<Integer, Integer> {
    final /* synthetic */ Ref.IntRef $firstLeakingElementIndex;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HeapAnalyzer$computeLeakStatuses$previousLeakingIndex$1(Ref.IntRef intRef) {
        super(1);
        this.$firstLeakingElementIndex = intRef;
    }

    public /* synthetic */ Object invoke(Object obj) {
        return invoke(((Number) obj).intValue());
    }

    public final Integer invoke(int i) {
        if (i > this.$firstLeakingElementIndex.element) {
            return Integer.valueOf(i - 1);
        }
        return null;
    }
}
