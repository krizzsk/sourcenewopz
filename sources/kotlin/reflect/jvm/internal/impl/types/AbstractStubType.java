package kotlin.reflect.jvm.internal.impl.types;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;

/* compiled from: StubTypes.kt */
public abstract class AbstractStubType extends SimpleType {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a */
    private final TypeConstructor f61081a;

    /* renamed from: b */
    private final boolean f61082b;

    /* renamed from: c */
    private final MemberScope f61083c;

    public abstract AbstractStubType materialize(boolean z);

    public AbstractStubType refine(KotlinTypeRefiner kotlinTypeRefiner) {
        Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        return this;
    }

    public AbstractStubType(TypeConstructor typeConstructor, boolean z) {
        Intrinsics.checkNotNullParameter(typeConstructor, "originalTypeVariable");
        this.f61081a = typeConstructor;
        this.f61082b = z;
        MemberScope createErrorScope = ErrorUtils.createErrorScope(Intrinsics.stringPlus("Scope for stub type: ", typeConstructor));
        Intrinsics.checkNotNullExpressionValue(createErrorScope, "createErrorScope(\"Scope …: $originalTypeVariable\")");
        this.f61083c = createErrorScope;
    }

    public final TypeConstructor getOriginalTypeVariable() {
        return this.f61081a;
    }

    public boolean isMarkedNullable() {
        return this.f61082b;
    }

    public MemberScope getMemberScope() {
        return this.f61083c;
    }

    public List<TypeProjection> getArguments() {
        return CollectionsKt.emptyList();
    }

    public Annotations getAnnotations() {
        return Annotations.Companion.getEMPTY();
    }

    public SimpleType replaceAnnotations(Annotations annotations) {
        Intrinsics.checkNotNullParameter(annotations, "newAnnotations");
        return this;
    }

    public SimpleType makeNullableAsSpecified(boolean z) {
        return z == isMarkedNullable() ? this : materialize(z);
    }

    /* compiled from: StubTypes.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
