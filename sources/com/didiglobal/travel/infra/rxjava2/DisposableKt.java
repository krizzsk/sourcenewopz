package com.didiglobal.travel.infra.rxjava2;

import androidx.lifecycle.LifecycleOwner;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p242io.reactivex.disposables.Disposable;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a\n\u0010\u0005\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0006\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0007"}, mo175978d2 = {"bindLifecycle", "", "Lio/reactivex/disposables/Disposable;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "disposeSafely", "forever", "lib-rxjava2_release"}, mo175979k = 2, mo175980mv = {1, 1, 16})
/* compiled from: Disposable.kt */
public final class DisposableKt {
    public static final void forever(Disposable disposable) {
        Intrinsics.checkParameterIsNotNull(disposable, "$this$forever");
    }

    public static final void disposeSafely(Disposable disposable) {
        Intrinsics.checkParameterIsNotNull(disposable, "$this$disposeSafely");
        if (!disposable.isDisposed()) {
            disposable.dispose();
        }
    }

    public static final void bindLifecycle(Disposable disposable, LifecycleOwner lifecycleOwner) {
        DisposableHolder disposableHolder;
        Intrinsics.checkParameterIsNotNull(disposable, "$this$bindLifecycle");
        Intrinsics.checkParameterIsNotNull(lifecycleOwner, "lifecycleOwner");
        int hashCode = lifecycleOwner.getLifecycle().hashCode();
        synchronized (DisposableHolderKt.f51425a) {
            disposableHolder = (DisposableHolder) DisposableHolderKt.f51426b.get(hashCode);
            if (disposableHolder == null) {
                disposableHolder = new DisposableHolder(lifecycleOwner, new DisposableKt$obtainHolder$$inlined$synchronized$lambda$1(lifecycleOwner, hashCode));
                DisposableHolderKt.f51426b.put(hashCode, disposableHolder);
            }
        }
        disposableHolder.addDisposable(disposable);
    }
}
