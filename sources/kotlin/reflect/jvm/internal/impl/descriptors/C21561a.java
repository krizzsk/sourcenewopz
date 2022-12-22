package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.Variance;

/* renamed from: kotlin.reflect.jvm.internal.impl.descriptors.a */
/* compiled from: typeParameterUtils.kt */
final class C21561a implements TypeParameterDescriptor {

    /* renamed from: a */
    private final TypeParameterDescriptor f60188a;

    /* renamed from: b */
    private final DeclarationDescriptor f60189b;

    /* renamed from: c */
    private final int f60190c;

    public <R, D> R accept(DeclarationDescriptorVisitor<R, D> declarationDescriptorVisitor, D d) {
        return this.f60188a.accept(declarationDescriptorVisitor, d);
    }

    public Annotations getAnnotations() {
        return this.f60188a.getAnnotations();
    }

    public SimpleType getDefaultType() {
        return this.f60188a.getDefaultType();
    }

    public Name getName() {
        return this.f60188a.getName();
    }

    public SourceElement getSource() {
        return this.f60188a.getSource();
    }

    public StorageManager getStorageManager() {
        return this.f60188a.getStorageManager();
    }

    public TypeConstructor getTypeConstructor() {
        return this.f60188a.getTypeConstructor();
    }

    public List<KotlinType> getUpperBounds() {
        return this.f60188a.getUpperBounds();
    }

    public Variance getVariance() {
        return this.f60188a.getVariance();
    }

    public boolean isCapturedFromOuterDeclaration() {
        return true;
    }

    public boolean isReified() {
        return this.f60188a.isReified();
    }

    public C21561a(TypeParameterDescriptor typeParameterDescriptor, DeclarationDescriptor declarationDescriptor, int i) {
        Intrinsics.checkNotNullParameter(typeParameterDescriptor, "originalDescriptor");
        Intrinsics.checkNotNullParameter(declarationDescriptor, "declarationDescriptor");
        this.f60188a = typeParameterDescriptor;
        this.f60189b = declarationDescriptor;
        this.f60190c = i;
    }

    public TypeParameterDescriptor getOriginal() {
        TypeParameterDescriptor original = this.f60188a.getOriginal();
        Intrinsics.checkNotNullExpressionValue(original, "originalDescriptor.original");
        return original;
    }

    public DeclarationDescriptor getContainingDeclaration() {
        return this.f60189b;
    }

    public int getIndex() {
        return this.f60190c + this.f60188a.getIndex();
    }

    public String toString() {
        return this.f60188a + "[inner-copy]";
    }
}
