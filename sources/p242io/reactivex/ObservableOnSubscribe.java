package p242io.reactivex;

/* renamed from: io.reactivex.ObservableOnSubscribe */
public interface ObservableOnSubscribe<T> {
    void subscribe(ObservableEmitter<T> observableEmitter) throws Exception;
}
