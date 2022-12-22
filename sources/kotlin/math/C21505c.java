package kotlin.math;

import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b7\u001a\u0011\u0010\u0016\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\b\u001a\u0011\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\b\u001a\u0011\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\tH\b\u001a\u0011\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\fH\b\u001a\u0011\u0010\u0019\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\b\u001a\u0011\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\b\u001a\u0010\u0010\u001a\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0007\u001a\u0011\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\b\u001a\u0011\u0010\u001b\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\b\u001a\u0011\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\b\u001a\u0010\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0007\u001a\u0011\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\b\u001a\u0011\u0010\u001d\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\b\u001a\u0011\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\b\u001a\u0019\u0010\u001e\u001a\u00020\u00012\u0006\u0010\u001f\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\b\u001a\u0019\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\b\u001a\u0010\u0010 \u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0007\u001a\u0011\u0010 \u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\b\u001a\u0011\u0010!\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\b\u001a\u0011\u0010!\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\b\u001a\u0011\u0010\"\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\b\u001a\u0011\u0010\"\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\b\u001a\u0011\u0010#\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\b\u001a\u0011\u0010#\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\b\u001a\u0011\u0010$\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\b\u001a\u0011\u0010$\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\b\u001a\u0011\u0010%\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\b\u001a\u0011\u0010%\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\b\u001a\u0011\u0010&\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\b\u001a\u0011\u0010&\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\b\u001a\u0019\u0010'\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u00012\u0006\u0010\u001f\u001a\u00020\u0001H\b\u001a\u0019\u0010'\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u0006H\b\u001a\u0011\u0010(\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\b\u001a\u0011\u0010(\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\b\u001a\u0011\u0010)\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\b\u001a\u0011\u0010)\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\b\u001a\u0018\u0010*\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u00012\u0006\u0010+\u001a\u00020\u0001H\u0007\u001a\u0018\u0010*\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00062\u0006\u0010+\u001a\u00020\u0006H\u0007\u001a\u0011\u0010,\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\b\u001a\u0011\u0010,\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\b\u001a\u0010\u0010-\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0007\u001a\u0010\u0010-\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0007\u001a\u0019\u0010.\u001a\u00020\u00012\u0006\u0010/\u001a\u00020\u00012\u0006\u00100\u001a\u00020\u0001H\b\u001a\u0019\u0010.\u001a\u00020\u00062\u0006\u0010/\u001a\u00020\u00062\u0006\u00100\u001a\u00020\u0006H\b\u001a\u0019\u0010.\u001a\u00020\t2\u0006\u0010/\u001a\u00020\t2\u0006\u00100\u001a\u00020\tH\b\u001a\u0019\u0010.\u001a\u00020\f2\u0006\u0010/\u001a\u00020\f2\u0006\u00100\u001a\u00020\fH\b\u001a\u0019\u00101\u001a\u00020\u00012\u0006\u0010/\u001a\u00020\u00012\u0006\u00100\u001a\u00020\u0001H\b\u001a\u0019\u00101\u001a\u00020\u00062\u0006\u0010/\u001a\u00020\u00062\u0006\u00100\u001a\u00020\u0006H\b\u001a\u0019\u00101\u001a\u00020\t2\u0006\u0010/\u001a\u00020\t2\u0006\u00100\u001a\u00020\tH\b\u001a\u0019\u00101\u001a\u00020\f2\u0006\u0010/\u001a\u00020\f2\u0006\u00100\u001a\u00020\fH\b\u001a\u0011\u00102\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\b\u001a\u0011\u00102\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\b\u001a\u0011\u0010\u000f\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\b\u001a\u0011\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\b\u001a\u0011\u00103\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\b\u001a\u0011\u00103\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\b\u001a\u0011\u00104\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\b\u001a\u0011\u00104\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\b\u001a\u0011\u00105\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\b\u001a\u0011\u00105\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\b\u001a\u0011\u00106\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\b\u001a\u0011\u00106\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\b\u001a\u0011\u00107\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\b\u001a\u0011\u00107\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\b\u001a\u0010\u00108\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0007\u001a\u0010\u00108\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0007\u001a\u0015\u00109\u001a\u00020\u0001*\u00020\u00012\u0006\u0010:\u001a\u00020\u0001H\b\u001a\u0015\u00109\u001a\u00020\u0006*\u00020\u00062\u0006\u0010:\u001a\u00020\u0006H\b\u001a\r\u0010;\u001a\u00020\u0001*\u00020\u0001H\b\u001a\r\u0010;\u001a\u00020\u0006*\u00020\u0006H\b\u001a\u0015\u0010<\u001a\u00020\u0001*\u00020\u00012\u0006\u0010=\u001a\u00020\u0001H\b\u001a\u0015\u0010<\u001a\u00020\u0006*\u00020\u00062\u0006\u0010=\u001a\u00020\u0006H\b\u001a\r\u0010>\u001a\u00020\u0001*\u00020\u0001H\b\u001a\r\u0010>\u001a\u00020\u0006*\u00020\u0006H\b\u001a\u0015\u0010?\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\b\u001a\u0015\u0010?\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0018\u001a\u00020\tH\b\u001a\u0015\u0010?\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\b\u001a\u0015\u0010?\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\u0018\u001a\u00020\tH\b\u001a\f\u0010@\u001a\u00020\t*\u00020\u0001H\u0007\u001a\f\u0010@\u001a\u00020\t*\u00020\u0006H\u0007\u001a\f\u0010A\u001a\u00020\f*\u00020\u0001H\u0007\u001a\f\u0010A\u001a\u00020\f*\u00020\u0006H\u0007\u001a\u0015\u0010B\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u0001H\b\u001a\u0015\u0010B\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u000f\u001a\u00020\tH\b\u001a\u0015\u0010B\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0006H\b\u001a\u0015\u0010B\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\u000f\u001a\u00020\tH\b\"\u001f\u0010\u0000\u001a\u00020\u0001*\u00020\u00018Æ\u0002X\u0004¢\u0006\f\u0012\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005\"\u001f\u0010\u0000\u001a\u00020\u0006*\u00020\u00068Æ\u0002X\u0004¢\u0006\f\u0012\u0004\b\u0002\u0010\u0007\u001a\u0004\b\u0004\u0010\b\"\u001f\u0010\u0000\u001a\u00020\t*\u00020\t8Æ\u0002X\u0004¢\u0006\f\u0012\u0004\b\u0002\u0010\n\u001a\u0004\b\u0004\u0010\u000b\"\u001f\u0010\u0000\u001a\u00020\f*\u00020\f8Æ\u0002X\u0004¢\u0006\f\u0012\u0004\b\u0002\u0010\r\u001a\u0004\b\u0004\u0010\u000e\"\u001f\u0010\u000f\u001a\u00020\u0001*\u00020\u00018Æ\u0002X\u0004¢\u0006\f\u0012\u0004\b\u0010\u0010\u0003\u001a\u0004\b\u0011\u0010\u0005\"\u001f\u0010\u000f\u001a\u00020\u0006*\u00020\u00068Æ\u0002X\u0004¢\u0006\f\u0012\u0004\b\u0010\u0010\u0007\u001a\u0004\b\u0011\u0010\b\"\u001e\u0010\u000f\u001a\u00020\t*\u00020\t8FX\u0004¢\u0006\f\u0012\u0004\b\u0010\u0010\n\u001a\u0004\b\u0011\u0010\u000b\"\u001e\u0010\u000f\u001a\u00020\t*\u00020\f8FX\u0004¢\u0006\f\u0012\u0004\b\u0010\u0010\r\u001a\u0004\b\u0011\u0010\u0012\"\u001f\u0010\u0013\u001a\u00020\u0001*\u00020\u00018Æ\u0002X\u0004¢\u0006\f\u0012\u0004\b\u0014\u0010\u0003\u001a\u0004\b\u0015\u0010\u0005\"\u001f\u0010\u0013\u001a\u00020\u0006*\u00020\u00068Æ\u0002X\u0004¢\u0006\f\u0012\u0004\b\u0014\u0010\u0007\u001a\u0004\b\u0015\u0010\b¨\u0006C"}, mo175978d2 = {"absoluteValue", "", "getAbsoluteValue$annotations", "(D)V", "getAbsoluteValue", "(D)D", "", "(F)V", "(F)F", "", "(I)V", "(I)I", "", "(J)V", "(J)J", "sign", "getSign$annotations", "getSign", "(J)I", "ulp", "getUlp$annotations", "getUlp", "abs", "x", "n", "acos", "acosh", "asin", "asinh", "atan", "atan2", "y", "atanh", "ceil", "cos", "cosh", "exp", "expm1", "floor", "hypot", "ln", "ln1p", "log", "base", "log10", "log2", "max", "a", "b", "min", "round", "sin", "sinh", "sqrt", "tan", "tanh", "truncate", "IEEErem", "divisor", "nextDown", "nextTowards", "to", "nextUp", "pow", "roundToInt", "roundToLong", "withSign", "kotlin-stdlib"}, mo175979k = 5, mo175980mv = {1, 5, 1}, mo175982xi = 1, mo175983xs = "kotlin/math/MathKt")
/* renamed from: kotlin.math.c */
/* compiled from: MathJVM.kt */
class C21505c extends C21504b {
    public static /* synthetic */ void getAbsoluteValue$annotations(double d) {
    }

    public static /* synthetic */ void getAbsoluteValue$annotations(float f) {
    }

    public static /* synthetic */ void getAbsoluteValue$annotations(int i) {
    }

    public static /* synthetic */ void getAbsoluteValue$annotations(long j) {
    }

    public static final int getSign(int i) {
        if (i < 0) {
            return -1;
        }
        return i > 0 ? 1 : 0;
    }

    public static final int getSign(long j) {
        int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
        if (i < 0) {
            return -1;
        }
        return i > 0 ? 1 : 0;
    }

    public static /* synthetic */ void getSign$annotations(double d) {
    }

    public static /* synthetic */ void getSign$annotations(float f) {
    }

    public static /* synthetic */ void getSign$annotations(int i) {
    }

    public static /* synthetic */ void getSign$annotations(long j) {
    }

    public static /* synthetic */ void getUlp$annotations(double d) {
    }

    public static /* synthetic */ void getUlp$annotations(float f) {
    }

    /* renamed from: a */
    private static final double m44310a(double d) {
        return Math.sin(d);
    }

    /* renamed from: b */
    private static final double m44320b(double d) {
        return Math.cos(d);
    }

    /* renamed from: c */
    private static final double m44330c(double d) {
        return Math.tan(d);
    }

    /* renamed from: d */
    private static final double m44334d(double d) {
        return Math.asin(d);
    }

    /* renamed from: e */
    private static final double m44338e(double d) {
        return Math.acos(d);
    }

    /* renamed from: f */
    private static final double m44342f(double d) {
        return Math.atan(d);
    }

    /* renamed from: a */
    private static final double m44311a(double d, double d2) {
        return Math.atan2(d, d2);
    }

    /* renamed from: g */
    private static final double m44346g(double d) {
        return Math.sinh(d);
    }

    /* renamed from: h */
    private static final double m44350h(double d) {
        return Math.cosh(d);
    }

    /* renamed from: i */
    private static final double m44354i(double d) {
        return Math.tanh(d);
    }

    public static final double asinh(double d) {
        if (d >= C21503a.f59950d) {
            if (d <= C21503a.f59952f) {
                return Math.log(d + Math.sqrt((d * d) + ((double) 1)));
            }
            if (d > C21503a.f59951e) {
                return Math.log(d) + C21503a.f59947a;
            }
            double d2 = d * ((double) 2);
            return Math.log(d2 + (((double) 1) / d2));
        } else if (d <= (-C21503a.f59950d)) {
            return -MathKt.asinh(-d);
        } else {
            return Math.abs(d) >= C21503a.f59949c ? d - (((d * d) * d) / ((double) 6)) : d;
        }
    }

    public static final double acosh(double d) {
        double d2 = (double) 1;
        if (d < d2) {
            return Double.NaN;
        }
        if (d > C21503a.f59951e) {
            return Math.log(d) + C21503a.f59947a;
        }
        double d3 = d - d2;
        if (d3 >= C21503a.f59950d) {
            return Math.log(d + Math.sqrt((d * d) - d2));
        }
        double sqrt = Math.sqrt(d3);
        if (sqrt >= C21503a.f59949c) {
            sqrt -= ((sqrt * sqrt) * sqrt) / ((double) 12);
        }
        return sqrt * Math.sqrt(2.0d);
    }

    public static final double atanh(double d) {
        if (Math.abs(d) < C21503a.f59950d) {
            return Math.abs(d) > C21503a.f59949c ? d + (((d * d) * d) / ((double) 3)) : d;
        }
        double d2 = (double) 1;
        return Math.log((d2 + d) / (d2 - d)) / ((double) 2);
    }

    /* renamed from: b */
    private static final double m44321b(double d, double d2) {
        return Math.hypot(d, d2);
    }

    /* renamed from: j */
    private static final double m44356j(double d) {
        return Math.sqrt(d);
    }

    /* renamed from: k */
    private static final double m44358k(double d) {
        return Math.exp(d);
    }

    /* renamed from: l */
    private static final double m44360l(double d) {
        return Math.expm1(d);
    }

    public static final double log(double d, double d2) {
        if (d2 <= 0.0d || d2 == 1.0d) {
            return Double.NaN;
        }
        return Math.log(d) / Math.log(d2);
    }

    /* renamed from: m */
    private static final double m44362m(double d) {
        return Math.log(d);
    }

    /* renamed from: n */
    private static final double m44364n(double d) {
        return Math.log10(d);
    }

    public static final double log2(double d) {
        return Math.log(d) / C21503a.f59947a;
    }

    /* renamed from: o */
    private static final double m44366o(double d) {
        return Math.log1p(d);
    }

    /* renamed from: p */
    private static final double m44368p(double d) {
        return Math.ceil(d);
    }

    /* renamed from: q */
    private static final double m44370q(double d) {
        return Math.floor(d);
    }

    public static final double truncate(double d) {
        if (Double.isNaN(d) || Double.isInfinite(d)) {
            return d;
        }
        if (d > ((double) 0)) {
            return Math.floor(d);
        }
        return Math.ceil(d);
    }

    /* renamed from: r */
    private static final double m44372r(double d) {
        return Math.rint(d);
    }

    /* renamed from: s */
    private static final double m44374s(double d) {
        return Math.abs(d);
    }

    /* renamed from: t */
    private static final double m44376t(double d) {
        return Math.signum(d);
    }

    /* renamed from: c */
    private static final double m44331c(double d, double d2) {
        return Math.min(d, d2);
    }

    /* renamed from: d */
    private static final double m44335d(double d, double d2) {
        return Math.max(d, d2);
    }

    /* renamed from: e */
    private static final double m44339e(double d, double d2) {
        return Math.pow(d, d2);
    }

    /* renamed from: a */
    private static final double m44312a(double d, int i) {
        return Math.pow(d, (double) i);
    }

    /* renamed from: f */
    private static final double m44343f(double d, double d2) {
        return Math.IEEEremainder(d, d2);
    }

    /* renamed from: u */
    private static final double m44378u(double d) {
        return Math.abs(d);
    }

    /* renamed from: v */
    private static final double m44380v(double d) {
        return Math.signum(d);
    }

    /* renamed from: g */
    private static final double m44347g(double d, double d2) {
        return Math.copySign(d, d2);
    }

    /* renamed from: b */
    private static final double m44322b(double d, int i) {
        return Math.copySign(d, (double) i);
    }

    /* renamed from: w */
    private static final double m44382w(double d) {
        return Math.ulp(d);
    }

    /* renamed from: x */
    private static final double m44384x(double d) {
        return Math.nextUp(d);
    }

    /* renamed from: y */
    private static final double m44386y(double d) {
        return Math.nextAfter(d, Double.NEGATIVE_INFINITY);
    }

    /* renamed from: h */
    private static final double m44351h(double d, double d2) {
        return Math.nextAfter(d, d2);
    }

    public static final int roundToInt(double d) {
        if (Double.isNaN(d)) {
            throw new IllegalArgumentException("Cannot round NaN value.");
        } else if (d > ((double) Integer.MAX_VALUE)) {
            return Integer.MAX_VALUE;
        } else {
            if (d < ((double) Integer.MIN_VALUE)) {
                return Integer.MIN_VALUE;
            }
            return (int) Math.round(d);
        }
    }

    public static final long roundToLong(double d) {
        if (!Double.isNaN(d)) {
            return Math.round(d);
        }
        throw new IllegalArgumentException("Cannot round NaN value.");
    }

    /* renamed from: a */
    private static final float m44313a(float f) {
        return (float) Math.sin((double) f);
    }

    /* renamed from: b */
    private static final float m44323b(float f) {
        return (float) Math.cos((double) f);
    }

    /* renamed from: c */
    private static final float m44332c(float f) {
        return (float) Math.tan((double) f);
    }

    /* renamed from: d */
    private static final float m44336d(float f) {
        return (float) Math.asin((double) f);
    }

    /* renamed from: e */
    private static final float m44340e(float f) {
        return (float) Math.acos((double) f);
    }

    /* renamed from: f */
    private static final float m44344f(float f) {
        return (float) Math.atan((double) f);
    }

    /* renamed from: a */
    private static final float m44314a(float f, float f2) {
        return (float) Math.atan2((double) f, (double) f2);
    }

    /* renamed from: g */
    private static final float m44348g(float f) {
        return (float) Math.sinh((double) f);
    }

    /* renamed from: h */
    private static final float m44352h(float f) {
        return (float) Math.cosh((double) f);
    }

    /* renamed from: i */
    private static final float m44355i(float f) {
        return (float) Math.tanh((double) f);
    }

    /* renamed from: j */
    private static final float m44357j(float f) {
        return (float) MathKt.asinh((double) f);
    }

    /* renamed from: k */
    private static final float m44359k(float f) {
        return (float) MathKt.acosh((double) f);
    }

    /* renamed from: l */
    private static final float m44361l(float f) {
        return (float) MathKt.atanh((double) f);
    }

    /* renamed from: b */
    private static final float m44324b(float f, float f2) {
        return (float) Math.hypot((double) f, (double) f2);
    }

    /* renamed from: m */
    private static final float m44363m(float f) {
        return (float) Math.sqrt((double) f);
    }

    /* renamed from: n */
    private static final float m44365n(float f) {
        return (float) Math.exp((double) f);
    }

    /* renamed from: o */
    private static final float m44367o(float f) {
        return (float) Math.expm1((double) f);
    }

    public static final float log(float f, float f2) {
        if (f2 <= 0.0f || f2 == 1.0f) {
            return Float.NaN;
        }
        return (float) (Math.log((double) f) / Math.log((double) f2));
    }

    /* renamed from: p */
    private static final float m44369p(float f) {
        return (float) Math.log((double) f);
    }

    /* renamed from: q */
    private static final float m44371q(float f) {
        return (float) Math.log10((double) f);
    }

    public static final float log2(float f) {
        return (float) (Math.log((double) f) / C21503a.f59947a);
    }

    /* renamed from: r */
    private static final float m44373r(float f) {
        return (float) Math.log1p((double) f);
    }

    /* renamed from: s */
    private static final float m44375s(float f) {
        return (float) Math.ceil((double) f);
    }

    /* renamed from: t */
    private static final float m44377t(float f) {
        return (float) Math.floor((double) f);
    }

    public static final float truncate(float f) {
        double d;
        if (Float.isNaN(f) || Float.isInfinite(f)) {
            return f;
        }
        if (f > ((float) 0)) {
            d = Math.floor((double) f);
        } else {
            d = Math.ceil((double) f);
        }
        return (float) d;
    }

    /* renamed from: u */
    private static final float m44379u(float f) {
        return (float) Math.rint((double) f);
    }

    /* renamed from: v */
    private static final float m44381v(float f) {
        return Math.abs(f);
    }

    /* renamed from: w */
    private static final float m44383w(float f) {
        return Math.signum(f);
    }

    /* renamed from: c */
    private static final float m44333c(float f, float f2) {
        return Math.min(f, f2);
    }

    /* renamed from: d */
    private static final float m44337d(float f, float f2) {
        return Math.max(f, f2);
    }

    /* renamed from: e */
    private static final float m44341e(float f, float f2) {
        return (float) Math.pow((double) f, (double) f2);
    }

    /* renamed from: a */
    private static final float m44315a(float f, int i) {
        return (float) Math.pow((double) f, (double) i);
    }

    /* renamed from: f */
    private static final float m44345f(float f, float f2) {
        return (float) Math.IEEEremainder((double) f, (double) f2);
    }

    /* renamed from: x */
    private static final float m44385x(float f) {
        return Math.abs(f);
    }

    /* renamed from: y */
    private static final float m44387y(float f) {
        return Math.signum(f);
    }

    /* renamed from: g */
    private static final float m44349g(float f, float f2) {
        return Math.copySign(f, f2);
    }

    /* renamed from: b */
    private static final float m44325b(float f, int i) {
        return Math.copySign(f, (float) i);
    }

    /* renamed from: z */
    private static final float m44388z(float f) {
        return Math.ulp(f);
    }

    /* renamed from: A */
    private static final float m44308A(float f) {
        return Math.nextUp(f);
    }

    /* renamed from: B */
    private static final float m44309B(float f) {
        return Math.nextAfter(f, Double.NEGATIVE_INFINITY);
    }

    /* renamed from: h */
    private static final float m44353h(float f, float f2) {
        return Math.nextAfter(f, (double) f2);
    }

    public static final int roundToInt(float f) {
        if (!Float.isNaN(f)) {
            return Math.round(f);
        }
        throw new IllegalArgumentException("Cannot round NaN value.");
    }

    public static final long roundToLong(float f) {
        return MathKt.roundToLong((double) f);
    }

    /* renamed from: a */
    private static final int m44316a(int i) {
        return Math.abs(i);
    }

    /* renamed from: a */
    private static final int m44317a(int i, int i2) {
        return Math.min(i, i2);
    }

    /* renamed from: b */
    private static final int m44327b(int i, int i2) {
        return Math.max(i, i2);
    }

    /* renamed from: b */
    private static final int m44326b(int i) {
        return Math.abs(i);
    }

    /* renamed from: a */
    private static final long m44318a(long j) {
        return Math.abs(j);
    }

    /* renamed from: a */
    private static final long m44319a(long j, long j2) {
        return Math.min(j, j2);
    }

    /* renamed from: b */
    private static final long m44329b(long j, long j2) {
        return Math.max(j, j2);
    }

    /* renamed from: b */
    private static final long m44328b(long j) {
        return Math.abs(j);
    }
}
