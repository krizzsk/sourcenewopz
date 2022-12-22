package kshark.internal.hppc;

import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\u0010\u0000\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u0002H\u0003\u0018\u00010\u0001\"\u0004\b\u0000\u0010\u0003H\n¢\u0006\u0002\b\u0004"}, mo175978d2 = {"<anonymous>", "Lkotlin/Pair;", "", "T", "invoke"}, mo175979k = 3, mo175980mv = {1, 1, 15})
/* compiled from: LongObjectScatterMap.kt */
final class LongObjectScatterMap$entrySequence$1 extends Lambda implements Function0<Pair<? extends Long, ? extends T>> {
    final /* synthetic */ int $max;
    final /* synthetic */ Ref.IntRef $slot;
    final /* synthetic */ LongObjectScatterMap this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LongObjectScatterMap$entrySequence$1(LongObjectScatterMap longObjectScatterMap, Ref.IntRef intRef, int i) {
        super(0);
        this.this$0 = longObjectScatterMap;
        this.$slot = intRef;
        this.$max = i;
    }

    public final Pair<Long, T> invoke() {
        if (this.$slot.element < this.$max) {
            this.$slot.element++;
            while (this.$slot.element < this.$max) {
                long j = this.this$0.f4702a[this.$slot.element];
                if (j != 0) {
                    Long valueOf = Long.valueOf(j);
                    Object obj = this.this$0.f4703b[this.$slot.element];
                    if (obj == null) {
                        Intrinsics.throwNpe();
                    }
                    return TuplesKt.m42317to(valueOf, obj);
                }
                this.$slot.element++;
            }
        }
        if (this.$slot.element != this.$max || !this.this$0.f4707f) {
            return null;
        }
        this.$slot.element++;
        Object obj2 = this.this$0.f4703b[this.$max];
        if (obj2 == null) {
            Intrinsics.throwNpe();
        }
        return TuplesKt.m42317to(0L, obj2);
    }
}
