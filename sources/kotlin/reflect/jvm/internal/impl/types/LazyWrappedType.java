package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;

/* compiled from: SpecialTypes.kt */
public final class LazyWrappedType extends WrappedType {

    /* renamed from: a */
    private final StorageManager f61119a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final Function0<KotlinType> f61120b;

    /* renamed from: c */
    private final NotNullLazyValue<KotlinType> f61121c;

    public LazyWrappedType(StorageManager storageManager, Function0<? extends KotlinType> function0) {
        Intrinsics.checkNotNullParameter(storageManager, "storageManager");
        Intrinsics.checkNotNullParameter(function0, "computation");
        this.f61119a = storageManager;
        this.f61120b = function0;
        this.f61121c = storageManager.createLazyValue(function0);
    }

    /* access modifiers changed from: protected */
    public KotlinType getDelegate() {
        return (KotlinType) this.f61121c.invoke();
    }

    public boolean isComputed() {
        return this.f61121c.isComputed();
    }

    public LazyWrappedType refine(KotlinTypeRefiner kotlinTypeRefiner) {
        Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        return new LazyWrappedType(this.f61119a, new LazyWrappedType$refine$1(kotlinTypeRefiner, this));
    }
}
