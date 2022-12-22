package kotlin.reflect.jvm.internal.impl.load.java;

import com.google.firebase.remoteconfig.RemoteConfigConstants;
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
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* compiled from: BuiltinSpecialProperties.kt */
public final class BuiltinSpecialProperties {
    public static final BuiltinSpecialProperties INSTANCE = new BuiltinSpecialProperties();

    /* renamed from: a */
    private static final Map<FqName, Name> f60373a;

    /* renamed from: b */
    private static final Map<Name, List<Name>> f60374b;

    /* renamed from: c */
    private static final Set<FqName> f60375c;

    /* renamed from: d */
    private static final Set<Name> f60376d;

    private BuiltinSpecialProperties() {
    }

    public final Map<FqName, Name> getPROPERTY_FQ_NAME_TO_JVM_GETTER_NAME_MAP() {
        return f60373a;
    }

    static {
        Map<FqName, Name> mapOf = MapsKt.mapOf(TuplesKt.m42317to(BuiltinSpecialPropertiesKt.m44582a(StandardNames.FqNames._enum, "name"), Name.identifier("name")), TuplesKt.m42317to(BuiltinSpecialPropertiesKt.m44582a(StandardNames.FqNames._enum, "ordinal"), Name.identifier("ordinal")), TuplesKt.m42317to(BuiltinSpecialPropertiesKt.m44581a(StandardNames.FqNames.collection, "size"), Name.identifier("size")), TuplesKt.m42317to(BuiltinSpecialPropertiesKt.m44581a(StandardNames.FqNames.map, "size"), Name.identifier("size")), TuplesKt.m42317to(BuiltinSpecialPropertiesKt.m44582a(StandardNames.FqNames.charSequence, "length"), Name.identifier("length")), TuplesKt.m42317to(BuiltinSpecialPropertiesKt.m44581a(StandardNames.FqNames.map, "keys"), Name.identifier("keySet")), TuplesKt.m42317to(BuiltinSpecialPropertiesKt.m44581a(StandardNames.FqNames.map, "values"), Name.identifier("values")), TuplesKt.m42317to(BuiltinSpecialPropertiesKt.m44581a(StandardNames.FqNames.map, (String) RemoteConfigConstants.ResponseFieldKey.ENTRIES), Name.identifier("entrySet")));
        f60373a = mapOf;
        Iterable<Map.Entry> entrySet = mapOf.entrySet();
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(entrySet, 10));
        for (Map.Entry entry : entrySet) {
            arrayList.add(new Pair(((FqName) entry.getKey()).shortName(), entry.getValue()));
        }
        Map linkedHashMap = new LinkedHashMap();
        for (Pair pair : (List) arrayList) {
            Name name = (Name) pair.getSecond();
            Object obj = linkedHashMap.get(name);
            if (obj == null) {
                obj = new ArrayList();
                linkedHashMap.put(name, obj);
            }
            ((List) obj).add((Name) pair.getFirst());
        }
        Map<Name, List<Name>> linkedHashMap2 = new LinkedHashMap<>(MapsKt.mapCapacity(linkedHashMap.size()));
        for (Map.Entry entry2 : linkedHashMap.entrySet()) {
            linkedHashMap2.put(entry2.getKey(), CollectionsKt.distinct((Iterable) entry2.getValue()));
        }
        f60374b = linkedHashMap2;
        Set<FqName> keySet = f60373a.keySet();
        f60375c = keySet;
        Iterable<FqName> iterable = keySet;
        Collection arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (FqName shortName : iterable) {
            arrayList2.add(shortName.shortName());
        }
        f60376d = CollectionsKt.toSet((List) arrayList2);
    }

    public final Set<FqName> getSPECIAL_FQ_NAMES() {
        return f60375c;
    }

    public final Set<Name> getSPECIAL_SHORT_NAMES() {
        return f60376d;
    }

    public final List<Name> getPropertyNameCandidatesBySpecialGetterName(Name name) {
        Intrinsics.checkNotNullParameter(name, "name1");
        List<Name> list = f60374b.get(name);
        return list == null ? CollectionsKt.emptyList() : list;
    }
}
