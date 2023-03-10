package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.RangesKt;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaField;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* compiled from: LazyJavaClassMemberScope.kt */
final class LazyJavaClassMemberScope$enumEntryIndex$1 extends Lambda implements Function0<Map<Name, ? extends JavaField>> {
    final /* synthetic */ LazyJavaClassMemberScope this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LazyJavaClassMemberScope$enumEntryIndex$1(LazyJavaClassMemberScope lazyJavaClassMemberScope) {
        super(0);
        this.this$0 = lazyJavaClassMemberScope;
    }

    public final Map<Name, JavaField> invoke() {
        Collection arrayList = new ArrayList();
        for (Object next : this.this$0.f60540c.getFields()) {
            if (((JavaField) next).isEnumEntry()) {
                arrayList.add(next);
            }
        }
        Iterable iterable = (List) arrayList;
        Map<Name, JavaField> linkedHashMap = new LinkedHashMap<>(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(iterable, 10)), 16));
        for (Object next2 : iterable) {
            linkedHashMap.put(((JavaField) next2).getName(), next2);
        }
        return linkedHashMap;
    }
}
