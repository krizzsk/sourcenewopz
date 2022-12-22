package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.BinaryVersion;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.name.ClassId;

/* compiled from: ProtoBasedClassDataFinder.kt */
public final class ProtoBasedClassDataFinder implements ClassDataFinder {

    /* renamed from: a */
    private final NameResolver f61001a;

    /* renamed from: b */
    private final BinaryVersion f61002b;

    /* renamed from: c */
    private final Function1<ClassId, SourceElement> f61003c;

    /* renamed from: d */
    private final Map<ClassId, ProtoBuf.Class> f61004d;

    public ProtoBasedClassDataFinder(ProtoBuf.PackageFragment packageFragment, NameResolver nameResolver, BinaryVersion binaryVersion, Function1<? super ClassId, ? extends SourceElement> function1) {
        Intrinsics.checkNotNullParameter(packageFragment, "proto");
        Intrinsics.checkNotNullParameter(nameResolver, "nameResolver");
        Intrinsics.checkNotNullParameter(binaryVersion, "metadataVersion");
        Intrinsics.checkNotNullParameter(function1, "classSource");
        this.f61001a = nameResolver;
        this.f61002b = binaryVersion;
        this.f61003c = function1;
        List<ProtoBuf.Class> class_List = packageFragment.getClass_List();
        Intrinsics.checkNotNullExpressionValue(class_List, "proto.class_List");
        Iterable iterable = class_List;
        Map<ClassId, ProtoBuf.Class> linkedHashMap = new LinkedHashMap<>(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(iterable, 10)), 16));
        for (Object next : iterable) {
            linkedHashMap.put(NameResolverUtilKt.getClassId(this.f61001a, ((ProtoBuf.Class) next).getFqName()), next);
        }
        this.f61004d = linkedHashMap;
    }

    public final Collection<ClassId> getAllClassIds() {
        return this.f61004d.keySet();
    }

    public ClassData findClassData(ClassId classId) {
        Intrinsics.checkNotNullParameter(classId, "classId");
        ProtoBuf.Class classR = this.f61004d.get(classId);
        if (classR == null) {
            return null;
        }
        return new ClassData(this.f61001a, classR, this.f61002b, this.f61003c.invoke(classId));
    }
}
