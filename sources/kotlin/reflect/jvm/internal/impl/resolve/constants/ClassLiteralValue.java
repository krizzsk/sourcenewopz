package kotlin.reflect.jvm.internal.impl.resolve.constants;

import com.didi.beatles.p099im.access.utils.IMTextUtils;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.ClassId;

/* compiled from: ClassLiteralValue.kt */
public final class ClassLiteralValue {

    /* renamed from: a */
    private final ClassId f60871a;

    /* renamed from: b */
    private final int f60872b;

    public final ClassId component1() {
        return this.f60871a;
    }

    public final int component2() {
        return this.f60872b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ClassLiteralValue)) {
            return false;
        }
        ClassLiteralValue classLiteralValue = (ClassLiteralValue) obj;
        return Intrinsics.areEqual((Object) this.f60871a, (Object) classLiteralValue.f60871a) && this.f60872b == classLiteralValue.f60872b;
    }

    public int hashCode() {
        return (this.f60871a.hashCode() * 31) + this.f60872b;
    }

    public ClassLiteralValue(ClassId classId, int i) {
        Intrinsics.checkNotNullParameter(classId, "classId");
        this.f60871a = classId;
        this.f60872b = i;
    }

    public final int getArrayNestedness() {
        return this.f60872b;
    }

    public final ClassId getClassId() {
        return this.f60871a;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        int arrayNestedness = getArrayNestedness();
        for (int i = 0; i < arrayNestedness; i++) {
            sb.append("kotlin/Array<");
        }
        sb.append(getClassId());
        int arrayNestedness2 = getArrayNestedness();
        for (int i2 = 0; i2 < arrayNestedness2; i2++) {
            sb.append(IMTextUtils.STREET_IMAGE_TAG_END);
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }
}
