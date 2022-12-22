package kshark.internal.hppc;

import java.util.Arrays;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\b\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0007J\u001e\u0010\u0010\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000¨\u0006\u0013"}, mo175978d2 = {"Lkshark/internal/hppc/HHPC;", "", "()V", "MAX_HASH_ARRAY_LENGTH", "", "MIN_HASH_ARRAY_LENGTH", "PHI_C64", "", "expandAtCount", "arraySize", "loadFactor", "", "minBufferSize", "elements", "mixPhi", "k", "nextBufferSize", "nextHighestPowerOfTwo", "input", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
/* compiled from: HHPC.kt */
public final class HHPC {
    public static final HHPC INSTANCE = new HHPC();

    /* renamed from: a */
    private static final long f4692a = -7046029254386353131L;

    /* renamed from: b */
    private static final int f4693b = 4;

    /* renamed from: c */
    private static final int f4694c = 1073741824;

    public final int mixPhi(long j) {
        long j2 = j * f4692a;
        return (int) (j2 ^ (j2 >>> 32));
    }

    public final long nextHighestPowerOfTwo(long j) {
        long j2 = j - 1;
        long j3 = j2 | (j2 >> 1);
        long j4 = j3 | (j3 >> 2);
        long j5 = j4 | (j4 >> 4);
        long j6 = j5 | (j5 >> 8);
        long j7 = j6 | (j6 >> 16);
        return (j7 | (j7 >> 32)) + 1;
    }

    private HHPC() {
    }

    public final int minBufferSize(int i, double d) {
        long ceil = (long) Math.ceil(((double) i) / d);
        if (ceil == ((long) i)) {
            ceil++;
        }
        long max = Math.max((long) 4, nextHighestPowerOfTwo(ceil));
        if (max <= ((long) 1073741824)) {
            return (int) max;
        }
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        Locale locale = Locale.ROOT;
        Intrinsics.checkExpressionValueIsNotNull(locale, "Locale.ROOT");
        String format = String.format(locale, "Maximum array size exceeded for this load factor (elements: %d, load factor: %f)", Arrays.copyOf(new Object[]{Integer.valueOf(i), Double.valueOf(d)}, 2));
        Intrinsics.checkExpressionValueIsNotNull(format, "java.lang.String.format(locale, format, *args)");
        throw new RuntimeException(format);
    }

    public final int expandAtCount(int i, double d) {
        return Math.min(i - 1, (int) Math.ceil(((double) i) * d));
    }

    public final int nextBufferSize(int i, int i2, double d) {
        if (i != 1073741824) {
            return i << 1;
        }
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        Locale locale = Locale.ROOT;
        Intrinsics.checkExpressionValueIsNotNull(locale, "Locale.ROOT");
        String format = String.format(locale, "Maximum array size exceeded for this load factor (elements: %d, load factor: %f)", Arrays.copyOf(new Object[]{Integer.valueOf(i2), Double.valueOf(d)}, 2));
        Intrinsics.checkExpressionValueIsNotNull(format, "java.lang.String.format(locale, format, *args)");
        throw new RuntimeException(format);
    }
}
