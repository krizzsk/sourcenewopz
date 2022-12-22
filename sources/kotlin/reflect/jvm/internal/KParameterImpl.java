package kotlin.reflect.jvm.internal;

import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.C21490Reflection;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.KParameter;
import kotlin.reflect.KProperty;
import kotlin.reflect.KType;
import kotlin.reflect.jvm.internal.ReflectProperties;
import kotlin.reflect.jvm.internal.impl.descriptors.ParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

@Metadata(mo175977d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B/\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0002\u0010\u000bJ\u0013\u0010)\u001a\u00020\u001c2\b\u0010*\u001a\u0004\u0018\u00010+H\u0002J\b\u0010,\u001a\u00020\u0005H\u0016J\b\u0010-\u001a\u00020\"H\u0016R!\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8VX\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R\u0015\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0015\u001a\u00020\n8BX\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0012\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001b\u001a\u00020\u001c8VX\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001dR\u0014\u0010\u001e\u001a\u00020\u001c8VX\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001dR\u0014\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0016\u0010!\u001a\u0004\u0018\u00010\"8VX\u0004¢\u0006\u0006\u001a\u0004\b#\u0010$R\u0014\u0010%\u001a\u00020&8VX\u0004¢\u0006\u0006\u001a\u0004\b'\u0010(¨\u0006."}, mo175978d2 = {"Lkotlin/reflect/jvm/internal/KParameterImpl;", "Lkotlin/reflect/KParameter;", "callable", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "index", "", "kind", "Lkotlin/reflect/KParameter$Kind;", "computeDescriptor", "Lkotlin/Function0;", "Lkotlin/reflect/jvm/internal/impl/descriptors/ParameterDescriptor;", "(Lkotlin/reflect/jvm/internal/KCallableImpl;ILkotlin/reflect/KParameter$Kind;Lkotlin/jvm/functions/Function0;)V", "annotations", "", "", "getAnnotations", "()Ljava/util/List;", "annotations$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "getCallable", "()Lkotlin/reflect/jvm/internal/KCallableImpl;", "descriptor", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/ParameterDescriptor;", "descriptor$delegate", "getIndex", "()I", "isOptional", "", "()Z", "isVararg", "getKind", "()Lkotlin/reflect/KParameter$Kind;", "name", "", "getName", "()Ljava/lang/String;", "type", "Lkotlin/reflect/KType;", "getType", "()Lkotlin/reflect/KType;", "equals", "other", "", "hashCode", "toString", "kotlin-reflection"}, mo175979k = 1, mo175980mv = {1, 5, 1})
/* compiled from: KParameterImpl.kt */
public final class KParameterImpl implements KParameter {

    /* renamed from: a */
    static final /* synthetic */ KProperty[] f60038a;

    /* renamed from: b */
    private final ReflectProperties.LazySoftVal f60039b;

    /* renamed from: c */
    private final ReflectProperties.LazySoftVal f60040c = ReflectProperties.lazySoft(new KParameterImpl$annotations$2(this));

    /* renamed from: d */
    private final KCallableImpl<?> f60041d;

    /* renamed from: e */
    private final int f60042e;

    /* renamed from: f */
    private final KParameter.Kind f60043f;

    static {
        Class<KParameterImpl> cls = KParameterImpl.class;
        f60038a = new KProperty[]{C21490Reflection.property1(new PropertyReference1Impl(C21490Reflection.getOrCreateKotlinClass(cls), "descriptor", "getDescriptor()Lorg/jetbrains/kotlin/descriptors/ParameterDescriptor;")), C21490Reflection.property1(new PropertyReference1Impl(C21490Reflection.getOrCreateKotlinClass(cls), "annotations", "getAnnotations()Ljava/util/List;"))};
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final ParameterDescriptor m44446a() {
        return (ParameterDescriptor) this.f60039b.getValue(this, f60038a[0]);
    }

    public List<Annotation> getAnnotations() {
        return (List) this.f60040c.getValue(this, f60038a[1]);
    }

    public KParameterImpl(KCallableImpl<?> kCallableImpl, int i, KParameter.Kind kind, Function0<? extends ParameterDescriptor> function0) {
        Intrinsics.checkNotNullParameter(kCallableImpl, "callable");
        Intrinsics.checkNotNullParameter(kind, "kind");
        Intrinsics.checkNotNullParameter(function0, "computeDescriptor");
        this.f60041d = kCallableImpl;
        this.f60042e = i;
        this.f60043f = kind;
        this.f60039b = ReflectProperties.lazySoft(function0);
    }

    public final KCallableImpl<?> getCallable() {
        return this.f60041d;
    }

    public int getIndex() {
        return this.f60042e;
    }

    public KParameter.Kind getKind() {
        return this.f60043f;
    }

    public String getName() {
        ParameterDescriptor a = m44446a();
        if (!(a instanceof ValueParameterDescriptor)) {
            a = null;
        }
        ValueParameterDescriptor valueParameterDescriptor = (ValueParameterDescriptor) a;
        if (valueParameterDescriptor == null || valueParameterDescriptor.getContainingDeclaration().hasSynthesizedParameterNames()) {
            return null;
        }
        Name name = valueParameterDescriptor.getName();
        Intrinsics.checkNotNullExpressionValue(name, "valueParameter.name");
        if (name.isSpecial()) {
            return null;
        }
        return name.asString();
    }

    public KType getType() {
        KotlinType type = m44446a().getType();
        Intrinsics.checkNotNullExpressionValue(type, "descriptor.type");
        return new KTypeImpl(type, new KParameterImpl$type$1(this));
    }

    public boolean isOptional() {
        ParameterDescriptor a = m44446a();
        if (!(a instanceof ValueParameterDescriptor)) {
            a = null;
        }
        ValueParameterDescriptor valueParameterDescriptor = (ValueParameterDescriptor) a;
        if (valueParameterDescriptor != null) {
            return DescriptorUtilsKt.declaresOrInheritsDefaultValue(valueParameterDescriptor);
        }
        return false;
    }

    public boolean isVararg() {
        ParameterDescriptor a = m44446a();
        return (a instanceof ValueParameterDescriptor) && ((ValueParameterDescriptor) a).getVarargElementType() != null;
    }

    public boolean equals(Object obj) {
        if (obj instanceof KParameterImpl) {
            KParameterImpl kParameterImpl = (KParameterImpl) obj;
            return Intrinsics.areEqual((Object) this.f60041d, (Object) kParameterImpl.f60041d) && getIndex() == kParameterImpl.getIndex();
        }
    }

    public int hashCode() {
        return (this.f60041d.hashCode() * 31) + Integer.valueOf(getIndex()).hashCode();
    }

    public String toString() {
        return ReflectionObjectRenderer.INSTANCE.renderParameter(this);
    }
}
