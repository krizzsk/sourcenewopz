package kotlin.reflect.jvm.internal.impl.load.java;

import com.didi.map.constant.StringConstant;
import com.didi.payment.base.cons.WalletExtraConstant;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.kotlin.SignatureBuildingComponents;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;
import org.osgi.framework.VersionRange;

/* compiled from: SpecialGenericSignatures.kt */
public class SpecialGenericSignatures {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a */
    private static final List<Companion.NameAndSignature> f60420a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static final List<String> f60421b;

    /* renamed from: c */
    private static final List<String> f60422c;

    /* renamed from: d */
    private static final Map<Companion.NameAndSignature, TypeSafeBarrierDescription> f60423d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public static final Map<String, TypeSafeBarrierDescription> f60424e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public static final Set<Name> f60425f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public static final Set<String> f60426g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public static final Companion.NameAndSignature f60427h;

    /* renamed from: i */
    private static final Map<Companion.NameAndSignature, Name> f60428i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public static final Map<String, Name> f60429j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public static final List<Name> f60430k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public static final Map<Name, List<Name>> f60431l;

    /* compiled from: SpecialGenericSignatures.kt */
    public enum TypeSafeBarrierDescription {
        NULL((String) null),
        INDEX(-1),
        FALSE(false);
        
        private final Object defaultValue;

        private TypeSafeBarrierDescription(Object obj) {
            this.defaultValue = obj;
        }

        /* compiled from: SpecialGenericSignatures.kt */
        static final class MAP_GET_OR_DEFAULT extends TypeSafeBarrierDescription {
            MAP_GET_OR_DEFAULT(String str, int i) {
                super(str, i, (Object) null, (DefaultConstructorMarker) null);
            }
        }
    }

    /* compiled from: SpecialGenericSignatures.kt */
    public enum SpecialSignatureInfo {
        ONE_COLLECTION_PARAMETER("Ljava/util/Collection<+Ljava/lang/Object;>;", false),
        OBJECT_PARAMETER_NON_GENERIC((String) null, true),
        OBJECT_PARAMETER_GENERIC("Ljava/lang/Object;", true);
        
        private final boolean isObjectReplacedWithTypeParameter;
        private final String valueParametersSignature;

        private SpecialSignatureInfo(String str, boolean z) {
            this.valueParametersSignature = str;
            this.isObjectReplacedWithTypeParameter = z;
        }
    }

    /* compiled from: SpecialGenericSignatures.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final SpecialSignatureInfo getSpecialSignatureInfo(String str) {
            Intrinsics.checkNotNullParameter(str, "builtinSignature");
            if (getERASED_COLLECTION_PARAMETER_SIGNATURES().contains(str)) {
                return SpecialSignatureInfo.ONE_COLLECTION_PARAMETER;
            }
            if (((TypeSafeBarrierDescription) MapsKt.getValue(getSIGNATURE_TO_DEFAULT_VALUES_MAP(), str)) == TypeSafeBarrierDescription.NULL) {
                return SpecialSignatureInfo.OBJECT_PARAMETER_GENERIC;
            }
            return SpecialSignatureInfo.OBJECT_PARAMETER_NON_GENERIC;
        }

        /* compiled from: SpecialGenericSignatures.kt */
        public static final class NameAndSignature {
            private final Name name;
            private final String signature;

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof NameAndSignature)) {
                    return false;
                }
                NameAndSignature nameAndSignature = (NameAndSignature) obj;
                return Intrinsics.areEqual((Object) this.name, (Object) nameAndSignature.name) && Intrinsics.areEqual((Object) this.signature, (Object) nameAndSignature.signature);
            }

            public int hashCode() {
                return (this.name.hashCode() * 31) + this.signature.hashCode();
            }

            public String toString() {
                return "NameAndSignature(name=" + this.name + ", signature=" + this.signature + VersionRange.RIGHT_OPEN;
            }

            public NameAndSignature(Name name2, String str) {
                Intrinsics.checkNotNullParameter(name2, "name");
                Intrinsics.checkNotNullParameter(str, "signature");
                this.name = name2;
                this.signature = str;
            }

            public final Name getName() {
                return this.name;
            }

            public final String getSignature() {
                return this.signature;
            }
        }

        /* access modifiers changed from: private */
        public final NameAndSignature method(String str, String str2, String str3, String str4) {
            Name identifier = Name.identifier(str2);
            Intrinsics.checkNotNullExpressionValue(identifier, "identifier(name)");
            SignatureBuildingComponents signatureBuildingComponents = SignatureBuildingComponents.INSTANCE;
            return new NameAndSignature(identifier, signatureBuildingComponents.signature(str, str2 + VersionRange.LEFT_OPEN + str3 + VersionRange.RIGHT_OPEN + str4));
        }

        public final List<String> getERASED_COLLECTION_PARAMETER_SIGNATURES() {
            return SpecialGenericSignatures.f60421b;
        }

        public final Map<String, TypeSafeBarrierDescription> getSIGNATURE_TO_DEFAULT_VALUES_MAP() {
            return SpecialGenericSignatures.f60424e;
        }

        public final Set<Name> getERASED_VALUE_PARAMETERS_SHORT_NAMES() {
            return SpecialGenericSignatures.f60425f;
        }

        public final Set<String> getERASED_VALUE_PARAMETERS_SIGNATURES() {
            return SpecialGenericSignatures.f60426g;
        }

        public final NameAndSignature getREMOVE_AT_NAME_AND_SIGNATURE() {
            return SpecialGenericSignatures.f60427h;
        }

        public final Map<String, Name> getSIGNATURE_TO_JVM_REPRESENTATION_NAME() {
            return SpecialGenericSignatures.f60429j;
        }

        public final List<Name> getORIGINAL_SHORT_NAMES() {
            return SpecialGenericSignatures.f60430k;
        }

        public final Map<Name, List<Name>> getJVM_SHORT_NAME_TO_BUILTIN_SHORT_NAMES_MAP() {
            return SpecialGenericSignatures.f60431l;
        }

        public final List<Name> getBuiltinFunctionNamesByJvmName(Name name) {
            Intrinsics.checkNotNullParameter(name, "name");
            List<Name> list = getJVM_SHORT_NAME_TO_BUILTIN_SHORT_NAMES_MAP().get(name);
            return list == null ? CollectionsKt.emptyList() : list;
        }

        public final boolean getSameAsRenamedInJvmBuiltin(Name name) {
            Intrinsics.checkNotNullParameter(name, "<this>");
            return getORIGINAL_SHORT_NAMES().contains(name);
        }
    }

    static {
        Iterable<String> of = SetsKt.setOf("containsAll", "removeAll", "retainAll");
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(of, 10));
        for (String access$method : of) {
            Companion companion = Companion;
            String desc = JvmPrimitiveType.BOOLEAN.getDesc();
            Intrinsics.checkNotNullExpressionValue(desc, "BOOLEAN.desc");
            arrayList.add(companion.method("java/util/Collection", access$method, "Ljava/util/Collection;", desc));
        }
        List<Companion.NameAndSignature> list = (List) arrayList;
        f60420a = list;
        Iterable<Companion.NameAndSignature> iterable = list;
        Collection arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (Companion.NameAndSignature signature : iterable) {
            arrayList2.add(signature.getSignature());
        }
        f60421b = (List) arrayList2;
        Iterable<Companion.NameAndSignature> iterable2 = f60420a;
        Collection arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable2, 10));
        for (Companion.NameAndSignature name : iterable2) {
            arrayList3.add(name.getName().asString());
        }
        f60422c = (List) arrayList3;
        SignatureBuildingComponents signatureBuildingComponents = SignatureBuildingComponents.INSTANCE;
        Companion companion2 = Companion;
        String javaUtil = signatureBuildingComponents.javaUtil("Collection");
        String desc2 = JvmPrimitiveType.BOOLEAN.getDesc();
        Intrinsics.checkNotNullExpressionValue(desc2, "BOOLEAN.desc");
        Companion companion3 = Companion;
        String javaUtil2 = signatureBuildingComponents.javaUtil("Collection");
        String desc3 = JvmPrimitiveType.BOOLEAN.getDesc();
        Intrinsics.checkNotNullExpressionValue(desc3, "BOOLEAN.desc");
        Companion companion4 = Companion;
        String javaUtil3 = signatureBuildingComponents.javaUtil(StringConstant.META_NAME);
        String desc4 = JvmPrimitiveType.BOOLEAN.getDesc();
        Intrinsics.checkNotNullExpressionValue(desc4, "BOOLEAN.desc");
        Companion companion5 = Companion;
        String javaUtil4 = signatureBuildingComponents.javaUtil(StringConstant.META_NAME);
        String desc5 = JvmPrimitiveType.BOOLEAN.getDesc();
        Intrinsics.checkNotNullExpressionValue(desc5, "BOOLEAN.desc");
        Companion companion6 = Companion;
        String javaUtil5 = signatureBuildingComponents.javaUtil(StringConstant.META_NAME);
        String desc6 = JvmPrimitiveType.BOOLEAN.getDesc();
        Intrinsics.checkNotNullExpressionValue(desc6, "BOOLEAN.desc");
        Companion companion7 = Companion;
        String javaUtil6 = signatureBuildingComponents.javaUtil("List");
        String desc7 = JvmPrimitiveType.INT.getDesc();
        Intrinsics.checkNotNullExpressionValue(desc7, "INT.desc");
        Companion companion8 = Companion;
        String javaUtil7 = signatureBuildingComponents.javaUtil("List");
        String desc8 = JvmPrimitiveType.INT.getDesc();
        Intrinsics.checkNotNullExpressionValue(desc8, "INT.desc");
        Map<Companion.NameAndSignature, TypeSafeBarrierDescription> mapOf = MapsKt.mapOf(TuplesKt.m42317to(companion2.method(javaUtil, "contains", "Ljava/lang/Object;", desc2), TypeSafeBarrierDescription.FALSE), TuplesKt.m42317to(companion3.method(javaUtil2, WalletExtraConstant.Key.REMOVE, "Ljava/lang/Object;", desc3), TypeSafeBarrierDescription.FALSE), TuplesKt.m42317to(companion4.method(javaUtil3, "containsKey", "Ljava/lang/Object;", desc4), TypeSafeBarrierDescription.FALSE), TuplesKt.m42317to(companion5.method(javaUtil4, "containsValue", "Ljava/lang/Object;", desc5), TypeSafeBarrierDescription.FALSE), TuplesKt.m42317to(companion6.method(javaUtil5, WalletExtraConstant.Key.REMOVE, "Ljava/lang/Object;Ljava/lang/Object;", desc6), TypeSafeBarrierDescription.FALSE), TuplesKt.m42317to(Companion.method(signatureBuildingComponents.javaUtil(StringConstant.META_NAME), "getOrDefault", "Ljava/lang/Object;Ljava/lang/Object;", "Ljava/lang/Object;"), TypeSafeBarrierDescription.MAP_GET_OR_DEFAULT), TuplesKt.m42317to(Companion.method(signatureBuildingComponents.javaUtil(StringConstant.META_NAME), "get", "Ljava/lang/Object;", "Ljava/lang/Object;"), TypeSafeBarrierDescription.NULL), TuplesKt.m42317to(Companion.method(signatureBuildingComponents.javaUtil(StringConstant.META_NAME), WalletExtraConstant.Key.REMOVE, "Ljava/lang/Object;", "Ljava/lang/Object;"), TypeSafeBarrierDescription.NULL), TuplesKt.m42317to(companion7.method(javaUtil6, "indexOf", "Ljava/lang/Object;", desc7), TypeSafeBarrierDescription.INDEX), TuplesKt.m42317to(companion8.method(javaUtil7, "lastIndexOf", "Ljava/lang/Object;", desc8), TypeSafeBarrierDescription.INDEX));
        f60423d = mapOf;
        Map<String, TypeSafeBarrierDescription> linkedHashMap = new LinkedHashMap<>(MapsKt.mapCapacity(mapOf.size()));
        for (Map.Entry entry : mapOf.entrySet()) {
            linkedHashMap.put(((Companion.NameAndSignature) entry.getKey()).getSignature(), entry.getValue());
        }
        f60424e = linkedHashMap;
        Iterable<Companion.NameAndSignature> plus = SetsKt.plus(f60423d.keySet(), f60420a);
        Collection arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(plus, 10));
        for (Companion.NameAndSignature name2 : plus) {
            arrayList4.add(name2.getName());
        }
        f60425f = CollectionsKt.toSet((List) arrayList4);
        Collection arrayList5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(plus, 10));
        for (Companion.NameAndSignature signature2 : plus) {
            arrayList5.add(signature2.getSignature());
        }
        f60426g = CollectionsKt.toSet((List) arrayList5);
        Companion companion9 = Companion;
        String desc9 = JvmPrimitiveType.INT.getDesc();
        Intrinsics.checkNotNullExpressionValue(desc9, "INT.desc");
        f60427h = companion9.method("java/util/List", "removeAt", desc9, "Ljava/lang/Object;");
        SignatureBuildingComponents signatureBuildingComponents2 = SignatureBuildingComponents.INSTANCE;
        Companion companion10 = Companion;
        String javaLang = signatureBuildingComponents2.javaLang("Number");
        String desc10 = JvmPrimitiveType.BYTE.getDesc();
        Intrinsics.checkNotNullExpressionValue(desc10, "BYTE.desc");
        Companion companion11 = Companion;
        String javaLang2 = signatureBuildingComponents2.javaLang("Number");
        String desc11 = JvmPrimitiveType.SHORT.getDesc();
        Intrinsics.checkNotNullExpressionValue(desc11, "SHORT.desc");
        Companion companion12 = Companion;
        String javaLang3 = signatureBuildingComponents2.javaLang("Number");
        String desc12 = JvmPrimitiveType.INT.getDesc();
        Intrinsics.checkNotNullExpressionValue(desc12, "INT.desc");
        Companion companion13 = Companion;
        String javaLang4 = signatureBuildingComponents2.javaLang("Number");
        String desc13 = JvmPrimitiveType.LONG.getDesc();
        Intrinsics.checkNotNullExpressionValue(desc13, "LONG.desc");
        Companion companion14 = Companion;
        String javaLang5 = signatureBuildingComponents2.javaLang("Number");
        String desc14 = JvmPrimitiveType.FLOAT.getDesc();
        Intrinsics.checkNotNullExpressionValue(desc14, "FLOAT.desc");
        Companion companion15 = Companion;
        String javaLang6 = signatureBuildingComponents2.javaLang("Number");
        String desc15 = JvmPrimitiveType.DOUBLE.getDesc();
        Intrinsics.checkNotNullExpressionValue(desc15, "DOUBLE.desc");
        Companion companion16 = Companion;
        String javaLang7 = signatureBuildingComponents2.javaLang("CharSequence");
        String desc16 = JvmPrimitiveType.INT.getDesc();
        Intrinsics.checkNotNullExpressionValue(desc16, "INT.desc");
        String desc17 = JvmPrimitiveType.CHAR.getDesc();
        Intrinsics.checkNotNullExpressionValue(desc17, "CHAR.desc");
        Map<Companion.NameAndSignature, Name> mapOf2 = MapsKt.mapOf(TuplesKt.m42317to(companion10.method(javaLang, "toByte", "", desc10), Name.identifier("byteValue")), TuplesKt.m42317to(companion11.method(javaLang2, "toShort", "", desc11), Name.identifier("shortValue")), TuplesKt.m42317to(companion12.method(javaLang3, "toInt", "", desc12), Name.identifier("intValue")), TuplesKt.m42317to(companion13.method(javaLang4, "toLong", "", desc13), Name.identifier("longValue")), TuplesKt.m42317to(companion14.method(javaLang5, "toFloat", "", desc14), Name.identifier("floatValue")), TuplesKt.m42317to(companion15.method(javaLang6, "toDouble", "", desc15), Name.identifier("doubleValue")), TuplesKt.m42317to(f60427h, Name.identifier(WalletExtraConstant.Key.REMOVE)), TuplesKt.m42317to(companion16.method(javaLang7, "get", desc16, desc17), Name.identifier("charAt")));
        f60428i = mapOf2;
        Map<String, Name> linkedHashMap2 = new LinkedHashMap<>(MapsKt.mapCapacity(mapOf2.size()));
        for (Map.Entry entry2 : mapOf2.entrySet()) {
            linkedHashMap2.put(((Companion.NameAndSignature) entry2.getKey()).getSignature(), entry2.getValue());
        }
        f60429j = linkedHashMap2;
        Iterable<Companion.NameAndSignature> keySet = f60428i.keySet();
        Collection arrayList6 = new ArrayList(CollectionsKt.collectionSizeOrDefault(keySet, 10));
        for (Companion.NameAndSignature name3 : keySet) {
            arrayList6.add(name3.getName());
        }
        f60430k = (List) arrayList6;
        Iterable<Map.Entry> entrySet = f60428i.entrySet();
        Collection arrayList7 = new ArrayList(CollectionsKt.collectionSizeOrDefault(entrySet, 10));
        for (Map.Entry entry3 : entrySet) {
            arrayList7.add(new Pair(((Companion.NameAndSignature) entry3.getKey()).getName(), entry3.getValue()));
        }
        Map<Name, List<Name>> linkedHashMap3 = new LinkedHashMap<>();
        for (Pair pair : (List) arrayList7) {
            Name name4 = (Name) pair.getSecond();
            List<Name> list2 = linkedHashMap3.get(name4);
            if (list2 == null) {
                list2 = new ArrayList<>();
                linkedHashMap3.put(name4, list2);
            }
            list2.add((Name) pair.getFirst());
        }
        f60431l = linkedHashMap3;
    }
}
