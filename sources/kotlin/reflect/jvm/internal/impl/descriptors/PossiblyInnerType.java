package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;

/* compiled from: typeParameterUtils.kt */
public final class PossiblyInnerType {

    /* renamed from: a */
    private final ClassifierDescriptorWithTypeParameters f60178a;

    /* renamed from: b */
    private final List<TypeProjection> f60179b;

    /* renamed from: c */
    private final PossiblyInnerType f60180c;

    public PossiblyInnerType(ClassifierDescriptorWithTypeParameters classifierDescriptorWithTypeParameters, List<? extends TypeProjection> list, PossiblyInnerType possiblyInnerType) {
        Intrinsics.checkNotNullParameter(classifierDescriptorWithTypeParameters, "classifierDescriptor");
        Intrinsics.checkNotNullParameter(list, "arguments");
        this.f60178a = classifierDescriptorWithTypeParameters;
        this.f60179b = list;
        this.f60180c = possiblyInnerType;
    }

    public final ClassifierDescriptorWithTypeParameters getClassifierDescriptor() {
        return this.f60178a;
    }

    public final List<TypeProjection> getArguments() {
        return this.f60179b;
    }

    public final PossiblyInnerType getOuterType() {
        return this.f60180c;
    }
}
