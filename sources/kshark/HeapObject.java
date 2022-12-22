package kshark;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TuplesKt;
import kotlin.TypeCastException;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.C21490Reflection;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.reflect.KClass;
import kotlin.reflect.KProperty;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import kshark.HprofRecord;
import kshark.internal.IndexedObject;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b6\u0018\u0000 \u001d2\u00020\u0001:\u0005\u001d\u001e\u001f !B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u001b\u001a\u00020\u001cH&R\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u00048F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b8F¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f8F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u00108F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0012\u0010\u0013\u001a\u00020\u0014X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0012\u0010\u0017\u001a\u00020\u0018X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001a\u0001\u0004\u0004\b\f\u0010¨\u0006\""}, mo175978d2 = {"Lkshark/HeapObject;", "", "()V", "asClass", "Lkshark/HeapObject$HeapClass;", "getAsClass", "()Lkshark/HeapObject$HeapClass;", "asInstance", "Lkshark/HeapObject$HeapInstance;", "getAsInstance", "()Lkshark/HeapObject$HeapInstance;", "asObjectArray", "Lkshark/HeapObject$HeapObjectArray;", "getAsObjectArray", "()Lkshark/HeapObject$HeapObjectArray;", "asPrimitiveArray", "Lkshark/HeapObject$HeapPrimitiveArray;", "getAsPrimitiveArray", "()Lkshark/HeapObject$HeapPrimitiveArray;", "graph", "Lkshark/HeapGraph;", "getGraph", "()Lkshark/HeapGraph;", "objectId", "", "getObjectId", "()J", "readRecord", "Lkshark/HprofRecord$HeapDumpRecord$ObjectRecord;", "Companion", "HeapClass", "HeapInstance", "HeapObjectArray", "HeapPrimitiveArray", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
/* compiled from: HeapObject.kt */
public abstract class HeapObject {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final Map<String, PrimitiveType> primitiveArrayClassesByName;

    public abstract HeapGraph getGraph();

    public abstract long getObjectId();

    public abstract HprofRecord.HeapDumpRecord.ObjectRecord readRecord();

    private HeapObject() {
    }

    public /* synthetic */ HeapObject(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public final HeapClass getAsClass() {
        if (this instanceof HeapClass) {
            return (HeapClass) this;
        }
        return null;
    }

    public final HeapInstance getAsInstance() {
        if (this instanceof HeapInstance) {
            return (HeapInstance) this;
        }
        return null;
    }

    public final HeapObjectArray getAsObjectArray() {
        if (this instanceof HeapObjectArray) {
            return (HeapObjectArray) this;
        }
        return null;
    }

    public final HeapPrimitiveArray getAsPrimitiveArray() {
        if (this instanceof HeapPrimitiveArray) {
            return (HeapPrimitiveArray) this;
        }
        return null;
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0013\u00105\u001a\u0004\u0018\u0001062\u0006\u00107\u001a\u00020#H\u0002J\u0006\u00108\u001a\u00020\u0016J\b\u00109\u001a\u00020:H\u0016J\u0010\u0010;\u001a\u0004\u0018\u0001062\u0006\u00107\u001a\u00020#J\f\u0010<\u001a\b\u0012\u0004\u0012\u0002060\nJ\u0011\u0010=\u001a\u00020\u001e2\u0006\u00102\u001a\u00020\u0000H\u0004J\u0011\u0010>\u001a\u00020\u001e2\u0006\u0010?\u001a\u00020\u0000H\u0004J\b\u0010@\u001a\u00020#H\u0016R\u0016\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00000\n8F¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\n8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\rR\u0014\u0010\u0011\u001a\u00020\u00128VX\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0015\u001a\u00020\u00168F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u000f0\n8F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\rR\u0011\u0010\u001b\u001a\u00020\u00168F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u0018R\u0011\u0010\u001d\u001a\u00020\u001e8F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001fR\u0011\u0010 \u001a\u00020\u001e8F¢\u0006\u0006\u001a\u0004\b \u0010\u001fR\u0011\u0010!\u001a\u00020\u001e8F¢\u0006\u0006\u001a\u0004\b!\u0010\u001fR\u0011\u0010\"\u001a\u00020#8F¢\u0006\u0006\u001a\u0004\b$\u0010%R\u0017\u0010&\u001a\b\u0012\u0004\u0012\u00020'0\n8F¢\u0006\u0006\u001a\u0004\b(\u0010\rR\u0014\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0017\u0010+\u001a\b\u0012\u0004\u0012\u00020,0\n8F¢\u0006\u0006\u001a\u0004\b-\u0010\rR\u0011\u0010.\u001a\u00020#8F¢\u0006\u0006\u001a\u0004\b/\u0010%R\u0017\u00100\u001a\b\u0012\u0004\u0012\u00020\u00000\n8F¢\u0006\u0006\u001a\u0004\b1\u0010\rR\u0013\u00102\u001a\u0004\u0018\u00010\u00008F¢\u0006\u0006\u001a\u0004\b3\u00104¨\u0006A"}, mo175978d2 = {"Lkshark/HeapObject$HeapClass;", "Lkshark/HeapObject;", "hprofGraph", "Lkshark/HprofHeapGraph;", "indexedObject", "Lkshark/internal/IndexedObject$IndexedClass;", "objectId", "", "(Lkshark/HprofHeapGraph;Lkshark/internal/IndexedObject$IndexedClass;J)V", "_classHierarchy", "Lkotlin/sequences/Sequence;", "classHierarchy", "getClassHierarchy", "()Lkotlin/sequences/Sequence;", "directInstances", "Lkshark/HeapObject$HeapInstance;", "getDirectInstances", "graph", "Lkshark/HeapGraph;", "getGraph", "()Lkshark/HeapGraph;", "instanceByteSize", "", "getInstanceByteSize", "()I", "instances", "getInstances", "instancesCount", "getInstancesCount", "isArrayClass", "", "()Z", "isObjectArrayClass", "isPrimitiveArrayClass", "name", "", "getName", "()Ljava/lang/String;", "objectArrayInstances", "Lkshark/HeapObject$HeapObjectArray;", "getObjectArrayInstances", "getObjectId", "()J", "primitiveArrayInstances", "Lkshark/HeapObject$HeapPrimitiveArray;", "getPrimitiveArrayInstances", "simpleName", "getSimpleName", "subclasses", "getSubclasses", "superclass", "getSuperclass", "()Lkshark/HeapObject$HeapClass;", "get", "Lkshark/HeapField;", "fieldName", "readFieldsByteSize", "readRecord", "Lkshark/HprofRecord$HeapDumpRecord$ObjectRecord$ClassDumpRecord;", "readStaticField", "readStaticFields", "subclassOf", "superclassOf", "subclass", "toString", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
    /* compiled from: HeapObject.kt */
    public static final class HeapClass extends HeapObject {
        private Sequence<HeapClass> _classHierarchy;
        /* access modifiers changed from: private */
        public final HprofHeapGraph hprofGraph;
        private final IndexedObject.IndexedClass indexedObject;
        private final long objectId;

        public long getObjectId() {
            return this.objectId;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public HeapClass(HprofHeapGraph hprofHeapGraph, IndexedObject.IndexedClass indexedClass, long j) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkParameterIsNotNull(hprofHeapGraph, "hprofGraph");
            Intrinsics.checkParameterIsNotNull(indexedClass, "indexedObject");
            this.hprofGraph = hprofHeapGraph;
            this.indexedObject = indexedClass;
            this.objectId = j;
        }

        public HeapGraph getGraph() {
            return this.hprofGraph;
        }

        public final String getName() {
            return this.hprofGraph.className$shark(getObjectId());
        }

        public final String getSimpleName() {
            return HeapObject.Companion.classSimpleName(getName());
        }

        public final int getInstanceByteSize() {
            return this.indexedObject.getInstanceSize();
        }

        public final boolean isArrayClass() {
            return StringsKt.endsWith$default(getName(), "[]", false, 2, (Object) null);
        }

        public final boolean isPrimitiveArrayClass() {
            return HeapObject.primitiveArrayClassesByName.containsKey(getName());
        }

        public final boolean isObjectArrayClass() {
            return isArrayClass() && !isPrimitiveArrayClass();
        }

        public final int readFieldsByteSize() {
            int i;
            int i2 = 0;
            for (HprofRecord.HeapDumpRecord.ObjectRecord.ClassDumpRecord.FieldRecord fieldRecord : readRecord().getFields()) {
                if (fieldRecord.getType() == 2) {
                    i = this.hprofGraph.getIdentifierByteSize();
                } else {
                    i = ((Number) MapsKt.getValue(PrimitiveType.Companion.getByteSizeByHprofType(), Integer.valueOf(fieldRecord.getType()))).intValue();
                }
                i2 += i;
            }
            return i2;
        }

        public final HeapClass getSuperclass() {
            if (this.indexedObject.getSuperclassId() == 0) {
                return null;
            }
            HeapObject findObjectById = this.hprofGraph.findObjectById(this.indexedObject.getSuperclassId());
            if (findObjectById != null) {
                return (HeapClass) findObjectById;
            }
            throw new TypeCastException("null cannot be cast to non-null type kshark.HeapObject.HeapClass");
        }

        public final Sequence<HeapClass> getClassHierarchy() {
            if (this._classHierarchy == null) {
                this._classHierarchy = SequencesKt.generateSequence(this, HeapObject$HeapClass$classHierarchy$1.INSTANCE);
            }
            Sequence<HeapClass> sequence = this._classHierarchy;
            if (sequence == null) {
                Intrinsics.throwNpe();
            }
            return sequence;
        }

        public final Sequence<HeapClass> getSubclasses() {
            return SequencesKt.filter(this.hprofGraph.getClasses(), new HeapObject$HeapClass$subclasses$1(this));
        }

        public final boolean superclassOf(HeapClass heapClass) {
            boolean z;
            Intrinsics.checkParameterIsNotNull(heapClass, "subclass");
            Iterator<HeapClass> it = heapClass.getClassHierarchy().iterator();
            do {
                z = false;
                if (!it.hasNext()) {
                    return false;
                }
                if (it.next().getObjectId() == getObjectId()) {
                    z = true;
                    continue;
                }
            } while (!z);
            return true;
        }

        public final boolean subclassOf(HeapClass heapClass) {
            boolean z;
            Intrinsics.checkParameterIsNotNull(heapClass, "superclass");
            Iterator<HeapClass> it = getClassHierarchy().iterator();
            do {
                z = false;
                if (!it.hasNext()) {
                    return false;
                }
                if (it.next().getObjectId() == heapClass.getObjectId()) {
                    z = true;
                    continue;
                }
            } while (!z);
            return true;
        }

        public final Sequence<HeapInstance> getInstances() {
            if (!isArrayClass()) {
                return SequencesKt.filter(this.hprofGraph.getInstances(), new HeapObject$HeapClass$instances$1(this));
            }
            return SequencesKt.emptySequence();
        }

        public final int getInstancesCount() {
            if (!isArrayClass()) {
                return SequencesKt.count(SequencesKt.filter(this.hprofGraph.getInstances(), new HeapObject$HeapClass$instancesCount$1(this)));
            }
            return 0;
        }

        public final Sequence<HeapObjectArray> getObjectArrayInstances() {
            if (isObjectArrayClass()) {
                return SequencesKt.filter(this.hprofGraph.getObjectArrays(), new HeapObject$HeapClass$objectArrayInstances$1(this));
            }
            return SequencesKt.emptySequence();
        }

        public final Sequence<HeapPrimitiveArray> getPrimitiveArrayInstances() {
            if (isPrimitiveArrayClass()) {
                return SequencesKt.filter(this.hprofGraph.getPrimitiveArrays(), new HeapObject$HeapClass$primitiveArrayInstances$1((PrimitiveType) HeapObject.primitiveArrayClassesByName.get(getName())));
            }
            return SequencesKt.emptySequence();
        }

        public final Sequence<HeapInstance> getDirectInstances() {
            return SequencesKt.filter(this.hprofGraph.getInstances(), new HeapObject$HeapClass$directInstances$1(this));
        }

        public HprofRecord.HeapDumpRecord.ObjectRecord.ClassDumpRecord readRecord() {
            return this.hprofGraph.readClassDumpRecord$shark(getObjectId(), this.indexedObject);
        }

        public final Sequence<HeapField> readStaticFields() {
            return SequencesKt.map(CollectionsKt.asSequence(readRecord().getStaticFields()), new HeapObject$HeapClass$readStaticFields$1(this));
        }

        public final HeapField readStaticField(String str) {
            Intrinsics.checkParameterIsNotNull(str, "fieldName");
            for (HprofRecord.HeapDumpRecord.ObjectRecord.ClassDumpRecord.StaticFieldRecord next : readRecord().getStaticFields()) {
                if (Intrinsics.areEqual((Object) this.hprofGraph.staticFieldName$shark(getObjectId(), next), (Object) str)) {
                    return new HeapField(this, this.hprofGraph.staticFieldName$shark(getObjectId(), next), new HeapValue(this.hprofGraph, next.getValue()));
                }
            }
            return null;
        }

        public final HeapField get(String str) {
            Intrinsics.checkParameterIsNotNull(str, "fieldName");
            return readStaticField(str);
        }

        public String toString() {
            return "class " + getName();
        }
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\u0018\u00002\u00020\u0001B'\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u001b\u0010$\u001a\u0004\u0018\u00010%2\u0006\u0010&\u001a\u00020\u001d2\u0006\u0010'\u001a\u00020\u001dH\u0002J#\u0010$\u001a\u0004\u0018\u00010%2\u000e\u0010(\u001a\n\u0012\u0006\b\u0001\u0012\u00020*0)2\u0006\u0010'\u001a\u00020\u001dH\u0002J\u0011\u0010+\u001a\u00020\t2\u0006\u0010,\u001a\u00020\u001dH\u0004J\u0015\u0010+\u001a\u00020\t2\n\u0010-\u001a\u0006\u0012\u0002\b\u00030)H\u0004J\u0011\u0010+\u001a\u00020\t2\u0006\u0010-\u001a\u00020\u0016H\u0004J\b\u0010.\u001a\u0004\u0018\u00010\u001dJ\u0018\u0010/\u001a\u0004\u0018\u00010%2\u0006\u0010&\u001a\u00020\u001d2\u0006\u0010'\u001a\u00020\u001dJ \u0010/\u001a\u0004\u0018\u00010%2\u000e\u0010(\u001a\n\u0012\u0006\b\u0001\u0012\u00020*0)2\u0006\u0010'\u001a\u00020\u001dJ\f\u00100\u001a\b\u0012\u0004\u0012\u00020%01J\b\u00102\u001a\u000203H\u0016J\b\u00104\u001a\u00020\u001dH\u0016R\u0011\u0010\u000b\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u00108VX\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0015\u001a\u00020\u00168F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0019\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u001c\u001a\u00020\u001d8F¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010 \u001a\u00020\u001d8F¢\u0006\u0006\u001a\u0004\b!\u0010\u001fR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\"R\u0014\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001b¨\u00065²\u0006\n\u00106\u001a\u000207X\u0002"}, mo175978d2 = {"Lkshark/HeapObject$HeapInstance;", "Lkshark/HeapObject;", "hprofGraph", "Lkshark/HprofHeapGraph;", "indexedObject", "Lkshark/internal/IndexedObject$IndexedInstance;", "objectId", "", "isPrimitiveWrapper", "", "(Lkshark/HprofHeapGraph;Lkshark/internal/IndexedObject$IndexedInstance;JZ)V", "byteSize", "", "getByteSize", "()I", "graph", "Lkshark/HeapGraph;", "getGraph", "()Lkshark/HeapGraph;", "getIndexedObject$shark", "()Lkshark/internal/IndexedObject$IndexedInstance;", "instanceClass", "Lkshark/HeapObject$HeapClass;", "getInstanceClass", "()Lkshark/HeapObject$HeapClass;", "instanceClassId", "getInstanceClassId", "()J", "instanceClassName", "", "getInstanceClassName", "()Ljava/lang/String;", "instanceClassSimpleName", "getInstanceClassSimpleName", "()Z", "getObjectId", "get", "Lkshark/HeapField;", "declaringClassName", "fieldName", "declaringClass", "Lkotlin/reflect/KClass;", "", "instanceOf", "className", "expectedClass", "readAsJavaString", "readField", "readFields", "Lkotlin/sequences/Sequence;", "readRecord", "Lkshark/HprofRecord$HeapDumpRecord$ObjectRecord$InstanceDumpRecord;", "toString", "shark", "fieldReader", "Lkshark/internal/FieldValuesReader;"}, mo175979k = 1, mo175980mv = {1, 1, 15})
    /* compiled from: HeapObject.kt */
    public static final class HeapInstance extends HeapObject {
        static final /* synthetic */ KProperty[] $$delegatedProperties = {C21490Reflection.property0(new PropertyReference0Impl(C21490Reflection.getOrCreateKotlinClass(HeapInstance.class), "fieldReader", "<v#0>"))};
        /* access modifiers changed from: private */
        public final HprofHeapGraph hprofGraph;
        private final IndexedObject.IndexedInstance indexedObject;
        private final boolean isPrimitiveWrapper;
        private final long objectId;

        public final IndexedObject.IndexedInstance getIndexedObject$shark() {
            return this.indexedObject;
        }

        public long getObjectId() {
            return this.objectId;
        }

        public final boolean isPrimitiveWrapper() {
            return this.isPrimitiveWrapper;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public HeapInstance(HprofHeapGraph hprofHeapGraph, IndexedObject.IndexedInstance indexedInstance, long j, boolean z) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkParameterIsNotNull(hprofHeapGraph, "hprofGraph");
            Intrinsics.checkParameterIsNotNull(indexedInstance, "indexedObject");
            this.hprofGraph = hprofHeapGraph;
            this.indexedObject = indexedInstance;
            this.objectId = j;
            this.isPrimitiveWrapper = z;
        }

        public HeapGraph getGraph() {
            return this.hprofGraph;
        }

        public final int getByteSize() {
            return getInstanceClass().getInstanceByteSize();
        }

        public final String getInstanceClassName() {
            return this.hprofGraph.className$shark(this.indexedObject.getClassId());
        }

        public final String getInstanceClassSimpleName() {
            return HeapObject.Companion.classSimpleName(getInstanceClassName());
        }

        public final HeapClass getInstanceClass() {
            HeapObject findObjectById = this.hprofGraph.findObjectById(this.indexedObject.getClassId());
            if (findObjectById != null) {
                return (HeapClass) findObjectById;
            }
            throw new TypeCastException("null cannot be cast to non-null type kshark.HeapObject.HeapClass");
        }

        public final long getInstanceClassId() {
            return this.indexedObject.getClassId();
        }

        public HprofRecord.HeapDumpRecord.ObjectRecord.InstanceDumpRecord readRecord() {
            return this.hprofGraph.readInstanceDumpRecord$shark(getObjectId(), this.indexedObject);
        }

        public final boolean instanceOf(String str) {
            Intrinsics.checkParameterIsNotNull(str, "className");
            for (HeapClass name : getInstanceClass().getClassHierarchy()) {
                if (Intrinsics.areEqual((Object) name.getName(), (Object) str)) {
                    return true;
                }
            }
            return false;
        }

        public final boolean instanceOf(KClass<?> kClass) {
            Intrinsics.checkParameterIsNotNull(kClass, "expectedClass");
            String name = JvmClassMappingKt.getJavaClass(kClass).getName();
            Intrinsics.checkExpressionValueIsNotNull(name, "expectedClass.java.name");
            return instanceOf(name);
        }

        public final boolean instanceOf(HeapClass heapClass) {
            boolean z;
            Intrinsics.checkParameterIsNotNull(heapClass, "expectedClass");
            Iterator<HeapClass> it = getInstanceClass().getClassHierarchy().iterator();
            do {
                z = false;
                if (!it.hasNext()) {
                    return false;
                }
                if (it.next().getObjectId() == heapClass.getObjectId()) {
                    z = true;
                    continue;
                }
            } while (!z);
            return true;
        }

        public final HeapField readField(KClass<? extends Object> kClass, String str) {
            Intrinsics.checkParameterIsNotNull(kClass, "declaringClass");
            Intrinsics.checkParameterIsNotNull(str, "fieldName");
            String name = JvmClassMappingKt.getJavaClass(kClass).getName();
            Intrinsics.checkExpressionValueIsNotNull(name, "declaringClass.java.name");
            return readField(name, str);
        }

        public final HeapField readField(String str, String str2) {
            HeapField heapField;
            boolean z;
            Intrinsics.checkParameterIsNotNull(str, "declaringClassName");
            Intrinsics.checkParameterIsNotNull(str2, "fieldName");
            Iterator<HeapField> it = readFields().iterator();
            while (true) {
                if (!it.hasNext()) {
                    heapField = null;
                    break;
                }
                heapField = it.next();
                HeapField heapField2 = heapField;
                if (!Intrinsics.areEqual((Object) heapField2.getDeclaringClass().getName(), (Object) str) || !Intrinsics.areEqual((Object) heapField2.getName(), (Object) str2)) {
                    z = false;
                    continue;
                } else {
                    z = true;
                    continue;
                }
                if (z) {
                    break;
                }
            }
            return heapField;
        }

        public final HeapField get(KClass<? extends Object> kClass, String str) {
            Intrinsics.checkParameterIsNotNull(kClass, "declaringClass");
            Intrinsics.checkParameterIsNotNull(str, "fieldName");
            return readField(kClass, str);
        }

        public final HeapField get(String str, String str2) {
            Intrinsics.checkParameterIsNotNull(str, "declaringClassName");
            Intrinsics.checkParameterIsNotNull(str2, "fieldName");
            return readField(str, str2);
        }

        public final Sequence<HeapField> readFields() {
            return SequencesKt.flatten(SequencesKt.map(getInstanceClass().getClassHierarchy(), new HeapObject$HeapInstance$readFields$1(this, LazyKt.lazy(new HeapObject$HeapInstance$readFields$fieldReader$2(this)), $$delegatedProperties[0])));
        }

        /* JADX WARNING: Code restructure failed: missing block: B:5:0x0018, code lost:
            r0 = r0.getValue();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.String readAsJavaString() {
            /*
                r6 = this;
                java.lang.String r0 = r6.getInstanceClassName()
                java.lang.String r1 = "java.lang.String"
                boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r1)
                r0 = r0 ^ 1
                r2 = 0
                if (r0 == 0) goto L_0x0010
                return r2
            L_0x0010:
                java.lang.String r0 = "count"
                kshark.HeapField r0 = r6.get((java.lang.String) r1, (java.lang.String) r0)
                if (r0 == 0) goto L_0x0023
                kshark.HeapValue r0 = r0.getValue()
                if (r0 == 0) goto L_0x0023
                java.lang.Integer r0 = r0.getAsInt()
                goto L_0x0024
            L_0x0023:
                r0 = r2
            L_0x0024:
                if (r0 != 0) goto L_0x0027
                goto L_0x0030
            L_0x0027:
                int r3 = r0.intValue()
                if (r3 != 0) goto L_0x0030
                java.lang.String r0 = ""
                return r0
            L_0x0030:
                java.lang.String r3 = "value"
                kshark.HeapField r4 = r6.get((java.lang.String) r1, (java.lang.String) r3)
                if (r4 != 0) goto L_0x003b
                kotlin.jvm.internal.Intrinsics.throwNpe()
            L_0x003b:
                kshark.HeapValue r4 = r4.getValue()
                kshark.HeapObject r4 = r4.getAsObject()
                if (r4 != 0) goto L_0x0048
                kotlin.jvm.internal.Intrinsics.throwNpe()
            L_0x0048:
                kshark.HprofRecord$HeapDumpRecord$ObjectRecord r4 = r4.readRecord()
                boolean r5 = r4 instanceof kshark.HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.CharArrayDump
                if (r5 == 0) goto L_0x00a0
                java.lang.String r3 = "offset"
                kshark.HeapField r1 = r6.get((java.lang.String) r1, (java.lang.String) r3)
                if (r1 == 0) goto L_0x0062
                kshark.HeapValue r1 = r1.getValue()
                if (r1 == 0) goto L_0x0062
                java.lang.Integer r2 = r1.getAsInt()
            L_0x0062:
                if (r0 == 0) goto L_0x0094
                if (r2 == 0) goto L_0x0094
                int r1 = r2.intValue()
                int r3 = r0.intValue()
                int r1 = r1 + r3
                kshark.HprofRecord$HeapDumpRecord$ObjectRecord$PrimitiveArrayDumpRecord$CharArrayDump r4 = (kshark.HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.CharArrayDump) r4
                char[] r3 = r4.getArray()
                int r3 = r3.length
                if (r1 <= r3) goto L_0x007e
                char[] r0 = r4.getArray()
                int r0 = r0.length
                goto L_0x0087
            L_0x007e:
                int r1 = r2.intValue()
                int r0 = r0.intValue()
                int r0 = r0 + r1
            L_0x0087:
                char[] r1 = r4.getArray()
                int r2 = r2.intValue()
                char[] r0 = kotlin.collections.ArraysKt.copyOfRange((char[]) r1, (int) r2, (int) r0)
                goto L_0x009a
            L_0x0094:
                kshark.HprofRecord$HeapDumpRecord$ObjectRecord$PrimitiveArrayDumpRecord$CharArrayDump r4 = (kshark.HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.CharArrayDump) r4
                char[] r0 = r4.getArray()
            L_0x009a:
                java.lang.String r1 = new java.lang.String
                r1.<init>(r0)
                return r1
            L_0x00a0:
                boolean r0 = r4 instanceof kshark.HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.ByteArrayDump
                if (r0 == 0) goto L_0x00bb
                kshark.HprofRecord$HeapDumpRecord$ObjectRecord$PrimitiveArrayDumpRecord$ByteArrayDump r4 = (kshark.HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.ByteArrayDump) r4
                byte[] r0 = r4.getArray()
                java.lang.String r1 = "UTF-8"
                java.nio.charset.Charset r1 = java.nio.charset.Charset.forName(r1)
                java.lang.String r2 = "Charset.forName(\"UTF-8\")"
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r2)
                java.lang.String r2 = new java.lang.String
                r2.<init>(r0, r1)
                return r2
            L_0x00bb:
                java.lang.UnsupportedOperationException r0 = new java.lang.UnsupportedOperationException
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                java.lang.String r4 = "'value' field "
                r2.append(r4)
                kshark.HeapField r1 = r6.get((java.lang.String) r1, (java.lang.String) r3)
                if (r1 != 0) goto L_0x00d0
                kotlin.jvm.internal.Intrinsics.throwNpe()
            L_0x00d0:
                kshark.HeapValue r1 = r1.getValue()
                r2.append(r1)
                java.lang.String r1 = " was expected to be either"
                r2.append(r1)
                java.lang.String r1 = " a char or byte array in string instance with id "
                r2.append(r1)
                long r3 = r6.getObjectId()
                r2.append(r3)
                java.lang.String r1 = r2.toString()
                r0.<init>(r1)
                java.lang.Throwable r0 = (java.lang.Throwable) r0
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: kshark.HeapObject.HeapInstance.readAsJavaString():java.lang.String");
        }

        public String toString() {
            return "instance @" + getObjectId() + " of " + getInstanceClassName();
        }
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B'\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0006\u0010\"\u001a\u00020\u0016J\f\u0010#\u001a\b\u0012\u0004\u0012\u00020%0$J\b\u0010&\u001a\u00020'H\u0016J\b\u0010(\u001a\u00020\u0010H\u0016R\u0011\u0010\u000b\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0013\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0012R\u0011\u0010\u0015\u001a\u00020\u00168F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\u001a8VX\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u001fR\u0014\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010!¨\u0006)"}, mo175978d2 = {"Lkshark/HeapObject$HeapObjectArray;", "Lkshark/HeapObject;", "hprofGraph", "Lkshark/HprofHeapGraph;", "indexedObject", "Lkshark/internal/IndexedObject$IndexedObjectArray;", "objectId", "", "isPrimitiveWrapperArray", "", "(Lkshark/HprofHeapGraph;Lkshark/internal/IndexedObject$IndexedObjectArray;JZ)V", "arrayClass", "Lkshark/HeapObject$HeapClass;", "getArrayClass", "()Lkshark/HeapObject$HeapClass;", "arrayClassName", "", "getArrayClassName", "()Ljava/lang/String;", "arrayClassSimpleName", "getArrayClassSimpleName", "arrayLength", "", "getArrayLength", "()I", "graph", "Lkshark/HeapGraph;", "getGraph", "()Lkshark/HeapGraph;", "getIndexedObject$shark", "()Lkshark/internal/IndexedObject$IndexedObjectArray;", "()Z", "getObjectId", "()J", "readByteSize", "readElements", "Lkotlin/sequences/Sequence;", "Lkshark/HeapValue;", "readRecord", "Lkshark/HprofRecord$HeapDumpRecord$ObjectRecord$ObjectArrayDumpRecord;", "toString", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
    /* compiled from: HeapObject.kt */
    public static final class HeapObjectArray extends HeapObject {
        /* access modifiers changed from: private */
        public final HprofHeapGraph hprofGraph;
        private final IndexedObject.IndexedObjectArray indexedObject;
        private final boolean isPrimitiveWrapperArray;
        private final long objectId;

        public final IndexedObject.IndexedObjectArray getIndexedObject$shark() {
            return this.indexedObject;
        }

        public long getObjectId() {
            return this.objectId;
        }

        public final boolean isPrimitiveWrapperArray() {
            return this.isPrimitiveWrapperArray;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public HeapObjectArray(HprofHeapGraph hprofHeapGraph, IndexedObject.IndexedObjectArray indexedObjectArray, long j, boolean z) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkParameterIsNotNull(hprofHeapGraph, "hprofGraph");
            Intrinsics.checkParameterIsNotNull(indexedObjectArray, "indexedObject");
            this.hprofGraph = hprofHeapGraph;
            this.indexedObject = indexedObjectArray;
            this.objectId = j;
            this.isPrimitiveWrapperArray = z;
        }

        public HeapGraph getGraph() {
            return this.hprofGraph;
        }

        public final String getArrayClassName() {
            return this.hprofGraph.className$shark(this.indexedObject.getArrayClassId());
        }

        public final String getArrayClassSimpleName() {
            return HeapObject.Companion.classSimpleName(getArrayClassName());
        }

        public final HeapClass getArrayClass() {
            HeapObject findObjectById = this.hprofGraph.findObjectById(this.indexedObject.getArrayClassId());
            if (findObjectById != null) {
                return (HeapClass) findObjectById;
            }
            throw new TypeCastException("null cannot be cast to non-null type kshark.HeapObject.HeapClass");
        }

        public final int getArrayLength() {
            return this.indexedObject.getSize();
        }

        public final int readByteSize() {
            return readRecord().getElementIds().length * this.hprofGraph.getIdentifierByteSize();
        }

        public HprofRecord.HeapDumpRecord.ObjectRecord.ObjectArrayDumpRecord readRecord() {
            return this.hprofGraph.readObjectArrayDumpRecord$shark(getObjectId(), this.indexedObject);
        }

        public final Sequence<HeapValue> readElements() {
            return SequencesKt.map(ArraysKt.asSequence(readRecord().getElementIds()), new HeapObject$HeapObjectArray$readElements$1(this));
        }

        public String toString() {
            return "object array @" + getObjectId() + " of " + getArrayClassName();
        }
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010\u001f\u001a\u00020\u0012J\b\u0010 \u001a\u00020!H\u0016J\b\u0010\"\u001a\u00020\u000eH\u0016R\u0011\u0010\t\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u000e8F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u00168VX\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u001b\u001a\u00020\u001c8F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001e¨\u0006#"}, mo175978d2 = {"Lkshark/HeapObject$HeapPrimitiveArray;", "Lkshark/HeapObject;", "hprofGraph", "Lkshark/HprofHeapGraph;", "indexedObject", "Lkshark/internal/IndexedObject$IndexedPrimitiveArray;", "objectId", "", "(Lkshark/HprofHeapGraph;Lkshark/internal/IndexedObject$IndexedPrimitiveArray;J)V", "arrayClass", "Lkshark/HeapObject$HeapClass;", "getArrayClass", "()Lkshark/HeapObject$HeapClass;", "arrayClassName", "", "getArrayClassName", "()Ljava/lang/String;", "arrayLength", "", "getArrayLength", "()I", "graph", "Lkshark/HeapGraph;", "getGraph", "()Lkshark/HeapGraph;", "getObjectId", "()J", "primitiveType", "Lkshark/PrimitiveType;", "getPrimitiveType", "()Lkshark/PrimitiveType;", "readByteSize", "readRecord", "Lkshark/HprofRecord$HeapDumpRecord$ObjectRecord$PrimitiveArrayDumpRecord;", "toString", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
    /* compiled from: HeapObject.kt */
    public static final class HeapPrimitiveArray extends HeapObject {
        private final HprofHeapGraph hprofGraph;
        private final IndexedObject.IndexedPrimitiveArray indexedObject;
        private final long objectId;

        public long getObjectId() {
            return this.objectId;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public HeapPrimitiveArray(HprofHeapGraph hprofHeapGraph, IndexedObject.IndexedPrimitiveArray indexedPrimitiveArray, long j) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkParameterIsNotNull(hprofHeapGraph, "hprofGraph");
            Intrinsics.checkParameterIsNotNull(indexedPrimitiveArray, "indexedObject");
            this.hprofGraph = hprofHeapGraph;
            this.indexedObject = indexedPrimitiveArray;
            this.objectId = j;
        }

        public HeapGraph getGraph() {
            return this.hprofGraph;
        }

        public final int readByteSize() {
            int length;
            int byteSize;
            HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord readRecord = readRecord();
            if (readRecord instanceof HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.BooleanArrayDump) {
                length = ((HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.BooleanArrayDump) readRecord).getArray().length;
                byteSize = PrimitiveType.BOOLEAN.getByteSize();
            } else if (readRecord instanceof HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.CharArrayDump) {
                length = ((HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.CharArrayDump) readRecord).getArray().length;
                byteSize = PrimitiveType.CHAR.getByteSize();
            } else if (readRecord instanceof HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.FloatArrayDump) {
                length = ((HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.FloatArrayDump) readRecord).getArray().length;
                byteSize = PrimitiveType.FLOAT.getByteSize();
            } else if (readRecord instanceof HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.DoubleArrayDump) {
                length = ((HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.DoubleArrayDump) readRecord).getArray().length;
                byteSize = PrimitiveType.DOUBLE.getByteSize();
            } else if (readRecord instanceof HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.ByteArrayDump) {
                length = ((HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.ByteArrayDump) readRecord).getArray().length;
                byteSize = PrimitiveType.BYTE.getByteSize();
            } else if (readRecord instanceof HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.ShortArrayDump) {
                length = ((HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.ShortArrayDump) readRecord).getArray().length;
                byteSize = PrimitiveType.SHORT.getByteSize();
            } else if (readRecord instanceof HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.IntArrayDump) {
                length = ((HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.IntArrayDump) readRecord).getArray().length;
                byteSize = PrimitiveType.INT.getByteSize();
            } else if (readRecord instanceof HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.LongArrayDump) {
                length = ((HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.LongArrayDump) readRecord).getArray().length;
                byteSize = PrimitiveType.LONG.getByteSize();
            } else {
                throw new NoWhenBranchMatchedException();
            }
            return length * byteSize;
        }

        public final PrimitiveType getPrimitiveType() {
            return this.indexedObject.getPrimitiveType();
        }

        public final String getArrayClassName() {
            StringBuilder sb = new StringBuilder();
            String name = getPrimitiveType().name();
            Locale locale = Locale.US;
            Intrinsics.checkExpressionValueIsNotNull(locale, "Locale.US");
            if (name != null) {
                String lowerCase = name.toLowerCase(locale);
                Intrinsics.checkExpressionValueIsNotNull(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
                sb.append(lowerCase);
                sb.append("[]");
                return sb.toString();
            }
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }

        public final HeapClass getArrayClass() {
            HeapClass findClassByName = getGraph().findClassByName(getArrayClassName());
            if (findClassByName == null) {
                Intrinsics.throwNpe();
            }
            return findClassByName;
        }

        public final int getArrayLength() {
            return this.indexedObject.getSize();
        }

        public HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord readRecord() {
            return this.hprofGraph.readPrimitiveArrayDumpRecord$shark(getObjectId(), this.indexedObject);
        }

        public String toString() {
            return "primitive array @" + getObjectId() + " of " + getArrayClassName();
        }
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005H\u0002R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, mo175978d2 = {"Lkshark/HeapObject$Companion;", "", "()V", "primitiveArrayClassesByName", "", "", "Lkshark/PrimitiveType;", "classSimpleName", "className", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
    /* compiled from: HeapObject.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* access modifiers changed from: private */
        public final String classSimpleName(String str) {
            int lastIndexOf$default = StringsKt.lastIndexOf$default((CharSequence) str, '.', 0, false, 6, (Object) null);
            if (lastIndexOf$default == -1) {
                return str;
            }
            int i = lastIndexOf$default + 1;
            if (str != null) {
                String substring = str.substring(i);
                Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.String).substring(startIndex)");
                return substring;
            }
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
    }

    static {
        PrimitiveType[] values = PrimitiveType.values();
        Collection arrayList = new ArrayList(values.length);
        int length = values.length;
        int i = 0;
        while (i < length) {
            PrimitiveType primitiveType = values[i];
            StringBuilder sb = new StringBuilder();
            String name = primitiveType.name();
            Locale locale = Locale.US;
            Intrinsics.checkExpressionValueIsNotNull(locale, "Locale.US");
            if (name != null) {
                String lowerCase = name.toLowerCase(locale);
                Intrinsics.checkExpressionValueIsNotNull(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
                sb.append(lowerCase);
                sb.append("[]");
                arrayList.add(TuplesKt.m42317to(sb.toString(), primitiveType));
                i++;
            } else {
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
        }
        primitiveArrayClassesByName = MapsKt.toMap((List) arrayList);
    }
}
