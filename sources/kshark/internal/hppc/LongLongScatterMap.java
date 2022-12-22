package kshark.internal.hppc;

import java.util.Arrays;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0016\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0004H\u0002J \u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0019H\u0002J\u000e\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u0019J\u000e\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u001e\u001a\u00020\u0004J\u0018\u0010\u001f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00190!0 J \u0010\"\u001a\u00020\u00142\u0018\u0010#\u001a\u0014\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00140$J\u0011\u0010%\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u0019H\u0002J\u000e\u0010&\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u0019J\u000e\u0010'\u001a\u00020\u00192\u0006\u0010\u0017\u001a\u00020\u0004J\u0010\u0010(\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u0019H\u0002J\u0018\u0010)\u001a\u00020\u00142\u0006\u0010*\u001a\u00020\n2\u0006\u0010+\u001a\u00020\nH\u0002J\u0006\u0010,\u001a\u00020\u0014J\u000e\u0010-\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u0019J\u0019\u0010.\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u00192\u0006\u0010/\u001a\u00020\u0019H\u0002J\u0010\u00100\u001a\u00020\u00142\u0006\u00101\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u000f\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000¨\u00062"}, mo175978d2 = {"Lkshark/internal/hppc/LongLongScatterMap;", "", "()V", "assigned", "", "hasEmptyKey", "", "isEmpty", "()Z", "keys", "", "loadFactor", "", "mask", "resizeAt", "size", "getSize", "()I", "values", "allocateBuffers", "", "arraySize", "allocateThenInsertThenRehash", "slot", "pendingKey", "", "pendingValue", "containsKey", "key", "ensureCapacity", "expectedElements", "entrySequence", "Lkotlin/sequences/Sequence;", "Lkotlin/Pair;", "forEach", "block", "Lkotlin/Function2;", "get", "getSlot", "getSlotValue", "hashKey", "rehash", "fromKeys", "fromValues", "release", "remove", "set", "value", "shiftConflictingKeys", "gapSlotArg", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
/* compiled from: LongLongScatterMap.kt */
public final class LongLongScatterMap {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public long[] f4695a = new long[0];
    /* access modifiers changed from: private */

    /* renamed from: b */
    public long[] f4696b = new long[0];

    /* renamed from: c */
    private int f4697c;

    /* renamed from: d */
    private int f4698d;

    /* renamed from: e */
    private int f4699e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public boolean f4700f;

    /* renamed from: g */
    private double f4701g = 0.75d;

    public LongLongScatterMap() {
        ensureCapacity(4);
    }

    public final boolean isEmpty() {
        return getSize() == 0;
    }

    public final long set(long j, long j2) {
        int i = this.f4698d;
        if (j == 0) {
            this.f4700f = true;
            long[] jArr = this.f4696b;
            int i2 = i + 1;
            long j3 = jArr[i2];
            jArr[i2] = j2;
            return j3;
        }
        long[] jArr2 = this.f4695a;
        int a = m3011a(j) & i;
        long j4 = jArr2[a];
        while (j4 != 0) {
            if (j4 == j) {
                long[] jArr3 = this.f4696b;
                long j5 = jArr3[a];
                jArr3[a] = j2;
                return j5;
            }
            a = (a + 1) & i;
            j4 = jArr2[a];
        }
        if (this.f4697c == this.f4699e) {
            m3013a(a, j, j2);
        } else {
            jArr2[a] = j;
            this.f4696b[a] = j2;
        }
        this.f4697c++;
        return 0;
    }

    public final long remove(long j) {
        int i = this.f4698d;
        if (j == 0) {
            this.f4700f = false;
            long[] jArr = this.f4696b;
            int i2 = i + 1;
            long j2 = jArr[i2];
            jArr[i2] = 0;
            return j2;
        }
        long[] jArr2 = this.f4695a;
        int a = m3011a(j) & i;
        long j3 = jArr2[a];
        while (j3 != 0) {
            if (j3 == j) {
                long j4 = this.f4696b[a];
                m3015b(a);
                return j4;
            }
            a = (a + 1) & i;
            j3 = jArr2[a];
        }
        return 0;
    }

    public final int getSlot(long j) {
        if (j != 0) {
            long[] jArr = this.f4695a;
            int i = this.f4698d;
            int a = m3011a(j) & i;
            long j2 = jArr[a];
            while (j2 != 0) {
                if (j2 == j) {
                    return a;
                }
                a = (a + 1) & i;
                j2 = jArr[a];
            }
            return -1;
        } else if (this.f4700f) {
            return this.f4698d + 1;
        } else {
            return -1;
        }
    }

    public final long getSlotValue(int i) {
        return this.f4696b[i];
    }

    public final long get(long j) {
        int slot = getSlot(j);
        if (slot != -1) {
            return getSlotValue(slot);
        }
        throw new IllegalArgumentException(("Unknown key " + j).toString());
    }

    public final void forEach(Function2<? super Long, ? super Long, Unit> function2) {
        Intrinsics.checkParameterIsNotNull(function2, "block");
        int i = this.f4698d + 1;
        int i2 = -1;
        while (true) {
            if (i2 < i) {
                while (true) {
                    i2++;
                    if (i2 >= i) {
                        break;
                    }
                    long j = this.f4695a[i2];
                    if (j != 0) {
                        function2.invoke(Long.valueOf(j), Long.valueOf(this.f4696b[i2]));
                        break;
                    }
                }
            }
            if (i2 == i && this.f4700f) {
                i2++;
                function2.invoke(0L, Long.valueOf(this.f4696b[i]));
            } else {
                return;
            }
        }
    }

    public final Sequence<Pair<Long, Long>> entrySequence() {
        Ref.IntRef intRef = new Ref.IntRef();
        intRef.element = -1;
        return SequencesKt.generateSequence(new LongLongScatterMap$entrySequence$1(this, intRef, this.f4698d + 1));
    }

    public final boolean containsKey(long j) {
        if (j == 0) {
            return this.f4700f;
        }
        long[] jArr = this.f4695a;
        int i = this.f4698d;
        int a = m3011a(j) & i;
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
        this.f4697c = 0;
        this.f4700f = false;
        m3012a(HHPC.INSTANCE.minBufferSize(4, this.f4701g));
    }

    public final int getSize() {
        return this.f4697c + (this.f4700f ? 1 : 0);
    }

    public final void ensureCapacity(int i) {
        if (i > this.f4699e) {
            long[] jArr = this.f4695a;
            long[] jArr2 = this.f4696b;
            m3012a(HHPC.INSTANCE.minBufferSize(i, this.f4701g));
            if (!isEmpty()) {
                m3014a(jArr, jArr2);
            }
        }
    }

    /* renamed from: a */
    private final int m3011a(long j) {
        return HHPC.INSTANCE.mixPhi(j);
    }

    /* renamed from: a */
    private final void m3014a(long[] jArr, long[] jArr2) {
        int i;
        long[] jArr3 = this.f4695a;
        long[] jArr4 = this.f4696b;
        int i2 = this.f4698d;
        int length = jArr.length - 1;
        jArr3[jArr3.length - 1] = jArr[length];
        jArr4[jArr4.length - 1] = jArr2[length];
        while (true) {
            length--;
            if (length >= 0) {
                long j = jArr[length];
                if (j != 0) {
                    int a = m3011a(j);
                    while (true) {
                        i = a & i2;
                        if (jArr3[i] == 0) {
                            break;
                        }
                        a = i + 1;
                    }
                    jArr3[i] = j;
                    jArr4[i] = jArr2[length];
                }
            } else {
                return;
            }
        }
    }

    /* renamed from: a */
    private final void m3012a(int i) {
        long[] jArr = this.f4695a;
        long[] jArr2 = this.f4696b;
        int i2 = i + 1;
        try {
            this.f4695a = new long[i2];
            this.f4696b = new long[i2];
            this.f4699e = HHPC.INSTANCE.expandAtCount(i, this.f4701g);
            this.f4698d = i - 1;
        } catch (OutOfMemoryError e) {
            this.f4695a = jArr;
            this.f4696b = jArr2;
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            Locale locale = Locale.ROOT;
            Intrinsics.checkExpressionValueIsNotNull(locale, "Locale.ROOT");
            String format = String.format(locale, "Not enough memory to allocate buffers for rehashing: %,d -> %,d", Arrays.copyOf(new Object[]{Integer.valueOf(this.f4698d + 1), Integer.valueOf(i)}, 2));
            Intrinsics.checkExpressionValueIsNotNull(format, "java.lang.String.format(locale, format, *args)");
            throw new RuntimeException(format, e);
        }
    }

    /* renamed from: a */
    private final void m3013a(int i, long j, long j2) {
        long[] jArr = this.f4695a;
        long[] jArr2 = this.f4696b;
        m3012a(HHPC.INSTANCE.nextBufferSize(this.f4698d + 1, getSize(), this.f4701g));
        jArr[i] = j;
        jArr2[i] = j2;
        m3014a(jArr, jArr2);
    }

    /* renamed from: b */
    private final void m3015b(int i) {
        int i2;
        long j;
        long[] jArr = this.f4695a;
        long[] jArr2 = this.f4696b;
        int i3 = this.f4698d;
        while (true) {
            int i4 = 0;
            do {
                i4++;
                i2 = (i + i4) & i3;
                j = jArr[i2];
                if (j == 0) {
                    jArr[i] = 0;
                    jArr2[i] = 0;
                    this.f4697c--;
                    return;
                }
            } while (((i2 - m3011a(j)) & i3) < i4);
            jArr[i] = j;
            jArr2[i] = jArr2[i2];
            i = i2;
        }
    }
}
