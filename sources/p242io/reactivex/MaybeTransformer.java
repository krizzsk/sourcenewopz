package p242io.reactivex;

/* renamed from: io.reactivex.MaybeTransformer */
public interface MaybeTransformer<Upstream, Downstream> {
    MaybeSource<Downstream> apply(Maybe<Upstream> maybe);
}
