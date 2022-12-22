package p242io.reactivex.subjects;

import p242io.reactivex.Observable;
import p242io.reactivex.Observer;

/* renamed from: io.reactivex.subjects.Subject */
public abstract class Subject<T> extends Observable<T> implements Observer<T> {
    public abstract Throwable getThrowable();

    public abstract boolean hasComplete();

    public abstract boolean hasObservers();

    public abstract boolean hasThrowable();

    public final Subject<T> toSerialized() {
        if (this instanceof C21230a) {
            return this;
        }
        return new C21230a(this);
    }
}
