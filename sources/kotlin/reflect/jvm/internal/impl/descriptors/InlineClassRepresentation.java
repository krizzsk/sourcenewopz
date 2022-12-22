package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker;

/* compiled from: InlineClassRepresentation.kt */
public final class InlineClassRepresentation<Type extends SimpleTypeMarker> {

    /* renamed from: a */
    private final Name f60170a;

    /* renamed from: b */
    private final Type f60171b;

    public InlineClassRepresentation(Name name, Type type) {
        Intrinsics.checkNotNullParameter(name, "underlyingPropertyName");
        Intrinsics.checkNotNullParameter(type, "underlyingType");
        this.f60170a = name;
        this.f60171b = type;
    }

    public final Name getUnderlyingPropertyName() {
        return this.f60170a;
    }

    public final Type getUnderlyingType() {
        return this.f60171b;
    }
}
