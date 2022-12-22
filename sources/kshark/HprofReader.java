package kshark;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.TypeCastException;
import kotlin.UShort;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.C21490Reflection;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.DoubleCompanionObject;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlin.text.Charsets;
import kshark.GcRoot;
import kshark.HprofRecord;
import kshark.ValueHolder;
import okio.BufferedSource;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000ê\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010$\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0018\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\f\n\u0000\n\u0002\u0010\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0013\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\n\n\u0000\n\u0002\u0010\u0017\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 c2\u00020\u0001:\u0001cB\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u0014\u001a\u00020\u0015H\u0002J\b\u0010\u0016\u001a\u00020\u0015H\u0002J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0005H\u0002J\b\u0010\u001a\u001a\u00020\u001bH\u0002J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0005H\u0002J\b\u0010\u001f\u001a\u00020 H\u0002J\u0010\u0010!\u001a\u00020\"2\u0006\u0010\u0019\u001a\u00020\u0005H\u0002J\u0006\u0010#\u001a\u00020$J\u0006\u0010%\u001a\u00020&J\b\u0010'\u001a\u00020(H\u0002J\u0010\u0010)\u001a\u00020*2\u0006\u0010\u0019\u001a\u00020\u0005H\u0002J\b\u0010+\u001a\u00020,H\u0002J\u0010\u0010-\u001a\u00020.2\u0006\u0010\u0019\u001a\u00020\u0005H\u0002J\b\u0010/\u001a\u000200H\u0002J$\u00101\u001a\u0002022\u0014\u00103\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020605042\u0006\u00107\u001a\u000208J\b\u00109\u001a\u00020\u0007H\u0002J\u0010\u0010:\u001a\u00020;2\u0006\u0010\u0019\u001a\u00020\u0005H\u0002J\u0006\u0010<\u001a\u00020=J\u0006\u0010>\u001a\u00020?J\b\u0010@\u001a\u00020\u0005H\u0002J\u0010\u0010A\u001a\u00020B2\u0006\u0010\u0019\u001a\u00020\u0005H\u0002J\b\u0010C\u001a\u00020\u0007H\u0002J\u0010\u0010D\u001a\u00020;2\u0006\u0010\u0019\u001a\u00020\u0005H\u0002J\u0006\u0010E\u001a\u00020FJ\u0006\u0010G\u001a\u00020HJ\u0006\u0010I\u001a\u00020JJ\u0006\u0010K\u001a\u00020LJ\b\u0010M\u001a\u00020NH\u0002J\u0010\u0010O\u001a\u00020P2\u0006\u0010\u0019\u001a\u00020\u0005H\u0002J\u0018\u0010Q\u001a\u00020R2\u0006\u0010\u001e\u001a\u00020\u00052\u0006\u0010S\u001a\u00020TH\u0002J\b\u0010U\u001a\u00020\u0005H\u0002J\b\u0010V\u001a\u00020\u0007H\u0002J\b\u0010W\u001a\u00020\u0005H\u0002J\u0010\u0010X\u001a\u00020R2\u0006\u0010\u001e\u001a\u00020\u0007H\u0002J\u000e\u0010Y\u001a\u00020Z2\u0006\u0010[\u001a\u00020\u0005J\u0010\u0010\\\u001a\u0002022\u0006\u0010\u001e\u001a\u00020\u0005H\u0002J\u0010\u0010\\\u001a\u0002022\u0006\u0010\u001e\u001a\u00020\u0007H\u0002J\b\u0010]\u001a\u000202H\u0002J\b\u0010^\u001a\u000202H\u0002J\b\u0010_\u001a\u000202H\u0002J\b\u0010`\u001a\u000202H\u0002J\b\u0010a\u001a\u000202H\u0002J\u0010\u0010b\u001a\u00020\u00052\u0006\u0010[\u001a\u00020\u0005H\u0002R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR$\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0007@@X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u001a\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0013X\u0004¢\u0006\u0002\n\u0000¨\u0006d"}, mo175978d2 = {"Lkshark/HprofReader;", "", "source", "Lokio/BufferedSource;", "identifierByteSize", "", "startPosition", "", "(Lokio/BufferedSource;IJ)V", "getIdentifierByteSize", "()I", "<set-?>", "position", "getPosition", "()J", "setPosition$shark", "(J)V", "getStartPosition", "typeSizes", "", "exhausted", "", "readBoolean", "readBooleanArray", "", "arrayLength", "readByte", "", "readByteArray", "", "byteCount", "readChar", "", "readCharArray", "", "readClassDumpRecord", "Lkshark/HprofRecord$HeapDumpRecord$ObjectRecord$ClassDumpRecord;", "readClassSkipContentRecord", "Lkshark/HprofRecord$HeapDumpRecord$ObjectRecord$ClassSkipContentRecord;", "readDouble", "", "readDoubleArray", "", "readFloat", "", "readFloatArray", "", "readHeapDumpInfoRecord", "Lkshark/HprofRecord$HeapDumpRecord$HeapDumpInfoRecord;", "readHprofRecords", "", "recordTypes", "", "Lkotlin/reflect/KClass;", "Lkshark/HprofRecord;", "listener", "Lkshark/OnHprofRecordListener;", "readId", "readIdArray", "", "readInstanceDumpRecord", "Lkshark/HprofRecord$HeapDumpRecord$ObjectRecord$InstanceDumpRecord;", "readInstanceSkipContentRecord", "Lkshark/HprofRecord$HeapDumpRecord$ObjectRecord$InstanceSkipContentRecord;", "readInt", "readIntArray", "", "readLong", "readLongArray", "readObjectArrayDumpRecord", "Lkshark/HprofRecord$HeapDumpRecord$ObjectRecord$ObjectArrayDumpRecord;", "readObjectArraySkipContentRecord", "Lkshark/HprofRecord$HeapDumpRecord$ObjectRecord$ObjectArraySkipContentRecord;", "readPrimitiveArrayDumpRecord", "Lkshark/HprofRecord$HeapDumpRecord$ObjectRecord$PrimitiveArrayDumpRecord;", "readPrimitiveArraySkipContentRecord", "Lkshark/HprofRecord$HeapDumpRecord$ObjectRecord$PrimitiveArraySkipContentRecord;", "readShort", "", "readShortArray", "", "readString", "", "charset", "Ljava/nio/charset/Charset;", "readUnsignedByte", "readUnsignedInt", "readUnsignedShort", "readUtf8", "readValue", "Lkshark/ValueHolder;", "type", "skip", "skipClassDumpRecord", "skipHeapDumpInfoRecord", "skipInstanceDumpRecord", "skipObjectArrayDumpRecord", "skipPrimitiveArrayDumpRecord", "typeSize", "Companion", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
/* compiled from: HprofReader.kt */
public final class HprofReader {
    public static final int ALLOC_SITES = 6;
    public static final int CLASS_DUMP = 32;
    public static final int CONTROL_SETTINGS = 14;
    public static final int CPU_SAMPLES = 13;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int END_THREAD = 11;
    public static final int HEAP_DUMP = 12;
    public static final int HEAP_DUMP_END = 44;
    public static final int HEAP_DUMP_INFO = 254;
    public static final int HEAP_DUMP_SEGMENT = 28;
    public static final int HEAP_SUMMARY = 7;
    public static final int INSTANCE_DUMP = 33;
    public static final int LOAD_CLASS = 2;
    public static final int OBJECT_ARRAY_DUMP = 34;
    public static final int PRIMITIVE_ARRAY_DUMP = 35;
    public static final int PRIMITIVE_ARRAY_NODATA = 195;
    public static final int ROOT_DEBUGGER = 139;
    public static final int ROOT_FINALIZING = 138;
    public static final int ROOT_INTERNED_STRING = 137;
    public static final int ROOT_JAVA_FRAME = 3;
    public static final int ROOT_JNI_GLOBAL = 1;
    public static final int ROOT_JNI_LOCAL = 2;
    public static final int ROOT_JNI_MONITOR = 142;
    public static final int ROOT_MONITOR_USED = 7;
    public static final int ROOT_NATIVE_STACK = 4;
    public static final int ROOT_REFERENCE_CLEANUP = 140;
    public static final int ROOT_STICKY_CLASS = 5;
    public static final int ROOT_THREAD_BLOCK = 6;
    public static final int ROOT_THREAD_OBJECT = 8;
    public static final int ROOT_UNKNOWN = 255;
    public static final int ROOT_UNREACHABLE = 144;
    public static final int ROOT_VM_INTERNAL = 141;
    public static final int STACK_FRAME = 4;
    public static final int STACK_TRACE = 5;
    public static final int START_THREAD = 10;
    public static final int STRING_IN_UTF8 = 1;
    public static final int UNLOAD_CLASS = 3;

    /* renamed from: f */
    private static final int f4553f = PrimitiveType.BOOLEAN.getByteSize();

    /* renamed from: g */
    private static final int f4554g = PrimitiveType.CHAR.getByteSize();

    /* renamed from: h */
    private static final int f4555h = PrimitiveType.FLOAT.getByteSize();

    /* renamed from: i */
    private static final int f4556i = PrimitiveType.DOUBLE.getByteSize();

    /* renamed from: j */
    private static final int f4557j = PrimitiveType.BYTE.getByteSize();

    /* renamed from: k */
    private static final int f4558k = PrimitiveType.SHORT.getByteSize();

    /* renamed from: l */
    private static final int f4559l = PrimitiveType.INT.getByteSize();

    /* renamed from: m */
    private static final int f4560m = PrimitiveType.LONG.getByteSize();

    /* renamed from: n */
    private static final int f4561n = PrimitiveType.BOOLEAN.getHprofType();

    /* renamed from: o */
    private static final int f4562o = PrimitiveType.CHAR.getHprofType();

    /* renamed from: p */
    private static final int f4563p = PrimitiveType.FLOAT.getHprofType();

    /* renamed from: q */
    private static final int f4564q = PrimitiveType.DOUBLE.getHprofType();

    /* renamed from: r */
    private static final int f4565r = PrimitiveType.BYTE.getHprofType();

    /* renamed from: s */
    private static final int f4566s = PrimitiveType.SHORT.getHprofType();

    /* renamed from: t */
    private static final int f4567t = PrimitiveType.INT.getHprofType();

    /* renamed from: u */
    private static final int f4568u = PrimitiveType.LONG.getHprofType();

    /* renamed from: v */
    private static final long f4569v = 4294967295L;

    /* renamed from: w */
    private static final int f4570w = 255;

    /* renamed from: a */
    private long f4571a;

    /* renamed from: b */
    private final Map<Integer, Integer> f4572b;

    /* renamed from: c */
    private BufferedSource f4573c;

    /* renamed from: d */
    private final int f4574d;

    /* renamed from: e */
    private final long f4575e;

    public HprofReader(BufferedSource bufferedSource, int i, long j) {
        Intrinsics.checkParameterIsNotNull(bufferedSource, "source");
        this.f4573c = bufferedSource;
        this.f4574d = i;
        this.f4575e = j;
        this.f4571a = j;
        this.f4572b = MapsKt.plus(PrimitiveType.Companion.getByteSizeByHprofType(), TuplesKt.m42317to(2, Integer.valueOf(this.f4574d)));
    }

    public final int getIdentifierByteSize() {
        return this.f4574d;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ HprofReader(BufferedSource bufferedSource, int i, long j, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(bufferedSource, i, (i2 & 4) != 0 ? 0 : j);
    }

    public final long getStartPosition() {
        return this.f4575e;
    }

    public final long getPosition() {
        return this.f4571a;
    }

    public final void setPosition$shark(long j) {
        this.f4571a = j;
    }

    public final void readHprofRecords(Set<? extends KClass<? extends HprofRecord>> set, OnHprofRecordListener onHprofRecordListener) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        int i;
        long j;
        long j2;
        Set<? extends KClass<? extends HprofRecord>> set2 = set;
        OnHprofRecordListener onHprofRecordListener2 = onHprofRecordListener;
        Intrinsics.checkParameterIsNotNull(set2, "recordTypes");
        Intrinsics.checkParameterIsNotNull(onHprofRecordListener2, "listener");
        boolean contains = set2.contains(C21490Reflection.getOrCreateKotlinClass(HprofRecord.class));
        boolean z6 = contains || set2.contains(C21490Reflection.getOrCreateKotlinClass(HprofRecord.StringRecord.class));
        boolean z7 = contains || set2.contains(C21490Reflection.getOrCreateKotlinClass(HprofRecord.LoadClassRecord.class));
        boolean z8 = contains || set2.contains(C21490Reflection.getOrCreateKotlinClass(HprofRecord.HeapDumpEndRecord.class));
        boolean z9 = contains || set2.contains(C21490Reflection.getOrCreateKotlinClass(HprofRecord.StackFrameRecord.class));
        boolean z10 = contains || set2.contains(C21490Reflection.getOrCreateKotlinClass(HprofRecord.StackTraceRecord.class));
        boolean z11 = contains || set2.contains(C21490Reflection.getOrCreateKotlinClass(HprofRecord.HeapDumpRecord.class));
        boolean z12 = z11 || set2.contains(C21490Reflection.getOrCreateKotlinClass(HprofRecord.HeapDumpRecord.GcRootRecord.class));
        boolean z13 = contains || set2.contains(C21490Reflection.getOrCreateKotlinClass(HprofRecord.HeapDumpRecord.HeapDumpInfoRecord.class));
        boolean z14 = z11 || set2.contains(C21490Reflection.getOrCreateKotlinClass(HprofRecord.HeapDumpRecord.ObjectRecord.class));
        boolean z15 = z14 || set2.contains(C21490Reflection.getOrCreateKotlinClass(HprofRecord.HeapDumpRecord.ObjectRecord.ClassDumpRecord.class));
        boolean contains2 = set2.contains(C21490Reflection.getOrCreateKotlinClass(HprofRecord.HeapDumpRecord.ObjectRecord.ClassSkipContentRecord.class));
        boolean z16 = z14 || set2.contains(C21490Reflection.getOrCreateKotlinClass(HprofRecord.HeapDumpRecord.ObjectRecord.InstanceDumpRecord.class));
        boolean contains3 = set2.contains(C21490Reflection.getOrCreateKotlinClass(HprofRecord.HeapDumpRecord.ObjectRecord.InstanceSkipContentRecord.class));
        boolean z17 = z14 || set2.contains(C21490Reflection.getOrCreateKotlinClass(HprofRecord.HeapDumpRecord.ObjectRecord.ObjectArrayDumpRecord.class));
        boolean z18 = z6;
        boolean contains4 = set2.contains(C21490Reflection.getOrCreateKotlinClass(HprofRecord.HeapDumpRecord.ObjectRecord.ObjectArraySkipContentRecord.class));
        boolean z19 = z14 || set2.contains(C21490Reflection.getOrCreateKotlinClass(HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.class));
        boolean z20 = z7;
        boolean contains5 = set2.contains(C21490Reflection.getOrCreateKotlinClass(HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArraySkipContentRecord.class));
        int byteSize = PrimitiveType.INT.getByteSize();
        while (!m2921d()) {
            boolean z21 = z9;
            int l = m2937l();
            m2936k(byteSize);
            boolean z22 = z15;
            boolean z23 = contains2;
            long k = m2935k();
            boolean z24 = z10;
            if (l == 1) {
                z4 = z13;
                z3 = contains3;
                z5 = z17;
                z2 = contains4;
                z = z8;
                long j3 = k;
                if (z18) {
                    onHprofRecordListener2.onHprofRecord(this.f4571a, new HprofRecord.StringRecord(m2933j(), m2917b(j3 - ((long) this.f4574d))));
                } else {
                    m2915a(j3);
                }
            } else if (l == 2) {
                z4 = z13;
                z3 = contains3;
                z5 = z17;
                z2 = contains4;
                z = z8;
                long j4 = k;
                if (z20) {
                    onHprofRecordListener2.onHprofRecord(this.f4571a, new HprofRecord.LoadClassRecord(m2916b(), m2933j(), m2916b(), m2933j()));
                } else {
                    m2915a(j4);
                }
            } else if (l == 4) {
                z4 = z13;
                z3 = contains3;
                z5 = z17;
                z2 = contains4;
                z = z8;
                long j5 = k;
                if (z21) {
                    onHprofRecordListener2.onHprofRecord(this.f4571a, new HprofRecord.StackFrameRecord(m2933j(), m2933j(), m2933j(), m2933j(), m2916b(), m2916b()));
                } else {
                    m2915a(j5);
                }
            } else if (l == 5) {
                z4 = z13;
                z3 = contains3;
                z5 = z17;
                z2 = contains4;
                z = z8;
                long j6 = k;
                if (z24) {
                    onHprofRecordListener2.onHprofRecord(this.f4571a, new HprofRecord.StackTraceRecord(m2916b(), m2916b(), m2918b(m2916b())));
                } else {
                    m2915a(j6);
                }
            } else if (l == 12 || l == 28) {
                long j7 = this.f4571a;
                z4 = z13;
                z3 = contains3;
                z2 = contains4;
                long j8 = 0;
                int i2 = 0;
                z5 = z17;
                while (true) {
                    long j9 = this.f4571a;
                    z = z8;
                    if (j9 - j7 < k) {
                        int l2 = m2937l();
                        long j10 = j7;
                        if (l2 == 144) {
                            j2 = j9;
                            i = l2;
                            j = k;
                            if (z12) {
                                onHprofRecordListener2.onHprofRecord(this.f4571a, new HprofRecord.HeapDumpRecord.GcRootRecord(new GcRoot.Unreachable(m2933j())));
                            } else {
                                m2936k(this.f4574d);
                            }
                        } else if (l2 == 195) {
                            throw new UnsupportedOperationException("PRIMITIVE_ARRAY_NODATA cannot be parsed");
                        } else if (l2 == 254) {
                            j2 = j9;
                            i = l2;
                            j = k;
                            if (z4) {
                                onHprofRecordListener2.onHprofRecord(this.f4571a, m2943r());
                            } else {
                                m2944s();
                            }
                        } else if (l2 != 255) {
                            switch (l2) {
                                case 1:
                                    j2 = j9;
                                    i = l2;
                                    j = k;
                                    if (!z12) {
                                        int i3 = this.f4574d;
                                        m2936k(i3 + i3);
                                        break;
                                    } else {
                                        onHprofRecordListener2.onHprofRecord(this.f4571a, new HprofRecord.HeapDumpRecord.GcRootRecord(new GcRoot.JniGlobal(m2933j(), m2933j())));
                                        break;
                                    }
                                case 2:
                                    j2 = j9;
                                    i = l2;
                                    j = k;
                                    if (!z12) {
                                        m2936k(this.f4574d + byteSize + byteSize);
                                        break;
                                    } else {
                                        onHprofRecordListener2.onHprofRecord(this.f4571a, new HprofRecord.HeapDumpRecord.GcRootRecord(new GcRoot.JniLocal(m2933j(), m2916b(), m2916b())));
                                        break;
                                    }
                                case 3:
                                    j2 = j9;
                                    i = l2;
                                    j = k;
                                    if (!z12) {
                                        m2936k(this.f4574d + byteSize + byteSize);
                                        break;
                                    } else {
                                        onHprofRecordListener2.onHprofRecord(this.f4571a, new HprofRecord.HeapDumpRecord.GcRootRecord(new GcRoot.JavaFrame(m2933j(), m2916b(), m2916b())));
                                        break;
                                    }
                                case 4:
                                    j2 = j9;
                                    i = l2;
                                    j = k;
                                    if (!z12) {
                                        m2936k(this.f4574d + byteSize);
                                        break;
                                    } else {
                                        onHprofRecordListener2.onHprofRecord(this.f4571a, new HprofRecord.HeapDumpRecord.GcRootRecord(new GcRoot.NativeStack(m2933j(), m2916b())));
                                        break;
                                    }
                                case 5:
                                    j2 = j9;
                                    i = l2;
                                    j = k;
                                    if (!z12) {
                                        m2936k(this.f4574d);
                                        break;
                                    } else {
                                        onHprofRecordListener2.onHprofRecord(this.f4571a, new HprofRecord.HeapDumpRecord.GcRootRecord(new GcRoot.StickyClass(m2933j())));
                                        break;
                                    }
                                case 6:
                                    j2 = j9;
                                    i = l2;
                                    j = k;
                                    if (!z12) {
                                        m2936k(this.f4574d + byteSize);
                                        break;
                                    } else {
                                        onHprofRecordListener2.onHprofRecord(this.f4571a, new HprofRecord.HeapDumpRecord.GcRootRecord(new GcRoot.ThreadBlock(m2933j(), m2916b())));
                                        break;
                                    }
                                case 7:
                                    j2 = j9;
                                    i = l2;
                                    j = k;
                                    if (!z12) {
                                        m2936k(this.f4574d);
                                        break;
                                    } else {
                                        onHprofRecordListener2.onHprofRecord(this.f4571a, new HprofRecord.HeapDumpRecord.GcRootRecord(new GcRoot.MonitorUsed(m2933j())));
                                        break;
                                    }
                                case 8:
                                    j2 = j9;
                                    i = l2;
                                    j = k;
                                    if (!z12) {
                                        m2936k(this.f4574d + byteSize + byteSize);
                                        break;
                                    } else {
                                        onHprofRecordListener2.onHprofRecord(this.f4571a, new HprofRecord.HeapDumpRecord.GcRootRecord(new GcRoot.ThreadObject(m2933j(), m2916b(), m2916b())));
                                        break;
                                    }
                                default:
                                    switch (l2) {
                                        case 32:
                                            j2 = j9;
                                            i = l2;
                                            j = k;
                                            if (!z22) {
                                                if (!z23) {
                                                    m2940o();
                                                    break;
                                                } else {
                                                    onHprofRecordListener2.onHprofRecord(this.f4571a, readClassSkipContentRecord());
                                                    break;
                                                }
                                            } else {
                                                onHprofRecordListener2.onHprofRecord(this.f4571a, readClassDumpRecord());
                                                break;
                                            }
                                        case 33:
                                            j2 = j9;
                                            i = l2;
                                            j = k;
                                            if (!z16) {
                                                if (!z3) {
                                                    m2939n();
                                                    break;
                                                } else {
                                                    onHprofRecordListener2.onHprofRecord(this.f4571a, readInstanceSkipContentRecord());
                                                    break;
                                                }
                                            } else {
                                                onHprofRecordListener2.onHprofRecord(this.f4571a, readInstanceDumpRecord());
                                                break;
                                            }
                                        case 34:
                                            j2 = j9;
                                            i = l2;
                                            j = k;
                                            if (!z5) {
                                                if (!z2) {
                                                    m2941p();
                                                    break;
                                                } else {
                                                    onHprofRecordListener2.onHprofRecord(this.f4571a, readObjectArraySkipContentRecord());
                                                    break;
                                                }
                                            } else {
                                                onHprofRecordListener2.onHprofRecord(this.f4571a, readObjectArrayDumpRecord());
                                                break;
                                            }
                                        case 35:
                                            j2 = j9;
                                            i = l2;
                                            j = k;
                                            if (!z19) {
                                                if (!contains5) {
                                                    m2942q();
                                                    break;
                                                } else {
                                                    onHprofRecordListener2.onHprofRecord(this.f4571a, readPrimitiveArraySkipContentRecord());
                                                    break;
                                                }
                                            } else {
                                                onHprofRecordListener2.onHprofRecord(this.f4571a, readPrimitiveArrayDumpRecord());
                                                break;
                                            }
                                        default:
                                            switch (l2) {
                                                case 137:
                                                    j2 = j9;
                                                    i = l2;
                                                    j = k;
                                                    if (!z12) {
                                                        m2936k(this.f4574d);
                                                        break;
                                                    } else {
                                                        onHprofRecordListener2.onHprofRecord(this.f4571a, new HprofRecord.HeapDumpRecord.GcRootRecord(new GcRoot.InternedString(m2933j())));
                                                        break;
                                                    }
                                                case 138:
                                                    j2 = j9;
                                                    i = l2;
                                                    j = k;
                                                    if (!z12) {
                                                        m2936k(this.f4574d);
                                                        break;
                                                    } else {
                                                        onHprofRecordListener2.onHprofRecord(this.f4571a, new HprofRecord.HeapDumpRecord.GcRootRecord(new GcRoot.Finalizing(m2933j())));
                                                        break;
                                                    }
                                                case 139:
                                                    j2 = j9;
                                                    i = l2;
                                                    j = k;
                                                    if (!z12) {
                                                        m2936k(this.f4574d);
                                                        break;
                                                    } else {
                                                        onHprofRecordListener2.onHprofRecord(this.f4571a, new HprofRecord.HeapDumpRecord.GcRootRecord(new GcRoot.Debugger(m2933j())));
                                                        break;
                                                    }
                                                case 140:
                                                    j2 = j9;
                                                    i = l2;
                                                    j = k;
                                                    if (!z12) {
                                                        m2936k(this.f4574d);
                                                        break;
                                                    } else {
                                                        onHprofRecordListener2.onHprofRecord(this.f4571a, new HprofRecord.HeapDumpRecord.GcRootRecord(new GcRoot.ReferenceCleanup(m2933j())));
                                                        break;
                                                    }
                                                case 141:
                                                    j2 = j9;
                                                    i = l2;
                                                    j = k;
                                                    if (!z12) {
                                                        m2936k(this.f4574d);
                                                        break;
                                                    } else {
                                                        onHprofRecordListener2.onHprofRecord(this.f4571a, new HprofRecord.HeapDumpRecord.GcRootRecord(new GcRoot.VmInternal(m2933j())));
                                                        break;
                                                    }
                                                case 142:
                                                    if (!z12) {
                                                        j2 = j9;
                                                        i = l2;
                                                        j = k;
                                                        m2936k(this.f4574d + byteSize + byteSize);
                                                        break;
                                                    } else {
                                                        j2 = j9;
                                                        i = l2;
                                                        j = k;
                                                        onHprofRecordListener2.onHprofRecord(this.f4571a, new HprofRecord.HeapDumpRecord.GcRootRecord(new GcRoot.JniMonitor(m2933j(), m2916b(), m2916b())));
                                                        break;
                                                    }
                                                default:
                                                    StringBuilder sb = new StringBuilder();
                                                    sb.append("Unknown tag ");
                                                    String format = String.format("0x%02x", Arrays.copyOf(new Object[]{Integer.valueOf(l2)}, 1));
                                                    Intrinsics.checkExpressionValueIsNotNull(format, "java.lang.String.format(this, *args)");
                                                    sb.append(format);
                                                    sb.append(" at ");
                                                    sb.append(j9);
                                                    sb.append(" after ");
                                                    String format2 = String.format("0x%02x", Arrays.copyOf(new Object[]{Integer.valueOf(i2)}, 1));
                                                    Intrinsics.checkExpressionValueIsNotNull(format2, "java.lang.String.format(this, *args)");
                                                    sb.append(format2);
                                                    sb.append(" at ");
                                                    sb.append(j8);
                                                    throw new IllegalStateException(sb.toString());
                                            }
                                    }
                            }
                        } else {
                            j2 = j9;
                            i = l2;
                            j = k;
                            if (z12) {
                                onHprofRecordListener2.onHprofRecord(this.f4571a, new HprofRecord.HeapDumpRecord.GcRootRecord(new GcRoot.Unknown(m2933j())));
                            } else {
                                m2936k(this.f4574d);
                            }
                        }
                        i2 = i;
                        z8 = z;
                        j7 = j10;
                        j8 = j2;
                        k = j;
                    } else {
                        continue;
                    }
                }
            } else {
                if (l != 44) {
                    m2915a(k);
                } else if (z8) {
                    onHprofRecordListener2.onHprofRecord(this.f4571a, HprofRecord.HeapDumpEndRecord.INSTANCE);
                }
                z4 = z13;
                z3 = contains3;
                z5 = z17;
                z2 = contains4;
                z = z8;
            }
            z9 = z21;
            z15 = z22;
            contains2 = z23;
            z10 = z24;
            z17 = z5;
            z13 = z4;
            contains3 = z3;
            contains4 = z2;
            z8 = z;
        }
    }

    public final HprofRecord.HeapDumpRecord.ObjectRecord.InstanceDumpRecord readInstanceDumpRecord() {
        return new HprofRecord.HeapDumpRecord.ObjectRecord.InstanceDumpRecord(m2933j(), m2916b(), m2933j(), m2934j(m2916b()));
    }

    public final HprofRecord.HeapDumpRecord.ObjectRecord.InstanceSkipContentRecord readInstanceSkipContentRecord() {
        long j = m2933j();
        int b = m2916b();
        long j2 = m2933j();
        m2936k(m2916b());
        return new HprofRecord.HeapDumpRecord.ObjectRecord.InstanceSkipContentRecord(j, b, j2);
    }

    public final HprofRecord.HeapDumpRecord.ObjectRecord.ClassDumpRecord readClassDumpRecord() {
        HprofReader hprofReader = this;
        long j = m2933j();
        int b = m2916b();
        long j2 = m2933j();
        long j3 = m2933j();
        long j4 = m2933j();
        long j5 = m2933j();
        m2933j();
        m2933j();
        int b2 = m2916b();
        int m = m2938m();
        for (int i = 0; i < m; i++) {
            hprofReader.m2936k(f4558k);
            hprofReader.m2936k(hprofReader.m2912a(m2937l()));
        }
        int m2 = m2938m();
        ArrayList arrayList = new ArrayList(m2);
        int i2 = 0;
        while (i2 < m2) {
            long j6 = j5;
            long j7 = m2933j();
            int i3 = m2;
            int l = m2937l();
            arrayList.add(new HprofRecord.HeapDumpRecord.ObjectRecord.ClassDumpRecord.StaticFieldRecord(j7, l, hprofReader.readValue(l)));
            i2++;
            hprofReader = this;
            j5 = j6;
            m2 = i3;
            b2 = b2;
        }
        long j8 = j5;
        int i4 = b2;
        int m3 = m2938m();
        ArrayList arrayList2 = new ArrayList(m3);
        int i5 = 0;
        while (i5 < m3) {
            arrayList2.add(new HprofRecord.HeapDumpRecord.ObjectRecord.ClassDumpRecord.FieldRecord(m2933j(), m2937l()));
            i5++;
            j4 = j4;
        }
        long j9 = j4;
        return new HprofRecord.HeapDumpRecord.ObjectRecord.ClassDumpRecord(j, b, j2, j3, j4, j8, i4, arrayList, arrayList2);
    }

    public final HprofRecord.HeapDumpRecord.ObjectRecord.ClassSkipContentRecord readClassSkipContentRecord() {
        int i;
        long j = m2933j();
        int b = m2916b();
        long j2 = m2933j();
        long j3 = m2933j();
        long j4 = m2933j();
        long j5 = m2933j();
        m2933j();
        m2933j();
        int b2 = m2916b();
        int m = m2938m();
        for (int i2 = 0; i2 < m; i2++) {
            m2936k(f4558k);
            m2936k(m2912a(m2937l()));
        }
        int m2 = m2938m();
        int i3 = 0;
        while (i3 < m2) {
            m2936k(this.f4574d);
            int l = m2937l();
            int i4 = m2;
            if (l == 2) {
                i = this.f4574d;
            } else {
                i = ((Number) MapsKt.getValue(PrimitiveType.Companion.getByteSizeByHprofType(), Integer.valueOf(l))).intValue();
            }
            m2936k(i);
            i3++;
            m2 = i4;
        }
        int i5 = m2;
        int m3 = m2938m();
        m2936k((this.f4574d + 1) * m3);
        return new HprofRecord.HeapDumpRecord.ObjectRecord.ClassSkipContentRecord(j, b, j2, j3, j4, j5, b2, m2, m3);
    }

    public final HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord readPrimitiveArrayDumpRecord() {
        long j = m2933j();
        int b = m2916b();
        int b2 = m2916b();
        int l = m2937l();
        if (l == f4561n) {
            return new HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.BooleanArrayDump(j, b, m2920c(b2));
        }
        if (l == f4562o) {
            return new HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.CharArrayDump(j, b, m2922d(b2));
        }
        if (l == f4563p) {
            return new HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.FloatArrayDump(j, b, m2924e(b2));
        }
        if (l == f4564q) {
            return new HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.DoubleArrayDump(j, b, m2926f(b2));
        }
        if (l == f4565r) {
            return new HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.ByteArrayDump(j, b, m2934j(b2));
        }
        if (l == f4566s) {
            return new HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.ShortArrayDump(j, b, m2928g(b2));
        }
        if (l == f4567t) {
            return new HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.IntArrayDump(j, b, m2930h(b2));
        }
        if (l == f4568u) {
            return new HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.LongArrayDump(j, b, m2932i(b2));
        }
        throw new IllegalStateException("Unexpected type " + l);
    }

    public final HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArraySkipContentRecord readPrimitiveArraySkipContentRecord() {
        long j = m2933j();
        int b = m2916b();
        int b2 = m2916b();
        PrimitiveType primitiveType = (PrimitiveType) MapsKt.getValue(PrimitiveType.Companion.getPrimitiveTypeByHprofType(), Integer.valueOf(m2937l()));
        m2936k(primitiveType.getByteSize() * b2);
        return new HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArraySkipContentRecord(j, b, b2, primitiveType);
    }

    public final HprofRecord.HeapDumpRecord.ObjectRecord.ObjectArrayDumpRecord readObjectArrayDumpRecord() {
        long j = m2933j();
        int b = m2916b();
        int b2 = m2916b();
        return new HprofRecord.HeapDumpRecord.ObjectRecord.ObjectArrayDumpRecord(j, b, m2933j(), m2918b(b2), b2);
    }

    public final HprofRecord.HeapDumpRecord.ObjectRecord.ObjectArraySkipContentRecord readObjectArraySkipContentRecord() {
        long j = m2933j();
        int b = m2916b();
        int b2 = m2916b();
        long j2 = m2933j();
        m2936k(this.f4574d * b2);
        return new HprofRecord.HeapDumpRecord.ObjectRecord.ObjectArraySkipContentRecord(j, b, j2, b2);
    }

    public final ValueHolder readValue(int i) {
        if (i == 2) {
            return new ValueHolder.ReferenceHolder(m2933j());
        }
        if (i == f4561n) {
            return new ValueHolder.BooleanHolder(m2925f());
        }
        if (i == f4562o) {
            return new ValueHolder.CharHolder(m2927g());
        }
        if (i == f4563p) {
            return new ValueHolder.FloatHolder(m2929h());
        }
        if (i == f4564q) {
            return new ValueHolder.DoubleHolder(m2931i());
        }
        if (i == f4565r) {
            return new ValueHolder.ByteHolder(m2923e());
        }
        if (i == f4566s) {
            return new ValueHolder.ShortHolder(m2914a());
        }
        if (i == f4567t) {
            return new ValueHolder.IntHolder(m2916b());
        }
        if (i == f4568u) {
            return new ValueHolder.LongHolder(m2919c());
        }
        throw new IllegalStateException("Unknown type " + i);
    }

    /* renamed from: a */
    private final int m2912a(int i) {
        return ((Number) MapsKt.getValue(this.f4572b, Integer.valueOf(i))).intValue();
    }

    /* renamed from: a */
    private final short m2914a() {
        this.f4571a += (long) f4558k;
        return this.f4573c.readShort();
    }

    /* renamed from: b */
    private final int m2916b() {
        this.f4571a += (long) f4559l;
        return this.f4573c.readInt();
    }

    /* renamed from: b */
    private final long[] m2918b(int i) {
        long[] jArr = new long[i];
        for (int i2 = 0; i2 < i; i2++) {
            jArr[i2] = m2933j();
        }
        return jArr;
    }

    /* renamed from: c */
    private final boolean[] m2920c(int i) {
        boolean[] zArr = new boolean[i];
        for (int i2 = 0; i2 < i; i2++) {
            zArr[i2] = m2923e() != 0;
        }
        return zArr;
    }

    /* renamed from: d */
    private final char[] m2922d(int i) {
        String a = m2913a(f4554g * i, Charsets.UTF_16BE);
        if (a != null) {
            char[] charArray = a.toCharArray();
            Intrinsics.checkExpressionValueIsNotNull(charArray, "(this as java.lang.String).toCharArray()");
            return charArray;
        }
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    }

    /* renamed from: a */
    private final String m2913a(int i, Charset charset) {
        long j = (long) i;
        this.f4571a += j;
        String readString = this.f4573c.readString(j, charset);
        Intrinsics.checkExpressionValueIsNotNull(readString, "source.readString(byteCount.toLong(), charset)");
        return readString;
    }

    /* renamed from: e */
    private final float[] m2924e(int i) {
        float[] fArr = new float[i];
        for (int i2 = 0; i2 < i; i2++) {
            fArr[i2] = m2929h();
        }
        return fArr;
    }

    /* renamed from: f */
    private final double[] m2926f(int i) {
        double[] dArr = new double[i];
        for (int i2 = 0; i2 < i; i2++) {
            dArr[i2] = m2931i();
        }
        return dArr;
    }

    /* renamed from: g */
    private final short[] m2928g(int i) {
        short[] sArr = new short[i];
        for (int i2 = 0; i2 < i; i2++) {
            sArr[i2] = m2914a();
        }
        return sArr;
    }

    /* renamed from: h */
    private final int[] m2930h(int i) {
        int[] iArr = new int[i];
        for (int i2 = 0; i2 < i; i2++) {
            iArr[i2] = m2916b();
        }
        return iArr;
    }

    /* renamed from: i */
    private final long[] m2932i(int i) {
        long[] jArr = new long[i];
        for (int i2 = 0; i2 < i; i2++) {
            jArr[i2] = m2919c();
        }
        return jArr;
    }

    /* renamed from: c */
    private final long m2919c() {
        this.f4571a += (long) f4560m;
        return this.f4573c.readLong();
    }

    /* renamed from: d */
    private final boolean m2921d() {
        return this.f4573c.exhausted();
    }

    /* renamed from: a */
    private final void m2915a(long j) {
        this.f4571a += j;
        this.f4573c.skip(j);
    }

    /* renamed from: e */
    private final byte m2923e() {
        this.f4571a += (long) f4557j;
        return this.f4573c.readByte();
    }

    /* renamed from: f */
    private final boolean m2925f() {
        this.f4571a += (long) f4553f;
        return this.f4573c.readByte() != 0;
    }

    /* renamed from: j */
    private final byte[] m2934j(int i) {
        long j = (long) i;
        this.f4571a += j;
        byte[] readByteArray = this.f4573c.readByteArray(j);
        Intrinsics.checkExpressionValueIsNotNull(readByteArray, "source.readByteArray(byteCount.toLong())");
        return readByteArray;
    }

    /* renamed from: g */
    private final char m2927g() {
        return m2913a(f4554g, Charsets.UTF_16BE).charAt(0);
    }

    /* renamed from: h */
    private final float m2929h() {
        FloatCompanionObject floatCompanionObject = FloatCompanionObject.INSTANCE;
        return Float.intBitsToFloat(m2916b());
    }

    /* renamed from: i */
    private final double m2931i() {
        DoubleCompanionObject doubleCompanionObject = DoubleCompanionObject.INSTANCE;
        return Double.longBitsToDouble(m2919c());
    }

    /* renamed from: j */
    private final long m2933j() {
        int i;
        int i2 = this.f4574d;
        if (i2 == 1) {
            i = m2923e();
        } else if (i2 == 2) {
            i = m2914a();
        } else if (i2 == 4) {
            i = m2916b();
        } else if (i2 == 8) {
            return m2919c();
        } else {
            throw new IllegalArgumentException("ID Length must be 1, 2, 4, or 8");
        }
        return (long) i;
    }

    /* renamed from: b */
    private final String m2917b(long j) {
        this.f4571a += j;
        String readUtf8 = this.f4573c.readUtf8(j);
        Intrinsics.checkExpressionValueIsNotNull(readUtf8, "source.readUtf8(byteCount)");
        return readUtf8;
    }

    /* renamed from: k */
    private final long m2935k() {
        return ((long) m2916b()) & 4294967295L;
    }

    /* renamed from: l */
    private final int m2937l() {
        return m2923e() & 255;
    }

    /* renamed from: m */
    private final int m2938m() {
        return m2914a() & UShort.MAX_VALUE;
    }

    /* renamed from: k */
    private final void m2936k(int i) {
        long j = (long) i;
        this.f4571a += j;
        this.f4573c.skip(j);
    }

    /* renamed from: n */
    private final void m2939n() {
        int i = this.f4574d;
        m2936k(f4559l + i + i);
        m2936k(m2916b());
    }

    /* renamed from: o */
    private final void m2940o() {
        int i = this.f4574d;
        int i2 = f4559l;
        m2936k(i + i2 + i + i + i + i + i + i + i2);
        int m = m2938m();
        for (int i3 = 0; i3 < m; i3++) {
            m2936k(f4558k);
            m2936k(m2912a(m2937l()));
        }
        int m2 = m2938m();
        for (int i4 = 0; i4 < m2; i4++) {
            m2936k(this.f4574d);
            m2936k(m2912a(m2937l()));
        }
        m2936k(m2938m() * (this.f4574d + f4557j));
    }

    /* renamed from: p */
    private final void m2941p() {
        m2936k(this.f4574d + f4559l);
        int b = m2916b();
        int i = this.f4574d;
        m2936k(i + (b * i));
    }

    /* renamed from: q */
    private final void m2942q() {
        m2936k(this.f4574d + f4559l);
        m2936k(m2916b() * m2912a(m2937l()));
    }

    /* renamed from: r */
    private final HprofRecord.HeapDumpRecord.HeapDumpInfoRecord m2943r() {
        return new HprofRecord.HeapDumpRecord.HeapDumpInfoRecord(m2916b(), m2933j());
    }

    /* renamed from: s */
    private final void m2944s() {
        int i = this.f4574d;
        m2936k(i + i);
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0016\n\u0002\u0010\t\n\u0002\b \b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bXT¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006;"}, mo175978d2 = {"Lkshark/HprofReader$Companion;", "", "()V", "ALLOC_SITES", "", "BOOLEAN_SIZE", "BOOLEAN_TYPE", "BYTE_MASK", "BYTE_SIZE", "BYTE_TYPE", "CHAR_SIZE", "CHAR_TYPE", "CLASS_DUMP", "CONTROL_SETTINGS", "CPU_SAMPLES", "DOUBLE_SIZE", "DOUBLE_TYPE", "END_THREAD", "FLOAT_SIZE", "FLOAT_TYPE", "HEAP_DUMP", "HEAP_DUMP_END", "HEAP_DUMP_INFO", "HEAP_DUMP_SEGMENT", "HEAP_SUMMARY", "INSTANCE_DUMP", "INT_MASK", "", "INT_SIZE", "INT_TYPE", "LOAD_CLASS", "LONG_SIZE", "LONG_TYPE", "OBJECT_ARRAY_DUMP", "PRIMITIVE_ARRAY_DUMP", "PRIMITIVE_ARRAY_NODATA", "ROOT_DEBUGGER", "ROOT_FINALIZING", "ROOT_INTERNED_STRING", "ROOT_JAVA_FRAME", "ROOT_JNI_GLOBAL", "ROOT_JNI_LOCAL", "ROOT_JNI_MONITOR", "ROOT_MONITOR_USED", "ROOT_NATIVE_STACK", "ROOT_REFERENCE_CLEANUP", "ROOT_STICKY_CLASS", "ROOT_THREAD_BLOCK", "ROOT_THREAD_OBJECT", "ROOT_UNKNOWN", "ROOT_UNREACHABLE", "ROOT_VM_INTERNAL", "SHORT_SIZE", "SHORT_TYPE", "STACK_FRAME", "STACK_TRACE", "START_THREAD", "STRING_IN_UTF8", "UNLOAD_CLASS", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
    /* compiled from: HprofReader.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
