package kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization;

import androidx.exifinterface.media.ExifInterface;
import com.didi.map.constant.StringConstant;
import com.didichuxing.bigdata.p173dp.locsdk.Const;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.internal.ProgressionUtilKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.apache.commons.p071io.IOUtils;
import org.bouncycastle.pqc.math.linearalgebra.Matrix;

/* compiled from: ClassMapperLite.kt */
public final class ClassMapperLite {
    public static final ClassMapperLite INSTANCE = new ClassMapperLite();

    /* renamed from: a */
    private static final String f60704a = CollectionsKt.joinToString$default(CollectionsKt.listOf('k', 'o', 't', 'l', 'i', 'n'), "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);

    /* renamed from: b */
    private static final Map<String, String> f60705b;

    private ClassMapperLite() {
    }

    static {
        int i = 0;
        Map<String, String> linkedHashMap = new LinkedHashMap<>();
        List listOf = CollectionsKt.listOf("Boolean", "Z", "Char", "C", "Byte", "B", "Short", ExifInterface.LATITUDE_SOUTH, "Int", "I", "Float", "F", "Long", "J", "Double", "D");
        int progressionLastElement = ProgressionUtilKt.getProgressionLastElement(0, listOf.size() - 1, 2);
        if (progressionLastElement >= 0) {
            int i2 = 0;
            while (true) {
                int i3 = i2 + 2;
                int i4 = i2 + 1;
                linkedHashMap.put(f60704a + IOUtils.DIR_SEPARATOR_UNIX + ((String) listOf.get(i2)), listOf.get(i4));
                linkedHashMap.put(f60704a + IOUtils.DIR_SEPARATOR_UNIX + ((String) listOf.get(i2)) + "Array", Intrinsics.stringPlus(Const.jaLeft, listOf.get(i4)));
                if (i2 == progressionLastElement) {
                    break;
                }
                i2 = i3;
            }
        }
        linkedHashMap.put(Intrinsics.stringPlus(f60704a, "/Unit"), ExifInterface.GPS_MEASUREMENT_INTERRUPTED);
        m44763a(linkedHashMap, "Any", "java/lang/Object");
        m44763a(linkedHashMap, "Nothing", "java/lang/Void");
        m44763a(linkedHashMap, "Annotation", "java/lang/annotation/Annotation");
        for (String str : CollectionsKt.listOf("String", "CharSequence", "Throwable", "Cloneable", "Number", "Comparable", "Enum")) {
            m44763a(linkedHashMap, str, Intrinsics.stringPlus("java/lang/", str));
        }
        for (String str2 : CollectionsKt.listOf("Iterator", "Collection", "List", "Set", StringConstant.META_NAME, "ListIterator")) {
            m44763a(linkedHashMap, Intrinsics.stringPlus("collections/", str2), Intrinsics.stringPlus("java/util/", str2));
            m44763a(linkedHashMap, Intrinsics.stringPlus("collections/Mutable", str2), Intrinsics.stringPlus("java/util/", str2));
        }
        m44763a(linkedHashMap, "collections/Iterable", "java/lang/Iterable");
        m44763a(linkedHashMap, "collections/MutableIterable", "java/lang/Iterable");
        m44763a(linkedHashMap, "collections/Map.Entry", "java/util/Map$Entry");
        m44763a(linkedHashMap, "collections/MutableMap.MutableEntry", "java/util/Map$Entry");
        while (true) {
            int i5 = i + 1;
            String stringPlus = Intrinsics.stringPlus("Function", Integer.valueOf(i));
            m44763a(linkedHashMap, stringPlus, f60704a + "/jvm/functions/Function" + i);
            m44763a(linkedHashMap, Intrinsics.stringPlus("reflect/KFunction", Integer.valueOf(i)), Intrinsics.stringPlus(f60704a, "/reflect/KFunction"));
            if (i5 > 22) {
                break;
            }
            i = i5;
        }
        for (String str3 : CollectionsKt.listOf("Char", "Byte", "Short", "Int", "Float", "Long", "Double", "String", "Enum")) {
            String stringPlus2 = Intrinsics.stringPlus(str3, ".Companion");
            m44763a(linkedHashMap, stringPlus2, f60704a + "/jvm/internal/" + str3 + "CompanionObject");
        }
        f60705b = linkedHashMap;
    }

    /* renamed from: a */
    private static final void m44763a(Map<String, String> map, String str, String str2) {
        map.put(f60704a + IOUtils.DIR_SEPARATOR_UNIX + str, Matrix.MATRIX_TYPE_RANDOM_LT + str2 + ';');
    }

    @JvmStatic
    public static final String mapClass(String str) {
        Intrinsics.checkNotNullParameter(str, "classId");
        String str2 = f60705b.get(str);
        if (str2 != null) {
            return str2;
        }
        return Matrix.MATRIX_TYPE_RANDOM_LT + StringsKt.replace$default(str, '.', '$', false, 4, (Object) null) + ';';
    }
}
