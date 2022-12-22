package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Function;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function10;
import kotlin.jvm.functions.Function11;
import kotlin.jvm.functions.Function12;
import kotlin.jvm.functions.Function13;
import kotlin.jvm.functions.Function14;
import kotlin.jvm.functions.Function15;
import kotlin.jvm.functions.Function16;
import kotlin.jvm.functions.Function17;
import kotlin.jvm.functions.Function18;
import kotlin.jvm.functions.Function19;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function20;
import kotlin.jvm.functions.Function21;
import kotlin.jvm.functions.Function22;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.functions.Function7;
import kotlin.jvm.functions.Function8;
import kotlin.jvm.functions.Function9;
import kotlin.jvm.internal.C21490Reflection;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import org.apache.commons.p071io.IOUtils;
import org.bouncycastle.pqc.math.linearalgebra.Matrix;

/* compiled from: reflectClassUtil.kt */
public final class ReflectClassUtilKt {

    /* renamed from: a */
    private static final List<KClass<? extends Object>> f60330a;

    /* renamed from: b */
    private static final Map<Class<? extends Object>, Class<? extends Object>> f60331b;

    /* renamed from: c */
    private static final Map<Class<? extends Object>, Class<? extends Object>> f60332c;

    /* renamed from: d */
    private static final Map<Class<? extends Function<?>>, Integer> f60333d;

    public static final ClassLoader getSafeClassLoader(Class<?> cls) {
        Intrinsics.checkNotNullParameter(cls, "<this>");
        ClassLoader classLoader = cls.getClassLoader();
        if (classLoader != null) {
            return classLoader;
        }
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        Intrinsics.checkNotNullExpressionValue(systemClassLoader, "getSystemClassLoader()");
        return systemClassLoader;
    }

    public static final boolean isEnumClassOrSpecializedEnumEntryClass(Class<?> cls) {
        Intrinsics.checkNotNullParameter(cls, "<this>");
        return Enum.class.isAssignableFrom(cls);
    }

    static {
        int i = 0;
        List<KClass<? extends Object>> listOf = CollectionsKt.listOf(C21490Reflection.getOrCreateKotlinClass(Boolean.TYPE), C21490Reflection.getOrCreateKotlinClass(Byte.TYPE), C21490Reflection.getOrCreateKotlinClass(Character.TYPE), C21490Reflection.getOrCreateKotlinClass(Double.TYPE), C21490Reflection.getOrCreateKotlinClass(Float.TYPE), C21490Reflection.getOrCreateKotlinClass(Integer.TYPE), C21490Reflection.getOrCreateKotlinClass(Long.TYPE), C21490Reflection.getOrCreateKotlinClass(Short.TYPE));
        f60330a = listOf;
        Iterable<KClass> iterable = listOf;
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (KClass kClass : iterable) {
            arrayList.add(TuplesKt.m42317to(JvmClassMappingKt.getJavaObjectType(kClass), JvmClassMappingKt.getJavaPrimitiveType(kClass)));
        }
        f60331b = MapsKt.toMap((List) arrayList);
        Iterable<KClass> iterable2 = f60330a;
        Collection arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable2, 10));
        for (KClass kClass2 : iterable2) {
            arrayList2.add(TuplesKt.m42317to(JvmClassMappingKt.getJavaPrimitiveType(kClass2), JvmClassMappingKt.getJavaObjectType(kClass2)));
        }
        f60332c = MapsKt.toMap((List) arrayList2);
        Iterable listOf2 = CollectionsKt.listOf(Function0.class, Function1.class, Function2.class, Function3.class, Function4.class, Function5.class, Function6.class, Function7.class, Function8.class, Function9.class, Function10.class, Function11.class, Function12.class, Function13.class, Function14.class, Function15.class, Function16.class, Function17.class, Function18.class, Function19.class, Function20.class, Function21.class, Function22.class);
        Collection arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(listOf2, 10));
        for (Object next : listOf2) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            arrayList3.add(TuplesKt.m42317to((Class) next, Integer.valueOf(i)));
            i = i2;
        }
        f60333d = MapsKt.toMap((List) arrayList3);
    }

    public static final Class<?> getPrimitiveByWrapper(Class<?> cls) {
        Intrinsics.checkNotNullParameter(cls, "<this>");
        return f60331b.get(cls);
    }

    public static final Class<?> getWrapperByPrimitive(Class<?> cls) {
        Intrinsics.checkNotNullParameter(cls, "<this>");
        return f60332c.get(cls);
    }

    public static final Integer getFunctionClassArity(Class<?> cls) {
        Intrinsics.checkNotNullParameter(cls, "<this>");
        return f60333d.get(cls);
    }

    public static final ClassId getClassId(Class<?> cls) {
        Intrinsics.checkNotNullParameter(cls, "<this>");
        if (cls.isPrimitive()) {
            throw new IllegalArgumentException(Intrinsics.stringPlus("Can't compute ClassId for primitive type: ", cls));
        } else if (!cls.isArray()) {
            if (cls.getEnclosingMethod() == null && cls.getEnclosingConstructor() == null) {
                String simpleName = cls.getSimpleName();
                Intrinsics.checkNotNullExpressionValue(simpleName, "simpleName");
                if (!(simpleName.length() == 0)) {
                    Class<?> declaringClass = cls.getDeclaringClass();
                    ClassId createNestedClassId = declaringClass == null ? null : getClassId(declaringClass).createNestedClassId(Name.identifier(cls.getSimpleName()));
                    if (createNestedClassId == null) {
                        createNestedClassId = ClassId.topLevel(new FqName(cls.getName()));
                    }
                    Intrinsics.checkNotNullExpressionValue(createNestedClassId, "declaringClass?.classId?…Id.topLevel(FqName(name))");
                    return createNestedClassId;
                }
            }
            FqName fqName = new FqName(cls.getName());
            return new ClassId(fqName.parent(), FqName.topLevel(fqName.shortName()), true);
        } else {
            throw new IllegalArgumentException(Intrinsics.stringPlus("Can't compute ClassId for array type: ", cls));
        }
    }

    public static final String getDesc(Class<?> cls) {
        Intrinsics.checkNotNullParameter(cls, "<this>");
        if (cls.isPrimitive()) {
            String name = cls.getName();
            if (name != null) {
                switch (name.hashCode()) {
                    case -1325958191:
                        if (name.equals("double")) {
                            return "D";
                        }
                        break;
                    case 104431:
                        if (name.equals("int")) {
                            return "I";
                        }
                        break;
                    case 3039496:
                        if (name.equals("byte")) {
                            return "B";
                        }
                        break;
                    case 3052374:
                        if (name.equals("char")) {
                            return "C";
                        }
                        break;
                    case 3327612:
                        if (name.equals("long")) {
                            return "J";
                        }
                        break;
                    case 3625364:
                        if (name.equals("void")) {
                            return ExifInterface.GPS_MEASUREMENT_INTERRUPTED;
                        }
                        break;
                    case 64711720:
                        if (name.equals(TypedValues.Custom.S_BOOLEAN)) {
                            return "Z";
                        }
                        break;
                    case 97526364:
                        if (name.equals("float")) {
                            return "F";
                        }
                        break;
                    case 109413500:
                        if (name.equals("short")) {
                            return ExifInterface.LATITUDE_SOUTH;
                        }
                        break;
                }
            }
            throw new IllegalArgumentException(Intrinsics.stringPlus("Unsupported primitive type: ", cls));
        } else if (cls.isArray()) {
            String name2 = cls.getName();
            Intrinsics.checkNotNullExpressionValue(name2, "name");
            return StringsKt.replace$default(name2, '.', (char) IOUtils.DIR_SEPARATOR_UNIX, false, 4, (Object) null);
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append(Matrix.MATRIX_TYPE_RANDOM_LT);
            String name3 = cls.getName();
            Intrinsics.checkNotNullExpressionValue(name3, "name");
            sb.append(StringsKt.replace$default(name3, '.', (char) IOUtils.DIR_SEPARATOR_UNIX, false, 4, (Object) null));
            sb.append(';');
            return sb.toString();
        }
    }

    public static final List<Type> getParameterizedTypeArguments(Type type) {
        Intrinsics.checkNotNullParameter(type, "<this>");
        if (!(type instanceof ParameterizedType)) {
            return CollectionsKt.emptyList();
        }
        ParameterizedType parameterizedType = (ParameterizedType) type;
        if (parameterizedType.getOwnerType() != null) {
            return SequencesKt.toList(SequencesKt.flatMap(SequencesKt.generateSequence(type, ReflectClassUtilKt$parameterizedTypeArguments$1.INSTANCE), ReflectClassUtilKt$parameterizedTypeArguments$2.INSTANCE));
        }
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        Intrinsics.checkNotNullExpressionValue(actualTypeArguments, "actualTypeArguments");
        return ArraysKt.toList((T[]) (Object[]) actualTypeArguments);
    }
}
