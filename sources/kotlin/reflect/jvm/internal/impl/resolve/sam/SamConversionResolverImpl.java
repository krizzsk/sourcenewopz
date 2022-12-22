package kotlin.reflect.jvm.internal.impl.resolve.sam;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.storage.CacheWithNullableValues;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;

/* compiled from: SamConversionResolverImpl.kt */
public final class SamConversionResolverImpl implements SamConversionResolver {

    /* renamed from: a */
    private final Iterable<Object> f60890a;

    /* renamed from: b */
    private final CacheWithNullableValues<ClassDescriptor, SimpleType> f60891b;

    public SamConversionResolverImpl(StorageManager storageManager, Iterable<? extends Object> iterable) {
        Intrinsics.checkNotNullParameter(storageManager, "storageManager");
        Intrinsics.checkNotNullParameter(iterable, "samWithReceiverResolvers");
        this.f60890a = iterable;
        this.f60891b = storageManager.createCacheWithNullableValues();
    }
}
