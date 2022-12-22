package kshark.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0006\u0010\f\u001a\u00020\rJ\u0006\u0010\u000e\u001a\u00020\u000fJ\u0006\u0010\u0010\u001a\u00020\u0005J\u0006\u0010\u0011\u001a\u00020\u000fJ\u000e\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0005R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, mo175978d2 = {"Lkshark/internal/ByteSubArray;", "", "array", "", "rangeStart", "", "size", "longIdentifiers", "", "([BIIZ)V", "currentIndex", "endInclusive", "readByte", "", "readId", "", "readInt", "readLong", "readTruncatedLong", "byteCount", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
/* compiled from: ByteSubArray.kt */
public final class ByteSubArray {

    /* renamed from: a */
    private final int f4614a;

    /* renamed from: b */
    private int f4615b;

    /* renamed from: c */
    private final byte[] f4616c;

    /* renamed from: d */
    private final int f4617d;

    /* renamed from: e */
    private final boolean f4618e;

    public ByteSubArray(byte[] bArr, int i, int i2, boolean z) {
        Intrinsics.checkParameterIsNotNull(bArr, "array");
        this.f4616c = bArr;
        this.f4617d = i;
        this.f4618e = z;
        this.f4614a = i2 - 1;
    }

    public final byte readByte() {
        int i = this.f4615b;
        this.f4615b = i + 1;
        if (i >= 0 && this.f4614a >= i) {
            return this.f4616c[this.f4617d + i];
        }
        throw new IllegalArgumentException(("Index " + i + " should be between 0 and " + this.f4614a).toString());
    }

    public final long readId() {
        if (this.f4618e) {
            return readLong();
        }
        return (long) readInt();
    }

    public final int readInt() {
        int i = this.f4615b;
        this.f4615b = i + 4;
        if (i >= 0 && i <= this.f4614a + -3) {
            return ByteSubArrayKt.readInt(this.f4616c, this.f4617d + i);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Index ");
        sb.append(i);
        sb.append(" should be between 0 and ");
        sb.append(this.f4614a - 3);
        throw new IllegalArgumentException(sb.toString().toString());
    }

    public final long readTruncatedLong(int i) {
        int i2 = this.f4615b;
        this.f4615b = i2 + i;
        if (i2 >= 0 && i2 <= this.f4614a - (i + -1)) {
            int i3 = this.f4617d + i2;
            byte[] bArr = this.f4616c;
            long j = 0;
            int i4 = (i - 1) * 8;
            while (i4 >= 8) {
                j |= (255 & ((long) bArr[i3])) << i4;
                i4 -= 8;
                i3++;
            }
            return (((long) bArr[i3]) & 255) | j;
        }
        throw new IllegalArgumentException(("Index " + i2 + " should be between 0 and " + (this.f4614a - (i - 1))).toString());
    }

    public final long readLong() {
        int i = this.f4615b;
        this.f4615b = i + 8;
        if (i >= 0 && i <= this.f4614a + -7) {
            return ByteSubArrayKt.readLong(this.f4616c, this.f4617d + i);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Index ");
        sb.append(i);
        sb.append(" should be between 0 and ");
        sb.append(this.f4614a - 7);
        throw new IllegalArgumentException(sb.toString().toString());
    }
}
