package p242io.reactivex.internal.disposables;

import p242io.reactivex.disposables.Disposable;

/* renamed from: io.reactivex.internal.disposables.ResettableConnectable */
public interface ResettableConnectable {
    void resetIf(Disposable disposable);
}
