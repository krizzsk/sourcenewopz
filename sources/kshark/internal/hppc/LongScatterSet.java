package kshark.internal.hppc;

import java.util.Arrays;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0016\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000fJ\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0004H\u0002J\u0018\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u000fH\u0002J\u0011\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u000e\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u0004J\u0010\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0011\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0010\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\bH\u0002J\u0006\u0010\u001d\u001a\u00020\u0011J\u0006\u0010\u001e\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nXD¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, mo175978d2 = {"Lkshark/internal/hppc/LongScatterSet;", "", "()V", "assigned", "", "hasEmptyKey", "", "keys", "", "loadFactor", "", "mask", "resizeAt", "add", "key", "", "allocateBuffers", "", "arraySize", "allocateThenInsertThenRehash", "slot", "pendingKey", "contains", "ensureCapacity", "expectedElements", "hashKey", "plusAssign", "rehash", "fromKeys", "release", "size", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
/* compiled from: LongScatterSet.kt */
public final class LongScatterSet {

    /* renamed from: a */
    private long[] f4709a = new long[0];

    /* renamed from: b */
    private int f4710b;

    /* renamed from: c */
    private int f4711c;

    /* renamed from: d */
    private int f4712d;

    /* renamed from: e */
    private boolean f4713e;

    /* renamed from: f */
    private final double f4714f = 0.75d;

    public LongScatterSet() {
        ensureCapacity(4);
    }

    /* renamed from: a */
    private final int m3022a(long j) {
        return HHPC.INSTANCE.mixPhi(j);
    }

    public final void plusAssign(long j) {
        add(j);
    }

    public final boolean add(long j) {
        if (j == 0) {
            boolean z = !this.f4713e;
            this.f4713e = true;
            return z;
        }
        long[] jArr = this.f4709a;
        int i = this.f4711c;
        int a = m3022a(j) & i;
        long j2 = jArr[a];
        while (j2 != 0) {
            if (j2 == j) {
                return false;
            }
            a = (a + 1) & i;
            j2 = jArr[a];
        }
        if (this.f4710b == this.f4712d) {
            m3024a(a, j);
        } else {
            jArr[a] = j;
        }
        this.f4710b++;
        return true;
    }

    public final boolean contains(long j) {
        if (j == 0) {
            return this.f4713e;
        }
        long[] jArr = this.f4709a;
        int i = this.f4711c;
        int a = m3022a(j) & i;
        long j2 = jArr[a];
        while (j2 != 0) {
            if (j2 == j) {
                return true;
            }
            a = (a + 1) & i;
            j2 = jArr[a];
        }
        return false;
    }

    public final void release() {
        this.f4710b = 0;
        this.f4713e = false;
        m3023a(HHPC.INSTANCE.minBufferSize(4, this.f4714f));
    }

    public final void ensureCapacity(int i) {
        if (i > this.f4712d) {
            long[] jArr = this.f4709a;
            m3023a(HHPC.INSTANCE.minBufferSize(i, this.f4714f));
            if (size() != 0) {
                m3025a(jArr);
            }
        }
    }

    public final int size() {
        return this.f4710b + (this.f4713e ? 1 : 0);
    }

    /* renamed from: a */
    private final void m3025a(long[] jArr) {
        int i;
        long[] jArr2 = this.f4709a;
        int i2 = this.f4711c;
        int length = jArr.length - 1;
        while (true) {
            length--;
            if (length >= 0) {
                long j = jArr[length];
                if (j != 0) {
                    int a = m3022a(j);
                    while (true) {
                        i = a & i2;
                        if (jArr2[i] == 0) {
                            break;
                        }
                        a = i + 1;
                    }
                    jArr2[i] = j;
                }
            } else {
                return;
            }
        }
    }

    /* renamed from: a */
    private final void m3023a(int i) {
        long[] jArr = this.f4709a;
        try {
            this.f4709a = new long[(i + 1)];
            this.f4712d = HHPC.INSTANCE.expandAtCount(i, this.f4714f);
            this.f4711c = i - 1;
        } catch (OutOfMemoryError e) {
            this.f4709a = jArr;
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            Locale locale = Locale.ROOT;
            Intrinsics.checkExpressionValueIsNotNull(locale, "Locale.ROOT");
            String format = String.format(locale, "Not enough memory to allocate buffers for rehashing: %,d -> %,d", Arrays.copyOf(new Object[]{Integer.valueOf(size()), Integer.valueOf(i)}, 2));
            Intrinsics.checkExpressionValueIsNotNull(format, "java.lang.String.format(locale, format, *args)");
            throw new RuntimeException(format, e);
        }
    }

    /* renamed from: a */
    private final void m3024a(int i, long j) {
        long[] jArr = this.f4709a;
        m3023a(HHPC.INSTANCE.nextBufferSize(this.f4711c + 1, size(), this.f4714f));
        jArr[i] = j;
        m3025a(jArr);
    }
}
