package kotlin.collections;

import com.didi.sdk.util.SidConverter;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010(\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a0\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00010\u0005H\bø\u0001\u0000\u001a\u001f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0003\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\n\u001a\"\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\b0\u0003\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003\u0002\u0007\n\u0005\b20\u0001¨\u0006\t"}, mo175978d2 = {"forEach", "", "T", "", "operation", "Lkotlin/Function1;", "iterator", "withIndex", "Lkotlin/collections/IndexedValue;", "kotlin-stdlib"}, mo175979k = 5, mo175980mv = {1, 5, 1}, mo175982xi = 1, mo175983xs = "kotlin/collections/CollectionsKt")
/* renamed from: kotlin.collections.k */
/* compiled from: Iterators.kt */
class C21440k extends C21439j {
    /* renamed from: a */
    private static final <T> Iterator<T> m43243a(Iterator<? extends T> it) {
        Intrinsics.checkNotNullParameter(it, "$this$iterator");
        return it;
    }

    public static final <T> Iterator<IndexedValue<T>> withIndex(Iterator<? extends T> it) {
        Intrinsics.checkNotNullParameter(it, "$this$withIndex");
        return new IndexingIterator<>(it);
    }

    public static final <T> void forEach(Iterator<? extends T> it, Function1<? super T, Unit> function1) {
        Intrinsics.checkNotNullParameter(it, "$this$forEach");
        Intrinsics.checkNotNullParameter(function1, SidConverter.SID_OPERATION);
        while (it.hasNext()) {
            function1.invoke(it.next());
        }
    }
}
