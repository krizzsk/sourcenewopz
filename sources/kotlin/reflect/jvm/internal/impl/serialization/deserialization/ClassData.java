package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.BinaryVersion;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import org.osgi.framework.VersionRange;

/* compiled from: ClassData.kt */
public final class ClassData {

    /* renamed from: a */
    private final NameResolver f60949a;

    /* renamed from: b */
    private final ProtoBuf.Class f60950b;

    /* renamed from: c */
    private final BinaryVersion f60951c;

    /* renamed from: d */
    private final SourceElement f60952d;

    public final NameResolver component1() {
        return this.f60949a;
    }

    public final ProtoBuf.Class component2() {
        return this.f60950b;
    }

    public final BinaryVersion component3() {
        return this.f60951c;
    }

    public final SourceElement component4() {
        return this.f60952d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ClassData)) {
            return false;
        }
        ClassData classData = (ClassData) obj;
        return Intrinsics.areEqual((Object) this.f60949a, (Object) classData.f60949a) && Intrinsics.areEqual((Object) this.f60950b, (Object) classData.f60950b) && Intrinsics.areEqual((Object) this.f60951c, (Object) classData.f60951c) && Intrinsics.areEqual((Object) this.f60952d, (Object) classData.f60952d);
    }

    public int hashCode() {
        return (((((this.f60949a.hashCode() * 31) + this.f60950b.hashCode()) * 31) + this.f60951c.hashCode()) * 31) + this.f60952d.hashCode();
    }

    public String toString() {
        return "ClassData(nameResolver=" + this.f60949a + ", classProto=" + this.f60950b + ", metadataVersion=" + this.f60951c + ", sourceElement=" + this.f60952d + VersionRange.RIGHT_OPEN;
    }

    public ClassData(NameResolver nameResolver, ProtoBuf.Class classR, BinaryVersion binaryVersion, SourceElement sourceElement) {
        Intrinsics.checkNotNullParameter(nameResolver, "nameResolver");
        Intrinsics.checkNotNullParameter(classR, "classProto");
        Intrinsics.checkNotNullParameter(binaryVersion, "metadataVersion");
        Intrinsics.checkNotNullParameter(sourceElement, "sourceElement");
        this.f60949a = nameResolver;
        this.f60950b = classR;
        this.f60951c = binaryVersion;
        this.f60952d = sourceElement;
    }
}
