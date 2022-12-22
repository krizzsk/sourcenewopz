package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.name.FqName;

/* compiled from: FakePureImplementationsProvider.kt */
public final class FakePureImplementationsProvider {
    public static final FakePureImplementationsProvider INSTANCE = new FakePureImplementationsProvider();

    /* renamed from: a */
    private static final HashMap<FqName, FqName> f60378a = new HashMap<>();

    private FakePureImplementationsProvider() {
    }

    public final FqName getPurelyImplementedInterface(FqName fqName) {
        Intrinsics.checkNotNullParameter(fqName, "classFqName");
        return f60378a.get(fqName);
    }

    static {
        INSTANCE.m44586a(StandardNames.FqNames.mutableList, INSTANCE.m44585a("java.util.ArrayList", "java.util.LinkedList"));
        INSTANCE.m44586a(StandardNames.FqNames.mutableSet, INSTANCE.m44585a("java.util.HashSet", "java.util.TreeSet", "java.util.LinkedHashSet"));
        INSTANCE.m44586a(StandardNames.FqNames.mutableMap, INSTANCE.m44585a("java.util.HashMap", "java.util.TreeMap", "java.util.LinkedHashMap", "java.util.concurrent.ConcurrentHashMap", "java.util.concurrent.ConcurrentSkipListMap"));
        INSTANCE.m44586a(new FqName("java.util.function.Function"), INSTANCE.m44585a("java.util.function.UnaryOperator"));
        INSTANCE.m44586a(new FqName("java.util.function.BiFunction"), INSTANCE.m44585a("java.util.function.BinaryOperator"));
    }

    /* renamed from: a */
    private final void m44586a(FqName fqName, List<FqName> list) {
        Map map = f60378a;
        for (Object next : list) {
            FqName fqName2 = (FqName) next;
            map.put(next, fqName);
        }
    }

    /* renamed from: a */
    private final List<FqName> m44585a(String... strArr) {
        Collection arrayList = new ArrayList(strArr.length);
        for (String fqName : strArr) {
            arrayList.add(new FqName(fqName));
        }
        return (List) arrayList;
    }
}
