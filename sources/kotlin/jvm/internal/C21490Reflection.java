package kotlin.jvm.internal;

import java.util.Arrays;
import java.util.Collections;
import kotlin.collections.ArraysKt;
import kotlin.reflect.KClass;
import kotlin.reflect.KClassifier;
import kotlin.reflect.KDeclarationContainer;
import kotlin.reflect.KFunction;
import kotlin.reflect.KMutableProperty0;
import kotlin.reflect.KMutableProperty1;
import kotlin.reflect.KMutableProperty2;
import kotlin.reflect.KProperty0;
import kotlin.reflect.KProperty1;
import kotlin.reflect.KProperty2;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeParameter;
import kotlin.reflect.KTypeProjection;
import kotlin.reflect.KVariance;

/* renamed from: kotlin.jvm.internal.Reflection */
public class C21490Reflection {

    /* renamed from: a */
    static final String f59913a = " (Kotlin reflection is not available)";

    /* renamed from: b */
    private static final ReflectionFactory f59914b;

    /* renamed from: c */
    private static final KClass[] f59915c = new KClass[0];

    static {
        ReflectionFactory reflectionFactory = null;
        try {
            reflectionFactory = (ReflectionFactory) Class.forName("kotlin.reflect.jvm.internal.ReflectionFactoryImpl").newInstance();
        } catch (ClassCastException | ClassNotFoundException | IllegalAccessException | InstantiationException unused) {
        }
        if (reflectionFactory == null) {
            reflectionFactory = new ReflectionFactory();
        }
        f59914b = reflectionFactory;
    }

    public static KClass createKotlinClass(Class cls) {
        return f59914b.createKotlinClass(cls);
    }

    public static KClass createKotlinClass(Class cls, String str) {
        return f59914b.createKotlinClass(cls, str);
    }

    public static KDeclarationContainer getOrCreateKotlinPackage(Class cls) {
        return f59914b.getOrCreateKotlinPackage(cls, "");
    }

    public static KDeclarationContainer getOrCreateKotlinPackage(Class cls, String str) {
        return f59914b.getOrCreateKotlinPackage(cls, str);
    }

    public static KClass getOrCreateKotlinClass(Class cls) {
        return f59914b.getOrCreateKotlinClass(cls);
    }

    public static KClass getOrCreateKotlinClass(Class cls, String str) {
        return f59914b.getOrCreateKotlinClass(cls, str);
    }

    public static KClass[] getOrCreateKotlinClasses(Class[] clsArr) {
        int length = clsArr.length;
        if (length == 0) {
            return f59915c;
        }
        KClass[] kClassArr = new KClass[length];
        for (int i = 0; i < length; i++) {
            kClassArr[i] = getOrCreateKotlinClass(clsArr[i]);
        }
        return kClassArr;
    }

    public static String renderLambdaToString(Lambda lambda) {
        return f59914b.renderLambdaToString(lambda);
    }

    public static String renderLambdaToString(FunctionBase functionBase) {
        return f59914b.renderLambdaToString(functionBase);
    }

    public static KFunction function(FunctionReference functionReference) {
        return f59914b.function(functionReference);
    }

    public static KProperty0 property0(PropertyReference0 propertyReference0) {
        return f59914b.property0(propertyReference0);
    }

    public static KMutableProperty0 mutableProperty0(MutablePropertyReference0 mutablePropertyReference0) {
        return f59914b.mutableProperty0(mutablePropertyReference0);
    }

    public static KProperty1 property1(PropertyReference1 propertyReference1) {
        return f59914b.property1(propertyReference1);
    }

    public static KMutableProperty1 mutableProperty1(MutablePropertyReference1 mutablePropertyReference1) {
        return f59914b.mutableProperty1(mutablePropertyReference1);
    }

    public static KProperty2 property2(PropertyReference2 propertyReference2) {
        return f59914b.property2(propertyReference2);
    }

    public static KMutableProperty2 mutableProperty2(MutablePropertyReference2 mutablePropertyReference2) {
        return f59914b.mutableProperty2(mutablePropertyReference2);
    }

    public static KType typeOf(KClassifier kClassifier) {
        return f59914b.typeOf(kClassifier, Collections.emptyList(), false);
    }

    public static KType typeOf(Class cls) {
        return f59914b.typeOf(getOrCreateKotlinClass(cls), Collections.emptyList(), false);
    }

    public static KType typeOf(Class cls, KTypeProjection kTypeProjection) {
        return f59914b.typeOf(getOrCreateKotlinClass(cls), Collections.singletonList(kTypeProjection), false);
    }

    public static KType typeOf(Class cls, KTypeProjection kTypeProjection, KTypeProjection kTypeProjection2) {
        return f59914b.typeOf(getOrCreateKotlinClass(cls), Arrays.asList(new KTypeProjection[]{kTypeProjection, kTypeProjection2}), false);
    }

    public static KType typeOf(Class cls, KTypeProjection... kTypeProjectionArr) {
        return f59914b.typeOf(getOrCreateKotlinClass(cls), ArraysKt.toList((T[]) kTypeProjectionArr), false);
    }

    public static KType nullableTypeOf(KClassifier kClassifier) {
        return f59914b.typeOf(kClassifier, Collections.emptyList(), true);
    }

    public static KType nullableTypeOf(Class cls) {
        return f59914b.typeOf(getOrCreateKotlinClass(cls), Collections.emptyList(), true);
    }

    public static KType nullableTypeOf(Class cls, KTypeProjection kTypeProjection) {
        return f59914b.typeOf(getOrCreateKotlinClass(cls), Collections.singletonList(kTypeProjection), true);
    }

    public static KType nullableTypeOf(Class cls, KTypeProjection kTypeProjection, KTypeProjection kTypeProjection2) {
        return f59914b.typeOf(getOrCreateKotlinClass(cls), Arrays.asList(new KTypeProjection[]{kTypeProjection, kTypeProjection2}), true);
    }

    public static KType nullableTypeOf(Class cls, KTypeProjection... kTypeProjectionArr) {
        return f59914b.typeOf(getOrCreateKotlinClass(cls), ArraysKt.toList((T[]) kTypeProjectionArr), true);
    }

    public static KTypeParameter typeParameter(Object obj, String str, KVariance kVariance, boolean z) {
        return f59914b.typeParameter(obj, str, kVariance, z);
    }

    public static void setUpperBounds(KTypeParameter kTypeParameter, KType kType) {
        f59914b.setUpperBounds(kTypeParameter, Collections.singletonList(kType));
    }

    public static void setUpperBounds(KTypeParameter kTypeParameter, KType... kTypeArr) {
        f59914b.setUpperBounds(kTypeParameter, ArraysKt.toList((T[]) kTypeArr));
    }
}
