package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;

/* compiled from: SpecialTypes.kt */
public final class AbbreviatedType extends DelegatingSimpleType {

    /* renamed from: a */
    private final SimpleType f61079a;

    /* renamed from: b */
    private final SimpleType f61080b;

    public AbbreviatedType(SimpleType simpleType, SimpleType simpleType2) {
        Intrinsics.checkNotNullParameter(simpleType, "delegate");
        Intrinsics.checkNotNullParameter(simpleType2, "abbreviation");
        this.f61079a = simpleType;
        this.f61080b = simpleType2;
    }

    public final SimpleType getAbbreviation() {
        return this.f61080b;
    }

    /* access modifiers changed from: protected */
    public SimpleType getDelegate() {
        return this.f61079a;
    }

    public final SimpleType getExpandedType() {
        return getDelegate();
    }

    public AbbreviatedType replaceAnnotations(Annotations annotations) {
        Intrinsics.checkNotNullParameter(annotations, "newAnnotations");
        return new AbbreviatedType(getDelegate().replaceAnnotations(annotations), this.f61080b);
    }

    public AbbreviatedType makeNullableAsSpecified(boolean z) {
        return new AbbreviatedType(getDelegate().makeNullableAsSpecified(z), this.f61080b.makeNullableAsSpecified(z));
    }

    public AbbreviatedType replaceDelegate(SimpleType simpleType) {
        Intrinsics.checkNotNullParameter(simpleType, "delegate");
        return new AbbreviatedType(simpleType, this.f61080b);
    }

    public AbbreviatedType refine(KotlinTypeRefiner kotlinTypeRefiner) {
        Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        return new AbbreviatedType((SimpleType) kotlinTypeRefiner.refineType(getDelegate()), (SimpleType) kotlinTypeRefiner.refineType(this.f61080b));
    }
}
