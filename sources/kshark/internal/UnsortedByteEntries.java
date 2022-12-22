package kshark.internal;

import com.google.common.base.Ascii;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kshark.internal.aosp.ByteArrayTimSort;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0005\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001:\u0001!B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0012\u0010\u0012\u001a\u00060\u0010R\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u0014J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0003H\u0002J\u0006\u0010\u0018\u001a\u00020\u0019J\u0018\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u0003H\u0002J\u0018\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u0003H\u0002J\u0015\u0010\u001e\u001a\u00020\u0003*\u00020\u001f2\u0006\u0010 \u001a\u00020\u0003H\fJ\u0015\u0010\u001e\u001a\u00020\u0014*\u00020\u001f2\u0006\u0010 \u001a\u00020\u0014H\fR\u000e\u0010\n\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u000f\u001a\u00060\u0010R\u00020\u0000X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, mo175978d2 = {"Lkshark/internal/UnsortedByteEntries;", "", "bytesPerValue", "", "longIdentifiers", "", "initialCapacity", "growthFactor", "", "(IZID)V", "assigned", "bytesPerEntry", "currentCapacity", "entries", "", "subArray", "Lkshark/internal/UnsortedByteEntries$MutableByteSubArray;", "subArrayIndex", "append", "key", "", "growEntries", "", "newCapacity", "moveToSortedMap", "Lkshark/internal/SortedBytesMap;", "readInt", "array", "index", "readLong", "and", "", "other", "MutableByteSubArray", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
/* compiled from: UnsortedByteEntries.kt */
public final class UnsortedByteEntries {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final int f4670a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public byte[] f4671b;

    /* renamed from: c */
    private final MutableByteSubArray f4672c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public int f4673d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public int f4674e;

    /* renamed from: f */
    private int f4675f;

    /* renamed from: g */
    private final int f4676g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public final boolean f4677h;

    /* renamed from: i */
    private final int f4678i;

    /* renamed from: j */
    private final double f4679j;

    /* renamed from: a */
    private final int m2999a(byte b, int i) {
        return b & i;
    }

    /* renamed from: a */
    private final long m3001a(byte b, long j) {
        return ((long) b) & j;
    }

    public UnsortedByteEntries(int i, boolean z, int i2, double d) {
        this.f4676g = i;
        this.f4677h = z;
        this.f4678i = i2;
        this.f4679j = d;
        this.f4670a = i + (z ? 8 : 4);
        this.f4672c = new MutableByteSubArray();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ UnsortedByteEntries(int i, boolean z, int i2, double d, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, z, (i3 & 4) != 0 ? 4 : i2, (i3 & 8) != 0 ? 2.0d : d);
    }

    public final MutableByteSubArray append(long j) {
        if (this.f4671b == null) {
            int i = this.f4678i;
            this.f4675f = i;
            this.f4671b = new byte[(i * this.f4670a)];
        } else {
            int i2 = this.f4675f;
            if (i2 == this.f4674e) {
                int i3 = (int) (((double) i2) * this.f4679j);
                m3002a(i3);
                this.f4675f = i3;
            }
        }
        this.f4674e++;
        this.f4673d = 0;
        this.f4672c.writeId(j);
        return this.f4672c;
    }

    public final SortedBytesMap moveToSortedMap() {
        if (this.f4674e == 0) {
            return new SortedBytesMap(this.f4677h, this.f4676g, new byte[0]);
        }
        byte[] bArr = this.f4671b;
        if (bArr == null) {
            Intrinsics.throwNpe();
        }
        ByteArrayTimSort.Companion.sort(bArr, 0, this.f4674e, this.f4670a, new UnsortedByteEntries$moveToSortedMap$1(this));
        int length = bArr.length;
        int i = this.f4674e;
        int i2 = this.f4670a;
        if (length > i * i2) {
            bArr = Arrays.copyOf(bArr, i * i2);
            Intrinsics.checkExpressionValueIsNotNull(bArr, "java.util.Arrays.copyOf(this, newSize)");
        }
        this.f4671b = null;
        this.f4674e = 0;
        return new SortedBytesMap(this.f4677h, this.f4676g, bArr);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final int m3000a(byte[] bArr, int i) {
        int i2 = i + 1;
        int i3 = i2 + 1;
        byte b = ((bArr[i] & 255) << Ascii.CAN) | ((bArr[i2] & 255) << 16);
        return (bArr[i3 + 1] & 255) | b | ((bArr[i3] & 255) << 8);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public final long m3003b(byte[] bArr, int i) {
        int i2 = i + 1;
        int i3 = i2 + 1;
        int i4 = i3 + 1;
        int i5 = i4 + 1;
        int i6 = i5 + 1;
        int i7 = i6 + 1;
        return (((long) bArr[i7 + 1]) & 255) | ((((long) bArr[i]) & 255) << 56) | ((((long) bArr[i2]) & 255) << 48) | ((((long) bArr[i3]) & 255) << 40) | ((((long) bArr[i4]) & 255) << 32) | ((((long) bArr[i5]) & 255) << 24) | ((((long) bArr[i6]) & 255) << 16) | ((((long) bArr[i7]) & 255) << 8);
    }

    /* renamed from: a */
    private final void m3002a(int i) {
        int i2 = this.f4670a;
        byte[] bArr = new byte[(i * i2)];
        System.arraycopy(this.f4671b, 0, bArr, 0, this.f4674e * i2);
        this.f4671b = bArr;
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\bJ\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\nJ\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\bJ\u0016\u0010\f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\n¨\u0006\u000e"}, mo175978d2 = {"Lkshark/internal/UnsortedByteEntries$MutableByteSubArray;", "", "(Lkshark/internal/UnsortedByteEntries;)V", "writeByte", "", "value", "", "writeId", "", "writeInt", "", "writeLong", "writeTruncatedLong", "byteCount", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
    /* compiled from: UnsortedByteEntries.kt */
    public final class MutableByteSubArray {
        public MutableByteSubArray() {
        }

        public final void writeByte(byte b) {
            int access$getSubArrayIndex$p = UnsortedByteEntries.this.f4673d;
            UnsortedByteEntries unsortedByteEntries = UnsortedByteEntries.this;
            unsortedByteEntries.f4673d = unsortedByteEntries.f4673d + 1;
            if (access$getSubArrayIndex$p >= 0 && UnsortedByteEntries.this.f4670a >= access$getSubArrayIndex$p) {
                int access$getAssigned$p = ((UnsortedByteEntries.this.f4674e - 1) * UnsortedByteEntries.this.f4670a) + access$getSubArrayIndex$p;
                byte[] access$getEntries$p = UnsortedByteEntries.this.f4671b;
                if (access$getEntries$p == null) {
                    Intrinsics.throwNpe();
                }
                access$getEntries$p[access$getAssigned$p] = b;
                return;
            }
            throw new IllegalArgumentException(("Index " + access$getSubArrayIndex$p + " should be between 0 and " + UnsortedByteEntries.this.f4670a).toString());
        }

        public final void writeId(long j) {
            if (UnsortedByteEntries.this.f4677h) {
                writeLong(j);
            } else {
                writeInt((int) j);
            }
        }

        public final void writeInt(int i) {
            int access$getSubArrayIndex$p = UnsortedByteEntries.this.f4673d;
            UnsortedByteEntries unsortedByteEntries = UnsortedByteEntries.this;
            unsortedByteEntries.f4673d = unsortedByteEntries.f4673d + 4;
            if (access$getSubArrayIndex$p >= 0 && access$getSubArrayIndex$p <= UnsortedByteEntries.this.f4670a + -4) {
                int access$getAssigned$p = ((UnsortedByteEntries.this.f4674e - 1) * UnsortedByteEntries.this.f4670a) + access$getSubArrayIndex$p;
                byte[] access$getEntries$p = UnsortedByteEntries.this.f4671b;
                if (access$getEntries$p == null) {
                    Intrinsics.throwNpe();
                }
                int i2 = access$getAssigned$p + 1;
                access$getEntries$p[access$getAssigned$p] = (byte) ((i >>> 24) & 255);
                int i3 = i2 + 1;
                access$getEntries$p[i2] = (byte) ((i >>> 16) & 255);
                access$getEntries$p[i3] = (byte) ((i >>> 8) & 255);
                access$getEntries$p[i3 + 1] = (byte) (i & 255);
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Index ");
            sb.append(access$getSubArrayIndex$p);
            sb.append(" should be between 0 and ");
            sb.append(UnsortedByteEntries.this.f4670a - 4);
            throw new IllegalArgumentException(sb.toString().toString());
        }

        public final void writeTruncatedLong(long j, int i) {
            int access$getSubArrayIndex$p = UnsortedByteEntries.this.f4673d;
            UnsortedByteEntries unsortedByteEntries = UnsortedByteEntries.this;
            unsortedByteEntries.f4673d = unsortedByteEntries.f4673d + i;
            if (access$getSubArrayIndex$p >= 0 && access$getSubArrayIndex$p <= UnsortedByteEntries.this.f4670a - i) {
                int access$getAssigned$p = ((UnsortedByteEntries.this.f4674e - 1) * UnsortedByteEntries.this.f4670a) + access$getSubArrayIndex$p;
                byte[] access$getEntries$p = UnsortedByteEntries.this.f4671b;
                if (access$getEntries$p == null) {
                    Intrinsics.throwNpe();
                }
                int i2 = (i - 1) * 8;
                while (i2 >= 8) {
                    access$getEntries$p[access$getAssigned$p] = (byte) ((int) (255 & (j >>> i2)));
                    i2 -= 8;
                    access$getAssigned$p++;
                }
                access$getEntries$p[access$getAssigned$p] = (byte) ((int) (j & 255));
                return;
            }
            throw new IllegalArgumentException(("Index " + access$getSubArrayIndex$p + " should be between 0 and " + (UnsortedByteEntries.this.f4670a - i)).toString());
        }

        public final void writeLong(long j) {
            int access$getSubArrayIndex$p = UnsortedByteEntries.this.f4673d;
            UnsortedByteEntries unsortedByteEntries = UnsortedByteEntries.this;
            unsortedByteEntries.f4673d = unsortedByteEntries.f4673d + 8;
            if (access$getSubArrayIndex$p >= 0 && access$getSubArrayIndex$p <= UnsortedByteEntries.this.f4670a - 8) {
                int access$getAssigned$p = ((UnsortedByteEntries.this.f4674e - 1) * UnsortedByteEntries.this.f4670a) + access$getSubArrayIndex$p;
                byte[] access$getEntries$p = UnsortedByteEntries.this.f4671b;
                if (access$getEntries$p == null) {
                    Intrinsics.throwNpe();
                }
                int i = access$getAssigned$p + 1;
                access$getEntries$p[access$getAssigned$p] = (byte) ((int) ((j >>> 56) & 255));
                int i2 = i + 1;
                access$getEntries$p[i] = (byte) ((int) ((j >>> 48) & 255));
                int i3 = i2 + 1;
                access$getEntries$p[i2] = (byte) ((int) ((j >>> 40) & 255));
                int i4 = i3 + 1;
                access$getEntries$p[i3] = (byte) ((int) ((j >>> 32) & 255));
                int i5 = i4 + 1;
                access$getEntries$p[i4] = (byte) ((int) ((j >>> 24) & 255));
                int i6 = i5 + 1;
                access$getEntries$p[i5] = (byte) ((int) ((j >>> 16) & 255));
                access$getEntries$p[i6] = (byte) ((int) ((j >>> 8) & 255));
                access$getEntries$p[i6 + 1] = (byte) ((int) (j & 255));
                return;
            }
            throw new IllegalArgumentException(("Index " + access$getSubArrayIndex$p + " should be between 0 and " + (UnsortedByteEntries.this.f4670a - 8)).toString());
        }
    }
}
