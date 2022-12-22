package kshark.internal.hppc;

import java.util.Arrays;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0016\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0005H\u0002J%\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\u001fJ\u000e\u0010 \u001a\u00020\u00072\u0006\u0010!\u001a\u00020\u001dJ\u000e\u0010\"\u001a\u00020\u00182\u0006\u0010#\u001a\u00020\u0005J\u0018\u0010$\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00028\u00000&0%J\u0018\u0010'\u001a\u0004\u0018\u00018\u00002\u0006\u0010!\u001a\u00020\u001dH\u0002¢\u0006\u0002\u0010(J\u0010\u0010)\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u001dH\u0002J%\u0010*\u001a\u00020\u00182\u0006\u0010+\u001a\u00020\u000b2\u000e\u0010,\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0014H\u0002¢\u0006\u0002\u0010-J\u0006\u0010.\u001a\u00020\u0018J\u0015\u0010/\u001a\u0004\u0018\u00018\u00002\u0006\u0010!\u001a\u00020\u001d¢\u0006\u0002\u0010(J \u00100\u001a\u0004\u0018\u00018\u00002\u0006\u0010!\u001a\u00020\u001d2\u0006\u00101\u001a\u00028\u0000H\u0002¢\u0006\u0002\u00102J\u0010\u00103\u001a\u00020\u00182\u0006\u00104\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0010\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0014X\u000e¢\u0006\n\n\u0002\u0010\u0016\u0012\u0004\b\u0015\u0010\u0003¨\u00065"}, mo175978d2 = {"Lkshark/internal/hppc/LongObjectScatterMap;", "T", "", "()V", "assigned", "", "hasEmptyKey", "", "isEmpty", "()Z", "keys", "", "loadFactor", "", "mask", "resizeAt", "size", "getSize", "()I", "values", "", "values$annotations", "[Ljava/lang/Object;", "allocateBuffers", "", "arraySize", "allocateThenInsertThenRehash", "slot", "pendingKey", "", "pendingValue", "(IJLjava/lang/Object;)V", "containsKey", "key", "ensureCapacity", "expectedElements", "entrySequence", "Lkotlin/sequences/Sequence;", "Lkotlin/Pair;", "get", "(J)Ljava/lang/Object;", "hashKey", "rehash", "fromKeys", "fromValues", "([J[Ljava/lang/Object;)V", "release", "remove", "set", "value", "(JLjava/lang/Object;)Ljava/lang/Object;", "shiftConflictingKeys", "gapSlotArg", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
/* compiled from: LongObjectScatterMap.kt */
public final class LongObjectScatterMap<T> {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public long[] f4702a = new long[0];
    /* access modifiers changed from: private */

    /* renamed from: b */
    public T[] f4703b = new Object[0];

    /* renamed from: c */
    private int f4704c;

    /* renamed from: d */
    private int f4705d;

    /* renamed from: e */
    private int f4706e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public boolean f4707f;

    /* renamed from: g */
    private double f4708g = 0.75d;

    /* renamed from: a */
    private static /* synthetic */ void m3017a() {
    }

    public LongObjectScatterMap() {
        ensureCapacity(4);
    }

    public final boolean isEmpty() {
        return getSize() == 0;
    }

    public final T set(long j, T t) {
        int i = this.f4705d;
        if (j == 0) {
            this.f4707f = true;
            T[] tArr = this.f4703b;
            int i2 = i + 1;
            T t2 = tArr[i2];
            tArr[i2] = t;
            return t2;
        }
        long[] jArr = this.f4702a;
        int a = m3016a(j) & i;
        long j2 = jArr[a];
        while (j2 != 0) {
            if (j2 == j) {
                T[] tArr2 = this.f4703b;
                T t3 = tArr2[a];
                tArr2[a] = t;
                return t3;
            }
            a = (a + 1) & i;
            j2 = jArr[a];
        }
        if (this.f4704c == this.f4706e) {
            m3019a(a, j, t);
        } else {
            jArr[a] = j;
            this.f4703b[a] = t;
        }
        this.f4704c++;
        return null;
    }

    public final T remove(long j) {
        int i = this.f4705d;
        if (j == 0) {
            this.f4707f = false;
            T[] tArr = this.f4703b;
            int i2 = i + 1;
            T t = tArr[i2];
            tArr[i2] = null;
            return t;
        }
        long[] jArr = this.f4702a;
        int a = m3016a(j) & i;
        long j2 = jArr[a];
        while (j2 != 0) {
            if (j2 == j) {
                T t2 = this.f4703b[a];
                m3021b(a);
                return t2;
            }
            a = (a + 1) & i;
            j2 = jArr[a];
        }
        return null;
    }

    public final T get(long j) {
        if (j != 0) {
            long[] jArr = this.f4702a;
            int i = this.f4705d;
            int a = m3016a(j) & i;
            long j2 = jArr[a];
            while (j2 != 0) {
                if (j2 == j) {
                    return this.f4703b[a];
                }
                a = (a + 1) & i;
                j2 = jArr[a];
            }
            return null;
        } else if (this.f4707f) {
            return this.f4703b[this.f4705d + 1];
        } else {
            return null;
        }
    }

    public final Sequence<Pair<Long, T>> entrySequence() {
        Ref.IntRef intRef = new Ref.IntRef();
        intRef.element = -1;
        return SequencesKt.generateSequence(new LongObjectScatterMap$entrySequence$1(this, intRef, this.f4705d + 1));
    }

    public final boolean containsKey(long j) {
        if (j == 0) {
            return this.f4707f;
        }
        long[] jArr = this.f4702a;
        int i = this.f4705d;
        int a = m3016a(j) & i;
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
        this.f4704c = 0;
        this.f4707f = false;
        m3018a(HHPC.INSTANCE.minBufferSize(4, this.f4708g));
    }

    public final int getSize() {
        return this.f4704c + (this.f4707f ? 1 : 0);
    }

    public final void ensureCapacity(int i) {
        if (i > this.f4706e) {
            long[] jArr = this.f4702a;
            T[] tArr = this.f4703b;
            m3018a(HHPC.INSTANCE.minBufferSize(i, this.f4708g));
            if (!isEmpty()) {
                m3020a(jArr, tArr);
            }
        }
    }

    /* renamed from: a */
    private final int m3016a(long j) {
        return HHPC.INSTANCE.mixPhi(j);
    }

    /* renamed from: a */
    private final void m3020a(long[] jArr, T[] tArr) {
        int i;
        long[] jArr2 = this.f4702a;
        T[] tArr2 = this.f4703b;
        int i2 = this.f4705d;
        int length = jArr.length - 1;
        jArr2[jArr2.length - 1] = jArr[length];
        tArr2[tArr2.length - 1] = tArr[length];
        while (true) {
            length--;
            if (length >= 0) {
                long j = jArr[length];
                if (j != 0) {
                    int a = m3016a(j);
                    while (true) {
                        i = a & i2;
                        if (jArr2[i] == 0) {
                            break;
                        }
                        a = i + 1;
                    }
                    jArr2[i] = j;
                    tArr2[i] = tArr[length];
                }
            } else {
                return;
            }
        }
    }

    /* renamed from: a */
    private final void m3018a(int i) {
        long[] jArr = this.f4702a;
        T[] tArr = this.f4703b;
        int i2 = i + 1;
        try {
            this.f4702a = new long[i2];
            this.f4703b = new Object[i2];
            this.f4706e = HHPC.INSTANCE.expandAtCount(i, this.f4708g);
            this.f4705d = i - 1;
        } catch (OutOfMemoryError e) {
            this.f4702a = jArr;
            this.f4703b = tArr;
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            Locale locale = Locale.ROOT;
            Intrinsics.checkExpressionValueIsNotNull(locale, "Locale.ROOT");
            String format = String.format(locale, "Not enough memory to allocate buffers for rehashing: %,d -> %,d", Arrays.copyOf(new Object[]{Integer.valueOf(this.f4705d + 1), Integer.valueOf(i)}, 2));
            Intrinsics.checkExpressionValueIsNotNull(format, "java.lang.String.format(locale, format, *args)");
            throw new RuntimeException(format, e);
        }
    }

    /* renamed from: a */
    private final void m3019a(int i, long j, T t) {
        long[] jArr = this.f4702a;
        T[] tArr = this.f4703b;
        m3018a(HHPC.INSTANCE.nextBufferSize(this.f4705d + 1, getSize(), this.f4708g));
        jArr[i] = j;
        tArr[i] = t;
        m3020a(jArr, tArr);
    }

    /* renamed from: b */
    private final void m3021b(int i) {
        int i2;
        long j;
        long[] jArr = this.f4702a;
        T[] tArr = this.f4703b;
        int i3 = this.f4705d;
        while (true) {
            int i4 = 0;
            do {
                i4++;
                i2 = (i + i4) & i3;
                j = jArr[i2];
                if (j == 0) {
                    jArr[i] = 0;
                    tArr[i] = null;
                    this.f4704c--;
                    return;
                }
            } while (((i2 - m3016a(j)) & i3) < i4);
            jArr[i] = j;
            tArr[i] = tArr[i2];
            i = i2;
        }
    }
}
