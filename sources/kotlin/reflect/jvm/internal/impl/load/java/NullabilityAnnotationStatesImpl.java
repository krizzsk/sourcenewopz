package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNullable;

/* compiled from: JavaNullabilityAnnotationSettings.kt */
public final class NullabilityAnnotationStatesImpl<T> implements NullabilityAnnotationStates<T> {

    /* renamed from: a */
    private final Map<FqName, T> f60417a;

    /* renamed from: b */
    private final LockBasedStorageManager f60418b;

    /* renamed from: c */
    private final MemoizedFunctionToNullable<FqName, T> f60419c;

    public NullabilityAnnotationStatesImpl(Map<FqName, ? extends T> map) {
        Intrinsics.checkNotNullParameter(map, "states");
        this.f60417a = map;
        LockBasedStorageManager lockBasedStorageManager = new LockBasedStorageManager("Java nullability annotation states");
        this.f60418b = lockBasedStorageManager;
        MemoizedFunctionToNullable<FqName, T> createMemoizedFunctionWithNullableValues = lockBasedStorageManager.createMemoizedFunctionWithNullableValues(new NullabilityAnnotationStatesImpl$cache$1(this));
        Intrinsics.checkNotNullExpressionValue(createMemoizedFunctionWithNullableValues, "storageManager.createMem…cificFqname(states)\n    }");
        this.f60419c = createMemoizedFunctionWithNullableValues;
    }

    public final Map<FqName, T> getStates() {
        return this.f60417a;
    }

    public T get(FqName fqName) {
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        return this.f60419c.invoke(fqName);
    }
}
