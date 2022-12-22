package p242io.reactivex.internal.operators.maybe;

import p242io.reactivex.Maybe;
import p242io.reactivex.MaybeSource;
import p242io.reactivex.internal.fuseable.HasUpstreamMaybeSource;

/* renamed from: io.reactivex.internal.operators.maybe.a */
/* compiled from: AbstractMaybeWithUpstream */
abstract class C21209a<T, R> extends Maybe<R> implements HasUpstreamMaybeSource<T> {
    protected final MaybeSource<T> source;

    C21209a(MaybeSource<T> maybeSource) {
        this.source = maybeSource;
    }

    public final MaybeSource<T> source() {
        return this.source;
    }
}
