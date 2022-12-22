package p242io.reactivex;

/* renamed from: io.reactivex.SingleConverter */
public interface SingleConverter<T, R> {
    R apply(Single<T> single);
}
