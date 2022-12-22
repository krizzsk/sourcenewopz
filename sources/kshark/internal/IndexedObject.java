package kshark.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kshark.PrimitiveType;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0004\u0007\b\t\nB\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\u0001\u0004\u000b\f\r\u000e¨\u0006\u000f"}, mo175978d2 = {"Lkshark/internal/IndexedObject;", "", "()V", "position", "", "getPosition", "()J", "IndexedClass", "IndexedInstance", "IndexedObjectArray", "IndexedPrimitiveArray", "Lkshark/internal/IndexedObject$IndexedClass;", "Lkshark/internal/IndexedObject$IndexedInstance;", "Lkshark/internal/IndexedObject$IndexedObjectArray;", "Lkshark/internal/IndexedObject$IndexedPrimitiveArray;", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
/* compiled from: IndexedObject.kt */
public abstract class IndexedObject {
    public abstract long getPosition();

    private IndexedObject() {
    }

    public /* synthetic */ IndexedObject(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\r"}, mo175978d2 = {"Lkshark/internal/IndexedObject$IndexedClass;", "Lkshark/internal/IndexedObject;", "position", "", "superclassId", "instanceSize", "", "(JJI)V", "getInstanceSize", "()I", "getPosition", "()J", "getSuperclassId", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
    /* compiled from: IndexedObject.kt */
    public static final class IndexedClass extends IndexedObject {
        private final int instanceSize;
        private final long position;
        private final long superclassId;

        public long getPosition() {
            return this.position;
        }

        public final long getSuperclassId() {
            return this.superclassId;
        }

        public final int getInstanceSize() {
            return this.instanceSize;
        }

        public IndexedClass(long j, long j2, int i) {
            super((DefaultConstructorMarker) null);
            this.position = j;
            this.superclassId = j2;
            this.instanceSize = i;
        }
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\t"}, mo175978d2 = {"Lkshark/internal/IndexedObject$IndexedInstance;", "Lkshark/internal/IndexedObject;", "position", "", "classId", "(JJ)V", "getClassId", "()J", "getPosition", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
    /* compiled from: IndexedObject.kt */
    public static final class IndexedInstance extends IndexedObject {
        private final long classId;
        private final long position;

        public long getPosition() {
            return this.position;
        }

        public final long getClassId() {
            return this.classId;
        }

        public IndexedInstance(long j, long j2) {
            super((DefaultConstructorMarker) null);
            this.position = j;
            this.classId = j2;
        }
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, mo175978d2 = {"Lkshark/internal/IndexedObject$IndexedObjectArray;", "Lkshark/internal/IndexedObject;", "position", "", "arrayClassId", "size", "", "(JJI)V", "getArrayClassId", "()J", "getPosition", "getSize", "()I", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
    /* compiled from: IndexedObject.kt */
    public static final class IndexedObjectArray extends IndexedObject {
        private final long arrayClassId;
        private final long position;
        private final int size;

        public long getPosition() {
            return this.position;
        }

        public final long getArrayClassId() {
            return this.arrayClassId;
        }

        public final int getSize() {
            return this.size;
        }

        public IndexedObjectArray(long j, long j2, int i) {
            super((DefaultConstructorMarker) null);
            this.position = j;
            this.arrayClassId = j2;
            this.size = i;
        }
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0005\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bR\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, mo175978d2 = {"Lkshark/internal/IndexedObject$IndexedPrimitiveArray;", "Lkshark/internal/IndexedObject;", "position", "", "primitiveType", "Lkshark/PrimitiveType;", "size", "", "(JLkshark/PrimitiveType;I)V", "getPosition", "()J", "getPrimitiveType", "()Lkshark/PrimitiveType;", "primitiveTypeOrdinal", "", "getSize", "()I", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
    /* compiled from: IndexedObject.kt */
    public static final class IndexedPrimitiveArray extends IndexedObject {
        private final long position;
        private final byte primitiveTypeOrdinal;
        private final int size;

        public long getPosition() {
            return this.position;
        }

        public final int getSize() {
            return this.size;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public IndexedPrimitiveArray(long j, PrimitiveType primitiveType, int i) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkParameterIsNotNull(primitiveType, "primitiveType");
            this.position = j;
            this.size = i;
            this.primitiveTypeOrdinal = (byte) primitiveType.ordinal();
        }

        public final PrimitiveType getPrimitiveType() {
            return PrimitiveType.values()[this.primitiveTypeOrdinal];
        }
    }
}
