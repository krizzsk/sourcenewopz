package kotlin.reflect.jvm.internal.impl.types;

import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;

public class TypeProjectionImpl extends TypeProjectionBase {

    /* renamed from: a */
    private final Variance f61136a;

    /* renamed from: b */
    private final KotlinType f61137b;

    /* renamed from: a */
    private static /* synthetic */ void m45054a(int i) {
        String str = (i == 4 || i == 5) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[((i == 4 || i == 5) ? 2 : 3)];
        switch (i) {
            case 1:
            case 2:
            case 3:
                objArr[0] = "type";
                break;
            case 4:
            case 5:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/types/TypeProjectionImpl";
                break;
            case 6:
                objArr[0] = "kotlinTypeRefiner";
                break;
            default:
                objArr[0] = "projection";
                break;
        }
        if (i == 4) {
            objArr[1] = "getProjectionKind";
        } else if (i != 5) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/types/TypeProjectionImpl";
        } else {
            objArr[1] = "getType";
        }
        if (i == 3) {
            objArr[2] = "replaceType";
        } else if (!(i == 4 || i == 5)) {
            if (i != 6) {
                objArr[2] = "<init>";
            } else {
                objArr[2] = "refine";
            }
        }
        String format = String.format(str, objArr);
        throw ((i == 4 || i == 5) ? new IllegalStateException(format) : new IllegalArgumentException(format));
    }

    public boolean isStarProjection() {
        return false;
    }

    public TypeProjectionImpl(Variance variance, KotlinType kotlinType) {
        if (variance == null) {
            m45054a(0);
        }
        if (kotlinType == null) {
            m45054a(1);
        }
        this.f61136a = variance;
        this.f61137b = kotlinType;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public TypeProjectionImpl(KotlinType kotlinType) {
        this(Variance.INVARIANT, kotlinType);
        if (kotlinType == null) {
            m45054a(2);
        }
    }

    public Variance getProjectionKind() {
        Variance variance = this.f61136a;
        if (variance == null) {
            m45054a(4);
        }
        return variance;
    }

    public KotlinType getType() {
        KotlinType kotlinType = this.f61137b;
        if (kotlinType == null) {
            m45054a(5);
        }
        return kotlinType;
    }

    public TypeProjection refine(KotlinTypeRefiner kotlinTypeRefiner) {
        if (kotlinTypeRefiner == null) {
            m45054a(6);
        }
        return new TypeProjectionImpl(this.f61136a, kotlinTypeRefiner.refineType(this.f61137b));
    }
}
