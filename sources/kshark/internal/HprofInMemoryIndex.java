package kshark.internal;

import com.didichuxing.mlcp.drtc.consts.SDKConsts;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.C21490Reflection;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.reflect.KClass;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import kshark.GcRoot;
import kshark.Hprof;
import kshark.HprofReader;
import kshark.HprofRecord;
import kshark.OnHprofRecordListener;
import kshark.PrimitiveType;
import kshark.ProguardMapping;
import kshark.SharkLog;
import kshark.internal.IndexedObject;
import kshark.internal.UnsortedByteEntries;
import kshark.internal.hppc.LongLongScatterMap;
import kshark.internal.hppc.LongObjectScatterMap;
import org.apache.commons.p071io.IOUtils;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0000\u0018\u0000 02\u00020\u0001:\u0002/0Bk\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\n\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014¢\u0006\u0002\u0010\u0016J\u0015\u0010\u0019\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u001a\u001a\u00020\u0006¢\u0006\u0002\u0010\u001bJ\u000e\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u0015J\u0016\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u0015J\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fJ\u0010\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u0015H\u0002J\u0018\u0010\u001f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\"0!0 J\u0018\u0010#\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020$0!0 J\u0018\u0010%\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020&0!0 J\u0010\u0010'\u001a\u0004\u0018\u00010(2\u0006\u0010)\u001a\u00020\u0015J\u0018\u0010*\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020(0!0 J\u0018\u0010+\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020,0!0 J\u000e\u0010-\u001a\u00020.2\u0006\u0010)\u001a\u00020\u0015R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0004¢\u0006\u0002\n\u0000¨\u00061"}, mo175978d2 = {"Lkshark/internal/HprofInMemoryIndex;", "", "positionSize", "", "hprofStringCache", "Lkshark/internal/hppc/LongObjectScatterMap;", "", "classNames", "Lkshark/internal/hppc/LongLongScatterMap;", "classIndex", "Lkshark/internal/SortedBytesMap;", "instanceIndex", "objectArrayIndex", "primitiveArrayIndex", "gcRoots", "", "Lkshark/GcRoot;", "proguardMapping", "Lkshark/ProguardMapping;", "primitiveWrapperTypes", "", "", "(ILkshark/internal/hppc/LongObjectScatterMap;Lkshark/internal/hppc/LongLongScatterMap;Lkshark/internal/SortedBytesMap;Lkshark/internal/SortedBytesMap;Lkshark/internal/SortedBytesMap;Lkshark/internal/SortedBytesMap;Ljava/util/List;Lkshark/ProguardMapping;Ljava/util/Set;)V", "getPrimitiveWrapperTypes", "()Ljava/util/Set;", "classId", "className", "(Ljava/lang/String;)Ljava/lang/Long;", "fieldName", "id", "hprofStringById", "indexedClassSequence", "Lkotlin/sequences/Sequence;", "Lkotlin/Pair;", "Lkshark/internal/IndexedObject$IndexedClass;", "indexedInstanceSequence", "Lkshark/internal/IndexedObject$IndexedInstance;", "indexedObjectArraySequence", "Lkshark/internal/IndexedObject$IndexedObjectArray;", "indexedObjectOrNull", "Lkshark/internal/IndexedObject;", "objectId", "indexedObjectSequence", "indexedPrimitiveArraySequence", "Lkshark/internal/IndexedObject$IndexedPrimitiveArray;", "objectIdIsIndexed", "", "Builder", "Companion", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
/* compiled from: HprofInMemoryIndex.kt */
public final class HprofInMemoryIndex {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */

    /* renamed from: k */
    public static final Set<String> f4630k;
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final int f4631a;

    /* renamed from: b */
    private final LongObjectScatterMap<String> f4632b;

    /* renamed from: c */
    private final LongLongScatterMap f4633c;

    /* renamed from: d */
    private final SortedBytesMap f4634d;

    /* renamed from: e */
    private final SortedBytesMap f4635e;

    /* renamed from: f */
    private final SortedBytesMap f4636f;

    /* renamed from: g */
    private final SortedBytesMap f4637g;

    /* renamed from: h */
    private final List<GcRoot> f4638h;

    /* renamed from: i */
    private final ProguardMapping f4639i;

    /* renamed from: j */
    private final Set<Long> f4640j;

    private HprofInMemoryIndex(int i, LongObjectScatterMap<String> longObjectScatterMap, LongLongScatterMap longLongScatterMap, SortedBytesMap sortedBytesMap, SortedBytesMap sortedBytesMap2, SortedBytesMap sortedBytesMap3, SortedBytesMap sortedBytesMap4, List<? extends GcRoot> list, ProguardMapping proguardMapping, Set<Long> set) {
        this.f4631a = i;
        this.f4632b = longObjectScatterMap;
        this.f4633c = longLongScatterMap;
        this.f4634d = sortedBytesMap;
        this.f4635e = sortedBytesMap2;
        this.f4636f = sortedBytesMap3;
        this.f4637g = sortedBytesMap4;
        this.f4638h = list;
        this.f4639i = proguardMapping;
        this.f4640j = set;
    }

    public /* synthetic */ HprofInMemoryIndex(int i, LongObjectScatterMap longObjectScatterMap, LongLongScatterMap longLongScatterMap, SortedBytesMap sortedBytesMap, SortedBytesMap sortedBytesMap2, SortedBytesMap sortedBytesMap3, SortedBytesMap sortedBytesMap4, List list, ProguardMapping proguardMapping, Set set, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, longObjectScatterMap, longLongScatterMap, sortedBytesMap, sortedBytesMap2, sortedBytesMap3, sortedBytesMap4, list, proguardMapping, set);
    }

    public final Set<Long> getPrimitiveWrapperTypes() {
        return this.f4640j;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0008, code lost:
        r1 = r0.f4639i.deobfuscateFieldName(m2979a(r0.f4633c.get(r1)), r3);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String fieldName(long r1, long r3) {
        /*
            r0 = this;
            java.lang.String r3 = r0.m2979a(r3)
            kshark.ProguardMapping r4 = r0.f4639i
            if (r4 == 0) goto L_0x001b
            kshark.internal.hppc.LongLongScatterMap r4 = r0.f4633c
            long r1 = r4.get(r1)
            java.lang.String r1 = r0.m2979a(r1)
            kshark.ProguardMapping r2 = r0.f4639i
            java.lang.String r1 = r2.deobfuscateFieldName(r1, r3)
            if (r1 == 0) goto L_0x001b
            r3 = r1
        L_0x001b:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: kshark.internal.HprofInMemoryIndex.fieldName(long, long):java.lang.String");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000e, code lost:
        r3 = r3.deobfuscateClassName(r2);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String className(long r2) {
        /*
            r1 = this;
            kshark.internal.hppc.LongLongScatterMap r0 = r1.f4633c
            long r2 = r0.get(r2)
            java.lang.String r2 = r1.m2979a(r2)
            kshark.ProguardMapping r3 = r1.f4639i
            if (r3 == 0) goto L_0x0015
            java.lang.String r3 = r3.deobfuscateClassName(r2)
            if (r3 == 0) goto L_0x0015
            r2 = r3
        L_0x0015:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: kshark.internal.HprofInMemoryIndex.className(long):java.lang.String");
    }

    public final Long classId(String str) {
        Pair<Long, String> pair;
        Pair<Long, Long> pair2;
        boolean z;
        Intrinsics.checkParameterIsNotNull(str, "className");
        Iterator<Pair<Long, String>> it = this.f4632b.entrySequence().iterator();
        while (true) {
            if (!it.hasNext()) {
                pair = null;
                break;
            }
            pair = it.next();
            if (Intrinsics.areEqual((Object) (String) pair.getSecond(), (Object) str)) {
                break;
            }
        }
        Pair pair3 = pair;
        Long l = pair3 != null ? (Long) pair3.getFirst() : null;
        if (l == null) {
            return null;
        }
        long longValue = l.longValue();
        Iterator<Pair<Long, Long>> it2 = this.f4633c.entrySequence().iterator();
        while (true) {
            if (!it2.hasNext()) {
                pair2 = null;
                break;
            }
            pair2 = it2.next();
            if (((Number) pair2.getSecond()).longValue() == longValue) {
                z = true;
                continue;
            } else {
                z = false;
                continue;
            }
            if (z) {
                break;
            }
        }
        Pair pair4 = pair2;
        if (pair4 != null) {
            return (Long) pair4.getFirst();
        }
        return null;
    }

    public final Sequence<Pair<Long, IndexedObject.IndexedClass>> indexedClassSequence() {
        return SequencesKt.map(this.f4634d.entrySequence(), new HprofInMemoryIndex$indexedClassSequence$1(this));
    }

    public final Sequence<Pair<Long, IndexedObject.IndexedInstance>> indexedInstanceSequence() {
        return SequencesKt.map(this.f4635e.entrySequence(), new HprofInMemoryIndex$indexedInstanceSequence$1(this));
    }

    public final Sequence<Pair<Long, IndexedObject.IndexedObjectArray>> indexedObjectArraySequence() {
        return SequencesKt.map(this.f4636f.entrySequence(), new HprofInMemoryIndex$indexedObjectArraySequence$1(this));
    }

    public final Sequence<Pair<Long, IndexedObject.IndexedPrimitiveArray>> indexedPrimitiveArraySequence() {
        return SequencesKt.map(this.f4637g.entrySequence(), new HprofInMemoryIndex$indexedPrimitiveArraySequence$1(this));
    }

    public final Sequence<Pair<Long, IndexedObject>> indexedObjectSequence() {
        return SequencesKt.plus(SequencesKt.plus(SequencesKt.plus(indexedClassSequence(), (Sequence<Pair<Long, IndexedObject.IndexedClass>>) indexedInstanceSequence()), (Sequence<Pair<Long, IndexedObject.IndexedInstance>>) indexedObjectArraySequence()), (Sequence<Pair<Long, IndexedObject.IndexedObjectArray>>) indexedPrimitiveArraySequence());
    }

    public final List<GcRoot> gcRoots() {
        return this.f4638h;
    }

    public final IndexedObject indexedObjectOrNull(long j) {
        ByteSubArray byteSubArray = this.f4634d.get(j);
        if (byteSubArray != null) {
            return new IndexedObject.IndexedClass(byteSubArray.readTruncatedLong(this.f4631a), byteSubArray.readId(), byteSubArray.readInt());
        }
        ByteSubArray byteSubArray2 = this.f4635e.get(j);
        if (byteSubArray2 != null) {
            return new IndexedObject.IndexedInstance(byteSubArray2.readTruncatedLong(this.f4631a), byteSubArray2.readId());
        }
        ByteSubArray byteSubArray3 = this.f4636f.get(j);
        if (byteSubArray3 != null) {
            return new IndexedObject.IndexedObjectArray(byteSubArray3.readTruncatedLong(this.f4631a), byteSubArray3.readId(), byteSubArray3.readInt());
        }
        ByteSubArray byteSubArray4 = this.f4637g.get(j);
        if (byteSubArray4 != null) {
            return new IndexedObject.IndexedPrimitiveArray(byteSubArray4.readTruncatedLong(this.f4631a), PrimitiveType.values()[byteSubArray4.readByte()], byteSubArray4.readInt());
        }
        return null;
    }

    public final boolean objectIdIsIndexed(long j) {
        if (this.f4634d.get(j) == null && this.f4635e.get(j) == null && this.f4636f.get(j) == null && this.f4637g.get(j) == null) {
            return false;
        }
        return true;
    }

    /* renamed from: a */
    private final String m2979a(long j) {
        String str = this.f4632b.get(j);
        if (str != null) {
            return str;
        }
        throw new IllegalArgumentException("Hprof string " + j + " not in cache");
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010#\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001BK\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\u0014\u0010\u000b\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u000e0\r0\f¢\u0006\u0002\u0010\u000fJ\u0010\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$J\u0018\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u00052\u0006\u0010(\u001a\u00020)H\u0016R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0015X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u000b\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u000e0\r0\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00050\u001fX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00050\u001fX\u0004¢\u0006\u0002\n\u0000¨\u0006*"}, mo175978d2 = {"Lkshark/internal/HprofInMemoryIndex$Builder;", "Lkshark/OnHprofRecordListener;", "longIdentifiers", "", "fileLength", "", "classCount", "", "instanceCount", "objectArrayCount", "primitiveArrayCount", "indexedGcRootsTypes", "", "Lkotlin/reflect/KClass;", "Lkshark/GcRoot;", "(ZJIIIILjava/util/Set;)V", "classIndex", "Lkshark/internal/UnsortedByteEntries;", "classNames", "Lkshark/internal/hppc/LongLongScatterMap;", "gcRoots", "", "hprofStringCache", "Lkshark/internal/hppc/LongObjectScatterMap;", "", "identifierSize", "instanceIndex", "objectArrayIndex", "positionSize", "primitiveArrayIndex", "primitiveWrapperClassNames", "", "primitiveWrapperTypes", "buildIndex", "Lkshark/internal/HprofInMemoryIndex;", "proguardMapping", "Lkshark/ProguardMapping;", "onHprofRecord", "", "position", "record", "Lkshark/HprofRecord;", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
    /* compiled from: HprofInMemoryIndex.kt */
    private static final class Builder implements OnHprofRecordListener {
        private final UnsortedByteEntries classIndex;
        private final LongLongScatterMap classNames;
        private final List<GcRoot> gcRoots;
        private final LongObjectScatterMap<String> hprofStringCache;
        private final int identifierSize;
        private final Set<KClass<? extends GcRoot>> indexedGcRootsTypes;
        private final UnsortedByteEntries instanceIndex;
        private final UnsortedByteEntries objectArrayIndex;
        private final int positionSize;
        private final UnsortedByteEntries primitiveArrayIndex;
        private final Set<Long> primitiveWrapperClassNames;
        private final Set<Long> primitiveWrapperTypes;

        public Builder(boolean z, long j, int i, int i2, int i3, int i4, Set<? extends KClass<? extends GcRoot>> set) {
            Set<? extends KClass<? extends GcRoot>> set2 = set;
            Intrinsics.checkParameterIsNotNull(set2, "indexedGcRootsTypes");
            this.indexedGcRootsTypes = set2;
            this.identifierSize = z ? 8 : 4;
            long j2 = j;
            this.positionSize = HprofInMemoryIndex.Companion.byteSizeForUnsigned(j);
            this.hprofStringCache = new LongObjectScatterMap<>();
            this.classNames = new LongLongScatterMap();
            boolean z2 = z;
            this.classIndex = new UnsortedByteEntries(this.positionSize + this.identifierSize + 4, z2, i, 0.0d, 8, (DefaultConstructorMarker) null);
            this.instanceIndex = new UnsortedByteEntries(this.identifierSize + this.positionSize, z2, i2, 0.0d, 8, (DefaultConstructorMarker) null);
            this.objectArrayIndex = new UnsortedByteEntries(this.positionSize + this.identifierSize + 4, z2, i3, 0.0d, 8, (DefaultConstructorMarker) null);
            this.primitiveArrayIndex = new UnsortedByteEntries(this.positionSize + 1 + 4, z2, i4, 0.0d, 8, (DefaultConstructorMarker) null);
            this.primitiveWrapperTypes = new LinkedHashSet();
            this.primitiveWrapperClassNames = new LinkedHashSet();
            this.gcRoots = new ArrayList();
        }

        public void onHprofRecord(long j, HprofRecord hprofRecord) {
            Intrinsics.checkParameterIsNotNull(hprofRecord, SDKConsts.TAG_KEY_RECORD);
            if (hprofRecord instanceof HprofRecord.StringRecord) {
                HprofRecord.StringRecord stringRecord = (HprofRecord.StringRecord) hprofRecord;
                if (HprofInMemoryIndex.f4630k.contains(stringRecord.getString())) {
                    this.primitiveWrapperClassNames.add(Long.valueOf(stringRecord.getId()));
                }
                this.hprofStringCache.set(stringRecord.getId(), StringsKt.replace$default(stringRecord.getString(), (char) IOUtils.DIR_SEPARATOR_UNIX, '.', false, 4, (Object) null));
            } else if (hprofRecord instanceof HprofRecord.LoadClassRecord) {
                HprofRecord.LoadClassRecord loadClassRecord = (HprofRecord.LoadClassRecord) hprofRecord;
                this.classNames.set(loadClassRecord.getId(), loadClassRecord.getClassNameStringId());
                if (this.primitiveWrapperClassNames.contains(Long.valueOf(loadClassRecord.getClassNameStringId()))) {
                    this.primitiveWrapperTypes.add(Long.valueOf(loadClassRecord.getId()));
                }
            } else if (hprofRecord instanceof HprofRecord.HeapDumpRecord.GcRootRecord) {
                GcRoot gcRoot = ((HprofRecord.HeapDumpRecord.GcRootRecord) hprofRecord).getGcRoot();
                if (gcRoot.getId() != 0 && this.indexedGcRootsTypes.contains(C21490Reflection.getOrCreateKotlinClass(gcRoot.getClass()))) {
                    this.gcRoots.add(gcRoot);
                }
            } else if (hprofRecord instanceof HprofRecord.HeapDumpRecord.ObjectRecord.ClassSkipContentRecord) {
                HprofRecord.HeapDumpRecord.ObjectRecord.ClassSkipContentRecord classSkipContentRecord = (HprofRecord.HeapDumpRecord.ObjectRecord.ClassSkipContentRecord) hprofRecord;
                UnsortedByteEntries.MutableByteSubArray append = this.classIndex.append(classSkipContentRecord.getId());
                append.writeTruncatedLong(j, this.positionSize);
                append.writeId(classSkipContentRecord.getSuperclassId());
                append.writeInt(classSkipContentRecord.getInstanceSize());
            } else if (hprofRecord instanceof HprofRecord.HeapDumpRecord.ObjectRecord.InstanceSkipContentRecord) {
                HprofRecord.HeapDumpRecord.ObjectRecord.InstanceSkipContentRecord instanceSkipContentRecord = (HprofRecord.HeapDumpRecord.ObjectRecord.InstanceSkipContentRecord) hprofRecord;
                UnsortedByteEntries.MutableByteSubArray append2 = this.instanceIndex.append(instanceSkipContentRecord.getId());
                append2.writeTruncatedLong(j, this.positionSize);
                append2.writeId(instanceSkipContentRecord.getClassId());
            } else if (hprofRecord instanceof HprofRecord.HeapDumpRecord.ObjectRecord.ObjectArraySkipContentRecord) {
                HprofRecord.HeapDumpRecord.ObjectRecord.ObjectArraySkipContentRecord objectArraySkipContentRecord = (HprofRecord.HeapDumpRecord.ObjectRecord.ObjectArraySkipContentRecord) hprofRecord;
                UnsortedByteEntries.MutableByteSubArray append3 = this.objectArrayIndex.append(objectArraySkipContentRecord.getId());
                append3.writeTruncatedLong(j, this.positionSize);
                append3.writeId(objectArraySkipContentRecord.getArrayClassId());
                append3.writeInt(objectArraySkipContentRecord.getSize());
            } else if (hprofRecord instanceof HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArraySkipContentRecord) {
                HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArraySkipContentRecord primitiveArraySkipContentRecord = (HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArraySkipContentRecord) hprofRecord;
                UnsortedByteEntries.MutableByteSubArray append4 = this.primitiveArrayIndex.append(primitiveArraySkipContentRecord.getId());
                append4.writeTruncatedLong(j, this.positionSize);
                append4.writeByte((byte) primitiveArraySkipContentRecord.getType().ordinal());
                append4.writeInt(primitiveArraySkipContentRecord.getSize());
            }
        }

        public final HprofInMemoryIndex buildIndex(ProguardMapping proguardMapping) {
            SortedBytesMap moveToSortedMap = this.instanceIndex.moveToSortedMap();
            SortedBytesMap moveToSortedMap2 = this.objectArrayIndex.moveToSortedMap();
            SortedBytesMap moveToSortedMap3 = this.primitiveArrayIndex.moveToSortedMap();
            return new HprofInMemoryIndex(this.positionSize, this.hprofStringCache, this.classNames, this.classIndex.moveToSortedMap(), moveToSortedMap, moveToSortedMap2, moveToSortedMap3, this.gcRoots, proguardMapping, this.primitiveWrapperTypes, (DefaultConstructorMarker) null);
        }
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0002J.\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0014\u0010\u0010\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00120\u00110\u0004R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, mo175978d2 = {"Lkshark/internal/HprofInMemoryIndex$Companion;", "", "()V", "PRIMITIVE_WRAPPER_TYPES", "", "", "byteSizeForUnsigned", "", "maxValue", "", "createReadingHprof", "Lkshark/internal/HprofInMemoryIndex;", "hprof", "Lkshark/Hprof;", "proguardMapping", "Lkshark/ProguardMapping;", "indexedGcRootTypes", "Lkotlin/reflect/KClass;", "Lkshark/GcRoot;", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
    /* compiled from: HprofInMemoryIndex.kt */
    public static final class Companion {
        /* access modifiers changed from: private */
        public final int byteSizeForUnsigned(long j) {
            int i = 0;
            while (j != 0) {
                j >>= 8;
                i++;
            }
            return i;
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final HprofInMemoryIndex createReadingHprof(Hprof hprof, ProguardMapping proguardMapping, Set<? extends KClass<? extends GcRoot>> set) {
            Hprof hprof2 = hprof;
            Intrinsics.checkParameterIsNotNull(hprof, "hprof");
            Intrinsics.checkParameterIsNotNull(set, "indexedGcRootTypes");
            boolean z = false;
            Set of = SetsKt.setOf(C21490Reflection.getOrCreateKotlinClass(HprofRecord.StringRecord.class), C21490Reflection.getOrCreateKotlinClass(HprofRecord.LoadClassRecord.class), C21490Reflection.getOrCreateKotlinClass(HprofRecord.HeapDumpRecord.ObjectRecord.ClassSkipContentRecord.class), C21490Reflection.getOrCreateKotlinClass(HprofRecord.HeapDumpRecord.ObjectRecord.InstanceSkipContentRecord.class), C21490Reflection.getOrCreateKotlinClass(HprofRecord.HeapDumpRecord.ObjectRecord.ObjectArraySkipContentRecord.class), C21490Reflection.getOrCreateKotlinClass(HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArraySkipContentRecord.class), C21490Reflection.getOrCreateKotlinClass(HprofRecord.HeapDumpRecord.GcRootRecord.class));
            HprofReader reader = hprof.getReader();
            Ref.IntRef intRef = new Ref.IntRef();
            intRef.element = 0;
            Ref.IntRef intRef2 = new Ref.IntRef();
            intRef2.element = 0;
            Ref.IntRef intRef3 = new Ref.IntRef();
            intRef3.element = 0;
            Ref.IntRef intRef4 = new Ref.IntRef();
            intRef4.element = 0;
            Set of2 = SetsKt.setOf(C21490Reflection.getOrCreateKotlinClass(HprofRecord.LoadClassRecord.class), C21490Reflection.getOrCreateKotlinClass(HprofRecord.HeapDumpRecord.ObjectRecord.InstanceSkipContentRecord.class), C21490Reflection.getOrCreateKotlinClass(HprofRecord.HeapDumpRecord.ObjectRecord.ObjectArraySkipContentRecord.class), C21490Reflection.getOrCreateKotlinClass(HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArraySkipContentRecord.class));
            OnHprofRecordListener.Companion companion = OnHprofRecordListener.Companion;
            reader.readHprofRecords(of2, new C2361xa2ae7540(intRef, intRef2, intRef3, intRef4));
            SharkLog.Logger logger = SharkLog.INSTANCE.getLogger();
            if (logger != null) {
                logger.mo23715d("classCount:" + intRef.element + " instanceCount:" + intRef2.element + " objectArrayCount:" + intRef3.element + " primitiveArrayCount:" + intRef4.element);
            }
            hprof.moveReaderTo(reader.getStartPosition());
            if (reader.getIdentifierByteSize() == 8) {
                z = true;
            }
            Builder builder = new Builder(z, hprof.getFileLength(), intRef.element, intRef2.element, intRef3.element, intRef4.element, set);
            reader.readHprofRecords(of, builder);
            return builder.buildIndex(proguardMapping);
        }
    }

    static {
        String name = Boolean.TYPE.getName();
        Intrinsics.checkExpressionValueIsNotNull(name, "Boolean::class.java.name");
        String name2 = Character.TYPE.getName();
        Intrinsics.checkExpressionValueIsNotNull(name2, "Char::class.java.name");
        String name3 = Float.TYPE.getName();
        Intrinsics.checkExpressionValueIsNotNull(name3, "Float::class.java.name");
        String name4 = Double.TYPE.getName();
        Intrinsics.checkExpressionValueIsNotNull(name4, "Double::class.java.name");
        String name5 = Byte.TYPE.getName();
        Intrinsics.checkExpressionValueIsNotNull(name5, "Byte::class.java.name");
        String name6 = Short.TYPE.getName();
        Intrinsics.checkExpressionValueIsNotNull(name6, "Short::class.java.name");
        String name7 = Integer.TYPE.getName();
        Intrinsics.checkExpressionValueIsNotNull(name7, "Int::class.java.name");
        String name8 = Long.TYPE.getName();
        Intrinsics.checkExpressionValueIsNotNull(name8, "Long::class.java.name");
        f4630k = SetsKt.setOf(name, name2, name3, name4, name5, name6, name7, name8);
    }
}
