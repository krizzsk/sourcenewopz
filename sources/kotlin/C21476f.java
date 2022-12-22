package kotlin;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0010\b\n\u0002\u0010\t\n\u0002\b\u0002\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\n\u001a\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\n\u001a\r\u0010\u0004\u001a\u00020\u0001*\u00020\u0001H\n\u001a\u0015\u0010\u0005\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\n\u001a\u0015\u0010\u0006\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\n\u001a\u0015\u0010\u0007\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\n\u001a\u0015\u0010\b\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\n\u001a\r\u0010\t\u001a\u00020\u0001*\u00020\nH\b\u001a\u0015\u0010\t\u001a\u00020\u0001*\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\b\u001a\r\u0010\t\u001a\u00020\u0001*\u00020\rH\b\u001a\u0015\u0010\t\u001a\u00020\u0001*\u00020\r2\u0006\u0010\u000b\u001a\u00020\fH\b\u001a\r\u0010\t\u001a\u00020\u0001*\u00020\u000eH\b\u001a\u0015\u0010\t\u001a\u00020\u0001*\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\fH\b\u001a\r\u0010\t\u001a\u00020\u0001*\u00020\u000fH\b\u001a\u0015\u0010\t\u001a\u00020\u0001*\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\fH\b\u001a\r\u0010\u0010\u001a\u00020\u0001*\u00020\u0001H\n¨\u0006\u0011"}, mo175978d2 = {"dec", "Ljava/math/BigDecimal;", "div", "other", "inc", "minus", "plus", "rem", "times", "toBigDecimal", "", "mathContext", "Ljava/math/MathContext;", "", "", "", "unaryMinus", "kotlin-stdlib"}, mo175979k = 5, mo175980mv = {1, 5, 1}, mo175982xi = 1, mo175983xs = "kotlin/NumbersKt")
/* renamed from: kotlin.f */
/* compiled from: BigDecimals.kt */
class C21476f {
    /* renamed from: a */
    private static final BigDecimal m44006a(BigDecimal bigDecimal, BigDecimal bigDecimal2) {
        Intrinsics.checkNotNullParameter(bigDecimal, "$this$plus");
        BigDecimal add = bigDecimal.add(bigDecimal2);
        Intrinsics.checkNotNullExpressionValue(add, "this.add(other)");
        return add;
    }

    /* renamed from: b */
    private static final BigDecimal m44008b(BigDecimal bigDecimal, BigDecimal bigDecimal2) {
        Intrinsics.checkNotNullParameter(bigDecimal, "$this$minus");
        BigDecimal subtract = bigDecimal.subtract(bigDecimal2);
        Intrinsics.checkNotNullExpressionValue(subtract, "this.subtract(other)");
        return subtract;
    }

    /* renamed from: c */
    private static final BigDecimal m44010c(BigDecimal bigDecimal, BigDecimal bigDecimal2) {
        Intrinsics.checkNotNullParameter(bigDecimal, "$this$times");
        BigDecimal multiply = bigDecimal.multiply(bigDecimal2);
        Intrinsics.checkNotNullExpressionValue(multiply, "this.multiply(other)");
        return multiply;
    }

    /* renamed from: d */
    private static final BigDecimal m44011d(BigDecimal bigDecimal, BigDecimal bigDecimal2) {
        Intrinsics.checkNotNullParameter(bigDecimal, "$this$div");
        BigDecimal divide = bigDecimal.divide(bigDecimal2, RoundingMode.HALF_EVEN);
        Intrinsics.checkNotNullExpressionValue(divide, "this.divide(other, RoundingMode.HALF_EVEN)");
        return divide;
    }

    /* renamed from: e */
    private static final BigDecimal m44012e(BigDecimal bigDecimal, BigDecimal bigDecimal2) {
        Intrinsics.checkNotNullParameter(bigDecimal, "$this$rem");
        BigDecimal remainder = bigDecimal.remainder(bigDecimal2);
        Intrinsics.checkNotNullExpressionValue(remainder, "this.remainder(other)");
        return remainder;
    }

    /* renamed from: a */
    private static final BigDecimal m44005a(BigDecimal bigDecimal) {
        Intrinsics.checkNotNullParameter(bigDecimal, "$this$unaryMinus");
        BigDecimal negate = bigDecimal.negate();
        Intrinsics.checkNotNullExpressionValue(negate, "this.negate()");
        return negate;
    }

    /* renamed from: b */
    private static final BigDecimal m44007b(BigDecimal bigDecimal) {
        Intrinsics.checkNotNullParameter(bigDecimal, "$this$inc");
        BigDecimal add = bigDecimal.add(BigDecimal.ONE);
        Intrinsics.checkNotNullExpressionValue(add, "this.add(BigDecimal.ONE)");
        return add;
    }

    /* renamed from: c */
    private static final BigDecimal m44009c(BigDecimal bigDecimal) {
        Intrinsics.checkNotNullParameter(bigDecimal, "$this$dec");
        BigDecimal subtract = bigDecimal.subtract(BigDecimal.ONE);
        Intrinsics.checkNotNullExpressionValue(subtract, "this.subtract(BigDecimal.ONE)");
        return subtract;
    }

    /* renamed from: a */
    private static final BigDecimal m44001a(int i) {
        BigDecimal valueOf = BigDecimal.valueOf((long) i);
        Intrinsics.checkNotNullExpressionValue(valueOf, "BigDecimal.valueOf(this.toLong())");
        return valueOf;
    }

    /* renamed from: a */
    private static final BigDecimal m44002a(int i, MathContext mathContext) {
        return new BigDecimal(i, mathContext);
    }

    /* renamed from: a */
    private static final BigDecimal m44003a(long j) {
        BigDecimal valueOf = BigDecimal.valueOf(j);
        Intrinsics.checkNotNullExpressionValue(valueOf, "BigDecimal.valueOf(this)");
        return valueOf;
    }

    /* renamed from: a */
    private static final BigDecimal m44004a(long j, MathContext mathContext) {
        return new BigDecimal(j, mathContext);
    }

    /* renamed from: a */
    private static final BigDecimal m43999a(float f) {
        return new BigDecimal(String.valueOf(f));
    }

    /* renamed from: a */
    private static final BigDecimal m44000a(float f, MathContext mathContext) {
        return new BigDecimal(String.valueOf(f), mathContext);
    }

    /* renamed from: a */
    private static final BigDecimal m43997a(double d) {
        return new BigDecimal(String.valueOf(d));
    }

    /* renamed from: a */
    private static final BigDecimal m43998a(double d, MathContext mathContext) {
        return new BigDecimal(String.valueOf(d), mathContext);
    }
}
