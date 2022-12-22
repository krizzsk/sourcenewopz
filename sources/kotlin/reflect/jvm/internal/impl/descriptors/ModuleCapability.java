package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: ModuleCapability.kt */
public final class ModuleCapability<T> {

    /* renamed from: a */
    private final String f60172a;

    public ModuleCapability(String str) {
        Intrinsics.checkNotNullParameter(str, "name");
        this.f60172a = str;
    }

    public String toString() {
        return this.f60172a;
    }
}
