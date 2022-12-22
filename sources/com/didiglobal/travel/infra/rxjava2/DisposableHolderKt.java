package com.didiglobal.travel.infra.rxjava2;

import androidx.collection.SparseArrayCompat;
import androidx.lifecycle.LifecycleOwner;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000*\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002\u001a!\u0010\t\u001a\u00020\u0006*\u00020\n2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00060\fH\b\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, mo175978d2 = {"LOCK", "", "internalDisposableHolderArray", "Landroidx/collection/SparseArrayCompat;", "Lcom/didiglobal/travel/infra/rxjava2/DisposableHolder;", "clearHolder", "", "key", "", "obtainHolder", "Landroidx/lifecycle/LifecycleOwner;", "block", "Lkotlin/Function1;", "lib-rxjava2_release"}, mo175979k = 2, mo175980mv = {1, 1, 16})
/* compiled from: DisposableHolder.kt */
public final class DisposableHolderKt {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final Object f51425a = new Object();
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static final SparseArrayCompat<DisposableHolder> f51426b = new SparseArrayCompat<>();

    public static final void obtainHolder(LifecycleOwner lifecycleOwner, Function1<? super DisposableHolder, Unit> function1) {
        DisposableHolder disposableHolder;
        Intrinsics.checkParameterIsNotNull(lifecycleOwner, "$this$obtainHolder");
        Intrinsics.checkParameterIsNotNull(function1, "block");
        int hashCode = lifecycleOwner.getLifecycle().hashCode();
        synchronized (f51425a) {
            try {
                disposableHolder = (DisposableHolder) f51426b.get(hashCode);
                if (disposableHolder == null) {
                    disposableHolder = new DisposableHolder(lifecycleOwner, new DisposableHolderKt$obtainHolder$$inlined$synchronized$lambda$1(lifecycleOwner, hashCode));
                    f51426b.put(hashCode, disposableHolder);
                }
                InlineMarker.finallyStart(1);
            } catch (Throwable th) {
                InlineMarker.finallyStart(1);
                InlineMarker.finallyEnd(1);
                throw th;
            }
        }
        InlineMarker.finallyEnd(1);
        function1.invoke(disposableHolder);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m36813a(int i) {
        synchronized (f51425a) {
            f51426b.remove(i);
            Unit unit = Unit.INSTANCE;
        }
    }
}
