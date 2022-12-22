package kotlin.reflect.jvm.internal.impl.descriptors.runtime.components;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.ReadKotlinClassHeaderAnnotationVisitor;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.text.StringsKt;
import org.apache.commons.p071io.IOUtils;

/* compiled from: ReflectKotlinClass.kt */
public final class ReflectKotlinClass implements KotlinJvmBinaryClass {
    public static final Factory Factory = new Factory((DefaultConstructorMarker) null);

    /* renamed from: a */
    private final Class<?> f60319a;

    /* renamed from: b */
    private final KotlinClassHeader f60320b;

    public /* synthetic */ ReflectKotlinClass(Class cls, KotlinClassHeader kotlinClassHeader, DefaultConstructorMarker defaultConstructorMarker) {
        this(cls, kotlinClassHeader);
    }

    private ReflectKotlinClass(Class<?> cls, KotlinClassHeader kotlinClassHeader) {
        this.f60319a = cls;
        this.f60320b = kotlinClassHeader;
    }

    public final Class<?> getKlass() {
        return this.f60319a;
    }

    public KotlinClassHeader getClassHeader() {
        return this.f60320b;
    }

    /* compiled from: ReflectKotlinClass.kt */
    public static final class Factory {
        public /* synthetic */ Factory(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Factory() {
        }

        public final ReflectKotlinClass create(Class<?> cls) {
            Intrinsics.checkNotNullParameter(cls, "klass");
            ReadKotlinClassHeaderAnnotationVisitor readKotlinClassHeaderAnnotationVisitor = new ReadKotlinClassHeaderAnnotationVisitor();
            C21579a.f60326a.mo177756a(cls, (KotlinJvmBinaryClass.AnnotationVisitor) readKotlinClassHeaderAnnotationVisitor);
            KotlinClassHeader createHeader = readKotlinClassHeaderAnnotationVisitor.createHeader();
            if (createHeader == null) {
                return null;
            }
            return new ReflectKotlinClass(cls, createHeader, (DefaultConstructorMarker) null);
        }
    }

    public String getLocation() {
        String name = this.f60319a.getName();
        Intrinsics.checkNotNullExpressionValue(name, "klass.name");
        return Intrinsics.stringPlus(StringsKt.replace$default(name, '.', (char) IOUtils.DIR_SEPARATOR_UNIX, false, 4, (Object) null), ".class");
    }

    public ClassId getClassId() {
        return ReflectClassUtilKt.getClassId(this.f60319a);
    }

    public void loadClassAnnotations(KotlinJvmBinaryClass.AnnotationVisitor annotationVisitor, byte[] bArr) {
        Intrinsics.checkNotNullParameter(annotationVisitor, "visitor");
        C21579a.f60326a.mo177756a(this.f60319a, annotationVisitor);
    }

    public void visitMembers(KotlinJvmBinaryClass.MemberVisitor memberVisitor, byte[] bArr) {
        Intrinsics.checkNotNullParameter(memberVisitor, "visitor");
        C21579a.f60326a.mo177757a(this.f60319a, memberVisitor);
    }

    public boolean equals(Object obj) {
        return (obj instanceof ReflectKotlinClass) && Intrinsics.areEqual((Object) this.f60319a, (Object) ((ReflectKotlinClass) obj).f60319a);
    }

    public int hashCode() {
        return this.f60319a.hashCode();
    }

    public String toString() {
        return getClass().getName() + ": " + this.f60319a;
    }
}
