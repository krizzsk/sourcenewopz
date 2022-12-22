package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaValueParameter;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* compiled from: ReflectJavaValueParameter.kt */
public final class ReflectJavaValueParameter extends ReflectJavaElement implements JavaValueParameter {

    /* renamed from: a */
    private final ReflectJavaType f60356a;

    /* renamed from: b */
    private final Annotation[] f60357b;

    /* renamed from: c */
    private final String f60358c;

    /* renamed from: d */
    private final boolean f60359d;

    public boolean isDeprecatedInJavaDoc() {
        return false;
    }

    public ReflectJavaType getType() {
        return this.f60356a;
    }

    public boolean isVararg() {
        return this.f60359d;
    }

    public ReflectJavaValueParameter(ReflectJavaType reflectJavaType, Annotation[] annotationArr, String str, boolean z) {
        Intrinsics.checkNotNullParameter(reflectJavaType, "type");
        Intrinsics.checkNotNullParameter(annotationArr, "reflectAnnotations");
        this.f60356a = reflectJavaType;
        this.f60357b = annotationArr;
        this.f60358c = str;
        this.f60359d = z;
    }

    public List<ReflectJavaAnnotation> getAnnotations() {
        return ReflectJavaAnnotationOwnerKt.getAnnotations(this.f60357b);
    }

    public ReflectJavaAnnotation findAnnotation(FqName fqName) {
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        return ReflectJavaAnnotationOwnerKt.findAnnotation(this.f60357b, fqName);
    }

    public Name getName() {
        String str = this.f60358c;
        if (str == null) {
            return null;
        }
        return Name.guessByFirstCharacter(str);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getName());
        sb.append(": ");
        sb.append(isVararg() ? "vararg " : "");
        sb.append(getName());
        sb.append(": ");
        sb.append(getType());
        return sb.toString();
    }
}
