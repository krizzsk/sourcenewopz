package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaField;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMember;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMethod;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaRecordComponent;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

/* compiled from: DeclaredMemberIndex.kt */
public class ClassDeclaredMemberIndex implements DeclaredMemberIndex {

    /* renamed from: a */
    private final JavaClass f60502a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final Function1<JavaMember, Boolean> f60503b;

    /* renamed from: c */
    private final Function1<JavaMethod, Boolean> f60504c = new ClassDeclaredMemberIndex$methodFilter$1(this);

    /* renamed from: d */
    private final Map<Name, List<JavaMethod>> f60505d;

    /* renamed from: e */
    private final Map<Name, JavaField> f60506e;

    /* renamed from: f */
    private final Map<Name, JavaRecordComponent> f60507f;

    public ClassDeclaredMemberIndex(JavaClass javaClass, Function1<? super JavaMember, Boolean> function1) {
        Intrinsics.checkNotNullParameter(javaClass, "jClass");
        Intrinsics.checkNotNullParameter(function1, "memberFilter");
        this.f60502a = javaClass;
        this.f60503b = function1;
        Sequence<T> filter = SequencesKt.filter(CollectionsKt.asSequence(this.f60502a.getMethods()), this.f60504c);
        Map<Name, List<JavaMethod>> linkedHashMap = new LinkedHashMap<>();
        for (T next : filter) {
            Name name = ((JavaMethod) next).getName();
            List<JavaMethod> list = linkedHashMap.get(name);
            if (list == null) {
                list = new ArrayList<>();
                linkedHashMap.put(name, list);
            }
            list.add(next);
        }
        this.f60505d = linkedHashMap;
        Sequence<T> filter2 = SequencesKt.filter(CollectionsKt.asSequence(this.f60502a.getFields()), this.f60503b);
        Map<Name, JavaField> linkedHashMap2 = new LinkedHashMap<>();
        for (T next2 : filter2) {
            linkedHashMap2.put(((JavaField) next2).getName(), next2);
        }
        this.f60506e = linkedHashMap2;
        Function1<JavaMember, Boolean> function12 = this.f60503b;
        Collection arrayList = new ArrayList();
        for (Object next3 : this.f60502a.getRecordComponents()) {
            if (function12.invoke(next3).booleanValue()) {
                arrayList.add(next3);
            }
        }
        Iterable iterable = (List) arrayList;
        Map<Name, JavaRecordComponent> linkedHashMap3 = new LinkedHashMap<>(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(iterable, 10)), 16));
        for (Object next4 : iterable) {
            linkedHashMap3.put(((JavaRecordComponent) next4).getName(), next4);
        }
        this.f60507f = linkedHashMap3;
    }

    public Collection<JavaMethod> findMethodsByName(Name name) {
        Intrinsics.checkNotNullParameter(name, "name");
        List list = this.f60505d.get(name);
        if (list == null) {
            list = CollectionsKt.emptyList();
        }
        return list;
    }

    public Set<Name> getMethodNames() {
        Sequence<T> filter = SequencesKt.filter(CollectionsKt.asSequence(this.f60502a.getMethods()), this.f60504c);
        Collection linkedHashSet = new LinkedHashSet();
        for (T name : filter) {
            linkedHashSet.add(name.getName());
        }
        return (Set) linkedHashSet;
    }

    public JavaField findFieldByName(Name name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return this.f60506e.get(name);
    }

    public Set<Name> getFieldNames() {
        Sequence<T> filter = SequencesKt.filter(CollectionsKt.asSequence(this.f60502a.getFields()), this.f60503b);
        Collection linkedHashSet = new LinkedHashSet();
        for (T name : filter) {
            linkedHashSet.add(name.getName());
        }
        return (Set) linkedHashSet;
    }

    public Set<Name> getRecordComponentNames() {
        return this.f60507f.keySet();
    }

    public JavaRecordComponent findRecordComponentByName(Name name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return this.f60507f.get(name);
    }
}
