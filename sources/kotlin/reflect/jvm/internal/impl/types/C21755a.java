package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;

/* renamed from: kotlin.reflect.jvm.internal.impl.types.a */
/* compiled from: KotlinTypeFactory.kt */
final class C21755a extends DelegatingSimpleTypeImpl {

    /* renamed from: a */
    private final Annotations f61143a;

    public Annotations getAnnotations() {
        return this.f61143a;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C21755a(SimpleType simpleType, Annotations annotations) {
        super(simpleType);
        Intrinsics.checkNotNullParameter(simpleType, "delegate");
        Intrinsics.checkNotNullParameter(annotations, "annotations");
        this.f61143a = annotations;
    }

    /* renamed from: a */
    public C21755a replaceDelegate(SimpleType simpleType) {
        Intrinsics.checkNotNullParameter(simpleType, "delegate");
        return new C21755a(simpleType, getAnnotations());
    }
}
