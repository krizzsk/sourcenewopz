package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceFile;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMetadataVersion;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.IncompatibleVersionErrorData;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerAbiStability;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerSource;

/* compiled from: KotlinJvmBinarySourceElement.kt */
public final class KotlinJvmBinarySourceElement implements DeserializedContainerSource {

    /* renamed from: a */
    private final KotlinJvmBinaryClass f60651a;

    /* renamed from: b */
    private final IncompatibleVersionErrorData<JvmMetadataVersion> f60652b;

    /* renamed from: c */
    private final boolean f60653c;

    /* renamed from: d */
    private final DeserializedContainerAbiStability f60654d;

    public KotlinJvmBinarySourceElement(KotlinJvmBinaryClass kotlinJvmBinaryClass, IncompatibleVersionErrorData<JvmMetadataVersion> incompatibleVersionErrorData, boolean z, DeserializedContainerAbiStability deserializedContainerAbiStability) {
        Intrinsics.checkNotNullParameter(kotlinJvmBinaryClass, "binaryClass");
        Intrinsics.checkNotNullParameter(deserializedContainerAbiStability, "abiStability");
        this.f60651a = kotlinJvmBinaryClass;
        this.f60652b = incompatibleVersionErrorData;
        this.f60653c = z;
        this.f60654d = deserializedContainerAbiStability;
    }

    public final KotlinJvmBinaryClass getBinaryClass() {
        return this.f60651a;
    }

    public String getPresentableString() {
        return "Class '" + this.f60651a.getClassId().asSingleFqName().asString() + '\'';
    }

    public SourceFile getContainingFile() {
        SourceFile sourceFile = SourceFile.NO_SOURCE_FILE;
        Intrinsics.checkNotNullExpressionValue(sourceFile, "NO_SOURCE_FILE");
        return sourceFile;
    }

    public String toString() {
        return getClass().getSimpleName() + ": " + this.f60651a;
    }
}
