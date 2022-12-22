package p242io.reactivex.internal.fuseable;

import p242io.reactivex.Flowable;

/* renamed from: io.reactivex.internal.fuseable.FuseToFlowable */
public interface FuseToFlowable<T> {
    Flowable<T> fuseToFlowable();
}
