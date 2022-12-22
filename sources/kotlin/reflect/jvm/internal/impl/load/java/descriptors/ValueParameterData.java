package kotlin.reflect.jvm.internal.impl.load.java.descriptors;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* compiled from: util.kt */
public final class ValueParameterData {

    /* renamed from: a */
    private final KotlinType f60460a;

    /* renamed from: b */
    private final boolean f60461b;

    public ValueParameterData(KotlinType kotlinType, boolean z) {
        Intrinsics.checkNotNullParameter(kotlinType, "type");
        this.f60460a = kotlinType;
        this.f60461b = z;
    }

    public final boolean getHasDefaultValue() {
        return this.f60461b;
    }

    public final KotlinType getType() {
        return this.f60460a;
    }
}
