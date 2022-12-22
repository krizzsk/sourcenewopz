package kotlin;

import kotlin.jvm.internal.DoubleCompanionObject;
import kotlin.jvm.internal.FloatCompanionObject;

@Metadata(mo175977d1 = {"\u0000*\n\u0000\n\u0002\u0010\b\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\b\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\b\u001a\r\u0010\u0003\u001a\u00020\u0001*\u00020\u0001H\b\u001a\r\u0010\u0003\u001a\u00020\u0001*\u00020\u0002H\b\u001a\r\u0010\u0004\u001a\u00020\u0001*\u00020\u0001H\b\u001a\r\u0010\u0004\u001a\u00020\u0001*\u00020\u0002H\b\u001a\u0015\u0010\u0005\u001a\u00020\u0006*\u00020\u00072\u0006\u0010\b\u001a\u00020\u0002H\b\u001a\u0015\u0010\u0005\u001a\u00020\t*\u00020\n2\u0006\u0010\b\u001a\u00020\u0001H\b\u001a\r\u0010\u000b\u001a\u00020\f*\u00020\u0006H\b\u001a\r\u0010\u000b\u001a\u00020\f*\u00020\tH\b\u001a\r\u0010\r\u001a\u00020\f*\u00020\u0006H\b\u001a\r\u0010\r\u001a\u00020\f*\u00020\tH\b\u001a\r\u0010\u000e\u001a\u00020\f*\u00020\u0006H\b\u001a\r\u0010\u000e\u001a\u00020\f*\u00020\tH\b\u001a\u0015\u0010\u000f\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u0001H\b\u001a\u0015\u0010\u000f\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0001H\b\u001a\u0015\u0010\u0011\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u0001H\b\u001a\u0015\u0010\u0011\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0001H\b\u001a\r\u0010\u0012\u001a\u00020\u0001*\u00020\u0001H\b\u001a\r\u0010\u0012\u001a\u00020\u0002*\u00020\u0002H\b\u001a\r\u0010\u0013\u001a\u00020\u0001*\u00020\u0001H\b\u001a\r\u0010\u0013\u001a\u00020\u0002*\u00020\u0002H\b\u001a\r\u0010\u0014\u001a\u00020\u0002*\u00020\u0006H\b\u001a\r\u0010\u0014\u001a\u00020\u0001*\u00020\tH\b\u001a\r\u0010\u0015\u001a\u00020\u0002*\u00020\u0006H\b\u001a\r\u0010\u0015\u001a\u00020\u0001*\u00020\tH\b¨\u0006\u0016"}, mo175978d2 = {"countLeadingZeroBits", "", "", "countOneBits", "countTrailingZeroBits", "fromBits", "", "Lkotlin/Double$Companion;", "bits", "", "Lkotlin/Float$Companion;", "isFinite", "", "isInfinite", "isNaN", "rotateLeft", "bitCount", "rotateRight", "takeHighestOneBit", "takeLowestOneBit", "toBits", "toRawBits", "kotlin-stdlib"}, mo175979k = 5, mo175980mv = {1, 5, 1}, mo175982xi = 1, mo175983xs = "kotlin/NumbersKt")
/* renamed from: kotlin.i */
/* compiled from: NumbersJVM.kt */
class C21479i extends C21478h {
    /* renamed from: a */
    private static final boolean m44074a(double d) {
        return Double.isNaN(d);
    }

    /* renamed from: a */
    private static final boolean m44075a(float f) {
        return Float.isNaN(f);
    }

    /* renamed from: b */
    private static final boolean m44080b(double d) {
        return Double.isInfinite(d);
    }

    /* renamed from: b */
    private static final boolean m44081b(float f) {
        return Float.isInfinite(f);
    }

    /* renamed from: c */
    private static final boolean m44084c(double d) {
        return !Double.isInfinite(d) && !Double.isNaN(d);
    }

    /* renamed from: c */
    private static final boolean m44085c(float f) {
        return !Float.isInfinite(f) && !Float.isNaN(f);
    }

    /* renamed from: d */
    private static final long m44088d(double d) {
        return Double.doubleToLongBits(d);
    }

    /* renamed from: e */
    private static final long m44092e(double d) {
        return Double.doubleToRawLongBits(d);
    }

    /* renamed from: a */
    private static final double m44068a(DoubleCompanionObject doubleCompanionObject, long j) {
        return Double.longBitsToDouble(j);
    }

    /* renamed from: d */
    private static final int m44086d(float f) {
        return Float.floatToIntBits(f);
    }

    /* renamed from: e */
    private static final int m44090e(float f) {
        return Float.floatToRawIntBits(f);
    }

    /* renamed from: a */
    private static final float m44069a(FloatCompanionObject floatCompanionObject, int i) {
        return Float.intBitsToFloat(i);
    }

    /* renamed from: a */
    private static final int m44070a(int i) {
        return Integer.bitCount(i);
    }

    /* renamed from: b */
    private static final int m44076b(int i) {
        return Integer.numberOfLeadingZeros(i);
    }

    /* renamed from: c */
    private static final int m44082c(int i) {
        return Integer.numberOfTrailingZeros(i);
    }

    /* renamed from: d */
    private static final int m44087d(int i) {
        return Integer.highestOneBit(i);
    }

    /* renamed from: e */
    private static final int m44091e(int i) {
        return Integer.lowestOneBit(i);
    }

    /* renamed from: a */
    private static final int m44071a(int i, int i2) {
        return Integer.rotateLeft(i, i2);
    }

    /* renamed from: b */
    private static final int m44077b(int i, int i2) {
        return Integer.rotateRight(i, i2);
    }

    /* renamed from: a */
    private static final int m44072a(long j) {
        return Long.bitCount(j);
    }

    /* renamed from: b */
    private static final int m44078b(long j) {
        return Long.numberOfLeadingZeros(j);
    }

    /* renamed from: c */
    private static final int m44083c(long j) {
        return Long.numberOfTrailingZeros(j);
    }

    /* renamed from: d */
    private static final long m44089d(long j) {
        return Long.highestOneBit(j);
    }

    /* renamed from: e */
    private static final long m44093e(long j) {
        return Long.lowestOneBit(j);
    }

    /* renamed from: a */
    private static final long m44073a(long j, int i) {
        return Long.rotateLeft(j, i);
    }

    /* renamed from: b */
    private static final long m44079b(long j, int i) {
        return Long.rotateRight(j, i);
    }
}
