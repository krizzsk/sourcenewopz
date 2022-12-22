package kshark.internal;

import com.didichuxing.mlcp.drtc.consts.SDKConsts;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kshark.HprofRecord;
import kshark.PrimitiveType;
import kshark.ValueHolder;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\b\u001a\u00020\tH\u0002J\b\u0010\n\u001a\u00020\u000bH\u0002J\b\u0010\f\u001a\u00020\u000bH\u0002J\b\u0010\r\u001a\u00020\u000bH\u0002J\b\u0010\u000e\u001a\u00020\u000bH\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0002J\b\u0010\u0011\u001a\u00020\u0005H\u0002J\b\u0010\u0012\u001a\u00020\u0010H\u0002J\b\u0010\u0013\u001a\u00020\u000bH\u0002J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u0017R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, mo175978d2 = {"Lkshark/internal/FieldValuesReader;", "", "record", "Lkshark/HprofRecord$HeapDumpRecord$ObjectRecord$InstanceDumpRecord;", "identifierByteSize", "", "(Lkshark/HprofRecord$HeapDumpRecord$ObjectRecord$InstanceDumpRecord;I)V", "position", "readBoolean", "", "readByte", "", "readChar", "readDouble", "readFloat", "readId", "", "readInt", "readLong", "readShort", "readValue", "Lkshark/ValueHolder;", "field", "Lkshark/HprofRecord$HeapDumpRecord$ObjectRecord$ClassDumpRecord$FieldRecord;", "Companion", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
/* compiled from: FieldValuesReader.kt */
public final class FieldValuesReader {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: d */
    private static final int f4619d = PrimitiveType.BOOLEAN.getHprofType();

    /* renamed from: e */
    private static final int f4620e = PrimitiveType.CHAR.getHprofType();

    /* renamed from: f */
    private static final int f4621f = PrimitiveType.FLOAT.getHprofType();

    /* renamed from: g */
    private static final int f4622g = PrimitiveType.DOUBLE.getHprofType();

    /* renamed from: h */
    private static final int f4623h = PrimitiveType.BYTE.getHprofType();

    /* renamed from: i */
    private static final int f4624i = PrimitiveType.SHORT.getHprofType();

    /* renamed from: j */
    private static final int f4625j = PrimitiveType.INT.getHprofType();

    /* renamed from: k */
    private static final int f4626k = PrimitiveType.LONG.getHprofType();

    /* renamed from: a */
    private int f4627a;

    /* renamed from: b */
    private final HprofRecord.HeapDumpRecord.ObjectRecord.InstanceDumpRecord f4628b;

    /* renamed from: c */
    private final int f4629c;

    public FieldValuesReader(HprofRecord.HeapDumpRecord.ObjectRecord.InstanceDumpRecord instanceDumpRecord, int i) {
        Intrinsics.checkParameterIsNotNull(instanceDumpRecord, SDKConsts.TAG_KEY_RECORD);
        this.f4628b = instanceDumpRecord;
        this.f4629c = i;
    }

    public final ValueHolder readValue(HprofRecord.HeapDumpRecord.ObjectRecord.ClassDumpRecord.FieldRecord fieldRecord) {
        Intrinsics.checkParameterIsNotNull(fieldRecord, "field");
        int type = fieldRecord.getType();
        if (type == 2) {
            return new ValueHolder.ReferenceHolder(m2970a());
        }
        if (type == f4619d) {
            return new ValueHolder.BooleanHolder(m2971b());
        }
        if (type == f4620e) {
            m2978i();
            return null;
        } else if (type == f4621f) {
            m2976g();
            return null;
        } else if (type == f4622g) {
            m2977h();
            return null;
        } else if (type == f4623h) {
            m2972c();
            return null;
        } else if (type == f4624i) {
            m2974e();
            return null;
        } else if (type == f4625j) {
            return new ValueHolder.IntHolder(m2973d());
        } else {
            if (type == f4626k) {
                return new ValueHolder.LongHolder(m2975f());
            }
            throw new IllegalStateException("Unknown type " + fieldRecord.getType());
        }
    }

    /* renamed from: a */
    private final long m2970a() {
        int i = this.f4629c;
        if (i == 4) {
            return (long) m2973d();
        }
        if (i == 8) {
            return m2975f();
        }
        throw new IllegalArgumentException("ID Length must be 1, 2, 4, or 8");
    }

    /* renamed from: b */
    private final boolean m2971b() {
        byte[] fieldValues = this.f4628b.getFieldValues();
        int i = this.f4627a;
        byte b = fieldValues[i];
        this.f4627a = i + 1;
        if (b != ((byte) 0)) {
            return true;
        }
        return false;
    }

    /* renamed from: c */
    private final void m2972c() {
        this.f4627a++;
    }

    /* renamed from: d */
    private final int m2973d() {
        int readInt = ByteSubArrayKt.readInt(this.f4628b.getFieldValues(), this.f4627a);
        this.f4627a += 4;
        return readInt;
    }

    /* renamed from: e */
    private final void m2974e() {
        this.f4627a += 2;
    }

    /* renamed from: f */
    private final long m2975f() {
        long readLong = ByteSubArrayKt.readLong(this.f4628b.getFieldValues(), this.f4627a);
        this.f4627a += 8;
        return readLong;
    }

    /* renamed from: g */
    private final void m2976g() {
        this.f4627a += 4;
    }

    /* renamed from: h */
    private final void m2977h() {
        this.f4627a += 8;
    }

    /* renamed from: i */
    private final void m2978i() {
        this.f4627a += 2;
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, mo175978d2 = {"Lkshark/internal/FieldValuesReader$Companion;", "", "()V", "BOOLEAN_TYPE", "", "BYTE_TYPE", "CHAR_TYPE", "DOUBLE_TYPE", "FLOAT_TYPE", "INT_TYPE", "LONG_TYPE", "SHORT_TYPE", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
    /* compiled from: FieldValuesReader.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
