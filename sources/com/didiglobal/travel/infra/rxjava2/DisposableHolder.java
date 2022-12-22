package com.didiglobal.travel.infra.rxjava2;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.AdminPermission;
import p242io.reactivex.disposables.Disposable;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\u000e\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\fJ\u0006\u0010\u000f\u001a\u00020\u0006R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, mo175978d2 = {"Lcom/didiglobal/travel/infra/rxjava2/DisposableHolder;", "", "owner", "Landroidx/lifecycle/LifecycleOwner;", "onDispose", "Lkotlin/Function0;", "", "(Landroidx/lifecycle/LifecycleOwner;Lkotlin/jvm/functions/Function0;)V", "_disposed", "", "_list", "", "Lio/reactivex/disposables/Disposable;", "addDisposable", "disposable", "dispose", "lib-rxjava2_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: DisposableHolder.kt */
public final class DisposableHolder {

    /* renamed from: a */
    private boolean f51423a;

    /* renamed from: b */
    private List<Disposable> f51424b;

    public DisposableHolder(LifecycleOwner lifecycleOwner, Function0<Unit> function0) {
        Intrinsics.checkParameterIsNotNull(lifecycleOwner, "owner");
        Intrinsics.checkParameterIsNotNull(function0, "onDispose");
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        Intrinsics.checkExpressionValueIsNotNull(lifecycle, AdminPermission.LIFECYCLE);
        if (lifecycle.getCurrentState() == Lifecycle.State.DESTROYED) {
            this.f51423a = true;
        } else {
            lifecycle.addObserver(new DisposableHolder$$special$$inlined$also$lambda$1(this, function0));
        }
    }

    public final void addDisposable(Disposable disposable) {
        List<Disposable> list;
        Intrinsics.checkParameterIsNotNull(disposable, "disposable");
        if (this.f51423a) {
            DisposableKt.disposeSafely(disposable);
            return;
        }
        synchronized (this) {
            list = this.f51424b;
            if (list == null) {
                ArrayList arrayList = new ArrayList(8);
                this.f51424b = arrayList;
                list = arrayList;
            }
        }
        list.add(disposable);
    }

    public final void dispose() {
        if (!this.f51423a) {
            List<Disposable> list = this.f51424b;
            if (list != null) {
                Object[] array = list.toArray(new Disposable[0]);
                if (array != null) {
                    Disposable[] disposableArr = (Disposable[]) array;
                    if (disposableArr != null) {
                        for (Disposable disposeSafely : disposableArr) {
                            DisposableKt.disposeSafely(disposeSafely);
                        }
                    }
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
                }
            }
            this.f51423a = false;
        }
    }
}
