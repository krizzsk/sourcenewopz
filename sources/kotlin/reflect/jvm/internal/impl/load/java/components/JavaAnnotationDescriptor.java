package kotlin.reflect.jvm.internal.impl.load.java.components;

import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.C21490Reflection;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.PossiblyExternalAnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageKt;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;

/* compiled from: JavaAnnotationMapper.kt */
public class JavaAnnotationDescriptor implements AnnotationDescriptor, PossiblyExternalAnnotationDescriptor {

    /* renamed from: a */
    static final /* synthetic */ KProperty<Object>[] f60432a = {C21490Reflection.property1(new PropertyReference1Impl(C21490Reflection.getOrCreateKotlinClass(JavaAnnotationDescriptor.class), "type", "getType()Lorg/jetbrains/kotlin/types/SimpleType;"))};

    /* renamed from: b */
    private final FqName f60433b;

    /* renamed from: c */
    private final SourceElement f60434c;

    /* renamed from: d */
    private final NotNullLazyValue f60435d;

    /* renamed from: e */
    private final JavaAnnotationArgument f60436e;

    /* renamed from: f */
    private final boolean f60437f;

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v7, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v4, resolved type: kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationArgument} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public JavaAnnotationDescriptor(kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext r3, kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation r4, kotlin.reflect.jvm.internal.impl.name.FqName r5) {
        /*
            r2 = this;
            java.lang.String r0 = "c"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "fqName"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            r2.<init>()
            r2.f60433b = r5
            r5 = 0
            if (r4 != 0) goto L_0x0014
            r0 = r5
            goto L_0x0023
        L_0x0014:
            kotlin.reflect.jvm.internal.impl.load.java.lazy.JavaResolverComponents r0 = r3.getComponents()
            kotlin.reflect.jvm.internal.impl.load.java.sources.JavaSourceElementFactory r0 = r0.getSourceElementFactory()
            r1 = r4
            kotlin.reflect.jvm.internal.impl.load.java.structure.JavaElement r1 = (kotlin.reflect.jvm.internal.impl.load.java.structure.JavaElement) r1
            kotlin.reflect.jvm.internal.impl.load.java.sources.JavaSourceElement r0 = r0.source(r1)
        L_0x0023:
            if (r0 != 0) goto L_0x002d
            kotlin.reflect.jvm.internal.impl.descriptors.SourceElement r0 = kotlin.reflect.jvm.internal.impl.descriptors.SourceElement.NO_SOURCE
            java.lang.String r1 = "NO_SOURCE"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            goto L_0x002f
        L_0x002d:
            kotlin.reflect.jvm.internal.impl.descriptors.SourceElement r0 = (kotlin.reflect.jvm.internal.impl.descriptors.SourceElement) r0
        L_0x002f:
            r2.f60434c = r0
            kotlin.reflect.jvm.internal.impl.storage.StorageManager r0 = r3.getStorageManager()
            kotlin.reflect.jvm.internal.impl.load.java.components.JavaAnnotationDescriptor$type$2 r1 = new kotlin.reflect.jvm.internal.impl.load.java.components.JavaAnnotationDescriptor$type$2
            r1.<init>(r3, r2)
            kotlin.jvm.functions.Function0 r1 = (kotlin.jvm.functions.Function0) r1
            kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue r3 = r0.createLazyValue(r1)
            r2.f60435d = r3
            if (r4 != 0) goto L_0x0045
            goto L_0x0055
        L_0x0045:
            java.util.Collection r3 = r4.getArguments()
            if (r3 != 0) goto L_0x004c
            goto L_0x0055
        L_0x004c:
            java.lang.Iterable r3 = (java.lang.Iterable) r3
            java.lang.Object r3 = kotlin.collections.CollectionsKt.firstOrNull(r3)
            r5 = r3
            kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationArgument r5 = (kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationArgument) r5
        L_0x0055:
            r2.f60436e = r5
            r3 = 0
            r5 = 1
            if (r4 != 0) goto L_0x005c
            goto L_0x0063
        L_0x005c:
            boolean r4 = r4.isIdeExternalAnnotation()
            if (r4 != r5) goto L_0x0063
            r3 = 1
        L_0x0063:
            r2.f60437f = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.java.components.JavaAnnotationDescriptor.<init>(kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext, kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation, kotlin.reflect.jvm.internal.impl.name.FqName):void");
    }

    public FqName getFqName() {
        return this.f60433b;
    }

    public SourceElement getSource() {
        return this.f60434c;
    }

    public SimpleType getType() {
        return (SimpleType) StorageKt.getValue(this.f60435d, (Object) this, (KProperty<?>) f60432a[0]);
    }

    /* access modifiers changed from: protected */
    public final JavaAnnotationArgument getFirstArgument() {
        return this.f60436e;
    }

    public Map<Name, ConstantValue<?>> getAllValueArguments() {
        return MapsKt.emptyMap();
    }

    public boolean isIdeExternalAnnotation() {
        return this.f60437f;
    }
}
