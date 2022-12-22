package kshark;

import com.didichuxing.mlcp.drtc.consts.SDKConsts;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TypeCastException;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.C21490Reflection;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kshark.GcRoot;
import kshark.HeapObject;
import kshark.HprofRecord;
import kshark.internal.FieldValuesReader;
import kshark.internal.HprofInMemoryIndex;
import kshark.internal.IndexedObject;
import kshark.internal.LruCache;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000Þ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \\2\u00020\u0001:\u0001\\B\u0017\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0015\u00100\u001a\u0002012\u0006\u00102\u001a\u00020\tH\u0000¢\u0006\u0002\b3J\u0015\u00104\u001a\u0002052\u0006\u00106\u001a\u000207H\u0000¢\u0006\u0002\b8J\u001d\u00109\u001a\u0002012\u0006\u00102\u001a\u00020\t2\u0006\u0010:\u001a\u00020;H\u0000¢\u0006\u0002\b<J\u0012\u0010=\u001a\u0004\u0018\u00010\u00112\u0006\u00100\u001a\u000201H\u0016J\u0010\u0010>\u001a\u00020+2\u0006\u0010?\u001a\u00020\tH\u0016J\u0012\u0010@\u001a\u0004\u0018\u00010+2\u0006\u0010?\u001a\u00020\tH\u0016J\u0010\u0010A\u001a\u00020B2\u0006\u0010?\u001a\u00020\tH\u0016J\u001d\u0010C\u001a\u00020\n2\u0006\u0010?\u001a\u00020\t2\u0006\u0010D\u001a\u00020EH\u0000¢\u0006\u0002\bFJ\u001d\u0010G\u001a\u0002072\u0006\u0010?\u001a\u00020\t2\u0006\u0010D\u001a\u00020HH\u0000¢\u0006\u0002\bIJ\u001d\u0010J\u001a\u00020K2\u0006\u0010?\u001a\u00020\t2\u0006\u0010D\u001a\u00020LH\u0000¢\u0006\u0002\bMJ5\u0010N\u001a\u0002HO\"\b\b\u0000\u0010O*\u00020)2\u0006\u0010?\u001a\u00020\t2\u0006\u0010D\u001a\u00020P2\f\u0010Q\u001a\b\u0012\u0004\u0012\u0002HO0RH\u0002¢\u0006\u0002\u0010SJ\u001d\u0010T\u001a\u00020U2\u0006\u0010?\u001a\u00020\t2\u0006\u0010D\u001a\u00020VH\u0000¢\u0006\u0002\bWJ\u001d\u0010X\u001a\u0002012\u0006\u00102\u001a\u00020\t2\u0006\u0010:\u001a\u00020YH\u0000¢\u0006\u0002\bZJ\u0018\u0010[\u001a\u00020+2\u0006\u0010D\u001a\u00020P2\u0006\u0010?\u001a\u00020\tH\u0002R&\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108VX\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u0015X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00198VX\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001d\u001a\u00020\u001e8VX\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010!\u001a\b\u0012\u0004\u0012\u00020\"0\u00108VX\u0004¢\u0006\u0006\u001a\u0004\b#\u0010\u0013R\u001a\u0010$\u001a\b\u0012\u0004\u0012\u00020%0\u00108VX\u0004¢\u0006\u0006\u001a\u0004\b&\u0010\u0013R\u001a\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020)0(X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010*\u001a\b\u0012\u0004\u0012\u00020+0\u00108VX\u0004¢\u0006\u0006\u001a\u0004\b,\u0010\u0013R\u001a\u0010-\u001a\b\u0012\u0004\u0012\u00020.0\u00108VX\u0004¢\u0006\u0006\u001a\u0004\b/\u0010\u0013¨\u0006]"}, mo175978d2 = {"Lkshark/HprofHeapGraph;", "Lkshark/HeapGraph;", "hprof", "Lkshark/Hprof;", "index", "Lkshark/internal/HprofInMemoryIndex;", "(Lkshark/Hprof;Lkshark/internal/HprofInMemoryIndex;)V", "classMap", "", "", "Lkshark/HprofRecord$HeapDumpRecord$ObjectRecord$ClassDumpRecord;", "getClassMap", "()Ljava/util/Map;", "setClassMap", "(Ljava/util/Map;)V", "classes", "Lkotlin/sequences/Sequence;", "Lkshark/HeapObject$HeapClass;", "getClasses", "()Lkotlin/sequences/Sequence;", "context", "Lkshark/GraphContext;", "getContext", "()Lkshark/GraphContext;", "gcRoots", "", "Lkshark/GcRoot;", "getGcRoots", "()Ljava/util/List;", "identifierByteSize", "", "getIdentifierByteSize", "()I", "instances", "Lkshark/HeapObject$HeapInstance;", "getInstances", "objectArrays", "Lkshark/HeapObject$HeapObjectArray;", "getObjectArrays", "objectCache", "Lkshark/internal/LruCache;", "Lkshark/HprofRecord$HeapDumpRecord$ObjectRecord;", "objects", "Lkshark/HeapObject;", "getObjects", "primitiveArrays", "Lkshark/HeapObject$HeapPrimitiveArray;", "getPrimitiveArrays", "className", "", "classId", "className$shark", "createFieldValuesReader", "Lkshark/internal/FieldValuesReader;", "record", "Lkshark/HprofRecord$HeapDumpRecord$ObjectRecord$InstanceDumpRecord;", "createFieldValuesReader$shark", "fieldName", "fieldRecord", "Lkshark/HprofRecord$HeapDumpRecord$ObjectRecord$ClassDumpRecord$FieldRecord;", "fieldName$shark", "findClassByName", "findObjectById", "objectId", "findObjectByIdOrNull", "objectExists", "", "readClassDumpRecord", "indexedObject", "Lkshark/internal/IndexedObject$IndexedClass;", "readClassDumpRecord$shark", "readInstanceDumpRecord", "Lkshark/internal/IndexedObject$IndexedInstance;", "readInstanceDumpRecord$shark", "readObjectArrayDumpRecord", "Lkshark/HprofRecord$HeapDumpRecord$ObjectRecord$ObjectArrayDumpRecord;", "Lkshark/internal/IndexedObject$IndexedObjectArray;", "readObjectArrayDumpRecord$shark", "readObjectRecord", "T", "Lkshark/internal/IndexedObject;", "readBlock", "Lkotlin/Function0;", "(JLkshark/internal/IndexedObject;Lkotlin/jvm/functions/Function0;)Lkshark/HprofRecord$HeapDumpRecord$ObjectRecord;", "readPrimitiveArrayDumpRecord", "Lkshark/HprofRecord$HeapDumpRecord$ObjectRecord$PrimitiveArrayDumpRecord;", "Lkshark/internal/IndexedObject$IndexedPrimitiveArray;", "readPrimitiveArrayDumpRecord$shark", "staticFieldName", "Lkshark/HprofRecord$HeapDumpRecord$ObjectRecord$ClassDumpRecord$StaticFieldRecord;", "staticFieldName$shark", "wrapIndexedObject", "Companion", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
/* compiled from: HprofHeapGraph.kt */
public final class HprofHeapGraph implements HeapGraph {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a */
    private final GraphContext f4548a = new GraphContext();

    /* renamed from: b */
    private final LruCache<Long, HprofRecord.HeapDumpRecord.ObjectRecord> f4549b = new LruCache<>(3000);

    /* renamed from: c */
    private Map<Long, HprofRecord.HeapDumpRecord.ObjectRecord.ClassDumpRecord> f4550c = new LinkedHashMap();
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final Hprof f4551d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public final HprofInMemoryIndex f4552e;

    public HprofHeapGraph(Hprof hprof, HprofInMemoryIndex hprofInMemoryIndex) {
        Intrinsics.checkParameterIsNotNull(hprof, "hprof");
        Intrinsics.checkParameterIsNotNull(hprofInMemoryIndex, "index");
        this.f4551d = hprof;
        this.f4552e = hprofInMemoryIndex;
    }

    public int getIdentifierByteSize() {
        return this.f4551d.getReader().getIdentifierByteSize();
    }

    public GraphContext getContext() {
        return this.f4548a;
    }

    public List<GcRoot> getGcRoots() {
        return this.f4552e.gcRoots();
    }

    public Sequence<HeapObject> getObjects() {
        return SequencesKt.map(this.f4552e.indexedObjectSequence(), new HprofHeapGraph$objects$1(this));
    }

    public Sequence<HeapObject.HeapClass> getClasses() {
        return SequencesKt.map(this.f4552e.indexedClassSequence(), new HprofHeapGraph$classes$1(this));
    }

    public Sequence<HeapObject.HeapInstance> getInstances() {
        return SequencesKt.map(this.f4552e.indexedInstanceSequence(), new HprofHeapGraph$instances$1(this));
    }

    public Sequence<HeapObject.HeapObjectArray> getObjectArrays() {
        return SequencesKt.map(this.f4552e.indexedObjectArraySequence(), new HprofHeapGraph$objectArrays$1(this));
    }

    public Sequence<HeapObject.HeapPrimitiveArray> getPrimitiveArrays() {
        return SequencesKt.map(this.f4552e.indexedPrimitiveArraySequence(), new HprofHeapGraph$primitiveArrays$1(this));
    }

    public HeapObject findObjectById(long j) {
        HeapObject findObjectByIdOrNull = findObjectByIdOrNull(j);
        if (findObjectByIdOrNull != null) {
            return findObjectByIdOrNull;
        }
        throw new IllegalArgumentException("Object id " + j + " not found in heap dump.");
    }

    public HeapObject findObjectByIdOrNull(long j) {
        IndexedObject indexedObjectOrNull = this.f4552e.indexedObjectOrNull(j);
        if (indexedObjectOrNull != null) {
            return m2910a(indexedObjectOrNull, j);
        }
        return null;
    }

    public HeapObject.HeapClass findClassByName(String str) {
        Intrinsics.checkParameterIsNotNull(str, "className");
        Long classId = this.f4552e.classId(str);
        if (classId == null) {
            return null;
        }
        HeapObject findObjectById = findObjectById(classId.longValue());
        if (findObjectById != null) {
            return (HeapObject.HeapClass) findObjectById;
        }
        throw new TypeCastException("null cannot be cast to non-null type kshark.HeapObject.HeapClass");
    }

    public boolean objectExists(long j) {
        return this.f4552e.objectIdIsIndexed(j);
    }

    public final String fieldName$shark(long j, HprofRecord.HeapDumpRecord.ObjectRecord.ClassDumpRecord.FieldRecord fieldRecord) {
        Intrinsics.checkParameterIsNotNull(fieldRecord, "fieldRecord");
        return this.f4552e.fieldName(j, fieldRecord.getNameStringId());
    }

    public final String staticFieldName$shark(long j, HprofRecord.HeapDumpRecord.ObjectRecord.ClassDumpRecord.StaticFieldRecord staticFieldRecord) {
        Intrinsics.checkParameterIsNotNull(staticFieldRecord, "fieldRecord");
        return this.f4552e.fieldName(j, staticFieldRecord.getNameStringId());
    }

    public final FieldValuesReader createFieldValuesReader$shark(HprofRecord.HeapDumpRecord.ObjectRecord.InstanceDumpRecord instanceDumpRecord) {
        Intrinsics.checkParameterIsNotNull(instanceDumpRecord, SDKConsts.TAG_KEY_RECORD);
        return new FieldValuesReader(instanceDumpRecord, getIdentifierByteSize());
    }

    public final String className$shark(long j) {
        return this.f4552e.className(j);
    }

    public final HprofRecord.HeapDumpRecord.ObjectRecord.ObjectArrayDumpRecord readObjectArrayDumpRecord$shark(long j, IndexedObject.IndexedObjectArray indexedObjectArray) {
        Intrinsics.checkParameterIsNotNull(indexedObjectArray, "indexedObject");
        return (HprofRecord.HeapDumpRecord.ObjectRecord.ObjectArrayDumpRecord) m2911a(j, indexedObjectArray, new HprofHeapGraph$readObjectArrayDumpRecord$1(this));
    }

    public final HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord readPrimitiveArrayDumpRecord$shark(long j, IndexedObject.IndexedPrimitiveArray indexedPrimitiveArray) {
        Intrinsics.checkParameterIsNotNull(indexedPrimitiveArray, "indexedObject");
        return (HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord) m2911a(j, indexedPrimitiveArray, new HprofHeapGraph$readPrimitiveArrayDumpRecord$1(this));
    }

    public final Map<Long, HprofRecord.HeapDumpRecord.ObjectRecord.ClassDumpRecord> getClassMap() {
        return this.f4550c;
    }

    public final void setClassMap(Map<Long, HprofRecord.HeapDumpRecord.ObjectRecord.ClassDumpRecord> map) {
        Intrinsics.checkParameterIsNotNull(map, "<set-?>");
        this.f4550c = map;
    }

    public final HprofRecord.HeapDumpRecord.ObjectRecord.ClassDumpRecord readClassDumpRecord$shark(long j, IndexedObject.IndexedClass indexedClass) {
        Intrinsics.checkParameterIsNotNull(indexedClass, "indexedObject");
        HprofRecord.HeapDumpRecord.ObjectRecord.ClassDumpRecord classDumpRecord = this.f4550c.get(Long.valueOf(j));
        if (classDumpRecord != null) {
            return classDumpRecord;
        }
        HprofRecord.HeapDumpRecord.ObjectRecord.ClassDumpRecord classDumpRecord2 = (HprofRecord.HeapDumpRecord.ObjectRecord.ClassDumpRecord) m2911a(j, indexedClass, new HprofHeapGraph$readClassDumpRecord$1(this));
        this.f4550c.put(Long.valueOf(j), classDumpRecord2);
        return classDumpRecord2;
    }

    public final HprofRecord.HeapDumpRecord.ObjectRecord.InstanceDumpRecord readInstanceDumpRecord$shark(long j, IndexedObject.IndexedInstance indexedInstance) {
        Intrinsics.checkParameterIsNotNull(indexedInstance, "indexedObject");
        return (HprofRecord.HeapDumpRecord.ObjectRecord.InstanceDumpRecord) m2911a(j, indexedInstance, new HprofHeapGraph$readInstanceDumpRecord$1(this));
    }

    /* renamed from: a */
    private final <T extends HprofRecord.HeapDumpRecord.ObjectRecord> T m2911a(long j, IndexedObject indexedObject, Function0<? extends T> function0) {
        T t = (HprofRecord.HeapDumpRecord.ObjectRecord) this.f4549b.get(Long.valueOf(j));
        if (t != null) {
            return t;
        }
        this.f4551d.moveReaderTo(indexedObject.getPosition());
        T t2 = (HprofRecord.HeapDumpRecord.ObjectRecord) function0.invoke();
        this.f4549b.put(Long.valueOf(j), t2);
        return t2;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final HeapObject m2910a(IndexedObject indexedObject, long j) {
        if (indexedObject instanceof IndexedObject.IndexedClass) {
            return new HeapObject.HeapClass(this, (IndexedObject.IndexedClass) indexedObject, j);
        }
        if (indexedObject instanceof IndexedObject.IndexedInstance) {
            IndexedObject.IndexedInstance indexedInstance = (IndexedObject.IndexedInstance) indexedObject;
            return new HeapObject.HeapInstance(this, indexedInstance, j, this.f4552e.getPrimitiveWrapperTypes().contains(Long.valueOf(indexedInstance.getClassId())));
        } else if (indexedObject instanceof IndexedObject.IndexedObjectArray) {
            IndexedObject.IndexedObjectArray indexedObjectArray = (IndexedObject.IndexedObjectArray) indexedObject;
            return new HeapObject.HeapObjectArray(this, indexedObjectArray, j, this.f4552e.getPrimitiveWrapperTypes().contains(Long.valueOf(indexedObjectArray.getArrayClassId())));
        } else if (indexedObject instanceof IndexedObject.IndexedPrimitiveArray) {
            return new HeapObject.HeapPrimitiveArray(this, (IndexedObject.IndexedPrimitiveArray) indexedObject, j);
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J2\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0016\b\u0002\u0010\t\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\f0\u000b0\n¨\u0006\r"}, mo175978d2 = {"Lkshark/HprofHeapGraph$Companion;", "", "()V", "indexHprof", "Lkshark/HeapGraph;", "hprof", "Lkshark/Hprof;", "proguardMapping", "Lkshark/ProguardMapping;", "indexedGcRootTypes", "", "Lkotlin/reflect/KClass;", "Lkshark/GcRoot;", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
    /* compiled from: HprofHeapGraph.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ HeapGraph indexHprof$default(Companion companion, Hprof hprof, ProguardMapping proguardMapping, Set set, int i, Object obj) {
            if ((i & 2) != 0) {
                proguardMapping = null;
            }
            if ((i & 4) != 0) {
                set = SetsKt.setOf(C21490Reflection.getOrCreateKotlinClass(GcRoot.JniGlobal.class), C21490Reflection.getOrCreateKotlinClass(GcRoot.JavaFrame.class), C21490Reflection.getOrCreateKotlinClass(GcRoot.JniLocal.class), C21490Reflection.getOrCreateKotlinClass(GcRoot.MonitorUsed.class), C21490Reflection.getOrCreateKotlinClass(GcRoot.NativeStack.class), C21490Reflection.getOrCreateKotlinClass(GcRoot.StickyClass.class), C21490Reflection.getOrCreateKotlinClass(GcRoot.ThreadBlock.class), C21490Reflection.getOrCreateKotlinClass(GcRoot.ThreadObject.class), C21490Reflection.getOrCreateKotlinClass(GcRoot.JniMonitor.class));
            }
            return companion.indexHprof(hprof, proguardMapping, set);
        }

        public final HeapGraph indexHprof(Hprof hprof, ProguardMapping proguardMapping, Set<? extends KClass<? extends GcRoot>> set) {
            Intrinsics.checkParameterIsNotNull(hprof, "hprof");
            Intrinsics.checkParameterIsNotNull(set, "indexedGcRootTypes");
            return new HprofHeapGraph(hprof, HprofInMemoryIndex.Companion.createReadingHprof(hprof, proguardMapping, set));
        }
    }
}
