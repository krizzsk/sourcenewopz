package p054break;

/* renamed from: break.for */
/* compiled from: Interpolator */
public abstract class C1251for<T> {

    /* renamed from: a */
    final T f434a;

    /* renamed from: b */
    final T f435b;

    /* renamed from: c */
    private final long f436c;

    /* renamed from: d */
    private long f437d = -1;

    C1251for(long j, T t, T t2) {
        this.f436c = j;
        this.f434a = t;
        this.f435b = t2;
    }

    /* renamed from: do */
    public T mo14074do() {
        if (this.f437d == -1) {
            return this.f434a;
        }
        return mo14075do(((float) Math.min(System.currentTimeMillis() - this.f437d, this.f436c)) / ((float) this.f436c));
    }

    /* access modifiers changed from: protected */
    /* renamed from: do */
    public abstract T mo14075do(float f);

    /* renamed from: if */
    public void mo14076if() {
        this.f437d = System.currentTimeMillis();
    }
}
