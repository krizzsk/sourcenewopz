package kshark.internal;

import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, mo175978d2 = {"<anonymous>", "Lkotlin/Pair;", "", "Lkshark/internal/ByteSubArray;", "keyIndex", "", "invoke"}, mo175979k = 3, mo175980mv = {1, 1, 15})
/* compiled from: SortedBytesMap.kt */
final class SortedBytesMap$entrySequence$1 extends Lambda implements Function1<Integer, Pair<? extends Long, ? extends ByteSubArray>> {
    final /* synthetic */ SortedBytesMap this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SortedBytesMap$entrySequence$1(SortedBytesMap sortedBytesMap) {
        super(1);
        this.this$0 = sortedBytesMap;
    }

    public /* synthetic */ Object invoke(Object obj) {
        return invoke(((Number) obj).intValue());
    }

    public final Pair<Long, ByteSubArray> invoke(int i) {
        return TuplesKt.m42317to(Long.valueOf(this.this$0.m2997a(i)), new ByteSubArray(this.this$0.f4669f, (this.this$0.f4665b * i) + this.this$0.f4664a, this.this$0.f4668e, this.this$0.f4667d));
    }
}
