package p242io.reactivex.internal.operators.observable;

import p242io.reactivex.Observable;
import p242io.reactivex.Observer;
import p242io.reactivex.internal.disposables.EmptyDisposable;
import p242io.reactivex.internal.fuseable.ScalarCallable;

/* renamed from: io.reactivex.internal.operators.observable.ObservableEmpty */
public final class ObservableEmpty extends Observable<Object> implements ScalarCallable<Object> {
    public static final Observable<Object> INSTANCE = new ObservableEmpty();

    public Object call() {
        return null;
    }

    private ObservableEmpty() {
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(Observer<? super Object> observer) {
        EmptyDisposable.complete((Observer<?>) observer);
    }
}
