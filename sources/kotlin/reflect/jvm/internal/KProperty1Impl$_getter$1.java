package kotlin.reflect.jvm.internal;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.KProperty1Impl;

@Metadata(mo175977d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0000\u001a\"\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0003 \u0004*\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0003\u0018\u00010\u00010\u0001\"\u0004\b\u0000\u0010\u0002\"\u0006\b\u0001\u0010\u0003 \u0001H\n¢\u0006\u0002\b\u0005"}, mo175978d2 = {"<anonymous>", "Lkotlin/reflect/jvm/internal/KProperty1Impl$Getter;", "T", "V", "kotlin.jvm.PlatformType", "invoke"}, mo175979k = 3, mo175980mv = {1, 5, 1})
/* compiled from: KProperty1Impl.kt */
final class KProperty1Impl$_getter$1 extends Lambda implements Function0<KProperty1Impl.Getter<T, ? extends V>> {
    final /* synthetic */ KProperty1Impl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    KProperty1Impl$_getter$1(KProperty1Impl kProperty1Impl) {
        super(0);
        this.this$0 = kProperty1Impl;
    }

    public final KProperty1Impl.Getter<T, V> invoke() {
        return new KProperty1Impl.Getter<>(this.this$0);
    }
}
