package kotlin.math;

import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0006\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001a\u00020\u00048\u0000X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00048\u0000X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00048\u0000X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u00020\u00048\u0000X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\u00048\u0000X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u00020\u00048\u0000X\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, mo175978d2 = {"Lkotlin/math/Constants;", "", "()V", "LN2", "", "epsilon", "taylor_2_bound", "taylor_n_bound", "upper_taylor_2_bound", "upper_taylor_n_bound", "kotlin-stdlib"}, mo175979k = 1, mo175980mv = {1, 5, 1})
/* renamed from: kotlin.math.a */
/* compiled from: MathJVM.kt */
final class C21503a {

    /* renamed from: a */
    public static final double f59947a = Math.log(2.0d);

    /* renamed from: b */
    public static final double f59948b;

    /* renamed from: c */
    public static final double f59949c;

    /* renamed from: d */
    public static final double f59950d;

    /* renamed from: e */
    public static final double f59951e;

    /* renamed from: f */
    public static final double f59952f;

    /* renamed from: g */
    public static final C21503a f59953g = new C21503a();

    static {
        double ulp = Math.ulp(1.0d);
        f59948b = ulp;
        double sqrt = Math.sqrt(ulp);
        f59949c = sqrt;
        double sqrt2 = Math.sqrt(sqrt);
        f59950d = sqrt2;
        double d = (double) 1;
        f59951e = d / f59949c;
        f59952f = d / sqrt2;
    }

    private C21503a() {
    }
}
