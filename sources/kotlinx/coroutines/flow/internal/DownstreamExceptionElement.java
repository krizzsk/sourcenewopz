package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(mo175977d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 \t2\u00020\u0001:\u0001\tB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\n"}, mo175978d2 = {"Lkotlinx/coroutines/flow/internal/DownstreamExceptionElement;", "Lkotlin/coroutines/CoroutineContext$Element;", "e", "", "(Ljava/lang/Throwable;)V", "key", "Lkotlin/coroutines/CoroutineContext$Key;", "getKey", "()Lkotlin/coroutines/CoroutineContext$Key;", "Key", "kotlinx-coroutines-core"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: SafeCollector.kt */
public final class DownstreamExceptionElement implements CoroutineContext.Element {
    public static final Key Key = new Key((DefaultConstructorMarker) null);

    /* renamed from: a */
    private final CoroutineContext.Key<?> f61483a = Key;

    /* renamed from: e */
    public final Throwable f61484e;

    @Metadata(mo175977d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003¨\u0006\u0004"}, mo175978d2 = {"Lkotlinx/coroutines/flow/internal/DownstreamExceptionElement$Key;", "Lkotlin/coroutines/CoroutineContext$Key;", "Lkotlinx/coroutines/flow/internal/DownstreamExceptionElement;", "()V", "kotlinx-coroutines-core"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: SafeCollector.kt */
    public static final class Key implements CoroutineContext.Key<DownstreamExceptionElement> {
        public /* synthetic */ Key(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Key() {
        }
    }

    public DownstreamExceptionElement(Throwable th) {
        this.f61484e = th;
    }

    public <R> R fold(R r, Function2<? super R, ? super CoroutineContext.Element, ? extends R> function2) {
        return CoroutineContext.Element.DefaultImpls.fold(this, r, function2);
    }

    public <E extends CoroutineContext.Element> E get(CoroutineContext.Key<E> key) {
        return CoroutineContext.Element.DefaultImpls.get(this, key);
    }

    public CoroutineContext minusKey(CoroutineContext.Key<?> key) {
        return CoroutineContext.Element.DefaultImpls.minusKey(this, key);
    }

    public CoroutineContext plus(CoroutineContext coroutineContext) {
        return CoroutineContext.Element.DefaultImpls.plus(this, coroutineContext);
    }

    public CoroutineContext.Key<?> getKey() {
        return this.f61483a;
    }
}
