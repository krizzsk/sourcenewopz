package kotlin.reflect.jvm.internal.pcollections;

/* renamed from: kotlin.reflect.jvm.internal.pcollections.a */
/* compiled from: IntTree */
final class C21782a<V> {

    /* renamed from: a */
    static final C21782a<Object> f61212a = new C21782a<>();

    /* renamed from: b */
    private final long f61213b;

    /* renamed from: c */
    private final V f61214c;

    /* renamed from: d */
    private final C21782a<V> f61215d;

    /* renamed from: e */
    private final C21782a<V> f61216e;

    /* renamed from: f */
    private final int f61217f;

    private C21782a() {
        this.f61217f = 0;
        this.f61213b = 0;
        this.f61214c = null;
        this.f61215d = null;
        this.f61216e = null;
    }

    private C21782a(long j, V v, C21782a<V> aVar, C21782a<V> aVar2) {
        this.f61213b = j;
        this.f61214c = v;
        this.f61215d = aVar;
        this.f61216e = aVar2;
        this.f61217f = aVar.f61217f + 1 + aVar2.f61217f;
    }

    /* renamed from: c */
    private C21782a<V> m45124c(long j) {
        if (this.f61217f == 0 || j == this.f61213b) {
            return this;
        }
        return new C21782a(j, this.f61214c, this.f61215d, this.f61216e);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public V mo180235a(long j) {
        if (this.f61217f == 0) {
            return null;
        }
        long j2 = this.f61213b;
        if (j < j2) {
            return this.f61215d.mo180235a(j - j2);
        }
        if (j > j2) {
            return this.f61216e.mo180235a(j - j2);
        }
        return this.f61214c;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C21782a<V> mo180236a(long j, V v) {
        if (this.f61217f == 0) {
            return new C21782a(j, v, this, this);
        }
        long j2 = this.f61213b;
        if (j < j2) {
            return m45123a(this.f61215d.mo180236a(j - j2, v), this.f61216e);
        }
        if (j > j2) {
            return m45123a(this.f61215d, this.f61216e.mo180236a(j - j2, v));
        }
        if (v == this.f61214c) {
            return this;
        }
        return new C21782a(j, v, this.f61215d, this.f61216e);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public C21782a<V> mo180237b(long j) {
        if (this.f61217f == 0) {
            return this;
        }
        long j2 = this.f61213b;
        if (j < j2) {
            return m45123a(this.f61215d.mo180237b(j - j2), this.f61216e);
        }
        if (j > j2) {
            return m45123a(this.f61215d, this.f61216e.mo180237b(j - j2));
        }
        C21782a<V> aVar = this.f61215d;
        if (aVar.f61217f == 0) {
            C21782a<V> aVar2 = this.f61216e;
            return aVar2.m45124c(aVar2.f61213b + j2);
        }
        C21782a<V> aVar3 = this.f61216e;
        if (aVar3.f61217f == 0) {
            return aVar.m45124c(aVar.f61213b + j2);
        }
        long a = aVar3.m45121a();
        long j3 = this.f61213b;
        long j4 = a + j3;
        V a2 = this.f61216e.mo180235a(j4 - j3);
        C21782a<V> b = this.f61216e.mo180237b(j4 - this.f61213b);
        C21782a<V> c = b.m45124c((b.f61213b + this.f61213b) - j4);
        C21782a<V> aVar4 = this.f61215d;
        return m45122a(j4, a2, aVar4.m45124c((aVar4.f61213b + this.f61213b) - j4), c);
    }

    /* renamed from: a */
    private long m45121a() {
        C21782a<V> aVar = this.f61215d;
        if (aVar.f61217f == 0) {
            return this.f61213b;
        }
        return aVar.m45121a() + this.f61213b;
    }

    /* renamed from: a */
    private C21782a<V> m45123a(C21782a<V> aVar, C21782a<V> aVar2) {
        if (aVar == this.f61215d && aVar2 == this.f61216e) {
            return this;
        }
        return m45122a(this.f61213b, this.f61214c, aVar, aVar2);
    }

    /* renamed from: a */
    private static <V> C21782a<V> m45122a(long j, V v, C21782a<V> aVar, C21782a<V> aVar2) {
        C21782a<V> aVar3 = aVar;
        int i = aVar3.f61217f;
        int i2 = aVar2.f61217f;
        if (i + i2 > 1) {
            if (i >= i2 * 5) {
                C21782a<V> aVar4 = aVar3.f61215d;
                C21782a<V> aVar5 = aVar3.f61216e;
                if (aVar5.f61217f < aVar4.f61217f * 2) {
                    long j2 = aVar3.f61213b + j;
                    V v2 = aVar3.f61214c;
                    long j3 = aVar3.f61213b;
                    return new C21782a(j2, v2, aVar4, new C21782a(-j3, v, aVar5.m45124c(aVar5.f61213b + j3), aVar2));
                }
                C21782a<V> aVar6 = aVar5.f61215d;
                C21782a<V> aVar7 = aVar5.f61216e;
                long j4 = aVar5.f61213b + aVar3.f61213b + j;
                V v3 = aVar5.f61214c;
                long j5 = aVar5.f61213b;
                V v4 = v3;
                C21782a aVar8 = new C21782a(-j5, aVar3.f61214c, aVar4, aVar6.m45124c(aVar6.f61213b + j5));
                long j6 = aVar3.f61213b;
                long j7 = aVar5.f61213b;
                return new C21782a(j4, v4, aVar8, new C21782a((-j6) - j7, v, aVar7.m45124c(aVar7.f61213b + j7 + j6), aVar2));
            }
            C21782a<V> aVar9 = aVar2;
            if (i2 >= i * 5) {
                C21782a<V> aVar10 = aVar9.f61215d;
                C21782a<V> aVar11 = aVar9.f61216e;
                if (aVar10.f61217f < aVar11.f61217f * 2) {
                    long j8 = aVar9.f61213b + j;
                    V v5 = aVar9.f61214c;
                    long j9 = aVar9.f61213b;
                    return new C21782a(j8, v5, new C21782a(-j9, v, aVar, aVar10.m45124c(aVar10.f61213b + j9)), aVar11);
                }
                C21782a<V> aVar12 = aVar10.f61215d;
                C21782a<V> aVar13 = aVar10.f61216e;
                long j10 = aVar10.f61213b + aVar9.f61213b + j;
                V v6 = aVar10.f61214c;
                long j11 = aVar9.f61213b;
                long j12 = j10;
                long j13 = aVar10.f61213b;
                C21782a aVar14 = new C21782a((-j11) - j13, v, aVar, aVar12.m45124c(aVar12.f61213b + j13 + j11));
                long j14 = aVar10.f61213b;
                V v7 = aVar9.f61214c;
                C21782a<V> aVar15 = aVar13;
                return new C21782a(j12, v6, aVar14, new C21782a(-j14, v7, aVar15.m45124c(aVar15.f61213b + j14), aVar11));
            }
        }
        return new C21782a(j, v, aVar, aVar2);
    }
}
