package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import java.util.Map;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

public class AnnotationDescriptorImpl implements AnnotationDescriptor {

    /* renamed from: a */
    private final KotlinType f60191a;

    /* renamed from: b */
    private final Map<Name, ConstantValue<?>> f60192b;

    /* renamed from: c */
    private final SourceElement f60193c;

    /* renamed from: a */
    private static /* synthetic */ void m44523a(int i) {
        String str = (i == 3 || i == 4 || i == 5) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[((i == 3 || i == 4 || i == 5) ? 2 : 3)];
        if (i == 1) {
            objArr[0] = "valueArguments";
        } else if (i == 2) {
            objArr[0] = "source";
        } else if (i == 3 || i == 4 || i == 5) {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/annotations/AnnotationDescriptorImpl";
        } else {
            objArr[0] = "annotationType";
        }
        if (i == 3) {
            objArr[1] = "getType";
        } else if (i == 4) {
            objArr[1] = "getAllValueArguments";
        } else if (i != 5) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/annotations/AnnotationDescriptorImpl";
        } else {
            objArr[1] = "getSource";
        }
        if (!(i == 3 || i == 4 || i == 5)) {
            objArr[2] = "<init>";
        }
        String format = String.format(str, objArr);
        throw ((i == 3 || i == 4 || i == 5) ? new IllegalStateException(format) : new IllegalArgumentException(format));
    }

    public AnnotationDescriptorImpl(KotlinType kotlinType, Map<Name, ConstantValue<?>> map, SourceElement sourceElement) {
        if (kotlinType == null) {
            m44523a(0);
        }
        if (map == null) {
            m44523a(1);
        }
        if (sourceElement == null) {
            m44523a(2);
        }
        this.f60191a = kotlinType;
        this.f60192b = map;
        this.f60193c = sourceElement;
    }

    public KotlinType getType() {
        KotlinType kotlinType = this.f60191a;
        if (kotlinType == null) {
            m44523a(3);
        }
        return kotlinType;
    }

    public FqName getFqName() {
        return AnnotationDescriptor.DefaultImpls.getFqName(this);
    }

    public Map<Name, ConstantValue<?>> getAllValueArguments() {
        Map<Name, ConstantValue<?>> map = this.f60192b;
        if (map == null) {
            m44523a(4);
        }
        return map;
    }

    public SourceElement getSource() {
        SourceElement sourceElement = this.f60193c;
        if (sourceElement == null) {
            m44523a(5);
        }
        return sourceElement;
    }

    public String toString() {
        return DescriptorRenderer.FQ_NAMES_IN_TYPES.renderAnnotation(this, (AnnotationUseSiteTarget) null);
    }
}
