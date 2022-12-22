package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.reflect.Field;
import java.lang.reflect.Type;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaField;

/* compiled from: ReflectJavaField.kt */
public final class ReflectJavaField extends ReflectJavaMember implements JavaField {

    /* renamed from: a */
    private final Field f60348a;

    public boolean getHasConstantNotNullInitializer() {
        return false;
    }

    public ReflectJavaField(Field field) {
        Intrinsics.checkNotNullParameter(field, "member");
        this.f60348a = field;
    }

    public Field getMember() {
        return this.f60348a;
    }

    public boolean isEnumEntry() {
        return getMember().isEnumConstant();
    }

    public ReflectJavaType getType() {
        ReflectJavaType.Factory factory = ReflectJavaType.Factory;
        Type genericType = getMember().getGenericType();
        Intrinsics.checkNotNullExpressionValue(genericType, "member.genericType");
        return factory.create(genericType);
    }
}
