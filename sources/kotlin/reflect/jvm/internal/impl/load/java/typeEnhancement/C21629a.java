package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import java.util.Map;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* renamed from: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.a */
/* compiled from: typeEnhancement.kt */
final class C21629a implements AnnotationDescriptor {

    /* renamed from: a */
    public static final C21629a f60618a = new C21629a();

    public String toString() {
        return "[EnhancedType]";
    }

    private C21629a() {
    }

    public FqName getFqName() {
        return AnnotationDescriptor.DefaultImpls.getFqName(this);
    }

    /* renamed from: a */
    private final Void m44709a() {
        throw new IllegalStateException("No methods should be called on this descriptor. Only its presence matters".toString());
    }

    public KotlinType getType() {
        m44709a();
        throw null;
    }

    public Map<Name, ConstantValue<?>> getAllValueArguments() {
        m44709a();
        throw null;
    }

    public SourceElement getSource() {
        m44709a();
        throw null;
    }
}
