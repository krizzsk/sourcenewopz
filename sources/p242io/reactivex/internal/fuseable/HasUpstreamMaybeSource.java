package p242io.reactivex.internal.fuseable;

import p242io.reactivex.MaybeSource;

/* renamed from: io.reactivex.internal.fuseable.HasUpstreamMaybeSource */
public interface HasUpstreamMaybeSource<T> {
    MaybeSource<T> source();
}
