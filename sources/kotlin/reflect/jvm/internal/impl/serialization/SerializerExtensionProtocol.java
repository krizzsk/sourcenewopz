package kotlin.reflect.jvm.internal.impl.serialization;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;

/* compiled from: SerializerExtensionProtocol.kt */
public class SerializerExtensionProtocol {

    /* renamed from: a */
    private final ExtensionRegistryLite f60928a;

    /* renamed from: b */
    private final GeneratedMessageLite.GeneratedExtension<ProtoBuf.Package, Integer> f60929b;

    /* renamed from: c */
    private final GeneratedMessageLite.GeneratedExtension<ProtoBuf.Constructor, List<ProtoBuf.Annotation>> f60930c;

    /* renamed from: d */
    private final GeneratedMessageLite.GeneratedExtension<ProtoBuf.Class, List<ProtoBuf.Annotation>> f60931d;

    /* renamed from: e */
    private final GeneratedMessageLite.GeneratedExtension<ProtoBuf.Function, List<ProtoBuf.Annotation>> f60932e;

    /* renamed from: f */
    private final GeneratedMessageLite.GeneratedExtension<ProtoBuf.Property, List<ProtoBuf.Annotation>> f60933f;

    /* renamed from: g */
    private final GeneratedMessageLite.GeneratedExtension<ProtoBuf.Property, List<ProtoBuf.Annotation>> f60934g;

    /* renamed from: h */
    private final GeneratedMessageLite.GeneratedExtension<ProtoBuf.Property, List<ProtoBuf.Annotation>> f60935h;

    /* renamed from: i */
    private final GeneratedMessageLite.GeneratedExtension<ProtoBuf.EnumEntry, List<ProtoBuf.Annotation>> f60936i;

    /* renamed from: j */
    private final GeneratedMessageLite.GeneratedExtension<ProtoBuf.Property, ProtoBuf.Annotation.Argument.Value> f60937j;

    /* renamed from: k */
    private final GeneratedMessageLite.GeneratedExtension<ProtoBuf.ValueParameter, List<ProtoBuf.Annotation>> f60938k;

    /* renamed from: l */
    private final GeneratedMessageLite.GeneratedExtension<ProtoBuf.Type, List<ProtoBuf.Annotation>> f60939l;

    /* renamed from: m */
    private final GeneratedMessageLite.GeneratedExtension<ProtoBuf.TypeParameter, List<ProtoBuf.Annotation>> f60940m;

    public SerializerExtensionProtocol(ExtensionRegistryLite extensionRegistryLite, GeneratedMessageLite.GeneratedExtension<ProtoBuf.Package, Integer> generatedExtension, GeneratedMessageLite.GeneratedExtension<ProtoBuf.Constructor, List<ProtoBuf.Annotation>> generatedExtension2, GeneratedMessageLite.GeneratedExtension<ProtoBuf.Class, List<ProtoBuf.Annotation>> generatedExtension3, GeneratedMessageLite.GeneratedExtension<ProtoBuf.Function, List<ProtoBuf.Annotation>> generatedExtension4, GeneratedMessageLite.GeneratedExtension<ProtoBuf.Property, List<ProtoBuf.Annotation>> generatedExtension5, GeneratedMessageLite.GeneratedExtension<ProtoBuf.Property, List<ProtoBuf.Annotation>> generatedExtension6, GeneratedMessageLite.GeneratedExtension<ProtoBuf.Property, List<ProtoBuf.Annotation>> generatedExtension7, GeneratedMessageLite.GeneratedExtension<ProtoBuf.EnumEntry, List<ProtoBuf.Annotation>> generatedExtension8, GeneratedMessageLite.GeneratedExtension<ProtoBuf.Property, ProtoBuf.Annotation.Argument.Value> generatedExtension9, GeneratedMessageLite.GeneratedExtension<ProtoBuf.ValueParameter, List<ProtoBuf.Annotation>> generatedExtension10, GeneratedMessageLite.GeneratedExtension<ProtoBuf.Type, List<ProtoBuf.Annotation>> generatedExtension11, GeneratedMessageLite.GeneratedExtension<ProtoBuf.TypeParameter, List<ProtoBuf.Annotation>> generatedExtension12) {
        Intrinsics.checkNotNullParameter(extensionRegistryLite, "extensionRegistry");
        Intrinsics.checkNotNullParameter(generatedExtension, "packageFqName");
        Intrinsics.checkNotNullParameter(generatedExtension2, "constructorAnnotation");
        Intrinsics.checkNotNullParameter(generatedExtension3, "classAnnotation");
        Intrinsics.checkNotNullParameter(generatedExtension4, "functionAnnotation");
        Intrinsics.checkNotNullParameter(generatedExtension5, "propertyAnnotation");
        Intrinsics.checkNotNullParameter(generatedExtension6, "propertyGetterAnnotation");
        Intrinsics.checkNotNullParameter(generatedExtension7, "propertySetterAnnotation");
        Intrinsics.checkNotNullParameter(generatedExtension8, "enumEntryAnnotation");
        Intrinsics.checkNotNullParameter(generatedExtension9, "compileTimeValue");
        Intrinsics.checkNotNullParameter(generatedExtension10, "parameterAnnotation");
        Intrinsics.checkNotNullParameter(generatedExtension11, "typeAnnotation");
        Intrinsics.checkNotNullParameter(generatedExtension12, "typeParameterAnnotation");
        this.f60928a = extensionRegistryLite;
        this.f60929b = generatedExtension;
        this.f60930c = generatedExtension2;
        this.f60931d = generatedExtension3;
        this.f60932e = generatedExtension4;
        this.f60933f = generatedExtension5;
        this.f60934g = generatedExtension6;
        this.f60935h = generatedExtension7;
        this.f60936i = generatedExtension8;
        this.f60937j = generatedExtension9;
        this.f60938k = generatedExtension10;
        this.f60939l = generatedExtension11;
        this.f60940m = generatedExtension12;
    }

    public final ExtensionRegistryLite getExtensionRegistry() {
        return this.f60928a;
    }

    public final GeneratedMessageLite.GeneratedExtension<ProtoBuf.Constructor, List<ProtoBuf.Annotation>> getConstructorAnnotation() {
        return this.f60930c;
    }

    public final GeneratedMessageLite.GeneratedExtension<ProtoBuf.Class, List<ProtoBuf.Annotation>> getClassAnnotation() {
        return this.f60931d;
    }

    public final GeneratedMessageLite.GeneratedExtension<ProtoBuf.Function, List<ProtoBuf.Annotation>> getFunctionAnnotation() {
        return this.f60932e;
    }

    public final GeneratedMessageLite.GeneratedExtension<ProtoBuf.Property, List<ProtoBuf.Annotation>> getPropertyAnnotation() {
        return this.f60933f;
    }

    public final GeneratedMessageLite.GeneratedExtension<ProtoBuf.Property, List<ProtoBuf.Annotation>> getPropertyGetterAnnotation() {
        return this.f60934g;
    }

    public final GeneratedMessageLite.GeneratedExtension<ProtoBuf.Property, List<ProtoBuf.Annotation>> getPropertySetterAnnotation() {
        return this.f60935h;
    }

    public final GeneratedMessageLite.GeneratedExtension<ProtoBuf.EnumEntry, List<ProtoBuf.Annotation>> getEnumEntryAnnotation() {
        return this.f60936i;
    }

    public final GeneratedMessageLite.GeneratedExtension<ProtoBuf.Property, ProtoBuf.Annotation.Argument.Value> getCompileTimeValue() {
        return this.f60937j;
    }

    public final GeneratedMessageLite.GeneratedExtension<ProtoBuf.ValueParameter, List<ProtoBuf.Annotation>> getParameterAnnotation() {
        return this.f60938k;
    }

    public final GeneratedMessageLite.GeneratedExtension<ProtoBuf.Type, List<ProtoBuf.Annotation>> getTypeAnnotation() {
        return this.f60939l;
    }

    public final GeneratedMessageLite.GeneratedExtension<ProtoBuf.TypeParameter, List<ProtoBuf.Annotation>> getTypeParameterAnnotation() {
        return this.f60940m;
    }
}
